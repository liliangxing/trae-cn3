# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
.super Ljava/lang/Object;
.source "SimpleMarkdownTextView.kt"

.field private final color:Ljava/lang/Integer;
.field private final sizesSp:Ljava/util/Map;


.method public constructor <init>(java.util.Map  java.lang.Integer)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig  java.util.Map  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->copy(Ljava/util/Map; Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(java.util.Map  java.lang.Integer)com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;-><init>(Ljava/util/Map; Ljava/lang/Integer;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getColor()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    return-object v0
.end method

.method public final getSizesSp()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "HeaderStyleConfig(sizesSp="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->sizesSp Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", color="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;->color Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
