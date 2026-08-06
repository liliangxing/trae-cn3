package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* renamed from: com.xiaomi.push.dc */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1550dc implements LoggerInterface {

    /* renamed from: a */
    private static volatile C1550dc f1311a;

    /* renamed from: a */
    private Context f1315a;

    /* renamed from: a */
    private Handler f1316a;

    /* renamed from: b */
    private String f1317b;

    /* renamed from: a */
    private static final SimpleDateFormat f1313a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a */
    public static String f1312a = "/MiPushLog";

    /* renamed from: a */
    private static List<Pair<String, Throwable>> f1314a = Collections.synchronizedList(new ArrayList());

    private C1550dc(Context context) {
        this.f1315a = context;
        if (context.getApplicationContext() != null) {
            this.f1315a = context.getApplicationContext();
        }
        this.f1317b = this.f1315a.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f1316a = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static C1550dc m2020a(Context context) {
        if (f1311a == null) {
            synchronized (C1550dc.class) {
                if (f1311a == null) {
                    f1311a = new C1550dc(context);
                }
            }
        }
        return f1311a;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f1317b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String str, final Throwable th) {
        this.f1316a.post(new Runnable() { // from class: com.xiaomi.push.dc.1
            @Override // java.lang.Runnable
            public void run() {
                C1550dc.f1314a.add(new Pair(String.format("%1$s %2$s %3$s ", C1550dc.f1313a.format(new Date()), C1550dc.this.f1317b, str), th));
                if (C1550dc.f1314a.size() > 20000) {
                    int size = (C1550dc.f1314a.size() - 20000) + 50;
                    for (int i = 0; i < size; i++) {
                        try {
                            if (C1550dc.f1314a.size() > 0) {
                                C1550dc.f1314a.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    C1550dc.f1314a.add(new Pair(String.format("%1$s %2$s %3$s ", C1550dc.f1313a.format(new Date()), C1550dc.this.f1317b, "flush " + size + " lines logs."), null));
                }
                try {
                    C1550dc.this.m2024a();
                } catch (Exception e) {
                    Log.e(C1550dc.this.f1317b, "", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0160 -> B:49:0x0165). Please report as a decompilation issue!!! */
    /* renamed from: a */
    public void m2024a() {
        RandomAccessFile randomAccessFile;
        File file;
        FileLock fileLock = "Cannot wirte internal file: ";
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    file = new File(this.f1315a.getFilesDir(), f1312a);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
                fileLock = 0;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                fileLock = 0;
                randomAccessFile = null;
            }
        } catch (IOException e2) {
            Log.e(this.f1317b, "", e2);
        }
        if (!C1800u.m4103a(file)) {
            Log.w(this.f1317b, "Cannot wirte internal file: " + file);
            return;
        }
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            Log.w(this.f1317b, "Create mipushlog directory fail.");
            return;
        }
        File file2 = new File(file, "log.lock");
        if (!file2.exists() || file2.isDirectory()) {
            file2.createNewFile();
        }
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            fileLock = randomAccessFile.getChannel().lock();
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                while (!f1314a.isEmpty()) {
                    try {
                        Pair<String, Throwable> remove = f1314a.remove(0);
                        String str = (String) remove.first;
                        if (remove.second != null) {
                            str = (str + UpdateDialogNewBase.TYPE) + Log.getStackTraceString((Throwable) remove.second);
                        }
                        bufferedWriter2.write(str + UpdateDialogNewBase.TYPE);
                    } catch (Exception e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        Log.e(this.f1317b, "", e);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e4) {
                                Log.e(this.f1317b, "", e4);
                            }
                        }
                        if (fileLock != 0 && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                Log.e(this.f1317b, "", e5);
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e6) {
                                Log.e(this.f1317b, "", e6);
                            }
                        }
                        if (fileLock != 0 && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e7) {
                                Log.e(this.f1317b, "", e7);
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                throw th;
                            } catch (IOException e8) {
                                Log.e(this.f1317b, "", e8);
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                bufferedWriter2.flush();
                bufferedWriter2.close();
                File file3 = new File(file, "log1.txt");
                if (file3.length() >= 1048576) {
                    File file4 = new File(file, "log0.txt");
                    if (file4.exists() && file4.isFile()) {
                        file4.delete();
                    }
                    file3.renameTo(file4);
                }
                if (fileLock != 0 && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e9) {
                        Log.e(this.f1317b, "", e9);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Exception e11) {
            e = e11;
            fileLock = 0;
        } catch (Throwable th4) {
            th = th4;
            fileLock = 0;
        }
    }
}
