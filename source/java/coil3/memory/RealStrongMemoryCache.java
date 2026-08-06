package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import coil3.memory.RealStrongMemoryCache;
import coil3.util.LruCache;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: StrongMemoryCache.kt */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J4\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\t0\u001e2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcoil3/memory/RealStrongMemoryCache;", "Lcoil3/memory/StrongMemoryCache;", "maxSize", "", "weakMemoryCache", "Lcoil3/memory/WeakMemoryCache;", "<init>", "(JLcoil3/memory/WeakMemoryCache;)V", "lock", "", "cache", "coil3/memory/RealStrongMemoryCache$cache$1", "Lcoil3/memory/RealStrongMemoryCache$cache$1;", "size", "getSize", "()J", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", "set", "", "image", "Lcoil3/Image;", "extras", "", "", "remove", "", "clear", "trimToSize", "InternalValue", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RealStrongMemoryCache implements StrongMemoryCache {
    private final RealStrongMemoryCache$cache$1 cache;
    private final Object lock = new Object();
    private final WeakMemoryCache weakMemoryCache;

    /* JADX WARN: Type inference failed for: r3v2, types: [coil3.memory.RealStrongMemoryCache$cache$1] */
    public RealStrongMemoryCache(final long j, WeakMemoryCache weakMemoryCache) {
        this.weakMemoryCache = weakMemoryCache;
        this.cache = new LruCache<MemoryCache.Key, InternalValue>(j) { // from class: coil3.memory.RealStrongMemoryCache$cache$1
            @Override // coil3.util.LruCache
            public long sizeOf(MemoryCache.Key key, RealStrongMemoryCache.InternalValue value) {
                return value.getSize();
            }

            @Override // coil3.util.LruCache
            public void entryRemoved(MemoryCache.Key key, RealStrongMemoryCache.InternalValue oldValue, RealStrongMemoryCache.InternalValue newValue) {
                WeakMemoryCache weakMemoryCache2;
                weakMemoryCache2 = this.weakMemoryCache;
                weakMemoryCache2.set(key, oldValue.getImage(), oldValue.getExtras(), oldValue.getSize());
            }
        };
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getSize() {
        long size;
        synchronized (this.lock) {
            size = getSize();
        }
        return size;
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getMaxSize() {
        long maxSize;
        synchronized (this.lock) {
            maxSize = getMaxSize();
        }
        return maxSize;
    }

    @Override // coil3.memory.StrongMemoryCache
    public Set<MemoryCache.Key> getKeys() {
        Set<MemoryCache.Key> keys;
        synchronized (this.lock) {
            keys = getKeys();
        }
        return keys;
    }

    @Override // coil3.memory.StrongMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        MemoryCache.Value value;
        synchronized (this.lock) {
            InternalValue internalValue = get(key);
            value = internalValue != null ? new MemoryCache.Value(internalValue.getImage(), internalValue.getExtras()) : null;
        }
        return value;
    }

    @Override // coil3.memory.StrongMemoryCache
    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> extras, long size) {
        synchronized (this.lock) {
            if (size <= getMaxSize()) {
                put(key, new InternalValue(image, extras, size));
            } else {
                remove(key);
                this.weakMemoryCache.set(key, image, extras, size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // coil3.memory.StrongMemoryCache
    public boolean remove(MemoryCache.Key key) {
        boolean z;
        synchronized (this.lock) {
            z = remove(key) != null;
        }
        return z;
    }

    @Override // coil3.memory.StrongMemoryCache
    public void clear() {
        synchronized (this.lock) {
            clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // coil3.memory.StrongMemoryCache
    public void trimToSize(long size) {
        synchronized (this.lock) {
            trimToSize(size);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StrongMemoryCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcoil3/memory/RealStrongMemoryCache$InternalValue;", "", "image", "Lcoil3/Image;", "extras", "", "", "size", "", "<init>", "(Lcoil3/Image;Ljava/util/Map;J)V", "getImage", "()Lcoil3/Image;", "getExtras", "()Ljava/util/Map;", "getSize", "()J", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class InternalValue {
        private final Map<String, Object> extras;
        private final Image image;
        private final long size;

        public InternalValue(Image image, Map<String, ? extends Object> map, long j) {
            this.image = image;
            this.extras = map;
            this.size = j;
        }

        public final Image getImage() {
            return this.image;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final long getSize() {
            return this.size;
        }
    }
}
