# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;
.super Lcom/ss/android/account/UserBindCallback;
.source "DouyinLoginServiceImpl.kt"

.field final synthetic $onFail:Lkotlin/jvm/functions/Function2;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function0;
.field final synthetic this$0:Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;


.method public static synthetic $r8$lambda$7tUJtprFy_hulWqzVJsJzzY6OyM(kotlin.jvm.functions.Function2  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->onBindExist$lambda$1(Lkotlin/jvm/functions/Function2; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$G-lIRbUxolJNK62mLtsn8yG5_40(kotlin.jvm.functions.Function2  com.bytedance.sdk.account.api.call.UserApiResponse)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->onBindError$lambda$2(Lkotlin/jvm/functions/Function2; Lcom/bytedance/sdk/account/api/call/UserApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vDlX-XPb1szx6K_TI5sO_j8gYzI(kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->onBindSuccess$lambda$0(Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.service.DouyinLoginServiceImpl  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->$onFail Lkotlin/jvm/functions/Function2;
    invoke-direct v0, Lcom/ss/android/account/UserBindCallback;-><init>()V
    return-void 
.end method

.method private static final onBindError$lambda$2(kotlin.jvm.functions.Function2  com.bytedance.sdk.account.api.call.UserApiResponse)kotlin.Unit
    .registers 4
    # ins_size=2
    iget v0, v3, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iget-object v3, v3, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->errorMsg Ljava/lang/String;
    if-nez v3, +013h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_account_failed I
    invoke-virtual v3, v1, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v1, "getString(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v0, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onBindExist$lambda$1(kotlin.jvm.functions.Function2  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=2
    const/16 v0, 1030
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    if-nez v3, +013h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_douyin_already_bound_other I
    invoke-virtual v3, v1, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v1, "getString(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v0, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onBindSuccess$lambda$0(kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public onBindError(com.bytedance.sdk.account.api.call.UserApiResponse)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v1, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->$onFail Lkotlin/jvm/functions/Function2;
    new-instance v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda1;
    invoke-direct v2, v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function2; Lcom/bytedance/sdk/account/api/call/UserApiResponse;)V
    invoke-static v0, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onBindExist(com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=5
    const-string/jumbo v3, response
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->$onFail Lkotlin/jvm/functions/Function2;
    new-instance v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda0;
    invoke-direct v4, v3, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function2; Ljava/lang/String;)V
    invoke-static v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onBindSuccess(com.bytedance.sdk.account.api.call.UserApiResponse)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v0, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    new-instance v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda2;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-static v3, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
