# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;
.super Ljava/lang/Object;
.source "IMService.kt"

.field private final conversationId:Ljava/lang/String;
.field private final planItem:Lcom/bytedance/trae/im/model/ParsedPlanItem;
.field private final taskId:Ljava/lang/String;


.method public constructor <init>(com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "planItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.IMService$ConfirmEvent  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.IMService$ConfirmEvent
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->copy(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.im.model.ParsedPlanItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String)com.bytedance.trae.im.service.IMService$ConfirmEvent
    .registers 5
    # ins_size=4
    const-string v0, "planItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;-><init>(Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getPlanItem()com.bytedance.trae.im.model.ParsedPlanItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ConfirmEvent(planItem="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
