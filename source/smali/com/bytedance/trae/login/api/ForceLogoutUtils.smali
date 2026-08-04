# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/ForceLogoutUtils;
.super Ljava/lang/Object;
.source "ForceLogoutUtils.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/api/ForceLogoutUtils;
.field private static final logoutListeners:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-direct v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->logoutListeners Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$navigateToLogin(com.bytedance.trae.login.api.ForceLogoutUtils)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->navigateToLogin()V
    return-void 
.end method

.method private final navigateToLogin()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->logoutListeners Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;
    invoke-interface v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;->navigateToLogin()V
    goto -fh
    return-void 
.end method

.method public final addOnLogoutListener(com.bytedance.trae.login.api.ForceLogoutUtils$OnLogoutListener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->logoutListeners Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final performForceLogout(android.app.Activity)void
    .registers 5
    # ins_size=2
    sget-object v4, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->logoutListeners Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;
    invoke-interface v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;->onLogout()V
    goto -fh
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v4
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v4, v0, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v4, +003h
    return-void 
    new-instance v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils$performForceLogout$2;
    invoke-direct v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils$performForceLogout$2;-><init>()V
    check-cast v0, Lcom/bytedance/trae/login/api/IAccountCallback;
    const-string/jumbo v1, risk_control
    const/4 v2, 1
    invoke-interface v4, v2, v0, v1, Lcom/bytedance/trae/login/api/ILoginService;->logout(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method public final removeOnLogoutListener(com.bytedance.trae.login.api.ForceLogoutUtils$OnLogoutListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->logoutListeners Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method
