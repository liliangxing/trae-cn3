# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/ConversationDao;
.super Ljava/lang/Object;
.source "ConversationDao.kt"

.field private final dbHelper:Lcom/bytedance/trae/im/database/DatabaseOpenHelper;


.method public constructor <init>(com.bytedance.trae.im.database.DatabaseOpenHelper)void
    .registers 3
    # ins_size=2
    const-string v0, "dbHelper"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    return-void 
.end method

.method private final cursorToConversation(android.database.Cursor)com.bytedance.trae.im.service.Conversation
    .registers 34
    # ins_size=2
    move-object/from16 v0, v32
    move-object/from16 v1, v33
    const-string v2, "cli_conversation_id"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    const-string v2, "id"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v2, user_id
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-string v2, "cli_id"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v2, title
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v2, workspace
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    const-string v2, "git_uri"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    const-string v2, "mode"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    const-string/jumbo v2, status
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    const-string v2, "cli_type"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    const-string v2, "latest_task_id"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v16
    const-string v2, "latest_task_status"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v17
    const-string v2, "latest_task_update_time"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v18
    const-string v2, "created_at"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v19
    const-string/jumbo v2, updated_at
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v20
    const-string v2, "icon_type"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v22
    const-string v2, "cli_conversation_status"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getIntOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v23
    const-string v2, "owner_project_id"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v24
    const-string v2, "latest_project_id"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v25
    const-string v2, "owner_project_absolute_path"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v26
    const-string v2, "owner_project_workspace_status"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v27
    const-string v2, "is_pinned"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/database/ConversationDao;->getIntOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v2
    if-nez v2, +003h
    goto +9h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    const/4 v3, 1
    if-ne v2, v3, +003h
    goto +2h
    const/4 v3, 0
    move v2, v3
    const-string v3, "pinned_at"
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/im/database/ConversationDao;->getStringOrNull(Landroid/database/Cursor; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v29
    new-instance v1, Lcom/bytedance/trae/im/service/Conversation;
    move-object v3, v1
    const/4 v5, 0
    const/4 v6, 0
    const/16 v21, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v28
    const v30, 131078
    const/16 v31, 0
    invoke-direct/range v3 ... v31, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method private final getIntOrNull(android.database.Cursor  java.lang.String)java.lang.Integer
    .registers 4
    # ins_size=3
    invoke-interface v2, v3, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v3
    if-ltz v3, +011h
    invoke-interface v2, v3, Landroid/database/Cursor;->isNull(I)Z
    move-result v0
    if-nez v0, +00bh
    invoke-interface v2, v3, Landroid/database/Cursor;->getInt(I)I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    return-object v2
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

.method public final clearAll()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    const-string v1, "conversation"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, v2, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
.end method

.method public final deleteById(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string v0, "id"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/String;
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "conversation"
    const-string v2, "id = ?"
    invoke-virtual v0, v4, v2, v1, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
.end method

.method public final insertOrUpdateAll(java.util.List)void
    .registers 9
    # ins_size=2
    const-string v0, "conversations"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    invoke-interface v8, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +0feh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto -12h
    new-instance v3, Landroid/content/ContentValues;
    invoke-direct v3, Landroid/content/ContentValues;-><init>()V
    const-string v4, "id"
    invoke-virtual v3, v4, v2, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "cli_conversation_id"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v2, user_id
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getUserId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "cli_id"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v2, title
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v2, workspace
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getDisplayWorkspace()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "git_uri"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getDisplayGitUri()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "mode"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v2, status
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getStatus()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "cli_type"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "latest_task_id"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "latest_task_status"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskStatus()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "latest_task_update_time"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskUpdateTime()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "created_at"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCreatedAt()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v2, updated_at
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getUpdatedAt()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "icon_type"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getIconType()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "cli_conversation_status"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationStatus()Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    const-string v2, "owner_project_id"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "latest_project_id"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getLatestProjectId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "owner_project_absolute_path"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "owner_project_workspace_status"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectWorkSpaceStatus()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "is_pinned"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->isPinned()Ljava/lang/Boolean;
    move-result-object v4
    const/4 v5, 1
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    const/4 v5, 0
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v3, v2, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    const-string v2, "pinned_at"
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getPinnedAt()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v2, v1, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v1, "conversation"
    const/4 v2, 0
    const/4 v4, 5
    invoke-virtual v0, v1, v2, v3, v4, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String; Ljava/lang/String; Landroid/content/ContentValues; I)J
    goto/16 -100h
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    return-void 
    move-exception v8
    invoke-virtual v0, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    throw v8
    :try_start_0xe
.end method

.method public final queryAll()java.util.List
    .registers 11
    # ins_size=1
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iget-object v1, v10, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v1, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v2
    const-string v3, "conversation"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const-string v9, "is_pinned DESC, pinned_at DESC, updated_at DESC"
    invoke-virtual/range v2 ... v9, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v1
    const-string v2, "query(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/io/Closeable;
    move-object v2, v1
    check-cast v2, Landroid/database/Cursor;
    invoke-interface v2, Landroid/database/Cursor;->moveToNext()Z
    move-result v3
    if-eqz v3, +00ah
    invoke-direct v10, v2, Lcom/bytedance/trae/im/database/ConversationDao;->cursorToConversation(Landroid/database/Cursor;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -dh
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v2, 0
    invoke-static v1, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    move-exception v0
    throw v0
    move-exception v2
    invoke-static v1, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v2
    :try_start_0x21
    :try_start_0x3a
.end method

.method public final queryById(java.lang.String)com.bytedance.trae.im.service.Conversation
    .registers 12
    # ins_size=2
    const-string v0, "id"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v1
    const-string v2, "conversation"
    const/4 v3, 0
    const-string v4, "id = ?"
    const/4 v0, 1
    new-array v5, v0, [Ljava/lang/String;
    const/4 v0, 0
    aput-object v11, v5, v0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const-string v9, "1"
    invoke-virtual/range v1 ... v9, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v11
    const-string v0, "query(...)"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/io/Closeable;
    move-object v0, v11
    check-cast v0, Landroid/database/Cursor;
    invoke-interface v0, Landroid/database/Cursor;->moveToFirst()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +00ah
    invoke-direct v10, v0, Lcom/bytedance/trae/im/database/ConversationDao;->cursorToConversation(Landroid/database/Cursor;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    invoke-static v11, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v11, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v2
    move-exception v0
    throw v0
    move-exception v1
    invoke-static v11, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    :try_start_0x26
    :try_start_0x38
    :try_start_0x3f
.end method

.method public final replaceAll(java.util.List)void
    .registers 11
    # ins_size=2
    const-string v0, "conversation"
    const-string v1, "conversations"
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v9, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v1, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v1
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V
    const/4 v2, 0
    invoke-virtual v1, v0, v2, v2, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String;)I
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +0fbh
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto -12h
    new-instance v5, Landroid/content/ContentValues;
    invoke-direct v5, Landroid/content/ContentValues;-><init>()V
    const-string v6, "id"
    invoke-virtual v5, v6, v4, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "cli_conversation_id"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v4, user_id
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getUserId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "cli_id"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v4, title
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v4, workspace
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getDisplayWorkspace()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "git_uri"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getDisplayGitUri()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "mode"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v4, status
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "cli_type"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "latest_task_id"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "latest_task_status"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "latest_task_update_time"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskUpdateTime()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "created_at"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCreatedAt()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v4, updated_at
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getUpdatedAt()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "icon_type"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getIconType()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "cli_conversation_status"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationStatus()Ljava/lang/Integer;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    const-string v4, "owner_project_id"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "latest_project_id"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getLatestProjectId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "owner_project_absolute_path"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "owner_project_workspace_status"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectWorkSpaceStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "is_pinned"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->isPinned()Ljava/lang/Boolean;
    move-result-object v6
    const/4 v7, 1
    invoke-static v7, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-static v6, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    const/4 v7, 0
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-virtual v5, v4, v6, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/Integer;)V
    const-string v4, "pinned_at"
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getPinnedAt()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v4, v3, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v3, 5
    invoke-virtual v1, v0, v2, v5, v3, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String; Ljava/lang/String; Landroid/content/ContentValues; I)J
    goto/16 -0fdh
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    return-void 
    move-exception v10
    invoke-virtual v1, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    throw v10
    :try_start_0x11
.end method

.method public final updateTitle(java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=3
    const-string v0, "id"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newTitle"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/ContentValues;
    invoke-direct v0, Landroid/content/ContentValues;-><init>()V
    const-string/jumbo v1, title
    invoke-virtual v0, v1, v5, Landroid/content/ContentValues;->put(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v3, Lcom/bytedance/trae/im/database/ConversationDao;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v5, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v5
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/String;
    const/4 v2, 0
    aput-object v4, v1, v2
    const-string v4, "conversation"
    const-string v2, "id = ?"
    invoke-virtual v5, v4, v0, v2, v1, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String; Landroid/content/ContentValues; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
.end method
