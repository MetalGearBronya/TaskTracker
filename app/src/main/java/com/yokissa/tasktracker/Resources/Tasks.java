package com.yokissa.tasktracker.Resources;

import com.yokissa.tasktracker.Data.HeaderItem;
import com.yokissa.tasktracker.Data.SpaceItem;
import com.yokissa.tasktracker.Data.TaskItem;
import com.yokissa.tasktracker.Data.TimelineItem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tasks {
    public static List<TimelineItem> getTimelineData() {

        List<TimelineItem> mData = new ArrayList<>();

        // sample data
//        HeaderItem header = new HeaderItem("Yesterday");
        HeaderItem header = new HeaderItem("Now");
        TimelineItem headerOnTimeline = new TimelineItem(header);

//        TaskItem task = new TaskItem("ENGN4528 Assignment 1", LocalDateTime.of(2020, 5, 24, 23, 55), Duration.ofDays(14));
//        TimelineItem taskOnTimeline = new TimelineItem(task);

//        SpaceItem space = new SpaceItem();
//        TimelineItem spaceOnTimeline = new TimelineItem(space);

        mData.add(headerOnTimeline);
//        mData.add(taskOnTimeline);
//        mData.add(spaceOnTimeline);

        // my tasks

        List<TaskItem> tasks = new LinkedList<>();
        tasks.add(new TaskItem("COMP2100 Group Project", 5, 29, 23, 59, 15));
        tasks.add(new TaskItem("ENGN4528 CLab 3", 6, 7, 23, 59, 10));
        tasks.add(new TaskItem("ENGN4528 Assignment", 6, 3, 23, 59, 14));
        tasks.add(new TaskItem("COMP4670 Video 2", 6, 3, 23, 55, 7));
        tasks.add(new TaskItem("COMP4660 Lab Quiz 8", 5, 25, 13, 00, 2));
        tasks.add(new TaskItem("COMP4660 Assignment 2", 5, 31, 23, 55, 7));

        tasks.sort((t1, t2) -> t1.getDeadline().compareTo(t2.getDeadline()));

        int index = 1;
        for (TaskItem task : tasks) {
            int height = 0;
            if (index < tasks.size()) {
                height = (int) (Duration.between(task.getDeadline(), tasks.get(index).getDeadline()).toHours());
//                System.out.println(height);
            }
            task.setHeight(height);
            mData.add(new TimelineItem(task));
            index ++;
        }

//        mData.add(new TimelineItem(new TaskItem())) // 未采用的语法

        return mData;
    }
}
