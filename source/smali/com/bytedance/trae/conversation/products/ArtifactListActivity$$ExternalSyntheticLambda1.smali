# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.ArtifactListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$4 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$$ExternalSyntheticLambda1;->f$4 Ljava/lang/String;
    move-object v5, v7
    check-cast v5, Lcom/bytedance/trae/conversation/products/ArtifactItem;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->$r8$lambda$L1XQFsKb5pugxTvgxbDPCb9L4D4(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/ArtifactItem;)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
