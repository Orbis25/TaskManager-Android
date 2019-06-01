package com.oag.myapplicationwithsugar.ViewModel;

import android.widget.ImageView;

public class UI_1_RecyclerView {
    private String Title;
    private String Description;
    private int Pic;
    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public UI_1_RecyclerView() {
    }

    public UI_1_RecyclerView(String title, String description, int pic , long id) {
        Title = title;
        Description = description;
        Pic = pic;
        Id = id;
    }

    public int getPic() {
        return Pic;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPic(int pic) {
        Pic = pic;
    }
}
