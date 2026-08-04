# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1;
.super Ljava/lang/Object;
.source "InitAccountTask.kt"

.implements Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;


.method public static synthetic $r8$lambda$JSPW4DpaYhXaKr_rAN8GPoLbnHM(android.app.Activity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1;->navigateToLogin$lambda$0(Landroid/app/Activity;)V
    return-void 
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final navigateToLogin$lambda$0(android.app.Activity)void
    .registers 4
    # ins_size=1
    move-object v0, v3
    check-cast v0, Landroid/content/Context;
    const v1, 2131689845
    const/4 v2, 1
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    new-instance v1, Landroid/content/Intent;
    invoke-direct v1, Landroid/content/Intent;-><init>()V
    const-string v2, "com.bytedance.trae.login.activity.AccountLoginActivity"
    invoke-virtual v1, v0, v2, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v0, 268468224
    invoke-virtual v1, v0, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v1, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public navigateToLogin()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    new-instance v1, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1$$ExternalSyntheticLambda0;-><init>(Landroid/app/Activity;)V
    invoke-virtual v0, v1, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public onLogout()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseManager;->onUserLogout()V
    return-void 
.end method
