package com.bytedance.sdk.open.aweme.base;

/* loaded from: classes5.dex */
public interface IAPPCheckHelper {
    String buildComponentClassName(String str, String str2);

    String getPackageName();

    String getRemoteAuthEntryActivity();

    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    boolean isAppSupportShare();
}
