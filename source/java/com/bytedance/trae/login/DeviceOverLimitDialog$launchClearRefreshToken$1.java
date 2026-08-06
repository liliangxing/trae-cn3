package com.bytedance.trae.login;

import android.app.Activity;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding;
import com.bytedance.trae.login.traeauth.ClearRefreshTokenResult;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceOverLimitDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.DeviceOverLimitDialog$launchClearRefreshToken$1", f = "DeviceOverLimitDialog.kt", i = {}, l = {219, 233, 262}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDialog$launchClearRefreshToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ DeviceOverLimitDeviceAdapter $adapter;
    final /* synthetic */ TraeDialogDeviceOverLimitBinding $binding;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $maxDeviceCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceOverLimitDialog$launchClearRefreshToken$1(String str, DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter, int i, TraeDialogDeviceOverLimitBinding traeDialogDeviceOverLimitBinding, Activity activity, Continuation<? super DeviceOverLimitDialog$launchClearRefreshToken$1> continuation) {
        super(2, continuation);
        this.$deviceId = str;
        this.$adapter = deviceOverLimitDeviceAdapter;
        this.$maxDeviceCount = i;
        this.$binding = traeDialogDeviceOverLimitBinding;
        this.$activity = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deviceOverLimitDialog$launchClearRefreshToken$1 = new DeviceOverLimitDialog$launchClearRefreshToken$1(this.$deviceId, this.$adapter, this.$maxDeviceCount, this.$binding, this.$activity, continuation);
        deviceOverLimitDialog$launchClearRefreshToken$1.L$0 = obj;
        return deviceOverLimitDialog$launchClearRefreshToken$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th;
        Object clearRefreshToken;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$deviceId;
            Result.Companion companion2 = Result.Companion;
            TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
            this.label = 1;
            clearRefreshToken = traeAuthManager.clearRefreshToken(str, this);
            if (clearRefreshToken == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
                String str2 = this.$deviceId;
                Activity activity = this.$activity;
                th = Result.exceptionOrNull-impl(obj2);
                if (th != null) {
                    FLogger.INSTANCE.mo426e("DeviceOverLimitDialog", "clearRefreshToken failed, deviceId=" + str2 + ", error=" + th.getMessage());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", 1);
                        IApplog.Companion.reportEvent("device_delete_result", jSONObject);
                    } catch (Throwable unused) {
                    }
                    CoroutineContext main = Dispatchers.getMain();
                    DeviceOverLimitDialog$launchClearRefreshToken$1$3$1 deviceOverLimitDialog$launchClearRefreshToken$1$3$1 = new DeviceOverLimitDialog$launchClearRefreshToken$1$3$1(activity, null);
                    this.L$0 = obj2;
                    this.label = 3;
                    if (BuildersKt.withContext(main, deviceOverLimitDialog$launchClearRefreshToken$1$3$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            clearRefreshToken = obj;
        }
        obj2 = Result.constructor-impl((ClearRefreshTokenResult) clearRefreshToken);
        DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter = this.$adapter;
        String str3 = this.$deviceId;
        int i2 = this.$maxDeviceCount;
        TraeDialogDeviceOverLimitBinding traeDialogDeviceOverLimitBinding = this.$binding;
        Activity activity2 = this.$activity;
        if (Result.isSuccess-impl(obj2)) {
            ClearRefreshTokenResult clearRefreshTokenResult = (ClearRefreshTokenResult) obj2;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", 0);
                IApplog.Companion.reportEvent("device_delete_result", jSONObject2);
            } catch (Throwable unused2) {
            }
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("clearRefreshToken success, success=").append(clearRefreshTokenResult.getSuccess()).append(", deviceId=");
            String deviceId = clearRefreshTokenResult.getDeviceId();
            if (deviceId == null) {
                deviceId = "";
            }
            StringBuilder append2 = append.append(deviceId).append(", status=");
            String deviceStatus = clearRefreshTokenResult.getDeviceStatus();
            if (deviceStatus == null) {
                deviceStatus = "";
            }
            fLogger.mo428i("DeviceOverLimitDialog", append2.append(deviceStatus).toString());
            CoroutineContext main2 = Dispatchers.getMain();
            DeviceOverLimitDialog$launchClearRefreshToken$1$2$1 deviceOverLimitDialog$launchClearRefreshToken$1$2$1 = new DeviceOverLimitDialog$launchClearRefreshToken$1$2$1(deviceOverLimitDeviceAdapter, str3, i2, traeDialogDeviceOverLimitBinding, activity2, null);
            this.L$0 = obj2;
            this.label = 2;
            if (BuildersKt.withContext(main2, deviceOverLimitDialog$launchClearRefreshToken$1$2$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        String str22 = this.$deviceId;
        Activity activity3 = this.$activity;
        th = Result.exceptionOrNull-impl(obj2);
        if (th != null) {
        }
        return Unit.INSTANCE;
    }
}
