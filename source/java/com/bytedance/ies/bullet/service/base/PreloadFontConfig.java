package com.bytedance.ies.bullet.service.base;

import com.bytedance.pia.core.cache.IPiaCacheProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadFontConfig;", "", "url", "", "priority", "", "serial", "", com.bytedance.forest.model.PreloadConfig.SUB_KEY_ENABLE_MEMORY, IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, "", "(Ljava/lang/String;IZZJ)V", "getEnableMemory", "()Z", "getExpire", "()J", "getPriority", "()I", "getSerial", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreloadFontConfig {
    private final boolean enableMemory;
    private final long expire;
    private final int priority;
    private final boolean serial;
    private final String url;

    public static /* synthetic */ PreloadFontConfig copy$default(PreloadFontConfig preloadFontConfig, String str, int i, boolean z, boolean z2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preloadFontConfig.url;
        }
        if ((i2 & 2) != 0) {
            i = preloadFontConfig.priority;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z = preloadFontConfig.serial;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = preloadFontConfig.enableMemory;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            j = preloadFontConfig.expire;
        }
        return preloadFontConfig.copy(str, i3, z3, z4, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSerial() {
        return this.serial;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getEnableMemory() {
        return this.enableMemory;
    }

    /* renamed from: component5, reason: from getter */
    public final long getExpire() {
        return this.expire;
    }

    public final PreloadFontConfig copy(String url, int priority, boolean serial, boolean enableMemory, long expire) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new PreloadFontConfig(url, priority, serial, enableMemory, expire);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloadFontConfig)) {
            return false;
        }
        PreloadFontConfig preloadFontConfig = (PreloadFontConfig) other;
        return Intrinsics.areEqual(this.url, preloadFontConfig.url) && this.priority == preloadFontConfig.priority && this.serial == preloadFontConfig.serial && this.enableMemory == preloadFontConfig.enableMemory && this.expire == preloadFontConfig.expire;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + Integer.hashCode(this.priority)) * 31) + Boolean.hashCode(this.serial)) * 31) + Boolean.hashCode(this.enableMemory)) * 31) + Long.hashCode(this.expire);
    }

    public String toString() {
        return "PreloadFontConfig(url=" + this.url + ", priority=" + this.priority + ", serial=" + this.serial + ", enableMemory=" + this.enableMemory + ", expire=" + this.expire + ')';
    }

    public PreloadFontConfig(String url, int i, boolean z, boolean z2, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.priority = i;
        this.serial = z;
        this.enableMemory = z2;
        this.expire = j;
    }

    public /* synthetic */ PreloadFontConfig(String str, int i, boolean z, boolean z2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? 600000L : j);
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getSerial() {
        return this.serial;
    }

    public final boolean getEnableMemory() {
        return this.enableMemory;
    }

    public final long getExpire() {
        return this.expire;
    }
}
