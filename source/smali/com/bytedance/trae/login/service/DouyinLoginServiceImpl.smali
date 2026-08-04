# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
.super Ljava/lang/Object;
.source "DouyinLoginServiceImpl.kt"

.implements Lcom/bytedance/trae/login/api/IDouyinLoginService;

.field private static final CALLER_LOCAL_ENTRY:Ljava/lang/String;
.field private static final CLIENT_KEY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$Companion;
.field private static final EXT_FAILED_STEP:Ljava/lang/String;
.field private static final FAILED_STEP_TRAE_AUTH_AFTER_DOUYIN_AUTH:Ljava/lang/String;
.field private static final PLATFORM_ID:Ljava/lang/String;
.field private static final mainHandler:Landroid/os/Handler;
.field private bridge initialized:Z


.method public static synthetic $r8$lambda$dsZH5kpMEe_vBYx6fOPaRQJFjmM(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->postToMain$lambda$1(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$oNCBswZxYIGZoj8TOAzMNBLQPmI(kotlin.jvm.functions.Function2)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->bindToAccount$lambda$4(Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$senkbGN2MSuz3PymLXTl5yXTO_M(com.bytedance.trae.login.api.IAccountCallback  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->authorize$lambda$2(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->Companion Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$Companion;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->mainHandler Landroid/os/Handler;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$postToMain(com.bytedance.trae.login.service.DouyinLoginServiceImpl  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->postToMain(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final authorize$lambda$2(com.bytedance.trae.login.api.IAccountCallback  java.lang.String)kotlin.Unit
    .registers 14
    # ins_size=2
    sget-object v1, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    const/4 v2, -1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_douyin_authorize_start_failed I
    invoke-virtual v0, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 480
    const/4 v11, 0
    move-object v0, v12
    move-object v4, v13
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
.end method

.method private static final bindToAccount$lambda$4(kotlin.jvm.functions.Function2)kotlin.Unit
    .registers 4
    # ins_size=1
    const/4 v0, -1
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_douyin_authorize_unavailable I
    invoke-virtual v1, v2, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-interface v3, v0, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final ensureInitialized()void
    .registers 6
    # ins_size=1
    iget-boolean v0, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->initialized Z
    if-eqz v0, +003h
    return-void 
    monitor-enter v5
    iget-boolean v0, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->initialized Z
    if-eqz v0, +004h
    monitor-exit v5
    return-void 
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    const/4 v1, 1
    new-array v2, v1, [Lcom/bytedance/sdk/account/platform/douyin/DouYinServiceIniter;
    new-instance v3, Lcom/bytedance/sdk/account/platform/douyin/DouYinServiceIniter;
    const-string v4, "awu8u4pfmz7hocvm"
    invoke-direct v3, v4, Lcom/bytedance/sdk/account/platform/douyin/DouYinServiceIniter;-><init>(Ljava/lang/String;)V
    const/4 v4, 0
    aput-object v3, v2, v4
    check-cast v2, [Lcom/bytedance/sdk/account/platform/base/AuthorizeIniter;
    invoke-static v0, v2, Lcom/bytedance/sdk/account/platform/base/AuthorizeFramework;->init(Landroid/content/Context; [Lcom/bytedance/sdk/account/platform/base/AuthorizeIniter;)V
    iput-boolean v1, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->initialized Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v5
    return-void 
    move-exception v0
    monitor-exit v5
    throw v0
    :try_start_0x6
    :try_start_0xc
.end method

.method private final postToMain(kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=2
    invoke-static Landroid/os/Looper;->myLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +bh
    sget-object v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final postToMain$lambda$1(kotlin.jvm.functions.Function0)void
    .registers 1
    # ins_size=1
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public authorize(android.app.Activity  com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    .registers 7
    # ins_size=4
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->ensureInitialized()V
    const-string/jumbo v0, user_info
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->hashSetOf([Ljava/lang/Object;)Ljava/util/HashSet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    invoke-direct v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;-><init>()V
    check-cast v0, Ljava/util/Set;
    invoke-virtual v1, v0, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setScopes(Ljava/util/Set;)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    const-string v1, "dy_authorize"
    invoke-virtual v0, v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setState(Ljava/lang/String;)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    const-string v1, "com.bytedance.trae.login.DouyinEntryActivity"
    invoke-virtual v0, v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setCallerLocalEntry(Ljava/lang/String;)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setAuthType(I)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->build()Lcom/bytedance/sdk/account/platform/base/Request;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;
    invoke-direct v2, v3, v6, v5, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;-><init>(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Ljava/lang/String; Lcom/bytedance/trae/login/api/IAccountCallback; Landroid/content/Context;)V
    const-class v1, Lcom/bytedance/sdk/account/platform/api/IDouYin2Service;
    invoke-static v1, Lcom/bytedance/sdk/account/platform/base/AuthorizeFramework;->getService(Ljava/lang/Class;)Lcom/bytedance/sdk/account/platform/api/IAuthorizeService;
    move-result-object v1
    check-cast v1, Lcom/bytedance/sdk/account/platform/api/IDouYin2Service;
    if-eqz v1, +00dh
    check-cast v2, Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;
    invoke-interface v1, v4, v0, v2, Lcom/bytedance/sdk/account/platform/api/IDouYin2Service;->authorize(Landroid/app/Activity; Lcom/bytedance/sdk/account/platform/base/Request; Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;)Z
    move-result v4
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +00ah
    new-instance v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda2;
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->postToMain(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bindToAccount(android.app.Activity  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2)void
    .registers 6
    # ins_size=4
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onSuccess
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onFail
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->ensureInitialized()V
    const-string/jumbo v0, user_info
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->hashSetOf([Ljava/lang/Object;)Ljava/util/HashSet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    invoke-direct v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;-><init>()V
    check-cast v0, Ljava/util/Set;
    invoke-virtual v1, v0, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setScopes(Ljava/util/Set;)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    const-string v1, "dy_bind"
    invoke-virtual v0, v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setState(Ljava/lang/String;)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    const-string v1, "com.bytedance.trae.login.DouyinEntryActivity"
    invoke-virtual v0, v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setCallerLocalEntry(Ljava/lang/String;)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->setAuthType(I)Lcom/bytedance/sdk/account/platform/base/Request$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/sdk/account/platform/base/Request$Builder;->build()Lcom/bytedance/sdk/account/platform/base/Request;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;
    invoke-direct v1, v2, v4, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;-><init>(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2;)V
    new-instance v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;
    invoke-direct v4, v1, v2, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;-><init>(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1; Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function2;)V
    const-class v1, Lcom/bytedance/sdk/account/platform/api/IDouYin2Service;
    invoke-static v1, Lcom/bytedance/sdk/account/platform/base/AuthorizeFramework;->getService(Ljava/lang/Class;)Lcom/bytedance/sdk/account/platform/api/IAuthorizeService;
    move-result-object v1
    check-cast v1, Lcom/bytedance/sdk/account/platform/api/IDouYin2Service;
    if-eqz v1, +00dh
    check-cast v4, Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;
    invoke-interface v1, v3, v0, v4, Lcom/bytedance/sdk/account/platform/api/IDouYin2Service;->authorize(Landroid/app/Activity; Lcom/bytedance/sdk/account/platform/base/Request; Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;)Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    const/4 v4, 1
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00ah
    new-instance v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda1;
    invoke-direct v3, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function2;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->postToMain(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public getDouyinNickname()java.lang.String
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountDelegateInner;->instance()Lcom/bytedance/sdk/account/api/IBDAccount;
    move-result-object v0
    const-string v1, "aweme_v2"
    invoke-interface v0, v1, Lcom/bytedance/sdk/account/api/IBDAccount;->getPlatformByName(Ljava/lang/String;)Lcom/ss/android/account/model2/BDAccountPlatformEntity;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +015h
    iget-object v0, v0, Lcom/ss/android/account/model2/BDAccountPlatformEntity;->mNickname Ljava/lang/String;
    if-eqz v0, +011h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +003h
    move-object v1, v0
    return-object v1
.end method

.method public isBound()boolean
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountDelegateInner;->instance()Lcom/bytedance/sdk/account/api/IBDAccount;
    move-result-object v0
    const-string v1, "aweme_v2"
    invoke-interface v0, v1, Lcom/bytedance/sdk/account/api/IBDAccount;->getPlatformByName(Ljava/lang/String;)Lcom/ss/android/account/model2/BDAccountPlatformEntity;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +008h
    iget-boolean v0, v0, Lcom/ss/android/account/model2/BDAccountPlatformEntity;->mLogin Z
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method public unbind(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, onSuccess
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onFail
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountPlatformImpl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountPlatformAPI;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;-><init>(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2;)V
    check-cast v1, Lcom/bytedance/sdk/account/api/call/AbsApiCall;
    const-string v3, "aweme_v2"
    invoke-interface v0, v3, v1, Lcom/bytedance/sdk/account/api/IBDAccountPlatformAPI;->unbindPlatform(Ljava/lang/String; Lcom/bytedance/sdk/account/api/call/AbsApiCall;)V
    return-void 
.end method
