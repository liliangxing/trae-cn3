package com.bytedance.platform.settingsx.api.map;

/* loaded from: classes4.dex */
public abstract class MappedData {
    private int hashPtr;
    private String name;

    public MappedData(int i, String str) {
        this.hashPtr = i;
        this.name = str;
    }

    public int getHashPtr() {
        return this.hashPtr;
    }

    public String getName() {
        return this.name;
    }
}
