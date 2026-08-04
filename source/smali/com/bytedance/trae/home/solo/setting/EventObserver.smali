# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EventObserver;
.super Ljava/lang/Object;
.source "SettingsViewModel.kt"

.implements Landroidx/lifecycle/Observer;

.field public static final $stable:I
.field private final onEvent:Lkotlin/jvm/functions/Function1;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "onEvent"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/EventObserver;->onEvent Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public onChanged(com.bytedance.trae.home.solo.setting.Event)void
    .registers 3
    # ins_size=2
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/Event;->getContentIfNotHandled()Ljava/lang/Object;
    move-result-object v2
    if-eqz v2, +007h
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EventObserver;->onEvent Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public bridge synthetic onChanged(java.lang.Object)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/Event;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/EventObserver;->onChanged(Lcom/bytedance/trae/home/solo/setting/Event;)V
    return-void 
.end method
