# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
.super Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;
.source "TraeRefParser.kt"

.field private final group:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
.field private final rawEnd:I
.field private final rawStart:I


.method public constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  int  int)void
    .registers 5
    # ins_size=4
    const-string v0, "group"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    iput v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefParser$Segment$Ref  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  int  int  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefParser$Segment$Ref
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->copy(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; I I)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup  int  int)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefParser$Segment$Ref
    .registers 5
    # ins_size=4
    const-string v0, "group"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; I I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    iget v5, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getGroup()com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    return-object v0
.end method

.method public final getRawEnd()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    return v0
.end method

.method public final getRawStart()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Ref(group="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->group Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawStart="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawStart I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawEnd="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->rawEnd I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
