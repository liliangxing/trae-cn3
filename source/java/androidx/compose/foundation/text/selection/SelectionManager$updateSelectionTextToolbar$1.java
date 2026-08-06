package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectionManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public /* synthetic */ class SelectionManager$updateSelectionTextToolbar$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectionManager$updateSelectionTextToolbar$1(Object obj) {
        super(0, obj, SelectionManager.class, "toolbarCopy", "toolbarCopy()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2114invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2114invoke() {
        ((SelectionManager) this.receiver).toolbarCopy();
    }
}
