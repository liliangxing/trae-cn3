package com.bytedance.ies.bullet.ug;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletOptimize.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/ug/BulletOptimizeConfig;", "", "initializer", "Lcom/bytedance/ies/bullet/ug/SDKInitializer;", "(Lcom/bytedance/ies/bullet/ug/SDKInitializer;)V", "getInitializer", "()Lcom/bytedance/ies/bullet/ug/SDKInitializer;", "prefetchPages", "", "", "getPrefetchPages", "()Ljava/util/List;", "setPrefetchPages", "(Ljava/util/List;)V", "preloadPages", "getPreloadPages", "setPreloadPages", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BulletOptimizeConfig {
    private final SDKInitializer initializer;
    private List<String> prefetchPages;
    private List<String> preloadPages;

    public BulletOptimizeConfig(SDKInitializer initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        this.preloadPages = new ArrayList();
        this.prefetchPages = new ArrayList();
    }

    public final SDKInitializer getInitializer() {
        return this.initializer;
    }

    public final List<String> getPreloadPages() {
        return this.preloadPages;
    }

    public final void setPreloadPages(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.preloadPages = list;
    }

    public final List<String> getPrefetchPages() {
        return this.prefetchPages;
    }

    public final void setPrefetchPages(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.prefetchPages = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("preloadPages\n");
        Iterator<String> it = this.preloadPages.iterator();
        while (it.hasNext()) {
            sb.append("  " + it.next());
        }
        sb.append("prefetchPages\n");
        Iterator<String> it2 = this.prefetchPages.iterator();
        while (it2.hasNext()) {
            sb.append("  " + it2.next());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
