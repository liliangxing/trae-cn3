# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
.super Ljava/lang/Object;
.source "SubTaskProtocol.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage$Companion;
.field public static final TYPE:Ljava/lang/String;
.field private final error:Ljava/lang/String;
.field private final result:Ljava/lang/String;
.field private final status:Ljava/lang/String;
.field private final taskId:Ljava/lang/String;
.field private final toolName:Ljava/lang/String;
.field private final type:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->Companion Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=7
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 18
    # ins_size=9
    and-int/lit8 v0, v16, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v12
    and-int/lit8 v0, v16, 8
    if-eqz v0, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v13
    and-int/lit8 v0, v16, 16
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v14
    and-int/lit8 v0, v16, 32
    if-eqz v0, +004h
    move-object v8, v1
    goto +2h
    move-object v8, v15
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.subtask.ToolResultMessage  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.voice.subtask.ToolResultMessage
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.voice.subtask.ToolResultMessage
    .registers 15
    # ins_size=7
    const-string/jumbo v0, type
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getError()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    return-object v0
.end method

.method public final getResult()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final getToolName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public final getType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ToolResultMessage(type="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->type Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->toolName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", result="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->result Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", error="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->error Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
