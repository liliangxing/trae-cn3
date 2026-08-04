# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
.super Ljava/lang/Object;
.source "ArtifactFileUrlHelper.kt"

.field private final isDeleted:Z
.field private final url:Ljava/lang/String;


.method public constructor <init>(java.lang.String  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper$FileUrlResult  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper$FileUrlResult
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->copy(Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    return v0
.end method

.method public final copy(java.lang.String  boolean)com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper$FileUrlResult
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;-><init>(Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isDeleted()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "FileUrlResult(url="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->url Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isDeleted="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->isDeleted Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
