# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final synthetic Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "KmpClickHandler.kt"

.implements Lkotlin/jvm/functions/Function0;

.field public static final INSTANCE:Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;
    invoke-direct v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;->INSTANCE Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;
    return-void 
.end method

.method constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const-class v2, Lcom/bytedance/trae/kmp/ui/KmpClickHandlerKt;
    const-string v3, "monotonicNowMillis"
    const-string v4, "monotonicNowMillis()J"
    const/4 v5, 1
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke()java.lang.Long
    .registers 3
    # ins_size=1
    invoke-static Lcom/bytedance/trae/kmp/ui/KmpClickHandlerKt;->access$monotonicNowMillis()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    return-object v0
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler$1;->invoke()Ljava/lang/Long;
    move-result-object v0
    return-object v0
.end method
