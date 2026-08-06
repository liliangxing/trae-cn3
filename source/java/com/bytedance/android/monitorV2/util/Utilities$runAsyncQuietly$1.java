package com.bytedance.android.monitorV2.util;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Utilities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 176)
/* loaded from: classes3.dex */
public final class Utilities$runAsyncQuietly$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $closure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Utilities$runAsyncQuietly$1(Function0<Unit> function0) {
        super(0);
        this.$closure = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        try {
            this.$closure.invoke();
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }
}
