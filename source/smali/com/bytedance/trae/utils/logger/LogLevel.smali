# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/utils/logger/LogLevel;
.super Ljava/lang/Enum;
.source "FormatLogBuilder.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/utils/logger/LogLevel;
.field public static final enum DEBUG:Lcom/bytedance/trae/utils/logger/LogLevel;
.field public static final enum ERROR:Lcom/bytedance/trae/utils/logger/LogLevel;
.field public static final enum INFO:Lcom/bytedance/trae/utils/logger/LogLevel;
.field public static final enum WARN:Lcom/bytedance/trae/utils/logger/LogLevel;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.utils.logger.LogLevel[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/utils/logger/LogLevel;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->DEBUG Lcom/bytedance/trae/utils/logger/LogLevel;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->INFO Lcom/bytedance/trae/utils/logger/LogLevel;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->WARN Lcom/bytedance/trae/utils/logger/LogLevel;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/utils/logger/LogLevel;->ERROR Lcom/bytedance/trae/utils/logger/LogLevel;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogLevel;
    const/4 v1, 0
    const-string v2, "D"
    const-string v3, "DEBUG"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/utils/logger/LogLevel;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->DEBUG Lcom/bytedance/trae/utils/logger/LogLevel;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogLevel;
    const/4 v1, 1
    const-string v2, "I"
    const-string v3, "INFO"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/utils/logger/LogLevel;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->INFO Lcom/bytedance/trae/utils/logger/LogLevel;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogLevel;
    const/4 v1, 2
    const-string v2, "W"
    const-string v3, "WARN"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/utils/logger/LogLevel;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->WARN Lcom/bytedance/trae/utils/logger/LogLevel;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogLevel;
    const/4 v1, 3
    const-string v2, "E"
    const-string v3, "ERROR"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/utils/logger/LogLevel;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->ERROR Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-static Lcom/bytedance/trae/utils/logger/LogLevel;->$values()[Lcom/bytedance/trae/utils/logger/LogLevel;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->$VALUES [Lcom/bytedance/trae/utils/logger/LogLevel;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/utils/logger/LogLevel;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.utils.logger.LogLevel
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/utils/logger/LogLevel;
    return-object v1
.end method

.method public static values()com.bytedance.trae.utils.logger.LogLevel[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogLevel;->$VALUES [Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/utils/logger/LogLevel;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogLevel;->value Ljava/lang/String;
    return-object v0
.end method
