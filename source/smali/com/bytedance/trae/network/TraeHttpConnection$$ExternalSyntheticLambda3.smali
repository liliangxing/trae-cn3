# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function2;
.field public final synthetic f$1:Ljava/lang/Object;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function2  java.lang.Object)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda3;->f$0 Lkotlin/jvm/functions/Function2;
    iput-object v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda3;->f$1 Ljava/lang/Object;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda3;->f$0 Lkotlin/jvm/functions/Function2;
    iget-object v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection$$ExternalSyntheticLambda3;->f$1 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/network/TraeHttpConnection;->$r8$lambda$l-voyZFwfkAoART7GY8hmVGo2as(Lkotlin/jvm/functions/Function2; Ljava/lang/Object; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    return-object v3
.end method
