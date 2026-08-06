package com.bytedance.lottie;

/* loaded from: classes4.dex */
public class LottieMonitor {
    private static ILottieError sLottieError;

    /* loaded from: classes4.dex */
    public interface ILottieError {
        void lottieError(String str, Throwable th);
    }

    public static void register(ILottieError iLottieError) {
        sLottieError = iLottieError;
    }

    public static void reportError(String str, Throwable th) {
        ILottieError iLottieError = sLottieError;
        if (iLottieError != null) {
            iLottieError.lottieError(str, th);
        }
    }
}
