# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;
.super Ljava/lang/Object;
.source "MaxLengthMonitorInterceptor.kt"

.implements Lcom/bytedance/retrofit2/intercept/Interceptor;

.field public static final Companion:Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor$Companion;
.field private static final DEF_MAX_RESPONSE_LENGTH:I
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;->Companion Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getHeaderValue(java.util.List  java.lang.String)java.lang.String
    .registers 7
    # ins_size=3
    const/4 v0, 0
    if-eqz v5, +02ah
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v2, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 1
    invoke-static v2, v6, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    if-eqz v2, -016h
    goto +2h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/retrofit2/client/Header;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final monitorLog(java.lang.String  int  java.lang.String)void
    .registers 7
    # ins_size=4
    const/4 v0, 0
    if-eqz v4, +02bh
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;
    new-instance v1, Ljava/net/URI;
    invoke-direct v1, v4, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/net/URI;->getPath()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v4, v0
    check-cast v4, Ljava/lang/String;
    if-nez v4, +004h
    const-string v4, ""
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, path
    invoke-virtual v1, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "code"
    invoke-virtual v1, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v4, "content_length"
    invoke-virtual v1, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string/jumbo v5, request_too_large
    invoke-virtual v4, v5, v1, v0, v0, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x3
    :try_start_0x17
.end method

.method public intercept(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 8
    # ins_size=2
    if-eqz v7, +06ch
    invoke-interface v7, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +003h
    goto +64h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getMaxLength()I
    move-result v1
    invoke-interface v7, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v2
    if-eqz v2, +05ah
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->isSuccessful()Z
    move-result v3
    if-eqz v3, +054h
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v3
    const-string v4, "content-length"
    invoke-direct v6, v3, v4, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;->getHeaderValue(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    return-object v2
    invoke-static v3, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v4
    if-eqz v4, +034h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    if-gez v1, +03bh
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getMethod()Ljava/lang/String;
    move-result-object v1
    const-string v5, "GET"
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +02fh
    const/high16 v1, 5242880
    if-lt v4, v1, +02bh
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v5
    invoke-direct v6, v1, v5, v3, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;->monitorLog(Ljava/lang/String; I Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/bytedance/retrofit2/client/Request$Builder;->maxLength(I)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-interface v7, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v7
    return-object v7
    return-object v2
    move-exception v7
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "intercept error"
    check-cast v7, Ljava/lang/Throwable;
    const-string v3, "MaxLengthMonitor"
    invoke-virtual v0, v3, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v2
    const/4 v7, 0
    return-object v7
    :try_start_0x13
.end method
