# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/apm/impl/Logger$LogInfo;
.super Ljava/lang/Object;
.source "LoggerImpl.kt"

.field private final level:I
.field private final message:Ljava/lang/String;
.field private final millis:J
.field private final tag:Ljava/lang/String;
.field private final th:Ljava/lang/Throwable;


.method public constructor <init>(int  java.lang.String  java.lang.String  java.lang.Throwable  long)void
    .registers 8
    # ins_size=7
    const-string/jumbo v0, tag
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->level I
    iput-object v3, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->tag Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->message Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->th Ljava/lang/Throwable;
    iput-wide v6, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->millis J
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.String  java.lang.Throwable  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v14, v14, 16
    if-eqz v14, +006h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v12
    move-wide v5, v12
    move-object v0, v7
    move v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; J)V
    return-void 
.end method

.method public final getLevel()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->level I
    return v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->millis J
    return-wide v0
.end method

.method public final getTag()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->tag Ljava/lang/String;
    return-object v0
.end method

.method public final getTh()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->th Ljava/lang/Throwable;
    return-object v0
.end method
