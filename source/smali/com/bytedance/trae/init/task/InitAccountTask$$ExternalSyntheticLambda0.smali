# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/init/task/InitAccountTask;


.method public synthetic constructor <init>(com.bytedance.trae.init.task.InitAccountTask)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/init/task/InitAccountTask;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/init/task/InitAccountTask;
    check-cast v2, Lcom/bytedance/trae/login/api/AccountInfo;
    invoke-static v0, v2, Lcom/bytedance/trae/init/task/InitAccountTask;->$r8$lambda$x8De3TROFuCS0ax2YDZHK_y6IbI(Lcom/bytedance/trae/init/task/InitAccountTask; Lcom/bytedance/trae/login/api/AccountInfo;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
