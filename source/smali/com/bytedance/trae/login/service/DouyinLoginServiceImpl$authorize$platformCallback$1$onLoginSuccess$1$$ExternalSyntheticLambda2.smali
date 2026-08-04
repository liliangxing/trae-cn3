# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/sdk/account/api/call/UserApiResponse;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/trae/login/api/IAccountCallback;


.method public synthetic constructor <init>(com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  com.bytedance.trae.login.api.IAccountCallback)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/login/api/IAccountCallback;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    iget-object v1, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/login/api/IAccountCallback;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$r8$lambda$Vx-qr3l55blpf6VeZY1cbImmmB8(Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Lcom/bytedance/trae/login/api/IAccountCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
