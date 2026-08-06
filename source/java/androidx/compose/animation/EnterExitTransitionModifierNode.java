package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0007¢\u0006\u0004\bL\u0010MJ\b\u0010N\u001a\u00020OH\u0016J\u001d\u0010P\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0007¢\u0006\u0004\bQ\u0010MJ#\u0010R\u001a\u00020S*\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u000206H\u0016¢\u0006\u0004\bX\u0010YJ\u001d\u0010\\\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0007¢\u0006\u0004\b]\u0010MR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR2\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR2\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR2\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R \u00107\u001a\u0002062\u0006\u00105\u001a\u000206@BX\u0082\u000e¢\u0006\n\n\u0002\u00104\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010;8F¢\u0006\u0006\u001a\u0004\bA\u0010=R.\u0010B\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070E0C¢\u0006\u0002\bF¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR.\u0010Z\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0E0C¢\u0006\u0002\bF¢\u0006\b\n\u0000\u001a\u0004\b[\u0010H¨\u0006^"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getOffsetAnimation", "setOffsetAnimation", "getSlideAnimation", "setSlideAnimation", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "lookaheadConstraintsAvailable", "lookaheadSize", "J", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "currentAlignment", "Landroidx/compose/ui/Alignment;", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "alignment", "getAlignment", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "onAttach", "", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "slideSpec", "getSlideSpec", "slideTargetValueByState", "slideTargetValueByState-oFUgxo0", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    private Alignment currentAlignment;
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0<Boolean> isEnabled;
    private boolean lookaheadConstraintsAvailable;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;
    private Transition<EnterExitState> transition;
    private long lookaheadSize = AnimationModifierKt.getInvalidSize();
    private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$sizeTransitionSpec$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<EnterExitState> segment) {
            SpringSpec springSpec;
            SpringSpec springSpec2;
            SpringSpec springSpec3 = null;
            if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                ChangeSize changeSize = EnterExitTransitionModifierNode.this.getEnter().getData().getChangeSize();
                if (changeSize != null) {
                    springSpec3 = changeSize.getAnimationSpec();
                }
            } else if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                springSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                springSpec3 = springSpec;
            } else {
                ChangeSize changeSize2 = EnterExitTransitionModifierNode.this.getExit().getData().getChangeSize();
                if (changeSize2 != null) {
                    springSpec3 = changeSize2.getAnimationSpec();
                }
            }
            if (springSpec3 != null) {
                return springSpec3;
            }
            springSpec2 = EnterExitTransitionKt.DefaultSizeAnimationSpec;
            return springSpec2;
        }
    };
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> slideSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
            SpringSpec springSpec;
            SpringSpec springSpec2;
            FiniteAnimationSpec<IntOffset> animationSpec;
            SpringSpec springSpec3;
            FiniteAnimationSpec<IntOffset> animationSpec2;
            if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                Slide slide = EnterExitTransitionModifierNode.this.getEnter().getData().getSlide();
                if (slide != null && (animationSpec2 = slide.getAnimationSpec()) != null) {
                    return animationSpec2;
                }
                springSpec3 = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                return springSpec3;
            }
            if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                springSpec = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                return springSpec;
            }
            Slide slide2 = EnterExitTransitionModifierNode.this.getExit().getData().getSlide();
            if (slide2 != null && (animationSpec = slide2.getAnimationSpec()) != null) {
                return animationSpec;
            }
            springSpec2 = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            return springSpec2;
        }
    };

    /* compiled from: EnterExitTransition.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public final void setTransition(Transition<EnterExitState> transition) {
        this.transition = transition;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final void setSizeAnimation(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation) {
        this.sizeAnimation = deferredAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final void setOffsetAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.offsetAnimation = deferredAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    public final void setSlideAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.slideAnimation = deferredAnimation;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final void setEnter(EnterTransition enterTransition) {
        this.enter = enterTransition;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final void setExit(ExitTransition exitTransition) {
        this.exit = exitTransition;
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(Function0<Boolean> function0) {
        this.isEnabled = function0;
    }

    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final void setGraphicsLayerBlock(GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    public EnterExitTransitionModifierNode(Transition<EnterExitState> transition, Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3, EnterTransition enterTransition, ExitTransition exitTransition, Function0<Boolean> function0, GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.transition = transition;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransition;
        this.exit = exitTransition;
        this.isEnabled = function0;
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    /* renamed from: setLookaheadConstraints-BRTryo0, reason: not valid java name */
    private final void m215setLookaheadConstraintsBRTryo0(long j) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = j;
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final void setCurrentAlignment(Alignment alignment) {
        this.currentAlignment = alignment;
    }

    public final Alignment getAlignment() {
        Alignment alignment;
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            ChangeSize changeSize = this.enter.getData().getChangeSize();
            if (changeSize == null || (alignment = changeSize.getAlignment()) == null) {
                ChangeSize changeSize2 = this.exit.getData().getChangeSize();
                if (changeSize2 != null) {
                    return changeSize2.getAlignment();
                }
                return null;
            }
        } else {
            ChangeSize changeSize3 = this.exit.getData().getChangeSize();
            if (changeSize3 == null || (alignment = changeSize3.getAlignment()) == null) {
                ChangeSize changeSize4 = this.enter.getData().getChangeSize();
                if (changeSize4 != null) {
                    return changeSize4.getAlignment();
                }
                return null;
            }
        }
        return alignment;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    /* renamed from: sizeByState-Uzc_VyU, reason: not valid java name */
    public final long m217sizeByStateUzc_VyU(EnterExitState targetState, long fullSize) {
        Function1<IntSize, IntSize> size;
        Function1<IntSize, IntSize> size2;
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i == 1) {
            return fullSize;
        }
        if (i == 2) {
            ChangeSize changeSize = this.enter.getData().getChangeSize();
            return (changeSize == null || (size = changeSize.getSize()) == null) ? fullSize : ((IntSize) size.invoke(IntSize.box-impl(fullSize))).unbox-impl();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ChangeSize changeSize2 = this.exit.getData().getChangeSize();
        return (changeSize2 == null || (size2 = changeSize2.getSize()) == null) ? fullSize : ((IntSize) size2.invoke(IntSize.box-impl(fullSize))).unbox-impl();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    /* renamed from: targetOffsetByState-oFUgxo0, reason: not valid java name */
    public final long m219targetOffsetByStateoFUgxo0(EnterExitState targetState, long fullSize) {
        if (this.currentAlignment != null && getAlignment() != null && !Intrinsics.areEqual(this.currentAlignment, getAlignment())) {
            int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
            if (i == 1) {
                return IntOffset.Companion.getZero-nOcc-ac();
            }
            if (i == 2) {
                return IntOffset.Companion.getZero-nOcc-ac();
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            ChangeSize changeSize = this.exit.getData().getChangeSize();
            if (changeSize != null) {
                long j = ((IntSize) changeSize.getSize().invoke(IntSize.box-impl(fullSize))).unbox-impl();
                Alignment alignment = getAlignment();
                Intrinsics.checkNotNull(alignment);
                long mo4279alignKFBX0sM = alignment.mo4279alignKFBX0sM(fullSize, j, LayoutDirection.Ltr);
                Alignment alignment2 = this.currentAlignment;
                Intrinsics.checkNotNull(alignment2);
                return IntOffset.minus-qkQi6aY(mo4279alignKFBX0sM, alignment2.mo4279alignKFBX0sM(fullSize, j, LayoutDirection.Ltr));
            }
            return IntOffset.Companion.getZero-nOcc-ac();
        }
        return IntOffset.Companion.getZero-nOcc-ac();
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m216measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        State<IntOffset> animate;
        State<IntOffset> animate2;
        if (this.transition.getCurrentState() == this.transition.getTargetState()) {
            this.currentAlignment = null;
        } else if (this.currentAlignment == null) {
            Alignment alignment = getAlignment();
            if (alignment == null) {
                alignment = Alignment.INSTANCE.getTopStart();
            }
            this.currentAlignment = alignment;
        }
        if (measureScope.isLookingAhead()) {
            final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
            long j2 = IntSize.constructor-impl((mo6318measureBRTryo0.getWidth() << 32) | (mo6318measureBRTryo0.getHeight() & 4294967295L));
            this.lookaheadSize = j2;
            m215setLookaheadConstraintsBRTryo0(j);
            return MeasureScope.layout$default(measureScope, (int) (j2 >> 32), (int) (j2 & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        if (((Boolean) this.isEnabled.invoke()).booleanValue()) {
            final Function1<GraphicsLayerScope, Unit> init = this.graphicsLayerBlock.init();
            final Placeable mo6318measureBRTryo02 = measurable.mo6318measureBRTryo0(j);
            long j3 = IntSize.constructor-impl((mo6318measureBRTryo02.getWidth() << 32) | (mo6318measureBRTryo02.getHeight() & 4294967295L));
            final long j4 = AnimationModifierKt.m181isValidozmzZPI(this.lookaheadSize) ? this.lookaheadSize : j3;
            Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
            State<IntSize> animate3 = deferredAnimation != null ? deferredAnimation.animate(this.sizeTransitionSpec, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return IntSize.box-impl(m220invokeYEO4UFw((EnterExitState) obj));
                }

                /* renamed from: invoke-YEO4UFw, reason: not valid java name */
                public final long m220invokeYEO4UFw(EnterExitState enterExitState) {
                    return EnterExitTransitionModifierNode.this.m217sizeByStateUzc_VyU(enterExitState, j4);
                }
            }) : null;
            if (animate3 != null) {
                j3 = animate3.getValue().unbox-impl();
            }
            long j5 = ConstraintsKt.constrain-4WqzIAM(j, j3);
            Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2 = this.offsetAnimation;
            final long j6 = (deferredAnimation2 == null || (animate2 = deferredAnimation2.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$1
                public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
                    SpringSpec springSpec;
                    springSpec = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    return springSpec;
                }
            }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return IntOffset.box-impl(m221invokeBjo55l4((EnterExitState) obj));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m221invokeBjo55l4(EnterExitState enterExitState) {
                    return EnterExitTransitionModifierNode.this.m219targetOffsetByStateoFUgxo0(enterExitState, j4);
                }
            })) == null) ? IntOffset.Companion.getZero-nOcc-ac() : animate2.getValue().unbox-impl();
            Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = this.slideAnimation;
            long j7 = (deferredAnimation3 == null || (animate = deferredAnimation3.animate(this.slideSpec, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$slideOffset$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return IntOffset.box-impl(m222invokeBjo55l4((EnterExitState) obj));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m222invokeBjo55l4(EnterExitState enterExitState) {
                    return EnterExitTransitionModifierNode.this.m218slideTargetValueByStateoFUgxo0(enterExitState, j4);
                }
            })) == null) ? IntOffset.Companion.getZero-nOcc-ac() : animate.getValue().unbox-impl();
            Alignment alignment2 = this.currentAlignment;
            final long j8 = IntOffset.plus-qkQi6aY(alignment2 != null ? alignment2.mo4279alignKFBX0sM(j4, j5, LayoutDirection.Ltr) : IntOffset.Companion.getZero-nOcc-ac(), j7);
            return MeasureScope.layout$default(measureScope, (int) (j5 >> 32), (int) (j5 & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    placementScope.placeWithLayer(Placeable.this, IntOffset.getX-impl(j6) + IntOffset.getX-impl(j8), IntOffset.getY-impl(j6) + IntOffset.getY-impl(j8), 0.0f, init);
                }
            }, 4, null);
        }
        final Placeable mo6318measureBRTryo03 = measurable.mo6318measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo6318measureBRTryo03.getWidth(), mo6318measureBRTryo03.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getSlideSpec() {
        return this.slideSpec;
    }

    /* renamed from: slideTargetValueByState-oFUgxo0, reason: not valid java name */
    public final long m218slideTargetValueByStateoFUgxo0(EnterExitState targetState, long fullSize) {
        Function1<IntSize, IntOffset> slideOffset;
        Function1<IntSize, IntOffset> slideOffset2;
        Slide slide = this.enter.getData().getSlide();
        long j = (slide == null || (slideOffset2 = slide.getSlideOffset()) == null) ? IntOffset.Companion.getZero-nOcc-ac() : ((IntOffset) slideOffset2.invoke(IntSize.box-impl(fullSize))).unbox-impl();
        Slide slide2 = this.exit.getData().getSlide();
        long j2 = (slide2 == null || (slideOffset = slide2.getSlideOffset()) == null) ? IntOffset.Companion.getZero-nOcc-ac() : ((IntOffset) slideOffset.invoke(IntSize.box-impl(fullSize))).unbox-impl();
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i == 1) {
            return IntOffset.Companion.getZero-nOcc-ac();
        }
        if (i == 2) {
            return j;
        }
        if (i == 3) {
            return j2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
