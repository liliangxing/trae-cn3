# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/RegisterAppRequest;
.super Ljava/lang/Object;
.source "RegisterAppApi.kt"

.field private final appId:I
.field private final appRuntimeType:Ljava/lang/String;
.field private final frontierid:Ljava/lang/Long;
.field private final id:Ljava/lang/String;
.field private final name:Ljava/lang/String;
.field private final processId:I
.field private final productId:I
.field private final status:Ljava/lang/String;
.field private final userId:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  int  java.lang.String  int  int)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    iput-object v5, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    iput v6, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    iput-object v7, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    iput v8, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    iput v9, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  int  java.lang.String  int  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 24
    # ins_size=12
    and-int/lit8 v0, v22, 1
    const-string v1, ""
    if-eqz v0, +004h
    move-object v3, v1
    goto +2h
    move-object v3, v13
    and-int/lit8 v0, v22, 2
    if-eqz v0, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v14
    and-int/lit8 v0, v22, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v15
    and-int/lit8 v0, v22, 8
    if-eqz v0, +004h
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v16
    and-int/lit8 v0, v22, 16
    if-eqz v0, +007h
    const-string/jumbo v0, online
    move-object v7, v0
    goto +3h
    move-object/from16 v7, v17
    move-object v2, v12
    move/from16 v8, v18
    move-object/from16 v9, v19
    move/from16 v10, v20
    move/from16 v11, v21
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/network/RegisterAppRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Ljava/lang/String; I I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.RegisterAppRequest  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  int  java.lang.String  int  int  int  java.lang.Object)com.bytedance.trae.network.RegisterAppRequest
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget v7, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    goto +3h
    move/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    goto +3h
    move/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget v1, v0, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    goto +3h
    move/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move/from16 v16, v7
    move-object/from16 v17, v8
    move/from16 v18, v9
    move/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/network/RegisterAppRequest;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Ljava/lang/String; I I)Lcom/bytedance/trae/network/RegisterAppRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component6()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    return v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    return-object v0
.end method

.method public final component8()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    return v0
.end method

.method public final component9()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  int  java.lang.String  int  int)com.bytedance.trae.network.RegisterAppRequest
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/network/RegisterAppRequest;
    move-object v0, v10
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move/from16 v6, v17
    move-object/from16 v7, v18
    move/from16 v8, v19
    move/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/RegisterAppRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Ljava/lang/String; I I)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/network/RegisterAppRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/network/RegisterAppRequest;
    iget-object v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    iget v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    iget v3, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    iget v5, v5, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAppId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    return v0
.end method

.method public final getAppRuntimeType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    return-object v0
.end method

.method public final getFrontierid()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getProcessId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    return v0
.end method

.method public final getProductId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    return v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget v2, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    invoke-static v2, Ljava/lang/Integer;->hashCode(I)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RegisterAppRequest(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", frontierid="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->frontierid Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", appId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->appId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", appRuntimeType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->appRuntimeType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", processId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->processId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", productId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/network/RegisterAppRequest;->productId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
