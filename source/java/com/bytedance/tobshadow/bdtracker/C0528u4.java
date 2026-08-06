package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.tobshadow.bdtracker.C0501q5;
import com.bytedance.tracing.log.Fields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.u4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0528u4 extends AbstractC0479n4 {

    /* renamed from: s */
    public String f1102s;

    /* renamed from: t */
    public boolean f1103t;

    /* renamed from: u */
    public String f1104u;

    public C0528u4() {
    }

    public C0528u4(String str) {
        this.f1104u = str;
    }

    public C0528u4(String str, String str2, boolean z, String str3) {
        this.f882m = str;
        this.f1104u = str2;
        this.f1103t = z;
        this.f1102s = str3;
        this.f881l = 0;
    }

    public C0528u4(String str, String str2, boolean z, String str3, int i) {
        this.f882m = str;
        this.f1104u = str2;
        this.f1103t = z;
        this.f1102s = str3;
        this.f881l = i;
    }

    public C0528u4(String str, JSONObject jSONObject) {
        this.f1104u = str;
        this.f884o = jSONObject;
    }

    public C0528u4(String str, boolean z) {
        this.f1104u = str;
        this.f1103t = z;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public int mo570a(Cursor cursor) {
        super.mo570a(cursor);
        this.f1104u = cursor.getString(14);
        this.f1102s = cursor.getString(15);
        this.f1103t = cursor.getInt(16) == 1;
        return 17;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        super.mo266a(jSONObject);
        this.f1104u = jSONObject.optString(Fields.EVENT, null);
        this.f1102s = jSONObject.optString("params", null);
        this.f1103t = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public List<String> mo267b() {
        List<String> mo267b = super.mo267b();
        ArrayList arrayList = new ArrayList(mo267b.size());
        arrayList.addAll(mo267b);
        arrayList.addAll(Arrays.asList(Fields.EVENT, "varchar", "params", "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        super.mo268b(contentValues);
        contentValues.put(Fields.EVENT, this.f1104u);
        if (this.f1103t && this.f1102s == null) {
            try {
                mo607k();
            } catch (Throwable th) {
                m576d().error(4, this.f870a, "Fill params failed", th, new Object[0]);
            }
        }
        contentValues.put("params", C0402c5.m297a(this.f1102s));
        contentValues.put("is_bav", Integer.valueOf(this.f1103t ? 1 : 0));
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        super.mo269b(jSONObject);
        jSONObject.put(Fields.EVENT, this.f1104u);
        if (this.f1103t && this.f1102s == null) {
            mo607k();
        }
        jSONObject.put("params", this.f1102s);
        jSONObject.put("is_bav", this.f1103t);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: c */
    public String mo270c() {
        return this.f1104u;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: e */
    public String mo577e() {
        return this.f1102s;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return "eventv3";
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
        jSONObject.put(Fields.EVENT, this.f1104u);
        if (this.f1103t) {
            jSONObject.put("is_bav", 1);
        }
        if (this.f1103t && this.f1102s == null) {
            mo607k();
        }
        m574a(jSONObject, this.f1102s);
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

    /* renamed from: k */
    public void mo607k() {
    }
}
