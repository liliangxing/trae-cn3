package com.huawei.hms.framework.network.grs.p023g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import com.huawei.hms.framework.network.grs.p026h.p027f.C1117a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.framework.network.grs.g.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CallableC1104f extends C1099a implements Callable<C1102d> {

    /* renamed from: i */
    private static final String f1349i = "f";

    public CallableC1104f(String str, int i, C1101c c1101c, Context context, String str2, GrsBaseInfo grsBaseInfo, C1093c c1093c) {
        super(str, i, c1101c, context, str2, grsBaseInfo, c1093c);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0149: MOVE (r7 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:80:0x0149 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013c  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1102d call() {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        long j;
        long currentTimeMillis;
        long elapsedRealtime;
        String str = f1349i;
        Logger.m1185i(str, "Post call execute");
        long j2 = 0;
        HttpsURLConnection httpsURLConnection3 = null;
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            try {
                try {
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        j2 = System.currentTimeMillis();
                        httpsURLConnection2 = C1117a.m1377a(m1284c(), m1282a(), m1286e());
                    } catch (IOException e) {
                        e = e;
                        httpsURLConnection2 = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (httpsURLConnection3 != null) {
                        try {
                            httpsURLConnection3.disconnect();
                        } catch (RuntimeException unused) {
                            Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                        } catch (Throwable unused2) {
                            Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                httpsURLConnection2 = null;
                j = 0;
            }
            try {
            } catch (IOException e3) {
                e = e3;
                long j3 = j2;
                j2 = elapsedRealtime;
                j = j3;
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                currentTimeMillis = System.currentTimeMillis();
                Logger.m1190w(f1349i, "RequestCallableV2 run task catch IOException", e);
                this.f1308a = new C1102d(e, elapsedRealtime2 - j2);
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (RuntimeException unused3) {
                        j2 = j;
                        Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                        this.f1308a.m1320b(m1284c());
                        this.f1308a.m1315a(m1285d());
                        this.f1308a.m1319b(j2);
                        this.f1308a.m1316a(currentTimeMillis);
                        if (m1283b() != null) {
                        }
                        return this.f1308a;
                    } catch (Throwable unused4) {
                        j2 = j;
                        Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                        this.f1308a.m1320b(m1284c());
                        this.f1308a.m1315a(m1285d());
                        this.f1308a.m1319b(j2);
                        this.f1308a.m1316a(currentTimeMillis);
                        if (m1283b() != null) {
                        }
                        return this.f1308a;
                    }
                }
                j2 = j;
                this.f1308a.m1320b(m1284c());
                this.f1308a.m1315a(m1285d());
                this.f1308a.m1319b(j2);
                this.f1308a.m1316a(currentTimeMillis);
                if (m1283b() != null) {
                }
                return this.f1308a;
            }
            if (httpsURLConnection2 == null) {
                Logger.m1189w(str, "create HttpsURLConnection instance by url return null.");
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (RuntimeException unused5) {
                        Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                    } catch (Throwable unused6) {
                        Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                    }
                }
                return null;
            }
            httpsURLConnection2.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnection2.setRequestProperty("Connection", "close");
            httpsURLConnection2.setRequestMethod("POST");
            httpsURLConnection2.setDoOutput(true);
            httpsURLConnection2.setDoInput(true);
            String m1297a = m1283b() != null ? m1283b().m1297a() : "";
            if (TextUtils.isEmpty(m1297a)) {
                m1297a = ContainerUtils.FIELD_DELIMITER;
            }
            httpsURLConnection2.setRequestProperty("If-None-Match", m1297a);
            httpsURLConnection2.connect();
            C1117a.m1378a(httpsURLConnection2, m1287f().m1244a("services", ""));
            int responseCode = httpsURLConnection2.getResponseCode();
            Logger.m1185i(str, "httpsURLConnection result code:" + responseCode);
            if (responseCode == 200) {
                try {
                    inputStream = httpsURLConnection2.getInputStream();
                    byte[] byteArray = IoUtils.toByteArray(inputStream);
                    IoUtils.closeSecure(inputStream);
                    bArr = byteArray;
                } catch (Throwable th2) {
                    IoUtils.closeSecure(inputStream);
                    throw th2;
                }
            }
            Map headerFields = httpsURLConnection2.getHeaderFields();
            httpsURLConnection2.disconnect();
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            currentTimeMillis = System.currentTimeMillis();
            this.f1308a = new C1102d(responseCode, headerFields, bArr == null ? new byte[0] : bArr, elapsedRealtime3 - elapsedRealtime);
            if (httpsURLConnection2 != null) {
                try {
                    httpsURLConnection2.disconnect();
                } catch (RuntimeException unused7) {
                    Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                    this.f1308a.m1320b(m1284c());
                    this.f1308a.m1315a(m1285d());
                    this.f1308a.m1319b(j2);
                    this.f1308a.m1316a(currentTimeMillis);
                    if (m1283b() != null) {
                    }
                    return this.f1308a;
                } catch (Throwable unused8) {
                    Logger.m1189w(f1349i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                    this.f1308a.m1320b(m1284c());
                    this.f1308a.m1315a(m1285d());
                    this.f1308a.m1319b(j2);
                    this.f1308a.m1316a(currentTimeMillis);
                    if (m1283b() != null) {
                    }
                    return this.f1308a;
                }
            }
            this.f1308a.m1320b(m1284c());
            this.f1308a.m1315a(m1285d());
            this.f1308a.m1319b(j2);
            this.f1308a.m1316a(currentTimeMillis);
            if (m1283b() != null) {
                m1283b().m1298a(this.f1308a);
            }
            return this.f1308a;
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection3 = httpsURLConnection;
        }
    }
}
