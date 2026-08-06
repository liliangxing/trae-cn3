package coil3.memory;

import coil3.memory.MemoryCache;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* compiled from: RealMemoryCache.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0002J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0014H\u0096\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcoil3/memory/RealMemoryCache;", "Lcoil3/memory/MemoryCache;", "strongMemoryCache", "Lcoil3/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil3/memory/WeakMemoryCache;", "<init>", "(Lcoil3/memory/StrongMemoryCache;Lcoil3/memory/WeakMemoryCache;)V", "size", "", "getSize", "()J", "maxSize", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", "set", "", StrategyConstants.VALUE, "remove", "", "trimToSize", "clear", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RealMemoryCache implements MemoryCache {
    private final StrongMemoryCache strongMemoryCache;
    private final WeakMemoryCache weakMemoryCache;

    public RealMemoryCache(StrongMemoryCache strongMemoryCache, WeakMemoryCache weakMemoryCache) {
        this.strongMemoryCache = strongMemoryCache;
        this.weakMemoryCache = weakMemoryCache;
    }

    @Override // coil3.memory.MemoryCache
    public long getSize() {
        return this.strongMemoryCache.getSize();
    }

    @Override // coil3.memory.MemoryCache
    public long getMaxSize() {
        return this.strongMemoryCache.getMaxSize();
    }

    @Override // coil3.memory.MemoryCache
    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.plus(this.strongMemoryCache.getKeys(), this.weakMemoryCache.getKeys());
    }

    @Override // coil3.memory.MemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        MemoryCache.Value value = this.strongMemoryCache.get(key);
        return value == null ? this.weakMemoryCache.get(key) : value;
    }

    @Override // coil3.memory.MemoryCache
    public void set(MemoryCache.Key key, MemoryCache.Value value) {
        long size = value.getImage().getSize();
        if (!(size >= 0)) {
            throw new IllegalStateException(("Image size must be non-negative: " + size).toString());
        }
        this.strongMemoryCache.set(key, value.getImage(), value.getExtras(), size);
    }

    @Override // coil3.memory.MemoryCache
    public boolean remove(MemoryCache.Key key) {
        return this.strongMemoryCache.remove(key) || this.weakMemoryCache.remove(key);
    }

    @Override // coil3.memory.MemoryCache
    public void trimToSize(long size) {
        this.strongMemoryCache.trimToSize(size);
    }

    @Override // coil3.memory.MemoryCache
    public void clear() {
        this.strongMemoryCache.clear();
        this.weakMemoryCache.clear();
    }
}
