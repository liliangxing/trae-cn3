# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/ui/KmpClickHandlerKt;
.super Ljava/lang/Object;
.source "KmpClickHandler.kt"

.field private static final clickEpoch:J


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    sget-object v0, Lkotlin/time/TimeSource$Monotonic;->INSTANCE Lkotlin/time/TimeSource$Monotonic;
    invoke-virtual v0, Lkotlin/time/TimeSource$Monotonic;->markNow-z9LOYto()J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandlerKt;->clickEpoch J
    return-void 
.end method

.method public static final synthetic access$monotonicNowMillis()long
    .registers 2
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/ui/KmpClickHandlerKt;->monotonicNowMillis()J
    move-result-wide v0
    return-wide v0
.end method

.method private static final monotonicNowMillis()long
    .registers 2
    # ins_size=0
    sget-wide v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandlerKt;->clickEpoch J
    invoke-static v0, v1, Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;->elapsedNow-UwyO8pc(J)J
    move-result-wide v0
    invoke-static v0, v1, Lkotlin/time/Duration;->getInWholeMilliseconds-impl(J)J
    move-result-wide v0
    return-wide v0
.end method
