# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$ucTwiceVerifyDepend$1$1;
.super Ljava/lang/Object;
.source "BDTuringAccount.kt"

.implements Lcom/bytedance/sdk/account/twiceverify/TwiceVerifyResultCallback;

.field final synthetic $callback:Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;


.method constructor <init>(com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyResultCallback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$ucTwiceVerifyDepend$1$1;->$callback Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onFail()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$ucTwiceVerifyDepend$1$1;->$callback Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;
    if-eqz v0, +007h
    const/4 v1, 1
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;->onResult(I Lorg/json/JSONObject;)V
    return-void 
.end method

.method public onSuccess(java.lang.String  java.lang.String  java.util.Map  java.util.Map)void
    .registers 7
    # ins_size=5
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, verifyWay
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, verifyTicket
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "bizParams"
    invoke-virtual v0, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, verifyExtraParams
    invoke-virtual v0, v3, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v3, v2, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$ucTwiceVerifyDepend$1$1;->$callback Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;
    if-eqz v3, +006h
    const/4 v4, 0
    invoke-interface v3, v4, v0, Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;->onResult(I Lorg/json/JSONObject;)V
    return-void 
.end method
