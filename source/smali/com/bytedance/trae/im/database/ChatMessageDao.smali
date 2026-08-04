# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/ChatMessageDao;
.super Ljava/lang/Object;
.source "ChatMessageDao.kt"

.field private final dbHelper:Lcom/bytedance/trae/im/database/DatabaseOpenHelper;


.method public constructor <init>(com.bytedance.trae.im.database.DatabaseOpenHelper)void
    .registers 3
    # ins_size=2
    const-string v0, "dbHelper"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/database/ChatMessageDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    return-void 
.end method

.method public final insert(java.lang.String  java.lang.String  java.lang.String  int  java.lang.String)long
    .registers 9
    # ins_size=6
    const-string/jumbo v0, taskId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Landroid/content/ContentValues;
    invoke-direct v1, Landroid/content/ContentValues;-><init>()V
    const-string/jumbo v2, task_id
    invoke-virtual v1, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "message_id"
    invoke-virtual v1, v4, v5, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "message_type"
    invoke-virtual v1, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "message_index"
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-virtual v1, v4, v5, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    invoke-virtual v1, v0, v8, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/im/database/ChatMessageDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v4, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v4
    const-string v5, "chat_message"
    const/4 v6, 0
    invoke-virtual v4, v5, v6, v1, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String; Ljava/lang/String; Landroid/content/ContentValues;)J
    move-result-wide v4
    return-wide v4
.end method

.method public final queryByTaskId(java.lang.String)java.util.List
    .registers 21
    # ins_size=2
    move-object/from16 v0, v20
    const-string v1, "getString(...)"
    const-string/jumbo v2, taskId
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    move-object/from16 v3, v19
    iget-object v4, v3, Lcom/bytedance/trae/im/database/ChatMessageDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v4, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v5
    const-string v6, "chat_message"
    const/4 v7, 0
    const-string/jumbo v8, task_id = ? AND deleted_at = 0
    const/4 v4, 1
    new-array v9, v4, [Ljava/lang/String;
    const/4 v4, 0
    aput-object v0, v9, v4
    const/4 v10, 0
    const/4 v11, 0
    const-string v12, "message_index ASC"
    invoke-virtual/range v5 ... v12, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v0
    const-string v4, "query(...)"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v0
    check-cast v4, Ljava/io/Closeable;
    move-object v0, v4
    check-cast v0, Landroid/database/Cursor;
    invoke-interface v0, Landroid/database/Cursor;->moveToNext()Z
    move-result v5
    if-eqz v5, +075h
    new-instance v5, Lcom/bytedance/trae/im/database/ChatMessageEntity;
    const-string v6, "id"
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v7
    const-string/jumbo v6, task_id
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "message_id"
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "message_type"
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "message_index"
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getInt(I)I
    move-result v12
    const-string v6, "content"
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, status
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getInt(I)I
    move-result v14
    const-string v6, "created_at"
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v15
    const-string/jumbo v6, updated_at
    invoke-interface v0, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v0, v6, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v17
    move-object v6, v5
    invoke-direct/range v6 ... v18, Lcom/bytedance/trae/im/database/ChatMessageEntity;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I J J)V
    invoke-interface v2, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -78h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v0, 0
    invoke-static v4, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v2
    move-exception v0
    move-object v1, v0
    throw v1
    move-exception v0
    move-object v2, v0
    invoke-static v4, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v2
    :try_start_0x35
    :try_start_0xba
.end method
