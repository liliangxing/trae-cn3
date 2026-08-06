package coil3.intercept;

import coil3.memory.MemoryCache;
import kotlin.Metadata;

/* compiled from: SignalRegistry.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"interceptorCache", "Lcoil3/intercept/SignalRegistry;", "Lcoil3/memory/MemoryCache$Key;", "", "getInterceptorCache", "()Lcoil3/intercept/SignalRegistry;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SignalRegistryKt {
    private static final SignalRegistry<MemoryCache.Key, Boolean> interceptorCache = new SignalRegistry<>();

    public static final SignalRegistry<MemoryCache.Key, Boolean> getInterceptorCache() {
        return interceptorCache;
    }
}
