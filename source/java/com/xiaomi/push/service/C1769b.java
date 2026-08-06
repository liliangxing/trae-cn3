package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1801v;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* renamed from: com.xiaomi.push.service.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1769b {

    /* renamed from: a */
    private static volatile C1769b f3114a;

    /* renamed from: a */
    private Context f3115a;

    /* renamed from: e */
    private volatile String f3122e;

    /* renamed from: f */
    private volatile String f3123f;

    /* renamed from: a */
    private final Object f3116a = new Object();

    /* renamed from: b */
    private final Object f3118b = new Object();

    /* renamed from: a */
    private final String f3117a = "mipush_region";

    /* renamed from: b */
    private final String f3119b = "mipush_country_code";

    /* renamed from: c */
    private final String f3120c = "mipush_region.lock";

    /* renamed from: d */
    private final String f3121d = "mipush_country_code.lock";

    /* renamed from: a */
    public static C1769b m3796a(Context context) {
        if (f3114a == null) {
            synchronized (C1769b.class) {
                if (f3114a == null) {
                    f3114a = new C1769b(context);
                }
            }
        }
        return f3114a;
    }

    public C1769b(Context context) {
        this.f3115a = context;
    }

    /* renamed from: a */
    public String m3799a() {
        if (TextUtils.isEmpty(this.f3122e)) {
            this.f3122e = m3797a(this.f3115a, "mipush_region", "mipush_region.lock", this.f3116a);
        }
        return this.f3122e;
    }

    /* renamed from: a */
    public void m3800a(String str, boolean z) {
        if (!TextUtils.equals(str, this.f3122e)) {
            this.f3122e = str;
        }
        if (z) {
            m3798a(this.f3115a, str, "mipush_region", "mipush_region.lock", this.f3116a);
        }
    }

    /* renamed from: b */
    public String m3801b() {
        if (TextUtils.isEmpty(this.f3123f)) {
            this.f3123f = m3797a(this.f3115a, "mipush_country_code", "mipush_country_code.lock", this.f3118b);
        }
        return this.f3123f;
    }

    /* renamed from: b */
    public void m3802b(String str, boolean z) {
        if (!TextUtils.equals(str, this.f3123f)) {
            this.f3123f = str;
        }
        if (z) {
            m3798a(this.f3115a, str, "mipush_country_code", "mipush_region.lock", this.f3116a);
        }
    }

    /* renamed from: a */
    private void m3798a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
                    C1801v.m4109a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            C1801v.m4107a(new File(context.getFilesDir(), str2), str);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e) {
                                    AbstractC1417b.m1093a(e);
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            AbstractC1417b.m1093a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    AbstractC1417b.m1093a(e3);
                                }
                            }
                            C1801v.m4105a(randomAccessFile);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                AbstractC1417b.m1093a(e4);
                            }
                        }
                        C1801v.m4105a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                C1801v.m4105a(randomAccessFile);
                throw th;
            }
            C1801v.m4105a(randomAccessFile);
        }
    }

    /* renamed from: a */
    private String m3797a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            AbstractC1417b.m1089a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                C1801v.m4109a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
            } catch (Exception e) {
                e = e;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    try {
                        String m4104a = C1801v.m4104a(file);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                AbstractC1417b.m1093a(e2);
                            }
                        }
                        C1801v.m4105a(randomAccessFile);
                        return m4104a;
                    } catch (Exception e3) {
                        e = e3;
                        AbstractC1417b.m1093a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                AbstractC1417b.m1093a(e4);
                            }
                        }
                        C1801v.m4105a(randomAccessFile);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        try {
                            fileLock2.release();
                        } catch (IOException e5) {
                            AbstractC1417b.m1093a(e5);
                        }
                    }
                    C1801v.m4105a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileLock = null;
            } catch (Throwable th3) {
                th = th3;
                if (fileLock2 != null) {
                    fileLock2.release();
                }
                C1801v.m4105a(randomAccessFile);
                throw th;
            }
        }
    }
}
