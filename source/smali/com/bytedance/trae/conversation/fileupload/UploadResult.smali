# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/UploadResult;
.super Ljava/lang/Object;
.source "ResourceUploadModels.kt"

.field private final checksum:Ljava/lang/String;
.field private final error:Ljava/lang/String;
.field private final fileSize:Ljava/lang/Long;
.field private final oid:Ljava/lang/String;
.field private final success:Z


.method public constructor <init>(java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.Long)void
    .registers 7
    # ins_size=6
    const-string v0, "oid"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    iput-object v4, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v10, v13, 8
    if-eqz v10, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v10, v13, 16
    if-eqz v10, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.UploadResult  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.Long  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.UploadResult
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-boolean v5, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->copy(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long;)Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    return-object v0
.end method

.method public final copy(java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.Long)com.bytedance.trae.conversation.fileupload.UploadResult
    .registers 13
    # ins_size=6
    const-string v0, "oid"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    move-object v1, v0
    move-object v2, v8
    move v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/fileupload/UploadResult;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getChecksum()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    return-object v0
.end method

.method public final getError()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    return-object v0
.end method

.method public final getFileSize()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    return-object v0
.end method

.method public final getOid()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    return-object v0
.end method

.method public final getSuccess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UploadResult(oid="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->oid Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", success="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->success Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", error="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->error Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", checksum="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->checksum Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fileSize="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadResult;->fileSize Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
