# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "WelcomeFragment.kt"

.field final synthetic $viewConfiguration:Landroid/view/ViewConfiguration;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/WelcomeFragment;


.method constructor <init>(android.view.ViewConfiguration  com.bytedance.trae.conversation.widget.WelcomeFragment)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;->$viewConfiguration Landroid/view/ViewConfiguration;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    invoke-direct v0, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V
    return-void 
.end method

.method public onDown(android.view.MotionEvent)boolean
    .registers 3
    # ins_size=2
    const-string v0, "e"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    return v2
.end method

.method public onFling(android.view.MotionEvent  android.view.MotionEvent  float  float)boolean
    .registers 7
    # ins_size=5
    const-string v6, "e2"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    if-nez v3, +003h
    return v6
    invoke-virtual v4, Landroid/view/MotionEvent;->getX()F
    move-result v0
    invoke-virtual v3, Landroid/view/MotionEvent;->getX()F
    move-result v1
    sub-float/2addr v0, v1
    invoke-virtual v4, Landroid/view/MotionEvent;->getY()F
    move-result v4
    invoke-virtual v3, Landroid/view/MotionEvent;->getY()F
    move-result v3
    sub-float/2addr v4, v3
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v3
    invoke-static v4, Ljava/lang/Math;->abs(F)F
    move-result v4
    cmpg-float v3, v3, v4
    if-gtz v3, +003h
    return v6
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v3
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;->$viewConfiguration Landroid/view/ViewConfiguration;
    invoke-virtual v4, Landroid/view/ViewConfiguration;->getScaledPagingTouchSlop()I
    move-result v4
    int-to-float v4, v4
    cmpg-float v3, v3, v4
    if-gez v3, +003h
    return v6
    invoke-static v5, Ljava/lang/Math;->abs(F)F
    move-result v3
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;->$viewConfiguration Landroid/view/ViewConfiguration;
    invoke-virtual v4, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I
    move-result v4
    int-to-float v4, v4
    cmpg-float v3, v3, v4
    if-gez v3, +003h
    return v6
    const/4 v3, 0
    cmpg-float v3, v0, v3
    if-gez v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->access$getCurrentMode$p(Lcom/bytedance/trae/conversation/widget/WelcomeFragment;)Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v4
    if-ne v3, v4, +003h
    return v6
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$gestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->getOnModeSwipe()Lkotlin/jvm/functions/Function1;
    move-result-object v4
    if-eqz v4, +005h
    invoke-interface v4, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    const/4 v3, 1
    return v3
.end method
