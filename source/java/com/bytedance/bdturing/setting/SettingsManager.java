package com.bytedance.bdturing.setting;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.localstorage.DbManager;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.setting.SettingUpdateRequest;
import com.bytedance.bdturing.ttnet.HttpClient;
import com.bytedance.bdturing.utils.Consts;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: SettingsManager.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010]\u001a\u00020$2\u0006\u0010^\u001a\u00020\u0001J\u0012\u0010_\u001a\u0004\u0018\u00010\u00042\u0006\u0010`\u001a\u00020\u0004H\u0002J\b\u0010a\u001a\u00020$H\u0002J\u0012\u0010b\u001a\u0004\u0018\u00010\u00042\u0006\u0010c\u001a\u00020\u0004H\u0002J\u0010\u0010d\u001a\u0004\u0018\u00010\u00042\u0006\u0010e\u001a\u00020\u0004J\u0018\u0010f\u001a\u0004\u0018\u00010\u00042\u0006\u0010e\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u0004J\u0010\u0010h\u001a\u0004\u0018\u00010\u00042\u0006\u0010e\u001a\u00020\u0004J\u0010\u0010i\u001a\u0004\u0018\u00010\u00042\u0006\u0010j\u001a\u00020\u0004J\u000e\u0010k\u001a\u00020?2\u0006\u0010e\u001a\u00020\u0004J\u0018\u0010l\u001a\u0004\u0018\u00010\u00042\u0006\u0010e\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u0004J\u0012\u0010m\u001a\u00020\u000b2\b\b\u0002\u0010n\u001a\u00020$H\u0002J\u0016\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020 J\"\u0010t\u001a\u00020p2\u0006\u0010u\u001a\u00020\"2\b\u0010v\u001a\u0004\u0018\u00010\u00042\u0006\u0010w\u001a\u00020\u000bH\u0016J\u000e\u0010x\u001a\u00020$2\u0006\u0010^\u001a\u00020\u0001J\u001a\u0010y\u001a\u00020p2\b\b\u0002\u0010z\u001a\u00020$2\u0006\u0010{\u001a\u00020\u0001H\u0007J\b\u0010|\u001a\u00020pH\u0002J&\u0010}\u001a\u00020p2\u0006\u0010e\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u0004J\u0013\u0010\u007f\u001a\u00020p2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u000bH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020p2\u0006\u0010c\u001a\u00020\u0004H\u0002J\u0016\u0010\u0082\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010\u0083\u0001\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0011\u0010)\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001aR\u0011\u0010+\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010-\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b.\u0010&R\u000e\u0010/\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001aR\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00010\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001aR\u0011\u00108\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b9\u00105R\u0011\u0010:\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010&R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010D\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bE\u00105R$\u0010F\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010&\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010K\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010&\"\u0004\bM\u0010IR\u000e\u0010N\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010O\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010&\"\u0004\bQ\u0010IR\u000e\u0010R\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010S\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010&\"\u0004\bU\u0010IR\u000e\u0010V\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010W\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bX\u0010&R\u0011\u0010Y\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bZ\u0010&R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/bdturing/setting/SettingsManager;", "Lcom/bytedance/bdturing/setting/SettingUpdateRequest$Callback;", "()V", "AUTH_SERVICE", "", "BACK_UP_KEY", "CDN_KEY", "COMMON_SERVICE", "HOST_KEY", "IDENTITY_VERIFY_SERVICE", "MIN_DELAY_TIME", "", "NO_CAPTCHA", "QA_SERVICE", "RETRY_DELAY_TIME", "SETTINGS_PATH", "SMARTER_BUTTON_SERVICE", "SMARTER_VIEW_SERVICE", "SMS_SERVICE", "TAG", "TWICE_VERIFY_SERVICE", "UNPUNISH_SERVICE", "VERIFY_SERVICE", "value", "availableTime", "getAvailableTime", "()J", "setAvailableTime", "(J)V", "callbacks", "", "configProvider", "Lcom/bytedance/bdturing/setting/ConfigProvider;", "currentRetryCount", "", "h5AccEnable", "", "getH5AccEnable", "()Z", "h5GyroEnable", "getH5GyroEnable", "h5LoadTimeOut", "getH5LoadTimeOut", "h5loadRetryEnable", "getH5loadRetryEnable", "identityUseDialogV2", "getIdentityUseDialogV2", "inited", "period", "getPeriod", "proxys", "retryCount", "getRetryCount", "()I", "retryInterval", "getRetryInterval", "sensorMaxNum", "getSensorMaxNum", "sensorUpdateInterval", "", "getSensorUpdateInterval", "()D", DbManager.KEY_SETTINGS, "Lorg/json/JSONObject;", "skipLaunch", "getSkipLaunch", "updateTask", "Ljava/lang/Runnable;", "useDialogSizeV2", "getUseDialogSizeV2", "useJsbRequest", "getUseJsbRequest", "setUseJsbRequest", "(Z)V", "useJsbRequestTest", "useMock", "getUseMock", "setUseMock", "useMockTest", "useNativeReport", "getUseNativeReport", "setUseNativeReport", "useNativeReportTest", "usePreCreate", "getUsePreCreate", "setUsePreCreate", "usePreCreateTest", "verifyCancellable", "getVerifyCancellable", "verifyUseDialogV2", "getVerifyUseDialogV2", "workHandler", "Landroid/os/Handler;", "addCallback", "pxy", "addUrlParam", "url", "checkValid", "encode", "content", "getCDN", "service", "getDataWithFallback", "type", "getHost", "getPopUrl", "region", "getServiceSettings", "getSettingConfig", "getTaskDelay", "isSuccess", "init", "", "context", "Landroid/content/Context;", "provider", "onResponse", "responseCode", "responseContent", "duration", "removeCallback", "requestSettings", "force", JsCallParser.VALUE_CALLBACK, "sendRequest", "setServiceUrlSettings", Api.KEY_ENCRYPT_RESP_KEY, "startUpdateTask", ReportConsts.RESPONSE_DELAY, "updateSettings", "appendPath", "path", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SettingsManager implements SettingUpdateRequest.Callback {
    public static final String AUTH_SERVICE = "auth";
    public static final String BACK_UP_KEY = "back_up_host";
    public static final String CDN_KEY = "url";
    public static final String COMMON_SERVICE = "common";
    public static final String HOST_KEY = "host";
    public static final String IDENTITY_VERIFY_SERVICE = "verify_identity";
    private static final long MIN_DELAY_TIME = 300000;
    public static final String NO_CAPTCHA = "nocaptcha";
    public static final String QA_SERVICE = "qa";
    private static final long RETRY_DELAY_TIME = 30000;
    private static final String SETTINGS_PATH = "vc/setting";
    public static final String SMARTER_BUTTON_SERVICE = "smarter_verify";
    public static final String SMARTER_VIEW_SERVICE = "smartest_verify";
    public static final String SMS_SERVICE = "sms";
    private static final String TAG = "SettingsMager";
    public static final String TWICE_VERIFY_SERVICE = "twice_verify";
    public static final String UNPUNISH_SERVICE = "self_unpunish";
    public static final String VERIFY_SERVICE = "verify";
    private static ConfigProvider configProvider;
    private static int currentRetryCount;
    private static boolean inited;
    private static boolean useJsbRequestTest;
    private static boolean useMockTest;
    private static boolean useNativeReportTest;
    private static boolean usePreCreateTest;
    private static Handler workHandler;
    public static final SettingsManager INSTANCE = new SettingsManager();
    private static JSONObject settings = DefaultSettings.INSTANCE.getSETTINGS();
    private static final List<SettingUpdateRequest.Callback> proxys = new LinkedList();
    private static final List<SettingUpdateRequest.Callback> callbacks = new LinkedList();
    private static final Runnable updateTask = new Runnable() { // from class: com.bytedance.bdturing.setting.SettingsManager$updateTask$1
        @Override // java.lang.Runnable
        public void run() {
            SettingsManager.INSTANCE.sendRequest();
        }
    };

    public final void requestSettings(SettingUpdateRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
        requestSettings$default(this, false, callback, 1, null);
    }

    private SettingsManager() {
    }

    private final boolean getSkipLaunch() {
        return getServiceSettings(COMMON_SERVICE).optInt("skip_launch", 0) == 1;
    }

    private final int getRetryCount() {
        return getServiceSettings(COMMON_SERVICE).optInt("retry_count", 0);
    }

    private final long getRetryInterval() {
        return getServiceSettings(COMMON_SERVICE).optLong("retry_interval", 30000L);
    }

    private final long getPeriod() {
        return getServiceSettings(COMMON_SERVICE).optLong("period", 300000L);
    }

    public final boolean getUseNativeReport() {
        return useNativeReportTest || getServiceSettings(COMMON_SERVICE).optInt("use_native_report", 0) == 1;
    }

    public final void setUseNativeReport(boolean z) {
        useNativeReportTest = z;
    }

    public final boolean getUseJsbRequest() {
        return useJsbRequestTest || getServiceSettings(COMMON_SERVICE).optInt("use_jsb_request", 0) == 1;
    }

    public final void setUseJsbRequest(boolean z) {
        useJsbRequestTest = z;
    }

    public final boolean getUsePreCreate() {
        return usePreCreateTest || getServiceSettings(COMMON_SERVICE).optInt("pre_create", 0) == 1;
    }

    public final void setUsePreCreate(boolean z) {
        usePreCreateTest = z;
    }

    public final int getUseDialogSizeV2() {
        return getServiceSettings(COMMON_SERVICE).optInt("use_dialog_size_v2", 0);
    }

    public final boolean getVerifyUseDialogV2() {
        return getServiceSettings(COMMON_SERVICE).optInt("verify_use_dialog_v2", 0) == 1;
    }

    public final boolean getIdentityUseDialogV2() {
        return getServiceSettings(COMMON_SERVICE).optInt("identity_use_dialog_v2", 0) == 1;
    }

    public final boolean getH5loadRetryEnable() {
        return getServiceSettings(COMMON_SERVICE).optInt("h5_load_retry_enable", 0) == 1;
    }

    public final long getH5LoadTimeOut() {
        return getServiceSettings(COMMON_SERVICE).optLong("h5_load_timeout", 0L);
    }

    public final double getSensorUpdateInterval() {
        return getServiceSettings(COMMON_SERVICE).optDouble("sensor_update_interval", 0.05d);
    }

    public final int getSensorMaxNum() {
        return getServiceSettings(COMMON_SERVICE).optInt("sensor_max_num", BdTuringConfig.DEFAULT_EVENT_COUNT);
    }

    public final boolean getH5AccEnable() {
        return getServiceSettings(COMMON_SERVICE).optInt("h5_verify_acc_switch", 0) == 1;
    }

    public final boolean getH5GyroEnable() {
        return getServiceSettings(COMMON_SERVICE).optInt("h5_verify_gyro_switch", 0) == 1;
    }

    public final boolean getVerifyCancellable() {
        return getServiceSettings(COMMON_SERVICE).optInt("verify_cancellable", 1) == 1;
    }

    public final boolean getUseMock() {
        return useMockTest;
    }

    public final void setUseMock(boolean z) {
        useMockTest = z;
    }

    private final void setAvailableTime(long j) {
        settings.put("available_time", j);
    }

    private final long getAvailableTime() {
        return settings.optLong("available_time");
    }

    public final void init(final Context context, ConfigProvider provider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(provider, "provider");
        synchronized (this) {
            if (!inited) {
                configProvider = provider;
                ConfigProvider configProvider2 = null;
                if (provider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                    provider = null;
                }
                if (provider.getWorkerLooper() != null) {
                    ConfigProvider configProvider3 = configProvider;
                    if (configProvider3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                    } else {
                        configProvider2 = configProvider3;
                    }
                    workHandler = new Handler(configProvider2.getWorkerLooper());
                }
                Handler handler = workHandler;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.bytedance.bdturing.setting.SettingsManager$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            SettingsManager.m435init$lambda2$lambda1(context);
                        }
                    });
                }
                inited = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-2$lambda-1, reason: not valid java name */
    public static final void m435init$lambda2$lambda1(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        DbManager.INSTANCE.init(context);
        String settingsStr = DbManager.INSTANCE.getSettingsStr();
        if (settingsStr != null) {
            INSTANCE.updateSettings(settingsStr);
        }
        SettingsManager settingsManager = INSTANCE;
        if (settingsManager.getSkipLaunch()) {
            settingsManager.startUpdateTask(getTaskDelay$default(settingsManager, false, 1, null));
        } else {
            startUpdateTask$default(settingsManager, 0L, 1, null);
        }
    }

    public final boolean addCallback(SettingUpdateRequest.Callback pxy) {
        boolean add;
        Intrinsics.checkNotNullParameter(pxy, "pxy");
        List<SettingUpdateRequest.Callback> list = proxys;
        synchronized (list) {
            add = list.add(pxy);
        }
        return add;
    }

    public final boolean removeCallback(SettingUpdateRequest.Callback pxy) {
        boolean remove;
        Intrinsics.checkNotNullParameter(pxy, "pxy");
        List<SettingUpdateRequest.Callback> list = proxys;
        synchronized (list) {
            remove = list.remove(pxy);
        }
        return remove;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[LOOP:0: B:13:0x005c->B:15:0x0062, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.bdturing.setting.SettingUpdateRequest.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponse(int responseCode, String responseContent, long duration) {
        Iterator<T> it;
        boolean z = true;
        boolean z2 = responseCode == 200;
        if (z2) {
            String str = responseContent;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (!z) {
                LogUtil.m162i(TAG, "pull settings success," + responseContent);
                updateSettings(responseContent);
                currentRetryCount = 0;
                it = proxys.iterator();
                while (it.hasNext()) {
                    ((SettingUpdateRequest.Callback) it.next()).onResponse(responseCode, responseContent, duration);
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                synchronized (this) {
                    ArrayList arrayList = new ArrayList();
                    List<SettingUpdateRequest.Callback> list = callbacks;
                    arrayList.addAll(list);
                    objectRef.element = arrayList;
                    list.clear();
                    Unit unit = Unit.INSTANCE;
                }
                Iterator it2 = ((Iterable) objectRef.element).iterator();
                while (it2.hasNext()) {
                    ((SettingUpdateRequest.Callback) it2.next()).onResponse(responseCode, responseContent, duration);
                }
                startUpdateTask(getTaskDelay(z2));
                return;
            }
        }
        LogUtil.m162i(TAG, "pull settings fail,code:" + responseCode + ",content:" + responseContent);
        it = proxys.iterator();
        while (it.hasNext()) {
        }
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        synchronized (this) {
        }
    }

    public final String getCDN(String service) {
        Intrinsics.checkNotNullParameter(service, "service");
        return getDataWithFallback(service, "url");
    }

    public final String getHost(String service) {
        Intrinsics.checkNotNullParameter(service, "service");
        return getDataWithFallback(service, "host");
    }

    public final JSONObject getServiceSettings(String service) {
        Intrinsics.checkNotNullParameter(service, "service");
        JSONObject optJSONObject = settings.optJSONObject(service);
        if (optJSONObject == null) {
            optJSONObject = DefaultSettings.INSTANCE.getSETTINGS().optJSONObject(service);
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        ConfigProvider configProvider2 = configProvider;
        if (configProvider2 != null) {
            if (configProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider2 = null;
            }
            ServiceInterceptor serviceInterceptor = configProvider2.getServiceInterceptor();
            if (serviceInterceptor != null) {
                settings.put(service, serviceInterceptor.UpdateServiceUrl(service, optJSONObject));
            }
        }
        return optJSONObject;
    }

    public final void setServiceUrlSettings(String service, String key, String region, String url) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(url, "url");
        settings.optJSONObject(service).optJSONObject(key).putOpt(region, url);
    }

    public final String getDataWithFallback(String service, String type) {
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(type, "type");
        String value = Region.CN.getValue();
        ConfigProvider configProvider2 = configProvider;
        if (configProvider2 != null) {
            if (configProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider2 = null;
            }
            value = configProvider2.getRegion();
        }
        JSONObject optJSONObject2 = getServiceSettings(service).optJSONObject(type);
        String optString = optJSONObject2 != null ? optJSONObject2.optString(value) : null;
        if (!TextUtils.isEmpty(optString)) {
            return optString;
        }
        JSONObject optJSONObject3 = DefaultSettings.INSTANCE.getSETTINGS().optJSONObject(service);
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject(type)) == null) {
            return null;
        }
        return optJSONObject.optString(value);
    }

    public final String getSettingConfig(String service, String type) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(type, "type");
        String optString = getServiceSettings(service).optString(type);
        if (!TextUtils.isEmpty(optString)) {
            return optString;
        }
        JSONObject optJSONObject = DefaultSettings.INSTANCE.getSETTINGS().optJSONObject(service);
        if (optJSONObject != null) {
            return optJSONObject.optString(type);
        }
        return null;
    }

    public final String getPopUrl(String region) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Intrinsics.checkNotNullParameter(region, "region");
        JSONObject serviceSettings = getServiceSettings(COMMON_SERVICE);
        String optString = (serviceSettings == null || (optJSONObject2 = serviceSettings.optJSONObject("popup_url")) == null) ? null : optJSONObject2.optString(region);
        if (!TextUtils.isEmpty(optString)) {
            return optString;
        }
        JSONObject optJSONObject3 = DefaultSettings.INSTANCE.getSETTINGS().optJSONObject(COMMON_SERVICE);
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("popup_url")) == null) {
            return null;
        }
        return optJSONObject.optString(region);
    }

    public static /* synthetic */ void requestSettings$default(SettingsManager settingsManager, boolean z, SettingUpdateRequest.Callback callback, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        settingsManager.requestSettings(z, callback);
    }

    public final void requestSettings(boolean force, SettingUpdateRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
        if (!force && checkValid()) {
            callback.onResponse(200, null, 0L);
            return;
        }
        synchronized (this) {
            List<SettingUpdateRequest.Callback> list = callbacks;
            boolean z = list.size() == 0;
            list.add(callback);
            if (z) {
                startUpdateTask$default(INSTANCE, 0L, 1, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void updateSettings(String content) {
        try {
            settings = new JSONObject(content);
            setAvailableTime(System.currentTimeMillis() + getPeriod());
            DbManager.INSTANCE.setSettingsStr(content);
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    static /* synthetic */ void startUpdateTask$default(SettingsManager settingsManager, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        settingsManager.startUpdateTask(j);
    }

    private final void startUpdateTask(long delay) {
        Handler handler = workHandler;
        if (handler != null) {
            handler.removeCallbacks(updateTask);
        }
        Handler handler2 = workHandler;
        if (handler2 != null) {
            handler2.postDelayed(updateTask, delay);
        }
    }

    static /* synthetic */ long getTaskDelay$default(SettingsManager settingsManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return settingsManager.getTaskDelay(z);
    }

    private final long getTaskDelay(boolean isSuccess) {
        if (!isSuccess && currentRetryCount < getRetryCount() && getRetryInterval() != 0) {
            currentRetryCount++;
            return getRetryInterval();
        }
        return Math.max(Math.min(getAvailableTime() - System.currentTimeMillis(), getPeriod()), 300000L);
    }

    private final boolean checkValid() {
        return getAvailableTime() > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendRequest() {
        if (configProvider == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        ConfigProvider configProvider2 = configProvider;
        ConfigProvider configProvider3 = null;
        if (configProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider2 = null;
        }
        Pair pair = TuplesKt.to("aid", configProvider2.getAppId());
        hashMap.put(pair.getFirst(), pair.getSecond());
        ConfigProvider configProvider4 = configProvider;
        if (configProvider4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider4 = null;
        }
        Pair pair2 = TuplesKt.to("lang", configProvider4.getLang());
        hashMap.put(pair2.getFirst(), pair2.getSecond());
        ConfigProvider configProvider5 = configProvider;
        if (configProvider5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider5 = null;
        }
        Pair pair3 = TuplesKt.to(com.bytedance.bdinstall.Api.KEY_APP_NAME, configProvider5.getAppName());
        hashMap.put(pair3.getFirst(), pair3.getSecond());
        ConfigProvider configProvider6 = configProvider;
        if (configProvider6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider6 = null;
        }
        Pair pair4 = TuplesKt.to("channel", configProvider6.getChannel());
        hashMap.put(pair4.getFirst(), pair4.getSecond());
        ConfigProvider configProvider7 = configProvider;
        if (configProvider7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider7 = null;
        }
        Pair pair5 = TuplesKt.to("region", configProvider7.getRegion());
        hashMap.put(pair5.getFirst(), pair5.getSecond());
        Pair pair6 = TuplesKt.to("os_type", "0");
        hashMap.put(pair6.getFirst(), pair6.getSecond());
        Pair pair7 = TuplesKt.to(Api.KEY_DATETIME, String.valueOf(System.currentTimeMillis()));
        hashMap.put(pair7.getFirst(), pair7.getSecond());
        ConfigProvider configProvider8 = configProvider;
        if (configProvider8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider8 = null;
        }
        Pair pair8 = TuplesKt.to("sdk_version", configProvider8.getSDKVersion());
        hashMap.put(pair8.getFirst(), pair8.getSecond());
        ConfigProvider configProvider9 = configProvider;
        if (configProvider9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider9 = null;
        }
        Pair pair9 = TuplesKt.to("iid", configProvider9.getInstallId());
        hashMap.put(pair9.getFirst(), pair9.getSecond());
        ConfigProvider configProvider10 = configProvider;
        if (configProvider10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider10 = null;
        }
        Pair pair10 = TuplesKt.to("app_version", configProvider10.getAppVersion());
        hashMap.put(pair10.getFirst(), pair10.getSecond());
        Pair pair11 = TuplesKt.to("device_platform", Consts.OS_NAME);
        hashMap.put(pair11.getFirst(), pair11.getSecond());
        ConfigProvider configProvider11 = configProvider;
        if (configProvider11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider11 = null;
        }
        Pair pair12 = TuplesKt.to("version_code", String.valueOf(configProvider11.getAppVersionCode()));
        hashMap.put(pair12.getFirst(), pair12.getSecond());
        ConfigProvider configProvider12 = configProvider;
        if (configProvider12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider12 = null;
        }
        Pair pair13 = TuplesKt.to("version_name", configProvider12.getAppVersion());
        hashMap.put(pair13.getFirst(), pair13.getSecond());
        Pair pair14 = TuplesKt.to("os_name", Consts.OS_NAME);
        hashMap.put(pair14.getFirst(), pair14.getSecond());
        Pair pair15 = TuplesKt.to("os_version", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put(pair15.getFirst(), pair15.getSecond());
        ConfigProvider configProvider13 = configProvider;
        if (configProvider13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            configProvider13 = null;
        }
        Pair pair16 = TuplesKt.to("did", configProvider13.getDeviceId());
        hashMap.put(pair16.getFirst(), pair16.getSecond());
        String str = Build.BRAND;
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LogUtil.printException(e);
        }
        Pair pair17 = TuplesKt.to("device_brand", str);
        hashMap.put(pair17.getFirst(), pair17.getSecond());
        String host = getHost(COMMON_SERVICE);
        String appendPath = host != null ? appendPath(host, SETTINGS_PATH) : null;
        LogUtil.m160d(TAG, appendPath);
        if (appendPath == null && LogUtil.isDebug()) {
            throw new RuntimeException("url should not empty");
        }
        String addUrlParam = appendPath != null ? INSTANCE.addUrlParam(appendPath) : null;
        ConfigProvider configProvider14 = configProvider;
        if (configProvider14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
        } else {
            configProvider3 = configProvider14;
        }
        HttpClient httpClient = configProvider3.getHttpClient();
        if (httpClient != null) {
            if (addUrlParam == null) {
                addUrlParam = "";
            }
            new SettingUpdateRequest(addUrlParam, hashMap, this, httpClient).startGetResponse();
        }
    }

    private final String addUrlParam(String url) {
        StringBuilder sb = new StringBuilder(url);
        try {
            if (StringsKt.indexOf$default(url, '?', 0, false, 6, (Object) null) < 0) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            HashMap hashMap = new HashMap();
            ConfigProvider configProvider2 = configProvider;
            if (configProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider2 = null;
            }
            Pair pair = TuplesKt.to("aid", configProvider2.getAppId());
            hashMap.put(pair.getFirst(), pair.getSecond());
            ConfigProvider configProvider3 = configProvider;
            if (configProvider3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider3 = null;
            }
            Pair pair2 = TuplesKt.to(com.bytedance.bdinstall.Api.KEY_APP_NAME, configProvider3.getAppName());
            hashMap.put(pair2.getFirst(), pair2.getSecond());
            ConfigProvider configProvider4 = configProvider;
            if (configProvider4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider4 = null;
            }
            Pair pair3 = TuplesKt.to("app_version", configProvider4.getAppVersion());
            hashMap.put(pair3.getFirst(), pair3.getSecond());
            ConfigProvider configProvider5 = configProvider;
            if (configProvider5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider5 = null;
            }
            Pair pair4 = TuplesKt.to("channel", configProvider5.getChannel());
            hashMap.put(pair4.getFirst(), pair4.getSecond());
            ConfigProvider configProvider6 = configProvider;
            if (configProvider6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider6 = null;
            }
            Pair pair5 = TuplesKt.to("lang", configProvider6.getLang());
            hashMap.put(pair5.getFirst(), pair5.getSecond());
            ConfigProvider configProvider7 = configProvider;
            if (configProvider7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider7 = null;
            }
            Pair pair6 = TuplesKt.to("sdk_version", configProvider7.getSDKVersion());
            hashMap.put(pair6.getFirst(), pair6.getSecond());
            ConfigProvider configProvider8 = configProvider;
            if (configProvider8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider8 = null;
            }
            Pair pair7 = TuplesKt.to("version_code", String.valueOf(configProvider8.getAppVersionCode()));
            hashMap.put(pair7.getFirst(), pair7.getSecond());
            ConfigProvider configProvider9 = configProvider;
            if (configProvider9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configProvider");
                configProvider9 = null;
            }
            Pair pair8 = TuplesKt.to("version_name", configProvider9.getAppVersion());
            hashMap.put(pair8.getFirst(), pair8.getSecond());
            Pair pair9 = TuplesKt.to("device_platform", Consts.OS_NAME);
            hashMap.put(pair9.getFirst(), pair9.getSecond());
            for (String str : hashMap.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                SettingsManager settingsManager = INSTANCE;
                String encode = settingsManager.encode(str);
                String str2 = (String) hashMap.get(str);
                sb.append(encode).append("=").append(str2 != null ? settingsManager.encode(str2) : null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private final String encode(String content) {
        try {
            return URLEncoder.encode(content, UrlUtils.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private final String appendPath(String str, String str2) {
        if (StringsKt.endsWith$default(str, "/", false, 2, (Object) null)) {
            return str + str2;
        }
        return str + '/' + str2;
    }
}
