package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.q4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0500q4 extends AbstractC0479n4 {

    /* renamed from: s */
    public String f948s;

    /* renamed from: t */
    public String f949t;

    public C0500q4() {
        this.f948s = null;
        this.f949t = null;
    }

    public C0500q4(String str, JSONObject jSONObject) {
        this.f949t = null;
        this.f948s = str;
        if (jSONObject != null) {
            this.f949t = jSONObject.toString();
        }
        this.f881l = 0;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public int mo570a(Cursor cursor) {
        super.mo570a(cursor);
        this.f949t = cursor.getString(14);
        this.f948s = cursor.getString(15);
        return 16;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        super.mo266a(jSONObject);
        this.f949t = jSONObject.optString("params", null);
        this.f948s = jSONObject.optString("category", null);
        return this;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public List<String> mo267b() {
        List<String> mo267b = super.mo267b();
        ArrayList arrayList = new ArrayList(mo267b.size());
        arrayList.addAll(mo267b);
        arrayList.addAll(Arrays.asList("params", "varchar", "category", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        super.mo268b(contentValues);
        contentValues.put("params", this.f949t);
        contentValues.put("category", this.f948s);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        super.mo269b(jSONObject);
        jSONObject.put("params", this.f949t);
        jSONObject.put("category", this.f948s);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: c */
    public String mo270c() {
        return C0380a.m252a("param:").append(this.f949t).append(" category:").append(this.f948s).toString();
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return "custom_event";
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
        if (C0411e.m379d(this.f949t)) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.f949t);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (jSONObject.opt(next) != null) {
                        m576d().warn(4, this.f870a, "自定义事件存在重复的key", new Object[0]);
                    }
                    jSONObject.put(next, obj);
                }
            } catch (Exception e) {
                m576d().warn(4, this.f870a, "解析事件参数失败", e);
            }
        }
        return jSONObject;
    }
}
