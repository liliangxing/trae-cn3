# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/quota/SdkAppStartServiceImpl;
.super Ljava/lang/Object;
.source "SdkAppStartServiceImpl.kt"

.implements Lcom/bytedance/trae/platform/api/ISdkAppStart;

.field public static final INSTANCE:Lcom/bytedance/trae/network/quota/SdkAppStartServiceImpl;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/quota/SdkAppStartServiceImpl;
    invoke-direct v0, Lcom/bytedance/trae/network/quota/SdkAppStartServiceImpl;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/quota/SdkAppStartServiceImpl;->INSTANCE Lcom/bytedance/trae/network/quota/SdkAppStartServiceImpl;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getLastStartState()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->INSTANCE Lcom/bytedance/trae/network/quota/AppStartManager;
    invoke-virtual v0, Lcom/bytedance/trae/network/quota/AppStartManager;->getLastStartState()Lcom/bytedance/trae/network/quota/AppStartState;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/quota/AppStartState;->getValue()I
    move-result v0
    return v0
.end method

.method public isColdLaunch()boolean
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/platform/api/ISdkAppStart$DefaultImpls;->isColdLaunch(Lcom/bytedance/trae/platform/api/ISdkAppStart;)Z
    move-result v0
    return v0
.end method
