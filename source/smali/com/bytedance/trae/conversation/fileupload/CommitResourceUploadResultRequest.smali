# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;
.super Ljava/lang/Object;
.source "ResourceUploadModels.kt"

.field private final bizType:Lcom/bytedance/trae/conversation/fileupload/BizType;
.field private final oids:Ljava/util/List;
.field private final sessionKey:Ljava/lang/String;


.method public constructor <init>(java.util.List  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType)void
    .registers 5
    # ins_size=4
    const-string v0, "oids"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionKey
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;-><init>(Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.CommitResourceUploadResultRequest  java.util.List  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.CommitResourceUploadResultRequest
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->copy(Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType;)Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.fileupload.BizType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType)com.bytedance.trae.conversation.fileupload.CommitResourceUploadResultRequest
    .registers 5
    # ins_size=4
    const-string v0, "oids"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionKey
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;-><init>(Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getBizType()com.bytedance.trae.conversation.fileupload.BizType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    return-object v0
.end method

.method public final getOids()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    return-object v0
.end method

.method public final getSessionKey()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/BizType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CommitResourceUploadResultRequest(oids="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->oids Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sessionKey="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->sessionKey Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", bizType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;->bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
