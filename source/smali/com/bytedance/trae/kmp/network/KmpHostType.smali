# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/kmp/network/KmpHostType;
.super Ljava/lang/Enum;
.source "KmpHostResolver.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Ai:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Community:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Docs:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Imagex:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Login:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Marketplace:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Mssdk:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Notification:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Online:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Passport:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum PluginWeb:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Praise:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Remote:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Settings:Lcom/bytedance/trae/kmp/network/KmpHostType;
.field public static final enum Website:Lcom/bytedance/trae/kmp/network/KmpHostType;


.method private static final synthetic $values()com.bytedance.trae.kmp.network.KmpHostType[]
    .registers 3
    # ins_size=0
    const/16 v0, 15
    new-array v0, v0, [Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Online Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Remote Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Imagex Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Mssdk Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Passport Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Settings Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Praise Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Notification Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Marketplace Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Website Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Docs Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/16 v1, 13
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Community Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    const/16 v1, 14
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->PluginWeb Lcom/bytedance/trae/kmp/network/KmpHostType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Online"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Online Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Login"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Ai"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Remote"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Remote Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Imagex"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Imagex Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Mssdk"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Mssdk Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Passport"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Passport Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Settings"
    const/4 v2, 7
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Settings Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Praise"
    const/16 v2, 8
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Praise Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Notification"
    const/16 v2, 9
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Notification Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Marketplace"
    const/16 v2, 10
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Marketplace Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Website"
    const/16 v2, 11
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Website Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Docs"
    const/16 v2, 12
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Docs Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "Community"
    const/16 v2, 13
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Community Lcom/bytedance/trae/kmp/network/KmpHostType;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v1, "PluginWeb"
    const/16 v2, 14
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->PluginWeb Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-static Lcom/bytedance/trae/kmp/network/KmpHostType;->$values()[Lcom/bytedance/trae/kmp/network/KmpHostType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->$VALUES [Lcom/bytedance/trae/kmp/network/KmpHostType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.kmp.network.KmpHostType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/network/KmpHostType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.kmp.network.KmpHostType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->$VALUES [Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/kmp/network/KmpHostType;
    return-object v0
.end method
