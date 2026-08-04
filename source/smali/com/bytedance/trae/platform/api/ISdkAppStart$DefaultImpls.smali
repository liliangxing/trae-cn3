# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/api/ISdkAppStart$DefaultImpls;
.super Ljava/lang/Object;
.source "ISdkAppStart.kt"


.method public static getLastStartState(com.bytedance.trae.platform.api.ISdkAppStart)int
    .registers 1
    # ins_size=1
    const/4 v0, -1
    return v0
.end method

.method public static isColdLaunch(com.bytedance.trae.platform.api.ISdkAppStart)boolean
    .registers 1
    # ins_size=1
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkAppStart;->getLastStartState()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method
