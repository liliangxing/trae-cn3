# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/util/Set;


.method public synthetic constructor <init>(java.util.Set)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda0;->f$0 Ljava/util/Set;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1$$ExternalSyntheticLambda0;->f$0 Ljava/util/Set;
    check-cast v2, Ljava/lang/String;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;->$r8$lambda$rxObfrh1oeIs3ZXxEFqTj2db1cs(Ljava/util/Set; Ljava/lang/String;)Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    return-object v2
.end method
