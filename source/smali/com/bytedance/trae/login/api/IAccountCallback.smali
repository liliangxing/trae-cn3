# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/login/api/IAccountCallback;
.super Ljava/lang/Object;
.source "IAccountCallback.kt"


.method public abstract onDeviceOverLimit(java.lang.String  java.util.Map)void
    # abstract or native
.end method

.method public abstract onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    # abstract or native
.end method

.method public abstract onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    # abstract or native
.end method
