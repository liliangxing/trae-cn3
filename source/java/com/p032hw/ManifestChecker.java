package com.p032hw;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.ManifestUtils;
import com.huawei.hms.utils.Util;
import java.util.Collections;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class ManifestChecker {
    ManifestChecker() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkManifest(String str, Context context) throws PackageManager.NameNotFoundException {
        return checkComponents(context, str) & checkKeys(str, context);
    }

    private static boolean checkComponents(Context context, String str) throws PackageManager.NameNotFoundException {
        return ManifestUtils.checkService(context, str, HWPushAdapter.TAG, Collections.singletonList(Component.Builder.create("com.huawei.MessageService").setProcess(context.getPackageName()).addIntentFilter(new Component.IntentFilter(Collections.singletonList("com.huawei.push.action.MESSAGING_EVENT"))).build()));
    }

    private static boolean checkKeys(String str, Context context) {
        if (!TextUtils.isEmpty(Util.getAppId(context))) {
            return true;
        }
        Logger.d(str, "HWPush. You need to declare metadata \"com.huawei.hms.client.appid \" in AndroidManifest.xml");
        return false;
    }
}
