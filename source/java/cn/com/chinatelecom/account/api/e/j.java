package cn.com.chinatelecom.account.api.e;

import android.text.TextUtils;
import com.bytedance.sdk.account.information.UserInfoNetConstants;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class j {
    public static final byte[] a = {-30, -91, -67, -20, -69, -120, -30, PSSSigner.TRAILER_IMPLICIT, -113, -20, -99, PSSSigner.TRAILER_IMPLICIT};
    public static final byte[] b = {-30, -91, -67, -20, -69, -120, -19, -73, -101, -19, -79, -106, -17, -74, -120, -17, -78, -78};
    public static final byte[] c = {-17, -103, -121, -17, -80, -98, -19, -86, -117, -29, -98, -109, -30, -91, -91};
    public static final byte[] d = {-20, -99, -86, -19, -73, -101, -19, -79, -106, -30, -75, -108, -20, -124, -81};
    public static final byte[] e = {-19, -83, -79, -17, ByteCompanionObject.MIN_VALUE, -94, -19, -73, -101, -19, -79, -106, -20, -106, -96, -17, -74, -118, -17, -102, -91};
    public static final byte[] f = {89, 101, 105, 97, 111, 126, -30, PSSSigner.TRAILER_IMPLICIT, -113, -20, -99, PSSSigner.TRAILER_IMPLICIT, -17, -74, -120, -17, -78, -78};
    public static final byte[] g = {-17, -107, -107, -17, -102, -121, -30, -83, -87, -20, -108, -102, -17, -74, -120, -17, -78, -78};
    public static final byte[] h = {67, 69, -17, -74, -120, -17, -78, -78};
    public static final byte[] i = {-19, -109, -79, -17, -73, -97, -19, -79, -103, -20, -108, -106, -18, -78, -80, -19, -93, -80};
    public static final byte[] j = {-19, -109, -79, -17, -73, -97, -17, -74, -120, -17, -78, -78};
    public static final byte[] k = {-29, -88, -114, -19, -109, -79, -17, -73, -97, -17, -74, -120, -17, -78, -78};
    public static final byte[] l = {-30, -91, -67, -17, -113, -126, -17, -126, -105, -17, -83, -127, -17, -122, -100, 89, 78, 65};
    public static final byte[] m = {-19, -98, -94, -20, -126, -67, -17, -113, -71, -29, -99, -89, -19, -97, -122, -29, -105, -88};
    public static final byte[] n = {-17, -113, PSSSigner.TRAILER_IMPLICIT, -18, -79, -100, -19, -109, -79, -17, -73, -97, -20, -100, -77, -17, -74, -123};
    public static final byte[] o = {93, 67, 76, 67, -17, -126, -115, -20, -121, -88, -30, PSSSigner.TRAILER_IMPLICIT, -113, -20, -99, PSSSigner.TRAILER_IMPLICIT};
    public static final byte[] p = {93, 67, 76, 67, -17, -126, -115, -20, -121, -88, -17, -74, -120, -17, -78, -78};
    public static final byte[] q = {-17, -125, -121, -19, -73, -92, -17, -107, -107, -17, -102, -121, -30, -83, -87, -20, -108, -102, -17, -82, -69, -30, -66, -81};

    public static String a(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i2);
            jSONObject.put("msg", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("reqId", str2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static JSONObject a() {
        return a(UserInfoNetConstants.API_UPDATE_USER_INFO, cn.com.chinatelecom.account.api.a.d.a(d));
    }

    public static JSONObject a(int i2, String str) {
        return b(i2, str, null);
    }

    public static JSONObject b() {
        return b(UserInfoNetConstants.API_CAN_MODIFY_USER, cn.com.chinatelecom.account.api.a.d.a(b), null);
    }

    public static JSONObject b(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i2);
            jSONObject.put("msg", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("reqId", str2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject c() {
        return a(80000, cn.com.chinatelecom.account.api.a.d.a(a));
    }

    public static JSONObject d() {
        return a(UserInfoNetConstants.API_CHECK_DEFAULT_INFO, cn.com.chinatelecom.account.api.a.d.a(e));
    }

    public static JSONObject e() {
        return a(80103, cn.com.chinatelecom.account.api.a.d.a(l));
    }

    public static JSONObject f() {
        return a(80500, "传入参数为空");
    }

    public static JSONObject g() {
        return a(80102, cn.com.chinatelecom.account.api.a.d.a(k));
    }
}
