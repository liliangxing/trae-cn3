# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/im/service/CreateTaskRequest;


.method public synthetic constructor <init>(com.bytedance.trae.im.service.CreateTaskRequest)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/service/CreateTaskRequest;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/im/service/CreateTaskRequest;
    check-cast v2, Lcom/bytedance/trae/im/service/ICreateAgentTask;
    check-cast v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->$r8$lambda$ASRyn786m_Hdy9Q0LztrpNAqGgs(Lcom/bytedance/trae/im/service/CreateTaskRequest; Lcom/bytedance/trae/im/service/ICreateAgentTask; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v2
    return-object v2
.end method
