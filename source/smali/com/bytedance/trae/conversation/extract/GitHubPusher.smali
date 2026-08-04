# Decompiled TRAE business class
# Source DEX: classes.dex
.class public final Lcom/bytedance/trae/conversation/extract/GitHubPusher;
.super Ljava/lang/Object;
.source "GitHubPusher.kt"


# static fields
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/extract/GitHubPusher;

.field private static final MAX_RETRY_COUNT:I = 0x0A

.field private static final RETRY_INTERVAL_MS:J = 0x927c0L

.field private static final SHARED_PREFS_NAME:Ljava/lang/String; = "extract_retry_prefs"

.field private static final PREF_RETRY_PREFIX:Ljava/lang/String; = "extract_retry_count_"


# direct methods
.method static constructor <clinit>()V
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/extract/GitHubPusher;
    invoke-direct {v0}, Lcom/bytedance/trae/conversation/extract/GitHubPusher;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/extract/GitHubPusher;->INSTANCE:Lcom/bytedance/trae/conversation/extract/GitHubPusher;
    return-void
.end method

.method private constructor <init>()V
    .registers 1
    # ins_size=1
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V
    return-void
.end method


# virtual methods

.method public final pushAsync(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V
    .registers 12
    # ins_size=5
    const-string v0, "context"
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V
    const-string v0, "fileName"
    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V
    const-string v0, "file"
    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V
    const-string v0, "taskId"
    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/bytedance/trae/conversation/extract/GitHubPusher$pushAsync$1;
    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, p3, v1}, Lcom/bytedance/trae/conversation/extract/GitHubPusher$pushAsync$1;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/jvm/functions/Function2;

    const/4 v1, 0x0
    const/4 v2, 0x0
    const/4 v6, 0x0

    move-object v3, v0
    move-object v4, v1
    move-object v5, v2
    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->runBlocking$default(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public final pushWithRetry(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)V
    .registers 16
    # ins_size=5
    move-object v0, p0
    move-object v1, p1
    move-object v2, p2
    move-object v3, p3

    invoke-direct {v0, v1, v2}, Lcom/bytedance/trae/conversation/extract/GitHubPusher;->getRetryCount(Landroid/content/Context;Ljava/lang/String;)I
    move-result v4

    const/16 v5, 0x0A
    if-lt v4, v5, :cond_hit_max

    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V
    const-string v1, "GitHubPush: max retries reached for "
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual {v0}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v0

    const-string v1, "GitHubPusher"
    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    return-void

    :cond_hit_max
    invoke-static {v2, v3}, Lcom/bytedance/trae/conversation/extract/GitHubPusher;->performPush(Ljava/lang/String;Ljava/io/File;)Z
    move-result v4

    if-nez v4, :cond_success

    add-int/lit8 v4, v4, 0x1
    invoke-direct {v0, v1, v2, v4}, Lcom/bytedance/trae/conversation/extract/GitHubPusher;->setRetryCount(Landroid/content/Context;Ljava/lang/String;I)V

    move-object v0, v1
    check-cast v0, Landroid/content/Context;

    const-wide/32 v5, 0x927c0

    invoke-static {v5, v6}, Lkotlinx/coroutines/DelayKt;->delay(J;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    goto :cond_done

    :cond_success
    const/4 v0, 0x0
    invoke-direct {v0, v1, v2, v0}, Lcom/bytedance/trae/conversation/extract/GitHubPusher;->setRetryCount(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_done
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    return-object v0
.end method

.method private final performPush(Ljava/lang/String;Ljava/io/File;)Z
    .registers 20
    # ins_size=3
    const/4 v0, 0x0

    :try_start_push
    new-instance v1, Ljava/net/URL;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "https://api.github.com/repos/"
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2

    invoke-static {}, Lcom/bytedance/trae/conversation/BuildConfig;->getGITHUB_TOKEN()Ljava/lang/String;
    move-result-object v3

    const-string v4, "liliangxing"
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2

    const-string v4, "/"
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2

    const-string v4, "trae-cn2"
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2

    const-string v4, "/contents/docs/"
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2

    move-object/from16 v4, p1
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2

    const-string v4, ".md"
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;
    move-result-object v1

    if-eqz v1, :cond_null_conn

    move-object v2, v1
    check-cast v2, Ljava/net/HttpURLConnection;

    const-string v1, "PUT"
    invoke-virtual {v2, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    const-string v3, "Authorization"
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "token "
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/bytedance/trae/conversation/BuildConfig;->getGITHUB_TOKEN()Ljava/lang/String;
    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "Content-Type"
    const-string v4, "application/json"
    invoke-virtual {v2, v3, v4}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "Accept"
    const-string v4, "application/vnd.github.v3+json"
    invoke-virtual {v2, v3, v4}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v3, 0x1
    invoke-virtual {v2, v3}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    new-instance v4, Ljava/io/FileInputStream;
    move-object/from16 v5, p2
    invoke-direct {v4, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v4, Ljava/io/Closeable;

    move-object v5, v4
    check-cast v5, Ljava/io/FileInputStream;

    const/16 v6, 0x1000
    new-array v6, v6, [B

    invoke-virtual {v5, v6}, Ljava/io/FileInputStream;->read([B)I
    move-result v7

    :cond_read_loop
    const/4 v8, -0x1
    if-ne v7, v8, :cond_read_done

    invoke-static {v6, v7}, Ljava/util/Arrays;->copyOf([BI)[B
    move-result-object v5

    const/4 v6, 0x2
    invoke-static {v5, v6}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;
    move-result-object v5

    const/4 v6, 0x0
    invoke-static {v4, v6}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    new-instance v4, Lorg/json/JSONObject;
    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    const-string v6, "message"
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "Extract conversation: "
    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v8, p1
    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual {v7}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    const-string v6, "content"
    invoke-virtual {v4, v6, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v4

    new-instance v5, Ljava/io/DataOutputStream;
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;
    move-result-object v6
    invoke-direct {v5, v6}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-virtual {v5, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V
    invoke-virtual {v5}, Ljava/io/DataOutputStream;->close()V

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I
    move-result v4

    const/16 v5, 0xc8
    if-eq v4, v5, :cond_check_201
    const/16 v5, 0xca
    if-ne v4, v5, :cond_20x_success

    :cond_check_201
    const/4 v0, 0x1
    :cond_20x_success
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :cond_read_done
    :cond_null_conn
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "null cannot be cast to non-null type java.net.HttpURLConnection"
    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
    :cond_read_done

    :try_end_push
    .catch Ljava/lang/Exception; {:try_start_push .. :try_end_push} :catch_push

    goto :goto_done
    :catch_push
    move-exception v1
    const-string v2, "GitHubPusher"
    const-string v3, "Push failed"
    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_done
    return v0
.end method

.method private final getRetryCount(Landroid/content/Context;Ljava/lang/String;)I
    .registers 6
    # ins_size=3
    const-string v0, "extract_retry_prefs"

    const/4 v1, 0x0
    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    move-result-object p1

    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "extract_retry_count_"
    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object p2
    invoke-virtual {p2}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object p2

    invoke-interface {p1, p2, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    move-result p1

    return p1
.end method

.method private final setRetryCount(Landroid/content/Context;Ljava/lang/String;I)V
    .registers 7
    # ins_size=4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "extract_retry_count_"
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder()->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object p2
    invoke-virtual {p2}, Ljava/lang/StringBuilder()->toString()Ljava/lang/String;
    move-result-object p2

    const-string v0, "extract_retry_prefs"
    const/4 v1, 0x0
    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object p1

    invoke-interface {p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object p1

    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    return-void
.end method
