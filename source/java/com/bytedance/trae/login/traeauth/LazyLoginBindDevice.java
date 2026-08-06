package com.bytedance.trae.login.traeauth;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.login.api.ForceLogoutUtils;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.network.DebugSettings;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LazyLoginBindDevice {
    private static volatile boolean isBindScheduled;
    private static volatile boolean isNeedBind;
    private static final ExecutorService ioExecutor = Executors.newSingleThreadExecutor();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static void lazyBindDevice() {
        isNeedBind = true;
        String deviceId = IApplog.Companion.getDeviceId();
        if (DebugSettings.INSTANCE.isDeviceManagerMockDid()) {
            if (TextUtils.isEmpty(deviceId)) {
                return;
            }
            mainHandler.postDelayed(new Runnable() { // from class: com.bytedance.trae.login.traeauth.LazyLoginBindDevice$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    LazyLoginBindDevice.onDidGet();
                }
            }, (long) (Math.random() * 3000.0d));
            return;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return;
        }
        isBindScheduled = true;
        mainHandler.postDelayed(new LazyLoginBindDevice$$ExternalSyntheticLambda2(), 2000L);
    }

    public static void onDidGet() {
        if (!isBindScheduled && isNeedBind) {
            mainHandler.postDelayed(new LazyLoginBindDevice$$ExternalSyntheticLambda2(), 2000L);
        }
    }

    public static void realBindDevice() {
        TraeAuthManager.INSTANCE.bindDeviceAsync(new Function1() { // from class: com.bytedance.trae.login.traeauth.LazyLoginBindDevice$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return LazyLoginBindDevice.lambda$realBindDevice$2((BindDeviceResult) obj);
            }
        });
    }

    public static /* synthetic */ Unit lambda$realBindDevice$2(BindDeviceResult bindDeviceResult) {
        if (Boolean.TRUE.equals(bindDeviceResult.isDeviceLimit())) {
            ioExecutor.execute(new Runnable() { // from class: com.bytedance.trae.login.traeauth.LazyLoginBindDevice$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    LazyLoginBindDevice.lambda$realBindDevice$1();
                }
            });
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void lambda$realBindDevice$1() {
        try {
            ListDevicesResult listDevicesResult = (ListDevicesResult) BuildersKt.runBlocking(Dispatchers.getIO(), new Function2() { // from class: com.bytedance.trae.login.traeauth.LazyLoginBindDevice$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return LazyLoginBindDevice.lambda$realBindDevice$0((CoroutineScope) obj, (Continuation) obj2);
                }
            });
            if (listDevicesResult != null) {
                DeviceOverLimitDialogManager.showWhenReadyAsync(listDevicesResult, DeviceOverLimitDialog.Scene.REBIND, new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.traeauth.LazyLoginBindDevice$$ExternalSyntheticLambda1
                    @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
                    public final void onResult(boolean z) {
                        LazyLoginBindDevice.onResult(z);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ Object lambda$realBindDevice$0(CoroutineScope coroutineScope, Continuation continuation) {
        try {
            return TraeAuthManager.INSTANCE.listDevices(continuation);
        } catch (TraeAuthException e) {
            throw new RuntimeException(e);
        }
    }

    public static void onResult(boolean z) {
        if (!z) {
            mainHandler.post(new Runnable() { // from class: com.bytedance.trae.login.traeauth.LazyLoginBindDevice$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    LazyLoginBindDevice.lambda$onResult$3();
                }
            });
        } else {
            TraeAuthManager.INSTANCE.bindDeviceAsync(null);
        }
    }

    public static /* synthetic */ void lambda$onResult$3() {
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity != null) {
            Toast.makeText(currentActivity, currentActivity.getString(C0882R.string.trae_device_over_limit), 1).show();
            ForceLogoutUtils.INSTANCE.performForceLogout(currentActivity);
        }
    }
}
