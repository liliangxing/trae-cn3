package com.bytedance.bdinstall;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.util.LocalConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GWorker extends Register {
    public static final long INTERVAL = 10000;
    private final long[] RETRY_INTERVAL;
    private final InstallOptions mConfig;

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    protected void doEventTrack() {
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return "GWorker";
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    protected void onResult(boolean z) {
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    protected void updateFailCount(int i) {
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public /* bridge */ /* synthetic */ boolean needListenNetChange() {
        return super.needListenNetChange();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GWorker(InstallOptions installOptions, DeviceManager deviceManager, Env env, AppStateListener appStateListener) {
        super(installOptions, deviceManager, env, appStateListener);
        this.RETRY_INTERVAL = new long[]{INTERVAL, INTERVAL, INTERVAL};
        this.mConfig = installOptions;
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        int egdiRetryInterval = BDInstall.getBDInstallConfig().getEgdiRetryInterval();
        if (egdiRetryInterval <= 0) {
            return this.RETRY_INTERVAL;
        }
        long j = egdiRetryInterval;
        return new long[]{j, j, j};
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    protected long nextInterval() {
        return super.nextInterval();
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() throws JSONException {
        String optString;
        if (this.mFailCount >= this.RETRY_INTERVAL.length) {
            DrLog.m139d("[egdi]  retry count has limited and stop worker");
            stop();
            return true;
        }
        TTResponse doRequest = doRequest();
        if (doRequest == null) {
            return false;
        }
        try {
            optString = new JSONObject(doRequest.getBody()).optString(Api.KEY_KLINK_EGDI, "");
        } catch (JSONException e) {
            DrLog.m141e("[egdi] " + e.getMessage(), e);
        }
        if (TextUtils.isEmpty(optString)) {
            DrLog.m139d("[egdi]  egdi is null");
            return false;
        }
        SharedPreferences sp = this.mConfig.getSp();
        SharedPreferences commonSp = LocalConstants.getCommonSp(this.mApp, this.mConfig);
        if (sp != null) {
            sp.edit().putString(Api.KEY_KLINK_EGDI, optString).apply();
            DrLog.m139d("[egdi]  egdi is cached to olad sp applog_stats");
        }
        if (commonSp != null) {
            commonSp.edit().putString(Api.KEY_KLINK_EGDI, optString).apply();
            DrLog.m139d("[egdi]  egdi is cached to global sp ug_install_settings_pref_aid");
        }
        return true;
    }
}
