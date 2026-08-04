# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/products/ArtifactItem;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.ArtifactListAdapter  com.bytedance.trae.conversation.products.ArtifactItem)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/products/ArtifactItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/products/ArtifactItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->$r8$lambda$sDLutREuk1ST_GpzLoG8X_xQIRI(Lcom/bytedance/trae/conversation/products/ArtifactListAdapter; Lcom/bytedance/trae/conversation/products/ArtifactItem; Landroid/view/View;)V
    return-void 
.end method
