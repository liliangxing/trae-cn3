# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/interceptor/BackgroundRequestRejectException;
.super Ljava/io/IOException;
.source "BackgroundRequestRejectException.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/io/IOException;-><init>()V
    return-void 
.end method

.method public constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.Throwable)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/io/IOException;-><init>(Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Throwable)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
    return-void 
.end method
