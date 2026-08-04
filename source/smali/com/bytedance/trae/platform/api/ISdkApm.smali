# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/platform/api/ISdkApm;
.super Ljava/lang/Object;
.source "ISdkApm.kt"


.method public abstract ensureNotReachHere(java.lang.String)void
    # abstract or native
.end method

.method public abstract ensureNotReachHere(java.lang.Throwable)void
    # abstract or native
.end method

.method public abstract ensureNotReachHere(java.lang.Throwable  java.lang.String)void
    # abstract or native
.end method

.method public abstract ensureNotReachHere(java.lang.Throwable  java.lang.String  java.util.Map)void
    # abstract or native
.end method

.method public abstract getPageLoadTrace(java.lang.String)com.bytedance.trae.platform.api.IPageLoadTrace
    # abstract or native
.end method

.method public abstract handleCloudMessage(byte[]  java.util.Map)void
    # abstract or native
.end method

.method public abstract monitorEventForSlardar(java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    # abstract or native
.end method

.method public abstract startCpuMonitor(java.lang.String)void
    # abstract or native
.end method

.method public abstract stopCpuMonitor(java.lang.String)void
    # abstract or native
.end method
