package com.vivo.push;

import android.net.Uri;
import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;

/* compiled from: PushConstants.java */
/* renamed from: com.vivo.push.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1402x {

    /* renamed from: a */
    public static final Uri f728a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* renamed from: b */
    public static final Uri f729b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* renamed from: c */
    public static final Uri f730c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* renamed from: d */
    public static final Uri f731d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    /* renamed from: e */
    public static final Uri f732e = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");

    /* renamed from: f */
    public static final Uri f733f = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");

    /* renamed from: a */
    public static String m1070a(int i) {
        switch (i) {
            case 2002:
                return "method_alias_bind";
            case InstallErrorCode.ERROR_NO_INSTALL_PERMISSION /* 2003 */:
                return "method_alias_unbind";
            case InstallErrorCode.ERROR_CANCELED /* 2004 */:
                return "method_tag_bind";
            case InstallErrorCode.ERROR_TTMD5 /* 2005 */:
                return "method_tag_unbind";
            case InstallErrorCode.ERROR_SIGNATURE /* 2006 */:
                return "method_sdk_bind";
            case InstallErrorCode.ERROR_NEED_UPGRADE /* 2007 */:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
