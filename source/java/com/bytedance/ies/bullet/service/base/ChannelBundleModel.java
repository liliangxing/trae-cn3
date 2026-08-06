package com.bytedance.ies.bullet.service.base;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISchemaService.kt */
@Deprecated(message = "Only for LuckyCat plugin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ChannelBundleModel;", "", "channel", "", "bundlePath", "valid", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBundlePath", "()Ljava/lang/String;", "setBundlePath", "(Ljava/lang/String;)V", "getChannel", "setChannel", "getValid", "()Z", "setValid", "(Z)V", "component1", "component2", "component3", "copy", "equals", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "", "provideChannel", "providerBundlePath", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ChannelBundleModel {
    private String bundlePath;
    private String channel;
    private boolean valid;

    public static /* synthetic */ ChannelBundleModel copy$default(ChannelBundleModel channelBundleModel, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelBundleModel.channel;
        }
        if ((i & 2) != 0) {
            str2 = channelBundleModel.bundlePath;
        }
        if ((i & 4) != 0) {
            z = channelBundleModel.valid;
        }
        return channelBundleModel.copy(str, str2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBundlePath() {
        return this.bundlePath;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getValid() {
        return this.valid;
    }

    public final ChannelBundleModel copy(String channel, String bundlePath, boolean valid) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(bundlePath, "bundlePath");
        return new ChannelBundleModel(channel, bundlePath, valid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelBundleModel)) {
            return false;
        }
        ChannelBundleModel channelBundleModel = (ChannelBundleModel) other;
        return Intrinsics.areEqual(this.channel, channelBundleModel.channel) && Intrinsics.areEqual(this.bundlePath, channelBundleModel.bundlePath) && this.valid == channelBundleModel.valid;
    }

    public int hashCode() {
        return (((this.channel.hashCode() * 31) + this.bundlePath.hashCode()) * 31) + Boolean.hashCode(this.valid);
    }

    public String toString() {
        return "ChannelBundleModel(channel=" + this.channel + ", bundlePath=" + this.bundlePath + ", valid=" + this.valid + ')';
    }

    public ChannelBundleModel(String channel, String bundlePath, boolean z) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(bundlePath, "bundlePath");
        this.channel = channel;
        this.bundlePath = bundlePath;
        this.valid = z;
    }

    public final String getBundlePath() {
        return this.bundlePath;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final boolean getValid() {
        return this.valid;
    }

    public final void setBundlePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bundlePath = str;
    }

    public final void setChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channel = str;
    }

    public final void setValid(boolean z) {
        this.valid = z;
    }

    public final String provideChannel() {
        if (this.valid) {
            return this.channel;
        }
        return null;
    }

    public final String providerBundlePath() {
        if (this.valid) {
            return this.bundlePath;
        }
        return null;
    }
}
