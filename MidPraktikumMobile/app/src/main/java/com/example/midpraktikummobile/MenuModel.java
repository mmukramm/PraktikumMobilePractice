package com.example.midpraktikummobile;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class MenuModel implements Parcelable {
    private String menuName, menuDesc, menuPrice, menuType;
    private boolean isSelected = false;

    protected MenuModel(Parcel in) {
        menuName = in.readString();
        menuDesc = in.readString();
        menuPrice = in.readString();
        menuType = in.readString();
        isSelected = in.readByte() != 0;
    }

    public static final Creator<MenuModel> CREATOR = new Creator<MenuModel>() {
        @Override
        public MenuModel createFromParcel(Parcel in) {
            return new MenuModel(in);
        }

        @Override
        public MenuModel[] newArray(int size) {
            return new MenuModel[size];
        }
    };

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public MenuModel(String menuName, String menuDesc, String menuPrice, String menuType, Boolean isSelected) {
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuPrice = menuPrice;
        this.menuType = menuType;
        this.isSelected = isSelected;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(menuName);
        parcel.writeString(menuDesc);
        parcel.writeString(menuPrice);
        parcel.writeString(menuType);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }
}
