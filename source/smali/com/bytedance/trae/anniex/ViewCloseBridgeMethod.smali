# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/ViewCloseBridgeMethod;
.super Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL;
.source "ViewCloseBridgeMethod.kt"

.field public static final $stable:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL;-><init>()V
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
    check-cast v2, Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL$ViewCloseParamModel;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/anniex/ViewCloseBridgeMethod;->handle(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext; Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL$ViewCloseParamModel; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V
    return-void 
.end method

.method public handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.trae.anniex.AbsViewCloseMethodIDL$ViewCloseParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 10
    # ins_size=4
    const-string v0, "bridgeContext"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v8, "callback"
    invoke-static v9, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-virtual v7, Landroid/app/Activity;->finish()V
    const-class v7, Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL$ViewCloseResultModel;
    invoke-static v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL$ViewCloseResultModel;
    const/4 v8, 0
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    check-cast v8, Ljava/lang/Number;
    invoke-interface v7, v8, Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL$ViewCloseResultModel;->setCode(Ljava/lang/Number;)V
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
    const-string v7, "failed to close"
    move-object v2, v7
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    :try_start_0xf
.end method
