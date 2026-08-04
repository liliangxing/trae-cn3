# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function3;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda16;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda16;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    check-cast v2, Lcom/bytedance/trae/home/solo/task/TaskModel;
    check-cast v3, Ljava/lang/Float;
    invoke-virtual v3, Ljava/lang/Float;->floatValue()F
    move-result v3
    check-cast v4, Ljava/lang/Float;
    invoke-virtual v4, Ljava/lang/Float;->floatValue()F
    move-result v4
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->$r8$lambda$BO0c-hQyX1j8MmMUde7dNYmhNmI(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel; F F)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
