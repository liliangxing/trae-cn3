package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.exception.ExceptionWithCode;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThrottleRequestPolicy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/request/ThrottleRequestPolicy;", "Lcom/bytedance/iesgurd/request/RequestPolicy;", "mEnableThrottle", "", "mChannelSortedStr", "", "(ZLjava/lang/String;)V", "prepareRequest", "", "requestFail", "requestSuccess", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class ThrottleRequestPolicy implements RequestPolicy {
    private static final long CHECK_UPDATE_CHANNEL_INTERVAL = 600000;
    private static final ConcurrentHashMap<String, Long> updateIntervalMap = new ConcurrentHashMap<>();
    private final String mChannelSortedStr;
    private final boolean mEnableThrottle;

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void requestSuccess() {
    }

    public ThrottleRequestPolicy(boolean z, String mChannelSortedStr) {
        Intrinsics.checkParameterIsNotNull(mChannelSortedStr, "mChannelSortedStr");
        this.mEnableThrottle = z;
        this.mChannelSortedStr = mChannelSortedStr;
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void prepareRequest() throws Exception {
        if (this.mEnableThrottle) {
            ConcurrentHashMap<String, Long> concurrentHashMap = updateIntervalMap;
            Long l = concurrentHashMap.get(this.mChannelSortedStr);
            if (l == null) {
                concurrentHashMap.put(this.mChannelSortedStr, Long.valueOf(System.currentTimeMillis()));
            } else {
                if (System.currentTimeMillis() - l.longValue() <= 600000) {
                    throw new ExceptionWithCode(600, "repeat gecko update request in 600s");
                }
                concurrentHashMap.put(this.mChannelSortedStr, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void requestFail() {
        updateIntervalMap.remove(this.mChannelSortedStr);
    }
}
