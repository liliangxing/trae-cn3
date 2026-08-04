# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/IResizeStrategyKt;
.super Ljava/lang/Object;
.source "IResizeStrategy.kt"

.field private static final strategies:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/image/fresco/IResizeStrategy;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;->INSTANCE Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;->INSTANCE Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;
    aput-object v2, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/image/fresco/IResizeStrategyKt;->strategies Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$log(java.lang.String  android.net.Uri  int  int  int  int)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/image/fresco/IResizeStrategyKt;->log(Ljava/lang/String; Landroid/net/Uri; I I I I)V
    return-void 
.end method

.method public static final getStrategies()java.util.List
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/image/fresco/IResizeStrategyKt;->strategies Ljava/util/List;
    return-object v0
.end method

.method private static final log(java.lang.String  android.net.Uri  int  int  int  int)void
    .registers 9
    # ins_size=6
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, use strategy for 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, ", img="
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v5, 120
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", view="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
