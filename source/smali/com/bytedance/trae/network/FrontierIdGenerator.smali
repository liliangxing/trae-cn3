# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/FrontierIdGenerator;
.super Ljava/lang/Object;
.source "FrontierIdGenerator.kt"

.field public static final APP_RUNTIME_TYPE_ANDROID:Ljava/lang/String;
.field public static final APP_RUNTIME_TYPE_TRAE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/network/FrontierIdGenerator;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/FrontierIdGenerator;
    invoke-direct v0, Lcom/bytedance/trae/network/FrontierIdGenerator;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/FrontierIdGenerator;->INSTANCE Lcom/bytedance/trae/network/FrontierIdGenerator;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final generateFrontierId(java.lang.String  int  java.lang.String  int)long
    .registers 10
    # ins_size=5
    const-string/jumbo v0, userID
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "appRuntimeType"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const/16 v0, 95
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    sget-object v7, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v6, v7, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v6
    const-string v7, "getBytes(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v7, v6
    const-wide v8, -3750763034362895579
    const/4 v0, 0
    if-ge v0, v7, +012h
    aget-byte v1, v6, v0
    int-to-long v1, v1
    const-wide/16 v3, 255
    and-long/2addr v1, v3
    xor-long/2addr v8, v1
    const-wide v1, 1099511628211
    mul-long/2addr v8, v1
    add-int/lit8 v0, v0, 1
    goto -11h
    const-wide v6, 9223372036854775807
    and-long/2addr v6, v8
    return-wide v6
.end method
