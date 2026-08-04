# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults$WhenMappings;
.super Ljava/lang/Object;
.source "FeatureCapabilityDefaults.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->values()[Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOC Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    invoke-virtual v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->SSO Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    invoke-virtual v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->TOB Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    invoke-virtual v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
.end method
