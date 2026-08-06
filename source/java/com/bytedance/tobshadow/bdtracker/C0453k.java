package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.sync.SyncConstants;
import com.bytedance.tobshadow.applog.AppLog;
import com.bytedance.tobshadow.applog.IAppLogInstance;
import java.util.Iterator;

/* renamed from: com.bytedance.tobshadow.bdtracker.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0453k {

    /* renamed from: a */
    public static e f710a = new a();

    /* renamed from: b */
    public static e f711b = new b();

    /* renamed from: c */
    public static e f712c = new c();

    /* renamed from: com.bytedance.tobshadow.bdtracker.k$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a implements e {
        @Override // com.bytedance.tobshadow.bdtracker.C0453k.e
        /* renamed from: a */
        public boolean mo248a(C0467m c0467m) {
            return c0467m.isH5CollectEnable();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.k$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class b implements e {
        @Override // com.bytedance.tobshadow.bdtracker.C0453k.e
        /* renamed from: a */
        public boolean mo248a(C0467m c0467m) {
            return c0467m.getInitConfig() != null && c0467m.getInitConfig().isHandleLifeCycle();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.k$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class c implements e {
        @Override // com.bytedance.tobshadow.bdtracker.C0453k.e
        /* renamed from: a */
        public boolean mo248a(C0467m c0467m) {
            return !(c0467m.getInitConfig() != null && c0467m.getInitConfig().isPageMetaAnnotationEnable());
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.k$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface d {
        /* renamed from: a */
        void mo499a(C0467m c0467m);
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.k$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface e {
        /* renamed from: a */
        boolean mo248a(C0467m c0467m);
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.k$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface f {
        /* renamed from: a */
        AbstractC0479n4 mo250a();
    }

    /* renamed from: a */
    public static C0467m m491a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (C0467m c0467m : C0467m.f759L) {
            if (str.equals(c0467m.f784m)) {
                return c0467m;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m498b(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<C0467m> it = C0467m.f759L.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (str.equals(it.next().f784m)) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static String m492a(IAppLogInstance iAppLogInstance, String str) {
        return AppLog.getInstance() == iAppLogInstance ? str : str + SyncConstants.SEPARATOR + iAppLogInstance.getAppId();
    }

    /* renamed from: a */
    public static void m493a(d dVar) {
        Iterator<C0467m> it = C0467m.f759L.iterator();
        while (it.hasNext()) {
            dVar.mo499a(it.next());
        }
    }

    /* renamed from: a */
    public static boolean m497a(e eVar) {
        Iterator<C0467m> it = C0467m.f759L.iterator();
        while (it.hasNext()) {
            if (eVar.mo248a(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m496a(String[] strArr) {
        Iterator<C0467m> it = C0467m.f759L.iterator();
        while (it.hasNext()) {
            it.next().receive((String[]) strArr.clone());
        }
    }

    /* renamed from: a */
    public static void m494a(f fVar, e eVar) {
        AbstractC0479n4 abstractC0479n4 = null;
        for (C0467m c0467m : C0467m.f759L) {
            if (eVar.mo248a(c0467m)) {
                if (abstractC0479n4 == null) {
                    abstractC0479n4 = fVar.mo250a();
                }
                c0467m.receive(abstractC0479n4.m1094clone());
            }
        }
    }

    /* renamed from: a */
    public static void m495a(AbstractC0479n4 abstractC0479n4, e eVar) {
        for (C0467m c0467m : C0467m.f759L) {
            if (eVar.mo248a(c0467m)) {
                c0467m.receive(abstractC0479n4.m1094clone());
            }
        }
    }
}
