# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;
.super Ljava/lang/Object;
.source "ICheckpointDialogCreator.kt"


.method public static bindActions(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    const-string v0, "contentView"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onConfirm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onSkip"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static bindActions(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=5
    const-string v0, "contentView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onConfirm"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onSkip"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onConfirmWithParams"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->bindActions(Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static synthetic createContentView$default(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo  int  java.lang.Object)android.view.View
    .registers 6
    # ins_size=6
    if-nez v5, +00ch
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->createContentView(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)Landroid/view/View;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: createContentView"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static getCHECK_POINT_TAG(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)java.lang.String
    .registers 1
    # ins_size=1
    const-string v0, "CheckPointDialog"
    return-object v0
.end method

.method public static getContentTopMarginDp(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)int
    .registers 1
    # ins_size=1
    const/16 v0, 16
    return v0
.end method

.method public static getContentTopMarginRes(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)int
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public static getHeaderLabel(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  android.content.Context)java.lang.String
    .registers 2
    # ins_size=2
    const-string v0, "context"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    return-object v0
.end method

.method public static getPrimaryButtonBackgroundRes(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)int
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public static getTitleLetterSpacing(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)float
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public static getTitleTextColorRes(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)int
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public static hideDefaultButtons(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)boolean
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public static setFileClickListener(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public static setResolvedDisplayName(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  java.lang.String)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public static showCloseButton(com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)boolean
    .registers 1
    # ins_size=1
    const/4 v0, 0
    return v0
.end method
