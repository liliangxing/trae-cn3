package com.bytedance.android.anniex.optimize.prehandle.api;

import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreHandleTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/api/IPreHandleTask;", "INPUT", "OUTPUT", "", "bid", "", "getBid", "()Ljava/lang/String;", "handler", "Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "getHandler", "()Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "preHandleMethod", "", "methodCalls", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IPreHandleTask<INPUT, OUTPUT> {

    /* compiled from: IPreHandleTask.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <INPUT, OUTPUT> Map<String, OUTPUT> preHandleMethod(IPreHandleTask<INPUT, OUTPUT> iPreHandleTask, List<String> methodCalls) {
            Intrinsics.checkNotNullParameter(methodCalls, "methodCalls");
            return null;
        }
    }

    String getBid();

    BaseBridgeHandler<INPUT, OUTPUT> getHandler();

    Map<String, OUTPUT> preHandleMethod(List<String> methodCalls);
}
