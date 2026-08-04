# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputAttachmentListModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $$this$launch:Lkotlinx/coroutines/CoroutineScope;
.field final synthetic $file:Ljava/io/File;
.field final synthetic $item:Lcom/bytedance/trae/conversation/widget/AttachmentItem;
.field final synthetic $itemUri:Landroid/net/Uri;
.field final synthetic $useImageUpload:Z
.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;


.method public static synthetic $r8$lambda$7EeuEF0v4n1U2emrX24U7vZx6b8(com.bytedance.trae.conversation.fileupload.UploadResult  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invokeSuspend$lambda$3$lambda$2(Lcom/bytedance/trae/conversation/fileupload/UploadResult; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$MGughME2XICEyfLBn8JBQPfeXDI(kotlin.jvm.functions.Function1  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invokeSuspend$lambda$1$lambda$0(Lkotlin/jvm/functions/Function1; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$TJdM9ATtGNBxZEIrZoUp391Kn2w(com.bytedance.trae.conversation.fileupload.UploadResult  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invokeSuspend$lambda$9(Lcom/bytedance/trae/conversation/fileupload/UploadResult; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Y7AFiTzMQ99203P8ScgyLw_e9Jw(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invokeSuspend$lambda$7$lambda$6(Lkotlin/jvm/functions/Function1; I J J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$_J9ia98q6moPR1jye7n-p9anhW4(java.lang.String  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invokeSuspend$lambda$10(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ptmwKOkCAvPOiasRGYny3JS4UaY(java.lang.String  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invokeSuspend$lambda$5$lambda$4(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(boolean  kotlinx.coroutines.CoroutineScope  java.io.File  com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$useImageUpload Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$file Ljava/io/File;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$itemUri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$1$lambda$0(kotlin.jvm.functions.Function1  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final invokeSuspend$lambda$10(java.lang.String  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 19
    # ins_size=2
    move-object/from16 v14, v17
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
    const/16 v15, 895
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$3$lambda$2(com.bytedance.trae.conversation.fileupload.UploadResult  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
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
    sget-object v11, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Success Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/16 v12, 100
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/16 v15, 1151
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$5$lambda$4(java.lang.String  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 19
    # ins_size=2
    move-object/from16 v14, v17
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
    const/16 v15, 895
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$7$lambda$6(kotlin.jvm.functions.Function1  int  long  long)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final invokeSuspend$lambda$9(com.bytedance.trae.conversation.fileupload.UploadResult  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
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
    sget-object v11, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Success Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/16 v12, 100
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/16 v15, 1151
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 12
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;
    iget-boolean v1, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$useImageUpload Z
    iget-object v2, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$file Ljava/io/File;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$itemUri Landroid/net/Uri;
    move-object v0, v8
    move-object v7, v11
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;-><init>(Z Lkotlinx/coroutines/CoroutineScope; Ljava/io/File; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    iput-object v10, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->L$0 Ljava/lang/Object;
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlin/jvm/functions/Function1;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invoke(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 24
    # ins_size=2
    move-object/from16 v11, v22
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->label I
    const-string/jumbo v12, toString(...)
    const/4 v2, 2
    const-string v13, "Upload failed"
    const/4 v14, 1
    if-eqz v1, +020h
    if-eq v1, v14, +016h
    if-ne v1, v2, +00ch
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v1, v23
    goto/16 +103h
    move-exception v0
    goto/16 +107h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v1, v23
    goto +28h
    move-exception v0
    goto +2dh
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlin/jvm/functions/Function1;
    iget-boolean v3, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$useImageUpload Z
    if-eqz v3, +077h
    iget-object v2, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$file Ljava/io/File;
    iget-object v4, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda0;
    invoke-direct v5, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V
    iput v14, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->label I
    invoke-static v2, v3, v4, v5, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$uploadImageFile(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Ljava/io/File; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    check-cast v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +bh
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$file Ljava/io/File;
    invoke-virtual v1, Ljava/io/File;->delete()Z
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$itemUri Landroid/net/Uri;
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v4
    if-nez v4, +022h
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    sget-object v4, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v5, v1, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/fileupload/UploadResult;)V
    invoke-static v2, v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    goto/16 +112h
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v13, v0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda2;
    invoke-direct v0, v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String;)V
    invoke-static v2, v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$get_uploadError$p(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, v13, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    goto/16 +0f9h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ".trae"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    iget-object v4, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$file Ljava/io/File;
    iget-object v6, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$getFileUploadService(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    move-result-object v4
    const/4 v7, 0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v6
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v8
    const-class v9, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v8, v9, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v8, +00dh
    invoke-interface v8, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    const/16 v16, 1
    const/16 v17, 1
    new-instance v10, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda3;
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function1;)V
    const/16 v19, 0
    const/16 v20, 8
    const/16 v21, 0
    move-object v15, v9
    move-object/from16 v18, v10
    invoke-direct/range v15 ... v21, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;-><init>(Z Z Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v10, 4
    const/4 v15, 0
    iput v2, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->label I
    move-object v1, v4
    move-object v2, v5
    move-object v4, v7
    move-object v5, v6
    move-object v6, v8
    move-object v7, v9
    move-object/from16 v8, v22
    move v9, v10
    move-object v10, v15
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->uploadSingleFile$default(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    check-cast v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +bh
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-nez v1, +003h
    goto +18h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    const-string v3, ""
    const/4 v4, 0
    invoke-virtual v1, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v5, v13
    goto +2h
    move-object v5, v1
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 24
    const/4 v9, 0
    move-object v2, v0
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$file Ljava/io/File;
    invoke-virtual v1, Ljava/io/File;->delete()Z
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getSuccess()Z
    move-result v1
    if-eqz v1, +032h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v14
    if-eqz v1, +025h
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v2
    iget-object v3, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v3, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$itemUri Landroid/net/Uri;
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda4;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/fileupload/UploadResult;)V
    invoke-static v1, v2, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    goto +1eh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getError()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v13, v0
    iget-object v0, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$itemUri Landroid/net/Uri;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda5;
    invoke-direct v2, v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda5;-><init>(Ljava/lang/String;)V
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$get_uploadError$p(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, v13, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x15
    :try_start_0x27
    :try_start_0x40
    :try_start_0xcc
.end method
