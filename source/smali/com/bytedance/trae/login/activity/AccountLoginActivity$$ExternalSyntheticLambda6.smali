# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    return-void 
.end method

.method public final onResult(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lambda$checkBytecloudNetwork$0$com-bytedance-trae-login-activity-AccountLoginActivity(Z)V
    return-void 
.end method
