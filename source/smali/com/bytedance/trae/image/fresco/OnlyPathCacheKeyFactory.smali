# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;
.super Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;
.source "FrescoExt.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;->INSTANCE Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;-><init>()V
    return-void 
.end method

.method private final getUriCacheKey(android.net.Uri)java.lang.String
    .registers 4
    # ins_size=2
    if-nez v3, +005h
    const-string v3, ""
    return-object v3
    const-string v0, "http"
    invoke-virtual v3, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +019h
    const-string v0, "https"
    invoke-virtual v3, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00dh
    invoke-virtual v3, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toString(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;->toStringWithoutHost(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final toStringWithoutHost(android.net.Uri)java.lang.String
    .registers 5
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ":"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v4, Landroid/net/Uri;->getEncodedAuthority()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +007h
    const-string v1, "//"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v4, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +005h
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v0, toString(...)
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method protected getCacheKeySourceUriStr(android.net.Uri)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;->getUriCacheKey(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method
