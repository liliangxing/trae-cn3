package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SigHashLoader extends BaseLoader {
    private final Context mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SigHashLoader(Context context) {
        super(true, false);
        this.mApp = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature signature;
        String str = null;
        try {
            packageInfo = this.mApp.getPackageManager().getPackageInfo(this.mApp.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e) {
            DrLog.ysnp(e);
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && (signature = packageInfo.signatures[0]) != null) {
            str = DigestUtils.md5Hex(signature.toByteArray());
        }
        if (str == null) {
            return true;
        }
        jSONObject.put("sig_hash", str);
        return true;
    }
}
