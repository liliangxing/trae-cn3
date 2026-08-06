package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.ad;
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

/* loaded from: classes7.dex */
public class bv {
    private static volatile bv a;

    /* renamed from: a, reason: collision with other field name */
    private Context f217a;

    /* renamed from: a, reason: collision with other field name */
    private bu f218a;

    /* renamed from: a, reason: collision with other field name */
    private final HashMap<String, bt> f220a = new HashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f221a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f219a = new ArrayList<>();

    private bv(Context context) {
        this.f217a = context;
    }

    public static bv a(Context context) {
        if (a == null) {
            synchronized (bv.class) {
                if (a == null) {
                    a = new bv(context);
                }
            }
        }
        return a;
    }

    private void a() {
        ad.a(this.f217a).b(new ad.a() { // from class: com.xiaomi.push.bv.1
            @Override // com.xiaomi.push.ad.a
            /* renamed from: a */
            public String mo9661a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (bv.this.f219a) {
                    if (bv.this.f219a.size() > 0) {
                        if (bv.this.f219a.size() > 1) {
                            bv bvVar = bv.this;
                            bvVar.a(bvVar.f219a);
                        } else {
                            bv bvVar2 = bv.this;
                            bvVar2.b((a) bvVar2.f219a.get(0));
                        }
                        bv.this.f219a.clear();
                        System.gc();
                    }
                }
            }
        }, com.xiaomi.push.service.ah.a(this.f217a).a(gj.StatDataProcessFrequency.a(), 5));
    }

    public void a(a aVar) {
        bt btVar;
        if (aVar == null) {
            return;
        }
        if (this.f218a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m9672a = aVar.m9672a();
        synchronized (this.f220a) {
            btVar = this.f220a.get(m9672a);
            if (btVar == null) {
                btVar = this.f218a.a(this.f217a, m9672a);
                this.f220a.put(m9672a, btVar);
            }
        }
        if (this.f221a.isShutdown()) {
            return;
        }
        aVar.a(btVar, this.f217a);
        synchronized (this.f219a) {
            this.f219a.add(aVar);
            a();
        }
    }

    public void b(a aVar) {
        bt btVar;
        if (aVar == null) {
            return;
        }
        if (this.f218a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m9672a = aVar.m9672a();
        synchronized (this.f220a) {
            btVar = this.f220a.get(m9672a);
            if (btVar == null) {
                btVar = this.f218a.a(this.f217a, m9672a);
                this.f220a.put(m9672a, btVar);
            }
        }
        if (this.f221a.isShutdown()) {
            return;
        }
        aVar.a(btVar, this.f217a);
        a((Runnable) aVar);
    }

    public void a(Runnable runnable) {
        if (this.f221a.isShutdown()) {
            return;
        }
        this.f221a.execute(runnable);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m9670a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f218a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f221a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m9673a()) {
                next.a(a(next.m9672a()), this.f217a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m9672a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m9672a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f222a, this.f217a);
                this.f221a.execute(cVar);
            }
        }
    }

    private bt a(String str) {
        bt btVar = this.f220a.get(str);
        if (btVar == null) {
            synchronized (this.f220a) {
                if (btVar == null) {
                    btVar = this.f218a.a(this.f217a, str);
                    this.f220a.put(str, btVar);
                }
            }
        }
        return btVar;
    }

    /* loaded from: classes7.dex */
    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.bv.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with other field name */
        private a f223a;

        /* renamed from: a, reason: collision with other field name */
        private String f224a;

        /* renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f225a;
        protected String b;

        /* renamed from: a, reason: collision with other field name */
        protected bt f222a = null;

        /* renamed from: a, reason: collision with other field name */
        private Random f226a = new Random();
        private int a = 0;

        /* renamed from: a, reason: collision with other method in class */
        public Object mo9671a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void b(Context context) {
        }

        public a(String str) {
            this.f224a = str;
        }

        void a(bt btVar, Context context) {
            this.f222a = btVar;
            this.b = btVar.a();
            this.f225a = new WeakReference<>(context);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m9673a() {
            return this.f222a == null || TextUtils.isEmpty(this.b) || this.f225a == null;
        }

        public void a(a aVar) {
            this.f223a = aVar;
        }

        public void a(Context context, Object obj) {
            bv.a(context).a(this);
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m9672a() {
            return this.f224a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f225a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f222a == null || TextUtils.isEmpty(this.f224a)) {
                return;
            }
            File file = new File(this.f224a);
            t.a(context, new File(file.getParentFile(), az.b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bv.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SQLiteDatabase sQLiteDatabase = null;
                    try {
                        try {
                            sQLiteDatabase = a.this.a();
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.beginTransaction();
                                a.this.a(context, sQLiteDatabase);
                                sQLiteDatabase.setTransactionSuccessful();
                            }
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e) {
                                    e = e;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                    a.this.a(context);
                                }
                            }
                            if (a.this.f222a != null) {
                                a.this.f222a.close();
                            }
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    a.this.a(context);
                                    throw th;
                                }
                            }
                            if (a.this.f222a != null) {
                                a.this.f222a.close();
                            }
                            a.this.a(context);
                            throw th;
                        }
                    } catch (Exception e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Exception e4) {
                                e = e4;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                a.this.a(context);
                            }
                        }
                        if (a.this.f222a != null) {
                            a.this.f222a.close();
                        }
                    }
                    a.this.a(context);
                }
            });
        }

        public SQLiteDatabase a() {
            return this.f222a.getWritableDatabase();
        }

        void a(Context context) {
            a aVar = this.f223a;
            if (aVar != null) {
                aVar.a(context, mo9671a());
            }
            b(context);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a, reason: collision with other field name */
        private String f228a;

        /* renamed from: a, reason: collision with other field name */
        private List<String> f229a;

        /* renamed from: a, reason: collision with other field name */
        private String[] f230a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public abstract T a(Context context, Cursor cursor);

        public abstract void a(Context context, List<T> list);

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f229a = list;
            this.f228a = str2;
            this.f230a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            if (r14.moveToFirst() != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        
            r0 = a(r13, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        
            if (r0 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        
            r12.b.add(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        
            if (r14.moveToNext() != false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        
            r14.close();
         */
        @Override // com.xiaomi.push.bv.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f229a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f229a.size()];
                this.f229a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.a;
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f228a, this.f230a, this.c, this.d, this.e, i > 0 ? String.valueOf(i) : null);
            if (query != null) {
            }
            a(context, (List) this.b);
        }

        @Override // com.xiaomi.push.bv.a
        public SQLiteDatabase a() {
            return this.f222a.getReadableDatabase();
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends a {
        private String a;

        /* renamed from: a, reason: collision with other field name */
        protected String[] f231a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f231a = strArr;
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f231a);
        }
    }
}
