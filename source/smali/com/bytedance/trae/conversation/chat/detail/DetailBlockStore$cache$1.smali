# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;
.super Ljava/util/LinkedHashMap;
.source "DetailBlockStore.kt"


.method constructor <init>()void
    .registers 4
    # ins_size=1
    const/high16 v0, 1061158912
    const/4 v1, 1
    const/16 v2, 20
    invoke-direct v3, v2, v0, v1, Ljava/util/LinkedHashMap;-><init>(I F Z)V
    return-void 
.end method

.method public final bridge containsKey(java.lang.Object)boolean
    .registers 3
    # ins_size=2
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +004h
    const/4 v2, 0
    return v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->containsKey(Ljava/lang/String;)Z
    move-result v2
    return v2
.end method

.method public bridge containsKey(java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method public bridge containsValue(com.bytedance.trae.conversation.chat.block.AgentContentBlock)boolean
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Ljava/util/LinkedHashMap;->containsValue(Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method public final bridge containsValue(java.lang.Object)boolean
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    if-nez v0, +004h
    const/4 v2, 0
    return v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->containsValue(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v2
    return v2
.end method

.method public final bridge entrySet()java.util.Set
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->getEntries()Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method

.method public final bridge get(java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 3
    # ins_size=2
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +004h
    const/4 v2, 0
    return-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    return-object v2
.end method

.method public bridge get(java.lang.String)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    return-object v1
.end method

.method public final bridge synthetic get(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +004h
    const/4 v2, 0
    return-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    return-object v2
.end method

.method public bridge getEntries()java.util.Set
    .registers 2
    # ins_size=1
    invoke-super v1, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method

.method public bridge getKeys()java.util.Set
    .registers 2
    # ins_size=1
    invoke-super v1, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method

.method public final bridge getOrDefault(java.lang.Object  com.bytedance.trae.conversation.chat.block.AgentContentBlock)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 4
    # ins_size=3
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +003h
    return-object v3
    check-cast v2, Ljava/lang/String;
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->getOrDefault(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    return-object v2
.end method

.method public bridge getOrDefault(java.lang.String  com.bytedance.trae.conversation.chat.block.AgentContentBlock)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 3
    # ins_size=3
    invoke-super v0, v1, v2, Ljava/util/LinkedHashMap;->getOrDefault(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    return-object v1
.end method

.method public final bridge synthetic getOrDefault(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +003h
    return-object v3
    check-cast v2, Ljava/lang/String;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->getOrDefault(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    return-object v2
.end method

.method public bridge getSize()int
    .registers 2
    # ins_size=1
    invoke-super v1, Ljava/util/LinkedHashMap;->size()I
    move-result v0
    return v0
.end method

.method public bridge getValues()java.util.Collection
    .registers 2
    # ins_size=1
    invoke-super v1, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    return-object v0
.end method

.method public final bridge keySet()java.util.Set
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->getKeys()Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method

.method public final bridge remove(java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 3
    # ins_size=2
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +004h
    const/4 v2, 0
    return-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->remove(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    return-object v2
.end method

.method public bridge remove(java.lang.String)com.bytedance.trae.conversation.chat.block.AgentContentBlock
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    return-object v1
.end method

.method public final bridge synthetic remove(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    instance-of v0, v2, Ljava/lang/String;
    if-nez v0, +004h
    const/4 v2, 0
    return-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->remove(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    return-object v2
.end method

.method public final bridge remove(java.lang.Object  java.lang.Object)boolean
    .registers 5
    # ins_size=3
    instance-of v0, v3, Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    if-nez v0, +003h
    return v1
    check-cast v3, Ljava/lang/String;
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->remove(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v3
    return v3
.end method

.method public bridge remove(java.lang.String  com.bytedance.trae.conversation.chat.block.AgentContentBlock)boolean
    .registers 3
    # ins_size=3
    invoke-super v0, v1, v2, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method protected removeEldestEntry(java.util.Map$Entry)boolean
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->size()I
    move-result v2
    const/16 v0, 20
    if-le v2, v0, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public final bridge size()int
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->getSize()I
    move-result v0
    return v0
.end method

.method public final bridge values()java.util.Collection
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore$cache$1;->getValues()Ljava/util/Collection;
    move-result-object v0
    return-object v0
.end method
