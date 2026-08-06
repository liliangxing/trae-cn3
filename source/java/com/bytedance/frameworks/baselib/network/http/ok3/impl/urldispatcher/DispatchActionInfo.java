package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

/* loaded from: classes2.dex */
public class DispatchActionInfo {
    public boolean mActionHit;
    public String mDispatchedUrl;
    public boolean mNeedFeedBack;
    public int mPriority;
    public long mRuleid;
    public String mServiceName;
    public int mStrategyType;

    public DispatchActionInfo() {
    }

    public DispatchActionInfo(String str, long j, int i, boolean z, int i2, boolean z2, String str2) {
        this.mServiceName = str;
        this.mRuleid = j;
        this.mPriority = i;
        this.mActionHit = z;
        this.mStrategyType = i2;
        this.mNeedFeedBack = z2;
        this.mDispatchedUrl = str2;
    }
}
