# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/settings/api/feature/Feature;
.super Ljava/lang/Enum;
.source "Feature.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/settings/api/feature/Feature;
.field public static final enum BRAINSTORM_V2:Lcom/bytedance/trae/settings/api/feature/Feature;
.field public static final enum CONNECTORS:Lcom/bytedance/trae/settings/api/feature/Feature;
.field public static final enum HTML_SHARE:Lcom/bytedance/trae/settings/api/feature/Feature;
.field public static final enum MOBILE_IDE_GUIDE:Lcom/bytedance/trae/settings/api/feature/Feature;
.field public static final enum PLUGIN:Lcom/bytedance/trae/settings/api/feature/Feature;
.field public static final enum TASK_LIST_PIN:Lcom/bytedance/trae/settings/api/feature/Feature;
.field public static final enum TASK_LIST_SEARCH:Lcom/bytedance/trae/settings/api/feature/Feature;
.field private final key:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.settings.api.feature.Feature[]
    .registers 3
    # ins_size=0
    const/4 v0, 7
    new-array v0, v0, [Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->CONNECTORS Lcom/bytedance/trae/settings/api/feature/Feature;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->MOBILE_IDE_GUIDE Lcom/bytedance/trae/settings/api/feature/Feature;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->BRAINSTORM_V2 Lcom/bytedance/trae/settings/api/feature/Feature;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_SEARCH Lcom/bytedance/trae/settings/api/feature/Feature;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->HTML_SHARE Lcom/bytedance/trae/settings/api/feature/Feature;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->PLUGIN Lcom/bytedance/trae/settings/api/feature/Feature;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 0
    const-string v2, "connectors"
    const-string v3, "CONNECTORS"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/api/feature/Feature;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->CONNECTORS Lcom/bytedance/trae/settings/api/feature/Feature;
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 1
    const-string v2, "mobile_ide_guide"
    const-string v3, "MOBILE_IDE_GUIDE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/api/feature/Feature;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->MOBILE_IDE_GUIDE Lcom/bytedance/trae/settings/api/feature/Feature;
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 2
    const-string v2, "brainstorm-v2"
    const-string v3, "BRAINSTORM_V2"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/api/feature/Feature;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->BRAINSTORM_V2 Lcom/bytedance/trae/settings/api/feature/Feature;
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 3
    const-string/jumbo v2, task-list-search
    const-string v3, "TASK_LIST_SEARCH"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/api/feature/Feature;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_SEARCH Lcom/bytedance/trae/settings/api/feature/Feature;
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 4
    const-string/jumbo v2, task-list-pin
    const-string v3, "TASK_LIST_PIN"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/api/feature/Feature;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 5
    const-string/jumbo v2, share_html
    const-string v3, "HTML_SHARE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/api/feature/Feature;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->HTML_SHARE Lcom/bytedance/trae/settings/api/feature/Feature;
    new-instance v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 6
    const-string/jumbo v2, plugin
    const-string v3, "PLUGIN"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/settings/api/feature/Feature;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->PLUGIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static Lcom/bytedance/trae/settings/api/feature/Feature;->$values()[Lcom/bytedance/trae/settings/api/feature/Feature;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->$VALUES [Lcom/bytedance/trae/settings/api/feature/Feature;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/settings/api/feature/Feature;->key Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.settings.api.feature.Feature
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/settings/api/feature/Feature;
    return-object v1
.end method

.method public static values()com.bytedance.trae.settings.api.feature.Feature[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->$VALUES [Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/settings/api/feature/Feature;
    return-object v0
.end method

.method public final getKey()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/settings/api/feature/Feature;->key Ljava/lang/String;
    return-object v0
.end method
