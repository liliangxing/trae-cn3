package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.service.C1750ah;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.bv */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1515bv {

    /* renamed from: a */
    private static volatile C1515bv f1101a;

    /* renamed from: a */
    private Context f1102a;

    /* renamed from: a */
    private AbstractC1514bu f1103a;

    /* renamed from: a */
    private final HashMap<String, AbstractC1513bt> f1105a = new HashMap<>();

    /* renamed from: a */
    private ThreadPoolExecutor f1106a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    private final ArrayList<a> f1104a = new ArrayList<>();

    private C1515bv(Context context) {
        this.f1102a = context;
    }

    /* renamed from: a */
    public static C1515bv m1703a(Context context) {
        if (f1101a == null) {
            synchronized (C1515bv.class) {
                if (f1101a == null) {
                    f1101a = new C1515bv(context);
                }
            }
        }
        return f1101a;
    }

    /* renamed from: a */
    private void m1705a() {
        C1470ad.m1444a(this.f1102a).m1456b(new C1470ad.a() { // from class: com.xiaomi.push.bv.1
            @Override // com.xiaomi.push.C1470ad.a
            /* renamed from: a */
            public String mo1133a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (C1515bv.this.f1104a) {
                    if (C1515bv.this.f1104a.size() > 0) {
                        if (C1515bv.this.f1104a.size() > 1) {
                            C1515bv c1515bv = C1515bv.this;
                            c1515bv.m1709a(c1515bv.f1104a);
                        } else {
                            C1515bv c1515bv2 = C1515bv.this;
                            c1515bv2.m1710b((a) c1515bv2.f1104a.get(0));
                        }
                        C1515bv.this.f1104a.clear();
                        System.gc();
                    }
                }
            }
        }, C1750ah.m3674a(this.f1102a).m3678a(EnumC1638gj.StatDataProcessFrequency.m2760a(), 5));
    }

    /* renamed from: a */
    public void m1707a(a aVar) {
        AbstractC1513bt abstractC1513bt;
        if (aVar == null) {
            return;
        }
        if (this.f1103a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m1712a = aVar.m1712a();
        synchronized (this.f1105a) {
            abstractC1513bt = this.f1105a.get(m1712a);
            if (abstractC1513bt == null) {
                abstractC1513bt = this.f1103a.m1701a(this.f1102a, m1712a);
                this.f1105a.put(m1712a, abstractC1513bt);
            }
        }
        if (this.f1106a.isShutdown()) {
            return;
        }
        aVar.m1715a(abstractC1513bt, this.f1102a);
        synchronized (this.f1104a) {
            this.f1104a.add(aVar);
            m1705a();
        }
    }

    /* renamed from: b */
    public void m1710b(a aVar) {
        AbstractC1513bt abstractC1513bt;
        if (aVar == null) {
            return;
        }
        if (this.f1103a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m1712a = aVar.m1712a();
        synchronized (this.f1105a) {
            abstractC1513bt = this.f1105a.get(m1712a);
            if (abstractC1513bt == null) {
                abstractC1513bt = this.f1103a.m1701a(this.f1102a, m1712a);
                this.f1105a.put(m1712a, abstractC1513bt);
            }
        }
        if (this.f1106a.isShutdown()) {
            return;
        }
        aVar.m1715a(abstractC1513bt, this.f1102a);
        m1708a((Runnable) aVar);
    }

    /* renamed from: a */
    public void m1708a(Runnable runnable) {
        if (this.f1106a.isShutdown()) {
            return;
        }
        this.f1106a.execute(runnable);
    }

    /* renamed from: a */
    public String m1706a(String str) {
        return m1702a(str).m1700a();
    }

    /* renamed from: a */
    public void m1709a(ArrayList<a> arrayList) {
        if (this.f1103a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f1106a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m1717a()) {
                next.m1715a(m1702a(next.m1712a()), this.f1102a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m1712a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m1712a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.m1715a(((a) arrayList3.get(0)).f1109a, this.f1102a);
                this.f1106a.execute(cVar);
            }
        }
    }

    /* renamed from: a */
    private AbstractC1513bt m1702a(String str) {
        AbstractC1513bt abstractC1513bt = this.f1105a.get(str);
        if (abstractC1513bt == null) {
            synchronized (this.f1105a) {
                if (abstractC1513bt == null) {
                    abstractC1513bt = this.f1103a.m1701a(this.f1102a, str);
                    this.f1105a.put(str, abstractC1513bt);
                }
            }
        }
        return abstractC1513bt;
    }

    /* renamed from: com.xiaomi.push.bv$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class c extends a {

        /* renamed from: a */
        private ArrayList<a> f1125a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f1125a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.C1515bv.a
        /* renamed from: a */
        public void mo1714a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f1125a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.mo1714a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.C1515bv.a
        /* renamed from: a */
        public final void mo1713a(Context context) {
            super.mo1713a(context);
            Iterator<a> it = this.f1125a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.mo1713a(context);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.bv$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a */
        private a f1110a;

        /* renamed from: a */
        private String f1111a;

        /* renamed from: a */
        private WeakReference<Context> f1112a;

        /* renamed from: b */
        protected String f1114b;

        /* renamed from: a */
        protected AbstractC1513bt f1109a = null;

        /* renamed from: a */
        private Random f1113a = new Random();

        /* renamed from: a */
        private int f1108a = 0;

        /* renamed from: a */
        public Object mo1696a() {
            return null;
        }

        /* renamed from: a */
        public abstract void mo1714a(Context context, SQLiteDatabase sQLiteDatabase);

        /* renamed from: b */
        public void m1718b(Context context) {
        }

        public a(String str) {
            this.f1111a = str;
        }

        /* renamed from: a */
        void m1715a(AbstractC1513bt abstractC1513bt, Context context) {
            this.f1109a = abstractC1513bt;
            this.f1114b = abstractC1513bt.m1700a();
            this.f1112a = new WeakReference<>(context);
        }

        /* renamed from: a */
        public boolean m1717a() {
            return this.f1109a == null || TextUtils.isEmpty(this.f1114b) || this.f1112a == null;
        }

        /* renamed from: a */
        public void m1716a(a aVar) {
            this.f1110a = aVar;
        }

        /* renamed from: a */
        public void mo1693a(Context context, Object obj) {
            C1515bv.m1703a(context).m1707a(this);
        }

        /* renamed from: a */
        public String m1712a() {
            return this.f1111a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f1112a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f1109a == null || TextUtils.isEmpty(this.f1111a)) {
                return;
            }
            File file = new File(this.f1111a);
            AbstractRunnableC1799t.m4100a(context, new File(file.getParentFile(), C1492az.m1597b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bv.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SQLiteDatabase sQLiteDatabase = null;
                    try {
                        try {
                            sQLiteDatabase = a.this.mo1711a();
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.beginTransaction();
                                a.this.mo1714a(context, sQLiteDatabase);
                                sQLiteDatabase.setTransactionSuccessful();
                            }
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e) {
                                    e = e;
                                    AbstractC1417b.m1093a(e);
                                    a.this.mo1713a(context);
                                }
                            }
                            if (a.this.f1109a != null) {
                                a.this.f1109a.close();
                            }
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e2) {
                                    AbstractC1417b.m1093a(e2);
                                    a.this.mo1713a(context);
                                    throw th;
                                }
                            }
                            if (a.this.f1109a != null) {
                                a.this.f1109a.close();
                            }
                            a.this.mo1713a(context);
                            throw th;
                        }
                    } catch (Exception e3) {
                        AbstractC1417b.m1093a(e3);
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Exception e4) {
                                e = e4;
                                AbstractC1417b.m1093a(e);
                                a.this.mo1713a(context);
                            }
                        }
                        if (a.this.f1109a != null) {
                            a.this.f1109a.close();
                        }
                    }
                    a.this.mo1713a(context);
                }
            });
        }

        /* renamed from: a */
        public SQLiteDatabase mo1711a() {
            return this.f1109a.getWritableDatabase();
        }

        /* renamed from: a */
        void mo1713a(Context context) {
            a aVar = this.f1110a;
            if (aVar != null) {
                aVar.mo1693a(context, mo1696a());
            }
            m1718b(context);
        }
    }

    /* renamed from: com.xiaomi.push.bv$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a */
        private int f1117a;

        /* renamed from: a */
        private String f1118a;

        /* renamed from: a */
        private List<String> f1119a;

        /* renamed from: a */
        private String[] f1120a;

        /* renamed from: b */
        private List<T> f1121b;

        /* renamed from: c */
        private String f1122c;

        /* renamed from: d */
        private String f1123d;

        /* renamed from: e */
        private String f1124e;

        /* renamed from: a */
        public abstract T mo1695a(Context context, Cursor cursor);

        /* renamed from: a */
        public abstract void mo1697a(Context context, List<T> list);

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f1121b = new ArrayList();
            this.f1119a = list;
            this.f1118a = str2;
            this.f1120a = strArr;
            this.f1122c = str3;
            this.f1123d = str4;
            this.f1124e = str5;
            this.f1117a = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            if (r14.moveToFirst() != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        
            r0 = mo1695a(r13, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        
            if (r0 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        
            r12.f1121b.add(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        
            if (r14.moveToNext() != false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        
            r14.close();
         */
        @Override // com.xiaomi.push.C1515bv.a
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo1714a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f1121b.clear();
            List<String> list = this.f1119a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f1119a.size()];
                this.f1119a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.f1117a;
            Cursor query = sQLiteDatabase.query(this.f1114b, strArr, this.f1118a, this.f1120a, this.f1122c, this.f1123d, this.f1124e, i > 0 ? String.valueOf(i) : null);
            if (query != null) {
            }
            mo1697a(context, (List) this.f1121b);
        }

        @Override // com.xiaomi.push.C1515bv.a
        /* renamed from: a */
        public SQLiteDatabase mo1711a() {
            return this.f1109a.getReadableDatabase();
        }
    }

    /* renamed from: com.xiaomi.push.bv$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class e extends a {

        /* renamed from: a */
        private ContentValues f1128a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f1128a = contentValues;
        }

        @Override // com.xiaomi.push.C1515bv.a
        /* renamed from: a */
        public void mo1714a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f1114b, null, this.f1128a);
        }
    }

    /* renamed from: com.xiaomi.push.bv$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class d extends a {

        /* renamed from: a */
        private String f1126a;

        /* renamed from: a */
        protected String[] f1127a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f1126a = str2;
            this.f1127a = strArr;
        }

        @Override // com.xiaomi.push.C1515bv.a
        /* renamed from: a */
        public void mo1714a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f1114b, this.f1126a, this.f1127a);
        }
    }
}
