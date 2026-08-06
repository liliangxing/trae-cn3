package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1490ax;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1655h;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1698n;
import com.xiaomi.push.C1801v;
import com.xiaomi.push.C1803x;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* renamed from: com.xiaomi.push.service.ba */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1770ba {

    /* renamed from: a */
    public static final Object f3124a = new Object();

    /* renamed from: a */
    public static void m3803a(final Context context, final C1637gi c1637gi) {
        if (C1768az.m3795a(c1637gi.m2750e())) {
            C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.service.ba.1
                @Override // java.lang.Runnable
                public void run() {
                    RandomAccessFile randomAccessFile;
                    synchronized (C1770ba.f3124a) {
                        FileLock fileLock = null;
                        try {
                            try {
                                File file = new File(context.getFilesDir(), "tiny_data.lock");
                                C1801v.m4109a(file);
                                randomAccessFile = new RandomAccessFile(file, "rw");
                                try {
                                    try {
                                        fileLock = randomAccessFile.getChannel().lock();
                                        C1770ba.m3807c(context, c1637gi);
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
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /* renamed from: c */
    public static void m3807c(Context context, C1637gi c1637gi) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? r0 = "TinyData write to cache file failed case too much data content item:";
        try {
            try {
                byte[] m3007b = C1655h.m3007b(m3804a(context), C1670ho.m3313a(c1637gi));
                if (m3007b != null && m3007b.length >= 1) {
                    if (m3007b.length > 30720) {
                        AbstractC1417b.m1089a("TinyData write to cache file failed case too much data content item:" + c1637gi.m2747d() + "  ts:" + System.currentTimeMillis());
                        C1801v.m4105a((Closeable) null);
                        C1801v.m4105a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(C1803x.m4118a(m3007b.length));
                        bufferedOutputStream3.write(m3007b);
                        bufferedOutputStream3.flush();
                        C1801v.m4105a((Closeable) null);
                        C1801v.m4105a(bufferedOutputStream3);
                        return;
                    } catch (IOException e) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e;
                        AbstractC1417b.m1091a("TinyData write to cache file failed cause io exception item:" + c1637gi.m2747d(), e);
                        r0 = bufferedOutputStream2;
                        C1801v.m4105a((Closeable) null);
                        C1801v.m4105a((Closeable) r0);
                        return;
                    } catch (Exception e2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e2;
                        AbstractC1417b.m1091a("TinyData write to cache file  failed item:" + c1637gi.m2747d(), e);
                        r0 = bufferedOutputStream;
                        C1801v.m4105a((Closeable) null);
                        C1801v.m4105a((Closeable) r0);
                        return;
                    } catch (Throwable th) {
                        r0 = bufferedOutputStream3;
                        th = th;
                        C1801v.m4105a((Closeable) null);
                        C1801v.m4105a((Closeable) r0);
                        throw th;
                    }
                }
                AbstractC1417b.m1089a("TinyData write to cache file failed case encryption fail item:" + c1637gi.m2747d() + "  ts:" + System.currentTimeMillis());
                C1801v.m4105a((Closeable) null);
                C1801v.m4105a((Closeable) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = null;
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            r0 = 0;
        }
    }

    /* renamed from: a */
    public static byte[] m3804a(Context context) {
        String m3456a = C1698n.m3453a(context).m3456a("mipush", "td_key", "");
        if (TextUtils.isEmpty(m3456a)) {
            m3456a = C1494ba.m1624a(20);
            C1698n.m3453a(context).m3457a("mipush", "td_key", m3456a);
        }
        return m3805a(m3456a);
    }

    /* renamed from: a */
    private static byte[] m3805a(String str) {
        byte[] copyOf = Arrays.copyOf(C1490ax.m1586a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }
}
