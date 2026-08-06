package com.bytedance.bdinstall.oaid;

import android.content.Context;

/* loaded from: classes3.dex */
interface OaidApi {

    /* loaded from: classes3.dex */
    public static class Result {
        boolean isTrackLimit;
        String oaid;
    }

    String getName();

    Result getOaid(Context context);

    boolean support(Context context);
}
