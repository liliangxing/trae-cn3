package com.honor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.ManifestUtils;
import com.honor.runable.GetTokenAndUploadRunnable;
import java.util.Collections;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ManifestChecker {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkManifest(String str, Context context) throws PackageManager.NameNotFoundException {
        return checkComponents(context, str) && checkKeys(str, context);
    }

    private static boolean checkComponents(Context context, String str) throws PackageManager.NameNotFoundException {
        return ManifestUtils.checkService(context, str, GetTokenAndUploadRunnable.TAG, Collections.singletonList(Component.Builder.create("com.honor.HonorMessageListenerService").setProcess(context.getPackageName()).addIntentFilter(new Component.IntentFilter(Collections.singletonList("com.hihonor.push.action.MESSAGING_EVENT"))).build()));
    }

    private static boolean checkKeys(String str, Context context) {
        String str2;
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.hihonor.push.app_id").toString();
        } catch (Throwable unused) {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        Logger.d(str, "HonorPush. You need to declare metadata \"com.hihonor.push.app_id \" in AndroidManifest.xml");
        return false;
    }
}
