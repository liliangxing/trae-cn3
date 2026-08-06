package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.v4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0535v4 extends AbstractC0479n4 {

    /* renamed from: s */
    public int f1135s;

    /* renamed from: t */
    public String f1136t;

    /* renamed from: u */
    public boolean f1137u;

    /* renamed from: v */
    public String f1138v;

    /* renamed from: w */
    public int f1139w;

    /* renamed from: x */
    public String f1140x;

    /* renamed from: y */
    public String f1141y;

    /* renamed from: z */
    public boolean f1142z;

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public int mo570a(Cursor cursor) {
        super.mo570a(cursor);
        this.f1136t = cursor.getString(14);
        this.f1135s = cursor.getInt(15);
        this.f1138v = cursor.getString(16);
        this.f1139w = cursor.getInt(17);
        this.f1140x = cursor.getString(18);
        this.f1141y = cursor.getString(19);
        this.f1142z = cursor.getInt(20) == 1;
        return 21;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        m576d().error(4, this.f870a, "Not allowed", new Object[0]);
        return null;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public List<String> mo267b() {
        List<String> mo267b = super.mo267b();
        ArrayList arrayList = new ArrayList(mo267b.size());
        arrayList.addAll(mo267b);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", "page_title", "varchar", "page_key", "varchar", "resume_from_background", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        super.mo268b(contentValues);
        contentValues.put("ver_name", this.f1136t);
        contentValues.put("ver_code", Integer.valueOf(this.f1135s));
        contentValues.put("last_session", this.f1138v);
        contentValues.put("is_first_time", Integer.valueOf(this.f1139w));
        contentValues.put("page_title", this.f1140x);
        contentValues.put("page_key", this.f1141y);
        contentValues.put("resume_from_background", Integer.valueOf(this.f1142z ? 1 : 0));
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        m576d().error(4, this.f870a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: c */
    public String mo270c() {
        return this.f1137u ? "bg" : "fg";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return "launch";
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
        boolean z = this.f1137u;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.f883n);
        if (!TextUtils.isEmpty(this.f879j)) {
            jSONObject.put("ab_sdk_version", this.f879j);
        }
        C0467m m491a = C0453k.m491a(this.f882m);
        if (m491a != null) {
            String deepLinkUrl = m491a.getDeepLinkUrl();
            if (!TextUtils.isEmpty(deepLinkUrl)) {
                jSONObject.put("$deeplink_url", deepLinkUrl);
            }
        }
        if (!TextUtils.isEmpty(this.f1138v)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.f1138v);
        }
        if (this.f1139w == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$page_title", TextUtils.isEmpty(this.f1140x) ? "" : this.f1140x);
        jSONObject.put("$page_key", TextUtils.isEmpty(this.f1141y) ? "" : this.f1141y);
        jSONObject.put("$resume_from_background", this.f1142z ? "true" : "false");
        return jSONObject;
    }
}
