# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/common/security/api/SecurityService;
.super Ljava/lang/Object;
.source "SecurityService.kt"


.method public abstract createBdInterceptor()com.bytedance.retrofit2.intercept.Interceptor
    # abstract or native
.end method

.method public abstract enableTTNetEncrypt()boolean
    # abstract or native
.end method

.method public abstract forceTTNetRetry()boolean
    # abstract or native
.end method

.method public abstract getTTNetEncryptScene(java.lang.String)java.lang.String
    # abstract or native
.end method

.method public abstract initAOPEnvironment(android.content.Context)void
    # abstract or native
.end method

.method public abstract initBdInstall()void
    # abstract or native
.end method

.method public abstract msFrameSign(java.lang.String)java.util.Map
    # abstract or native
.end method

.method public abstract msInit(android.content.Context)void
    # abstract or native
.end method

.method public abstract msReport(android.content.Context  java.lang.String)void
    # abstract or native
.end method

.method public abstract shouldAddTTNetEncryptHeader(java.lang.String)boolean
    # abstract or native
.end method

.method public abstract tryMobTTNetEncryptResult(java.lang.String  java.lang.String  java.util.List)void
    # abstract or native
.end method
