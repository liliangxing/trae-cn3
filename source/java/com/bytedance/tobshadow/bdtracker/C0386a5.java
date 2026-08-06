package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.a5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0386a5 extends AbstractC0479n4 {

    /* renamed from: s */
    public long f445s;

    /* renamed from: t */
    public long f446t;

    /* renamed from: u */
    public String f447u;

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        m576d().error(4, this.f870a, "Not allowed", new Object[0]);
        return this;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public List<String> mo267b() {
        return null;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        m576d().error(4, this.f870a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        m576d().error(4, this.f870a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: c */
    public String mo270c() {
        return String.valueOf(this.f445s);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return "terminate";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: i */
    public JSONObject mo272i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f872c);
        jSONObject.put("tea_event_index", this.f873d);
        jSONObject.put("session_id", this.f874e);
        jSONObject.put("stop_timestamp", this.f446t / 1000);
        jSONObject.put(ReportConstant.COMMON_INIT_DURATION, this.f445s / 1000);
        jSONObject.put("datetime", this.f883n);
        long j = this.f875f;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f876g) ? JSONObject.NULL : this.f876g);
        if (!TextUtils.isEmpty(this.f877h)) {
            jSONObject.put("$user_unique_id_type", this.f877h);
        }
        if (!TextUtils.isEmpty(this.f878i)) {
            jSONObject.put("ssid", this.f878i);
        }
        if (!TextUtils.isEmpty(this.f879j)) {
            jSONObject.put("ab_sdk_version", this.f879j);
        }
        if (!TextUtils.isEmpty(this.f447u)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.f447u, this.f874e)) {
                jSONObject.put("original_session_id", this.f447u);
            }
        }
        return jSONObject;
    }
}
