package com.bytedance.vcloud.uniplayer;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniKitService.android.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0086\bø\u0001\u0000J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/OnceGate;", "", "()V", "done", "Ljava/util/concurrent/atomic/AtomicBoolean;", "load", "", "block", "Lkotlin/Function0;", "tryOnce", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OnceGate {
    private final AtomicBoolean done = new AtomicBoolean(false);

    public final boolean tryOnce() {
        return this.done.compareAndSet(false, true);
    }

    public final void load(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.done.get()) {
            return;
        }
        synchronized (this) {
            try {
                if (this.done.get()) {
                    InlineMarker.finallyStart(2);
                    InlineMarker.finallyEnd(2);
                    return;
                }
                block.invoke();
                this.done.set(true);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }
}
