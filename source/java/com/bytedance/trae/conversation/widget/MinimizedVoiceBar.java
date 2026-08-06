package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: MinimizedVoiceBar.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u0013H\u0014J\b\u0010 \u001a\u00020\u0013H\u0014J\b\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tvTitle", "Landroid/widget/TextView;", "tvTimer", "btnMaximize", "Landroid/widget/ImageView;", "waveIcon", "Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;", "onMaximizeClick", "Lkotlin/Function0;", "", "getOnMaximizeClick", "()Lkotlin/jvm/functions/Function0;", "setOnMaximizeClick", "(Lkotlin/jvm/functions/Function0;)V", "collectJobs", "", "Lkotlinx/coroutines/Job;", "bindHolder", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", SettingsTracker.BINDING_ACTION_UNBIND, "onDetachedFromWindow", "onAttachedToWindow", "updateWaveAnimationForMicState", "updateAncestorClipPolicy", "formatTimer", "", "ms", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MinimizedVoiceBar extends ConstraintLayout {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_CLIP_PARENT_DEPTH = 4;
    private final ImageView btnMaximize;
    private List<Job> collectJobs;
    private Function0<Unit> onMaximizeClick;
    private final TextView tvTimer;
    private final TextView tvTitle;
    private final VoiceStatusWaveIconView waveIcon;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MinimizedVoiceBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MinimizedVoiceBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MinimizedVoiceBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MinimizedVoiceBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.collectJobs = new ArrayList();
        LayoutInflater.from(context).inflate(C0637R.layout.trae_view_minimized_voice_bar, (ViewGroup) this, true);
        setBackground(ContextCompat.getDrawable(context, C0637R.drawable.trae_bg_minimized_voice_bar));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        setLayoutParams(layoutParams == null ? (ViewGroup.LayoutParams) new ConstraintLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C0637R.dimen.trae_minimized_voice_bar_height)) : layoutParams);
        setMinHeight(getResources().getDimensionPixelSize(C0637R.dimen.trae_minimized_voice_bar_height));
        View findViewById = findViewById(C0637R.id.iv_chat_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        VoiceStatusWaveIconView voiceStatusWaveIconView = (VoiceStatusWaveIconView) findViewById;
        this.waveIcon = voiceStatusWaveIconView;
        View findViewById2 = findViewById(C0637R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.tvTitle = textView;
        View findViewById3 = findViewById(C0637R.id.tv_timer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.tvTimer = textView2;
        View findViewById4 = findViewById(C0637R.id.btn_maximize);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById4;
        this.btnMaximize = imageView;
        TextViewCompat.setLineHeight(textView, getResources().getDimensionPixelSize(C0591R.dimen.trae_body_body_base_strong_line_height_dp));
        TextViewCompat.setLineHeight(textView2, getResources().getDimensionPixelSize(C0591R.dimen.trae_footnote_footnote_line_height_dp));
        voiceStatusWaveIconView.setWaveColor(ContextCompat.getColor(context, C0591R.color.trae_icon_icon_default));
        voiceStatusWaveIconView.setState(VoiceStatusWaveIconView.State.Slow);
        updateWaveAnimationForMicState();
        final float dimension = getResources().getDimension(C0637R.dimen.trae_minimized_voice_bar_corner_radius);
        setElevation(getResources().getDimension(C0637R.dimen.trae_minimized_voice_bar_elevation));
        if (Build.VERSION.SDK_INT >= 28) {
            setOutlineAmbientShadowColor(ContextCompat.getColor(context, C0637R.color.trae_minimized_voice_shadow_ambient));
            setOutlineSpotShadowColor(ContextCompat.getColor(context, C0637R.color.trae_minimized_voice_shadow_spot));
        }
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.trae.conversation.widget.MinimizedVoiceBar.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), dimension);
            }
        });
        setClipToOutline(true);
        setClipChildren(true);
        setClipToPadding(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.MinimizedVoiceBar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MinimizedVoiceBar._init_$lambda$0(MinimizedVoiceBar.this, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.MinimizedVoiceBar$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MinimizedVoiceBar._init_$lambda$1(MinimizedVoiceBar.this, view);
            }
        });
    }

    public final Function0<Unit> getOnMaximizeClick() {
        return this.onMaximizeClick;
    }

    public final void setOnMaximizeClick(Function0<Unit> function0) {
        this.onMaximizeClick = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MinimizedVoiceBar minimizedVoiceBar, View view) {
        Function0<Unit> function0 = minimizedVoiceBar.onMaximizeClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(MinimizedVoiceBar minimizedVoiceBar, View view) {
        Function0<Unit> function0 = minimizedVoiceBar.onMaximizeClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void bindHolder(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        unbind();
        updateAncestorClipPolicy();
        updateWaveAnimationForMicState();
        this.collectJobs.add(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new MinimizedVoiceBar$bindHolder$1(this, null), 3, (Object) null));
        this.collectJobs.add(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new MinimizedVoiceBar$bindHolder$2(this, null), 3, (Object) null));
    }

    public final void unbind() {
        Iterator<T> it = this.collectJobs.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        this.collectJobs.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.waveIcon.stopAnimating();
        unbind();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAncestorClipPolicy();
        updateWaveAnimationForMicState();
    }

    private final void updateWaveAnimationForMicState() {
        if (BrainstormSessionHolder.INSTANCE.isMicMuted()) {
            this.waveIcon.stopAnimating();
        } else {
            this.waveIcon.startAnimating();
        }
    }

    private final void updateAncestorClipPolicy() {
        ViewParent parent = getParent();
        for (int i = 0; (parent instanceof ViewGroup) && i < 4; i++) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            parent = viewGroup.getParent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatTimer(long ms) {
        int i = (int) (ms / 1000);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* compiled from: MinimizedVoiceBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$Companion;", "", "<init>", "()V", "MAX_CLIP_PARENT_DEPTH", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
