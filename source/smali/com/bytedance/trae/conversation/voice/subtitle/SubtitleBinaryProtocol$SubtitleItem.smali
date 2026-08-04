# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;
.super Ljava/lang/Object;
.source "SubtitleBinaryProtocol.kt"

.field private final definite:Z
.field private final paragraph:Z
.field private final text:Ljava/lang/String;
.field private final userId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;-><init>(Z Ljava/lang/String; Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean  java.lang.String  boolean  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    iput-object v5, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  java.lang.String  boolean  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 9
    # ins_size=7
    and-int/lit8 v8, v7, 1
    const/4 v0, 0
    if-eqz v8, +003h
    move v3, v0
    and-int/lit8 v8, v7, 2
    const-string v1, ""
    if-eqz v8, +003h
    move-object v4, v1
    and-int/lit8 v8, v7, 4
    if-eqz v8, +003h
    move v5, v0
    and-int/lit8 v7, v7, 8
    if-eqz v7, +003h
    move-object v6, v1
    invoke-direct v2, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;-><init>(Z Ljava/lang/String; Z Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol$SubtitleItem  boolean  java.lang.String  boolean  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol$SubtitleItem
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->copy(Z Ljava/lang/String; Z Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(boolean  java.lang.String  boolean  java.lang.String)com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol$SubtitleItem
    .registers 6
    # ins_size=5
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;-><init>(Z Ljava/lang/String; Z Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDefinite()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    return v0
.end method

.method public final getParagraph()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    return v0
.end method

.method public final getText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubtitleItem(definite="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->definite Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", text="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->text Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", paragraph="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->paragraph Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
