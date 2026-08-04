# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/apm/api/IApmTrace;
.super Ljava/lang/Object;
.source "IApmTrace.kt"

.field public static final Companion:Lcom/bytedance/trae/apm/api/IApmTrace$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->$$INSTANCE Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    return-void 
.end method

.method public abstract addPerfTag(java.lang.String  java.lang.String)void
    # abstract or native
.end method

.method public abstract addTag(java.lang.String  java.lang.String)void
    # abstract or native
.end method

.method public abstract reportApmEvent(java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    # abstract or native
.end method

.method public abstract reportTeaEvent(java.lang.String  org.json.JSONObject)void
    # abstract or native
.end method

.method public abstract startApmScene(java.lang.String)void
    # abstract or native
.end method

.method public abstract stopApmScene(java.lang.String)void
    # abstract or native
.end method

.method public abstract traceAll(java.lang.String  java.lang.String)void
    # abstract or native
.end method
