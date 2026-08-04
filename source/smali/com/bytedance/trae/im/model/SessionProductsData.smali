# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/SessionProductsData;
.super Ljava/lang/Object;
.source "FinishCardResult.kt"

.field private final changedCodes:Ljava/util/List;
.field private final changedDocs:Ljava/util/List;
.field private final changedImages:Ljava/util/List;
.field private final changedSheets:Ljava/util/List;
.field private final changedSkills:Ljava/util/List;
.field private final changedSlides:Ljava/util/List;
.field private final mergeProducts:Ljava/util/List;
.field private final previews:Ljava/util/List;


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
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/im/model/SessionProductsData;-><init>(Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    iput-object v4, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    iput-object v5, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    iput-object v6, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    iput-object v7, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    iput-object v8, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
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
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/im/model/SessionProductsData;-><init>(Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.SessionProductsData  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  int  java.lang.Object)com.bytedance.trae.im.model.SessionProductsData
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
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
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/im/model/SessionProductsData;->copy(Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List;)Lcom/bytedance/trae/im/model/SessionProductsData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    return-object v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    return-object v0
.end method

.method public final component5()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    return-object v0
.end method

.method public final component6()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    return-object v0
.end method

.method public final component7()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    return-object v0
.end method

.method public final component8()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List  java.util.List)com.bytedance.trae.im.model.SessionProductsData
    .registers 19
    # ins_size=9
    new-instance v9, Lcom/bytedance/trae/im/model/SessionProductsData;
    move-object v0, v9
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/im/model/SessionProductsData;-><init>(Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List; Ljava/util/List;)V
    return-object v9
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/model/SessionProductsData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/model/SessionProductsData;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getChangedCodes()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    return-object v0
.end method

.method public final getChangedDocs()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    return-object v0
.end method

.method public final getChangedImages()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    return-object v0
.end method

.method public final getChangedSheets()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    return-object v0
.end method

.method public final getChangedSkills()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    return-object v0
.end method

.method public final getChangedSlides()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    return-object v0
.end method

.method public final getMergeProducts()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
    return-object v0
.end method

.method public final getPreviews()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
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
    const-string v1, "SessionProductsData(previews="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->previews Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", changedDocs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->changedDocs Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", changedCodes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->changedCodes Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", changedImages="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->changedImages Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", changedSheets="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSheets Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", changedSlides="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSlides Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", changedSkills="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->changedSkills Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mergeProducts="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/SessionProductsData;->mergeProducts Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
