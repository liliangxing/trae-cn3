package com.bytedance.sliver;

import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes5.dex */
class SliverLagAnalyzer {
    SliverLagAnalyzer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StackTraceElement[] analyze(File file, long j, long j2, long j3, File file2) {
        SliverLagStack sliverLagStack = new SliverLagStack();
        sliverLagStack.setPrintFile(file2);
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("#")) {
                            sliverLagStack.onEvent(readLine);
                        } else {
                            long parseLong = Long.parseLong(readLine.split(Constants.COLON_SEPARATOR)[0]);
                            if (parseLong >= j) {
                                if (parseLong > j2) {
                                    break;
                                }
                                sliverLagStack.onEvent(readLine);
                            }
                        }
                    } catch (Throwable unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return SliverLagFilter.filter(sliverLagStack, j3);
                    }
                }
                sliverLagStack.onFinish(j2);
                bufferedReader2.close();
            } catch (Throwable unused2) {
            }
        } catch (IOException unused3) {
        }
        return SliverLagFilter.filter(sliverLagStack, j3);
    }
}
