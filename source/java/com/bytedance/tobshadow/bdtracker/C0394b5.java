package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.C0501q5;
import com.bytedance.tracing.log.Fields;
import java.util.Collections;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.b5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0394b5 extends AbstractC0479n4 {

    /* renamed from: s */
    public static final JSONObject f472s;

    static {
        JSONObject jSONObject = new JSONObject();
        f472s = jSONObject;
        try {
            jSONObject.put("_staging_flag", 1);
            jSONObject.put("params_for_special", "applog_trace");
        } catch (Throwable th) {
            LoggerImpl.global().error(4, Collections.singletonList("trace"), "JSON handle failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return "trace";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: i */
    public JSONObject mo272i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f872c);
        jSONObject.put("tea_event_index", this.f873d);
        jSONObject.put("session_id", this.f874e);
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
        jSONObject.put(Fields.EVENT, "rangersapplog_trace");
        m575a(jSONObject, f472s);
        int i = this.f880k;
        if (i != C0501q5.a.UNKNOWN.f966a) {
            jSONObject.put("nt", i);
        }
        jSONObject.put("datetime", this.f883n);
        return jSONObject;
    }
}
