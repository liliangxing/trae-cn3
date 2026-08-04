# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $attachment:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
.field final synthetic $attachmentId:Ljava/lang/String;
.field final synthetic $sourceUri:Landroid/net/Uri;
.field final synthetic $uploadStartMs:J
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method public static synthetic $r8$lambda$EiDxNcnrsAv9kyYRuFJtOf4IZ28(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String  int)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invokeSuspend$lambda$2(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IZV82p8p6TLw7VtM_Pzuzw_4DoM(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invokeSuspend$lambda$3(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$MqdLOmCKP9TaUQ48-8wXuy_xeHM(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$i9qh-yF9pLo_LrLIeE5OQ6-gvFs(java.lang.Throwable  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invokeSuspend$lambda$5(Ljava/lang/Throwable; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$t7ESWVTpINP28t3naiR_D2p-Mxc(java.lang.String  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invokeSuspend$lambda$4(Ljava/lang/String; Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xqSaMVxE4gpt1vbsFK4b46y-NzE(int  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invokeSuspend$lambda$2$lambda$1(I Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  android.net.Uri  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  java.lang.String  long  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$sourceUri Landroid/net/Uri;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$uploadStartMs J
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 21
    # ins_size=2
    move-object/from16 v0, v20
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getApplication()Landroid/app/Application;
    move-result-object v12
    sget v13, Lcom/bytedance/trae/multilanguage/R$string;->trae_file_invalid_format I
    invoke-virtual v12, v13, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v12
    const/4 v13, 0
    const-wide/16 v14, 0
    const/16 v16, 0
    const/16 v17, 15231
    const/16 v18, 0
    invoke-static/range v0 ... v18, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$2(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String  int)kotlin.Unit
    .registers 9
    # ins_size=3
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda5;
    invoke-direct v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda5;-><init>(I)V
    const/4 v4, 2
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v7
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final invokeSuspend$lambda$2$lambda$1(int  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 23
    # ins_size=2
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-eq v0, v1, +005h
    move-object/from16 v0, v22
    goto +24h
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const-wide/16 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v0, 0
    const/16 v1, 99
    move/from16 v2, v21
    invoke-static v2, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v12
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const-wide/16 v16, 0
    const/16 v18, 0
    const/16 v19, 16127
    const/16 v20, 0
    move-object/from16 v2, v22
    invoke-static/range v2 ... v20, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$3(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 20
    # ins_size=1
    move-object/from16 v0, v19
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v10, 0
    const/4 v11, 0
    const-string v12, "Upload failed"
    const/4 v13, 0
    const-wide/16 v14, 0
    const/16 v16, 0
    const/16 v17, 15231
    const/16 v18, 0
    invoke-static/range v0 ... v18, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$4(java.lang.String  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 22
    # ins_size=3
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploaded Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/16 v10, 100
    const/4 v12, 0
    const/4 v13, 0
    if-eqz v20, +007h
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getCreatedAtMs()J
    move-result-wide v14
    goto +5h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v14
    const/16 v16, 0
    const/16 v17, 11391
    const/16 v18, 0
    move-object/from16 v0, v21
    move-object/from16 v11, v19
    invoke-static/range v0 ... v18, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$5(java.lang.Throwable  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 21
    # ins_size=2
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual/range v19, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "Upload failed"
    move-object v12, v0
    const/4 v13, 0
    const-wide/16 v14, 0
    const/16 v16, 0
    const/16 v17, 15231
    const/16 v18, 0
    move-object/from16 v0, v20
    invoke-static/range v0 ... v18, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$sourceUri Landroid/net/Uri;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$uploadStartMs J
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Landroid/net/Uri; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 30
    # ins_size=2
    move-object/from16 v1, v28
    const-string v2, "attachment upload failed: "
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->label I
    const-string v4, "discussion_attach_upload_failed"
    const/4 v5, 5
    const/4 v6, 4
    const/4 v7, 3
    const/4 v8, 2
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v0, +03ch
    if-eq v0, v9, +02ch
    if-eq v0, v8, +01eh
    if-eq v0, v7, +017h
    if-eq v0, v6, +015h
    if-eq v0, v5, +00ah
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/Throwable;
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1e8h
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +145h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    move-object v11, v0
    check-cast v11, Ljava/io/File;
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v29
    goto/16 +098h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    move-object v11, v0
    check-cast v11, Ljava/io/File;
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v29
    goto +67h
    move-exception v0
    goto/16 +137h
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getAttachmentManager$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    move-result-object v0
    iget-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$sourceUri Landroid/net/Uri;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getMimeType()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v11, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->uriToFile(Landroid/net/Uri; Ljava/lang/String;)Ljava/io/File;
    move-result-object v11
    if-nez v11, +027h
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    const/4 v14, 0
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda0;
    invoke-direct v15, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)V
    const/16 v16, 2
    const/16 v17, 0
    invoke-static/range v12 ... v17, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v4
    iget-wide v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$uploadStartMs J
    const-string v8, "failed"
    const-string v9, "file_invalid_format"
    invoke-static/range v2 ... v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$reportVoiceFileUploadEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; J J Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda1;
    invoke-direct v15, v0, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUseImageUpload()Z
    move-result v0
    if-eqz v0, +01bh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getAttachmentManager$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    move-result-object v0
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$sourceUri Landroid/net/Uri;
    move-object v13, v1
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    iput v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->label I
    invoke-virtual v0, v11, v12, v15, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->uploadImage(Ljava/io/File; Landroid/net/Uri; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Ljava/lang/String;
    goto +25h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getAttachmentManager$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;
    move-result-object v13
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$sourceUri Landroid/net/Uri;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getMimeType()Ljava/lang/String;
    move-result-object v16
    move-object/from16 v18, v1
    check-cast v18, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    iput v8, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->label I
    move-object v14, v11
    move-object v12, v15
    move-object v15, v0
    move-object/from16 v17, v12
    invoke-virtual/range v13 ... v18, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->uploadFile(Ljava/io/File; Landroid/net/Uri; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Ljava/lang/String;
    move-object v12, v0
    check-cast v12, Ljava/lang/CharSequence;
    const/4 v13, 0
    if-eqz v12, +00bh
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    if-eqz v12, +003h
    goto +3h
    move v12, v13
    goto +2h
    move v12, v9
    if-eqz v12, +032h
    iget-object v14, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    const/16 v16, 0
    new-instance v17, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda2;
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda2;-><init>()V
    const/16 v18, 2
    const/16 v19, 0
    invoke-static/range v14 ... v19, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v11, Ljava/io/File;->length()J
    move-result-wide v22
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$uploadStartMs J
    const-string v26, "failed"
    const-string/jumbo v27, upload_empty_ref
    move-object/from16 v20, v0
    move-object/from16 v21, v9
    move-wide/from16 v24, v12
    invoke-static/range v20 ... v27, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$reportVoiceFileUploadEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; J J Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-static v0, v4, v10, v8, v10, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +43h
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getGroupId()Ljava/lang/String;
    move-result-object v12
    if-eqz v12, +004h
    move v12, v9
    goto +2h
    move v12, v13
    iget-object v14, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    xor-int/lit8 v9, v12, 1
    if-eqz v12, +003h
    const/4 v13, 1
    new-instance v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3;
    invoke-direct v12, v0, v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3;-><init>(Ljava/lang/String; Z)V
    invoke-virtual v14, v15, v9, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment(Ljava/lang/String; Z Lkotlin/jvm/functions/Function1;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v11, Ljava/io/File;->length()J
    move-result-wide v18
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$uploadStartMs J
    const-string/jumbo v22, success
    const-string v23, ""
    move-object/from16 v16, v0
    move-object/from16 v17, v9
    move-wide/from16 v20, v12
    invoke-static/range v16 ... v23, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$reportVoiceFileUploadEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; J J Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string v9, "discussion_attach_upload_success"
    invoke-static v0, v9, v10, v8, v10, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    invoke-static v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$onAttachmentUploadDone(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$5;
    invoke-direct v2, v11, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$5;-><init>(Ljava/io/File; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    iput v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->label I
    invoke-static v0, v2, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getAttachmentUploadJobs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto +74h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v9, "BrainstormViewModel"
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v12, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, v9, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    const/4 v14, 0
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda4;
    invoke-direct v15, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda4;-><init>(Ljava/lang/Throwable;)V
    const/16 v16, 2
    const/16 v17, 0
    invoke-static/range v12 ... v17, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->updateAttachment$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v11, Ljava/io/File;->length()J
    move-result-wide v20
    iget-wide v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$uploadStartMs J
    const-string v24, "failed"
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +00dh
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v25, v0
    goto +3h
    move-object/from16 v25, v9
    move-object/from16 v18, v2
    move-object/from16 v19, v7
    move-wide/from16 v22, v12
    invoke-static/range v18 ... v25, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$reportVoiceFileUploadEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; J J Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-static v0, v4, v10, v8, v10, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$5;
    invoke-direct v2, v11, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$5;-><init>(Ljava/io/File; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->label I
    invoke-static v0, v2, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, -07ch
    return-object v3
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$5;
    invoke-direct v4, v11, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$5;-><init>(Ljava/io/File; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v6, v1
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->L$0 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->label I
    invoke-static v2, v4, v6, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v3, +003h
    return-object v3
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$getAttachmentUploadJobs$p(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;)Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$attachmentId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    throw v0
    :try_start_0x39
    :try_start_0x45
    :try_start_0x93
    :try_start_0x183
.end method
