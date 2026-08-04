# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/response/ApiRespInterceptedException;
.super Ljava/lang/RuntimeException;
.source "ApiRespInterceptedException.kt"


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;-><init>(Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Throwable)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Throwable  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/response/ApiRespInterceptedException;-><init>(Ljava/lang/Throwable;)V
    return-void 
.end method
