package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1770ba;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

/* renamed from: com.xiaomi.push.ga */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1629ga {

    /* renamed from: a */
    private static boolean f1886a;

    /* renamed from: a */
    public static void m2698a(Context context, InterfaceC1632gd interfaceC1632gd) {
        C1470ad.m1444a(context).m1449a(new a(context, interfaceC1632gd));
    }

    /* renamed from: com.xiaomi.push.ga$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class a implements Runnable {

        /* renamed from: a */
        private Context f1887a;

        /* renamed from: a */
        private InterfaceC1632gd f1888a;

        public a(Context context, InterfaceC1632gd interfaceC1632gd) {
            this.f1888a = interfaceC1632gd;
            this.f1887a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1629ga.m2702c(this.f1887a, this.f1888a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2702c(Context context, InterfaceC1632gd interfaceC1632gd) {
        RandomAccessFile randomAccessFile;
        File file;
        if (!f1886a) {
            f1886a = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                AbstractC1417b.m1089a("TinyData no ready file to get data.");
                return;
            }
            m2697a(context);
            byte[] m3804a = C1770ba.m3804a(context);
            FileLock fileLock = null;
            try {
                try {
                    File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                    C1801v.m4109a(file3);
                    randomAccessFile = new RandomAccessFile(file3, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e) {
                                e = e;
                                AbstractC1417b.m1093a(e);
                                C1801v.m4105a(randomAccessFile);
                                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                                if (file.exists()) {
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        AbstractC1417b.m1093a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                e = e3;
                                AbstractC1417b.m1093a(e);
                                C1801v.m4105a(randomAccessFile);
                                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                                if (file.exists()) {
                                }
                            }
                        }
                        C1801v.m4105a(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                        if (file.exists()) {
                        }
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
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                C1801v.m4105a(randomAccessFile);
                throw th;
            }
            C1801v.m4105a(randomAccessFile);
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                AbstractC1417b.m1089a("TinyData no ready file to get data.");
                return;
            }
            m2699a(context, interfaceC1632gd, file, m3804a);
            C1627fz.m2672a(false);
            m2700b(context);
            f1886a = false;
            return;
        }
        AbstractC1417b.m1089a("TinyData extractTinyData is running");
    }

    /* renamed from: a */
    private static void m2699a(Context context, InterfaceC1632gd interfaceC1632gd, File file, byte[] bArr) {
        int m4117a;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                loop0: while (true) {
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream2.read(bArr2);
                            if (read == -1) {
                                break loop0;
                            }
                            if (read != 4) {
                                AbstractC1417b.m1103d("TinyData read from cache file failed cause lengthBuffer error. size:" + read);
                                break loop0;
                            }
                            m4117a = C1803x.m4117a(bArr2);
                            if (m4117a < 1 || m4117a > 30720) {
                                break loop0;
                            }
                            byte[] bArr3 = new byte[m4117a];
                            int read2 = bufferedInputStream2.read(bArr3);
                            if (read2 != m4117a) {
                                AbstractC1417b.m1103d("TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + m4117a);
                                break loop0;
                            }
                            byte[] m3006a = C1655h.m3006a(bArr, bArr3);
                            if (m3006a != null && m3006a.length != 0) {
                                C1637gi c1637gi = new C1637gi();
                                C1670ho.m3312a(c1637gi, m3006a);
                                c1637gi.m2733a("item_size", String.valueOf(m3006a.length));
                                arrayList.add(c1637gi);
                                i++;
                                i2 += m3006a.length;
                                if (i >= 8 || i2 >= 30720) {
                                }
                            }
                            AbstractC1417b.m1103d("TinyData read from cache file failed cause decrypt fail");
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            AbstractC1417b.m1093a(e);
                            C1801v.m4105a((Closeable) bufferedInputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            C1801v.m4105a((Closeable) bufferedInputStream);
                            throw th;
                        }
                    }
                    C1630gb.m2705a(context, interfaceC1632gd, arrayList);
                    arrayList.clear();
                }
                AbstractC1417b.m1103d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + m4117a);
                C1630gb.m2705a(context, interfaceC1632gd, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    AbstractC1417b.m1089a("TinyData delete reading temp file failed");
                }
                C1801v.m4105a((Closeable) bufferedInputStream2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private static void m2697a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* renamed from: b */
    private static void m2700b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }
}
