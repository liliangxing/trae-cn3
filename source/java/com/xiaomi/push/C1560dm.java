package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.lynx.tasm.utils.LynxConstants;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.PushClient;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.service.C1750ah;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.dm */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1560dm extends C1470ad.a {

    /* renamed from: a */
    private Context f1335a;

    /* renamed from: a */
    private SharedPreferences f1336a;

    /* renamed from: a */
    private C1750ah f1337a;

    @Override // com.xiaomi.push.C1470ad.a
    /* renamed from: a */
    public String mo1133a() {
        return PushClient.DEFAULT_REQUEST_ID;
    }

    public C1560dm(Context context) {
        this.f1335a = context;
        this.f1336a = context.getSharedPreferences("mipush_extra", 0);
        this.f1337a = C1750ah.m3674a(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f1335a.getFilesDir(), "push_cdata.data");
        if (!C1486at.m1548c(this.f1335a)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!m2055a() && file.exists()) {
            List<C1641gm> m2052a = m2052a(file);
            if (!C1804y.m4119a(m2052a)) {
                int size = m2052a.size();
                if (size > 4000) {
                    m2052a = m2052a.subList(size + AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo, size);
                }
                C1652gx c1652gx = new C1652gx();
                c1652gx.m2959a(m2052a);
                byte[] m4111a = C1801v.m4111a(C1670ho.m3313a(c1652gx));
                C1659hd c1659hd = new C1659hd(LynxConstants.LYNX_DEFAULT_COMPONENT_ID, false);
                c1659hd.m3064c(EnumC1643go.DataCollection.f2208a);
                c1659hd.m3051a(m4111a);
                InterfaceC1552de m2028a = C1553df.m2027a().m2028a();
                if (m2028a != null) {
                    m2028a.mo1311a(c1659hd, EnumC1633ge.Notification, null);
                }
                m2053a();
            }
            file.delete();
        }
    }

    /* renamed from: a */
    private boolean m2055a() {
        if (C1486at.m1549d(this.f1335a)) {
            return false;
        }
        if ((C1486at.m1551f(this.f1335a) || C1486at.m1550e(this.f1335a)) && !m2057c()) {
            return true;
        }
        return (C1486at.m1552g(this.f1335a) && !m2056b()) || C1486at.m1553h(this.f1335a);
    }

    /* renamed from: b */
    private boolean m2056b() {
        if (!this.f1337a.m3686a(EnumC1638gj.Upload3GSwitch.m2760a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f1336a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(Constants.MAX_RETRY_AFTER, this.f1337a.m3678a(EnumC1638gj.Upload3GFrequency.m2760a(), 432000)));
    }

    /* renamed from: c */
    private boolean m2057c() {
        if (!this.f1337a.m3686a(EnumC1638gj.Upload4GSwitch.m2760a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f1336a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(Constants.MAX_RETRY_AFTER, this.f1337a.m3678a(EnumC1638gj.Upload4GFrequency.m2760a(), 259200)));
    }

    /* renamed from: a */
    private void m2053a() {
        SharedPreferences.Editor edit = this.f1336a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a */
    private List<C1641gm> m2052a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        InterfaceC1552de m2028a = C1553df.m2027a().m2028a();
        String mo1310a = m2028a == null ? "" : m2028a.mo1310a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(mo1310a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (C1556di.f1326a) {
            try {
                File file2 = new File(this.f1335a.getFilesDir(), "push_cdata.lock");
                C1801v.m4109a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int m4117a = C1803x.m4117a(bArr);
                                byte[] bArr2 = new byte[m4117a];
                                if (fileInputStream.read(bArr2) != m4117a) {
                                    break;
                                }
                                byte[] m2033a = C1555dh.m2033a(mo1310a, bArr2);
                                if (m2033a != null && m2033a.length != 0) {
                                    C1641gm c1641gm = new C1641gm();
                                    C1670ho.m3312a(c1641gm, m2033a);
                                    arrayList.add(c1641gm);
                                    m2054a(c1641gm);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                C1801v.m4105a((Closeable) fileInputStream);
                                C1801v.m4105a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                C1801v.m4105a((Closeable) fileInputStream);
                                C1801v.m4105a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        C1801v.m4105a((Closeable) fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            C1801v.m4105a(randomAccessFile);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m2054a(C1641gm c1641gm) {
        if (c1641gm.f2135a != EnumC1635gg.AppInstallList || c1641gm.f2136a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f1336a.edit();
        edit.putLong("dc_job_result_time_4", c1641gm.f2134a);
        edit.putString("dc_job_result_4", C1494ba.m1625a(c1641gm.f2136a));
        edit.commit();
    }
}
