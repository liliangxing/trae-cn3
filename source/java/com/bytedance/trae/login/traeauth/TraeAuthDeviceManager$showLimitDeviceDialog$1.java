package com.bytedance.trae.login.traeauth;

import android.app.Activity;
import android.util.Log;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.login.api.ForceLogoutUtils;
import com.bytedance.trae.login.traeauth.TraeAuthDeviceManager;
import com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$showLimitDeviceDialog$1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: TraeAuthDeviceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$showLimitDeviceDialog$1", f = "TraeAuthDeviceManager.kt", i = {}, l = {219, 220}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class TraeAuthDeviceManager$showLimitDeviceDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TraeAuthDeviceManager.TraeAuthDeviceCallback $callback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthDeviceManager$showLimitDeviceDialog$1(TraeAuthDeviceManager.TraeAuthDeviceCallback traeAuthDeviceCallback, Continuation<? super TraeAuthDeviceManager$showLimitDeviceDialog$1> continuation) {
        super(2, continuation);
        this.$callback = traeAuthDeviceCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TraeAuthDeviceManager$showLimitDeviceDialog$1(this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Log.e("InitAppLog", "listDevices failed: " + th.getMessage());
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = TraeAuthManager.INSTANCE.listDevices((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new C08741((ListDevicesResult) obj, this.$callback, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TraeAuthDeviceManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$showLimitDeviceDialog$1$1", f = "TraeAuthDeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$showLimitDeviceDialog$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TraeAuthDeviceManager.TraeAuthDeviceCallback $callback;
        final /* synthetic */ ListDevicesResult $listResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08741(ListDevicesResult listDevicesResult, TraeAuthDeviceManager.TraeAuthDeviceCallback traeAuthDeviceCallback, Continuation<? super C08741> continuation) {
            super(2, continuation);
            this.$listResult = listDevicesResult;
            this.$callback = traeAuthDeviceCallback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08741(this.$listResult, this.$callback, continuation);
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
            final Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing() && !currentActivity.isDestroyed()) {
                DeviceOverLimitDialog deviceOverLimitDialog = DeviceOverLimitDialog.INSTANCE;
                ListDevicesResult listDevicesResult = this.$listResult;
                DeviceOverLimitDialog.Scene scene = DeviceOverLimitDialog.Scene.EXCHANGE;
                final TraeAuthDeviceManager.TraeAuthDeviceCallback traeAuthDeviceCallback = this.$callback;
                deviceOverLimitDialog.show(currentActivity, listDevicesResult, scene, new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0
                    @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
                    public final void onResult(boolean z) {
                        TraeAuthDeviceManager$showLimitDeviceDialog$1.C08741.invokeSuspend$lambda$0(TraeAuthDeviceManager.TraeAuthDeviceCallback.this, currentActivity, z);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(TraeAuthDeviceManager.TraeAuthDeviceCallback traeAuthDeviceCallback, Activity activity, boolean z) {
            if (z) {
                traeAuthDeviceCallback.unBind();
            } else {
                ForceLogoutUtils.INSTANCE.performForceLogout(activity);
            }
        }
    }
}
