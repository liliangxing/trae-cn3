package com.bytedance.apm6.frequency;

/* loaded from: classes3.dex */
class RecordItem {
    private String category;
    private String command;
    private long duration;
    private volatile boolean isUsing = false;
    private String key;

    public RecordItem() {
    }

    public RecordItem(String str, long j) {
        this.command = str;
        this.duration = j;
    }

    public RecordItem(String str, String str2) {
        this.category = str;
        this.key = str2;
    }

    public String getCommand() {
        return this.command;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getCategory() {
        return this.category;
    }

    public String getKey() {
        return this.key;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    public void setUsing(boolean z) {
        this.isUsing = z;
    }
}
