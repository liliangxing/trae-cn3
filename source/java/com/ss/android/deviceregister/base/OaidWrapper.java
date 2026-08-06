package com.ss.android.deviceregister.base;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.ss.android.deviceregister.LogUtils;
import com.ss.android.deviceregister.base.OaidApi;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class OaidWrapper {
    private static volatile OaidWrapper sOaid;
    private final Context context;
    private final OaidApi mImpl;
    private OaidModel mModel;
    private Future<OaidModel> mOaidGetFuture;
    private final boolean maySupport;
    private final OaidSp oaidSp;
    private final AtomicBoolean sInitializing = new AtomicBoolean(false);

    public static OaidWrapper instance(Context context) {
        if (sOaid == null) {
            synchronized (OaidWrapper.class) {
                if (sOaid == null) {
                    sOaid = new OaidWrapper(context);
                }
            }
        }
        return sOaid;
    }

    private OaidWrapper(Context context) {
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
            this.mOaidGetFuture = TTExecutors.getIOThreadPool().submit(new Callable<OaidModel>() { // from class: com.ss.android.deviceregister.base.OaidWrapper.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public OaidModel call() {
                    return OaidWrapper.this.resolveOaid();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OaidModel resolveOaid() {
        LogUtils.d(LogUtils.TAG, "Oaid#initOaid");
        LogUtils.d(LogUtils.TAG, "Oaid#initOaid exec");
        OaidModel fetch = this.oaidSp.fetch();
        LogUtils.d(LogUtils.TAG, "Oaid#initOaid fetch=" + fetch);
        if (fetch != null) {
            this.mModel = fetch;
        }
        OaidModel callSysOaid = callSysOaid(this.context, fetch);
        if (callSysOaid != null) {
            this.oaidSp.save(callSysOaid);
        }
        if (callSysOaid != null) {
            this.mModel = callSysOaid;
        }
        LogUtils.d(LogUtils.TAG, "Oaid#initOaid oaidModel=" + callSysOaid);
        return callSysOaid;
    }

    public Map<String, String> getOaid(long j) {
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
                LogUtils.d(LogUtils.TAG, "Oaid#getOaid timeoutMills=" + j);
                OaidModel oaidModel2 = this.mOaidGetFuture.get(j, TimeUnit.MILLISECONDS);
                LogUtils.d(LogUtils.TAG, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                oaidModel = oaidModel2;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    LogUtils.d(LogUtils.TAG, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                }
            }
        }
        if (oaidModel == null) {
            oaidModel = this.mModel;
        }
        Map<String, String> apiMap = oaidModel != null ? oaidModel.toApiMap() : null;
        LogUtils.d(LogUtils.TAG, "Oaid#getOaid return apiMap=" + apiMap);
        return apiMap;
    }

    public String getOaidId() {
        init();
        OaidModel oaidModel = this.mModel;
        String str = oaidModel != null ? oaidModel.oaid : null;
        LogUtils.d(LogUtils.TAG, "Oaid#getOaidId sOaidId = " + str);
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
            i = oaidModel.queryTimes.intValue() + 1;
        } else {
            i = -1;
        }
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        return new OaidModel(oaid.oaid, str, Boolean.valueOf(oaid.isTrackLimit), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i > 0 ? i : 1), Long.valueOf(oaid.versionCode));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long safeParseLong(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }

    public String getImplName() {
        OaidApi oaidApi = this.mImpl;
        if (oaidApi == null) {
            return null;
        }
        return oaidApi.getName(this.context);
    }
}
