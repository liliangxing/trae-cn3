# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;
.super Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoCallback;
.source "LoginServiceImpl.kt"

.field final synthetic $onFail:Lkotlin/jvm/functions/Function1;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function0;
.field final synthetic $params:Ljava/util/Map;
.field final synthetic this$0:Lcom/bytedance/trae/login/service/LoginServiceImpl;


.method constructor <init>(com.bytedance.trae.login.service.LoginServiceImpl  java.util.Map  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->$params Ljava/util/Map;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-direct v0, Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoCallback;-><init>()V
    return-void 
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->onError(Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.information.method.update_user_info.UpdateUserInfoResponse  int)void
    .registers 3
    # ins_size=3
    iget-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->onSuccess(Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.information.method.update_user_info.UpdateUserInfoResponse)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->$params Ljava/util/Map;
    invoke-static v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl;->access$syncLocalUserInfo(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/util/Map;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfile$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method
