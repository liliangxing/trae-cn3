# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/network/HubNetMessageListener;

.field public final synthetic f$0:Lkotlinx/coroutines/channels/ProducerScope;


.method public synthetic constructor <init>(kotlinx.coroutines.channels.ProducerScope)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda0;->f$0 Lkotlinx/coroutines/channels/ProducerScope;
    return-void 
.end method

.method public final onMessage(int  java.lang.String  boolean)void
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda0;->f$0 Lkotlinx/coroutines/channels/ProducerScope;
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->$r8$lambda$WJlaivRNP0z6XSvpsolIL6F6cxY(Lkotlinx/coroutines/channels/ProducerScope; I Ljava/lang/String; Z)V
    return-void 
.end method
