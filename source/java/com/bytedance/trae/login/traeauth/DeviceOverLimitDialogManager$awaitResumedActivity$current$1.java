package com.bytedance.trae.login.traeauth;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceOverLimitDialogManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/app/Activity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager$awaitResumedActivity$current$1", f = "DeviceOverLimitDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDialogManager$awaitResumedActivity$current$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Activity>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceOverLimitDialogManager$awaitResumedActivity$current$1(Continuation<? super DeviceOverLimitDialogManager$awaitResumedActivity$current$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceOverLimitDialogManager$awaitResumedActivity$current$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Activity> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return DeviceOverLimitDialogManager.INSTANCE.getValidResumedActivity();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
