package com.bytedance.pia.nsr;

import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.nsr.NsrManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NsrManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005J\u0019\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002¨\u0006\t"}, d2 = {"com/bytedance/pia/nsr/NsrManager$renderInternal$safeSuccess$1", "Lkotlin/Function2;", "", "", "", "Lcom/bytedance/pia/nsr/NsrSuccessCallback;", "invoke", "html", "cache", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NsrManager$renderInternal$safeSuccess$1 implements Function2<String, Boolean, Unit> {
    final /* synthetic */ AtomicBoolean $finish;
    final /* synthetic */ PiaManifest $manifest;
    final /* synthetic */ NsrManager.NsrTraceConsumer $nsrConsumer;
    final /* synthetic */ Function2<String, Boolean, Unit> $onSuccess;
    final /* synthetic */ PiaRuntime $runtime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public NsrManager$renderInternal$safeSuccess$1(AtomicBoolean atomicBoolean, PiaManifest piaManifest, PiaRuntime piaRuntime, NsrManager.NsrTraceConsumer nsrTraceConsumer, Function2<? super String, ? super Boolean, Unit> function2) {
        this.$finish = atomicBoolean;
        this.$manifest = piaManifest;
        this.$runtime = piaRuntime;
        this.$nsrConsumer = nsrTraceConsumer;
        this.$onSuccess = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public void invoke(String html, boolean cache) {
        Intrinsics.checkNotNullParameter(html, "html");
        if (this.$finish.compareAndSet(false, true)) {
            Logger.i$default("[NSR] Run nsr success. (URL: " + this.$manifest.getUri() + ')', null, null, 6, null);
            NsrManager nsrManager = NsrManager.INSTANCE;
            PiaRuntime piaRuntime = this.$runtime;
            String uri = this.$manifest.getUri().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "manifest.uri.toString()");
            nsrManager.reportPVIfNeeded(piaRuntime, uri, true, this.$nsrConsumer);
            Function2<String, Boolean, Unit> function2 = this.$onSuccess;
            if (function2 != null) {
                function2.invoke(html, Boolean.valueOf(cache));
            }
        }
    }
}
