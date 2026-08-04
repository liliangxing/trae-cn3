# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;
.super Ljava/lang/Object;
.source "IMultiInstanceAppLogService.kt"


.method public abstract init(android.content.Context  com.bytedance.trae.applog.api.MultiInstanceAppLogInitConfig)void
    # abstract or native
.end method

.method public abstract removeHeaderInfo(java.lang.String)void
    # abstract or native
.end method

.method public abstract reportEvent(java.lang.String)void
    # abstract or native
.end method

.method public abstract reportEvent(java.lang.String  android.os.Bundle)void
    # abstract or native
.end method

.method public abstract reportEvent(java.lang.String  org.json.JSONObject)void
    # abstract or native
.end method

.method public abstract setHeaderInfo(java.lang.String  java.lang.Object)void
    # abstract or native
.end method

.method public abstract setHeaderInfo(java.util.HashMap)void
    # abstract or native
.end method
