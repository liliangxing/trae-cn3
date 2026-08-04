# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputAttachmentListModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $$this$launch:Lkotlinx/coroutines/CoroutineScope;
.field final synthetic $file:Ljava/io/File;
.field final synthetic $item:Lcom/bytedance/trae/conversation/widget/AttachmentItem;
.field final synthetic $itemUri:Landroid/net/Uri;
.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;


.method public static synthetic $r8$lambda$Gl5yymDH28ecM_x9k-gMKwT1Hyc(kotlin.jvm.functions.Function1  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->invokeSuspend$lambda$1$lambda$0(Lkotlin/jvm/functions/Function1; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sZChMJM3TxZ_dWxXfP5POX0Uhik(com.bytedance.trae.conversation.fileupload.UploadResult  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->invokeSuspend$lambda$3$lambda$2(Lcom/bytedance/trae/conversation/fileupload/UploadResult; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wsyt33UWuur-T1uiqD15BTshm74(java.lang.String  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->invokeSuspend$lambda$5$lambda$4(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(kotlinx.coroutines.CoroutineScope  java.io.File  com.bytedance.trae.conversation.widget.InputAttachmentListModel  com.bytedance.trae.conversation.widget.AttachmentItem  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$file Ljava/io/File;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$itemUri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
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

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$$this$launch Lkotlinx/coroutines/CoroutineScope;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$file Ljava/io/File;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$itemUri Landroid/net/Uri;
    move-object v0, v7
    move-object v6, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;-><init>(Lkotlinx/coroutines/CoroutineScope; Ljava/io/File; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    iput-object v9, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlin/jvm/functions/Function1;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->invoke(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ah
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/functions/Function1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$file Ljava/io/File;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda0;
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V
    iput v2, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->label I
    invoke-static v1, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$uploadImageFile(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Ljava/io/File; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$file Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->delete()Z
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$itemUri Landroid/net/Uri;
    invoke-static v7, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v3
    if-nez v3, +024h
    check-cast v7, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    sget-object v3, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->getOid()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v0, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v5, toString(...)
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda1;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/fileupload/UploadResult;)V
    invoke-static v1, v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    goto +11h
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +004h
    const-string v7, "Upload failed"
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda2;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String;)V
    invoke-static v1, v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0xb
    :try_start_0x24
.end method
