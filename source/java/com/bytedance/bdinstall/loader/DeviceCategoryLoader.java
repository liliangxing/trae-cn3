package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceCategoryLoader extends BaseLoader {
    private final InstallOptions mOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceCategoryLoader(Context context, InstallOptions installOptions) {
        super(true, true);
        this.mOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException {
        try {
            jSONObject.put(Api.KEY_DEVICE_CATEGORY, this.mOptions.getDeviceCategory());
            return true;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
