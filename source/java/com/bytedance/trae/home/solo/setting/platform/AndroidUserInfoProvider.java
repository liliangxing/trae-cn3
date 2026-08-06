package com.bytedance.trae.home.solo.setting.platform;

import androidx.lifecycle.Observer;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.solo.setting.SettingsViewModel;
import com.bytedance.trae.home.solo.setting.UserProfileState;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AndroidUserInfoProvider.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;", "Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;", "settingsViewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)V", "_userInfo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;", "userInfo", "Lkotlinx/coroutines/flow/StateFlow;", "getUserInfo", "()Lkotlinx/coroutines/flow/StateFlow;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/trae/home/solo/setting/UserProfileState;", "observeForever", "", "removeObserver", "refresh", "mapProfile", IAppAuthService.Scope.PROFILE, "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AndroidUserInfoProvider implements UserInfoProvider {
    public static final int $stable = 8;
    private final MutableStateFlow<UserInfo> _userInfo;
    private final Observer<UserProfileState> observer;
    private final SettingsViewModel settingsViewModel;
    private final StateFlow<UserInfo> userInfo;

    public AndroidUserInfoProvider(SettingsViewModel settingsViewModel) {
        Intrinsics.checkNotNullParameter(settingsViewModel, "settingsViewModel");
        this.settingsViewModel = settingsViewModel;
        MutableStateFlow<UserInfo> MutableStateFlow = StateFlowKt.MutableStateFlow(mapProfile((UserProfileState) settingsViewModel.getUserProfile().getValue()));
        this._userInfo = MutableStateFlow;
        this.userInfo = FlowKt.asStateFlow(MutableStateFlow);
        this.observer = new Observer() { // from class: com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                AndroidUserInfoProvider.observer$lambda$0(AndroidUserInfoProvider.this, (UserProfileState) obj);
            }
        };
    }

    @Override // com.bytedance.trae.home.solo.setting.platform.UserInfoProvider
    public StateFlow<UserInfo> getUserInfo() {
        return this.userInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(AndroidUserInfoProvider androidUserInfoProvider, UserProfileState userProfileState) {
        androidUserInfoProvider._userInfo.setValue(androidUserInfoProvider.mapProfile(userProfileState));
    }

    public final void observeForever() {
        this.settingsViewModel.getUserProfile().observeForever(this.observer);
    }

    public final void removeObserver() {
        this.settingsViewModel.getUserProfile().removeObserver(this.observer);
    }

    @Override // com.bytedance.trae.home.solo.setting.platform.UserInfoProvider
    public void refresh() {
        this.settingsViewModel.loadUserInfo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0050, code lost:
    
        if (r3 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final UserInfo mapProfile(UserProfileState profile) {
        String email;
        AccountInfo accountInfo;
        String screenName = profile != null ? profile.getScreenName() : null;
        if (screenName == null) {
            screenName = "";
        }
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        boolean z = ((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getAccountType()) == AccountType.TOB;
        if (AppHost.INSTANCE.isOversea() || z) {
            email = profile != null ? profile.getEmail() : null;
        } else {
            email = profile != null ? profile.getPhoneNumber() : null;
        }
        String avatarUrl = profile != null ? profile.getAvatarUrl() : null;
        return new UserInfo(screenName, email, avatarUrl != null ? avatarUrl : "", profile != null ? profile.getProductType() : 0);
    }
}
