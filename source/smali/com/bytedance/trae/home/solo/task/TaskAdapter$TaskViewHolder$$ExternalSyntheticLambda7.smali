# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/task/TaskAdapter;
.field public final synthetic f$2:F
.field public final synthetic f$3:F


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  com.bytedance.trae.home.solo.task.TaskAdapter  float  float)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    iput v3, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$2 F
    iput v4, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$3 F
    return-void 
.end method

.method public final run()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    iget v2, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$2 F
    iget v3, v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder$$ExternalSyntheticLambda7;->f$3 F
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->$r8$lambda$nfXC_AzimxtnKv0ealOxopindWc(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; Lcom/bytedance/trae/home/solo/task/TaskAdapter; F F)V
    return-void 
.end method
