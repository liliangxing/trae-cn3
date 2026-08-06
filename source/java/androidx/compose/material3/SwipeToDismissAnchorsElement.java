package androidx.compose.material3;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeToDismissBox.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016J\u0013\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\f\u0010\u0012\u001a\u00020\u0010*\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/SwipeToDismissAnchorsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/SwipeToDismissAnchorsNode;", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "(Landroidx/compose/material3/SwipeToDismissBoxState;ZZ)V", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class SwipeToDismissAnchorsElement extends ModifierNodeElement<SwipeToDismissAnchorsNode> {
    private final boolean enableDismissFromEndToStart;
    private final boolean enableDismissFromStartToEnd;
    private final SwipeToDismissBoxState state;

    public SwipeToDismissAnchorsElement(SwipeToDismissBoxState swipeToDismissBoxState, boolean z, boolean z2) {
        this.state = swipeToDismissBoxState;
        this.enableDismissFromStartToEnd = z;
        this.enableDismissFromEndToStart = z2;
    }

    /* renamed from: create, reason: merged with bridge method [inline-methods] */
    public SwipeToDismissAnchorsNode m3052create() {
        return new SwipeToDismissAnchorsNode(this.state, this.enableDismissFromStartToEnd, this.enableDismissFromEndToStart);
    }

    public void update(SwipeToDismissAnchorsNode node) {
        node.setState(this.state);
        node.setEnableDismissFromStartToEnd(this.enableDismissFromStartToEnd);
        node.setEnableDismissFromEndToStart(this.enableDismissFromEndToStart);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.material3.SwipeToDismissAnchorsElement");
        SwipeToDismissAnchorsElement swipeToDismissAnchorsElement = (SwipeToDismissAnchorsElement) other;
        return Intrinsics.areEqual(this.state, swipeToDismissAnchorsElement.state) && this.enableDismissFromStartToEnd == swipeToDismissAnchorsElement.enableDismissFromStartToEnd && this.enableDismissFromEndToStart == swipeToDismissAnchorsElement.enableDismissFromEndToStart;
    }

    public int hashCode() {
        return (((this.state.hashCode() * 31) + Boolean.hashCode(this.enableDismissFromStartToEnd)) * 31) + Boolean.hashCode(this.enableDismissFromEndToStart);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.SwipeToDismissAnchorsElement$inspectableProperties$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(InspectorInfo inspectorInfo2) {
                    SwipeToDismissBoxState swipeToDismissBoxState;
                    boolean z;
                    boolean z2;
                    ValueElementSequence properties = inspectorInfo2.getProperties();
                    swipeToDismissBoxState = SwipeToDismissAnchorsElement.this.state;
                    properties.set("state", swipeToDismissBoxState);
                    ValueElementSequence properties2 = inspectorInfo2.getProperties();
                    z = SwipeToDismissAnchorsElement.this.enableDismissFromStartToEnd;
                    properties2.set("enableDismissFromStartToEnd", Boolean.valueOf(z));
                    ValueElementSequence properties3 = inspectorInfo2.getProperties();
                    z2 = SwipeToDismissAnchorsElement.this.enableDismissFromEndToStart;
                    properties3.set("enableDismissFromEndToStart", Boolean.valueOf(z2));
                }
            };
        } else {
            InspectableValueKt.getNoInspectorInfo();
        }
    }
}
