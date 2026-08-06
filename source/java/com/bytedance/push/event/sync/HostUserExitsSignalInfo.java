package com.bytedance.push.event.sync;

/* loaded from: classes4.dex */
public class HostUserExitsSignalInfo {
    public boolean mIsValid;
    public String mLastPage;

    public HostUserExitsSignalInfo(boolean z, String str) {
        this.mIsValid = z;
        this.mLastPage = str;
    }

    public HostUserExitsSignalInfo(boolean z) {
        this.mIsValid = z;
    }
}
