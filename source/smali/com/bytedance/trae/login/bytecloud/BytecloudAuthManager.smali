# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
.super Ljava/lang/Object;
.source "BytecloudAuthManager.kt"

.field private static final CONSOLE_HOST_CN:Ljava/lang/String;
.field private static final CONSOLE_HOST_OVERSEA:Ljava/lang/String;
.field private static final ENABLE_SSO_HOSTS:Ljava/util/List;
.field public static final INSTANCE:Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
.field private static final INTERNAL_CHECK_LIST:Ljava/util/List;
.field public static final LOGIN_PLATFORM_BYTECLOUD:Ljava/lang/String;
.field private static final MIN_RECHECK_INTERVAL_MS:J
.field public static final ODIN_USER_TYPE_LOGIN:I
.field private static final OVERSEA_SSO_ENABLED:Z
.field private static final REDIRECT_PATH:Ljava/lang/String;
.field private static final REDIRECT_SCHEME_CN:Ljava/lang/String;
.field private static final REDIRECT_SCHEME_OVERSEA:Ljava/lang/String;
.field private static final REGION_CN:I
.field private static final REGION_SG:I
.field private static final STATE_EXPIRY_MS:J
.field private static final TAG:Ljava/lang/String;
.field private static bridge cachedNetworkResult:Ljava/lang/Boolean;
.field private static bridge forceNextCheck:Z
.field private static bridge lastCheckTimestamp:J
.field private static final networkCheckMutex:Lkotlinx/coroutines/sync/Mutex;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-direct v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    sget-object v0, Lcom/bytedance/trae/network/IntranetProber;->INSTANCE Lcom/bytedance/trae/network/IntranetProber;
    invoke-virtual v0, Lcom/bytedance/trae/network/IntranetProber;->getPING_URLS()Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INTERNAL_CHECK_LIST Ljava/util/List;
    const-string v0, "https://copilot-cn.bytedance.net"
    const-string v1, "https://copilot-sg-og.byteintl.net"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->ENABLE_SSO_HOSTS Ljava/util/List;
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v2, v0, v1, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->networkCheckMutex Lkotlinx/coroutines/sync/Mutex;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$checkSingleUrl(com.bytedance.trae.login.bytecloud.BytecloudAuthManager  java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->checkSingleUrl(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$fetchEnableSsoFromHost(com.bytedance.trae.login.bytecloud.BytecloudAuthManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->fetchEnableSsoFromHost(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getENABLE_SSO_HOSTS$p()java.util.List
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->ENABLE_SSO_HOSTS Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getINTERNAL_CHECK_LIST$p()java.util.List
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INTERNAL_CHECK_LIST Ljava/util/List;
    return-object v0
.end method

.method private final checkSingleUrl(java.lang.String)boolean
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/IntranetProber;->INSTANCE Lcom/bytedance/trae/network/IntranetProber;
    const/16 v1, 3000
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/network/IntranetProber;->isReachable(Ljava/lang/String; I)Z
    move-result v3
    return v3
.end method

.method private final fetchEnableSsoFromHost(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=3
    move-object/from16 v1, v22
    move-object/from16 v0, v23
    const-string v2, "enable_sso 结果("
    const-string v3, "enable_sso 业务异常("
    instance-of v4, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;
    if-eqz v4, +014h
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;
    iget v5, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +00ah
    iget v0, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->label I
    sub-int/2addr v0, v6
    iput v0, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->label I
    move-object/from16 v5, v21
    goto +8h
    new-instance v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;
    move-object/from16 v5, v21
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;-><init>(Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    iget v7, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->label I
    const-string v8, "): "
    const-string v9, "BytecloudAuth"
    const/4 v10, 1
    const/4 v11, 0
    if-eqz v7, +014h
    if-ne v7, v10, +00ah
    iget-object v1, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +47h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const/16 v12, 47
    invoke-virtual v7, v12, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v16
    sget-object v12, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v13, "enable_sso"
    const-class v14, Lcom/bytedance/trae/login/bytecloud/IEnableSsoApi;
    const/4 v15, 0
    const/16 v17, 0
    const/16 v18, 1
    const/16 v19, 20
    const/16 v20, 0
    invoke-static/range v12 ... v20, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/login/bytecloud/IEnableSsoApi;
    const-string v12, "android"
    iput-object v1, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->L$0 Ljava/lang/Object;
    iput v10, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$fetchEnableSsoFromHost$1;->label I
    invoke-interface v7, v12, v0, v4, Lcom/bytedance/trae/login/bytecloud/IEnableSsoApi;->checkEnableSso(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v6, +003h
    return-object v6
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    if-eqz v0, +03bh
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v6
    const-wide/16 v12, 200
    cmp-long v4, v6, v12
    if-eqz v4, +003h
    goto +2fh
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/bytecloud/EnableSsoData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/EnableSsoData;->getEnableSso()Z
    move-result v0
    goto +2h
    move v0, v11
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v0, +003h
    goto +2h
    move v10, v11
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v9, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move v11, v0
    goto +4fh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "): code="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v6
    invoke-static v6, v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v9, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "enable_sso 请求异常("
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v9, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    :try_start_0x3b
    :try_start_0x4a
.end method

.method private final getConsoleHost()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "https://solo-web.tiktok-row.net"
    goto +3h
    const-string v0, "https://solo-web.bytedance.net"
    return-object v0
.end method

.method private final regionalIndex()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    return v0
.end method

.method public final buildLoginUrl()java.lang.String
    .registers 7
    # ins_size=1
    invoke-direct v6, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->getConsoleHost()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->getRedirectUri()Ljava/lang/String;
    move-result-object v1
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v2
    invoke-virtual v2, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, toString(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual v3, v2, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveBytecloudOAuthState(Ljava/lang/String; J)V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, "/authorization?auth_callback_url="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "&product_name=TRAE&client_name=mobile&client_state="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final checkBytedanceNetwork(kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=2
    instance-of v0, v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;
    if-eqz v0, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;
    iget v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v10, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->label I
    sub-int/2addr v10, v2
    iput v10, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;
    invoke-direct v0, v9, v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;-><init>(Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v10, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->label I
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v2, +023h
    if-eq v2, v5, +018h
    if-ne v2, v3, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07ah
    move-exception v10
    goto/16 +0a7h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    iget-object v2, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v10, v2
    goto +33h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v10
    if-eqz v10, +00bh
    sget-boolean v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->OVERSEA_SSO_ENABLED Z
    if-nez v10, +007h
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v10
    return-object v10
    sget-boolean v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->forceNextCheck Z
    if-nez v10, +00fh
    sget-object v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->cachedNetworkResult Ljava/lang/Boolean;
    if-eqz v10, +00bh
    invoke-virtual v10, Ljava/lang/Boolean;->booleanValue()Z
    move-result v10
    invoke-static v10, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v10
    return-object v10
    sget-object v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->networkCheckMutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v10, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->label I
    invoke-interface v10, v4, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-boolean v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->forceNextCheck Z
    if-nez v2, +011h
    sget-object v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->cachedNetworkResult Ljava/lang/Boolean;
    if-eqz v2, +00dh
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-eqz v0, +004h
    move-object v0, v10
    goto +47h
    move-object v0, v10
    move v5, v6
    goto +44h
    sget-object v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    sput-boolean v6, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->forceNextCheck Z
    invoke-direct v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->regionalIndex()I
    move-result v2
    new-instance v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1;
    invoke-direct v7, v2, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$3$result$1;-><init>(I Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    iput-object v10, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkBytedanceNetwork$1;->label I
    const-wide/16 v2, 10000
    invoke-static v2, v3, v7, v0, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v8, v0
    move-object v0, v10
    move-object v10, v8
    check-cast v10, Ljava/lang/Boolean;
    if-eqz v10, +007h
    invoke-virtual v10, Ljava/lang/Boolean;->booleanValue()Z
    move-result v10
    goto +2h
    move v10, v6
    if-eqz v10, +004h
    move v1, v5
    goto +2h
    move v1, v6
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->cachedNetworkResult Ljava/lang/Boolean;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    sput-wide v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->lastCheckTimestamp J
    if-eqz v10, +007h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->markIntranetSsoSeen()V
    if-eqz v10, -043h
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v10
    invoke-interface v0, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v10
    move-exception v0
    move-object v8, v0
    move-object v0, v10
    move-object v10, v8
    invoke-interface v0, v4, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v10
    :try_start_0x2f
    :try_start_0x7a
    :try_start_0xac
.end method

.method public final checkIntranetRealTime(kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;
    iget v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;
    invoke-direct v0, v6, v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;-><init>(Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +010h
    if-ne v2, v4, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +34h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v7
    if-eqz v7, +00bh
    sget-boolean v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->OVERSEA_SSO_ENABLED Z
    if-nez v7, +007h
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v7
    return-object v7
    invoke-direct v6, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->regionalIndex()I
    move-result v7
    new-instance v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$2;
    const/4 v5, 0
    invoke-direct v2, v7, v5, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$2;-><init>(I Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    iput v4, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$checkIntranetRealTime$1;->label I
    const-wide/16 v4, 5000
    invoke-static v4, v5, v2, v0, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Ljava/lang/Boolean;
    if-eqz v7, +006h
    invoke-virtual v7, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v7
    return-object v7
.end method

.method public final forceResetNetworkCache()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->forceNextCheck Z
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->cachedNetworkResult Ljava/lang/Boolean;
    return-void 
.end method

.method public final getRedirectUri()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, traei18n
    goto +4h
    const-string/jumbo v0, traecn
    const-string v1, "://oauth/bytecloud/callback"
    invoke-virtual v0, v1, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final handleCallback(android.net.Uri  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;-><init>(Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public final hasEverSeenIntranet()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->hasIntranetSsoSeen()Z
    move-result v0
    return v0
.end method

.method public final isBytecloudLogin()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    const-string v1, "bytecloud"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final resetNetworkCache()boolean
    .registers 5
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-wide v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->lastCheckTimestamp J
    sub-long/2addr v0, v2
    const-wide/16 v2, 3000
    cmp-long v0, v0, v2
    if-gez v0, +004h
    const/4 v0, 0
    return v0
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->cachedNetworkResult Ljava/lang/Boolean;
    const/4 v0, 1
    return v0
.end method
