# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/api/IAccountCallback;
.field public final synthetic f$1:Lcom/bytedance/sdk/account/api/call/UserApiResponse;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Ljava/util/Map;


.method public synthetic constructor <init>(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  java.lang.String  java.util.Map)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$4 Ljava/util/Map;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v1, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    iget-object v2, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iget-object v4, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;->f$4 Ljava/util/Map;
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$r8$lambda$7kRUMDgKnnjFkCKIWLgYm3XHIMU(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
