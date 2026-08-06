package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.dr.OaidApi;
import com.bytedance.tobshadow.applog.IOaidObserver;
import com.bytedance.tobshadow.applog.OaidHelper;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import com.bytedance.tobshadow.bdtracker.C0475n0;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0404d {

    /* renamed from: a */
    public static AbstractC0388b<C0418f> f491a = new a();

    /* renamed from: com.bytedance.tobshadow.bdtracker.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a extends AbstractC0388b<C0418f> {
        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0388b
        /* renamed from: a */
        public C0418f mo276a(Object[] objArr) {
            return new C0418f((Context) objArr[0]);
        }
    }

    /* renamed from: a */
    public static String m303a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    /* renamed from: a */
    public static void m305a(IOaidObserver iOaidObserver) {
        C0418f.m390a(iOaidObserver);
    }

    /* renamed from: a */
    public static void m306a(InterfaceC0488p interfaceC0488p) {
        InterfaceC0488p interfaceC0488p2;
        C0418f.f567k = interfaceC0488p;
        Map<String, String> map = C0418f.f569m;
        if (map == null || (interfaceC0488p2 = C0418f.f567k) == null) {
            return;
        }
        ((C0475n0.b) interfaceC0488p2).m561a(map);
    }

    /* renamed from: b */
    public static void m307b(Context context) {
        LoggerImpl.global().debug(1, "Oaid#initOaidEarly", new Object[0]);
        f491a.m277b(context).m396a();
    }

    /* renamed from: b */
    public static void m308b(IOaidObserver iOaidObserver) {
        C0418f.m394b(iOaidObserver);
    }

    /* renamed from: a */
    public static String m302a(IKVStore iKVStore) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String m277b = C0396c.f476a.m277b(iKVStore);
        LoggerImpl.global().debug(1, "getCdid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms", new Object[0]);
        return m277b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0087, code lost:
    
        if (r3 != false) goto L26;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map m304a(Context context) {
        Map<String, String> map;
        boolean z;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C0418f m277b = f491a.m277b(context);
        long j = OaidHelper.oadiTimeout;
        if (m277b.f572c) {
            m277b.m396a();
            LoggerImpl.global().debug(1, "Oaid#getOaid timeoutMills=" + j, new Object[0]);
            if (C0418f.f569m == null) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                try {
                    OaidApi oaidApi = m277b.f571b;
                    if (oaidApi != null && "HONOR".equalsIgnoreCase(oaidApi.getName())) {
                        j += 100;
                    }
                    z = m277b.f570a.tryLock(j, TimeUnit.MILLISECONDS);
                    try {
                        LoggerImpl.global().debug(1, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime2) + " ms", new Object[0]);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            LoggerImpl.global().error(1, "Oaid#Get oaid failed", th, new Object[0]);
                        } finally {
                            if (z) {
                                m277b.f570a.unlock();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
            }
            LoggerImpl.global().debug(1, "Oaid#getOaid return apiMap={}", C0418f.f569m);
            map = C0418f.f569m;
        } else {
            map = null;
        }
        LoggerImpl.global().debug(1, "Oaid#getOaid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms", new Object[0]);
        return map;
    }
}
