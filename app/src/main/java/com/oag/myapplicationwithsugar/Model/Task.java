package com.oag.myapplicationwithsugar.Model;

import com.orm.SugarRecord;

public class Task extends SugarRecord<Task> {
    String Title;
    String Description;

    public Task(){}

    public Task(String title , String description){
        this.Title = title;
        this.Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
