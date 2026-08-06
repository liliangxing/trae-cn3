package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PackageLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PackageLoader(Context context, InstallOptions installOptions) {
        super(false, false);
        this.mApp = context;
        this.mConfig = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        int i;
        String packageName = this.mApp.getPackageName();
        if (TextUtils.isEmpty(this.mConfig.getZijiePackage())) {
            jSONObject.put("package", packageName);
        } else {
            if (DrLog.debug()) {
                DrLog.m139d("has zijie pkg");
            }
            jSONObject.put("package", this.mConfig.getZijiePackage());
            jSONObject.put(Api.KEY_REAL_PACKAGE_NAME, packageName);
        }
        try {
            jSONObject.put("app_version", this.mConfig.getVersion());
            jSONObject.put(Api.KEY_APP_VERSION_MINOR, this.mConfig.getVersionMinor());
            jSONObject.put("version_code", this.mConfig.getVersionCode());
            jSONObject.put("update_version_code", this.mConfig.getUpdateVersionCode());
            jSONObject.put("manifest_version_code", this.mConfig.getManifestVersionCode());
            if (!TextUtils.isEmpty(this.mConfig.getAppName())) {
                jSONObject.put(Api.KEY_APP_NAME, this.mConfig.getAppName());
            }
            if (!TextUtils.isEmpty(this.mConfig.getTweakedChannel())) {
                jSONObject.put(Api.KEY_TWEAKED_CHANNEL, this.mConfig.getTweakedChannel());
            }
            try {
                PackageInfo packageInfo = this.mApp.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo.applicationInfo == null || (i = packageInfo.applicationInfo.labelRes) <= 0) {
                    return true;
                }
                jSONObject.put(Api.KEY_DISPLAY_NAME, this.mApp.getString(i));
                return true;
            } catch (Throwable th) {
                DrLog.m141e("PackageLoader#getPackageInfo error", th);
                return true;
            }
        } catch (Throwable th2) {
            DrLog.ysnp(th2);
            return false;
        }
    }
}
