package com.yokissa.tasktracker.Adapter;

import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.yokissa.tasktracker.Data.TaskItem;
import com.yokissa.tasktracker.Data.TimelineItem;
import com.yokissa.tasktracker.R;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Locale;

public class TaskViewHolder extends BaseViewHolder {
    private TextView time, content, pan_gu;
//    private ImageView group;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        this.time = itemView.findViewById(R.id.deadline);
        this.content = itemView.findViewById(R.id.taskDescription);
//        this.group = itemView.findViewById(R.id.logo);
        this.pan_gu = itemView.findViewById(R.id.pan_gu);

    }

    void setData(TimelineItem item) {
        TaskItem task = item.getTaskItem();
        time.setText(task.getDeadline().format(DateTimeFormatter.ofPattern("HH:mm")));
        SpannableStringBuilder textInContent = new SpannableStringBuilder();

        String date = task.getDeadline().format(DateTimeFormatter.ofPattern("截止日期是：uuuu年M月d日 EEEE", Locale.CHINESE));
        textInContent.append(date + "\n");

        String taskName = task.getTitle();
        textInContent.append(taskName + "\n");
        RelativeSizeSpan style = new RelativeSizeSpan(1.5f);
        textInContent.setSpan(style, date.length() + 1, date.length() + 1 + taskName.length() + 1, SpannableStringBuilder.SPAN_INCLUSIVE_EXCLUSIVE);

        String note = "预计要花" + task.getExpectedTimeRequired().toDays() + "天完成";
        textInContent.append(note + "\n");

        Duration timeLeft = Duration.between(LocalDateTime.now(), task.getDeadline());
//        long progress = task.getExpectedTimeRequired().dividedBy(timeLeft); // this method was implemented in java 9, which android have not yet supported
        String implication = "你还有" + timeLeft.toDays() + "天" + timeLeft.toHours() % 24 + "小时" + timeLeft.toMinutes() % 60 + "分钟";
        if (timeLeft.compareTo(task.getExpectedTimeRequired()) > 0) {
            Duration difference = timeLeft.minus(task.getExpectedTimeRequired());
            implication += "\n距离你应当开始这项工作还有" + difference.toDays() + "天" + difference.toHours() % 24 + "小时" + difference.toMinutes() % 60 + "分钟";
        } else {
            implication += "\n你应该已经完成了进度的" + (1 - (double) timeLeft.toNanos() / task.getExpectedTimeRequired().toNanos()) * 100 + "%";
        }

        textInContent.append(implication);

        content.setText(textInContent);

        int height = task.getHeight() * 15;
        final float scale = content.getContext().getResources().getDisplayMetrics().density;
        int heightInPixels = (int) (height * scale + 0.5f);
//        System.out.println(heightInPixels);
        pan_gu.setHeight(heightInPixels);

//        pan_gu.setText("\n".repeat(6)); // requires jdk 11
//        pan_gu.setText(String.join("", Collections.nCopies(height, "测试\n")));

//        Glide.with(itemView.getContext()).load(task.getLogo()).into(group);

        // 下一步是在每周打断点
        // 然后是挂一个floating action button来添加内容
        // 这里涉及文件的存取
        // 然后是自动生成Logo

        // 因为大小写大小不同，所以即使gravity设为center了，首字母大写的单词总是右倾（是一个右边低的直角梯形slope）且视觉观感偏低，设计上要怎么解决这个问题呢

        // 检查所有应开始时间在当前task开始前或在这个task跟下一个task之间的任务（这个if决定是否需要考虑线的长度），为它绘制一条constrain to bottom of parent的线，固定offset
        // 应该不会多到需要右边有margin
        // 线的左右次序由deadline或当前应已完成比例（急迫程度）排序？动态的话需要移动，是个不小的麻烦
        // 到自己的那条线应该延伸到时间以上
        // 颜色需要任务specific，至少相邻不能相同，包括上下相邻和左右相邻
        // 截止在当前block的要向右延伸，让位使得下面的block只要渲染左侧？画休止横线？交叉处如何设计？
        // 地铁或许是个好参考，将持续的任务要从上面盖过将截止的任务，并移动到左侧，角度就135度不错。
        // 当前任务底部这个尾巴/尽头折到文本框左侧
        // 其他持续任务则全部平行折到它的左侧
    }
}
