package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AppTraitLoader extends BaseLoader {
    private final Context mContext;
    private final InstallOptions mOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppTraitLoader(Context context, InstallOptions installOptions) {
        super(true, false);
        this.mContext = context;
        this.mOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException {
        IAppTraitCallback appTraitCallback = this.mOptions.getAppTraitCallback();
        DrLog.m139d("IAppTraitCallback = " + appTraitCallback);
        if (appTraitCallback == null) {
            return true;
        }
        String str = appTraitCallback.get(this.mContext);
        DrLog.m139d("IAppTraitCallback.get = " + str);
        jSONObject.put("app_trait", str);
        return true;
    }
}
