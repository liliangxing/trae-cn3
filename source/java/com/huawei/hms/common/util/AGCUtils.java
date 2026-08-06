package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AGCUtils {
    /* renamed from: b */
    private static String m1138b(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m2118e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("com.huawei.hms.client.cpid")) != null) {
                String valueOf = String.valueOf(obj);
                return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
            }
            HMSLog.m2120i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (AndroidException unused) {
            HMSLog.m2118e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (RuntimeException e) {
            HMSLog.m2119e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e);
            return "";
        }
    }

    /* renamed from: c */
    private static boolean m1139c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context context) {
        String str;
        if (context == null) {
            HMSLog.m2121w("AGCUtils", "getAppId context is null");
            return "";
        }
        if (m1139c(context)) {
            str = m1137a(context, "client/app_id");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } else {
            str = null;
        }
        try {
            AGConnectInstance aGConnectInstance = AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.m2118e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String m1136a = m1136a(context);
        return !TextUtils.isEmpty(m1136a) ? m1136a : m1137a(context, "client/app_id");
    }

    public static String getCpId(Context context) {
        String str;
        if (context == null) {
            HMSLog.m2121w("AGCUtils", "getCpId context is null");
            return "";
        }
        if (m1139c(context)) {
            return m1137a(context, "client/cp_id");
        }
        try {
            AGConnectInstance aGConnectInstance = AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.m2118e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String m1138b = m1138b(context);
        return !TextUtils.isEmpty(m1138b) ? m1138b : m1137a(context, "client/cp_id");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String m1137a(Context context, String str) {
        String str2;
        InputStream inputStream = null;
        try {
            try {
                try {
                    AGConnectOptionsBuilder aGConnectOptionsBuilder = new AGConnectOptionsBuilder();
                    inputStream = context.getResources().getAssets().open("agconnect-services.json");
                    aGConnectOptionsBuilder.setInputStream(inputStream);
                    str2 = aGConnectOptionsBuilder.build(context).getString(str);
                } catch (IOException e) {
                    HMSLog.m2118e("AGCUtils", "Get " + str + " failed: " + e);
                    str2 = "";
                    IOUtils.closeQuietly(inputStream);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            } catch (NullPointerException e2) {
                HMSLog.m2118e("AGCUtils", "Get " + str + " with AGConnectServicesConfig failed: " + e2);
                str2 = "";
                IOUtils.closeQuietly(inputStream);
                if (!TextUtils.isEmpty(str2)) {
                }
            }
            IOUtils.closeQuietly(inputStream);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            HMSLog.m2118e("AGCUtils", "The " + str + " is null.");
            return "";
        } catch (Throwable th) {
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m1136a(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m2118e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("com.huawei.hms.client.appid")) != null) {
                String valueOf = String.valueOf(obj);
                return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
            }
            HMSLog.m2118e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (AndroidException unused) {
            HMSLog.m2118e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (RuntimeException e) {
            HMSLog.m2119e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e);
            return "";
        }
    }
}
