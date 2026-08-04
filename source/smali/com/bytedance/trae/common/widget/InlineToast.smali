# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/InlineToast;
.super Ljava/lang/Object;
.source "InlineToast.kt"

.field public static final DEFAULT_DURATION_MS:J
.field private static final DEFAULT_TOP_MARGIN_DP:I
.field private static final FADE_IN_MS:J
.field private static final FADE_OUT_MS:J
.field public static final INSTANCE:Lcom/bytedance/trae/common/widget/InlineToast;
.field public static final NO_ICON:I
.field private static final TAG:Ljava/lang/String;
.field private static currentHideRunnable:Ljava/lang/Runnable;
.field private static currentToastView:Landroid/view/View;


.method public static synthetic $r8$lambda$JROhnwc6CzcH6u3UZkGcx6ctPcQ(android.view.View)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/common/widget/InlineToast;->show$lambda$2(Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/InlineToast;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/InlineToast;-><init>()V
    sput-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->INSTANCE Lcom/bytedance/trae/common/widget/InlineToast;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$removeFromParent(com.bytedance.trae.common.widget.InlineToast  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/InlineToast;->removeFromParent(Landroid/view/View;)V
    return-void 
.end method

.method private final removeFromParent(android.view.View)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v1, v0, Landroid/view/ViewGroup;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    move-object v0, v2
    if-eqz v0, +005h
    invoke-virtual v0, v4, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    sget-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->currentToastView Landroid/view/View;
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +006h
    sput-object v2, Lcom/bytedance/trae/common/widget/InlineToast;->currentToastView Landroid/view/View;
    sput-object v2, Lcom/bytedance/trae/common/widget/InlineToast;->currentHideRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method private final resolveAnchor(android.view.ViewGroup)android.view.ViewGroup
    .registers 7
    # ins_size=2
    instance-of v0, v6, Landroid/widget/FrameLayout;
    if-eqz v0, +003h
    return-object v6
    invoke-virtual v6, Landroid/view/ViewGroup;->getRootView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ch
    const v1, 16908290
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    const/4 v0, 0
    instance-of v1, v0, Landroid/widget/FrameLayout;
    const-string v2, "container "
    const-string v3, "InlineToast"
    if-eqz v1, +023h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v2, " is not FrameLayout, fallback to android.R.id.content"
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " is not FrameLayout and no FrameLayout fallback available, layout may be broken"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v6
.end method

.method public static synthetic show$default(com.bytedance.trae.common.widget.InlineToast  android.view.ViewGroup  java.lang.CharSequence  int  long  int  com.bytedance.trae.common.widget.InlineToast$Position  int  int  java.lang.Object)void
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 4
    if-eqz v0, +005h
    const/4 v0, 0
    move v4, v0
    goto +2h
    move v4, v13
    and-int/lit8 v0, v19, 8
    if-eqz v0, +006h
    const-wide/16 v0, 2000
    move-wide v5, v0
    goto +2h
    move-wide v5, v14
    and-int/lit8 v0, v19, 16
    const/16 v1, 80
    if-eqz v0, +004h
    move v7, v1
    goto +3h
    move/from16 v7, v16
    and-int/lit8 v0, v19, 32
    if-eqz v0, +006h
    sget-object v0, Lcom/bytedance/trae/common/widget/InlineToast$Position;->TOP Lcom/bytedance/trae/common/widget/InlineToast$Position;
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v0, v19, 64
    if-eqz v0, +004h
    move v9, v1
    goto +3h
    move/from16 v9, v18
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/common/widget/InlineToast;->show(Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I)V
    return-void 
.end method

.method private static final show$lambda$2(android.view.View)void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const-wide/16 v1, 300
    invoke-virtual v0, v1, v2, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/common/widget/InlineToast$show$hideRunnable$1$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/common/widget/InlineToast$show$hideRunnable$1$1;-><init>(Landroid/view/View;)V
    check-cast v1, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;
    move-result-object v3
    invoke-virtual v3, Landroid/view/ViewPropertyAnimator;->start()V
    return-void 
.end method

.method public final dismiss()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->currentToastView Landroid/view/View;
    if-eqz v0, +015h
    invoke-virtual v0, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewPropertyAnimator;->cancel()V
    sget-object v1, Lcom/bytedance/trae/common/widget/InlineToast;->currentHideRunnable Ljava/lang/Runnable;
    if-eqz v1, +005h
    invoke-virtual v0, v1, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z
    sget-object v1, Lcom/bytedance/trae/common/widget/InlineToast;->INSTANCE Lcom/bytedance/trae/common/widget/InlineToast;
    invoke-direct v1, v0, Lcom/bytedance/trae/common/widget/InlineToast;->removeFromParent(Landroid/view/View;)V
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->currentHideRunnable Ljava/lang/Runnable;
    sput-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->currentToastView Landroid/view/View;
    return-void 
.end method

.method public final show(android.view.ViewGroup  java.lang.CharSequence)void
    .registers 15
    # ins_size=3
    const-string v0, "container"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const-wide/16 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 124
    const/4 v11, 0
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/InlineToast;->show$default(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I I Ljava/lang/Object;)V
    return-void 
.end method

.method public final show(android.view.ViewGroup  java.lang.CharSequence  int)void
    .registers 16
    # ins_size=4
    const-string v0, "container"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-wide/16 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 120
    const/4 v11, 0
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    move v4, v15
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/InlineToast;->show$default(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I I Ljava/lang/Object;)V
    return-void 
.end method

.method public final show(android.view.ViewGroup  java.lang.CharSequence  int  long)void
    .registers 18
    # ins_size=6
    const-string v0, "container"
    move-object v2, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 112
    const/4 v11, 0
    move-object v1, v12
    move v4, v15
    move-wide/from16 v5, v16
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/InlineToast;->show$default(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I I Ljava/lang/Object;)V
    return-void 
.end method

.method public final show(android.view.ViewGroup  java.lang.CharSequence  int  long  int)void
    .registers 19
    # ins_size=7
    const-string v0, "container"
    move-object v2, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 96
    const/4 v11, 0
    move-object v1, v12
    move v4, v15
    move-wide/from16 v5, v16
    move/from16 v7, v18
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/InlineToast;->show$default(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I I Ljava/lang/Object;)V
    return-void 
.end method

.method public final show(android.view.ViewGroup  java.lang.CharSequence  int  long  int  com.bytedance.trae.common.widget.InlineToast$Position)void
    .registers 20
    # ins_size=8
    const-string v0, "container"
    move-object v2, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "position"
    move-object/from16 v8, v19
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v9, 0
    const/16 v10, 64
    const/4 v11, 0
    move-object v1, v12
    move v4, v15
    move-wide/from16 v5, v16
    move/from16 v7, v18
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/InlineToast;->show$default(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I I Ljava/lang/Object;)V
    return-void 
.end method

.method public final show(android.view.ViewGroup  java.lang.CharSequence  int  long  int  com.bytedance.trae.common.widget.InlineToast$Position  int)void
    .registers 12
    # ins_size=9
    const-string v0, "container"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "position"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/InlineToast;->dismiss()V
    invoke-direct v3, v4, Lcom/bytedance/trae/common/widget/InlineToast;->resolveAnchor(Landroid/view/ViewGroup;)Landroid/view/ViewGroup;
    move-result-object v4
    invoke-virtual v4, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$layout;->trae_layout_inline_toast I
    const/4 v2, 0
    invoke-virtual v0, v1, v4, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$id;->tv_inline_toast_message I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    invoke-virtual v1, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$id;->iv_inline_toast_icon I
    invoke-virtual v0, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v6, +009h
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v5, v2, Landroid/widget/ImageView;->setVisibility(I)V
    goto +6h
    const/16 v6, 8
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setVisibility(I)V
    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v6, -2
    invoke-direct v5, v6, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    sget-object v6, Lcom/bytedance/trae/common/widget/InlineToast$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/InlineToast$Position;->ordinal()I
    move-result v1
    aget v6, v6, v1
    const/4 v1, 2
    const/4 v2, 1
    if-eq v6, v2, +00dh
    if-ne v6, v1, +005h
    const/16 v6, 81
    goto +9h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    const/16 v6, 49
    iput v6, v5, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    sget-object v6, Lcom/bytedance/trae/common/widget/InlineToast$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/InlineToast$Position;->ordinal()I
    move-result v10
    aget v6, v6, v10
    if-eq v6, v2, +01ah
    if-ne v6, v1, +012h
    int-to-float v6, v11
    invoke-virtual v4, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v9
    iget v9, v9, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v6, v9
    float-to-int v6, v6
    iput v6, v5, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin I
    goto +16h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    int-to-float v6, v9
    invoke-virtual v4, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v9
    iget v9, v9, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v6, v9
    float-to-int v6, v6
    iput v6, v5, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    const/4 v6, 0
    invoke-virtual v0, v6, Landroid/view/View;->setAlpha(F)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v0, v5, Landroid/view/ViewGroup;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    sput-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->currentToastView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v4
    const/high16 v5, 1065353216
    invoke-virtual v4, v5, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v4
    const-wide/16 v5, 200
    invoke-virtual v4, v5, v6, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v4
    invoke-virtual v4, Landroid/view/ViewPropertyAnimator;->start()V
    new-instance v4, Lcom/bytedance/trae/common/widget/InlineToast$$ExternalSyntheticLambda0;
    invoke-direct v4, v0, Lcom/bytedance/trae/common/widget/InlineToast$$ExternalSyntheticLambda0;-><init>(Landroid/view/View;)V
    sput-object v4, Lcom/bytedance/trae/common/widget/InlineToast;->currentHideRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v4, v7, v8, Landroid/view/View;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method
