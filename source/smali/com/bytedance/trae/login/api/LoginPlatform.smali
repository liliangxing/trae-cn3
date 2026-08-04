# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/login/api/LoginPlatform;
.super Ljava/lang/Enum;
.source "LoginPlatform.java"

.field private static final synthetic $VALUES:[Lcom/bytedance/trae/login/api/LoginPlatform;
.field public static final enum BYTECLOUD:Lcom/bytedance/trae/login/api/LoginPlatform;
.field public static final enum DOUYIN:Lcom/bytedance/trae/login/api/LoginPlatform;
.field public static final enum EMAIL:Lcom/bytedance/trae/login/api/LoginPlatform;
.field public static final enum ENTERPRISE:Lcom/bytedance/trae/login/api/LoginPlatform;
.field public static final enum GITHUB:Lcom/bytedance/trae/login/api/LoginPlatform;
.field public static final enum GOOGLE:Lcom/bytedance/trae/login/api/LoginPlatform;
.field public static final enum PHONE:Lcom/bytedance/trae/login/api/LoginPlatform;


.method private static synthetic $values()com.bytedance.trae.login.api.LoginPlatform[]
    .registers 3
    # ins_size=0
    const/4 v0, 7
    new-array v0, v0, [Lcom/bytedance/trae/login/api/LoginPlatform;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->EMAIL Lcom/bytedance/trae/login/api/LoginPlatform;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->GOOGLE Lcom/bytedance/trae/login/api/LoginPlatform;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->GITHUB Lcom/bytedance/trae/login/api/LoginPlatform;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->BYTECLOUD Lcom/bytedance/trae/login/api/LoginPlatform;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->ENTERPRISE Lcom/bytedance/trae/login/api/LoginPlatform;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v1, "PHONE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v1, "EMAIL"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->EMAIL Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v1, "GOOGLE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->GOOGLE Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v1, "GITHUB"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->GITHUB Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v1, "BYTECLOUD"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->BYTECLOUD Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v1, "ENTERPRISE"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->ENTERPRISE Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    const-string v1, "DOUYIN"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/api/LoginPlatform;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-static Lcom/bytedance/trae/login/api/LoginPlatform;->$values()[Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->$VALUES [Lcom/bytedance/trae/login/api/LoginPlatform;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.login.api.LoginPlatform
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/LoginPlatform;
    return-object v1
.end method

.method public static values()com.bytedance.trae.login.api.LoginPlatform[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->$VALUES [Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-virtual v0, [Lcom/bytedance/trae/login/api/LoginPlatform;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/login/api/LoginPlatform;
    return-object v0
.end method
