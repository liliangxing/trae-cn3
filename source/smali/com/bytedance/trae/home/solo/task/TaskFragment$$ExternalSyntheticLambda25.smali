# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/task/TaskModel;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;->f$1 Lcom/bytedance/trae/home/solo/task/TaskModel;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;->f$1 Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->$r8$lambda$NAmbT-lz_b1jnAHBK0zDTjDMaFg(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
