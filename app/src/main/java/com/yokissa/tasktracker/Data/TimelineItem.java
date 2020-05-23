package com.yokissa.tasktracker.Data;

import com.yokissa.tasktracker.Resources.Constant;

public class TimelineItem {
    private HeaderItem headerItem;
    private TaskItem taskItem;
    private SpaceItem spaceItem;
    private int viewType;

    public TimelineItem(HeaderItem headerItem) {
        this.headerItem = headerItem;
        this.viewType = Constant.ITEM_HEADER_VIEW_TYPE;
    }

    public TimelineItem(TaskItem taskItem) {
        this.taskItem = taskItem;
        this.viewType = Constant.ITEM_TASK_VIEW_TYPE;
    }

    public TimelineItem(SpaceItem spaceItem) {
        this.spaceItem = spaceItem;
        this.viewType = Constant.ITEM_SPACE_VIEW_TYPE;
    }

    public int getViewType() {
        return viewType;
    }

    public HeaderItem getHeaderItem() {
        return headerItem;
    }

    public TaskItem getTaskItem() {
        return taskItem;
    }

    public SpaceItem getSpaceItem() {
        return spaceItem;
    }
}
