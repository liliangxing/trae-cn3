# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/api/IAccountCallback;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/util/HashMap;


.method public synthetic constructor <init>(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  java.util.HashMap)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;->f$2 Ljava/util/HashMap;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v1, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;->f$2 Ljava/util/HashMap;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$r8$lambda$FwhWRRZb0ppOf1ewKCRzx3WKZlw(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Ljava/util/HashMap;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
