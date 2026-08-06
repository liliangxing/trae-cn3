package com.apm.lite.runtime.p024a;

import android.content.Context;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.runtime.p024a.AbstractC0813c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.apm.lite.runtime.a.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0815e {

    /* renamed from: a */
    private static volatile C0815e f685a;

    /* renamed from: b */
    private Context f686b;

    /* renamed from: c */
    private Map<CrashType, AbstractC0813c> f687c = new HashMap();

    /* renamed from: d */
    private C0812b f688d;

    /* renamed from: e */
    private C0814d f689e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.lite.runtime.a.e$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f690a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f690a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f690a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f690a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f690a[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f690a[CrashType.DART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f690a[CrashType.ENSURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private C0815e(Context context) {
        this.f686b = context;
        try {
            this.f688d = C0812b.m1057d();
            this.f689e = new C0814d(this.f686b);
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
    }

    /* renamed from: a */
    private AbstractC0813c m1102a(CrashType crashType) {
        AbstractC0813c abstractC0813c = this.f687c.get(crashType);
        if (abstractC0813c != null) {
            return abstractC0813c;
        }
        switch (AnonymousClass1.f690a[crashType.ordinal()]) {
            case 1:
                abstractC0813c = new C0818h(this.f686b, this.f688d, this.f689e);
                break;
            case 2:
                abstractC0813c = new C0819i(this.f686b, this.f688d, this.f689e);
                break;
            case 3:
                abstractC0813c = new C0820j(this.f686b, this.f688d, this.f689e);
                break;
            case 4:
                abstractC0813c = new C0811a(this.f686b, this.f688d, this.f689e);
                break;
            case 5:
                abstractC0813c = new C0816f(this.f686b, this.f688d, this.f689e);
                break;
            case 6:
                abstractC0813c = new C0817g(this.f686b, this.f688d, this.f689e);
                break;
        }
        if (abstractC0813c != null) {
            this.f687c.put(crashType, abstractC0813c);
        }
        return abstractC0813c;
    }

    /* renamed from: a */
    public static C0815e m1103a() {
        if (f685a == null) {
            Context m565g = C0749e.m565g();
            if (m565g == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            f685a = new C0815e(m565g);
        }
        return f685a;
    }

    /* renamed from: a */
    public C0745a m1104a(CrashType crashType, C0745a c0745a) {
        AbstractC0813c m1102a;
        return (crashType == null || (m1102a = m1102a(crashType)) == null) ? c0745a : m1102a.m1090a(c0745a, null, false);
    }

    /* renamed from: a */
    public C0745a m1105a(CrashType crashType, C0745a c0745a, AbstractC0813c.a aVar, boolean z) {
        AbstractC0813c m1102a;
        return (crashType == null || (m1102a = m1102a(crashType)) == null) ? c0745a : m1102a.m1090a(c0745a, aVar, z);
    }
}
