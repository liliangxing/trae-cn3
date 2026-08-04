# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;
.super Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;
.source "ConversationDetailFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;


.method constructor <init>(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;-><init>()V
    return-void 
.end method

.method public onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView  android.view.MotionEvent)boolean
    .registers 7
    # ins_size=3
    const-string/jumbo v0, rv
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "e"
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v5
    const/4 v0, 0
    if-eqz v5, +05ch
    const/4 v1, 1
    if-eq v5, v1, +052h
    const/4 v2, 2
    if-eq v5, v2, +006h
    const/4 v6, 3
    if-eq v5, v6, +04ch
    goto +68h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$getLastTouchY$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)Ljava/lang/Float;
    move-result-object v5
    if-eqz v5, +035h
    invoke-virtual v6, Landroid/view/MotionEvent;->getY()F
    move-result v2
    invoke-virtual v5, Ljava/lang/Float;->floatValue()F
    move-result v3
    sub-float/2addr v2, v3
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$getTouchSlop$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)I
    move-result v3
    int-to-float v3, v3
    cmpl-float v2, v2, v3
    if-lez v2, +008h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v5, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$setUserDraggedTowardOlderSinceLastCheck$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Z)V
    goto +1ah
    invoke-virtual v5, Ljava/lang/Float;->floatValue()F
    move-result v5
    invoke-virtual v6, Landroid/view/MotionEvent;->getY()F
    move-result v2
    sub-float/2addr v5, v2
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$getTouchSlop$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)I
    move-result v2
    int-to-float v2, v2
    cmpl-float v5, v5, v2
    if-lez v5, +007h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v5, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$setUserDraggedTowardNewerSinceLastCheck$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Z)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-virtual v6, Landroid/view/MotionEvent;->getY()F
    move-result v6
    invoke-static v6, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v6
    invoke-static v5, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$setLastTouchY$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/Float;)V
    goto +1fh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    const/4 v6, 0
    invoke-static v5, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$setLastTouchY$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/Float;)V
    goto +18h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-virtual v6, Landroid/view/MotionEvent;->getY()F
    move-result v6
    invoke-static v6, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v6
    invoke-static v5, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$setLastTouchY$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/Float;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v5, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$setUserDraggedTowardOlderSinceLastCheck$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Z)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;->this$0 Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    invoke-static v5, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->access$setUserDraggedTowardNewerSinceLastCheck$p(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Z)V
    return v0
.end method
