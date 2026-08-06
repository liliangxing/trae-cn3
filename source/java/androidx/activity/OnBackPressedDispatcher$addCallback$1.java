package androidx.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnBackPressedDispatcher.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCallback$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OnBackPressedDispatcher$addCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m81invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m81invoke() {
        ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
    }
}
