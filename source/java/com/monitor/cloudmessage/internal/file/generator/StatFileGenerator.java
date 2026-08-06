package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class StatFileGenerator {
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d A[Catch: IOException -> 0x0089, TRY_LEAVE, TryCatch #0 {IOException -> 0x0089, blocks: (B:50:0x0085, B:43:0x008d), top: B:49:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File generateFile(Context context, JSONObject jSONObject) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        if (jSONObject == null) {
            return null;
        }
        String absolutePath = FileUtils.getCloudMsgDir(context).getAbsolutePath();
        String str = absolutePath + File.separator + "stats.txt";
        try {
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileWriter fileWriter2 = new FileWriter(str);
            try {
                bufferedWriter = new BufferedWriter(fileWriter2);
                try {
                    bufferedWriter.write(jSONObject.toString());
                    try {
                        bufferedWriter.close();
                        fileWriter2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return new File(str);
                } catch (IOException e2) {
                    e = e2;
                    IOException iOException = e;
                    fileWriter = fileWriter2;
                    e = iOException;
                    try {
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    Throwable th3 = th;
                    fileWriter = fileWriter2;
                    th = th3;
                    if (bufferedWriter2 != null) {
                    }
                    if (fileWriter != null) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedWriter = null;
            } catch (Throwable th4) {
                th = th4;
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
