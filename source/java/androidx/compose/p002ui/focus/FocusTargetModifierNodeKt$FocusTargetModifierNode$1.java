package androidx.compose.p002ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: FocusTargetModifierNode.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
/* synthetic */ class FocusTargetModifierNodeKt$FocusTargetModifierNode$1 extends FunctionReferenceImpl implements Function1<FocusTargetNode, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusTargetModifierNodeKt$FocusTargetModifierNode$1(Object obj) {
        super(1, obj, InvalidateSemantics.class, "onDispatchEventsCompleted", "onDispatchEventsCompleted(Landroidx/compose/ui/focus/FocusTargetNode;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusTargetNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusTargetNode focusTargetNode) {
        ((InvalidateSemantics) this.receiver).onDispatchEventsCompleted(focusTargetNode);
    }
}
