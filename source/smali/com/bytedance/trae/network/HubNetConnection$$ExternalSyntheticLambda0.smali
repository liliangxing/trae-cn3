# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:J
.field public final synthetic f$1:Lcom/bytedance/trae/network/HubNetConnection;
.field public final synthetic f$2:Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
.field public final synthetic f$3:J


.method public synthetic constructor <init>(long  com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.HubNetConnection$PendingSend  long)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$0 J
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/network/HubNetConnection;
    iput-object v4, v0, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    iput-wide v5, v0, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$3 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-wide v0, v7, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$0 J
    iget-object v2, v7, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v3, v7, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    iget-wide v4, v7, Lcom/bytedance/trae/network/HubNetConnection$$ExternalSyntheticLambda0;->f$3 J
    check-cast v8, Ljava/lang/Boolean;
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v6
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/network/HubNetConnection;->$r8$lambda$t6B1t06vTwpGouCyUuxcreZfq_c(J Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/HubNetConnection$PendingSend; J Z)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
