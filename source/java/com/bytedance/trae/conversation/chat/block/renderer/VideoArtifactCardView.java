package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest;
import com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: VideoArtifactCardView.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0017\u001a\u00020\nH\u0014J\b\u0010\u0018\u001a\u00020\nH\u0014J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "descriptor", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;", "openRequest", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "onOpen", "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;Lkotlin/jvm/functions/Function1;)V", "preview", "Lcom/facebook/drawee/view/SimpleDraweeView;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "getResourceUploadApi", "()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "resourceUploadApi$delegate", "Lkotlin/Lazy;", "loadJob", "Lkotlinx/coroutines/Job;", "onAttachedToWindow", "onDetachedFromWindow", "loadLastFrame", "signedUrl", "", "createHeader", "Landroid/view/View;", "createPreview", "updateAccessibility", "dimen", "", "resourceId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VideoArtifactCardView extends LinearLayout {
    private final VideoArtifactDescriptor descriptor;
    private Job loadJob;
    private final Function1<ArtifactOpenRequest, Unit> onOpen;
    private final ArtifactOpenRequest openRequest;
    private final SimpleDraweeView preview;

    /* renamed from: resourceUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy resourceUploadApi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoArtifactCardView(Context context, VideoArtifactDescriptor videoArtifactDescriptor, ArtifactOpenRequest artifactOpenRequest, Function1<? super ArtifactOpenRequest, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoArtifactDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(artifactOpenRequest, "openRequest");
        Intrinsics.checkNotNullParameter(function1, "onOpen");
        this.descriptor = videoArtifactDescriptor;
        this.openRequest = artifactOpenRequest;
        this.onOpen = function1;
        this.preview = new SimpleDraweeView(context);
        this.resourceUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView$$ExternalSyntheticLambda1
            public final Object invoke() {
                ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$1;
                resourceUploadApi_delegate$lambda$1 = VideoArtifactCardView.resourceUploadApi_delegate$lambda$1();
                return resourceUploadApi_delegate$lambda$1;
            }
        });
        setOrientation(1);
        setClipToOutline(true);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_card));
        gradientDrawable.setCornerRadius(dimen(C0591R.dimen.trae_video_artifact_card_radius));
        gradientDrawable.setStroke(dimen(C0591R.dimen.trae_video_artifact_card_border_width), ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dimen(C0591R.dimen.trae_video_artifact_card_bottom_margin);
        setLayoutParams(layoutParams);
        setClickable(true);
        setFocusable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoArtifactCardView._init_$lambda$4(VideoArtifactCardView.this, view);
            }
        });
        addView(createHeader());
        addView(createPreview());
        updateAccessibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationCopilotResourceUploadApi getResourceUploadApi() {
        return (ConversationCopilotResourceUploadApi) this.resourceUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$1() {
        return new ConversationCopilotResourceUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView$$ExternalSyntheticLambda0
            public final Object invoke() {
                String resourceUploadApi_delegate$lambda$1$lambda$0;
                resourceUploadApi_delegate$lambda$1$lambda$0 = VideoArtifactCardView.resourceUploadApi_delegate$lambda$1$lambda$0();
                return resourceUploadApi_delegate$lambda$1$lambda$0;
            }
        }, null, "video_artifact_last_frame", 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resourceUploadApi_delegate$lambda$1$lambda$0() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(VideoArtifactCardView videoArtifactCardView, View view) {
        videoArtifactCardView.onOpen.invoke(videoArtifactCardView.openRequest);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String lastFrameUri = this.descriptor.getLastFrameUri();
        if (lastFrameUri == null) {
            return;
        }
        String str = ResourceRepoManager.INSTANCE.get(lastFrameUri);
        if (str != null) {
            loadLastFrame(str);
            return;
        }
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner == null) {
            Context context = getContext();
            lifecycleOwner = context instanceof LifecycleOwner ? (LifecycleOwner) context : null;
            if (lifecycleOwner == null) {
                return;
            }
        }
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new VideoArtifactCardView$onAttachedToWindow$2(lastFrameUri, this, null), 3, (Object) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadJob = null;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadLastFrame(String signedUrl) {
        this.preview.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(signedUrl)).setOldController(this.preview.getController()).build());
    }

    private final View createHeader() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, dimen(C0591R.dimen.trae_video_artifact_card_header_height)));
        frameLayout.setPadding(dimen(C0591R.dimen.trae_video_artifact_card_header_horizontal_padding), dimen(C0591R.dimen.trae_video_artifact_card_header_vertical_padding), dimen(C0591R.dimen.trae_video_artifact_card_header_horizontal_padding), dimen(C0591R.dimen.trae_video_artifact_card_header_vertical_padding));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(C0637R.drawable.ic_artifact_video);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout2.addView(imageView, new FrameLayout.LayoutParams(dimen(C0591R.dimen.trae_video_artifact_card_file_icon_size), dimen(C0591R.dimen.trae_video_artifact_card_file_icon_size), 17));
        linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(dimen(C0591R.dimen.trae_video_artifact_card_file_icon_container_size), dimen(C0591R.dimen.trae_video_artifact_card_file_icon_container_size)));
        TextView textView = new TextView(getContext(), null, 0, C0591R.style.Trae_Text_Body_Base);
        textView.setText(this.descriptor.getTitle());
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        textView.setLetterSpacing(-0.0253f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(dimen(C0591R.dimen.trae_video_artifact_card_title_gap));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private final View createPreview() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, dimen(C0591R.dimen.trae_video_artifact_card_preview_height)));
        this.preview.setHierarchy(new GenericDraweeHierarchyBuilder(frameLayout.getResources()).setPlaceholderImage(C0591R.drawable.trae_bg_image_loading, ScalingUtils.ScaleType.CENTER_CROP).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
        frameLayout.addView((View) this.preview, new FrameLayout.LayoutParams(-1, -1));
        View view = new View(frameLayout.getContext());
        view.setBackgroundColor(ContextCompat.getColor(view.getContext(), C0591R.color.trae_border_border_neutral_l1));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, dimen(C0591R.dimen.trae_video_artifact_card_divider_height), 48));
        View view2 = new View(frameLayout.getContext());
        view2.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ContextCompat.getColor(view2.getContext(), C0637R.color.trae_video_artifact_card_gradient_start), ContextCompat.getColor(view2.getContext(), C0637R.color.trae_video_artifact_card_gradient_end)}));
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, dimen(C0591R.dimen.trae_video_artifact_card_gradient_height), 80));
        Context context = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        frameLayout.addView(new VideoArtifactPlayButtonView(context), new FrameLayout.LayoutParams(dimen(C0591R.dimen.trae_video_artifact_card_play_button_size), dimen(C0591R.dimen.trae_video_artifact_card_play_button_size), 17));
        TextView textView = new TextView(frameLayout.getContext());
        textView.setText(this.descriptor.getFormattedDuration());
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setLetterSpacing(-0.0062f);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), C0591R.color.trae_text_text_white));
        textView.setTextSize(0, textView.getResources().getDimension(C0591R.dimen.trae_footnote_footnote_font_size_sp));
        TextViewCompat.setLineHeight(textView, dimen(C0591R.dimen.trae_footnote_footnote_line_height_dp));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimen(C0591R.dimen.trae_context_menu_radius));
        gradientDrawable.setColor(ColorUtils.setAlphaComponent(ContextCompat.getColor(textView.getContext(), C0591R.color.trae_icon_icon_onbrand), MathKt.roundToInt(102.0f)));
        textView.setBackground(gradientDrawable);
        textView.setPadding(dimen(C0591R.dimen.trae_video_artifact_card_duration_horizontal_padding), 0, dimen(C0591R.dimen.trae_video_artifact_card_duration_horizontal_padding), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimen(C0591R.dimen.trae_video_artifact_card_duration_height), 8388693);
        layoutParams.setMarginEnd(dimen(C0591R.dimen.trae_video_artifact_card_duration_end_margin));
        layoutParams.bottomMargin = dimen(C0591R.dimen.trae_video_artifact_card_duration_bottom_margin);
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(textView, layoutParams);
        return frameLayout;
    }

    private final void updateAccessibility() {
        setContentDescription("Video artifact card: " + this.descriptor.getTitle() + ", " + this.descriptor.getFormattedDuration());
    }

    private final int dimen(int resourceId) {
        return getResources().getDimensionPixelSize(resourceId);
    }
}
