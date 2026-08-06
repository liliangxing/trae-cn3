package com.bytedance.timonbase.commoncache;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheEnv.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \r*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006J \u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timonbase/commoncache/CacheEnv;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "apiCacheProcessors", "", "", "Lcom/bytedance/timonbase/commoncache/CacheProcessor;", "getCacheProcessor", "key", "updateCacheProcessors", "", "processors", "Companion", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public class CacheEnv<T> {
    public static final String TAG = "CacheEnv";
    private Map<String, CacheProcessor<T>> apiCacheProcessors = MapsKt.emptyMap();

    public final void updateCacheProcessors(Map<String, CacheProcessor<T>> processors) {
        Intrinsics.checkParameterIsNotNull(processors, "processors");
        this.apiCacheProcessors = processors;
    }

    public final CacheProcessor<T> getCacheProcessor(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.apiCacheProcessors.get(key);
    }
}
