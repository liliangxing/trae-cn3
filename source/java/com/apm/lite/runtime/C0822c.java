package com.apm.lite.runtime;

import com.apm.lite.CrashInfoCallback;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.apm.lite.runtime.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0822c {

    /* renamed from: a */
    private final List<ICrashCallback> f693a = new CopyOnWriteArrayList();

    /* renamed from: b */
    private final List<ICrashCallback> f694b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private final List<ICrashCallback> f695c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private final List<ICrashCallback> f696d = new CopyOnWriteArrayList();

    /* renamed from: e */
    private final List<IOOMCallback> f697e = new CopyOnWriteArrayList();

    /* renamed from: f */
    private final List<CrashInfoCallback> f698f = new CopyOnWriteArrayList();

    /* renamed from: com.apm.lite.runtime.c$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f699a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f699a = iArr;
            try {
                iArr[CrashType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f699a[CrashType.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f699a[CrashType.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f699a[CrashType.LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f699a[CrashType.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: a */
    public List<IOOMCallback> m1110a() {
        return this.f697e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1111a(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = AnonymousClass1.f699a[crashType.ordinal()];
        if (i == 1) {
            this.f693a.add(iCrashCallback);
            this.f694b.add(iCrashCallback);
            this.f695c.add(iCrashCallback);
        } else if (i != 2) {
            if (i == 3) {
                list = this.f694b;
            } else if (i == 4) {
                list = this.f693a;
            } else if (i != 5) {
                return;
            } else {
                list = this.f695c;
            }
            list.add(iCrashCallback);
        }
        list = this.f696d;
        list.add(iCrashCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1112a(IOOMCallback iOOMCallback) {
        this.f697e.add(iOOMCallback);
    }

    /* renamed from: b */
    public List<ICrashCallback> m1113b() {
        return this.f693a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m1114b(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = AnonymousClass1.f699a[crashType.ordinal()];
        if (i == 1) {
            this.f693a.remove(iCrashCallback);
            this.f694b.remove(iCrashCallback);
            this.f695c.remove(iCrashCallback);
        } else if (i != 2) {
            if (i == 3) {
                list = this.f694b;
            } else if (i == 4) {
                list = this.f693a;
            } else if (i != 5) {
                return;
            } else {
                list = this.f695c;
            }
            list.remove(iCrashCallback);
        }
        list = this.f696d;
        list.remove(iCrashCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m1115b(IOOMCallback iOOMCallback) {
        this.f697e.remove(iOOMCallback);
    }

    /* renamed from: c */
    public List<ICrashCallback> m1116c() {
        return this.f694b;
    }

    /* renamed from: d */
    public List<ICrashCallback> m1117d() {
        return this.f695c;
    }

    /* renamed from: e */
    public List<ICrashCallback> m1118e() {
        return this.f696d;
    }
}
