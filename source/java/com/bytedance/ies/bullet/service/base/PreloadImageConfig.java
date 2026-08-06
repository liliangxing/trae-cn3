package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadImageConfig;", "", "url", "", "priority", "", "serial", "", com.bytedance.forest.model.PreloadConfig.SUB_KEY_ENABLE_MEMORY, "(Ljava/lang/String;IZZ)V", "getEnableMemory", "()Z", "getPriority", "()I", "getSerial", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreloadImageConfig {
    private final boolean enableMemory;
    private final int priority;
    private final boolean serial;
    private final String url;

    public static /* synthetic */ PreloadImageConfig copy$default(PreloadImageConfig preloadImageConfig, String str, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preloadImageConfig.url;
        }
        if ((i2 & 2) != 0) {
            i = preloadImageConfig.priority;
        }
        if ((i2 & 4) != 0) {
            z = preloadImageConfig.serial;
        }
        if ((i2 & 8) != 0) {
            z2 = preloadImageConfig.enableMemory;
        }
        return preloadImageConfig.copy(str, i, z, z2);
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

    public final PreloadImageConfig copy(String url, int priority, boolean serial, boolean enableMemory) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new PreloadImageConfig(url, priority, serial, enableMemory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloadImageConfig)) {
            return false;
        }
        PreloadImageConfig preloadImageConfig = (PreloadImageConfig) other;
        return Intrinsics.areEqual(this.url, preloadImageConfig.url) && this.priority == preloadImageConfig.priority && this.serial == preloadImageConfig.serial && this.enableMemory == preloadImageConfig.enableMemory;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + Integer.hashCode(this.priority)) * 31) + Boolean.hashCode(this.serial)) * 31) + Boolean.hashCode(this.enableMemory);
    }

    public String toString() {
        return "PreloadImageConfig(url=" + this.url + ", priority=" + this.priority + ", serial=" + this.serial + ", enableMemory=" + this.enableMemory + ')';
    }

    public PreloadImageConfig(String url, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.priority = i;
        this.serial = z;
        this.enableMemory = z2;
    }

    public /* synthetic */ PreloadImageConfig(String str, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? true : z2);
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
}
