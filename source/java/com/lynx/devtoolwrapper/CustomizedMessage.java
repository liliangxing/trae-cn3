package com.lynx.devtoolwrapper;

/* loaded from: classes6.dex */
public class CustomizedMessage {
    private String mData;
    private int mMark;
    private String mType;

    public CustomizedMessage(String str, String str2) {
        this(str, str2, -1);
    }

    @Deprecated
    public CustomizedMessage(String str, String str2, int i) {
        this.mType = str;
        this.mData = str2;
        this.mMark = i;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getData() {
        return this.mData;
    }

    public void setData(String str) {
        this.mData = str;
    }

    public int getMark() {
        return this.mMark;
    }

    public void setMark(int i) {
        this.mMark = i;
    }
}
