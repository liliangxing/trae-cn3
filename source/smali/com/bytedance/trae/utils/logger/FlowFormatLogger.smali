# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/FlowFormatLogger;
.super Ljava/lang/Object;
.source "FormatLogBuilder.kt"

.field private final logger:Lcom/bytedance/trae/utils/logger/Logger;


.method public constructor <init>(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "module"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, subModule
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/utils/logger/Logger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v1, 45
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Lcom/bytedance/trae/utils/logger/Logger;-><init>(Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/utils/logger/FlowFormatLogger;->logger Lcom/bytedance/trae/utils/logger/Logger;
    return-void 
.end method

.method public final debug(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 5
    # ins_size=2
    const-string/jumbo v0, what
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/utils/logger/FlowFormatLogger;->logger Lcom/bytedance/trae/utils/logger/Logger;
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->DEBUG Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-direct v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;-><init>(Lcom/bytedance/trae/utils/logger/Logger; Lcom/bytedance/trae/utils/logger/LogLevel; Ljava/lang/String;)V
    return-object v0
.end method

.method public final error(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 5
    # ins_size=2
    const-string/jumbo v0, what
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/utils/logger/FlowFormatLogger;->logger Lcom/bytedance/trae/utils/logger/Logger;
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->ERROR Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-direct v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;-><init>(Lcom/bytedance/trae/utils/logger/Logger; Lcom/bytedance/trae/utils/logger/LogLevel; Ljava/lang/String;)V
    return-object v0
.end method

.method public final info(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 5
    # ins_size=2
    const-string/jumbo v0, what
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/utils/logger/FlowFormatLogger;->logger Lcom/bytedance/trae/utils/logger/Logger;
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->INFO Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-direct v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;-><init>(Lcom/bytedance/trae/utils/logger/Logger; Lcom/bytedance/trae/utils/logger/LogLevel; Ljava/lang/String;)V
    return-object v0
.end method

.method public final warn(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 5
    # ins_size=2
    const-string/jumbo v0, what
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/utils/logger/FlowFormatLogger;->logger Lcom/bytedance/trae/utils/logger/Logger;
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->WARN Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-direct v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;-><init>(Lcom/bytedance/trae/utils/logger/Logger; Lcom/bytedance/trae/utils/logger/LogLevel; Ljava/lang/String;)V
    return-object v0
.end method
