package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.home.generated.resources.Res;
import com.bytedance.trae.home.generated.resources.String0_commonMainKt;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementUiState;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel;
import com.bytedance.trae.kmp.host.KmpHostActions;
import com.bytedance.trae.kmp.host.KmpHostDialogs;
import com.bytedance.trae.kmp.host.KmpHostEnvironment;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import com.bytedance.trae.kmp.ui.KmpStringResource_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;

/* compiled from: SettingsContentScreens.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a)\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\nH\u0003¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002"}, d2 = {"DeviceManagementScreen", "", "httpClient", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "onOpenConnectComputerGuide", "Lkotlin/Function0;", "onRefreshDeviceCache", "onSwipeInteractionChanged", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bytedance/trae/kmp/network/KmpHttpClient;Lcom/bytedance/trae/kmp/host/KmpHostInfo;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DeviceManagementHostDialogs", "state", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;", "onAction", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ConnectComputerGuideScreen", "(Lcom/bytedance/trae/kmp/host/KmpHostInfo;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "impl_mainlandRelease", "latestCopySuccessMessage", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsContentScreensKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectComputerGuideScreen$lambda$22(KmpHostInfo kmpHostInfo, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ConnectComputerGuideScreen(kmpHostInfo, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceManagementHostDialogs$lambda$19(DeviceManagementUiState deviceManagementUiState, Function1 function1, int i, Composer composer, int i2) {
        DeviceManagementHostDialogs(deviceManagementUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceManagementScreen$lambda$14(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, Function0 function0, Function0 function02, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DeviceManagementScreen(kmpHttpClient, kmpHostInfo, function0, function02, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceManagementScreen$lambda$3$lambda$2(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DeviceManagementScreen(final KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, final Function0<Unit> function0, Function0<Unit> function02, Function1<? super Boolean, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        KmpHostInfo kmpHostInfo2;
        Function0<Unit> function03;
        int i4;
        Function1<? super Boolean, Unit> function12;
        int i5;
        Modifier modifier2;
        Function0<Unit> function04;
        int i6;
        final KmpHostInfo kmpHostInfo3;
        Function0<Unit> function05;
        Modifier modifier3;
        boolean changedInstance;
        Object rememberedValue;
        HasDefaultViewModelProviderFactory current;
        CreationExtras creationExtras;
        final Function1<? super Boolean, Unit> function13;
        final Function1<? super Boolean, Unit> function14;
        final KmpHostInfo kmpHostInfo4;
        final Modifier modifier4;
        final Function0<Unit> function06;
        int i7;
        Intrinsics.checkNotNullParameter(kmpHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(function0, "onOpenConnectComputerGuide");
        Composer startRestartGroup = composer.startRestartGroup(-1123572717);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(kmpHttpClient) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                kmpHostInfo2 = kmpHostInfo;
                if (startRestartGroup.changedInstance(kmpHostInfo2)) {
                    i7 = 32;
                    i3 |= i7;
                }
            } else {
                kmpHostInfo2 = kmpHostInfo;
            }
            i7 = 16;
            i3 |= i7;
        } else {
            kmpHostInfo2 = kmpHostInfo;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            function03 = function02;
            i3 |= startRestartGroup.changedInstance(function03) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                function12 = function1;
                i3 |= startRestartGroup.changedInstance(function12) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 131072 : 65536;
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if ((i2 & 2) != 0) {
                                kmpHostInfo2 = (KmpHostInfo) KmpHostEnvironment.INSTANCE;
                                i3 &= -113;
                            }
                            if (i8 == 0) {
                                startRestartGroup.startReplaceGroup(1213418215);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda4
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                function04 = (Function0) rememberedValue2;
                                startRestartGroup.endReplaceGroup();
                            } else {
                                function04 = function03;
                            }
                            if (i4 != 0) {
                                startRestartGroup.startReplaceGroup(1213419975);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda5
                                        public final Object invoke(Object obj) {
                                            Unit DeviceManagementScreen$lambda$3$lambda$2;
                                            DeviceManagementScreen$lambda$3$lambda$2 = SettingsContentScreensKt.DeviceManagementScreen$lambda$3$lambda$2(((Boolean) obj).booleanValue());
                                            return DeviceManagementScreen$lambda$3$lambda$2;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceGroup();
                                function12 = (Function1) rememberedValue3;
                            }
                            if (i5 == 0) {
                                i6 = i3;
                                kmpHostInfo3 = kmpHostInfo2;
                                function05 = function04;
                                modifier3 = (Modifier) Modifier.Companion;
                                Function1<? super Boolean, Unit> function15 = function12;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1123572717, i6, -1, "com.bytedance.trae.home.solo.setting.ui.DeviceManagementScreen (SettingsContentScreens.kt:37)");
                                }
                                startRestartGroup.startReplaceGroup(1213422431);
                                changedInstance = startRestartGroup.changedInstance(kmpHttpClient) | startRestartGroup.changedInstance(kmpHostInfo3);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda6
                                        public final Object invoke(Object obj) {
                                            DeviceManagementViewModel DeviceManagementScreen$lambda$5$lambda$4;
                                            DeviceManagementScreen$lambda$5$lambda$4 = SettingsContentScreensKt.DeviceManagementScreen$lambda$5$lambda$4(kmpHttpClient, kmpHostInfo3, (CreationExtras) obj);
                                            return DeviceManagementScreen$lambda$5$lambda$4;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                Function1 function16 = (Function1) rememberedValue;
                                startRestartGroup.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 419377738, "CC(viewModel)N(viewModelStoreOwner,key,initializer)127@5935L7,133@6124L329:ViewModel.kt#3tja67");
                                current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
                                if (current != null) {
                                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                                }
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DeviceManagementViewModel.class);
                                InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
                                initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(DeviceManagementViewModel.class), function16);
                                ViewModelProvider.Factory build = initializerViewModelFactoryBuilder.build();
                                if (current instanceof HasDefaultViewModelProviderFactory) {
                                    creationExtras = current.getDefaultViewModelCreationExtras();
                                } else {
                                    creationExtras = CreationExtras.Empty.INSTANCE;
                                }
                                int i9 = i6;
                                ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, build, creationExtras, startRestartGroup, 0, 0);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final DeviceManagementViewModel deviceManagementViewModel = (DeviceManagementViewModel) viewModel;
                                State collectAsState = SnapshotStateKt.collectAsState(deviceManagementViewModel.getState(), (CoroutineContext) null, startRestartGroup, 0, 1);
                                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_url_copied(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), startRestartGroup, 0);
                                DeviceManagementUiState DeviceManagementScreen$lambda$6 = DeviceManagementScreen$lambda$6(collectAsState);
                                startRestartGroup.startReplaceGroup(1213435384);
                                boolean changedInstance2 = startRestartGroup.changedInstance(deviceManagementViewModel);
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                    rememberedValue4 = (KFunction) new SettingsContentScreensKt$DeviceManagementScreen$3$1(deviceManagementViewModel);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                startRestartGroup.endReplaceGroup();
                                DeviceManagementHostDialogs(DeviceManagementScreen$lambda$6, (KFunction) rememberedValue4, startRestartGroup, 0);
                                startRestartGroup.startReplaceGroup(1213437404);
                                int i10 = 57344 & i9;
                                boolean changedInstance3 = startRestartGroup.changedInstance(deviceManagementViewModel) | (i10 == 16384);
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (changedInstance3 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                    function13 = function15;
                                    rememberedValue5 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda7
                                        public final Object invoke(Object obj) {
                                            DisposableEffectResult DeviceManagementScreen$lambda$11$lambda$10;
                                            DeviceManagementScreen$lambda$11$lambda$10 = SettingsContentScreensKt.DeviceManagementScreen$lambda$11$lambda$10(DeviceManagementViewModel.this, function13, (DisposableEffectScope) obj);
                                            return DeviceManagementScreen$lambda$11$lambda$10;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                } else {
                                    function13 = function15;
                                }
                                startRestartGroup.endReplaceGroup();
                                EffectsKt.DisposableEffect(deviceManagementViewModel, (Function1) rememberedValue5, startRestartGroup, 0);
                                startRestartGroup.startReplaceGroup(1213444341);
                                boolean changedInstance4 = ((i9 & 7168) == 2048) | startRestartGroup.changedInstance(deviceManagementViewModel) | startRestartGroup.changed(rememberUpdatedState);
                                SettingsContentScreensKt$DeviceManagementScreen$5$1 rememberedValue6 = startRestartGroup.rememberedValue();
                                if (changedInstance4 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                    rememberedValue6 = new SettingsContentScreensKt$DeviceManagementScreen$5$1(deviceManagementViewModel, function05, rememberUpdatedState, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                startRestartGroup.endReplaceGroup();
                                EffectsKt.LaunchedEffect(deviceManagementViewModel, function05, (Function2) rememberedValue6, startRestartGroup, (i9 >> 6) & 112);
                                DeviceManagementUiState DeviceManagementScreen$lambda$62 = DeviceManagementScreen$lambda$6(collectAsState);
                                String displayUrl = deviceManagementViewModel.displayUrl();
                                startRestartGroup.startReplaceGroup(1213466104);
                                boolean changedInstance5 = startRestartGroup.changedInstance(deviceManagementViewModel);
                                Object rememberedValue7 = startRestartGroup.rememberedValue();
                                if (changedInstance5 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                    rememberedValue7 = (KFunction) new SettingsContentScreensKt$DeviceManagementScreen$6$1(deviceManagementViewModel);
                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                }
                                startRestartGroup.endReplaceGroup();
                                Function0<Unit> function07 = function05;
                                DeviceManagementKt.DeviceManagementContent(DeviceManagementScreen$lambda$62, displayUrl, function0, (KFunction) rememberedValue7, function13, modifier3, startRestartGroup, (i9 & 896) | i10 | (i9 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function14 = function13;
                                kmpHostInfo4 = kmpHostInfo3;
                                modifier4 = modifier3;
                                function06 = function07;
                            } else {
                                i6 = i3;
                                kmpHostInfo3 = kmpHostInfo2;
                                function05 = function04;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            i6 = i3;
                            kmpHostInfo3 = kmpHostInfo2;
                            function05 = function03;
                        }
                        modifier3 = modifier2;
                        Function1<? super Boolean, Unit> function152 = function12;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceGroup(1213422431);
                        changedInstance = startRestartGroup.changedInstance(kmpHttpClient) | startRestartGroup.changedInstance(kmpHostInfo3);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                DeviceManagementViewModel DeviceManagementScreen$lambda$5$lambda$4;
                                DeviceManagementScreen$lambda$5$lambda$4 = SettingsContentScreensKt.DeviceManagementScreen$lambda$5$lambda$4(kmpHttpClient, kmpHostInfo3, (CreationExtras) obj);
                                return DeviceManagementScreen$lambda$5$lambda$4;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        Function1 function162 = (Function1) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 419377738, "CC(viewModel)N(viewModelStoreOwner,key,initializer)127@5935L7,133@6124L329:ViewModel.kt#3tja67");
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
                        if (current != null) {
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        kmpHostInfo4 = kmpHostInfo2;
                        function06 = function03;
                        function14 = function12;
                        modifier4 = modifier2;
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj, Object obj2) {
                                Unit DeviceManagementScreen$lambda$14;
                                DeviceManagementScreen$lambda$14 = SettingsContentScreensKt.DeviceManagementScreen$lambda$14(kmpHttpClient, kmpHostInfo4, function0, function06, function14, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return DeviceManagementScreen$lambda$14;
                            }
                        });
                        return;
                    }
                    return;
                }
                modifier2 = modifier;
                if ((74899 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if ((i2 & 2) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 != 0) {
                }
                if (i5 == 0) {
                }
            }
            function12 = function1;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            if ((74899 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 != 0) {
            }
            if (i5 == 0) {
            }
        }
        function03 = function02;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        function12 = function1;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 != 0) {
        }
        if (i5 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceManagementViewModel DeviceManagementScreen$lambda$5$lambda$4(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(creationExtras, "$this$viewModel");
        return new DeviceManagementViewModel(kmpHttpClient, kmpHostInfo, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult DeviceManagementScreen$lambda$11$lambda$10(final DeviceManagementViewModel deviceManagementViewModel, final Function1 function1, DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        deviceManagementViewModel.startPolling$impl_mainlandRelease();
        return new DisposableEffectResult() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementScreen$lambda$11$lambda$10$$inlined$onDispose$1
            public void dispose() {
                DeviceManagementViewModel.this.stopPolling$impl_mainlandRelease();
                function1.invoke(false);
            }
        };
    }

    private static final void DeviceManagementHostDialogs(final DeviceManagementUiState deviceManagementUiState, final Function1<? super DeviceManagementAction, Unit> function1, Composer composer, final int i) {
        int i2;
        String str;
        DeviceManagementDevice device;
        DeviceManagementDevice device2;
        Composer startRestartGroup = composer.startRestartGroup(1437536446);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(deviceManagementUiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1437536446, i2, -1, "com.bytedance.trae.home.solo.setting.ui.DeviceManagementHostDialogs (SettingsContentScreens.kt:89)");
            }
            String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_device_dialog_rename_title(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            String kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_device_delete_dialog_title(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            String kmpStringResource3 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_device_delete_dialog_message(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            String kmpStringResource4 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_dialog_btn_cancel(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            String kmpStringResource5 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_dialog_btn_confirm(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            String kmpStringResource6 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_dialog_btn_delete(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            DeviceManagementRenameState renameDialog = deviceManagementUiState.getRenameDialog();
            DeviceManagementDeleteState deleteDialog = deviceManagementUiState.getDeleteDialog();
            String str2 = null;
            String id = (renameDialog == null || (device2 = renameDialog.getDevice()) == null) ? null : device2.getId();
            if (deleteDialog != null && (device = deleteDialog.getDevice()) != null) {
                str2 = device.getId();
            }
            startRestartGroup.startReplaceGroup(-2137065663);
            boolean changed = ((i2 & 112) == 32) | startRestartGroup.changed(renameDialog) | startRestartGroup.changed(kmpStringResource) | startRestartGroup.changed(kmpStringResource4) | startRestartGroup.changed(kmpStringResource5) | startRestartGroup.changed(deleteDialog) | startRestartGroup.changed(kmpStringResource2) | startRestartGroup.changed(kmpStringResource3) | startRestartGroup.changed(kmpStringResource6);
            SettingsContentScreensKt$DeviceManagementHostDialogs$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                str = str2;
                rememberedValue = new SettingsContentScreensKt$DeviceManagementHostDialogs$1$1(renameDialog, kmpStringResource, kmpStringResource4, kmpStringResource5, deleteDialog, kmpStringResource2, kmpStringResource3, kmpStringResource6, function1, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                str = str2;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(id, str, (Function2) rememberedValue, startRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-2137028236);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult DeviceManagementHostDialogs$lambda$18$lambda$17;
                        DeviceManagementHostDialogs$lambda$18$lambda$17 = SettingsContentScreensKt.DeviceManagementHostDialogs$lambda$18$lambda$17((DisposableEffectScope) obj);
                        return DeviceManagementHostDialogs$lambda$18$lambda$17;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeviceManagementHostDialogs$lambda$19;
                    DeviceManagementHostDialogs$lambda$19 = SettingsContentScreensKt.DeviceManagementHostDialogs$lambda$19(DeviceManagementUiState.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DeviceManagementHostDialogs$lambda$19;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ConnectComputerGuideScreen(final KmpHostInfo kmpHostInfo, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-169088017);
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && startRestartGroup.changedInstance(kmpHostInfo)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    kmpHostInfo = (KmpHostInfo) KmpHostEnvironment.INSTANCE;
                    i3 &= -15;
                }
                if (i4 != 0) {
                    modifier = (Modifier) Modifier.Companion;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-169088017, i3, -1, "com.bytedance.trae.home.solo.setting.ui.ConnectComputerGuideScreen (SettingsContentScreens.kt:142)");
            }
            final String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_url_copied(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            String str = kmpHostInfo.isOversea() ? "trae.ai" : "trae.cn";
            final String str2 = kmpHostInfo.isOversea() ? "https://trae.ai" : "https://trae.cn";
            startRestartGroup.startReplaceGroup(879913695);
            boolean changed = startRestartGroup.changed(str2) | startRestartGroup.changed(kmpStringResource);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
                obj = rememberedValue;
            }
            Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit ConnectComputerGuideScreen$lambda$21$lambda$20;
                    ConnectComputerGuideScreen$lambda$21$lambda$20 = SettingsContentScreensKt.ConnectComputerGuideScreen$lambda$21$lambda$20(str2, kmpStringResource);
                    return ConnectComputerGuideScreen$lambda$21$lambda$20;
                }
            };
            startRestartGroup.updateRememberedValue(function0);
            obj = function0;
            startRestartGroup.endReplaceGroup();
            ConnectComputerGuidePageKt.ConnectComputerGuideContent(str, (Function0) obj, modifier, startRestartGroup, (i3 << 3) & 896, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ConnectComputerGuideScreen$lambda$22;
                    ConnectComputerGuideScreen$lambda$22 = SettingsContentScreensKt.ConnectComputerGuideScreen$lambda$22(kmpHostInfo, modifier, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    return ConnectComputerGuideScreen$lambda$22;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectComputerGuideScreen$lambda$21$lambda$20(String str, String str2) {
        KmpHostActions.INSTANCE.copyToClipboard(str);
        KmpHostActions.INSTANCE.showToast(str2);
        return Unit.INSTANCE;
    }

    private static final DeviceManagementUiState DeviceManagementScreen$lambda$6(State<DeviceManagementUiState> state) {
        return (DeviceManagementUiState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DeviceManagementScreen$lambda$7(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult DeviceManagementHostDialogs$lambda$18$lambda$17(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementHostDialogs$lambda$18$lambda$17$$inlined$onDispose$1
            public void dispose() {
                KmpHostDialogs.INSTANCE.dismiss();
            }
        };
    }
}
