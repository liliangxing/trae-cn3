package com.xiaomi.mipush.sdk;

import com.xiaomi.push.EnumC1638gj;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1448g {

    /* renamed from: a */
    private static HashMap<EnumC1445d, a> f852a = new HashMap<>();

    static {
        m1303a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        m1303a(EnumC1445d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        m1303a(EnumC1445d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        m1303a(EnumC1445d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    /* renamed from: a */
    private static void m1303a(EnumC1445d enumC1445d, a aVar) {
        if (aVar != null) {
            f852a.put(enumC1445d, aVar);
        }
    }

    /* renamed from: a */
    public static a m1300a(EnumC1445d enumC1445d) {
        return f852a.get(enumC1445d);
    }

    /* renamed from: a */
    public static EnumC1638gj m1302a(EnumC1445d enumC1445d) {
        return EnumC1638gj.AggregatePushSwitch;
    }

    /* renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f853a;

        static {
            int[] iArr = new int[EnumC1445d.values().length];
            f853a = iArr;
            try {
                iArr[EnumC1445d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f853a[EnumC1445d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f853a[EnumC1445d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f853a[EnumC1445d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a */
    public static EnumC1463v m1301a(EnumC1445d enumC1445d) {
        int i = AnonymousClass1.f853a[enumC1445d.ordinal()];
        if (i == 1) {
            return EnumC1463v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return EnumC1463v.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return EnumC1463v.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return EnumC1463v.UPLOAD_FTOS_TOKEN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        public String f854a;

        /* renamed from: b */
        public String f855b;

        public a(String str, String str2) {
            this.f854a = str;
            this.f855b = str2;
        }
    }
}
