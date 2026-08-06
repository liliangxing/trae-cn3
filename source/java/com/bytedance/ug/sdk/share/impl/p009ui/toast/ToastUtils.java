package com.bytedance.ug.sdk.share.impl.p009ui.toast;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.ug.sdk.share.impl.p009ui.utils.UIUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ToastUtils {
    public static void showToast(Context context, int i) {
        if (context == null) {
            return;
        }
        Toast.makeText(context.getApplicationContext(), i, 0).show();
    }

    public static boolean showToastWithIcon(Context context, int i, int i2) {
        if (context == null) {
            return false;
        }
        UIUtils.displayToastWithIcon(context.getApplicationContext(), i, i2);
        return true;
    }
}
