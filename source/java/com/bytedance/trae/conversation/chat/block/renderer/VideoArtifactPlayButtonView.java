package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.kmp.artifacts.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: VideoArtifactCardView.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dimen", "", "resourceId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class VideoArtifactPlayButtonView extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoArtifactPlayButtonView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ColorUtils.setAlphaComponent(ContextCompat.getColor(context, C0591R.color.trae_icon_icon_onbrand), MathKt.roundToInt(127.5f)));
        setBackground(gradientDrawable);
        setClickable(false);
        setFocusable(false);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.trae_video_preview_play);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(imageView, new FrameLayout.LayoutParams(dimen(C0591R.dimen.trae_video_artifact_card_play_icon_size), dimen(C0591R.dimen.trae_video_artifact_card_play_icon_size), 17));
    }

    private final int dimen(int resourceId) {
        return getResources().getDimensionPixelSize(resourceId);
    }
}
