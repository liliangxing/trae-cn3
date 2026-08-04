# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;
.super Ljava/lang/Object;
.source "SessionPreviewUrlBuilder.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;->INSTANCE Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final build(java.lang.String  java.lang.String)java.lang.String
    .registers 10
    # ins_size=3
    const-string/jumbo v0, sessionPreviewUrl
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pathSearchHash"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/net/URL;
    invoke-direct v0, v8, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/net/URL;->getPath()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +004h
    const-string v8, "/"
    check-cast v8, Ljava/lang/String;
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v4, 2
    const/4 v5, 0
    const/16 v6, 47
    invoke-static v1, v6, v3, v4, v5, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +12h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    new-instance v1, Ljava/net/URL;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, Ljava/net/URL;->getProtocol()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "://"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v0, Ljava/net/URL;->getAuthority()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v1, v8, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    new-array v8, v2, [C
    aput-char v6, v8, v3
    invoke-static v9, v8, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v8
    new-instance v9, Ljava/net/URL;
    invoke-direct v9, v1, v8, Ljava/net/URL;-><init>(Ljava/net/URL; Ljava/lang/String;)V
    invoke-virtual v9, Ljava/net/URL;->toString()Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v9, toString(...)
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v8
.end method
