# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
.super Ljava/lang/Object;
.source "KmpRawHttpClient.kt"

.field public static final $stable:I
.field private final error:Ljava/lang/Throwable;
.field private final headers:Ljava/util/Map;
.field private final rawBody:Ljava/lang/String;
.field private final statusCode:I
.field private final statusMessage:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  int  java.lang.String  java.util.Map  java.lang.Throwable)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, statusMessage
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    iput v3, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    iput-object v6, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.network.KmpRawHttpResult  java.lang.String  int  java.lang.String  java.util.Map  java.lang.Throwable  int  java.lang.Object)com.bytedance.trae.kmp.network.KmpRawHttpResult
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget v5, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->copy(Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/Throwable;)Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final component5()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    return-object v0
.end method

.method public final copy(java.lang.String  int  java.lang.String  java.util.Map  java.lang.Throwable)com.bytedance.trae.kmp.network.KmpRawHttpResult
    .registers 13
    # ins_size=6
    const-string/jumbo v0, statusMessage
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    move-object v1, v0
    move-object v2, v8
    move v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/Throwable;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    iget v3, v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getError()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    return-object v0
.end method

.method public final getHeaders()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final getRawBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    return-object v0
.end method

.method public final getStatusCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    return v0
.end method

.method public final getStatusMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v2, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    invoke-static v2, Ljava/lang/Integer;->hashCode(I)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Throwable;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "KmpRawHttpResult(rawBody="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->rawBody Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", statusCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", statusMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->statusMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", headers="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->headers Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", error="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;->error Ljava/lang/Throwable;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
