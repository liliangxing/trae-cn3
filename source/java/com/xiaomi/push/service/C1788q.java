package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1479am;
import com.xiaomi.push.C1484ar;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1802w;
import com.xiaomi.push.EnumC1697m;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.service.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1788q {

    /* renamed from: a */
    private static C1787p f3202a;

    /* renamed from: a */
    private static a f3203a;

    /* renamed from: com.xiaomi.push.service.q$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        void mo3566a();
    }

    /* renamed from: a */
    public static synchronized C1787p m3955a(Context context) {
        synchronized (C1788q.class) {
            C1787p c1787p = f3202a;
            if (c1787p != null) {
                return c1787p;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString(Constants.PACKAGE_NAME, null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && C1682i.m3387a(string7)) {
                string7 = C1682i.m3400g(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String m3400g = C1682i.m3400g(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(m3400g) && !TextUtils.isEmpty(string7) && !string7.equals(m3400g)) {
                AbstractC1417b.m1089a("read_phone_state permission changes.");
            }
            C1787p c1787p2 = new C1787p(string, string2, string3, string4, string5, string6, i);
            f3202a = c1787p2;
            return c1787p2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|(2:8|(24:10|11|(1:13)(1:118)|14|(1:16)(1:117)|17|(1:19)(1:116)|20|21|22|23|(1:25)(1:112)|26|(6:28|(1:30)|31|(1:35)|36|(1:38))|39|(1:41)|42|(6:45|46|47|49|50|43)|54|55|(3:60|61|(2:63|64)(9:(1:67)|68|69|(2:73|(4:75|76|77|(7:79|(1:81)|82|83|84|85|86)(6:88|89|(1:93)|94|95|96)))|106|(2:91|93)|94|95|96))|111|61|(0)(0)))|119|11|(0)(0)|14|(0)(0)|17|(0)(0)|20|21|22|23|(0)(0)|26|(0)|39|(0)|42|(1:43)|54|55|(4:57|60|61|(0)(0))|111|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0087, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0088, code lost:
    
        com.xiaomi.channel.commonutils.logger.AbstractC1417b.m1093a(r0);
        r0 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0090 A[Catch: all -> 0x034b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x001c, B:8:0x0024, B:10:0x003b, B:11:0x0047, B:14:0x005a, B:17:0x0066, B:20:0x0072, B:22:0x007c, B:25:0x0090, B:26:0x0099, B:28:0x00c2, B:30:0x00ce, B:31:0x00df, B:33:0x00e9, B:35:0x00ef, B:36:0x0106, B:38:0x010c, B:39:0x0111, B:41:0x0137, B:42:0x0141, B:43:0x017a, B:45:0x0180, B:47:0x0187, B:52:0x0196, B:55:0x01cd, B:57:0x01ed, B:60:0x01f4, B:61:0x020d, B:69:0x021c, B:110:0x0223, B:71:0x023c, B:73:0x0242, B:101:0x0302, B:91:0x0336, B:93:0x033c, B:94:0x0344, B:99:0x031c, B:115:0x0088), top: B:3:0x0007, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2 A[Catch: all -> 0x034b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x001c, B:8:0x0024, B:10:0x003b, B:11:0x0047, B:14:0x005a, B:17:0x0066, B:20:0x0072, B:22:0x007c, B:25:0x0090, B:26:0x0099, B:28:0x00c2, B:30:0x00ce, B:31:0x00df, B:33:0x00e9, B:35:0x00ef, B:36:0x0106, B:38:0x010c, B:39:0x0111, B:41:0x0137, B:42:0x0141, B:43:0x017a, B:45:0x0180, B:47:0x0187, B:52:0x0196, B:55:0x01cd, B:57:0x01ed, B:60:0x01f4, B:61:0x020d, B:69:0x021c, B:110:0x0223, B:71:0x023c, B:73:0x0242, B:101:0x0302, B:91:0x0336, B:93:0x033c, B:94:0x0344, B:99:0x031c, B:115:0x0088), top: B:3:0x0007, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0137 A[Catch: all -> 0x034b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x001c, B:8:0x0024, B:10:0x003b, B:11:0x0047, B:14:0x005a, B:17:0x0066, B:20:0x0072, B:22:0x007c, B:25:0x0090, B:26:0x0099, B:28:0x00c2, B:30:0x00ce, B:31:0x00df, B:33:0x00e9, B:35:0x00ef, B:36:0x0106, B:38:0x010c, B:39:0x0111, B:41:0x0137, B:42:0x0141, B:43:0x017a, B:45:0x0180, B:47:0x0187, B:52:0x0196, B:55:0x01cd, B:57:0x01ed, B:60:0x01f4, B:61:0x020d, B:69:0x021c, B:110:0x0223, B:71:0x023c, B:73:0x0242, B:101:0x0302, B:91:0x0336, B:93:0x033c, B:94:0x0344, B:99:0x031c, B:115:0x0088), top: B:3:0x0007, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0180 A[Catch: all -> 0x034b, TRY_LEAVE, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x001c, B:8:0x0024, B:10:0x003b, B:11:0x0047, B:14:0x005a, B:17:0x0066, B:20:0x0072, B:22:0x007c, B:25:0x0090, B:26:0x0099, B:28:0x00c2, B:30:0x00ce, B:31:0x00df, B:33:0x00e9, B:35:0x00ef, B:36:0x0106, B:38:0x010c, B:39:0x0111, B:41:0x0137, B:42:0x0141, B:43:0x017a, B:45:0x0180, B:47:0x0187, B:52:0x0196, B:55:0x01cd, B:57:0x01ed, B:60:0x01f4, B:61:0x020d, B:69:0x021c, B:110:0x0223, B:71:0x023c, B:73:0x0242, B:101:0x0302, B:91:0x0336, B:93:0x033c, B:94:0x0344, B:99:0x031c, B:115:0x0088), top: B:3:0x0007, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0217 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0336 A[Catch: all -> 0x034b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x001c, B:8:0x0024, B:10:0x003b, B:11:0x0047, B:14:0x005a, B:17:0x0066, B:20:0x0072, B:22:0x007c, B:25:0x0090, B:26:0x0099, B:28:0x00c2, B:30:0x00ce, B:31:0x00df, B:33:0x00e9, B:35:0x00ef, B:36:0x0106, B:38:0x010c, B:39:0x0111, B:41:0x0137, B:42:0x0141, B:43:0x017a, B:45:0x0180, B:47:0x0187, B:52:0x0196, B:55:0x01cd, B:57:0x01ed, B:60:0x01f4, B:61:0x020d, B:69:0x021c, B:110:0x0223, B:71:0x023c, B:73:0x0242, B:101:0x0302, B:91:0x0336, B:93:0x033c, B:94:0x0344, B:99:0x031c, B:115:0x0088), top: B:3:0x0007, inners: #1, #2, #4 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized C1787p m3956a(Context context, String str, String str2, String str3) {
        String str4;
        int m3377a;
        String m3763a;
        boolean z;
        String m3958a;
        C1484ar c1484ar;
        JSONObject jSONObject;
        synchronized (C1788q.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", C1682i.m3382a(context, false));
            C1787p c1787p = f3202a;
            if (c1787p != null && !TextUtils.isEmpty(c1787p.f3196a)) {
                treeMap.put("uuid", f3202a.f3196a);
                int lastIndexOf = f3202a.f3196a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = f3202a.f3196a.substring(lastIndexOf + 1);
                    C1479am.m1501a(context).m1504a(treeMap);
                    String str5 = !m3964a(context) ? "1000271" : str2;
                    String str6 = !m3964a(context) ? "420100086271" : str3;
                    String str7 = !m3964a(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str5);
                    treeMap.put("apptoken", str6);
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str7, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));
                    treeMap.put("packagename", str7);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put("board", Build.BOARD);
                    if (!C1694j.m3437d()) {
                        String m3394c = C1682i.m3394c(context);
                        String str8 = TextUtils.isEmpty(m3394c) ? "" : "" + C1494ba.m1625a(m3394c);
                        String m3398e = C1682i.m3398e(context);
                        if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(m3398e)) {
                            str8 = str8 + Constants.ACCEPT_TIME_SEPARATOR_SP + m3398e;
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str8);
                        }
                    }
                    treeMap.put(RegistrationHeaderHelper.KEY_OS, Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
                    m3377a = C1682i.m3377a();
                    if (m3377a >= 0) {
                        treeMap.put("space_id", Integer.toString(m3377a));
                    }
                    treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
                    treeMap.put("ram", C1682i.m3379a());
                    treeMap.put("rom", C1682i.m3389b());
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : treeMap.entrySet()) {
                        try {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        } catch (JSONException e) {
                            AbstractC1417b.m1103d("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e);
                        }
                    }
                    m3763a = C1764av.m3763a(jSONObject2.toString());
                    TreeMap treeMap2 = new TreeMap();
                    treeMap2.put("requestData", m3763a);
                    treeMap2.put("keyPairVer", PushClient.DEFAULT_REQUEST_ID);
                    if (m3954a(context) < 2 && !TextUtils.isEmpty(m3763a)) {
                        AbstractC1417b.m1089a("r.data = " + m3763a);
                        z = 1;
                        m3958a = m3958a(context, z);
                        if (!TextUtils.isEmpty(m3958a)) {
                            return null;
                        }
                        if (z != 0) {
                            treeMap = treeMap2;
                        }
                        try {
                            c1484ar = C1486at.m1528a(context, m3958a, treeMap);
                        } catch (IOException e2) {
                            AbstractC1417b.m1103d("device registration request failed. " + e2);
                            c1484ar = null;
                        }
                        if (c1484ar != null && c1484ar.f1008a == 200) {
                            String m1525a = c1484ar.m1525a();
                            if (!TextUtils.isEmpty(m1525a)) {
                                try {
                                    jSONObject = new JSONObject(m1525a);
                                } catch (JSONException e3) {
                                    e = e3;
                                    str4 = z;
                                } catch (Throwable th) {
                                    th = th;
                                    str4 = z;
                                }
                                try {
                                } catch (JSONException e4) {
                                    e = e4;
                                    AbstractC1417b.m1103d("failed to parse respone json data. " + e);
                                    if (str4 != null) {
                                    }
                                    AbstractC1417b.m1089a("fail to register push account. meet error.");
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    AbstractC1417b.m1103d("unknow throwable. " + th);
                                    if (str4 != null) {
                                    }
                                    AbstractC1417b.m1089a("fail to register push account. meet error.");
                                    return null;
                                }
                                if (jSONObject.getInt(MonitorConstants.CODE) == 0) {
                                    JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                                    String string = jSONObject3.getString("ssecurity");
                                    String string2 = jSONObject3.getString("token");
                                    String string3 = jSONObject3.getString("userId");
                                    if (TextUtils.isEmpty(str4)) {
                                        str4 = "an" + C1494ba.m1624a(6);
                                    }
                                    C1787p c1787p2 = new C1787p(string3 + "@xiaomi.com/" + str4, string2, string, str5, str6, str7, C1802w.m4113a());
                                    m3962a(context, c1787p2);
                                    f3202a = c1787p2;
                                    m3961a(context, 0);
                                    AbstractC1417b.m1089a("device registration is successful. " + string3);
                                    return c1787p2;
                                }
                                str4 = z;
                                C1792t.m3978a(context, jSONObject.getInt(MonitorConstants.CODE), jSONObject.optString("description"));
                                AbstractC1417b.m1089a("device registration resp: " + m1525a);
                                if (str4 != null && C1486at.m1547b(context)) {
                                    m3961a(context, m3954a(context) + 1);
                                }
                                AbstractC1417b.m1089a("fail to register push account. meet error.");
                                return null;
                            }
                        }
                        str4 = z;
                        if (str4 != null) {
                            m3961a(context, m3954a(context) + 1);
                        }
                        AbstractC1417b.m1089a("fail to register push account. meet error.");
                        return null;
                    }
                    z = 0;
                    m3958a = m3958a(context, z);
                    if (!TextUtils.isEmpty(m3958a)) {
                    }
                }
            }
            str4 = null;
            C1479am.m1501a(context).m1504a(treeMap);
            if (!m3964a(context)) {
            }
            if (!m3964a(context)) {
            }
            if (!m3964a(context)) {
            }
            treeMap.put("appid", str5);
            treeMap.put("apptoken", str6);
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str7, 16384);
            treeMap.put("appversion", packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));
            treeMap.put("packagename", str7);
            treeMap.put("model", Build.MODEL);
            treeMap.put("board", Build.BOARD);
            if (!C1694j.m3437d()) {
            }
            treeMap.put(RegistrationHeaderHelper.KEY_OS, Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            m3377a = C1682i.m3377a();
            if (m3377a >= 0) {
            }
            treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
            treeMap.put("ram", C1682i.m3379a());
            treeMap.put("rom", C1682i.m3389b());
            JSONObject jSONObject22 = new JSONObject();
            while (r9.hasNext()) {
            }
            m3763a = C1764av.m3763a(jSONObject22.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put("requestData", m3763a);
            treeMap22.put("keyPairVer", PushClient.DEFAULT_REQUEST_ID);
            if (m3954a(context) < 2) {
                AbstractC1417b.m1089a("r.data = " + m3763a);
                z = 1;
                m3958a = m3958a(context, z);
                if (!TextUtils.isEmpty(m3958a)) {
                }
            }
            z = 0;
            m3958a = m3958a(context, z);
            if (!TextUtils.isEmpty(m3958a)) {
            }
        }
    }

    /* renamed from: a */
    private static String m3958a(Context context, boolean z) {
        String m3799a = C1769b.m3796a(context).m3799a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (C1802w.m4116b()) {
            return "http://10.38.162.35:9085".concat(str);
        }
        if (EnumC1697m.China.name().equals(m3799a)) {
            return "https://cn.register.xmpush.xiaomi.com".concat(str);
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m3964a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* renamed from: a */
    private static void m3961a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    /* renamed from: a */
    private static int m3954a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* renamed from: a */
    public static void m3962a(Context context, C1787p c1787p) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", c1787p.f3196a);
        edit.putString("security", c1787p.f3198c);
        edit.putString("token", c1787p.f3197b);
        edit.putString("app_id", c1787p.f3199d);
        edit.putString(Constants.PACKAGE_NAME, c1787p.f3201f);
        edit.putString("app_token", c1787p.f3200e);
        edit.putString("device_id", C1682i.m3400g(context));
        edit.putInt("env_type", c1787p.f3195a);
        edit.commit();
        m3959a();
    }

    /* renamed from: a */
    public static void m3960a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f3202a = null;
        m3959a();
    }

    /* renamed from: a */
    public static void m3963a(a aVar) {
        f3203a = aVar;
    }

    /* renamed from: a */
    public static void m3959a() {
        a aVar = f3203a;
        if (aVar != null) {
            aVar.mo3566a();
        }
    }

    /* renamed from: a */
    public static String m3957a(Context context) {
        C1787p m3955a = m3955a(context);
        if (m3955a != null && !TextUtils.isEmpty(m3955a.f3196a)) {
            String[] split = m3955a.f3196a.split("@");
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }
}
