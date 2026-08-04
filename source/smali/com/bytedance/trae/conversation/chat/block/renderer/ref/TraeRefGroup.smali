# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
.super Ljava/lang/Object;
.source "TraeRefModels.kt"

.field private final sources:Ljava/util/List;


.method public constructor <init>(java.util.List)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, sources
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  java.util.List  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->copy(Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.util.List)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup
    .registers 3
    # ins_size=2
    const-string/jumbo v0, sources
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;-><init>(Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getDisplayText()java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getExtraCount()I
    move-result v0
    if-lez v0, +022h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getPrimaryHost()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 43
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getExtraCount()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getPrimaryHost()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getExtraCount()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    add-int/lit8 v0, v0, -1
    const/4 v1, 0
    invoke-static v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    return v0
.end method

.method public final getPrimaryHost()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getHost()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final getSources()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    return v0
.end method

.method public final isSingle()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    if-ne v0, v1, +003h
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeRefGroup(sources="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->sources Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
