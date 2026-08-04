# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
.super Ljava/lang/Object;
.source "TraeAuthManager.kt"

.field private static final AUTH_FLOW_TIMEOUT_MS:J
.field private static final CHAIN_RETRY_BASE_DELAY_MS:J
.field private static final CHAIN_RETRY_MAX_DELAY_MS:J
.field private static final ERROR_CODE_DEVICE_BIND_REQUIRED:Ljava/lang/String;
.field private static final ERROR_CODE_DEVICE_LIMIT_REACHED:Ljava/lang/String;
.field private static final ERROR_CODE_NOT_LOGGED_IN:Ljava/lang/String;
.field private static final ERROR_CODE_REFRESH_TOKEN_EXPIRED:Ljava/lang/String;
.field private static final ERROR_CODE_SESSION_NOT_FOUND:Ljava/lang/String;
.field private static final EVENT_LOGIN_FUNNEL:Ljava/lang/String;
.field private static final EVENT_STEP_DURATION:Ljava/lang/String;
.field private static final EVENT_TOKEN_REFRESH:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
.field public static final PLATFORM_BYTECLOUD:Ljava/lang/String;
.field public static final PLATFORM_DOUYIN:Ljava/lang/String;
.field public static final PLATFORM_EMAIL:Ljava/lang/String;
.field public static final PLATFORM_GITHUB:Ljava/lang/String;
.field public static final PLATFORM_GOOGLE:Ljava/lang/String;
.field public static final PLATFORM_ONE_CLICK:Ljava/lang/String;
.field public static final PLATFORM_PHONE:Ljava/lang/String;
.field public static final PLATFORM_UNSELECTED:Ljava/lang/String;
.field private static final SESSION_NOT_FOUND_MAX_CHAIN_RETRIES:I
.field public static final STAGE_ACCOUNT_DELETION_PENDING_SHOWN:Ljava/lang/String;
.field public static final STAGE_ACCOUNT_RESTORE_API_SUCCESS:Ljava/lang/String;
.field public static final STAGE_ACCOUNT_RESTORE_CLICK:Ljava/lang/String;
.field public static final STAGE_ACCOUNT_RESTORE_EXIT:Ljava/lang/String;
.field public static final STAGE_ACCOUNT_RESTORE_FAIL:Ljava/lang/String;
.field public static final STAGE_ACCOUNT_RESTORE_SUCCESS:Ljava/lang/String;
.field public static final STAGE_AGREEMENT_ACCEPTED:Ljava/lang/String;
.field public static final STAGE_AGREEMENT_DIALOG_SHOWN:Ljava/lang/String;
.field public static final STAGE_AGREEMENT_REJECTED:Ljava/lang/String;
.field public static final STAGE_AUTH_RETRY_FAILURE:Ljava/lang/String;
.field public static final STAGE_BYTECLOUD_PASSPORT_DONE:Ljava/lang/String;
.field public static final STAGE_BYTECLOUD_PASSPORT_FAIL:Ljava/lang/String;
.field public static final STAGE_DEVICE_LIMIT:Ljava/lang/String;
.field public static final STAGE_DEVICE_LIMIT_DISMISSED:Ljava/lang/String;
.field public static final STAGE_DOUYIN_AUTH_CANCELLED:Ljava/lang/String;
.field public static final STAGE_DOUYIN_AUTH_NEED_BIND:Ljava/lang/String;
.field public static final STAGE_DOUYIN_AUTH_SERVICE_UNAVAILABLE:Ljava/lang/String;
.field public static final STAGE_DOUYIN_AUTH_SUCCESS_NO_BIND:Ljava/lang/String;
.field public static final STAGE_DOUYIN_AUTH_TRAE_AUTH_FAIL:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_DEVICE_LIMIT:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_FAIL:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_PHONE_CONFLICT:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_PHONE_DESTROY:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_PHONE_EXIT:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_PHONE_PAUSE:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_PHONE_SHOWN:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_RESEND_CODE:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_RESEND_CODE_FAIL:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_RESEND_CODE_SUCCESS:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_SEND_CODE:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_SEND_CODE_FAIL:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_SUBMIT:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_SUCCESS:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_TRAE_AUTH_FAIL:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_VERIFY_CODE_DESTROY:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_VERIFY_CODE_ERROR:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_VERIFY_CODE_EXIT:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_VERIFY_CODE_PAUSE:Ljava/lang/String;
.field public static final STAGE_DOUYIN_BIND_VERIFY_CODE_SHOWN:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_CHECK_CONFIG_FAIL:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_CHECK_CONFIG_RESULT:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_EMAIL_SUBMITTED:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_PAGE_EXIT:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_PAGE_SHOWN:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_PASSWORD_SUBMITTED:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_SSO_CALLBACK:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_SSO_OPENED:Ljava/lang/String;
.field public static final STAGE_ENTERPRISE_SSO_SESSION_FAIL:Ljava/lang/String;
.field public static final STAGE_LOGIN_BUTTON_CLICKED:Ljava/lang/String;
.field public static final STAGE_LOGIN_FAILURE:Ljava/lang/String;
.field public static final STAGE_LOGIN_METHOD_SELECTED:Ljava/lang/String;
.field public static final STAGE_LOGIN_SUCCESS:Ljava/lang/String;
.field public static final STAGE_LOGIN_SUCCESS_DEGRADED:Ljava/lang/String;
.field public static final STAGE_ONE_CLICK_SWITCH_TO_PHONE:Ljava/lang/String;
.field public static final STAGE_PAGE_EXIT:Ljava/lang/String;
.field public static final STAGE_PAGE_PAUSE:Ljava/lang/String;
.field public static final STAGE_PAGE_RESUME:Ljava/lang/String;
.field public static final STAGE_PAGE_SOURCE:Ljava/lang/String;
.field public static final STAGE_PASSPORT_DONE:Ljava/lang/String;
.field public static final STAGE_PASSPORT_FAIL:Ljava/lang/String;
.field public static final STAGE_PHONE_LOGIN_CLICKED:Ljava/lang/String;
.field public static final STAGE_PRELOAD_RESULT:Ljava/lang/String;
.field public static final STAGE_SMS_RESEND_ERROR:Ljava/lang/String;
.field public static final STAGE_START:Ljava/lang/String;
.field public static final STAGE_TRANSIENT_RETRY:Ljava/lang/String;
.field public static final STAGE_VIEW_SHOWN:Ljava/lang/String;
.field private static final STEP_MAX_RETRIES:I
.field private static final TAG:Ljava/lang/String;
.field private static final TOKEN_REFRESH_THRESHOLD_MS:J
.field private static enterpriseExchangeProvider:Lkotlin/jvm/functions/Function1;
.field private static final exceptionHandler:Lkotlinx/coroutines/CoroutineExceptionHandler;
.field private static final isExchangeRequesting:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final refreshMutex:Lkotlinx/coroutines/sync/Mutex;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$LdwG8wISFE_oQ7RhIc99CQQl9nA(java.util.Map$Entry)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->buildCookieHeader$lambda$25(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$NYBQBgpEju8dhOGg1zHTic-rqOI(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->exchangeTokenOrThrowIgnoreDevice$lambda$1(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    sput-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->exceptionHandler Lkotlinx/coroutines/CoroutineExceptionHandler;
    const/4 v0, 0
    const/4 v2, 1
    invoke-static v0, v2, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v3, v4, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v3
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v3, v1, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    invoke-static v1, v2, v0, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->refreshMutex Lkotlinx/coroutines/sync/Mutex;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isExchangeRequesting Ljava/util/concurrent/atomic/AtomicBoolean;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$doEnterpriseExchangeTokenOrThrow(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->doEnterpriseExchangeTokenOrThrow(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$doExchangeTokenOrThrow(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->doExchangeTokenOrThrow(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$doGetRefreshTokenOrThrow(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->doGetRefreshTokenOrThrow(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$doLoginOrThrow(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->doLoginOrThrow(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getRefreshMutex$p()kotlinx.coroutines.sync.Mutex
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->refreshMutex Lkotlinx/coroutines/sync/Mutex;
    return-object v0
.end method

.method public static final synthetic access$isExchangeRequesting$p()java.util.concurrent.atomic.AtomicBoolean
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isExchangeRequesting Ljava/util/concurrent/atomic/AtomicBoolean;
    return-object v0
.end method

.method public static final synthetic access$retryOnTransient(com.bytedance.trae.login.traeauth.TraeAuthManager  int  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->retryOnTransient(I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toLoginType(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->toLoginType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic bindDevice$default(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  com.bytedance.trae.login.traeauth.DeviceInfo  com.bytedance.trae.login.traeauth.DeviceProof  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->bindDevice(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic bindDeviceAsync$default(com.bytedance.trae.login.traeauth.TraeAuthManager  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->bindDeviceAsync(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final buildCookieHeader(java.util.Map)java.lang.String
    .registers 11
    # ins_size=2
    invoke-interface v10, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, "; "
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    new-instance v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda0;
    invoke-direct v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda0;-><init>()V
    const/16 v7, 30
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private static final buildCookieHeader$lambda$25(java.util.Map$Entry)java.lang.CharSequence
    .registers 3
    # ins_size=1
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 61
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    return-object v2
.end method

.method private final buildDeviceHeaders()java.util.Map
    .registers 14
    # ins_size=1
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    const-string v1, "Content-Type"
    const-string v2, "application/json"
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, x-device-id
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getClientDid()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, x-machine-id
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Landroid/os/Build;->BRAND Ljava/lang/String;
    const-string v2, ""
    if-nez v1, +003h
    move-object v1, v2
    const-string/jumbo v3, x-device-brand
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Landroid/os/Build;->MODEL Ljava/lang/String;
    if-nez v1, +003h
    move-object v1, v2
    const-string/jumbo v3, x-device-type
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Landroid/os/Build$VERSION;->RELEASE Ljava/lang/String;
    if-nez v1, +003h
    move-object v1, v2
    const-string/jumbo v3, x-os-version
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Landroid/os/Build;->SUPPORTED_ABIS [Ljava/lang/String;
    if-eqz v4, +015h
    const-string v1, ","
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 62
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lkotlin/collections/ArraysKt;->joinToString$default([Ljava/lang/Object; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    move-object v1, v2
    const-string/jumbo v3, x-device-cpu
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "http.agent"
    invoke-static v1, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    move-object v1, v2
    const-string v3, "User-Agent"
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "Referer"
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v0
.end method

.method private final doEnterpriseExchangeTokenOrThrow(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=3
    sget-object v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->enterpriseExchangeProvider Lkotlin/jvm/functions/Function1;
    if-eqz v13, +021h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "doEnterpriseExchangeToken: requesting via provider, refreshTokenLen="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Ljava/lang/String;->length()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "TraeAuthManager"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v13, v12, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    return-object v12
    new-instance v12, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v1, 0
    const-string v2, "doEnterpriseExchangeToken: provider not registered"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 248
    const/4 v10, 0
    move-object v0, v12
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v12
.end method

.method private final doExchangeTokenOrThrow(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 41
    # ins_size=3
    move-object/from16 v1, v38
    move-object/from16 v0, v39
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v12, 1
    if-nez v0, +004h
    move v0, v12
    goto +2h
    const/4 v0, 0
    if-nez v0, +382h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getClientId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    move v0, v12
    goto +2h
    const/4 v0, 0
    if-nez v0, +35ch
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    const-string v2, "enterprise"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct/range v38 ... v40, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->doEnterpriseExchangeTokenOrThrow(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getCloudideSession()Ljava/lang/String;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    move v2, v12
    goto +2h
    const/4 v2, 0
    if-nez v2, +31ah
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v13
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "doExchangeToken: requesting, refreshTokenLen="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v39, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", sessionLen="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v15, "TraeAuthManager"
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v10, 0
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v20
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    move-object v9, v2
    check-cast v9, Ljava/util/Map;
    const-string v2, "Cookie"
    const-string v3, "X-Cloudide-Session"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->buildCookieHeader(Ljava/util/Map;)Ljava/lang/String;
    move-result-object v0
    invoke-interface v9, v2, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "Content-Type"
    const-string v2, "application/json"
    invoke-interface v9, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v0, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v0, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    iput-boolean v12, v0, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    new-instance v8, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenRequest;
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getClientId()Ljava/lang/String;
    move-result-object v3
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getClientSecret()Ljava/lang/String;
    move-result-object v4
    const/4 v6, 0
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getDeviceInfo()Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    move-result-object v7
    sget-object v21, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    const-string v22, "POST"
    const-string v23, "/trae/api/v3/oauth/ExchangeToken"
    const/16 v24, 0
    const/16 v25, 4
    const/16 v26, 0
    invoke-static/range v21 ... v26, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getDeviceProof$default(Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/login/traeauth/DeviceProof;
    move-result-object v16
    const/16 v17, 8
    const/16 v18, 0
    move-object v2, v8
    move-object/from16 v5, v39
    move-object v11, v8
    move-object/from16 v8, v16
    move-object/from16 v21, v9
    move/from16 v9, v17
    move-object/from16 v10, v18
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v16, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v17, trae_auth
    const-class v18, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    const/16 v19, 0
    const/16 v22, 0
    const/16 v23, 36
    const/16 v24, 0
    invoke-static/range v16 ... v24, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    invoke-interface v2, v11, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;->exchangeTokenRaw(Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v2
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v3
    const-string v4, "headers(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    move-object v4, v10
    check-cast v4, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v4, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v4
    const-string v5, "X-Tt-Logid"
    invoke-static v4, v5, v12, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-eqz v4, -017h
    goto +6h
    move-exception v0
    const/4 v12, 0
    goto/16 +1b7h
    const/4 v10, 0
    check-cast v10, Lcom/bytedance/retrofit2/client/Header;
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-nez v4, +049h
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03ch
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v4, "in(...)"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v5, Ljava/io/InputStreamReader;
    invoke-direct v5, v0, v4, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v5, Ljava/io/Reader;
    instance-of v0, v5, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v5, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v4, 8192
    invoke-direct v0, v5, v4, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v5, v0
    check-cast v5, Ljava/io/Closeable;
    move-object v0, v5
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v10
    const/4 v6, 0
    invoke-static v5, v6, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +ch
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v4, v0
    invoke-static v5, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    const/4 v6, 0
    move-object v10, v6
    move-object v4, v10
    goto +2h
    const/4 v6, 0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    const-string v7, "doExchangeToken: response received in "
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    sub-long/2addr v7, v13
    invoke-virtual v5, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, "ms, logId="
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v15, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    invoke-direct v1, v4, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->parseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/traeauth/TraeResponse;
    move-result-object v0
    if-eqz v0, +0ffh
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v10
    goto +2h
    move-object v10, v6
    if-eqz v10, +081h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "doExchangeToken business error: ["
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, "] "
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v15, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getStandardCode()Ljava/lang/String;
    move-result-object v0
    const-string v2, "040034"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +01eh
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    invoke-static v12, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 254
    const/16 v23, 0
    move-object v13, v0
    invoke-direct/range v13 ... v23, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;-><init>(Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v28
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "doExchangeToken failed: "
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v29
    const/16 v30, 0
    const/16 v31, 0
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v32
    const/16 v33, 0
    const/16 v34, 0
    const/16 v36, 104
    const/16 v37, 0
    move-object/from16 v27, v0
    move-object/from16 v35, v3
    invoke-direct/range v27 ... v37, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResult()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v6
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v12
    if-nez v2, +031h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "doExchangeToken: success, tokenExpireAt="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getTokenExpireAt()Ljava/lang/Long;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", hasNewRefreshToken="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +004h
    move v11, v12
    goto +2h
    const/4 v11, 0
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "doExchangeToken: token is empty"
    invoke-virtual v0, v15, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/16 v28, 0
    const-string v29, "doExchangeToken returned empty token"
    const/16 v30, 1
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v36, 120
    const/16 v37, 0
    move-object/from16 v27, v0
    move-object/from16 v35, v3
    invoke-direct/range v27 ... v37, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "doExchangeToken: response body is null"
    invoke-virtual v0, v15, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v28
    const-string v29, "doExchangeToken response body is null"
    const/16 v30, 1
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v36, 120
    const/16 v37, 0
    move-object/from16 v27, v0
    move-object/from16 v35, v3
    invoke-direct/range v27 ... v37, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    move-exception v0
    move-object v12, v3
    goto +7h
    move-exception v0
    const/4 v6, 0
    goto +3h
    move-exception v0
    move-object v6, v10
    move-object v12, v6
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "doExchangeToken network exception: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v4, 32
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", elapsed="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    sub-long/2addr v4, v13
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "ms"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    move-object v8, v0
    check-cast v8, Ljava/lang/Throwable;
    invoke-direct v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractHttpStatusCode(Ljava/lang/Throwable;)I
    move-result v2
    const/16 v3, 401
    if-ne v2, v3, +014h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const-string v5, "20311"
    const-string v6, "doExchangeToken: HTTP 401 - refresh token invalid"
    const/4 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v13, 112
    const/4 v14, 0
    move-object v4, v0
    invoke-direct/range v4 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v5, 0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "doExchangeToken network error: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isTransientError(Ljava/lang/Throwable;)Z
    move-result v7
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v13, 112
    const/4 v14, 0
    move-object v4, v2
    invoke-direct/range v4 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/16 v16, 0
    const-string v17, "doExchangeToken: cloudideSession is empty"
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 248
    const/16 v25, 0
    move-object v15, v0
    invoke-direct/range v15 ... v25, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v3, 0
    const-string v4, "doExchangeToken: clientId is empty"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 248
    const/4 v12, 0
    move-object v2, v0
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v14, 0
    const-string v15, "doExchangeToken: refreshToken is empty"
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 248
    const/16 v23, 0
    move-object v13, v0
    invoke-direct/range v13 ... v23, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x79
    :try_start_0xdd
    :try_start_0x116
    :try_start_0x12f
    :try_start_0x133
    :try_start_0x139
    :try_start_0x16d
    :try_start_0x177
    :try_start_0x17d
    :try_start_0x180
.end method

.method private final doGetRefreshTokenOrThrow(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 36
    # ins_size=3
    move-object/from16 v1, v33
    move-object/from16 v0, v34
    const-string v2, "TraeAuthManager"
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 0
    const/4 v5, 1
    if-nez v3, +004h
    move v3, v5
    goto +2h
    move v3, v4
    if-nez v3, +2e1h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    sget-object v8, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v8, Lcom/bytedance/trae/network/DebugSettings;->isDeviceManagerMockDid()Z
    move-result v8
    if-eqz v8, +004h
    const-string v3, ""
    const/16 v8, 32
    const/4 v9, 0
    sget-object v10, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v15
    const-string v10, "X-Cloudide-Session"
    invoke-static v10, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    invoke-direct v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->buildCookieHeader(Ljava/util/Map;)Ljava/lang/String;
    move-result-object v0
    new-instance v10, Ljava/util/LinkedHashMap;
    invoke-direct v10, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v10, Ljava/util/Map;
    const-string v11, "Cookie"
    invoke-interface v10, v11, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "Content-Type"
    const-string v11, "application/json"
    invoke-interface v10, v0, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v11, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v12, trae_auth
    const-class v13, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    const/4 v14, 0
    const/16 v17, 0
    const/16 v18, 36
    const/16 v19, 0
    move-object/from16 v16, v10
    invoke-static/range v11 ... v19, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    new-instance v10, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v10, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    iput-boolean v5, v10, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    move-object v11, v3
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v11
    if-eqz v11, +017h
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;
    sget-object v11, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getClientId()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 14
    const/16 v18, 0
    move-object v12, v3
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +23h
    new-instance v11, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;
    sget-object v12, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v12, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getClientId()Ljava/lang/String;
    move-result-object v12
    sget-object v13, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getDeviceInfo()Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    move-result-object v13
    sget-object v14, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    const-string v15, "POST"
    const-string v16, "/trae/api/v3/oauth/GetRefreshToken"
    const/16 v17, 0
    const/16 v18, 4
    const/16 v19, 0
    invoke-static/range v14 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getDeviceProof$default(Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/login/traeauth/DeviceProof;
    move-result-object v14
    invoke-direct v11, v12, v3, v13, v14, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof;)V
    move-object v3, v11
    invoke-interface v0, v3, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;->getRefreshTokenRaw(Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v3
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v10
    const-string v11, "headers(...)"
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +016h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v12, v11
    check-cast v12, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v12, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v12
    const-string v13, "X-Tt-Logid"
    invoke-static v12, v13, v5, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v12
    if-eqz v12, -017h
    goto +2h
    move-object v11, v9
    check-cast v11, Lcom/bytedance/retrofit2/client/Header;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v9
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    if-nez v11, +046h
    move-object v11, v1
    check-cast v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03ch
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v11, "in(...)"
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v11, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v12, Ljava/io/InputStreamReader;
    invoke-direct v12, v0, v11, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v12, Ljava/io/Reader;
    instance-of v0, v12, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v12, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v11, 8192
    invoke-direct v0, v12, v11, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v12, v0
    check-cast v12, Ljava/io/Closeable;
    move-object v0, v12
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v0
    invoke-static v12, v9, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    move-object v11, v0
    goto +bh
    move-exception v0
    move-object v3, v0
    throw v3
    move-exception v0
    move-object v4, v0
    invoke-static v12, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    move-object v11, v9
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, Ljava/lang/StringBuilder;-><init>()V
    const-string v13, "doGetRefreshToken: response received in "
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v13
    sub-long/2addr v13, v6
    invoke-virtual v12, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v12
    const-string v13, "ms, logId="
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v0, v2, v12, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    invoke-direct v1, v11, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->parseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/traeauth/TraeResponse;
    move-result-object v0
    if-eqz v0, +0f7h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v6
    goto +2h
    move-object v6, v9
    if-eqz v6, +093h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v7, "doGetRefreshToken business error: ["
    invoke-direct v4, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, "] "
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getStandardCode()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getStandardCode()Ljava/lang/String;
    move-result-object v0
    const-string v2, "040034"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +01ch
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 63
    const/16 v19, 0
    move-object v11, v0
    invoke-direct/range v11 ... v19, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;-><init>(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->setDeviceLimitReached(Ljava/lang/Boolean;)V
    return-object v0
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v0
    const-string v2, "20310"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v12
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "doGetRefreshToken failed: "
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v16
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v15, 0
    const/16 v17, 0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v18
    const/16 v20, 40
    const/16 v21, 0
    move-object v11, v0
    move-object/from16 v19, v10
    invoke-direct/range v11 ... v21, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResult()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    if-eqz v9, +008h
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    move v4, v5
    if-nez v4, +01eh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "doGetRefreshToken: success, refreshExpireAt="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "doGetRefreshToken: refreshToken is empty"
    invoke-virtual v0, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v12, 0
    const-string v13, "doGetRefreshToken returned empty refreshToken"
    const/4 v14, 1
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v18
    const/16 v20, 56
    const/16 v21, 0
    move-object v11, v0
    move-object/from16 v19, v10
    invoke-direct/range v11 ... v21, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "doGetRefreshToken: response body is null"
    invoke-virtual v0, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v12, 0
    const-string v13, "doGetRefreshToken response body is null"
    const/4 v14, 1
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v18
    const/16 v20, 56
    const/16 v21, 0
    move-object v11, v0
    move-object/from16 v19, v10
    invoke-direct/range v11 ... v21, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    move-exception v0
    move-object/from16 v30, v10
    goto +4h
    move-exception v0
    move-object/from16 v30, v9
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "doGetRefreshToken network exception: "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", elapsed="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    sub-long/2addr v8, v6
    invoke-virtual v4, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "ms"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/16 v23, 0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "doGetRefreshToken network error: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v24
    check-cast v0, Ljava/lang/Throwable;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isTransientError(Ljava/lang/Throwable;)Z
    move-result v25
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v31, 112
    const/16 v32, 0
    move-object/from16 v22, v2
    move-object/from16 v26, v0
    invoke-direct/range v22 ... v32, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v4, 0
    const-string v5, "doGetRefreshToken: cloudideSession is empty"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 248
    const/4 v13, 0
    move-object v3, v0
    invoke-direct/range v3 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x2d
    :try_start_0xf1
    :try_start_0x125
    :try_start_0x12e
    :try_start_0x135
    :try_start_0x138
.end method

.method private final doLoginOrThrow(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 35
    # ins_size=3
    move-object/from16 v1, v32
    move-object/from16 v0, v34
    const-string v2, "doLogin: response received in "
    const-string v3, "doLogin: requesting "
    instance-of v4, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;
    if-eqz v4, +012h
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;
    iget v5, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->label I
    sub-int/2addr v0, v6
    iput v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->label I
    const-string v7, "ms"
    const/4 v8, 0
    const/4 v9, 0
    const-string v10, "TraeAuthManager"
    const/4 v11, 1
    if-eqz v6, +01ah
    if-ne v6, v11, +010h
    iget-wide v5, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->J$0 J
    iget-object v3, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0b0h
    move-exception v0
    goto/16 +25fh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v12
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v0
    invoke-direct/range v32, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->buildDeviceHeaders()Ljava/util/Map;
    move-result-object v6
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    invoke-direct v15, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v15, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v15, ", deviceId="
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string/jumbo v15, x-device-id
    invoke-interface v6, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v15, ", machineId="
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string/jumbo v15, x-machine-id
    invoke-interface v6, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    invoke-virtual v3, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v14, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v15, trae_auth
    const-class v16, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    const/16 v17, 0
    const/16 v20, 0
    const/16 v21, 36
    const/16 v22, 0
    move-object/from16 v18, v0
    move-object/from16 v19, v6
    invoke-static/range v14 ... v22, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getLoginChannel()Ljava/lang/String;
    move-result-object v15
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getPlatform()Ljava/lang/String;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 32764
    const/16 v31, 0
    move-object v14, v3
    invoke-direct/range v14 ... v31, Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->L$0 Ljava/lang/Object;
    iput-wide v12, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->J$0 J
    iput v11, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$doLoginOrThrow$1;->label I
    move-object/from16 v6, v33
    invoke-interface v0, v3, v6, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;->login(Lcom/bytedance/trae/login/traeauth/TraeLoginRequest; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v5, +003h
    return-object v5
    move-object v3, v1
    move-wide v5, v12
    check-cast v0, Lcom/bytedance/retrofit2/SsResponse;
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v13
    sub-long/2addr v13, v5
    invoke-virtual v12, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-string v2, "X-Tt-Logid"
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->getHeaderValues(Lcom/bytedance/retrofit2/SsResponse; Ljava/lang/String;)Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    const-class v4, Lcom/bytedance/trae/login/traeauth/TraeLoginResult;
    invoke-direct v3, v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->parseResponse(Lcom/bytedance/retrofit2/SsResponse; Ljava/lang/Class;)Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;
    move-result-object v0
    if-eqz v0, +160h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v4
    goto +2h
    move-object v4, v8
    if-nez v4, +0fdh
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;->getSsResponse()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    const-string v4, "X-Cloudide-Session"
    invoke-direct v3, v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractCookieFromResponse(Lcom/bytedance/retrofit2/SsResponse; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +007h
    invoke-direct v3, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractCookieFromCookieManager(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    if-nez v0, +06fh
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "doLogin: extractCookieFromResponse returned null, fallback to CookieManager (hasValue="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    move v7, v9
    goto +2h
    move v7, v11
    xor-int/2addr v7, v11
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, "), logId="
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v10, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v5, stage
    const-string/jumbo v7, session_cookie_fallback
    invoke-virtual v4, v5, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v9
    goto +2h
    move v5, v11
    xor-int/2addr v5, v11
    const-string v6, "cookie_manager_has_value"
    invoke-virtual v4, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    if-nez v2, +005h
    const-string v5, ""
    goto +2h
    move-object v5, v2
    const-string v6, "log_id"
    invoke-virtual v4, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v6, reason_detail
    const-string v7, "extractCookieFromResponse returned null, used CookieManager fallback"
    invoke-virtual v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v6, "icube_login_funnel"
    invoke-static v6, v4, v8, v5, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "cloudideSession: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    move v7, v9
    goto +2h
    move v7, v11
    if-eqz v7, +005h
    const-string v0, "EMPTY"
    goto +24h
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v8, obtained (
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, " chars), fromResponse="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    if-eqz v0, +004h
    move v0, v11
    goto +2h
    move v0, v9
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v5, ", logId="
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v10, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v6, +008h
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    move v9, v11
    if-nez v9, +003h
    return-object v3
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v13, 0
    const-string v14, "Failed to extract X-Cloudide-Session"
    const/4 v15, 1
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v21, 120
    const/16 v22, 0
    move-object v12, v0
    move-object/from16 v20, v2
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "doLogin business error: ["
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, "] "
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v13
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "doLogin failed: "
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 0
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v17
    const/16 v18, 0
    const/16 v19, 0
    const/16 v21, 104
    const/16 v22, 0
    move-object v12, v0
    move-object/from16 v20, v2
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "doLogin: response body is null"
    invoke-virtual v0, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v13, 0
    const-string v14, "doLogin response body is null"
    const/4 v15, 1
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v21, 120
    const/16 v22, 0
    move-object v12, v0
    move-object/from16 v20, v2
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    move-exception v0
    move-object v3, v1
    move-wide v5, v12
    move-object v2, v0
    check-cast v2, Ljava/lang/Throwable;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractHttpStatusCode(Ljava/lang/Throwable;)I
    move-result v4
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v14, "doLogin network exception: "
    invoke-direct v13, v14, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const/16 v14, 32
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, ", httpStatus="
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, ", elapsed="
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v14
    sub-long/2addr v14, v5
    invoke-virtual v13, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v12, v10, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->intValue()I
    move-result v6
    if-lez v6, +003h
    move v9, v11
    if-eqz v9, +003h
    goto +2h
    move-object v5, v8
    if-eqz v5, +008h
    invoke-virtual v5, Ljava/lang/Integer;->toString()Ljava/lang/String;
    move-result-object v5
    move-object v13, v5
    goto +2h
    move-object v13, v8
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "doLogin network error: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-direct v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isTransientError(Ljava/lang/Throwable;)Z
    move-result v15
    const/16 v0, 401
    if-ne v4, v0, +005h
    const-string/jumbo v8, 登录受到安全策略限制，请稍后再试
    move-object/from16 v17, v8
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 224
    const/16 v22, 0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    move-object v12, v0
    move-object/from16 v16, v2
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x3a
    :try_start_0x51
    :try_start_0xed
.end method

.method static synthetic doLoginOrThrow$default(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    const/4 v1, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->doLoginOrThrow(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private static final exchangeTokenOrThrowIgnoreDevice$lambda$1(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  boolean)void
    .registers 9
    # ins_size=3
    if-eqz v8, +01dh
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v8
    check-cast v8, Lkotlin/coroutines/CoroutineContext;
    invoke-static v8, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 0
    new-instance v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;
    const/4 v3, 0
    invoke-direct v8, v6, v7, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    move-object v3, v8
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +12h
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v6
    invoke-interface v6, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v6
    if-eqz v6, +007h
    sget-object v7, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-virtual v7, v6, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->performForceLogout(Landroid/app/Activity;)V
    return-void 
.end method

.method private final extractCookieFromCookieManager(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v0
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const/4 v3, 0
    return-object v3
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractCookieValue(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final extractCookieFromResponse(com.bytedance.retrofit2.SsResponse  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    const-string v0, "Set-Cookie"
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->getHeaderValues(Lcom/bytedance/retrofit2/SsResponse; Ljava/lang/String;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +020h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-direct v1, v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractCookieValue(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, -021h
    return-object v0
    const/4 v3, 0
    return-object v3
.end method

.method private final extractCookieValue(java.lang.String  java.lang.String)java.lang.String
    .registers 9
    # ins_size=3
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const-string v7, ";"
    filled-new-array v7, [Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +036h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 61
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 2
    invoke-static v0, v2, v3, v4, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -030h
    const-string v7, "="
    const-string v8, ""
    invoke-static v0, v7, v8, Lkotlin/text/StringsKt;->substringAfter(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    return-object v1
.end method

.method private final extractHttpStatusCode(java.lang.Throwable)int
    .registers 3
    # ins_size=2
    if-eqz v2, +01dh
    instance-of v0, v2, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;
    invoke-virtual v2, Lcom/bytedance/frameworks/baselib/network/http/cronet/impl/CronetIOException;->getStatusCode()I
    move-result v2
    return v2
    instance-of v0, v2, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    invoke-virtual v2, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;->getStatusCode()I
    move-result v2
    return v2
    invoke-virtual v2, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    move-result-object v2
    goto -1ch
    const/4 v2, -1
    return v2
.end method

.method private final getHeaderValues(com.bytedance.retrofit2.SsResponse  java.lang.String)java.util.List
    .registers 7
    # ins_size=3
    if-nez v5, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    return-object v5
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v5
    const-string v0, "headers(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
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
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    const/16 v6, 10
    invoke-static v0, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v5, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-interface v5, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v5, Ljava/util/List;
    return-object v5
.end method

.method private final isTransientError(java.lang.Throwable)boolean
    .registers 6
    # ins_size=2
    invoke-virtual v5, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +010h
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v0, +004h
    const-string v0, ""
    instance-of v1, v5, Ljava/net/SocketException;
    if-nez v1, +053h
    instance-of v5, v5, Ljava/net/SocketTimeoutException;
    if-nez v5, +04fh
    check-cast v0, Ljava/lang/CharSequence;
    const-string v5, "broken pipe"
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +040h
    const-string v5, "connection reset"
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +036h
    const-string v5, "connection abort"
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +02ch
    const-string/jumbo v5, timeout
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +021h
    const-string v5, "eof"
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +017h
    const-string/jumbo v5, stream was reset
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00ch
    const-string v5, "err_name_not_resolved"
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    const/4 v1, 1
    return v1
.end method

.method public static synthetic onLoginContinueByDeviceLimit$default(com.bytedance.trae.login.traeauth.TraeAuthManager  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +003h
    const/4 v1, 0
    and-int/lit8 v3, v3, 2
    if-eqz v3, +005h
    const-string/jumbo v2, unknown
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onLoginContinueByDeviceLimit(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic onPassportLoginSuccess$default(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +005h
    const-string/jumbo v1, unselected
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onPassportLoginSuccess(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method

.method private final parseResponse(com.bytedance.retrofit2.SsResponse  java.lang.Class)com.bytedance.trae.login.traeauth.TraeAuthManager$TraeResponseWithRaw
    .registers 7
    # ins_size=3
    if-eqz v5, +032h
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    goto +28h
    const-class v1, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    check-cast v1, Ljava/lang/reflect/Type;
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/reflect/Type;
    const/4 v3, 0
    aput-object v6, v2, v3
    invoke-static v1, v2, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v6
    invoke-virtual v6, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v1
    invoke-virtual v1, v0, v6, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v6, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;-><init>(Lcom/bytedance/trae/login/traeauth/TraeResponse; Lcom/bytedance/retrofit2/SsResponse;)V
    return-object v0
    const/4 v5, 0
    return-object v5
.end method

.method private final parseResponse(java.lang.String  java.lang.Class)com.bytedance.trae.login.traeauth.TraeResponse
    .registers 6
    # ins_size=3
    if-nez v4, +004h
    const/4 v4, 0
    return-object v4
    const-class v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    check-cast v0, Ljava/lang/reflect/Type;
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/reflect/Type;
    const/4 v2, 0
    aput-object v5, v1, v2
    invoke-static v0, v1, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    invoke-virtual v0, v4, v5, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    return-object v4
.end method

.method private final performExchangeAndPersist(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback)void
    .registers 10
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isExchangeRequesting Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;
    const/4 v4, 0
    invoke-direct v0, v8, v9, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static synthetic refreshIDEAccessTokenIfNeeded$default(com.bytedance.trae.login.traeauth.TraeAuthManager  com.bytedance.trae.login.traeauth.TokenRefreshTrigger  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->refreshIDEAccessTokenIfNeeded(Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method

.method public static synthetic reportLoginFunnel$default(com.bytedance.trae.login.traeauth.TraeAuthManager  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 29
    # ins_size=14
    move/from16 v0, v27
    and-int/lit8 v1, v0, 4
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v1, v0, 8
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v20
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v21
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v1, v0, 128
    if-eqz v1, +009h
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v11, v1
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v25
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +004h
    move-object v14, v2
    goto +3h
    move-object/from16 v14, v26
    move-object v3, v15
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    invoke-virtual/range v3 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final reportTokenRefresh(boolean  long  java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=6
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, result
    if-eqz v4, +006h
    const-string/jumbo v4, success
    goto +3h
    const-string v4, "failure"
    invoke-virtual v0, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v7, +007h
    const-string v4, "error_code"
    invoke-virtual v0, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string v7, "duration_ms"
    const-wide/16 v1, 0
    invoke-static v5, v6, v1, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v5
    invoke-virtual v4, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    if-eqz v8, +00eh
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v6, reason_detail
    invoke-virtual v5, v6, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +2h
    const/4 v5, 0
    const-string v6, "icube_token_refresh"
    invoke-static v6, v0, v4, v5, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +1dh
    move-exception v4
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, reportTokenRefresh failed: 
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v6, "TraeAuthManager"
    invoke-virtual v5, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x0
.end method

.method static synthetic reportTokenRefresh$default(com.bytedance.trae.login.traeauth.TraeAuthManager  boolean  long  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v11, v13, 8
    if-eqz v11, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move v2, v8
    move-wide v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportTokenRefresh(Z J Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final retryOnTransient(int  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 41
    # ins_size=6
    move-object/from16 v0, v40
    instance-of v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;
    iget v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->label I
    move-object/from16 v2, v35
    goto +8h
    new-instance v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;
    move-object/from16 v2, v35
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->label I
    const/16 v5, 47
    const/4 v6, 2
    const-string/jumbo v7, retryOnTransient[
    const-string v8, "TraeAuthManager"
    const/4 v9, 1
    if-eqz v4, +05ch
    if-eq v4, v9, +02dh
    if-ne v4, v6, +023h
    iget v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$2 I
    iget v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$1 I
    iget v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$0 I
    iget-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$3 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v13, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$2 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/functions/Function1;
    iget-object v14, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$1 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$0 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v32, v7
    move v7, v6
    move-object v6, v13
    move-object v13, v12
    move v12, v5
    goto/16 +190h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$3 I
    iget v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$2 I
    iget v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$1 I
    iget v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$0 I
    iget-object v13, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$3 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v14, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$2 Ljava/lang/Object;
    check-cast v14, Lkotlin/jvm/functions/Function1;
    iget-object v15, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$1 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    iget-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +074h
    move-exception v0
    move-object/from16 v33, v15
    move-object v15, v6
    move-object v6, v14
    move-object/from16 v14, v33
    move-object/from16 v34, v13
    move v13, v10
    move v10, v11
    move v11, v12
    move-object/from16 v12, v34
    goto/16 +071h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    add-int/lit8 v4, v36, 1
    const/4 v6, 0
    move-object v10, v0
    move-object v11, v1
    move-object v12, v3
    move v14, v4
    move v13, v6
    move/from16 v1, v36
    move-object/from16 v3, v37
    move-object/from16 v4, v38
    move-object/from16 v6, v39
    if-ge v13, v14, +1bch
    if-lez v13, +02eh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    invoke-direct v15, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v15, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    const-string v9, "]: attempt #"
    invoke-virtual v15, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    add-int/lit8 v15, v13, 1
    invoke-virtual v9, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    add-int/lit8 v15, v1, 1
    invoke-virtual v9, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v8, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v3, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$0 Ljava/lang/Object;
    iput-object v4, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$1 Ljava/lang/Object;
    iput-object v6, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$2 Ljava/lang/Object;
    iput-object v10, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$3 Ljava/lang/Object;
    iput v1, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$0 I
    iput v14, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$1 I
    iput v13, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$2 I
    iput v13, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$3 I
    const/4 v9, 1
    iput v9, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->label I
    invoke-interface v6, v11, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v12, +003h
    return-object v12
    return-object v0
    move-exception v0
    move-object v15, v3
    move-object v3, v12
    move-object v12, v10
    move v10, v14
    move-object v14, v4
    move v4, v13
    move-object/from16 v33, v11
    move v11, v1
    move-object/from16 v1, v33
    iput-object v0, v12, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->isRetryable()Z
    move-result v9
    const-string v5, ", isRetryable="
    const-string v2, "] "
    move-object/from16 v36, v3
    const-string v3, ": ["
    if-eqz v9, +10dh
    if-ge v4, v11, +10bh
    const-wide/16 v30, 0
    move/from16 v37, v10
    if-nez v4, +007h
    move/from16 v38, v13
    move-wide/from16 v9, v30
    goto +8h
    int-to-long v9, v4
    const-wide/16 v16, 500
    mul-long v9, v9, v16
    move/from16 v38, v13
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    move-object/from16 v39, v12
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    move-object/from16 v32, v7
    const-string v7, "]: retry #"
    invoke-virtual v12, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    add-int/lit8 v4, v4, 1
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const/16 v12, 47
    invoke-virtual v7, v12, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->isRetryable()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", delay="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "ms"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v13, v8, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v16, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v17, transient_retry
    const/16 v19, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v21
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "attempt_"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ": "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v22
    const/16 v23, 0
    const/16 v24, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getLogId()Ljava/lang/String;
    move-result-object v25
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 1732
    const/16 v29, 0
    move-object/from16 v18, v14
    move-object/from16 v20, v15
    invoke-static/range v16 ... v29, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    cmp-long v0, v9, v30
    if-lez v0, +035h
    iput-object v15, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$1 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$2 Ljava/lang/Object;
    move-object/from16 v13, v39
    iput-object v13, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->L$3 Ljava/lang/Object;
    iput v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$0 I
    move/from16 v0, v37
    iput v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$1 I
    move/from16 v2, v38
    iput v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->I$2 I
    const/4 v7, 2
    iput v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$retryOnTransient$1;->label I
    invoke-static v9, v10, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    move-object/from16 v4, v36
    if-ne v3, v4, +003h
    return-object v4
    move v10, v0
    move-object v3, v4
    move v4, v2
    move-object v0, v3
    move-object v3, v15
    const/4 v9, 1
    move/from16 v33, v11
    move-object v11, v1
    move/from16 v1, v33
    move-object/from16 v34, v13
    move v13, v4
    move-object v4, v14
    move v14, v10
    move-object/from16 v10, v34
    goto +19h
    move-object/from16 v4, v36
    move/from16 v0, v37
    move/from16 v2, v38
    move-object/from16 v13, v39
    const/4 v7, 2
    move-object v10, v13
    move-object v3, v15
    const/4 v9, 1
    move v13, v2
    move-object/from16 v33, v14
    move v14, v0
    move-object v0, v4
    move-object/from16 v4, v33
    move/from16 v34, v11
    move-object v11, v1
    move/from16 v1, v34
    add-int/2addr v13, v9
    move-object/from16 v2, v35
    move v5, v12
    move-object/from16 v7, v32
    move-object v12, v0
    goto/16 -170h
    move-object/from16 v32, v7
    const/4 v9, 1
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    move-object/from16 v7, v32
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "]: giving up after attempt #"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    add-int/2addr v4, v9
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->isRetryable()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v8, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v15, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->setStep(Ljava/lang/String;)V
    throw v0
    iget-object v0, v10, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-virtual v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->setStep(Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Throwable;
    throw v0
    :try_start_0x77
    :try_start_0xa8
.end method

.method static synthetic retryOnTransient$default(com.bytedance.trae.login.traeauth.TraeAuthManager  int  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +004h
    const-string v8, ""
    move-object v2, v8
    and-int/lit8 v8, v12, 4
    if-eqz v8, +003h
    const/4 v9, 0
    move-object v3, v9
    move-object v0, v6
    move v1, v7
    move-object v4, v10
    move-object v5, v11
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->retryOnTransient(I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    return-object v6
.end method

.method private final toLoginType(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +0000052h
    goto +4ch
    const-string/jumbo v0, one_click
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +42h
    const-string/jumbo v2, one_tap
    goto +3fh
    const-string/jumbo v0, phone
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +027h
    goto +34h
    const-string v0, "email"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +01eh
    goto +2bh
    const-string v0, "google"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +015h
    goto +22h
    const-string v0, "github"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00ch
    goto +19h
    const-string v0, "douyin"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +10h
    move-object v2, v0
    goto +fh
    const-string v0, "bytecloud"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +5h
    const-string/jumbo v2, sso
    goto +2h
    const/4 v2, 0
    return-object v2
    nop 
    sparse-switch-payload -7a0d1dd3 -4f082e2c -4a3ee41d -49eca1c7 5c24b9c 65b3d6e 7304f26f
.end method

.method public final bindDevice(java.lang.String  com.bytedance.trae.login.traeauth.DeviceInfo  com.bytedance.trae.login.traeauth.DeviceProof  kotlin.coroutines.Continuation)java.lang.Object
    .registers 32
    # ins_size=5
    move-object/from16 v1, v27
    move-object/from16 v0, v28
    const-string v2, "ms"
    const-string v3, "TraeAuthManager"
    const-string v4, "bindDevice: response received in "
    move-object v5, v0
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    const/4 v6, 0
    const/4 v7, 1
    if-nez v5, +004h
    move v5, v7
    goto +2h
    move v5, v6
    if-nez v5, +237h
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getCloudideSession()Ljava/lang/String;
    move-result-object v5
    move-object v8, v5
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +004h
    move v8, v7
    goto +2h
    move v8, v6
    if-nez v8, +207h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    sget-object v10, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v15
    new-instance v10, Ljava/util/LinkedHashMap;
    invoke-direct v10, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v10, Ljava/util/Map;
    const-string v11, "Cookie"
    const-string v12, "X-Cloudide-Session"
    invoke-static v12, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    invoke-direct v1, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->buildCookieHeader(Ljava/util/Map;)Ljava/lang/String;
    move-result-object v5
    invoke-interface v10, v11, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v5, "Content-Type"
    const-string v11, "application/json"
    invoke-interface v10, v5, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v11, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v12, trae_auth
    const-class v13, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    const/4 v14, 0
    const/16 v17, 0
    const/16 v18, 36
    const/16 v19, 0
    move-object/from16 v16, v10
    invoke-static/range v11 ... v19, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    new-instance v10, Lcom/bytedance/trae/login/traeauth/BindDeviceRequest;
    move-object/from16 v11, v29
    move-object/from16 v12, v30
    invoke-direct v10, v0, v11, v12, Lcom/bytedance/trae/login/traeauth/BindDeviceRequest;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof;)V
    new-instance v0, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v0, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    iput-boolean v7, v0, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    invoke-interface v5, v10, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;->bindDeviceRaw(Lcom/bytedance/trae/login/traeauth/BindDeviceRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    const/4 v10, 0
    if-nez v5, +046h
    move-object v5, v1
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03ch
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v5, "in(...)"
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v5, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v11, Ljava/io/InputStreamReader;
    invoke-direct v11, v0, v5, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v11, Ljava/io/Reader;
    instance-of v0, v11, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v11, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v5, 8192
    invoke-direct v0, v11, v5, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v11, v0
    check-cast v11, Ljava/io/Closeable;
    move-object v0, v11
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v0
    invoke-static v11, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    move-object v5, v0
    goto +bh
    move-exception v0
    move-object v4, v0
    throw v4
    move-exception v0
    move-object v5, v0
    invoke-static v11, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v5
    move-object v5, v10
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v12
    sub-long/2addr v12, v8
    invoke-virtual v11, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;
    invoke-direct v1, v5, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->parseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/traeauth/TraeResponse;
    move-result-object v0
    if-eqz v0, +09fh
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v2
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v10
    if-eqz v10, +078h
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getStandardCode()Ljava/lang/String;
    move-result-object v0
    const-string v2, "040034"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +018h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v12
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 62
    const/16 v19, 0
    move-object v11, v0
    invoke-direct/range v11 ... v19, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;-><init>(Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "bindDevice business error: ["
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, "] "
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v12
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "bindDevice failed: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 232
    const/16 v21, 0
    move-object v11, v0
    invoke-direct/range v11 ... v21, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResult()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;
    if-nez v0, +014h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;
    const/4 v8, 0
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v9
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 61
    const/4 v15, 0
    move-object v7, v0
    invoke-direct/range v7 ... v15, Lcom/bytedance/trae/login/traeauth/BindDeviceResult;-><init>(Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "bindDevice: response body is null"
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v5, 0
    const-string v6, "bindDevice response body is null"
    const/4 v7, 1
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 248
    const/4 v14, 0
    move-object v4, v0
    invoke-direct/range v4 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    move-exception v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "bindDevice network exception: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v6, 32
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", elapsed="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sub-long/2addr v6, v8
    invoke-virtual v5, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    move-object v9, v0
    check-cast v9, Ljava/lang/Throwable;
    invoke-direct v1, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractHttpStatusCode(Ljava/lang/Throwable;)I
    move-result v2
    const/16 v3, 401
    if-ne v2, v3, +015h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const-string v6, "20311"
    const-string v7, "bindDevice: HTTP 401 - session invalid"
    const/4 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 240
    const/4 v15, 0
    move-object v5, v0
    invoke-direct/range v5 ... v15, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v6, 0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "bindDevice network error: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v1, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isTransientError(Ljava/lang/Throwable;)Z
    move-result v8
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 240
    const/4 v15, 0
    move-object v5, v2
    invoke-direct/range v5 ... v15, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/16 v17, 0
    const-string v18, "bindDevice: cloudideSession is empty"
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 248
    const/16 v26, 0
    move-object/from16 v16, v0
    invoke-direct/range v16 ... v26, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v3, 0
    const-string v4, "bindDevice: refreshToken is empty"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 248
    const/4 v12, 0
    move-object v2, v0
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x32
    :try_start_0xbf
    :try_start_0xc8
    :try_start_0xcf
    :try_start_0xd2
.end method

.method public final bindDeviceAsync(kotlin.jvm.functions.Function1)void
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;
    const/4 v4, 0
    invoke-direct v3, v7, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$bindDeviceAsync$1;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final clearAuthData()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->clear()V
    return-void 
.end method

.method public final clearRefreshToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 34
    # ins_size=3
    move-object/from16 v1, v31
    move-object/from16 v0, v32
    move-object/from16 v2, v33
    const-string v3, "clearRefreshToken: response received in "
    instance-of v4, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;
    if-eqz v4, +012h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;
    iget v5, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v2, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->label I
    sub-int/2addr v2, v6
    iput v2, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;
    invoke-direct v4, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->label I
    const/4 v7, 0
    const-string v8, "TraeAuthManager"
    const/4 v9, 1
    if-eqz v6, +01eh
    if-ne v6, v9, +014h
    iget-wide v5, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->J$0 J
    iget-object v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->L$1 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v4, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +08fh
    move-exception v0
    goto/16 +156h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    move v2, v9
    goto +2h
    move v2, v7
    if-nez v2, +1e2h
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getCloudideSession()Ljava/lang/String;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +004h
    move v6, v9
    goto +2h
    move v6, v7
    if-nez v6, +1b2h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v10
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v16
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-direct v6, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v6, Ljava/util/Map;
    const-string v12, "Cookie"
    const-string v13, "X-Cloudide-Session"
    invoke-static v13, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->buildCookieHeader(Ljava/util/Map;)Ljava/lang/String;
    move-result-object v2
    invoke-interface v6, v12, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v2, "Content-Type"
    const-string v12, "application/json"
    invoke-interface v6, v2, v12, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v12, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v13, trae_auth
    const-class v14, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    const/4 v15, 0
    const/16 v18, 0
    const/16 v19, 36
    const/16 v20, 0
    move-object/from16 v17, v6
    invoke-static/range v12 ... v20, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    new-instance v6, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenRequest;
    sget-object v12, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v12, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getClientId()Ljava/lang/String;
    move-result-object v12
    invoke-direct v6, v12, v0, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    iput-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->L$0 Ljava/lang/Object;
    iput-object v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->L$1 Ljava/lang/Object;
    iput-wide v10, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->J$0 J
    iput v9, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$clearRefreshToken$1;->label I
    invoke-interface v2, v6, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;->clearRefreshToken(Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    move-object v4, v1
    move-wide v5, v10
    check-cast v2, Lcom/bytedance/retrofit2/SsResponse;
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    sub-long/2addr v11, v5
    invoke-virtual v10, v11, v12, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v10, "ms, deviceId="
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;
    invoke-direct v4, v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->parseResponse(Lcom/bytedance/retrofit2/SsResponse; Ljava/lang/Class;)Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;
    move-result-object v0
    const/4 v2, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;->getResponse()Lcom/bytedance/trae/login/traeauth/TraeResponse;
    move-result-object v0
    goto +2h
    move-object v0, v2
    if-eqz v0, +078h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v2
    if-nez v2, +019h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResult()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;
    if-nez v0, +010h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;
    invoke-static v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v9
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 6
    const/4 v13, 0
    move-object v8, v0
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;-><init>(Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "clearRefreshToken business error: ["
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "] "
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v8, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v10
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "clearRefreshToken failed: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    const/4 v12, 0
    const/4 v13, 0
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 232
    const/16 v19, 0
    move-object v9, v0
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "clearRefreshToken: response body is null"
    invoke-virtual v0, v8, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v10, 0
    const-string v11, "clearRefreshToken response body is null"
    const/4 v12, 1
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 248
    const/16 v19, 0
    move-object v9, v0
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    move-exception v0
    move-object v4, v1
    move-wide v5, v10
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v7, "clearRefreshToken network exception: "
    invoke-direct v3, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v7, 32
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, ", elapsed="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    sub-long/2addr v9, v5
    invoke-virtual v3, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, "ms"
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v8, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    move-object v13, v0
    check-cast v13, Ljava/lang/Throwable;
    invoke-direct v4, v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractHttpStatusCode(Ljava/lang/Throwable;)I
    move-result v2
    const/16 v3, 401
    if-ne v2, v3, +018h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const-string v10, "20311"
    const-string v11, "clearRefreshToken: HTTP 401 - session invalid"
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 240
    const/16 v19, 0
    move-object v9, v0
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v10, 0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "clearRefreshToken network error: "
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v4, v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isTransientError(Ljava/lang/Throwable;)Z
    move-result v12
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 240
    const/16 v19, 0
    move-object v9, v2
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/16 v21, 0
    const-string v22, "clearRefreshToken: cloudideSession is empty"
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 248
    const/16 v30, 0
    move-object/from16 v20, v0
    invoke-direct/range v20 ... v30, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v3, 0
    const-string v4, "clearRefreshToken: deviceId is empty"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 248
    const/4 v12, 0
    move-object v2, v0
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x3b
    :try_start_0x74
    :try_start_0xcd
.end method

.method public final exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 42
    # ins_size=5
    move-object/from16 v9, v37
    move-object/from16 v0, v38
    move-object/from16 v1, v41
    const-string/jumbo v10, performExchangeAndPersist: success, tokenExpireAt=
    const-string v11, "listDevices failed: "
    instance-of v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;
    iget v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;
    invoke-direct v2, v9, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Lkotlin/coroutines/Continuation;)V
    move-object v12, v2
    iget-object v1, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v13
    iget v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    const-string/jumbo v14, reason
    const-string v15, "duration_ms"
    const-string/jumbo v7, success
    const-string v6, "icube_token_refresh_result"
    const-string v4, "TraeAuthManager"
    packed-switch v2, +0000497h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +486h
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    iget-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +45ah
    iget-wide v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    move-object/from16 v16, v0
    check-cast v16, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +467h
    move-exception v0
    move-object v8, v4
    const/4 v9, 0
    move-wide/from16 v35, v10
    move-object v11, v6
    move-object v10, v7
    move-wide/from16 v5, v35
    goto/16 +2fah
    move-exception v0
    move-object v8, v4
    move-object/from16 v17, v16
    const/4 v9, 0
    move-wide/from16 v35, v10
    move-object v11, v6
    move-object v10, v7
    move-wide/from16 v5, v35
    goto/16 +36dh
    move-object/from16 v41, v6
    iget-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    move-object v10, v0
    check-cast v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v25, v41
    move-object/from16 v24, v4
    move-object/from16 v26, v7
    const/4 v7, 0
    const/4 v9, 0
    const/16 v16, 1
    goto/16 +1a8h
    move-object/from16 v41, v6
    iget-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v25, v41
    move-object/from16 v24, v4
    move-object/from16 v26, v7
    const/4 v7, 0
    const/4 v9, 0
    const/16 v16, 1
    goto/16 +166h
    move-exception v0
    move-object/from16 v25, v41
    move-object/from16 v24, v4
    move-object/from16 v26, v7
    const/4 v7, 0
    const/4 v9, 0
    const/16 v16, 1
    goto/16 +183h
    move-object/from16 v41, v6
    iget-wide v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    move-object v5, v0
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +3f2h
    move-object/from16 v41, v6
    iget-wide v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    move-object v5, v0
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v25, v41
    move-object/from16 v24, v4
    move-object v4, v5
    move-object/from16 v26, v7
    const/4 v7, 0
    const/4 v9, 0
    const/16 v16, 1
    goto/16 +0d7h
    move-exception v0
    move-object v8, v4
    move-object/from16 v16, v5
    move-wide v5, v10
    const/4 v9, 0
    move-object/from16 v11, v41
    move-object v10, v7
    goto/16 +267h
    move-exception v0
    move-object v8, v4
    move-object/from16 v17, v5
    move-wide v5, v10
    const/4 v9, 0
    move-object/from16 v11, v41
    move-object v10, v7
    goto/16 +2dch
    move-object/from16 v41, v6
    iget-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    iget-boolean v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->Z$0 Z
    iget-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v8, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v25, v41
    move-object/from16 v24, v4
    move-object/from16 v26, v7
    const/4 v9, 0
    const/16 v16, 1
    move-object v4, v3
    move-object v3, v1
    move v1, v0
    move-object v0, v8
    goto/16 +06ah
    move-exception v0
    move-object/from16 v11, v41
    move-object/from16 v16, v3
    move-object v8, v4
    move-object v10, v7
    const/4 v9, 0
    goto/16 +22eh
    move-exception v0
    move-object/from16 v11, v41
    move-object/from16 v17, v3
    move-object v8, v4
    move-object v10, v7
    const/4 v9, 0
    goto/16 +2a4h
    move-object/from16 v41, v6
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    const/4 v2, 2
    const-string v3, "exchangeRefresh"
    new-instance v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$result$1;
    const/4 v8, 0
    invoke-direct v1, v0, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v18, v1
    check-cast v18, Lkotlin/jvm/functions/Function1;
    const/16 v20, 4
    const/16 v21, 0
    iput-object v9, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    move-object/from16 v1, v39
    iput-object v1, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    move/from16 v8, v40
    iput-boolean v8, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->Z$0 Z
    iput-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    move-object/from16 v23, v4
    const/4 v4, 1
    iput v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    move-object/from16 v1, v37
    move/from16 v16, v4
    move-object/from16 v24, v23
    const/4 v4, 0
    move-wide/from16 v22, v5
    move/from16 v6, v16
    move-object/from16 v5, v18
    move-object/from16 v25, v41
    move-object v6, v12
    move-object/from16 v26, v7
    move/from16 v7, v20
    const/4 v9, 0
    move-object/from16 v8, v21
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->retryOnTransient$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v13, +003h
    return-object v13
    move-object/from16 v4, v37
    move-object/from16 v2, v39
    move-object v3, v1
    move-wide/from16 v5, v22
    move/from16 v1, v40
    check-cast v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit()Ljava/lang/Boolean;
    move-result-object v7
    invoke-static/range v16, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +0c4h
    if-eqz v1, +060h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$2;
    const/4 v7, 0
    invoke-direct v1, v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$2;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-object v7, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    iput-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    const/4 v3, 2
    iput v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-static v0, v1, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v13, +003h
    return-object v13
    move-wide v10, v5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;
    invoke-direct v1, v2, v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-wide v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    const/4 v3, 3
    iput v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-static v0, v1, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v13, +2e3h
    return-object v13
    move-exception v0
    move-object/from16 v16, v4
    move-wide v5, v10
    move-object/from16 v8, v24
    move-object/from16 v11, v25
    move-object/from16 v10, v26
    goto/16 +174h
    move-exception v0
    move-object/from16 v17, v4
    move-wide v5, v10
    move-object/from16 v8, v24
    move-object/from16 v11, v25
    move-object/from16 v10, v26
    goto/16 +1e8h
    move-exception v0
    move-object/from16 v16, v4
    goto -17h
    move-exception v0
    move-object/from16 v17, v4
    goto -fh
    const/4 v7, 0
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    iput-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    const/4 v1, 4
    iput v1, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-virtual v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->listDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v13, +003h
    return-object v13
    move-object v10, v4
    check-cast v1, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->clearFirstAppUpgrade()V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
    sget-object v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->EXCHANGE Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    new-instance v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda1;
    invoke-direct v8, v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    iput-object v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-object v7, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    iput-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    const/4 v0, 5
    iput v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-virtual v3, v1, v4, v8, v12, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->showWhenReady(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v13, +003h
    return-object v13
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 +288h
    move-exception v0
    goto +3h
    move-exception v0
    move-object v10, v4
    const-string v1, "InitAppLog"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    move-result v0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    goto/16 +268h
    move-exception v0
    move-object/from16 v16, v10
    goto -79h
    move-exception v0
    move-object/from16 v17, v10
    goto -71h
    const/4 v7, 0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->clearFirstAppUpgrade()V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getTokenExpireAt()Ljava/lang/Long;
    move-result-object v8
    invoke-virtual v0, v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveJwtToken(Ljava/lang/String; Ljava/lang/Long;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00bh
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v8
    invoke-virtual v1, v0, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveRefreshToken(Ljava/lang/String; Ljava/lang/Long;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v17
    const/16 v1, 1000
    int-to-long v7, v1
    div-long v7, v17, v7
    invoke-virtual v0, v7, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveLastExchangeSuccessAt(J)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sub-long/2addr v0, v5
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getTokenExpireAt()Ljava/lang/Long;
    move-result-object v3
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v8, v24
    invoke-virtual v7, v8, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    move/from16 v11, v16
    move-object/from16 v10, v26
    invoke-virtual v7, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    invoke-virtual v7, v15, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v16, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object/from16 v11, v25
    invoke-virtual v3, v11, v7, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    const/16 v28, 1
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 12
    const/16 v34, 0
    move-object/from16 v27, v4
    move-wide/from16 v29, v0
    invoke-static/range v27 ... v34, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportTokenRefresh$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Z J Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7;
    const/4 v3, 0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-object v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    iput-wide v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->J$0 J
    const/4 v3, 6
    iput v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-static v0, v1, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v13, +1c8h
    return-object v13
    move-exception v0
    goto +16h
    move-exception v0
    goto +1eh
    move-exception v0
    move-object/from16 v11, v25
    goto +10h
    move-exception v0
    move-object/from16 v11, v25
    goto +16h
    move-exception v0
    goto +6h
    move-exception v0
    goto +eh
    move-exception v0
    move-object/from16 v8, v24
    move-object/from16 v11, v25
    move-object/from16 v10, v26
    move-object/from16 v16, v4
    goto +4ah
    move-exception v0
    move-object/from16 v8, v24
    move-object/from16 v11, v25
    move-object/from16 v10, v26
    move-object/from16 v17, v4
    goto/16 +0c0h
    move-exception v0
    move-object/from16 v8, v24
    move-object/from16 v11, v25
    move-object/from16 v10, v26
    move-object/from16 v16, v37
    move-object/from16 v2, v39
    move-wide/from16 v5, v22
    goto +31h
    move-exception v0
    move-object/from16 v8, v24
    move-object/from16 v11, v25
    move-object/from16 v10, v26
    move-object/from16 v17, v37
    move-object/from16 v2, v39
    move-wide/from16 v5, v22
    goto/16 +0a3h
    move-exception v0
    move-object/from16 v11, v41
    move-object v10, v7
    move-object/from16 v8, v23
    const/4 v9, 0
    move-wide/from16 v22, v5
    goto +14h
    move-exception v0
    move-object/from16 v11, v41
    move-object v10, v7
    move-object/from16 v8, v23
    const/4 v9, 0
    move-wide/from16 v22, v5
    goto/16 +08ah
    move-exception v0
    move-object/from16 v11, v41
    move-object v8, v4
    move-wide/from16 v22, v5
    move-object v10, v7
    const/4 v9, 0
    move-object/from16 v16, v37
    move-object/from16 v2, v39
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    sub-long/2addr v3, v5
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, performExchangeAndPersist exception: 
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v8, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v5, v10, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    invoke-virtual v5, v15, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v7, unexpected_exception
    if-nez v6, +003h
    move-object v6, v7
    invoke-virtual v5, v14, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v11, v5, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    const/16 v17, 0
    const/16 v20, 0
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    move-object/from16 v21, v7
    goto +3h
    move-object/from16 v21, v1
    const/16 v22, 4
    const/16 v23, 0
    move-wide/from16 v18, v3
    invoke-static/range v16 ... v23, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportTokenRefresh$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Z J Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12;
    const/4 v4, 0
    invoke-direct v3, v2, v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/Exception; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    const/16 v0, 9
    iput v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-static v1, v3, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v13, +0f1h
    return-object v13
    move-exception v0
    move-object/from16 v11, v41
    move-object v8, v4
    move-wide/from16 v22, v5
    move-object v10, v7
    const/4 v9, 0
    move-object/from16 v17, v37
    move-object/from16 v2, v39
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    sub-long/2addr v3, v5
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, performExchangeAndPersist failed: [
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "] "
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v8, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v5, v10, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    invoke-virtual v5, v15, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    const-string v6, ""
    const-string v7, "error_code"
    invoke-virtual v5, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +005h
    const-string/jumbo v6, unknown
    invoke-virtual v5, v14, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v11, v5, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    const/16 v18, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v21
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v22
    move-wide/from16 v19, v3
    invoke-direct/range v17 ... v22, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportTokenRefresh(Z J Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v1
    const-string v3, "20311"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +012h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v1
    const-string v3, "20101"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +4h
    move/from16 v16, v9
    goto +3h
    const/16 v16, 1
    if-eqz v16, +03fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, performExchangeAndPersist: token expired or not logged in (
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "), forcing logout"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v8, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$9;
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$9;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    iput-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    const/4 v4, 7
    iput v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-static v1, v3, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v13, +003h
    return-object v13
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10;
    const/4 v4, 0
    invoke-direct v3, v2, v0, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lcom/bytedance/trae/login/traeauth/TraeAuthException; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$0 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$1 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->L$2 Ljava/lang/Object;
    const/16 v0, 8
    iput v0, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;->label I
    invoke-static v1, v3, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v13, +003h
    return-object v13
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    packed-switch-payload 0 1 2 3 4 5 6 7 8 9
    :try_start_0x63
    :try_start_0x8e
    :try_start_0xae
    :try_start_0xd8
    :try_start_0xeb
    :try_start_0x123
    :try_start_0x153
    :try_start_0x174
    :try_start_0x18d
    :try_start_0x19d
    :try_start_0x1af
    :try_start_0x1d0
    :try_start_0x20e
    :try_start_0x221
    :try_start_0x24b
    :try_start_0x270
    :try_start_0x28b
    :try_start_0x294
    :try_start_0x2bc
    :try_start_0x2ca
    :try_start_0x2d4
.end method

.method public final getEnterpriseExchangeProvider()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->enterpriseExchangeProvider Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final listDevices(kotlin.coroutines.Continuation)java.lang.Object
    .registers 44
    # ins_size=2
    move-object/from16 v1, v42
    const-string v2, "ms"
    const-string v3, "TraeAuthManager"
    const-string v0, "listDevices: response received in "
    const-string v4, "listDevicesRaw:response:"
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getCloudideSession()Ljava/lang/String;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    const/4 v7, 1
    const/4 v8, 0
    if-nez v6, +004h
    move v6, v7
    goto +2h
    move v6, v8
    if-nez v6, +226h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    const/16 v6, 401
    sget-object v11, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v16
    new-instance v11, Ljava/util/LinkedHashMap;
    invoke-direct v11, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v11, Ljava/util/Map;
    const-string v12, "Cookie"
    const-string v13, "X-Cloudide-Session"
    invoke-static v13, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    invoke-direct v1, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->buildCookieHeader(Ljava/util/Map;)Ljava/lang/String;
    move-result-object v5
    invoke-interface v11, v12, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v5, "Content-Type"
    const-string v12, "application/json"
    invoke-interface v11, v5, v12, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v5, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v5, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    iput-boolean v7, v5, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    sget-object v12, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v13, trae_auth
    const-class v14, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    const/4 v15, 0
    const/16 v18, 0
    const/16 v19, 36
    const/16 v20, 0
    move-object/from16 v17, v11
    invoke-static/range v12 ... v20, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;
    new-instance v11, Lcom/bytedance/trae/login/traeauth/ListDevicesRequest;
    sget-object v12, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    invoke-virtual v12, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getDeviceInfo()Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    move-result-object v12
    invoke-direct v11, v12, Lcom/bytedance/trae/login/traeauth/ListDevicesRequest;-><init>(Lcom/bytedance/trae/login/traeauth/DeviceInfo;)V
    invoke-interface v7, v11, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthApi;->listDevicesRaw(Lcom/bytedance/trae/login/traeauth/ListDevicesRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v5
    invoke-interface v5, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v5
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v4
    invoke-virtual v11, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v4
    if-eq v4, v6, +102h
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    const/4 v7, 0
    if-nez v4, +045h
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v4
    if-eqz v4, +03bh
    invoke-interface v4, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v4
    const-string v5, "in(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v5, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v11, Ljava/io/InputStreamReader;
    invoke-direct v11, v4, v5, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v11, Ljava/io/Reader;
    instance-of v4, v11, Ljava/io/BufferedReader;
    if-eqz v4, +005h
    check-cast v11, Ljava/io/BufferedReader;
    goto +9h
    new-instance v4, Ljava/io/BufferedReader;
    const/16 v5, 8192
    invoke-direct v4, v11, v5, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v11, v4
    check-cast v11, Ljava/io/Closeable;
    move-object v4, v11
    check-cast v4, Ljava/io/BufferedReader;
    check-cast v4, Ljava/io/Reader;
    invoke-static v4, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v4
    invoke-static v11, v7, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v4, v0
    throw v4
    move-exception v0
    move-object v5, v0
    invoke-static v11, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v5
    move-object v4, v7
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v12
    sub-long/2addr v12, v9
    invoke-virtual v11, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    invoke-direct v1, v4, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->parseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/traeauth/TraeResponse;
    move-result-object v0
    if-eqz v0, +074h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v2
    goto +2h
    move-object v2, v7
    if-nez v2, +011h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResult()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    if-nez v0, +008h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    const/4 v2, 3
    invoke-direct v0, v7, v7, v2, v7, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;-><init>(Ljava/util/List; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "listDevices business error: ["
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "] "
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getCode()Ljava/lang/String;
    move-result-object v10
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v3, "listDevices failed: "
    invoke-direct v0, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeResponseError;->getMessage()Ljava/lang/String;
    move-result-object v14
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v15, 0
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 168
    const/16 v19, 0
    move-object v9, v0
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "listDevices: response body is null"
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v10, 0
    const-string v11, "listDevices response body is null"
    const/4 v12, 1
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 184
    const/16 v19, 0
    move-object v9, v0
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const-string v21, "20311"
    const-string v22, "listDevices: HTTP 401 - session invalid"
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 248
    const/16 v30, 0
    move-object/from16 v20, v0
    invoke-direct/range v20 ... v30, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    move-exception v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v7, "listDevices network exception: "
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v7, 32
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, ", elapsed="
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    sub-long/2addr v7, v9
    invoke-virtual v5, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->extractHttpStatusCode(Ljava/lang/Throwable;)I
    move-result v2
    if-ne v2, v6, +01eh
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const-string v32, "20311"
    const-string v33, "listDevices: HTTP 401 - session invalid"
    const/16 v34, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 240
    const/16 v41, 0
    move-object/from16 v31, v2
    move-object/from16 v35, v0
    invoke-direct/range v31 ... v41, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/16 v32, 0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "listDevices network error: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v33
    invoke-direct v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->isTransientError(Ljava/lang/Throwable;)Z
    move-result v34
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 240
    const/16 v41, 0
    move-object/from16 v31, v2
    move-object/from16 v35, v0
    invoke-direct/range v31 ... v41, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v4, 0
    const-string v5, "listDevices: cloudideSession is empty"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 248
    const/4 v13, 0
    move-object v3, v0
    invoke-direct/range v3 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x26
    :try_start_0xce
    :try_start_0xd7
    :try_start_0xdd
    :try_start_0xe0
    :try_start_0x199
.end method

.method public final onLoginContinueByDeviceLimit(com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  java.lang.String)void
    .registers 10
    # ins_size=3
    const-string v0, "loginPlatform"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;
    const/4 v4, 0
    invoke-direct v0, v9, v8, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final onPassportLoginSuccess(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback)void
    .registers 10
    # ins_size=3
    const-string v0, "loginPlatform"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;
    const/4 v4, 0
    invoke-direct v0, v8, v9, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final refreshIDEAccessTokenIfNeeded(com.bytedance.trae.login.traeauth.TokenRefreshTrigger  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback)void
    .registers 19
    # ins_size=3
    move-object/from16 v0, v16
    move-object/from16 v1, v18
    const-string/jumbo v2, trigger
    move-object/from16 v3, v17
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getRefreshToken()Ljava/lang/String;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    const/4 v5, 1
    if-nez v4, +004h
    move v4, v5
    goto +2h
    const/4 v4, 0
    const-string v6, "TraeAuthManager"
    if-eqz v4, +013h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, refreshIDEAccessTokenIfNeeded: no refresh token, skip
    invoke-virtual v2, v6, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v1, +008h
    const/4 v2, 0
    const-string v3, "No refresh token available"
    invoke-interface v1, v2, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;->onFailure(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtExpireAt()J
    move-result-wide v7
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    sub-long v9, v7, v9
    sget-object v4, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v4, Lcom/bytedance/trae/network/DebugSettings;->getForceTokenRefresh()Z
    move-result v4
    if-eqz v4, +00eh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v4, refreshIDEAccessTokenIfNeeded: forceTokenRefresh enabled, bypassing expiry check
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->performExchangeAndPersist(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v17, Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger;->ordinal()I
    move-result v3
    aget v3, v4, v3
    const-wide/32 v11, 18000000
    const-string/jumbo v13, s), performing exchange
    const-wide/16 v14, 0
    const/16 v4, 1000
    if-eq v3, v5, +061h
    const/4 v5, 2
    if-ne v3, v5, +058h
    cmp-long v3, v7, v14
    if-lez v3, +035h
    cmp-long v3, v9, v11
    if-lez v3, +031h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v7, refreshIDEAccessTokenIfNeeded: heartbeat skip, token still valid for 
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    int-to-long v7, v4
    div-long/2addr v9, v7
    invoke-virtual v5, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v5, 115
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->isFirstAppUpgrade()Z
    move-result v3
    if-eqz v3, +006h
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->performExchangeAndPersist(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    goto +6h
    if-eqz v1, +005h
    invoke-interface/range v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;->onSuccess()V
    return-void 
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v7, refreshIDEAccessTokenIfNeeded: heartbeat triggered, token expiring soon (remaining=
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    int-to-long v7, v4
    div-long/2addr v9, v7
    invoke-virtual v5, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->performExchangeAndPersist(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    goto +5ch
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    cmp-long v3, v7, v14
    if-lez v3, +035h
    cmp-long v3, v9, v11
    if-lez v3, +031h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v7, refreshIDEAccessTokenIfNeeded: cold launch skip, token still valid for 
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    int-to-long v7, v4
    div-long/2addr v9, v7
    invoke-virtual v5, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v5, 115
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->isFirstAppUpgrade()Z
    move-result v3
    if-eqz v3, +006h
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->performExchangeAndPersist(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    goto +6h
    if-eqz v1, +005h
    invoke-interface/range v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;->onSuccess()V
    return-void 
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v7, refreshIDEAccessTokenIfNeeded: cold launch, token expiring soon (remaining=
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    int-to-long v7, v4
    div-long/2addr v9, v7
    invoke-virtual v5, v9, v10, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->performExchangeAndPersist(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String)void
    .registers 17
    # ins_size=3
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2044
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long)void
    .registers 18
    # ins_size=4
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2040
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String)void
    .registers 19
    # ins_size=5
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2032
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String)void
    .registers 20
    # ins_size=6
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2016
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String)void
    .registers 21
    # ins_size=7
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 1984
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 22
    # ins_size=8
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 1920
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v21
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer)void
    .registers 23
    # ins_size=9
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 1792
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 24
    # ins_size=10
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 1536
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    move-object/from16 v9, v23
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String)void
    .registers 25
    # ins_size=11
    const/4 v11, 0
    const/16 v12, 1024
    const/4 v13, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    move-object/from16 v9, v23
    move-object/from16 v10, v24
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final reportLoginFunnel(java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String)void
    .registers 15
    # ins_size=12
    const-string v0, "icube_login_funnel"
    if-nez v4, +009h
    const-string/jumbo v4, unknown_stage
    goto +4h
    move-exception v4
    goto/16 +0b3h
    if-nez v5, +005h
    const-string/jumbo v5, unknown_platform
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, stage
    invoke-virtual v1, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "login_platform"
    invoke-virtual v1, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v7, +007h
    const-string v4, "failed_step"
    invoke-virtual v1, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v8, +007h
    const-string v4, "error_code"
    invoke-virtual v1, v4, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v10, +007h
    const-string v4, "bindStatus"
    invoke-virtual v1, v4, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v11, +00bh
    const-string v4, "httpCode"
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-virtual v1, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    if-eqz v9, +007h
    const-string v4, "fail_reason"
    invoke-virtual v1, v4, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v4, v12
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v7, 1
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    move v4, v7
    if-nez v4, +007h
    const-string v4, "log_id"
    invoke-virtual v1, v4, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v4, v13
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    move v4, v7
    if-nez v4, +008h
    const-string/jumbo v4, result
    invoke-virtual v1, v4, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v4, v14
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +008h
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    move v5, v7
    if-nez v5, +007h
    const-string v4, "bind_stage"
    invoke-virtual v1, v4, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const/4 v4, 0
    if-eqz v6, +01bh
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v7
    const-wide/16 v10, 0
    cmp-long v5, v7, v10
    if-ltz v5, +011h
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string v7, "duration_ms"
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v10
    invoke-virtual v5, v7, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    goto +2h
    move-object v5, v4
    if-eqz v9, +00dh
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v6, reason_detail
    invoke-virtual v4, v6, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-static v0, v1, v5, v4, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +1ch
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, reportLoginFunnel failed: 
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v6, "TraeAuthManager"
    invoke-virtual v5, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x4
.end method

.method public final reportStepDuration(java.lang.String  java.lang.String  long)void
    .registers 8
    # ins_size=5
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, step
    if-nez v4, +005h
    const-string/jumbo v4, unknown_step
    invoke-virtual v0, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "login_platform"
    if-nez v5, +005h
    const-string/jumbo v5, unknown_platform
    invoke-virtual v0, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string v5, "duration_ms"
    const-wide/16 v1, 0
    invoke-static v6, v7, v1, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v6
    invoke-virtual v4, v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v5, "icube_login_step_duration"
    const/4 v6, 0
    invoke-static v5, v0, v4, v6, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +1dh
    move-exception v4
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, reportStepDuration failed: 
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v6, "TraeAuthManager"
    invoke-virtual v5, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x0
.end method

.method public final setEnterpriseExchangeProvider(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->enterpriseExchangeProvider Lkotlin/jvm/functions/Function1;
    return-void 
.end method
