package io.noties.markwon.ext.onetex;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexDrawable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0014¨\u0006\u0010"}, d2 = {"Lio/noties/markwon/ext/onetex/ImageCache;", "Landroidx/collection/LruCache;", "", "Landroid/graphics/Bitmap;", "maxSize", "", "(I)V", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "sizeOf", "value", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class ImageCache extends LruCache<String, Bitmap> {
    public ImageCache(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public int sizeOf(String key, Bitmap value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        return value.getByteCount() / 1024;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");
        if (oldValue.isRecycled()) {
            return;
        }
        oldValue.recycle();
    }
}
