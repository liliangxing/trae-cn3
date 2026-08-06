package com.huawei.hms.framework.network.grs.p023g;

import android.text.TextUtils;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1102d {

    /* renamed from: o */
    private static final String f1331o = "d";

    /* renamed from: a */
    private Map<String, List<String>> f1332a;

    /* renamed from: b */
    private byte[] f1333b;

    /* renamed from: c */
    private int f1334c;

    /* renamed from: d */
    private long f1335d;

    /* renamed from: e */
    private long f1336e;

    /* renamed from: f */
    private long f1337f;

    /* renamed from: g */
    private String f1338g;

    /* renamed from: h */
    private int f1339h;

    /* renamed from: i */
    private int f1340i;

    /* renamed from: j */
    private String f1341j;

    /* renamed from: k */
    private long f1342k;

    /* renamed from: l */
    private String f1343l;

    /* renamed from: m */
    private Exception f1344m;

    /* renamed from: n */
    private String f1345n;

    public C1102d(int i, Map<String, List<String>> map, byte[] bArr, long j) {
        this.f1339h = 2;
        this.f1340i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f1341j = "";
        this.f1342k = 0L;
        this.f1343l = "";
        this.f1334c = i;
        this.f1332a = map;
        this.f1333b = ByteBuffer.wrap(bArr).array();
        this.f1335d = j;
        m1313s();
    }

    public C1102d(Exception exc, long j) {
        this.f1334c = 0;
        this.f1339h = 2;
        this.f1340i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f1341j = "";
        this.f1342k = 0L;
        this.f1343l = "";
        this.f1344m = exc;
        this.f1335d = j;
    }

    /* renamed from: a */
    private void m1300a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey("ETag")) {
            String str3 = map.get("ETag");
            if (!TextUtils.isEmpty(str3)) {
                Logger.m1185i(f1331o, "success get Etag from server");
                m1317a(str3);
                return;
            } else {
                str = f1331o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = f1331o;
            str2 = "Response Heads has not Etag";
        }
        Logger.m1185i(str, str2);
    }

    /* renamed from: b */
    private void m1301b(int i) {
        this.f1340i = i;
    }

    /* renamed from: b */
    private void m1302b(Map<String, String> map) {
        long time;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.m1188v(f1331o, "Cache-Control value{%s}", Long.valueOf(time));
                    } catch (NumberFormatException e) {
                        e = e;
                        Logger.m1190w(f1331o, "getExpireTime addHeadersToResult NumberFormatException", e);
                        if (time > 0) {
                        }
                        time = 86400;
                        long j = time * 1000;
                        Logger.m1186i(f1331o, "convert expireTime{%s}", Long.valueOf(j));
                        m1305c(String.valueOf(j + System.currentTimeMillis()));
                    }
                } catch (NumberFormatException e2) {
                    e = e2;
                    time = 0;
                }
            }
            time = 0;
        } else {
            if (map.containsKey("Expires")) {
                String str2 = map.get("Expires");
                Logger.m1188v(f1331o, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = map.containsKey("Date") ? map.get("Date") : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e3) {
                    Logger.m1190w(f1331o, "getExpireTime ParseException.", e3);
                }
            } else {
                Logger.m1185i(f1331o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time > 0 || time > 2592000) {
            time = 86400;
        }
        long j2 = time * 1000;
        Logger.m1186i(f1331o, "convert expireTime{%s}", Long.valueOf(j2));
        m1305c(String.valueOf(j2 + System.currentTimeMillis()));
    }

    /* renamed from: c */
    private void m1303c(int i) {
        this.f1339h = i;
    }

    /* renamed from: c */
    private void m1304c(long j) {
        this.f1342k = j;
    }

    /* renamed from: c */
    private void m1305c(String str) {
        this.f1341j = str;
    }

    /* renamed from: c */
    private void m1306c(Map<String, String> map) {
        long j;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException e) {
                    Logger.m1190w(f1331o, "getRetryAfter addHeadersToResult NumberFormatException", e);
                }
                long j2 = j * 1000;
                Logger.m1188v(f1331o, "convert retry-afterTime{%s}", Long.valueOf(j2));
                m1304c(j2);
            }
        }
        j = 0;
        long j22 = j * 1000;
        Logger.m1188v(f1331o, "convert retry-afterTime{%s}", Long.valueOf(j22));
        m1304c(j22);
    }

    /* renamed from: d */
    private void m1307d(String str) {
    }

    /* renamed from: e */
    private void m1308e(String str) {
    }

    /* renamed from: f */
    private void m1309f(String str) {
        this.f1338g = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0051, code lost:
    
        if (r9.getInt("resultCode") == 0) goto L20;
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1310p() {
        int i;
        if (m1331m()) {
            Logger.m1185i(f1331o, "GRSSDK get httpcode{304} not any changed.");
            m1303c(1);
            return;
        }
        if (!m1333o()) {
            Logger.m1185i(f1331o, "GRSSDK parse server body all failed.");
            m1303c(2);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.f1333b));
            if (jSONObject.has("isSuccess")) {
                if (jSONObject.getInt("isSuccess") == 1) {
                    i = 1;
                }
                i = 2;
            } else if (!jSONObject.has("resultCode")) {
                Logger.m1182e(f1331o, "sth. wrong because server errorcode's key.");
                i = -1;
            }
            if (i != 1 && jSONObject.has("services")) {
                i = 0;
            }
            m1303c(i);
            if (i == 1 || i == 0) {
                m1309f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                m1308e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
            } else {
                m1301b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : ConnectionResult.RESOLUTION_REQUIRED);
                m1307d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            }
        } catch (JSONException e) {
            Logger.m1191w(f1331o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            m1303c(2);
        }
    }

    /* renamed from: q */
    private void m1311q() {
        if (m1333o() || m1332n() || m1331m()) {
            Map<String, String> m1312r = m1312r();
            if (m1312r.size() <= 0) {
                Logger.m1189w(f1331o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (m1333o() || m1331m()) {
                    m1302b(m1312r);
                    m1300a(m1312r);
                }
                if (m1332n()) {
                    m1306c(m1312r);
                }
            } catch (JSONException e) {
                Logger.m1191w(f1331o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
        }
    }

    /* renamed from: r */
    private Map<String, String> m1312r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f1332a;
        if (map == null || map.size() <= 0) {
            Logger.m1187v(f1331o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : this.f1332a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                hashMap.put(key, it.next());
            }
        }
        return hashMap;
    }

    /* renamed from: s */
    private void m1313s() {
        m1311q();
        m1310p();
    }

    /* renamed from: a */
    public String m1314a() {
        return this.f1341j;
    }

    /* renamed from: a */
    public void m1315a(int i) {
    }

    /* renamed from: a */
    public void m1316a(long j) {
        this.f1337f = j;
    }

    /* renamed from: a */
    public void m1317a(String str) {
        this.f1343l = str;
    }

    /* renamed from: b */
    public int m1318b() {
        return this.f1334c;
    }

    /* renamed from: b */
    public void m1319b(long j) {
        this.f1336e = j;
    }

    /* renamed from: b */
    public void m1320b(String str) {
        this.f1345n = str;
    }

    /* renamed from: c */
    public int m1321c() {
        return this.f1340i;
    }

    /* renamed from: d */
    public Exception m1322d() {
        return this.f1344m;
    }

    /* renamed from: e */
    public String m1323e() {
        return this.f1343l;
    }

    /* renamed from: f */
    public int m1324f() {
        return this.f1339h;
    }

    /* renamed from: g */
    public long m1325g() {
        return this.f1337f;
    }

    /* renamed from: h */
    public long m1326h() {
        return this.f1336e;
    }

    /* renamed from: i */
    public long m1327i() {
        return this.f1335d;
    }

    /* renamed from: j */
    public String m1328j() {
        return this.f1338g;
    }

    /* renamed from: k */
    public long m1329k() {
        return this.f1342k;
    }

    /* renamed from: l */
    public String m1330l() {
        return this.f1345n;
    }

    /* renamed from: m */
    public boolean m1331m() {
        return this.f1334c == 304;
    }

    /* renamed from: n */
    public boolean m1332n() {
        return this.f1334c == 503;
    }

    /* renamed from: o */
    public boolean m1333o() {
        return this.f1334c == 200;
    }
}
