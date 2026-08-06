package com.bytedance.gkfs;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: utils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "R", "invoke"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class UtilsKt$traceTime$1$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ long $startTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$traceTime$1$1(long j) {
        super(0);
        this.$startTime = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return System.currentTimeMillis() - this.$startTime;
    }
}
