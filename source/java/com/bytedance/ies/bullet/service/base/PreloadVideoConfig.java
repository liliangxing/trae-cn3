package com.bytedance.ies.bullet.service.base;

import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadVideoConfig;", "", "id", "", "h265", "", "uri", "url", "", "priority", "", "serial", com.bytedance.forest.model.PreloadConfig.SUB_KEY_ENABLE_MEMORY, IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;IZZJ)V", "getEnableMemory", "()Z", "getExpire", "()J", "getH265", "getId", "()Ljava/lang/String;", "getPriority", "()I", "getSerial", "getUri", "getUrl", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreloadVideoConfig {
    private final boolean enableMemory;
    private final long expire;
    private final boolean h265;
    private final String id;
    private final int priority;
    private final boolean serial;
    private final String uri;
    private final List<String> url;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getH265() {
        return this.h265;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    public final List<String> component4() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getSerial() {
        return this.serial;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getEnableMemory() {
        return this.enableMemory;
    }

    /* renamed from: component8, reason: from getter */
    public final long getExpire() {
        return this.expire;
    }

    public final PreloadVideoConfig copy(String id, boolean h265, String uri, List<String> url, int priority, boolean serial, boolean enableMemory, long expire) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(url, "url");
        return new PreloadVideoConfig(id, h265, uri, url, priority, serial, enableMemory, expire);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloadVideoConfig)) {
            return false;
        }
        PreloadVideoConfig preloadVideoConfig = (PreloadVideoConfig) other;
        return Intrinsics.areEqual(this.id, preloadVideoConfig.id) && this.h265 == preloadVideoConfig.h265 && Intrinsics.areEqual(this.uri, preloadVideoConfig.uri) && Intrinsics.areEqual(this.url, preloadVideoConfig.url) && this.priority == preloadVideoConfig.priority && this.serial == preloadVideoConfig.serial && this.enableMemory == preloadVideoConfig.enableMemory && this.expire == preloadVideoConfig.expire;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + Boolean.hashCode(this.h265)) * 31) + this.uri.hashCode()) * 31) + this.url.hashCode()) * 31) + Integer.hashCode(this.priority)) * 31) + Boolean.hashCode(this.serial)) * 31) + Boolean.hashCode(this.enableMemory)) * 31) + Long.hashCode(this.expire);
    }

    public String toString() {
        return "PreloadVideoConfig(id=" + this.id + ", h265=" + this.h265 + ", uri=" + this.uri + ", url=" + this.url + ", priority=" + this.priority + ", serial=" + this.serial + ", enableMemory=" + this.enableMemory + ", expire=" + this.expire + ')';
    }

    public PreloadVideoConfig(String id, boolean z, String uri, List<String> url, int i, boolean z2, boolean z3, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.h265 = z;
        this.uri = uri;
        this.url = url;
        this.priority = i;
        this.serial = z2;
        this.enableMemory = z3;
        this.expire = j;
    }

    public /* synthetic */ PreloadVideoConfig(String str, boolean z, String str2, List list, int i, boolean z2, boolean z3, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, str2, list, i, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? true : z3, (i2 & 128) != 0 ? 600000L : j);
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getH265() {
        return this.h265;
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getUrl() {
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
