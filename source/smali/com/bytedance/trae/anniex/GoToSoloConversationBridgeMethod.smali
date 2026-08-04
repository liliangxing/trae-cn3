# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/GoToSoloConversationBridgeMethod;
.super Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;
.source "GoToSoloConversationBridgeMethod.kt"

.field public static final $stable:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;-><init>()V
    return-void 
.end method

.method public canRunInBackground()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public bridge synthetic handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 4
    # ins_size=4
    check-cast v2, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$GoToSoloConversationParamModel;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/anniex/GoToSoloConversationBridgeMethod;->handle(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext; Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$GoToSoloConversationParamModel; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V
    return-void 
.end method

.method public handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.trae.anniex.AbsGoToSoloConversationMethodIDL$GoToSoloConversationParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 10
    # ins_size=4
    const-string v0, "bridgeContext"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v8, "callback"
    invoke-static v9, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;->getBridgeCall()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;->getUrl()Ljava/lang/String;
    move-result-object v8
    sget-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v0, v8, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v8
    if-nez v8, +00eh
    const/4 v1, 0
    const-string/jumbo v2, untrusted domain
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    invoke-interface v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;->getOwnerActivity()Landroid/app/Activity;
    move-result-object v7
    if-nez v7, +00dh
    const/4 v1, 0
    const-string v2, "no activity context"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    const-string v8, "com.bytedance.trae.conversation.ConversationActivity"
    invoke-static v8, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v8
    new-instance v0, Landroid/content/Intent;
    move-object v1, v7
    check-cast v1, Landroid/content/Context;
    invoke-direct v0, v1, v8, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v7, v0, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    const-class v7, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$GoToSoloConversationResultModel;
    invoke-static v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v7
    check-cast v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    const/4 v8, 2
    const/4 v0, 0
    invoke-static v9, v7, v0, v8, v0, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onSuccess$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +13h
    move-exception v7
    const/4 v1, 0
    invoke-virtual v7, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +004h
    const-string v7, "failed to navigate"
    move-object v2, v7
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    :try_start_0x2b
.end method
