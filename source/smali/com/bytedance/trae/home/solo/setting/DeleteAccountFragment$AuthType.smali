# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final enum Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
.super Ljava/lang/Enum;
.source "DeleteAccountFragment.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
.field public static final enum EMAIL_CODE:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
.field public static final enum GITHUB:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
.field public static final enum GOOGLE:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
.field public static final enum SMS_CODE:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;


.method private static final synthetic $values()com.bytedance.trae.home.solo.setting.DeleteAccountFragment$AuthType[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->EMAIL_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->SMS_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GOOGLE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GITHUB Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    const-string v1, "EMAIL_CODE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->EMAIL_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    const-string v1, "SMS_CODE"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->SMS_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    const-string v1, "GOOGLE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GOOGLE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    const-string v1, "GITHUB"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GITHUB Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-static Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->$values()[Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->$VALUES [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.home.solo.setting.DeleteAccountFragment$AuthType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.home.solo.setting.DeleteAccountFragment$AuthType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->$VALUES [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    return-object v0
.end method
