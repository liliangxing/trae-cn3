package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Path;
import androidx.compose.p002ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: TextFieldCoreModifier.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006Ba\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010-\u001a\u00020.H\u0016J`\u0010/\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\f\u00109\u001a\u00020.*\u00020:H\u0016J#\u0010;\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b<\u00108J#\u0010=\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b>\u00108J'\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020)H\u0002¢\u0006\u0004\bC\u0010DJ3\u0010E\u001a\u00020.*\u00020F2\u0006\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020)2\u0006\u0010@\u001a\u00020%2\u0006\u0010I\u001a\u00020JH\u0002¢\u0006\u0004\bK\u0010LJ#\u0010M\u001a\u00020.*\u00020N2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020QH\u0002¢\u0006\u0004\bR\u0010SJ(\u0010T\u001a\u00020.*\u00020N2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020%0V2\u0006\u0010P\u001a\u00020QH\u0002J\u0014\u0010X\u001a\u00020.*\u00020N2\u0006\u0010P\u001a\u00020QH\u0002J\f\u0010Y\u001a\u00020.*\u00020NH\u0002J\b\u0010Z\u001a\u00020.H\u0002J\u0010\u0010[\u001a\u00020.2\u0006\u0010\\\u001a\u00020]H\u0016J\f\u0010^\u001a\u00020.*\u00020_H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "<init>", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "showCursor", "getShowCursor", "()Z", "changeObserverJob", "Lkotlinx/coroutines/Job;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousTextLayoutSize", "", "previousContainerSize", "textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "onAttach", "", "updateNode", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "calculateOffsetToFollow", "currSelection", "currContainerSize", "currTextLayoutSize", "calculateOffsetToFollow-8ffj60Q", "(JII)I", "updateScrollState", "Landroidx/compose/ui/unit/Density;", "containerSize", "textLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "updateScrollState-tIlFzwE", "(Landroidx/compose/ui/unit/Density;IIJLandroidx/compose/ui/unit/LayoutDirection;)V", "drawSelection", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "selection", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawHighlight", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "drawText", "drawCursor", "startCursorJob", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Job changeObserverJob;
    private CursorAnimationState cursorAnimation;
    private Brush cursorBrush;
    private boolean isDragHovered;
    private boolean isFocused;
    private Orientation orientation;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousContainerSize;
    private Rect previousCursorRect = new Rect(-1.0f, -1.0f, -1.0f, -1.0f);
    private TextRange previousSelection;
    private int previousTextLayoutSize;
    private ScrollState scrollState;
    private final TextFieldMagnifierNode textFieldMagnifierNode;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private ToolbarRequester toolbarRequester;
    private boolean writeable;

    public TextFieldCoreModifierNode(boolean z, boolean z2, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z3, ScrollState scrollState, Orientation orientation, ToolbarRequester toolbarRequester, PlatformSelectionBehaviors platformSelectionBehaviors) {
        this.isFocused = z;
        this.isDragHovered = z2;
        this.textLayoutState = textLayoutState;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = brush;
        this.writeable = z3;
        this.scrollState = scrollState;
        this.orientation = orientation;
        this.toolbarRequester = toolbarRequester;
        this.platformSelectionBehaviors = platformSelectionBehaviors;
        this.textFieldMagnifierNode = delegate((DelegatableNode) AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, this.isFocused || this.isDragHovered));
        delegate((DelegatableNode) new TextContextMenuToolbarHandlerNode(this.toolbarRequester, new C04681(null), new C04692(null), new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Rect _init_$lambda$0;
                _init_$lambda$0 = TextFieldCoreModifierNode._init_$lambda$0(TextFieldCoreModifierNode.this, (LayoutCoordinates) obj);
                return _init_$lambda$0;
            }
        }));
    }

    private final boolean getShowCursor() {
        boolean isSpecified;
        if (this.writeable && (this.isFocused || this.isDragHovered)) {
            isSpecified = TextFieldCoreModifierKt.isSpecified(this.cursorBrush);
            if (isSpecified) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: TextFieldCoreModifier.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$1", f = "TextFieldCoreModifier.kt", i = {}, l = {209, 210}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    static final class C04681 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C04681(Continuation<? super C04681> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04681(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TextFieldCoreModifierNode.this.textFieldSelectionState.updateClipboardEntry((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    TextFieldCoreModifierNode.this.textFieldSelectionState.setTextToolbarShown$foundation_release(true);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            PlatformSelectionBehaviors platformSelectionBehaviors = TextFieldCoreModifierNode.this.platformSelectionBehaviors;
            if (platformSelectionBehaviors != null) {
                this.label = 2;
                if (platformSelectionBehaviors.mo2060onShowContextMenuSbBc2M(TextFieldCoreModifierNode.this.textFieldSelectionState.getTextFieldState().getVisualText().getText(), TextFieldCoreModifierNode.this.textFieldSelectionState.getTextFieldState().getVisualText().getSelection(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            TextFieldCoreModifierNode.this.textFieldSelectionState.setTextToolbarShown$foundation_release(true);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TextFieldCoreModifier.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$2", f = "TextFieldCoreModifier.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    static final class C04692 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C04692(Continuation<? super C04692> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04692(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TextFieldCoreModifierNode.this.textFieldSelectionState.setTextToolbarShown$foundation_release(false);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect _init_$lambda$0(TextFieldCoreModifierNode textFieldCoreModifierNode, LayoutCoordinates layoutCoordinates) {
        Rect derivedVisibleContentBounds$foundation_release = textFieldCoreModifierNode.textFieldSelectionState.getDerivedVisibleContentBounds$foundation_release();
        if (derivedVisibleContentBounds$foundation_release == null) {
            derivedVisibleContentBounds$foundation_release = Rect.INSTANCE.getZero();
        }
        LayoutCoordinates textLayoutNodeCoordinates = textFieldCoreModifierNode.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(derivedVisibleContentBounds$foundation_release, textLayoutNodeCoordinates, layoutCoordinates);
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public void onAttach() {
        if (this.isFocused && getShowCursor()) {
            startCursorJob();
        }
    }

    public final void updateNode(boolean isFocused, boolean isDragHovered, TextLayoutState textLayoutState, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation, ToolbarRequester toolbarRequester, PlatformSelectionBehaviors platformSelectionBehaviors) {
        boolean showCursor = getShowCursor();
        boolean z = this.isFocused;
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        TextLayoutState textLayoutState2 = this.textLayoutState;
        TextFieldSelectionState textFieldSelectionState2 = this.textFieldSelectionState;
        ScrollState scrollState2 = this.scrollState;
        this.isFocused = isFocused;
        this.isDragHovered = isDragHovered;
        this.textLayoutState = textLayoutState;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = cursorBrush;
        this.writeable = writeable;
        this.scrollState = scrollState;
        this.orientation = orientation;
        this.toolbarRequester = toolbarRequester;
        this.platformSelectionBehaviors = platformSelectionBehaviors;
        this.textFieldMagnifierNode.update(textFieldState, textFieldSelectionState, textLayoutState, isFocused || isDragHovered);
        if (!getShowCursor()) {
            Job job = this.changeObserverJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.changeObserverJob = null;
            CursorAnimationState cursorAnimationState = this.cursorAnimation;
            if (cursorAnimationState != null) {
                cursorAnimationState.cancelAndHide();
            }
        } else if (!z || !Intrinsics.areEqual(transformedTextFieldState, textFieldState) || !showCursor) {
            startCursorJob();
        }
        if (Intrinsics.areEqual(transformedTextFieldState, textFieldState) && Intrinsics.areEqual(textLayoutState2, textLayoutState) && Intrinsics.areEqual(textFieldSelectionState2, textFieldSelectionState) && Intrinsics.areEqual(scrollState2, scrollState)) {
            return;
        }
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1851measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        if (this.orientation == Orientation.Vertical) {
            return m1849measureVerticalScroll3p2s80s(measureScope, measurable, j);
        }
        return m1848measureHorizontalScroll3p2s80s(measureScope, measurable, j);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return;
        }
        Pair<TextHighlightType, TextRange> highlight = visualText.getHighlight();
        if (highlight != null) {
            drawHighlight(contentDrawScope, highlight, layoutResult);
        }
        if (TextRange.getCollapsed-impl(visualText.getSelection())) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            drawText(contentDrawScope2, layoutResult);
            if (visualText.shouldShowSelection()) {
                drawCursor(contentDrawScope2);
            }
        } else {
            if (visualText.shouldShowSelection()) {
                m1847drawSelectionSbBc2M(contentDrawScope, visualText.getSelection(), layoutResult);
            }
            drawText(contentDrawScope, layoutResult);
        }
        this.textFieldMagnifierNode.draw(contentDrawScope);
    }

    /* renamed from: measureVerticalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1849measureVerticalScroll3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 7, (Object) null));
        final int min = Math.min(mo6318measureBRTryo0.getHeight(), Constraints.getMaxHeight-impl(j));
        return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), min, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measureVerticalScroll_3p2s80s$lambda$3;
                measureVerticalScroll_3p2s80s$lambda$3 = TextFieldCoreModifierNode.measureVerticalScroll_3p2s80s$lambda$3(TextFieldCoreModifierNode.this, min, mo6318measureBRTryo0, measureScope, (Placeable.PlacementScope) obj);
                return measureVerticalScroll_3p2s80s$lambda$3;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureVerticalScroll_3p2s80s$lambda$3(TextFieldCoreModifierNode textFieldCoreModifierNode, int i, Placeable placeable, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        textFieldCoreModifierNode.m1850updateScrollStatetIlFzwE(placementScope, i, placeable.getHeight(), textFieldCoreModifierNode.textFieldState.getVisualText().getSelection(), measureScope.getLayoutDirection());
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, -textFieldCoreModifierNode.scrollState.getValue(), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* renamed from: measureHorizontalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1848measureHorizontalScroll3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, (Object) null));
        final int min = Math.min(mo6318measureBRTryo0.getWidth(), Constraints.getMaxWidth-impl(j));
        return MeasureScope.layout$default(measureScope, min, mo6318measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit measureHorizontalScroll_3p2s80s$lambda$4;
                measureHorizontalScroll_3p2s80s$lambda$4 = TextFieldCoreModifierNode.measureHorizontalScroll_3p2s80s$lambda$4(TextFieldCoreModifierNode.this, min, mo6318measureBRTryo0, measureScope, (Placeable.PlacementScope) obj);
                return measureHorizontalScroll_3p2s80s$lambda$4;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureHorizontalScroll_3p2s80s$lambda$4(TextFieldCoreModifierNode textFieldCoreModifierNode, int i, Placeable placeable, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        textFieldCoreModifierNode.m1850updateScrollStatetIlFzwE(placementScope, i, placeable.getWidth(), textFieldCoreModifierNode.textFieldState.getVisualText().getSelection(), measureScope.getLayoutDirection());
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, -textFieldCoreModifierNode.scrollState.getValue(), 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* renamed from: calculateOffsetToFollow-8ffj60Q, reason: not valid java name */
    private final int m1846calculateOffsetToFollow8ffj60Q(long currSelection, int currContainerSize, int currTextLayoutSize) {
        TextRange textRange = this.previousSelection;
        if (!(textRange != null && TextRange.getEnd-impl(currSelection) == TextRange.getEnd-impl(textRange.unbox-impl()))) {
            return TextRange.getEnd-impl(currSelection);
        }
        TextRange textRange2 = this.previousSelection;
        if (!(textRange2 != null && TextRange.getStart-impl(currSelection) == TextRange.getStart-impl(textRange2.unbox-impl()))) {
            return TextRange.getStart-impl(currSelection);
        }
        if (currTextLayoutSize == this.previousTextLayoutSize && currContainerSize == this.previousContainerSize) {
            return -1;
        }
        return TextRange.getStart-impl(currSelection);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* renamed from: updateScrollState-tIlFzwE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m1850updateScrollStatetIlFzwE(Density density, int i, int i2, long j, LayoutDirection layoutDirection) {
        TextLayoutResult layoutResult;
        Rect cursorRectInScroller;
        boolean z;
        float bottom;
        float f;
        float f2;
        this.scrollState.setViewportSize$foundation_release(i);
        this.scrollState.setMaxValue$foundation_release(i2 - i);
        int m1846calculateOffsetToFollow8ffj60Q = m1846calculateOffsetToFollow8ffj60Q(j, i, i2);
        if (m1846calculateOffsetToFollow8ffj60Q < 0 || !getShowCursor() || (layoutResult = this.textLayoutState.getLayoutResult()) == null) {
            return;
        }
        Rect cursorRect = layoutResult.getCursorRect(RangesKt.coerceIn(m1846calculateOffsetToFollow8ffj60Q, new IntRange(0, layoutResult.getLayoutInput().getText().length())));
        cursorRectInScroller = TextFieldCoreModifierKt.getCursorRectInScroller(density, cursorRect, layoutDirection == LayoutDirection.Rtl, i2);
        if (cursorRectInScroller.getLeft() == this.previousCursorRect.getLeft()) {
            if ((cursorRectInScroller.getTop() == this.previousCursorRect.getTop()) && i2 == this.previousTextLayoutSize) {
                z = false;
                if (z && i == this.previousContainerSize) {
                    return;
                }
                boolean z2 = this.orientation == Orientation.Vertical;
                float top = !z2 ? cursorRectInScroller.getTop() : cursorRectInScroller.getLeft();
                bottom = !z2 ? cursorRectInScroller.getBottom() : cursorRectInScroller.getRight();
                int value = this.scrollState.getValue();
                f = value + i;
                if (bottom <= f) {
                    float f3 = value;
                    if (top >= f3 || bottom - top <= i) {
                        f2 = (top >= f3 || bottom - top > ((float) i)) ? 0.0f : top - f3;
                        this.previousSelection = TextRange.box-impl(j);
                        this.previousCursorRect = cursorRectInScroller;
                        this.previousContainerSize = i;
                        this.previousTextLayoutSize = i2;
                        BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldCoreModifierNode$updateScrollState$1(this, f2, z, cursorRect, null), 1, (Object) null);
                    }
                }
                f2 = bottom - f;
                this.previousSelection = TextRange.box-impl(j);
                this.previousCursorRect = cursorRectInScroller;
                this.previousContainerSize = i;
                this.previousTextLayoutSize = i2;
                BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldCoreModifierNode$updateScrollState$1(this, f2, z, cursorRect, null), 1, (Object) null);
            }
        }
        z = true;
        if (z) {
        }
        if (this.orientation == Orientation.Vertical) {
        }
        if (!z2) {
        }
        if (!z2) {
        }
        int value2 = this.scrollState.getValue();
        f = value2 + i;
        if (bottom <= f) {
        }
        f2 = bottom - f;
        this.previousSelection = TextRange.box-impl(j);
        this.previousCursorRect = cursorRectInScroller;
        this.previousContainerSize = i;
        this.previousTextLayoutSize = i2;
        BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldCoreModifierNode$updateScrollState$1(this, f2, z, cursorRect, null), 1, (Object) null);
    }

    /* renamed from: drawSelection-Sb-Bc2M, reason: not valid java name */
    private final void m1847drawSelectionSbBc2M(DrawScope drawScope, long j, TextLayoutResult textLayoutResult) {
        int i = TextRange.getMin-impl(j);
        int i2 = TextRange.getMax-impl(j);
        if (i != i2) {
            DrawScope.m5407drawPathLG529CI$default(drawScope, textLayoutResult.getPathForRange(i, i2), ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor(), 0.0f, null, null, 0, 60, null);
        }
    }

    private final void drawHighlight(DrawScope drawScope, Pair<TextHighlightType, TextRange> pair, TextLayoutResult textLayoutResult) {
        int value = ((TextHighlightType) pair.component1()).getValue();
        long j = ((TextRange) pair.component2()).unbox-impl();
        if (TextRange.getCollapsed-impl(j)) {
            return;
        }
        Path pathForRange = textLayoutResult.getPathForRange(TextRange.getMin-impl(j), TextRange.getMax-impl(j));
        if (TextHighlightType.m1747equalsimpl0(value, TextHighlightType.INSTANCE.m1751getHandwritingDeletePreviewsxJuwY())) {
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush != null) {
                DrawScope.m5406drawPathGBMwjPU$default(drawScope, pathForRange, brush, 0.2f, null, null, 0, 56, null);
                return;
            }
            long j2 = textLayoutResult.getLayoutInput().getStyle().getColor-0d7_KjU();
            if (!(j2 != 16)) {
                j2 = Color.INSTANCE.m4865getBlack0d7_KjU();
            }
            long j3 = j2;
            DrawScope.m5407drawPathLG529CI$default(drawScope, pathForRange, Color.m4838copywmQWz5c$default(j3, Color.m4841getAlphaimpl(j3) * 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, null, null, 0, 60, null);
            return;
        }
        DrawScope.m5407drawPathLG529CI$default(drawScope, pathForRange, ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor(), 0.0f, null, null, 0, 60, null);
    }

    private final void drawCursor(DrawScope drawScope) {
        CursorAnimationState cursorAnimationState = this.cursorAnimation;
        float cursorAlpha = cursorAnimationState != null ? cursorAnimationState.getCursorAlpha() : 0.0f;
        if ((cursorAlpha == 0.0f) || !getShowCursor()) {
            return;
        }
        Rect cursorRect = this.textFieldSelectionState.getCursorRect();
        DrawScope.m5402drawLine1RTmtNc$default(drawScope, this.cursorBrush, cursorRect.m4627getTopCenterF1C5BW0(), cursorRect.m4620getBottomCenterF1C5BW0(), cursorRect.getRight() - cursorRect.getLeft(), 0, null, cursorAlpha, null, 0, 432, null);
    }

    private final void startCursorJob() {
        if (this.cursorAnimation == null) {
            this.cursorAnimation = new CursorAnimationState(((Boolean) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalCursorBlinkEnabled())).booleanValue());
            DrawModifierNodeKt.invalidateDraw(this);
        }
        this.changeObserverJob = BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldCoreModifierNode$startCursorJob$1(this, null), 3, (Object) null);
    }

    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setCoreNodeCoordinates(coordinates);
        this.textFieldMagnifierNode.onGloballyPositioned(coordinates);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.textFieldMagnifierNode.applySemantics(semanticsPropertyReceiver);
    }

    private final void drawText(DrawScope drawScope, TextLayoutResult textLayoutResult) {
        TextPainter.INSTANCE.paint(drawScope.getDrawContext().getCanvas(), textLayoutResult);
    }
}
