# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
.super Ljava/lang/Object;
.source "IFeatureCapabilityService.kt"


.method public abstract getEnabledFeatures()java.util.Set
    # abstract or native
.end method

.method public abstract isEnabled(com.bytedance.trae.settings.api.feature.Feature)boolean
    # abstract or native
.end method

.method public abstract isToBUser()boolean
    # abstract or native
.end method

.method public abstract refresh()void
    # abstract or native
.end method

.method public abstract setDebugOverride(com.bytedance.trae.settings.api.feature.Feature  java.lang.Boolean)void
    # abstract or native
.end method
