# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$BooleanRef;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Lkotlin/jvm/internal/Ref$ObjectRef;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$BooleanRef  android.content.Context  kotlin.jvm.internal.Ref$ObjectRef)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/internal/Ref$BooleanRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/internal/Ref$ObjectRef;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/internal/Ref$BooleanRef;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/share/ShareUtils$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/share/ShareUtils;->$r8$lambda$vLSTuzTarZyOcRX62X3gcqHr4wM(Lkotlin/jvm/internal/Ref$BooleanRef; Landroid/content/Context; Lkotlin/jvm/internal/Ref$ObjectRef;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
