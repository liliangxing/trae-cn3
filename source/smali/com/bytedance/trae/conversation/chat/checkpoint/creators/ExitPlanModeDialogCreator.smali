# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/ExitPlanModeDialogCreator;
.super Ljava/lang/Object;
.source "ExitPlanModeDialogCreator.kt"

.implements Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public createContentView(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)android.view.View
    .registers 8
    # ins_size=4
    const-string v7, "context"
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v7, toolCallInfo
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->density F
    new-instance v7, Landroid/widget/LinearLayout;
    invoke-direct v7, v5, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 1
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v5, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_exit_plan_message I
    invoke-virtual v5, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v5, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v0, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v5, 2
    const/high16 v3, 1096810496
    invoke-virtual v0, v5, v3, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v5, 4
    int-to-float v5, v5
    mul-float/2addr v5, v6
    float-to-int v5, v5
    const/4 v6, 0
    invoke-virtual v0, v6, v5, v6, v5, Landroid/widget/TextView;->setPadding(I I I I)V
    check-cast v0, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v5, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v0, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v7, Landroid/view/View;
    return-object v7
.end method

.method public getCHECK_POINT_TAG()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getCHECK_POINT_TAG(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getContentTopMarginDp()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getContentTopMarginDp(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getContentTopMarginRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getContentTopMarginRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getHeaderLabel(android.content.Context)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getHeaderLabel(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/content/Context;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public getPrimaryButtonBackgroundRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getPrimaryButtonBackgroundRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getPrimaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_execute I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getSecondaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_cancel I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getTitle(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_exit_plan_title I
    invoke-virtual v2, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v3, "getString(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getTitleLetterSpacing()float
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getTitleLetterSpacing(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)F
    move-result v0
    return v0
.end method

.method public getTitleTextColorRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getTitleTextColorRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public hideDefaultButtons()boolean
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->hideDefaultButtons(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Z
    move-result v0
    return v0
.end method

.method public setFileClickListener(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->setFileClickListener(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public setResolvedDisplayName(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->setResolvedDisplayName(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Ljava/lang/String;)V
    return-void 
.end method

.method public showCloseButton()boolean
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->showCloseButton(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Z
    move-result v0
    return v0
.end method
