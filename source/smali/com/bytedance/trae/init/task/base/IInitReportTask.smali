# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/init/task/base/IInitReportTask;
.super Ljava/lang/Object;
.source "IInitReportTask.kt"

.implements Ljava/lang/Runnable;

.field public static final Companion:Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;->$$INSTANCE Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;
    sput-object v0, Lcom/bytedance/trae/init/task/base/IInitReportTask;->Companion Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;
    return-void 
.end method

.method public abstract checkFirstStartAsyncTaskInit(java.lang.String)boolean
    # abstract or native
.end method

.method public abstract getFirstStyle()java.lang.String
    # abstract or native
.end method

.method public abstract getScene()java.lang.String
    # abstract or native
.end method

.method public abstract run()void
    # abstract or native
.end method

.method public abstract runInternal()void
    # abstract or native
.end method
