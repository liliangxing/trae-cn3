package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.agconnect.config.impl.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0982h implements AesDecrypt {

    /* renamed from: a */
    private final Context f847a;

    /* renamed from: b */
    private final String f848b;

    /* renamed from: c */
    private IDecrypt f849c;

    public C0982h(Context context, String str) {
        Log.d("AGC_FlexibleDecrypt", ReportUtil.Event.EVENT_INIT);
        this.f847a = context;
        this.f848b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.f849c == null) {
            this.f849c = decryptComponent();
        }
        if (this.f849c == null) {
            Log.w("AGC_FlexibleDecrypt", "decrypt Flexible Decrypt error, use old instead");
            this.f849c = new C0981g(this.f847a, this.f848b).decryptComponent();
        }
        return this.f849c.decrypt(C0986l.m824a(this.f847a, this.f848b, "agc_plugin_", str), str2);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        String m824a = C0986l.m824a(this.f847a, this.f848b, "agc_plugin_", "crypto_component");
        if (m824a == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Hex.decodeHexString(m824a), "utf-8"));
            return new C0980f(new C0978d(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e) {
            Log.e("AGC_FlexibleDecrypt", "FlexibleDecrypt exception: " + e.getMessage());
            return null;
        }
    }
}
