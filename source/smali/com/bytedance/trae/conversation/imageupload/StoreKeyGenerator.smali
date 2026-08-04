# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;
.super Ljava/lang/Object;
.source "StoreKeyGenerator.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;
    invoke-direct v0, Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final randomString(int)java.lang.String
    .registers 6
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v5, Ljava/lang/StringBuilder;-><init>(I)V
    const/4 v1, 0
    if-ge v1, v5, +016h
    sget-object v2, Lkotlin/random/Random;->Default Lkotlin/random/Random$Default;
    const/16 v3, 36
    invoke-virtual v2, v3, Lkotlin/random/Random$Default;->nextInt(I)I
    move-result v2
    const-string v3, "abcdefghijklmnopqrstuvwxyz0123456789"
    invoke-virtual v3, v2, Ljava/lang/String;->charAt(I)C
    move-result v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    add-int/lit8 v1, v1, 1
    goto -15h
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, toString(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method

.method public final generate(java.io.File  java.lang.String  java.lang.String  com.bytedance.trae.conversation.imageupload.ImageDimension)java.lang.String
    .registers 10
    # ins_size=5
    const-string v0, "file"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "region"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    const/16 v2, 12
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;->randomString(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v6
    const-string v3, "getName(...)"
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v3, 46
    const-string v4, "png"
    invoke-static v6, v3, v4, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v6, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v3, toLowerCase(...)
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v9, +024h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "_"
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getWidth()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v4, 120
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getHeight()I
    move-result v9
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    goto +3h
    const-string v9, ""
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const/16 v3, 47
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "/image/"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    const/16 v8, 95
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method
