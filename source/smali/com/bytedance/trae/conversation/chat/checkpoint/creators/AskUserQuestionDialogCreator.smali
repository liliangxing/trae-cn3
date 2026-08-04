# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/AskUserQuestionDialogCreator;
.super Ljava/lang/Object;
.source "AskUserQuestionDialogCreator.kt"

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
    .registers 7
    # ins_size=4
    const-string v6, "context"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, toolCallInfo
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/AskUserQuestionDialogCreator;->getCHECK_POINT_TAG()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[AskUserQuestionDialogCreator] createContentView: toolCallInfo="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v6, v0, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v4, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v4, 1
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -1
    const/4 v0, -2
    invoke-direct v4, v6, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v5, Landroid/view/View;
    return-object v5
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
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_submit I
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
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +01ah
    const-string v0, "question"
    invoke-virtual v3, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +012h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +00dh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_ask_user_default_title I
    invoke-virtual v2, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v2, "getString(...)"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
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
