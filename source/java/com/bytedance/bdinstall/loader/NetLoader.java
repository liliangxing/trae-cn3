package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NetLoader extends BaseLoader {
    private final Context mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetLoader(Context context) {
        super(true, true);
        this.mApp = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_ACCESS, NetworkUtils.getNetworkAccessType(this.mApp));
        return true;
    }
}
