package com.bytedance.ies.bullet.service.base.settings;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletSettingsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/AppInfo;", "", "appId", "", "appVersion", "installId", CommonConstants.KEY_DEVICE_ID, "channel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppVersion", "getChannel", "getDid", "getInstallId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AppInfo {
    private final String appId;
    private final String appVersion;
    private final String channel;
    private final String did;
    private final String installId;

    public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appInfo.appId;
        }
        if ((i & 2) != 0) {
            str2 = appInfo.appVersion;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = appInfo.installId;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = appInfo.did;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = appInfo.channel;
        }
        return appInfo.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInstallId() {
        return this.installId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDid() {
        return this.did;
    }

    /* renamed from: component5, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    public final AppInfo copy(String appId, String appVersion, String installId, String did, String channel) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(installId, "installId");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return new AppInfo(appId, appVersion, installId, did, channel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) other;
        return Intrinsics.areEqual(this.appId, appInfo.appId) && Intrinsics.areEqual(this.appVersion, appInfo.appVersion) && Intrinsics.areEqual(this.installId, appInfo.installId) && Intrinsics.areEqual(this.did, appInfo.did) && Intrinsics.areEqual(this.channel, appInfo.channel);
    }

    public int hashCode() {
        return (((((((this.appId.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.installId.hashCode()) * 31) + this.did.hashCode()) * 31) + this.channel.hashCode();
    }

    public String toString() {
        return "AppInfo(appId=" + this.appId + ", appVersion=" + this.appVersion + ", installId=" + this.installId + ", did=" + this.did + ", channel=" + this.channel + ')';
    }

    public AppInfo(String appId, String appVersion, String installId, String did, String channel) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(installId, "installId");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.appId = appId;
        this.appVersion = appVersion;
        this.installId = installId;
        this.did = did;
        this.channel = channel;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getInstallId() {
        return this.installId;
    }

    public final String getDid() {
        return this.did;
    }

    public final String getChannel() {
        return this.channel;
    }
}
