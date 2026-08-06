package com.bytedance.trae.login;

import android.app.Activity;
import android.widget.Toast;
import com.bytedance.trae.multilanguage.C0882R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceOverLimitDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.DeviceOverLimitDialog$launchClearRefreshToken$1$3$1", f = "DeviceOverLimitDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class DeviceOverLimitDialog$launchClearRefreshToken$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceOverLimitDialog$launchClearRefreshToken$1$3$1(Activity activity, Continuation<? super DeviceOverLimitDialog$launchClearRefreshToken$1$3$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceOverLimitDialog$launchClearRefreshToken$1$3$1(this.$activity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.$activity.isFinishing() && !this.$activity.isDestroyed()) {
            Activity activity = this.$activity;
            Toast.makeText(activity, activity.getString(C0882R.string.trae_device_over_limit_network_retry), 0).show();
        }
        return Unit.INSTANCE;
    }
}
