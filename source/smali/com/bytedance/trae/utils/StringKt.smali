# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/StringKt;
.super Ljava/lang/Object;
.source "String.kt"


.method public static final analysis(java.lang.String)java.lang.String
    .registers 2
    # ins_size=1
    if-nez v1, +005h
    const-string v1, "be_null"
    return-object v1
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +004h
    const-string v1, "be_empty"
    return-object v1
.end method

.method public static final base64(java.lang.String)java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v1, v0, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v1
    const-string v0, "getBytes(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v1, v0, Landroid/util/Base64;->encodeToString([B I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v1, 0
    check-cast v1, Ljava/lang/String;
    return-object v1
    :try_start_0x5
.end method

.method public static final base64Decode(java.lang.String)java.lang.String
    .registers 3
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    const/4 v0, 0
    invoke-static v2, v0, Landroid/util/Base64;->decode(Ljava/lang/String; I)[B
    move-result-object v2
    const-string v0, "decode(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/String;
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v0, v2, v1, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v2, 0
    check-cast v2, Ljava/lang/String;
    return-object v2
    :try_start_0x5
.end method

.method public static final getCodePointCount(java.lang.String)int
    .registers 3
    # ins_size=1
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return v1
    invoke-virtual v2, Ljava/lang/String;->length()I
    move-result v0
    invoke-virtual v2, v1, v0, Ljava/lang/String;->codePointCount(I I)I
    move-result v2
    return v2
.end method

.method public static final getWordPercent(java.lang.String)float
    .registers 9
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    move v1, v0
    move v2, v1
    move v3, v2
    move v4, v3
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v5
    if-ge v1, v5, +031h
    invoke-virtual v8, v1, Ljava/lang/String;->charAt(I)C
    move-result v5
    const/16 v6, 65
    const/4 v7, 1
    if-gt v6, v5, +008h
    const/16 v6, 91
    if-ge v5, v6, +004h
    move v6, v7
    goto +2h
    move v6, v0
    if-nez v6, +01bh
    const/16 v6, 97
    if-gt v6, v5, +008h
    const/16 v6, 123
    if-ge v5, v6, +004h
    move v5, v7
    goto +2h
    move v5, v0
    if-eqz v5, +003h
    goto +ch
    if-eqz v2, +007h
    add-int/lit8 v3, v3, 1
    add-int/lit8 v4, v4, 1
    move v2, v0
    add-int/2addr v4, v7
    add-int/lit8 v1, v1, 1
    goto -30h
    add-int/lit8 v1, v1, 1
    move v2, v7
    goto -34h
    if-eqz v2, +006h
    add-int/lit8 v3, v3, 1
    add-int/lit8 v4, v4, 1
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, word = 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", total = "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getWordPercent"
    invoke-virtual v8, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    int-to-float v8, v3
    int-to-float v0, v4
    div-float/2addr v8, v0
    return v8
.end method

.method public static final isNotNullOrEmpty(java.lang.String)boolean
    .registers 3
    # ins_size=1
    const/4 v0, 0
    if-eqz v2, +011h
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v1, 1
    if-lez v2, +004h
    move v2, v1
    goto +2h
    move v2, v0
    if-eqz v2, +003h
    move v0, v1
    return v0
.end method

.method public static final runWhenNotEmpty(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "block"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-void 
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
