# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/api/IAccountStatusListener;

.field public final synthetic f$0:Lcom/bytedance/trae/init/task/InitAccountTask;


.method public synthetic constructor <init>(com.bytedance.trae.init.task.InitAccountTask)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/init/task/InitAccountTask;
    return-void 
.end method

.method public final onAccountStatusChanged(com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/init/task/InitAccountTask;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/init/task/InitAccountTask;->$r8$lambda$Xh-mp18Mt4DxIU4v3h-e8GfI-tw(Lcom/bytedance/trae/init/task/InitAccountTask; Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    return-void 
.end method
