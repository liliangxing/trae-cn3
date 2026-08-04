# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;
.field public final synthetic f$1:I
.field public final synthetic f$2:Lcom/bytedance/sdk/account/api/call/MobileApiResponse;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity  int  com.bytedance.sdk.account.api.call.MobileApiResponse)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    iput v2, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;->f$1 I
    iput-object v3, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    iget v1, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;->f$1 I
    iget-object v2, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/sdk/account/api/call/MobileApiResponse;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1;->$r8$lambda$k-VGQcamYRVkUvWMvAtOq0h8mYc(Lcom/bytedance/trae/login/activity/PhoneBindActivity; I Lcom/bytedance/sdk/account/api/call/MobileApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
