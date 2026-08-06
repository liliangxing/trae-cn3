package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.tobshadow.bdtracker.o5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0487o5 {

    /* renamed from: a */
    public static volatile String f903a;

    /* renamed from: com.bytedance.tobshadow.bdtracker.o5$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a implements Callable<String> {

        /* renamed from: a */
        public final /* synthetic */ Context f904a;

        /* renamed from: b */
        public final /* synthetic */ C0407d2 f905b;

        public a(Context context, C0407d2 c0407d2) {
            this.f904a = context;
            this.f905b = c0407d2;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0042 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x000b, B:8:0x0013, B:9:0x0015, B:17:0x003c, B:19:0x0042, B:20:0x006f, B:21:0x0071, B:23:0x004d, B:25:0x005d, B:29:0x0068, B:33:0x0026, B:35:0x002a, B:38:0x002f, B:40:0x0036, B:14:0x0018, B:16:0x0020), top: B:5:0x000b, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x000b, B:8:0x0013, B:9:0x0015, B:17:0x003c, B:19:0x0042, B:20:0x006f, B:21:0x0071, B:23:0x004d, B:25:0x005d, B:29:0x0068, B:33:0x0026, B:35:0x002a, B:38:0x002f, B:40:0x0036, B:14:0x0018, B:16:0x0020), top: B:5:0x000b, inners: #1 }] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String call() {
            String str;
            AdvertisingIdClient.Info advertisingIdInfo;
            if (TextUtils.isEmpty(C0487o5.f903a)) {
                synchronized (C0487o5.class) {
                    if (!TextUtils.isEmpty(C0487o5.f903a)) {
                        return C0487o5.f903a;
                    }
                    try {
                        advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f904a);
                    } catch (Throwable th) {
                        if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                            LoggerImpl.global().error("Query Gaid failed", th, new Object[0]);
                        }
                    }
                    if (advertisingIdInfo != null) {
                        str = advertisingIdInfo.getId();
                        if (!TextUtils.isEmpty(str)) {
                            str = this.f905b.f505f.getString("google_aid", null);
                        } else if (!TextUtils.equals(this.f905b.f505f.getString("google_aid", null), str)) {
                            C0407d2 c0407d2 = this.f905b;
                            if (!TextUtils.isEmpty(str) && c0407d2 != null) {
                                c0407d2.f505f.putString("google_aid", str);
                            }
                        }
                        C0487o5.f903a = str;
                    }
                    str = null;
                    if (!TextUtils.isEmpty(str)) {
                    }
                    C0487o5.f903a = str;
                }
            }
            return C0487o5.f903a;
        }
    }

    /* renamed from: a */
    public static String m606a(Context context, C0407d2 c0407d2) {
        return (String) C0426g0.f610a.submit(new a(context, c0407d2)).get(c0407d2.f502c.getGaidTimeOutMilliSeconds(), TimeUnit.MILLISECONDS);
    }
}
