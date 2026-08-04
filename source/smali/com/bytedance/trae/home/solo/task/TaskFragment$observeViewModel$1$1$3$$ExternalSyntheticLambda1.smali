# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Ljava/util/List;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/task/TaskFragment;
.field public final synthetic f$2:Landroidx/recyclerview/widget/RecyclerView;
.field public final synthetic f$3:Z
.field public final synthetic f$4:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(java.util.List  com.bytedance.trae.home.solo.task.TaskFragment  androidx.recyclerview.widget.RecyclerView  boolean  kotlin.jvm.functions.Function0)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$0 Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$2 Landroidx/recyclerview/widget/RecyclerView;
    iput-boolean v4, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$3 Z
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$4 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final run()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$0 Ljava/util/List;
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$2 Landroidx/recyclerview/widget/RecyclerView;
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$3 Z
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1;->f$4 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$3;->$r8$lambda$_SU2_iQTZ2SyBMFh_SslZdmfzjI(Ljava/util/List; Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Z Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
