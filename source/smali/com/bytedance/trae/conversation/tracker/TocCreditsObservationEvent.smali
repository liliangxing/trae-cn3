# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
.super Ljava/lang/Object;
.source "TocCreditsObservation.kt"

.field private final category:Ljava/util/Map;
.field private final channel:Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
.field private final metric:Ljava/util/Map;
.field private final name:Ljava/lang/String;


.method public constructor <init>(com.bytedance.trae.conversation.tracker.TocCreditsObservationChannel  java.lang.String  java.util.Map  java.util.Map)void
    .registers 6
    # ins_size=5
    const-string v0, "channel"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "category"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "metric"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.tracker.TocCreditsObservationChannel  java.lang.String  java.util.Map  java.util.Map  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v4
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;-><init>(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent  com.bytedance.trae.conversation.tracker.TocCreditsObservationChannel  java.lang.String  java.util.Map  java.util.Map  int  java.lang.Object)com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->copy(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map;)Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.tracker.TocCreditsObservationChannel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    return-object v0
.end method

.method public final component4()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.tracker.TocCreditsObservationChannel  java.lang.String  java.util.Map  java.util.Map)com.bytedance.trae.conversation.tracker.TocCreditsObservationEvent
    .registers 6
    # ins_size=5
    const-string v0, "channel"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "category"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "metric"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;-><init>(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCategory()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    return-object v0
.end method

.method public final getChannel()com.bytedance.trae.conversation.tracker.TocCreditsObservationChannel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    return-object v0
.end method

.method public final getMetric()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TocCreditsObservationEvent(channel="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->channel Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", category="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->category Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", metric="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;->metric Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
