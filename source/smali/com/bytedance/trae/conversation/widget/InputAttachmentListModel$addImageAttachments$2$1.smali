# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputAttachmentListModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $attachment:Lcom/bytedance/trae/conversation/widget/AttachmentItem;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;


.method public static synthetic $r8$lambda$zXIeLZR-_ICSeHhiCqOEecr_vSM(com.bytedance.trae.conversation.widget.InputAttachmentListModel  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.widget.InputAttachmentListModel  com.bytedance.trae.conversation.widget.AttachmentItem  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->$attachment Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.conversation.widget.InputAttachmentListModel  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 19
    # ins_size=2
    move-object/from16 v0, v18
    const-wide/16 v1, 0
    const-wide/16 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Error Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v12, 0
    const/4 v13, 0
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getApplication()Landroid/app/Application;
    move-result-object v14
    sget v15, Lcom/bytedance/trae/multilanguage/R$string;->trae_file_invalid_format I
    invoke-virtual v14, v15, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v14
    const/16 v15, 895
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->$attachment Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +76h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->L$0 Ljava/lang/Object;
    move-object v4, v12
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->$attachment Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v1
    iget-object v3, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->$attachment Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v3
    invoke-static v12, v1, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$uriToFile(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Ljava/lang/String;)Ljava/io/File;
    move-result-object v5
    if-nez v5, +017h
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->$attachment Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v0
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)V
    invoke-static v12, v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->$attachment Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v12
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getTAG()Ljava/lang/String;
    move-result-object v3
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "addImageAttachments:"
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    new-instance v10, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1$2;
    iget-object v6, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v7, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->$attachment Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    const/4 v9, 0
    move-object v3, v10
    move-object v8, v12
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1$2;-><init>(Lkotlinx/coroutines/CoroutineScope; Ljava/io/File; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    move-object v3, v11
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImageAttachments$2$1;->label I
    invoke-static v1, v12, v10, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$uploadWithFakeProgress(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
.end method
