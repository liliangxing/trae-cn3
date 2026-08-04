# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;
.super Ljava/lang/Object;
.source "DouyinLoginServiceImpl.kt"

.implements Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;

.field final synthetic $bindCallback:Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;
.field final synthetic $onFail:Lkotlin/jvm/functions/Function2;
.field final synthetic this$0:Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;


.method public static synthetic $r8$lambda$QMA92RavWNm6cBIn5MPdv1mw0E8(kotlin.jvm.functions.Function2)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->onSuccess$lambda$0(Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hn5niUfz_z26qXTI61M9BzoFTy0(kotlin.jvm.functions.Function2  com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->onError$lambda$1(Lkotlin/jvm/functions/Function2; Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.service.DouyinLoginServiceImpl$bindToAccount$bindCallback$1  com.bytedance.trae.login.service.DouyinLoginServiceImpl  kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->$bindCallback Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->$onFail Lkotlin/jvm/functions/Function2;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onError$lambda$1(kotlin.jvm.functions.Function2  com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse)kotlin.Unit
    .registers 4
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;->platformErrorCode Ljava/lang/String;
    if-eqz v0, +00dh
    invoke-static v0, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    const/4 v0, -1
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iget-object v3, v3, Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;->platformErrorMsg Ljava/lang/String;
    if-nez v3, +013h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_douyin_authorize_failed I
    invoke-virtual v3, v1, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v1, "getString(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v0, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onSuccess$lambda$0(kotlin.jvm.functions.Function2)kotlin.Unit
    .registers 4
    # ins_size=1
    const/4 v0, -1
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_douyin_get_auth_code_failed I
    invoke-virtual v1, v2, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-interface v3, v0, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public onError(com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse)void
    .registers 5
    # ins_size=2
    const-string v0, "msg"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v1, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->$onFail Lkotlin/jvm/functions/Function2;
    new-instance v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1$$ExternalSyntheticLambda1;
    invoke-direct v2, v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function2; Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;)V
    invoke-static v0, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onSuccess(android.os.Bundle)void
    .registers 11
    # ins_size=2
    const-string v0, "bundle"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "auth_code"
    invoke-virtual v10, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    move-object v10, v4
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +003h
    goto +3h
    const/4 v10, 0
    goto +2h
    const/4 v10, 1
    if-nez v10, +016h
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountPlatformImpl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountPlatformAPI;
    move-result-object v1
    const-string v2, "23081"
    const-string v3, "aweme_v2"
    const-wide/16 v5, 0
    const/4 v7, 0
    iget-object v10, v9, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->$bindCallback Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;
    move-object v8, v10
    check-cast v8, Lcom/ss/android/account/UserBindCallback;
    invoke-interface/range v1 ... v8, Lcom/bytedance/sdk/account/api/IBDAccountPlatformAPI;->ssoWithAuthCodeBind(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/util/Map; Lcom/ss/android/account/UserBindCallback;)V
    goto +dh
    iget-object v10, v9, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v0, v9, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1;->$onFail Lkotlin/jvm/functions/Function2;
    new-instance v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function2;)V
    invoke-static v10, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
