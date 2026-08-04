# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
.super Ljava/lang/Object;
.source "ArtifactTrack.kt"

.field private static final EVENT_ARTIFACT_CLICK:Ljava/lang/String;
.field private static final EVENT_ARTIFACT_CLOSE:Ljava/lang/String;
.field private static final EVENT_ARTIFACT_OPEN:Ljava/lang/String;
.field private static final EVENT_ARTIFACT_OPEN_LOCAL:Ljava/lang/String;
.field private static final EVENT_ARTIFACT_SHOW:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildArtifactId(java.lang.String  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v0, 95
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->normalizeArtifactPath(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private final extractFileExtension(java.lang.String)java.lang.String
    .registers 11
    # ins_size=2
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const-string v2, ""
    if-eqz v0, +003h
    return-object v2
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    move-object v3, v10
    check-cast v3, Ljava/lang/CharSequence;
    const/16 v4, 46
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-lez v0, +00dh
    add-int/2addr v0, v1
    invoke-virtual v10, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v10, substring(...)
    invoke-static v2, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final extractFileName(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    const/4 v2, 1
    if-eqz v2, +005h
    const-string v6, ""
    return-object v6
    const/16 v2, 92
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/16 v2, 47
    invoke-static v6, v2, v4, v3, v4, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method private final getArtifactType(java.lang.String)java.lang.String
    .registers 10
    # ins_size=2
    const-string v0, "diff"
    const-string/jumbo v1, svg
    const-string v2, "pdf"
    const-string v3, "csv"
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->normalizeArtifactPath(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string v4, "http://"
    const/4 v5, 0
    const/4 v6, 2
    const/4 v7, 0
    invoke-static v9, v4, v7, v6, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +110h
    const-string v4, "https://"
    invoke-static v9, v4, v7, v6, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    goto/16 +106h
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v9, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v9, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Ljava/lang/String;->hashCode()I
    move-result v4
    const-string v5, "pptx"
    const-string v6, "html"
    const-string v7, "md"
    sparse-switch v4, +00000f0h
    goto/16 +0e4h
    const-string v0, "markdown"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +0dah
    goto/16 +0dah
    const-string/jumbo v0, xhtml
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +09ch
    goto/16 +0cfh
    const-string/jumbo v0, xlsx
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +051h
    goto/16 +0c4h
    const-string/jumbo v0, webp
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +0afh
    goto/16 +0b9h
    const-string/jumbo v0, tiff
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +0a4h
    goto/16 +0aeh
    invoke-virtual v9, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +04ch
    goto/16 +0a6h
    const-string v0, "jpeg"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +092h
    goto/16 +09ch
    invoke-virtual v9, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +061h
    goto/16 +094h
    const-string v0, "docx"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +06bh
    goto/16 +08ah
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +08ch
    goto/16 +082h
    const-string/jumbo v0, xls
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +004h
    goto/16 +077h
    const-string v0, "excel"
    goto/16 +07bh
    invoke-virtual v9, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +004h
    goto/16 +06bh
    move-object v0, v1
    goto/16 +070h
    const-string v0, "ppt"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +004h
    goto/16 +05eh
    move-object v0, v5
    goto/16 +063h
    const-string v0, "png"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +047h
    goto +51h
    invoke-virtual v9, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +4ah
    move-object v0, v2
    goto +50h
    const-string v0, "jpg"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +035h
    goto +3fh
    const-string v0, "htm"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +36h
    move-object v0, v6
    goto +3ch
    const-string v0, "gif"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +021h
    goto +2bh
    const-string v0, "doc"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +22h
    const-string v0, "docs"
    goto +27h
    invoke-virtual v9, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +18h
    move-object v0, v3
    goto +1eh
    const-string v0, "bmp"
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +dh
    const-string v0, "image"
    goto +12h
    invoke-virtual v9, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +3h
    move-object v0, v7
    goto +9h
    const-string v0, "others"
    goto +6h
    const-string v9, "http_url"
    return-object v9
    const-string v0, ""
    return-object v0
    sparse-switch-payload d97 17d85 18206 18538 18fc4 194e1 19be1 1b0f2 1b229 1b274 1be64 1cfff 2f0c05 2f2240 3107ab 31e068 349c84 3651f5 379f9c 383059 6cc0c23 eb7fcef
    :try_start_0x9
    :try_start_0x41
.end method

.method private final normalizeArtifactPath(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    const/16 v0, 63
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v7, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    const/16 v0, 35
    invoke-static v7, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    const-string v0, "files/"
    const/4 v3, 0
    invoke-static v7, v0, v3, v2, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    const-string v5, "/"
    if-eqz v4, +009h
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v7, v0, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v7
    goto +16h
    const-string v0, "files"
    invoke-static v7, v0, v3, v2, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00fh
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v7, v0, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v7
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v7, v0, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v7
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v7, v5, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v7
    return-object v7
.end method

.method private final report(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, reportEvent: 
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-interface v5, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v5
    if-eqz v5, +01eh
    const-string v5, "ArtifactTrack"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", params: "
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v5, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v5, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v5, v4, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x3
.end method

.method public final trackArtifactClick(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, reportEvent: icube_artifact_click, params: 
    const-string v1, "messageId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v6, +003h
    return-void 
    const-string v1, "icube_artifact_click"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_id"
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-direct v4, v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->buildArtifactId(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->getArtifactType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +014h
    const-string v6, "ArtifactTrack"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xb
.end method

.method public final trackArtifactClickWithArtifactType(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, reportEvent: icube_artifact_click, params: 
    const-string v1, "artifactType"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "messageId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "icube_artifact_click"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_id"
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const/16 v4, 95
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    invoke-virtual v2, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +014h
    const-string v6, "ArtifactTrack"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xd
.end method

.method public final trackArtifactClose(java.lang.String  java.lang.String  long)void
    .registers 10
    # ins_size=5
    const-string/jumbo v0, reportEvent: icube_artifact_close, params: 
    const-string v1, "messageId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v6, +003h
    return-void 
    const-string v1, "icube_artifact_close"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_id"
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-direct v4, v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->buildArtifactId(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->getArtifactType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v6, stay_time
    invoke-virtual v2, v6, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +014h
    const-string v6, "ArtifactTrack"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xb
.end method

.method public final trackArtifactOpen(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, reportEvent: icube_artifact_open, params: 
    const-string v1, "messageId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v6, +003h
    return-void 
    const-string v1, "icube_artifact_open"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_id"
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-direct v4, v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->buildArtifactId(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->getArtifactType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +014h
    const-string v6, "ArtifactTrack"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xb
.end method

.method public final trackArtifactOpenLocal(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, reportEvent: icube_artifact_open_local, params: 
    const-string v1, "messageId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v6, +003h
    return-void 
    const-string v1, "icube_artifact_open_local"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_id"
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-direct v4, v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->buildArtifactId(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->getArtifactType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +014h
    const-string v6, "ArtifactTrack"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xb
.end method

.method public final trackArtifactShow(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, reportEvent: icube_artifact_show, params: 
    const-string v1, "messageId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v6, +003h
    return-void 
    const-string v1, "icube_artifact_show"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_id"
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-direct v4, v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->buildArtifactId(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->getArtifactType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +014h
    const-string v6, "ArtifactTrack"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xb
.end method

.method public final trackArtifactWithArtifactType(java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, reportEvent: icube_artifact_show, params: 
    const-string v1, "artifactType"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "messageId"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "icube_artifact_show"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_id"
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const/16 v4, 95
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    invoke-virtual v2, v7, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-eqz v6, +014h
    const-string v6, "ArtifactTrack"
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xd
.end method
