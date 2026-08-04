# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/SubTaskResultRequest;
.super Ljava/lang/Object;
.source "ISubTaskResultApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/SubTaskResultRequest$Companion;
.field public static final STATUS_FAILED:Ljava/lang/String;
.field public static final STATUS_SUCCESS:Ljava/lang/String;
.field private final durationMs:J
.field private final error:Ljava/lang/String;
.field private final errorCode:Ljava/lang/String;
.field private final result:Ljava/lang/String;
.field private final status:Ljava/lang/String;
.field private final taskId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/SubTaskResultRequest$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->Companion Lcom/bytedance/trae/im/service/SubTaskResultRequest$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String)void
    .registers 9
    # ins_size=8
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "errorCode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    iput-wide v6, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    iput-object v8, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 32
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v16
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-wide v6, v14
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.SubTaskResultRequest  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.SubTaskResultRequest
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-wide v10, v5, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    move-wide v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-wide v12, v2
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)Lcom/bytedance/trae/im/service/SubTaskResultRequest;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    return-object v0
.end method

.method public final component5()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    return-wide v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String)com.bytedance.trae.im.service.SubTaskResultRequest
    .registers 17
    # ins_size=8
    const-string/jumbo v0, taskId
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    move-object v3, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    move-object v4, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "errorCode"
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/SubTaskResultRequest;
    move-object v1, v0
    move-wide v6, v14
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;
    iget-object v1, v7, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    iget-wide v5, v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getDurationMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    return-wide v0
.end method

.method public final getError()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    return-object v0
.end method

.method public final getErrorCode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    return-object v0
.end method

.method public final getResult()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubTaskResultRequest(taskId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", result="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->result Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->errorCode Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", durationMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->durationMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", error="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/service/SubTaskResultRequest;->error Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
