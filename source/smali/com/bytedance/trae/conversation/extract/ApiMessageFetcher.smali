.class public Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;
.super Ljava/lang/Object;
.source "ApiMessageFetcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private baseUrl:Ljava/lang/String;

.field private conversationId:Ljava/lang/String;

.field private latch:Ljava/util/concurrent/CountDownLatch;

.field private markdown:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private token:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/CountDownLatch;)V
    .registers 6

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->conversationId:Ljava/lang/String;

    .line 31
    iput-object p2, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->title:Ljava/lang/String;

    .line 32
    iput-object p3, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->token:Ljava/lang/String;

    .line 33
    iput-object p4, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->baseUrl:Ljava/lang/String;

    .line 34
    iput-object p5, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->latch:Ljava/util/concurrent/CountDownLatch;

    .line 35
    return-void
.end method

.method private static createTrustAllSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .registers 4

    .line 167
    const/4 v0, 0x1

    :try_start_1
    new-array v0, v0, [Ljavax/net/ssl/TrustManager;

    new-instance v1, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher$1;

    invoke-direct {v1}, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher$1;-><init>()V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    .line 184
    const-string v1, "TLS"

    invoke-static {v1}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v1

    .line 185
    new-instance v2, Ljava/security/SecureRandom;

    invoke-direct {v2}, Ljava/security/SecureRandom;-><init>()V

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v0, v2}, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V

    .line 186
    invoke-virtual {v1}, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0
    :try_end_1e
    .catchall {:try_start_1 .. :try_end_1e} :catchall_1f

    return-object v0

    .line 187
    :catchall_1f
    move-exception v0

    .line 188
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    return-object v0
.end method

.method public static fetch(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 12

    .line 38
    new-instance v6, Ljava/util/concurrent/CountDownLatch;

    const/4 v0, 0x1

    invoke-direct {v6, v0}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 39
    new-instance v7, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;

    move-object v0, v7

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, v6

    invoke-direct/range {v0 .. v5}, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/CountDownLatch;)V

    .line 40
    new-instance p0, Ljava/lang/Thread;

    invoke-direct {p0, v7}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {p0}, Ljava/lang/Thread;->start()V

    .line 43
    :try_start_19
    sget-object p0, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 p1, 0x23

    invoke-virtual {v6, p1, p2, p0}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_20
    .catch Ljava/lang/InterruptedException; {:try_start_19 .. :try_end_20} :catch_26

    .line 46
    nop

    .line 48
    invoke-virtual {v7}, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->getMarkdown()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 44
    :catch_26
    move-exception p0

    .line 45
    const/4 p0, 0x0

    return-object p0
.end method


# virtual methods
.method public getMarkdown()Ljava/lang/String;
    .registers 2

    .line 52
    iget-object v0, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->markdown:Ljava/lang/String;

    return-object v0
.end method

.method public run()V
    .registers 10

    .line 57
    const-string v0, "ApiFetcher"

    .line 59
    const/4 v1, 0x0

    :try_start_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->baseUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "api/solo_hub/v1/conversations/messages/anchor?conversation_id="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->conversationId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&before_limit=10&after_limit=0&include_anchor=true"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 60
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "API-1: URL="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    new-instance v3, Ljava/net/URL;

    invoke-direct {v3, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 63
    invoke-virtual {v3}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    check-cast v2, Ljavax/net/ssl/HttpsURLConnection;

    .line 64
    invoke-static {}, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->createTrustAllSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljavax/net/ssl/HttpsURLConnection;->setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 65
    const-string v3, "GET"

    invoke-virtual {v2, v3}, Ljavax/net/ssl/HttpsURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 66
    const-string v3, "Content-Type"

    const-string v4, "application/json"

    invoke-virtual {v2, v3, v4}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    const-string v3, "X-App-Id"

    const-string v4, "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"

    invoke-virtual {v2, v3, v4}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    const-string v3, "X-App-Version-Code"

    const-string v4, "20260310"

    invoke-virtual {v2, v3, v4}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const-string v3, "x-ide-token"

    iget-object v4, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->token:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    const/16 v3, 0x7530

    invoke-virtual {v2, v3}, Ljavax/net/ssl/HttpsURLConnection;->setConnectTimeout(I)V

    .line 71
    invoke-virtual {v2, v3}, Ljavax/net/ssl/HttpsURLConnection;->setReadTimeout(I)V

    .line 73
    const-string v3, "API-2: headers set, getting response"

    invoke-static {v0, v3}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    invoke-virtual {v2}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v3

    .line 76
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "API-3: responseCode="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_94
    .catchall {:try_start_3 .. :try_end_94} :catchall_1e9

    .line 78
    const/16 v4, 0xc8

    const-string v5, " body="

    if-ne v3, v4, :cond_187

    .line 79
    :try_start_9a
    new-instance v3, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/InputStreamReader;

    invoke-virtual {v2}, Ljavax/net/ssl/HttpsURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    invoke-direct {v4, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v3, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 80
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 82
    :goto_ad
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_b7

    .line 83
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_ad

    .line 85
    :cond_b7
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 86
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 88
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "API-4: rawLen="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 91
    const-string v2, "data"

    invoke-virtual {v3, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 93
    if-nez v2, :cond_f6

    .line 94
    const-string v2, "API-ERR: data object is null"

    invoke-static {v0, v2}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    iput-object v1, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->markdown:Ljava/lang/String;

    goto/16 :goto_186

    .line 97
    :cond_f6
    const-string v3, "items"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 98
    if-nez v3, :cond_104

    .line 99
    const-string v3, "messages"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 102
    :cond_104
    if-nez v3, :cond_10f

    .line 103
    const-string v2, "API-ERR: items/messages array is null"

    invoke-static {v0, v2}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    iput-object v1, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->markdown:Ljava/lang/String;

    goto/16 :goto_186

    .line 106
    :cond_10f
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v2

    .line 107
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "API-5: arrayLen="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    if-nez v2, :cond_133

    .line 110
    const-string v2, "API-ERR: array is empty"

    invoke-static {v0, v2}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    iput-object v1, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->markdown:Ljava/lang/String;

    goto :goto_186

    .line 113
    :cond_133
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 114
    const-string v5, "# "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->title:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    const-string v5, "\n\n---\n\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 117
    const/4 v5, 0x0

    :goto_149
    if-ge v5, v2, :cond_17b

    .line 118
    invoke-virtual {v3, v5}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 119
    if-eqz v6, :cond_178

    .line 120
    const-string v7, "role"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 121
    const-string v8, "user"

    invoke-virtual {v8, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_165

    .line 122
    const-string v7, "**[User]**: "

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_16a

    .line 124
    :cond_165
    const-string v7, "**[Assistant]**: "

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 126
    :goto_16a
    const-string v7, "content"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 127
    const-string v6, "\n\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 117
    :cond_178
    add-int/lit8 v5, v5, 0x1

    goto :goto_149

    .line 131
    :cond_17b
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->markdown:Ljava/lang/String;

    .line 132
    const-string v2, "API-6: markdown built successfully"

    invoke-static {v0, v2}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    :goto_186
    goto :goto_1e8

    .line 137
    :cond_187
    invoke-virtual {v2}, Ljavax/net/ssl/HttpsURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v2
    :try_end_18b
    .catchall {:try_start_9a .. :try_end_18b} :catchall_1e9

    .line 138
    const-string v4, "API-ERR: code="

    if-eqz v2, :cond_1cc

    .line 139
    :try_start_18f
    new-instance v6, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/InputStreamReader;

    invoke-direct {v7, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v6, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 140
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 142
    :goto_19e
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1a8

    .line 143
    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_19e

    .line 145
    :cond_1a8
    invoke-virtual {v6}, Ljava/io/BufferedReader;->close()V

    .line 146
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    goto :goto_1e6

    .line 148
    :cond_1cc
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " no error stream"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    :goto_1e6
    iput-object v1, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->markdown:Ljava/lang/String;
    :try_end_1e8
    .catchall {:try_start_18f .. :try_end_1e8} :catchall_1e9

    .line 160
    :goto_1e8
    goto :goto_21d

    .line 152
    :catchall_1e9
    move-exception v2

    .line 154
    :try_start_1ea
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "API-EXCEPTION: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 155
    invoke-static {v0, v3}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    invoke-static {v0, v3, v2}, Lcom/bytedance/trae/conversation/extract/FileLogger;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_219
    .catchall {:try_start_1ea .. :try_end_219} :catchall_21a

    .line 158
    goto :goto_21b

    .line 157
    :catchall_21a
    move-exception v0

    .line 159
    :goto_21b
    iput-object v1, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->markdown:Ljava/lang/String;

    .line 162
    :goto_21d
    iget-object v0, p0, Lcom/bytedance/trae/conversation/extract/ApiMessageFetcher;->latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 163
    return-void
.end method
