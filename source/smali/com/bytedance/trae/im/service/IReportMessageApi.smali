# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IReportMessageApi;
.super Ljava/lang/Object;
.source "IReportMessageApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IReportMessageApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IReportMessageApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IReportMessageApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IReportMessageApi;->Companion Lcom/bytedance/trae/im/service/IReportMessageApi$Companion;
    return-void 
.end method

.method public abstract reportMessage(com.bytedance.trae.im.service.ReportMessageRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
