package com.bytedance.ug.sdk.deeplink.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.huawei.hms.android.SystemUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class CommonUtils {
    private static final String SEARCH_BOX_PACKAGE_NAME = "com.baidu.searchbox";
    private static final AtomicBoolean isAlreadySetOrigin = new AtomicBoolean(false);
    public static boolean isJumpFromBaidu;

    private CommonUtils() {
    }

    public static boolean isHuaWei() {
        return Build.MANUFACTURER != null && (Build.MANUFACTURER.toUpperCase(Locale.getDefault()).contains(SystemUtils.PRODUCT_HUAWEI) || Build.MANUFACTURER.toUpperCase(Locale.getDefault()).contains("HONOR"));
    }

    public static boolean isFirstStartAfterInstalled(Context context, String str) {
        if (context == null || SharedPreferencesHelper.getInstance(context).getBoolean(str)) {
            return false;
        }
        SharedPreferencesHelper.getInstance(context).putBoolean(str, true);
        return true;
    }

    public static boolean isInWhiteList(Activity activity) {
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        List<String> deepLinkActivities = zlinkDepend != null ? zlinkDepend.getDeepLinkActivities() : null;
        if (CollectionsUtils.isEmptyList(deepLinkActivities)) {
            return true;
        }
        String canonicalName = activity.getClass().getCanonicalName();
        Iterator<String> it = deepLinkActivities.iterator();
        while (it.hasNext()) {
            if (canonicalName.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void recordFromBaiduWhenColdStart(Activity activity) {
        if (activity != null && isAlreadySetOrigin.compareAndSet(false, true)) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mReferrer");
                declaredField.setAccessible(true);
                isJumpFromBaidu = SEARCH_BOX_PACKAGE_NAME.equals((String) declaredField.get(activity));
            } catch (Exception unused) {
            }
        }
    }
}
