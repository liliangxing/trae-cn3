package ms.bd.p001c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.Utils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
import net.openid.appauth.BuildConfig;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.bouncycastle.math.ec.Tnaf;
import org.json.JSONObject;

/* renamed from: ms.bd.c.l2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0170l2 extends AbstractC0134f2 {

    /* renamed from: a */
    public a f231a;

    /* renamed from: b */
    public long f232b;

    /* renamed from: ms.bd.c.l2$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public final class a implements Interceptor {

        /* renamed from: a */
        public final C0148h4 f233a = new C0148h4();

        public a() {
        }

        /* renamed from: a */
        public final void m141a(String str, String str2) {
            MSManager mSManager;
            try {
                String m140a = m140a(str2);
                if (TextUtils.isEmpty(m140a) || (mSManager = MSManagerUtils.get(m140a)) == null) {
                    return;
                }
                for (String str3 : this.f233a.keySet()) {
                    if (str.contains(str3)) {
                        mSManager.report((String) this.f233a.get(str3));
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:89:0x0095 A[Catch: all -> 0x04f4, TryCatch #1 {, blocks: (B:70:0x0041, B:72:0x0047, B:76:0x0053, B:78:0x0063, B:81:0x006e, B:83:0x007e, B:86:0x0089, B:87:0x008f, B:89:0x0095, B:93:0x00a8, B:97:0x00b5, B:101:0x00c2), top: B:69:0x0041 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final SsResponse intercept(Interceptor.Chain chain) {
            Object m166a;
            Object m166a2;
            boolean z;
            Iterator it;
            C0197r c0197r;
            RequestBody requestBody;
            Object obj;
            Request request = chain.request();
            long j = C0170l2.this.f232b;
            if (j != -1 && (m166a2 = AbstractC0190p2.m166a(50331651, 0, j, null, null)) != null) {
                C0202s m186a = C0202s.m186a(C0122d2.f158b.f159a);
                String url = request.getUrl();
                synchronized (m186a) {
                    if (url != null) {
                        Object m166a3 = AbstractC0190p2.m166a(33554445, 3, 0L, null, null);
                        if (m166a3 != null && ((Integer) m166a3).intValue() == 0) {
                            z = false;
                            Object m166a4 = AbstractC0190p2.m166a(33554445, 2, 0L, null, null);
                            boolean z2 = m166a4 == null && ((Integer) m166a4).intValue() == 1;
                            Object m166a5 = AbstractC0190p2.m166a(33554445, 1, 0L, null, null);
                            boolean z3 = m166a5 == null && ((Integer) m166a5).intValue() == 1;
                            it = m186a.f387b.iterator();
                            while (it.hasNext()) {
                                c0197r = (C0197r) it.next();
                                if (!c0197r.f325a.equals(C0202s.f383e) || z3) {
                                    if (!c0197r.f325a.equals(C0202s.f382d) || z2) {
                                        if (!c0197r.f325a.equals(C0202s.f381c) || z) {
                                            if (Pattern.compile(c0197r.f325a).matcher(url).find()) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                        Object m166a42 = AbstractC0190p2.m166a(33554445, 2, 0L, null, null);
                        if (m166a42 == null) {
                        }
                        Object m166a52 = AbstractC0190p2.m166a(33554445, 1, 0L, null, null);
                        if (m166a52 == null) {
                        }
                        it = m186a.f387b.iterator();
                        while (it.hasNext()) {
                        }
                    }
                    c0197r = null;
                }
                if (c0197r != null && !DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(c0197r.f326b)) {
                    if ("async".equals(c0197r.f326b)) {
                        AbstractC0190p2.m166a(33554433, 0, ((Long) m166a2).longValue(), "report-async_" + (System.currentTimeMillis() / 1000), C0122d2.f158b.f159a);
                    } else if ("sync".equals(c0197r.f326b)) {
                        HashMap hashMap = new HashMap();
                        Long l = (Long) m166a2;
                        String str = ((String) AbstractC0190p2.m166a(33554444, 0, l.longValue(), null, null)) + "&cdi=0.3&sh=report_sync";
                        String str2 = BuildConfig.FLAVOR;
                        Object m166a6 = AbstractC0190p2.m166a(33554440, AbstractC0116c2.COLLECT_MODE_DEFAULT, l.longValue(), "report_sync", null);
                        if (m166a6 != null && (m166a6 instanceof Object[])) {
                            Object[] objArr = (Object[]) m166a6;
                            if (objArr.length >= 2 && objArr[0] != null && (obj = objArr[1]) != null) {
                                str2 = obj.toString();
                            }
                        }
                        hashMap.put("x-bdms-payload", AbstractC0192q.m169a(AbstractC0192q.m170a(str.getBytes())) + ";;" + AbstractC0192q.m169a(str2));
                        int i = AbstractC0124d4.f160a;
                        try {
                            if (hashMap.size() > 0 && ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5c8840", new byte[]{52, 110, 88, 88})).equalsIgnoreCase(request.getMethod())) {
                                if (request.getRequestBody() == null) {
                                    TypedOutput body = request.getBody();
                                    if (body != null) {
                                        try {
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            body.writeTo(byteArrayOutputStream);
                                            requestBody = RequestBody.create(MediaType.parse(body.mimeType()), new String(byteArrayOutputStream.toByteArray(), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "789759", new byte[]{19, 14, 108, 14, 82})));
                                        } catch (Exception unused) {
                                        }
                                    }
                                    requestBody = null;
                                } else {
                                    requestBody = request.getRequestBody();
                                }
                                String subtype = requestBody.contentType().subtype();
                                long length = request.getBody().length();
                                if (subtype.contains((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b3bf9c", new byte[]{121, 34, 30, 28}))) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(AbstractC0124d4.m85a(requestBody));
                                        for (String str3 : hashMap.keySet()) {
                                            jSONObject.put(str3, (String) hashMap.get(str3));
                                        }
                                        requestBody = RequestBody.create(requestBody.contentType(), jSONObject.toString());
                                    } catch (Exception unused2) {
                                    }
                                } else {
                                    requestBody = subtype.contains((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e81fb4", new byte[]{114, 53, 80, 31, Tnaf.POW_2_WIDTH, 54, 116, 21, 101, 56, 119, 53, 70, 23, 89})) ? AbstractC0124d4.m86a(requestBody, hashMap) : null;
                                }
                                if (requestBody != null && requestBody.contentLength() >= length) {
                                    request = request.newBuilder().post(Utils.convert(requestBody)).build();
                                }
                            }
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
            SsResponse proceed = chain.proceed(request);
            for (Header header : proceed.headers()) {
                String name = header.getName();
                String value = header.getValue();
                if ("x-bdms-dy".equals(name) && value != null) {
                    C0198r0 m176a = C0198r0.m176a();
                    String path = request.getPath();
                    m176a.getClass();
                    AtomicBoolean atomicBoolean = C0198r0.f339d;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        AtomicInteger atomicInteger = C0198r0.f355t;
                        atomicInteger.incrementAndGet();
                        if (C0198r0.f336J.size() > 0 && path != null && path.length() < C0198r0.f348m) {
                            if (atomicInteger.incrementAndGet() >= C0198r0.f340e) {
                                atomicInteger.decrementAndGet();
                            } else if (!C0162k0.m134a().m135a(EnumC0150i0.f186c, path) && atomicInteger.decrementAndGet() < 0) {
                                atomicInteger.set(0);
                            }
                        }
                        if (!C0162k0.m134a().m135a(EnumC0150i0.f185b, value)) {
                            if (atomicInteger.decrementAndGet() < 0) {
                                atomicInteger.set(0);
                            }
                            atomicBoolean.set(false);
                        }
                    }
                    AtomicInteger atomicInteger2 = C0198r0.f355t;
                    if (atomicInteger2.get() > C0198r0.f340e) {
                        C0162k0.m134a().m135a(EnumC0150i0.f187d, null);
                        atomicInteger2.set(0);
                        atomicBoolean.set(false);
                    }
                } else {
                    if ("x-bdms-dy-sw".equals(name) && value != null) {
                        C0198r0.m176a().getClass();
                        try {
                            Integer.parseInt(value);
                        } catch (Exception unused4) {
                        }
                    }
                    if ("x-bdms-cj".equals(name) && value != null && request != null) {
                        try {
                            if (Integer.parseInt(value.trim()) == 1) {
                                m141a(request.getPath(), request.getUrl());
                            }
                        } catch (Exception unused5) {
                        }
                    } else if ("x-bdms-ctrl".equals(name) && value != null && (m166a = AbstractC0190p2.m166a(33554445, 4, 0L, null, null)) != null && ((Integer) m166a).intValue() == 1) {
                        C0122d2 c0122d2 = C0122d2.f158b;
                        if (c0122d2.f159a != null) {
                            String value2 = header.getValue();
                            String str4 = AbstractC0192q.f314a;
                            if (value2 != null && value2.length() > 0) {
                                int length2 = 4 - (value2.length() % 4);
                                String str5 = BuildConfig.FLAVOR;
                                if (length2 == 1) {
                                    str5 = AbstractC0192q.f315b;
                                } else if (length2 == 2) {
                                    str5 = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "644ba8", new byte[]{122, 107});
                                }
                                value2 = value2.replaceAll((String) AbstractC0190p2.m166a(16777217, 0, 0L, "62a233", new byte[]{106}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "88fbbf", new byte[]{98})).replaceAll((String) AbstractC0190p2.m166a(16777217, 0, 0L, "3249ed", new byte[]{29}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "1e1ea1", new byte[]{111})) + str5;
                            }
                            C0202s.m186a(c0122d2.f159a).m187a(new String(AbstractC0192q.m171b(value2)), true);
                        }
                    }
                }
            }
            return proceed;
        }

        /* renamed from: a */
        public static String m140a(String str) {
            try {
                String query = new URL(str).getQuery();
                HashMap hashMap = new HashMap();
                if (query != null) {
                    for (String str2 : query.split("&")) {
                        String[] split = str2.split("=");
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                }
                return (hashMap.isEmpty() || !hashMap.containsKey("aid")) ? BuildConfig.FLAVOR : (String) hashMap.get("aid");
            } catch (Exception unused) {
                return BuildConfig.FLAVOR;
            }
        }
    }

    @Override // ms.bd.p001c.AbstractC0134f2
    /* renamed from: a */
    public final void mo97a(long j) {
        this.f232b = j;
        a aVar = new a();
        this.f231a = aVar;
        RetrofitUtils.addInterceptor(aVar);
    }

    public final void finalize() {
        RetrofitUtils.removeInterceptor(this.f231a);
        super.finalize();
    }
}
