package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppKeyLoader extends BaseLoader {
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppKeyLoader(Context context) {
        super(true, false);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException {
        try {
            Bundle bundle = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData;
            if (bundle == null) {
                return true;
            }
            jSONObject.put(Api.KEY_APPKEY, bundle.getString(SensitiveUtils.CHANNEL_APP_KEY));
            return true;
        } catch (Exception e) {
            DrLog.e("getApplicationInfo error", e);
            return true;
        }
    }
}
