# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$hide$2$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "VoiceRecordingOverlay.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;


.method constructor <init>(com.bytedance.trae.conversation.widget.VoiceRecordingOverlay)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$hide$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    invoke-direct v0, Landroid/animation/AnimatorListenerAdapter;-><init>()V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$hide$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    const/16 v0, 8
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$hide$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    invoke-static v2, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->access$getAudioVisualizer$p(Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;)Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;->stopAnimation()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$hide$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->getBlurCircle()Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    move-result-object v2
    const/high16 v0, 1065353216
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->setCircleScale(F)V
    return-void 
.end method
