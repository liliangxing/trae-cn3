package com.ss.android.update;

import android.util.Log;
import android.util.Pair;

/* loaded from: classes7.dex */
public final class RequestTagHeaderManager {
    private static final String TAG = "RequestTagHeaderManager";
    private static volatile IRequestTagHeaderProvider sProvider;

    private RequestTagHeaderManager() {
    }

    public static void setRequestTagHeaderProvider(IRequestTagHeaderProvider iRequestTagHeaderProvider) {
        sProvider = iRequestTagHeaderProvider;
    }

    public static Pair<String, String> getHeader() {
        IRequestTagHeaderProvider iRequestTagHeaderProvider = sProvider;
        if (iRequestTagHeaderProvider == null) {
            Log.w(TAG, "getHeader(isAuto, isNewUser) but provider is null, skip.");
            return null;
        }
        try {
            return iRequestTagHeaderProvider.getRequestTagHeader();
        } catch (Throwable th) {
            Log.e(TAG, "getHeader(isAuto, isNewUser) error", th);
            return null;
        }
    }
}
