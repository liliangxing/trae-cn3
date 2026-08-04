# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/Logger;
.super Ljava/lang/Object;
.source "FormatLogBuilder.kt"

.field private final tag:Ljava/lang/String;


.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/utils/logger/Logger;->tag Ljava/lang/String;
    return-void 
.end method

.method private final getFormattedTime()java.lang.String
    .registers 8
    # ins_size=1
    new-instance v0, Ljava/util/Date;
    invoke-direct v0, Ljava/util/Date;-><init>()V
    new-instance v1, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v3
    invoke-direct v1, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    new-instance v2, Ljava/text/SimpleDateFormat;
    const-string v3, "HH:mm:ss.SSS"
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v4
    invoke-direct v2, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;
    move-result-object v3
    invoke-virtual v0, Ljava/util/Date;->getTime()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/util/TimeZone;->getOffset(J)I
    move-result v3
    int-to-float v3, v3
    sget-object v4, Ljava/util/concurrent/TimeUnit;->HOURS Ljava/util/concurrent/TimeUnit;
    const-wide/16 v5, 1
    invoke-virtual v4, v5, v6, Ljava/util/concurrent/TimeUnit;->toMillis(J)J
    move-result-wide v4
    long-to-float v4, v4
    div-float/2addr v3, v4
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, " +"
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/4 v4, 1
    new-array v5, v4, [Ljava/lang/Object;
    const/4 v6, 0
    invoke-static v3, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v3
    aput-object v3, v5, v6
    invoke-static v5, v4, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v3
    const-string v4, "%.1f"
    invoke-static v4, v3, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "format(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 32
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v2, v0, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final log(com.bytedance.trae.utils.logger.LogLevel  java.lang.String  java.lang.String  java.lang.String  int)void
    .registers 13
    # ins_size=6
    const-string v0, "level"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "file"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "function"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const-string v10, "/"
    filled-new-array v10, [Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    invoke-static v10, Lkotlin/collections/CollectionsKt;->last(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const/16 v0, 44
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v11, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v11, " ["
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const/16 v10, 93
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/utils/logger/Logger$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v8, Lcom/bytedance/trae/utils/logger/LogLevel;->ordinal()I
    move-result v8
    aget v8, v10, v8
    const/4 v10, 1
    if-eq v8, v10, +029h
    const/4 v10, 2
    if-eq v8, v10, +01eh
    const/4 v10, 3
    if-eq v8, v10, +013h
    const/4 v10, 4
    if-ne v8, v10, +00ah
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v10, v7, Lcom/bytedance/trae/utils/logger/Logger;->tag Ljava/lang/String;
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +1eh
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v10, v7, Lcom/bytedance/trae/utils/logger/Logger;->tag Ljava/lang/String;
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +10h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v10, v7, Lcom/bytedance/trae/utils/logger/Logger;->tag Ljava/lang/String;
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +8h
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v10, v7, Lcom/bytedance/trae/utils/logger/Logger;->tag Ljava/lang/String;
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
