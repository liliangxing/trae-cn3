package cn.com.chinatelecom.account.api.p010e;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.api.e.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0703j {

    /* renamed from: a */
    public static final byte[] f298a = {-30, -91, -67, -20, -69, -120, -30, -68, -113, -20, -99, -68};

    /* renamed from: b */
    public static final byte[] f299b = {-30, -91, -67, -20, -69, -120, -19, -73, -101, -19, -79, -106, -17, -74, -120, -17, -78, -78};

    /* renamed from: c */
    public static final byte[] f300c = {-17, -103, -121, -17, -80, -98, -19, -86, -117, -29, -98, -109, -30, -91, -91};

    /* renamed from: d */
    public static final byte[] f301d = {-20, -99, -86, -19, -73, -101, -19, -79, -106, -30, -75, -108, -20, -124, -81};

    /* renamed from: e */
    public static final byte[] f302e = {-19, -83, -79, -17, Byte.MIN_VALUE, -94, -19, -73, -101, -19, -79, -106, -20, -106, -96, -17, -74, -118, -17, -102, -91};

    /* renamed from: f */
    public static final byte[] f303f = {89, 101, 105, 97, 111, 126, -30, -68, -113, -20, -99, -68, -17, -74, -120, -17, -78, -78};

    /* renamed from: g */
    public static final byte[] f304g = {-17, -107, -107, -17, -102, -121, -30, -83, -87, -20, -108, -102, -17, -74, -120, -17, -78, -78};

    /* renamed from: h */
    public static final byte[] f305h = {67, 69, -17, -74, -120, -17, -78, -78};

    /* renamed from: i */
    public static final byte[] f306i = {-19, -109, -79, -17, -73, -97, -19, -79, -103, -20, -108, -106, -18, -78, -80, -19, -93, -80};

    /* renamed from: j */
    public static final byte[] f307j = {-19, -109, -79, -17, -73, -97, -17, -74, -120, -17, -78, -78};

    /* renamed from: k */
    public static final byte[] f308k = {-29, -88, -114, -19, -109, -79, -17, -73, -97, -17, -74, -120, -17, -78, -78};

    /* renamed from: l */
    public static final byte[] f309l = {-30, -91, -67, -17, -113, -126, -17, -126, -105, -17, -83, -127, -17, -122, -100, 89, 78, 65};

    /* renamed from: m */
    public static final byte[] f310m = {-19, -98, -94, -20, -126, -67, -17, -113, -71, -29, -99, -89, -19, -97, -122, -29, -105, -88};

    /* renamed from: n */
    public static final byte[] f311n = {-17, -113, -68, -18, -79, -100, -19, -109, -79, -17, -73, -97, -20, -100, -77, -17, -74, -123};

    /* renamed from: o */
    public static final byte[] f312o = {93, 67, 76, 67, -17, -126, -115, -20, -121, -88, -30, -68, -113, -20, -99, -68};

    /* renamed from: p */
    public static final byte[] f313p = {93, 67, 76, 67, -17, -126, -115, -20, -121, -88, -17, -74, -120, -17, -78, -78};

    /* renamed from: q */
    public static final byte[] f314q = {-17, -125, -121, -19, -73, -92, -17, -107, -107, -17, -102, -121, -30, -83, -87, -20, -108, -102, -17, -82, -69, -30, -66, -81};

    /* renamed from: a */
    public static String m362a(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(StrategyConstants.RESULT, i);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("reqId", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static JSONObject m363a() {
        return m364a(80003, C0678d.m189a(f301d));
    }

    /* renamed from: a */
    public static JSONObject m364a(int i, String str) {
        return m366b(i, str, null);
    }

    /* renamed from: b */
    public static JSONObject m365b() {
        return m366b(80001, C0678d.m189a(f299b), null);
    }

    /* renamed from: b */
    public static JSONObject m366b(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(StrategyConstants.RESULT, i);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("reqId", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: c */
    public static JSONObject m367c() {
        return m364a(80000, C0678d.m189a(f298a));
    }

    /* renamed from: d */
    public static JSONObject m368d() {
        return m364a(80004, C0678d.m189a(f302e));
    }

    /* renamed from: e */
    public static JSONObject m369e() {
        return m364a(80103, C0678d.m189a(f309l));
    }

    /* renamed from: f */
    public static JSONObject m370f() {
        return m364a(80500, "传入参数为空");
    }

    /* renamed from: g */
    public static JSONObject m371g() {
        return m364a(80102, C0678d.m189a(f308k));
    }
}
