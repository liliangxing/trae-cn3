# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAccountTask$appBackgroundListener$1;
.super Ljava/lang/Object;
.source "InitAccountTask.kt"

.implements Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAllActivityDestroyed()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public onAppBackground()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public onAppForeground()void
    .registers 5
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +010h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger;->FOREGROUND_HEARTBEAT Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger;
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v0, v1, v3, v2, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->refreshIDEAccessTokenIfNeeded$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->validateOnForegroundIfNeeded()V
    return-void 
.end method
