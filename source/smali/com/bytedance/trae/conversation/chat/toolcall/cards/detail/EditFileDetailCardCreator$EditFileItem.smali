# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
.super Ljava/lang/Object;
.source "EditFileDetailCardCreator.kt"

.field private final additions:I
.field private final deletions:I
.field private final displayName:Ljava/lang/String;
.field private final filePath:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  int  int)void
    .registers 6
    # ins_size=5
    const-string v0, "filePath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    iput v5, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  int  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;-><init>(Ljava/lang/String; Ljava/lang/String; I I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator$EditFileItem  java.lang.String  java.lang.String  int  int  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator$EditFileItem
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget v4, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->copy(Ljava/lang/String; Ljava/lang/String; I I)Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    return v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  int  int)com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator$EditFileItem
    .registers 6
    # ins_size=5
    const-string v0, "filePath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;-><init>(Ljava/lang/String; Ljava/lang/String; I I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    iget v5, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAdditions()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    return v0
.end method

.method public final getDeletions()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    return v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getFilePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EditFileItem(filePath="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->filePath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", displayName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->displayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", additions="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->additions I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deletions="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;->deletions I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
