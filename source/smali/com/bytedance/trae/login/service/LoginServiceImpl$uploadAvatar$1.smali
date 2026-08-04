# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;
.super Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarCallback;
.source "LoginServiceImpl.kt"

.field final synthetic $onFail:Lkotlin/jvm/functions/Function1;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function1;


.method constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-direct v0, Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarCallback;-><init>()V
    return-void 
.end method

.method public bridge synthetic onError(com.bytedance.sdk.account.api.call.BaseApiResponse  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;->onError(Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarResponse; I)V
    return-void 
.end method

.method public onError(com.bytedance.sdk.account.information.method.upload_avatar.UploadAvatarResponse  int)void
    .registers 5
    # ins_size=3
    iget-object v3, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;->$onFail Lkotlin/jvm/functions/Function1;
    int-to-long v0, v4
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    invoke-interface v3, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public bridge synthetic onSuccess(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarResponse;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;->onSuccess(Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarResponse;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.sdk.account.information.method.upload_avatar.UploadAvatarResponse)void
    .registers 5
    # ins_size=2
    const/4 v0, 0
    if-eqz v4, +015h
    iget-object v1, v4, Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarResponse;->webUri Ljava/lang/String;
    if-eqz v1, +011h
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    if-lez v1, +004h
    move v1, v2
    goto +2h
    move v1, v0
    if-ne v1, v2, +003h
    move v0, v2
    if-eqz v0, +010h
    iget-object v0, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iget-object v4, v4, Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarResponse;->webUri Ljava/lang/String;
    const-string/jumbo v1, webUri
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +ch
    iget-object v4, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatar$1;->$onFail Lkotlin/jvm/functions/Function1;
    const-wide/16 v0, -1
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-interface v4, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
