# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/ToastBridgeMethod;
.super Lcom/bytedance/trae/anniex/AbsToastMethodIDL;
.source "ToastBridgeMethod.kt"

.field public static final $stable:I


.method public static synthetic $r8$lambda$UTcDFyvLxC7tT_2lc6JSSfYoDps(android.app.Activity  java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/anniex/ToastBridgeMethod;->handle$lambda$0(Landroid/app/Activity; Ljava/lang/String; I)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AbsToastMethodIDL;-><init>()V
    return-void 
.end method

.method private static final handle$lambda$0(android.app.Activity  java.lang.String  int)void
    .registers 3
    # ins_size=3
    check-cast v0, Landroid/content/Context;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
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
    check-cast v2, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/anniex/ToastBridgeMethod;->handle(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext; Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V
    return-void 
.end method

.method public handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.trae.anniex.AbsToastMethodIDL$ToastParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 10
    # ins_size=4
    const-string v0, "bridgeContext"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;->getOwnerActivity()Landroid/app/Activity;
    move-result-object v7
    if-nez v7, +00dh
    const/4 v1, 0
    const-string v2, "no context"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    invoke-interface v8, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel;->getText()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel;->getDuration()Ljava/lang/Number;
    move-result-object v8
    const/4 v1, 0
    if-eqz v8, +007h
    invoke-virtual v8, Ljava/lang/Number;->intValue()I
    move-result v8
    goto +2h
    move v8, v1
    const/16 v2, 2000
    const/4 v3, 1
    if-le v8, v2, +003h
    move v1, v3
    new-instance v8, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v2
    invoke-direct v8, v2, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v2, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;
    invoke-direct v2, v7, v0, v1, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;-><init>(Landroid/app/Activity; Ljava/lang/String; I)V
    invoke-virtual v8, v2, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    const-class v7, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastResultModel;
    invoke-static v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastResultModel;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    check-cast v8, Ljava/lang/Number;
    invoke-interface v7, v8, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastResultModel;->setCode(Ljava/lang/Number;)V
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v8
    invoke-interface v7, v8, Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastResultModel;->setData(Ljava/lang/Object;)V
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
    const-string v7, "failed to show toast"
    move-object v2, v7
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    :try_start_0xf
.end method
