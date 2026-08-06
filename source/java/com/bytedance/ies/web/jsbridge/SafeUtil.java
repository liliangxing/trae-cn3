package com.bytedance.ies.web.jsbridge;

import android.net.Uri;
import android.os.Build;

/* loaded from: classes4.dex */
class SafeUtil {
    SafeUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String parseUriHost(String str) {
        if (Build.VERSION.SDK_INT < 27) {
            int indexOf = str.indexOf(92);
            if (indexOf == -1) {
                return Uri.parse(str).getHost();
            }
            return Uri.parse(str.substring(0, indexOf)).getHost();
        }
        return Uri.parse(str).getHost();
    }
}
