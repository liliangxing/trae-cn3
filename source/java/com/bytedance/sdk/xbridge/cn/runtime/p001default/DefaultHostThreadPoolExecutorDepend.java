package com.bytedance.sdk.xbridge.cn.runtime.p001default;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHostThreadPoolExecutorDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/default/DefaultHostThreadPoolExecutorDepend;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostThreadPoolExecutorDepend;", "()V", "getNormalThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultHostThreadPoolExecutorDepend implements IHostThreadPoolExecutorDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend
    public ExecutorService getNormalThreadExecutor() {
        ExecutorService normalExecutor = TTExecutors.getNormalExecutor();
        Intrinsics.checkNotNullExpressionValue(normalExecutor, "getNormalExecutor()");
        return normalExecutor;
    }
}
