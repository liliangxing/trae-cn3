# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/task/DeviceInfo;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.DeviceInfo)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->$r8$lambda$0Me2H8UVS0Sm7LYpBEBuVPnMyJA(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/DeviceInfo; Landroid/view/View;)V
    return-void 
.end method
