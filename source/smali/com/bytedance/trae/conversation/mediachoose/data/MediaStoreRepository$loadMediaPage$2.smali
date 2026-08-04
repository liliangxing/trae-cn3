# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MediaStoreRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $bucketId:J
.field final synthetic $limit:I
.field final synthetic $mediaType:Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
.field final synthetic $offset:I
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;


.method constructor <init>(long  int  com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository  com.bytedance.trae.conversation.mediachoose.model.MediaType  int  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$bucketId J
    iput v3, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$limit I
    iput-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->this$0 Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    iput v6, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$offset I
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;
    iget-wide v1, v8, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$bucketId J
    iget v3, v8, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$limit I
    iget-object v4, v8, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->this$0 Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    iget v6, v8, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$offset I
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;-><init>(J I Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository; Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; I Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 36
    # ins_size=2
    move-object/from16 v1, v34
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->label I
    if-nez v0, +10eh
    invoke-static/range v35, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-wide v2, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$bucketId J
    const-wide/16 v4, -1
    cmp-long v0, v2, v4
    const/4 v4, 0
    if-nez v0, +004h
    move-object v0, v4
    goto +5h
    invoke-static v2, v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v0
    new-instance v2, Ljava/util/ArrayList;
    iget v3, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$limit I
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->this$0 Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    iget v6, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$offset I
    iget v7, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;->$limit I
    invoke-static v3, v0, v5, v6, v7, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->access$queryMediaCursor(Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository; Ljava/lang/Long; Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; I I)Landroid/database/Cursor;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/io/Closeable;
    move-object v0, v3
    check-cast v0, Landroid/database/Cursor;
    if-nez v0, +00fh
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v3, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    move-exception v0
    move-object v2, v0
    move-object v1, v3
    goto/16 +0cdh
    const-string v5, "_id"
    invoke-interface v0, v5, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v5
    const-string v6, "mime_type"
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    const-string/jumbo v7, width
    invoke-interface v0, v7, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v7
    const-string v8, "height"
    invoke-interface v0, v8, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v8
    const-string v9, "_size"
    invoke-interface v0, v9, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v9
    const-string v10, "_display_name"
    invoke-interface v0, v10, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v10
    const-string v11, "bucket_id"
    invoke-interface v0, v11, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v11
    const-string v12, "bucket_display_name"
    invoke-interface v0, v12, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v12
    const-string v13, "duration"
    invoke-interface v0, v13, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v13
    const-string v14, "media_type"
    invoke-interface v0, v14, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v14
    invoke-interface v0, Landroid/database/Cursor;->moveToNext()Z
    move-result v15
    if-eqz v15, +07bh
    move-object v15, v3
    invoke-interface v0, v5, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v3
    const-string v16, "external"
    invoke-static/range v16, Landroid/provider/MediaStore$Files;->getContentUri(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-static v1, v3, v4, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri; J)Landroid/net/Uri;
    move-result-object v1
    move/from16 v32, v5
    const-string/jumbo v5, withAppendedId(...)
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v11, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v23
    invoke-interface v0, v12, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    move-object/from16 v25, v5
    invoke-interface v0, v14, Landroid/database/Cursor;->getInt(I)I
    move-result v5
    move/from16 v33, v11
    const/4 v11, 3
    const/16 v16, 1
    const/16 v17, 0
    if-ne v5, v11, +005h
    move/from16 v5, v16
    goto +3h
    move/from16 v5, v17
    const/4 v11, -1
    if-eq v10, v11, +009h
    invoke-interface v0, v10, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v11
    move-object/from16 v31, v11
    goto +3h
    const/16 v31, 0
    new-instance v11, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-interface v0, v6, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v20
    invoke-interface v0, v13, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v21
    invoke-interface v0, v7, Landroid/database/Cursor;->getInt(I)I
    move-result v26
    invoke-interface v0, v8, Landroid/database/Cursor;->getInt(I)I
    move-result v27
    invoke-interface v0, v9, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v28
    if-eqz v5, +005h
    move/from16 v30, v16
    goto +3h
    move/from16 v30, v17
    move-object/from16 v16, v11
    move-wide/from16 v17, v3
    move-object/from16 v19, v1
    invoke-direct/range v16 ... v31, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;-><init>(J Landroid/net/Uri; Ljava/lang/String; J J Ljava/lang/String; I I J Z Ljava/lang/String;)V
    invoke-virtual v2, v11, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    move-object/from16 v1, v34
    move-object v3, v15
    move/from16 v5, v32
    move/from16 v11, v33
    const/4 v4, 0
    goto -7ah
    move-exception v0
    move-object v2, v0
    move-object v1, v15
    goto +10h
    move-object v15, v3
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object v1, v15
    const/4 v0, 0
    invoke-static v1, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v2
    move-exception v0
    move-object v1, v15
    goto +3h
    move-exception v0
    move-object v1, v3
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v1, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    :try_start_0x31
    :try_start_0x36
    :try_start_0x43
    :try_start_0x87
    :try_start_0x100
    :try_start_0x10e
.end method
