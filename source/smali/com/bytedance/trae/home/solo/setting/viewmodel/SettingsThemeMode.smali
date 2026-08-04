# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
.super Ljava/lang/Enum;
.source "SettingsUiState.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;
.field public static final enum Dark:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
.field public static final enum Light:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
.field public static final enum System:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    const/4 v1, 0
    const-string v2, "light"
    const-string v3, "Light"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    const/4 v1, 1
    const-string v2, "dark"
    const-string v3, "Dark"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Dark Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    const/4 v1, 2
    const-string/jumbo v2, system
    const-string v3, "System"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->System Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->$values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->$VALUES [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Companion Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->$VALUES [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->value Ljava/lang/String;
    return-object v0
.end method
