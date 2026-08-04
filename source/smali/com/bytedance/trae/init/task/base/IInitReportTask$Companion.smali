# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;
.super Ljava/lang/Object;
.source "IInitReportTask.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;
.field private static final prePrivacyWhiteList:Ljava/util/Set;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;
    invoke-direct v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;->$$INSTANCE Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;->prePrivacyWhiteList Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getPrePrivacyWhiteList()java.util.Set
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;->prePrivacyWhiteList Ljava/util/Set;
    return-object v0
.end method
