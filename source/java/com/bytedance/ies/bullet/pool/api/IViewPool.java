package com.bytedance.ies.bullet.pool.api;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: IPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0013H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/pool/api/IViewPool;", ExifInterface.LATITUDE_SOUTH, "C", "", "clearAll", "", "contains", "", "uniqueSchema", "(Ljava/lang/Object;)Z", "get", "evict", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "put", "cache", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "resize", "newSize", "", "size", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IViewPool<S, C> {
    void clearAll();

    boolean contains(S uniqueSchema);

    C get(S uniqueSchema, boolean evict);

    boolean put(S uniqueSchema, C cache);

    boolean remove(S uniqueSchema);

    void resize(int newSize);

    int size();

    /* compiled from: IPool.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object get$default(IViewPool iViewPool, Object obj, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return iViewPool.get(obj, z);
        }
    }
}
