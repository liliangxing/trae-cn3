package com.bytedance.sysoptimizer;

import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes5.dex */
public class StackLeakItem {
    private int leakCount;
    private String soBuildId;
    private long soEndAddr;
    private String soPath;
    private long soStartAddr;
    private long startRoutine;
    private long startRoutineOffset;

    public String getBuildId() {
        return this.soBuildId;
    }

    public int getLeakCount() {
        return this.leakCount;
    }

    public long getOffset() {
        return this.startRoutineOffset;
    }

    public String getSoName() {
        int lastIndexOf;
        String str = this.soPath;
        return (str == null || (lastIndexOf = str.lastIndexOf(47)) < 0 || lastIndexOf >= this.soPath.length() + (-1)) ? "UNKNOWN" : this.soPath.substring(lastIndexOf + 1);
    }

    public String getLeakItem() {
        return "[" + this.leakCount + "] stacks leaked: " + Long.toHexString(this.startRoutineOffset) + " " + Long.toHexString(this.soStartAddr) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Long.toHexString(this.soEndAddr) + " r-xp " + getSoName() + " (" + this.soBuildId + ")";
    }

    public StackLeakItem(int i, long j, long j2, long j3, String str, String str2) {
        this.leakCount = i;
        this.startRoutine = j;
        this.soStartAddr = j2;
        this.soEndAddr = j3;
        this.soPath = str;
        this.soBuildId = str2;
        this.startRoutineOffset = j - j2;
    }
}
