package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.q2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0498q2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final C0407d2 f945e;

    public C0498q2(Context context, C0407d2 c0407d2, C0421f2 c0421f2) {
        super(true, false, false);
        this.f945e = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "ServerId";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        IKVStore iKVStore = this.f945e.f505f;
        String string = iKVStore.getString("device_id", null);
        C0421f2.m398a(jSONObject, "device_id", string);
        String string2 = iKVStore.getString("bd_did", null);
        C0421f2.m398a(jSONObject, "bd_did", string2);
        String string3 = iKVStore.getString("install_id", null);
        String string4 = iKVStore.getString(this.f945e.m318e(), null);
        C0421f2.m398a(jSONObject, "install_id", string3);
        C0421f2.m398a(jSONObject, "ssid", string4);
        long j = 0;
        long j2 = iKVStore.getLong("register_time", 0L);
        if ((C0411e.m361a(string3) && ((C0411e.m361a(string) || C0411e.m361a(string2)) && C0411e.m361a(string4))) || j2 == 0) {
            j = j2;
        } else {
            this.f945e.f505f.putLong("register_time", 0L);
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
