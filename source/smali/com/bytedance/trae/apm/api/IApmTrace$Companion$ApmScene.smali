# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
.super Ljava/lang/Enum;
.source "IApmTrace.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
.field public static final enum DORA_QUERY:Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
.field public static final enum MUSIC_PLAY:Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
.field public static final enum NAVIGATION_LOCATING:Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
.field public static final enum REALTIME_CALL:Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
.field public static final enum TTS_PLAY:Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;


.method private static final synthetic $values()com.bytedance.trae.apm.api.IApmTrace$Companion$ApmScene[]
    .registers 3
    # ins_size=0
    const/4 v0, 5
    new-array v0, v0, [Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->DORA_QUERY Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->TTS_PLAY Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->REALTIME_CALL Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->NAVIGATION_LOCATING Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->MUSIC_PLAY Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    const-string v1, "DORA_QUERY"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->DORA_QUERY Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    new-instance v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    const-string v1, "TTS_PLAY"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->TTS_PLAY Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    new-instance v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    const-string v1, "REALTIME_CALL"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->REALTIME_CALL Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    new-instance v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    const-string v1, "NAVIGATION_LOCATING"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->NAVIGATION_LOCATING Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    new-instance v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    const-string v1, "MUSIC_PLAY"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->MUSIC_PLAY Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    invoke-static Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->$values()[Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->$VALUES [Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.apm.api.IApmTrace$Companion$ApmScene
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    return-object v1
.end method

.method public static values()com.bytedance.trae.apm.api.IApmTrace$Companion$ApmScene[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;->$VALUES [Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/apm/api/IApmTrace$Companion$ApmScene;
    return-object v0
.end method
