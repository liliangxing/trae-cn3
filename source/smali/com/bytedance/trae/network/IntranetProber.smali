# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/IntranetProber;
.super Ljava/lang/Object;
.source "IntranetProber.kt"

.field private static final DEFAULT_TIMEOUT_MS:I
.field public static final INSTANCE:Lcom/bytedance/trae/network/IntranetProber;
.field private static final PING_URLS:Ljava/util/List;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/IntranetProber;
    invoke-direct v0, Lcom/bytedance/trae/network/IntranetProber;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/IntranetProber;->INSTANCE Lcom/bytedance/trae/network/IntranetProber;
    const-string v0, "https://icube-api.bytedance.net/trae/ping"
    const-string v1, "https://icube-api-sg.tiktok-row.net/trae/ping"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/IntranetProber;->PING_URLS Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic isReachable$default(com.bytedance.trae.network.IntranetProber  java.lang.String  int  int  java.lang.Object)boolean
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +00bh
    sget-object v1, Lcom/bytedance/trae/network/IntranetProber;->PING_URLS Ljava/util/List;
    const/4 v4, 0
    invoke-interface v1, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const/16 v2, 2000
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/IntranetProber;->isReachable(Ljava/lang/String; I)Z
    move-result v0
    return v0
.end method

.method public static synthetic isRegionalReachable$default(com.bytedance.trae.network.IntranetProber  int  int  java.lang.Object)boolean
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const/16 v1, 2000
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/IntranetProber;->isRegionalReachable(I)Z
    move-result v0
    return v0
.end method

.method public final getPING_URLS()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/IntranetProber;->PING_URLS Ljava/util/List;
    return-object v0
.end method

.method public final getRegionalPingUrl()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    sget-object v0, Lcom/bytedance/trae/network/IntranetProber;->PING_URLS Ljava/util/List;
    const/4 v1, 1
    goto +4h
    sget-object v0, Lcom/bytedance/trae/network/IntranetProber;->PING_URLS Ljava/util/List;
    const/4 v1, 0
    invoke-interface v0, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method public final isReachable(java.lang.String  int)boolean
    .registers 11
    # ins_size=3
    const-string v0, "IntranetProber"
    const-string/jumbo v1, 探测: 
    const-string/jumbo v2, 探测失败: 
    const-string/jumbo v3, 探测异常: 
    const-string/jumbo v4, url
    invoke-static v9, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 0
    new-instance v6, Ljava/net/URL;
    invoke-direct v6, v9, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;
    move-result-object v6
    const-string/jumbo v7, null cannot be cast to non-null type java.net.HttpURLConnection
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/net/HttpURLConnection;
    const-string v7, "GET"
    invoke-virtual v6, v7, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    invoke-virtual v6, v10, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V
    invoke-virtual v6, v10, Ljava/net/HttpURLConnection;->setReadTimeout(I)V
    invoke-virtual v6, v4, Ljava/net/HttpURLConnection;->setUseCaches(Z)V
    const-string v10, "Accept"
    const-string v7, "application/json"
    invoke-virtual v6, v10, v7, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Ljava/net/HttpURLConnection;->getResponseCode()I
    move-result v10
    const/16 v7, 200
    if-eq v10, v7, +022h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, " HTTP "
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v0, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Ljava/net/HttpURLConnection;->disconnect()V
    return v4
    invoke-virtual v6, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    move-result-object v10
    const-string v2, "getInputStream(...)"
    invoke-static v10, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v7, Ljava/io/InputStreamReader;
    invoke-direct v7, v10, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v7, Ljava/io/Reader;
    instance-of v10, v7, Ljava/io/BufferedReader;
    if-eqz v10, +005h
    check-cast v7, Ljava/io/BufferedReader;
    goto +9h
    new-instance v10, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v10, v7, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v7, v10
    check-cast v7, Ljava/io/Closeable;
    move-object v10, v7
    check-cast v10, Ljava/io/BufferedReader;
    check-cast v10, Ljava/io/Reader;
    invoke-static v10, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v10
    invoke-static v7, v5, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, v10, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string/jumbo v10, success
    invoke-virtual v2, v10, v4, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String; Z)Z
    move-result v10
    const-string v5, "data"
    const-string v7, ""
    invoke-virtual v2, v5, v7, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v10, +00ch
    const-string v10, "TRAE"
    invoke-static v2, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +004h
    const/4 v10, 1
    goto +2h
    move v10, v4
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, " → "
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Ljava/net/HttpURLConnection;->disconnect()V
    move v4, v10
    goto +36h
    move-exception v10
    throw v10
    move-exception v1
    invoke-static v7, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    move-exception v9
    move-object v5, v6
    goto +2dh
    move-exception v10
    move-object v5, v6
    goto +4h
    move-exception v9
    goto +28h
    move-exception v10
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const/16 v2, 32
    invoke-virtual v9, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v10, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v1, v0, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +005h
    invoke-virtual v5, Ljava/net/HttpURLConnection;->disconnect()V
    return v4
    if-eqz v5, +005h
    invoke-virtual v5, Ljava/net/HttpURLConnection;->disconnect()V
    throw v9
    :try_start_0x13
    :try_start_0x24
    :try_start_0x61
    :try_start_0x84
    :try_start_0x8d
    :try_start_0xd3
    :try_start_0xd5
    :try_start_0xe2
.end method

.method public final isRegionalReachable(int)boolean
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/network/IntranetProber;->getRegionalPingUrl()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/network/IntranetProber;->isReachable(Ljava/lang/String; I)Z
    move-result v2
    return v2
.end method
