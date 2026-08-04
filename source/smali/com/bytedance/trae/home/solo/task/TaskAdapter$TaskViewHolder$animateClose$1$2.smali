# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$animateClose$1$2;
.super Landroid/animation/AnimatorListenerAdapter;
.source "TaskAdapter.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$animateClose$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    invoke-direct v0, Landroid/animation/AnimatorListenerAdapter;-><init>()V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$animateClose$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    invoke-static v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->access$applyNormalContentBackground(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;)V
    return-void 
.end method
