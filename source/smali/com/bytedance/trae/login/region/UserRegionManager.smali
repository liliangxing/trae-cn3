# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/region/UserRegionManager;
.super Ljava/lang/Object;
.source "UserRegionManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/region/UserRegionManager;
.field private static final TAG:Ljava/lang/String;
.field private static bridge coldStartDone:Z
.field private static final exceptionHandler:Lkotlinx/coroutines/CoroutineExceptionHandler;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$9h7hI1ucq-zaj_fjrxyQMuKiREM()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/region/UserRegionManager;->registerLifecycle$lambda$1()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-direct v0, Lcom/bytedance/trae/login/region/UserRegionManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/login/region/UserRegionManager$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/region/UserRegionManager$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    sput-object v1, Lcom/bytedance/trae/login/region/UserRegionManager;->exceptionHandler Lkotlinx/coroutines/CoroutineExceptionHandler;
    const/4 v0, 0
    const/4 v2, 1
    invoke-static v0, v2, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v2, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/region/UserRegionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$doFetchUserRegion(com.bytedance.trae.login.region.UserRegionManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/region/UserRegionManager;->doFetchUserRegion(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$doPerformCheckLogin(com.bytedance.trae.login.region.UserRegionManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/region/UserRegionManager;->doPerformCheckLogin(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getColdStartDone$p()boolean
    .registers 1
    # ins_size=0
    sget-boolean v0, Lcom/bytedance/trae/login/region/UserRegionManager;->coldStartDone Z
    return v0
.end method

.method public static final synthetic access$performCheckLoginOnWarmLaunch(com.bytedance.trae.login.region.UserRegionManager)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/region/UserRegionManager;->performCheckLoginOnWarmLaunch()V
    return-void 
.end method

.method public static final synthetic access$setColdStartDone$p(boolean)void
    .registers 1
    # ins_size=1
    sput-boolean v0, Lcom/bytedance/trae/login/region/UserRegionManager;->coldStartDone Z
    return-void 
.end method

.method private final doFetchUserRegion(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;
    iget v1, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;-><init>(Lcom/bytedance/trae/login/region/UserRegionManager; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->label I
    const-string v3, "UserRegionManager"
    const/4 v4, 1
    if-eqz v2, +014h
    if-ne v2, v4, +00ah
    iget-object v6, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ch
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v7
    if-eqz v7, +00ch
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v7, "doFetchUserRegion: bytecloud login, skip"
    invoke-virtual v6, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    sget-object v7, Lcom/bytedance/trae/login/user/UserInfoFetcher;->INSTANCE Lcom/bytedance/trae/login/user/UserInfoFetcher;
    iput-object v5, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doFetchUserRegion$1;->label I
    invoke-virtual v7, v6, v0, Lcom/bytedance/trae/login/user/UserInfoFetcher;->doFetch(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v6, v5
    check-cast v7, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    if-eqz v7, +00dh
    invoke-virtual v7, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->getResult()Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    move-result-object v7
    if-nez v7, +003h
    goto +5h
    invoke-virtual v6, v7, Lcom/bytedance/trae/login/region/UserRegionManager;->applyRegionFromUserInfo(Lcom/bytedance/trae/login/user/TraeUserInfoResult;)V
    goto +1dh
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    move-exception v6
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "doFetchUserRegion exception: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    :try_start_0x2c
    :try_start_0x4d
.end method

.method private final doPerformCheckLogin(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v1, v17
    move-object/from16 v0, v19
    const-string v2, "doPerformCheckLogin: MigrateToSG=false, uploadRegion="
    instance-of v3, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;
    if-eqz v3, +012h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;
    iget v4, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v0, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->label I
    sub-int/2addr v0, v5
    iput v0, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;
    invoke-direct v3, v1, v0, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;-><init>(Lcom/bytedance/trae/login/region/UserRegionManager; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->label I
    const/4 v6, 1
    const-string v7, "UserRegionManager"
    if-eqz v5, +014h
    if-ne v5, v6, +00ah
    iget-object v3, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4ch
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v12
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    move-object v13, v0
    check-cast v13, Ljava/util/Map;
    const-string/jumbo v0, x-ide-token
    move-object/from16 v5, v18
    invoke-interface v13, v0, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v8, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v9, trae_region
    const-class v10, Lcom/bytedance/trae/login/region/CheckLoginApi;
    const/4 v11, 0
    const/4 v14, 0
    const/16 v15, 36
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/region/CheckLoginApi;
    new-instance v5, Lcom/bytedance/trae/login/region/CheckLoginRequest;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 7
    const/4 v13, 0
    move-object v8, v5
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/login/region/CheckLoginRequest;-><init>(Ljava/lang/String; Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->L$0 Ljava/lang/Object;
    iput v6, v3, Lcom/bytedance/trae/login/region/UserRegionManager$doPerformCheckLogin$1;->label I
    invoke-interface v0, v5, v3, Lcom/bytedance/trae/login/region/CheckLoginApi;->checkLogin(Lcom/bytedance/trae/login/region/CheckLoginRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v3, v1
    check-cast v0, Lcom/bytedance/retrofit2/SsResponse;
    if-eqz v0, +07bh
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    goto +71h
    const-class v3, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    check-cast v3, Ljava/lang/reflect/Type;
    new-array v4, v6, [Ljava/lang/reflect/Type;
    const-class v5, Lcom/bytedance/trae/login/region/CheckLoginResult;
    const/4 v8, 0
    aput-object v5, v4, v8
    invoke-static v3, v4, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v3
    invoke-virtual v3, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v4, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v4
    invoke-virtual v4, v0, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResult()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/region/CheckLoginResult;
    goto +2h
    const/4 v0, 0
    if-nez v0, +00ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "doPerformCheckLogin: result is null"
    invoke-virtual v0, v7, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/region/CheckLoginResult;->getMigrateToSG()Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +011h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    const-string v2, "SG"
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUploadRegion(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "doPerformCheckLogin: MigrateToSG=true, uploadRegion set to SG"
    invoke-virtual v0, v7, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +44h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUserRegion()Ljava/lang/String;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUploadRegion(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v7, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +26h
    check-cast v3, Lcom/bytedance/trae/login/region/UserRegionManager;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "doPerformCheckLogin: response body is null"
    invoke-virtual v0, v7, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "doPerformCheckLogin exception: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v7, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x32
    :try_start_0x41
.end method

.method private final performCheckLoginOnWarmLaunch()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/login/region/UserRegionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/login/region/UserRegionManager$performCheckLoginOnWarmLaunch$1;
    const/4 v5, 0
    invoke-direct v1, v0, v5, Lcom/bytedance/trae/login/region/UserRegionManager$performCheckLoginOnWarmLaunch$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final registerLifecycle$lambda$1()void
    .registers 2
    # ins_size=0
    sget-object v0, Landroidx/lifecycle/ProcessLifecycleOwner;->Companion Landroidx/lifecycle/ProcessLifecycleOwner$Companion;
    invoke-virtual v0, Landroidx/lifecycle/ProcessLifecycleOwner$Companion;->get()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-interface v0, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/region/UserRegionManager$registerLifecycle$1$1;
    invoke-direct v1, Lcom/bytedance/trae/login/region/UserRegionManager$registerLifecycle$1$1;-><init>()V
    check-cast v1, Landroidx/lifecycle/LifecycleObserver;
    invoke-virtual v0, v1, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V
    return-void 
.end method

.method public final applyRegionFromUserInfo(com.bytedance.trae.login.user.TraeUserInfoResult)void
    .registers 9
    # ins_size=2
    const-string/jumbo v0, userInfo
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getStoreCountry()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    move v1, v2
    const-string v3, "UserRegionManager"
    if-nez v1, +04dh
    sget-object v1, Lcom/bytedance/trae/login/region/UserRegionMapper;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionMapper;
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/region/UserRegionMapper;->regionForStoreCountry(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserRegion(Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUploadRegion(Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "applyRegionFromUserInfo: storeCountry="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v5, ", region="
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getMigrateToSG()Ljava/lang/Boolean;
    move-result-object v8
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +018h
    sget-object v8, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    const-string v0, "SG"
    invoke-virtual v8, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUploadRegion(Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "applyRegionFromUserInfo: MigrateToSG=true, uploadRegion overridden to SG"
    invoke-virtual v8, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +8h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "applyRegionFromUserInfo: storeCountry is empty"
    invoke-virtual v8, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final performCheckLoginSync(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/region/UserRegionManager;->doPerformCheckLogin(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    if-ne v1, v2, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final refreshRegion()void
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "UserRegionManager"
    const-string/jumbo v2, refreshRegion: not logged in, skip
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/login/region/UserRegionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/login/region/UserRegionManager$refreshRegion$1;
    const/4 v2, 0
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/login/region/UserRegionManager$refreshRegion$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final registerLifecycle()void
    .registers 3
    # ins_size=1
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v1, Lcom/bytedance/trae/login/region/UserRegionManager$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/login/region/UserRegionManager$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method
