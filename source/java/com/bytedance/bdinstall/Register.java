package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Register extends BaseWorker {
    private static final int REFRESH_BG = 43200000;
    private static final int REFRESH_UI = 21600000;
    private final AppStateListener mAppStateListener;
    private final InstallOptions mConfig;
    private final Env mEnv;
    private final DeviceManager mManager;
    private final RegisterResultListener mRegisterResultListener;
    private final IInstallParameters provider;
    static final long[] RETRY_DIFF = {GWorker.INTERVAL, 30000, 60000, 120000, 120000, 120000, 180000, 180000};
    private static final long[] RETRY_SAME = {180000, 360000, 540000, 540000, 900000, ReportConsts.LAST_STOP_INTERVAL};
    private static final long[] RETRY_EMPTY = {100, TraceStatsConsts.APP_START_MAX_LIMIT_MS, TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS, TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS, 60000, 60000, 180000, 180000, 540000, 540000};

    @Override // com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return "r";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needListenNetChange() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean needNet() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Register(InstallOptions installOptions, DeviceManager deviceManager, Env env, AppStateListener appStateListener) {
        super(installOptions.getContext(), installOptions, getLastRegisterTime(installOptions.getContext(), installOptions, deviceManager, env));
        this.mManager = deviceManager;
        this.mConfig = installOptions;
        this.mAppStateListener = appStateListener;
        this.mEnv = env;
        this.mRegisterResultListener = deviceManager;
        this.provider = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(installOptions.getAid()));
    }

    private static long getLastRegisterTime(Context context, InstallOptions installOptions, DeviceManager deviceManager, Env env) {
        SharedPreferences envIsolateSp;
        if (env == null || (envIsolateSp = env.getEnvIsolateSp(installOptions)) == null) {
            return 0L;
        }
        long j = envIsolateSp.getLong(Api.KEY_REGISTER_TIME, 0L);
        InstallInfo installInfo = deviceManager.getInstallInfo();
        if ((installInfo != null && Utils.checkId(installInfo.getDid()) && Utils.checkId(installInfo.getIid())) || j == 0) {
            return j;
        }
        envIsolateSp.edit().putLong(Api.KEY_REGISTER_TIME, 0L).apply();
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.BaseWorker
    public long nextInterval() {
        return this.mAppStateListener.isForeground() ? 21600000L : 43200000L;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        int registerState = this.mManager.getRegisterState();
        if (registerState == 0) {
            return RETRY_EMPTY;
        }
        if (registerState == 1) {
            return RETRY_SAME;
        }
        if (registerState == 2) {
            return RETRY_DIFF;
        }
        DrLog.ysnp(null);
        return RETRY_SAME;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() throws JSONException {
        DrLog.m139d("Register#doRegister");
        TTResponse doRequest = doRequest();
        if (DrLog.debug()) {
            DrLog.m139d("Register#doRegister result = " + doRequest);
        }
        if (doRequest == null) {
            return false;
        }
        boolean onRegisterResult = this.mRegisterResultListener.onRegisterResult(doRequest, this.mEnv, this.provider);
        if (onRegisterResult) {
            doSaveRequestTime(System.currentTimeMillis());
        }
        return onRegisterResult;
    }

    private void doSaveRequestTime(long j) {
        SharedPreferences envIsolateSp = this.mEnv.getEnvIsolateSp(this.mConfig);
        if (envIsolateSp != null) {
            envIsolateSp.edit().putLong(Api.KEY_REGISTER_TIME, j).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TTResponse doRequest() throws JSONException {
        String str;
        str = "";
        JSONObject buildHeader = buildHeader();
        TTResponse tTResponse = null;
        if (buildHeader == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", buildHeader);
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put(com.bytedance.applog.server.Api.KEY_GEN_TIME, System.currentTimeMillis());
        if (DrLog.debug()) {
            DrLog.m139d("register request header = " + jSONObject);
        }
        String uri = Uri.parse(this.mEnv.getConfig().getRegisterUri()).buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();
        this.mBdInstallInstance.getsInstallLock().setRequestingRegister(true);
        boolean z = (TextUtils.isEmpty(buildHeader.optString("device_id")) || TextUtils.isEmpty(buildHeader.optString("install_id"))) ? false : true;
        try {
            RegisterMonitor registerMonitor = EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid());
            if (registerMonitor != null) {
                registerMonitor.onRegisterRequestStart();
            }
            tTResponse = Api.register(this.mConfig.getNetworkClient(), BDInstall.getBDInstallConfig().getNetworkClientWrapper(), uri, jSONObject, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), z, this.mManager.getTicketGuardHelper().getTicketHeader(uri, true, true));
            if (registerMonitor != null) {
                registerMonitor.onRegisterRequestFinish();
            }
            return tTResponse;
        } finally {
            this.mBdInstallInstance.getsInstallLock().setRequestingRegister(false);
            EventUtils.onDidFetchResult(this.mConfig, buildHeader, new JSONObject(tTResponse != null ? tTResponse.getBody() : ""));
        }
    }

    JSONObject buildHeader() {
        JSONObject constHeader = this.mManager.getConstHeader();
        JSONObject jSONObject = new JSONObject();
        Utils.copy(jSONObject, constHeader);
        this.mManager.updateDrSpecialHeader(jSONObject, this.mEnv);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.BaseWorker
    public void updateFailCount(int i) {
        RegisterMonitor registerMonitor = EventUtils.getInstance().getRegisterMonitor(this.sOptions.getAid());
        if (registerMonitor != null) {
            registerMonitor.setRegisterFailCount(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.BaseWorker
    public void doEventTrack() {
        RegisterMonitor registerMonitor = EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid());
        SharedPreferences commonSp = LocalConstants.getCommonSp(this.mConfig.getContext(), this.mConfig);
        SharedPreferences.Editor edit = commonSp.edit();
        if (!commonSp.getBoolean(Api.SP_KEY_IS_FIRST_REGISTER_FOR_APP, false) && edit != null) {
            edit.putBoolean(Api.SP_KEY_IS_FIRST_REGISTER_FOR_APP, true);
            edit.apply();
            registerMonitor.setNewUser(true);
        }
        EventUtils.onRegisterResult(this.mConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.BaseWorker
    public void onResult(boolean z) {
        EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid()).setResult(z);
    }
}
