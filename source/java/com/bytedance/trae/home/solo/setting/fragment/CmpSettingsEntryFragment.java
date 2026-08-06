package com.bytedance.trae.home.solo.setting.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.bytedance.sdk.account.api.AccountDef;
import com.bytedance.trae.common.theme.ThemeManager;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.MainActivity;
import com.bytedance.trae.home.solo.setting.AccountFragment;
import com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet;
import com.bytedance.trae.home.solo.setting.CmpSettingsNavigator;
import com.bytedance.trae.home.solo.setting.ConnectorsFragment;
import com.bytedance.trae.home.solo.setting.DebugSettingsFragment;
import com.bytedance.trae.home.solo.setting.EditProfileFragment;
import com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.home.solo.setting.SettingsViewModel;
import com.bytedance.trae.home.solo.setting.p009di.SettingsViewModelFactory;
import com.bytedance.trae.home.solo.setting.p010ui.SettingsEntryKt;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageTracker;
import com.bytedance.trae.kmp.cmp.TraeCmpSheetContentFragment;
import com.bytedance.trae.kmp.host.KmpHostDialogs;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.network.IChangeLanguageApi;
import com.bytedance.trae.push.api.IPushService;
import com.bytedance.trae.update.AppUpdateChecker;
import com.bytedance.trae.utils.LocaleManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;

/* compiled from: CmpSettingsEntryFragment.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001b\u001a\u00020\u001cH\u0015¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001cH\u0014J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u001cH\u0002J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\n\u00105\u001a\u0004\u0018\u000106H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u00068²\u0006\f\u00109\u001a\u0004\u0018\u00010:X\u008a\u0084\u0002"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;", "Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;", "<init>", "()V", "titleResId", "", "getTitleResId", "()I", "leftAction", "Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;", "getLeftAction", "()Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;", "rightAction", "getRightAction", "composeViewId", "getComposeViewId", "legacyViewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "getLegacyViewModel", "()Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "legacyViewModel$delegate", "Lkotlin/Lazy;", "settingsEntryViewModel", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;", "getSettingsEntryViewModel", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;", "settingsEntryViewModel$delegate", "RenderCmpContent", "", "(Landroidx/compose/runtime/Composer;I)V", "onCmpViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCloseAction", "onResume", "onDestroyView", "handleItemClick", "key", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;", "applyThemeMode", "mode", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;", "applyLanguage", SettingsTracker.TYPE_LANGUAGE, "", "showNotificationConfirmDialog", "performLogout", "navigateTo", "fragment", "Landroidx/fragment/app/Fragment;", "dismissSheet", "cmpSheet", "Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;", "Companion", "impl_mainlandRelease", "state", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CmpSettingsEntryFragment extends TraeCmpSheetContentFragment {

    /* renamed from: settingsEntryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsEntryViewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final int titleResId = C0820R.string.trae_setting_title;
    private final TraeTitleBar.Action leftAction = TraeTitleBar.Action.NONE;
    private final TraeTitleBar.Action rightAction = TraeTitleBar.Action.CLOSE;
    private final int composeViewId = C0820R.id.cmp_settings_entry_root;

    /* renamed from: legacyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy legacyViewModel = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda4
        public final Object invoke() {
            SettingsViewModel legacyViewModel_delegate$lambda$0;
            legacyViewModel_delegate$lambda$0 = CmpSettingsEntryFragment.legacyViewModel_delegate$lambda$0(CmpSettingsEntryFragment.this);
            return legacyViewModel_delegate$lambda$0;
        }
    });

    /* compiled from: CmpSettingsEntryFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SettingsItemKey.values().length];
            try {
                iArr[SettingsItemKey.Subscribe.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsItemKey.Usage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingsItemKey.Points.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SettingsItemKey.Account.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SettingsItemKey.Message.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SettingsItemKey.Theme.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SettingsItemKey.Language.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SettingsItemKey.Notification.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SettingsItemKey.DeviceManagement.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SettingsItemKey.Connectors.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SettingsItemKey.PrivacyPermission.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SettingsItemKey.Update.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SettingsItemKey.About.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SettingsItemKey.Debug.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[SettingsItemKey.Logout.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SettingsThemeMode.values().length];
            try {
                iArr2[SettingsThemeMode.Light.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[SettingsThemeMode.Dark.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[SettingsThemeMode.System.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$15(CmpSettingsEntryFragment cmpSettingsEntryFragment, int i, Composer composer, int i2) {
        cmpSettingsEntryFragment.RenderCmpContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public CmpSettingsEntryFragment() {
        final Fragment fragment = (Fragment) this;
        Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda5
            public final Object invoke() {
                ViewModelProvider.Factory factory;
                factory = CmpSettingsEntryFragment.settingsEntryViewModel_delegate$lambda$1(CmpSettingsEntryFragment.this);
                return factory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m2436invoke() {
                return fragment;
            }
        };
        this.settingsEntryViewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsEntryViewModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m2437invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function02.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, function0);
    }

    protected int getTitleResId() {
        return this.titleResId;
    }

    protected TraeTitleBar.Action getLeftAction() {
        return this.leftAction;
    }

    protected TraeTitleBar.Action getRightAction() {
        return this.rightAction;
    }

    protected int getComposeViewId() {
        return this.composeViewId;
    }

    private final SettingsViewModel getLegacyViewModel() {
        return (SettingsViewModel) this.legacyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsViewModel legacyViewModel_delegate$lambda$0(CmpSettingsEntryFragment cmpSettingsEntryFragment) {
        ViewModelStoreOwner requireActivity = cmpSettingsEntryFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        return new ViewModelProvider(requireActivity).get(SettingsViewModel.class);
    }

    private final SettingsEntryViewModel getSettingsEntryViewModel() {
        return (SettingsEntryViewModel) this.settingsEntryViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory settingsEntryViewModel_delegate$lambda$1(CmpSettingsEntryFragment cmpSettingsEntryFragment) {
        KmpHostInfo kmpHostInfo = null;
        return new SettingsViewModelFactory(cmpSettingsEntryFragment.getLegacyViewModel(), kmpHostInfo, 2, kmpHostInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0147, code lost:
    
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0173, code lost:
    
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0199, code lost:
    
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void RenderCmpContent(Composer composer, final int i) {
        int i2;
        Object obj;
        Object obj2;
        Object obj3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-390959967);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-390959967, i2, -1, "com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment.RenderCmpContent (CmpSettingsEntryFragment.kt:63)");
            }
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(getSettingsEntryViewModel().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            SettingsEntryState RenderCmpContent$lambda$2 = RenderCmpContent$lambda$2(collectAsStateWithLifecycle);
            if (RenderCmpContent$lambda$2 == null) {
                composer2 = startRestartGroup;
            } else {
                Modifier modifier = Modifier.Companion;
                startRestartGroup.startReplaceGroup(176946141);
                boolean changedInstance = startRestartGroup.changedInstance(this) | startRestartGroup.changed(rememberScrollState);
                PointerInputEventHandler rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new PointerInputEventHandler() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$RenderCmpContent$1$1$1

                        /* compiled from: CmpSettingsEntryFragment.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1", f = "CmpSettingsEntryFragment.kt", i = {0, 1}, l = {73, 76}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"})
                        /* renamed from: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1 */
                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
                        static final class C08311 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ScrollState $contentScrollState;
                            private /* synthetic */ Object L$0;
                            int label;
                            final /* synthetic */ CmpSettingsEntryFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C08311(CmpSettingsEntryFragment cmpSettingsEntryFragment, ScrollState scrollState, Continuation<? super C08311> continuation) {
                                super(2, continuation);
                                this.this$0 = cmpSettingsEntryFragment;
                                this.$contentScrollState = scrollState;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                Continuation<Unit> c08311 = new C08311(this.this$0, this.$contentScrollState, continuation);
                                c08311.L$0 = obj;
                                return c08311;
                            }

                            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
                            
                                r13 = true;
                             */
                            /* JADX WARN: Removed duplicated region for block: B:12:0x00a0  */
                            /* JADX WARN: Removed duplicated region for block: B:18:0x00ae  */
                            /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[RETURN] */
                            /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
                            /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
                            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006b -> B:6:0x0070). Please report as a decompilation issue!!! */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invokeSuspend(Object obj) {
                                AwaitPointerEventScope awaitPointerEventScope;
                                CmpAccountSettingsBottomSheet cmpSheet;
                                C08311 c08311;
                                Object awaitPointerEvent$default;
                                Iterator it;
                                CmpAccountSettingsBottomSheet cmpSheet2;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                                    this.L$0 = awaitPointerEventScope;
                                    this.label = 1;
                                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, (PointerEventPass) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i == 1) {
                                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    AwaitPointerEventScope awaitPointerEventScope3 = awaitPointerEventScope2;
                                    Object obj2 = coroutine_suspended;
                                    C08311 c083112 = this;
                                    List changes = ((PointerEvent) obj).getChanges();
                                    if ((changes instanceof Collection) || !changes.isEmpty()) {
                                        it = changes.iterator();
                                        while (it.hasNext()) {
                                            if (((PointerInputChange) it.next()).getPressed()) {
                                                break;
                                            }
                                        }
                                    }
                                    boolean z = false;
                                    if (z) {
                                        cmpSheet2 = c083112.this$0.cmpSheet();
                                        if (cmpSheet2 != null) {
                                            cmpSheet2.onContentGestureEnded();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    c08311 = c083112;
                                    coroutine_suspended = obj2;
                                    awaitPointerEventScope = awaitPointerEventScope3;
                                    c08311.L$0 = awaitPointerEventScope;
                                    c08311.label = 2;
                                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, (Continuation) c08311, 1, (Object) null);
                                    if (awaitPointerEvent$default != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Object obj3 = coroutine_suspended;
                                    c083112 = c08311;
                                    obj = awaitPointerEvent$default;
                                    awaitPointerEventScope3 = awaitPointerEventScope;
                                    obj2 = obj3;
                                    List changes2 = ((PointerEvent) obj).getChanges();
                                    if (changes2 instanceof Collection) {
                                    }
                                    it = changes2.iterator();
                                    while (it.hasNext()) {
                                    }
                                    boolean z2 = false;
                                    if (z2) {
                                    }
                                }
                                cmpSheet = this.this$0.cmpSheet();
                                if (cmpSheet != null) {
                                    cmpSheet.onContentGestureStarted(this.$contentScrollState.getValue() > 0);
                                }
                                c08311 = this;
                                c08311.L$0 = awaitPointerEventScope;
                                c08311.label = 2;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, (Continuation) c08311, 1, (Object) null);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            }
                        }

                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C08311(CmpSettingsEntryFragment.this, rememberScrollState, null), continuation);
                            return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, rememberScrollState, (PointerInputEventHandler) rememberedValue);
                startRestartGroup.startReplaceGroup(176963977);
                boolean changedInstance2 = startRestartGroup.changedInstance(this);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = (KFunction) new CmpSettingsEntryFragment$RenderCmpContent$1$2$1(this);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function1 function1 = (KFunction) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(176965736);
                boolean changedInstance3 = startRestartGroup.changedInstance(this);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = (KFunction) new CmpSettingsEntryFragment$RenderCmpContent$1$3$1(this);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Function1 function12 = (KFunction) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(176980616);
                boolean changedInstance4 = startRestartGroup.changedInstance(this);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = (KFunction) new CmpSettingsEntryFragment$RenderCmpContent$1$4$1(this);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function0 function0 = (KFunction) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(176982122);
                boolean changedInstance5 = startRestartGroup.changedInstance(this);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = (KFunction) new CmpSettingsEntryFragment$RenderCmpContent$1$5$1(this);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Function1 function13 = (KFunction) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(176961290);
                boolean changedInstance6 = startRestartGroup.changedInstance(this);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changedInstance6) {
                    obj = rememberedValue6;
                }
                Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit RenderCmpContent$lambda$14$lambda$9$lambda$8;
                        RenderCmpContent$lambda$14$lambda$9$lambda$8 = CmpSettingsEntryFragment.RenderCmpContent$lambda$14$lambda$9$lambda$8(CmpSettingsEntryFragment.this);
                        return RenderCmpContent$lambda$14$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(function02);
                obj = function02;
                Function0 function03 = (Function0) obj;
                startRestartGroup.endReplaceGroup();
                Function1 function14 = function1;
                Function1 function15 = function12;
                startRestartGroup.startReplaceGroup(176967382);
                boolean changedInstance7 = startRestartGroup.changedInstance(this);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (!changedInstance7) {
                    obj2 = rememberedValue7;
                }
                Function0 function04 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit RenderCmpContent$lambda$14$lambda$11$lambda$10;
                        RenderCmpContent$lambda$14$lambda$11$lambda$10 = CmpSettingsEntryFragment.RenderCmpContent$lambda$14$lambda$11$lambda$10(CmpSettingsEntryFragment.this);
                        return RenderCmpContent$lambda$14$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(function04);
                obj2 = function04;
                Function0 function05 = (Function0) obj2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(176973805);
                boolean changedInstance8 = startRestartGroup.changedInstance(this);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (!changedInstance8) {
                    obj3 = rememberedValue8;
                }
                Function0 function06 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit RenderCmpContent$lambda$14$lambda$13$lambda$12;
                        RenderCmpContent$lambda$14$lambda$13$lambda$12 = CmpSettingsEntryFragment.RenderCmpContent$lambda$14$lambda$13$lambda$12(CmpSettingsEntryFragment.this);
                        return RenderCmpContent$lambda$14$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(function06);
                obj3 = function06;
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                SettingsEntryKt.SettingsEntryContent(RenderCmpContent$lambda$2, pointerInput, rememberScrollState, function03, function14, function15, function05, (Function0) obj3, function0, function13, startRestartGroup, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda3
                public final Object invoke(Object obj4, Object obj5) {
                    Unit RenderCmpContent$lambda$15;
                    RenderCmpContent$lambda$15 = CmpSettingsEntryFragment.RenderCmpContent$lambda$15(CmpSettingsEntryFragment.this, i, (Composer) obj4, ((Integer) obj5).intValue());
                    return RenderCmpContent$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$14$lambda$9$lambda$8(CmpSettingsEntryFragment cmpSettingsEntryFragment) {
        cmpSettingsEntryFragment.navigateTo(EditProfileFragment.INSTANCE.newInstance());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$14$lambda$11$lambda$10(CmpSettingsEntryFragment cmpSettingsEntryFragment) {
        CmpSettingsNavigator navigator;
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_ABOUT);
        CmpAccountSettingsBottomSheet cmpSheet = cmpSettingsEntryFragment.cmpSheet();
        if (cmpSheet != null && (navigator = cmpSheet.getNavigator()) != null) {
            navigator.openAbout();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$14$lambda$13$lambda$12(CmpSettingsEntryFragment cmpSettingsEntryFragment) {
        CmpSettingsNavigator navigator;
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_DEVICE_MANAGEMENT);
        CmpAccountSettingsBottomSheet cmpSheet = cmpSettingsEntryFragment.cmpSheet();
        if (cmpSheet != null && (navigator = cmpSheet.getNavigator()) != null) {
            navigator.openDeviceManagement();
        }
        return Unit.INSTANCE;
    }

    protected void onCmpViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        SettingsTracker.trackSettingsPageView$default(SettingsTracker.INSTANCE, null, 1, null);
    }

    protected void onCloseAction() {
        CmpAccountSettingsBottomSheet cmpSheet = cmpSheet();
        if (cmpSheet != null) {
            cmpSheet.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
        getSettingsEntryViewModel().onResume();
    }

    public void onDestroyView() {
        CmpAccountSettingsBottomSheet cmpSheet = cmpSheet();
        if (cmpSheet != null) {
            cmpSheet.onContentGestureEnded();
        }
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleItemClick(SettingsItemKey key) {
        switch (WhenMappings.$EnumSwitchMapping$0[key.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 9:
            case 13:
                return;
            case 4:
                SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_ACCOUNT);
                navigateTo(AccountFragment.INSTANCE.newInstance());
                return;
            case 5:
                SiteMessageTracker.INSTANCE.trackEntryClick(((Number) SiteMessageRepository.INSTANCE.getUnreadCount().getValue()).intValue() > 0);
                navigateTo(SiteMessageListFragment.INSTANCE.newInstance());
                return;
            case 6:
                SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_THEME);
                return;
            case 7:
                SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_LANGUAGE);
                return;
            case 8:
                SettingsTracker.INSTANCE.trackSettingsClick("notification");
                showNotificationConfirmDialog();
                return;
            case 10:
                SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_CONNECTORS);
                navigateTo(ConnectorsFragment.INSTANCE.newInstance());
                return;
            case 11:
                navigateTo(PrivacyPermissionFragment.INSTANCE.newInstance());
                return;
            case 12:
                AppUpdateChecker.INSTANCE.checkUpdate(false);
                return;
            case 14:
                navigateTo(DebugSettingsFragment.INSTANCE.newInstance());
                return;
            case 15:
                SettingsTracker.INSTANCE.trackLogoutClick();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyThemeMode(SettingsThemeMode mode) {
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_THEME);
        SettingsTracker.INSTANCE.trackThemeSwitchClick(mode.getValue());
        ThemeManager themeManager = ThemeManager.INSTANCE;
        int i = WhenMappings.$EnumSwitchMapping$1[mode.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i2 = -1;
            }
        }
        themeManager.applyDarkMode(i2);
        getSettingsEntryViewModel().refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyLanguage(String language) {
        Intent intent;
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_LANGUAGE);
        if (Intrinsics.areEqual(language, LocaleManager.INSTANCE.getCurrentLanguage())) {
            return;
        }
        SettingsTracker.INSTANCE.trackLanguageSwitchClick(language);
        LocaleManager.INSTANCE.setLanguage(language);
        IChangeLanguageApi.Companion.syncLanguage(language);
        CmpAccountSettingsBottomSheet parentFragment = getParentFragment();
        CmpAccountSettingsBottomSheet cmpAccountSettingsBottomSheet = parentFragment instanceof CmpAccountSettingsBottomSheet ? parentFragment : null;
        if (cmpAccountSettingsBottomSheet != null) {
            cmpAccountSettingsBottomSheet.dismissAllowingStateLoss();
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            intent.putExtra(MainActivity.EXTRA_FROM_LANGUAGE_SWITCH, true);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.recreate();
        }
    }

    private final void showNotificationConfirmDialog() {
        KmpHostDialogs kmpHostDialogs = KmpHostDialogs.INSTANCE;
        String string = getString(C0820R.string.trae_setting_notification_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.trae_setting_notification_dialog_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(C0820R.string.trae_setting_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0820R.string.trae_setting_notification_dialog_confirm);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        KmpHostDialogs.showConfirmDialog$default(kmpHostDialogs, string, string2, string3, string4, false, new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit showNotificationConfirmDialog$lambda$16;
                showNotificationConfirmDialog$lambda$16 = CmpSettingsEntryFragment.showNotificationConfirmDialog$lambda$16();
                return showNotificationConfirmDialog$lambda$16;
            }
        }, new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 16, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationConfirmDialog$lambda$16() {
        IPushService.Companion.openSystemNotificationSetting();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performLogout() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            return;
        }
        iLoginService.logout(false, new IAccountCallback() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment$performLogout$1
            public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
            }

            public void onSuccess(LoginPlatform platform, String businessScene, Boolean isNewUserLogin) {
                CmpSettingsEntryFragment.this.dismissSheet();
            }

            public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                CmpSettingsEntryFragment.this.dismissSheet();
            }
        }, AccountDef.LogoutScene.USER_LOGOUT);
    }

    private final void navigateTo(Fragment fragment) {
        CmpSettingsNavigator navigator;
        CmpAccountSettingsBottomSheet cmpSheet = cmpSheet();
        if (cmpSheet == null || (navigator = cmpSheet.getNavigator()) == null) {
            return;
        }
        navigator.openNative(fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissSheet() {
        CmpAccountSettingsBottomSheet cmpSheet = cmpSheet();
        if (cmpSheet != null) {
            cmpSheet.dismissSafely();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CmpAccountSettingsBottomSheet cmpSheet() {
        CmpAccountSettingsBottomSheet parentFragment = getParentFragment();
        if (parentFragment instanceof CmpAccountSettingsBottomSheet) {
            return parentFragment;
        }
        return null;
    }

    /* compiled from: CmpSettingsEntryFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CmpSettingsEntryFragment newInstance() {
            return new CmpSettingsEntryFragment();
        }
    }

    private static final SettingsEntryState RenderCmpContent$lambda$2(State<SettingsEntryState> state) {
        return (SettingsEntryState) state.getValue();
    }
}
