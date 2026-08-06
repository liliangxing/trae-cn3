package com.ss.android.deviceregister.base;

import android.content.Context;

/* loaded from: classes7.dex */
interface OaidApi {

    /* loaded from: classes7.dex */
    public static class Result {
        boolean isTrackLimit;
        String oaid;
        long versionCode;
    }

    String getName(Context context);

    Result getOaid(Context context);

    boolean support(Context context);
}
