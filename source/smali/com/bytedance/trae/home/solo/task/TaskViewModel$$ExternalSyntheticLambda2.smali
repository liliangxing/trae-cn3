# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    return-void 
.end method

.method public final onConversationChanged(com.bytedance.trae.im.service.IMService$ConversationChangeEvent)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->$r8$lambda$B4c89l6b5E1hzCq8DQKs-YDC35o(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    return-void 
.end method
