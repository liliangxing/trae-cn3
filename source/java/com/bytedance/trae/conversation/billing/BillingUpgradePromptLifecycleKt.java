package com.bytedance.trae.conversation.billing;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: BillingUpgradePromptLifecycle.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"launchManagedPromptResolutionWhenResumed", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "resolveWhileResumed", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePromptLifecycleKt {
    public static final Job launchManagedPromptResolutionWhenResumed(CoroutineScope coroutineScope, Lifecycle lifecycle, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(function1, "resolveWhileResumed");
        return BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0640x2e7d4b64(lifecycle, function1, null), 3, (Object) null);
    }
}
