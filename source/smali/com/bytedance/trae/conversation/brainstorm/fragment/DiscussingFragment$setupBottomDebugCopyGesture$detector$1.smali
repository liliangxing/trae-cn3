# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupBottomDebugCopyGesture$detector$1;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "DiscussingFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupBottomDebugCopyGesture$detector$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v0, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V
    return-void 
.end method

.method public onDoubleTap(android.view.MotionEvent)boolean
    .registers 5
    # ins_size=2
    const-string v0, "e"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->INSTANCE Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupBottomDebugCopyGesture$detector$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupBottomDebugCopyGesture$detector$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v1
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->buildDiscussionDebugLogInfo()Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    move-result-object v1
    const-string/jumbo v2, voice_discussion_debug_info
    invoke-virtual v4, v0, v2, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->copy(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;)V
    const/4 v4, 1
    return v4
.end method

.method public onDown(android.view.MotionEvent)boolean
    .registers 3
    # ins_size=2
    const-string v0, "e"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    return v2
.end method
