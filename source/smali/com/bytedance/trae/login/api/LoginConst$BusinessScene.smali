# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/LoginConst$BusinessScene;
.super Ljava/lang/Object;
.source "LoginConst.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/api/LoginConst$BusinessScene;
.field public static final LOGOUT_BY_SESSION_EXPIRED:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/api/LoginConst$BusinessScene;
    invoke-direct v0, Lcom/bytedance/trae/login/api/LoginConst$BusinessScene;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/api/LoginConst$BusinessScene;->INSTANCE Lcom/bytedance/trae/login/api/LoginConst$BusinessScene;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
