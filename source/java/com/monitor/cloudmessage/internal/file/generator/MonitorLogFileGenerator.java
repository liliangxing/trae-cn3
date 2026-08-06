package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes7.dex */
public class MonitorLogFileGenerator {
    /* JADX WARN: Removed duplicated region for block: B:43:0x0090 A[Catch: IOException -> 0x008c, TRY_LEAVE, TryCatch #7 {IOException -> 0x008c, blocks: (B:50:0x0088, B:43:0x0090), top: B:49:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File generateFile(Context context, String str, String str2) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String absolutePath = FileUtils.getCloudMsgDir(context).getAbsolutePath();
        String str3 = absolutePath + File.separator + str2 + ".txt";
        try {
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileWriter fileWriter2 = new FileWriter(str3);
            try {
                bufferedWriter = new BufferedWriter(fileWriter2);
            } catch (IOException e) {
                e = e;
                bufferedWriter = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedWriter.write(str);
                try {
                    bufferedWriter.close();
                    fileWriter2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return new File(str3);
            } catch (IOException e3) {
                e = e3;
                IOException iOException = e;
                fileWriter = fileWriter2;
                e = iOException;
                try {
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                Throwable th4 = th;
                fileWriter = fileWriter2;
                th = th4;
                if (bufferedWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            fileWriter = null;
            bufferedWriter = null;
        } catch (Throwable th5) {
            th = th5;
            fileWriter = null;
        }
    }
}
