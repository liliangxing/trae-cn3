# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
.field public final synthetic f$1:Ljava/util/List;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Ljava/lang/String;
.field public final synthetic f$5:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.viewholder.UserPreviewImageItem  java.util.List  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder  java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$1 Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$5 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$1 Ljava/util/List;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;->f$5 Ljava/lang/String;
    move-object v6, v8
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->$r8$lambda$Ol-Zjk9lr0Lpnf83evmrAmcOeSA(Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
