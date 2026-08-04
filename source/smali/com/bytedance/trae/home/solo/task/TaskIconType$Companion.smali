# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;
.super Ljava/lang/Object;
.source "TaskModel.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;-><init>()V
    return-void 
.end method

.method public final fromString(java.lang.String)com.bytedance.trae.home.solo.task.TaskIconType
    .registers 3
    # ins_size=2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CHAT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    return-object v2
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +00000b7h
    goto/16 +0b1h
    const-string/jumbo v0, website
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +05ch
    goto/16 +0a6h
    const-string v0, "document"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +06ah
    goto/16 +09ch
    const-string v0, "personal"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +092h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->PERSONAL Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto/16 +090h
    const-string v0, "image"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +084h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->IMAGE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto/16 +082h
    const-string v0, "data"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +076h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DATA Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto/16 +074h
    const-string v0, "code"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +068h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CODE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto/16 +066h
    const-string v0, "chat"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +5ah
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CHAT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +59h
    const-string/jumbo v0, web
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4dh
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->WEBSITE Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +4ch
    const-string v0, "ppt"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +41h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->PPT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +40h
    const-string v0, "doc"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +35h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DOCUMENT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +34h
    const-string v0, "app"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +29h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->APP Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +28h
    const-string/jumbo v0, research
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +1ch
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->RESEARCH Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +1bh
    const-string v0, "business"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +10h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->BUSINESS Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +fh
    const-string v0, "design"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->DESIGN Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CHAT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    return-object v2
    sparse-switch-payload -4f963e42 -445b4040 -14ea3e65 17a21 18538 1b274 1cb54 2e9358 2eaded 2eefaa 5faa95b 1a6a2640 335cd11b 48f9e09b
.end method
