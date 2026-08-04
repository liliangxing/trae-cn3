# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpHttpResult;
.super Ljava/lang/Object;
.source "KmpHttpResult.kt"

.field public static final $stable:I
.field private final data:Ljava/lang/Object;
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

.method public constructor <init>(java.lang.Object  java.lang.String  int  java.lang.String  java.util.Map  java.lang.Throwable)void
    .registers 8
    # ins_size=7
    const-string/jumbo v0, statusMessage
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    iput-object v5, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    iput-object v7, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.network.KmpHttpResult  java.lang.Object  java.lang.String  int  java.lang.String  java.util.Map  java.lang.Throwable  int  java.lang.Object)com.bytedance.trae.kmp.network.KmpHttpResult
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget v7, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    move v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->copy(Ljava/lang/Object; Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/Throwable;)Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final component6()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
    return-object v0
.end method

.method public final copy(java.lang.Object  java.lang.String  int  java.lang.String  java.util.Map  java.lang.Throwable)com.bytedance.trae.kmp.network.KmpHttpResult
    .registers 15
    # ins_size=7
    const-string/jumbo v0, statusMessage
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/network/KmpHttpResult;-><init>(Ljava/lang/Object; Ljava/lang/String; I Ljava/lang/String; Ljava/util/Map; Ljava/lang/Throwable;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    iget v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final getError()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
    return-object v0
.end method

.method public final getHeaders()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final getRawBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    return-object v0
.end method

.method public final getStatusCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    return v0
.end method

.method public final getStatusMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    invoke-static v2, Ljava/lang/Integer;->hashCode(I)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
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
    const-string v1, "KmpHttpResult(data="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->data Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawBody="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->rawBody Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", statusCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", statusMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->statusMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", headers="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->headers Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", error="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->error Ljava/lang/Throwable;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
