# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "DatabaseOpenHelper.kt"

.field public static final Companion:Lcom/bytedance/trae/im/database/DatabaseOpenHelper$Companion;
.field public static final DB_VERSION:I


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/database/DatabaseOpenHelper$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;->Companion Lcom/bytedance/trae/im/database/DatabaseOpenHelper$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context  java.lang.String  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v2, v3, v0, v4, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context; Ljava/lang/String; Landroid/database/sqlite/SQLiteDatabase$CursorFactory; I)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.lang.String  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    const-string v2, "im.db"
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 7
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/im/database/DatabaseOpenHelper;-><init>(Landroid/content/Context; Ljava/lang/String; I)V
    return-void 
.end method

.method public onCreate(android.database.sqlite.SQLiteDatabase)void
    .registers 3
    # ins_size=2
    const-string v0, "db"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseSchema;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseSchema;
    invoke-virtual v0, v2, Lcom/bytedance/trae/im/database/DatabaseSchema;->createAll(Landroid/database/sqlite/SQLiteDatabase;)V
    return-void 
.end method

.method public onUpgrade(android.database.sqlite.SQLiteDatabase  int  int)void
    .registers 5
    # ins_size=4
    const-string v4, "db"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/im/database/DatabaseSchema;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseSchema;
    invoke-virtual v4, v3, Lcom/bytedance/trae/im/database/DatabaseSchema;->upgradeStatementsBeforeConversationCompatibility$im_mainlandRelease(I)Ljava/util/List;
    move-result-object v4
    invoke-interface v4, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-virtual v2, v0, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    goto -fh
    const/4 v4, 7
    if-ge v3, v4, +007h
    sget-object v3, Lcom/bytedance/trae/im/database/DatabaseSchema;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseSchema;
    invoke-virtual v3, v2, Lcom/bytedance/trae/im/database/DatabaseSchema;->migrateConversationCompatibilityColumns(Landroid/database/sqlite/SQLiteDatabase;)V
    return-void 
.end method
