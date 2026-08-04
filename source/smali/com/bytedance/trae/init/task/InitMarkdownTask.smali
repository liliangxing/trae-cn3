# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitMarkdownTask;
.super Ljava/lang/Object;
.source "InitMarkdownTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private final scene:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitMarkdownTask;->scene Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$isBlockedLink(com.bytedance.trae.init.task.InitMarkdownTask  java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/InitMarkdownTask;->isBlockedLink(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$openLink(com.bytedance.trae.init.task.InitMarkdownTask  android.view.View  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/init/task/InitMarkdownTask;->openLink(Landroid/view/View; Ljava/lang/String;)V
    return-void 
.end method

.method private final isBlockedLink(java.lang.String)boolean
    .registers 9
    # ins_size=2
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v8, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "http://"
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 0
    invoke-static v0, v2, v3, v4, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    const/4 v6, 1
    if-nez v2, +00bh
    const-string v2, "https://"
    invoke-static v0, v2, v3, v4, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return v6
    invoke-static v8, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v8
    invoke-virtual v8, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +030h
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v8, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v8, +003h
    goto +23h
    const-string v0, "127.0.0.1"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01ah
    const-string v0, "localhost"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +012h
    const-string v0, "0.0.0.0"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ah
    const-string v0, "::1"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +003h
    move v3, v6
    return v3
    return v6
    :try_start_0x21
.end method

.method private final openLink(android.view.View  java.lang.String)void
    .registers 5
    # ins_size=3
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +018h
    invoke-direct v2, v4, Lcom/bytedance/trae/init/task/InitMarkdownTask;->isBlockedLink(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    goto +10h
    sget-object v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->Companion Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v3
    const-string v1, "getContext(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 1
    invoke-virtual v0, v3, v4, v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Z)V
    return-void 
    :try_start_0x10
.end method

.method public checkFirstStartAsyncTaskInit(java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->checkFirstStartAsyncTaskInit(Lcom/bytedance/trae/init/task/base/IInitReportTask; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method public getFirstStyle()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->getFirstStyle(Lcom/bytedance/trae/init/task/base/IInitReportTask;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitMarkdownTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    sget-object v1, Lcom/larus/business/markdown/api/MarkdownService;->Companion Lcom/larus/business/markdown/api/MarkdownService$Companion;
    invoke-virtual v1, Lcom/larus/business/markdown/api/MarkdownService$Companion;->getService()Lcom/larus/business/markdown/api/MarkdownService;
    move-result-object v1
    if-eqz v1, +01dh
    new-instance v2, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$1;
    invoke-direct v2, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$1;-><init>()V
    check-cast v2, Lcom/larus/business/markdown/api/depend/IMarkdownConfig;
    invoke-interface v1, v0, v2, Lcom/larus/business/markdown/api/MarkdownService;->init(Landroid/app/Application; Lcom/larus/business/markdown/api/depend/IMarkdownConfig;)V
    sget-object v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;->INSTANCE Lcom/bytedance/trae/init/markdown/CMarkInjectParser;
    check-cast v0, Lio/noties/markwon/inject/IInjectParser;
    invoke-interface v1, v0, Lcom/larus/business/markdown/api/MarkdownService;->registerInjectParser(Lio/noties/markwon/inject/IInjectParser;)V
    new-instance v0, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$2;
    invoke-direct v0, v3, Lcom/bytedance/trae/init/task/InitMarkdownTask$runInternal$1$2;-><init>(Lcom/bytedance/trae/init/task/InitMarkdownTask;)V
    check-cast v0, Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;
    invoke-interface v1, v0, Lcom/larus/business/markdown/api/MarkdownService;->registerLinkResolver(Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;)V
    return-void 
.end method
