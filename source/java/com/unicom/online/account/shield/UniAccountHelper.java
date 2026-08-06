package com.unicom.online.account.shield;

import android.content.Context;
import android.text.TextUtils;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.unicom.online.account.kernel.C1164a;
import com.unicom.online.account.kernel.C1165aa;
import com.unicom.online.account.kernel.C1166ab;
import com.unicom.online.account.kernel.C1167ac;
import com.unicom.online.account.kernel.C1169ae;
import com.unicom.online.account.kernel.C1170b;
import com.unicom.online.account.kernel.C1171c;
import com.unicom.online.account.kernel.C1174f;
import com.unicom.online.account.kernel.C1184p;
import com.unicom.online.account.kernel.C1185q;
import com.unicom.online.account.kernel.C1189u;
import com.unicom.online.account.kernel.C1191w;
import com.unicom.online.account.kernel.InterfaceC1173e;
import com.unicom.online.account.kernel.InterfaceC1186r;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLDecoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UniAccountHelper {
    public static final int SUCCESS = 100;
    private static volatile UniAccountHelper s_instance;
    private Context mContext = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum Language {
        SIMPLECHINESE(0),
        ENGLISH(1);

        private int value;

        Language(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private UniAccountHelper() {
    }

    private boolean checkActivity(Context context) {
        return false;
    }

    private void cuPreGetToken(int i, final int i2, String str, final ResultListener resultListener) {
        String str2;
        if (this.mContext == null) {
            initFail(resultListener, "sdk未初始化");
            return;
        }
        C1174f.m513a();
        if (!C1174f.m515a(this.mContext)) {
            str2 = "操作频繁,请稍后再试";
        } else if (!str.equals("cuPreGetToken")) {
            str2 = "sdk参数错误";
        } else {
            if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                C1174f m513a = C1174f.m513a();
                InterfaceC1173e interfaceC1173e = new InterfaceC1173e() { // from class: com.unicom.online.account.shield.UniAccountHelper.1
                    @Override // com.unicom.online.account.kernel.InterfaceC1173e
                    public void onResult(String str3) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            C1171c.m509d(jSONObject.optString("seq"));
                            if (jSONObject.getInt("resultCode") == 100) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("resultData");
                                C1171c.m507b(jSONObject2.optString("fakeMobile"));
                                C1171c.m508c(jSONObject2.optString("accessCode"));
                                C1171c.m506b(jSONObject2.getLong("exp"));
                                C1171c.m503a(System.currentTimeMillis());
                                String optString = jSONObject.optString("operator");
                                if (!TextUtils.isEmpty(optString)) {
                                    C1171c.m504a(optString);
                                }
                                int i3 = i2;
                                if (4 == i3 || 2 == i3) {
                                    jSONObject2.put("fakeMobile", (Object) null);
                                }
                                C1174f.m513a();
                                C1174f.m519b(UniAccountHelper.this.mContext);
                            } else {
                                C1174f.m513a();
                                C1174f.m522c(UniAccountHelper.this.mContext);
                            }
                            resultListener.onResult(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                if (m513a.f249a == null || TextUtils.isEmpty(C1166ab.m458c()) || TextUtils.isEmpty(C1166ab.m460d())) {
                    C1174f.m514a(interfaceC1173e, "sdk未初始化");
                    return;
                }
                C1167ac.m487c();
                C1167ac.m491e("cuPreGetToken");
                C1167ac.m488d();
                C1166ab.m453a(i);
                final C1184p c1184p = new C1184p();
                final Context context = m513a.f249a;
                c1184p.f291b = new C1185q();
                c1184p.f291b.f305a = interfaceC1173e;
                try {
                    c1184p.f290a.schedule(new Runnable() { // from class: com.unicom.online.account.kernel.p.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            synchronized (C1184p.this) {
                                if (C1184p.this.f291b != null) {
                                    C1184p.this.f291b.m549a(410000, "请求超时");
                                    C1184p.this.f291b = null;
                                    C1184p.m545a(C1184p.this);
                                }
                            }
                        }
                    }, i, TimeUnit.MILLISECONDS);
                    final InterfaceC1186r interfaceC1186r = new InterfaceC1186r() { // from class: com.unicom.online.account.kernel.p.2
                        @Override // com.unicom.online.account.kernel.InterfaceC1186r
                        /* renamed from: a */
                        public final void mo547a(int i3, String str3) {
                            synchronized (C1184p.this) {
                                if (C1184p.this.f291b == null) {
                                    return;
                                }
                                if (i3 == 1) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(str3);
                                        int optInt = jSONObject.optInt(MonitorConstants.CODE);
                                        String optString = jSONObject.optString(IAssociationStartMonitorEventService.KEY_MSG);
                                        String optString2 = jSONObject.optString("data");
                                        String optString3 = jSONObject.optString("seq");
                                        if (optInt == 100) {
                                            String m469a = C1167ac.m469a();
                                            String substring = m469a.substring(0, 16);
                                            String substring2 = m469a.substring(16, 32);
                                            String str4 = C1189u.f311a ? new String(C1179k.m539b(C1176h.m535b(optString2), substring.getBytes(), substring2.getBytes())) : URLDecoder.decode(C1167ac.m483b(optString2, substring, substring2), HTTP.UTF_8);
                                            if (TextUtils.isEmpty(str4)) {
                                                C1184p.this.f291b.m550a(410002, "数据异常", optString2, optString3);
                                            } else {
                                                C1185q c1185q = C1184p.this.f291b;
                                                try {
                                                    if (c1185q.f305a != null) {
                                                        JSONObject jSONObject2 = new JSONObject();
                                                        jSONObject2.put("resultCode", 100);
                                                        jSONObject2.put("resultMsg", optString);
                                                        jSONObject2.put("seq", optString3);
                                                        if (TextUtils.isEmpty(str4)) {
                                                            jSONObject2.put("resultData", "");
                                                        } else {
                                                            jSONObject2.put("resultData", new JSONObject(str4));
                                                        }
                                                        c1185q.f305a.onResult(jSONObject2.toString());
                                                        c1185q.f305a = null;
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        } else {
                                            if (optInt == -2 && !TextUtils.isEmpty(C1166ab.m462e())) {
                                                optString = optString + "apn is " + C1166ab.m462e();
                                            }
                                            C1184p.this.f291b.m550a(i3, optString, optString2, optString3);
                                        }
                                    } catch (Exception e2) {
                                        C1184p.this.f291b.m550a(410002, "异常" + e2.getMessage(), str3, "");
                                    }
                                } else {
                                    C1184p.this.f291b.m549a(i3, str3);
                                }
                                C1184p.this.f291b = null;
                                C1184p.m545a(C1184p.this);
                            }
                        }
                    };
                    C1165aa.m448b("\n■★■★■★■★■★■★■★■★■★■\nrequestPreCheck()\n■★■★■★■★■★■★■★■★■★■\n");
                    try {
                        int m468a = C1167ac.m468a(context.getApplicationContext());
                        C1166ab.m456b(m468a);
                        C1165aa.m448b("-1=NULL; 0=流量; 1=双开; 2=WIFI; networkType = ".concat(String.valueOf(m468a)));
                        if (m468a == 1) {
                            final long currentTimeMillis = System.currentTimeMillis();
                            C1191w.m564a().m569a(context, new C1191w.a() { // from class: com.unicom.online.account.kernel.p.3
                                @Override // com.unicom.online.account.kernel.C1191w.a
                                /* renamed from: a */
                                public final void mo548a(boolean z, Object obj) {
                                    if (!z) {
                                        interfaceC1186r.mo547a(410003, "无法切换至数据网络");
                                    } else {
                                        C1165aa.m448b("selectDataChannel:" + (System.currentTimeMillis() - currentTimeMillis));
                                        C1184p.this.m546a(context, i2, obj, interfaceC1186r);
                                    }
                                }
                            });
                            return;
                        } else if (m468a == 0) {
                            c1184p.m546a(context, i2, null, interfaceC1186r);
                            return;
                        } else {
                            interfaceC1186r.mo547a(410004, "数据网络未开启");
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        interfaceC1186r.mo547a(410005, "网络判断异常" + e.getMessage());
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            str2 = "sdk type 参数错误";
        }
        initFail(resultListener, str2);
    }

    public static String getCertFingerType() {
        return C1189u.f313c;
    }

    public static UniAccountHelper getInstance() {
        if (s_instance == null) {
            synchronized (UniAccountHelper.class) {
                if (s_instance == null) {
                    s_instance = new UniAccountHelper();
                }
            }
        }
        return s_instance;
    }

    private void initFail(ResultListener resultListener, String str) {
        C1170b.m500a(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 410021);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            jSONObject.put("operatorType", "CU");
            if (resultListener != null) {
                resultListener.onResult(jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendFail(ResultListener resultListener, int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            jSONObject.put("operatorType", C1171c.m502a());
            resultListener.onResult(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UniAccountHelper setCertFingerType(String str) {
        if (!str.equalsIgnoreCase("MD5") && !str.equalsIgnoreCase("SHA1") && !str.equalsIgnoreCase("SHA256") && !str.equalsIgnoreCase("sm3")) {
            return null;
        }
        C1189u.f313c = str.toLowerCase();
        return s_instance;
    }

    public void clearCache() {
        C1171c.m505b();
    }

    public String cuDebugInfo(String str) {
        if (this.mContext == null) {
            return "sdk 未初始化, context 为空";
        }
        C1174f m513a = C1174f.m513a();
        if (m513a.f249a == null) {
            return "sdk 未初始化, context 为空";
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1831168304:
                if (lowerCase.equals("debuginfo1")) {
                    c = 0;
                    break;
                }
                break;
            case -1705644026:
                if (lowerCase.equals("testversion")) {
                    c = 1;
                    break;
                }
                break;
            case -903629273:
                if (lowerCase.equals("sha256")) {
                    c = 2;
                    break;
                }
                break;
            case -197617279:
                if (lowerCase.equals("debuginfo")) {
                    c = 3;
                    break;
                }
                break;
            case 107902:
                if (lowerCase.equals("md5")) {
                    c = 4;
                    break;
                }
                break;
            case 113945:
                if (lowerCase.equals("sm3")) {
                    c = 5;
                    break;
                }
                break;
            case 3528965:
                if (lowerCase.equals("sha1")) {
                    c = 6;
                    break;
                }
                break;
            case 93029116:
                if (lowerCase.equals("appid")) {
                    c = 7;
                    break;
                }
                break;
            case 667683678:
                if (lowerCase.equals("sdkversion")) {
                    c = '\b';
                    break;
                }
                break;
            case 909712337:
                if (lowerCase.equals("packagename")) {
                    c = '\t';
                    break;
                }
                break;
            case 1285324646:
                if (lowerCase.equals("bcproviderversion")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return C1167ac.m470a(1);
            case 1:
                return C1174f.m521c();
            case 2:
            case 4:
            case 6:
                return C1167ac.m472a(m513a.f249a, m513a.f249a.getPackageName(), str.toLowerCase());
            case 3:
                return C1167ac.m470a(0);
            case 5:
                return C1167ac.m471a(m513a.f249a, m513a.f249a.getPackageName());
            case 7:
                return C1166ab.m458c();
            case '\b':
                return C1174f.m518b();
            case '\t':
                return m513a.f249a.getApplicationContext().getPackageName();
            case '\n':
                return C1174f.m523d();
            default:
                return "no info";
        }
    }

    public void cuGetToken(int i, ResultListener resultListener) {
        cuPreGetToken(i, C1189u.f311a ? 3 : 5, "cuPreGetToken", resultListener);
    }

    public void cuMobileAuth(int i, ResultListener resultListener) {
        cuPreGetToken(i, C1189u.f311a ? 2 : 4, "cuPreGetToken", resultListener);
    }

    public UniAccountHelper enableDNS2IP(boolean z) {
        C1174f.m513a();
        C1174f.m517a(z);
        return s_instance;
    }

    public String getHostName() {
        C1174f.m513a();
        return C1174f.m524e();
    }

    public String getSdkVersion() {
        C1174f.m513a();
        return C1174f.m518b();
    }

    public String getUnicomProtocolTitle() {
        return "联通统一认证服务条款";
    }

    public UniAccountHelper init(Context context, String str) {
        return init(context, str, false);
    }

    public UniAccountHelper init(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty("a4bbdcc6f89912460651407946a9f90a")) {
            C1170b.m500a("初始化参数不能为空");
            return null;
        }
        if (this.mContext != null) {
            C1170b.m500a("重复初始化");
            return null;
        }
        this.mContext = context.getApplicationContext();
        C1164a.m443a(context);
        C1174f m513a = C1174f.m513a();
        if (context != null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty("a4bbdcc6f89912460651407946a9f90a")) {
                if (TextUtils.isEmpty(C1166ab.m458c())) {
                    C1189u.f312b = true;
                    C1189u.f311a = z;
                    if (z) {
                        C1165aa.m448b(" MyApplication.enableGuoMi  ");
                    }
                    m513a.f249a = context.getApplicationContext();
                    C1166ab.m457b(str);
                    C1166ab.m459c("a4bbdcc6f89912460651407946a9f90a");
                    C1166ab.m465f(C1167ac.m481b(m513a.f249a));
                    Context context2 = m513a.f249a;
                    String m498a = C1169ae.m498a(context2, "auth02");
                    if (TextUtils.isEmpty(m498a)) {
                        m498a = C1167ac.m482b(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") + System.currentTimeMillis());
                        C1169ae.m499a(context2, "auth02", m498a);
                    }
                    C1166ab.m467g(m498a);
                    m513a.m527g();
                } else {
                    C1165aa.m450d("不可重复初始化");
                }
                C1171c.f239a = str;
                return s_instance;
            }
        }
        C1165aa.m450d("初始化参数不能为空");
        C1171c.f239a = str;
        return s_instance;
    }

    public UniAccountHelper initDNS2IP() {
        C1174f.m513a().m527g();
        return s_instance;
    }

    public UniAccountHelper initHostName(String str) {
        C1174f.m513a();
        if (C1174f.m516a(str)) {
            return s_instance;
        }
        C1170b.m500a("初始化参数错误");
        return null;
    }

    public void releaseNetwork() {
        C1174f.m513a();
        C1174f.m526h();
    }

    public UniAccountHelper setCryptoGM(boolean z) {
        C1189u.f311a = z;
        return s_instance;
    }

    public void setDefaultLanguage(Language language) {
        C1171c.f240b = language;
    }

    public void setLogEnable(boolean z) {
        C1170b.m501a(z);
        C1174f.m513a();
        C1174f.m520b(z);
    }
}
