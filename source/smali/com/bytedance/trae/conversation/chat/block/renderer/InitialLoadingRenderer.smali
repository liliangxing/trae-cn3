# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer;
.super Ljava/lang/Object;
.source "InitialLoadingRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$InitialLoading)android.view.View
    .registers 16
    # ins_size=3
    const-string v0, "context"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v15, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "AgentBlock"
    const-string v1, "[InitialLoadingRenderer] render"
    invoke-virtual v15, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v15
    invoke-virtual v15, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v15
    iget v15, v15, Landroid/util/DisplayMetrics;->density F
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const v2, 8388627
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v3, 20
    int-to-float v3, v3
    mul-float/2addr v3, v15
    float-to-int v3, v3
    const/4 v4, -1
    invoke-direct v2, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v2, 8
    int-to-float v2, v2
    mul-float/2addr v2, v15
    float-to-int v2, v2
    const/4 v3, 6
    int-to-float v3, v3
    mul-float/2addr v3, v15
    float-to-int v3, v3
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v14, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/List;
    move v7, v1
    const/4 v8, 3
    if-ge v7, v8, +064h
    new-instance v8, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v8, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const/4 v9, 1
    invoke-virtual v8, v9, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    invoke-virtual v8, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    new-instance v10, Landroid/view/View;
    invoke-direct v10, v14, Landroid/view/View;-><init>(Landroid/content/Context;)V
    check-cast v8, Landroid/graphics/drawable/Drawable;
    invoke-virtual v10, v8, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v11, 2
    if-lez v7, +006h
    invoke-virtual v8, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    goto +9h
    if-nez v7, +008h
    int-to-float v12, v11
    mul-float/2addr v12, v15
    float-to-int v12, v12
    invoke-virtual v8, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v10, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-array v8, v9, [Landroid/animation/PropertyValuesHolder;
    sget-object v9, Landroid/view/View;->ALPHA Landroid/util/Property;
    new-array v12, v11, [F
    fill-array-data v12, +000003bh
    invoke-static v9, v12, Landroid/animation/PropertyValuesHolder;->ofFloat(Landroid/util/Property; [F)Landroid/animation/PropertyValuesHolder;
    move-result-object v9
    aput-object v9, v8, v1
    invoke-static v10, v8, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object; [Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;
    move-result-object v8
    const-wide/16 v9, 400
    invoke-virtual v8, v9, v10, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    invoke-virtual v8, v11, Landroid/animation/ObjectAnimator;->setRepeatMode(I)V
    invoke-virtual v8, v4, Landroid/animation/ObjectAnimator;->setRepeatCount(I)V
    int-to-long v9, v7
    const-wide/16 v11, 150
    mul-long/2addr v9, v11
    invoke-virtual v8, v9, v10, Landroid/animation/ObjectAnimator;->setStartDelay(J)V
    const-string v9, "apply(...)"
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v6, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v8, Landroid/animation/ObjectAnimator;->start()V
    add-int/lit8 v7, v7, 1
    goto -64h
    new-instance v14, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$render$1;
    invoke-direct v14, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$render$1;-><init>(Ljava/util/List;)V
    check-cast v14, Landroid/view/View$OnAttachStateChangeListener;
    invoke-virtual v0, v14, Landroid/widget/LinearLayout;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
    check-cast v0, Landroid/view/View;
    return-object v0
    nop 
    fill-array-data-payload b'\x00\x00\x80?\x9a\x99\x99>' | \x00\x00\x80\x3f\x9a\x99\x99\x3e
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$InitialLoading)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;)V
    return-void 
.end method
