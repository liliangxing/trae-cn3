# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$network$1;
.super Ljava/lang/Object;
.source "ZlinkSetup.kt"

.implements Lcom/bytedance/ug/sdk/deeplink/interfaces/INetwork;


.method public static synthetic $r8$lambda$DBy3cWMVhyZ09oczWBcRtlR5gHU(java.lang.String  com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$network$1;->fetchScheme$lambda$0(Ljava/lang/String; Lcom/bytedance/ug/sdk/deeplink/callback/CallBackForFetchScheme; Ljava/lang/String;)V
    return-void 
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final fetchScheme$lambda$0(java.lang.String  com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme  java.lang.String)void
    .registers 5
    # ins_size=3
    const-class v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;
    invoke-static v2, v0, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;
    if-nez v0, +011h
    if-eqz v3, +00eh
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "TTNet not initialized"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Throwable;
    invoke-interface v3, v4, Lcom/bytedance/ug/sdk/deeplink/callback/CallBackForFetchScheme;->onFailure(Ljava/lang/Throwable;)V
    return-void 
    const/4 v1, 0
    invoke-interface v0, v4, v1, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;->get(Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/retrofit2/Call;
    move-result-object v4
    invoke-interface v4, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-nez v4, +004h
    const-string v4, ""
    if-eqz v3, +024h
    const/16 v0, 200
    invoke-interface v3, v0, v4, Lcom/bytedance/ug/sdk/deeplink/callback/CallBackForFetchScheme;->onSuccess(I Ljava/lang/String;)V
    goto +1dh
    move-exception v4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "fetchScheme failed, baseUrl="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v4, Ljava/lang/Throwable;
    const-string v0, "ZlinkSetup"
    invoke-static v0, v2, v4, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    if-eqz v3, +005h
    invoke-interface v3, v4, Lcom/bytedance/ug/sdk/deeplink/callback/CallBackForFetchScheme;->onFailure(Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method public fetchScheme(java.lang.String  java.lang.String  int  com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme)void
    .registers 7
    # ins_size=5
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v0
    goto +2h
    move v5, v1
    if-nez v5, +01eh
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +008h
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    move v0, v1
    if-eqz v0, +003h
    goto +eh
    invoke-static Lcom/bytedance/trae/home/zlink/ZlinkSetup;->access$getFetchExecutor$p()Ljava/util/concurrent/ExecutorService;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$network$1$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, v6, v4, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$network$1$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Lcom/bytedance/ug/sdk/deeplink/callback/CallBackForFetchScheme; Ljava/lang/String;)V
    invoke-interface v5, v0, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
    if-eqz v6, +00eh
    new-instance v3, Ljava/lang/IllegalArgumentException;
    const-string v4, "empty url"
    invoke-direct v3, v4, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Throwable;
    invoke-interface v6, v3, Lcom/bytedance/ug/sdk/deeplink/callback/CallBackForFetchScheme;->onFailure(Ljava/lang/Throwable;)V
    return-void 
.end method

.method public get(java.lang.String  java.util.Map  boolean  long)java.lang.String
    .registers 7
    # ins_size=6
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    const/4 v4, 0
    goto +2h
    const/4 v4, 1
    const-string v5, ""
    if-eqz v4, +003h
    return-object v5
    sget-object v4, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkSetup;
    invoke-static v4, v2, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->access$parseUrl(Lcom/bytedance/trae/home/zlink/ZlinkSetup; Ljava/lang/String;)Lkotlin/Pair;
    move-result-object v4
    invoke-virtual v4, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-virtual v4, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    const-class v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;
    invoke-static v6, v0, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;
    if-nez v6, +003h
    return-object v5
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkSetup;
    invoke-static v0, v3, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->access$toHeaderList(Lcom/bytedance/trae/home/zlink/ZlinkSetup; Ljava/util/Map;)Ljava/util/List;
    move-result-object v3
    invoke-interface v6, v4, v3, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;->get(Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/retrofit2/Call;
    move-result-object v3
    invoke-interface v3, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +003h
    goto +1ah
    move-object v5, v3
    goto +18h
    move-exception v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v6, "INetwork.get failed, url="
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v3, Ljava/lang/Throwable;
    const-string v4, "ZlinkSetup"
    invoke-static v4, v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v5
    :try_start_0x14
.end method

.method public post(java.lang.String  java.util.Map  byte[]  long  boolean  java.lang.String  boolean)java.lang.String
    .registers 10
    # ins_size=9
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v6
    goto +2h
    const/4 v5, 1
    const-string v7, ""
    if-eqz v5, +003h
    return-object v7
    sget-object v5, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkSetup;
    invoke-static v5, v2, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->access$parseUrl(Lcom/bytedance/trae/home/zlink/ZlinkSetup; Ljava/lang/String;)Lkotlin/Pair;
    move-result-object v5
    invoke-virtual v5, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    invoke-virtual v5, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    const-class v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;
    invoke-static v9, v0, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;
    if-nez v9, +003h
    return-object v7
    if-nez v8, +004h
    const-string v8, "application/json; charset=utf-8"
    new-instance v0, Lcom/bytedance/retrofit2/mime/TypedByteArray;
    if-nez v4, +004h
    new-array v4, v6, [B
    new-array v6, v6, [Ljava/lang/String;
    invoke-direct v0, v8, v4, v6, Lcom/bytedance/retrofit2/mime/TypedByteArray;-><init>(Ljava/lang/String; [B [Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkSetup;
    invoke-static v4, v3, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->access$toHeaderList(Lcom/bytedance/trae/home/zlink/ZlinkSetup; Ljava/util/Map;)Ljava/util/List;
    move-result-object v3
    invoke-interface v9, v5, v0, v3, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;->post(Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedByteArray; Ljava/util/List;)Lcom/bytedance/retrofit2/Call;
    move-result-object v3
    invoke-interface v3, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +003h
    goto +1ah
    move-object v7, v3
    goto +18h
    move-exception v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "INetwork.post failed, url="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v3, Ljava/lang/Throwable;
    const-string v4, "ZlinkSetup"
    invoke-static v4, v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-object v7
    :try_start_0x15
.end method
