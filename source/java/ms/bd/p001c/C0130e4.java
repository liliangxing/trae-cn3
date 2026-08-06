package ms.bd.p001c;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.mobsec.matrix.utils.m.TN;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.math.ec.Tnaf;
import org.json.JSONObject;

/* renamed from: ms.bd.c.e4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0130e4 extends AbstractC0146h2 {
    /* renamed from: a */
    public static String m90a(List list) {
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Header header = (Header) it.next();
                if (header != null && ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "cdf479", new byte[]{106, 43, 1, 84, 69, 34, 111, 66, 62, 96})).equalsIgnoreCase(header.getName())) {
                    return header.getValue();
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static int m93b(String str) {
        if (str != null && BuildConfig.FLAVOR != str) {
            try {
                return new JSONObject(str).getJSONObject((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c7a8d0", new byte[]{96, 48, 1, 92, 84, 41, 115, 19})).getInt((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9ebd4d", new byte[]{43, 104, 21, 21}));
            } catch (Throwable unused) {
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static int m89a(String str) {
        if (str == null || BuildConfig.FLAVOR == str) {
            return 80000;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject((String) AbstractC0190p2.m166a(16777217, 0, 0L, "560137", new byte[]{38, 53, 80, 64}));
            if (jSONObject == null) {
                return 80001;
            }
            String string = jSONObject.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "f8f32b", new byte[]{100, 46, 20, 83, 24, 102}));
            if (string != null && ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c52fc5", new byte[]{65, 2, 98, 49, 121, 17, 83})) != string) {
                return jSONObject.getInt((String) AbstractC0190p2.m166a(16777217, 0, 0L, "7597a1", new byte[]{40, 50, 94, 124, 91, 52, 38, 27, 122}));
            }
            return 80002;
        } catch (Throwable unused) {
            return 80003;
        }
    }

    /* renamed from: b */
    public static int m92b(Call call, SsResponse ssResponse) {
        HttpRequestInfo httpRequestInfo;
        if (call == null || ssResponse == null || !(call instanceof IMetricsCollect)) {
            return -1;
        }
        ((IMetricsCollect) call).doCollect();
        Response raw = ssResponse.raw();
        if (raw == null) {
            return -1;
        }
        Object extraInfo = raw.getExtraInfo();
        if (!(extraInfo instanceof HttpRequestInfo) || (httpRequestInfo = (HttpRequestInfo) extraInfo) == null) {
            return -1;
        }
        return m93b(httpRequestInfo.requestLog);
    }

    /* renamed from: a */
    public static int m88a(Call call, SsResponse ssResponse) {
        if (call == null || ssResponse == null) {
            return 80004;
        }
        if (!(call instanceof IMetricsCollect)) {
            return 80005;
        }
        ((IMetricsCollect) call).doCollect();
        Response raw = ssResponse.raw();
        if (raw == null) {
            return 80006;
        }
        Object extraInfo = raw.getExtraInfo();
        if (!(extraInfo instanceof HttpRequestInfo)) {
            return 80007;
        }
        HttpRequestInfo httpRequestInfo = (HttpRequestInfo) extraInfo;
        if (httpRequestInfo != null) {
            return m89a(httpRequestInfo.requestLog);
        }
        return 80008;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x04dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0478 A[Catch: all -> 0x050a, TryCatch #5 {all -> 0x050a, blocks: (B:63:0x043c, B:66:0x0443, B:69:0x044a, B:72:0x0451, B:75:0x0458, B:78:0x045f, B:81:0x0466, B:84:0x046d, B:87:0x0474, B:89:0x0478, B:94:0x0490, B:95:0x0498, B:97:0x04cb, B:98:0x04d5), top: B:62:0x043c }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x04cb A[Catch: all -> 0x050a, TryCatch #5 {all -> 0x050a, blocks: (B:63:0x043c, B:66:0x0443, B:69:0x044a, B:72:0x0451, B:75:0x0458, B:78:0x045f, B:81:0x0466, B:84:0x046d, B:87:0x0474, B:89:0x0478, B:94:0x0490, B:95:0x0498, B:97:0x04cb, B:98:0x04d5), top: B:62:0x043c }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object[] m91a(String str, byte[] bArr, String str2, String str3, HashMap hashMap, String str4, boolean z) {
        Call call;
        OutputStream outputStream;
        SsResponse ssResponse;
        int i;
        InputStream inputStream;
        int i2;
        int m88a;
        byte[] bArr2;
        C0241z3 c0241z3;
        C0128e2 c0128e2 = new C0128e2();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Header((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2f487e", new byte[]{0, 107, 72, 71, 1, 119}), ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6973ce", new byte[]{52, 62, 87, 84, 85, 125, 59, 17, 98, 62})) + str2));
            arrayList.add(new Header((String) AbstractC0190p2.m166a(16777217, 0, 0L, "48b1f2", new byte[]{4, 57, 18, 64, 73, 49}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "6a817b", new byte[]{109, 44, 1})));
            arrayList.add(new Header((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9d7a9b", new byte[]{29, 117, 65, 7, 75, 84, Base64.padSymbol, 64, 104, 37}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "d2c210", new byte[]{87, 41, 4, 67, 42, 38, 105, Tnaf.POW_2_WIDTH, 55, 47, 88, 3, 35, 98, 37})));
            arrayList.add(new Header((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a920c4", new byte[]{83, 52, 79, 80, 89, 45, 118, 85, 87, 121, 96, 62}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "2c647a", new byte[]{34, 113, 85, 76, 1, 117, 48, 86, 110, 107, 45, 46, 74, 67, 28, 115, 37, 15, 116, 112, 49, 100, 68, 77})));
            if (hashMap != null && hashMap.size() > 0) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    arrayList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
                }
            }
            if (str3 != null && str3.trim().length() > 0) {
                arrayList.add(new Header((String) AbstractC0190p2.m166a(16777217, 0, 0L, "1d0235", new byte[]{56, 43, 87, 82, 65, 48, 55, 84, 116, 103, 51, 114, 14, 82, 13, 37}), str3));
            }
            TN tn = (TN) RetrofitUtils.getSsRetrofit(str).create(TN.class);
            call = z ? tn.p1(str, arrayList, new TypedByteArray((String) AbstractC0190p2.m166a(16777217, 0, 0L, "04fe6d", new byte[]{32, 38, 5, 29, 0, 112, 50, 1, 62, 58, 47, 121, 26, 18, 29, 118, 39, 88, 36, 33, 51, 51, 20, 28}), bArr, new String[0])) : tn.p2(str, arrayList);
            try {
                c0128e2.f164b = str;
                c0128e2.f163a = System.currentTimeMillis();
                ssResponse = call.execute();
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                ssResponse = null;
                i = -1;
                inputStream = null;
                i2 = AbstractC0116c2.COLLECT_MODE_DEFAULT;
                try {
                    if (th instanceof UnsupportedOperationException) {
                        i2 = 90000;
                    }
                    if (th instanceof CdnCacheVerifyException) {
                        i2 = 90001;
                    }
                    if (th instanceof ClientProtocolException) {
                        i2 = 90002;
                    }
                    if (th instanceof HttpResponseException) {
                        i2 = 90003;
                    }
                    if (th instanceof NetworkNotAvailabeException) {
                        i2 = 90004;
                    }
                    if (th instanceof NoHttpResponseException) {
                        i2 = 90005;
                    }
                    if (th instanceof NotAllowApiHttpException) {
                        i2 = 90006;
                    }
                    if (th instanceof NotAllowUseNetworkException) {
                        i2 = 90007;
                    }
                    if (th instanceof CronetIOException) {
                        CronetIOException cronetIOException = th;
                        i2 = m89a(cronetIOException.getRequestLog());
                        if (i2 >= 80000) {
                            i2 = 90009;
                        }
                        if (i == -1) {
                            i = m93b(cronetIOException.getRequestLog());
                        }
                    }
                    c0128e2.m87a(ssResponse == null ? m90a(ssResponse.headers()) : null, i);
                    m88a = (i == 200 && i2 == 0) ? m88a(call, ssResponse) : i2;
                    if (i == -1) {
                        i = m92b(call, ssResponse);
                    }
                    StreamParser.safeClose(inputStream);
                    StreamParser.safeClose(outputStream);
                    if (call != null) {
                        call.cancel();
                    }
                    bArr2 = null;
                    return new Object[]{String.valueOf(i), bArr2, Integer.valueOf(m88a)};
                } catch (Throwable th2) {
                    if (i != 200 && i2 == 0) {
                        m88a(call, ssResponse);
                    }
                    if (i == -1) {
                        m92b(call, ssResponse);
                    }
                    StreamParser.safeClose(inputStream);
                    StreamParser.safeClose(outputStream);
                    if (call != null) {
                        call.cancel();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            call = null;
        }
        try {
            i = ssResponse.code();
            try {
                String m90a = m90a(ssResponse.headers());
                synchronized (C0241z3.class) {
                    c0241z3 = C0241z3.f482c;
                }
                if (c0241z3 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = c0128e2.f163a;
                    long j2 = currentTimeMillis - j;
                    String str5 = c0128e2.f164b;
                    SDKMonitor sDKMonitor = c0241z3.f483a;
                    if (sDKMonitor != null) {
                        sDKMonitor.monitorSLA(j2, j, str5, (String) null, m90a, i, (JSONObject) null);
                    }
                }
                outputStream = str4 != null ? new FileOutputStream(str4) : new ByteArrayOutputStream();
                try {
                    inputStream = ((TypedInput) ssResponse.body()).in();
                    try {
                        byte[] bArr3 = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr3, 0, 1024);
                            if (read <= 0) {
                                break;
                            }
                            outputStream.write(bArr3, 0, read);
                        }
                        outputStream.flush();
                        byte[] byteArray = outputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) outputStream).toByteArray() : null;
                        m88a = i != 200 ? m88a(call, ssResponse) : 0;
                        if (i == -1) {
                            i = m92b(call, ssResponse);
                        }
                        StreamParser.safeClose(inputStream);
                        StreamParser.safeClose(outputStream);
                        call.cancel();
                        bArr2 = byteArray;
                    } catch (Throwable th4) {
                        th = th4;
                        i2 = AbstractC0116c2.COLLECT_MODE_DEFAULT;
                        if (th instanceof UnsupportedOperationException) {
                        }
                        if (th instanceof CdnCacheVerifyException) {
                        }
                        if (th instanceof ClientProtocolException) {
                        }
                        if (th instanceof HttpResponseException) {
                        }
                        if (th instanceof NetworkNotAvailabeException) {
                        }
                        if (th instanceof NoHttpResponseException) {
                        }
                        if (th instanceof NotAllowApiHttpException) {
                        }
                        if (th instanceof NotAllowUseNetworkException) {
                        }
                        if (th instanceof CronetIOException) {
                        }
                        c0128e2.m87a(ssResponse == null ? m90a(ssResponse.headers()) : null, i);
                        if (i == 200) {
                        }
                        if (i == -1) {
                        }
                        StreamParser.safeClose(inputStream);
                        StreamParser.safeClose(outputStream);
                        if (call != null) {
                        }
                        bArr2 = null;
                        return new Object[]{String.valueOf(i), bArr2, Integer.valueOf(m88a)};
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    i2 = AbstractC0116c2.COLLECT_MODE_DEFAULT;
                    if (th instanceof UnsupportedOperationException) {
                    }
                    if (th instanceof CdnCacheVerifyException) {
                    }
                    if (th instanceof ClientProtocolException) {
                    }
                    if (th instanceof HttpResponseException) {
                    }
                    if (th instanceof NetworkNotAvailabeException) {
                    }
                    if (th instanceof NoHttpResponseException) {
                    }
                    if (th instanceof NotAllowApiHttpException) {
                    }
                    if (th instanceof NotAllowUseNetworkException) {
                    }
                    if (th instanceof CronetIOException) {
                    }
                    c0128e2.m87a(ssResponse == null ? m90a(ssResponse.headers()) : null, i);
                    if (i == 200) {
                    }
                    if (i == -1) {
                    }
                    StreamParser.safeClose(inputStream);
                    StreamParser.safeClose(outputStream);
                    if (call != null) {
                    }
                    bArr2 = null;
                    return new Object[]{String.valueOf(i), bArr2, Integer.valueOf(m88a)};
                }
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            outputStream = null;
            i = -1;
            inputStream = null;
            i2 = AbstractC0116c2.COLLECT_MODE_DEFAULT;
            if (th instanceof UnsupportedOperationException) {
            }
            if (th instanceof CdnCacheVerifyException) {
            }
            if (th instanceof ClientProtocolException) {
            }
            if (th instanceof HttpResponseException) {
            }
            if (th instanceof NetworkNotAvailabeException) {
            }
            if (th instanceof NoHttpResponseException) {
            }
            if (th instanceof NotAllowApiHttpException) {
            }
            if (th instanceof NotAllowUseNetworkException) {
            }
            if (th instanceof CronetIOException) {
            }
            c0128e2.m87a(ssResponse == null ? m90a(ssResponse.headers()) : null, i);
            if (i == 200) {
            }
            if (i == -1) {
            }
            StreamParser.safeClose(inputStream);
            StreamParser.safeClose(outputStream);
            if (call != null) {
            }
            bArr2 = null;
            return new Object[]{String.valueOf(i), bArr2, Integer.valueOf(m88a)};
        }
        return new Object[]{String.valueOf(i), bArr2, Integer.valueOf(m88a)};
    }
}
