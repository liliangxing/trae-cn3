package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.tobshadow.bdtracker.C0501q5;
import com.bytedance.tracing.log.Fields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.y4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0556y4 extends AbstractC0479n4 {

    /* renamed from: s */
    public String f1259s;

    /* renamed from: t */
    public String f1260t;

    public C0556y4() {
    }

    public C0556y4(String str, String str2) {
        this.f1260t = str;
        this.f1259s = str2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public int mo570a(Cursor cursor) {
        super.mo570a(cursor);
        this.f1260t = cursor.getString(14);
        this.f1259s = cursor.getString(15);
        return 16;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        super.mo266a(jSONObject);
        this.f1260t = jSONObject.optString(Fields.EVENT, null);
        this.f1259s = jSONObject.optString("params", null);
        return this;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public List<String> mo267b() {
        List<String> mo267b = super.mo267b();
        ArrayList arrayList = new ArrayList(mo267b.size());
        arrayList.addAll(mo267b);
        arrayList.addAll(Arrays.asList(Fields.EVENT, "varchar", "params", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        super.mo268b(contentValues);
        contentValues.put(Fields.EVENT, this.f1260t);
        contentValues.put("params", this.f1259s);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        super.mo269b(jSONObject);
        jSONObject.put(Fields.EVENT, this.f1260t);
        jSONObject.put("params", this.f1259s);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: c */
    public String mo270c() {
        return this.f1260t;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: e */
    public String mo577e() {
        return this.f1259s;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return IAppAuthService.Scope.PROFILE;
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
        jSONObject.put(Fields.EVENT, this.f1260t);
        m574a(jSONObject, this.f1259s);
        int i = this.f880k;
        if (i != C0501q5.a.UNKNOWN.f966a) {
            jSONObject.put("nt", i);
        }
        jSONObject.put("datetime", this.f883n);
        if (!TextUtils.isEmpty(this.f879j)) {
            jSONObject.put("ab_sdk_version", this.f879j);
        }
        return jSONObject;
    }
}
