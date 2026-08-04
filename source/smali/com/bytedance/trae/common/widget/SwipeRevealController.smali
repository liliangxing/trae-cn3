# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/SwipeRevealController;
.super Ljava/lang/Object;
.source "SwipeRevealController.kt"

.field public static final Companion:Lcom/bytedance/trae/common/widget/SwipeRevealController$Companion;
.field private static final DEFAULT_DAMPING_FACTOR:F
.field private final actionsView:Landroid/view/View;
.field private final animationDurationMs:J
.field private animationTargetShouldOpen:Z
.field private animationTargetTranslationX:F
.field private animator:Landroid/animation/ValueAnimator;
.field private final closedActionsVisibility:I
.field private final contentView:Landroid/view/View;
.field private lastTouchRawX:F
.field private lastTouchRawY:F
.field private final onCancelPendingLongPress:Lkotlin/jvm/functions/Function0;
.field private final onClosed:Lkotlin/jvm/functions/Function0;
.field private final onDragStarted:Lkotlin/jvm/functions/Function0;
.field private final onOpened:Lkotlin/jvm/functions/Function0;
.field private final state:Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;


.method public static synthetic $r8$lambda$By_amCgWFSirvHbDNsROOePwSKU(com.bytedance.trae.common.widget.SwipeRevealController  kotlin.jvm.functions.Function1  android.view.View)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContentWithTouch$lambda$8$lambda$7(Lcom/bytedance/trae/common/widget/SwipeRevealController; Lkotlin/jvm/functions/Function1; Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$F1N_0_3786Rsekj2tETOKH2lV_Q()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/SwipeRevealController;->_init_$lambda$2()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LqDIBd-kAqATUABl1UyGj2iSYIM(com.bytedance.trae.common.widget.SwipeRevealController  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContentWithTouch$lambda$6(Lcom/bytedance/trae/common/widget/SwipeRevealController; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$R09_4Q8xPpQhdWpl8Wm1av2gYJI()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/SwipeRevealController;->_init_$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hlBmq8dArY8VRjamF0rv0LKcyMM()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/SwipeRevealController;->_init_$lambda$3()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lTjq5wJeJtHwEyWM4iIDyGr_o54()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/SwipeRevealController;->_init_$lambda$1()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qnPrPK_Sezm8NRDj-jhYgTpcrdc(kotlin.jvm.functions.Function0  com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContent$lambda$5$lambda$4(Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qywacmRdWJBRSD4lA-E6volgcNQ(com.bytedance.trae.common.widget.SwipeRevealController  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animateTo$lambda$10$lambda$9(Lcom/bytedance/trae/common/widget/SwipeRevealController; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->Companion Lcom/bytedance/trae/common/widget/SwipeRevealController$Companion;
    return-void 
.end method

.method public constructor <init>(android.view.View  android.view.View  int  long  float  float  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 13
    # ins_size=12
    const-string v0, "contentView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actionsView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDragStarted"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onCancelPendingLongPress"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onOpened"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClosed"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    iput-object v3, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    iput v4, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->closedActionsVisibility I
    iput-wide v5, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animationDurationMs J
    iput-object v9, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onDragStarted Lkotlin/jvm/functions/Function0;
    iput-object v10, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onCancelPendingLongPress Lkotlin/jvm/functions/Function0;
    iput-object v11, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onOpened Lkotlin/jvm/functions/Function0;
    iput-object v12, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onClosed Lkotlin/jvm/functions/Function0;
    new-instance v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-direct v2, v7, v8, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;-><init>(F F)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    const/high16 v2, -4194304
    iput v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawX F
    iput v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawY F
    return-void 
.end method

.method public synthetic constructor <init>(android.view.View  android.view.View  int  long  float  float  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 28
    # ins_size=14
    move/from16 v0, v26
    and-int/lit8 v1, v0, 4
    if-eqz v1, +005h
    const/4 v1, 4
    move v5, v1
    goto +3h
    move/from16 v5, v17
    and-int/lit8 v1, v0, 8
    if-eqz v1, +006h
    const-wide/16 v1, 200
    move-wide v6, v1
    goto +3h
    move-wide/from16 v6, v18
    and-int/lit8 v1, v0, 16
    if-eqz v1, +011h
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I
    move-result v1
    int-to-float v1, v1
    move v8, v1
    goto +3h
    move/from16 v8, v20
    and-int/lit8 v1, v0, 32
    if-eqz v1, +007h
    const v1, 1055286886
    move v9, v1
    goto +3h
    move/from16 v9, v21
    and-int/lit8 v1, v0, 64
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda4;
    invoke-direct v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda4;-><init>()V
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v1, v0, 128
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda5;
    invoke-direct v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda5;-><init>()V
    move-object v11, v1
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v1, v0, 256
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda6;
    invoke-direct v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda6;-><init>()V
    move-object v12, v1
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v0, v0, 512
    if-eqz v0, +009h
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda7;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda7;-><init>()V
    move-object v13, v0
    goto +3h
    move-object/from16 v13, v25
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v16
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/common/widget/SwipeRevealController;-><init>(Landroid/view/View; Landroid/view/View; I J F F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final _init_$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$1()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$2()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$3()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final synthetic access$setAnimator$p(com.bytedance.trae.common.widget.SwipeRevealController  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animator Landroid/animation/ValueAnimator;
    return-void 
.end method

.method public static final synthetic access$settleAnimationTarget(com.bytedance.trae.common.widget.SwipeRevealController  float  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->settleAnimationTarget(F Z)V
    return-void 
.end method

.method private final animateTo(float  boolean)void
    .registers 7
    # ins_size=3
    const/4 v0, 0
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v4, v1, v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelAnimator$default(Lcom/bytedance/trae/common/widget/SwipeRevealController; Z I Ljava/lang/Object;)V
    iput v5, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animationTargetTranslationX F
    iput-boolean v6, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animationTargetShouldOpen Z
    if-eqz v6, +007h
    iget-object v0, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    const/4 v0, 2
    new-array v0, v0, [F
    iget-object v3, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getTranslationX()F
    move-result v3
    aput v3, v0, v1
    aput v5, v0, v2
    invoke-static v0, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    iget-wide v1, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animationDurationMs J
    invoke-virtual v0, v1, v2, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/common/widget/SwipeRevealController;)V
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    new-instance v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;
    invoke-direct v1, v4, v5, v6, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;-><init>(Lcom/bytedance/trae/common/widget/SwipeRevealController; F Z)V
    check-cast v1, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V
    iput-object v0, v4, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animator Landroid/animation/ValueAnimator;
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    return-void 
.end method

.method private static final animateTo$lambda$10$lambda$9(com.bytedance.trae.common.widget.SwipeRevealController  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v2, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Float;
    invoke-virtual v2, Ljava/lang/Float;->floatValue()F
    move-result v2
    invoke-virtual v1, v2, Landroid/view/View;->setTranslationX(F)V
    return-void 
.end method

.method public static synthetic attachToContent$default(com.bytedance.trae.common.widget.SwipeRevealController  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContent(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final attachToContent$lambda$5$lambda$4(kotlin.jvm.functions.Function0  com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public static synthetic attachToContentWithTouch$default(com.bytedance.trae.common.widget.SwipeRevealController  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContentWithTouch(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final attachToContentWithTouch$lambda$6(com.bytedance.trae.common.widget.SwipeRevealController  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->handleTouch(Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method private static final attachToContentWithTouch$lambda$8$lambda$7(com.bytedance.trae.common.widget.SwipeRevealController  kotlin.jvm.functions.Function1  android.view.View)boolean
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->getCanTriggerLongPress()Z
    move-result v2
    if-eqz v2, +00ah
    invoke-direct v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->currentLongPressTouch()Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    move-result-object v0
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +4h
    invoke-direct v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelPendingLongPress()V
    const/4 v0, 1
    return v0
.end method

.method private final cancelAnimator(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animator Landroid/animation/ValueAnimator;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/animation/ValueAnimator;->removeAllUpdateListeners()V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->removeAllListeners()V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animator Landroid/animation/ValueAnimator;
    if-eqz v2, +009h
    iget v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animationTargetTranslationX F
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animationTargetShouldOpen Z
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->settleAnimationTarget(F Z)V
    return-void 
.end method

.method static synthetic cancelAnimator$default(com.bytedance.trae.common.widget.SwipeRevealController  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelAnimator(Z)V
    return-void 
.end method

.method private final cancelPendingLongPress()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->cancelLongPress()V
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setPressed(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->jumpDrawablesToCurrentState()V
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onCancelPendingLongPress Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final clearLastTouchRaw()void
    .registers 2
    # ins_size=1
    const/high16 v0, -4194304
    iput v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawX F
    iput v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawY F
    return-void 
.end method

.method private final currentLongPressTouch()com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch
    .registers 6
    # ins_size=1
    iget v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawX F
    invoke-static v0, Ljava/lang/Float;->isNaN(F)Z
    move-result v0
    if-nez v0, +014h
    iget v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawY F
    invoke-static v0, Ljava/lang/Float;->isNaN(F)Z
    move-result v0
    if-nez v0, +00ch
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    iget v1, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawX F
    iget v2, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawY F
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;-><init>(F F)V
    return-object v0
    const/4 v0, 2
    new-array v0, v0, [I
    iget-object v1, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v1, v0, Landroid/view/View;->getLocationOnScreen([I)V
    new-instance v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    const/4 v2, 0
    aget v2, v0, v2
    int-to-float v2, v2
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getWidth()I
    move-result v3
    int-to-float v3, v3
    const/high16 v4, 1073741824
    div-float/2addr v3, v4
    add-float/2addr v2, v3
    const/4 v3, 1
    aget v0, v0, v3
    int-to-float v0, v0
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getHeight()I
    move-result v3
    int-to-float v3, v3
    div-float/2addr v3, v4
    add-float/2addr v0, v3
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;-><init>(F F)V
    return-object v1
.end method

.method private final measureActionsWidth()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getHeight()I
    move-result v0
    const/4 v1, 0
    if-lez v0, +00fh
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getHeight()I
    move-result v0
    const/high16 v2, 1073741824
    invoke-static v0, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v0
    goto +5h
    invoke-static v1, v1, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v0
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-static v1, v1, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v1
    invoke-virtual v2, v1, v0, Landroid/view/View;->measure(I I)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getMeasuredWidth()I
    move-result v0
    return v0
.end method

.method private final revealWidth()float
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getWidth()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-lez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    const/4 v4, 0
    if-eqz v1, +003h
    goto +2h
    move-object v0, v4
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +24h
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getMeasuredWidth()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    if-lez v1, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +003h
    move-object v4, v0
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +5h
    invoke-direct v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->measureActionsWidth()I
    move-result v0
    const/4 v1, 0
    int-to-float v0, v0
    invoke-static v1, v0, Ljava/lang/Math;->max(F F)F
    move-result v0
    return v0
.end method

.method private final settleAnimationTarget(float  boolean)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setTranslationX(F)V
    if-eqz v3, +00eh
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    const/4 v3, 0
    invoke-virtual v2, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onOpened Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +dh
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    iget v3, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->closedActionsVisibility I
    invoke-virtual v2, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onClosed Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final animateClose()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->setClosed()V
    const/4 v0, 0
    const/4 v1, 0
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animateTo(F Z)V
    return-void 
.end method

.method public final animateOpen()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-direct v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->revealWidth()F
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->setOpen(F)V
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->getTranslationX()F
    move-result v0
    const/4 v1, 1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animateTo(F Z)V
    return-void 
.end method

.method public final attachToContent(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    if-eqz v2, +008h
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0;)V
    goto +2h
    const/4 v0, 0
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContentWithTouch(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public final attachToContentWithTouch(kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    new-instance v1, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/common/widget/SwipeRevealController;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    if-eqz v3, +008h
    new-instance v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda3;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/common/widget/SwipeRevealController; Lkotlin/jvm/functions/Function1;)V
    goto +2h
    const/4 v0, 0
    iget-object v3, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v3, v0, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    return-void 
.end method

.method public final getCanTriggerLongPress()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->getCanTriggerLongPress()Z
    move-result v0
    if-eqz v0, +008h
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animator Landroid/animation/ValueAnimator;
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final handleTouch(android.view.MotionEvent)boolean
    .registers 7
    # ins_size=2
    const-string v0, "event"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +08fh
    if-eq v0, v1, +05ch
    const/4 v3, 2
    if-eq v0, v3, +00dh
    const/4 v6, 3
    if-eq v0, v6, +056h
    iget-object v6, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging()Z
    move-result v2
    goto/16 +0a6h
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v3
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v6
    invoke-direct v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->revealWidth()F
    move-result v4
    invoke-virtual v0, v3, v6, v4, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->onMove(F F F)Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->getDragStarted()Z
    move-result v0
    if-eqz v0, +01ah
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onDragStarted Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v1, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    invoke-direct v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelPendingLongPress()V
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging()Z
    move-result v0
    if-eqz v0, +013h
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->getTranslationX()F
    move-result v1
    invoke-virtual v0, v1, Landroid/view/View;->setTranslationX(F)V
    invoke-direct v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelPendingLongPress()V
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging()Z
    move-result v2
    goto +59h
    iget-object v6, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-direct v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->revealWidth()F
    move-result v0
    invoke-virtual v6, v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->onRelease(F)Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;->getWasDragging()Z
    move-result v0
    if-eqz v0, +010h
    invoke-direct v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelPendingLongPress()V
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;->getTargetTranslationX()F
    move-result v0
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;->getShouldOpen()Z
    move-result v1
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animateTo(F Z)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    invoke-direct v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->clearLastTouchRaw()V
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;->getWasDragging()Z
    move-result v2
    goto +28h
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v0
    iput v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawX F
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v0
    iput v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->lastTouchRawY F
    invoke-direct v5, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelAnimator(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v1
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v6
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->onDown(F F)V
    iget-object v6, v5, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    invoke-virtual v6, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v6
    if-eqz v6, +005h
    invoke-interface v6, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    return v2
.end method

.method public final isDragging()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging()Z
    move-result v0
    return v0
.end method

.method public final isOpen()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isOpen()Z
    move-result v0
    return v0
.end method

.method public final reset()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v3, v2, v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->cancelAnimator$default(Lcom/bytedance/trae/common/widget/SwipeRevealController; Z I Ljava/lang/Object;)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->state Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->setClosed()V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->contentView Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setTranslationX(F)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->actionsView Landroid/view/View;
    iget v1, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->closedActionsVisibility I
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->onClosed Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method
