package com.bytedance.crash.dumper;

import com.bytedance.crash.jni.NativeBridge;
import java.io.File;

/* loaded from: classes3.dex */
public class ProcInfo {
    public static final long GB = 1073741824;
    public static final long KB = 1024;
    public static final long MB = 1048576;

    public static String getFdCountRange(int i) {
        return i > 2000 ? "(2000 - MAX)" : i > 1500 ? "(1500 - 2000]" : i > 1200 ? "(1200 - 1500]" : i > 960 ? "(960 - 1200]" : i > 800 ? "(800 - 960]" : i > 600 ? "(600 - 800]" : i > 400 ? "(400 - 600]" : "(0 - 400]";
    }

    public static String getPthreadKeyCountRange(int i) {
        return i > 120 ? "(120 - MAX]" : i > 100 ? "(100 - 120]" : i > 80 ? "(80 - 100]" : i > 60 ? "(60 - 80]" : i > 40 ? "(40 - 60]" : "(0 - 40]";
    }

    public static String getThreadCountRange(int i) {
        return i > 750 ? "(750 - MAX)" : i > 650 ? "(650 - 750]" : i > 550 ? "(550 - 650]" : i > 450 ? "(450 - 550]" : i > 350 ? "(350 - 450]" : i > 250 ? "(250 - 350]" : i > 150 ? "(150 - 250]" : "[0 - 150]";
    }

    private static long getVmMaxSize(boolean z) {
        return z ? 4294967296L : 3221225472L;
    }

    public static String getVmRange64(long j) {
        long j2 = j * 1024;
        return j2 > 25769803776L ? "(24GB - MAX)" : j2 > 21474836480L ? "(20GB - 24GB]" : j2 > 17179869184L ? "(16GB - 20GB]" : j2 > 12884901888L ? "(12GB - 16GB]" : j2 > 10737418240L ? "(10GB - 12GB]" : j2 > 9663676416L ? "(9GB - 10GB]" : j2 > 8589934592L ? "(8GB - 9GB]" : j2 > 7516192768L ? "(7GB - 8GB]" : j2 > 6442450944L ? "(6GB - 7GB]" : j2 > 5368709120L ? "(5GB - 6GB]" : j2 > 4294967296L ? "(4GB - 5GB]" : "[0GB - 4GB]";
    }

    public static String getVmRssRange(long j) {
        long j2 = j * 1024;
        return j2 > 5368709120L ? "(5GB - MAX)" : j2 > 4294967296L ? "(4GB - 5GB]" : j2 > 3221225472L ? "(3GB - 4GB]" : j2 > 2147483648L ? "(2GB - 3GB]" : j2 > 1073741824 ? "(1GB - 2GB]" : j2 > 939524096 ? "(896MB - 1GB]" : j2 > 805306368 ? "(768MB - 896MB]" : j2 > 671088640 ? "(640MB - 768MB]" : j2 > 536870912 ? "(512MB - 640MB]" : j2 > 402653184 ? "(384MB - 512MB]" : j2 > 268435456 ? "(256MB - 384MB]" : j2 > 134217728 ? "(128MB - 256MB]" : "(0MB - 128MB]";
    }

    public static boolean isPthreadKeyLeak(int i) {
        return i > 100;
    }

    public static boolean isRssExcess(long j) {
        return j > 209715200;
    }

    public static boolean isThreadLeak(int i) {
        return i > 350;
    }

    public static boolean isVmaCountLeak(int i) {
        return i > 60000;
    }

    public static boolean isFdLeak(int i) {
        return ((double) i) > ((double) NativeBridge.getFdLimit()) * 0.9d;
    }

    public static String getVmUsage32(long j, boolean z) {
        float f = (float) (j * 1024);
        float vmMaxSize = (float) getVmMaxSize(z);
        return f > 0.95f * vmMaxSize ? "(95% - 100%]" : f > 0.9f * vmMaxSize ? "(90% - 95%]" : f > 0.85f * vmMaxSize ? "(85% - 90%]" : f > 0.8f * vmMaxSize ? "(80% - 85%]" : f > 0.7f * vmMaxSize ? "(70% - 80%]" : f > 0.6f * vmMaxSize ? "(60% - 70%]" : f > vmMaxSize * 0.5f ? "(50% - 60%]" : "[0% - 50%]";
    }

    public static boolean isMemoryLeak32(long j, boolean z) {
        return ((float) (j * 1024)) > ((float) getVmMaxSize(z)) * 0.9f;
    }

    public static int getThreadCount(File file) {
        return NativeBridge.getThreadCount(file.getAbsolutePath());
    }

    public static int getFdCount(File file) {
        return NativeBridge.getFdCount(file.getAbsolutePath());
    }

    public static int getPthreadKeyCount(File file) {
        return NativeBridge.PthreadKeyCount(file.getAbsolutePath());
    }

    public static long getVmSizeKb(File file) {
        return NativeBridge.getVmSize(file.getAbsolutePath(), false);
    }

    public static long getVmPeakKb(File file) {
        return NativeBridge.getVmSize(file.getAbsolutePath(), true);
    }

    public static long getVmRssKb(File file) {
        return NativeBridge.getVmRss(file.getAbsolutePath());
    }

    public static int getVmaCount(File file) {
        return NativeBridge.getVmaCount(file.getAbsolutePath());
    }
}
