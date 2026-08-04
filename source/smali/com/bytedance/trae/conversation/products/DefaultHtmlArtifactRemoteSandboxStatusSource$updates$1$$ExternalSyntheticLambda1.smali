# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/network/HubNetConnection;
.field public final synthetic f$1:Lcom/bytedance/trae/network/HubNetMessageListener;


.method public synthetic constructor <init>(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.HubNetMessageListener)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/network/HubNetConnection;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/network/HubNetMessageListener;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/network/HubNetMessageListener;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->$r8$lambda$xKJ_VMfDH6Mx761dFxLDGhF-dKs(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/HubNetMessageListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
