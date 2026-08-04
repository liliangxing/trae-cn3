# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;
.super Ljava/lang/Object;
.source "StsTokenManager.kt"

.field private final fallbackServiceIdProvider:Lkotlin/jvm/functions/Function0;
.field private final getStsTokenApi:Lkotlin/jvm/functions/Function2;
.field private final mutex:Lkotlinx/coroutines/sync/Mutex;
.field private final refreshPromises:Ljava/util/concurrent/ConcurrentHashMap;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field private bridge serverTimeDiffMillis:J
.field private final tokenCache:Ljava/util/concurrent/ConcurrentHashMap;


.method public constructor <init>(kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=3
    const-string v0, "getStsTokenApi"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "fallbackServiceIdProvider"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->getStsTokenApi Lkotlin/jvm/functions/Function2;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->fallbackServiceIdProvider Lkotlin/jvm/functions/Function0;
    const/4 v3, 0
    const/4 v4, 1
    invoke-static v3, v4, v3, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->tokenCache Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    const/4 v0, 0
    invoke-static v0, v4, v3, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->mutex Lkotlinx/coroutines/sync/Mutex;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +006h
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$1;
    check-cast v2, Lkotlin/jvm/functions/Function0;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;-><init>(Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static final synthetic access$fetchToken(com.bytedance.trae.conversation.imageupload.StsTokenManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->fetchToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getRefreshPromises$p(com.bytedance.trae.conversation.imageupload.StsTokenManager)java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$getTokenCache$p(com.bytedance.trae.conversation.imageupload.StsTokenManager)java.util.concurrent.ConcurrentHashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->tokenCache Ljava/util/concurrent/ConcurrentHashMap;
    return-object v0
.end method

.method public static final synthetic access$refreshTokenSync(com.bytedance.trae.conversation.imageupload.StsTokenManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshTokenSync(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final checkTokenStatus(java.lang.String)com.bytedance.trae.conversation.imageupload.TokenStatus
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->tokenCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v5, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    if-nez v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->NeedSyncRefresh Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    return-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;->getExpiredTimeIso()Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->parseIsoMillis(Ljava/lang/String;)J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v5, v0, v2
    if-gtz v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->NeedSyncRefresh Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    return-object v5
    invoke-direct v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->getCalibratedNowMillis()J
    move-result-wide v2
    sub-long/2addr v0, v2
    const-wide/32 v2, 60000
    cmp-long v5, v0, v2
    if-gez v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->NeedSyncRefresh Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    goto +dh
    const-wide/32 v2, 300000
    cmp-long v5, v0, v2
    if-gez v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->NeedAsyncRefresh Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    goto +3h
    sget-object v5, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->Valid Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    return-object v5
.end method

.method public static synthetic clearToken$default(com.bytedance.trae.conversation.imageupload.StsTokenManager  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->clearToken(Ljava/lang/String;)V
    return-void 
.end method

.method private final fetchToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=3
    instance-of v0, v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;
    invoke-direct v0, v9, v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/StsTokenManager; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v10, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v11, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v11, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->getStsTokenApi Lkotlin/jvm/functions/Function2;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$fetchToken$1;->label I
    invoke-interface v11, v10, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object v10, v9
    check-cast v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-direct v10, v0, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->formatIsoUtc(J)Ljava/lang/String;
    move-result-object v0
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;->getAccessKeyId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;->getSecretAccessKey()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;->getSessionToken()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;->getExpiredTime()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;->getCurrentTime()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;->getServiceId()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +00eh
    iget-object v11, v10, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->fallbackServiceIdProvider Lkotlin/jvm/functions/Function0;
    invoke-interface v11, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    if-nez v11, +004h
    const-string v11, ""
    move-object v7, v11
    move-object v1, v8
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;->getCurrentTimeIso()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->updateServerTimeDiff(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;->getServiceId()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v10
    if-nez v10, +003h
    return-object v8
    new-instance v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOKEN_FETCH_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v2, "Token response missing service_id"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v10
    move-exception v10
    new-instance v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOKEN_FETCH_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Token fetch failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v11, v0, v1, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    throw v11
    :try_start_0x2a
    :try_start_0x39
.end method

.method private final formatIsoUtc(long)java.lang.String
    .registers 7
    # ins_size=3
    const-string v0, "UTC"
    invoke-static v0, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;
    move-result-object v0
    new-instance v1, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v1, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-virtual v1, v0, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v1, v5, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const-string v6, "format(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method

.method private final getCalibratedNowMillis()long
    .registers 5
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->serverTimeDiffMillis J
    add-long/2addr v0, v2
    return-wide v0
.end method

.method private final isoParsers()java.util.List
    .registers 6
    # ins_size=1
    const-string v0, "UTC"
    invoke-static v0, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;
    move-result-object v0
    const/4 v1, 4
    new-array v1, v1, [Ljava/text/SimpleDateFormat;
    new-instance v2, Ljava/text/SimpleDateFormat;
    const-string/jumbo v3, yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
    sget-object v4, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v2, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-virtual v2, v0, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v3, 0
    aput-object v2, v1, v3
    new-instance v2, Ljava/text/SimpleDateFormat;
    const-string/jumbo v3, yyyy-MM-dd'T'HH:mm:ss'Z'
    sget-object v4, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v2, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-virtual v2, v0, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v0, 1
    aput-object v2, v1, v0
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd'T'HH:mm:ss.SSSXXX
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v0, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const/4 v2, 2
    aput-object v0, v1, v2
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd'T'HH:mm:ssXXX
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v0, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const/4 v2, 3
    aput-object v0, v1, v2
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final parseIsoMillis(java.lang.String)long
    .registers 6
    # ins_size=2
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    const-wide/16 v1, 0
    if-eqz v0, +003h
    return-wide v1
    invoke-direct v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->isoParsers()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/text/SimpleDateFormat;
    invoke-virtual v3, v5, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Ljava/util/Date;->getTime()J
    move-result-wide v1
    return-wide v1
    :try_start_0x2f
.end method

.method private final refreshTokenAsync(java.lang.String)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v8, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenAsync$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenAsync$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/StsTokenManager; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final refreshTokenSync(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v1, v17
    move-object/from16 v0, v18
    move-object/from16 v2, v19
    instance-of v3, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;
    if-eqz v3, +012h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;
    iget v4, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    sub-int/2addr v2, v5
    iput v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/StsTokenManager; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    const/4 v6, 4
    const/4 v7, 3
    const/4 v8, 2
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v5, +03eh
    if-eq v5, v9, +038h
    if-eq v5, v8, +024h
    if-eq v5, v7, +016h
    if-ne v5, v6, +00ch
    iget-object v0, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$0 Ljava/lang/Object;
    move-object v3, v0
    check-cast v3, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09eh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$0 Ljava/lang/Object;
    move-object v3, v0
    check-cast v3, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5eh
    move-exception v0
    goto/16 +092h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$2 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Mutex;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v8, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v0
    move-object v0, v5
    goto +2eh
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v2, v0, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/coroutines/Deferred;
    if-eqz v2, +00ch
    iput v9, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    invoke-interface v2, v3, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    return-object v2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$0 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$1 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$2 Ljava/lang/Object;
    iput v8, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    invoke-interface v2, v10, v3, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v4, +003h
    return-object v4
    move-object v8, v1
    iget-object v5, v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v5, v0, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lkotlinx/coroutines/Deferred;
    if-eqz v5, +016h
    iput-object v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$0 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$1 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$2 Ljava/lang/Object;
    iput v7, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    invoke-interface v5, v3, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v3, v2
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    goto +2eh
    iget-object v11, v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v12, 0
    const/4 v13, 0
    new-instance v5, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$2$deferred$1;
    invoke-direct v5, v8, v0, v10, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$2$deferred$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/StsTokenManager; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v14, v5
    check-cast v14, Lkotlin/jvm/functions/Function2;
    const/4 v15, 3
    const/16 v16, 0
    invoke-static/range v11 ... v16, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v5
    iget-object v7, v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v7, Ljava/util/Map;
    invoke-interface v7, v0, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$0 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$1 Ljava/lang/Object;
    iput-object v10, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->L$2 Ljava/lang/Object;
    iput v6, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$refreshTokenSync$1;->label I
    invoke-interface v5, v3, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v3, v2
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    invoke-interface v3, v10, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v2
    move-exception v0
    move-object v3, v2
    invoke-interface v3, v10, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    :try_start_0x3b
    :try_start_0x4d
    :try_start_0x93
    :try_start_0xae
    :try_start_0xb1
    :try_start_0xdc
.end method

.method private final updateServerTimeDiff(java.lang.String)void
    .registers 6
    # ins_size=2
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->parseIsoMillis(Ljava/lang/String;)J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v5, v0, v2
    if-gtz v5, +003h
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sub-long/2addr v0, v2
    iput-wide v0, v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->serverTimeDiffMillis J
    return-void 
.end method

.method public final clearToken(java.lang.String)void
    .registers 3
    # ins_size=2
    if-eqz v2, +00dh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->tokenCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->tokenCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v2, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshPromises Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v2, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    return-void 
.end method

.method public final getToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->checkTokenStatus(Ljava/lang/String;)Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +02eh
    const/4 v1, 2
    if-eq v0, v1, +017h
    const/4 v4, 3
    if-ne v0, v4, +00eh
    iget-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->tokenCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v4, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    goto +1ah
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshTokenAsync(Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->tokenCache Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    if-nez v0, +007h
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshTokenSync(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
    move-object v3, v0
    return-object v3
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->refreshTokenSync(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method
