# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/network/HubNetConnection;
.field public final synthetic f$1:Lcom/bytedance/trae/network/FrontierConfig;
.field public final synthetic f$2:Lcom/bytedance/trae/network/HubConnectionListener;


.method public synthetic constructor <init>(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/network/HubNetConnection;
    iput-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/network/FrontierConfig;
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/network/HubConnectionListener;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/network/FrontierConfig;
    iget-object v2, v3, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/network/HubConnectionListener;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$r8$lambda$9c-y2PFNBOyRrUDnLH_P8na9LXE(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
