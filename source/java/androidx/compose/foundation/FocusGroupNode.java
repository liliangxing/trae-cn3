package androidx.compose.foundation;

import androidx.compose.p002ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.p002ui.focus.Focusability;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;

/* compiled from: Focusable.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/FocusGroupNode;", "Landroidx/compose/ui/node/DelegatingNode;", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class FocusGroupNode extends DelegatingNode {
    public FocusGroupNode() {
        delegate(FocusTargetModifierNodeKt.m4504FocusTargetModifierNodePYyLHbc$default(Focusability.INSTANCE.m4528getNeverLCbbffg(), null, 2, null));
    }
}
