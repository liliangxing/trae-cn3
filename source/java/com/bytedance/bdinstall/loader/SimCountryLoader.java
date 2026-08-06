package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.SensitiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SimCountryLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimCountryLoader(Context context, InstallOptions installOptions) {
        super(true, false);
        this.mApp = context;
        this.mOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_SIM_REGION, SensitiveUtils.getSimCountryIso(this.mOptions));
        return true;
    }
}
