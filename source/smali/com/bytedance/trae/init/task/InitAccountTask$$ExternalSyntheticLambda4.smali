# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:I
.field public final synthetic f$3:Lcom/bytedance/trae/init/task/InitAccountTask;
.field public final synthetic f$4:Z


.method public synthetic constructor <init>(java.lang.String  java.lang.String  int  com.bytedance.trae.init.task.InitAccountTask  boolean)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$1 Ljava/lang/String;
    iput v3, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$2 I
    iput-object v4, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$3 Lcom/bytedance/trae/init/task/InitAccountTask;
    iput-boolean v5, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$4 Z
    return-void 
.end method

.method public final run()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$0 Ljava/lang/String;
    iget-object v1, v5, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$1 Ljava/lang/String;
    iget v2, v5, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$2 I
    iget-object v3, v5, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$3 Lcom/bytedance/trae/init/task/InitAccountTask;
    iget-boolean v4, v5, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda4;->f$4 Z
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/init/task/InitAccountTask;->$r8$lambda$KR3fLFc5NXk5TksI_YFn_BIuVAw(Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/init/task/InitAccountTask; Z)V
    return-void 
.end method
