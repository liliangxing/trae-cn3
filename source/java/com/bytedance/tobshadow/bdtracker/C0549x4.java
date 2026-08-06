package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tracing.log.Fields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.x4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0549x4 extends AbstractC0479n4 {

    /* renamed from: A */
    public int f1236A;

    /* renamed from: B */
    public String f1237B;

    /* renamed from: C */
    public boolean f1238C;

    /* renamed from: D */
    public boolean f1239D;

    /* renamed from: E */
    public Class<?> f1240E;

    /* renamed from: s */
    public long f1241s;

    /* renamed from: t */
    public String f1242t;

    /* renamed from: u */
    public String f1243u;

    /* renamed from: v */
    public String f1244v;

    /* renamed from: w */
    public String f1245w;

    /* renamed from: x */
    public String f1246x;

    /* renamed from: y */
    public String f1247y;

    /* renamed from: z */
    public long f1248z;

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public int mo570a(Cursor cursor) {
        super.mo570a(cursor);
        this.f1243u = cursor.getString(14);
        this.f1242t = cursor.getString(15);
        this.f1241s = cursor.getLong(16);
        this.f1236A = cursor.getInt(17);
        this.f1237B = cursor.getString(18);
        this.f1244v = cursor.getString(19);
        this.f1245w = cursor.getString(20);
        this.f1246x = cursor.getString(21);
        this.f1247y = cursor.getString(22);
        this.f1238C = cursor.getInt(23) == 1;
        this.f1239D = cursor.getInt(24) == 1;
        this.f1248z = cursor.getLong(25);
        return 26;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        super.mo266a(jSONObject);
        this.f1243u = jSONObject.optString("page_key", "");
        this.f1242t = jSONObject.optString("refer_page_key", null);
        this.f1241s = jSONObject.optLong(ReportConstant.COMMON_INIT_DURATION, 0L);
        this.f1236A = jSONObject.optInt("is_back", 0);
        this.f1244v = jSONObject.optString("page_title", "");
        this.f1245w = jSONObject.optString("refer_page_title", null);
        this.f1246x = jSONObject.optString("page_path", null);
        this.f1247y = jSONObject.optString("referrer_page_path", null);
        this.f1238C = jSONObject.optBoolean("is_custom", false);
        this.f1239D = jSONObject.optBoolean("is_fragment", false);
        this.f1248z = jSONObject.optLong("resume_at", 0L);
        return this;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public List<String> mo267b() {
        List<String> mo267b = super.mo267b();
        ArrayList arrayList = new ArrayList(mo267b.size());
        arrayList.addAll(mo267b);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", ReportConstant.COMMON_INIT_DURATION, "integer", "is_back", "integer", "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar", "is_custom", "integer", "is_fragment", "integer", "resume_at", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        super.mo268b(contentValues);
        contentValues.put("page_key", C0411e.m347a((Object) this.f1243u));
        contentValues.put("refer_page_key", this.f1242t);
        contentValues.put(ReportConstant.COMMON_INIT_DURATION, Long.valueOf(this.f1241s));
        contentValues.put("is_back", Integer.valueOf(this.f1236A));
        contentValues.put("last_session", this.f1237B);
        contentValues.put("page_title", this.f1244v);
        contentValues.put("refer_page_title", this.f1245w);
        contentValues.put("page_path", this.f1246x);
        contentValues.put("referrer_page_path", this.f1247y);
        contentValues.put("is_custom", Integer.valueOf(this.f1238C ? 1 : 0));
        contentValues.put("is_fragment", Integer.valueOf(this.f1239D ? 1 : 0));
        long j = this.f1248z;
        if (j <= 0) {
            j = this.f872c;
        }
        contentValues.put("resume_at", Long.valueOf(j));
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: c */
    public String mo270c() {
        return C0411e.m347a((Object) this.f1243u) + ", " + this.f1241s;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return "page";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: i */
    public JSONObject mo272i() {
        JSONObject jSONObject = new JSONObject();
        long j = this.f1248z;
        if (j <= 0) {
            j = this.f872c;
        }
        jSONObject.put("local_time_ms", j);
        jSONObject.put("datetime", AbstractC0479n4.m568b(j));
        jSONObject.put("tea_event_index", this.f873d);
        jSONObject.put("session_id", this.f874e);
        long j2 = this.f875f;
        if (j2 > 0) {
            jSONObject.put("user_id", j2);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f876g) ? JSONObject.NULL : this.f876g);
        if (!TextUtils.isEmpty(this.f877h)) {
            jSONObject.put("$user_unique_id_type", this.f877h);
        }
        if (!TextUtils.isEmpty(this.f878i)) {
            jSONObject.put("ssid", this.f878i);
        }
        jSONObject.put(Fields.EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("page_key", C0411e.m347a((Object) this.f1243u));
        jSONObject2.put("refer_page_key", this.f1242t);
        jSONObject2.put("is_back", this.f1236A);
        jSONObject2.put(ReportConstant.COMMON_INIT_DURATION, this.f1241s);
        jSONObject2.put("page_title", this.f1244v);
        jSONObject2.put("refer_page_title", this.f1245w);
        jSONObject2.put("page_path", this.f1246x);
        jSONObject2.put("referrer_page_path", this.f1247y);
        m575a(jSONObject, jSONObject2);
        return jSONObject;
    }

    /* renamed from: k */
    public boolean m752k() {
        return this.f1241s == -1;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        super.mo269b(jSONObject);
        jSONObject.put("page_key", C0411e.m347a((Object) this.f1243u));
        jSONObject.put("refer_page_key", this.f1242t);
        jSONObject.put(ReportConstant.COMMON_INIT_DURATION, this.f1241s);
        jSONObject.put("is_back", this.f1236A);
        jSONObject.put("page_title", this.f1244v);
        jSONObject.put("refer_page_title", this.f1245w);
        jSONObject.put("page_path", this.f1246x);
        jSONObject.put("referrer_page_path", this.f1247y);
        jSONObject.put("is_custom", this.f1238C);
        jSONObject.put("is_fragment", this.f1239D);
        jSONObject.put("resume_at", this.f1248z);
    }
}
