# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AddReminderBridgeMethod;
.super Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL;
.source "AddReminderBridgeMethod.kt"

.field public static final $stable:I
.field private static final CODE_FAILED:I
.field private static final CODE_SUCCESS:I
.field public static final Companion:Lcom/bytedance/trae/anniex/AddReminderBridgeMethod$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/anniex/AddReminderBridgeMethod$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/anniex/AddReminderBridgeMethod$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/anniex/AddReminderBridgeMethod;->Companion Lcom/bytedance/trae/anniex/AddReminderBridgeMethod$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL;-><init>()V
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
    check-cast v2, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderParamModel;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/anniex/AddReminderBridgeMethod;->handle(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext; Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderParamModel; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V
    return-void 
.end method

.method public handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.trae.anniex.AbsAddReminderMethodIDL$AddReminderParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 15
    # ins_size=4
    const-string v0, "bridgeContext"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;->getBridgeCall()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;->getUrl()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v1, v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const/4 v2, 2
    const/4 v3, 0
    if-nez v0, +01ch
    const-class v12, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    invoke-static v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v12
    move-object v13, v12
    check-cast v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    check-cast v1, Ljava/lang/Number;
    invoke-interface v13, v1, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setCode(Ljava/lang/Number;)V
    const-string/jumbo v0, untrusted domain
    invoke-interface v13, v0, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setMsg(Ljava/lang/String;)V
    check-cast v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    invoke-static v14, v12, v3, v2, v3, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onSuccess$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    invoke-interface v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;->getOwnerActivity()Landroid/app/Activity;
    move-result-object v12
    const-string v0, "Failed"
    if-nez v12, +019h
    const-class v12, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    invoke-static v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v12
    move-object v13, v12
    check-cast v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    check-cast v1, Ljava/lang/Number;
    invoke-interface v13, v1, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setCode(Ljava/lang/Number;)V
    invoke-interface v13, v0, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setMsg(Ljava/lang/String;)V
    check-cast v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    invoke-static v14, v12, v3, v2, v3, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onSuccess$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    new-instance v4, Landroid/content/Intent;
    const-string v5, "android.intent.action.INSERT"
    invoke-direct v4, v5, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    sget-object v5, Landroid/provider/CalendarContract$Events;->CONTENT_URI Landroid/net/Uri;
    invoke-virtual v4, v5, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    const-string/jumbo v5, title
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderParamModel;->getTopic()Ljava/lang/String;
    move-result-object v6
    const-string v7, ""
    if-nez v6, +003h
    move-object v6, v7
    invoke-virtual v4, v5, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v5, "description"
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderParamModel;->getDescription()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +2h
    move-object v7, v6
    invoke-virtual v4, v5, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v5, "beginTime"
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderParamModel;->getStartTime()Ljava/lang/Number;
    move-result-object v6
    const-wide/16 v7, 0
    if-eqz v6, +007h
    invoke-virtual v6, Ljava/lang/Number;->longValue()J
    move-result-wide v9
    goto +2h
    move-wide v9, v7
    invoke-virtual v4, v5, v9, v10, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    const-string v5, "endTime"
    invoke-interface v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderParamModel;->getEndTime()Ljava/lang/Number;
    move-result-object v13
    if-eqz v13, +006h
    invoke-virtual v13, Ljava/lang/Number;->longValue()J
    move-result-wide v7
    invoke-virtual v4, v5, v7, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    invoke-virtual v12, v4, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    const-class v12, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    invoke-static v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v12
    move-object v13, v12
    check-cast v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    const/4 v4, 1
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    check-cast v4, Ljava/lang/Number;
    invoke-interface v13, v4, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setCode(Ljava/lang/Number;)V
    const-string v4, "Success"
    invoke-interface v13, v4, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setMsg(Ljava/lang/String;)V
    check-cast v12, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    invoke-static v14, v12, v3, v2, v3, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onSuccess$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +20h
    move-exception v12
    const-class v13, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    invoke-static v13, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v13
    move-object v4, v13
    check-cast v4, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;
    check-cast v1, Ljava/lang/Number;
    invoke-interface v4, v1, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setCode(Ljava/lang/Number;)V
    invoke-virtual v12, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v12
    if-nez v12, +003h
    goto +2h
    move-object v0, v12
    invoke-interface v4, v0, Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;->setMsg(Ljava/lang/String;)V
    check-cast v13, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    invoke-static v14, v13, v3, v2, v3, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onSuccess$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    :try_start_0x5f
    :try_start_0x77
.end method
