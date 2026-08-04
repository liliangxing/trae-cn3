# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;
.super Ljava/lang/Object;
.source "ToolListFragment.kt"

.implements Ljava/lang/Runnable;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;


.method constructor <init>(com.bytedance.trae.conversation.chat.detail.ToolListFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public run()void
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$getBlockKey$p(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v0
    const-string v1, "AgentTool"
    if-nez v0, +020h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    move-object v2, v5
    check-cast v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[ToolList] poll: block not found for key="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$getBlockKey$p(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$computeFingerprint(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$getLastFingerprint$p(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;)Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +035h
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$setLastFingerprint$p(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment; Ljava/lang/String;)V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$flattenBlock(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[ToolList] poll: data changed, items="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$getItems$p(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;)Ljava/util/List;
    move-result-object v4
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$getAdapter$p(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;)Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;->notifyDataSetChanged()V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$isBlockRunning(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v0
    if-eqz v0, +011h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;->this$0 Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->access$getPollHandler$p(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;)Landroid/os/Handler;
    move-result-object v0
    move-object v1, v5
    check-cast v1, Ljava/lang/Runnable;
    const-wide/16 v2, 1000
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    goto +8h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "[ToolList] poll: block finished, stop polling"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
