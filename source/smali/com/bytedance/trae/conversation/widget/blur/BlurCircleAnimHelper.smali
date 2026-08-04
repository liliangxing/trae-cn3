# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
.super Ljava/lang/Object;
.source "BlurCircleAnimHelper.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$Companion;
.field private static final STARTED:I
.field private static final STOPPED:I
.field private static final TAG:Ljava/lang/String;
.field private currentState:I
.field private playingAnimator:Landroid/animation/Animator;
.field private final view:Lcom/bytedance/trae/conversation/widget/blur/BlurView;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->Companion Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.widget.blur.BlurView)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->view Lcom/bytedance/trae/conversation/widget/blur/BlurView;
    const/4 v2, 1
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->currentState I
    return-void 
.end method

.method public static final synthetic access$getCurrentState$p(com.bytedance.trae.conversation.widget.blur.BlurCircleAnimHelper)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->currentState I
    return v0
.end method

.method public static final synthetic access$setPlayingAnimator$p(com.bytedance.trae.conversation.widget.blur.BlurCircleAnimHelper  android.animation.Animator)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->playingAnimator Landroid/animation/Animator;
    return-void 
.end method

.method public static final synthetic access$startAnimOnce(com.bytedance.trae.conversation.widget.blur.BlurCircleAnimHelper  com.bytedance.trae.conversation.widget.blur.BlurView  float  android.animation.Animator$AnimatorListener)android.animation.Animator
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->startAnimOnce(Lcom/bytedance/trae/conversation/widget/blur/BlurView; F Landroid/animation/Animator$AnimatorListener;)Landroid/animation/Animator;
    move-result-object v0
    return-object v0
.end method

.method private final calcTargetCircleScale(float)float
    .registers 8
    # ins_size=2
    const/high16 v0, 1065353216
    float-to-double v0, v0
    const-wide v2, 4591870180066957722
    float-to-double v4, v7
    mul-double/2addr v4, v2
    add-double/2addr v0, v4
    double-to-float v7, v0
    return v7
.end method

.method private final startAnimOnce(com.bytedance.trae.conversation.widget.blur.BlurView  float  android.animation.Animator$AnimatorListener)android.animation.Animator
    .registers 7
    # ins_size=4
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->calcTargetCircleScale(F)F
    move-result v5
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->playingAnimator Landroid/animation/Animator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/Animator;->cancel()V
    const/4 v0, 3
    new-array v0, v0, [F
    const/4 v1, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->getCircleScale()F
    move-result v2
    aput v2, v0, v1
    const/4 v1, 1
    aput v5, v0, v1
    const/4 v5, 2
    const/high16 v1, 1065353216
    aput v1, v0, v5
    const-string v5, "circleScale"
    invoke-static v4, v5, v0, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Ljava/lang/String; [F)Landroid/animation/ObjectAnimator;
    move-result-object v4
    const-wide/16 v0, 400
    invoke-virtual v4, v0, v1, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    invoke-virtual v4, v6, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V
    invoke-virtual v4, Landroid/animation/ObjectAnimator;->start()V
    move-object v5, v4
    check-cast v5, Landroid/animation/Animator;
    iput-object v5, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->playingAnimator Landroid/animation/Animator;
    const-string v6, "apply(...)"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method

.method public final getView()com.bytedance.trae.conversation.widget.blur.BlurView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->view Lcom/bytedance/trae/conversation/widget/blur/BlurView;
    return-object v0
.end method

.method public final isAnimating()boolean
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->currentState I
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final startAnim(kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=2
    const-string v0, "getAmplitude"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->currentState I
    if-nez v0, +003h
    return-void 
    const/4 v0, 0
    iput v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->currentState I
    new-instance v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;-><init>(Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper; Lkotlin/jvm/functions/Function0;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->view Lcom/bytedance/trae/conversation/widget/blur/BlurView;
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->floatValue()F
    move-result v3
    check-cast v0, Landroid/animation/Animator$AnimatorListener;
    invoke-direct v2, v1, v3, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->startAnimOnce(Lcom/bytedance/trae/conversation/widget/blur/BlurView; F Landroid/animation/Animator$AnimatorListener;)Landroid/animation/Animator;
    return-void 
.end method

.method public final stopAnim()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->currentState I
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->playingAnimator Landroid/animation/Animator;
    if-eqz v0, +008h
    invoke-virtual v0, Landroid/animation/Animator;->removeAllListeners()V
    invoke-virtual v0, Landroid/animation/Animator;->cancel()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->playingAnimator Landroid/animation/Animator;
    return-void 
.end method
