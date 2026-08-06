package com.bytedance.trae.apm.impl;

import android.app.Application;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IExitReasonCallback;
import com.bytedance.crash.Npth;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.terminate.TerminateMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.trae.apm.api.IExtraParams;
import com.bytedance.trae.apm.api.INpth;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.ThreadUtils;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NpthImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/apm/impl/NpthImpl;", "Lcom/bytedance/trae/apm/api/INpth;", "<init>", "()V", "init", "", "baseCtx", "Landroid/content/Context;", "deviceIdKV", "Lcom/bytedance/keva/Keva;", "trySaveDeviceIdToKeva", "getDeviceIdFromKeva", "", "getDeviceIdForNpth", "registerExitReasonCallback", "addAttachUserData", "registerCrashCallback", "getCurrentDateString", "crashCallback", "Lcom/bytedance/trae/apm/api/ICrashCallback;", "getProcessNameFromCmd", "stopUpload", "stop", "", "goUpload", "startNpthLifecycleRecorder", "app", "Landroid/app/Application;", "maxLifeCycleCount", "", "enableGwpAsan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NpthImpl implements INpth {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NpthImpl";
    private final Keva deviceIdKV;

    public NpthImpl() {
        Keva repo = Keva.getRepo("device_id_repo", 1);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        this.deviceIdKV = repo;
    }

    /* compiled from: NpthImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/apm/impl/NpthImpl$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return NpthImpl.TAG;
        }
    }

    @Override // com.bytedance.trae.apm.api.INpth
    public void init(Context baseCtx) {
        Intrinsics.checkNotNullParameter(baseCtx, "baseCtx");
        Npth.setApplication(AppHost.INSTANCE.getApplication());
        App.setCurProcessName(getProcessNameFromCmd());
        Npth.init(baseCtx, new ICommonParams() { // from class: com.bytedance.trae.apm.impl.NpthImpl$init$1
            public List<String> getPatchInfo() {
                return null;
            }

            public Map<String, Integer> getPluginInfo() {
                return null;
            }

            public Map<String, Object> getCommonParams() {
                HashMap hashMap = new HashMap();
                hashMap.put(Constant.KEY_AID, Integer.valueOf(AppHost.INSTANCE.getAppId()));
                hashMap.put(Constant.KEY_CHANNEL, AppHost.INSTANCE.getBuildChannel());
                hashMap.put(Constant.KEY_APP_VERSION, AppHost.INSTANCE.getVersionName());
                hashMap.put("version_code", Integer.valueOf(AppHost.INSTANCE.getVersionCode()));
                hashMap.put(Constant.KEY_UPDATE_VERSION_CODE, Integer.valueOf(AppHost.INSTANCE.getUpdateVersionCode()));
                String country = Locale.getDefault().getCountry();
                Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
                if (!TextUtils.isEmpty(country)) {
                    Npth.addTag("region", country);
                    hashMap.put("region", country);
                }
                hashMap.put("flow_app_variant", IExtraParams.INSTANCE.getAppVariant());
                return hashMap;
            }

            public String getDeviceId() {
                String deviceIdForNpth;
                deviceIdForNpth = NpthImpl.this.getDeviceIdForNpth();
                return deviceIdForNpth;
            }

            public long getUserId() {
                Object obj;
                try {
                    Result.Companion companion = Result.Companion;
                    NpthImpl$init$1 npthImpl$init$1 = this;
                    Long longOrNull = StringsKt.toLongOrNull(IApplog.INSTANCE.getUserID());
                    obj = Result.constructor-impl(Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = 0L;
                }
                return ((Number) obj).longValue();
            }

            public String getSessionId() {
                return IApplog.INSTANCE.getSessionId();
            }
        }, true, true, true);
        IApplog.INSTANCE.addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.apm.impl.NpthImpl$init$2
            @Override // com.bytedance.trae.applog.api.OnGetAppLogIdListener
            public void onGetId(String did, String iid, String ssid) {
                Intrinsics.checkNotNullParameter(did, "did");
                Intrinsics.checkNotNullParameter(iid, "iid");
                Intrinsics.checkNotNullParameter(ssid, "ssid");
                if (NpthBus.getSettingManager().isDidSet() || TextUtils.isEmpty(did) || Intrinsics.areEqual("0", did)) {
                    return;
                }
                NpthBus.getSettingManager().setDeviceId(did);
            }
        });
        registerCrashCallback();
        registerExitReasonCallback();
        addAttachUserData();
        trySaveDeviceIdToKeva();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trySaveDeviceIdToKeva() {
        ThreadUtils.postInBackground(new Runnable() { // from class: com.bytedance.trae.apm.impl.NpthImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NpthImpl.trySaveDeviceIdToKeva$lambda$0(NpthImpl.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trySaveDeviceIdToKeva$lambda$0(final NpthImpl npthImpl) {
        String deviceId = IApplog.INSTANCE.getDeviceId();
        if (!TextUtils.isEmpty(deviceId) && !Intrinsics.areEqual("0", deviceId)) {
            if (Intrinsics.areEqual(npthImpl.getDeviceIdFromKeva(), deviceId)) {
                return;
            }
            npthImpl.deviceIdKV.storeString("latest_did", deviceId);
            return;
        }
        IApplog.INSTANCE.addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.apm.impl.NpthImpl$trySaveDeviceIdToKeva$1$1
            @Override // com.bytedance.trae.applog.api.OnGetAppLogIdListener
            public void onGetId(String did, String iid, String ssid) {
                Intrinsics.checkNotNullParameter(did, "did");
                Intrinsics.checkNotNullParameter(iid, "iid");
                Intrinsics.checkNotNullParameter(ssid, "ssid");
                NpthImpl.this.trySaveDeviceIdToKeva();
            }
        });
    }

    private final String getDeviceIdFromKeva() {
        String string = this.deviceIdKV.getString("latest_did", "");
        if (!TextUtils.isEmpty(string) && !Intrinsics.areEqual("0", string)) {
            FLogger.INSTANCE.i(TAG, "getDeviceIdFromKeva latest_did success");
        } else {
            FLogger.INSTANCE.i(TAG, "getDeviceIdFromKeva latest_did empty");
        }
        Intrinsics.checkNotNull(string);
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDeviceIdForNpth() {
        String deviceId = IApplog.INSTANCE.getDeviceId();
        if (!TextUtils.isEmpty(deviceId) && !Intrinsics.areEqual("0", deviceId)) {
            FLogger.INSTANCE.i(TAG, "getDeviceIdForNpth: GetDeviceId from AppLog success");
            return deviceId;
        }
        return getDeviceIdFromKeva();
    }

    private final void registerExitReasonCallback() {
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        TerminateMonitor.registerExitReasonCallback(new IExitReasonCallback() { // from class: com.bytedance.trae.apm.impl.NpthImpl$$ExternalSyntheticLambda0
            public final void findOneExitReason(ApplicationExitInfo applicationExitInfo) {
                NpthImpl.registerExitReasonCallback$lambda$1(applicationExitInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerExitReasonCallback$lambda$1(ApplicationExitInfo applicationExitInfo) {
        FLogger.INSTANCE.w(TAG, "App exit reason: " + applicationExitInfo);
    }

    private final void addAttachUserData() {
        Npth.addAttachUserData(new NpthAttachUserDataImpl(), CrashType.ALL);
    }

    private final void registerCrashCallback() {
        Npth.registerCrashCallback(new ICrashCallback() { // from class: com.bytedance.trae.apm.impl.NpthImpl$$ExternalSyntheticLambda1
            public final void onCrash(CrashType crashType, String str, Thread thread) {
                NpthImpl.registerCrashCallback$lambda$2(NpthImpl.this, crashType, str, thread);
            }
        }, CrashType.ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerCrashCallback$lambda$2(NpthImpl npthImpl, CrashType crashType, String str, Thread thread) {
        Intrinsics.checkNotNullParameter(crashType, DBData.FIELD_TYPE);
        try {
            StringBuilder append = new StringBuilder("crash occurs!\n").append("crash-time:").append(npthImpl.getCurrentDateString()).append("\n");
            Intrinsics.checkNotNullExpressionValue(append, "append(...)");
            if (thread != null) {
                append.append("thread-name:").append(thread.getName()).append("\n").append("thread-id:").append(thread.getId()).append("\n").append("process-name:").append(npthImpl.getProcessNameFromCmd()).append("\n");
            }
            append.append("crash-type:").append(crashType).append("\n");
            if (str != null) {
                append.append(str).append("\n");
            }
            FLogger.INSTANCE.e("CrashMonitor", append.toString());
        } catch (Throwable th) {
            FLogger.INSTANCE.e("CrashMonitor", "registerCrashCallback error", th);
        }
    }

    private final String getCurrentDateString() {
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.trae.apm.api.INpth
    public void registerCrashCallback(final com.bytedance.trae.apm.api.ICrashCallback crashCallback) {
        Intrinsics.checkNotNullParameter(crashCallback, "crashCallback");
        Npth.registerCrashCallback(new ICrashCallback() { // from class: com.bytedance.trae.apm.impl.NpthImpl$$ExternalSyntheticLambda3
            public final void onCrash(CrashType crashType, String str, Thread thread) {
                NpthImpl.registerCrashCallback$lambda$3(com.bytedance.trae.apm.api.ICrashCallback.this, crashType, str, thread);
            }
        }, CrashType.ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerCrashCallback$lambda$3(com.bytedance.trae.apm.api.ICrashCallback iCrashCallback, CrashType crashType, String str, Thread thread) {
        Intrinsics.checkNotNullParameter(crashType, DBData.FIELD_TYPE);
        iCrashCallback.onCrash(str);
    }

    private final String getProcessNameFromCmd() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                Intrinsics.checkNotNull(readLine);
                String str = readLine;
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                readLine = str.subSequence(i, length + 1).toString();
            }
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return readLine;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        }
    }

    @Override // com.bytedance.trae.apm.api.INpth
    public void stopUpload(boolean stop) {
        if (stop) {
            Npth.stopUpload();
        }
    }

    @Override // com.bytedance.trae.apm.api.INpth
    public void goUpload() {
        try {
            Reflect.on("com.bytedance.crash.NpthCore").set("sStopUpload", false);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.trae.apm.api.INpth
    public void startNpthLifecycleRecorder(Application app, int maxLifeCycleCount) {
        Intrinsics.checkNotNullParameter(app, "app");
        NpthLifecycleRecoder.INSTANCE.onAppCreate(AppHost.INSTANCE.getApplication(), maxLifeCycleCount);
    }

    @Override // com.bytedance.trae.apm.api.INpth
    public void enableGwpAsan() {
        Npth.enableGwpAsan(true);
    }
}
