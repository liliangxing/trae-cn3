# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnLongClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/task/TaskAdapter;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9;->f$1 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    return-void 
.end method

.method public final onLongClick(android.view.View)boolean
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda9;->f$1 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->$r8$lambda$hgJN_9AXQSlBwRnAthYsjbolAZ4(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; Landroid/view/View;)Z
    move-result v3
    return v3
.end method
