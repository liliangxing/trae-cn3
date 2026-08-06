package com.apm.lite;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.apm.lite.MonitorCrash;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p020h.C0760a;
import com.apm.lite.p022j.C0776k;
import com.apm.lite.p023k.C0788k;
import com.apm.lite.p023k.C0794q;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.framwork.core.sdklib.MonitorCommonConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0731b {

    /* renamed from: a */
    MonitorCrash.Config f344a;

    /* renamed from: b */
    Map<String, String> f345b;

    /* renamed from: c */
    volatile JSONObject f346c;

    /* renamed from: a */
    private static C0776k m382a(String str, byte[] bArr, String str2, String str3) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            C0760a.m639a(httpURLConnection);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setRequestProperty(MonitorNetUtil.KEY_CONTENT_ENCODING, "gzip");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.setRequestProperty(MonitorConstants.KEY_AID, str2);
                httpURLConnection.setRequestProperty("x-auth-token", str3);
            }
            httpURLConnection.setRequestMethod("POST");
            if (bArr != null && bArr.length > 0) {
                try {
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        dataOutputStream.write(bArr);
                        dataOutputStream.flush();
                        C0788k.m813a(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        C0788k.m813a(dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                return new C0776k(responseCode, "http response code " + responseCode);
            }
            C0776k c0776k = new C0776k(HttpStatus.SC_PARTIAL_CONTENT, "http response code " + responseCode);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
            }
            C0788k.m813a((Closeable) null);
            return c0776k;
        } catch (Throwable th4) {
            th = th4;
            try {
                C0794q.m892a(th);
                C0776k c0776k2 = new C0776k(HttpStatus.SC_MULTI_STATUS, th);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused2) {
                    }
                }
                C0788k.m813a((Closeable) null);
                return c0776k2;
            } finally {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused3) {
                    }
                }
                C0788k.m813a((Closeable) null);
            }
        }
    }

    /* renamed from: a */
    private JSONObject m383a(HashMap<String, String> hashMap) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (this.f346c == null) {
            Context m565g = C0749e.m565g();
            try {
                this.f346c = new JSONObject();
                if (this.f345b != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : this.f345b.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    this.f346c.put("custom", jSONObject2);
                }
                this.f346c.put("os", "Android");
                this.f346c.put("platform", "Android");
                this.f346c.put("os_version", C0747c.m521c());
                this.f346c.put("os_api", Build.VERSION.SDK_INT);
                this.f346c.put("sdk_version", this.f344a.f327d);
                this.f346c.put("sdk_version_code", this.f344a.f327d);
                this.f346c.put("sdk_version_name", this.f344a.f328e);
                this.f346c.put(MonitorConstants.KEY_AID, this.f344a.f324a);
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                this.f346c.put("device_model", str);
                this.f346c.put("device_brand", Build.BRAND);
                this.f346c.put("device_manufacturer", Build.MANUFACTURER);
                this.f346c.put("channel", this.f344a.f326c);
                this.f346c.put("app_version", this.f344a.f328e);
                this.f346c.put("version_code", this.f344a.f327d);
                this.f346c.put("update_version_code", this.f344a.f327d);
                this.f346c.put("manifest_version_code", this.f344a.f327d);
                this.f346c.put("bd_did", this.f344a.getDeviceId());
                String packageName = m565g.getPackageName();
                this.f346c.put("package", packageName);
                PackageInfo packageInfo = m565g.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo.applicationInfo != null) {
                    int i = packageInfo.applicationInfo.labelRes;
                    if (i > 0) {
                        this.f346c.put("display_name", m565g.getString(i));
                    } else {
                        this.f346c.put("display_name", m565g.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
                    }
                }
            } catch (Exception unused) {
            }
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put(Constants.KEY_HEADER, this.f346c);
        jSONObject.put("local_time", currentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long currentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put(StrategyConstants.LOCAL_TIME_MS, currentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put(MonitorCommonConstants.KEY_SESSION_ID, UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(currentTimeMillis2)));
        if (hashMap != null) {
            JSONObject jSONObject4 = new JSONObject();
            for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                jSONObject4.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject3.put("pv_filters", jSONObject4);
        }
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public String m384a() {
        return null;
    }

    /* renamed from: a */
    public void m385a(Context context, MonitorCrash.Config config, Map<String, String> map) {
        if (config == null) {
            return;
        }
        this.f344a = config;
        this.f345b = map;
    }

    /* renamed from: a */
    public void m386a(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0084 A[Catch: all -> 0x008b, TRY_LEAVE, TryCatch #1 {all -> 0x008b, blocks: (B:11:0x0016, B:17:0x0034, B:18:0x0037, B:19:0x0040, B:21:0x0084, B:27:0x003c), top: B:10:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m387a(HashMap<String, String> hashMap, IUploadCallback iUploadCallback) {
        MonitorCrash.Config config = this.f344a;
        if (config == null && !TextUtils.isEmpty(config.getDeviceId())) {
            if (iUploadCallback != null) {
                iUploadCallback.afterUpload(false);
                return;
            }
            return;
        }
        try {
            JSONObject m383a = m383a(hashMap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(m383a.toString().getBytes(UrlUtils.UTF_8));
                    C0788k.m813a(gZIPOutputStream2);
                } catch (Throwable unused) {
                    gZIPOutputStream = gZIPOutputStream2;
                    C0788k.m813a(gZIPOutputStream);
                    C0788k.m813a(byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    StringBuilder sb = new StringBuilder(C0749e.m567i().getPageViewUrl());
                    sb.append("?version_code=").append(this.f344a.f327d).append("&device_platform=android&aid=").append(this.f344a.f324a).append("&iid=iid");
                    C0776k m382a = m382a(sb.toString(), byteArray, this.f344a.f324a, this.f344a.f325b);
                    if (iUploadCallback == null) {
                    }
                }
            } catch (Throwable unused2) {
            }
            C0788k.m813a(byteArrayOutputStream);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            StringBuilder sb2 = new StringBuilder(C0749e.m567i().getPageViewUrl());
            sb2.append("?version_code=").append(this.f344a.f327d).append("&device_platform=android&aid=").append(this.f344a.f324a).append("&iid=iid");
            C0776k m382a2 = m382a(sb2.toString(), byteArray2, this.f344a.f324a, this.f344a.f325b);
            if (iUploadCallback == null) {
                iUploadCallback.afterUpload(m382a2.m732a());
            }
        } catch (Throwable unused3) {
        }
    }

    /* renamed from: b */
    public void m388b(String str) {
    }
}
