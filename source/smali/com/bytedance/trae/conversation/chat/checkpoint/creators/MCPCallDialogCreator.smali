# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/MCPCallDialogCreator;
.super Ljava/lang/Object;
.source "MCPCallDialogCreator.kt"

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
    .registers 15
    # ins_size=4
    const-string v14, "context"
    invoke-static v12, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v14, toolCallInfo
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/MCPCallDialogCreator;->getCHECK_POINT_TAG()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[MCPCallDialogCreator] createContentView: toolCallInfo="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v14, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v12, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v14
    invoke-virtual v14, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v14
    iget v14, v14, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v13
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_mcp_unknown I
    invoke-virtual v12, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    if-eqz v13, +01bh
    const-string/jumbo v2, server_name
    invoke-virtual v13, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +012h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v1
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v0
    if-eqz v13, +01bh
    const-string/jumbo v3, tool_name
    invoke-virtual v13, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +012h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v1
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +01fh
    if-eqz v13, +019h
    const-string v3, "name"
    invoke-virtual v13, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v1
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v1
    if-nez v3, +003h
    goto +2h
    move-object v0, v3
    if-eqz v13, +018h
    const-string v3, "args"
    invoke-virtual v13, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v13
    if-eqz v13, +010h
    invoke-virtual v13, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v13, v1
    if-eqz v13, +006h
    invoke-virtual v13, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v1
    new-instance v13, Landroid/widget/LinearLayout;
    invoke-direct v13, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 1
    invoke-virtual v13, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v6, -2
    invoke-direct v4, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct v4, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v7, 0
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v7, 16
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->setGravity(I)V
    int-to-float v7, v7
    mul-float/2addr v7, v14
    float-to-int v7, v7
    new-instance v8, Landroid/widget/ImageView;
    invoke-direct v8, v12, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->ic_mcp_tool I
    invoke-virtual v8, v9, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v7, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v10, 8
    int-to-float v10, v10
    mul-float/2addr v10, v14
    float-to-int v10, v10
    invoke-virtual v9, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v9, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v8, Landroid/view/View;
    invoke-virtual v4, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v8, " / "
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v12, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v0, 2
    const/high16 v8, 1097859072
    invoke-virtual v2, v0, v8, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v9, 20
    int-to-float v9, v9
    mul-float/2addr v9, v14
    float-to-int v9, v9
    invoke-static v2, v9, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    check-cast v2, Landroid/view/View;
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v10, v6, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v2, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v4, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    if-eqz v1, +08ah
    invoke-virtual v1, Lcom/google/gson/JsonObject;->size()I
    move-result v2
    if-lez v2, +084h
    new-instance v2, Lcom/google/gson/GsonBuilder;
    invoke-direct v2, Lcom/google/gson/GsonBuilder;-><init>()V
    invoke-virtual v2, Lcom/google/gson/GsonBuilder;->setPrettyPrinting()Lcom/google/gson/GsonBuilder;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v2
    move-object v4, v1
    check-cast v4, Lcom/google/gson/JsonElement;
    invoke-virtual v2, v4, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v1
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Landroidx/core/widget/NestedScrollView;
    invoke-direct v2, v12, Landroidx/core/widget/NestedScrollView;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v3, Landroidx/core/widget/NestedScrollView;->setVerticalScrollBarEnabled(Z)V
    const/16 v3, 12
    int-to-float v3, v3
    mul-float/2addr v3, v14
    float-to-int v3, v3
    invoke-virtual v2, v3, v3, v3, v3, Landroidx/core/widget/NestedScrollView;->setPadding(I I I I)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v12, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v4, 10
    int-to-float v4, v4
    mul-float/2addr v4, v14
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v3, Landroidx/core/widget/NestedScrollView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v3, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v12, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v12
    invoke-virtual v3, v12, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v3, v0, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-static v3, v9, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    sget-object v12, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v3, v12, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    check-cast v3, Landroid/view/View;
    new-instance v12, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v12, v5, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, v12, Landroidx/core/widget/NestedScrollView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v12, 300
    int-to-float v12, v12
    mul-float/2addr v12, v14
    float-to-int v12, v12
    check-cast v2, Landroid/view/View;
    new-instance v14, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v14, v5, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v7, v14, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v2, v14, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v13, Landroid/view/View;
    return-object v13
    :try_start_0x149
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
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_run I
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
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_deny I
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
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_mcp_call_title I
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
