package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.data.C1419a;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.C1801v;
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
import java.util.HashMap;
import java.util.List;

/* renamed from: com.xiaomi.clientreport.processor.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1425e {
    /* renamed from: a */
    public static void m1157a(String str, C1419a[] c1419aArr) {
        RandomAccessFile randomAccessFile;
        if (c1419aArr == null || c1419aArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            C1801v.m4109a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> m1154a = m1154a(str);
                for (C1419a c1419a : c1419aArr) {
                    if (c1419a != null) {
                        String m1153a = m1153a((PerfClientReport) c1419a);
                        long j = ((PerfClientReport) c1419a).perfCounts;
                        long j2 = ((PerfClientReport) c1419a).perfLatencies;
                        if (!TextUtils.isEmpty(m1153a) && j > 0 && j2 >= 0) {
                            m1158a(m1154a, m1153a, j, j2);
                        }
                    }
                }
                m1156a(str, m1154a);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e) {
                        e = e;
                        AbstractC1417b.m1093a(e);
                        C1801v.m4105a(randomAccessFile);
                    }
                }
            } catch (Throwable unused) {
                try {
                    AbstractC1417b.m1101c("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            e = e2;
                            AbstractC1417b.m1093a(e);
                            C1801v.m4105a(randomAccessFile);
                        }
                    }
                    C1801v.m4105a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            AbstractC1417b.m1093a(e3);
                        }
                    }
                    C1801v.m4105a(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        C1801v.m4105a(randomAccessFile);
    }

    /* renamed from: a */
    private static void m1158a(HashMap<String, String> hashMap, String str, long j, long j2) {
        String str2;
        String str3 = hashMap.get(str);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put(str, j + "#" + j2);
            return;
        }
        long[] m1159a = m1159a(str3);
        if (m1159a != null) {
            long j3 = m1159a[0];
            if (j3 > 0) {
                long j4 = m1159a[1];
                if (j4 >= 0) {
                    str2 = (j + j3) + "#" + (j2 + j4);
                    hashMap.put(str, str2);
                }
            }
        }
        str2 = j + "#" + j2;
        hashMap.put(str, str2);
    }

    /* renamed from: a */
    protected static long[] m1159a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return null;
        }
    }

    /* renamed from: a */
    private static void m1156a(String str, HashMap<String, String> hashMap) {
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    for (String str2 : hashMap.keySet()) {
                        bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                        bufferedWriter.newLine();
                    }
                } catch (Exception e2) {
                    e = e2;
                    AbstractC1417b.m1093a(e);
                    C1801v.m4105a(bufferedWriter);
                }
            } catch (Throwable th2) {
                th = th2;
                C1801v.m4105a((Closeable) null);
                throw th;
            }
        } catch (Exception e3) {
            bufferedWriter = null;
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            C1801v.m4105a((Closeable) null);
            throw th;
        }
        C1801v.m4105a(bufferedWriter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* renamed from: a */
    private static HashMap<String, String> m1154a(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
        ?? r1 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader3.readLine();
                        if (readLine == null) {
                            break;
                        }
                        ?? split = readLine.split("%%%");
                        r1 = split.length;
                        if (r1 >= 2) {
                            r1 = 0;
                            r1 = 0;
                            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                r1 = split[0];
                                hashMap.put(r1, split[1]);
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        bufferedReader2 = bufferedReader3;
                        AbstractC1417b.m1093a(e);
                        C1801v.m4105a(bufferedReader2);
                        bufferedReader = bufferedReader2;
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        C1801v.m4105a(bufferedReader);
                        throw th;
                    }
                }
                C1801v.m4105a(bufferedReader3);
                bufferedReader = r1;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d8, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> m1155a(Context context, String str) {
        File file;
        RandomAccessFile randomAccessFile;
        ?? r4;
        PerfClientReport m1151a;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return arrayList;
        }
        FileLock fileLock = null;
        try {
            file = new File(str + ".lock");
            try {
                C1801v.m4109a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        r4 = new BufferedReader(new FileReader(str));
                        while (true) {
                            try {
                                String readLine = r4.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                String[] split = readLine.split("%%%");
                                if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (m1151a = m1151a(m1152a(split[0]), split[1])) != null) {
                                    arrayList.add(m1151a.toJsonString());
                                }
                            } catch (Exception e) {
                                e = e;
                                fileLock = lock;
                                r4 = r4;
                                try {
                                    AbstractC1417b.m1093a(e);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e2) {
                                            AbstractC1417b.m1093a(e2);
                                        }
                                    }
                                    C1801v.m4105a(randomAccessFile);
                                    C1801v.m4105a((Closeable) r4);
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            AbstractC1417b.m1093a(e3);
                                        }
                                    }
                                    C1801v.m4105a(randomAccessFile);
                                    C1801v.m4105a((Closeable) r4);
                                    if (file == null) {
                                        throw th;
                                    }
                                    file.delete();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = lock;
                                if (fileLock != null) {
                                }
                                C1801v.m4105a(randomAccessFile);
                                C1801v.m4105a((Closeable) r4);
                                if (file == null) {
                                }
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException e4) {
                                AbstractC1417b.m1093a(e4);
                            }
                        }
                        C1801v.m4105a(randomAccessFile);
                        C1801v.m4105a((Closeable) r4);
                    } catch (Exception e5) {
                        e = e5;
                        r4 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        r4 = 0;
                    }
                } catch (Exception e6) {
                    e = e6;
                    r4 = 0;
                } catch (Throwable th4) {
                    th = th4;
                    r4 = 0;
                }
            } catch (Exception e7) {
                e = e7;
                randomAccessFile = null;
                r4 = randomAccessFile;
                AbstractC1417b.m1093a(e);
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                C1801v.m4105a(randomAccessFile);
                C1801v.m4105a((Closeable) r4);
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                r4 = randomAccessFile;
                if (fileLock != null) {
                    fileLock.release();
                }
                C1801v.m4105a(randomAccessFile);
                C1801v.m4105a((Closeable) r4);
                if (file == null) {
                }
            }
        } catch (Exception e8) {
            e = e8;
            file = null;
            randomAccessFile = null;
        } catch (Throwable th6) {
            th = th6;
            file = null;
            randomAccessFile = null;
        }
        file.delete();
        return arrayList;
    }

    /* renamed from: a */
    private static String[] m1160a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    /* renamed from: a */
    private static PerfClientReport m1152a(String str) {
        PerfClientReport perfClientReport = null;
        try {
            String[] m1160a = m1160a(str);
            if (m1160a == null || m1160a.length < 4 || TextUtils.isEmpty(m1160a[0]) || TextUtils.isEmpty(m1160a[1]) || TextUtils.isEmpty(m1160a[2]) || TextUtils.isEmpty(m1160a[3])) {
                return null;
            }
            perfClientReport = PerfClientReport.getBlankInstance();
            perfClientReport.production = Integer.parseInt(m1160a[0]);
            perfClientReport.clientInterfaceId = m1160a[1];
            perfClientReport.reportType = Integer.parseInt(m1160a[2]);
            perfClientReport.code = Integer.parseInt(m1160a[3]);
            return perfClientReport;
        } catch (Exception unused) {
            AbstractC1417b.m1101c("parse per key error");
            return perfClientReport;
        }
    }

    /* renamed from: a */
    private static PerfClientReport m1151a(PerfClientReport perfClientReport, String str) {
        long[] m1159a;
        if (perfClientReport == null || (m1159a = m1159a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = m1159a[0];
        perfClientReport.perfLatencies = m1159a[1];
        return perfClientReport;
    }

    /* renamed from: a */
    public static String m1153a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }
}
