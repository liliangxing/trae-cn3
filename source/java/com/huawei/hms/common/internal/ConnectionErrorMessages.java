package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ConnectionErrorMessages {
    /* renamed from: a */
    private static boolean m1116a(Context context) {
        return context != null && Util.isAvailableLibExist(context) && AvailableUtil.isInstallerLibExist(context);
    }

    public static String getErrorDialogButtonMessage(Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1) {
            if (m1116a(activity)) {
                return ResourceLoaderUtil.getString("hms_install");
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        }
        if (i != 2) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }
        if (m1116a(activity)) {
            return ResourceLoaderUtil.getString("hms_update");
        }
        return ResourceLoaderUtil.getString("hms_confirm");
    }

    public static String getErrorMessage(Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i != 1 && i != 2) {
            return null;
        }
        if (m1116a(activity)) {
            return ResourceLoaderUtil.getString("hms_update_title");
        }
        return activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), new Object[]{Util.getAppName(activity, activity.getPackageName())});
    }

    public static String getErrorTitle(Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1) {
            if (m1116a(activity)) {
                return ResourceLoaderUtil.getString("hms_install_message");
            }
            return null;
        }
        if (i == 2) {
            if (m1116a(activity)) {
                return ResourceLoaderUtil.getString("hms_update_message");
            }
            return null;
        }
        if (i == 3) {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
        }
        if (i != 9) {
            HMSLog.m2118e("HuaweiApiAvailability", "Unexpected error code " + i);
            return null;
        }
        HMSLog.m2118e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
        return null;
    }
}
