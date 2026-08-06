package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Focusable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public /* synthetic */ class FocusableNode$applySemantics$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusableNode$applySemantics$1(Object obj) {
        super(0, obj, FocusableNode.class, "requestFocus", "requestFocus()Z", 0);
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m466invoke() {
        return Boolean.valueOf(((FocusableNode) this.receiver).requestFocus());
    }
}
