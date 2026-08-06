package com.bytedance.iesgurd;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdDefines.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/AccessKeyCacheConfig;", "", "limit", "", StrategyConstants.POLICY, "Lcom/bytedance/iesgurd/AccessKeyCacheConfig$Policy;", "(ILcom/bytedance/iesgurd/AccessKeyCacheConfig$Policy;)V", "getLimit", "()I", "getPolicy", "()Lcom/bytedance/iesgurd/AccessKeyCacheConfig$Policy;", "Policy", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class AccessKeyCacheConfig {
    private final int limit;
    private final Policy policy;

    /* compiled from: IESGurdDefines.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/iesgurd/AccessKeyCacheConfig$Policy;", "", "(Ljava/lang/String;I)V", "FIFO", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public enum Policy {
        FIFO
    }

    public AccessKeyCacheConfig(int i, Policy policy) {
        Intrinsics.checkParameterIsNotNull(policy, "policy");
        this.limit = i;
        this.policy = policy;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final Policy getPolicy() {
        return this.policy;
    }
}
