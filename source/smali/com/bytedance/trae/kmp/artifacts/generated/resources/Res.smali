# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res;
.super Ljava/lang/Object;
.source "Res.androidMain.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getUri(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string/jumbo v0, path
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lorg/jetbrains/compose/resources/ResourceReaderKt;->getResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final readBytes(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-static v1, v2, Lorg/jetbrains/compose/resources/ResourceReaderKt;->readResourceBytes(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
