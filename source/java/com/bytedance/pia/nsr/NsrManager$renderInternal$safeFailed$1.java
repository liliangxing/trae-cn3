package com.bytedance.pia.nsr;

import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.metrics.ErrorCode;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.nsr.NsrManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NsrManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¨\u0006\u0007"}, d2 = {"com/bytedance/pia/nsr/NsrManager$renderInternal$safeFailed$1", "Lkotlin/Function1;", "", "", "Lcom/bytedance/pia/nsr/NsrFailedCallback;", "invoke", "error", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NsrManager$renderInternal$safeFailed$1 implements Function1<String, Unit> {
    final /* synthetic */ AtomicBoolean $finish;
    final /* synthetic */ PiaManifest $manifest;
    final /* synthetic */ NsrManager.NsrTraceConsumer $nsrConsumer;
    final /* synthetic */ Function1<String, Unit> $onFailed;
    final /* synthetic */ PiaRuntime $runtime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public NsrManager$renderInternal$safeFailed$1(AtomicBoolean atomicBoolean, PiaRuntime piaRuntime, PiaManifest piaManifest, NsrManager.NsrTraceConsumer nsrTraceConsumer, Function1<? super String, Unit> function1) {
        this.$finish = atomicBoolean;
        this.$runtime = piaRuntime;
        this.$manifest = piaManifest;
        this.$nsrConsumer = nsrTraceConsumer;
        this.$onFailed = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public void invoke(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.$finish.compareAndSet(false, true)) {
            this.$runtime.getMetrics().onError(ErrorType.NSR_WORKER, ErrorCode.NSR_EXECUTE_FAILED, error);
            Logger.i$default("[NSR] Run nsr failed (URL: " + this.$manifest.getUri() + ", Reason: " + error + ')', null, null, 6, null);
            NsrManager nsrManager = NsrManager.INSTANCE;
            PiaRuntime piaRuntime = this.$runtime;
            String uri = this.$manifest.getUri().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "manifest.uri.toString()");
            nsrManager.reportPVIfNeeded(piaRuntime, uri, false, this.$nsrConsumer);
            Function1<String, Unit> function1 = this.$onFailed;
            if (function1 != null) {
                function1.invoke(error);
            }
        }
    }
}
