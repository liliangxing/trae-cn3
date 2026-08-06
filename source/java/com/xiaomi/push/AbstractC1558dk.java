package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.service.C1750ah;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* renamed from: com.xiaomi.push.dk */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1558dk extends C1470ad.a {

    /* renamed from: a */
    protected int f1333a;

    /* renamed from: a */
    protected Context f1334a;

    /* renamed from: a */
    public abstract EnumC1635gg mo2047a();

    /* renamed from: b */
    public abstract String mo2049b();

    /* renamed from: b */
    protected boolean m2050b() {
        return true;
    }

    /* renamed from: c */
    protected boolean m2051c() {
        return false;
    }

    public AbstractC1558dk(Context context, int i) {
        this.f1333a = i;
        this.f1334a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String mo2049b = mo2049b();
        if (TextUtils.isEmpty(mo2049b)) {
            return;
        }
        if (m2048a()) {
            AbstractC1417b.m1089a("DC run job mutual: " + mo2047a());
            return;
        }
        InterfaceC1552de m2028a = C1553df.m2027a().m2028a();
        String mo1310a = m2028a == null ? "" : m2028a.mo1310a();
        if (!TextUtils.isEmpty(mo1310a) && m2050b()) {
            if (m2051c()) {
                SharedPreferences sharedPreferences = this.f1334a.getSharedPreferences("mipush_extra", 0);
                if (C1494ba.m1625a(mo2049b).equals(sharedPreferences.getString(m2046d(), null))) {
                    long j = sharedPreferences.getLong(m2045c(), 0L);
                    int m3678a = C1750ah.m3674a(this.f1334a).m3678a(EnumC1638gj.DCJobUploadRepeatedInterval.m2760a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.f1333a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < m3678a) {
                        mo2049b = "same_" + j;
                    }
                }
            }
            C1641gm c1641gm = new C1641gm();
            c1641gm.m2767a(mo2049b);
            c1641gm.m2765a(System.currentTimeMillis());
            c1641gm.m2766a(mo2047a());
            m2044a(this.f1334a, c1641gm, mo1310a);
        }
    }

    /* renamed from: a */
    protected boolean m2048a() {
        return C1555dh.m2032a(this.f1334a, String.valueOf(mo2047a()), this.f1333a);
    }

    /* renamed from: a */
    public static void m2043a(Context context, C1641gm c1641gm) {
        InterfaceC1552de m2028a = C1553df.m2027a().m2028a();
        String mo1310a = m2028a == null ? "" : m2028a.mo1310a();
        if (TextUtils.isEmpty(mo1310a) || TextUtils.isEmpty(c1641gm.m2768a())) {
            return;
        }
        m2044a(context, c1641gm, mo1310a);
    }

    /* renamed from: a */
    private static void m2044a(Context context, C1641gm c1641gm, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] m2034b = C1555dh.m2034b(str, C1670ho.m3313a(c1641gm));
        if (m2034b == null || m2034b.length == 0) {
            return;
        }
        synchronized (C1556di.f1326a) {
            FileLock fileLock = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            fileLock = null;
            fileLock = null;
            fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), "push_cdata.lock");
                    C1801v.m4109a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            File file2 = new File(context.getFilesDir(), "push_cdata.data");
                            if (C1800u.m4103a(file2)) {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                                try {
                                    bufferedOutputStream.write(C1803x.m4118a(m2034b.length));
                                    bufferedOutputStream.write(m2034b);
                                    bufferedOutputStream.flush();
                                    file2.setLastModified(0L);
                                    bufferedOutputStream2 = bufferedOutputStream;
                                } catch (IOException e) {
                                    e = e;
                                    fileLock = lock;
                                    try {
                                        e.printStackTrace();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        C1801v.m4105a(bufferedOutputStream);
                                        C1801v.m4105a(randomAccessFile);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        C1801v.m4105a(bufferedOutputStream);
                                        C1801v.m4105a(randomAccessFile);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileLock = lock;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    C1801v.m4105a(bufferedOutputStream);
                                    C1801v.m4105a(randomAccessFile);
                                    throw th;
                                }
                            }
                            if (lock != null && lock.isValid()) {
                                try {
                                    lock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            C1801v.m4105a(bufferedOutputStream2);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
                randomAccessFile = null;
            }
            C1801v.m4105a(randomAccessFile);
        }
    }

    /* renamed from: c */
    private String m2045c() {
        return "dc_job_result_time_" + mo2047a();
    }

    /* renamed from: d */
    private String m2046d() {
        return "dc_job_result_" + mo2047a();
    }
}
