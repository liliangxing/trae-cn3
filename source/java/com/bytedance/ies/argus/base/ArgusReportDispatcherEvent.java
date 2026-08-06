package com.bytedance.ies.argus.base;

import com.bytedance.ies.argus.bean.AspectContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* compiled from: ArgusMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusReportDispatcherEvent;", "", "context", "Lcom/bytedance/ies/argus/bean/AspectContext;", "deferredJobs", "", "Lkotlinx/coroutines/Deferred;", "(Lcom/bytedance/ies/argus/bean/AspectContext;Ljava/util/List;)V", "getContext", "()Lcom/bytedance/ies/argus/bean/AspectContext;", "getDeferredJobs", "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusReportDispatcherEvent {
    private final AspectContext<?, ?> context;
    private final List<Deferred<?>> deferredJobs;

    public ArgusReportDispatcherEvent(AspectContext<?, ?> aspectContext, List<? extends Deferred<?>> list) {
        Intrinsics.checkNotNullParameter(aspectContext, "context");
        this.context = aspectContext;
        this.deferredJobs = list;
    }

    public /* synthetic */ ArgusReportDispatcherEvent(AspectContext aspectContext, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aspectContext, (i & 2) != 0 ? null : list);
    }

    public final AspectContext<?, ?> getContext() {
        return this.context;
    }

    public final List<Deferred<?>> getDeferredJobs() {
        return this.deferredJobs;
    }
}
