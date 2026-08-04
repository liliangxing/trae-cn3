# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/im/service/PinConversationRequest;


.method public synthetic constructor <init>(com.bytedance.trae.im.service.PinConversationRequest)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/im/service/PinConversationRequest;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IPinConversationService$Companion$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/im/service/PinConversationRequest;
    check-cast v2, Lcom/bytedance/trae/im/service/IPinConversationService;
    check-cast v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->$r8$lambda$ZETAbnVAwmAPF-dS3y4Ey3xeLTs(Lcom/bytedance/trae/im/service/PinConversationRequest; Lcom/bytedance/trae/im/service/IPinConversationService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v2
    return-object v2
.end method
