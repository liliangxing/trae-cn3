# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;
.super Ljava/lang/Object;
.source "SecurityServiceImpl.kt"

.implements Lcom/bytedance/trae/login/api/IAccountStatusListener;

.field final synthetic $appContext:Landroid/content/Context;
.field final synthetic this$0:Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;


.method public static synthetic $r8$lambda$2ocgNzB4CN12M00EX4t3HvAJfsM(com.bytedance.trae.common.security.impl.SecurityServiceImpl  android.content.Context  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;->onAccountStatusChanged$lambda$0(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.common.security.impl.SecurityServiceImpl  android.content.Context)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;->this$0 Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
    iput-object v2, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;->$appContext Landroid/content/Context;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onAccountStatusChanged$lambda$0(com.bytedance.trae.common.security.impl.SecurityServiceImpl  android.content.Context  java.lang.String  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "login"
    const/4 v4, 1
    invoke-static v1, v2, v3, v4, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->access$report(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Landroid/content/Context; Ljava/lang/String; Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public onAccountStatusChanged(com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "accountStatus"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "businessScene"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    if-ne v4, v3, +026h
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    iget-object v4, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;->this$0 Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
    iget-object v0, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;->$appContext Landroid/content/Context;
    new-instance v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Landroid/content/Context;)V
    invoke-virtual v3, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->doWhenIdsReady(Lkotlin/jvm/functions/Function2;)V
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v3
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v3, v4, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v3, +008h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/login/api/IAccountStatusListener;
    invoke-interface v3, v4, Lcom/bytedance/trae/login/api/ILoginService;->unregisterAccountStatusChangeListener(Lcom/bytedance/trae/login/api/IAccountStatusListener;)V
    return-void 
.end method
