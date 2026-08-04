# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;
.super Ljava/lang/Object;
.source "HtmlArtifactRemoteArchiveUrlBuilder.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final build(java.lang.String  java.lang.String  java.lang.String  java.lang.String)java.lang.String
    .registers 9
    # ins_size=5
    const-string v0, "explorerUrl"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "archivePath"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filename"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, xttToken
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    const/4 v1, 1
    new-array v1, v1, [C
    const/4 v2, 0
    const/16 v3, 47
    aput-char v3, v1, v2
    invoke-static v5, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "/archive.zip?path="
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, "UTF-8"
    invoke-static v6, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "&filename="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-static v7, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "&authorization="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "Cloud-IDE-JWT "
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method
