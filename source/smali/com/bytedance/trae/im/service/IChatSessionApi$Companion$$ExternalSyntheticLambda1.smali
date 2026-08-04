# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    check-cast v2, Lcom/bytedance/trae/im/service/IChatSessionApi;
    check-cast v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->$r8$lambda$nGkiixe0m07G247L8Axwg_9tGoQ(Ljava/lang/String; Lcom/bytedance/trae/im/service/IChatSessionApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v2
    return-object v2
.end method
