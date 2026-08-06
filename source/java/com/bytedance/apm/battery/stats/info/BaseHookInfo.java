package com.bytedance.apm.battery.stats.info;

import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes3.dex */
public abstract class BaseHookInfo {
    public StackTraceElement[] elements;
    public long endTime;
    public long startTime;
    public String threadName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getStackDetails() {
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i < this.elements.length; i++) {
            sb.append("\tat ").append(this.elements[i].toString()).append(UpdateDialogNewBase.TYPE);
        }
        return sb.toString();
    }
}
