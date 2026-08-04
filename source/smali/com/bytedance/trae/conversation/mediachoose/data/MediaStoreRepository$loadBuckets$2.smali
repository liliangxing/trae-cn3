# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MediaStoreRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $mediaType:Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;


.method constructor <init>(com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository  com.bytedance.trae.conversation.mediachoose.model.MediaType  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->this$0 Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->$mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->this$0 Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->$mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;-><init>(Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository; Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=2
    move-object/from16 v1, v19
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->label I
    if-nez v0, +132h
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->this$0 Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;->$mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    const/16 v4, 2000
    const/4 v5, 0
    const/4 v6, 0
    invoke-static v2, v5, v3, v6, v4, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->access$queryMediaCursor(Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository; Ljava/lang/Long; Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; I I)Landroid/database/Cursor;
    move-result-object v2
    check-cast v2, Ljava/io/Closeable;
    move-object v3, v2
    check-cast v3, Landroid/database/Cursor;
    if-nez v3, +00ah
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v2, v5, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    const-string v4, "bucket_id"
    invoke-interface v3, v4, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v4
    const-string v7, "bucket_display_name"
    invoke-interface v3, v7, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v7
    const-string v8, "_id"
    invoke-interface v3, v8, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v8
    invoke-interface v3, Landroid/database/Cursor;->moveToNext()Z
    move-result v9
    if-eqz v9, +05bh
    invoke-interface v3, v8, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v9
    invoke-interface v3, v4, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v12
    invoke-interface v3, v7, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +004h
    const-string v11, ""
    move-object v14, v11
    const-string v11, "external"
    invoke-static v11, Landroid/provider/MediaStore$Files;->getContentUri(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v11
    invoke-static v11, v9, v10, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri; J)Landroid/net/Uri;
    move-result-object v9
    const-string/jumbo v10, withAppendedId(...)
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v10, v0
    check-cast v10, Ljava/util/Map;
    invoke-static v12, v13, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v15
    invoke-interface v10, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-nez v11, +017h
    new-instance v11, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;
    const/16 v16, 0
    const/16 v17, 4
    const/16 v18, 0
    move-object/from16 v20, v11
    move-object v6, v15
    move/from16 v15, v16
    move-object/from16 v16, v9
    invoke-direct/range v11 ... v18, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;-><init>(J Ljava/lang/String; I Landroid/net/Uri; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v10, v6, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->getCount()I
    move-result v6
    add-int/lit8 v6, v6, 1
    invoke-virtual v11, v6, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->setCount(I)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->getCoverUri()Landroid/net/Uri;
    move-result-object v6
    if-nez v6, +005h
    invoke-virtual v11, v9, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->setCoverUri(Landroid/net/Uri;)V
    const/4 v6, 0
    goto -5eh
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, v5, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-virtual v0, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    const-string v2, "<get-values>(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v0, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +022h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;
    new-instance v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->getId()J
    move-result-wide v7
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->getName()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->getCount()I
    move-result v10
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;->getCoverUri()Landroid/net/Uri;
    move-result-object v11
    move-object v6, v4
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;-><init>(J Ljava/lang/String; I Landroid/net/Uri;)V
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -25h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2$invokeSuspend$$inlined$sortedByDescending$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2$invokeSuspend$$inlined$sortedByDescending$1;-><init>()V
    check-cast v0, Ljava/util/Comparator;
    invoke-static v2, v0, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    const/4 v10, 0
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +00eh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getCount()I
    move-result v4
    add-int/2addr v10, v4
    goto -11h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getCoverUri()Landroid/net/Uri;
    move-result-object v5
    move-object v11, v5
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    const-wide/16 v7, -1
    const-string/jumbo v9, 全部
    move-object v6, v0
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;-><init>(J Ljava/lang/String; I Landroid/net/Uri;)V
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    return-object v0
    move-exception v0
    move-object v3, v0
    throw v3
    move-exception v0
    move-object v4, v0
    invoke-static v2, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    :try_start_0x1f
    :try_start_0x2c
    :try_start_0x132
.end method
