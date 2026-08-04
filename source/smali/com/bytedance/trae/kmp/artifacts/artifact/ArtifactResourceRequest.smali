# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"

.field public static final $stable:I
.field private final artifactPath:Ljava/lang/String;
.field private final cliConversationId:Ljava/lang/String;
.field private final conversationId:Ljava/lang/String;
.field private final messageId:Ljava/lang/String;
.field private final rendition:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
.field private final source:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.ArtifactRendition)void
    .registers 8
    # ins_size=7
    const-string/jumbo v0, source
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliConversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "artifactPath"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, rendition
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest  com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.ArtifactRendition  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->copy(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    move-result-object v4
    return-object v4
.end method

.method public final component1()com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.kmp.artifacts.artifact.ArtifactRendition
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.ArtifactRendition)com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest
    .registers 15
    # ins_size=7
    const-string/jumbo v0, source
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliConversationId"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "artifactPath"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, rendition
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getArtifactPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    return-object v0
.end method

.method public final getCliConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getRendition()com.bytedance.trae.kmp.artifacts.artifact.ArtifactRendition
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    return-object v0
.end method

.method public final getSource()com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ArtifactResourceRequest(source="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->source Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cliConversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->cliConversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", artifactPath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->artifactPath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rendition="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceRequest;->rendition Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRendition;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
