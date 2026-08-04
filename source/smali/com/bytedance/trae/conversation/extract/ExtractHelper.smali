# Decompiled TRAE business class
# Source DEX: classes.dex
.class public final Lcom/bytedance/trae/conversation/extract/ExtractHelper;
.super Ljava/lang/Object;
.source "ExtractHelper.kt"


# static fields
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/extract/ExtractHelper;

.field private static final TAG:Ljava/lang/String; = "ExtractHelper"

.field private static final GITHUB_REPO_OWNER:Ljava/lang/String; = "liliangxing"

.field private static final GITHUB_REPO_NAME:Ljava/lang/String; = "trae-cn2"

.field private static final GITHUB_TARGET_DIR:Ljava/lang/String; = "docs"

.field private static final MAX_RETRY_COUNT:I = 0x0A

.field private static final RETRY_INTERVAL_MS:J = 0x927c0L


# direct methods
.method static constructor <clinit>()V
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/extract/ExtractHelper;
    invoke-direct {v0}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->INSTANCE:Lcom/bytedance/trae/conversation/extract/ExtractHelper;
    return-void
.end method

.method private constructor <init>()V
    .registers 1
    # ins_size=1
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V
    return-void
.end method


# virtual methods
.method public final start(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V
    .registers 9
    # ins_size=4
    const-string v0, "activity"
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V
    const-string v0, "taskId"
    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V
    const-string v0, "title"
    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, p1, p2, p3}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->performExtractAndPush(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final performExtractAndPush(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V
    .registers 8
    # ins_size=4
    invoke-direct {p0, p2}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->queryUserMessages(Ljava/lang/String;)Ljava/util/List;
    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, :cond_done

    invoke-direct {p0, p3, v0}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->buildMarkdown(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    move-result-object v0

    move-object v1, p1
    check-cast v1, Landroid/content/Context;
    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v1

    invoke-direct {p0, v1, p3, v0}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->saveMarkdownFile(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    move-result-object v1

    invoke-direct {p0, p1, v1, p3}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->openPreview(Landroid/app/Activity;Ljava/io/File;Ljava/lang/String;)V

    invoke-direct {p0, p1, p3, v1}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->scheduleGitHubPush(Landroid/app/Activity;Ljava/lang/String;Ljava/io/File;)V

    :cond_done
    return-void
.end method

.method private final queryUserMessages(Ljava/lang/String;)Ljava/util/List;
    .registers 14
    # ins_size=2
    move-object/from16 v0, p1

    new-instance v1, Ljava/util/ArrayList;
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;

    :try_start_query
    sget-object v2, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE:Lcom/bytedance/trae/im/database/DatabaseManager;

    sget-object v3, Lcom/bytedance/trae/TraeApplication;->Companion:Lcom/bytedance/trae/TraeApplication$Companion;
    invoke-virtual {v3}, Lcom/bytedance/trae/TraeApplication$Companion;->getInstance()Lcom/bytedance/trae/TraeApplication;
    move-result-object v3
    check-cast v3, Landroid/content/Context;

    const-string v4, "getInstance(...)"
    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v4, Lcom/bytedance/trae/user/UserManager;->INSTANCE:Lcom/bytedance/trae/user/UserManager;
    invoke-virtual {v4}, Lcom/bytedance/trae/user/UserManager;->getCurrentUserId()Ljava/lang/String;
    move-result-object v5

    invoke-virtual {v2, v3, v5}, Lcom/bytedance/trae/im/database/DatabaseManager;->getDatabase(Landroid/content/Context;Ljava/lang/String;)Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    move-result-object v2

    new-instance v3, Lcom/bytedance/trae/im/database/ChatMessageDao;
    invoke-direct {v3, v2}, Lcom/bytedance/trae/im/database/ChatMessageDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V

    invoke-virtual {v3, v0}, Lcom/bytedance/trae/im/database/ChatMessageDao;->queryByTaskId(Ljava/lang/String;)Ljava/util/List;
    move-result-object v0

    const-string v2, "queryByTaskId(...)"
    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/lang/Iterable;

    new-instance v2, Ljava/util/ArrayList;
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    check-cast v2, Ljava/util/Collection;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0

    :cond_loop
    :goto_iterate
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-nez v3, :cond_filter_done

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3

    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/database/ChatMessageEntity;

    invoke-virtual {v4}, Lcom/bytedance/trae/im/database/ChatMessageEntity;->getMessageType()Ljava/lang/String;
    move-result-object v4

    const-string v5, "user"
    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z
    move-result v4

    if-eqz v4, :cond_loop

    invoke-interface {v2, v3}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto :goto_iterate

    :cond_filter_done
    move-object v0, v2
    check-cast v0, Ljava/util/List;

    :try_end_query
    .catch Ljava/lang/Exception; {:try_start_query .. :try_end_query} :catch_query

    goto :catch_query

    :catch_query
    move v14, v14

    return-object v0
.end method

.method private final buildMarkdown(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    .registers 16
    # ins_size=3
    move-object/from16 v0, p2

    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "# "
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v3, p1
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "\n\n"
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "> Extracted by TRAE Android\n> Task: "
    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/database/ChatMessageEntity;
    if-eqz v4, :cond_taskid_null
    invoke-virtual {v4}, Lcom/bytedance/trae/im/database/ChatMessageEntity;->getTaskId()Ljava/lang/String;
    move-result-object v4
    goto :goto_taskid_null
    :cond_taskid_null
    const-string v4, "null"
    :goto_taskid_null
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, "\n> Messages: "
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-interface {v0}, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual {v2}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "---\n\n"
    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object v2, v0
    check-cast v2, Ljava/lang/Iterable;

    invoke-interface {v2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2

    :goto_loop
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-nez v4, :cond_loop_end

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4

    check-cast v4, Lcom/bytedance/trae/im/database/ChatMessageEntity;

    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "**[User]**: "
    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual {v4}, Lcom/bytedance/trae/im/database/ChatMessageEntity;->getContent()Ljava/lang/String;
    move-result-object v4
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual {v4}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto :goto_loop

    :cond_loop_end
    invoke-virtual {v1}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v0

    const-string v1, "StringBuilder().apply(builderAction).toString()"
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method private final saveMarkdownFile(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .registers 8
    # ins_size=4
    move-object/from16 v0, p2

    new-instance v1, Ljava/io/File;
    move-object/from16 v2, p1
    invoke-virtual {v2}, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v2
    const-string v3, "extracted"
    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z
    move-result v2
    if-nez v2, :skip_mkdir
    invoke-virtual {v1}, Ljava/io/File()->mkdirs()Z
    :skip_mkdir
    new-instance v2, Ljava/io/File;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v0, v3
    const-string v3, ".md"
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual {v0}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct {v2, v1, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    :try_start_save
    new-instance v1, Ljava/io/FileWriter;
    invoke-direct {v1, v2}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V
    check-cast v1, Ljava/io/Closeable;
    move-object v0, v1
    check-cast v0, Ljava/io/FileWriter;

    move-object/from16 v3, p3
    invoke-virtual {v0, v3}, Ljava/io/FileWriter;->write(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    const/4 v0, 0x0
    invoke-static {v1, v0}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    :try_end_save
    .catch Ljava/lang/Exception; {:try_start_save .. :try_end_save} :catch_save

    goto :goto_done
    :catch_save
    move-exception v3

    :goto_done
    return-object v2
.end method

.method private final openPreview(Landroid/app/Activity;Ljava/io/File;Ljava/lang/String;)V
    .registers 7
    # ins_size=4
    new-instance v0, Landroid/content/Intent;
    move-object v1, p1
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v1, "extra_url"
    invoke-static {p2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v2
    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const-string p2, "extra_show_more_menu"
    const/4 v1, 0x1
    invoke-virtual {v0, p2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    invoke-virtual {p1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private final scheduleGitHubPush(Landroid/app/Activity;Ljava/lang/String;Ljava/io/File;)V
    .registers 15
    # ins_size=5
    sget-object v0, Lkotlinx/coroutines/CoroutineScope:Lkotlinx/coroutines/CoroutineScope;

    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;

    new-instance v1, Lcom/bytedance/trae/conversation/extract/ExtractHelper$scheduleGitHubPush$1;

    const/4 v2, 0x0

    invoke-direct {v1, p2, p3, v2}, Lcom/bytedance/trae/conversation/extract/ExtractHelper$scheduleGitHubPush$1;-><init>(Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)V

    check-cast v1, Lkotlin/jvm/functions/Function2;

    const/4 v4, 0x1
    const/4 v5, 0x0
    const/4 v2, 0x0
    const/4 v3, 0x0

    move-object v6, v0
    move-object v7, v1
    move v8, v2
    move-object v9, v4
    move v10, v5
    invoke-static/range {v6 .. v10}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    return-void
.end method
