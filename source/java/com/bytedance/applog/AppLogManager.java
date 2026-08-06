package com.bytedance.applog;

import com.bytedance.applog.util.Utils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AppLogManager {
    public static IAppLogInstance getInstance(String str) {
        if (Utils.isEmpty(str)) {
            return null;
        }
        return AppLogHelper.getInstanceByAppId(str);
    }
}
