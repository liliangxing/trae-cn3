package com.bytedance.android.anniex.utils;

import com.lynx.tasm.base.TraceEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0086\bø\u0001\u0000\u001a/\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0003H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"ignorable", "", "block", "Lkotlin/Function0;", "lynxTrace", "R", "label", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class TraceExtKt {
    public static final <R> R lynxTrace(String label, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(block, "block");
        TraceEvent.beginSection(label);
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            TraceEvent.endSection(label);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void ignorable(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (TraceEvent.enableTrace()) {
            return;
        }
        block.invoke();
    }
}
