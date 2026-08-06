package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: SelectionManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
/* synthetic */ class SelectionManager$updateSelectionTextToolbar$2 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectionManager$updateSelectionTextToolbar$2(Object obj) {
        super(0, obj, SelectionManager.class, "selectAll", "selectAll$foundation_release()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2115invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2115invoke() {
        ((SelectionManager) this.receiver).selectAll$foundation_release();
    }
}
