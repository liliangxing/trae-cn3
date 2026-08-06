package androidx.compose.material3;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: SwipeToDismissBox.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/SwipeToDismissAnchorsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "(Landroidx/compose/material3/SwipeToDismissBoxState;ZZ)V", "didLookahead", "getEnableDismissFromEndToStart", "()Z", "setEnableDismissFromEndToStart", "(Z)V", "getEnableDismissFromStartToEnd", "setEnableDismissFromStartToEnd", "getState", "()Landroidx/compose/material3/SwipeToDismissBoxState;", "setState", "(Landroidx/compose/material3/SwipeToDismissBoxState;)V", "onDetach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class SwipeToDismissAnchorsNode extends Modifier.Node implements LayoutModifierNode {
    private boolean didLookahead;
    private boolean enableDismissFromEndToStart;
    private boolean enableDismissFromStartToEnd;
    private SwipeToDismissBoxState state;

    public final SwipeToDismissBoxState getState() {
        return this.state;
    }

    public final void setState(SwipeToDismissBoxState swipeToDismissBoxState) {
        this.state = swipeToDismissBoxState;
    }

    public final boolean getEnableDismissFromStartToEnd() {
        return this.enableDismissFromStartToEnd;
    }

    public final void setEnableDismissFromStartToEnd(boolean z) {
        this.enableDismissFromStartToEnd = z;
    }

    public final boolean getEnableDismissFromEndToStart() {
        return this.enableDismissFromEndToStart;
    }

    public final void setEnableDismissFromEndToStart(boolean z) {
        this.enableDismissFromEndToStart = z;
    }

    public SwipeToDismissAnchorsNode(SwipeToDismissBoxState swipeToDismissBoxState, boolean z, boolean z2) {
        this.state = swipeToDismissBoxState;
        this.enableDismissFromStartToEnd = z;
        this.enableDismissFromEndToStart = z2;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.didLookahead = false;
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3053measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
        if (measureScope.isLookingAhead() || !this.didLookahead) {
            final float width = mo6318measureBRTryo0.getWidth();
            AnchoredDraggableState.updateAnchors$default(this.state.getAnchoredDraggableState$material3_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissAnchorsNode$measure$newAnchors$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DraggableAnchorsConfig<SwipeToDismissBoxValue>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                    draggableAnchorsConfig.m48at(SwipeToDismissBoxValue.Settled, 0.0f);
                    if (SwipeToDismissAnchorsNode.this.getEnableDismissFromStartToEnd()) {
                        draggableAnchorsConfig.m48at(SwipeToDismissBoxValue.StartToEnd, width);
                    }
                    if (SwipeToDismissAnchorsNode.this.getEnableDismissFromEndToStart()) {
                        draggableAnchorsConfig.m48at(SwipeToDismissBoxValue.EndToStart, -width);
                    }
                }
            }), null, 2, null);
        }
        this.didLookahead = measureScope.isLookingAhead() || this.didLookahead;
        return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), mo6318measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SwipeToDismissAnchorsNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                float requireOffset;
                if (MeasureScope.this.isLookingAhead()) {
                    requireOffset = this.getState().getAnchoredDraggableState$material3_release().getAnchors().positionOf(this.getState().getTargetValue());
                } else {
                    requireOffset = this.getState().requireOffset();
                }
                Placeable.PlacementScope.place$default(placementScope, mo6318measureBRTryo0, MathKt.roundToInt(requireOffset), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
