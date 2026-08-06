package com.bytedance.bdinstall.loader;

import android.content.SharedPreferences;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ServerIdLoader extends BaseLoader {
    private final InstallOptions mConfig;
    private final Env mEnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerIdLoader(InstallOptions installOptions, Env env) {
        super(true, false, false);
        this.mConfig = installOptions;
        this.mEnv = env;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        SharedPreferences envIsolateSp = this.mEnv.getEnvIsolateSp(this.mConfig);
        String deviceId = ((IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mConfig.getAid()))).getDeviceId();
        String string = envIsolateSp.getString("bd_did", null);
        String string2 = envIsolateSp.getString("install_id", null);
        String string3 = envIsolateSp.getString("ssid", null);
        String string4 = envIsolateSp.getString(Api.KEY_ENCRYPT_DID, null);
        String string5 = envIsolateSp.getString(Api.KEY_ENCRYPT_IID, null);
        String string6 = envIsolateSp.getString(Api.KEY_KLINK_EGDI, null);
        if (DrLog.debug()) {
            DrLog.m139d("load d=" + deviceId + " i=" + string2 + " s=" + string3 + " eDid=" + string4 + " eIid=" + string5);
        }
        Utils.putStringIfNotEmpty(jSONObject, "install_id", string2);
        Utils.putStringIfNotEmpty(jSONObject, "device_id", deviceId);
        Utils.putStringIfNotEmpty(jSONObject, "ssid", string3);
        Utils.putStringIfNotEmpty(jSONObject, "bd_did", string);
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_ENCRYPT_DID, string4);
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_ENCRYPT_IID, string5);
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_KLINK_EGDI, string6);
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject jSONObject) throws SecurityException {
        jSONObject.remove("bd_did");
        jSONObject.remove("install_id");
        jSONObject.remove("ssid");
        jSONObject.remove("device_id");
        jSONObject.remove(Api.KEY_ENCRYPT_DID);
        jSONObject.remove(Api.KEY_ENCRYPT_IID);
    }
}
