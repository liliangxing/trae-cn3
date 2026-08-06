package com.apm.lite.runtime;

import com.apm.lite.CrashInfoCallback;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class c {
    private final List<ICrashCallback> a = new CopyOnWriteArrayList();
    private final List<ICrashCallback> b = new CopyOnWriteArrayList();
    private final List<ICrashCallback> c = new CopyOnWriteArrayList();
    private final List<ICrashCallback> d = new CopyOnWriteArrayList();
    private final List<IOOMCallback> e = new CopyOnWriteArrayList();
    private final List<CrashInfoCallback> f = new CopyOnWriteArrayList();

    /* renamed from: com.apm.lite.runtime.c$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CrashType.values().length];
            a = iArr;
            try {
                iArr[CrashType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CrashType.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CrashType.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CrashType.LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CrashType.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public List<IOOMCallback> a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = AnonymousClass1.a[crashType.ordinal()];
        if (i == 1) {
            this.a.add(iCrashCallback);
            this.b.add(iCrashCallback);
            this.c.add(iCrashCallback);
        } else if (i != 2) {
            if (i == 3) {
                list = this.b;
            } else if (i == 4) {
                list = this.a;
            } else if (i != 5) {
                return;
            } else {
                list = this.c;
            }
            list.add(iCrashCallback);
        }
        list = this.d;
        list.add(iCrashCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(IOOMCallback iOOMCallback) {
        this.e.add(iOOMCallback);
    }

    public List<ICrashCallback> b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = AnonymousClass1.a[crashType.ordinal()];
        if (i == 1) {
            this.a.remove(iCrashCallback);
            this.b.remove(iCrashCallback);
            this.c.remove(iCrashCallback);
        } else if (i != 2) {
            if (i == 3) {
                list = this.b;
            } else if (i == 4) {
                list = this.a;
            } else if (i != 5) {
                return;
            } else {
                list = this.c;
            }
            list.remove(iCrashCallback);
        }
        list = this.d;
        list.remove(iCrashCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(IOOMCallback iOOMCallback) {
        this.e.remove(iOOMCallback);
    }

    public List<ICrashCallback> c() {
        return this.b;
    }

    public List<ICrashCallback> d() {
        return this.c;
    }

    public List<ICrashCallback> e() {
        return this.d;
    }
}
