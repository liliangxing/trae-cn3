# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
.super Ljava/lang/Object;
.source "VoiceSummaryRenderTracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
.field private static bridge firstCharOnScreenMs:J
.field private static bridge lastCharOnScreenMs:J
.field private static bridge onLastCharOnScreen:Lkotlin/jvm/functions/Function0;
.field private static bridge trackingId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-direct v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.conversation.perf.VoiceSummaryRenderTracker  java.lang.String  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->start(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final getFirstCharOnScreenMs()long
    .registers 3
    # ins_size=1
    sget-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->firstCharOnScreenMs J
    return-wide v0
.end method

.method public final getLastCharOnScreenMs()long
    .registers 3
    # ins_size=1
    sget-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->lastCharOnScreenMs J
    return-wide v0
.end method

.method public final markFirstChar(java.lang.String)void
    .registers 6
    # ins_size=2
    if-eqz v5, +01ah
    sget-object v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->trackingId Ljava/lang/String;
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +10h
    sget-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->firstCharOnScreenMs J
    const-wide/16 v2, 0
    cmp-long v5, v0, v2
    if-eqz v5, +003h
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->firstCharOnScreenMs J
    return-void 
.end method

.method public final markLastChar(java.lang.String)void
    .registers 6
    # ins_size=2
    if-eqz v5, +025h
    sget-object v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->trackingId Ljava/lang/String;
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +1bh
    sget-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->lastCharOnScreenMs J
    const-wide/16 v2, 0
    cmp-long v5, v0, v2
    if-nez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->lastCharOnScreenMs J
    if-eqz v5, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->onLastCharOnScreen Lkotlin/jvm/functions/Function0;
    if-eqz v5, +005h
    invoke-interface v5, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final start(java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=3
    const-string v0, "id"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    sput-object v3, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->trackingId Ljava/lang/String;
    const-wide/16 v0, 0
    sput-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->firstCharOnScreenMs J
    sput-wide v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->lastCharOnScreenMs J
    sput-object v4, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->onLastCharOnScreen Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final stop()void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->trackingId Ljava/lang/String;
    const-wide/16 v1, 0
    sput-wide v1, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->firstCharOnScreenMs J
    sput-wide v1, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->lastCharOnScreenMs J
    sput-object v0, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->onLastCharOnScreen Lkotlin/jvm/functions/Function0;
    return-void 
.end method
