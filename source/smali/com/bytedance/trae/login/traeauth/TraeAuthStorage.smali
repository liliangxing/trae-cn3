# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
.super Ljava/lang/Object;
.source "TraeAuthStorage.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
.field private static final KEY_APP_UPGRADE:Ljava/lang/String;
.field private static final KEY_BYTECLOUD_OAUTH_STATE:Ljava/lang/String;
.field private static final KEY_BYTECLOUD_OAUTH_STATE_TIMESTAMP:Ljava/lang/String;
.field private static final KEY_CLOUDIDE_SESSION:Ljava/lang/String;
.field private static final KEY_INTRANET_SSO_SEEN:Ljava/lang/String;
.field private static final KEY_JWT_EXPIRE_AT:Ljava/lang/String;
.field private static final KEY_JWT_TOKEN:Ljava/lang/String;
.field private static final KEY_LAST_EXCHANGE_SUCCESS_AT:Ljava/lang/String;
.field private static final KEY_LOGIN_BINDING_REQUIRED:Ljava/lang/String;
.field private static final KEY_LOGIN_DEVICE_CALLED:Ljava/lang/String;
.field private static final KEY_LOGIN_PLATFORM:Ljava/lang/String;
.field private static final KEY_REFRESH_EXPIRE_AT:Ljava/lang/String;
.field private static final KEY_REFRESH_TOKEN:Ljava/lang/String;
.field private static final KEY_UPLOAD_REGION:Ljava/lang/String;
.field private static final KEY_USER_INFO:Ljava/lang/String;
.field private static final KEY_USER_REGION:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static cachedUserInfo:Lcom/bytedance/trae/login/user/UserInfo;
.field private static final gson:Lcom/google/gson/Gson;
.field private static final repo:Lcom/bytedance/keva/Keva;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    sget-object v0, Lcom/bytedance/trae/keva/KevaRepos;->INSTANCE Lcom/bytedance/trae/keva/KevaRepos;
    invoke-virtual v0, Lcom/bytedance/trae/keva/KevaRepos;->getDefaultRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final clear()void
    .registers 6
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->cachedUserInfo Lcom/bytedance/trae/login/user/UserInfo;
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_cloudide_session
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, trae_refresh_token
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, trae_refresh_expire_at
    const-wide/16 v3, 0
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    const-string/jumbo v1, trae_jwt_token
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, trae_jwt_expire_at
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    const-string/jumbo v1, trae_last_exchange_success_at
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    const-string/jumbo v1, trae_user_info
    const-string/jumbo v3, {}
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, trae_user_region
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, trae_upload_region
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, trae_login_platform
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->clearBytecloudOAuthState()V
    return-void 
.end method

.method public final clearBytecloudOAuthState()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_bytecloud_oauth_state
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, trae_bytecloud_oauth_state_timestamp
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method public final clearFirstAppUpgrade()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_app_upgrade
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final getBytecloudOAuthState()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_bytecloud_oauth_state
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getBytecloudOAuthStateTimestamp()long
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_bytecloud_oauth_state_timestamp
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v0
    return-wide v0
.end method

.method public final getCloudideSession()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_cloudide_session
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getJwtExpireAt()long
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_jwt_expire_at
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v0
    return-wide v0
.end method

.method public final getJwtToken()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_jwt_token
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getLastExchangeSuccessAt()long
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_last_exchange_success_at
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v0
    return-wide v0
.end method

.method public final getLoginPlatform()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_login_platform
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getRefreshExpireAt()long
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_refresh_expire_at
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v0
    return-wide v0
.end method

.method public final getRefreshToken()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_refresh_token
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getUploadRegion()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_upload_region
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getUserInfo()com.bytedance.trae.login.user.UserInfo
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->cachedUserInfo Lcom/bytedance/trae/login/user/UserInfo;
    if-eqz v0, +003h
    return-object v0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_user_info
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-object v2
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->gson Lcom/google/gson/Gson;
    const-class v3, Lcom/bytedance/trae/login/user/UserInfo;
    invoke-virtual v1, v0, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/user/UserInfo;
    if-eqz v0, +005h
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->cachedUserInfo Lcom/bytedance/trae/login/user/UserInfo;
    goto +2h
    move-object v0, v2
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/login/user/UserInfo;
    return-object v2
    :try_start_0x12
.end method

.method public final getUserRegion()java.lang.String
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_user_region
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final hasIntranetSsoSeen()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_intranet_sso_seen
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final isFirstAppUpgrade()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_app_upgrade
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final markIntranetSsoSeen()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_intranet_sso_seen
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final saveBytecloudOAuthState(java.lang.String  long)void
    .registers 6
    # ins_size=4
    const-string/jumbo v0, state
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_bytecloud_oauth_state
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v3, trae_bytecloud_oauth_state_timestamp
    invoke-virtual v0, v3, v4, v5, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method public final saveCloudideSession(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_cloudide_session
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->clearFirstAppUpgrade()V
    return-void 
.end method

.method public final saveJwtToken(java.lang.String  java.lang.Long)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_jwt_token
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v4, +00eh
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    const-string/jumbo v1, trae_jwt_expire_at
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method public final saveLastExchangeSuccessAt(long)void
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_last_exchange_success_at
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method public final saveLoginPlatform(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, platform
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_login_platform
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final saveRefreshToken(java.lang.String  java.lang.Long)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_refresh_token
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v4, +00eh
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    const-string/jumbo v1, trae_refresh_expire_at
    invoke-virtual v0, v1, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method public final saveUploadRegion(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_upload_region
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final saveUserInfo(com.bytedance.trae.login.user.UserInfo)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, userInfo
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->cachedUserInfo Lcom/bytedance/trae/login/user/UserInfo;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, saveUserInfo: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "TraeAuthStorage"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->gson Lcom/google/gson/Gson;
    invoke-virtual v1, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v1, trae_user_info
    invoke-virtual v0, v1, v4, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final saveUserRegion(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->repo Lcom/bytedance/keva/Keva;
    const-string/jumbo v1, trae_user_region
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
