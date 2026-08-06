package com.bytedance.ies.xbridge.event.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XEventRuntime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/event/depend/XEventRuntime;", "", "()V", "hostEventDepend", "Lcom/bytedance/ies/xbridge/event/depend/IHostEventDepend;", "getHostEventDepend", "init", "", "setHostEventDepend", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XEventRuntime {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static XEventRuntime INSTANCE;
    private IHostEventDepend hostEventDepend;

    public /* synthetic */ XEventRuntime(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: XEventRuntime.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/event/depend/XEventRuntime$Companion;", "", "()V", "<set-?>", "Lcom/bytedance/ies/xbridge/event/depend/XEventRuntime;", "INSTANCE", "getINSTANCE", "()Lcom/bytedance/ies/xbridge/event/depend/XEventRuntime;", "create", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final XEventRuntime getINSTANCE() {
            return XEventRuntime.INSTANCE;
        }

        public final XEventRuntime create() {
            return new XEventRuntime(null);
        }
    }

    private XEventRuntime() {
    }

    public final IHostEventDepend getHostEventDepend() {
        return this.hostEventDepend;
    }

    public final XEventRuntime setHostEventDepend(IHostEventDepend hostEventDepend) {
        Intrinsics.checkNotNullParameter(hostEventDepend, "hostEventDepend");
        this.hostEventDepend = hostEventDepend;
        return this;
    }

    public final synchronized void init() {
        if (INSTANCE == null) {
            INSTANCE = this;
        }
    }
}
