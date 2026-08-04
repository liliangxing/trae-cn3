# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    check-cast v2, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$r8$lambda$PTBG9ZeeFpXlKMlyD1Ov0XttCkA(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/home/solo/task/TaskModel;)Ljava/util/List;
    move-result-object v2
    return-object v2
.end method
