package com.yokissa.tasktracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yokissa.tasktracker.Data.TimelineItem;
import com.yokissa.tasktracker.R;
import com.yokissa.tasktracker.Resources.Constant;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private List<TimelineItem> mData;

    public TimelineAdapter(Context mContext, List<TimelineItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case (Constant.ITEM_HEADER_VIEW_TYPE):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(view);
            case (Constant.ITEM_TASK_VIEW_TYPE):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_task, parent, false);
                return new TaskViewHolder(view);
            case (Constant.ITEM_SPACE_VIEW_TYPE):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_space, parent, false);
                return new SpaceViewHolder(view);

            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }
}
