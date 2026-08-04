# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;
.field public final synthetic f$1:Lcom/bytedance/sdk/account/AccountSdkResponse;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity  com.bytedance.sdk.account.AccountSdkResponse)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/sdk/account/AccountSdkResponse;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    iget-object v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/sdk/account/AccountSdkResponse;
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2;->$r8$lambda$x3NFK7J121aa55AY-s7UltGi5sE(Lcom/bytedance/trae/login/activity/PhoneBindActivity; Lcom/bytedance/sdk/account/AccountSdkResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
