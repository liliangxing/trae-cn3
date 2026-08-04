# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/ConversationDetailDao;
.super Ljava/lang/Object;
.source "ConversationDetailDao.kt"

.field private final dbHelper:Lcom/bytedance/trae/im/database/DatabaseOpenHelper;


.method public constructor <init>(com.bytedance.trae.im.database.DatabaseOpenHelper)void
    .registers 3
    # ins_size=2
    const-string v0, "dbHelper"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    return-void 
.end method

.method private final cursorToEntity(android.database.Cursor)com.bytedance.trae.im.database.ConversationDetailEntity
    .registers 15
    # ins_size=2
    new-instance v12, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    const-string v0, "conversation_id"
    invoke-interface v14, v0, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v0
    invoke-interface v14, v0, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v0, "getString(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "message_id"
    invoke-interface v14, v2, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v2
    invoke-interface v14, v2, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "message_index"
    invoke-interface v14, v3, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v3
    invoke-interface v14, v3, Landroid/database/Cursor;->getInt(I)I
    move-result v3
    const-string/jumbo v4, role
    invoke-interface v14, v4, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v4
    invoke-interface v14, v4, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "content_type"
    invoke-interface v14, v5, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v5
    invoke-interface v14, v5, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "content"
    invoke-interface v14, v6, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v6
    invoke-interface v14, v6, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-direct v13, v14, v0, Lcom/bytedance/trae/im/database/ConversationDetailDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    const-string v0, "created_at"
    invoke-interface v14, v0, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v0
    invoke-interface v14, v0, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v8
    const-string/jumbo v0, updated_at
    invoke-interface v14, v0, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v0
    invoke-interface v14, v0, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v10
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/im/database/ConversationDetailEntity;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J J)V
    return-object v12
.end method

.method private final getStringOrNull(android.database.Cursor  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    invoke-interface v2, v3, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v3
    if-ltz v3, +00dh
    invoke-interface v2, v3, Landroid/database/Cursor;->isNull(I)Z
    move-result v0
    if-nez v0, +007h
    invoke-interface v2, v3, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method public static synthetic queryLatest$default(com.bytedance.trae.im.database.ConversationDetailDao  java.lang.String  int  int  java.lang.Object)java.util.List
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const/16 v2, 10
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDetailDao;->queryLatest(Ljava/lang/String; I)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final toContentValues(com.bytedance.trae.im.database.ConversationDetailEntity)android.content.ContentValues
    .registers 5
    # ins_size=2
    new-instance v0, Landroid/content/ContentValues;
    invoke-direct v0, Landroid/content/ContentValues;-><init>()V
    const-string v1, "conversation_id"
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v1, "message_id"
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getMessageIndex()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "message_index"
    invoke-virtual v0, v2, v1, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    const-string/jumbo v1, role
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getRole()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v1, "content_type"
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContentType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v1, "content"
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getContent()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, status
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getCreatedAt()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    const-string v2, "created_at"
    invoke-virtual v0, v2, v1, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Long;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->getUpdatedAt()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    const-string/jumbo v1, updated_at
    invoke-virtual v0, v1, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Long;)V
    return-object v0
.end method

.method public static synthetic trimOldConversations$default(com.bytedance.trae.im.database.ConversationDetailDao  int  int  java.lang.Object)int
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const/16 v1, 2000
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailDao;->trimOldConversations(I)I
    move-result v0
    return v0
.end method

.method public final deleteAll()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    const-string v1, "conversation_detail"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, v2, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
.end method

.method public final deleteByConversationId(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/String;
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "conversation_detail"
    const-string v2, "conversation_id = ?"
    invoke-virtual v0, v4, v2, v1, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
.end method

.method public final deleteByMessageId(java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    const/4 v1, 2
    new-array v1, v1, [Ljava/lang/String;
    const/4 v2, 0
    aput-object v4, v1, v2
    const/4 v4, 1
    aput-object v5, v1, v4
    const-string v4, "conversation_detail"
    const-string v5, "conversation_id = ? AND message_id = ?"
    invoke-virtual v0, v4, v5, v1, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
.end method

.method public final deleteByMessageIds(java.lang.String  java.util.List)void
    .registers 9
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageIds"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v8, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v6, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    invoke-interface v8, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +019h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    const-string v2, "conversation_detail"
    const-string v3, "conversation_id = ? AND message_id = ?"
    const/4 v4, 2
    new-array v4, v4, [Ljava/lang/String;
    const/4 v5, 0
    aput-object v7, v4, v5
    const/4 v5, 1
    aput-object v1, v4, v5
    invoke-virtual v0, v2, v3, v4, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    goto -1ch
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    return-void 
    move-exception v7
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    throw v7
    :try_start_0x1a
.end method

.method public final getTotalCount()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    const-string v1, "SELECT COUNT(*) FROM conversation_detail"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String; [Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v0
    const-string v1, "rawQuery(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/io/Closeable;
    move-object v1, v0
    check-cast v1, Landroid/database/Cursor;
    invoke-interface v1, Landroid/database/Cursor;->moveToFirst()Z
    move-result v3
    const/4 v4, 0
    if-eqz v3, +006h
    invoke-interface v1, v4, Landroid/database/Cursor;->getInt(I)I
    move-result v4
    invoke-static v0, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return v4
    move-exception v1
    throw v1
    move-exception v2
    invoke-static v0, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v2
    :try_start_0x14
    :try_start_0x27
.end method

.method public final insertOrReplace(com.bytedance.trae.im.database.ConversationDetailEntity)void
    .registers 6
    # ins_size=2
    const-string v0, "entity"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/im/database/ConversationDetailDao;->toContentValues(Lcom/bytedance/trae/im/database/ConversationDetailEntity;)Landroid/content/ContentValues;
    move-result-object v5
    iget-object v0, v4, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 5
    const-string v3, "conversation_detail"
    invoke-virtual v0, v3, v1, v5, v2, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String; Ljava/lang/String; Landroid/content/ContentValues; I)J
    return-void 
.end method

.method public final insertOrReplaceAll(java.util.List)void
    .registers 7
    # ins_size=2
    const-string v0, "entities"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    invoke-interface v6, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    const-string v2, "conversation_detail"
    invoke-direct v5, v1, Lcom/bytedance/trae/im/database/ConversationDetailDao;->toContentValues(Lcom/bytedance/trae/im/database/ConversationDetailEntity;)Landroid/content/ContentValues;
    move-result-object v1
    const/4 v3, 5
    const/4 v4, 0
    invoke-virtual v0, v2, v4, v1, v3, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String; Ljava/lang/String; Landroid/content/ContentValues; I)J
    goto -17h
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    return-void 
    move-exception v6
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    throw v6
    :try_start_0xe
.end method

.method public final queryLatest(java.lang.String  int)java.util.List
    .registers 14
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iget-object v1, v11, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v1, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v2
    const-string v3, "conversation_detail"
    const/4 v4, 0
    const-string v5, "conversation_id = ?"
    const/4 v1, 1
    new-array v6, v1, [Ljava/lang/String;
    const/4 v1, 0
    aput-object v12, v6, v1
    const/4 v7, 0
    const/4 v8, 0
    const-string v9, "created_at DESC"
    invoke-static v13, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v10
    invoke-virtual/range v2 ... v10, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v12
    const-string v13, "query(...)"
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Ljava/io/Closeable;
    move-object v13, v12
    check-cast v13, Landroid/database/Cursor;
    invoke-interface v13, Landroid/database/Cursor;->moveToNext()Z
    move-result v1
    if-eqz v1, +00ah
    invoke-direct v11, v13, Lcom/bytedance/trae/im/database/ConversationDetailDao;->cursorToEntity(Landroid/database/Cursor;)Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -dh
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v13, 0
    invoke-static v12, v13, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    move-exception v13
    throw v13
    move-exception v0
    invoke-static v12, v13, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v0
    :try_start_0x30
    :try_start_0x49
.end method

.method public final replaceAllForConversation(java.lang.String  java.util.List)void
    .registers 8
    # ins_size=3
    const-string v0, "conversation_detail"
    const-string v1, "conversationId"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "entities"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v5, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v1, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v1
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    const-string v2, "conversation_id = ?"
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/String;
    const/4 v4, 0
    aput-object v6, v3, v4
    invoke-virtual v1, v0, v2, v3, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    invoke-interface v7, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +012h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    invoke-direct v5, v7, Lcom/bytedance/trae/im/database/ConversationDetailDao;->toContentValues(Lcom/bytedance/trae/im/database/ConversationDetailEntity;)Landroid/content/ContentValues;
    move-result-object v7
    const/4 v2, 5
    const/4 v3, 0
    invoke-virtual v1, v0, v3, v7, v2, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String; Ljava/lang/String; Landroid/content/ContentValues; I)J
    goto -15h
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    return-void 
    move-exception v6
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    throw v6
    :try_start_0x15
.end method

.method public final trimOldConversations(int)int
    .registers 11
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/im/database/ConversationDetailDao;->getTotalCount()I
    move-result v0
    const/4 v1, 0
    if-gt v0, v10, +003h
    return v1
    iget-object v2, v9, Lcom/bytedance/trae/im/database/ConversationDetailDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v2, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v2
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    const-string v4, "SELECT conversation_id, COUNT(*) AS cnt
FROM conversation_detail
GROUP BY conversation_id
ORDER BY MAX(updated_at) ASC"
    const/4 v5, 0
    invoke-virtual v2, v4, v5, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String; [Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v4
    const-string v6, "rawQuery(...)"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/io/Closeable;
    move-object v6, v4
    check-cast v6, Landroid/database/Cursor;
    goto +1ah
    invoke-interface v6, Landroid/database/Cursor;->moveToNext()Z
    move-result v10
    const/4 v7, 1
    if-eqz v10, +016h
    if-lez v0, +014h
    invoke-interface v6, v1, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v10
    const-string v8, "getString(...)"
    invoke-static v10, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, v10, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v6, v7, Landroid/database/Cursor;->getInt(I)I
    move-result v10
    sub-int/2addr v0, v10
    goto -1ah
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v4, v5, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v10
    if-eqz v10, +003h
    return v1
    invoke-virtual v2, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +014h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const-string v4, "conversation_detail"
    const-string v5, "conversation_id = ?"
    new-array v6, v7, [Ljava/lang/String;
    aput-object v0, v6, v1
    invoke-virtual v2, v4, v5, v6, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    goto -17h
    invoke-virtual v2, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    invoke-virtual v2, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v10
    return v10
    move-exception v10
    invoke-virtual v2, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    throw v10
    move-exception v10
    throw v10
    move-exception v0
    invoke-static v4, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v0
    :try_start_0x23
    :try_start_0x51
    :try_start_0x7e
.end method
