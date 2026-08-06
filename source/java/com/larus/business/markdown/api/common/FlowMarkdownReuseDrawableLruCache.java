package com.larus.business.markdown.api.common;

import android.util.LruCache;
import io.noties.markwon.image.AsyncDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowMarkdownReuseDrawablePool.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawableLruCache;", "Landroid/util/LruCache;", "Lcom/larus/business/markdown/api/common/LatexLruKey;", "Lio/noties/markwon/image/AsyncDrawable;", "maxSize", "", "(I)V", "getDrawable", "urlKey", "", "order", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/noties/markwon/image/AsyncDrawable;", "putDrawable", "", "drawable", "(Ljava/lang/String;Ljava/lang/Integer;Lio/noties/markwon/image/AsyncDrawable;)V", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FlowMarkdownReuseDrawableLruCache extends LruCache<LatexLruKey, AsyncDrawable> {
    public FlowMarkdownReuseDrawableLruCache(int i) {
        super(i);
    }

    public final AsyncDrawable getDrawable(String urlKey, Integer order) {
        Intrinsics.checkNotNullParameter(urlKey, "urlKey");
        return get(new LatexLruKey(urlKey, order));
    }

    public final void putDrawable(String urlKey, Integer order, AsyncDrawable drawable) {
        Intrinsics.checkNotNullParameter(urlKey, "urlKey");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        put(new LatexLruKey(urlKey, order), drawable);
    }
}
