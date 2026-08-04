# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/im/model/MessagePart;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/IMessageListener;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Ljava/lang/String;
.field public final synthetic f$5:Ljava/lang/String;
.field public final synthetic f$6:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;
.field public final synthetic f$7:Ljava/lang/String;
.field public final synthetic f$8:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.im.model.MessagePart  com.bytedance.trae.conversation.chat.IMessageListener  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$FileViewHolder  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/model/MessagePart;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/IMessageListener;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$5 Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$6 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$7 Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$8 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/model/MessagePart;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/IMessageListener;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$5 Ljava/lang/String;
    iget-object v6, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$6 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$7 Ljava/lang/String;
    iget-object v8, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0;->f$8 Ljava/lang/String;
    move-object v9, v11
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->$r8$lambda$2deJcyUnro3C_GFUvKA57axgBc8(Lcom/bytedance/trae/im/model/MessagePart; Lcom/bytedance/trae/conversation/chat/IMessageListener; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
