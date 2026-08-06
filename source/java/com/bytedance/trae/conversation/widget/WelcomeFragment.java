package com.bytedance.trae.conversation.widget;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.databinding.TraeFragmentWelcomeBinding;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WelcomeFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\rH\u0002J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u000e\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/bytedance/trae/conversation/widget/WelcomeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/conversation/databinding/TraeFragmentWelcomeBinding;", "currentMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "onModeSwipe", "Lkotlin/Function1;", "", "getOnModeSwipe", "()Lkotlin/jvm/functions/Function1;", "setOnModeSwipe", "(Lkotlin/jvm/functions/Function1;)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateGreetingText", "getUserName", "", "setMode", "mode", "onDestroyView", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WelcomeFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "WelcomeFragment";
    private TraeFragmentWelcomeBinding _binding;
    private ChatMode currentMode = ChatMode.MTC;

    /* renamed from: gestureDetector$delegate, reason: from kotlin metadata */
    private final Lazy gestureDetector = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.widget.WelcomeFragment$$ExternalSyntheticLambda1
        public final Object invoke() {
            GestureDetector gestureDetector_delegate$lambda$0;
            gestureDetector_delegate$lambda$0 = WelcomeFragment.gestureDetector_delegate$lambda$0(WelcomeFragment.this);
            return gestureDetector_delegate$lambda$0;
        }
    });
    private Function1<? super ChatMode, Unit> onModeSwipe;

    /* compiled from: WelcomeFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChatMode.values().length];
            try {
                iArr[ChatMode.CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatMode.MTC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: WelcomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/widget/WelcomeFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/conversation/widget/WelcomeFragment;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WelcomeFragment newInstance() {
            return new WelcomeFragment();
        }
    }

    private final TraeFragmentWelcomeBinding getBinding() {
        TraeFragmentWelcomeBinding traeFragmentWelcomeBinding = this._binding;
        Intrinsics.checkNotNull(traeFragmentWelcomeBinding);
        return traeFragmentWelcomeBinding;
    }

    public final Function1<ChatMode, Unit> getOnModeSwipe() {
        return this.onModeSwipe;
    }

    public final void setOnModeSwipe(Function1<? super ChatMode, Unit> function1) {
        this.onModeSwipe = function1;
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GestureDetector gestureDetector_delegate$lambda$0(final WelcomeFragment welcomeFragment) {
        final ViewConfiguration viewConfiguration = ViewConfiguration.get(welcomeFragment.requireContext());
        return new GestureDetector(welcomeFragment.requireContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.trae.conversation.widget.WelcomeFragment$gestureDetector$2$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                ChatMode chatMode;
                Intrinsics.checkNotNullParameter(e2, "e2");
                if (e1 == null) {
                    return false;
                }
                float x = e2.getX() - e1.getX();
                if (Math.abs(x) <= Math.abs(e2.getY() - e1.getY()) || Math.abs(x) < viewConfiguration.getScaledPagingTouchSlop() || Math.abs(velocityX) < viewConfiguration.getScaledMinimumFlingVelocity()) {
                    return false;
                }
                ChatMode chatMode2 = x < 0.0f ? ChatMode.CODE : ChatMode.MTC;
                chatMode = welcomeFragment.currentMode;
                if (chatMode2 == chatMode) {
                    return false;
                }
                Function1<ChatMode, Unit> onModeSwipe = welcomeFragment.getOnModeSwipe();
                if (onModeSwipe == null) {
                    return true;
                }
                onModeSwipe.invoke(chatMode2);
                return true;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TraeFragmentWelcomeBinding.inflate(inflater, container, false);
        ScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.widget.WelcomeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onViewCreated$lambda$1;
                onViewCreated$lambda$1 = WelcomeFragment.onViewCreated$lambda$1(WelcomeFragment.this, view2, motionEvent);
                return onViewCreated$lambda$1;
            }
        });
        updateGreetingText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(WelcomeFragment welcomeFragment, View view, MotionEvent motionEvent) {
        welcomeFragment.getGestureDetector().onTouchEvent(motionEvent);
        return false;
    }

    private final void updateGreetingText() {
        int i;
        String userName = getUserName();
        String str = userName;
        if (str == null || StringsKt.isBlank(str)) {
            userName = getString(C0637R.string.solo_welcome_greeting_default_name);
        }
        Intrinsics.checkNotNull(userName);
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.currentMode.ordinal()];
        if (i2 == 1) {
            i = C0637R.string.solo_welcome_greeting_code;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = C0637R.string.solo_welcome_greeting;
        }
        getBinding().tvWelcomeTitle.setText(getString(i, new Object[]{userName}));
    }

    private final String getUserName() {
        AccountInfo accountInfo;
        try {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) {
                return null;
            }
            return accountInfo.getScreenName();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setMode(ChatMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.currentMode = mode;
        if (this._binding != null) {
            updateGreetingText();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
