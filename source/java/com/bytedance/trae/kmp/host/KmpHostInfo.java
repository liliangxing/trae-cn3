package com.bytedance.trae.kmp.host;

import kotlin.Metadata;

/* compiled from: KmpHostEnvironment.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0012\u0010\t\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0012\u0010\u0011\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u0012\u0010\u0015\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000fR\u0012\u0010\u0017\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0012\u0010\u0019\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0012\u0010\u001b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004R\u0012\u0010\u001c\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "", "isAndroid", "", "()Z", "isIOS", "isMainland", "isOversea", "isPublicCloud", "isByteCloud", "isEnterprise", "isLoggedIn", "userId", "", "getUserId", "()Ljava/lang/String;", "isDebug", "deviceId", "getDeviceId", "appVersionName", "getAppVersionName", "languageCode", "getLanguageCode", "storeCountryCode", "getStoreCountryCode", "aiRegion", "getAiRegion", "isEnterpriseBoe", "themeMode", "getThemeMode", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KmpHostInfo {
    String getAiRegion();

    String getAppVersionName();

    String getDeviceId();

    String getLanguageCode();

    String getStoreCountryCode();

    String getThemeMode();

    String getUserId();

    boolean isAndroid();

    boolean isByteCloud();

    boolean isDebug();

    boolean isEnterprise();

    boolean isEnterpriseBoe();

    boolean isIOS();

    boolean isLoggedIn();

    boolean isMainland();

    boolean isOversea();

    boolean isPublicCloud();
}
