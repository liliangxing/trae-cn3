package com.bytedance.ug.sdk.share.impl.utils;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ToastUtils {
    public static boolean isDebug;

    public static void showDebugToast(String str) {
        if (isDebug) {
            Toast.makeText(ShareSdkManager.getInstance().getAppContext().getApplicationContext(), str, 0).show();
        }
    }

    public static void showToast(Context context, ShareContent shareContent, int i, int i2) {
        if (context == null) {
            return;
        }
        ShareConfigManager.getInstance().showToast(context, shareContent, i, i2);
    }

    public static void showToastWithIcon(Context context, ShareContent shareContent, int i, int i2, int i3) {
        if (context == null) {
            return;
        }
        ShareConfigManager.getInstance().showToastWithIcon(context, shareContent, i, i2, i3);
    }
}
