# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;
.super Lcom/bytedance/sdk/account/api/call/AbsApiCall;
.source "DouyinLoginServiceImpl.kt"

.field final synthetic $onFail:Lkotlin/jvm/functions/Function2;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function0;
.field final synthetic this$0:Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;


.method public static synthetic $r8$lambda$As6dw2EzrKPhPAtJoDPb8K7445Q(kotlin.jvm.functions.Function2  com.bytedance.sdk.account.api.call.BaseApiResponse)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->onResponse$lambda$1(Lkotlin/jvm/functions/Function2; Lcom/bytedance/sdk/account/api/call/BaseApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$YaUP-YD6NCVR6IRvKtIQLsYqMVc(kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->onResponse$lambda$0(Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.service.DouyinLoginServiceImpl  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->$onFail Lkotlin/jvm/functions/Function2;
    invoke-direct v0, Lcom/bytedance/sdk/account/api/call/AbsApiCall;-><init>()V
    return-void 
.end method

.method private static final onResponse$lambda$0(kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onResponse$lambda$1(kotlin.jvm.functions.Function2  com.bytedance.sdk.account.api.call.BaseApiResponse)kotlin.Unit
    .registers 3
    # ins_size=2
    iget v0, v2, Lcom/bytedance/sdk/account/api/call/BaseApiResponse;->error I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iget-object v2, v2, Lcom/bytedance/sdk/account/api/call/BaseApiResponse;->errorMsg Ljava/lang/String;
    invoke-interface v1, v0, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public onResponse(com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v4, Lcom/bytedance/sdk/account/api/call/BaseApiResponse;->success Z
    if-eqz v0, +00fh
    iget-object v4, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v0, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    new-instance v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-static v4, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    goto +dh
    iget-object v0, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v1, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->$onFail Lkotlin/jvm/functions/Function2;
    new-instance v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1;
    invoke-direct v2, v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function2; Lcom/bytedance/sdk/account/api/call/BaseApiResponse;)V
    invoke-static v0, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
