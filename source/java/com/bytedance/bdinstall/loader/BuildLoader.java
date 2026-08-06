package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.util.RomUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BuildLoader extends BaseLoader {
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuildLoader(Context context) {
        super(true, false);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", Build.BRAND.equals("Pico") ? RomUtils.getProductName() : Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        return true;
    }
}
