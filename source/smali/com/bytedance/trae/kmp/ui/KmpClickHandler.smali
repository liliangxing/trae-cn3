# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
.super Ljava/lang/Object;
.source "KmpClickHandler.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/ui/KmpClickHandler$Companion;
.field public static final MIN_CLICK_INTERVAL_MS:J
.field private lastHandledAtMillis:Ljava/lang/Long;
.field private final nowMillis:Lkotlin/jvm/functions/Function0;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->Companion Lcom/bytedance/trae/kmp/ui/KmpClickHandler$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, nowMillis
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->nowMillis Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    sget-object v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;->INSTANCE Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;
    check-cast v1, Lkotlin/jvm/functions/Function0;
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final tryHandle(kotlin.jvm.functions.Function0)boolean
    .registers 8
    # ins_size=2
    const-string v0, "action"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->nowMillis Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    iget-object v2, v6, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->lastHandledAtMillis Ljava/lang/Long;
    if-eqz v2, +010h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v2
    sub-long v2, v0, v2
    const-wide/16 v4, 200
    cmp-long v2, v2, v4
    if-gez v2, +004h
    const/4 v7, 0
    return v7
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    iput-object v0, v6, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->lastHandledAtMillis Ljava/lang/Long;
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    const/4 v7, 1
    return v7
.end method
