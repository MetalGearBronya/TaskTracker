package com.yokissa.tasktracker.Data;

import java.time.Duration;
import java.time.LocalDateTime;

public class TaskItem {

    private String title;
    private LocalDateTime deadline;
    private Duration expectedTimeRequired;
    private int logo;
    private TaskItem previousTask;
    private TaskItem nextTask; // 之后在xml里新建一个空白元素，按duration设定高度让它挤开
    private int height;

    public TaskItem(String title, LocalDateTime deadline, Duration expectedTimeRequired) {
        this.title = title;
        this.deadline = deadline;
        this.expectedTimeRequired = expectedTimeRequired;
//        this.logo = logo;
    }

    public TaskItem(String title, int month, int day, int hour, int minute, int expectedDaysRequired) {
        this.title = title;
        this.deadline = LocalDateTime.of(2020, month, day, hour, minute);
        this.expectedTimeRequired = Duration.ofDays(expectedDaysRequired);
//        this.logo = logo;
    }


    public String getTitle() {
        return title;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public Duration getExpectedTimeRequired() {
        return expectedTimeRequired;
    }

    public int getLogo() {
        return logo;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
