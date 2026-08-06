package com.ss.ttm.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: classes7.dex */
public class VersionInfo {
    private static String[] mVersion;

    public static String[] getVersion() {
        FileReader fileReader;
        if (mVersion == null) {
            String[] strArr = {"null", "null", "null", "null"};
            BufferedReader bufferedReader = null;
            try {
                try {
                    fileReader = new FileReader("/proc/version");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                        try {
                            strArr[0] = bufferedReader2.readLine().split("\\s+")[2];
                            try {
                                bufferedReader2.close();
                                fileReader.close();
                            } catch (Throwable th) {
                                try {
                                    th.printStackTrace();
                                    fileReader.close();
                                } finally {
                                    try {
                                        fileReader.close();
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    try {
                                        th3.printStackTrace();
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                    } catch (Throwable th4) {
                                        if (fileReader != null) {
                                        }
                                        throw th4;
                                    }
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            strArr[1] = Build.VERSION.RELEASE;
                            strArr[2] = Build.MODEL;
                            strArr[3] = Build.DISPLAY;
                            mVersion = strArr;
                            return mVersion;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } catch (Throwable unused3) {
                fileReader = null;
            }
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            mVersion = strArr;
        }
        return mVersion;
    }
}
