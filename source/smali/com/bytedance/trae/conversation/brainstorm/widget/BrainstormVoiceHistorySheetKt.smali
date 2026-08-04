# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheetKt;
.super Ljava/lang/Object;
.source "BrainstormVoiceHistorySheet.kt"

.field private static final VOICE_HISTORY_REMOTE_RESOURCE_CACHE_DIR:Ljava/lang/String;
.field private static final VOICE_HISTORY_REMOTE_RESOURCE_PREFIX:Ljava/lang/String;


.method public static final synthetic access$normalizeRemoteResourceId(java.lang.String)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheetKt;->normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final normalizeRemoteResourceId(java.lang.String)java.lang.String
    .registers 3
    # ins_size=1
    const/4 v0, 0
    if-eqz v2, +00dh
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    if-nez v2, +004h
    const-string v2, ""
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v1, trae-res://remote_resource/
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v2, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v2
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    move-object v0, v2
    return-object v0
.end method
