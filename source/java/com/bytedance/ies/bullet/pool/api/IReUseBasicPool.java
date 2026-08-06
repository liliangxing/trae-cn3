package com.bytedance.ies.bullet.pool.api;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.base.PoolResult;
import kotlin.Metadata;

/* compiled from: IPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/pool/api/IReUseBasicPool;", ExifInterface.LATITUDE_SOUTH, "C", "Lcom/bytedance/ies/bullet/pool/api/IBasicPool;", "reUse", "Lcom/bytedance/ies/bullet/service/base/PoolResult;", "cacheItem", "(Ljava/lang/Object;)Lcom/bytedance/ies/bullet/service/base/PoolResult;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IReUseBasicPool<S, C> extends IBasicPool<S, C> {
    PoolResult reUse(C cacheItem);
}
