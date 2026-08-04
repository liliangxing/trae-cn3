# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;
.super Ljava/lang/Object;
.source "IDEProjectNameUtil.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;


.method public static synthetic $r8$lambda$1hFVGAfSNIRIvguZSSr_LPuAfYg(android.content.Context  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->getProjectName$lambda$1(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$732qXrjYUzWrckffxfyp12U1kGo(android.content.Context  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->getProjectName$lambda$0(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->INSTANCE Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final getProjectName$lambda$0(android.content.Context  java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    const-string v0, "folderName"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_ide_project_name_workspace I
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/Object;
    const/4 v2, 0
    aput-object v4, v1, v2
    invoke-virtual v3, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private static final getProjectName$lambda$1(android.content.Context  java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    const-string v0, "folderName"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_ide_project_name_unsaved_workspace I
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/Object;
    const/4 v2, 0
    aput-object v4, v1, v2
    invoke-virtual v3, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method public final getProjectName(android.content.Context  java.lang.String  java.lang.String)java.lang.String
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "folderPath"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, workspaceType
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil$$ExternalSyntheticLambda0;-><init>(Landroid/content/Context;)V
    new-instance v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil$$ExternalSyntheticLambda1;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil$$ExternalSyntheticLambda1;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v4, v5, v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->getProjectName$conversation_mainlandRelease(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final getProjectName$conversation_mainlandRelease(java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)java.lang.String
    .registers 12
    # ins_size=5
    const-string v0, "folderPath"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, workspaceType
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "formatMultiRoot"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "formatUnsavedMultiRoot"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    new-array v1, v0, [C
    fill-array-data v1, +0000088h
    invoke-static v8, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v8
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    new-array v2, v0, [C
    fill-array-data v2, +0000082h
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, -015h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    if-nez v8, +004h
    const-string v8, ""
    invoke-virtual v9, Ljava/lang/String;->hashCode()I
    move-result v0
    const v1, -1731779975
    if-eq v0, v1, +02eh
    const v1, -1560422023
    if-eq v0, v1, +018h
    const v11, 1249558568
    if-eq v0, v11, +003h
    goto +29h
    const-string v11, "multi_root"
    invoke-virtual v9, v11, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +20h
    invoke-interface v10, v8, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    goto +19h
    const-string/jumbo v10, unsaved_multi_root
    invoke-virtual v9, v10, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    goto +fh
    invoke-interface v11, v8, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    goto +8h
    const-string/jumbo v10, single_root
    invoke-virtual v9, v10, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v9
    return-object v8
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
.end method
