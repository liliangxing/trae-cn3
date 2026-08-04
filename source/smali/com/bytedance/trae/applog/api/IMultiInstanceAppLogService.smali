# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;
.super Ljava/lang/Object;
.source "IMultiInstanceAppLogService.kt"

.field public static final Companion:Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;->$$INSTANCE Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;
    sput-object v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;->Companion Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;
    return-void 
.end method

.method public abstract createInstance()com.bytedance.trae.applog.api.IMultiInstanceAppLog
    # abstract or native
.end method
