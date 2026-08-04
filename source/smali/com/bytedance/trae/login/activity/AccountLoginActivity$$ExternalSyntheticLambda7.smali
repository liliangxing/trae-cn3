# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lambda$notifyCurrentFragmentSso$1$com-bytedance-trae-login-activity-AccountLoginActivity()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
