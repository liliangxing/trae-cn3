# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;
.super Ljava/lang/Object;
.source "FeatureCapabilityScopeResolver.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;
    invoke-direct v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;->INSTANCE Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final resolve(boolean  java.lang.String)com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope
    .registers 3
    # ins_size=3
    if-nez v1, +005h
    sget-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOC Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    return-object v1
    const-string v1, "bytecloud"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->SSO Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    goto +eh
    const-string v1, "enterprise"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOB Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOC Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    return-object v1
.end method
