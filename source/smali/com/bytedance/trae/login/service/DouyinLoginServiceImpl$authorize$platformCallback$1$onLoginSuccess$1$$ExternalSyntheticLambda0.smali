# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/api/IAccountCallback;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iget-object v3, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$r8$lambda$X_iY37scyB3eA-zsfydcuMLwUGw(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
