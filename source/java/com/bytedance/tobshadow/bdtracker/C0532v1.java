package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.v1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0532v1 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f1114e;

    public C0532v1(Context context) {
        super(true, false);
        this.f1114e = context;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "AppKey";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        try {
            Bundle bundle = this.f1114e.getPackageManager().getApplicationInfo(this.f1114e.getPackageName(), 128).metaData;
            if (bundle == null || TextUtils.isEmpty(SensitiveUtils.CHANNEL_APP_KEY)) {
                return true;
            }
            jSONObject.put("appkey", bundle.getString(SensitiveUtils.CHANNEL_APP_KEY));
            return true;
        } catch (Throwable th) {
            LoggerImpl.global().error("Load app key failed.", th, new Object[0]);
            return true;
        }
    }
}
