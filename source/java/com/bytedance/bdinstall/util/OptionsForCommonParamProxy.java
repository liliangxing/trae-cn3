package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.AppContext;
import com.bytedance.bdinstall.InstallOptions;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OptionsForCommonParamProxy {
    private AppContext mAppContext;
    private InstallOptions mOptions;

    public OptionsForCommonParamProxy(InstallOptions installOptions) {
        this.mOptions = installOptions;
    }

    public OptionsForCommonParamProxy(AppContext appContext) {
        this.mAppContext = appContext;
    }

    public String getChannel() {
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            String tweakedChannel = installOptions.getTweakedChannel();
            return TextUtils.isEmpty(tweakedChannel) ? this.mOptions.getChannel() : tweakedChannel;
        }
        AppContext appContext = this.mAppContext;
        if (appContext == null) {
            return null;
        }
        String tweakedChannel2 = appContext.getTweakedChannel();
        return TextUtils.isEmpty(tweakedChannel2) ? this.mAppContext.getChannel() : tweakedChannel2;
    }

    public long getAid() {
        int aid;
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            aid = installOptions.getAid();
        } else {
            AppContext appContext = this.mAppContext;
            if (appContext == null) {
                return 0L;
            }
            aid = appContext.getAid();
        }
        return aid;
    }

    public String getAppName() {
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            return installOptions.getAppName();
        }
        AppContext appContext = this.mAppContext;
        if (appContext != null) {
            return appContext.getAppName();
        }
        return null;
    }

    public long getVersionCode() {
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            return installOptions.getVersionCode();
        }
        AppContext appContext = this.mAppContext;
        if (appContext != null) {
            return appContext.getVersionCode();
        }
        return 0L;
    }

    public String getVersion() {
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            return installOptions.getVersion();
        }
        AppContext appContext = this.mAppContext;
        if (appContext != null) {
            return appContext.getVersion();
        }
        return null;
    }

    public long getManifestVersionCode() {
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            return installOptions.getManifestVersionCode();
        }
        AppContext appContext = this.mAppContext;
        if (appContext != null) {
            return appContext.getManifestVersionCode();
        }
        return 0L;
    }

    public long getUpdateVersionCode() {
        InstallOptions installOptions = this.mOptions;
        if (installOptions != null) {
            return installOptions.getUpdateVersionCode();
        }
        AppContext appContext = this.mAppContext;
        if (appContext != null) {
            return appContext.getUpdateVersionCode();
        }
        return 0L;
    }
}
