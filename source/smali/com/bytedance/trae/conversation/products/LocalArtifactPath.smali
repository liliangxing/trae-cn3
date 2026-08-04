# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
.super Ljava/lang/Object;
.source "LocalArtifactPath.kt"

.field private static final FILES_PREFIX:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/LocalArtifactPath;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->INSTANCE Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final requestTarget(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    const-string v0, "rawPath"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-object v6
    const-string v0, "files/"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v6, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +26h
    const-string v4, "/"
    invoke-static v6, v4, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +012h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "files"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    goto +eh
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method
