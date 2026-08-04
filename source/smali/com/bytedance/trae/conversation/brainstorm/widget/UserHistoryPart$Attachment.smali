# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
.super Ljava/lang/Object;
.source "VoiceHistoryContentParser.kt"

.implements Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart;

.field private final file_size:J
.field private final filename:Ljava/lang/String;
.field private final isImage:Z
.field private final previewChatSessionId:Ljava/lang/String;
.field private final previewImageId:Ljava/lang/String;
.field private final previewResourceUri:Ljava/lang/String;
.field private final uri:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, uri
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filename"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    iput-wide v5, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    iput-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=11
    and-int/lit8 v0, v20, 8
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v6, v0
    goto +2h
    move-wide v6, v15
    and-int/lit8 v0, v20, 16
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v0, v20, 32
    if-eqz v0, +004h
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v18
    and-int/lit8 v0, v20, 64
    if-eqz v0, +004h
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v19
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move v5, v14
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;-><init>(Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.widget.UserHistoryPart$Attachment  java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.widget.UserHistoryPart$Attachment
    .registers 20
    # ins_size=11
    move-object v0, v9
    and-int/lit8 v1, v18, 1
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    goto +2h
    move-object v1, v10
    and-int/lit8 v2, v18, 2
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v18, 4
    if-eqz v3, +005h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    goto +2h
    move v3, v12
    and-int/lit8 v4, v18, 8
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    goto +2h
    move-wide v4, v13
    and-int/lit8 v6, v18, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v18, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v18, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v17
    move-object v10, v1
    move-object v11, v2
    move v12, v3
    move-wide v13, v4
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->copy(Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    return v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    return-wide v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  boolean  long  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.brainstorm.widget.UserHistoryPart$Attachment
    .registers 19
    # ins_size=9
    const-string/jumbo v0, uri
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filename"
    move-object v3, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    move-object v1, v0
    move v4, v13
    move-wide v5, v14
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    move-object/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;-><init>(Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getFile_size()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    return-wide v0
.end method

.method public final getFilename()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    return-object v0
.end method

.method public final getPreviewChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getPreviewImageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    return-object v0
.end method

.method public final getPreviewResourceUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    return-object v0
.end method

.method public final getUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
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
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Attachment(uri="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->uri Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", filename="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->filename Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isImage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", file_size="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->file_size J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", previewImageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewImageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", previewResourceUri="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewResourceUri Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", previewChatSessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->previewChatSessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
