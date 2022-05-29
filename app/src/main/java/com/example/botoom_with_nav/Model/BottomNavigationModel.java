package com.example.botoom_with_nav.Model;

import java.io.Serializable;

public class BottomNavigationModel implements Serializable {
    private String title;
    private int normalIcon;
    private int clickItemIcon;

    public BottomNavigationModel() {
    }

    public BottomNavigationModel(String title, int normalIcon, int clickItemIcon) {
        this.title = title;
        this.normalIcon = normalIcon;
        this.clickItemIcon = clickItemIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNormalIcon() {
        return normalIcon;
    }

    public void setNormalIcon(int normalIcon) {
        this.normalIcon = normalIcon;
    }

    public int getClickItemIcon() {
        return clickItemIcon;
    }

    public void setClickItemIcon(int clickItemIcon) {
        this.clickItemIcon = clickItemIcon;
    }
}
