# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity$1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;
    return-void 
.end method

.method public final run()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$1;->lambda$onAvailable$0$com-bytedance-trae-login-activity-AccountLoginActivity$1()V
    return-void 
.end method
