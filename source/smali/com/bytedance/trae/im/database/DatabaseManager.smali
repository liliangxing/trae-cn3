# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/DatabaseManager;
.super Ljava/lang/Object;
.source "DatabaseManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/im/database/DatabaseManager;
.field private static bridge currentUserId:Ljava/lang/String;
.field private static bridge dbHelper:Lcom/bytedance/trae/im/database/DatabaseOpenHelper;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/database/DatabaseManager;
    invoke-direct v0, Lcom/bytedance/trae/im/database/DatabaseManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final synchronized getDatabase(android.content.Context  java.lang.String)com.bytedance.trae.im.database.DatabaseOpenHelper
    .registers 9
    # ins_size=3
    const-string v0, "im_"
    monitor-enter v6
    const-string v1, "context"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, userId
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/database/DatabaseManager;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    sget-object v2, Lcom/bytedance/trae/im/database/DatabaseManager;->currentUserId Ljava/lang/String;
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    if-eqz v1, +004h
    monitor-exit v6
    return-object v1
    sget-object v1, Lcom/bytedance/trae/im/database/DatabaseManager;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->close()V
    sput-object v8, Lcom/bytedance/trae/im/database/DatabaseManager;->currentUserId Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v0, ".db"
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    new-instance v8, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    invoke-virtual v7, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    const-string v7, "getApplicationContext(...)"
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;-><init>(Landroid/content/Context; Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v8, Lcom/bytedance/trae/im/database/DatabaseManager;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    monitor-exit v6
    return-object v8
    move-exception v7
    monitor-exit v6
    throw v7
    :try_start_0x3
    :try_start_0x1c
.end method

.method public final synchronized onUserLogout()void
    .registers 2
    # ins_size=1
    monitor-enter v1
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->close()V
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->currentUserId Ljava/lang/String;
    monitor-exit v1
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x1
.end method
