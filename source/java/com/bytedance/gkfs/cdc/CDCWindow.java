package com.bytedance.gkfs.cdc;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: CDCWindow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\u0004H\u0082 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0082 J\u0019\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0082 J\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/gkfs/cdc/CDCWindow;", "", "()V", "nWindow", "", "getNWindow", "()J", "nWindow$delegate", "Lkotlin/Lazy;", "nCreate", "nReset", "", "wPtr", "nSlide8", "b", "", "reset", "slide8", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CDCWindow {

    /* renamed from: nWindow$delegate, reason: from kotlin metadata */
    private final Lazy nWindow = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.gkfs.cdc.CDCWindow$nWindow$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m565invoke() {
            return Long.valueOf(invoke());
        }

        public final long invoke() {
            Object obj;
            long nCreate;
            try {
                Result.Companion companion = Result.Companion;
                nCreate = CDCWindow.this.nCreate();
                obj = Result.constructor-impl(Long.valueOf(nCreate));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Long l = (Long) obj;
            if (l != null) {
                return l.longValue();
            }
            return 0L;
        }
    });

    private final long getNWindow() {
        return ((Number) this.nWindow.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long nCreate();

    private final native void nReset(long wPtr);

    private final native long nSlide8(long wPtr, byte b);

    static {
        try {
            Result.Companion companion = Result.Companion;
            System.loadLibrary("gkfs");
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final long slide8(byte b) {
        if (getNWindow() == 0) {
            throw new IllegalStateException("window not created, maybe libgkfs.so load failed");
        }
        return nSlide8(getNWindow(), b);
    }

    public final void reset() {
        if (getNWindow() == 0) {
            throw new IllegalStateException("window not created, maybe libgkfs.so load failed");
        }
        nReset(getNWindow());
    }
}
