# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/DiffViewResponse;
.super Ljava/lang/Object;
.source "IDiffViewApi.kt"

.field private final changedCodes:Lcom/bytedance/trae/im/model/ChangedFileData;
.field private final changedDocs:Lcom/bytedance/trae/im/model/ChangedFileData;
.field private final changedImages:Lcom/bytedance/trae/im/model/ChangedFileData;
.field private final changedSheets:Lcom/bytedance/trae/im/model/ChangedFileData;
.field private final changedSkills:Lcom/bytedance/trae/im/model/ChangedSkillsData;
.field private final changedSlides:Lcom/bytedance/trae/im/model/ChangedFileData;
.field private final chatSessionId:Ljava/lang/String;
.field private final createdAt:Ljava/lang/Long;
.field private final mergeProducts:Lcom/bytedance/trae/im/model/MergeChangedFilesData;
.field private final status:Ljava/lang/String;
.field private final turnId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 15
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2047
    const/4 v13, 0
    move-object v0, v14
    invoke-direct/range v0 ... v13, Lcom/bytedance/trae/im/service/DiffViewResponse;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedSkillsData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/MergeChangedFilesData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedSkillsData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.MergeChangedFilesData)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    iput-object v5, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    iput-object v6, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    iput-object v7, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    iput-object v8, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    iput-object v9, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    iput-object v10, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    iput-object v11, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedSkillsData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.MergeChangedFilesData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 26
    # ins_size=14
    move/from16 v0, v24
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v13
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v19
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v23
    move-object v13, v12
    move-object v14, v1
    move-object v15, v3
    move-object/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move-object/from16 v19, v7
    move-object/from16 v20, v8
    move-object/from16 v21, v9
    move-object/from16 v22, v10
    move-object/from16 v23, v11
    move-object/from16 v24, v2
    invoke-direct/range v13 ... v24, Lcom/bytedance/trae/im/service/DiffViewResponse;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedSkillsData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/MergeChangedFilesData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.DiffViewResponse  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedSkillsData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.MergeChangedFilesData  int  java.lang.Object)com.bytedance.trae.im.service.DiffViewResponse
    .registers 26
    # ins_size=14
    move-object v0, v12
    move/from16 v1, v24
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    goto +3h
    move-object/from16 v8, v19
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    goto +3h
    move-object/from16 v1, v23
    move-object v13, v2
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    move-object/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-object/from16 v21, v10
    move-object/from16 v22, v11
    move-object/from16 v23, v1
    invoke-virtual/range v12 ... v23, Lcom/bytedance/trae/im/service/DiffViewResponse;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedSkillsData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/MergeChangedFilesData;)Lcom/bytedance/trae/im/service/DiffViewResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final component11()com.bytedance.trae.im.model.MergeChangedFilesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final component7()com.bytedance.trae.im.model.ChangedSkillsData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    return-object v0
.end method

.method public final component8()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final component9()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.Long  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedSkillsData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.model.MergeChangedFilesData)com.bytedance.trae.im.service.DiffViewResponse
    .registers 25
    # ins_size=12
    new-instance v12, Lcom/bytedance/trae/im/service/DiffViewResponse;
    move-object v0, v12
    move-object v1, v14
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    move-object/from16 v7, v20
    move-object/from16 v8, v21
    move-object/from16 v9, v22
    move-object/from16 v10, v23
    move-object/from16 v11, v24
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/im/service/DiffViewResponse;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedSkillsData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/model/MergeChangedFilesData;)V
    return-object v12
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/DiffViewResponse;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getChangedCodes()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final getChangedDocs()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final getChangedImages()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final getChangedSheets()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final getChangedSkills()com.bytedance.trae.im.model.ChangedSkillsData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    return-object v0
.end method

.method public final getChangedSlides()com.bytedance.trae.im.model.ChangedFileData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    return-object v0
.end method

.method public final getChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getMergeProducts()com.bytedance.trae.im.model.MergeChangedFilesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getTurnId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedSkillsData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DiffViewResponse(turnId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->turnId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatSessionId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->chatSessionId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->status Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createdAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->createdAt Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", changedDocs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedDocs Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", changedCodes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedCodes Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", changedSkills="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSkills Lcom/bytedance/trae/im/model/ChangedSkillsData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", changedSheets="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSheets Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", changedSlides="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedSlides Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", changedImages="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->changedImages Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mergeProducts="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/DiffViewResponse;->mergeProducts Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
