# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;
.super Ljava/lang/Object;
.source "ApmServiceImpl.kt"

.implements Lcom/bytedance/trae/platform/api/IPageLoadTrace;

.field public static final $stable:I
.field private final trace:Lcom/bytedance/apm/trace/PageLoadTrace;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, pageName
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/apm/trace/PageLoadTrace;
    invoke-direct v0, v2, Lcom/bytedance/apm/trace/PageLoadTrace;-><init>(Ljava/lang/String;)V
    iput-object v0, v1, Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;->trace Lcom/bytedance/apm/trace/PageLoadTrace;
    return-void 
.end method

.method public endSpan(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, spanName
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;->trace Lcom/bytedance/apm/trace/PageLoadTrace;
    invoke-virtual v0, v2, Lcom/bytedance/apm/trace/PageLoadTrace;->endSpan(Ljava/lang/String;)V
    return-void 
.end method

.method public endTrace(int  long)void
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;->trace Lcom/bytedance/apm/trace/PageLoadTrace;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/apm/trace/PageLoadTrace;->endTrace(I J)V
    return-void 
.end method

.method public startSpan(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, spanName
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;->trace Lcom/bytedance/apm/trace/PageLoadTrace;
    invoke-virtual v0, v2, Lcom/bytedance/apm/trace/PageLoadTrace;->startSpan(Ljava/lang/String;)V
    return-void 
.end method

.method public startTrace()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;->trace Lcom/bytedance/apm/trace/PageLoadTrace;
    invoke-virtual v0, Lcom/bytedance/apm/trace/PageLoadTrace;->startTrace()V
    return-void 
.end method
