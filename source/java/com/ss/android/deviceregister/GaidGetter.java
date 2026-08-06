package com.ss.android.deviceregister;

import android.content.Context;
import android.util.Pair;
import com.ss.android.deviceregister.base.AppLogConstants;

/* loaded from: classes7.dex */
public class GaidGetter {
    private static final String KEY_GAID_LIMITED = "gaid_limited";

    public static Pair<String, Boolean> getGaid(Context context) {
        return null;
    }

    public static boolean isInitGaid() {
        return true;
    }

    public static void clearSp(Context context) {
        AppLogConstants.getApplogStatsSp(context).edit().remove("google_aid").remove("gaid_limited").apply();
    }
}
