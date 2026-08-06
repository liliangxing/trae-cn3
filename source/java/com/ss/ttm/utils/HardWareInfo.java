package com.ss.ttm.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes7.dex */
public class HardWareInfo {
    private static final int ATOM = 1;
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 3;
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_X86 = 2;
    private static final int NEON = 0;
    private static int[] mArmArchitecture = new int[3];
    private static int mCpuType;

    private static boolean isAndroidJB2() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x006f, code lost:
    
        com.ss.ttm.utils.HardWareInfo.mArmArchitecture[0] = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] getCpuInfo() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.replaceAll("\t", "").toLowerCase(Locale.US).split(Constants.COLON_SEPARATOR);
                    if (split.length == 2) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (trim2 != null && trim != null) {
                            if (trim.compareTo("processor") == 0) {
                                if (trim2.contains("armv") || trim2.contains("aarch64")) {
                                    break;
                                }
                                if (trim2.contains("intel")) {
                                    mArmArchitecture[0] = 2;
                                    break;
                                }
                            } else if (trim.compareToIgnoreCase("features") == 0) {
                                if (trim2.contains("neon") || trim2.contains("thumb") || trim2.contains("vfpv") || trim2.contains("asimd") || trim2.contains("simd")) {
                                    mArmArchitecture[0] = 1;
                                }
                            } else if (trim.compareToIgnoreCase("model name") != 0) {
                                continue;
                            } else {
                                if (trim2.contains("intel")) {
                                    mArmArchitecture[0] = 2;
                                    break;
                                }
                                if (trim2.contains("arm")) {
                                    mArmArchitecture[0] = 1;
                                    break;
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    throw th;
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mArmArchitecture;
    }

    public static int[] getCpuArchitecture() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.replace("\t", "").split(Constants.COLON_SEPARATOR);
                    if (split.length == 2) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (trim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int indexOf = trim2.indexOf("ARMv") + 4; indexOf < trim2.length(); indexOf++) {
                                String str = trim2.charAt(indexOf) + "";
                                if (!str.matches("\\d")) {
                                    break;
                                }
                                sb.append(str);
                            }
                            int[] iArr = mArmArchitecture;
                            iArr[0] = 1;
                            iArr[1] = Integer.parseInt(sb.toString());
                        } else if (trim.compareToIgnoreCase("Features") == 0) {
                            if (trim2.contains("neon")) {
                                mArmArchitecture[2] = 0;
                            }
                        } else if (trim.compareToIgnoreCase("model name") == 0) {
                            if (trim2.contains("Intel")) {
                                int[] iArr2 = mArmArchitecture;
                                iArr2[0] = 2;
                                iArr2[2] = 1;
                            }
                        } else if (trim.compareToIgnoreCase("cpu family") == 0) {
                            mArmArchitecture[1] = Integer.parseInt(trim2);
                        }
                    }
                } finally {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mArmArchitecture;
    }

    private static long getDirectoryAvailableSize(String path) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(path);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getDirectoryTotalSize(String path) {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(path);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getTotalStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryTotalSize(context.getFilesDir().getParent());
    }

    private static long getAvailableStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryAvailableSize(context.getFilesDir().getParent());
    }

    public static long[] getSDCardSize(Context context) {
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            long availableStorageSize = getAvailableStorageSize(context);
            jArr[0] = getTotalStorageSize(context);
            jArr[1] = availableStorageSize;
        }
        return jArr;
    }

    public static long getProcessCpuInfo() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] split = readLine.split(" ");
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    return Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    return 0L;
                }
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return 0L;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused3) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int getCpuFamily() {
        if (mCpuType == 0) {
            getCpuInfo();
            mCpuType = mArmArchitecture[0];
        }
        return mCpuType;
    }
}
