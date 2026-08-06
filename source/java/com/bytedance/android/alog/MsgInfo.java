package com.bytedance.android.alog;

/* loaded from: classes2.dex */
public class MsgInfo {
    public int level;
    public String msg;
    public String tag;

    public MsgInfo(int i, String str, String str2) {
        this.level = i;
        this.tag = str;
        this.msg = str2;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
