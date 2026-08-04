# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;
.super Ljava/lang/Object;
.source "BytecloudPassportLogin.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;
.field private static final PLATFORM_APP_ID:Ljava/lang/String;
.field private static final PLATFORM_NAME:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;
    invoke-direct v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$reportBind(com.bytedance.trae.login.bytecloud.BytecloudPassportLogin)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;->reportBind()V
    return-void 
.end method

.method private final reportBind()void
    .registers 8
    # ins_size=1
    sget-object v0, Landroidx/lifecycle/ProcessLifecycleOwner;->Companion Landroidx/lifecycle/ProcessLifecycleOwner$Companion;
    invoke-virtual v0, Landroidx/lifecycle/ProcessLifecycleOwner$Companion;->get()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$reportBind$1;
    const/4 v4, 0
    invoke-direct v0, v4, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$reportBind$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final login(java.lang.String  com.bytedance.trae.login.bytecloud.BytecloudPassportLogin$Callback)void
    .registers 14
    # ins_size=3
    const-string v0, "accessToken"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v12
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    const-string v1, "BytecloudPassportLogin"
    if-eqz v0, +010h
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "accessToken is empty, skip passport login"
    invoke-virtual v12, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v12, -1
    const-string v0, "accessToken is empty"
    invoke-interface v13, v12, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;->onError(I Ljava/lang/String;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, ssoWithAccessTokenLogin start
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountPlatformImpl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountPlatformAPI;
    move-result-object v3
    const-string v4, "22964"
    const-string v5, "customize_trae_bytecloud"
    const-wide/16 v7, 0
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v9
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;
    invoke-direct v0, v13, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$login$1;-><init>(Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;)V
    move-object v10, v0
    check-cast v10, Lcom/bytedance/sdk/account/api/call/AbsApiCall;
    move-object v6, v12
    invoke-interface/range v3 ... v10, Lcom/bytedance/sdk/account/api/IBDAccountPlatformAPI;->ssoWithAccessTokenLogin(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/util/Map; Lcom/bytedance/sdk/account/api/call/AbsApiCall;)V
    return-void 
.end method
