# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/applog/impl/TraeNetworkClient;
.super Lcom/bytedance/article/common/network/SSNetworkClient;
.source "TraeNetworkClient.java"

.field private static final HEADER_CONTENT_TYPE:Ljava/lang/String;
.field private static final STREAM_BUFFER_SIZE:I


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/article/common/network/SSNetworkClient;-><init>()V
    return-void 
.end method

.method private static convertHeaders(java.util.Map)java.util.List
    .registers 6
    # ins_size=1
    const/4 v0, 0
    if-eqz v5, +04ah
    invoke-interface v5, Ljava/util/Map;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +42h
    new-instance v1, Ljava/util/ArrayList;
    invoke-interface v5, Ljava/util/Map;->size()I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +024h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +003h
    goto -12h
    new-instance v3, Lcom/bytedance/retrofit2/client/Header;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-direct v3, v4, v2, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -27h
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v0, v1
    return-object v0
.end method

.method private static ensureTrailingSlash(java.lang.String)java.lang.String
    .registers 3
    # ins_size=1
    if-eqz v2, +023h
    invoke-virtual v2, Ljava/lang/String;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +1bh
    const-string v0, "/"
    invoke-virtual v2, v0, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +003h
    goto +12h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private static parseUrl(java.lang.String)android.util.Pair
    .registers 6
    # ins_size=1
    invoke-static v5, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v0, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, Landroid/net/Uri;->getPort()I
    move-result v3
    if-eqz v2, +05fh
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    if-eqz v1, +00bh
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, "://"
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    if-lez v3, +00bh
    const/16 v1, 58
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->ensureTrailingSlash(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v2
    if-nez v2, +004h
    const-string v1, "/"
    invoke-virtual v0, Landroid/net/Uri;->getEncodedQuery()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01fh
    invoke-virtual v0, Ljava/lang/String;->isEmpty()Z
    move-result v2
    if-nez v2, +019h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "?"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v0, Landroid/util/Pair;
    invoke-direct v0, v5, v1, Landroid/util/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
    new-instance v0, Ljava/lang/IllegalArgumentException;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Invalid url, host is null: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-direct v0, v5, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method private static safeMsg(java.lang.Exception)java.lang.String
    .registers 2
    # ins_size=1
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    goto +9h
    invoke-virtual v1, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static shouldAddCommonParams(com.bytedance.common.utility.NetworkClient$ReqContext)boolean
    .registers 1
    # ins_size=1
    if-eqz v0, +008h
    iget-boolean v0, v0, Lcom/bytedance/common/utility/NetworkClient$ReqContext;->addCommonParams Z
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static splitContentType(java.util.Map)android.util.Pair
    .registers 7
    # ins_size=1
    const/4 v0, 0
    if-eqz v6, +057h
    invoke-interface v6, Ljava/util/Map;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +4fh
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-interface v6, Ljava/util/Map;->size()I
    move-result v2
    invoke-direct v1, v2, Ljava/util/LinkedHashMap;-><init>(I)V
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    invoke-interface v6, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v6
    move-object v2, v0
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-nez v4, +003h
    goto -14h
    const-string v5, "Content-Type"
    invoke-virtual v5, v4, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z
    move-result v5
    if-eqz v5, +009h
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    goto -23h
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v1, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -2dh
    new-instance v6, Landroid/util/Pair;
    invoke-interface v1, Ljava/util/Map;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v0, v1
    invoke-direct v6, v2, v0, Landroid/util/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v6
    new-instance v6, Landroid/util/Pair;
    invoke-direct v6, v0, v0, Landroid/util/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v6
.end method

.method private static wrapToCommonHttpException(java.lang.Exception)com.bytedance.common.utility.CommonHttpException
    .registers 4
    # ins_size=1
    instance-of v0, v3, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    if-eqz v0, +013h
    new-instance v0, Lcom/bytedance/common/utility/CommonHttpException;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    invoke-virtual v1, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;->getStatusCode()I
    move-result v1
    invoke-static v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->safeMsg(Ljava/lang/Exception;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v1, v3, Lcom/bytedance/common/utility/CommonHttpException;-><init>(I Ljava/lang/String;)V
    return-object v0
    instance-of v0, v3, Lcom/bytedance/frameworks/baselib/network/http/exception/NetworkNotAvailabeException;
    if-eqz v0, +013h
    new-instance v0, Lcom/bytedance/common/utility/CommonHttpException;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/frameworks/baselib/network/http/exception/NetworkNotAvailabeException;
    invoke-virtual v1, Lcom/bytedance/frameworks/baselib/network/http/exception/NetworkNotAvailabeException;->getCronetInternalErrorCode()I
    move-result v1
    invoke-static v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->safeMsg(Ljava/lang/Exception;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v1, v3, Lcom/bytedance/common/utility/CommonHttpException;-><init>(I Ljava/lang/String;)V
    return-object v0
    instance-of v0, v3, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    if-eqz v0, +029h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    invoke-virtual v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;->getCronetInternalErrorCode()I
    move-result v1
    const/16 v2, -555
    if-ne v1, v2, +010h
    new-instance v1, Lcom/bytedance/common/utility/CommonHttpException;
    invoke-virtual v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;->getCronetInternalErrorCode()I
    move-result v0
    invoke-static v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->safeMsg(Ljava/lang/Exception;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v1, v0, v3, Lcom/bytedance/common/utility/CommonHttpException;-><init>(I Ljava/lang/String;)V
    return-object v1
    new-instance v1, Lcom/bytedance/common/utility/CommonHttpException;
    invoke-virtual v0, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;->getStatusCode()I
    move-result v0
    invoke-static v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->safeMsg(Ljava/lang/Exception;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v1, v0, v3, Lcom/bytedance/common/utility/CommonHttpException;-><init>(I Ljava/lang/String;)V
    return-object v1
    new-instance v0, Lcom/bytedance/common/utility/CommonHttpException;
    const/4 v1, 0
    invoke-static v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->safeMsg(Ljava/lang/Exception;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v1, v3, Lcom/bytedance/common/utility/CommonHttpException;-><init>(I Ljava/lang/String;)V
    return-object v0
.end method

.method public get(java.lang.String  java.util.Map  com.bytedance.common.utility.NetworkClient$ReqContext)java.lang.String
    .registers 6
    # ins_size=4
    invoke-static v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->parseUrl(Ljava/lang/String;)Landroid/util/Pair;
    move-result-object v3
    iget-object v0, v3, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v3, v3, Landroid/util/Pair;->second Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    const-class v1, Lcom/bytedance/article/common/network/ICommonApi;
    invoke-static v0, v1, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/article/common/network/ICommonApi;
    invoke-static v4, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->convertHeaders(Ljava/util/Map;)Ljava/util/List;
    move-result-object v4
    if-eqz v5, +005h
    iget-boolean v5, v5, Lcom/bytedance/common/utility/NetworkClient$ReqContext;->addCommonParams Z
    goto +2h
    const/4 v5, 0
    const/4 v1, -1
    invoke-interface v0, v1, v3, v4, v5, Lcom/bytedance/article/common/network/ICommonApi;->get(I Ljava/lang/String; Ljava/util/List; Z)Lcom/bytedance/retrofit2/Call;
    move-result-object v3
    invoke-interface v3, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    return-object v3
    move-exception v3
    invoke-static v3, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->wrapToCommonHttpException(Ljava/lang/Exception;)Lcom/bytedance/common/utility/CommonHttpException;
    move-result-object v3
    throw v3
    :try_start_0x0
.end method

.method public post(java.lang.String  java.util.List  java.util.Map  com.bytedance.common.utility.NetworkClient$ReqContext)java.lang.String
    .registers 12
    # ins_size=5
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->parseUrl(Ljava/lang/String;)Landroid/util/Pair;
    move-result-object v8
    iget-object v0, v8, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v8, v8, Landroid/util/Pair;->second Ljava/lang/Object;
    move-object v3, v8
    check-cast v3, Ljava/lang/String;
    const-class v8, Lcom/bytedance/article/common/network/ICommonApi;
    invoke-static v0, v8, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v8
    move-object v1, v8
    check-cast v1, Lcom/bytedance/article/common/network/ICommonApi;
    new-instance v4, Ljava/util/LinkedHashMap;
    invoke-direct v4, Ljava/util/LinkedHashMap;-><init>()V
    if-eqz v9, +025h
    invoke-interface v9, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01bh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Landroid/util/Pair;
    if-eqz v9, -00ch
    iget-object v0, v9, Landroid/util/Pair;->first Ljava/lang/Object;
    if-nez v0, +003h
    goto -12h
    iget-object v0, v9, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v9, v9, Landroid/util/Pair;->second Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    invoke-interface v4, v0, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1eh
    invoke-static v10, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->convertHeaders(Ljava/util/Map;)Ljava/util/List;
    move-result-object v5
    const/4 v2, -1
    invoke-static v11, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->shouldAddCommonParams(Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Z
    move-result v6
    invoke-interface/range v1 ... v6, Lcom/bytedance/article/common/network/ICommonApi;->postForm(I Ljava/lang/String; Ljava/util/Map; Ljava/util/List; Z)Lcom/bytedance/retrofit2/Call;
    move-result-object v8
    invoke-interface v8, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    return-object v8
    move-exception v8
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->wrapToCommonHttpException(Ljava/lang/Exception;)Lcom/bytedance/common/utility/CommonHttpException;
    move-result-object v8
    throw v8
    :try_start_0x0
.end method

.method public post(java.lang.String  byte[]  java.util.Map  com.bytedance.common.utility.NetworkClient$ReqContext)java.lang.String
    .registers 12
    # ins_size=5
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->parseUrl(Ljava/lang/String;)Landroid/util/Pair;
    move-result-object v8
    iget-object v0, v8, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v8, v8, Landroid/util/Pair;->second Ljava/lang/Object;
    move-object v3, v8
    check-cast v3, Ljava/lang/String;
    const-class v8, Lcom/bytedance/article/common/network/ICommonApi;
    invoke-static v0, v8, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v8
    move-object v1, v8
    check-cast v1, Lcom/bytedance/article/common/network/ICommonApi;
    invoke-static v10, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->splitContentType(Ljava/util/Map;)Landroid/util/Pair;
    move-result-object v8
    iget-object v10, v8, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v8, v8, Landroid/util/Pair;->second Ljava/lang/Object;
    check-cast v8, Ljava/util/Map;
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->convertHeaders(Ljava/util/Map;)Ljava/util/List;
    move-result-object v5
    new-instance v4, Lcom/bytedance/retrofit2/mime/TypedByteArray;
    const/4 v8, 0
    new-array v8, v8, [Ljava/lang/String;
    invoke-direct v4, v10, v9, v8, Lcom/bytedance/retrofit2/mime/TypedByteArray;-><init>(Ljava/lang/String; [B [Ljava/lang/String;)V
    const/4 v2, -1
    invoke-static v11, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->shouldAddCommonParams(Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Z
    move-result v6
    invoke-interface/range v1 ... v6, Lcom/bytedance/article/common/network/ICommonApi;->postData(I Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedOutput; Ljava/util/List; Z)Lcom/bytedance/retrofit2/Call;
    move-result-object v8
    invoke-interface v8, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    return-object v8
    move-exception v8
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->wrapToCommonHttpException(Ljava/lang/Exception;)Lcom/bytedance/common/utility/CommonHttpException;
    move-result-object v8
    throw v8
    :try_start_0x0
.end method

.method public postDataStream(java.lang.String  byte[]  java.util.Map  com.bytedance.common.utility.NetworkClient$ReqContext)byte[]
    .registers 12
    # ins_size=5
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->parseUrl(Ljava/lang/String;)Landroid/util/Pair;
    move-result-object v8
    iget-object v0, v8, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v8, v8, Landroid/util/Pair;->second Ljava/lang/Object;
    move-object v3, v8
    check-cast v3, Ljava/lang/String;
    const-class v8, Lcom/bytedance/article/common/network/ICommonApi;
    invoke-static v0, v8, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsService(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v8
    move-object v1, v8
    check-cast v1, Lcom/bytedance/article/common/network/ICommonApi;
    invoke-static v10, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->splitContentType(Ljava/util/Map;)Landroid/util/Pair;
    move-result-object v8
    iget-object v10, v8, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v8, v8, Landroid/util/Pair;->second Ljava/lang/Object;
    check-cast v8, Ljava/util/Map;
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->convertHeaders(Ljava/util/Map;)Ljava/util/List;
    move-result-object v5
    new-instance v4, Lcom/bytedance/retrofit2/mime/TypedByteArray;
    const/4 v8, 0
    new-array v0, v8, [Ljava/lang/String;
    invoke-direct v4, v10, v9, v0, Lcom/bytedance/retrofit2/mime/TypedByteArray;-><init>(Ljava/lang/String; [B [Ljava/lang/String;)V
    const/4 v2, -1
    invoke-static v11, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->shouldAddCommonParams(Lcom/bytedance/common/utility/NetworkClient$ReqContext;)Z
    move-result v6
    invoke-interface/range v1 ... v6, Lcom/bytedance/article/common/network/ICommonApi;->postDataStream(I Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedOutput; Ljava/util/List; Z)Lcom/bytedance/retrofit2/Call;
    move-result-object v9
    invoke-interface v9, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v9, +005h
    new-array v8, v8, [B
    return-object v8
    invoke-interface v9, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v9
    new-instance v10, Ljava/io/ByteArrayOutputStream;
    invoke-direct v10, Ljava/io/ByteArrayOutputStream;-><init>()V
    const/16 v11, 1024
    new-array v11, v11, [B
    invoke-virtual v9, v11, Ljava/io/InputStream;->read([B)I
    move-result v0
    const/4 v1, -1
    if-eq v0, v1, +006h
    invoke-virtual v10, v11, v8, v0, Ljava/io/ByteArrayOutputStream;->write([B I I)V
    goto -ah
    invoke-virtual v10, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v8
    invoke-virtual v10, Ljava/io/ByteArrayOutputStream;->close()V
    if-eqz v9, +005h
    invoke-virtual v9, Ljava/io/InputStream;->close()V
    return-object v8
    move-exception v8
    invoke-virtual v10, Ljava/io/ByteArrayOutputStream;->close()V
    goto +5h
    move-exception v10
    invoke-virtual v8, v10, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V
    throw v8
    move-exception v8
    if-eqz v9, +00ah
    invoke-virtual v9, Ljava/io/InputStream;->close()V
    goto +5h
    move-exception v9
    invoke-virtual v8, v9, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V
    throw v8
    move-exception v8
    invoke-static v8, Lcom/bytedance/trae/applog/impl/TraeNetworkClient;->wrapToCommonHttpException(Ljava/lang/Exception;)Lcom/bytedance/common/utility/CommonHttpException;
    move-result-object v8
    throw v8
    :try_start_0x0
    :try_start_0x4a
    :try_start_0x51
    :try_start_0x62
    :try_start_0x67
    :try_start_0x6c
    :try_start_0x71
    :try_start_0x78
    :try_start_0x7d
.end method
