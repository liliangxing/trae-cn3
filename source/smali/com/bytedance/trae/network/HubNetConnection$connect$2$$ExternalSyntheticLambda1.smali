# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/network/HubConnectionListener;


.method public synthetic constructor <init>(com.bytedance.trae.network.HubConnectionListener)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/network/HubConnectionListener;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/network/HubConnectionListener;
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$r8$lambda$N96cjqB8H8z4g0DLgadnfLhTC9s(Lcom/bytedance/trae/network/HubConnectionListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
