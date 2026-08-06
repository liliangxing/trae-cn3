package ms.bd.p001c;

import android.text.TextUtils;
import android.view.Display;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bouncycastle.math.ec.Tnaf;
import org.json.JSONObject;

/* renamed from: ms.bd.c.r3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0201r3 {

    /* renamed from: j */
    public static C0201r3 f371j;

    /* renamed from: a */
    public long f372a;

    /* renamed from: b */
    public long f373b;

    /* renamed from: c */
    public long f374c;

    /* renamed from: d */
    public int f375d = 1;

    /* renamed from: e */
    public long f376e;

    /* renamed from: f */
    public String f377f;

    /* renamed from: g */
    public String f378g;

    /* renamed from: h */
    public String f379h;

    /* renamed from: i */
    public boolean f380i;

    /* renamed from: a */
    public static String m183a(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                StringBuilder sb2 = new StringBuilder();
                Object m182a = m182a(display, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "ea21a1", new byte[]{121, 71, 72, 86, 78, 42, 103, 89, 74, 111, 114, 108}));
                sb2.append(m182a(m182a, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "f22b10", new byte[]{120, 39, 79, 19, 28, 23, 100, Tnaf.POW_2_WIDTH, 104, 51, 112, 53, 111, 23, 3, 34}))).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "4ba1b2", new byte[]{105}));
                sb2.append(m182a(m182a, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "28fc58", new byte[]{37, 54, 20, Tnaf.POW_2_WIDTH, 25}))).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "56b230", new byte[]{104}));
                sb2.append(m182a(m182a, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "cd029e", new byte[]{124, 103, 78, 67}))).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "fb719f", new byte[]{59}));
                sb2.append(m182a(m182a, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "ed6bca", new byte[]{96, Byte.MAX_VALUE, 85, 19})));
                if (!sb.toString().contains(sb2.toString())) {
                    if (sb.length() > 0) {
                        sb.append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "880e3e", new byte[]{114}));
                    }
                    sb.append((CharSequence) sb2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m184b(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                Object m182a = m182a(display, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "7c6225", new byte[]{43, 78, 82, 72, 8, 48, 4, 67, 100, 105, 39, 102, 64, 104, 12, 47, 49}));
                if (m182a != null && !sb.toString().contains(m182a.toString())) {
                    sb.append(m182a);
                    sb.append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "97fc79", new byte[]{115}));
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m182a(Object obj, String str) {
        Field field;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9e49b9", new byte[]{47, 98, 83, 105, 88, 45, 54, 69, 119, 108, 44, 65, 78, 72, 81, 42}), String.class);
            if (declaredMethod == null || (field = (Field) declaredMethod.invoke(obj.getClass(), str)) == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final JSONObject m185a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e3d03f", new byte[]{117, 37}), this.f372a);
            jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2883e4", new byte[]{49, 46}), this.f373b);
            jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "43c9f0", new byte[]{33, 60}), this.f375d);
            jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9a8558", new byte[]{44, 119}), this.f376e);
            jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "f92e31", new byte[]{116, 58, 69}), this.f380i ? 1 : 0);
            jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "f7ddf8", new byte[]{122, 49}), this.f377f);
            if (!TextUtils.isEmpty(this.f378g)) {
                jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9dc04f", new byte[]{56, 109}), this.f378g);
            }
            if (!TextUtils.isEmpty(this.f379h)) {
                jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "033488", new byte[]{37, 56}), this.f379h);
            }
            this.f374c = System.currentTimeMillis();
            jSONObject.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2d9c91", new byte[]{32, 114}), this.f374c / 1000);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
