package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.tobshadow.applog.log.AbstractAppLogLogger;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.n4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0479n4 implements Cloneable {

    /* renamed from: q */
    public static final SimpleDateFormat f868q = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: r */
    public static final AbstractC0438h5<HashMap<String, AbstractC0479n4>> f869r = new a();

    /* renamed from: a */
    public List<String> f870a;

    /* renamed from: b */
    public long f871b;

    /* renamed from: c */
    public long f872c;

    /* renamed from: d */
    public long f873d;

    /* renamed from: e */
    public String f874e;

    /* renamed from: f */
    public long f875f;

    /* renamed from: g */
    public String f876g;

    /* renamed from: h */
    public String f877h;

    /* renamed from: i */
    public String f878i;

    /* renamed from: j */
    public String f879j;

    /* renamed from: k */
    public int f880k;

    /* renamed from: l */
    public int f881l;

    /* renamed from: m */
    public String f882m;

    /* renamed from: n */
    public String f883n;

    /* renamed from: o */
    public JSONObject f884o;

    /* renamed from: p */
    public String f885p;

    /* renamed from: com.bytedance.tobshadow.bdtracker.n4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a extends AbstractC0438h5<HashMap<String, AbstractC0479n4>> {
        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0438h5
        /* renamed from: a */
        public HashMap<String, AbstractC0479n4> mo455a(Object[] objArr) {
            return AbstractC0479n4.m569j();
        }
    }

    public AbstractC0479n4() {
        m573a(0L);
        this.f870a = Collections.singletonList(mo271f());
        this.f885p = C0411e.m373c();
    }

    /* renamed from: a */
    public static AbstractC0479n4 m566a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return f869r.m456b(new Object[0]).get(jSONObject.optString("k_cls", "")).m1094clone().mo266a(jSONObject);
        } catch (Throwable th) {
            LoggerImpl.global().error(4, "JSON handle failed", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public static void m567a(AbstractC0479n4 abstractC0479n4, String str) {
        try {
            JSONObject jSONObject = abstractC0479n4.f884o;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("$app_version", str);
            abstractC0479n4.f884o = jSONObject;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static String m568b(long j) {
        return f868q.format(new Date(j));
    }

    /* renamed from: j */
    public static HashMap<String, AbstractC0479n4> m569j() {
        HashMap<String, AbstractC0479n4> hashMap = new HashMap<>();
        hashMap.put("page", new C0549x4());
        hashMap.put("launch", new C0535v4());
        hashMap.put("terminate", new C0386a5());
        hashMap.put("packV2", new C0542w4());
        hashMap.put("eventv3", new C0528u4());
        hashMap.put("custom_event", new C0500q4());
        hashMap.put(IAppAuthService.Scope.PROFILE, new C0556y4(null, null));
        hashMap.put("trace", new C0394b5());
        return hashMap;
    }

    /* renamed from: a */
    public int mo570a(Cursor cursor) {
        this.f871b = cursor.getLong(0);
        this.f872c = cursor.getLong(1);
        this.f873d = cursor.getLong(2);
        this.f880k = cursor.getInt(3);
        this.f875f = cursor.getLong(4);
        this.f874e = cursor.getString(5);
        this.f876g = cursor.getString(6);
        this.f877h = cursor.getString(7);
        this.f878i = cursor.getString(8);
        this.f879j = cursor.getString(9);
        this.f881l = cursor.getInt(10);
        this.f882m = cursor.getString(11);
        String string = cursor.getString(12);
        this.f885p = cursor.getString(13);
        this.f884o = new JSONObject();
        if (TextUtils.isEmpty(string)) {
            return 14;
        }
        try {
            this.f884o = new JSONObject(string);
            return 14;
        } catch (Exception unused) {
            return 14;
        }
    }

    /* renamed from: a */
    public final ContentValues m571a(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        mo268b(contentValues);
        return contentValues;
    }

    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        this.f872c = jSONObject.optLong("local_time_ms", 0L);
        this.f871b = 0L;
        this.f873d = 0L;
        this.f880k = 0;
        this.f875f = 0L;
        this.f874e = null;
        this.f876g = null;
        this.f877h = null;
        this.f878i = null;
        this.f879j = null;
        this.f882m = jSONObject.optString("_app_id");
        this.f884o = jSONObject.optJSONObject("properties");
        this.f885p = jSONObject.optString("local_event_id", C0411e.m373c());
        return this;
    }

    /* renamed from: a */
    public final String m572a() {
        List<String> mo267b = mo267b();
        if (mo267b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(mo271f()).append("(");
        for (int i = 0; i < mo267b.size(); i += 2) {
            sb.append(mo267b.get(i)).append(" ").append(mo267b.get(i + 1)).append(IWeiboService.Scope.EMPTY_SCOPE);
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m573a(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.f872c = j;
    }

    /* renamed from: a */
    public void m574a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            m575a(jSONObject, new JSONObject());
            return;
        }
        try {
            m575a(jSONObject, new JSONObject(str));
        } catch (Throwable th) {
            m576d().error(4, this.f870a, "Merge params failed", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public void m575a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            C0411e.m375c(jSONObject2, jSONObject3);
        }
        JSONObject jSONObject4 = this.f884o;
        if (jSONObject4 != null && jSONObject4.length() > 0) {
            C0411e.m375c(this.f884o, jSONObject3);
        }
        try {
            jSONObject.put("params", jSONObject3);
        } catch (Throwable th) {
            m576d().error(4, this.f870a, "Merge params failed", th, new Object[0]);
        }
    }

    /* renamed from: b */
    public List<String> mo267b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", "user_id", "integer", "session_id", "varchar", "user_unique_id", "varchar", "user_unique_id_type", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", "integer", "_app_id", "varchar", "properties", "varchar", "local_event_id", "varchar");
    }

    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f872c));
        contentValues.put("tea_event_index", Long.valueOf(this.f873d));
        contentValues.put("nt", Integer.valueOf(this.f880k));
        contentValues.put("user_id", Long.valueOf(this.f875f));
        contentValues.put("session_id", this.f874e);
        contentValues.put("user_unique_id", C0411e.m347a((Object) this.f876g));
        contentValues.put("user_unique_id_type", this.f877h);
        contentValues.put("ssid", this.f878i);
        contentValues.put("ab_sdk_version", this.f879j);
        contentValues.put("event_type", Integer.valueOf(this.f881l));
        contentValues.put("_app_id", this.f882m);
        JSONObject jSONObject = this.f884o;
        contentValues.put("properties", jSONObject != null ? jSONObject.toString() : "");
        contentValues.put("local_event_id", this.f885p);
    }

    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f872c);
        jSONObject.put("_app_id", this.f882m);
        jSONObject.put("properties", this.f884o);
        jSONObject.put("local_event_id", this.f885p);
    }

    /* renamed from: c */
    public String mo270c() {
        return C0380a.m252a("sid:").append(this.f874e).toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AbstractC0479n4 m1094clone() {
        try {
            AbstractC0479n4 abstractC0479n4 = (AbstractC0479n4) super.clone();
            abstractC0479n4.f885p = C0411e.m373c();
            return abstractC0479n4;
        } catch (CloneNotSupportedException e) {
            m576d().error(4, this.f870a, "Clone data failed", e, new Object[0]);
            return null;
        }
    }

    /* renamed from: d */
    public IAppLogLogger m576d() {
        IAppLogLogger logger = AbstractAppLogLogger.getLogger(this.f882m);
        return logger != null ? logger : LoggerImpl.global();
    }

    /* renamed from: e */
    public String mo577e() {
        return null;
    }

    /* renamed from: f */
    public abstract String mo271f();

    /* renamed from: g */
    public final JSONObject m578g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", mo271f());
            mo269b(jSONObject);
        } catch (JSONException e) {
            m576d().error(4, this.f870a, "JSON handle failed", e, new Object[0]);
        }
        return jSONObject;
    }

    /* renamed from: h */
    public final JSONObject m579h() {
        JSONObject jSONObject = new JSONObject();
        try {
            this.f883n = m568b(this.f872c);
            return mo272i();
        } catch (JSONException e) {
            m576d().error(4, this.f870a, "JSON handle failed", e, new Object[0]);
            return jSONObject;
        }
    }

    /* renamed from: i */
    public abstract JSONObject mo272i();

    public String toString() {
        String mo271f = mo271f();
        if (!getClass().getSimpleName().equalsIgnoreCase(mo271f)) {
            mo271f = mo271f + ", " + getClass().getSimpleName();
        }
        String str = this.f874e;
        if (str != null) {
            int indexOf = str.indexOf("-");
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
        } else {
            str = "-";
        }
        return "{" + mo271f + ", " + mo270c() + ", " + str + ", " + this.f872c + ", " + this.f873d + ", " + this.f874e + "}";
    }
}
