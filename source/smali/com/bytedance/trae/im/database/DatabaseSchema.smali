# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/DatabaseSchema;
.super Ljava/lang/Object;
.source "DatabaseSchema.kt"

.field private static final CONVERSATION_COMPATIBILITY_COLUMNS:Ljava/util/Map;
.field private static final CREATE_CONVERSATION_TABLE:Ljava/lang/String;
.field private static final CREATE_STATEMENTS:Ljava/util/List;
.field public static final DB_NAME:Ljava/lang/String;
.field private static final DROP_STATEMENTS:Ljava/util/List;
.field public static final INSTANCE:Lcom/bytedance/trae/im/database/DatabaseSchema;
.field private static final MIGRATION_1_TO_2:Ljava/util/List;
.field private static final MIGRATION_2_TO_3:Ljava/util/List;
.field private static final MIGRATION_3_TO_4:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 8
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/database/DatabaseSchema;
    invoke-direct v0, Lcom/bytedance/trae/im/database/DatabaseSchema;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseSchema;
    const/16 v0, 8
    new-array v0, v0, [Lkotlin/Pair;
    const-string v1, "cli_conversation_status"
    const-string v2, "INTEGER"
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const-string v1, "owner_project_id"
    const-string v3, "TEXT"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v4, 1
    aput-object v1, v0, v4
    const-string v1, "latest_project_id"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v5, 2
    aput-object v1, v0, v5
    const-string v1, "owner_project_absolute_path"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v6, 3
    aput-object v1, v0, v6
    const-string v1, "owner_project_name"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v7, 4
    aput-object v1, v0, v7
    const-string v1, "owner_project_workspace_status"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v7, 5
    aput-object v1, v0, v7
    const-string v1, "is_pinned"
    const-string v7, "INTEGER NOT NULL DEFAULT 0"
    invoke-static v1, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v7, 6
    aput-object v1, v0, v7
    const-string v1, "pinned_at"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v3, 7
    aput-object v1, v0, v3
    invoke-static v0, Lkotlin/collections/MapsKt;->linkedMapOf([Lkotlin/Pair;)Ljava/util/LinkedHashMap;
    move-result-object v0
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->CONVERSATION_COMPATIBILITY_COLUMNS Ljava/util/Map;
    const-string v0, "    CREATE TABLE IF NOT EXISTS conversation (
    id TEXT NOT NULL PRIMARY KEY,
    cli_conversation_id TEXT,
    user_id TEXT,
    cli_id TEXT,
    title TEXT,
    workspace TEXT,
    git_uri TEXT,
    mode TEXT,
    status TEXT,
    cli_type TEXT,
    latest_task_id TEXT,
    latest_task_status TEXT,
    latest_task_update_time TEXT,
    created_at TEXT,
    updated_at TEXT,
    icon_type TEXT,
    cli_conversation_status INTEGER,
    owner_project_id TEXT,
    latest_project_id TEXT,
    owner_project_absolute_path TEXT,
    owner_project_name TEXT,
    owner_project_workspace_status TEXT,
    is_pinned INTEGER NOT NULL DEFAULT 0,
    pinned_at TEXT,
    cached_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))
)"
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->CREATE_CONVERSATION_TABLE Ljava/lang/String;
    new-array v1, v6, [Ljava/lang/String;
    const-string v3, "    CREATE TABLE IF NOT EXISTS chat_message (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    task_id TEXT NOT NULL,
    message_id TEXT NOT NULL,
    message_type TEXT NOT NULL,
    message_index INTEGER NOT NULL,
    content TEXT NOT NULL,
    status INTEGER NOT NULL DEFAULT 0,
    created_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now')),
    updated_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now')),
    deleted_at INTEGER NOT NULL DEFAULT 0,
    revertible INTEGER NOT NULL DEFAULT 0
)"
    aput-object v3, v1, v2
    aput-object v0, v1, v4
    const-string v0, "    CREATE TABLE IF NOT EXISTS conversation_detail (
    conversation_id TEXT NOT NULL,
    message_id      TEXT NOT NULL,
    message_index   INTEGER DEFAULT 0,
    role            TEXT NOT NULL,
    content_type    TEXT NOT NULL,
    content         TEXT ,
    status          TEXT,
    created_at      INTEGER NOT NULL DEFAULT 0,
    updated_at      INTEGER NOT NULL DEFAULT (strftime('%s','now') * 1000),
    PRIMARY KEY (conversation_id, message_id)
)"
    aput-object v0, v1, v5
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/im/database/DatabaseSchema;->CREATE_STATEMENTS Ljava/util/List;
    const-string v1, "DROP TABLE IF EXISTS conversation"
    const-string v2, "DROP TABLE IF EXISTS conversation_detail"
    const-string v3, "DROP TABLE IF EXISTS chat_message"
    filled-new-array v3, v1, v2, [Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/im/database/DatabaseSchema;->DROP_STATEMENTS Ljava/util/List;
    const-string v1, "    CREATE TABLE IF NOT EXISTS conversation (
    id TEXT NOT NULL PRIMARY KEY,
    cli_conversation_id TEXT,
    user_id TEXT,
    cli_id TEXT,
    title TEXT,
    workspace TEXT,
    git_uri TEXT,
    mode TEXT,
    status TEXT,
    cli_type TEXT,
    latest_task_id TEXT,
    latest_task_status TEXT,
    latest_task_update_time TEXT,
    created_at TEXT,
    updated_at TEXT,
    cached_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))
)"
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_1_TO_2 Ljava/util/List;
    const-string v1, "ALTER TABLE conversation ADD COLUMN icon_type TEXT"
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_2_TO_3 Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_3_TO_4 Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final queryConversationColumns(android.database.sqlite.SQLiteDatabase)java.util.Set
    .registers 8
    # ins_size=2
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    const-string v1, "PRAGMA table_info(conversation)"
    const/4 v2, 0
    invoke-virtual v7, v1, v2, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String; [Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v7
    const-string v1, "rawQuery(...)"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Ljava/io/Closeable;
    move-object v1, v7
    check-cast v1, Landroid/database/Cursor;
    const-string v3, "name"
    invoke-interface v1, v3, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v3
    if-ltz v3, +015h
    invoke-interface v1, Landroid/database/Cursor;->moveToNext()Z
    move-result v4
    if-eqz v4, +00fh
    invoke-interface v1, v3, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v5, "getString(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v4, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    goto -14h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v7, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    move-exception v0
    throw v0
    move-exception v1
    invoke-static v7, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    :try_start_0x15
    :try_start_0x3a
.end method

.method public final createAll(android.database.sqlite.SQLiteDatabase)void
    .registers 4
    # ins_size=2
    const-string v0, "db"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->CREATE_STATEMENTS Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v3, v1, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    goto -fh
    return-void 
.end method

.method public final dropAll(android.database.sqlite.SQLiteDatabase)void
    .registers 4
    # ins_size=2
    const-string v0, "db"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->DROP_STATEMENTS Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v3, v1, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    goto -fh
    return-void 
.end method

.method public final getCREATE_CONVERSATION_TABLE()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->CREATE_CONVERSATION_TABLE Ljava/lang/String;
    return-object v0
.end method

.method public final getMIGRATION_1_TO_2()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_1_TO_2 Ljava/util/List;
    return-object v0
.end method

.method public final getMIGRATION_2_TO_3()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_2_TO_3 Ljava/util/List;
    return-object v0
.end method

.method public final getMIGRATION_3_TO_4()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_3_TO_4 Ljava/util/List;
    return-object v0
.end method

.method public final migrateConversationCompatibilityColumns(android.database.sqlite.SQLiteDatabase)void
    .registers 7
    # ins_size=2
    const-string v0, "db"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/im/database/DatabaseSchema;->queryConversationColumns(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/Set;
    move-result-object v0
    invoke-virtual v5, v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->missingConversationCompatibilityColumns$im_mainlandRelease(Ljava/util/Set;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +02dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/im/database/DatabaseSchema;->CONVERSATION_COMPATIBILITY_COLUMNS Ljava/util/Map;
    invoke-static v2, v1, Lkotlin/collections/MapsKt;->getValue(Ljava/util/Map; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "ALTER TABLE conversation ADD COLUMN "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 32
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v1, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    goto -30h
    return-void 
.end method

.method public final missingConversationCompatibilityColumns$im_mainlandRelease(java.util.Set)java.util.List
    .registers 6
    # ins_size=2
    const-string v0, "existingColumns"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->CONVERSATION_COMPATIBILITY_COLUMNS Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->keySet()Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/String;
    invoke-interface v5, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, -011h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public final upgradeStatementsBeforeConversationCompatibility$im_mainlandRelease(int)java.util.List
    .registers 5
    # ins_size=2
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    const/4 v1, 2
    if-ge v4, v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    sget-object v2, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_1_TO_2 Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    const/4 v1, 3
    if-ge v4, v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    sget-object v2, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_2_TO_3 Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    const/4 v1, 4
    if-ge v4, v1, +00ch
    move-object v4, v0
    check-cast v4, Ljava/util/Collection;
    sget-object v1, Lcom/bytedance/trae/im/database/DatabaseSchema;->MIGRATION_3_TO_4 Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v4, v1, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    return-object v0
.end method
