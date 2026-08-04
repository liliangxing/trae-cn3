# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/LoginServiceImpl;
.super Ljava/lang/Object;
.source "LoginServiceImpl.kt"

.implements Lcom/bytedance/trae/login/api/ILoginService;

.field public static final Companion:Lcom/bytedance/trae/login/service/LoginServiceImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/service/LoginServiceImpl;->Companion Lcom/bytedance/trae/login/service/LoginServiceImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method public static final synthetic access$refreshBytecloudUserInfo(com.bytedance.trae.login.service.LoginServiceImpl  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl;->refreshBytecloudUserInfo(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$refreshEnterpriseUserInfo(com.bytedance.trae.login.service.LoginServiceImpl  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl;->refreshEnterpriseUserInfo(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$refreshPublicUserInfo(com.bytedance.trae.login.service.LoginServiceImpl  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl;->refreshPublicUserInfo(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$syncLocalUserInfo(com.bytedance.trae.login.service.LoginServiceImpl  java.util.Map)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl;->syncLocalUserInfo(Ljava/util/Map;)V
    return-void 
.end method

.method private final refreshBytecloudUserInfo(java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=5
    move-object/from16 v0, v26
    instance-of v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;
    iget v2, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->label I
    move-object/from16 v2, v22
    goto +8h
    new-instance v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;
    move-object/from16 v2, v22
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;-><init>(Lcom/bytedance/trae/login/service/LoginServiceImpl; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->label I
    const/4 v5, 1
    if-eqz v4, +018h
    if-ne v4, v5, +00eh
    iget-object v3, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->L$1 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/functions/Function0;
    iget-object v1, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +23h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;->INSTANCE Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;
    move-object/from16 v4, v24
    iput-object v4, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->L$0 Ljava/lang/Object;
    move-object/from16 v6, v25
    iput-object v6, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->L$1 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshBytecloudUserInfo$1;->label I
    move-object/from16 v7, v23
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;->doFetch(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v1, v4
    move-object v3, v6
    check-cast v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$BytecloudUserInfoResponse;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$BytecloudUserInfoResponse;->getResult()Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +0e3h
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getUsername()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00ah
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +2h
    const/4 v5, 0
    if-nez v5, +0d1h
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUserInfo()Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v3
    new-instance v15, Lcom/bytedance/trae/login/user/UserInfo;
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getUsername()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getUsername()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    const-string v8, ""
    if-nez v5, +00eh
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-nez v5, +004h
    move-object v9, v8
    goto +2h
    move-object v9, v5
    const/4 v10, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getEmail()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +00eh
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getEmail()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-nez v5, +004h
    move-object v11, v8
    goto +2h
    move-object v11, v5
    const/4 v12, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getOrganization()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +00eh
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getTenantId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-nez v5, +004h
    move-object v13, v8
    goto +2h
    move-object v13, v5
    const/4 v14, 0
    const/16 v16, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getRegion()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +010h
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v4, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, toUpperCase(...)
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +00dh
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    if-nez v4, +003h
    move-object v4, v8
    invoke-virtual v0, Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;->getEmployeeId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00dh
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getEmployeeId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    move-object v0, v8
    const/16 v17, 0
    const/16 v18, 2472
    const/16 v19, 0
    move-object v5, v15
    move-object v8, v9
    move-object v9, v10
    move-object v10, v11
    move-object v11, v12
    move-object v12, v13
    move-object v13, v14
    move/from16 v14, v16
    move-object v3, v15
    move-object v15, v4
    move-object/from16 v16, v0
    invoke-direct/range v5 ... v19, Lcom/bytedance/trae/login/user/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    new-instance v0, Lcom/bytedance/trae/login/api/AccountInfo;
    move-object v4, v0
    const/4 v5, 1
    const-string v6, "bytecloud"
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getUserId()Ljava/lang/String;
    move-result-object v7
    const-string v8, ""
    const/4 v9, 0
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getScreenName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getEmail()Ljava/lang/String;
    move-result-object v12
    const-string v13, ""
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getTenantId()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getProductType()I
    move-result v16
    const/16 v18, 0
    const/16 v20, 28672
    const/16 v21, 0
    invoke-direct/range v4 ... v21, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +6h
    if-eqz v3, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final refreshEnterpriseUserInfo(java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=5
    instance-of v0, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;
    iget v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;
    invoke-direct v0, v5, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;-><init>(Lcom/bytedance/trae/login/service/LoginServiceImpl; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->label I
    const-string v3, "LoginServiceImpl"
    const/4 v4, 1
    if-eqz v2, +01ah
    if-ne v2, v4, +010h
    iget-object v6, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->L$1 Ljava/lang/Object;
    move-object v8, v6
    check-cast v8, Lkotlin/jvm/functions/Function0;
    iget-object v6, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->L$0 Ljava/lang/Object;
    move-object v7, v6
    check-cast v7, Lkotlin/jvm/functions/Function1;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +33h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v9, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    invoke-virtual v9, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->hasRefreshProvider()Z
    move-result v9
    if-nez v9, +012h
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v7, refreshEnterpriseUserInfo failed: refresh provider is not registered
    invoke-virtual v6, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v8, +005h
    invoke-interface v8, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    sget-object v9, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    iput-object v7, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->L$0 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshEnterpriseUserInfo$1;->label I
    invoke-virtual v9, v6, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->refresh(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    check-cast v9, Lcom/bytedance/trae/login/api/AccountInfo;
    const/4 v6, 0
    if-eqz v9, +009h
    invoke-virtual v9, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v0
    if-ne v0, v4, +003h
    goto +2h
    move v4, v6
    if-eqz v4, +006h
    invoke-interface v7, v9, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +eh
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v7, refreshEnterpriseUserInfo failed: provider returned invalid account info
    invoke-virtual v6, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v8, +005h
    invoke-interface v8, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private final refreshPublicUserInfo(java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=5
    move-object/from16 v0, v26
    instance-of v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;
    iget v2, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->label I
    move-object/from16 v2, v22
    goto +8h
    new-instance v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;
    move-object/from16 v2, v22
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;-><init>(Lcom/bytedance/trae/login/service/LoginServiceImpl; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->label I
    const/4 v5, 1
    if-eqz v4, +018h
    if-ne v4, v5, +00eh
    iget-object v3, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->L$1 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/functions/Function0;
    iget-object v1, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +23h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/login/user/UserInfoFetcher;->INSTANCE Lcom/bytedance/trae/login/user/UserInfoFetcher;
    move-object/from16 v4, v24
    iput-object v4, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->L$0 Ljava/lang/Object;
    move-object/from16 v6, v25
    iput-object v6, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->L$1 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshPublicUserInfo$1;->label I
    move-object/from16 v7, v23
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher;->doFetch(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v1, v4
    move-object v3, v6
    check-cast v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->getResult()Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +051h
    invoke-virtual v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getUserId()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00ah
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +2h
    const/4 v5, 0
    if-nez v5, +03fh
    sget-object v3, Lcom/bytedance/trae/login/user/UserInfo;->Companion Lcom/bytedance/trae/login/user/UserInfo$Companion;
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/user/UserInfo$Companion;->from(Lcom/bytedance/trae/login/user/TraeUserInfoResult;)Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    new-instance v3, Lcom/bytedance/trae/login/api/AccountInfo;
    move-object v4, v3
    const/4 v5, 1
    const-string v6, ""
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getUserId()Ljava/lang/String;
    move-result-object v7
    const-string v8, ""
    const/4 v9, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getScreenName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getEmail()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 32256
    const/16 v21, 0
    invoke-direct/range v4 ... v21, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +6h
    if-eqz v3, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final syncLocalUserInfo(java.util.Map)void
    .registers 20
    # ins_size=2
    move-object/from16 v0, v19
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object/from16 v1, v18
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUserInfo()Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    const-string v1, "name"
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Ljava/lang/String;
    if-eqz v4, +015h
    const/4 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 4093
    const/16 v16, 0
    invoke-static/range v2 ... v16, Lcom/bytedance/trae/login/user/UserInfo;->copy$default(Lcom/bytedance/trae/login/user/UserInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v2
    move-object v3, v2
    const-string v1, "avatar"
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move-object v6, v0
    check-cast v6, Ljava/lang/String;
    if-eqz v6, +015h
    const/4 v4, 0
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 4091
    const/16 v17, 0
    invoke-static/range v3 ... v17, Lcom/bytedance/trae/login/user/UserInfo;->copy$default(Lcom/bytedance/trae/login/user/UserInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x2
.end method

.method private final updateUserProfileEnterprise(java.util.Map  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 14
    # ins_size=4
    iget-object v0, v10, Lcom/bytedance/trae/login/service/LoginServiceImpl;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;
    const/4 v8, 0
    move-object v3, v9
    move-object v4, v11
    move-object v5, v10
    move-object v6, v12
    move-object v7, v13
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;-><init>(Ljava/util/Map; Lcom/bytedance/trae/login/service/LoginServiceImpl; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    move-object v3, v9
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final updateUserProfileOversea(java.util.Map  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 15
    # ins_size=4
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    move-object v2, v0
    check-cast v2, Ljava/util/Map;
    const-string v0, "name"
    invoke-interface v12, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-eqz v1, +005h
    invoke-interface v2, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "avatar"
    invoke-interface v12, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-eqz v1, +005h
    invoke-interface v2, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v2, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v12, -1
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-interface v14, v12, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    iget-object v0, v11, Lcom/bytedance/trae/login/service/LoginServiceImpl;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;
    const/4 v7, 0
    move-object v1, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;-><init>(Ljava/util/Map; Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/util/Map; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    move-object v3, v10
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    move-object v1, v8
    move-object v2, v9
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final uploadAvatarOversea(java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    .registers 14
    # ins_size=4
    iget-object v0, v10, Lcom/bytedance/trae/login/service/LoginServiceImpl;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;
    const/4 v8, 0
    move-object v3, v9
    move-object v4, v11
    move-object v5, v13
    move-object v6, v10
    move-object v7, v12
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;-><init>(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/login/service/LoginServiceImpl; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    move-object v3, v9
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public cleanupGoogleAuth()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->INSTANCE Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
    invoke-virtual v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->onDestroy()V
    return-void 
.end method

.method public getAccountInfo()com.bytedance.trae.login.api.AccountInfo
    .registers 38
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object/from16 v0, v37
    check-cast v0, Lcom/bytedance/trae/login/service/LoginServiceImpl;
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUserInfo()Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v0
    if-nez v0, +022h
    new-instance v0, Lcom/bytedance/trae/login/api/AccountInfo;
    const/4 v2, 0
    const-string v3, ""
    const-string v4, ""
    const-string v5, ""
    const/4 v6, 0
    const-string v7, ""
    const-string v8, ""
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 32640
    const/16 v18, 0
    move-object v1, v0
    invoke-direct/range v1 ... v18, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    new-instance v1, Lcom/bytedance/trae/login/api/AccountInfo;
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    move/from16 v20, v2
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getLoginPlatform()Ljava/lang/String;
    move-result-object v21
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getUserId()Ljava/lang/String;
    move-result-object v22
    const-string v23, ""
    const/16 v24, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v25
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getScreenName()Ljava/lang/String;
    move-result-object v26
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getEmail()Ljava/lang/String;
    move-result-object v27
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v28
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getTenantId()Ljava/lang/String;
    move-result-object v29
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v30
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getProductType()I
    move-result v31
    const/16 v32, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getTenantName()Ljava/lang/String;
    move-result-object v33
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v34
    const/16 v35, 4096
    const/16 v36, 0
    move-object/from16 v19, v1
    invoke-direct/range v19 ... v36, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +022h
    new-instance v0, Lcom/bytedance/trae/login/api/AccountInfo;
    move-object v1, v0
    const/4 v2, 0
    const-string v3, ""
    const-string v4, ""
    const-string v5, ""
    const/4 v6, 0
    const-string v7, ""
    const-string v8, ""
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 32640
    const/16 v18, 0
    invoke-direct/range v1 ... v18, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    new-instance v0, Lcom/bytedance/trae/login/api/AccountInfo;
    move-object/from16 v19, v0
    const/16 v20, 0
    const-string v21, ""
    const-string v22, ""
    const-string v23, ""
    const/16 v24, 0
    const-string v25, ""
    const-string v26, ""
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 32640
    const/16 v36, 0
    invoke-direct/range v19 ... v36, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    :try_start_0x0
.end method

.method public getCloudideSession()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getCloudideSession()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getGoogleSignInIntent(android.app.Activity)android.content.Intent
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->INSTANCE Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->initIfNeeded(Landroid/app/Activity;)V
    sget-object v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->INSTANCE Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->getSignInIntent(Landroid/app/Activity;)Landroid/content/Intent;
    move-result-object v2
    return-object v2
.end method

.method public getXTToken()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public handleGoogleAuthResult(int  int  android.content.Intent)void
    .registers 5
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->INSTANCE Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->onActivityResult(I I Landroid/content/Intent;)V
    return-void 
.end method

.method public isNewUser()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v0, Lcom/bytedance/trae/login/service/AccountHelper;->isNewUser()Z
    move-result v0
    return v0
.end method

.method public isTraeLoggedIn()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public listLoginDevices(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, onSuccess
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onFail
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v7, Lcom/bytedance/trae/login/service/LoginServiceImpl;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;
    const/4 v4, 0
    invoke-direct v0, v8, v9, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public logout(boolean  com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    .registers 8
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v0, Lcom/bytedance/trae/login/service/AccountHelper;->getAccountPlatform()Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getLoginPlatform()Ljava/lang/String;
    move-result-object v1
    const-string v2, "enterprise"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const-string v2, "LoginServiceImpl"
    if-eqz v1, +016h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "logout: enterprise user, do passport logout + local cleanup"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    new-instance v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$1;
    invoke-direct v2, v6, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$1;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    check-cast v2, Lcom/bytedance/trae/login/api/IAccountCallback;
    invoke-virtual v1, v5, v0, v2, v7, Lcom/bytedance/trae/login/service/AccountHelper;->doLogoutCommon(Z Lcom/bytedance/trae/login/api/LoginPlatform; Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v1
    if-eqz v1, +016h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "logout: bytecloud user, do passport logout + local cleanup"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    new-instance v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;
    invoke-direct v2, v6, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$2;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    check-cast v2, Lcom/bytedance/trae/login/api/IAccountCallback;
    invoke-virtual v1, v5, v0, v2, v7, Lcom/bytedance/trae/login/service/AccountHelper;->doLogoutCommon(Z Lcom/bytedance/trae/login/api/LoginPlatform; Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    new-instance v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;
    invoke-direct v2, v6, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$logout$3;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    check-cast v2, Lcom/bytedance/trae/login/api/IAccountCallback;
    invoke-virtual v1, v5, v0, v2, v7, Lcom/bytedance/trae/login/service/AccountHelper;->doLogoutCommon(Z Lcom/bytedance/trae/login/api/LoginPlatform; Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method public parseGoogleSignInResult(android.content.Intent)java.util.Map
    .registers 7
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->INSTANCE Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
    invoke-virtual v0, v6, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->parseSignInResult(Landroid/content/Intent;)Lcom/bytedance/trae/login/auth/GoogleAuthInfo;
    move-result-object v6
    if-nez v6, +004h
    const/4 v6, 0
    return-object v6
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v0
    const-string/jumbo v1, platform
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getPlatform()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, platform_app_id
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getPlatformAppId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getIdToken()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00ah
    const-string v2, "access_token_secret"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getServerAuthCode()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00ah
    const-string v2, "code"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getAccessToken()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00ah
    const-string v2, "access_token"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getExpiresIn()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v1, v1, v3
    if-lez v1, +00fh
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getExpiresIn()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v1
    const-string v2, "expires_in"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v6, Lcom/bytedance/trae/login/auth/GoogleAuthInfo;->getUid()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +008h
    const-string/jumbo v1, uid
    invoke-interface v0, v1, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v0, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v6
    return-object v6
.end method

.method public refreshUserInfo(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 13
    # ins_size=3
    const-string/jumbo v0, onSuccess
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +008h
    if-eqz v12, +005h
    invoke-interface v12, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    iget-object v0, v10, Lcom/bytedance/trae/login/service/LoginServiceImpl;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;
    const/4 v6, 0
    move-object v1, v9
    move-object v2, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;-><init>(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    move-object v11, v9
    check-cast v11, Lkotlin/jvm/functions/Function2;
    const/4 v12, 3
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v7
    move-object v6, v8
    move-object v7, v11
    move v8, v12
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public registerAccountStatusChangeListener(com.bytedance.trae.login.api.IAccountStatusListener  java.lang.Boolean)void
    .registers 5
    # ins_size=3
    const-string v0, "callback"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/service/AccountStatusManager;->INSTANCE Lcom/bytedance/trae/login/service/AccountStatusManager;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/login/service/AccountStatusManager;->addAccountStatusCallback(Lcom/bytedance/trae/login/api/IAccountStatusListener; Z)V
    return-void 
.end method

.method public unregisterAccountStatusChangeListener(com.bytedance.trae.login.api.IAccountStatusListener)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/service/AccountStatusManager;->INSTANCE Lcom/bytedance/trae/login/service/AccountStatusManager;
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/service/AccountStatusManager;->removeAccountStatusCallback(Lcom/bytedance/trae/login/api/IAccountStatusListener;)V
    return-void 
.end method

.method public updateUserProfile(java.util.Map  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=4
    const-string/jumbo v0, params
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onSuccess
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onFail
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->isEnterpriseLogin()Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v2, v3, v4, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl;->updateUserProfileEnterprise(Ljava/util/Map; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    goto +1ch
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v2, v3, v4, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl;->updateUserProfileOversea(Ljava/util/Map; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    goto +10h
    invoke-static Lcom/bytedance/sdk/account/information/BDInformationAPIImpl;->instance()Lcom/bytedance/sdk/account/information/IBDInformationAPI;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;-><init>(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/util/Map; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoCallback;
    const/4 v4, 0
    invoke-interface v0, v3, v4, v1, Lcom/bytedance/sdk/account/information/IBDInformationAPI;->updateUserInfo(Ljava/util/Map; Lorg/json/JSONObject; Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoCallback;)V
    return-void 
.end method

.method public uploadAvatar(java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=4
    const-string/jumbo v0, path
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onSuccess
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onFail
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v2, v3, v4, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl;->uploadAvatarOversea(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    goto +fh
    invoke-static Lcom/bytedance/sdk/account/information/BDInformationAPIImpl;->instance()Lcom/bytedance/sdk/account/information/IBDInformationAPI;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;
    invoke-direct v1, v4, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarCallback;
    invoke-interface v0, v3, v1, Lcom/bytedance/sdk/account/information/IBDInformationAPI;->uploadAvatar(Ljava/lang/String; Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarCallback;)V
    return-void 
.end method
