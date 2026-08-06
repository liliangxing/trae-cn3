package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.IOaidObserver;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.OaidChangeEvent;
import com.bytedance.bdinstall.event.ParamsMonitor;
import com.bytedance.bdinstall.oaid.HWOaidImpl;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Oaid {
    public static final String KEY_OAID_ID = "oaid";
    private static volatile Oaid sOaid;
    private final Context context;
    private CallbackCenter mCallbackCenter;
    private final OaidApi mImpl;
    private OaidModel mModel;
    private Future<OaidModel> mOaidGetFuture;
    private InstallOptions mOptions;
    private Runnable mPendingNotifyTask;
    private final boolean maySupport;
    private final OaidSp oaidSp;
    private final AtomicBoolean sInitializing = new AtomicBoolean(false);

    public static Oaid instance(Context context) {
        if (sOaid == null) {
            synchronized (Oaid.class) {
                if (sOaid == null) {
                    sOaid = new Oaid(context);
                }
            }
        }
        return sOaid;
    }

    public void setCallbackCenter(CallbackCenter callbackCenter) {
        this.mCallbackCenter = callbackCenter;
    }

    public void setInstallOptions(InstallOptions installOptions) {
        this.mOptions = installOptions;
    }

    private Oaid(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        OaidApi createOaidImpl = OaidFactory.createOaidImpl(context);
        this.mImpl = createOaidImpl;
        if (createOaidImpl != null) {
            this.maySupport = createOaidImpl.support(context);
        } else {
            this.maySupport = false;
        }
        this.oaidSp = new OaidSp(applicationContext);
    }

    public void init() {
        if (this.sInitializing.compareAndSet(false, true)) {
            OaidMonitor.onInit();
            this.mOaidGetFuture = ExecutorUtil.submitToFirstIOExecutor(new Callable<OaidModel>() { // from class: com.bytedance.bdinstall.oaid.Oaid.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public OaidModel call() {
                    return Oaid.this.resolveOaid();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OaidModel resolveOaid() {
        DrLog.m139d("Oaid#initOaid");
        OaidMonitor.onRealStartInit();
        try {
            DrLog.m139d("Oaid#initOaid exec");
            OaidModel fetch = this.oaidSp.fetch();
            DrLog.m139d("Oaid#initOaid fetch=" + fetch);
            if (fetch != null) {
                this.mModel = fetch;
            }
            OaidMonitor.onStartSystemCall();
            OaidModel callSysOaid = callSysOaid(this.context, fetch);
            OaidMonitor.onSystemCallFinished();
            if (callSysOaid != null) {
                this.oaidSp.save(callSysOaid);
            }
            if (callSysOaid != null) {
                this.mModel = callSysOaid;
            }
            DrLog.m139d("Oaid#initOaid oaidModel=" + callSysOaid);
            return callSysOaid;
        } finally {
            OaidMonitor.onOaidFinished();
            this.mPendingNotifyTask = new Runnable() { // from class: com.bytedance.bdinstall.oaid.Oaid.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LocalConstants.getCommonSp(Oaid.this.context, Oaid.this.mOptions).getBoolean(Api.KEY_STARTED, false)) {
                        String str = Oaid.this.mModel != null ? Oaid.this.mModel.oaid : null;
                        if (Oaid.this.mCallbackCenter != null) {
                            Oaid.this.mCallbackCenter.postEvent(new OaidChangeEvent(new IOaidObserver.Oaid(str, Oaid.this.maySupport)));
                        }
                        Oaid.this.mPendingNotifyTask = null;
                    }
                }
            };
            trySendOaidGetEvent();
        }
    }

    private synchronized void trySendOaidGetEvent() {
        Runnable runnable = this.mPendingNotifyTask;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void startNotify() {
        trySendOaidGetEvent();
    }

    public Map<String, String> getOaid(long j) {
        ParamsMonitor paramsMonitor;
        Map<String, String> map = null;
        if (!this.maySupport) {
            return null;
        }
        init();
        OaidModel oaidModel = this.mModel;
        if (oaidModel == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                if (this.mImpl instanceof HonorOaidImpl) {
                    j += 100;
                }
                DrLog.m143v("Oaid#getOaid timeoutMills=" + j);
                OaidModel oaidModel2 = this.mOaidGetFuture.get(j, TimeUnit.MILLISECONDS);
                DrLog.m139d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                oaidModel = oaidModel2;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    DrLog.m139d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                }
            }
        }
        if (oaidModel == null) {
            oaidModel = this.mModel;
        }
        if (oaidModel != null) {
            map = oaidModel.toApiMap();
            if (this.mOptions != null && (paramsMonitor = EventUtils.getInstance().getParamsMonitor(this.mOptions.getAid())) != null) {
                if (oaidModel.isTrackLimited == null || !oaidModel.isTrackLimited.booleanValue()) {
                    paramsMonitor.setFlag(0);
                } else {
                    paramsMonitor.setFlag(1);
                }
                paramsMonitor.setState(!TextUtils.isEmpty(oaidModel.oaid) ? 1 : 0);
                paramsMonitor.setType(1);
                paramsMonitor.setDuration(OaidMonitor.getSystemCallFinished() - OaidMonitor.getStartSystemCall());
            }
        }
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            EventUtils.onRegisterParams(installOptions);
        }
        DrLog.m143v("Oaid#getOaid return apiMap=" + map);
        return map;
    }

    public String getOaidId() {
        init();
        OaidModel oaidModel = this.mModel;
        String str = oaidModel != null ? oaidModel.oaid : null;
        DrLog.m143v("Oaid#getOaidId sOaidId=" + str);
        return str;
    }

    public boolean maySupport() {
        init();
        return this.maySupport;
    }

    private OaidModel callSysOaid(Context context, OaidModel oaidModel) {
        OaidApi.Result oaid;
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        OaidApi oaidApi = this.mImpl;
        String str = null;
        if (oaidApi == null || (oaid = oaidApi.getOaid(context)) == null) {
            return null;
        }
        if (oaidModel != null) {
            str = oaidModel.reqId;
            i = (oaidModel.queryTimes == null ? 0 : oaidModel.queryTimes.intValue()) + 1;
        } else {
            i = -1;
        }
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        return new OaidModel(oaid.oaid, str, Boolean.valueOf(oaid.isTrackLimit), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i > 0 ? i : 1), Long.valueOf(oaid instanceof HWOaidImpl.HWOaid ? ((HWOaidImpl.HWOaid) oaid).versionCode : 0L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void safePutNonEmptyValue(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void safePutNonNullValue(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isPackageExisted(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public String getImplName() {
        OaidApi oaidApi = this.mImpl;
        if (oaidApi == null) {
            return null;
        }
        return oaidApi.getName();
    }

    public void clear() {
        this.oaidSp.clear();
    }
}
