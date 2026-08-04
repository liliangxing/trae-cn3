# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "FileUploadService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $bizType:Lcom/bytedance/trae/conversation/fileupload/BizType;
.field final synthetic $contentType:Ljava/lang/String;
.field final synthetic $file:Ljava/io/File;
.field final synthetic $options:Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
.field final synthetic $subTargetPath:Ljava/lang/String;
.field final synthetic $userId:Ljava/lang/String;
.field  J$0:J
.field  J$1:J
.field  J$2:J
.field  J$3:J
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  Z$0:Z
.field  Z$1:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/fileupload/FileUploadService;


.method constructor <init>(com.bytedance.trae.conversation.fileupload.FileUploadService$UploadOptions  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  java.lang.String  java.lang.String  com.bytedance.trae.conversation.fileupload.FileUploadService  java.io.File  kotlin.coroutines.Continuation)void
    .registers 9
    # ins_size=9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$options Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$contentType Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$subTargetPath Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$userId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$file Ljava/io/File;
    const/4 v1, 2
    invoke-direct v0, v1, v8, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 13
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$options Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$contentType Ljava/lang/String;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$subTargetPath Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$userId Ljava/lang/String;
    iget-object v6, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$file Ljava/io/File;
    move-object v0, v9
    move-object v8, v12
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;-><init>(Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/io/File; Lkotlin/coroutines/Continuation;)V
    iput-object v11, v9, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 48
    # ins_size=2
    move-object/from16 v1, v46
    const-string/jumbo v2, uploadSingleFile commit start: bizType=
    const-string/jumbo v3, uploadSingleFile commit skipped: bizType=
    const-string v4, "Upload failed with status "
    const-string/jumbo v5, uploadSingleFile put result: bizType=
    const-string/jumbo v0, uploadSingleFile prepare success: bizType=
    const-string/jumbo v6, uploadSingleFile commit failed: bizType=
    const-string/jumbo v7, uploadSingleFile commit success: bizType=
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v8
    iget v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->label I
    const/4 v10, 2
    const-string v11, ", error="
    const-string v12, ", oid="
    const-string v14, "FileUploadService"
    const/4 v15, 1
    if-eqz v9, +090h
    if-eq v9, v15, +04ah
    if-ne v9, v10, +040h
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$3 J
    iget-wide v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$2 J
    iget-wide v8, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$1 J
    move-wide v15, v2
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$0 J
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$3 Ljava/lang/Object;
    move-object v10, v0
    check-cast v10, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$2 Ljava/lang/Object;
    move-object v13, v0
    check-cast v13, Ljava/lang/String;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$1 Ljava/lang/Object;
    move-object/from16 v17, v0
    check-cast v17, Ljava/lang/String;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$0 Ljava/lang/Object;
    move-object/from16 v18, v0
    check-cast v18, Lkotlin/jvm/functions/Function1;
    invoke-static/range v47, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v22, v6
    move-object/from16 v47, v7
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v18, v11
    move-object v11, v12
    goto/16 +5f1h
    move-exception v0
    move-wide/from16 v25, v4
    move-object/from16 v22, v6
    move-wide v4, v15
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v18, v11
    move-object v11, v12
    goto/16 +663h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-boolean v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->Z$1 Z
    iget-boolean v13, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->Z$0 Z
    move-object/from16 v18, v11
    iget-wide v10, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$0 J
    iget-object v15, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$3 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    move/from16 v20, v9
    iget-object v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$2 Ljava/lang/Object;
    check-cast v9, Lkotlin/jvm/functions/Function1;
    move-object/from16 v21, v9
    iget-object v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$1 Ljava/lang/Object;
    check-cast v9, Lkotlin/jvm/functions/Function3;
    move-object/from16 v22, v9
    iget-object v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v47, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v26, v0
    move-object/from16 v23, v2
    move-object/from16 v24, v4
    move-object/from16 v25, v5
    move-object v2, v8
    move/from16 v9, v20
    move-object/from16 v5, v21
    move-object/from16 v34, v22
    move-object/from16 v0, v47
    move-object/from16 v20, v3
    move-object/from16 v22, v6
    move-object/from16 v47, v7
    move-wide v6, v10
    move-object/from16 v21, v12
    goto/16 +14fh
    move-exception v0
    move-object/from16 v3, v18
    move-object/from16 v9, v21
    goto/16 +72ch
    move-object/from16 v18, v11
    invoke-static/range v47, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$options Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->getOnProgress()Lkotlin/jvm/functions/Function3;
    move-result-object v10
    iget-object v11, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$options Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->getOnFinish()Lkotlin/jvm/functions/Function1;
    move-result-object v11
    move-object v13, v6
    move-object v15, v7
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    move-object/from16 v47, v15
    iget-object v15, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$options Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->getEnableMagic()Z
    move-result v15
    move-object/from16 v20, v3
    iget-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$options Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$UploadOptions;->getUseV2()Z
    move-result v3
    const-string v21, "application/octet-stream"
    if-eqz v15, +007h
    move-object/from16 v22, v13
    move-object/from16 v13, v21
    goto +8h
    move-object/from16 v22, v13
    iget-object v13, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$contentType Ljava/lang/String;
    if-nez v13, +003h
    goto -9h
    move-object/from16 v21, v12
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    move-object/from16 v23, v2
    new-instance v2, Ljava/lang/StringBuilder;
    move-object/from16 v24, v4
    const-string/jumbo v4, uploadSingleFile start: bizType=
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v25, v5
    iget-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", subTargetPath="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-object/from16 v26, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$subTargetPath Ljava/lang/String;
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", contentType="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move-object/from16 v27, v8
    iget-object v8, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$contentType Ljava/lang/String;
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v8, ", usedContentType="
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move-wide/from16 v28, v6
    const-string v6, ", userIdBlank="
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v7, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$userId Ljava/lang/String;
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    const/4 v7, 0
    goto +2h
    const/4 v7, 1
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v7, ", enableMagic="
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    move-object/from16 v30, v11
    const-string v11, ", useV2="
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v14, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$subTargetPath Ljava/lang/String;
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$contentType Ljava/lang/String;
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$userId Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v15, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", useV2="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v14, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$getApi$p(Lcom/bytedance/trae/conversation/fileupload/FileUploadService;)Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$subTargetPath Ljava/lang/String;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    iget-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$1 Ljava/lang/Object;
    move-object/from16 v5, v30
    iput-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$2 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$3 Ljava/lang/Object;
    move-wide/from16 v6, v28
    iput-wide v6, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$0 J
    iput-boolean v15, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->Z$0 Z
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->Z$1 Z
    const/4 v8, 1
    iput v8, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->label I
    invoke-interface v0, v2, v4, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;->getResourceUploadUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v2, v27
    if-ne v0, v2, +003h
    return-object v2
    move v9, v3
    move-object/from16 v34, v10
    move/from16 v44, v15
    move-object v15, v13
    move/from16 v13, v44
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getUploadHosts()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    goto +6h
    move-exception v0
    move-object v9, v5
    goto/16 +536h
    const/4 v0, 0
    move-object v8, v0
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    const/4 v8, 0
    goto +2h
    const/4 v8, 1
    if-eqz v8, +032h
    const-string v38, "No upload host found"
    if-eqz v5, +01ah
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    const/16 v28, 0
    sget-object v29, Lcom/bytedance/trae/conversation/fileupload/UploadStage;->Prepare Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    const/16 v31, 0
    const/16 v32, 8
    const/16 v33, 0
    move-object/from16 v27, v0
    move-object/from16 v30, v38
    invoke-direct/range v27 ... v33, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;-><init>(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    const-string v36, ""
    const/16 v37, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 24
    const/16 v42, 0
    move-object/from16 v35, v0
    invoke-direct/range v35 ... v42, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getStoreInfos()Ljava/util/List;
    move-result-object v8
    if-eqz v8, +009h
    invoke-static v8, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;
    goto +2h
    const/4 v8, 0
    if-nez v8, +032h
    const-string v38, "No store info found"
    if-eqz v5, +01ah
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    const/16 v28, 0
    sget-object v29, Lcom/bytedance/trae/conversation/fileupload/UploadStage;->Prepare Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    const/16 v31, 0
    const/16 v32, 8
    const/16 v33, 0
    move-object/from16 v27, v0
    move-object/from16 v30, v38
    invoke-direct/range v27 ... v33, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;-><init>(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    const-string v36, ""
    const/16 v37, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 24
    const/16 v42, 0
    move-object/from16 v35, v0
    invoke-direct/range v35 ... v42, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;->getStoreUri()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v8, Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;->getAuth()Ljava/lang/String;
    move-result-object v11
    iget-object v12, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-static v12, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$shouldUseTobObjectStorePutCompat(Lcom/bytedance/trae/conversation/fileupload/FileUploadService;)Z
    move-result v12
    if-eqz v12, +03ah
    invoke-virtual v8, Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;->getOverrideResourceId()Ljava/lang/String;
    move-result-object v27
    if-eqz v27, +015h
    move-object/from16 v28, v27
    check-cast v28, Ljava/lang/CharSequence;
    invoke-static/range v28, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v28
    const/16 v19, 1
    xor-int/lit8 v28, v28, 1
    if-eqz v28, +003h
    goto +3h
    const/16 v27, 0
    if-nez v27, +01ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getOverrideResourceId()Ljava/lang/String;
    move-result-object v27
    if-eqz v27, +011h
    move-object/from16 v28, v27
    check-cast v28, Ljava/lang/CharSequence;
    invoke-static/range v28, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v28
    const/16 v19, 1
    xor-int/lit8 v28, v28, 1
    if-eqz v28, +003h
    goto +3h
    const/16 v27, 0
    if-nez v27, +003h
    goto +6h
    move-object/from16 v36, v2
    move-object/from16 v4, v27
    goto +4h
    move-object/from16 v36, v2
    move-object v4, v10
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    move-object/from16 v37, v5
    new-instance v5, Ljava/lang/StringBuilder;
    move/from16 v38, v12
    move-object/from16 v12, v26
    invoke-direct v5, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v26, v15
    iget-object v15, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v15, ", hasSessionKey="
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getSessionKey()Ljava/lang/String;
    move-result-object v15
    check-cast v15, Ljava/lang/CharSequence;
    if-eqz v15, +012h
    invoke-static v15, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v15
    if-eqz v15, +003h
    goto +ah
    const/4 v15, 0
    goto +9h
    move-exception v0
    move-object/from16 v3, v18
    move-object/from16 v9, v37
    goto/16 +4d2h
    const/4 v15, 1
    if-nez v15, +004h
    const/4 v15, 1
    goto +2h
    const/4 v15, 0
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v15, ", host="
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v15, ", storeUri="
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v15, ", storeOverrideResourceId="
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v8, Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;->getOverrideResourceId()Ljava/lang/String;
    move-result-object v15
    const-string v39, ""
    if-nez v15, +004h
    move-object/from16 v15, v39
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v15, ", responseOverrideResourceId="
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getOverrideResourceId()Ljava/lang/String;
    move-result-object v15
    if-nez v15, +004h
    move-object/from16 v15, v39
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v15, ", resourceId="
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v14, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", hasSessionKey="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getSessionKey()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    const/4 v5, 1
    if-nez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", host="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", storeUri="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", storeOverrideResourceId="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v8, Lcom/bytedance/trae/conversation/fileupload/StoreInfoItem;->getOverrideResourceId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    move-object/from16 v5, v39
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", responseOverrideResourceId="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getOverrideResourceId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    move-object/from16 v5, v39
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", resourceId="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v14, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$file Ljava/io/File;
    if-eqz v9, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    invoke-static v2, v13, v8, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->calculateChecksums(Ljava/io/File; Z Z)Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    move-result-object v2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v40
    move-object v8, v4
    sub-long v4, v40, v6
    iget-object v12, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-static v12, v0, v10, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$buildUploadUrl(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iget-object v12, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$userId Ljava/lang/String;
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v15
    move-wide/from16 v42, v4
    const-string v4, "Authorization"
    invoke-interface v15, v4, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v4, "Content-CRC32"
    invoke-virtual v2, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->getCrc32Hex()Ljava/lang/String;
    move-result-object v5
    invoke-interface v15, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v4, "Content-Type"
    move-object/from16 v5, v26
    invoke-interface v15, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-object v4, v12
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    const/4 v4, 0
    goto +2h
    const/4 v4, 1
    if-nez v4, +00bh
    const-string v4, "X-Storage-U"
    invoke-static v12, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->urlEncode(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-interface v15, v4, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v15, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v4
    new-instance v11, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$file Ljava/io/File;
    if-eqz v9, +005h
    const/16 v31, 1
    goto +3h
    const/16 v31, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->getSizeBytes()J
    move-result-wide v32
    move-object/from16 v27, v11
    move-object/from16 v28, v12
    move-object/from16 v29, v5
    move/from16 v30, v13
    invoke-direct/range v27 ... v34, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$FileWithOptionalMagicTypedOutput;-><init>(Ljava/io/File; Ljava/lang/String; Z Z J Lkotlin/jvm/functions/Function3;)V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-static v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$createObjectStoreApi(Lcom/bytedance/trae/conversation/fileupload/FileUploadService;)Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;
    move-result-object v5
    check-cast v11, Lcom/bytedance/retrofit2/mime/TypedOutput;
    if-nez v38, +004h
    const/4 v9, 1
    goto +2h
    const/4 v9, 0
    invoke-interface v5, v0, v11, v4, v9, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;->put(Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedOutput; Ljava/util/Map; Z)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v4
    const-string v0, "execute(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v27
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->isSuccessful()Z
    move-result v5
    const/16 v29, 0
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +003h
    const/4 v0, 0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +005h
    move-object/from16 v30, v39
    goto +3h
    move-object/from16 v30, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v4
    const-string v9, "headers(...)"
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$formatRetrofitHeaders(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/util/List;)Ljava/lang/String;
    move-result-object v31
    const/16 v32, 4
    const/16 v33, 0
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;
    if-eqz v5, +005h
    const/16 v28, 1
    goto +3h
    const/16 v28, 0
    move-object/from16 v26, v0
    invoke-direct/range v26 ... v33, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;-><init>(I Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    move-object/from16 v9, v25
    invoke-direct v5, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v11, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v11, ", code="
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getCode()I
    move-result v11
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v11, ", isSuccessful="
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful()Z
    move-result v11
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v14, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", code="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getCode()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", isSuccessful="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v14, v4, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    sub-long v11, v4, v40
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->isSuccessful()Z
    move-result v9
    if-nez v9, +066h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-static v2, v3, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$logPutFailureResponse(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Lcom/bytedance/trae/conversation/fileupload/BizType; Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;)V
    new-instance v2, Ljava/lang/StringBuilder;
    move-object/from16 v3, v24
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getCode()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ": "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$ObjectStorePutResult;->getErrorText()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +004h
    const-string v0, "Unknown error"
    check-cast v0, Ljava/lang/String;
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    if-eqz v37, +018h
    new-instance v9, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    const/4 v3, 0
    sget-object v4, Lcom/bytedance/trae/conversation/fileupload/UploadStage;->Upload Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v9
    move-object v5, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;-><init>(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v13, v37
    invoke-interface v13, v9, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +3h
    move-object/from16 v13, v37
    new-instance v10, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    const-string v3, ""
    const/4 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 24
    const/4 v9, 0
    move-object v2, v10
    move-object v5, v0
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
    move-exception v0
    move-object/from16 v13, v37
    move-object v9, v13
    goto/16 +1c2h
    move-object/from16 v13, v37
    invoke-virtual v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->getSessionKey()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object/from16 v0, v39
    if-nez v38, +013h
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    const/4 v9, 1
    xor-int/2addr v3, v9
    if-eqz v3, +003h
    goto +7h
    const/16 v16, 0
    goto +6h
    move-exception v0
    goto -1fh
    const/4 v9, 1
    move/from16 v16, v9
    if-eqz v16, +1a4h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    move-object/from16 v15, v23
    invoke-direct v9, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-wide/from16 v23, v11
    iget-object v11, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    move-object/from16 v11, v21
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v12, ", sessionKeyBlank="
    invoke-virtual v9, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    move-object v12, v0
    check-cast v12, Ljava/lang/CharSequence;
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    invoke-virtual v9, v12, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v3, v14, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v9, ", sessionKeyBlank="
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object v9, v0
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v14, v3, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-static v3, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$getApi$p(Lcom/bytedance/trae/conversation/fileupload/FileUploadService;)Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;
    move-result-object v3
    new-instance v9, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    iget-object v15, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-direct v9, v12, v0, v15, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;-><init>(Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$1 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$2 Ljava/lang/Object;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->L$3 Ljava/lang/Object;
    iput-wide v6, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$0 J
    move-wide v15, v6
    move-wide/from16 v6, v42
    iput-wide v6, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$1 J
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$2 J
    move-wide/from16 v25, v4
    move-wide/from16 v4, v23
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->J$3 J
    const/4 v12, 2
    iput v12, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->label I
    invoke-interface v3, v9, v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;->commitResourceUploadResult(Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v3, v36
    if-ne v0, v3, +003h
    return-object v3
    move-object/from16 v44, v10
    move-object v10, v2
    move-wide v2, v15
    move-wide v15, v4
    move-wide/from16 v4, v25
    move-object/from16 v45, v13
    move-object v13, v8
    move-wide v8, v6
    move-object/from16 v6, v44
    move-object/from16 v7, v45
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v12, Ljava/lang/StringBuilder;
    move-wide/from16 v19, v2
    move-object/from16 v2, v47
    invoke-direct v12, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v12, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v14, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v14, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sub-long/2addr v2, v4
    move-object v5, v7
    move-object v4, v13
    move-wide v11, v15
    move-object/from16 v15, v18
    move-wide/from16 v6, v19
    goto/16 +09dh
    move-exception v0
    move-wide/from16 v25, v4
    move-wide v4, v15
    move-wide/from16 v2, v19
    goto +33h
    move-exception v0
    move-wide/from16 v19, v2
    move-wide/from16 v25, v4
    move-wide v4, v15
    goto +2ch
    move-exception v0
    goto +1eh
    move-exception v0
    move-wide/from16 v25, v4
    move-wide/from16 v4, v23
    goto +18h
    move-exception v0
    move-wide/from16 v25, v4
    move-wide v15, v6
    goto +7h
    move-exception v0
    move-wide/from16 v25, v4
    move-wide v15, v6
    move-object/from16 v11, v21
    move-wide/from16 v4, v23
    goto +8h
    move-exception v0
    move-wide/from16 v25, v4
    move-wide v15, v6
    move-wide v4, v11
    move-object/from16 v11, v21
    move-wide/from16 v6, v42
    move-object/from16 v44, v10
    move-object v10, v2
    move-wide v2, v15
    move-object/from16 v45, v13
    move-object v13, v8
    move-wide v8, v6
    move-object/from16 v6, v44
    move-object/from16 v7, v45
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    move-wide/from16 v16, v2
    move-object/from16 v2, v22
    invoke-direct v15, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v15, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object/from16 v15, v18
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-wide/from16 v18, v4
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v12, v14, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v14, v2, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sub-long v2, v2, v25
    move-object v5, v7
    move-object v4, v13
    move-wide/from16 v6, v16
    move-wide/from16 v11, v18
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-wide/from16 v22, v2
    move-object v13, v5
    move-wide/from16 v18, v8
    move-object v2, v10
    move-wide/from16 v20, v11
    move-object v3, v15
    move-object v5, v4
    goto +57h
    move-exception v0
    move-object v9, v5
    goto +3h
    move-exception v0
    move-object v9, v7
    move-object v3, v15
    goto/16 +0a0h
    move-exception v0
    move-object v9, v7
    move-object/from16 v3, v18
    goto/16 +09ah
    move-wide v15, v6
    move-wide v4, v11
    move-object/from16 v3, v18
    move-wide/from16 v6, v42
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v9, Ljava/lang/StringBuilder;
    move-object/from16 v10, v20
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v11, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v11, ", reason=session_key_blank"
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v14, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v9, ", reason=session_key_blank"
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v14, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    move-result v0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    const-wide/16 v9, 0
    move-wide/from16 v20, v4
    move-wide/from16 v18, v6
    move-object v5, v8
    move-wide/from16 v22, v9
    move-wide v6, v15
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    sub-long v24, v8, v6
    if-eqz v13, +019h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    const/4 v7, 1
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    move-object/from16 v17, v10
    invoke-direct/range v17 ... v25, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;-><init>(J J J J)V
    const/4 v11, 6
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;-><init>(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v13, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    const/4 v6, 1
    const/4 v7, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->getSha256Hex()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->getSizeBytes()J
    move-result-wide v9
    invoke-static v9, v10, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v9
    const/4 v10, 4
    const/4 v11, 0
    move-object v4, v0
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    move-exception v0
    goto +dh
    move-exception v0
    goto +9h
    move-exception v0
    move-object/from16 v3, v18
    move-object/from16 v13, v37
    goto +5h
    move-exception v0
    move-object v13, v5
    move-object/from16 v3, v18
    move-object v9, v13
    goto +bh
    move-exception v0
    move-object/from16 v3, v18
    goto +6h
    move-exception v0
    move-object/from16 v3, v18
    move-object/from16 v5, v30
    move-object v9, v5
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, "Unknown upload error"
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, uploadSingleFile failed: bizType=
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v14, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$uploadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v14, v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    if-eqz v9, +019h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    const/16 v16, 0
    sget-object v17, Lcom/bytedance/trae/conversation/fileupload/UploadStage;->Prepare Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    const/16 v19, 0
    const/16 v20, 8
    const/16 v21, 0
    move-object v15, v0
    move-object/from16 v18, v2
    invoke-direct/range v15 ... v21, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;-><init>(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v9, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    const-string v16, ""
    const/16 v17, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 24
    const/16 v22, 0
    move-object v15, v0
    move-object/from16 v18, v2
    invoke-direct/range v15 ... v22, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    :try_start_0x49
    :try_start_0x8e
    :try_start_0x1be
    :try_start_0x1da
    :try_start_0x1fa
    :try_start_0x203
    :try_start_0x20f
    :try_start_0x214
    :try_start_0x250
    :try_start_0x256
    :try_start_0x290
    :try_start_0x2a0
    :try_start_0x2db
    :try_start_0x2df
    :try_start_0x2fe
    :try_start_0x314
    :try_start_0x33c
    :try_start_0x37c
    :try_start_0x38b
    :try_start_0x412
    :try_start_0x427
    :try_start_0x469
    :try_start_0x477
    :try_start_0x51e
    :try_start_0x546
    :try_start_0x548
    :try_start_0x564
    :try_start_0x584
    :try_start_0x58e
    :try_start_0x5a4
    :try_start_0x5af
    :try_start_0x5b7
    :try_start_0x623
    :try_start_0x62b
    :try_start_0x648
    :try_start_0x650
    :try_start_0x6c9
    :try_start_0x6e4
    :try_start_0x72b
    :try_start_0x74c
.end method
