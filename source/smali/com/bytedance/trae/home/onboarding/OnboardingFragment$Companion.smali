# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;
.super Ljava/lang/Object;
.source "OnboardingFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;-><init>()V
    return-void 
.end method

.method public final hasShown()boolean
    .registers 4
    # ins_size=1
    const-string/jumbo v0, trae_onboarding
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "onboarding_shown"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final markShown()void
    .registers 4
    # ins_size=1
    const-string/jumbo v0, trae_onboarding
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "onboarding_shown"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method
