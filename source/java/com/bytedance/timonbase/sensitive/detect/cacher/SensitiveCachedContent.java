package com.bytedance.timonbase.sensitive.detect.cacher;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SensitiveCachedContent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/SensitiveCachedContent;", "", "sensitiveContent", "extra", "", "", "(Ljava/lang/Object;Ljava/util/Map;)V", "getExtra", "()Ljava/util/Map;", "getSensitiveContent", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class SensitiveCachedContent {
    private final Map<String, Object> extra;
    private final Object sensitiveContent;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SensitiveCachedContent copy$default(SensitiveCachedContent sensitiveCachedContent, Object obj, Map map, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = sensitiveCachedContent.sensitiveContent;
        }
        if ((i & 2) != 0) {
            map = sensitiveCachedContent.extra;
        }
        return sensitiveCachedContent.copy(obj, map);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getSensitiveContent() {
        return this.sensitiveContent;
    }

    public final Map<String, Object> component2() {
        return this.extra;
    }

    public final SensitiveCachedContent copy(Object sensitiveContent, Map<String, ? extends Object> extra) {
        Intrinsics.checkParameterIsNotNull(sensitiveContent, "sensitiveContent");
        Intrinsics.checkParameterIsNotNull(extra, "extra");
        return new SensitiveCachedContent(sensitiveContent, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SensitiveCachedContent)) {
            return false;
        }
        SensitiveCachedContent sensitiveCachedContent = (SensitiveCachedContent) other;
        return Intrinsics.areEqual(this.sensitiveContent, sensitiveCachedContent.sensitiveContent) && Intrinsics.areEqual(this.extra, sensitiveCachedContent.extra);
    }

    public int hashCode() {
        Object obj = this.sensitiveContent;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Map<String, Object> map = this.extra;
        return hashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SensitiveCachedContent(sensitiveContent=" + this.sensitiveContent + ", extra=" + this.extra + ")";
    }

    public SensitiveCachedContent(Object sensitiveContent, Map<String, ? extends Object> extra) {
        Intrinsics.checkParameterIsNotNull(sensitiveContent, "sensitiveContent");
        Intrinsics.checkParameterIsNotNull(extra, "extra");
        this.sensitiveContent = sensitiveContent;
        this.extra = extra;
    }

    public final Object getSensitiveContent() {
        return this.sensitiveContent;
    }

    public /* synthetic */ SensitiveCachedContent(Object obj, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }
}
