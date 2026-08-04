# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$3$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity$3)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$3;->lambda$onFailed$0$com-bytedance-trae-login-activity-AccountLoginActivity$3()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
