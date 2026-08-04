# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/network/NetWorkResult;
.super Ljava/lang/Object;
.source "NetWorkResult.kt"

.field private final body:Ljava/lang/String;
.field private final exception:Ljava/lang/Throwable;
.field private final headers:Ljava/util/Map;
.field private final message:Ljava/lang/String;
.field private final originRequestUrl:Ljava/lang/String;
.field private final status:I
.field private final stream:Ljava/io/BufferedReader;
.field private final url:Ljava/lang/String;


.method public constructor <init>(java.lang.String  int  java.util.Map  java.lang.String  java.lang.String  java.io.BufferedReader  java.lang.Throwable  java.lang.String)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    iput v3, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    iput-object v4, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    iput-object v5, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    iput-object v8, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    iput-object v9, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  int  java.util.Map  java.lang.String  java.lang.String  java.io.BufferedReader  java.lang.Throwable  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 23
    # ins_size=11
    move/from16 v0, v21
    and-int/lit8 v1, v0, 32
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v19
    and-int/lit16 v0, v0, 128
    if-eqz v0, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v20
    move-object v3, v12
    move-object v4, v13
    move v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/im/network/NetWorkResult;-><init>(Ljava/lang/String; I Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Ljava/io/BufferedReader; Ljava/lang/Throwable; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.network.NetWorkResult  java.lang.String  int  java.util.Map  java.lang.String  java.lang.String  java.io.BufferedReader  java.lang.Throwable  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.network.NetWorkResult
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget v3, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    goto +2h
    move v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v17
    move-object v10, v2
    move v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    move-object/from16 v16, v8
    move-object/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/im/network/NetWorkResult;->copy(Ljava/lang/String; I Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Ljava/io/BufferedReader; Ljava/lang/Throwable; Ljava/lang/String;)Lcom/bytedance/trae/im/network/NetWorkResult;
    move-result-object v0
    return-object v0
.end method

.method public final acquireLDeviceId()java.lang.String
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 0
    return-object v0
    return-object v1
.end method

.method public final acquireLogId()java.lang.String
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    if-eqz v0, +00ch
    const-string/jumbo v1, x-tt-logid
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    return v0
.end method

.method public final component3()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.io.BufferedReader
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    return-object v0
.end method

.method public final component7()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  int  java.util.Map  java.lang.String  java.lang.String  java.io.BufferedReader  java.lang.Throwable  java.lang.String)com.bytedance.trae.im.network.NetWorkResult
    .registers 19
    # ins_size=9
    const-string/jumbo v0, url
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/network/NetWorkResult;
    move-object v1, v0
    move v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    move-object/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/im/network/NetWorkResult;-><init>(Ljava/lang/String; I Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Ljava/io/BufferedReader; Ljava/lang/Throwable; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/network/NetWorkResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/network/NetWorkResult;
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    iget v3, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    iget-object v3, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    iget-object v3, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    return-object v0
.end method

.method public final getException()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    return-object v0
.end method

.method public final getHeaders()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getOriginRequestUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    return v0
.end method

.method public final getStream()java.io.BufferedReader
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    return-object v0
.end method

.method public final getUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/io/BufferedReader;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Throwable;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isSuccessful()boolean
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    const/16 v1, 200
    const/4 v2, 0
    if-gt v1, v0, +007h
    const/16 v1, 300
    if-ge v0, v1, +003h
    const/4 v2, 1
    return v2
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NetWorkResult(url="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->url Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->status I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", headers="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->headers Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", body="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->body Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", stream="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->stream Ljava/io/BufferedReader;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", exception="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->exception Ljava/lang/Throwable;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", originRequestUrl="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/network/NetWorkResult;->originRequestUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
