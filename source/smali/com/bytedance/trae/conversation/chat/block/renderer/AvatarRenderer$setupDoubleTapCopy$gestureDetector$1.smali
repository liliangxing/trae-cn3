# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "AvatarRenderer.kt"

.field final synthetic $block:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
.field final synthetic $context:Landroid/content/Context;


.method constructor <init>(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Avatar)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;->$context Landroid/content/Context;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;->$block Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-direct v0, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V
    return-void 
.end method

.method public onDoubleTap(android.view.MotionEvent)boolean
    .registers 12
    # ins_size=2
    const-string v0, "e"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->INSTANCE Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;->$context Landroid/content/Context;
    sget-object v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->INSTANCE Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;->$block Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getCreatedAt()J
    move-result-wide v2
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;->$block Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getMessageId()Ljava/lang/String;
    move-result-object v4
    iget-object v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;->$block Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    iget-object v6, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;->$block Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getSessionId()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/16 v8, 16
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->buildInfo$default(Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier; J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    move-result-object v1
    const-string v2, "avatar_debug_info"
    invoke-virtual v11, v0, v2, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->copy(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;)V
    const/4 v11, 1
    return v11
.end method

.method public onDown(android.view.MotionEvent)boolean
    .registers 3
    # ins_size=2
    const-string v0, "e"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    return v2
.end method
