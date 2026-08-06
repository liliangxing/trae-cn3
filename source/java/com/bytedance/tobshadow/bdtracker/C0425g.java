package com.bytedance.tobshadow.bdtracker;

import com.bytedance.sdk.account.save.database.DBData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0425g {

    /* renamed from: a */
    public final String f603a;

    /* renamed from: b */
    public final String f604b;

    /* renamed from: c */
    public final Boolean f605c;

    /* renamed from: d */
    public final Long f606d;

    /* renamed from: e */
    public final Long f607e;

    /* renamed from: f */
    public final Integer f608f;

    /* renamed from: g */
    public final Long f609g;

    public C0425g(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.f603a = str;
        this.f604b = str2;
        this.f605c = bool;
        this.f606d = l;
        this.f607e = l2;
        this.f608f = num;
        this.f609g = l3;
    }

    /* renamed from: a */
    public Map<String, String> m441a() {
        HashMap hashMap = new HashMap();
        C0418f.m392a(hashMap, "id", this.f603a);
        C0418f.m392a(hashMap, "req_id", this.f604b);
        C0418f.m392a(hashMap, "is_track_limited", String.valueOf(this.f605c));
        C0418f.m392a(hashMap, "take_ms", String.valueOf(this.f606d));
        C0418f.m392a(hashMap, DBData.FIELD_TIME, String.valueOf(this.f607e));
        C0418f.m392a(hashMap, "query_times", String.valueOf(this.f608f));
        C0418f.m392a(hashMap, "hw_id_version_code", String.valueOf(this.f609g));
        return hashMap;
    }

    /* renamed from: b */
    public JSONObject m442b() {
        JSONObject jSONObject = new JSONObject();
        C0418f.m393a(jSONObject, "id", this.f603a);
        C0418f.m393a(jSONObject, "req_id", this.f604b);
        C0418f.m393a(jSONObject, "is_track_limited", this.f605c);
        C0418f.m393a(jSONObject, "take_ms", this.f606d);
        C0418f.m393a(jSONObject, DBData.FIELD_TIME, this.f607e);
        C0418f.m393a(jSONObject, "query_times", this.f608f);
        C0418f.m393a(jSONObject, "hw_id_version_code", this.f609g);
        return jSONObject;
    }

    public String toString() {
        return m442b().toString();
    }
}
