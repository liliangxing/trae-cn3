# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/AttachmentItem;
.super Ljava/lang/Object;
.source "AttachmentItem.kt"

.field private final bucketId:J
.field private final fileName:Ljava/lang/String;
.field private final id:J
.field private final isImage:Z
.field private final mimeType:Ljava/lang/String;
.field private final sizeBytes:J
.field private final uploadError:Ljava/lang/String;
.field private final uploadProgress:I
.field private final uploadStatus:Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
.field private final uploadedOid:Ljava/lang/String;
.field private final uri:Landroid/net/Uri;


.method public constructor <init>(long  long  java.lang.String  android.net.Uri  java.lang.String  long  boolean  com.bytedance.trae.conversation.widget.AttachmentUploadStatus  int  java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=15
    const-string/jumbo v0, uri
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uploadStatus
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    iput-object v6, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    iput-wide v9, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    iput-boolean v11, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    iput-object v12, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    iput v13, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    iput-object v14, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    iput-object v15, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(long  long  java.lang.String  android.net.Uri  java.lang.String  long  boolean  com.bytedance.trae.conversation.widget.AttachmentUploadStatus  int  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 35
    # ins_size=17
    move/from16 v0, v33
    and-int/lit8 v1, v0, 4
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v23
    and-int/lit16 v1, v0, 128
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Pending Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-object v14, v1
    goto +3h
    move-object/from16 v14, v29
    and-int/lit16 v1, v0, 256
    if-eqz v1, +005h
    const/4 v1, 0
    move v15, v1
    goto +3h
    move/from16 v15, v30
    and-int/lit16 v1, v0, 512
    if-eqz v1, +005h
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v31
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +005h
    move-object/from16 v17, v2
    goto +3h
    move-object/from16 v17, v32
    move-object/from16 v3, v18
    move-wide/from16 v4, v19
    move-wide/from16 v6, v21
    move-object/from16 v9, v24
    move-object/from16 v10, v25
    move-wide/from16 v11, v26
    move/from16 v13, v28
    invoke-direct/range v3 ... v17, Lcom/bytedance/trae/conversation/widget/AttachmentItem;-><init>(J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.widget.AttachmentItem  long  long  java.lang.String  android.net.Uri  java.lang.String  long  boolean  com.bytedance.trae.conversation.widget.AttachmentUploadStatus  int  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 32
    # ins_size=17
    move-object v0, v15
    move/from16 v1, v30
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    goto +3h
    move-wide/from16 v2, v16
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    goto +3h
    move-wide/from16 v4, v18
    and-int/lit8 v6, v1, 4
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v20
    and-int/lit8 v7, v1, 8
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    goto +3h
    move-object/from16 v7, v21
    and-int/lit8 v8, v1, 16
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v22
    and-int/lit8 v9, v1, 32
    if-eqz v9, +005h
    iget-wide v9, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    goto +3h
    move-wide/from16 v9, v23
    and-int/lit8 v11, v1, 64
    if-eqz v11, +005h
    iget-boolean v11, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    goto +3h
    move/from16 v11, v25
    and-int/lit16 v12, v1, 128
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    goto +3h
    move-object/from16 v12, v26
    and-int/lit16 v13, v1, 256
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    goto +3h
    move/from16 v13, v27
    and-int/lit16 v14, v1, 512
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    goto +3h
    move-object/from16 v14, v28
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v29
    move-wide/from16 v16, v2
    move-wide/from16 v18, v4
    move-object/from16 v20, v6
    move-object/from16 v21, v7
    move-object/from16 v22, v8
    move-wide/from16 v23, v9
    move/from16 v25, v11
    move-object/from16 v26, v12
    move/from16 v27, v13
    move-object/from16 v28, v14
    move-object/from16 v29, v1
    invoke-virtual/range v15 ... v29, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy(J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    return-wide v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    return-wide v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    return-object v0
.end method

.method public final component6()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    return-wide v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    return v0
.end method

.method public final component8()com.bytedance.trae.conversation.widget.AttachmentUploadStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    return-object v0
.end method

.method public final component9()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    return v0
.end method

.method public final copy(long  long  java.lang.String  android.net.Uri  java.lang.String  long  boolean  com.bytedance.trae.conversation.widget.AttachmentUploadStatus  int  java.lang.String  java.lang.String)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 31
    # ins_size=15
    const-string/jumbo v0, uri
    move-object/from16 v7, v22
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uploadStatus
    move-object/from16 v12, v27
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-object v1, v0
    move-wide/from16 v2, v17
    move-wide/from16 v4, v19
    move-object/from16 v6, v21
    move-object/from16 v8, v23
    move-wide/from16 v9, v24
    move/from16 v11, v26
    move/from16 v13, v28
    move-object/from16 v14, v29
    move-object/from16 v15, v30
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/conversation/widget/AttachmentItem;-><init>(J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    iget v3, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getBucketId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    return-wide v0
.end method

.method public final getFileName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    return-object v0
.end method

.method public final getId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    return-wide v0
.end method

.method public final getMimeType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    return-object v0
.end method

.method public final getSizeBytes()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    return-wide v0
.end method

.method public final getUploadError()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    return-object v0
.end method

.method public final getUploadProgress()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    return v0
.end method

.method public final getUploadStatus()com.bytedance.trae.conversation.widget.AttachmentUploadStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    return-object v0
.end method

.method public final getUploadedOid()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    return-object v0
.end method

.method public final getUri()android.net.Uri
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    return-object v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-wide v0, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    invoke-virtual v1, Landroid/net/Uri;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isImage()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "AttachmentItem(bucketId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->bucketId J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", id="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->id J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fileName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->fileName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uri="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uri Landroid/net/Uri;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mimeType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->mimeType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sizeBytes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->sizeBytes J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isImage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uploadStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadStatus Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uploadProgress="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadProgress I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uploadedOid="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadedOid Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uploadError="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->uploadError Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
