package com.bytedance.push.debug;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.ManifestUtils;
import com.ss.android.message.NotifyService;
import com.ss.android.message.log.LogService;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ManifestChecker {
    public static boolean checkConfig(Context context, String str) throws PackageManager.NameNotFoundException {
        return checkContentProvider(context, str) & checkService(context, str);
    }

    private static boolean checkContentProvider(Context context, String str) throws PackageManager.NameNotFoundException {
        return ManifestUtils.checkContentProviders(context, str, "Push", Arrays.asList(Component.Builder.create(PushMultiProcessSharedProvider.class.getName()).setProcess(context.getPackageName()).setAuthorities(context.getPackageName() + ".push.SHARE_PROVIDER_AUTHORITY").build()));
    }

    private static boolean checkService(Context context, String str) throws PackageManager.NameNotFoundException {
        return ManifestUtils.checkService(context, str, "Push", Arrays.asList(Component.Builder.create(NotifyService.class.getName()).setProcess(context.getPackageName() + ":push").addIntentFilter(new Component.IntentFilter(Arrays.asList("com.ss.android.message.action.PUSH_SERVICE"))).build(), Component.Builder.create(LogService.class.getName()).setProcess(context.getPackageName() + ":push").build()));
    }
}
