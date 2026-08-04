# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;
.super Ljava/lang/Object;
.source "TraeLayoutParticipantCardBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final avatarGlow:Landroid/view/View;
.field public final cardBg:Landroid/view/View;
.field public final dotsBg:Landroid/view/View;
.field public final ivAvatar:Landroid/widget/ImageView;
.field private final rootView:Landroid/view/View;
.field public final tvStatus:Landroid/widget/TextView;
.field public final waveformView:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;


.method private constructor <init>(android.view.View  android.view.View  android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView  com.bytedance.trae.conversation.brainstorm.widget.VoiceWaveformView)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->rootView Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->avatarGlow Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->cardBg Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->dotsBg Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->ivAvatar Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->tvStatus Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->waveformView Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeLayoutParticipantCardBinding
    .registers 10
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->avatar_glow I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +03bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->card_bg I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v4
    if-eqz v4, +033h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->dots_bg I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v5
    if-eqz v5, +02bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_avatar I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +020h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_status I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +015h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->waveform_view I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;
    if-eqz v8, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;
    move-object v1, v0
    move-object v2, v9
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;-><init>(Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;)V
    return-object v0
    invoke-virtual v9, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v9
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v9, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-direct v0, v9, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup)com.bytedance.trae.conversation.databinding.TraeLayoutParticipantCardBinding
    .registers 3
    # ins_size=2
    if-eqz v2, +00ch
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_participant_card I
    invoke-virtual v1, v0, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;
    move-result-object v1
    return-object v1
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "parent"
    invoke-direct v1, v2, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public getRoot()android.view.View
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutParticipantCardBinding;->rootView Landroid/view/View;
    return-object v0
.end method
