package com.bytedance.trae.applog.api;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMultiInstanceAppLogService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;", "", "appId", "", "appName", "", "versionCode", "versionName", "updateVersinCode", "channel", "isBoe", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Z)V", "getAppId", "()I", "getAppName", "()Ljava/lang/String;", "getVersionCode", "getVersionName", "getUpdateVersinCode", "getChannel", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MultiInstanceAppLogInitConfig {
    private final int appId;
    private final String appName;
    private final String channel;
    private final boolean isBoe;
    private final int updateVersinCode;
    private final int versionCode;
    private final String versionName;

    public static /* synthetic */ MultiInstanceAppLogInitConfig copy$default(MultiInstanceAppLogInitConfig multiInstanceAppLogInitConfig, int i, String str, int i2, String str2, int i3, String str3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = multiInstanceAppLogInitConfig.appId;
        }
        if ((i4 & 2) != 0) {
            str = multiInstanceAppLogInitConfig.appName;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            i2 = multiInstanceAppLogInitConfig.versionCode;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            str2 = multiInstanceAppLogInitConfig.versionName;
        }
        String str5 = str2;
        if ((i4 & 16) != 0) {
            i3 = multiInstanceAppLogInitConfig.updateVersinCode;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            str3 = multiInstanceAppLogInitConfig.channel;
        }
        String str6 = str3;
        if ((i4 & 64) != 0) {
            z = multiInstanceAppLogInitConfig.isBoe;
        }
        return multiInstanceAppLogInitConfig.copy(i, str4, i5, str5, i6, str6, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUpdateVersinCode() {
        return this.updateVersinCode;
    }

    /* renamed from: component6, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsBoe() {
        return this.isBoe;
    }

    public final MultiInstanceAppLogInitConfig copy(int appId, String appName, int versionCode, String versionName, int updateVersinCode, String channel, boolean isBoe) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return new MultiInstanceAppLogInitConfig(appId, appName, versionCode, versionName, updateVersinCode, channel, isBoe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiInstanceAppLogInitConfig)) {
            return false;
        }
        MultiInstanceAppLogInitConfig multiInstanceAppLogInitConfig = (MultiInstanceAppLogInitConfig) other;
        return this.appId == multiInstanceAppLogInitConfig.appId && Intrinsics.areEqual(this.appName, multiInstanceAppLogInitConfig.appName) && this.versionCode == multiInstanceAppLogInitConfig.versionCode && Intrinsics.areEqual(this.versionName, multiInstanceAppLogInitConfig.versionName) && this.updateVersinCode == multiInstanceAppLogInitConfig.updateVersinCode && Intrinsics.areEqual(this.channel, multiInstanceAppLogInitConfig.channel) && this.isBoe == multiInstanceAppLogInitConfig.isBoe;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.appId) * 31) + this.appName.hashCode()) * 31) + Integer.hashCode(this.versionCode)) * 31) + this.versionName.hashCode()) * 31) + Integer.hashCode(this.updateVersinCode)) * 31) + this.channel.hashCode()) * 31) + Boolean.hashCode(this.isBoe);
    }

    public String toString() {
        return "MultiInstanceAppLogInitConfig(appId=" + this.appId + ", appName=" + this.appName + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", updateVersinCode=" + this.updateVersinCode + ", channel=" + this.channel + ", isBoe=" + this.isBoe + ')';
    }

    public MultiInstanceAppLogInitConfig(int i, String appName, int i2, String versionName, int i3, String channel, boolean z) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.appId = i;
        this.appName = appName;
        this.versionCode = i2;
        this.versionName = versionName;
        this.updateVersinCode = i3;
        this.channel = channel;
        this.isBoe = z;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final int getUpdateVersinCode() {
        return this.updateVersinCode;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }
}
