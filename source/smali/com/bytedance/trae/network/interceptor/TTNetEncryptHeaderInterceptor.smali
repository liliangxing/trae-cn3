# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor;
.super Ljava/lang/Object;
.source "TTNetEncryptHeaderInterceptor.kt"

.implements Lcom/bytedance/retrofit2/intercept/Interceptor;

.field public static final Companion:Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor$Companion;
.field private static final X_TT_ENCRYPT_BODY:Ljava/lang/String;
.field private static final X_TT_ENCRYPT_SCENE:Ljava/lang/String;
.field private static final X_TT_GET_SVC:Ljava/lang/String;
.field private static final X_TT_RETRY_MOCK:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor;->Companion Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public intercept(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 11
    # ins_size=2
    if-eqz v10, +0d5h
    invoke-interface v10, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +0cdh
    const-class v1, Lcom/bytedance/trae/common/security/api/SecurityService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/common/security/api/SecurityService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/security/api/SecurityService;
    if-nez v1, +007h
    invoke-interface v10, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v10
    return-object v10
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Lcom/bytedance/trae/common/security/api/SecurityService;->shouldAddTTNetEncryptHeader(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +0a5h
    invoke-static Lcom/bytedance/applog/AppLog;->getUserUniqueID()Ljava/lang/String;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    if-nez v3, +003h
    goto +5h
    invoke-static Lcom/bytedance/applog/AppLog;->getDid()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v3, Lcom/bytedance/trae/common/security/api/SecurityService;->getTTNetEncryptScene(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getHeaders()Ljava/util/List;
    move-result-object v5
    const-string v6, "getHeaders(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/util/Collection;
    invoke-static v5, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v5
    new-instance v6, Lcom/bytedance/retrofit2/client/Header;
    const-string/jumbo v7, x-tt-e-b
    const-string v8, "1"
    invoke-direct v6, v7, v8, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v5, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v6, Lcom/bytedance/retrofit2/client/Header;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v7, 43
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v7, x-tt-e-k
    invoke-direct v6, v7, v2, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v5, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v1, Lcom/bytedance/trae/common/security/api/SecurityService;->forceTTNetRetry()Z
    move-result v2
    if-eqz v2, +017h
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    const-string v6, "get-svc"
    invoke-direct v2, v6, v8, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v5, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    const-string/jumbo v6, x-tt-mock-retry
    invoke-direct v2, v6, v8, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v5, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v4, v5, Lcom/bytedance/retrofit2/client/Request$Builder;->headers(Ljava/util/List;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v2
    invoke-interface v10, v2, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v10
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v0
    const-string v2, "getUrl(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v2
    const-string v4, "headers(...)"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, v0, v3, v2, Lcom/bytedance/trae/common/security/api/SecurityService;->tryMobTTNetEncryptResult(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-object v10
    invoke-interface v10, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-interface v10, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v10
    return-object v10
    const/4 v10, 0
    return-object v10
.end method
