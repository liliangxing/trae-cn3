# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/utils/logger/Logger$WhenMappings;
.super Ljava/lang/Object;
.source "FormatLogBuilder.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/utils/logger/LogLevel;->values()[Lcom/bytedance/trae/utils/logger/LogLevel;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/utils/logger/LogLevel;->DEBUG Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-virtual v1, Lcom/bytedance/trae/utils/logger/LogLevel;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/utils/logger/LogLevel;->INFO Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-virtual v1, Lcom/bytedance/trae/utils/logger/LogLevel;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/utils/logger/LogLevel;->WARN Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-virtual v1, Lcom/bytedance/trae/utils/logger/LogLevel;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/utils/logger/LogLevel;->ERROR Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-virtual v1, Lcom/bytedance/trae/utils/logger/LogLevel;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/utils/logger/Logger$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
.end method
