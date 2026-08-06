package com.bytedance.kmp.network;

import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.util.NLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;

/* compiled from: NetRequestMetrics.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u001e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/kmp/network/KmpRequestMetrics;", "", "()V", "kmpRequestEndTime", "", "kmpRequestInterceptorEndTime", "kmpRequestInterceptorStartTime", "kmpRequestStartTime", "kmpResponseDecodeEndTime", "kmpResponseDecodeStartTime", "kmpResponseHeaderTime", "kmpResponseInterceptorEndTime", "kmpResponseInterceptorStartTime", "recordRequestEndTimeAndReport", "", "request", "Lcom/bytedance/kmp/network/requet/Request;", "response", "Lcom/bytedance/kmp/network/response/Response;", "(Lcom/bytedance/kmp/network/requet/Request;Lcom/bytedance/kmp/network/response/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordRequestInterceptorEndTime", "recordRequestInterceptorStartTime", "recordRequestStartTime", "recordResponseDecodeEndTime", "recordResponseDecodeStartTime", "recordResponseHeaderTime", "recordResponseInterceptorEndTime", "recordResponseInterceptorStartTime", "report", "toString", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpRequestMetrics {
    private long kmpRequestStartTime = -1;
    private long kmpRequestInterceptorStartTime = -1;
    private long kmpRequestInterceptorEndTime = -1;
    private long kmpResponseHeaderTime = -1;
    private long kmpResponseInterceptorStartTime = -1;
    private long kmpResponseInterceptorEndTime = -1;
    private long kmpResponseDecodeStartTime = -1;
    private long kmpResponseDecodeEndTime = -1;
    private long kmpRequestEndTime = -1;

    public final void recordRequestStartTime() {
        if (((int) this.kmpRequestStartTime) == -1) {
            this.kmpRequestStartTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
        }
    }

    public final void recordRequestInterceptorStartTime() {
        this.kmpRequestInterceptorStartTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final void recordRequestInterceptorEndTime() {
        this.kmpRequestInterceptorEndTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final void recordResponseHeaderTime() {
        this.kmpResponseHeaderTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final void recordResponseInterceptorStartTime() {
        this.kmpResponseInterceptorStartTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final void recordResponseInterceptorEndTime() {
        this.kmpResponseInterceptorEndTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final void recordResponseDecodeStartTime() {
        this.kmpResponseDecodeStartTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final void recordResponseDecodeEndTime() {
        this.kmpResponseDecodeEndTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final Object recordRequestEndTimeAndReport(Request request, Response response, Continuation<? super Unit> continuation) {
        this.kmpRequestEndTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
        Object report = report(request, response, continuation);
        return report == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? report : Unit.INSTANCE;
    }

    public final Object report(Request request, Response response, Continuation<? super Unit> continuation) {
        if (response.isValid()) {
            NLog nLog = NLog.INSTANCE;
            NLog.Level level = NLog.Level.DEBUG;
            if (level.compareTo(nLog.getLevel()) >= 0) {
                String obj = "KmpNetworkManager, reportOK".toString();
                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + (obj != null ? obj : "null")));
            }
        } else {
            NLog nLog2 = NLog.INSTANCE;
            NLog.Level level2 = NLog.Level.DEBUG;
            if (level2.compareTo(nLog2.getLevel()) >= 0) {
                String obj2 = "KmpNetworkManager, reportError".toString();
                System.out.println((Object) ("[" + StringsKt.first(level2.name()) + "][kmp-ttnet] " + (obj2 != null ? obj2 : "null")));
            }
        }
        return Unit.INSTANCE;
    }

    public String toString() {
        return "KmpRequestMetrics(kmpRequestStartTime=" + this.kmpRequestStartTime + ", kmpRequestInterceptorStartTime=" + this.kmpRequestInterceptorStartTime + ", kmpRequestInterceptorEndTime=" + this.kmpRequestInterceptorEndTime + ", kmpResponseHeaderTime=" + this.kmpResponseHeaderTime + ", kmpResponseInterceptorStartTime=" + this.kmpResponseInterceptorStartTime + ", kmpResponseInterceptorEndTime=" + this.kmpResponseInterceptorEndTime + ", kmpResponseDecodeStartTime=" + this.kmpResponseDecodeStartTime + ", kmpResponseDecodeEndTime=" + this.kmpResponseDecodeEndTime + ", kmpRequestEndTime=" + this.kmpRequestEndTime + ')';
    }
}
