# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/network/RemoteModelItem;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  com.bytedance.trae.conversation.network.RemoteModelItem)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->$r8$lambda$NJQIgwrU-whdwN9GvlPfDMav1uA(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Landroid/view/View;)V
    return-void 
.end method
