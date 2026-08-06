package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.SensitiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceParamsLoader extends BaseLoader {
    private final Context mApp;
    private final Env mEnv;
    private final InstallOptions mOption;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceParamsLoader(Context context, InstallOptions installOptions, Env env) {
        super(false, true);
        this.mApp = context;
        this.mOption = installOptions;
        this.mEnv = env;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException {
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_CARRIER, SensitiveUtils.getNetworkOperatorName(this.mOption));
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_MCC_MNC, SensitiveUtils.getNetworkOperator(this.mOption));
        IInstallParameters iInstallParameters = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOption.getAid()));
        Utils.putStringIfNotEmpty(jSONObject, "clientudid", iInstallParameters.getClientUDID());
        if (!this.mEnv.isChildMode()) {
            Utils.putStringIfNotEmpty(jSONObject, "openudid", iInstallParameters.getOpenUdid(true));
        }
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject jSONObject) {
        super.remove(jSONObject);
        jSONObject.remove(Api.KEY_CARRIER);
        jSONObject.remove(Api.KEY_MCC_MNC);
        jSONObject.remove("clientudid");
        jSONObject.remove("openudid");
    }
}
