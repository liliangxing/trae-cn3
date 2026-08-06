package com.ttnet.org.chromium.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class MemoryUtils {
    private static String TAG = "MemoryUtils";
    private static boolean sInitialized = false;
    private static String sMemoryInfoPath = "/proc/meminfo";
    private static final Object sMemoryLock = new Object();
    private static String sTotalMemoryGB = "unknown";

    public static boolean initialize() {
        if (sInitialized) {
            return true;
        }
        fetchTotalMemory();
        sInitialized = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void fetchTotalMemory() {
        FileReader fileReader;
        Matcher matcher;
        Pattern compile = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        BufferedReader bufferedReader = null;
        long j = 0;
        try {
            fileReader = new FileReader(sMemoryInfoPath);
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                    try {
                        do {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    matcher = compile.matcher(readLine);
                                }
                                break;
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                            }
                        } while (!matcher.find());
                        break;
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (Exception unused) {
                    }
                    long parseLong = Long.parseLong(matcher.group(1));
                    if (parseLong <= 1024) {
                        try {
                            android.util.Log.w(TAG, "Invalid " + sMemoryInfoPath + " total size in kB: " + parseLong);
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            j = parseLong;
                            android.util.Log.w(TAG, "Cannot get total physical size from " + sMemoryInfoPath, e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    synchronized (sMemoryLock) {
                                        sTotalMemoryGB = String.valueOf((int) Math.ceil((j * 1.0d) / 1048576.0d));
                                    }
                                    return;
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            synchronized (sMemoryLock) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            j = parseLong;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                    synchronized (sMemoryLock) {
                                        sTotalMemoryGB = String.valueOf((int) Math.ceil((j * 1.0d) / 1048576.0d));
                                    }
                                    throw th;
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            synchronized (sMemoryLock) {
                            }
                        }
                    } else {
                        j = parseLong;
                    }
                    synchronized (sMemoryLock) {
                        sTotalMemoryGB = String.valueOf((int) Math.ceil((j * 1.0d) / 1048576.0d));
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
            fileReader = null;
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static String getTotalMemoryGB() {
        String str;
        synchronized (sMemoryLock) {
            str = sTotalMemoryGB;
        }
        return str;
    }
}
