package com.bytedance.crash.dumper;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.crash.Global;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCacheKt;
import java.io.File;

/* loaded from: classes3.dex */
public class Storage {
    private static final int G_1 = 1073741824;
    private static final int M_100 = 104857600;
    public static final int UNIT = 52428800;

    public static String getStorageRange(long j) {
        return j <= 52428800 ? "0 - 50M" : j <= ArtifactDiskCacheKt.ARTIFACT_CACHE_MAX_BYTES ? "50M - 100M" : j <= 1073741824 ? "100M - 1G" : "1G - ";
    }

    public static long storageFreeSize() {
        Context context = Global.getContext();
        if (context == null) {
            return 0L;
        }
        return getFreeSize(context.getFilesDir());
    }

    public static long storageTotalSize() {
        Context context = Global.getContext();
        if (context == null) {
            return 0L;
        }
        return getTotalSize(context.getFilesDir());
    }

    public static Pair<Long, Long> getSdcardStorage() {
        String str;
        long j;
        long blockSizeLong;
        try {
            str = Environment.getExternalStorageState();
        } catch (Throwable unused) {
            str = null;
        }
        long j2 = 0;
        if (TextUtils.equals(str, "mounted")) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                j = statFs.getAvailableBytes();
                try {
                    blockSizeLong = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
                    j2 = j;
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                j = 0;
            }
        } else {
            blockSizeLong = 0;
        }
        j = j2;
        j2 = blockSizeLong;
        return new Pair<>(Long.valueOf(j2), Long.valueOf(j));
    }

    public static String getInnerFreeSizeRange() {
        return getStorageRange(storageFreeSize());
    }

    public static long formatSize(long j) {
        return j / 52428800;
    }

    private static long getTotalSize(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long getFreeSize(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
