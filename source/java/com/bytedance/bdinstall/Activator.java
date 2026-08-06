package com.bytedance.bdinstall;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Activator extends BaseWorker {
    private ApiParamsUtil mApiParamsUtil;
    private final InstallOptions mConfig;
    private final Env mEnv;
    private boolean sHasSucceed;

    @Override // com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return "ac";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needListenNetChange() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean needNet() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long nextInterval() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activator(InstallOptions installOptions, Env env) {
        super(installOptions.getContext(), installOptions);
        this.sHasSucceed = false;
        this.mConfig = installOptions;
        this.mEnv = env;
        if (this.mBdInstallInstance != null) {
            this.mApiParamsUtil = this.mBdInstallInstance.getApiParamsUtil();
        }
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        return Register.RETRY_DIFF;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() {
        String buildUri = buildUri();
        if (TextUtils.isEmpty(buildUri)) {
            return false;
        }
        try {
            if (this.mBdInstallInstance != null) {
                this.mBdInstallInstance.getsInstallLock().setRequestingActive(true);
            }
            ActivateMonitor activateMonitor = EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid());
            if (activateMonitor != null) {
                activateMonitor.onActivateRequestStart();
            }
            boolean active = Api.active(this.mConfig.getNetworkClient(), BDInstall.getBDInstallConfig().getNetworkClientWrapper(), buildUri, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), this.sHasSucceed);
            if (activateMonitor != null) {
                activateMonitor.onActivateRequestFinish();
            }
            if (active) {
                this.sHasSucceed = true;
            }
            if (active) {
                stop();
            }
            return active;
        } finally {
            if (this.mBdInstallInstance != null) {
                this.mBdInstallInstance.getsInstallLock().setRequestingActive(false);
            }
        }
    }

    private String buildUri() {
        HashMap<String, String> extraParams;
        String activeUri = this.mEnv.getConfig().getActiveUri();
        ApiParamsUtil apiParamsUtil = this.mApiParamsUtil;
        if (apiParamsUtil != null) {
            activeUri = apiParamsUtil.appendNetParams(this.mApp, new StringBuilder(activeUri), null, true, Level.L0);
        }
        StringBuilder sb = new StringBuilder(activeUri);
        try {
            float timeZoneOffset = getTimeZoneOffset();
            Api.addParams(sb, "req_id", RequestIdGenerator.getRequestId());
            IAppTraitCallback appTraitCallback = this.mConfig.getAppTraitCallback();
            if (appTraitCallback != null) {
                Api.addParams(sb, "app_trait", appTraitCallback.get(this.mConfig.getContext()));
            }
            Api.addParams(sb, Api.KEY_TIMEZONE, timeZoneOffset + "");
            String zijiePackage = this.mConfig.getZijiePackage();
            if (!TextUtils.isEmpty(zijiePackage)) {
                Api.addParams(sb, "package", zijiePackage);
                Api.addParams(sb, Api.KEY_REAL_PACKAGE_NAME, this.mApp.getPackageName());
            }
            try {
                Api.addParams(sb, Api.KEY_CARRIER, SensitiveUtils.getNetworkOperatorName(this.mConfig));
                Api.addParams(sb, Api.KEY_MCC_MNC, SensitiveUtils.getNetworkOperator(this.mConfig));
                Api.addParams(sb, Api.KEY_SIM_REGION, SensitiveUtils.getSimCountryIso(this.mConfig));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ApiParamsForFlavor.addActiveParams(this.mApp, this.mConfig, sb);
            Api.addParams(sb, Api.KEY_APP_VERSION_MINOR, this.mConfig.getVersionMinor());
            Api.addParams(sb, "custom_bt", String.valueOf(getBootTime()));
            IExtraParams activeParam = this.mConfig.getActiveParam();
            if (activeParam != null && (extraParams = activeParam.getExtraParams(Level.L0)) != null) {
                for (Map.Entry<String, String> entry : extraParams.entrySet()) {
                    Api.addParams(sb, entry.getKey(), entry.getValue());
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            DrLog.ysnp(th);
            return sb.toString();
        }
    }

    private long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private float getTimeZoneOffset() {
        float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (rawOffset < -12.0f) {
            rawOffset = -12.0f;
        }
        if (rawOffset > 12.0f) {
            return 12.0f;
        }
        return rawOffset;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void updateFailCount(int i) {
        ActivateMonitor activateMonitor = EventUtils.getInstance().getActivateMonitor(this.sOptions.getAid());
        if (activateMonitor != null) {
            activateMonitor.setActivateFailCount(i);
        }
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void doEventTrack() {
        ActivateMonitor activateMonitor = EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid());
        SharedPreferences commonSp = LocalConstants.getCommonSp(this.mConfig.getContext(), this.mConfig);
        SharedPreferences.Editor edit = commonSp.edit();
        if (!commonSp.getBoolean(Api.SP_KEY_IS_FIRST_ACTIVATE_FOR_APP, false) && edit != null) {
            edit.putBoolean(Api.SP_KEY_IS_FIRST_ACTIVATE_FOR_APP, true);
            edit.apply();
            activateMonitor.setFirstActivate(true);
        }
        EventUtils.onActiveResult(this.mConfig);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void onResult(boolean z) {
        EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid()).setResult(z);
    }
}
