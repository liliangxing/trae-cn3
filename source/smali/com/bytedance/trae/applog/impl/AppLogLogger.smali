# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogLogger;
.super Ljava/lang/Object;
.source "AppLogLogger.kt"

.implements Lcom/bytedance/bdinstall/ILogger;

.field private final tag:Ljava/lang/String;


.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    return-void 
.end method

.method public d(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    if-eqz v3, +008h
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v0, v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto +ah
    iget-object v3, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v2, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public e(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v0, v2, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
.end method

.method public i(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    if-eqz v3, +008h
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v0, v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto +ah
    iget-object v3, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v2, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public v(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    if-eqz v3, +008h
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v0, v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto +ah
    iget-object v3, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v2, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Landroid/util/Log;->v(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public w(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogLogger;->tag Ljava/lang/String;
    invoke-static v0, v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
.end method
