# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroidx/recyclerview/widget/LinearLayoutManager;
.field public final synthetic f$1:I
.field public final synthetic f$2:I


.method public synthetic constructor <init>(androidx.recyclerview.widget.LinearLayoutManager  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;->f$0 Landroidx/recyclerview/widget/LinearLayoutManager;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;->f$1 I
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;->f$2 I
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;->f$0 Landroidx/recyclerview/widget/LinearLayoutManager;
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;->f$1 I
    iget v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;->f$2 I
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->lambda$9$lambda$8(Landroidx/recyclerview/widget/LinearLayoutManager; I I)V
    return-void 
.end method
