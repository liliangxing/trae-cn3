# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;
.super Ljava/lang/Object;
.source "MediaStoreRepository.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;-><init>()V
    return-void 
.end method

.method private final queryMediaItemFromMediaStore(android.content.Context  android.net.Uri)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 23
    # ins_size=3
    const-string v1, "_id"
    const-string v2, "mime_type"
    const-string/jumbo v3, width
    const-string v4, "height"
    const-string v5, "_size"
    const-string v6, "_display_name"
    filled-new-array/range v1 ... v6, [Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v21, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v7
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    move-object/from16 v8, v22
    invoke-virtual/range v7 ... v12, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    move-object v2, v0
    check-cast v2, Ljava/io/Closeable;
    move-object v0, v2
    check-cast v0, Landroid/database/Cursor;
    invoke-interface v0, Landroid/database/Cursor;->moveToFirst()Z
    move-result v3
    if-nez v3, +006h
    invoke-static v2, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v1
    const-string v3, "_id"
    invoke-interface v0, v3, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v3
    invoke-interface v0, v3, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v5
    const-string v3, "mime_type"
    invoke-interface v0, v3, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v3
    invoke-interface v0, v3, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v3, width
    invoke-interface v0, v3, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v3
    invoke-interface v0, v3, Landroid/database/Cursor;->getInt(I)I
    move-result v14
    const-string v3, "height"
    invoke-interface v0, v3, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v3
    invoke-interface v0, v3, Landroid/database/Cursor;->getInt(I)I
    move-result v15
    const-string v3, "_size"
    invoke-interface v0, v3, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v3
    invoke-interface v0, v3, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v16
    const-string v3, "_display_name"
    invoke-interface v0, v3, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v3
    const/4 v4, -1
    if-eq v3, v4, +009h
    invoke-interface v0, v3, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v0
    move-object/from16 v19, v0
    goto +3h
    move-object/from16 v19, v1
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const-string v13, ""
    const/16 v18, 0
    move-object v4, v0
    move-object/from16 v7, v22
    invoke-direct/range v4 ... v19, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;-><init>(J Landroid/net/Uri; Ljava/lang/String; J J Ljava/lang/String; I I J Z Ljava/lang/String;)V
    invoke-static v2, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    move-exception v0
    move-object v1, v0
    throw v1
    move-exception v0
    move-object v3, v0
    invoke-static v2, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    :try_start_0x25
    :try_start_0x32
    :try_start_0x8d
.end method

.method private final queryMediaItemFromProvider(android.content.Context  android.net.Uri)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 25
    # ins_size=3
    move-object/from16 v0, v24
    invoke-virtual/range v23, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v1
    const-string v7, "_display_name"
    const-string v8, "_size"
    filled-new-array v7, v8, [Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    move-object/from16 v2, v24
    invoke-virtual/range v1 ... v6, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v1
    const/4 v15, 0
    if-nez v1, +003h
    return-object v15
    move-object v13, v1
    check-cast v13, Ljava/io/Closeable;
    move-object v1, v13
    check-cast v1, Landroid/database/Cursor;
    invoke-interface v1, Landroid/database/Cursor;->moveToFirst()Z
    move-result v2
    if-nez v2, +006h
    invoke-static v13, v15, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v15
    invoke-interface v1, v8, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v2
    invoke-interface v1, v2, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v16
    invoke-interface v1, v7, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v2
    invoke-interface v1, v2, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v18
    invoke-virtual/range v23, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/content/ContentResolver;->getType(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v5
    new-instance v1, Landroid/graphics/BitmapFactory$Options;
    invoke-direct v1, Landroid/graphics/BitmapFactory$Options;-><init>()V
    const/4 v2, 1
    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds Z
    invoke-virtual/range v23, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v2
    invoke-virtual v2, v0, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;
    move-result-object v2
    if-eqz v2, +01bh
    check-cast v2, Ljava/io/Closeable;
    move-object v3, v2
    check-cast v3, Ljava/io/InputStream;
    invoke-static v3, v15, v1, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream; Landroid/graphics/Rect; Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    invoke-static v2, v15, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +eh
    move-exception v0
    move-object v1, v0
    throw v1
    move-exception v0
    move-object v3, v0
    invoke-static v2, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-exception v0
    move-object v2, v0
    move-object v1, v13
    goto +2eh
    new-instance v19, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    const-wide/16 v2, 0
    const-wide/16 v6, 0
    const-wide/16 v8, 0
    const-string v10, ""
    iget v11, v1, Landroid/graphics/BitmapFactory$Options;->outWidth I
    iget v12, v1, Landroid/graphics/BitmapFactory$Options;->outHeight I
    const/16 v20, 0
    move-object/from16 v1, v19
    move-object/from16 v4, v24
    move-object/from16 v21, v13
    move-wide/from16 v13, v16
    move-object v0, v15
    move/from16 v15, v20
    move-object/from16 v16, v18
    invoke-direct/range v1 ... v16, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;-><init>(J Landroid/net/Uri; Ljava/lang/String; J J Ljava/lang/String; I I J Z Ljava/lang/String;)V
    move-object/from16 v1, v21
    invoke-static v1, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v19
    move-exception v0
    move-object/from16 v1, v21
    goto +3h
    move-exception v0
    move-object v1, v13
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v1, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    :try_start_0x1e
    :try_start_0x2b
    :try_start_0x55
    :try_start_0x57
    :try_start_0x5d
    :try_start_0x63
    :try_start_0x66
    :try_start_0x6e
    :try_start_0x8b
    :try_start_0x9b
.end method

.method public final queryMediaItem(android.content.Context  android.net.Uri)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 8
    # ins_size=3
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uri
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v7, Landroid/net/Uri;->getAuthority()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +010h
    check-cast v1, Ljava/lang/CharSequence;
    const-string v3, "fileprovider"
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 1
    invoke-static v1, v3, v4, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v1
    if-ne v1, v4, +003h
    goto +2h
    move v4, v2
    if-nez v4, +01bh
    invoke-virtual v7, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v3, toString(...)
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "content://media/"
    const/4 v4, 2
    invoke-static v1, v3, v2, v4, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +6h
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;->queryMediaItemFromMediaStore(Landroid/content/Context; Landroid/net/Uri;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v6
    goto +5h
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;->queryMediaItemFromProvider(Landroid/content/Context; Landroid/net/Uri;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v6
    move-object v0, v6
    return-object v0
    :try_start_0xc
.end method
