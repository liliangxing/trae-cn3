package com.bytedance.trae.login.traeauth;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DeviceOverLimitDialogManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;", "", "<init>", "()V", "TAG", "", "showWhenReady", "", "listResult", "Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", ReportConst.KEY_SCENE, "Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;", "callback", "Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;", "(Lcom/bytedance/trae/login/traeauth/ListDevicesResult;Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showWhenReadyAsync", "awaitResumedActivity", "Landroid/app/Activity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValidResumedActivity", "showDialog", "activity", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDialogManager {
    public static final DeviceOverLimitDialogManager INSTANCE = new DeviceOverLimitDialogManager();
    private static final String TAG = "TraeAuthManager";

    private DeviceOverLimitDialogManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showWhenReady(ListDevicesResult listDevicesResult, DeviceOverLimitDialog.Scene scene, DeviceOverLimitDialog.Callback callback, Continuation<? super Unit> continuation) {
        DeviceOverLimitDialogManager$showWhenReady$1 deviceOverLimitDialogManager$showWhenReady$1;
        Object coroutine_suspended;
        int i;
        CoroutineContext main;
        DeviceOverLimitDialogManager$showWhenReady$2 deviceOverLimitDialogManager$showWhenReady$2;
        if (continuation instanceof DeviceOverLimitDialogManager$showWhenReady$1) {
            deviceOverLimitDialogManager$showWhenReady$1 = (DeviceOverLimitDialogManager$showWhenReady$1) continuation;
            if ((deviceOverLimitDialogManager$showWhenReady$1.label & Integer.MIN_VALUE) != 0) {
                deviceOverLimitDialogManager$showWhenReady$1.label -= Integer.MIN_VALUE;
                Object obj = deviceOverLimitDialogManager$showWhenReady$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = deviceOverLimitDialogManager$showWhenReady$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    deviceOverLimitDialogManager$showWhenReady$1.L$0 = listDevicesResult;
                    deviceOverLimitDialogManager$showWhenReady$1.L$1 = scene;
                    deviceOverLimitDialogManager$showWhenReady$1.L$2 = callback;
                    deviceOverLimitDialogManager$showWhenReady$1.label = 1;
                    obj = awaitResumedActivity(deviceOverLimitDialogManager$showWhenReady$1);
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
                    callback = (DeviceOverLimitDialog.Callback) deviceOverLimitDialogManager$showWhenReady$1.L$2;
                    scene = (DeviceOverLimitDialog.Scene) deviceOverLimitDialogManager$showWhenReady$1.L$1;
                    listDevicesResult = (ListDevicesResult) deviceOverLimitDialogManager$showWhenReady$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Activity activity = (Activity) obj;
                Log.e(TAG, "showWhenReady:" + activity);
                main = Dispatchers.getMain();
                deviceOverLimitDialogManager$showWhenReady$2 = new DeviceOverLimitDialogManager$showWhenReady$2(activity, listDevicesResult, scene, callback, null);
                deviceOverLimitDialogManager$showWhenReady$1.L$0 = null;
                deviceOverLimitDialogManager$showWhenReady$1.L$1 = null;
                deviceOverLimitDialogManager$showWhenReady$1.L$2 = null;
                deviceOverLimitDialogManager$showWhenReady$1.label = 2;
                if (BuildersKt.withContext(main, deviceOverLimitDialogManager$showWhenReady$2, deviceOverLimitDialogManager$showWhenReady$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        deviceOverLimitDialogManager$showWhenReady$1 = new DeviceOverLimitDialogManager$showWhenReady$1(this, continuation);
        Object obj2 = deviceOverLimitDialogManager$showWhenReady$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = deviceOverLimitDialogManager$showWhenReady$1.label;
        if (i != 0) {
        }
        Activity activity2 = (Activity) obj2;
        Log.e(TAG, "showWhenReady:" + activity2);
        main = Dispatchers.getMain();
        deviceOverLimitDialogManager$showWhenReady$2 = new DeviceOverLimitDialogManager$showWhenReady$2(activity2, listDevicesResult, scene, callback, null);
        deviceOverLimitDialogManager$showWhenReady$1.L$0 = null;
        deviceOverLimitDialogManager$showWhenReady$1.L$1 = null;
        deviceOverLimitDialogManager$showWhenReady$1.L$2 = null;
        deviceOverLimitDialogManager$showWhenReady$1.label = 2;
        if (BuildersKt.withContext(main, deviceOverLimitDialogManager$showWhenReady$2, deviceOverLimitDialogManager$showWhenReady$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void showWhenReadyAsync(ListDevicesResult listResult, DeviceOverLimitDialog.Scene scene, DeviceOverLimitDialog.Callback callback) {
        Intrinsics.checkNotNullParameter(listResult, "listResult");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new DeviceOverLimitDialogManager$showWhenReadyAsync$1(listResult, scene, callback, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitResumedActivity(Continuation<? super Activity> continuation) {
        DeviceOverLimitDialogManager$awaitResumedActivity$1 deviceOverLimitDialogManager$awaitResumedActivity$1;
        int i;
        Activity activity;
        if (continuation instanceof DeviceOverLimitDialogManager$awaitResumedActivity$1) {
            deviceOverLimitDialogManager$awaitResumedActivity$1 = (DeviceOverLimitDialogManager$awaitResumedActivity$1) continuation;
            if ((deviceOverLimitDialogManager$awaitResumedActivity$1.label & Integer.MIN_VALUE) != 0) {
                deviceOverLimitDialogManager$awaitResumedActivity$1.label -= Integer.MIN_VALUE;
                Object obj = deviceOverLimitDialogManager$awaitResumedActivity$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = deviceOverLimitDialogManager$awaitResumedActivity$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext main = Dispatchers.getMain();
                    DeviceOverLimitDialogManager$awaitResumedActivity$current$1 deviceOverLimitDialogManager$awaitResumedActivity$current$1 = new DeviceOverLimitDialogManager$awaitResumedActivity$current$1(null);
                    deviceOverLimitDialogManager$awaitResumedActivity$1.label = 1;
                    obj = BuildersKt.withContext(main, deviceOverLimitDialogManager$awaitResumedActivity$current$1, deviceOverLimitDialogManager$awaitResumedActivity$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                activity = (Activity) obj;
                if (activity == null) {
                    return activity;
                }
                FLogger.INSTANCE.mo428i(TAG, "No resumed activity, waiting for next resume...");
                deviceOverLimitDialogManager$awaitResumedActivity$1.label = 2;
                Continuation continuation2 = (Continuation) deviceOverLimitDialogManager$awaitResumedActivity$1;
                Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
                cancellableContinuationImpl.initCancellability();
                final Continuation continuation3 = (CancellableContinuation) cancellableContinuationImpl;
                final ?? r3 = new ActivityStackManager.ActivityLifecycleCallbacks() { // from class: com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1
                    public void onCreate(Activity activity2, Bundle bundle) {
                        ActivityStackManager.ActivityLifecycleCallbacks.DefaultImpls.onCreate(this, activity2, bundle);
                    }

                    public void onPaused(Activity activity2) {
                        ActivityStackManager.ActivityLifecycleCallbacks.DefaultImpls.onPaused(this, activity2);
                    }

                    public void onPreDestroyed(Activity activity2) {
                        ActivityStackManager.ActivityLifecycleCallbacks.DefaultImpls.onPreDestroyed(this, activity2);
                    }

                    public void onStopped(Activity activity2) {
                        ActivityStackManager.ActivityLifecycleCallbacks.DefaultImpls.onStopped(this, activity2);
                    }

                    public void onResumed(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        AppHost.Companion.getActivityStackManager().removeActivityLifecycleCallback(this);
                        if (continuation3.isActive()) {
                            FLogger.INSTANCE.mo428i("TraeAuthManager", "Activity resumed: " + activity2.getClass().getSimpleName());
                            Continuation continuation4 = continuation3;
                            Result.Companion companion = Result.Companion;
                            continuation4.resumeWith(Result.constructor-impl(activity2));
                        }
                    }
                };
                ActivityStackManager.ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityStackManager.ActivityLifecycleCallbacks) r3;
                AppHost.Companion.getActivityStackManager().addActivityLifecycleCallback(activityLifecycleCallbacks);
                continuation3.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager$awaitResumedActivity$2$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Throwable) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable th) {
                        AppHost.Companion.getActivityStackManager().removeActivityLifecycleCallback(C0872x3c9d8aa6.this);
                    }
                });
                Activity validResumedActivity = INSTANCE.getValidResumedActivity();
                if (validResumedActivity != null) {
                    AppHost.Companion.getActivityStackManager().removeActivityLifecycleCallback(activityLifecycleCallbacks);
                    if (continuation3.isActive()) {
                        Result.Companion companion = Result.Companion;
                        continuation3.resumeWith(Result.constructor-impl(validResumedActivity));
                    }
                }
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation2);
                }
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        deviceOverLimitDialogManager$awaitResumedActivity$1 = new DeviceOverLimitDialogManager$awaitResumedActivity$1(this, continuation);
        Object obj2 = deviceOverLimitDialogManager$awaitResumedActivity$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = deviceOverLimitDialogManager$awaitResumedActivity$1.label;
        if (i != 0) {
        }
        activity = (Activity) obj2;
        if (activity == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getValidResumedActivity() {
        Activity resumActivity = AppHost.Companion.getActivityStackManager().getResumActivity();
        if (resumActivity == null) {
            resumActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        }
        if (resumActivity != null) {
            if ((resumActivity.isFinishing() || resumActivity.isDestroyed()) ? false : true) {
                return resumActivity;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialog(Activity activity, ListDevicesResult listResult, DeviceOverLimitDialog.Scene scene, final DeviceOverLimitDialog.Callback callback) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            FLogger.INSTANCE.mo430w(TAG, "Activity invalid when showing dialog, skip");
        } else {
            DeviceOverLimitDialog.INSTANCE.show(activity, listResult, scene, new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager$$ExternalSyntheticLambda0
                @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
                public final void onResult(boolean z) {
                    DeviceOverLimitDialog.Callback.this.onResult(z);
                }
            });
        }
    }
}
