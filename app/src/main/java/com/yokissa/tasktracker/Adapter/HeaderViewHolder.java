package com.yokissa.tasktracker.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yokissa.tasktracker.Data.TimelineItem;
import com.yokissa.tasktracker.R;

public class HeaderViewHolder extends BaseViewHolder {
    private TextView text; //作为两个method之间的中转

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        this.text = itemView.findViewById(R.id.headerText);
    }

    @Override
    void setData(TimelineItem item) {
        text.setText(item.getHeaderItem().getHeaderText());
    }
}
