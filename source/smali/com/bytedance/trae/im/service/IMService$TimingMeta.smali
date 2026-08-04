# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IMService$TimingMeta;
.super Ljava/lang/Object;
.source "IMService.kt"

.field private final enableDbOpt:Ljava/lang/Boolean;
.field private final isServerRetried:Ljava/lang/Boolean;
.field private final logid:Ljava/lang/String;
.field private final modelAccountName:Ljava/lang/String;
.field private final modelAccountType:Ljava/lang/String;
.field private final modelName:Ljava/lang/String;
.field private final modelProviderName:Ljava/lang/String;
.field private final serverTimingInfo:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    iput-object v8, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.IMService$TimingMeta  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.im.service.IMService$TimingMeta
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
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
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/IMService$TimingMeta;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component8()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean)com.bytedance.trae.im.service.IMService$TimingMeta
    .registers 19
    # ins_size=9
    new-instance v9, Lcom/bytedance/trae/im/service/IMService$TimingMeta;
    move-object v0, v9
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/im/service/IMService$TimingMeta;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-object v9
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getEnableDbOpt()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getLogid()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    return-object v0
.end method

.method public final getModelAccountName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    return-object v0
.end method

.method public final getModelAccountType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    return-object v0
.end method

.method public final getModelName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    return-object v0
.end method

.method public final getModelProviderName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    return-object v0
.end method

.method public final getServerTimingInfo()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isServerRetried()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TimingMeta(modelName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", logid="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->logid Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", modelAccountName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", modelAccountType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelAccountType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", modelProviderName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->modelProviderName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", serverTimingInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->serverTimingInfo Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isServerRetried="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enableDbOpt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->enableDbOpt Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
