# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/util/function/Predicate;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final test(java.lang.Object)boolean
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function1;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->$r8$lambda$IV_c6xo4L4Z5WV_gyJBWn8WaeLM(Lkotlin/jvm/functions/Function1; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method
