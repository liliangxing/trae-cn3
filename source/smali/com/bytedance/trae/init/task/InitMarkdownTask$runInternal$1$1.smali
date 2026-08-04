# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$1;
.super Ljava/lang/Object;
.source "InitMarkdownTask.kt"

.implements Lcom/larus/business/markdown/api/depend/IMarkdownConfig;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getMarkdownSettings()com.larus.business.markdown.api.depend.IMarkdownSettings
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method
