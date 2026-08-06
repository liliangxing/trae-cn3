package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.common.applog.AppLog;
import com.ss.android.deviceregister.base.OaidModel;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1471ae;
import com.xiaomi.push.service.C1766ax;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.da */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1548da {

    /* renamed from: a */
    private static volatile C1548da f1286a;

    /* renamed from: a */
    private Context f1287a;

    /* renamed from: a */
    private final ConcurrentLinkedQueue<b> f1288a;

    private C1548da(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f1288a = concurrentLinkedQueue;
        this.f1287a = context;
        concurrentLinkedQueue.add(new a());
        m2013b(0L);
    }

    /* renamed from: a */
    public static C1548da m2007a(Context context) {
        if (f1286a == null) {
            synchronized (C1548da.class) {
                if (f1286a == null) {
                    f1286a = new C1548da(context);
                }
            }
        }
        f1286a.f1287a = context;
        return f1286a;
    }

    /* renamed from: a */
    public void m2016a(final String str, final String str2, final Date date, final Date date2, final int i, final boolean z) {
        this.f1288a.add(new b() { // from class: com.xiaomi.push.da.1

            /* renamed from: a */
            File f1291a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.xiaomi.push.C1548da.b, com.xiaomi.push.C1471ae.b
            /* renamed from: b */
            public void mo1470b() {
                try {
                    File file = new File(C1548da.this.f1287a.getFilesDir() + "/.logcache");
                    if (C1800u.m4103a(file)) {
                        file.mkdirs();
                        if (file.isDirectory()) {
                            C1546cz c1546cz = new C1546cz();
                            c1546cz.m1997a(i);
                            this.f1291a = c1546cz.m1996a(C1548da.this.f1287a, date, date2, file);
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }

            @Override // com.xiaomi.push.C1471ae.b
            /* renamed from: c */
            public void mo1471c() {
                File file = this.f1291a;
                if (file != null && file.exists()) {
                    C1548da.this.f1288a.add(new c(str, str2, this.f1291a, z));
                }
                C1548da.this.m2009a(0L);
            }
        });
        m2013b(0L);
    }

    /* renamed from: a */
    public void m2015a() {
        m2014c();
        m2009a(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.da$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class b extends C1471ae.b {

        /* renamed from: a */
        long f1300a = System.currentTimeMillis();

        /* renamed from: a */
        public boolean mo2017a() {
            return true;
        }

        @Override // com.xiaomi.push.C1471ae.b
        /* renamed from: b */
        public void mo1470b() {
        }

        b() {
        }

        /* renamed from: b */
        final boolean m2018b() {
            return System.currentTimeMillis() - this.f1300a > 172800000;
        }
    }

    /* renamed from: com.xiaomi.push.da$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class c extends b {

        /* renamed from: a */
        int f1302a;

        /* renamed from: a */
        File f1304a;

        /* renamed from: a */
        String f1305a;

        /* renamed from: a */
        boolean f1306a;

        /* renamed from: b */
        String f1307b;

        /* renamed from: b */
        boolean f1308b;

        c(String str, String str2, File file, boolean z) {
            super();
            this.f1305a = str;
            this.f1307b = str2;
            this.f1304a = file;
            this.f1308b = z;
        }

        @Override // com.xiaomi.push.C1548da.b
        /* renamed from: a */
        public boolean mo2017a() {
            return C1486at.m1549d(C1548da.this.f1287a) || (this.f1308b && C1486at.m1545a(C1548da.this.f1287a));
        }

        /* renamed from: c */
        private boolean m2019c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = C1548da.this.f1287a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong(OaidModel.KEY_TIME);
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= DownloadConstants.DAY) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                if (i > 10) {
                    return false;
                }
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(OaidModel.KEY_TIME, currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                AbstractC1417b.m1101c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.C1548da.b, com.xiaomi.push.C1471ae.b
        /* renamed from: b */
        public void mo1470b() {
            try {
                if (m2019c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(AppLog.KEY_UID, C1766ax.m3769a());
                    hashMap.put("token", this.f1307b);
                    hashMap.put("net", C1486at.m1535a(C1548da.this.f1287a));
                    C1486at.m1539a(this.f1305a, hashMap, this.f1304a, "file");
                }
                this.f1306a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.C1471ae.b
        /* renamed from: c */
        public void mo1471c() {
            if (!this.f1306a) {
                int i = this.f1302a + 1;
                this.f1302a = i;
                if (i < 3) {
                    C1548da.this.f1288a.add(this);
                }
            }
            if (this.f1306a || this.f1302a >= 3) {
                this.f1304a.delete();
            }
            C1548da.this.m2009a((1 << this.f1302a) * 1000);
        }
    }

    /* renamed from: com.xiaomi.push.da$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class a extends b {
        a() {
            super();
        }

        @Override // com.xiaomi.push.C1548da.b, com.xiaomi.push.C1471ae.b
        /* renamed from: b */
        public void mo1470b() {
            C1548da.this.m2012b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2012b() {
        try {
            File file = new File(this.f1287a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2009a(long j) {
        b peek = this.f1288a.peek();
        if (peek == null || !peek.mo2017a()) {
            return;
        }
        m2013b(j);
    }

    /* renamed from: b */
    private void m2013b(long j) {
        if (this.f1288a.isEmpty()) {
            return;
        }
        C1625fx.m2652a(new C1471ae.b() { // from class: com.xiaomi.push.da.2

            /* renamed from: a */
            C1471ae.b f1297a;

            @Override // com.xiaomi.push.C1471ae.b
            /* renamed from: b */
            public void mo1470b() {
                b bVar = (b) C1548da.this.f1288a.peek();
                if (bVar == null || !bVar.mo2017a()) {
                    return;
                }
                if (C1548da.this.f1288a.remove(bVar)) {
                    this.f1297a = bVar;
                }
                C1471ae.b bVar2 = this.f1297a;
                if (bVar2 != null) {
                    bVar2.mo1470b();
                }
            }

            @Override // com.xiaomi.push.C1471ae.b
            /* renamed from: c */
            public void mo1471c() {
                C1471ae.b bVar = this.f1297a;
                if (bVar != null) {
                    bVar.mo1471c();
                }
            }
        }, j);
    }

    /* renamed from: c */
    private void m2014c() {
        while (!this.f1288a.isEmpty()) {
            b peek = this.f1288a.peek();
            if (peek != null) {
                if (!peek.m2018b() && this.f1288a.size() <= 6) {
                    return;
                }
                AbstractC1417b.m1101c("remove Expired task");
                this.f1288a.remove(peek);
            }
        }
    }
}
