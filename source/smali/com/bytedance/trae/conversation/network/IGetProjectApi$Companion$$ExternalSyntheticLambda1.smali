# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/Class;


.method public synthetic constructor <init>(java.lang.Class)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda1;->f$0 Ljava/lang/Class;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda1;->f$0 Ljava/lang/Class;
    check-cast v2, Ljava/lang/String;
    check-cast v3, Lcom/bytedance/retrofit2/SsResponse;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->$r8$lambda$o2d9ZJ1udB1OTe611HRYpB8ma14(Ljava/lang/Class; Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    return-object v2
.end method
