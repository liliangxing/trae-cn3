# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final enum Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
.super Ljava/lang/Enum;
.source "DeleteAccountFragment.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
.field public static final enum CONFIRM:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
.field public static final enum SUBMITTED:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
.field public static final enum VERIFY:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;


.method private static final synthetic $values()com.bytedance.trae.home.solo.setting.DeleteAccountFragment$Step[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->VERIFY Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->CONFIRM Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->SUBMITTED Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    const-string v1, "VERIFY"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->VERIFY Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    const-string v1, "CONFIRM"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->CONFIRM Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    const-string v1, "SUBMITTED"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->SUBMITTED Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-static Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->$values()[Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->$VALUES [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.setting.DeleteAccountFragment$Step
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.setting.DeleteAccountFragment$Step[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->$VALUES [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    return-object v0
.end method
