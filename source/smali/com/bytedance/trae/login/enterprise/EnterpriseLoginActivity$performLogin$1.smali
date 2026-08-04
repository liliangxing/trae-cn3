# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;
.super Ljava/lang/Object;
.source "EnterpriseLoginActivity.kt"

.implements Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onFailure(java.lang.String)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Enterprise login failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "EnterpriseLoginActivity"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$setLoginLoading(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Z)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    if-nez v4, +00dh
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v1, "getString(...)"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$showError(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Ljava/lang/String;)V
    return-void 
.end method

.method public onSuccess()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "EnterpriseLoginActivity"
    const-string v2, "Enterprise login success"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    const/4 v1, 1
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$setLoginSuccess$p(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity; Z)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performLogin$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$navigateToMain(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    return-void 
.end method
