package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.ISensitiveInfoProvider;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.p2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0491p2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final ISensitiveInfoProvider f909e;

    /* renamed from: f */
    public final Context f910f;

    /* renamed from: g */
    public final C0407d2 f911g;

    /* renamed from: h */
    public final C0421f2 f912h;

    public C0491p2(Context context, C0407d2 c0407d2, C0421f2 c0421f2, ISensitiveInfoProvider iSensitiveInfoProvider) {
        super(true, false);
        this.f909e = iSensitiveInfoProvider;
        this.f910f = context;
        this.f911g = c0407d2;
        this.f912h = c0421f2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "SensitiveLoader";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        C0421f2.m398a(jSONObject, SensitiveUtils.KEY_ALIYUN_UUID, this.f911g.f502c.getAliyunUdid());
        C0407d2 c0407d2 = this.f911g;
        if (c0407d2.f502c.isMacEnable() && !c0407d2.m314a("mac")) {
            String macAddress = SensitiveUtils.getMacAddress(this.f909e, this.f910f);
            IKVStore iKVStore = this.f911g.f505f;
            String string = iKVStore.getString(SensitiveUtils.KEY_MAC, null);
            if (!TextUtils.isEmpty(macAddress)) {
                if (!TextUtils.equals(string, macAddress)) {
                    iKVStore.putString(SensitiveUtils.KEY_MAC, macAddress);
                }
                jSONObject.put(SensitiveUtils.KEY_MC, macAddress);
            } else if (!TextUtils.isEmpty(string)) {
                jSONObject.put(SensitiveUtils.KEY_MC, string);
            }
        }
        C0421f2.m398a(jSONObject, "udid", this.f912h.f591h.m516e());
        JSONArray m517f = this.f912h.f591h.m517f();
        if (SensitiveUtils.validMultiImei(m517f)) {
            jSONObject.put("udid_list", m517f);
        }
        if (this.f911g.f502c.isSerialNumberEnable()) {
            jSONObject.put(SensitiveUtils.KEY_BUILD_SERIAL, SensitiveUtils.getSerialNumber(this.f910f));
            C0421f2.m398a(jSONObject, "serial_number", this.f912h.f591h.m515d());
        }
        return true;
    }
}
