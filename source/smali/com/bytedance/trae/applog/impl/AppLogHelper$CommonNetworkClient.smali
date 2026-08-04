# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;
.super Ljava/lang/Object;
.source "AppLogHelper.kt"

.implements Lcom/bytedance/bdinstall/INetworkClient;

.field private mClient:Lcom/bytedance/trae/applog/impl/TraeNetworkClient;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;->mClient Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
    return-void 
.end method

.method public get(java.lang.String  java.util.Map)java.lang.String
    .registers 7
    # ins_size=3
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$get$tag$1;
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$get$tag$1;-><init>()V
    check-cast v2, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v1
    check-cast v0, Ljava/util/Map;
    iget-object v2, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    iget-object v3, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-nez v6, +009h
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-direct v6, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v6, Ljava/util/Map;
    invoke-static v6, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v6
    iget-object v0, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    const-string v2, "first"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    const-string/jumbo v2, second
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v6, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v4, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;->mClient Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
    const/4 v1, 0
    invoke-virtual v0, v5, v6, v1, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->get(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v5
    move-exception v5
    instance-of v6, v5, Lcom/bytedance/common/utility/CommonHttpException;
    if-eqz v6, +013h
    new-instance v6, Lcom/bytedance/bdinstall/RangersHttpException;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/common/utility/CommonHttpException;
    invoke-virtual v0, Lcom/bytedance/common/utility/CommonHttpException;->getResponseCode()I
    move-result v0
    invoke-virtual v5, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;
    move-result-object v5
    invoke-direct v6, v0, v5, Lcom/bytedance/bdinstall/RangersHttpException;-><init>(I Ljava/lang/Throwable;)V
    throw v6
    new-instance v6, Lcom/bytedance/bdinstall/RangersHttpException;
    const/16 v0, 400
    invoke-virtual v5, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;
    move-result-object v5
    invoke-direct v6, v0, v5, Lcom/bytedance/bdinstall/RangersHttpException;-><init>(I Ljava/lang/Throwable;)V
    throw v6
    :try_start_0x0
.end method

.method public post(java.lang.String  java.util.List)java.lang.String
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;->mClient Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->post(Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "post(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public post(java.lang.String  byte[]  java.lang.String)java.lang.String
    .registers 8
    # ins_size=4
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +007h
    const-string v1, "Content-Type"
    invoke-interface v0, v1, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v7, Ljava/util/HashMap;
    invoke-direct v7, Ljava/util/HashMap;-><init>()V
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$post$tag$2;
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$post$tag$2;-><init>()V
    check-cast v2, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v1
    check-cast v7, Ljava/util/Map;
    iget-object v2, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    iget-object v3, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    invoke-interface v7, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v0, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v7
    iget-object v0, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    const-string v2, "first"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    invoke-interface v7, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v4, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;->mClient Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
    const/4 v1, 0
    invoke-virtual v0, v5, v6, v7, v1, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->post(Ljava/lang/String; [B Ljava/util/Map; Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v5
    move-exception v5
    new-instance v6, Lcom/bytedance/bdinstall/RangersHttpException;
    invoke-virtual v5, Lcom/bytedance/common/utility/CommonHttpException;->getResponseCode()I
    move-result v7
    invoke-virtual v5, Lcom/bytedance/common/utility/CommonHttpException;->getCause()Ljava/lang/Throwable;
    move-result-object v5
    invoke-direct v6, v7, v5, Lcom/bytedance/bdinstall/RangersHttpException;-><init>(I Ljava/lang/Throwable;)V
    throw v6
    :try_start_0x15
.end method

.method public post(java.lang.String  byte[]  java.util.Map)java.lang.String
    .registers 8
    # ins_size=4
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$post$tag$1;
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$post$tag$1;-><init>()V
    check-cast v2, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v1
    check-cast v0, Ljava/util/Map;
    iget-object v2, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    iget-object v3, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-nez v7, +009h
    new-instance v7, Ljava/util/LinkedHashMap;
    invoke-direct v7, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v7, Ljava/util/Map;
    invoke-static v7, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v7
    iget-object v0, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    const-string v2, "first"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    const-string/jumbo v2, second
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v4, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;->mClient Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
    const/4 v1, 0
    invoke-virtual v0, v5, v6, v7, v1, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->post(Ljava/lang/String; [B Ljava/util/Map; Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v5
    move-exception v5
    new-instance v6, Lcom/bytedance/bdinstall/RangersHttpException;
    invoke-virtual v5, Lcom/bytedance/common/utility/CommonHttpException;->getResponseCode()I
    move-result v7
    invoke-virtual v5, Lcom/bytedance/common/utility/CommonHttpException;->getCause()Ljava/lang/Throwable;
    move-result-object v5
    invoke-direct v6, v7, v5, Lcom/bytedance/bdinstall/RangersHttpException;-><init>(I Ljava/lang/Throwable;)V
    throw v6
    :try_start_0x0
.end method

.method public postStream(java.lang.String  byte[]  java.util.Map)byte[]
    .registers 8
    # ins_size=4
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$postStream$tag$1;
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient$postStream$tag$1;-><init>()V
    check-cast v2, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v1
    check-cast v0, Ljava/util/Map;
    iget-object v2, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    iget-object v3, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-nez v7, +009h
    new-instance v7, Ljava/util/LinkedHashMap;
    invoke-direct v7, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v7, Ljava/util/Map;
    invoke-static v7, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v7
    iget-object v0, v1, Landroid/util/Pair;->first Ljava/lang/Object;
    const-string v2, "first"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Landroid/util/Pair;->second Ljava/lang/Object;
    const-string/jumbo v2, second
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v4, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;->mClient Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
    const/4 v1, 0
    invoke-virtual v0, v5, v6, v7, v1, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->postDataStream(Ljava/lang/String; [B Ljava/util/Map; Lcom/bytedance/common/utility/NetworkClient$ReqContext;)[B
    move-result-object v5
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v5
    move-exception v5
    new-instance v6, Lcom/bytedance/bdinstall/RangersHttpException;
    invoke-virtual v5, Lcom/bytedance/common/utility/CommonHttpException;->getResponseCode()I
    move-result v7
    invoke-virtual v5, Lcom/bytedance/common/utility/CommonHttpException;->getCause()Ljava/lang/Throwable;
    move-result-object v5
    invoke-direct v6, v7, v5, Lcom/bytedance/bdinstall/RangersHttpException;-><init>(I Ljava/lang/Throwable;)V
    throw v6
    :try_start_0x0
.end method
