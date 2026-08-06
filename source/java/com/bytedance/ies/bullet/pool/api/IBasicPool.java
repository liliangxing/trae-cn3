package com.bytedance.ies.bullet.pool.api;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: IPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/pool/api/IBasicPool;", ExifInterface.LATITUDE_SOUTH, "C", "", "clearAll", "", "fetch", "uniqueSchema", "(Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "(Ljava/lang/Object;)Z", "resize", "newSize", "", "size", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBasicPool<S, C> {
    void clearAll();

    C fetch(S uniqueSchema);

    boolean remove(S uniqueSchema);

    void resize(int newSize);

    int size();
}
