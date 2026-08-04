# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/EventItem;
.super Ljava/lang/Object;
.source "IListEventsService.kt"

.field private final cleanThought:Ljava/lang/Boolean;
.field private final data:Ljava/lang/String;
.field private final newToolCall:Ljava/lang/Boolean;
.field private final seq:Ljava/lang/Integer;
.field private final taskId:Ljava/lang/String;
.field private final thoughtFirstData:Ljava/lang/Boolean;
.field private final toolcallFirstData:Ljava/lang/Boolean;
.field private final type:Ljava/lang/String;


.method public constructor <init>()void
    .registers 12
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 255
    const/4 v10, 0
    move-object v0, v11
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/im/service/EventItem;-><init>(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    iput-object v6, v0, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    iput-object v7, v0, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    iput-object v8, v0, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 20
    # ins_size=11
    move/from16 v0, v18
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v10
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v0, v0, 128
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v17
    move-object v10, v9
    move-object v11, v1
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v2
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/im/service/EventItem;-><init>(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.EventItem  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.im.service.EventItem
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v17
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    move-object/from16 v16, v8
    move-object/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/im/service/EventItem;->copy(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/EventItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component6()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component7()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component8()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean)com.bytedance.trae.im.service.EventItem
    .registers 19
    # ins_size=9
    new-instance v9, Lcom/bytedance/trae/im/service/EventItem;
    move-object v0, v9
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/im/service/EventItem;-><init>(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-object v9
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/EventItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/EventItem;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCleanThought()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getData()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    return-object v0
.end method

.method public final getNewToolCall()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getSeq()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final getThoughtFirstData()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getToolcallFirstData()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EventItem(taskId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", seq="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->seq Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", type="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->type Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->data Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", newToolCall="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->newToolCall Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cleanThought="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->cleanThought Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", thoughtFirstData="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->thoughtFirstData Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolcallFirstData="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/EventItem;->toolcallFirstData Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
