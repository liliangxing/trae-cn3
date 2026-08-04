# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/CommandTimeoutDialogCreator;
.super Ljava/lang/Object;
.source "CommandTimeoutDialogCreator.kt"

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
    .registers 14
    # ins_size=4
    const-string v13, "context"
    invoke-static v11, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v13, toolCallInfo
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/CommandTimeoutDialogCreator;->getCHECK_POINT_TAG()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[CommandTimeoutDialogCreator] createContentView: toolCallInfo="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v13, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v11, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    invoke-virtual v13, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v13
    iget v13, v13, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v12
    if-eqz v12, +01ah
    const-string v0, "command"
    invoke-virtual v12, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v12
    if-eqz v12, +012h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v12, 0
    if-eqz v12, +008h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v12
    if-nez v12, +004h
    const-string v12, ""
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v5, 0
    invoke-virtual v2, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v6, 16
    invoke-virtual v2, v6, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v7, Landroid/widget/ImageView;
    invoke-direct v7, v11, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->info_filled I
    invoke-virtual v7, v8, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v9, 20
    int-to-float v9, v9
    mul-float/2addr v9, v13
    float-to-int v9, v9
    invoke-direct v8, v9, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v9, 4
    int-to-float v9, v9
    mul-float/2addr v9, v13
    float-to-int v9, v9
    invoke-virtual v8, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v8, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v7, Landroid/view/View;
    invoke-virtual v2, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v7, Landroid/widget/TextView;
    invoke-direct v7, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_timeout_title I
    invoke-virtual v11, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v7, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v11, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v7, v8, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v8, 1099431936
    const/4 v9, 2
    invoke-virtual v7, v9, v8, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v8, 5
    invoke-virtual v7, v8, Landroid/widget/TextView;->setTextAlignment(I)V
    invoke-virtual v7, Landroid/widget/TextView;->getTypeface()Landroid/graphics/Typeface;
    move-result-object v8
    invoke-virtual v7, v8, v1, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface; I)V
    check-cast v7, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v7, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v2, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_timeout_description I
    invoke-virtual v11, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v2, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v11, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v2, v7, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v7, 1097859072
    invoke-virtual v2, v9, v7, Landroid/widget/TextView;->setTextSize(I F)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v8, 12
    int-to-float v8, v8
    mul-float/2addr v8, v13
    float-to-int v8, v8
    iput v8, v7, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v7, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v12, Ljava/lang/CharSequence;
    invoke-interface v12, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    move v5, v1
    if-eqz v5, +05fh
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v1, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v1, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l2 I
    invoke-static v11, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v1, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v5, 10
    int-to-float v5, v5
    mul-float/2addr v5, v13
    invoke-virtual v1, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, v8, v8, v8, v8, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v12, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v12, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v1, v12, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v11, v12, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    invoke-virtual v1, v11, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v11, 1098907648
    invoke-virtual v1, v9, v11, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v1, Landroid/view/View;
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v1, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v12, v6
    mul-float/2addr v12, v13
    float-to-int v12, v12
    iput v12, v11, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v2, Landroid/view/View;
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
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
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_view_detail I
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
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_skip I
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
    const-string/jumbo v2, toolCallInfo
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, ""
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
