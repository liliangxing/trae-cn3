package com.bytedance.ies.bullet.service.base;

import com.bytedance.pia.core.cache.IPiaCacheProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadJsConfig;", "", "url", "", "priority", "", "serial", "", com.bytedance.forest.model.PreloadConfig.SUB_KEY_ENABLE_MEMORY, "memoryPriority", IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, "", "(Ljava/lang/String;IZZLjava/lang/String;J)V", "getEnableMemory", "()Z", "getExpire", "()J", "getMemoryPriority", "()Ljava/lang/String;", "getPriority", "()I", "getSerial", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreloadJsConfig {
    private final boolean enableMemory;
    private final long expire;
    private final String memoryPriority;
    private final int priority;
    private final boolean serial;
    private final String url;

    public static /* synthetic */ PreloadJsConfig copy$default(PreloadJsConfig preloadJsConfig, String str, int i, boolean z, boolean z2, String str2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preloadJsConfig.url;
        }
        if ((i2 & 2) != 0) {
            i = preloadJsConfig.priority;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z = preloadJsConfig.serial;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = preloadJsConfig.enableMemory;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            str2 = preloadJsConfig.memoryPriority;
        }
        String str3 = str2;
        if ((i2 & 32) != 0) {
            j = preloadJsConfig.expire;
        }
        return preloadJsConfig.copy(str, i3, z3, z4, str3, j);
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
    public final String getMemoryPriority() {
        return this.memoryPriority;
    }

    /* renamed from: component6, reason: from getter */
    public final long getExpire() {
        return this.expire;
    }

    public final PreloadJsConfig copy(String url, int priority, boolean serial, boolean enableMemory, String memoryPriority, long expire) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(memoryPriority, "memoryPriority");
        return new PreloadJsConfig(url, priority, serial, enableMemory, memoryPriority, expire);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloadJsConfig)) {
            return false;
        }
        PreloadJsConfig preloadJsConfig = (PreloadJsConfig) other;
        return Intrinsics.areEqual(this.url, preloadJsConfig.url) && this.priority == preloadJsConfig.priority && this.serial == preloadJsConfig.serial && this.enableMemory == preloadJsConfig.enableMemory && Intrinsics.areEqual(this.memoryPriority, preloadJsConfig.memoryPriority) && this.expire == preloadJsConfig.expire;
    }

    public int hashCode() {
        return (((((((((this.url.hashCode() * 31) + Integer.hashCode(this.priority)) * 31) + Boolean.hashCode(this.serial)) * 31) + Boolean.hashCode(this.enableMemory)) * 31) + this.memoryPriority.hashCode()) * 31) + Long.hashCode(this.expire);
    }

    public String toString() {
        return "PreloadJsConfig(url=" + this.url + ", priority=" + this.priority + ", serial=" + this.serial + ", enableMemory=" + this.enableMemory + ", memoryPriority=" + this.memoryPriority + ", expire=" + this.expire + ')';
    }

    public PreloadJsConfig(String url, int i, boolean z, boolean z2, String memoryPriority, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(memoryPriority, "memoryPriority");
        this.url = url;
        this.priority = i;
        this.serial = z;
        this.enableMemory = z2;
        this.memoryPriority = memoryPriority;
        this.expire = j;
    }

    public /* synthetic */ PreloadJsConfig(String str, int i, boolean z, boolean z2, String str2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? true : z2, str2, (i2 & 32) != 0 ? 600000L : j);
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

    public final String getMemoryPriority() {
        return this.memoryPriority;
    }

    public final long getExpire() {
        return this.expire;
    }
}
