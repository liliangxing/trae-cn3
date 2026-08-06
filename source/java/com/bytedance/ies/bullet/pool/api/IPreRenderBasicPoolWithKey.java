package com.bytedance.ies.bullet.pool.api;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.CacheItemStatus;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: IPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003Jw\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2X\u0010\t\u001aT\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0006\u0012%\u0012#\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00050\nj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000eH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/pool/api/IPreRenderBasicPoolWithKey;", "C", "U", "Lcom/bytedance/ies/bullet/pool/api/IBasicPool;", "preRender", "", "cacheKey", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;", "preRenderOp", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", "Lcom/bytedance/ies/bullet/pool/api/PreRenderOperationWithKey;", "(Ljava/lang/Object;Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;Lkotlin/jvm/functions/Function2;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPreRenderBasicPoolWithKey<C, U> extends IBasicPool<C, U> {
    void preRender(C cacheKey, IPreRenderCallback callback, Function2<? super C, ? super Function2<? super CacheItemStatus, ? super U, Unit>, Unit> preRenderOp);
}
