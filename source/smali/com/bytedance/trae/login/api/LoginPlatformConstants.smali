# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/LoginPlatformConstants;
.super Ljava/lang/Object;
.source "LoginPlatformConstants.kt"

.field public static final BYTECLOUD:Ljava/lang/String;
.field public static final ENTERPRISE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/login/api/LoginPlatformConstants;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/api/LoginPlatformConstants;
    invoke-direct v0, Lcom/bytedance/trae/login/api/LoginPlatformConstants;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginPlatformConstants;->INSTANCE Lcom/bytedance/trae/login/api/LoginPlatformConstants;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
