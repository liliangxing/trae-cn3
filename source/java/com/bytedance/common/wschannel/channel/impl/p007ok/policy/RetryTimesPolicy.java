package com.bytedance.common.wschannel.channel.impl.p007ok.policy;

import android.content.Context;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RetryTimesPolicy extends RetryIntervalPolicy {
    public static final int DEFAULT_MAX_RETRY_TIME = 4;
    private int mCurrRetryTime;
    private final int mMaxRetryTime;

    public RetryTimesPolicy(Context context) {
        this(context, 4);
    }

    RetryTimesPolicy(Context context, int i) {
        super(context);
        this.mMaxRetryTime = i < 0 ? 4 : i;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryIntervalPolicy
    public long getNextRetryInterval() {
        long nextRetryInterval = this.mCurrRetryTime < this.mMaxRetryTime ? super.getNextRetryInterval() : -1L;
        if (nextRetryInterval != -1) {
            this.mCurrRetryTime++;
        }
        return nextRetryInterval;
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.mMaxRetryTime + ", mCurrRetryTime=" + this.mCurrRetryTime + '}';
    }

    @Override // com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryIntervalPolicy, com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryPolicy
    public void reset() {
        super.reset();
        this.mCurrRetryTime = 0;
    }
}
