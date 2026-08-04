# Decompiled TRAE business class
# Source DEX: classes4.dex
.class 0x0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;
.super Landroid/net/ConnectivityManager$NetworkCallback;
.source "AccountLoginActivity.java"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;


.method constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-direct v0, Landroid/net/ConnectivityManager$NetworkCallback;-><init>()V
    return-void 
.end method

.method synthetic lambda$onAvailable$0$com-bytedance-trae-login-activity-AccountLoginActivity$1()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->forceResetNetworkCache()V
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$100(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    return-void 
.end method

.method synthetic lambda$onLost$1$com-bytedance-trae-login-activity-AccountLoginActivity$1()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->access$002(Lcom/bytedance/trae/login/activity/AccountLoginActivity; Z)Z
    return-void 
.end method

.method public onAvailable(android.net.Network)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public onLost(android.net.Network)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;->this$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    new-instance v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method
