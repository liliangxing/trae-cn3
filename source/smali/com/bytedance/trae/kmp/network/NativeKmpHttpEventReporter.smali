# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;
.super Ljava/lang/Object;
.source "AndroidKmpHttpClientFactory.kt"

.implements Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;

.field public static final $stable:I
.field private final reporter:Lkotlin/jvm/functions/Function5;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;-><init>(Lkotlin/jvm/functions/Function5; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function5)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, reporter
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;->reporter Lkotlin/jvm/functions/Function5;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function5  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +00bh
    new-instance v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter$1;
    sget-object v2, Lcom/bytedance/trae/network/TraeRequestEventReporter;->INSTANCE Lcom/bytedance/trae/network/TraeRequestEventReporter;
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter$1;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function5;
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;-><init>(Lkotlin/jvm/functions/Function5;)V
    return-void 
.end method

.method public report(com.bytedance.trae.kmp.network.KmpHttpRequestEvent)void
    .registers 9
    # ins_size=2
    const-string v0, "event"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;->reporter Lkotlin/jvm/functions/Function5;
    invoke-virtual v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->getPath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->getCostTimeMs()J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-virtual v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->getCode()J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v8, Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;->getHeaders()Ljava/util/Map;
    move-result-object v6
    invoke-interface/range v1 ... v6, Lkotlin/jvm/functions/Function5;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
