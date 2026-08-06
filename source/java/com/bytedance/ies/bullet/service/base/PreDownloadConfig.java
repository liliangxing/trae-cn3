package com.bytedance.ies.bullet.service.base;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreDownloadConfig;", "", "url", "", "", "loaderType", "Lcom/bytedance/ies/bullet/service/base/PreloadSourceType;", "priority", "", "serial", "", "(Ljava/util/List;Lcom/bytedance/ies/bullet/service/base/PreloadSourceType;IZ)V", "getLoaderType", "()Lcom/bytedance/ies/bullet/service/base/PreloadSourceType;", "getPriority", "()I", "getSerial", "()Z", "getUrl", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreDownloadConfig {
    private final PreloadSourceType loaderType;
    private final int priority;
    private final boolean serial;
    private final List<String> url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreDownloadConfig copy$default(PreDownloadConfig preDownloadConfig, List list, PreloadSourceType preloadSourceType, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = preDownloadConfig.url;
        }
        if ((i2 & 2) != 0) {
            preloadSourceType = preDownloadConfig.loaderType;
        }
        if ((i2 & 4) != 0) {
            i = preDownloadConfig.priority;
        }
        if ((i2 & 8) != 0) {
            z = preDownloadConfig.serial;
        }
        return preDownloadConfig.copy(list, preloadSourceType, i, z);
    }

    public final List<String> component1() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final PreloadSourceType getLoaderType() {
        return this.loaderType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSerial() {
        return this.serial;
    }

    public final PreDownloadConfig copy(List<String> url, PreloadSourceType loaderType, int priority, boolean serial) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(loaderType, "loaderType");
        return new PreDownloadConfig(url, loaderType, priority, serial);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreDownloadConfig)) {
            return false;
        }
        PreDownloadConfig preDownloadConfig = (PreDownloadConfig) other;
        return Intrinsics.areEqual(this.url, preDownloadConfig.url) && this.loaderType == preDownloadConfig.loaderType && this.priority == preDownloadConfig.priority && this.serial == preDownloadConfig.serial;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.loaderType.hashCode()) * 31) + Integer.hashCode(this.priority)) * 31) + Boolean.hashCode(this.serial);
    }

    public String toString() {
        return "PreDownloadConfig(url=" + this.url + ", loaderType=" + this.loaderType + ", priority=" + this.priority + ", serial=" + this.serial + ')';
    }

    public PreDownloadConfig(List<String> url, PreloadSourceType loaderType, int i, boolean z) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(loaderType, "loaderType");
        this.url = url;
        this.loaderType = loaderType;
        this.priority = i;
        this.serial = z;
    }

    public /* synthetic */ PreDownloadConfig(List list, PreloadSourceType preloadSourceType, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, preloadSourceType, i, (i2 & 8) != 0 ? false : z);
    }

    public final List<String> getUrl() {
        return this.url;
    }

    public final PreloadSourceType getLoaderType() {
        return this.loaderType;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getSerial() {
        return this.serial;
    }
}
