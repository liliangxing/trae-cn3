.class public final Lcom/bytedance/trae/conversation/extract/ExtractHelper;
.super Ljava/lang/Object;
.source "ExtractHelper.kt"


# static fields
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/extract/ExtractHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/bytedance/trae/conversation/extract/ExtractHelper;

    invoke-direct {v0}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;-><init>()V

    sput-object v0, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->INSTANCE:Lcom/bytedance/trae/conversation/extract/ExtractHelper;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final start(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 10

    invoke-virtual {p0, p1, p2, p3}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->performExtract(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private final performExtract(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 12

    move-object v0, p1

    move-object v1, p2

    move-object v2, p3

    const/4 v3, 0x0

    :try_start_0
    sget-object v4, Lcom/bytedance/trae/TraeApplication;->Companion:Lcom/bytedance/trae/TraeApplication$Companion;

    invoke-virtual {v4}, Lcom/bytedance/trae/TraeApplication$Companion;->getInst()Lcom/bytedance/trae/TraeApplication;

    move-result-object v4

    check-cast v4, Landroid/content/Context;

    invoke-static {}, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;

    move-result-object v5

    const-class v6, Lcom/bytedance/trae/login/api/ILoginService;

    invoke-virtual {v5, v6}, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bytedance/trae/login/api/ILoginService;

    if-eqz v5, :cond_done

    invoke-interface {v5}, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;

    move-result-object v5

    if-eqz v5, :cond_done

    invoke-virtual {v5}, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_done

    sget-object v6, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE:Lcom/bytedance/trae/im/database/DatabaseManager;

    invoke-virtual {v6, v4, v5}, Lcom/bytedance/trae/im/database/DatabaseManager;->getDatabase(Landroid/content/Context;Ljava/lang/String;)Lcom/bytedance/trae/im/database/DatabaseOpenHelper;

    move-result-object v4

    new-instance v5, Lcom/bytedance/trae/im/database/ChatMessageDao;

    invoke-direct {v5, v4}, Lcom/bytedance/trae/im/database/ChatMessageDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V

    invoke-virtual {v5, v1}, Lcom/bytedance/trae/im/database/ChatMessageDao;->queryByTaskId(Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_done

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_done

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "# "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, "\n\n---\n\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_loop
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :goto_done

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/bytedance/trae/im/database/ChatMessageEntity;

    invoke-virtual {v6}, Lcom/bytedance/trae/im/database/ChatMessageEntity;->getMessageType()Ljava/lang/String;

    move-result-object v7

    const-string v8, "user"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :goto_loop

    const-string v7, "**[User]**: "

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Lcom/bytedance/trae/im/database/ChatMessageEntity;->getContent()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, "\n\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_loop

    :goto_done
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    new-instance v6, Ljava/io/File;

    invoke-virtual {v5}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v7

    const-string v8, "extracted"

    invoke-direct {v6, v7, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-nez v7, :cond_mkdir

    invoke-virtual {v6}, Ljava/io/File;->mkdirs()Z

    :cond_mkdir
    new-instance v7, Ljava/io/File;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v9, ".md"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v6, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    new-instance v8, Ljava/io/FileWriter;

    invoke-direct {v8, v7}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    invoke-virtual {v8, v4}, Ljava/io/FileWriter;->write(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/io/FileWriter;->close()V

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"><style>body{font-family:sans-serif;padding:16px;line-height:1.6;color:#333;max-width:800px;margin:0 auto}h1{border-bottom:1px solid #eee;padding-bottom:8px}blockquote{border-left:4px solid #ddd;margin:0;padding:8px 16px;color:#666;background:#f9f9f9}hr{border:none;border-top:1px solid #eee;margin:16px 0}b{color:#0066cc}</style><script src=\"https://cdn.jsdelivr.net/npm/marked/marked.min.js\"></script></head><body><textarea id=\"md\" style=\"display:none\">"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v9, "</textarea><div id=\"content\"></div><script>var md=document.getElementById('md').value;document.getElementById('content').innerHTML=marked.parse(md);</script></body></html>"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    new-instance v9, Ljava/io/File;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v11, ".html"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v6, v10}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    new-instance v6, Ljava/io/FileWriter;

    invoke-direct {v6, v9}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    invoke-virtual {v6, v8}, Ljava/io/FileWriter;->write(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/FileWriter;->close()V

    new-instance v6, Landroid/content/Intent;

    check-cast v0, Landroid/content/Context;

    const-class v8, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;

    invoke-direct {v6, v0, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v8, "extra_url"

    invoke-static {v9}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v9

    invoke-virtual {v9}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p1, v6}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    invoke-static {v2, v7}, Lcom/bytedance/trae/conversation/extract/GitHubPusher;->push(Ljava/lang/String;Ljava/io/File;)V

    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :cond_done

    :catch_0
    move-exception v0

    const-string v1, "ExtractHelper"

    const-string v2, "Extract failed"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_done
    return-void
.end method
