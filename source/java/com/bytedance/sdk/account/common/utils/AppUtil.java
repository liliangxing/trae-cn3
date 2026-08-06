package com.bytedance.sdk.account.common.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.ttm.player.C;

/* loaded from: classes5.dex */
public class AppUtil {
    public static boolean isAppInstalled(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openApp(Context context, String str) {
        if (!isAppInstalled(context, str) || context == null) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            if (context instanceof Application) {
                launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
