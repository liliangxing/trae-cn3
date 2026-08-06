package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class bk {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(ax.m9639a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    public static String a(Context context) {
        String a = bl.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = ba.a(20);
        bl.a(context).m9666a("sp_client_report_status", "sp_client_report_key", a2);
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m9662a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m9662a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x00fa, code lost:
    
        if (r7 == null) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2) {
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
                        v.m10243a(file);
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                File file6 = new File(file2.getAbsolutePath() + File.separator + file5.getName() + currentTimeMillis);
                                try {
                                    v.b(file5, file6);
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
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                }
                                v.a(randomAccessFile);
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile2 = randomAccessFile;
                                file4 = file;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e5) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                                    }
                                }
                                v.a(randomAccessFile2);
                                if (file4 == null) {
                                    throw th;
                                }
                                file4.delete();
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e7);
                                }
                            }
                            v.a(randomAccessFile);
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
                    com.xiaomi.channel.commonutils.logger.b.a(e9);
                }
            }
            v.a(randomAccessFile2);
            if (file4 != null) {
                file4.delete();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m9663a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m9537a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() <= maxFileLength) {
                    return true;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            return false;
        }
        v.m10243a(file);
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static File[] m9664a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bk.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return (TextUtils.isEmpty(str2) || str2.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
    }
}
