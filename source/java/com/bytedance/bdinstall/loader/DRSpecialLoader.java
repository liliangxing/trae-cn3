package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BuildConfig;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.PreInstallChannelCallback;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.bdturing.utils.Consts;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DRSpecialLoader {
    private static final String KEY_FIRST_INSTALL_TIME = "apk_first_install_time";
    private static final String KEY_GIT_HASH = "git_hash";
    private static final String KEY_IS_SYSTEM_APP = "is_system_app";
    private static final String KEY_PRE_INSTALL_CHANNEL = "pre_installed_channel";
    private final InstallOptions mOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DRSpecialLoader(InstallOptions installOptions) {
        this.mOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean doLoad(JSONObject jSONObject, Env env) throws JSONException, SecurityException {
        if (env.isChildMode()) {
            jSONObject.put("scene", 2);
        }
        jSONObject.put("device_platform", Consts.OS_NAME);
        new HarmonyLoader().doLoad(jSONObject);
        jSONObject.put(KEY_GIT_HASH, BuildConfig.GIT_HASH);
        jSONObject.put("sdk_version_code", DrLog.SDK_VERSION_CODE);
        jSONObject.put(Api.KEY_SDK_TARGET_VERSION, 30);
        jSONObject.put("req_id", RequestIdGenerator.getRequestId());
        jSONObject.put("sdk_version", BuildConfig.BDINSTALL_VERSION_NAME);
        jSONObject.put("guest_mode", this.mOptions.isTouristMode() ? 1 : 0);
        jSONObject.put("sdk_flavor", BuildConfig.FLAVOR);
        if (MigrateDetector.isThisDeviceMigrate(this.mOptions.getContext(), this.mOptions)) {
            String oldDid = MigrateDetector.getOldDid(this.mOptions.getContext(), this.mOptions);
            if (TextUtils.isEmpty(oldDid)) {
                oldDid = "";
            }
            try {
                jSONObject.put("old_did", oldDid);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addPreInstallInfo(jSONObject);
        INewUserModeService iNewUserModeService = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(this.mOptions.getAid()));
        if (iNewUserModeService != null) {
            iNewUserModeService.addNewUserModeExtra(jSONObject);
        }
        setScene(this.mOptions, env, iNewUserModeService);
        return true;
    }

    private void addPreInstallInfo(JSONObject jSONObject) throws JSONException {
        Context context = this.mOptions.getContext();
        PreInstallChannelCallback preInstallChannelCallback = this.mOptions.getPreInstallChannelCallback();
        if (preInstallChannelCallback != null) {
            jSONObject.put(KEY_PRE_INSTALL_CHANNEL, preInstallChannelCallback.getChannel(context));
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                jSONObject.put(KEY_FIRST_INSTALL_TIME, packageInfo.firstInstallTime);
                jSONObject.put(KEY_IS_SYSTEM_APP, (packageInfo.applicationInfo.flags & 1) == 1 ? 1 : 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void setScene(InstallOptions installOptions, Env env, INewUserModeService iNewUserModeService) {
        RegisterMonitor registerMonitor = EventUtils.getInstance().getRegisterMonitor(installOptions.getAid());
        ActivateMonitor activateMonitor = EventUtils.getInstance().getActivateMonitor(installOptions.getAid());
        if (env.isChildMode()) {
            registerMonitor.setScene(2);
            activateMonitor.setScene(2);
        } else if (installOptions.isTouristMode()) {
            registerMonitor.setScene(1);
            activateMonitor.setScene(1);
        } else {
            registerMonitor.setScene(0);
            activateMonitor.setScene(0);
        }
        if (iNewUserModeService != null) {
            registerMonitor.setNewUserMode(iNewUserModeService.isNewUserMode() ? 1 : 0);
            activateMonitor.setNewUserMode(iNewUserModeService.isNewUserMode() ? 1 : 0);
        }
    }
}
