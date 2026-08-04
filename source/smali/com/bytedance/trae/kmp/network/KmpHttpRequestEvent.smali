# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;
.super Ljava/lang/Object;
.source "KmpHttpEventReporter.kt"

.field public static final $stable:I
.field private final code:J
.field private final costTimeMs:J
.field private final headers:Ljava/util/Map;
.field private final message:Ljava/lang/String;
.field private final path:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  long  long  java.lang.String  java.util.Map)void
    .registers 9
    # ins_size=8
    const-string/jumbo v0, path
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    iput-wide v5, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    iput-object v7, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.network.KmpHttpRequestEvent  java.lang.String  long  long  java.lang.String  java.util.Map  int  java.lang.Object)com.bytedance.trae.kmp.network.KmpHttpRequestEvent
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-wide v7, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    move-wide v0, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-wide v9, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    move-wide v2, v9
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    move-object v14, v11
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-wide v9, v0
    move-wide v11, v2
    move-object v13, v14
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->copy(Ljava/lang/String; J J Ljava/lang/String; Ljava/util/Map;)Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    return-wide v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    return-wide v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final copy(java.lang.String  long  long  java.lang.String  java.util.Map)com.bytedance.trae.kmp.network.KmpHttpRequestEvent
    .registers 17
    # ins_size=8
    const-string/jumbo v0, path
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;
    move-object v1, v0
    move-wide v3, v11
    move-wide v5, v13
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;-><init>(Ljava/lang/String; J J Ljava/lang/String; Ljava/util/Map;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    iget-object v8, v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCode()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    return-wide v0
.end method

.method public final getCostTimeMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    return-wide v0
.end method

.method public final getHeaders()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "KmpHttpRequestEvent(path="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->path Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", costTimeMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->costTimeMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", code="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->code J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", headers="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->headers Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
