package com.bytedance.android.live.setting;

import android.content.Context;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveSettingContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/setting/LiveSettingContext;", "", "context", "Landroid/content/Context;", "appId", "", "deviceId", "channel", "localTest", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAppId", "()Ljava/lang/String;", "getChannel", "getContext", "()Landroid/content/Context;", "getDeviceId", "getLocalTest", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final /* data */ class LiveSettingContext {
    private final String appId;
    private final String channel;
    private final Context context;
    private final String deviceId;
    private final boolean localTest;

    public static /* synthetic */ LiveSettingContext copy$default(LiveSettingContext liveSettingContext, Context context, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            context = liveSettingContext.context;
        }
        if ((i & 2) != 0) {
            str = liveSettingContext.appId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = liveSettingContext.deviceId;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = liveSettingContext.channel;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            z = liveSettingContext.localTest;
        }
        return liveSettingContext.copy(context, str4, str5, str6, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getLocalTest() {
        return this.localTest;
    }

    public final LiveSettingContext copy(Context context, String appId, String deviceId, String channel, boolean localTest) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return new LiveSettingContext(context, appId, deviceId, channel, localTest);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveSettingContext)) {
            return false;
        }
        LiveSettingContext liveSettingContext = (LiveSettingContext) other;
        return Intrinsics.areEqual(this.context, liveSettingContext.context) && Intrinsics.areEqual(this.appId, liveSettingContext.appId) && Intrinsics.areEqual(this.deviceId, liveSettingContext.deviceId) && Intrinsics.areEqual(this.channel, liveSettingContext.channel) && this.localTest == liveSettingContext.localTest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Context context = this.context;
        int hashCode = (context != null ? context.hashCode() : 0) * 31;
        String str = this.appId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.deviceId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channel;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.localTest;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "LiveSettingContext(context=" + this.context + ", appId=" + this.appId + ", deviceId=" + this.deviceId + ", channel=" + this.channel + ", localTest=" + this.localTest + ")";
    }

    public LiveSettingContext(Context context, String appId, String deviceId, String channel, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.context = context;
        this.appId = appId;
        this.deviceId = deviceId;
        this.channel = channel;
        this.localTest = z;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final boolean getLocalTest() {
        return this.localTest;
    }
}
