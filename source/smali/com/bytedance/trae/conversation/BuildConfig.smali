# Decompiled TRAE business class
# Source DEX: classes.dex
.class public final Lcom/bytedance/trae/conversation/BuildConfig;
.super Ljava/lang/Object;
.source "BuildConfig.java"

.field public static final BUILD_TYPE:Ljava/lang/String;

.field public static final DEBUG:Z

.field public static final FLAVOR:Ljava/lang/String;

.field public static final LIBRARY_PACKAGE_NAME:Ljava/lang/String;

.field public static final GITHUB_TOKEN:Ljava/lang/String;


.method public constructor <init>()V
    .registers 1
    # ins_size=1
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static getGITHUB_TOKEN()Ljava/lang/String;
    .registers 1
    # ins_size=0
    const-string v0, "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"
    return-object v0
.end method
