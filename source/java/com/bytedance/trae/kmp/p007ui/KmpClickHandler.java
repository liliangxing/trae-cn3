package com.bytedance.trae.kmp.p007ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpClickHandler.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/kmp/ui/KmpClickHandler;", "", "nowMillis", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "lastHandledAtMillis", "Ljava/lang/Long;", "tryHandle", "", "action", "", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpClickHandler {
    public static final long MIN_CLICK_INTERVAL_MS = 200;
    private Long lastHandledAtMillis;
    private final Function0<Long> nowMillis;
    public static final int $stable = 8;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KmpClickHandler() {
        this(r0, 1, r0);
        Function0 function0 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KmpClickHandler.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.bytedance.trae.kmp.ui.KmpClickHandler$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class C08161 extends FunctionReferenceImpl implements Function0<Long> {
        public static final C08161 INSTANCE = new C08161();

        C08161() {
            super(0, KmpClickHandlerKt.class, "monotonicNowMillis", "monotonicNowMillis()J", 1);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m884invoke() {
            long monotonicNowMillis;
            monotonicNowMillis = KmpClickHandlerKt.monotonicNowMillis();
            return Long.valueOf(monotonicNowMillis);
        }
    }

    public KmpClickHandler(Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(function0, "nowMillis");
        this.nowMillis = function0;
    }

    public /* synthetic */ KmpClickHandler(C08161 c08161, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C08161.INSTANCE : c08161);
    }

    public final boolean tryHandle(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        long longValue = ((Number) this.nowMillis.invoke()).longValue();
        Long l = this.lastHandledAtMillis;
        if (l != null && longValue - l.longValue() < 200) {
            return false;
        }
        this.lastHandledAtMillis = Long.valueOf(longValue);
        action.invoke();
        return true;
    }
}
