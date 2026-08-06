package com.bytedance.trae.conversation.devices.flow;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: DeviceFlowConnectionSuccessLifecycle.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0080@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"runConnectionSuccessWhenResumed", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "delayMs", "", "onCompletion", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;JLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceFlowConnectionSuccessLifecycleKt {
    public static final Object runConnectionSuccessWhenResumed(Lifecycle lifecycle, long j, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new C0723xa1add55f(lifecycle, j, function0, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}
