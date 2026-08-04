# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
.super Ljava/lang/Object;
.source "MediaChooseConfig.kt"

.implements Landroid/os/Parcelable;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
.field private final actionText:Ljava/lang/String;
.field private final columnCount:I
.field private final enablePreview:Z
.field private final keepOriginDefault:Z
.field private final maxSelectCount:I
.field private final mediaType:Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
.field private final showCamera:Z
.field private final showOrigin:Z
.field private final showSingleSelector:Z
.field private final singleVideo:Z


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig$Creator;
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig$Creator;-><init>()V
    check-cast v0, Landroid/os/Parcelable$Creator;
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->CREATOR Landroid/os/Parcelable$Creator;
    return-void 
.end method

.method public constructor <init>()void
    .registers 14
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
    const/16 v11, 1023
    const/4 v12, 0
    move-object v0, v13
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;-><init>(I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  com.bytedance.trae.conversation.mediachoose.model.MediaType  boolean  boolean  boolean  boolean  boolean  java.lang.String  int  boolean)void
    .registers 12
    # ins_size=11
    const-string v0, "mediaType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actionText"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    iput-object v3, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    iput-boolean v8, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    iput-object v9, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    iput v10, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    iput-boolean v11, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    return-void 
.end method

.method public synthetic constructor <init>(int  com.bytedance.trae.conversation.mediachoose.model.MediaType  boolean  boolean  boolean  boolean  boolean  java.lang.String  int  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 24
    # ins_size=13
    move/from16 v0, v22
    and-int/lit8 v1, v0, 1
    if-eqz v1, +004h
    const/4 v1, 5
    goto +2h
    move v1, v12
    and-int/lit8 v2, v0, 2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->IMAGE Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v0, 4
    const/4 v4, 0
    if-eqz v3, +004h
    move v3, v4
    goto +2h
    move v3, v14
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move v5, v4
    goto +2h
    move v5, v15
    and-int/lit8 v6, v0, 16
    const/4 v7, 1
    if-eqz v6, +004h
    move v6, v7
    goto +3h
    move/from16 v6, v16
    and-int/lit8 v8, v0, 32
    if-eqz v8, +003h
    goto +3h
    move/from16 v7, v17
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move v8, v4
    goto +3h
    move/from16 v8, v18
    and-int/lit16 v9, v0, 128
    if-eqz v9, +005h
    const-string v9, ""
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    const/4 v10, 3
    goto +3h
    move/from16 v10, v20
    and-int/lit16 v0, v0, 512
    if-eqz v0, +003h
    goto +3h
    move/from16 v4, v21
    move-object v12, v11
    move v13, v1
    move-object v14, v2
    move v15, v3
    move/from16 v16, v5
    move/from16 v17, v6
    move/from16 v18, v7
    move/from16 v19, v8
    move-object/from16 v20, v9
    move/from16 v21, v10
    move/from16 v22, v4
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;-><init>(I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig  int  com.bytedance.trae.conversation.mediachoose.model.MediaType  boolean  boolean  boolean  boolean  boolean  java.lang.String  int  boolean  int  java.lang.Object)com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig
    .registers 24
    # ins_size=13
    move-object v0, v11
    move/from16 v1, v22
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    goto +2h
    move v2, v12
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    goto +2h
    move-object v3, v13
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    goto +2h
    move v4, v14
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-boolean v5, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    goto +2h
    move v5, v15
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-boolean v6, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    goto +3h
    move/from16 v6, v16
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    goto +3h
    move/from16 v7, v17
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    goto +3h
    move/from16 v8, v18
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget v10, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    goto +3h
    move/from16 v10, v20
    and-int/lit16 v1, v1, 512
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    goto +3h
    move/from16 v1, v21
    move v12, v2
    move-object v13, v3
    move v14, v4
    move v15, v5
    move/from16 v16, v6
    move/from16 v17, v7
    move/from16 v18, v8
    move-object/from16 v19, v9
    move/from16 v20, v10
    move/from16 v21, v1
    invoke-virtual/range v11 ... v21, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->copy(I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z)Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    return v0
.end method

.method public final component10()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    return v0
.end method

.method public final component2()com.bytedance.trae.conversation.mediachoose.model.MediaType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    return v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    return v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    return v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    return-object v0
.end method

.method public final component9()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    return v0
.end method

.method public final copy(int  com.bytedance.trae.conversation.mediachoose.model.MediaType  boolean  boolean  boolean  boolean  boolean  java.lang.String  int  boolean)com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig
    .registers 23
    # ins_size=11
    const-string v0, "mediaType"
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actionText"
    move-object/from16 v9, v20
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-object v1, v0
    move v2, v13
    move v4, v15
    move/from16 v5, v16
    move/from16 v6, v17
    move/from16 v7, v18
    move/from16 v8, v19
    move/from16 v10, v21
    move/from16 v11, v22
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;-><init>(I Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Z Z Z Z Z Ljava/lang/String; I Z)V
    return-object v0
.end method

.method public final describeContents()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    iget v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getActionText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    return-object v0
.end method

.method public final getColumnCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    return v0
.end method

.method public final getEnablePreview()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    return v0
.end method

.method public final getKeepOriginDefault()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    return v0
.end method

.method public final getMaxSelectCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    return v0
.end method

.method public final getMediaType()com.bytedance.trae.conversation.mediachoose.model.MediaType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    return-object v0
.end method

.method public final getShowCamera()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    return v0
.end method

.method public final getShowOrigin()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    return v0
.end method

.method public final getShowSingleSelector()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    return v0
.end method

.method public final getSingleVideo()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MediaChooseConfig(maxSelectCount="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mediaType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", singleVideo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showCamera="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enablePreview="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showOrigin="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", keepOriginDefault="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", actionText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", columnCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showSingleSelector="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final writeToParcel(android.os.Parcel  int)void
    .registers 3
    # ins_size=3
    const-string v2, "dest"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->maxSelectCount I
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->mediaType Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->name()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->singleVideo Z
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showCamera Z
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->enablePreview Z
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showOrigin Z
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->keepOriginDefault Z
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->actionText Ljava/lang/String;
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V
    iget v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->columnCount I
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->showSingleSelector Z
    invoke-virtual v1, v2, Landroid/os/Parcel;->writeInt(I)V
    return-void 
.end method
