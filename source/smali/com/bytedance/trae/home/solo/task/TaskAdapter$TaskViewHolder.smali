# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "TaskAdapter.kt"

.field private final btnDelete:Landroid/view/View;
.field private final btnPin:Landroid/view/View;
.field private final btnRename:Landroid/view/View;
.field private currentTask:Lcom/bytedance/trae/home/solo/task/TaskModel;
.field private final dampingFactor:F
.field private final flIconContainer:Landroid/widget/FrameLayout;
.field private isDragging:Z
.field private isOpen:Z
.field private final ivEmojiIcon:Landroid/widget/ImageView;
.field private final ivPin:Landroid/widget/ImageView;
.field private final ivProduct:Landroid/widget/ImageView;
.field private final ivSourceIcon:Landroid/widget/ImageView;
.field private final layoutContent:Landroid/view/View;
.field private final layoutSwipeActions:Landroid/view/View;
.field private final longPressHandler:Landroid/os/Handler;
.field private longPressRunnable:Ljava/lang/Runnable;
.field private longPressTriggered:Z
.field private final pbLoading:Landroid/widget/ProgressBar;
.field private startX:F
.field private startY:F
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskAdapter;
.field private final tvLocation:Landroid/widget/TextView;
.field private final tvLocationDefaultMarginStart:I
.field private final tvPin:Landroid/widget/TextView;
.field private final tvSourceDivider:Landroid/widget/TextView;
.field private final tvTime:Landroid/widget/TextView;
.field private final tvTitle:Landroid/widget/TextView;
.field private final vBadge:Landroid/view/View;


.method public static synthetic $r8$lambda$1CSZhfc58WMRXoLyQG5N2EXwZIw(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->bind$lambda$14$lambda$13$lambda$12(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$C0Kf89S5MmzdDK4q2GIDpho7tEg(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->bind$lambda$17$lambda$16$lambda$15(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CjTJaFMB9gjfGurKJfuZRL-zWmc(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->bind$lambda$11(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HmULxzLR-fnPIFJdhhamXecbSnk(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->bind$lambda$14(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$K3IKxGiiBC63DHqfLxRsHcftbxo(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->_init_$lambda$0(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$bx5MLMpgVumx5E9Vr7FtyLxhTOA(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose$lambda$26$lambda$25(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$eCIDZHxx4iqL1RJBAa5y-4nXM3s(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->bind$lambda$11$lambda$10$lambda$9(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eyVr6ZgvtT7GSOfQU4f_cfZGaOw(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->bind$lambda$17(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hgJN_9AXQSlBwRnAthYsjbolAZ4(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->_init_$lambda$2(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$nfXC_AzimxtnKv0ealOxopindWc(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  float  float)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->scheduleLongPress$lambda$19(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; F F)V
    return-void 
.end method

.method public static synthetic $r8$lambda$zYvYvjx50Y-Q8YYpG6rwC0eCj74(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateOpen$lambda$23$lambda$22(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)void
    .registers 7
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-direct v4, v6, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->layout_content I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    sget v2, Lcom/bytedance/trae/home/R$id;->layout_swipe_actions I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutSwipeActions Landroid/view/View;
    sget v2, Lcom/bytedance/trae/home/R$id;->btn_pin I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnPin Landroid/view/View;
    sget v2, Lcom/bytedance/trae/home/R$id;->iv_pin I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivPin Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/home/R$id;->tv_pin I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvPin Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/home/R$id;->btn_rename I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnRename Landroid/view/View;
    sget v2, Lcom/bytedance/trae/home/R$id;->btn_delete I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnDelete Landroid/view/View;
    sget v2, Lcom/bytedance/trae/home/R$id;->fl_icon_container I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/FrameLayout;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->flIconContainer Landroid/widget/FrameLayout;
    sget v2, Lcom/bytedance/trae/home/R$id;->iv_emoji_icon I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivEmojiIcon Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/home/R$id;->pb_loading I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ProgressBar;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->pbLoading Landroid/widget/ProgressBar;
    sget v2, Lcom/bytedance/trae/home/R$id;->v_badge I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->vBadge Landroid/view/View;
    sget v2, Lcom/bytedance/trae/home/R$id;->tv_title I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvTitle Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/home/R$id;->iv_source_icon I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivSourceIcon Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/home/R$id;->iv_product_icon I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivProduct Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/home/R$id;->tv_dot1 I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvSourceDivider Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/home/R$id;->tv_location I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvLocation Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/home/R$id;->tv_time I
    invoke-virtual v6, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvTime Landroid/widget/TextView;
    invoke-virtual v2, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v6
    instance-of v1, v6, Landroid/view/ViewGroup$MarginLayoutParams;
    if-eqz v1, +005h
    check-cast v6, Landroid/view/ViewGroup$MarginLayoutParams;
    goto +2h
    const/4 v6, 0
    if-eqz v6, +007h
    invoke-virtual v6, Landroid/view/ViewGroup$MarginLayoutParams;->getMarginStart()I
    move-result v6
    goto +2h
    const/4 v6, 0
    iput v6, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvLocationDefaultMarginStart I
    const v6, 1055286886
    iput v6, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->dampingFactor F
    new-instance v6, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v6, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressHandler Landroid/os/Handler;
    new-instance v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda8;
    invoke-direct v6, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    invoke-virtual v0, v6, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    new-instance v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9;
    invoke-direct v6, v4, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter;)V
    invoke-virtual v0, v6, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->handleTouch(Landroid/view/MotionEvent;)V
    const/4 v0, 1
    return v0
.end method

.method private static final _init_$lambda$2(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)boolean
    .registers 7
    # ins_size=3
    iget-object v6, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    const/4 v0, 0
    if-eqz v6, +035h
    const/4 v1, 2
    new-array v1, v1, [I
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v2, v1, Landroid/view/View;->getLocationOnScreen([I)V
    invoke-static v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOnLongPress$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lkotlin/jvm/functions/Function3;
    move-result-object v5
    aget v0, v1, v0
    int-to-float v0, v0
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getWidth()I
    move-result v2
    int-to-float v2, v2
    const/high16 v3, 1073741824
    div-float/2addr v2, v3
    add-float/2addr v0, v2
    invoke-static v0, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v0
    const/4 v2, 1
    aget v1, v1, v2
    int-to-float v1, v1
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v4, Landroid/view/View;->getHeight()I
    move-result v4
    int-to-float v4, v4
    div-float/2addr v4, v3
    add-float/2addr v1, v4
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v4
    invoke-interface v5, v6, v0, v4, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move v0, v2
    return v0
.end method

.method public static final synthetic access$applyNormalContentBackground(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->applyNormalContentBackground()V
    return-void 
.end method

.method private static final animateClose$lambda$26$lambda$25(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
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

.method private final animateOpen()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getTranslationX()F
    move-result v0
    invoke-direct v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->getSwipeThreshold()F
    move-result v1
    neg-float v1, v1
    const/4 v2, 2
    new-array v2, v2, [F
    const/4 v3, 0
    aput v0, v2, v3
    const/4 v0, 1
    aput v1, v2, v0
    invoke-static v2, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v1
    const-wide/16 v2, 200
    invoke-virtual v1, v2, v3, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda6;
    invoke-direct v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    invoke-virtual v1, v2, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v1, Landroid/animation/ValueAnimator;->start()V
    iput-boolean v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isOpen Z
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$setOpenViewHolder$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter; Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    if-eqz v0, +00bh
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOnSlideOpen$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v1
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final animateOpen$lambda$23$lambda$22(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  android.animation.ValueAnimator)void
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
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

.method private final applyCircleStyle(com.bytedance.trae.home.solo.task.TaskStatus)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getCircleBgColorRes()I
    move-result v1
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    new-instance v2, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v2, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    invoke-virtual v2, v1, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getDisplayState()Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    if-eq v1, v4, +058h
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/home/R$dimen;->trae_task_icon_circle_border_width I
    invoke-virtual v1, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getCircleBorderStyle()Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;->ordinal()I
    move-result v4
    aget v4, v5, v4
    if-eq v4, v3, +033h
    const/4 v3, 2
    if-eq v4, v3, +00ch
    const/4 v7, 3
    if-ne v4, v7, +003h
    goto +36h
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getCircleBorderColorRes()I
    move-result v7
    invoke-static v0, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v3, Lcom/bytedance/trae/home/R$dimen;->trae_task_icon_circle_dash_width I
    invoke-virtual v0, v3, Landroid/content/res/Resources;->getDimension(I)F
    move-result v0
    iget-object v3, v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$dimen;->trae_task_icon_circle_dash_gap I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimension(I)F
    move-result v3
    invoke-virtual v2, v1, v7, v0, v3, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I F F)V
    goto +ch
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getCircleBorderColorRes()I
    move-result v7
    invoke-static v0, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v2, v1, v7, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->flIconContainer Landroid/widget/FrameLayout;
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v7, v2, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-void 
.end method

.method private final applyNormalContentBackground()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +005h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_tertiary I
    goto +3h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/view/View;->setBackgroundColor(I)V
    return-void 
.end method

.method private static final bind$lambda$11(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    if-eqz v3, +00eh
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOnPinClick$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    invoke-interface v2, v3, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$11$lambda$10$lambda$9(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final bind$lambda$14(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    if-eqz v3, +00eh
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOnRenameClick$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    invoke-interface v2, v3, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$14$lambda$13$lambda$12(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final bind$lambda$17(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    if-eqz v3, +00eh
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOnDeleteClick$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    invoke-interface v2, v3, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$17$lambda$16$lambda$15(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final cancelLongPress()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressHandler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method private final getSwipeThreshold()float
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutSwipeActions Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getWidth()I
    move-result v0
    int-to-float v0, v0
    return v0
.end method

.method private final handleTouch(android.view.MotionEvent)void
    .registers 7
    # ins_size=2
    invoke-virtual v6, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v0
    const/4 v1, 0
    if-eqz v0, +111h
    const/4 v2, 3
    const/4 v3, 1
    if-eq v0, v3, +0a2h
    const/4 v4, 2
    if-eq v0, v4, +006h
    if-eq v0, v2, +09dh
    goto/16 +12ch
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v0
    iget v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->startX F
    sub-float/2addr v0, v1
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v6
    iget v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->startY F
    sub-float/2addr v6, v1
    iget-boolean v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isDragging Z
    if-nez v1, +061h
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v1
    const/high16 v2, 1092616192
    cmpl-float v1, v1, v2
    if-lez v1, +057h
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v1
    invoke-static v6, Ljava/lang/Math;->abs(F)F
    move-result v6
    const/high16 v2, 1069547520
    mul-float/2addr v6, v2
    cmpl-float v6, v1, v6
    if-lez v6, +048h
    iput-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isDragging Z
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    move-result-object v6
    if-eqz v6, +01fh
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    move-result-object v6
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +013h
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    move-result-object v6
    if-eqz v6, +005h
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    const/4 v1, 0
    invoke-static v6, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$setOpenViewHolder$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter; Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->cancelLongPress()V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v6, v1, Landroid/view/View;->setBackgroundColor(I)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v6, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v6
    if-eqz v6, +005h
    invoke-interface v6, v3, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    iget-boolean v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isDragging Z
    if-eqz v6, +0b7h
    iget-boolean v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isOpen Z
    const/4 v1, 0
    if-eqz v6, +008h
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->getSwipeThreshold()F
    move-result v6
    neg-float v6, v6
    goto +2h
    move v6, v1
    iget v2, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->dampingFactor F
    mul-float/2addr v0, v2
    add-float/2addr v6, v0
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->getSwipeThreshold()F
    move-result v0
    neg-float v0, v0
    invoke-static v1, v6, Ljava/lang/Math;->min(F F)F
    move-result v6
    invoke-static v0, v6, Ljava/lang/Math;->max(F F)F
    move-result v6
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, v6, Landroid/view/View;->setTranslationX(F)V
    goto/16 +093h
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->cancelLongPress()V
    iget-boolean v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isDragging Z
    if-eqz v0, +031h
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->getSwipeThreshold()F
    move-result v6
    int-to-float v0, v2
    div-float/2addr v6, v0
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getTranslationX()F
    move-result v0
    iget-boolean v2, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isOpen Z
    if-eqz v2, +014h
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->getSwipeThreshold()F
    move-result v2
    neg-float v2, v2
    add-float/2addr v2, v6
    cmpl-float v6, v0, v2
    if-lez v6, +006h
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    goto +39h
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateOpen()V
    goto +35h
    neg-float v6, v6
    cmpg-float v6, v0, v6
    if-gez v6, +006h
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateOpen()V
    goto +2ch
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    goto +28h
    invoke-virtual v6, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v6
    if-ne v6, v3, +023h
    iget-boolean v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressTriggered Z
    if-nez v6, +01fh
    iget-boolean v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isOpen Z
    if-eqz v6, +006h
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    goto +16h
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    if-eqz v6, +013h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOnItemClick$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->getBindingAdapterPosition()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v6, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iput-boolean v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isDragging Z
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v6, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v6
    if-eqz v6, +02ch
    invoke-interface v6, v1, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    goto +27h
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v0
    iput v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->startX F
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v0
    iput v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->startY F
    iput-boolean v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isDragging Z
    iput-boolean v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressTriggered Z
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v0
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v6
    invoke-direct v5, v0, v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->scheduleLongPress(F F)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v6, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v6
    if-eqz v6, +005h
    invoke-interface v6, v1, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    return-void 
.end method

.method private final highlightQuery(java.lang.String  java.lang.String  java.util.List)java.lang.CharSequence
    .registers 8
    # ins_size=4
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +053h
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +48h
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;
    invoke-virtual v0, v5, v6, v7, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->format(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v5
    new-instance v0, Landroid/text/SpannableString;
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    invoke-direct v0, v1, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_brand I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;
    invoke-virtual v2, v5, v6, v7, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->highlightRanges(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;
    new-instance v7, Landroid/text/style/ForegroundColorSpan;
    invoke-direct v7, v1, Landroid/text/style/ForegroundColorSpan;-><init>(I)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;->getStart()I
    move-result v2
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;->getEnd()I
    move-result v6
    const/16 v3, 33
    invoke-virtual v0, v7, v2, v6, v3, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    goto -1eh
    check-cast v0, Ljava/lang/CharSequence;
    return-object v0
.end method

.method private final resetSwipe()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setTranslationX(F)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->applyNormalContentBackground()V
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isOpen Z
    return-void 
.end method

.method private final scheduleLongPress(float  float)void
    .registers 7
    # ins_size=3
    invoke-direct v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->cancelLongPress()V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;
    invoke-direct v1, v4, v0, v5, v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; F F)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressHandler Landroid/os/Handler;
    invoke-static Landroid/view/ViewConfiguration;->getLongPressTimeout()I
    move-result v6
    int-to-long v2, v6
    invoke-virtual v5, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    iput-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method private static final scheduleLongPress$lambda$19(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  float  float)void
    .registers 6
    # ins_size=4
    iget-boolean v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isDragging Z
    if-nez v0, +024h
    iget-boolean v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isOpen Z
    if-eqz v0, +003h
    goto +1eh
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    if-nez v0, +003h
    return-void 
    const/4 v1, 1
    iput-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->longPressTriggered Z
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v2, v1, Landroid/view/View;->performHapticFeedback(I)Z
    invoke-static v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOnLongPress$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lkotlin/jvm/functions/Function3;
    move-result-object v2
    invoke-static v4, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v3
    invoke-static v5, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v4
    invoke-interface v2, v0, v3, v4, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final animateClose()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getTranslationX()F
    move-result v0
    const/4 v1, 2
    new-array v1, v1, [F
    const/4 v2, 0
    aput v0, v1, v2
    const/4 v0, 1
    const/4 v3, 0
    aput v3, v1, v0
    invoke-static v1, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    const-wide/16 v3, 200
    invoke-virtual v0, v3, v4, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda10;
    invoke-direct v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$animateClose$1$2;
    invoke-direct v1, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$animateClose$1$2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    check-cast v1, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-boolean v2, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->isOpen Z
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter;)Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    move-result-object v0
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +008h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->access$setOpenViewHolder$p(Lcom/bytedance/trae/home/solo/task/TaskAdapter; Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.home.solo.task.TaskModel)void
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    const-string/jumbo v2, task
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->currentTask Lcom/bytedance/trae/home/solo/task/TaskModel;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvTitle Landroid/widget/TextView;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchQuery()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchHighlightKeywords()Ljava/util/List;
    move-result-object v5
    invoke-direct v0, v3, v4, v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->highlightQuery(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchSnippet()Ljava/lang/String;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    const/4 v4, 1
    xor-int/2addr v3, v4
    const/4 v5, 0
    if-eqz v3, +003h
    goto +2h
    move-object v2, v5
    const/4 v3, 0
    if-nez v2, +057h
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    const/4 v6, 2
    new-array v6, v6, [Ljava/lang/String;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTag()Ljava/lang/String;
    move-result-object v7
    aput-object v7, v6, v3
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getLocation()Ljava/lang/String;
    move-result-object v7
    aput-object v7, v6, v4
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +016h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Ljava/lang/String;
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    xor-int/2addr v9, v4
    if-eqz v9, -014h
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v7, Ljava/util/List;
    move-object v8, v7
    check-cast v8, Ljava/lang/Iterable;
    const-string v4, " · "
    move-object v9, v4
    check-cast v9, Ljava/lang/CharSequence;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 62
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    if-eqz v2, +007h
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchQuery()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v5
    if-nez v2, +004h
    const-string v2, ""
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvLocation Landroid/widget/TextView;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchHighlightKeywords()Ljava/util/List;
    move-result-object v7
    invoke-direct v0, v4, v2, v7, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->highlightQuery(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v6, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvTime Landroid/widget/TextView;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTime()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v2, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchQuery()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivSourceIcon Landroid/widget/ImageView;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal()Z
    move-result v6
    if-nez v6, +005h
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_cloud_1 I
    goto +ch
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline()Z
    move-result v6
    if-eqz v6, +005h
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_computer I
    goto +3h
    sget v6, Lcom/bytedance/trae/home/R$drawable;->ic_solo_computer_offline I
    invoke-virtual v4, v6, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->getShowProductType()Z
    move-result v4
    const/16 v6, 8
    if-eqz v4, +03eh
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;
    move-result-object v4
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +00fh
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivProduct Landroid/widget/ImageView;
    invoke-virtual v4, v3, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivProduct Landroid/widget/ImageView;
    sget v7, Lcom/bytedance/trae/home/R$drawable;->ic_task_product_ide I
    invoke-virtual v4, v7, Landroid/widget/ImageView;->setImageResource(I)V
    goto +25h
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +00fh
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivProduct Landroid/widget/ImageView;
    invoke-virtual v4, v3, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivProduct Landroid/widget/ImageView;
    sget v7, Lcom/bytedance/trae/home/R$drawable;->ic_task_product_local I
    invoke-virtual v4, v7, Landroid/widget/ImageView;->setImageResource(I)V
    goto +ch
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivProduct Landroid/widget/ImageView;
    invoke-virtual v4, v6, Landroid/widget/ImageView;->setVisibility(I)V
    goto +6h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivProduct Landroid/widget/ImageView;
    invoke-virtual v4, v6, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivSourceIcon Landroid/widget/ImageView;
    if-eqz v2, +004h
    move v7, v3
    goto +2h
    move v7, v6
    invoke-virtual v4, v7, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvSourceDivider Landroid/widget/TextView;
    if-eqz v2, +004h
    move v7, v3
    goto +2h
    move v7, v6
    invoke-virtual v4, v7, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvLocation Landroid/widget/TextView;
    invoke-virtual v4, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v4
    instance-of v7, v4, Landroid/view/ViewGroup$MarginLayoutParams;
    if-eqz v7, +005h
    check-cast v4, Landroid/view/ViewGroup$MarginLayoutParams;
    goto +2h
    move-object v4, v5
    if-eqz v4, +012h
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvLocationDefaultMarginStart I
    goto +2h
    move v2, v3
    invoke-virtual v4, v2, Landroid/view/ViewGroup$MarginLayoutParams;->setMarginStart(I)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvLocation Landroid/widget/TextView;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v4, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_tertiary I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivSourceIcon Landroid/widget/ImageView;
    invoke-static v2, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v2
    invoke-static v4, v2, Landroidx/core/widget/ImageViewCompat;->setImageTintList(Landroid/widget/ImageView; Landroid/content/res/ColorStateList;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivEmojiIcon Landroid/widget/ImageView;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getIconType()Lcom/bytedance/trae/home/solo/task/TaskIconType;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskIconType;->getIconRes()I
    move-result v4
    invoke-virtual v2, v4, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_onbrand I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivEmojiIcon Landroid/widget/ImageView;
    invoke-static v2, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v2
    invoke-static v4, v2, Landroidx/core/widget/ImageViewCompat;->setImageTintList(Landroid/widget/ImageView; Landroid/content/res/ColorStateList;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v2
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->applyCircleStyle(Lcom/bytedance/trae/home/solo/task/TaskStatus;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->vBadge Landroid/view/View;
    invoke-virtual v2, v6, Landroid/view/View;->setVisibility(I)V
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getDisplayState()Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    if-ne v2, v4, +008h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->pbLoading Landroid/widget/ProgressBar;
    invoke-virtual v2, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    goto +6h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->pbLoading Landroid/widget/ProgressBar;
    invoke-virtual v2, v6, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-direct/range v17, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->resetSwipe()V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnPin Landroid/view/View;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSupportsPin()Z
    move-result v4
    if-eqz v4, +00dh
    sget-object v4, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v7, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v4, v7, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v4
    if-eqz v4, +003h
    move v6, v3
    invoke-virtual v2, v6, Landroid/view/View;->setVisibility(I)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnRename Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    instance-of v4, v2, Landroid/view/ViewGroup$MarginLayoutParams;
    if-eqz v4, +005h
    move-object v5, v2
    check-cast v5, Landroid/view/ViewGroup$MarginLayoutParams;
    if-eqz v5, +028h
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSupportsPin()Z
    move-result v2
    if-eqz v2, +018h
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v4, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v2, v4, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v2
    if-eqz v2, +00eh
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$dimen;->trae_task_swipe_action_gap I
    invoke-virtual v2, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-virtual v5, v3, Landroid/view/ViewGroup$MarginLayoutParams;->setMarginStart(I)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnRename Landroid/view/View;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v5, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->tvPin Landroid/widget/TextView;
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->itemView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v4
    if-eqz v4, +005h
    sget v4, Lcom/bytedance/trae/home/R$string;->solo_context_menu_unpin I
    goto +3h
    sget v4, Lcom/bytedance/trae/home/R$string;->solo_context_menu_pin I
    invoke-virtual v3, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->ivPin Landroid/widget/ImageView;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v1
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/home/R$drawable;->ic_solo_unpin I
    goto +3h
    sget v1, Lcom/bytedance/trae/home/R$drawable;->ic_solo_pin_1 I
    invoke-virtual v2, v1, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnPin Landroid/view/View;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda3;
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter;)V
    invoke-virtual v1, v3, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnRename Landroid/view/View;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda4;
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter;)V
    invoke-virtual v1, v3, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->btnDelete Landroid/view/View;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda5;
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter;)V
    invoke-virtual v1, v3, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
