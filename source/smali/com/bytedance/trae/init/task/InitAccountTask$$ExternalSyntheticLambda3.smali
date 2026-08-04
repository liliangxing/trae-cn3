# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/init/task/InitAccountTask;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.init.task.InitAccountTask  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/init/task/InitAccountTask;
    iput-object v2, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/init/task/InitAccountTask;
    iget-object v1, v2, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask;->$r8$lambda$mdfRaNDpqHNkKxRVsNEpywAo0K8(Lcom/bytedance/trae/init/task/InitAccountTask; Ljava/lang/String;)V
    return-void 
.end method
