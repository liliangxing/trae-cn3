package com.bytedance.timonbase.sensitive.detect.cacher;

import com.bytedance.ies.xbridge.XBridge;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: ISensitiveContentCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH\u0017¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache;", "", "cacheContent", "", "content", "Lcom/bytedance/timonbase/sensitive/detect/cacher/SensitiveCachedContent;", "cacheOriginContent", "getCacheContent", "", "getOriginCacheContent", "hasCache", "", "type", "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "Type", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface ISensitiveContentCache {

    /* compiled from: ISensitiveContentCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "", "(Ljava/lang/String;I)V", XBridge.DEFAULT_NAMESPACE, "CLIPBOARD", "LOCATION", "STORAGE", "STORAGE_B", "STORAGE_KB", "STORAGE_MB", "STORAGE_FREE_B", "STORAGE_FREE_KB", "STORAGE_FREE_MB", "APPLIST", "FIRST_INSTALL_TIME", "LAST_UPDATE_TIME", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    @Deprecated(message = "please using string")
    /* loaded from: classes5.dex */
    public enum Type {
        DEFAULT,
        CLIPBOARD,
        LOCATION,
        STORAGE,
        STORAGE_B,
        STORAGE_KB,
        STORAGE_MB,
        STORAGE_FREE_B,
        STORAGE_FREE_KB,
        STORAGE_FREE_MB,
        APPLIST,
        FIRST_INSTALL_TIME,
        LAST_UPDATE_TIME
    }

    void cacheContent(SensitiveCachedContent content);

    void cacheOriginContent(Object content);

    List<SensitiveCachedContent> getCacheContent();

    List<Object> getOriginCacheContent();

    boolean hasCache();

    @Deprecated(message = "")
    Type type();

    /* compiled from: ISensitiveContentCache.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated(message = "")
        public static Type type(ISensitiveContentCache iSensitiveContentCache) {
            return Type.DEFAULT;
        }
    }
}
