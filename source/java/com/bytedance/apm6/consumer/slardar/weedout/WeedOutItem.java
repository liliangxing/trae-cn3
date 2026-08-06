package com.bytedance.apm6.consumer.slardar.weedout;

/* loaded from: classes3.dex */
public class WeedOutItem {
    private long afterSize;
    private long beforeSize;
    private String name;
    private boolean reachTopOfToday;

    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(String str) {
        this.name = str;
    }

    public long getBeforeSize() {
        return this.beforeSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBeforeSize(long j) {
        this.beforeSize = j;
    }

    public long getAfterSize() {
        return this.afterSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAfterSize(long j) {
        this.afterSize = j;
    }

    public boolean isReachTopOfToday() {
        return this.reachTopOfToday;
    }

    public void setReachTopOfToday(boolean z) {
        this.reachTopOfToday = z;
    }
}
