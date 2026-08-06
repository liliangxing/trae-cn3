package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.ab */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1468ab {
    /* JADX WARN: Removed duplicated region for block: B:18:0x00dd A[Catch: all -> 0x00f1, IOException -> 0x00f4, LOOP:0: B:16:0x00d7->B:18:0x00dd, LOOP_END, TRY_LEAVE, TryCatch #9 {IOException -> 0x00f4, all -> 0x00f1, blocks: (B:15:0x00d3, B:16:0x00d7, B:18:0x00dd), top: B:14:0x00d3 }] */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean m1440b(Context context, String str, long j) {
        Closeable closeable;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        Iterator it;
        File file = new File(context.getFilesDir(), "/.vdevdir/");
        if (!C1800u.m4103a(file)) {
            return true;
        }
        File file2 = new File(file, "lcfp");
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + Constants.COLON_SEPARATOR + context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP + currentTimeMillis;
        ?? exists = file2.exists();
        try {
            if (exists != 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file2));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split(Constants.COLON_SEPARATOR);
                            if (split.length == 2) {
                                if (TextUtils.equals(split[0], String.valueOf(str))) {
                                    String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    if (split2.length == 2) {
                                        long parseLong = Long.parseLong(split2[1]);
                                        if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j)) * 0.9f) {
                                            C1801v.m4105a(bufferedReader);
                                            return false;
                                        }
                                    }
                                } else {
                                    arrayList.add(readLine);
                                }
                            }
                        } catch (Exception unused) {
                            arrayList.clear();
                            C1801v.m4105a(bufferedReader);
                            arrayList.add(str2);
                            bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                            try {
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                }
                                C1801v.m4105a(bufferedWriter2);
                            } catch (IOException e) {
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                try {
                                    AbstractC1417b.m1103d(e.toString());
                                    C1801v.m4105a(bufferedWriter);
                                    return true;
                                } catch (Throwable th) {
                                    th = th;
                                    C1801v.m4105a(bufferedWriter);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter = bufferedWriter2;
                                C1801v.m4105a(bufferedWriter);
                                throw th;
                            }
                            return true;
                        }
                    }
                } catch (Exception unused2) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    C1801v.m4105a(closeable);
                    throw th;
                }
            } else if (!C1801v.m4109a(file2)) {
                return true;
            }
            arrayList.add(str2);
            try {
                bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                it = arrayList.iterator();
                while (it.hasNext()) {
                    bufferedWriter2.write((String) it.next());
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                }
                C1801v.m4105a(bufferedWriter2);
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter = null;
            }
            return true;
        } catch (Throwable th5) {
            th = th5;
            closeable = exists;
        }
    }

    /* renamed from: a */
    public static boolean m1439a(Context context, String str, long j) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        try {
            File file = new File(context.getFilesDir(), "/.vdevdir/");
            if (!C1800u.m4103a(file)) {
                C1801v.m4105a((Closeable) null);
                return true;
            }
            File file2 = new File(file, "lcfp.lock");
            C1801v.m4109a(file2);
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    boolean m1440b = m1440b(context, str, j);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    C1801v.m4105a(randomAccessFile);
                    return m1440b;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    C1801v.m4105a(randomAccessFile);
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                C1801v.m4105a(randomAccessFile);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
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
    }
}
