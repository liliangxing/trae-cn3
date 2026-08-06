package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadGeckoChannelConfig;", "Lcom/bytedance/ies/bullet/service/base/PreloadBaseConfig;", "channel", "", "priority", "", "serial", "", "(Ljava/lang/String;IZ)V", "getChannel", "()Ljava/lang/String;", "getPriority", "()I", "getSerial", "()Z", "component1", "component2", "component3", "copy", "equals", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreloadGeckoChannelConfig extends PreloadBaseConfig {
    private final String channel;
    private final int priority;
    private final boolean serial;

    public static /* synthetic */ PreloadGeckoChannelConfig copy$default(PreloadGeckoChannelConfig preloadGeckoChannelConfig, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preloadGeckoChannelConfig.channel;
        }
        if ((i2 & 2) != 0) {
            i = preloadGeckoChannelConfig.priority;
        }
        if ((i2 & 4) != 0) {
            z = preloadGeckoChannelConfig.serial;
        }
        return preloadGeckoChannelConfig.copy(str, i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSerial() {
        return this.serial;
    }

    public final PreloadGeckoChannelConfig copy(String channel, int priority, boolean serial) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        return new PreloadGeckoChannelConfig(channel, priority, serial);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloadGeckoChannelConfig)) {
            return false;
        }
        PreloadGeckoChannelConfig preloadGeckoChannelConfig = (PreloadGeckoChannelConfig) other;
        return Intrinsics.areEqual(this.channel, preloadGeckoChannelConfig.channel) && this.priority == preloadGeckoChannelConfig.priority && this.serial == preloadGeckoChannelConfig.serial;
    }

    public int hashCode() {
        return (((this.channel.hashCode() * 31) + Integer.hashCode(this.priority)) * 31) + Boolean.hashCode(this.serial);
    }

    public String toString() {
        return "PreloadGeckoChannelConfig(channel=" + this.channel + ", priority=" + this.priority + ", serial=" + this.serial + ')';
    }

    public /* synthetic */ PreloadGeckoChannelConfig(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z);
    }

    public final String getChannel() {
        return this.channel;
    }

    @Override // com.bytedance.ies.bullet.service.base.PreloadBaseConfig
    public int getPriority() {
        return this.priority;
    }

    public final boolean getSerial() {
        return this.serial;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadGeckoChannelConfig(String channel, int i, boolean z) {
        super(i);
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.priority = i;
        this.serial = z;
    }
}
