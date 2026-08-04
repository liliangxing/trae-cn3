# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/interceptor/AccountInterceptor;
.super Ljava/lang/Object;
.source "AccountInterceptor.kt"

.implements Lcom/bytedance/retrofit2/intercept/Interceptor;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public intercept(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 6
    # ins_size=2
    if-eqz v5, +038h
    invoke-interface v5, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +003h
    goto +30h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v1
    new-instance v2, Lcom/bytedance/frameworks/baselib/network/http/util/UrlBuilder;
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/frameworks/baselib/network/http/util/UrlBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getHeaders()Ljava/util/List;
    move-result-object v0
    const-string v3, "getHeaders(...)"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/frameworks/baselib/network/http/util/UrlBuilder;->build()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/retrofit2/client/Request$Builder;->url(Ljava/lang/String;)Lcom/bytedance/retrofit2/client/Request$Builder;
    invoke-virtual v1, v0, Lcom/bytedance/retrofit2/client/Request$Builder;->headers(Ljava/util/List;)Lcom/bytedance/retrofit2/client/Request$Builder;
    invoke-virtual v1, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-interface v5, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v5
    return-object v5
    const/4 v5, 0
    return-object v5
.end method
