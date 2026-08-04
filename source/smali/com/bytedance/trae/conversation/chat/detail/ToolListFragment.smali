# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
.super Landroidx/fragment/app/Fragment;
.source "ToolListFragment.kt"

.field private static final ARG_BLOCK_KEY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;
.field private static final POLL_INTERVAL_MS:J
.field private static final TOOL_TAG:Ljava/lang/String;
.field private adapter:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
.field private blockKey:Ljava/lang/String;
.field private final items:Ljava/util/List;
.field private lastFingerprint:Ljava/lang/String;
.field private final pollHandler:Landroid/os/Handler;
.field private final pollRunnable:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/fragment/app/Fragment;-><init>()V
    const-string v0, ""
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->blockKey Ljava/lang/String;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->items Ljava/util/List;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->lastFingerprint Ljava/lang/String;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->pollHandler Landroid/os/Handler;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;-><init>(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->pollRunnable Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;
    return-void 
.end method

.method public static final synthetic access$computeFingerprint(com.bytedance.trae.conversation.chat.detail.ToolListFragment  com.bytedance.trae.conversation.chat.block.AgentContentBlock)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->computeFingerprint(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$flattenBlock(com.bytedance.trae.conversation.chat.detail.ToolListFragment  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->flattenBlock(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.chat.detail.ToolListFragment)com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->adapter Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
    return-object v0
.end method

.method public static final synthetic access$getBlockKey$p(com.bytedance.trae.conversation.chat.detail.ToolListFragment)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->blockKey Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getItems$p(com.bytedance.trae.conversation.chat.detail.ToolListFragment)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->items Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getLastFingerprint$p(com.bytedance.trae.conversation.chat.detail.ToolListFragment)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->lastFingerprint Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getPollHandler$p(com.bytedance.trae.conversation.chat.detail.ToolListFragment)android.os.Handler
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->pollHandler Landroid/os/Handler;
    return-object v0
.end method

.method public static final synthetic access$isBlockRunning(com.bytedance.trae.conversation.chat.detail.ToolListFragment  com.bytedance.trae.conversation.chat.block.AgentContentBlock)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->isBlockRunning(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$setLastFingerprint$p(com.bytedance.trae.conversation.chat.detail.ToolListFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->lastFingerprint Ljava/lang/String;
    return-void 
.end method

.method private final appendBlockFingerprint(java.lang.StringBuilder  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    const/16 v1, 59
    const/4 v2, 0
    const/16 v3, 124
    if-eqz v0, +0a8h
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    const-string v4, "TC|"
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v4
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v4
    goto +2h
    move v4, v5
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v0
    goto +2h
    move v0, v5
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ConfirmInfo;->getConfirmStatus()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ConfirmInfo;->getBlockLevel()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v8
    if-eqz v8, +00ch
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ConfirmInfo;->getBlockCommandList()Ljava/util/List;
    move-result-object v8
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Object;->hashCode()I
    move-result v5
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto/16 +0f4h
    instance-of v0, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v0, +055h
    const-string v0, "TH|"
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getPlanItemId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getReasoningContent()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v8
    if-eqz v8, +027h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v8
    if-eqz v8, +006h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto/16 +09dh
    instance-of v0, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    const/16 v1, 125
    const/16 v2, 123
    if-eqz v0, +041h
    const-string v0, "TG|"
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getTitle()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v8
    invoke-interface v8, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v6, v7, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->appendBlockFingerprint(Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    goto -fh
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +55h
    instance-of v0, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v0, +04dh
    const-string v0, "TD|"
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getTodoWriteId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v8
    invoke-interface v8, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v6, v7, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->appendBlockFingerprint(Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    goto -fh
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +6h
    const-string v8, "OTHER;"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    return-void 
.end method

.method private final buildPlanItemContext(java.lang.String)com.bytedance.trae.conversation.chat.toolcall.PlanItemContext
    .registers 15
    # ins_size=2
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v1, "extra_conversation"
    invoke-virtual v0, v1, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/Conversation;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    goto +2h
    move-object v0, v2
    if-eqz v0, +018h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +012h
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +003h
    goto +19h
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-nez v1, +010h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v3, "extra_conversation_id"
    invoke-virtual v1, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object v7, v1
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    const/4 v5, 0
    const/4 v6, 0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    move-object v8, v2
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 102
    const/4 v12, 0
    move-object v3, v1
    move-object v4, v14
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method private final buildPlanItemContextFromGroup(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)com.bytedance.trae.conversation.chat.toolcall.PlanItemContext
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v2, -00ch
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-nez v4, +004h
    const/4 v4, 0
    return-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->buildPlanItemContext(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v4
    return-object v4
.end method

.method private final computeFingerprint(com.bytedance.trae.conversation.chat.block.AgentContentBlock)java.lang.String
    .registers 3
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->appendBlockFingerprint(Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toString(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final flattenBlock(com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 14
    # ins_size=2
    instance-of v0, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v0, +00bh
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-direct v12, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->buildPlanItemContextFromGroup(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v1
    move-object v2, v1
    goto +13h
    instance-of v1, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v1, +00eh
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v12, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->buildPlanItemContext(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v1
    goto -11h
    const/4 v1, 0
    goto -13h
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->items Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    if-eqz v0, +00eh
    check-cast v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v13
    iget-object v0, v12, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->items Ljava/util/List;
    invoke-direct v12, v13, v2, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->flattenChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/util/List;)V
    goto +43h
    instance-of v0, v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v0, +040h
    if-eqz v2, +018h
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v8
    const/4 v9, 0
    const/16 v10, 95
    const/4 v11, 0
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->copy$default(Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v0
    if-nez v0, +018h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v7
    const/4 v8, 0
    const/16 v9, 95
    const/4 v10, 0
    move-object v1, v0
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->items Ljava/util/List;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    check-cast v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v13
    invoke-direct v2, v13, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;-><init>(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method private final flattenChildren(java.util.List  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  java.util.List)void
    .registers 16
    # ins_size=4
    invoke-interface v13, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +08ah
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v1, +040h
    if-eqz v14, +019h
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v8
    const/4 v9, 0
    const/16 v10, 95
    const/4 v11, 0
    move-object v2, v14
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->copy$default(Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v1
    if-nez v1, +018h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v8
    const/4 v9, 0
    const/16 v10, 95
    const/4 v11, 0
    move-object v2, v1
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;-><init>(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    invoke-interface v15, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -4dh
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v1, +021h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-nez v2, +010h
    new-instance v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 31
    const/4 v10, 0
    move-object v3, v2
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedToolCallResult; Lcom/google/gson/JsonObject; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V
    invoke-interface v15, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -70h
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v1, +00ch
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-direct v12, v0, v14, v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->flattenChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/util/List;)V
    goto -7eh
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v1, -081h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-direct v12, v0, v14, v15, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->flattenChildren(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/util/List;)V
    goto/16 -08ch
    return-void 
.end method

.method private final isBlockRunning(com.bytedance.trae.conversation.chat.block.AgentContentBlock)boolean
    .registers 5
    # ins_size=2
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +02fh
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    instance-of v0, v4, Ljava/util/Collection;
    if-eqz v0, +00ch
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +27h
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01eh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->isBlockRunning(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v0
    if-eqz v0, -010h
    goto +37h
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v0, +00fh
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v4, v0, +003h
    goto +28h
    move v1, v2
    goto +26h
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v0, +00dh
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->isToolCallRunning(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Z
    move-result v1
    goto +17h
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v0, -013h
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    if-eqz v0, +00ch
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->isToolCallRunning(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Z
    move-result v4
    if-eqz v4, -025h
    return v1
.end method

.method private final isToolCallRunning(com.bytedance.trae.im.model.ParsedToolCallInfo)boolean
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-eqz v2, +016h
    const-string v0, "pending"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00eh
    const-string/jumbo v0, running
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_tool_list I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[ToolList] onDestroyView: blockKey="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->blockKey Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", stop polling"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentTool"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->pollHandler Landroid/os/Handler;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->pollRunnable Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;
    check-cast v1, Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->adapter Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
    invoke-super v3, Landroidx/fragment/app/Fragment;->onDestroyView()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v5, v6, v7, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v7
    const/4 v0, 0
    if-eqz v7, +009h
    const-string v1, "block_key"
    invoke-virtual v7, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v0
    if-nez v7, +004h
    const-string v7, ""
    iput-object v7, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->blockKey Ljava/lang/String;
    sget-object v7, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->blockKey Ljava/lang/String;
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v7
    const-string v1, "AgentTool"
    if-nez v7, +01ch
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v0, "[ToolList] onViewCreated: block not found for key="
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->blockKey Ljava/lang/String;
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[ToolList] onViewCreated: blockKey="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->blockKey Ljava/lang/String;
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", blockType="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v4
    invoke-interface v4, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->rv_tool_list I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView;
    new-instance v2, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    invoke-direct v2, v3, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v6, v2, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    invoke-virtual v6, v0, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->flattenBlock(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->computeFingerprint(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v7
    iput-object v7, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->lastFingerprint Ljava/lang/String;
    new-instance v7, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->items Ljava/util/List;
    invoke-direct v7, v5, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;-><init>(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment; Ljava/util/List;)V
    iput-object v7, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->adapter Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v6, v7, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v0, "[ToolList] onViewCreated: items="
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", start polling"
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->pollHandler Landroid/os/Handler;
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;->pollRunnable Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;
    check-cast v7, Ljava/lang/Runnable;
    const-wide/16 v0, 1000
    invoke-virtual v6, v7, v0, v1, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method
