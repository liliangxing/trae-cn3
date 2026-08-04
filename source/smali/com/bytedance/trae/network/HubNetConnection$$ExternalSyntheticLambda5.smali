# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/network/HubNetConnection;


.method public synthetic constructor <init>(com.bytedance.trae.network.HubNetConnection)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/network/HubNetConnection;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/network/HubNetConnection;
    check-cast v2, Lcom/bytedance/trae/network/SseState;
    invoke-static v0, v2, Lcom/bytedance/trae/network/HubNetConnection;->$r8$lambda$iMJEDkztJ6br82Hgx9CEq2iRwXo(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/SseState;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
