package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.c2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0399c2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final C0467m f479e;

    /* renamed from: f */
    public final C0407d2 f480f;

    public C0399c2(C0467m c0467m, Context context, C0407d2 c0407d2) {
        super(false, false);
        this.f479e = c0467m;
        this.f480f = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Config";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        jSONObject.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, 6171190);
        jSONObject.put("sdk_version_code", 16170789);
        jSONObject.put("sdk_version_name", "6.17.11-tobshadow");
        jSONObject.put(Constant.KEY_CHANNEL, this.f480f.m315b());
        jSONObject.put("not_request_sender", this.f480f.f502c.getNotReuqestSender() ? 1 : 0);
        C0421f2.m398a(jSONObject, Constant.KEY_AID, this.f480f.f502c.getAid());
        C0421f2.m398a(jSONObject, "release_build", this.f480f.f502c.getReleaseBuild());
        C0421f2.m398a(jSONObject, "user_agent", this.f480f.f505f.getString("user_agent", null));
        C0421f2.m398a(jSONObject, "ab_sdk_version", this.f480f.f503d.getString("ab_sdk_version", ""));
        String language = this.f480f.f502c.getLanguage();
        if (TextUtils.isEmpty(language)) {
            language = this.f480f.f505f.getString("app_language", null);
        }
        C0421f2.m398a(jSONObject, "app_language", language);
        String region = this.f480f.f502c.getRegion();
        if (TextUtils.isEmpty(region)) {
            region = this.f480f.f505f.getString("app_region", null);
        }
        if (TextUtils.isEmpty(region)) {
            region = Locale.getDefault().getCountry();
        }
        C0421f2.m398a(jSONObject, "app_region", region);
        String string = this.f480f.f503d.getString("app_track", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject.put("app_track", new JSONObject(string));
            } catch (Throwable th) {
                this.f479e.f764D.error("JSON handle appTrack failed", th, new Object[0]);
            }
        }
        String string2 = this.f480f.f503d.getString("header_custom_info", null);
        if (string2 != null && string2.length() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                jSONObject2.remove("_debug_flag");
                jSONObject.put("custom", jSONObject2);
            } catch (Throwable th2) {
                this.f479e.f764D.error("JSON handle failed", th2, new Object[0]);
            }
        }
        String m319f = this.f480f.m319f();
        if (!TextUtils.isEmpty(m319f)) {
            C0421f2.m398a(jSONObject, "user_unique_id", m319f);
        }
        String m320g = this.f480f.m320g();
        if (TextUtils.isEmpty(m320g)) {
            return true;
        }
        C0421f2.m398a(jSONObject, "user_unique_id_type", m320g);
        return true;
    }
}
