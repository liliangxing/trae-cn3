# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/model/AttachmentData;
.super Ljava/lang/Object;
.source "QueryItem.kt"

.field private final chatSessionId:Ljava/lang/String;
.field private final file_size:J
.field private final filename:Ljava/lang/String;
.field private final uri:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  long  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, uri
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filename"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    iput-object v6, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 4
    if-eqz v13, +004h
    const-wide/16 v9, 0
    move-wide v3, v9
    and-int/lit8 v9, v12, 8
    if-eqz v9, +003h
    const/4 v11, 0
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/model/AttachmentData;-><init>(Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.model.AttachmentData  java.lang.String  java.lang.String  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.model.AttachmentData
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-wide v6, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    move-wide v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-wide v8, v0
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/model/AttachmentData;->copy(Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/AttachmentData;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    return-object v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    return-wide v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  long  java.lang.String)com.bytedance.trae.conversation.model.AttachmentData
    .registers 13
    # ins_size=6
    const-string/jumbo v0, uri
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filename"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/model/AttachmentData;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-wide v4, v10
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/model/AttachmentData;-><init>(Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/model/AttachmentData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/model/AttachmentData;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getFile_size()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    return-wide v0
.end method

.method public final getFilename()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    return-object v0
.end method

.method public final getUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "AttachmentData(uri="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->uri Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", filename="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->filename Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", file_size="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->file_size J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", chatSessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/model/AttachmentData;->chatSessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
