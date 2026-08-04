# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    iget-object v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lambda$listDevicesAndNotify$5$com-bytedance-trae-login-activity-AccountLoginActivity(Ljava/lang/String;)V
    return-void 
.end method
