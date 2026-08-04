# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;
.field public final synthetic f$1:Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;
.field public final synthetic f$2:Ljava/util/Map;
.field public final synthetic f$3:Ljava/util/Map;
.field public final synthetic f$4:Ljava/lang/String;
.field public final synthetic f$5:Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;
.field public final synthetic f$6:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.anniex.AppFetchBridgeMethod  com.bytedance.trae.anniex.AbsAppFetchMethodIDL$AppFetchParamModel  java.util.Map  java.util.Map  java.lang.String  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock  java.lang.String)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;
    iput-object v2, v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;
    iput-object v3, v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$2 Ljava/util/Map;
    iput-object v4, v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$3 Ljava/util/Map;
    iput-object v5, v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$5 Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;
    iput-object v7, v0, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$6 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;
    iget-object v1, v7, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;
    iget-object v2, v7, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$2 Ljava/util/Map;
    iget-object v3, v7, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$3 Ljava/util/Map;
    iget-object v4, v7, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$5 Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;
    iget-object v6, v7, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod$$ExternalSyntheticLambda0;->f$6 Ljava/lang/String;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;->$r8$lambda$HWQavO4pOMCXDi4cgnCwRZhgMGU(Lcom/bytedance/trae/anniex/AppFetchBridgeMethod; Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel; Ljava/util/Map; Ljava/util/Map; Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Ljava/lang/String;)V
    return-void 
.end method
