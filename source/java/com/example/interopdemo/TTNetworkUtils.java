package com.example.interopdemo;

import com.bytedance.webx.seclink.util.ReportUtil;
import com.example.kmp.shared.sha.MultiNetStateBridge;
import com.example.kmp.shared.sha.TTNetworkUtilsBridge;
import com.example.kmp.shared.sha.TTNetworkUtilsBridge_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTNetworkUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/example/interopdemo/TTNetworkUtils;", "", "<init>", "()V", "preConnect", "", ReportUtil.Params.HOST, "", "getMultiNetState", "Lcom/example/interopdemo/NativeMultiNetState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class TTNetworkUtils {
    public static final TTNetworkUtils INSTANCE = new TTNetworkUtils();

    private TTNetworkUtils() {
    }

    public final void preConnect(String host) {
        Intrinsics.checkNotNullParameter(host, ReportUtil.Params.HOST);
        TTNetworkUtilsBridge_androidKt.getTTNetworkUtilsBridge().preConnect(host);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getMultiNetState(Continuation<? super NativeMultiNetState> continuation) {
        TTNetworkUtils$getMultiNetState$1 tTNetworkUtils$getMultiNetState$1;
        int i;
        if (continuation instanceof TTNetworkUtils$getMultiNetState$1) {
            tTNetworkUtils$getMultiNetState$1 = (TTNetworkUtils$getMultiNetState$1) continuation;
            if ((tTNetworkUtils$getMultiNetState$1.label & Integer.MIN_VALUE) != 0) {
                tTNetworkUtils$getMultiNetState$1.label -= Integer.MIN_VALUE;
                Object obj = tTNetworkUtils$getMultiNetState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tTNetworkUtils$getMultiNetState$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TTNetworkUtilsBridge tTNetworkUtilsBridge = TTNetworkUtilsBridge_androidKt.getTTNetworkUtilsBridge();
                    tTNetworkUtils$getMultiNetState$1.label = 1;
                    obj = tTNetworkUtilsBridge.getMultiNetState(tTNetworkUtils$getMultiNetState$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                MultiNetStateBridge multiNetStateBridge = (MultiNetStateBridge) obj;
                return new NativeMultiNetState(multiNetStateBridge.getPreState(), multiNetStateBridge.getCurState());
            }
        }
        tTNetworkUtils$getMultiNetState$1 = new TTNetworkUtils$getMultiNetState$1(this, continuation);
        Object obj2 = tTNetworkUtils$getMultiNetState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tTNetworkUtils$getMultiNetState$1.label;
        if (i != 0) {
        }
        MultiNetStateBridge multiNetStateBridge2 = (MultiNetStateBridge) obj2;
        return new NativeMultiNetState(multiNetStateBridge2.getPreState(), multiNetStateBridge2.getCurState());
    }
}
