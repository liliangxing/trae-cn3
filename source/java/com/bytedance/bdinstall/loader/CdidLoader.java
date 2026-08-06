package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CdidLoader extends BaseLoader {
    private final InstallOptions mConfig;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CdidLoader(Context context, InstallOptions installOptions) {
        super(true, true);
        this.mContext = context;
        this.mConfig = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException {
        String str = Cdid.get(this.mConfig);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        jSONObject.put(Cdid.KEY_CDID, str);
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject jSONObject) {
        super.remove(jSONObject);
        jSONObject.remove(Cdid.KEY_CDID);
    }
}
