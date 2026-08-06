package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class v1 extends y1 {
    public final Context e;

    public v1(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.tobshadow.bdtracker.y1
    public String a() {
        return "AppKey";
    }

    @Override // com.bytedance.tobshadow.bdtracker.y1
    public boolean a(JSONObject jSONObject) {
        try {
            Bundle bundle = this.e.getPackageManager().getApplicationInfo(this.e.getPackageName(), 128).metaData;
            if (bundle == null || TextUtils.isEmpty(SensitiveUtils.CHANNEL_APP_KEY)) {
                return true;
            }
            jSONObject.put(Api.KEY_APPKEY, bundle.getString(SensitiveUtils.CHANNEL_APP_KEY));
            return true;
        } catch (Throwable th) {
            LoggerImpl.global().error("Load app key failed.", th, new Object[0]);
            return true;
        }
    }
}
