package cn.com.chinatelecom.account.api.p010e;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.com.chinatelecom.account.api.C0674a;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import cn.com.chinatelecom.account.api.p009d.C0687b;
import cn.com.chinatelecom.account.api.p009d.C0689d;
import cn.com.chinatelecom.account.api.p009d.C0692g;
import cn.com.chinatelecom.account.api.p009d.C0693h;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.api.e.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0694a {

    /* renamed from: a */
    private static final String f248a = "a";

    /* renamed from: b */
    private static HashMap<String, String> f249b = new HashMap<>();

    /* renamed from: a */
    public static long m278a(Context context) {
        return C0696c.m293b(context, "key_difference_time", 0L);
    }

    /* renamed from: a */
    public static C0689d m279a(Context context, HttpURLConnection httpURLConnection, boolean z) {
        if (!z) {
            return null;
        }
        C0689d c0689d = new C0689d();
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            List<String> list = headerFields.get(AirActionConstant.ActionId.ACTION_ID_PARAMS);
            if (list != null && list.size() > 0) {
                CtAuth.info(f248a, "request protocol : " + list.get(0));
                c0689d.f217b = false;
            }
            List<String> list2 = headerFields.get("Set-Cookie");
            if (list2 != null && list2.size() > 0) {
                int i = 0;
                while (true) {
                    if (i >= list2.size()) {
                        break;
                    }
                    String str = list2.get(0);
                    if (!TextUtils.isEmpty(str) && str.contains("gw_auth")) {
                        c0689d.f216a = m282a(str, "gw_auth");
                        break;
                    }
                    i++;
                }
            }
            List<String> list3 = headerFields.get("Log-Level");
            if (list3 != null && !list3.isEmpty()) {
                for (int i2 = 0; i2 < list3.size(); i2++) {
                    String str2 = list3.get(0);
                    if (!TextUtils.isEmpty(str2)) {
                        C0699f.m330a(context, str2);
                    }
                }
            }
            List<String> list4 = headerFields.get("p-reset");
            if (list4 != null && !list4.isEmpty()) {
                String str3 = list4.get(0);
                if (!TextUtils.isEmpty(str3)) {
                    m286a(context, str3);
                }
            }
            List<String> list5 = headerFields.get("p-ikgx");
            if (list5 != null && !list5.isEmpty()) {
                String str4 = list5.get(0);
                if (!TextUtils.isEmpty(str4)) {
                    c0689d.f218c = str4;
                    C0700g.f293d = str4;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return c0689d;
    }

    /* renamed from: a */
    public static C0689d m280a(HttpURLConnection httpURLConnection) {
        C0689d c0689d = new C0689d();
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            List<String> list = headerFields.get("rdt_allow");
            if (list != null && list.size() > 0) {
                c0689d.f219d = list.get(0);
                CtAuth.info(f248a, "request method : " + c0689d.f219d);
            }
            List<String> list2 = headerFields.get("p-ikgx");
            if (list2 != null && !list2.isEmpty()) {
                String str = list2.get(0);
                if (!TextUtils.isEmpty(str)) {
                    c0689d.f218c = str;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return c0689d;
    }

    /* renamed from: a */
    public static synchronized String m281a(int i) {
        synchronized (C0694a.class) {
            return i == C0674a.f116d ? "presdk" : "preauthIfaa";
        }
    }

    /* renamed from: a */
    private static String m282a(String str, String str2) {
        try {
            String[] split = str.split(";");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(str2)) {
                    return split[i].split("=")[1];
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static JSONObject m283a(Context context, C0693h c0693h, String str, Network network, boolean z, String str2) {
        if (c0693h == null || c0693h.f245b == null) {
            return C0703j.m365b();
        }
        JSONObject jSONObject = c0693h.f245b;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c0693h.f244a != -1 && !TextUtils.isEmpty(str)) {
            int optInt = jSONObject.optInt(StrategyConstants.RESULT);
            String optString = jSONObject.optString(Constants.KEY_DATA);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(C0701h.m355a(optString, str));
                    if (optInt == 0) {
                        jSONObject2.put("gwAuth", c0693h.f246c);
                    }
                    if (optInt == -10020) {
                        jSONObject.put("taskId", str);
                    }
                    jSONObject.put(Constants.KEY_DATA, jSONObject2);
                } catch (Throwable th) {
                    CtAuth.warn(f248a, "dct", th);
                    jSONObject.put(Constants.KEY_DATA, (Object) null);
                }
            }
            if (optInt != 30002 || !z) {
                if (optInt == -10009 || optInt == -30001) {
                    long optLong = jSONObject.optLong("timeStamp", -1L);
                    if (optLong == -1) {
                        m287b(context);
                    } else {
                        m285a(context, optLong);
                    }
                }
                return jSONObject;
            }
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(Constants.KEY_DATA);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject3.optJSONArray("urls");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return m284a(context, arrayList, str, network, str2);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m284a(Context context, List<String> list, String str, Network network, String str2) {
        for (int i = 0; i < list.size(); i++) {
            try {
                String str3 = list.get(i);
                if (!TextUtils.isEmpty(str3)) {
                    C0700g.m343c(context);
                    C0692g.a aVar = new C0692g.a();
                    try {
                        aVar.m277b(str2);
                        try {
                            aVar.m270a(network);
                            try {
                                JSONObject m283a = m283a(context, new C0687b(context).mo239a(str3, "", 0, aVar.m275a()), str, network, false, str2);
                                if (m283a != null && m283a.optInt(StrategyConstants.RESULT) == 0) {
                                    return m283a;
                                }
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return C0703j.m364a(80001, C0678d.m189a(C0703j.f299b) + "- redirect 30002 ");
    }

    /* renamed from: a */
    private static void m285a(Context context, long j) {
        if (j > 0) {
            C0696c.m291a(context, "key_difference_time", j - System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    private static void m286a(Context context, String str) {
        C0696c.m290a(context, "key_p_rset_v3.8.12", str);
    }

    /* renamed from: b */
    private static void m287b(Context context) {
        String m296a = C0697d.m296a();
        C0692g.a aVar = new C0692g.a();
        aVar.m271a("reqTimestamp");
        aVar.m277b(m296a);
        JSONObject jSONObject = new C0687b(context).mo239a(C0700g.m340b(), "", 1, aVar.m275a()).f245b;
        if (jSONObject != null) {
            m285a(context, jSONObject.optLong(NotificationCompat.CATEGORY_MESSAGE, -1L));
        }
    }
}
