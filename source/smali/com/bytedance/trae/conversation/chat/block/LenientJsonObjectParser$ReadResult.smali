# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
.super Ljava/lang/Object;
.source "LenientJsonObjectParser.kt"

.field private final complete:Z
.field private final nextIndex:I
.field private final value:Ljava/lang/String;


.method public constructor <init>(java.lang.String  boolean  int)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, value
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.LenientJsonObjectParser$ReadResult  java.lang.String  boolean  int  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.LenientJsonObjectParser$ReadResult
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget v3, v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->copy(Ljava/lang/String; Z I)Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    return v0
.end method

.method public final copy(java.lang.String  boolean  int)com.bytedance.trae.conversation.chat.block.LenientJsonObjectParser$ReadResult
    .registers 5
    # ins_size=4
    const-string/jumbo v0, value
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    iget v5, v5, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getComplete()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    return v0
.end method

.method public final getNextIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    return v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ReadResult(value="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->value Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", complete="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->complete Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", nextIndex="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->nextIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
