# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
.super Ljava/lang/Object;
.source "MediaStoreRepository.kt"

.field public static final BUCKET_ALL:J
.field public static final Companion:Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;
.field private final context:Landroid/content/Context;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->Companion Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->context Landroid/content/Context;
    return-void 
.end method

.method public static final synthetic access$queryMediaCursor(com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository  java.lang.Long  com.bytedance.trae.conversation.mediachoose.model.MediaType  int  int)android.database.Cursor
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->queryMediaCursor(Ljava/lang/Long; Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; I I)Landroid/database/Cursor;
    move-result-object v0
    return-object v0
.end method

.method private final queryMediaCursor(java.lang.Long  com.bytedance.trae.conversation.mediachoose.model.MediaType  int  int)android.database.Cursor
    .registers 31
    # ins_size=5
    move-object/from16 v0, v26
    move/from16 v1, v29
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "("
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    sget-object v4, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v28, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ordinal()I
    move-result v5
    aget v4, v4, v5
    const-string v5, "3"
    const-string v6, "1"
    const/4 v7, 1
    if-eq v4, v7, +021h
    const/4 v8, 2
    if-eq v4, v8, +01eh
    const/4 v8, 3
    const-string v9, "media_type=?"
    if-eq v4, v8, +012h
    const/4 v6, 4
    if-ne v4, v6, +009h
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v3, v5, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto +19h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v3, v6, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto +ch
    const-string v4, "media_type=? OR media_type=?"
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v3, v6, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    invoke-virtual v3, v5, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    const-string v4, ") AND _size>0"
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    if-eqz v27, +00eh
    const-string v4, " AND bucket_id=?"
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual/range v27, Ljava/lang/Long;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    const-string v8, "_id"
    const-string v9, "media_type"
    const-string v10, "mime_type"
    const-string/jumbo v11, width
    const-string v12, "height"
    const-string v13, "_size"
    const-string v14, "_display_name"
    const-string v15, "bucket_id"
    const-string v16, "bucket_display_name"
    const-string v17, "duration"
    const-string v18, "date_added"
    const-string v19, "_display_name"
    filled-new-array/range v8 ... v19, [Ljava/lang/String;
    move-result-object v4
    const-string v5, "external"
    invoke-static v5, Landroid/provider/MediaStore$Files;->getContentUri(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v5
    sget v6, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v8, 26
    const/4 v9, 0
    if-lt v6, v8, +047h
    new-instance v6, Landroid/os/Bundle;
    invoke-direct v6, Landroid/os/Bundle;-><init>()V
    const-string v8, "android:query-arg-sql-selection"
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v8, v2, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v3, Ljava/util/Collection;
    new-array v2, v9, [Ljava/lang/String;
    invoke-interface v3, v2, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    move-result-object v2
    check-cast v2, [Ljava/lang/String;
    const-string v3, "android:query-arg-sql-selection-args"
    invoke-virtual v6, v3, v2, Landroid/os/Bundle;->putStringArray(Ljava/lang/String; [Ljava/lang/String;)V
    const-string v2, "date_added"
    filled-new-array v2, [Ljava/lang/String;
    move-result-object v2
    const-string v3, "android:query-arg-sort-columns"
    invoke-virtual v6, v3, v2, Landroid/os/Bundle;->putStringArray(Ljava/lang/String; [Ljava/lang/String;)V
    const-string v2, "android:query-arg-sort-direction"
    invoke-virtual v6, v2, v7, Landroid/os/Bundle;->putInt(Ljava/lang/String; I)V
    const-string v2, "android:query-arg-limit"
    move/from16 v3, v30
    invoke-virtual v6, v2, v3, Landroid/os/Bundle;->putInt(Ljava/lang/String; I)V
    const-string v2, "android:query-arg-offset"
    invoke-virtual v6, v2, v1, Landroid/os/Bundle;->putInt(Ljava/lang/String; I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->context Landroid/content/Context;
    invoke-virtual v1, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v1, v5, v4, v6, v2, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Landroid/os/Bundle; Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    move-result-object v1
    goto +2ah
    iget-object v6, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->context Landroid/content/Context;
    invoke-virtual v6, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v20
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v23
    check-cast v3, Ljava/util/Collection;
    new-array v2, v9, [Ljava/lang/String;
    invoke-interface v3, v2, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, [Ljava/lang/String;
    const-string v25, "date_added DESC"
    move-object/from16 v21, v5
    move-object/from16 v22, v4
    invoke-virtual/range v20 ... v25, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v2
    if-eqz v2, +008h
    if-lez v1, +006h
    sub-int/2addr v1, v7
    invoke-interface v2, v1, Landroid/database/Cursor;->moveToPosition(I)Z
    move-object v1, v2
    return-object v1
.end method

.method public final loadBuckets(com.bytedance.trae.conversation.mediachoose.model.MediaType  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;
    const/4 v2, 0
    invoke-direct v1, v3, v4, v2, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2;-><init>(Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository; Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public final loadMediaPage(long  com.bytedance.trae.conversation.mediachoose.model.MediaType  int  int  kotlin.coroutines.Continuation)java.lang.Object
    .registers 17
    # ins_size=7
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v9, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;
    const/4 v8, 0
    move-object v1, v9
    move-wide v2, v11
    move v4, v15
    move-object v5, v10
    move-object v6, v13
    move v7, v14
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadMediaPage$2;-><init>(J I Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository; Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; I Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    move-object/from16 v1, v16
    invoke-static v0, v9, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
