package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.manager.C1420a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.xiaomi.push.bk */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1504bk {
    /* renamed from: a */
    public static String m1663a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    /* renamed from: a */
    public static byte[] m1670a(String str) {
        byte[] copyOf = Arrays.copyOf(C1490ax.m1586a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* renamed from: a */
    public static String m1664a(Context context) {
        String m1674a = C1505bl.m1672a(context).m1674a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(m1674a)) {
            return m1674a;
        }
        String m1624a = C1494ba.m1624a(20);
        C1505bl.m1672a(context).m1676a("sp_client_report_status", "sp_client_report_key", m1624a);
        return m1624a;
    }

    /* renamed from: a */
    public static boolean m1668a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m1665a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* renamed from: a */
    public static void m1667a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m1668a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                m1665a(context, str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x00fa, code lost:
    
        if (r7 == null) goto L62;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1666a(Context context, String str, String str2) {
        File file;
        RandomAccessFile randomAccessFile;
        Exception e;
        if (context == null || str == null || str2 == null) {
            return;
        }
        File file2 = new File(context.getFilesDir(), str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(context.getFilesDir(), str);
        if (!file3.exists()) {
            file3.mkdirs();
            return;
        }
        File[] listFiles = file3.listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bk.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file4, String str3) {
                return (TextUtils.isEmpty(str3) || str3.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileLock fileLock = null;
        File file4 = null;
        RandomAccessFile randomAccessFile2 = null;
        for (File file5 : listFiles) {
            if (file5 != null) {
                try {
                } catch (Exception e2) {
                    file = file4;
                    randomAccessFile = randomAccessFile2;
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                }
                if (!TextUtils.isEmpty(file5.getAbsolutePath())) {
                    file = new File(file5.getAbsolutePath() + ".lock");
                    try {
                        C1801v.m4109a(file);
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                File file6 = new File(file2.getAbsolutePath() + File.separator + file5.getName() + currentTimeMillis);
                                try {
                                    C1801v.m4112b(file5, file6);
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    file5.delete();
                                    file6.delete();
                                }
                                file5.delete();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        AbstractC1417b.m1093a(e4);
                                    }
                                }
                                C1801v.m4105a(randomAccessFile);
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile2 = randomAccessFile;
                                file4 = file;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e5) {
                                        AbstractC1417b.m1093a(e5);
                                    }
                                }
                                C1801v.m4105a(randomAccessFile2);
                                if (file4 == null) {
                                    throw th;
                                }
                                file4.delete();
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            AbstractC1417b.m1093a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    AbstractC1417b.m1093a(e7);
                                }
                            }
                            C1801v.m4105a(randomAccessFile);
                        }
                    } catch (Exception e8) {
                        randomAccessFile = randomAccessFile2;
                        e = e8;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    file.delete();
                    randomAccessFile2 = randomAccessFile;
                    file4 = file;
                }
            }
            if (fileLock != null && fileLock.isValid()) {
                try {
                    fileLock.release();
                } catch (IOException e9) {
                    AbstractC1417b.m1093a(e9);
                }
            }
            C1801v.m4105a(randomAccessFile2);
            if (file4 != null) {
                file4.delete();
            }
        }
    }

    /* renamed from: a */
    public static boolean m1669a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = C1420a.m1108a(context).m1123a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() <= maxFileLength) {
                    return true;
                }
            } catch (Exception e) {
                AbstractC1417b.m1093a(e);
            }
            return false;
        }
        C1801v.m4109a(file);
        return true;
    }

    /* renamed from: a */
    public static File[] m1671a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bk.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return (TextUtils.isEmpty(str2) || str2.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
    }
}
