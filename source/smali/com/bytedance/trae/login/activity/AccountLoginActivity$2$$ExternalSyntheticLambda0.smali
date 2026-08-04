# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;
.field public final synthetic f$1:Lcom/bytedance/trae/login/PhoneOneKeyInfo;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity$2  com.bytedance.trae.login.PhoneOneKeyInfo)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;
    iput-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;
    iget-object v1, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity$2;->lambda$onGetPhoneOneKeyInfoSuccess$0$com-bytedance-trae-login-activity-AccountLoginActivity$2(Lcom/bytedance/trae/login/PhoneOneKeyInfo;)V
    return-void 
.end method
