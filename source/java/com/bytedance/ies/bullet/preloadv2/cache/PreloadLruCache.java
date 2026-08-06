package com.bytedance.ies.bullet.preloadv2.cache;

import android.util.LruCache;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PreloadCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0014R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadLruCache;", "Landroid/util/LruCache;", "", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "name", "maxSize", "", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "checkExpireAndRefresh", "", "entryRemoved", "evicted", "", "key", "oldValue", "newValue", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PreloadLruCache extends LruCache<String, PreloadItem> {
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadLruCache(String str, int i) {
        super(i);
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void checkExpireAndRefresh() {
        Map<String, PreloadItem> snapshot = snapshot();
        Intrinsics.checkNotNullExpressionValue(snapshot, "snapShot");
        for (Map.Entry<String, PreloadItem> entry : snapshot.entrySet()) {
            if (!entry.getValue().checkValid()) {
                remove(entry.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public void entryRemoved(boolean evicted, String key, PreloadItem oldValue, PreloadItem newValue) {
        super.entryRemoved(evicted, (boolean) key, oldValue, newValue);
        if (newValue == null) {
            PreloadLogger.INSTANCE.m43i("移除缓存 " + this.name + ", size " + size() + ", maxSize " + maxSize() + ", key " + key);
            if (StringsKt.contains$default(this.name, "重定向", false, 2, (Object) null)) {
                return;
            }
            PreloadLogger.INSTANCE.m43i("移除对象 size " + (oldValue != null ? Integer.valueOf(oldValue.getSize()) : null));
            if (oldValue != null) {
                oldValue.clearMemory();
            }
        }
    }
}
