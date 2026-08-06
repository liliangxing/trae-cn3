package com.bytedance.trae.login.traeauth;

import android.app.Activity;
import com.bytedance.trae.login.DeviceOverLimitDialog;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager$showWhenReady$2", f = "DeviceOverLimitDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDialogManager$showWhenReady$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ DeviceOverLimitDialog.Callback $callback;
    final /* synthetic */ ListDevicesResult $listResult;
    final /* synthetic */ DeviceOverLimitDialog.Scene $scene;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceOverLimitDialogManager$showWhenReady$2(Activity activity, ListDevicesResult listDevicesResult, DeviceOverLimitDialog.Scene scene, DeviceOverLimitDialog.Callback callback, Continuation<? super DeviceOverLimitDialogManager$showWhenReady$2> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$listResult = listDevicesResult;
        this.$scene = scene;
        this.$callback = callback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceOverLimitDialogManager$showWhenReady$2(this.$activity, this.$listResult, this.$scene, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceOverLimitDialogManager.INSTANCE.showDialog(this.$activity, this.$listResult, this.$scene, this.$callback);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
