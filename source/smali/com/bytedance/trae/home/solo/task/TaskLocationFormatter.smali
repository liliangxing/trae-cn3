# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;
.super Ljava/lang/Object;
.source "TaskLocationFormatter.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final lastPathComponent(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    move-object v0, v13
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const-string v3, ""
    if-eqz v0, +003h
    return-object v3
    const-string v0, ".git"
    const/4 v4, 0
    const/4 v5, 2
    invoke-static v13, v0, v1, v5, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    const/4 v0, 4
    invoke-static v13, v0, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v13
    new-array v0, v5, [C
    fill-array-data v0, +000004bh
    invoke-static v13, v0, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v13
    move-object v6, v13
    check-cast v6, Ljava/lang/CharSequence;
    new-array v7, v5, [C
    fill-array-data v7, +0000045h
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 6
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v13
    check-cast v13, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, -014h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/lang/String;
    if-nez v13, +003h
    goto +2h
    move-object v3, v13
    return-object v3
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
.end method

.method public final formatIdeLocation(java.lang.String  java.lang.String  java.lang.String)java.lang.String
    .registers 8
    # ins_size=4
    const/4 v0, 1
    if-eqz v5, +012h
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v0
    if-eqz v1, +003h
    goto +2h
    const/4 v5, 0
    if-nez v5, +003h
    goto +2h
    move-object v7, v5
    invoke-direct v4, v7, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->lastPathComponent(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-eqz v6, +05bh
    invoke-virtual v6, Ljava/lang/String;->hashCode()I
    move-result v7
    const v1, -1731779975
    if-eq v7, v1, +04bh
    const v1, -1560422023
    const-string v2, "getString(...)"
    const/4 v3, 0
    if-eq v7, v1, +025h
    const v1, 1249558568
    if-eq v7, v1, +003h
    goto +43h
    const-string v7, "multi_root"
    invoke-virtual v6, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +3ah
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_ide_project_name_workspace I
    new-array v0, v0, [Ljava/lang/Object;
    aput-object v5, v0, v3
    invoke-virtual v6, v7, v0, Landroid/app/Application;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +26h
    const-string/jumbo v7, unsaved_multi_root
    invoke-virtual v6, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +1ch
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_ide_project_name_unsaved_workspace I
    new-array v0, v0, [Ljava/lang/Object;
    aput-object v5, v0, v3
    invoke-virtual v6, v7, v0, Landroid/app/Application;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +8h
    const-string/jumbo v7, single_root
    invoke-virtual v6, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    return-object v5
.end method
