package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C1766ax;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.cz */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1546cz {

    /* renamed from: a */
    private static String f1278a = "/MiPushLog";

    /* renamed from: a */
    private int f1279a;

    /* renamed from: a */
    private boolean f1282a;

    /* renamed from: b */
    private String f1284b;

    /* renamed from: c */
    private String f1285c;

    /* renamed from: a */
    private final SimpleDateFormat f1280a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: b */
    private int f1283b = 2097152;

    /* renamed from: a */
    private ArrayList<File> f1281a = new ArrayList<>();

    /* renamed from: a */
    C1546cz m1995a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f1284b = this.f1280a.format(date2);
            this.f1285c = this.f1280a.format(date);
        } else {
            this.f1284b = this.f1280a.format(date);
            this.f1285c = this.f1280a.format(date2);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1997a(int i) {
        if (i != 0) {
            this.f1283b = i;
        }
    }

    /* renamed from: a */
    C1546cz m1994a(File file) {
        if (file.exists()) {
            this.f1281a.add(file);
        }
        return this;
    }

    /* renamed from: a */
    private void m1992a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f1284b.length() + start);
                if (!this.f1282a) {
                    if (substring.compareTo(this.f1284b) >= 0) {
                        this.f1282a = true;
                        i2 = start;
                    }
                } else if (substring.compareTo(this.f1285c) > 0) {
                    z = true;
                    read = start;
                    break;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f1284b.length();
                }
                i = start + indexOf;
            }
            if (this.f1282a) {
                int i3 = read - i2;
                this.f1279a += i3;
                if (z) {
                    bufferedWriter.write(cArr, i2, i3);
                    return;
                } else {
                    bufferedWriter.write(cArr, i2, i3);
                    if (this.f1279a > this.f1283b) {
                        return;
                    }
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.xiaomi.push.cz] */
    /* renamed from: a */
    private void m1993a(File file) {
        Object obj;
        Object obj2;
        ?? r2 = "model :";
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder("model :");
                    sb.append(Build.MODEL);
                    sb.append("; os :").append(Build.VERSION.INCREMENTAL);
                    sb.append("; uid :").append(C1766ax.m3769a());
                    sb.append("; lng :").append(Locale.getDefault().toString());
                    sb.append("; sdk :48; andver :");
                    sb.append(Build.VERSION.SDK_INT);
                    sb.append(UpdateDialogNewBase.TYPE);
                    bufferedWriter2.write(sb.toString());
                    this.f1279a = 0;
                    Iterator<File> it = this.f1281a.iterator();
                    while (it.hasNext()) {
                        r2 = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            m1992a(r2, bufferedWriter2, compile);
                            r2.close();
                            bufferedWriter = r2;
                        } catch (FileNotFoundException e) {
                            e = e;
                            bufferedWriter = bufferedWriter2;
                            obj2 = r2;
                            AbstractC1417b.m1101c("LOG: filter error = " + e.getMessage());
                            r2 = obj2;
                            C1801v.m4105a(bufferedWriter);
                            C1801v.m4105a((Closeable) r2);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedWriter = bufferedWriter2;
                            obj = r2;
                            AbstractC1417b.m1101c("LOG: filter error = " + e.getMessage());
                            r2 = obj;
                            C1801v.m4105a(bufferedWriter);
                            C1801v.m4105a((Closeable) r2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            C1801v.m4105a(bufferedWriter);
                            C1801v.m4105a((Closeable) r2);
                            throw th;
                        }
                    }
                    bufferedWriter2.write(C1526cf.m1812a().m1835c());
                    C1801v.m4105a(bufferedWriter2);
                    C1801v.m4105a(bufferedWriter);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    r2 = bufferedWriter;
                } catch (IOException e4) {
                    e = e4;
                    r2 = bufferedWriter;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = bufferedWriter;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            obj2 = null;
        } catch (IOException e6) {
            e = e6;
            obj = null;
        } catch (Throwable th4) {
            th = th4;
            r2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public File m1996a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = C1545cy.m1991a(context);
            if (file2 == null) {
                return null;
            }
            m1994a(new File(file2, "xmsf.log.1"));
            m1994a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(context.getFilesDir() + f1278a);
            if (!C1800u.m4103a(file3)) {
                return null;
            }
            m1994a(new File(file3, "log0.txt"));
            m1994a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        m1995a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        m1993a(file5);
        AbstractC1417b.m1101c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            C1801v.m4106a(file4, file5);
            AbstractC1417b.m1101c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }
}
