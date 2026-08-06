package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.UUID;

/* compiled from: AaidUtils.java */
/* renamed from: com.huawei.hms.opendevice.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1194b {
    /* renamed from: a */
    public static DeleteTokenReq m1840a(Context context, String str, String str2, String str3, String str4) {
        DeleteTokenReq deleteTokenReq = new DeleteTokenReq();
        deleteTokenReq.setAppId(str);
        deleteTokenReq.setScope(str4);
        deleteTokenReq.setProjectId(str2);
        deleteTokenReq.setPkgName(context.getPackageName());
        deleteTokenReq.setSubjectId(str3);
        if (TextUtils.isEmpty(str)) {
            deleteTokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(str4)) {
            deleteTokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        if (TextUtils.isEmpty(str2)) {
            deleteTokenReq.setProjectId(m1845c(context));
        }
        return deleteTokenReq;
    }

    /* renamed from: b */
    public static TokenReq m1842b(Context context, String str, String str2) {
        return m1843b(context, str, null, null, str2);
    }

    /* renamed from: c */
    public static String m1845c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    /* renamed from: d */
    public static boolean m1846d(Context context) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                if (!TextUtils.isEmpty(bundle.getString("com.huawei.hms.client.service.name:base"))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            HMSLog.m2118e(HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
            return true;
        }
    }

    /* renamed from: b */
    public static TokenReq m1841b(Context context, String str) {
        return m1843b(context, null, null, str, null);
    }

    /* renamed from: b */
    public static TokenReq m1843b(Context context, String str, String str2, String str3, String str4) {
        TokenReq tokenReq = new TokenReq();
        tokenReq.setPackageName(context.getPackageName());
        tokenReq.setAppId(str);
        tokenReq.setScope(str4);
        tokenReq.setProjectId(str2);
        tokenReq.setSubjectId(str3);
        tokenReq.setMultiSender(false);
        if (TextUtils.isEmpty(str)) {
            tokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(str2)) {
            tokenReq.setProjectId(m1845c(context));
        }
        if (TextUtils.isEmpty(str4)) {
            tokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        C1201i m1865a = C1201i.m1865a(context);
        if (!m1865a.getBoolean("hasRequestAgreement")) {
            tokenReq.setFirstTime(true);
            m1865a.saveBoolean("hasRequestAgreement", true);
        } else {
            tokenReq.setFirstTime(false);
        }
        return tokenReq;
    }

    /* renamed from: a */
    public static DeleteTokenReq m1839a(Context context, String str, String str2) {
        return m1840a(context, str, null, null, str2);
    }

    /* renamed from: a */
    public static DeleteTokenReq m1838a(Context context, String str) {
        return m1840a(context, null, null, str, null);
    }

    /* renamed from: a */
    public static DeleteTokenReq m1837a(Context context) {
        return m1840a(context, null, null, null, null);
    }

    /* renamed from: b */
    public static synchronized String m1844b(Context context) {
        String uuid;
        synchronized (C1194b.class) {
            PushPreferences pushPreferences = new PushPreferences(context, "aaid");
            if (pushPreferences.containsKey("aaid")) {
                uuid = pushPreferences.getString("aaid");
            } else {
                uuid = UUID.randomUUID().toString();
                pushPreferences.saveString("aaid", uuid);
                pushPreferences.saveLong("creationTime", Long.valueOf(System.currentTimeMillis()));
            }
        }
        return uuid;
    }
}
