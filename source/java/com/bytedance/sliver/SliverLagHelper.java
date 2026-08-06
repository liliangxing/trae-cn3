package com.bytedance.sliver;

import android.content.Context;
import android.os.Looper;
import android.util.Printer;
import com.bytedance.crash.runtime.LooperMessageManager;
import java.io.File;
import java.util.UUID;

/* loaded from: classes5.dex */
public class SliverLagHelper {
    private static final char END = '<';
    private static final char START = '>';

    /* loaded from: classes5.dex */
    public interface ISliverLagHandler {
        void executeTask(Runnable runnable);

        void reportLagData(StackTraceElement[] stackTraceElementArr, String str);

        void reportSliverLagFile(File file);
    }

    public static void init(Context context, int i, int i2, final ISliverLagHandler iSliverLagHandler) {
        final File externalFilesDir = context.getExternalFilesDir("sliver_lag");
        if (externalFilesDir != null) {
            if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
                File[] listFiles = externalFilesDir.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
                final long j = i * 1000 * 1000;
                final long j2 = i2 * 1000 * 1000;
                Printer printer = new Printer() { // from class: com.bytedance.sliver.SliverLagHelper.1
                    private long messageStartNs = 0;

                    @Override // android.util.Printer
                    public void println(String str) {
                        if (str.charAt(0) == '>') {
                            this.messageStartNs = System.nanoTime();
                            return;
                        }
                        if (str.charAt(0) != '<' || this.messageStartNs == 0) {
                            return;
                        }
                        final long nanoTime = System.nanoTime();
                        final long j3 = this.messageStartNs;
                        if (nanoTime - j3 < j) {
                            return;
                        }
                        iSliverLagHandler.executeTask(new Runnable() { // from class: com.bytedance.sliver.SliverLagHelper.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String uuid = UUID.randomUUID().toString();
                                File file2 = new File(externalFilesDir, "trace-" + uuid);
                                File file3 = new File(externalFilesDir, "mini-trace-" + uuid);
                                Sliver.dump(Looper.getMainLooper().getThread(), file2.getAbsolutePath(), true);
                                StackTraceElement[] analyze = SliverLagAnalyzer.analyze(file2, j3, nanoTime, j2, file3);
                                if (analyze.length > 0) {
                                    iSliverLagHandler.reportLagData(analyze, uuid);
                                    ISliverLagHandler iSliverLagHandler2 = iSliverLagHandler;
                                    if (file3.exists()) {
                                        file2 = file3;
                                    }
                                    iSliverLagHandler2.reportSliverLagFile(file2);
                                }
                            }
                        });
                    }
                };
                LooperMessageManager.getInstance().start();
                LooperMessageManager.getInstance().registerSyncStartPrinter(printer);
                LooperMessageManager.getInstance().registerSyncEndPrinter(printer);
            }
        }
    }
}
