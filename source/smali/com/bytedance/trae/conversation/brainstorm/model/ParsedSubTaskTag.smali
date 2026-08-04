# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
.super Ljava/lang/Object;
.source "BrainstormMessage.kt"

.field private final cleanedText:Ljava/lang/String;
.field private final isIncompleteHead:Z
.field private final sourceStatus:Ljava/lang/String;
.field private final sourceTaskId:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "cleanedText"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.model.ParsedSubTaskTag  java.lang.String  java.lang.String  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.model.ParsedSubTaskTag
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  boolean)com.bytedance.trae.conversation.brainstorm.model.ParsedSubTaskTag
    .registers 6
    # ins_size=5
    const-string v0, "cleanedText"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCleanedText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    return-object v0
.end method

.method public final getSourceStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getSourceTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isIncompleteHead()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ParsedSubTaskTag(cleanedText="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->cleanedText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sourceTaskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceTaskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sourceStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->sourceStatus Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isIncompleteHead="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
