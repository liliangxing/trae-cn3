# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
.super Ljava/lang/Object;
.source "MediaItem.kt"

.implements Landroid/os/Parcelable;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
.field private final bucketId:J
.field private final bucketName:Ljava/lang/String;
.field private final durationMs:J
.field private final fileName:Ljava/lang/String;
.field private final height:I
.field private final id:J
.field private final isVideo:Z
.field private final mimeType:Ljava/lang/String;
.field private final sizeBytes:J
.field private final uri:Landroid/net/Uri;
.field private final width:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem$Creator;
    invoke-direct v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem$Creator;-><init>()V
    check-cast v0, Landroid/os/Parcelable$Creator;
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->CREATOR Landroid/os/Parcelable$Creator;
    return-void 
.end method

.method public constructor <init>(long  android.net.Uri  java.lang.String  long  long  java.lang.String  int  int  long  boolean  java.lang.String)void
    .registers 21
    # ins_size=16
    move-object v0, v5
    move-object v1, v8
    move-object v2, v14
    const-string/jumbo v3, uri
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "bucketName"
    invoke-static v14, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, Ljava/lang/Object;-><init>()V
    move-wide v3, v6
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    move-wide v3, v10
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    move-wide v3, v12
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    iput-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    move v1, v15
    iput v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    move/from16 v1, v16
    iput v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    move-wide/from16 v1, v17
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    move/from16 v1, v19
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.mediachoose.model.MediaItem  long  android.net.Uri  java.lang.String  long  long  java.lang.String  int  int  long  boolean  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 34
    # ins_size=18
    move-object/from16 v0, v16
    move/from16 v1, v32
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    goto +3h
    move-wide/from16 v2, v17
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    goto +3h
    move-object/from16 v4, v19
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-wide v6, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    goto +3h
    move-wide/from16 v6, v21
    and-int/lit8 v8, v1, 16
    if-eqz v8, +005h
    iget-wide v8, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    goto +3h
    move-wide/from16 v8, v23
    and-int/lit8 v10, v1, 32
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v25
    and-int/lit8 v11, v1, 64
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    goto +3h
    move/from16 v11, v26
    and-int/lit16 v12, v1, 128
    if-eqz v12, +005h
    iget v12, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    goto +3h
    move/from16 v12, v27
    and-int/lit16 v13, v1, 256
    if-eqz v13, +005h
    iget-wide v13, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    goto +3h
    move-wide/from16 v13, v28
    and-int/lit16 v15, v1, 512
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    goto +3h
    move/from16 v15, v30
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v31
    move-wide/from16 v17, v2
    move-object/from16 v19, v4
    move-object/from16 v20, v5
    move-wide/from16 v21, v6
    move-wide/from16 v23, v8
    move-object/from16 v25, v10
    move/from16 v26, v11
    move/from16 v27, v12
    move-wide/from16 v28, v13
    move/from16 v30, v15
    move-object/from16 v31, v1
    invoke-virtual/range v16 ... v31, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->copy(J Landroid/net/Uri; Ljava/lang/String; J J Ljava/lang/String; I I J Z Ljava/lang/String;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    return-wide v0
.end method

.method public final component10()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    return v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    return-wide v0
.end method

.method public final component5()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    return-wide v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    return-object v0
.end method

.method public final component7()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    return v0
.end method

.method public final component8()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    return v0
.end method

.method public final component9()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    return-wide v0
.end method

.method public final copy(long  android.net.Uri  java.lang.String  long  long  java.lang.String  int  int  long  boolean  java.lang.String)com.bytedance.trae.conversation.mediachoose.model.MediaItem
    .registers 33
    # ins_size=16
    const-string/jumbo v0, uri
    move-object/from16 v4, v20
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "bucketName"
    move-object/from16 v10, v26
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-object v1, v0
    move-wide/from16 v2, v18
    move-object/from16 v5, v21
    move-wide/from16 v6, v22
    move-wide/from16 v8, v24
    move/from16 v11, v27
    move/from16 v12, v28
    move-wide/from16 v13, v29
    move/from16 v15, v31
    move-object/from16 v16, v32
    invoke-direct/range v1 ... v16, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;-><init>(J Landroid/net/Uri; Ljava/lang/String; J J Ljava/lang/String; I I J Z Ljava/lang/String;)V
    return-object v0
.end method

.method public final describeContents()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    iget v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    iget v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getBucketId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    return-wide v0
.end method

.method public final getBucketName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    return-object v0
.end method

.method public final getDurationMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    return-wide v0
.end method

.method public final getFileName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    return-object v0
.end method

.method public final getHeight()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    return v0
.end method

.method public final getId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    return-wide v0
.end method

.method public final getMimeType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    return-object v0
.end method

.method public final getSizeBytes()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    return-wide v0
.end method

.method public final getUri()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    return-object v0
.end method

.method public final getWidth()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    return v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-wide v0, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    invoke-virtual v1, Landroid/net/Uri;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isVideo()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MediaItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uri="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mimeType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", durationMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bucketId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bucketName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", width="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", height="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sizeBytes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isVideo="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fileName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final writeToParcel(android.os.Parcel  int)void
    .registers 5
    # ins_size=3
    const-string v0, "dest"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->id J
    invoke-virtual v3, v0, v1, Landroid/os/Parcel;->writeLong(J)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->uri Landroid/net/Uri;
    check-cast v0, Landroid/os/Parcelable;
    invoke-virtual v3, v0, v4, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable; I)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->mimeType Ljava/lang/String;
    invoke-virtual v3, v4, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->durationMs J
    invoke-virtual v3, v0, v1, Landroid/os/Parcel;->writeLong(J)V
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketId J
    invoke-virtual v3, v0, v1, Landroid/os/Parcel;->writeLong(J)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->bucketName Ljava/lang/String;
    invoke-virtual v3, v4, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V
    iget v4, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->width I
    invoke-virtual v3, v4, Landroid/os/Parcel;->writeInt(I)V
    iget v4, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->height I
    invoke-virtual v3, v4, Landroid/os/Parcel;->writeInt(I)V
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->sizeBytes J
    invoke-virtual v3, v0, v1, Landroid/os/Parcel;->writeLong(J)V
    iget-boolean v4, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo Z
    invoke-virtual v3, v4, Landroid/os/Parcel;->writeInt(I)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->fileName Ljava/lang/String;
    invoke-virtual v3, v4, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V
    return-void 
.end method
