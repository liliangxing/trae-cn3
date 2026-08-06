package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreRenderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/Event;", "", "originSchema", "Landroid/net/Uri;", "uniqueSchema", "cacheType", "Lcom/bytedance/ies/bullet/service/base/CacheType;", "(Landroid/net/Uri;Landroid/net/Uri;Lcom/bytedance/ies/bullet/service/base/CacheType;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "setCacheKey", "(Ljava/lang/String;)V", "getCacheType", "()Lcom/bytedance/ies/bullet/service/base/CacheType;", "getOriginSchema", "()Landroid/net/Uri;", "getUniqueSchema", "component1", "component2", "component3", "copy", "equals", "", com.bytedance.forest.model.PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Event {
    private String cacheKey;
    private final CacheType cacheType;
    private final Uri originSchema;
    private final Uri uniqueSchema;

    public static /* synthetic */ Event copy$default(Event event, Uri uri, Uri uri2, CacheType cacheType, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = event.originSchema;
        }
        if ((i & 2) != 0) {
            uri2 = event.uniqueSchema;
        }
        if ((i & 4) != 0) {
            cacheType = event.cacheType;
        }
        return event.copy(uri, uri2, cacheType);
    }

    /* renamed from: component1, reason: from getter */
    public final Uri getOriginSchema() {
        return this.originSchema;
    }

    /* renamed from: component2, reason: from getter */
    public final Uri getUniqueSchema() {
        return this.uniqueSchema;
    }

    /* renamed from: component3, reason: from getter */
    public final CacheType getCacheType() {
        return this.cacheType;
    }

    public final Event copy(Uri originSchema, Uri uniqueSchema, CacheType cacheType) {
        Intrinsics.checkNotNullParameter(originSchema, "originSchema");
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        return new Event(originSchema, uniqueSchema, cacheType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event event = (Event) other;
        return Intrinsics.areEqual(this.originSchema, event.originSchema) && Intrinsics.areEqual(this.uniqueSchema, event.uniqueSchema) && this.cacheType == event.cacheType;
    }

    public int hashCode() {
        return (((this.originSchema.hashCode() * 31) + this.uniqueSchema.hashCode()) * 31) + this.cacheType.hashCode();
    }

    public String toString() {
        return "Event(originSchema=" + this.originSchema + ", uniqueSchema=" + this.uniqueSchema + ", cacheType=" + this.cacheType + ')';
    }

    public Event(Uri originSchema, Uri uniqueSchema, CacheType cacheType) {
        Intrinsics.checkNotNullParameter(originSchema, "originSchema");
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        this.originSchema = originSchema;
        this.uniqueSchema = uniqueSchema;
        this.cacheType = cacheType;
    }

    public final Uri getOriginSchema() {
        return this.originSchema;
    }

    public final Uri getUniqueSchema() {
        return this.uniqueSchema;
    }

    public final CacheType getCacheType() {
        return this.cacheType;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final void setCacheKey(String str) {
        this.cacheKey = str;
    }
}
