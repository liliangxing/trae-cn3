package com.bytedance.tobshadow.bdtracker;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.network.RangersHttpException;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.i4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0444i4 {

    /* renamed from: d */
    public static JSONObject f666d;

    /* renamed from: a */
    public String f667a = "https://databyterangers.com.cn";

    /* renamed from: b */
    public final C0467m f668b;

    /* renamed from: c */
    public final C0480n5 f669c;

    /* renamed from: com.bytedance.tobshadow.bdtracker.i4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ JSONObject f670a;

        public a(JSONObject jSONObject) {
            this.f670a = jSONObject;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            C0411e.m375c(this.f670a, jSONObject);
            try {
                jSONObject.put("appId", C0444i4.this.f668b.f784m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.i4$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class b implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ String f672a;

        /* renamed from: b */
        public final /* synthetic */ int f673b;

        /* renamed from: c */
        public final /* synthetic */ byte[] f674c;

        /* renamed from: d */
        public final /* synthetic */ String f675d;

        /* renamed from: e */
        public final /* synthetic */ long f676e;

        /* renamed from: f */
        public final /* synthetic */ HttpURLConnection f677f;

        public b(String str, int i, byte[] bArr, String str2, long j, HttpURLConnection httpURLConnection) {
            this.f672a = str;
            this.f673b = i;
            this.f674c = bArr;
            this.f675d = str2;
            this.f676e = j;
            this.f677f = httpURLConnection;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", C0444i4.this.f668b.f784m);
                jSONObject.put("nid", this.f672a);
                jSONObject.put("statusCode", this.f673b);
                jSONObject.put("responseByte", this.f674c);
                jSONObject.put("responseString", this.f675d);
                jSONObject.put(DBData.FIELD_TIME, this.f676e);
                jSONObject.put("header", C0444i4.this.m467a(this.f677f));
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public C0444i4(C0467m c0467m) {
        this.f668b = c0467m;
        this.f669c = new C0480n5(c0467m);
    }

    /* renamed from: a */
    public static String m458a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public static JSONObject m459a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constant.KEY_AID, str);
        jSONObject.put("os", SiteMessageParams.platform);
        jSONObject.put(Constant.KEY_OS_VERSION, String.valueOf(Build.VERSION.SDK_INT));
        jSONObject.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, "6.17.11-tobshadow");
        jSONObject.put(Constant.KEY_APP_VERSION, str2);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m460a(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(sb.toString().indexOf(63) < 0 ? "?" : "&");
        sb.append(str).append("=").append(Uri.encode(str2));
    }

    /* renamed from: b */
    public static JSONObject m461b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("magic_tag", "ss_app_log");
        jSONObject2.put("header", jSONObject);
        jSONObject2.put("_gen_time", System.currentTimeMillis());
        return jSONObject2;
    }

    /* renamed from: a */
    public final HashMap<String, String> m464a() {
        HashMap hashMap = new HashMap(2);
        InitConfig initConfig = this.f668b.getInitConfig();
        if (initConfig != null) {
            Map<String, String> httpHeaders = initConfig.getHttpHeaderCallback() != null ? initConfig.getHttpHeaderCallback().get() : initConfig.getHttpHeaders();
            if (httpHeaders != null && !httpHeaders.isEmpty()) {
                hashMap.putAll(httpHeaders);
            }
        }
        return C0480n5.m581a((HashMap<String, String>) hashMap, this.f668b);
    }

    /* renamed from: a */
    public final JSONObject m465a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            m469a(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            this.f668b.f764D.error(11, "JSON handle failed", th, new Object[0]);
            this.f668b.m522b().mo639a(th, "handleTimeDiff");
            return null;
        }
    }

    /* renamed from: a */
    public final JSONObject m467a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : headerFields.keySet()) {
            if (C0411e.m379d(str)) {
                try {
                    jSONObject.put(str, headerFields.get(str));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final void m468a(String str, int i, byte[] bArr, String str2, long j, HttpURLConnection httpURLConnection) {
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("do_request_end", new b(str, i, bArr, str2, j, httpURLConnection));
    }

    /* renamed from: a */
    public final void m469a(JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong("server_time");
            if (optLong > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("server_time", optLong);
                jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                f666d = jSONObject2;
                if (LogUtils.isDisabled()) {
                    return;
                }
                LogUtils.sendJsonFetcher("server_time_sync", new a(jSONObject2));
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public JSONObject m471b(String str, JSONObject jSONObject) {
        String str2;
        this.f668b.f764D.debug(11, "Start to report oaid to uri:{} with request:{}...", str, jSONObject);
        try {
            str2 = new String(this.f668b.getNetClient().execute((byte) 1, this.f669c.m585a(str), jSONObject, m464a(), (byte) 0, true, 60000));
        } catch (Exception e) {
            e = e;
            str2 = null;
        }
        try {
            this.f668b.f764D.debug(11, "reportOaid success: {}", str2);
        } catch (Exception e2) {
            e = e2;
            this.f668b.f764D.error(11, "reportOaid error", e, new Object[0]);
            this.f668b.m522b().mo639a(e, "reportOaid");
            return m465a(str2);
        }
        return m465a(str2);
    }

    /* renamed from: c */
    public int m472c(String str, JSONObject jSONObject) {
        int i = 102;
        try {
            String str2 = new String(this.f668b.getNetClient().execute((byte) 1, str, jSONObject, m464a(), (byte) 0, true, 60000));
            if (TextUtils.isEmpty(str2)) {
                return 102;
            }
            JSONObject jSONObject2 = new JSONObject(str2);
            m469a(jSONObject2);
            if (!"ss_app_log".equals(jSONObject2.optString("magic_tag"))) {
                return 102;
            }
            if ("success".equals(jSONObject2.optString("message"))) {
                return 200;
            }
            i = 101;
            this.f668b.m522b().mo638a("f_data", (String) 1);
            return 101;
        } catch (Throwable th) {
            this.f668b.m522b().mo639a(th, "sendMonitor");
            if (th instanceof RangersHttpException) {
                return th.getResponseCode();
            }
            this.f668b.f764D.error(11, "Send monitor to server failed", th, new Object[0]);
            return i;
        }
    }

    /* renamed from: a */
    public JSONObject m466a(String str, JSONObject jSONObject) {
        String str2;
        this.f668b.f764D.debug(11, "Start to register to uri:{} with request:{}...", str, jSONObject);
        try {
            str2 = new String(this.f668b.getNetClient().execute((byte) 1, this.f669c.m585a(str), jSONObject, m464a(), (byte) 0, true, 60000));
            try {
                this.f668b.f764D.debug(11, "request register success: {}", str2);
            } catch (Throwable th) {
                th = th;
                this.f668b.f764D.error(11, "request register error", th, new Object[0]);
                this.f668b.m522b().mo639a(th, "register");
                return m465a(str2);
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        return m465a(str2);
    }

    /* renamed from: a */
    public final String m463a(JSONObject jSONObject, String str, Map<String, String> map, int i) {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        byte[] byteArray;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("iv");
        boolean z = true;
        boolean z2 = (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) ? false : true;
        this.f668b.f764D.debug("requestWithKeyIv, {}", Boolean.valueOf(z2));
        byte[] execute = this.f668b.getNetClient().execute((byte) 1, str, jSONObject, map, z2 ? (byte) 1 : (byte) 0, true, i);
        if (!z2) {
            return new String(execute);
        }
        String str2 = null;
        if (execute != null) {
            byte[] m583a = C0480n5.m583a(execute, optString, optString2);
            if (m583a != null) {
                if (m583a.length <= 0) {
                    byteArray = null;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(m583a);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = gZIPInputStream.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable unused2) {
                            gZIPInputStream = null;
                        }
                    } catch (Throwable unused3) {
                        gZIPInputStream = null;
                        byteArrayInputStream = null;
                    }
                    C0411e.m356a((Closeable) gZIPInputStream);
                    C0411e.m356a((Closeable) byteArrayInputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                if (byteArray != null) {
                    str2 = new String(byteArray);
                }
            } else {
                str2 = new String(execute);
            }
            z = false;
        }
        return z ? new String(this.f668b.getNetClient().execute((byte) 1, str, jSONObject, map, (byte) 0, true, 60000)) : str2;
    }

    /* renamed from: a */
    public int m462a(String[] strArr, JSONObject jSONObject, C0407d2 c0407d2) {
        int i;
        JSONObject jSONObject2;
        int i2;
        int i3;
        long j;
        int i4;
        boolean z;
        String str;
        boolean z2;
        String[] strArr2 = strArr;
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, String> m464a = m464a();
        int length = strArr2.length;
        boolean z3 = false;
        JSONObject jSONObject3 = null;
        int i5 = 0;
        int i6 = 102;
        while (i5 < length) {
            String str2 = strArr2[i5];
            try {
                i3 = i5;
                z2 = z3;
                try {
                    str = new String(this.f668b.getNetClient().execute((byte) 1, str2, jSONObject, m464a, (byte) 0, true, 60000));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = i5;
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject2 = new JSONObject(str);
                try {
                    m469a(jSONObject2);
                } catch (Throwable th3) {
                    th = th3;
                    jSONObject3 = jSONObject2;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    j = currentTimeMillis;
                    i4 = length;
                    this.f668b.m522b().mo638a("sampling", (String) new C0527u3(currentTimeMillis, currentTimeMillis2, currentTimeMillis2 - currentTimeMillis, i6, th.toString()));
                    this.f668b.m522b().mo639a(th, "sendLog");
                    if (th instanceof RangersHttpException) {
                        i2 = th.getResponseCode();
                        if (c0407d2.f502c.isCongestionControlEnable()) {
                            if (i2 >= 500 && i2 < 600) {
                                jSONObject2 = jSONObject3;
                                i = 200;
                                if (i2 == i) {
                                    c0407d2.m311a(jSONObject2);
                                    C0546x1 c0546x1 = c0407d2.f519t;
                                    c0546x1.m743a(jSONObject2, "blocklist");
                                    c0546x1.m743a(jSONObject2, "whitelist");
                                }
                                return i2;
                            }
                        }
                        i6 = i2;
                        z = false;
                    } else {
                        z = false;
                        this.f668b.f764D.error(11, "Send to server failed", th, new Object[0]);
                    }
                    i5 = i3 + 1;
                    strArr2 = strArr;
                    z3 = z;
                    length = i4;
                    currentTimeMillis = j;
                }
                if (!"ss_app_log".equals(jSONObject2.optString("magic_tag"))) {
                    jSONObject3 = jSONObject2;
                    i6 = 102;
                } else {
                    if ("success".equals(jSONObject2.optString("message"))) {
                        i2 = 200;
                        i = 200;
                        break;
                    }
                    i6 = 101;
                    this.f668b.m522b().mo638a("f_data", (String) 1);
                    jSONObject3 = jSONObject2;
                }
            }
            z = z2;
            j = currentTimeMillis;
            i4 = length;
            i5 = i3 + 1;
            strArr2 = strArr;
            z3 = z;
            length = i4;
            currentTimeMillis = j;
        }
        i = 200;
        jSONObject2 = jSONObject3;
        i2 = i6;
        if (i2 == i && jSONObject2 != null) {
            c0407d2.m311a(jSONObject2);
            C0546x1 c0546x12 = c0407d2.f519t;
            c0546x12.m743a(jSONObject2, "blocklist");
            c0546x12.m743a(jSONObject2, "whitelist");
        }
        return i2;
    }

    /* renamed from: a */
    public boolean m470a(JSONObject jSONObject, String str) {
        this.f668b.f764D.debug(11, "Start to send event:{} with cookie:{} to et...", jSONObject, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", this.f668b.getHeader());
            if (jSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                jSONObject2.put("event_v3", jSONArray);
            }
        } catch (Throwable th) {
            this.f668b.f764D.error(11, "JSON handle failed", th, new Object[0]);
            this.f668b.m522b().mo639a(th, "sendToRangersEventVerify header");
        }
        HashMap<String, String> m464a = m464a();
        m464a.put("Cookie", str);
        try {
            String str2 = new String(this.f668b.getNetClient().execute((byte) 1, this.f667a + "/simulator/mobile/log", jSONObject2, m464a, (byte) 0, true, 10000));
            if (!new JSONObject(str2).getJSONObject("data").optBoolean("keep", false)) {
                this.f668b.setRangersEventVerifyEnable(false, str);
            }
            this.f668b.f764D.debug(11, "Send event to et with response:{}", str2);
            return true;
        } catch (Throwable th2) {
            this.f668b.f764D.error(11, "Post to event verify failed", th2, new Object[0]);
            this.f668b.m522b().mo639a(th2, "sendToRangersEventVerify");
            return false;
        }
    }
}
