package com.bytedance.trae.conversation.brainstorm.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.BrainstormActivity;
import com.bytedance.trae.conversation.brainstorm.BrainstormViewModel;
import com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger;
import com.bytedance.trae.conversation.brainstorm.health.VoiceExceptionGuard;
import com.bytedance.trae.conversation.brainstorm.health.VoicePrompt;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar;
import com.bytedance.trae.conversation.brainstorm.widget.SphereController;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceWaveformView;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntroFragment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/fragment/IntroFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;", "introWaveform", "Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;", "sphereController", "Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTopBar", "setupWindowInsets", "setupTitle", "setupStartButton", "setupSphereWebView", "onDestroyView", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IntroFragment extends Fragment {
    private VoiceWaveformView introWaveform;
    private SphereController sphereController;
    private BrainstormViewModel viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_fragment_brainstorm_intro, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(BrainstormViewModel.class);
        setupTopBar(view);
        setupWindowInsets(view);
        setupTitle(view);
        setupStartButton(view);
        setupSphereWebView(view);
        VoiceExceptionGuard.INSTANCE.checkAndToast((ViewGroup) view, VoiceCheckTrigger.INTRO_ENTERED);
    }

    private final void setupTopBar(View view) {
        BrainstormTopBar brainstormTopBar = (BrainstormTopBar) view.findViewById(C0637R.id.top_bar);
        brainstormTopBar.setMode(BrainstormTopBar.TopBarMode.INTRO);
        brainstormTopBar.setOnBackClick(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit unit;
                unit = IntroFragment.setupTopBar$lambda$0(IntroFragment.this);
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTopBar$lambda$0(IntroFragment introFragment) {
        introFragment.requireActivity().finish();
        return Unit.INSTANCE;
    }

    private final void setupWindowInsets(View view) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment$$ExternalSyntheticLambda2
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat windowInsetsCompat2;
                windowInsetsCompat2 = IntroFragment.setupWindowInsets$lambda$1(view2, windowInsetsCompat);
                return windowInsetsCompat2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupWindowInsets$lambda$1(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), insets.top, view.getPaddingRight(), insets.bottom);
        return windowInsetsCompat;
    }

    private final void setupTitle(View view) {
        TextView textView = (TextView) view.findViewById(C0637R.id.tv_title);
        String string = getString(C0637R.string.trae_brainstorm_intro_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpannableString spannableString = new SpannableString(Html.fromHtml(string, 63));
        Typeface createFromAsset = Typeface.createFromAsset(requireContext().getAssets(), "fonts/feature_deck_regular_italic.ttf");
        Iterator it = ArrayIteratorKt.iterator((StyleSpan[]) spannableString.getSpans(0, spannableString.length(), StyleSpan.class));
        while (it.hasNext()) {
            StyleSpan styleSpan = (StyleSpan) it.next();
            if (styleSpan.getStyle() == 2) {
                int spanStart = spannableString.getSpanStart(styleSpan);
                int spanEnd = spannableString.getSpanEnd(styleSpan);
                int spanFlags = spannableString.getSpanFlags(styleSpan);
                spannableString.removeSpan(styleSpan);
                Intrinsics.checkNotNull(createFromAsset);
                spannableString.setSpan(new CustomTypefaceSpan(createFromAsset), spanStart, spanEnd, spanFlags);
            }
        }
        textView.setText(spannableString);
    }

    private final void setupStartButton(final View view) {
        view.findViewById(C0637R.id.btn_start).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IntroFragment.setupStartButton$lambda$2(view, this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupStartButton$lambda$2(View view, IntroFragment introFragment, View view2) {
        BrainstormViewModel brainstormViewModel;
        BrainstormViewModel brainstormViewModel2;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        VoicePrompt.Health checkAndToast = VoiceExceptionGuard.INSTANCE.checkAndToast((ViewGroup) view, VoiceCheckTrigger.INTRO_START_CLICK);
        BrainstormViewModel brainstormViewModel3 = null;
        if (checkAndToast == null) {
            BrainstormViewModel brainstormViewModel4 = introFragment.viewModel;
            if (brainstormViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                brainstormViewModel3 = brainstormViewModel4;
            }
            brainstormViewModel3.startBrainstorm();
            return;
        }
        if (Intrinsics.areEqual(checkAndToast, VoicePrompt.Health.MicPermissionDenied.INSTANCE)) {
            BrainstormViewModel brainstormViewModel5 = introFragment.viewModel;
            if (brainstormViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel2 = null;
            } else {
                brainstormViewModel2 = brainstormViewModel5;
            }
            BrainstormViewModel.recordVoiceAttemptSignal$default(brainstormViewModel2, VoiceDiscussionAttemptSignal.PERMISSION_DENIED, null, 0, 6, null);
            FragmentActivity requireActivity = introFragment.requireActivity();
            BrainstormActivity brainstormActivity = requireActivity instanceof BrainstormActivity ? (BrainstormActivity) requireActivity : null;
            if (brainstormActivity != null) {
                brainstormActivity.requestVoicePermissions();
                return;
            }
            return;
        }
        BrainstormViewModel brainstormViewModel6 = introFragment.viewModel;
        if (brainstormViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        } else {
            brainstormViewModel = brainstormViewModel6;
        }
        VoiceDiscussionAttemptSignal voiceDiscussionAttemptSignal = VoiceDiscussionAttemptSignal.HEALTH_CHECK_BLOCKED;
        String simpleName = checkAndToast.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        BrainstormViewModel.recordVoiceAttemptSignal$default(brainstormViewModel, voiceDiscussionAttemptSignal, simpleName, 0, 4, null);
    }

    private final void setupSphereWebView(View view) {
        View findViewById = view.findViewById(C0637R.id.webview_sphere);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        SphereController sphereController = new SphereController((WebView) findViewById);
        sphereController.init();
        SphereController.intro$default(sphereController, 0, 1, null);
        this.sphereController = sphereController;
    }

    public void onDestroyView() {
        super.onDestroyView();
        VoiceWaveformView voiceWaveformView = this.introWaveform;
        if (voiceWaveformView != null) {
            voiceWaveformView.stopAnimating();
        }
        this.introWaveform = null;
        SphereController sphereController = this.sphereController;
        if (sphereController != null) {
            sphereController.destroy();
        }
        this.sphereController = null;
    }
}
