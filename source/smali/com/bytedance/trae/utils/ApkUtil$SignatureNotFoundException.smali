# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
.super Ljava/lang/Exception;
.source "ApkUtil.java"

.field private static final serialVersionUID:J


.method public constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.Throwable)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method
