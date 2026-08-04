# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;
.super Ljava/lang/Object;
.source "AgentMessageViewHolder.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;-><init>()V
    return-void 
.end method

.method public final create(android.view.ViewGroup  com.bytedance.trae.im.service.Conversation  com.bytedance.trae.conversation.chat.IMessageListener)com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder
    .registers 7
    # ins_size=4
    const-string v0, "parent"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_agent_message I
    const/4 v2, 0
    invoke-virtual v0, v1, v4, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$id;->content_container I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/LinearLayout;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v4, v5, v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;-><init>(Landroid/widget/LinearLayout; Lcom/bytedance/trae/im/service/Conversation; Lcom/bytedance/trae/conversation/chat/IMessageListener;)V
    return-object v0
.end method
