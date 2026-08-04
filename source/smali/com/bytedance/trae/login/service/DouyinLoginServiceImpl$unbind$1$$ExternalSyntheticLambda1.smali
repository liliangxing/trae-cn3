# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function2;
.field public final synthetic f$1:Lcom/bytedance/sdk/account/api/call/BaseApiResponse;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function2  com.bytedance.sdk.account.api.call.BaseApiResponse)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function2;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/sdk/account/api/call/BaseApiResponse;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function2;
    iget-object v1, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/sdk/account/api/call/BaseApiResponse;
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1;->$r8$lambda$As6dw2EzrKPhPAtJoDPb8K7445Q(Lkotlin/jvm/functions/Function2; Lcom/bytedance/sdk/account/api/call/BaseApiResponse;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
