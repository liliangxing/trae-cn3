# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/apm/api/INpth;
.super Ljava/lang/Object;
.source "INpth.kt"

.field public static final Companion:Lcom/bytedance/trae/apm/api/INpth$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/apm/api/INpth$Companion;->$$INSTANCE Lcom/bytedance/trae/apm/api/INpth$Companion;
    sput-object v0, Lcom/bytedance/trae/apm/api/INpth;->Companion Lcom/bytedance/trae/apm/api/INpth$Companion;
    return-void 
.end method

.method public abstract enableGwpAsan()void
    # abstract or native
.end method

.method public abstract goUpload()void
    # abstract or native
.end method

.method public abstract init(android.content.Context)void
    # abstract or native
.end method

.method public abstract registerCrashCallback(com.bytedance.trae.apm.api.ICrashCallback)void
    # abstract or native
.end method

.method public abstract startNpthLifecycleRecorder(android.app.Application  int)void
    # abstract or native
.end method

.method public abstract stopUpload(boolean)void
    # abstract or native
.end method
