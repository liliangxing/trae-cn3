# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;
.super Ljava/lang/Object;
.source "AnnieXInitializer.kt"

.implements Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;

.field private final prefs$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$KWatEw70PUxQO2y_JVA9zH5TTJ8()android.content.SharedPreferences
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->prefs_delegate$lambda$0()Landroid/content/SharedPreferences;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->prefs$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getPrefs(com.bytedance.trae.anniex.AnnieXInitializer$initAnnieX$1)android.content.SharedPreferences
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->getPrefs()Landroid/content/SharedPreferences;
    move-result-object v0
    return-object v0
.end method

.method private final getPrefs()android.content.SharedPreferences
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->prefs$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/content/SharedPreferences;
    return-object v0
.end method

.method private static final prefs_delegate$lambda$0()android.content.SharedPreferences
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string v1, "bdx_bridge_permission"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    return-object v0
.end method

.method public doPost(java.lang.String  java.util.Map  java.lang.String  byte[])java.lang.String
    .registers 8
    # ins_size=5
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const/4 v2, 0
    if-eqz v0, +003h
    return-object v2
    new-instance v0, Ljava/net/URL;
    invoke-direct v0, v4, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;
    move-result-object v4
    const-string v0, "null cannot be cast to non-null type java.net.HttpURLConnection"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/net/HttpURLConnection;
    const-string v0, "POST"
    invoke-virtual v4, v0, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/net/HttpURLConnection;->setDoOutput(Z)V
    const/16 v0, 10000
    invoke-virtual v4, v0, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V
    invoke-virtual v4, v0, Ljava/net/HttpURLConnection;->setReadTimeout(I)V
    if-eqz v5, +02ah
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01ch
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-eqz v1, -018h
    if-eqz v0, -01ah
    invoke-virtual v4, v1, v0, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String; Ljava/lang/String;)V
    goto -1fh
    if-eqz v6, +007h
    const-string v5, "Content-Type"
    invoke-virtual v4, v5, v6, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v7, +01bh
    invoke-virtual v4, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;
    move-result-object v5
    check-cast v5, Ljava/io/Closeable;
    move-object v6, v5
    check-cast v6, Ljava/io/OutputStream;
    invoke-virtual v6, v7, Ljava/io/OutputStream;->write([B)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v5, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +8h
    move-exception v4
    throw v4
    move-exception v6
    invoke-static v5, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v6
    invoke-virtual v4, Ljava/net/HttpURLConnection;->getResponseCode()I
    move-result v5
    const/16 v6, 200
    if-ne v5, v6, +03ah
    invoke-virtual v4, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    move-result-object v4
    const-string v5, "getInputStream(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v5, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v6, Ljava/io/InputStreamReader;
    invoke-direct v6, v4, v5, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v6, Ljava/io/Reader;
    instance-of v4, v6, Ljava/io/BufferedReader;
    if-eqz v4, +005h
    check-cast v6, Ljava/io/BufferedReader;
    goto +9h
    new-instance v4, Ljava/io/BufferedReader;
    const/16 v5, 8192
    invoke-direct v4, v6, v5, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v6, v4
    check-cast v6, Ljava/io/Closeable;
    move-object v4, v6
    check-cast v4, Ljava/io/BufferedReader;
    check-cast v4, Ljava/io/Reader;
    invoke-static v4, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v4
    invoke-static v6, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    move-object v2, v4
    goto +8h
    move-exception v4
    throw v4
    move-exception v5
    invoke-static v6, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v5
    return-object v2
    :try_start_0x14
    :try_start_0x6d
    :try_start_0x75
    :try_start_0x7a
    :try_start_0x7c
    :try_start_0xab
    :try_start_0xb4
    :try_start_0xba
    :try_start_0xbc
.end method

.method public doRequestRemoteConfigAsync(java.lang.Runnable)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, runnable
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    invoke-interface v0, v2, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public provideAppId()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    return v0
.end method

.method public provideAppVersion()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public provideBuiltInPermissionConfig()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, ""
    return-object v0
.end method

.method public provideCacheConfigPermissionCapacity()int
    .registers 2
    # ins_size=1
    const/16 v0, 50
    return v0
.end method

.method public provideDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public provideGeckoAccessKey()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "2373bbcf94c1b893dad48961d0a2d086"
    return-object v0
.end method

.method public provideLocalStorage()com.bytedance.sdk.xbridge.cn.auth.ILocalStorage
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;-><init>(Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;)V
    check-cast v0, Lcom/bytedance/sdk/xbridge/cn/auth/ILocalStorage;
    return-object v0
.end method

.method public provideNamespaces()java.util.List
    .registers 2
    # ins_size=1
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public provideRemoteConfigUrl()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "https://gecko.snssdk.com/gecko/v2/jsb_permission"
    return-object v0
.end method

.method public provideWorkerExecutor()java.util.concurrent.Executor
    .registers 3
    # ins_size=1
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    const-string v1, "newSingleThreadExecutor(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/util/concurrent/Executor;
    return-object v0
.end method
