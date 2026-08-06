package com.larus.business.markdown.api.common;

import android.content.Context;
import io.noties.markwon.image.AsyncDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowMarkdownReuseDrawablePool.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ)\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\f\u0010\u0017\u001a\u00020\u000b*\u00020\u000fH\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "", "maxSize", "", "(I)V", "lastCreateIsDarkMode", "", "Ljava/lang/Boolean;", "pool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawableLruCache;", "clear", "", "obtain", "Lio/noties/markwon/image/AsyncDrawable;", "context", "Landroid/content/Context;", "urlKey", "", "order", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)Lio/noties/markwon/image/AsyncDrawable;", "recycle", "drawable", "(Lio/noties/markwon/image/AsyncDrawable;Ljava/lang/Integer;)V", "updateCacheStatus", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class FlowMarkdownReuseDrawablePool {
    private Boolean lastCreateIsDarkMode;
    private final FlowMarkdownReuseDrawableLruCache pool;

    public FlowMarkdownReuseDrawablePool() {
        this(0, 1, null);
    }

    public FlowMarkdownReuseDrawablePool(int i) {
        this.pool = new FlowMarkdownReuseDrawableLruCache(i);
    }

    public /* synthetic */ FlowMarkdownReuseDrawablePool(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 20 : i);
    }

    public static /* synthetic */ void recycle$default(FlowMarkdownReuseDrawablePool flowMarkdownReuseDrawablePool, AsyncDrawable asyncDrawable, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = 0;
        }
        flowMarkdownReuseDrawablePool.recycle(asyncDrawable, num);
    }

    public final void recycle(AsyncDrawable drawable, Integer order) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        FlowMarkdownReuseDrawableLruCache flowMarkdownReuseDrawableLruCache = this.pool;
        String destination = drawable.getDestination();
        Intrinsics.checkNotNullExpressionValue(destination, "drawable.destination");
        flowMarkdownReuseDrawableLruCache.putDrawable(destination, order, drawable);
    }

    public static /* synthetic */ AsyncDrawable obtain$default(FlowMarkdownReuseDrawablePool flowMarkdownReuseDrawablePool, Context context, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = 0;
        }
        return flowMarkdownReuseDrawablePool.obtain(context, str, num);
    }

    public final AsyncDrawable obtain(Context context, String urlKey, Integer order) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(urlKey, "urlKey");
        updateCacheStatus(context);
        return this.pool.getDrawable(urlKey, order);
    }

    public final void clear() {
        this.pool.evictAll();
    }

    private final void updateCacheStatus(Context context) {
        boolean z = (context.getResources().getConfiguration().uiMode & 48) == 32;
        if (Intrinsics.areEqual(Boolean.valueOf(z), this.lastCreateIsDarkMode)) {
            return;
        }
        this.pool.evictAll();
        this.lastCreateIsDarkMode = Boolean.valueOf(z);
    }
}
