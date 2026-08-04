# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final codeReferences:Ljava/util/List;
.field private final docReferences:Lcom/bytedance/trae/im/model/DocReferencesData;
.field private final searchReferences:Lcom/bytedance/trae/im/model/SearchReferenceData;


.method public constructor <init>(java.util.List  com.bytedance.trae.im.model.SearchReferenceData  com.bytedance.trae.im.model.DocReferencesData)void
    .registers 5
    # ins_size=4
    const-string v0, "codeReferences"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$References  java.util.List  com.bytedance.trae.im.model.SearchReferenceData  com.bytedance.trae.im.model.DocReferencesData  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$References
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->copy(Ljava/util/List; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.im.model.SearchReferenceData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.im.model.DocReferencesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    return-object v0
.end method

.method public final copy(java.util.List  com.bytedance.trae.im.model.SearchReferenceData  com.bytedance.trae.im.model.DocReferencesData)com.bytedance.trae.conversation.chat.block.AgentContentBlock$References
    .registers 5
    # ins_size=4
    const-string v0, "codeReferences"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;-><init>(Ljava/util/List; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCodeReferences()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    return-object v0
.end method

.method public final getDocReferences()com.bytedance.trae.im.model.DocReferencesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    return-object v0
.end method

.method public final getSearchReferences()com.bytedance.trae.im.model.SearchReferenceData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/SearchReferenceData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/DocReferencesData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "References(codeReferences="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->codeReferences Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", searchReferences="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->searchReferences Lcom/bytedance/trae/im/model/SearchReferenceData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", docReferences="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
