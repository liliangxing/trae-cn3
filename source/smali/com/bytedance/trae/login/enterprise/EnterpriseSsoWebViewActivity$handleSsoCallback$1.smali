# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$handleSsoCallback$1;
.super Ljava/lang/Object;
.source "EnterpriseSsoWebViewActivity.kt"

.implements Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$handleSsoCallback$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onFailure(java.lang.String)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "SSO login failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "EnterpriseSsoWebView"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$handleSsoCallback$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    if-nez v4, +00dh
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_sso_login_failed I
    invoke-virtual v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v0, "getString(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v0, 0
    invoke-static v1, v4, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$handleSsoCallback$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-virtual v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->finish()V
    return-void 
.end method

.method public onSuccess()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "EnterpriseSsoWebView"
    const-string v2, "SSO login completed successfully"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$handleSsoCallback$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->access$navigateToMain(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    return-void 
.end method
