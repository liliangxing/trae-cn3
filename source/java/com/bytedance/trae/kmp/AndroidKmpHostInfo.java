package com.bytedance.trae.kmp;

import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.theme.ThemeManager;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.utils.LocaleManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKmpHostInfo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001b\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/trae/kmp/AndroidKmpHostInfo;", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "<init>", "()V", "isAndroid", "", "()Z", "isIOS", "isOversea", "isMainland", "isPublicCloud", "isByteCloud", "isEnterprise", "isLoggedIn", "userId", "", "getUserId", "()Ljava/lang/String;", "isDebug", "deviceId", "getDeviceId", "appVersionName", "getAppVersionName", "languageCode", "getLanguageCode", "storeCountryCode", "getStoreCountryCode", "aiRegion", "getAiRegion", "isEnterpriseBoe", "themeMode", "getThemeMode", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpHostInfo implements KmpHostInfo {
    public static final int $stable = 0;
    private final boolean isAndroid = true;
    private final boolean isIOS;

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    /* renamed from: isAndroid, reason: from getter */
    public boolean getIsAndroid() {
        return this.isAndroid;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    /* renamed from: isIOS, reason: from getter */
    public boolean getIsIOS() {
        return this.isIOS;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isOversea() {
        return AppHost.Companion.isOversea();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isMainland() {
        return !isOversea();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isPublicCloud() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        if (accountInfo != null && accountInfo.getIsLogin()) {
            return (Intrinsics.areEqual(accountInfo.getLoginPlatform(), "bytecloud") || accountInfo.getAccountType() == AccountType.TOB) ? false : true;
        }
        return true;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isByteCloud() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return Intrinsics.areEqual((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getLoginPlatform(), "bytecloud");
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isEnterprise() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return ((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getAccountType()) == AccountType.TOB;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isLoggedIn() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || !accountInfo.getIsLogin()) ? false : true;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getUserId() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
        return userId == null ? "" : userId;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isDebug() {
        return AppHost.Companion.isDebug();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getDeviceId() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            AndroidKmpHostInfo androidKmpHostInfo = this;
            obj = Result.constructor-impl(IApplog.Companion.getDeviceId());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        return (String) obj;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getAppVersionName() {
        return AppHost.Companion.getVersionName();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getLanguageCode() {
        String language = LocaleManager.INSTANCE.getAppLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getStoreCountryCode() {
        String country = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        return country;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getAiRegion() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String aiRegion = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getAiRegion();
        return aiRegion == null ? "" : aiRegion;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isEnterpriseBoe() {
        return DebugSettings.INSTANCE.isEnterpriseTestEnv();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getThemeMode() {
        int currentMode = ThemeManager.INSTANCE.getCurrentMode();
        return currentMode != -1 ? currentMode != 2 ? "light" : "dark" : "system";
    }
}
