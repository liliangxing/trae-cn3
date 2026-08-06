package com.ss.ttffmpeg;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class FFmpegLibLoaderWrapper {
    private static final String TAG = "FFmpegLibLoaderWrapper";
    private static boolean isVcnverifyload;
    private static volatile boolean sHasLoadFFmpeg;
    private static volatile IFFmpegLoader sIFFmpegLoader;
    private static volatile IVerifyLoader sIFFmpegVerifyLoader;

    public static synchronized boolean loadFFmpeg() {
        synchronized (FFmpegLibLoaderWrapper.class) {
            if (sIFFmpegLoader != null) {
                sHasLoadFFmpeg = sIFFmpegLoader.loadFFmpeg();
            } else {
                if (sHasLoadFFmpeg) {
                    return true;
                }
                try {
                    System.loadLibrary("ttcrypto");
                    System.loadLibrary("ttboringssl");
                    System.loadLibrary(BuildConfig.FFMPEG_LIBNAME);
                    sHasLoadFFmpeg = true;
                } catch (UnsatisfiedLinkError e) {
                    Log.e(TAG, "load ffmpeg lib failed " + e.getMessage());
                }
            }
            return true;
        }
    }

    public static synchronized void setFFmpegLoader(IFFmpegLoader iFFmpegLoader) {
        synchronized (FFmpegLibLoaderWrapper.class) {
            sIFFmpegLoader = iFFmpegLoader;
        }
    }

    public static synchronized void setFFmpegVerifyLoader(IVerifyLoader iVerifyLoader) {
        synchronized (FFmpegLibLoaderWrapper.class) {
            sIFFmpegVerifyLoader = iVerifyLoader;
        }
    }

    public static synchronized String getFFmpegVersion() {
        synchronized (FFmpegLibLoaderWrapper.class) {
        }
        return BuildConfig.VERSION_NAME;
    }

    public static List<String> getFFmpegLibs() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add("ttcrypto");
            arrayList.add("ttboringssl");
            arrayList.add(BuildConfig.FFMPEG_LIBNAME);
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static synchronized boolean tryLoadVcnverifylib() {
        synchronized (FFmpegLibLoaderWrapper.class) {
            boolean z = true;
            if (isVcnverifyload) {
                return true;
            }
            if (sIFFmpegVerifyLoader != null) {
                boolean loadVerifyLib = sIFFmpegVerifyLoader.loadVerifyLib();
                isVcnverifyload = loadVerifyLib;
                return loadVerifyLib;
            }
            try {
                System.loadLibrary("ttmverify");
            } catch (UnsatisfiedLinkError e) {
                Log.e("ttmverify", "Can't load ttmverify library: " + e);
                try {
                    System.loadLibrary("ttmverifylite");
                    Log.e("ttmverifylite", "load ttmverifylite library suc");
                    CustomVerify.init();
                } catch (UnsatisfiedLinkError e2) {
                    Log.e("ttmverifylite", "Can't load ttmverifylite library: " + e2);
                    z = false;
                }
            }
            isVcnverifyload = z;
            return z;
        }
    }
}
