# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;
.super Ljava/lang/Object;
.source "TaskViewModel.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getEnOtherYearFormat(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getEnOtherYearFormat()Ljava/text/SimpleDateFormat;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getEnSameYearFormat(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getEnSameYearFormat()Ljava/text/SimpleDateFormat;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getJaOtherYearFormat(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getJaOtherYearFormat()Ljava/text/SimpleDateFormat;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getJaSameYearFormat(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getJaSameYearFormat()Ljava/text/SimpleDateFormat;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getParseDateFormats(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.util.List
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getParseDateFormats()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getTimeOnlyFormat(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getTimeOnlyFormat()Ljava/text/SimpleDateFormat;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getZhOtherYearFormat(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getZhOtherYearFormat()Ljava/text/SimpleDateFormat;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getZhSameYearFormat(com.bytedance.trae.home.solo.task.TaskViewModel$Companion)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->getZhSameYearFormat()Ljava/text/SimpleDateFormat;
    move-result-object v0
    return-object v0
.end method

.method private final getEnOtherYearFormat()java.text.SimpleDateFormat
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getEnOtherYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/text/SimpleDateFormat;
    if-nez v0, +012h
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string v1, "MMM dd, yyyy HH:mm"
    sget-object v2, Ljava/util/Locale;->ENGLISH Ljava/util/Locale;
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getEnOtherYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getEnSameYearFormat()java.text.SimpleDateFormat
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getEnSameYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/text/SimpleDateFormat;
    if-nez v0, +012h
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string v1, "MMM dd, HH:mm"
    sget-object v2, Ljava/util/Locale;->ENGLISH Ljava/util/Locale;
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getEnSameYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getJaOtherYearFormat()java.text.SimpleDateFormat
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getJaOtherYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/text/SimpleDateFormat;
    if-nez v0, +013h
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string/jumbo v1, yyyy年MM月dd日 HH:mm
    sget-object v2, Ljava/util/Locale;->JAPANESE Ljava/util/Locale;
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getJaOtherYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getJaSameYearFormat()java.text.SimpleDateFormat
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getJaSameYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/text/SimpleDateFormat;
    if-nez v0, +012h
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string v1, "MM月dd日 HH:mm"
    sget-object v2, Ljava/util/Locale;->JAPANESE Ljava/util/Locale;
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getJaSameYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getParseDateFormats()java.util.List
    .registers 5
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getParseDateFormats$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +06fh
    const/4 v0, 5
    new-array v0, v0, [Ljava/text/SimpleDateFormat;
    new-instance v1, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd'T'HH:mm:ss.SSSXXX
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v1, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const/4 v2, 0
    aput-object v1, v0, v2
    new-instance v1, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd'T'HH:mm:ssXXX
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v1, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const/4 v2, 1
    aput-object v1, v0, v2
    new-instance v1, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v1, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const/4 v2, 2
    aput-object v1, v0, v2
    new-instance v1, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd'T'HH:mm:ss'Z'
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v1, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const/4 v2, 3
    aput-object v1, v0, v2
    new-instance v1, Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, yyyy-MM-dd HH:mm:ss
    sget-object v3, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v1, v2, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const/4 v2, 4
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/text/SimpleDateFormat;
    const-string v3, "UTC"
    invoke-static v3, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V
    goto -15h
    check-cast v0, Ljava/util/List;
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getParseDateFormats$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getTimeOnlyFormat()java.text.SimpleDateFormat
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getTimeOnlyFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/text/SimpleDateFormat;
    if-nez v0, +012h
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string v1, "HH:mm"
    sget-object v2, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getTimeOnlyFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getZhOtherYearFormat()java.text.SimpleDateFormat
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getZhOtherYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/text/SimpleDateFormat;
    if-nez v0, +013h
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string/jumbo v1, yyyy年MM月dd日 HH:mm
    sget-object v2, Ljava/util/Locale;->CHINESE Ljava/util/Locale;
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getZhOtherYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getZhSameYearFormat()java.text.SimpleDateFormat
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getZhSameYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/text/SimpleDateFormat;
    if-nez v0, +012h
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string v1, "MM月dd日 HH:mm"
    sget-object v2, Ljava/util/Locale;->CHINESE Ljava/util/Locale;
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getZhSameYearFormat$cp()Ljava/lang/ThreadLocal;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V
    return-object v0
.end method
