package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FlavorSpecialLoader extends BaseLoader {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlavorSpecialLoader(Context context, InstallOptions installOptions) {
        super(false, false);
    }
}
