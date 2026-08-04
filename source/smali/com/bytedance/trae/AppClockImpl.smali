# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/AppClockImpl;
.super Ljava/lang/Object;
.source "AppClockImpl.kt"

.implements Lcom/bytedance/trae/common/apphost/time/AppClock;

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/AppClockImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private globalTime:Lkotlin/Pair;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/AppClockImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/AppClockImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/AppClockImpl;->Companion Lcom/bytedance/trae/AppClockImpl$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/AppClockImpl;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public currentTimeMillis()long
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/AppClockImpl;->globalTime Lkotlin/Pair;
    if-eqz v0, +00dh
    invoke-virtual v0, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, 0
    const-wide/16 v2, 10000
    cmp-long v0, v0, v2
    if-gez v0, +007h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    return-wide v0
    iget-object v0, v5, Lcom/bytedance/trae/AppClockImpl;->globalTime Lkotlin/Pair;
    if-eqz v0, +01dh
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v1
    invoke-virtual v0, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    sub-long/2addr v1, v3
    invoke-virtual v0, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    add-long/2addr v1, v3
    goto +5h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    return-wide v1
.end method

.method public updateTimestamp(long)void
    .registers 5
    # ins_size=3
    const-wide/16 v0, 0
    cmp-long v0, v3, v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/AppClockImpl;->globalTime Lkotlin/Pair;
    if-nez v0, +019h
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/AppClockImpl;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/AppClockImpl;->globalTime Lkotlin/Pair;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-void 
.end method
