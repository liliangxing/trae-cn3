package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1659hd;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1794v {

    /* renamed from: a */
    private static a f3238a;

    /* renamed from: a */
    private static b f3239a;

    /* renamed from: com.xiaomi.push.service.v$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        Map<String, String> m4017a(Context context, C1656ha c1656ha);

        /* renamed from: a */
        void m4018a(Context context, C1656ha c1656ha);

        /* renamed from: a */
        void m4019a(Context context, C1656ha c1656ha, C1659hd c1659hd);

        /* renamed from: a */
        boolean m4020a(Context context, C1656ha c1656ha, boolean z);
    }

    /* renamed from: com.xiaomi.push.service.v$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface b {
        /* renamed from: a */
        void m4021a(C1656ha c1656ha);

        /* renamed from: a */
        void m4022a(String str);

        /* renamed from: a */
        boolean m4023a(C1656ha c1656ha);
    }

    /* renamed from: a */
    public static void m4012a(Context context, C1656ha c1656ha, C1659hd c1659hd) {
        a aVar = f3238a;
        if (aVar == null) {
            AbstractC1417b.m1103d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.m4019a(context, c1656ha, c1659hd);
        }
    }

    /* renamed from: a */
    public static boolean m4015a(Context context, C1656ha c1656ha, boolean z) {
        a aVar = f3238a;
        if (aVar == null || c1656ha == null) {
            AbstractC1417b.m1089a("pepa judement listener or container is null");
            return false;
        }
        return aVar.m4020a(context, c1656ha, z);
    }

    /* renamed from: a */
    public static void m4011a(Context context, C1656ha c1656ha) {
        a aVar = f3238a;
        if (aVar == null || c1656ha == null) {
            AbstractC1417b.m1089a("handle msg wrong");
        } else {
            aVar.m4018a(context, c1656ha);
        }
    }

    /* renamed from: a */
    public static Map<String, String> m4010a(Context context, C1656ha c1656ha) {
        a aVar = f3238a;
        if (aVar == null || c1656ha == null) {
            AbstractC1417b.m1089a("pepa listener or container is null");
            return null;
        }
        return aVar.m4017a(context, c1656ha);
    }

    /* renamed from: a */
    public static boolean m4016a(C1656ha c1656ha) {
        b bVar = f3239a;
        if (bVar == null || c1656ha == null) {
            AbstractC1417b.m1089a("pepa handleReceiveMessage is null");
            return false;
        }
        return bVar.m4023a(c1656ha);
    }

    /* renamed from: a */
    public static void m4013a(C1656ha c1656ha) {
        b bVar = f3239a;
        if (bVar == null || c1656ha == null) {
            AbstractC1417b.m1089a("pepa clearMessage is null");
        } else {
            bVar.m4021a(c1656ha);
        }
    }

    /* renamed from: a */
    public static void m4014a(String str) {
        b bVar = f3239a;
        if (bVar == null || str == null) {
            AbstractC1417b.m1089a("pepa clearMessage is null");
        } else {
            bVar.m4022a(str);
        }
    }
}
