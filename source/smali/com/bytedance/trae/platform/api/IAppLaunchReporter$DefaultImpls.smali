# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/api/IAppLaunchReporter$DefaultImpls;
.super Ljava/lang/Object;
.source "IAppLaunchReporter.kt"


.method public static synthetic reportEvent$default(com.bytedance.trae.platform.api.IAppLaunchReporter  java.lang.String  java.util.Map  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/platform/api/IAppLaunchReporter;->reportEvent(Ljava/lang/String; Ljava/util/Map;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: reportEvent"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic reportSenseFail$default(com.bytedance.trae.platform.api.IAppLaunchReporter  java.util.Map  int  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    if-nez v5, +016h
    and-int/lit8 v5, v4, 1
    if-eqz v5, +003h
    const/4 v1, 0
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, -1
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const-string v3, ""
    invoke-interface v0, v1, v2, v3, Lcom/bytedance/trae/platform/api/IAppLaunchReporter;->reportSenseFail(Ljava/util/Map; I Ljava/lang/String;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: reportSenseFail"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic reportSenseStart$default(com.bytedance.trae.platform.api.IAppLaunchReporter  java.util.Map  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    if-nez v3, +00bh
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-interface v0, v1, Lcom/bytedance/trae/platform/api/IAppLaunchReporter;->reportSenseStart(Ljava/util/Map;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: reportSenseStart"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic reportSenseSuccess$default(com.bytedance.trae.platform.api.IAppLaunchReporter  java.util.Map  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    if-nez v3, +00bh
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-interface v0, v1, Lcom/bytedance/trae/platform/api/IAppLaunchReporter;->reportSenseSuccess(Ljava/util/Map;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: reportSenseSuccess"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic reportStepFail$default(com.bytedance.trae.platform.api.IAppLaunchReporter  java.lang.String  java.util.Map  int  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    if-nez v6, +016h
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    const/4 v2, 0
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, -1
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    const-string v4, ""
    invoke-interface v0, v1, v2, v3, v4, Lcom/bytedance/trae/platform/api/IAppLaunchReporter;->reportStepFail(Ljava/lang/String; Ljava/util/Map; I Ljava/lang/String;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: reportStepFail"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic reportStepStart$default(com.bytedance.trae.platform.api.IAppLaunchReporter  java.lang.String  java.util.Map  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/platform/api/IAppLaunchReporter;->reportStepStart(Ljava/lang/String; Ljava/util/Map;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: reportStepStart"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic reportStepSuccess$default(com.bytedance.trae.platform.api.IAppLaunchReporter  java.lang.String  java.util.Map  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/platform/api/IAppLaunchReporter;->reportStepSuccess(Ljava/lang/String; Ljava/util/Map;)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: reportStepSuccess"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
