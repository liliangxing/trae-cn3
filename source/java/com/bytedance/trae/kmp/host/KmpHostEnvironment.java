package com.bytedance.trae.kmp.host;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHostEnvironment.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001J\b\u0010#\u001a\u00020\u0001H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0014\u0010 \u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\tR\u0014\u0010!\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "<init>", "()V", "hostInfo", "configure", "", "isAndroid", "", "()Z", "isIOS", "isOversea", "isMainland", "isPublicCloud", "isByteCloud", "isEnterprise", "isLoggedIn", "userId", "", "getUserId", "()Ljava/lang/String;", "isDebug", "deviceId", "getDeviceId", "appVersionName", "getAppVersionName", "languageCode", "getLanguageCode", "storeCountryCode", "getStoreCountryCode", "aiRegion", "getAiRegion", "isEnterpriseBoe", "themeMode", "getThemeMode", "requireHostInfo", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpHostEnvironment implements KmpHostInfo {
    private static KmpHostInfo hostInfo;
    public static final KmpHostEnvironment INSTANCE = new KmpHostEnvironment();
    public static final int $stable = 8;

    private KmpHostEnvironment() {
    }

    public final void configure(KmpHostInfo hostInfo2) {
        Intrinsics.checkNotNullParameter(hostInfo2, "hostInfo");
        hostInfo = hostInfo2;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isAndroid() {
        return requireHostInfo().isAndroid();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isIOS() {
        return requireHostInfo().isIOS();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isOversea() {
        return requireHostInfo().isOversea();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isMainland() {
        return requireHostInfo().isMainland();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isPublicCloud() {
        return requireHostInfo().isPublicCloud();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isByteCloud() {
        return requireHostInfo().isByteCloud();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isEnterprise() {
        return requireHostInfo().isEnterprise();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isLoggedIn() {
        return requireHostInfo().isLoggedIn();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getUserId() {
        return requireHostInfo().getUserId();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isDebug() {
        return requireHostInfo().isDebug();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getDeviceId() {
        return requireHostInfo().getDeviceId();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getAppVersionName() {
        return requireHostInfo().getAppVersionName();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getLanguageCode() {
        return requireHostInfo().getLanguageCode();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getStoreCountryCode() {
        return requireHostInfo().getStoreCountryCode();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getAiRegion() {
        return requireHostInfo().getAiRegion();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public boolean isEnterpriseBoe() {
        return requireHostInfo().isEnterpriseBoe();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostInfo
    public String getThemeMode() {
        return requireHostInfo().getThemeMode();
    }

    private final KmpHostInfo requireHostInfo() {
        KmpHostInfo kmpHostInfo = hostInfo;
        if (kmpHostInfo != null) {
            return kmpHostInfo;
        }
        throw new IllegalStateException("KmpHostEnvironment must be configured by host before use.".toString());
    }
}
