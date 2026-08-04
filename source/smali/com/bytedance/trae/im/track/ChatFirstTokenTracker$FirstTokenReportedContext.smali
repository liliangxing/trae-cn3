# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
.super Ljava/lang/Object;
.source "ChatFirstTokenTracker.kt"

.field private final categories:Lorg/json/JSONObject;
.field private final firstTokenTime:J
.field private final metrics:Lorg/json/JSONObject;
.field private final serverTimingInfo:Ljava/lang/String;


.method public constructor <init>(org.json.JSONObject  org.json.JSONObject  long  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string v0, "categories"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "metrics"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    iput-object v3, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    iput-wide v4, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    iput-object v6, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.track.ChatFirstTokenTracker$FirstTokenReportedContext  org.json.JSONObject  org.json.JSONObject  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.track.ChatFirstTokenTracker$FirstTokenReportedContext
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-wide v6, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    move-wide v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-wide v8, v0
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->copy(Lorg/json/JSONObject; Lorg/json/JSONObject; J Ljava/lang/String;)Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    move-result-object v3
    return-object v3
.end method

.method public final component1()org.json.JSONObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    return-object v0
.end method

.method public final component2()org.json.JSONObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    return-object v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    return-wide v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    return-object v0
.end method

.method public final copy(org.json.JSONObject  org.json.JSONObject  long  java.lang.String)com.bytedance.trae.im.track.ChatFirstTokenTracker$FirstTokenReportedContext
    .registers 13
    # ins_size=6
    const-string v0, "categories"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "metrics"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-wide v4, v10
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;-><init>(Lorg/json/JSONObject; Lorg/json/JSONObject; J Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    iget-object v3, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    iget-wide v5, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCategories()org.json.JSONObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    return-object v0
.end method

.method public final getFirstTokenTime()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    return-wide v0
.end method

.method public final getMetrics()org.json.JSONObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    return-object v0
.end method

.method public final getServerTimingInfo()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    invoke-virtual v0, Lorg/json/JSONObject;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    invoke-virtual v1, Lorg/json/JSONObject;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "FirstTokenReportedContext(categories="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->categories Lorg/json/JSONObject;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", metrics="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->metrics Lorg/json/JSONObject;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", firstTokenTime="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->firstTokenTime J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", serverTimingInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;->serverTimingInfo Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
