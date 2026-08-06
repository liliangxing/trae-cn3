package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ConfigLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mConfig;
    private final Env mEnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigLoader(Context context, InstallOptions installOptions, Env env) {
        super(false, true);
        this.mApp = context;
        this.mConfig = installOptions;
        this.mEnv = env;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        jSONObject.put("channel", this.mConfig.getChannel());
        jSONObject.put(Api.KEY_NOT_REQUEST_SENDER, 1);
        jSONObject.put("aid", this.mConfig.getAid());
        String releaseBuild = this.mConfig.getReleaseBuild();
        if (releaseBuild == null) {
            releaseBuild = "";
        }
        jSONObject.put("release_build", releaseBuild);
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_USER_AGENT, this.mConfig.getUserAgent());
        Utils.putStringIfNotEmpty(jSONObject, "ab_version", this.mConfig.getAbVersion());
        String appLanguage = this.mConfig.getAppLanguage();
        if (TextUtils.isEmpty(appLanguage)) {
            appLanguage = this.mConfig.getAppLanguageFromSp();
        }
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_APP_LANGUAGE, appLanguage);
        String appRegion = this.mConfig.getAppRegion();
        if (TextUtils.isEmpty(appRegion)) {
            appRegion = this.mConfig.getAppRegionFromSp();
        }
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_APP_REGION, appRegion);
        JSONObject appTrack = this.mConfig.getAppTrack();
        if (appTrack != null) {
            try {
                jSONObject.put(Api.KEY_APP_TRACK, appTrack);
            } catch (Throwable th) {
                DrLog.ysnp(th);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("custom");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(this.mConfig.getZijiePackage())) {
            optJSONObject.put(Api.KEY_REAL_PACKAGE_NAME, this.mConfig.getContext().getPackageName());
        }
        try {
            Map<String, Object> customHeader = this.mConfig.getCustomHeader();
            if (customHeader != null && customHeader.size() > 0) {
                for (String str : customHeader.keySet()) {
                    optJSONObject.put(str, customHeader.get(str));
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        jSONObject.put("custom", optJSONObject);
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject jSONObject) {
        super.remove(jSONObject);
        jSONObject.remove("channel");
        jSONObject.remove(Api.KEY_NOT_REQUEST_SENDER);
        jSONObject.remove("aid");
        jSONObject.remove("release_build");
        jSONObject.remove(Api.KEY_USER_AGENT);
        jSONObject.remove("ab_version");
        jSONObject.remove(Api.KEY_APP_LANGUAGE);
        jSONObject.remove(Api.KEY_APP_REGION);
        jSONObject.remove(Api.KEY_APP_TRACK);
        jSONObject.remove("custom");
    }
}
