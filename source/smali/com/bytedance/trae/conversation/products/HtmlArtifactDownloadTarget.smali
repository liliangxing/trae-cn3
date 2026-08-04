# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
.super Ljava/lang/Object;
.source "HtmlArtifactDownloadTarget.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
.field private final localRequestPath:Ljava/lang/String;
.field private final remoteArchivePath:Ljava/lang/String;
.field private final requestedHtmlName:Ljava/lang/String;
.field private final savePath:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "localRequestPath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remoteArchivePath"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, savePath
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestedHtmlName
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget
    .registers 6
    # ins_size=5
    const-string v0, "localRequestPath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remoteArchivePath"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, savePath
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestedHtmlName
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getArchiveFileName()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->access$substringAfterLastPathSeparator(Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getLocalRequestPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    return-object v0
.end method

.method public final getRemoteArchivePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    return-object v0
.end method

.method public final getRequestPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    return-object v0
.end method

.method public final getRequestedHtmlName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    return-object v0
.end method

.method public final getSavePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "HtmlArtifactDownloadTarget(localRequestPath="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->localRequestPath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", remoteArchivePath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->remoteArchivePath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", savePath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->savePath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", requestedHtmlName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->requestedHtmlName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
