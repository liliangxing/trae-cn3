# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;
.super Ljava/lang/Object;
.source "ApmImpl.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getEnableOptApmLooper(com.bytedance.trae.apm.impl.ApmImpl$Companion)boolean
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;->getEnableOptApmLooper()Z
    move-result v0
    return v0
.end method

.method private final getEnableOptApmLooper()boolean
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/apm/impl/ApmImpl;->access$getEnableOptApmLooper$delegate$cp()Lkotlin/Lazy;
    move-result-object v0
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
.end method
