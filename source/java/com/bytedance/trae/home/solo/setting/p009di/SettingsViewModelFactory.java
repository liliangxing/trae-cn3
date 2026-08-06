package com.bytedance.trae.home.solo.setting.p009di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.trae.home.solo.setting.SettingsViewModel;
import com.bytedance.trae.home.solo.setting.data.DefaultNotificationRepository;
import com.bytedance.trae.home.solo.setting.data.DefaultPayRepository;
import com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository;
import com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel;
import com.bytedance.trae.kmp.host.KmpHostEnvironment;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.kmp.network.AndroidKmpHttpClientFactory;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import com.bytedance.trae.network.DebugSettings;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsViewModelFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "settingsViewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final KmpHostInfo hostInfo;
    private final SettingsViewModel settingsViewModel;

    public SettingsViewModelFactory(SettingsViewModel settingsViewModel, KmpHostInfo kmpHostInfo) {
        Intrinsics.checkNotNullParameter(settingsViewModel, "settingsViewModel");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        this.settingsViewModel = settingsViewModel;
        this.hostInfo = kmpHostInfo;
    }

    public /* synthetic */ SettingsViewModelFactory(SettingsViewModel settingsViewModel, KmpHostInfo kmpHostInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(settingsViewModel, (i & 2) != 0 ? (KmpHostInfo) KmpHostEnvironment.INSTANCE : kmpHostInfo);
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        KmpHttpClient kmpHttpClient = AndroidKmpHttpClientFactory.INSTANCE.get();
        final AndroidUserInfoProvider androidUserInfoProvider = new AndroidUserInfoProvider(this.settingsViewModel);
        androidUserInfoProvider.observeForever();
        SettingsEntryViewModel settingsEntryViewModel = new SettingsEntryViewModel(androidUserInfoProvider, new DefaultPayRepository(kmpHttpClient, this.hostInfo, null, 4, null), new DefaultNotificationRepository(kmpHttpClient, this.hostInfo, null, 4, null), new DefaultSettingsCreditsRepository(kmpHttpClient, this.hostInfo, null, 4, null), DebugSettings.INSTANCE.getPpeEnv(), this.hostInfo);
        settingsEntryViewModel.addCloseable(new Closeable() { // from class: com.bytedance.trae.home.solo.setting.di.SettingsViewModelFactory$$ExternalSyntheticLambda0
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                AndroidUserInfoProvider.this.removeObserver();
            }
        });
        return settingsEntryViewModel;
    }
}
