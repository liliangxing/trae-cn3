# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
.super Ljava/lang/Enum;
.source "PhoneOneKeyPlatform.java"

.field private static final synthetic $VALUES:[Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
.field public static final enum MOBILE:Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
.field public static final enum TELECOM:Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
.field public static final enum UNICOM:Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
.field public static final enum UNKNOWN:Lcom/bytedance/trae/login/PhoneOneKeyPlatform;


.method private static synthetic $values()com.bytedance.trae.login.PhoneOneKeyPlatform[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->MOBILE Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->TELECOM Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->UNICOM Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->UNKNOWN Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    const-string v1, "MOBILE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->MOBILE Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    new-instance v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    const-string v1, "TELECOM"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->TELECOM Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    new-instance v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    const-string v1, "UNICOM"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->UNICOM Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    new-instance v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    const-string v1, "UNKNOWN"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->UNKNOWN Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    invoke-static Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->$values()[Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->$VALUES [Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.login.PhoneOneKeyPlatform
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    return-object v1
.end method

.method public static values()com.bytedance.trae.login.PhoneOneKeyPlatform[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->$VALUES [Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    invoke-virtual v0, [Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/login/PhoneOneKeyPlatform;
    return-object v0
.end method
