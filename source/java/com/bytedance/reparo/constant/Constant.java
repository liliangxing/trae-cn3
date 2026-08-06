package com.bytedance.reparo.constant;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes4.dex */
public class Constant {
    private static final String AUTHORITIES_SUFFIX = ".reparo";

    public static Uri getAuthoritiesUri(Context context) {
        return Uri.parse("content://" + context.getPackageName() + AUTHORITIES_SUFFIX);
    }
}
