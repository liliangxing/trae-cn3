package com.bytedance.trae.home.solo.setting.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.home.solo.setting.data.NotificationRepository;
import com.bytedance.trae.home.solo.setting.data.PayRepository;
import com.bytedance.trae.home.solo.setting.data.SettingsCreditsRepository;
import com.bytedance.trae.home.solo.setting.data.SettingsCreditsState;
import com.bytedance.trae.home.solo.setting.data.model.PayIdentity;
import com.bytedance.trae.home.solo.setting.platform.UserInfo;
import com.bytedance.trae.home.solo.setting.platform.UserInfoProvider;
import com.bytedance.trae.kmp.host.KmpHostEnvironment;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SettingsEntryViewModel.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ*\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0002J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J:\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00100\u001a\u00020\u00112\b\b\u0002\u00101\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u00020\u0011H\u0002J\u000e\u00103\u001a\u0004\u0018\u00010,*\u00020$H\u0002J\"\u00104\u001a\u0004\u0018\u00010\u000b2\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0002J\f\u00108\u001a\u000209*\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006;"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;", "Landroidx/lifecycle/ViewModel;", "userInfoProvider", "Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;", "payRepository", "Lcom/bytedance/trae/home/solo/setting/data/PayRepository;", "notificationRepository", "Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;", "creditsRepository", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;", "debugPpeEnv", "", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;Lcom/bytedance/trae/home/solo/setting/data/PayRepository;Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;Ljava/lang/String;Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V", "hasResumed", "", "languageRefresh", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onResume", "", "refresh", "buildUiState", "userInfo", "Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;", "payIdentity", "Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;", "unreadCount", "creditsState", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;", "buildGroups", "", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;", "byteCloud", "buildFooterState", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;", "item", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;", "key", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;", "trailing", "destructive", "clickable", "showTrailingIcon", "toSettingsItem", "formatUnreadBadge", "count", ThirdPartyTokenRepository.TYPE_BYTECLOUD, "enterprise", "enterpriseBadge", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsEntryViewModel extends ViewModel {
    private static final String CREDITS_LOADING_TEXT = "--";
    private static final int SaaS_PRODUCT_TYPE_TEAM_GROUP = 220;
    private static final int SaaS_PRODUCT_TYPE_TEAM_GROUP_V2 = 221;
    private final SettingsCreditsRepository creditsRepository;
    private final String debugPpeEnv;
    private boolean hasResumed;
    private final KmpHostInfo hostInfo;
    private final MutableStateFlow<Integer> languageRefresh;
    private final NotificationRepository notificationRepository;
    private final PayRepository payRepository;
    private final StateFlow<SettingsEntryState> state;
    private final UserInfoProvider userInfoProvider;
    public static final int $stable = 8;

    public /* synthetic */ SettingsEntryViewModel(UserInfoProvider userInfoProvider, PayRepository payRepository, NotificationRepository notificationRepository, SettingsCreditsRepository settingsCreditsRepository, String str, KmpHostInfo kmpHostInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(userInfoProvider, payRepository, notificationRepository, settingsCreditsRepository, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? (KmpHostInfo) KmpHostEnvironment.INSTANCE : kmpHostInfo);
    }

    public SettingsEntryViewModel(UserInfoProvider userInfoProvider, PayRepository payRepository, NotificationRepository notificationRepository, SettingsCreditsRepository settingsCreditsRepository, String str, KmpHostInfo kmpHostInfo) {
        Intrinsics.checkNotNullParameter(userInfoProvider, "userInfoProvider");
        Intrinsics.checkNotNullParameter(payRepository, "payRepository");
        Intrinsics.checkNotNullParameter(notificationRepository, "notificationRepository");
        Intrinsics.checkNotNullParameter(settingsCreditsRepository, "creditsRepository");
        Intrinsics.checkNotNullParameter(str, "debugPpeEnv");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        this.userInfoProvider = userInfoProvider;
        this.payRepository = payRepository;
        this.notificationRepository = notificationRepository;
        this.creditsRepository = settingsCreditsRepository;
        this.debugPpeEnv = str;
        this.hostInfo = kmpHostInfo;
        Flow MutableStateFlow = StateFlowKt.MutableStateFlow(0);
        this.languageRefresh = MutableStateFlow;
        this.state = FlowKt.stateIn(FlowKt.combine(userInfoProvider.getUserInfo(), payRepository.getPayIdentity(), notificationRepository.getUnreadCount(), settingsCreditsRepository.getCreditsState(), MutableStateFlow, new SettingsEntryViewModel$state$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getEagerly(), (Object) null);
        refresh();
    }

    public final StateFlow<SettingsEntryState> getState() {
        return this.state;
    }

    public final void onResume() {
        if (!this.hasResumed) {
            this.hasResumed = true;
        } else {
            refresh();
        }
    }

    public final void refresh() {
        MutableStateFlow<Integer> mutableStateFlow = this.languageRefresh;
        mutableStateFlow.setValue(Integer.valueOf(((Number) mutableStateFlow.getValue()).intValue() + 1));
        this.userInfoProvider.refresh();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsEntryViewModel$refresh$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsEntryState buildUiState(UserInfo userInfo, PayIdentity payIdentity, int unreadCount, SettingsCreditsState creditsState) {
        boolean isByteCloud = this.hostInfo.isByteCloud();
        boolean isEnterprise = this.hostInfo.isEnterprise();
        return new SettingsEntryState(userInfo.getDisplayName(), userInfo.getAccountText(), userInfo.getAvatarUrl(), SettingsThemeMode.INSTANCE.fromValue(this.hostInfo.getThemeMode()), (isByteCloud || isEnterprise || payIdentity == null) ? null : payIdentity.getBadgeText(), isEnterprise ? enterpriseBadge(userInfo.getProductType()) : null, isByteCloud, buildGroups(isByteCloud, creditsState), !isByteCloud, formatUnreadBadge(unreadCount, isByteCloud, isEnterprise), buildFooterState(), SettingsAboutStateFactory.INSTANCE.build(this.hostInfo));
    }

    private final List<SettingsGroup> buildGroups(boolean byteCloud, SettingsCreditsState creditsState) {
        ArrayList arrayList = new ArrayList();
        if (!byteCloud) {
            ArrayList arrayList2 = arrayList;
            List createListBuilder = CollectionsKt.createListBuilder();
            createListBuilder.add(item$default(this, SettingsItemKey.Account, null, false, false, false, 30, null));
            if (!this.hostInfo.isEnterprise()) {
                createListBuilder.add(item$default(this, SettingsItemKey.Message, null, false, false, false, 30, null));
            }
            SettingsItem settingsItem = toSettingsItem(creditsState);
            if (settingsItem != null) {
                createListBuilder.add(settingsItem);
            }
            arrayList2.add(new SettingsGroup(CollectionsKt.build(createListBuilder)));
        }
        ArrayList arrayList3 = arrayList;
        arrayList3.add(new SettingsGroup(CollectionsKt.listOf(new SettingsItem[]{item$default(this, SettingsItemKey.Language, this.hostInfo.getLanguageCode(), false, false, false, 28, null), item$default(this, SettingsItemKey.Notification, null, false, false, false, 30, null)})));
        List createListBuilder2 = CollectionsKt.createListBuilder();
        createListBuilder2.add(item$default(this, SettingsItemKey.DeviceManagement, null, false, false, false, 30, null));
        if (!byteCloud) {
            createListBuilder2.add(item$default(this, SettingsItemKey.Connectors, null, false, false, false, 30, null));
        }
        arrayList3.add(new SettingsGroup(CollectionsKt.build(createListBuilder2)));
        List createListBuilder3 = CollectionsKt.createListBuilder();
        if (!this.hostInfo.isIOS()) {
            createListBuilder3.add(item$default(this, SettingsItemKey.PrivacyPermission, null, false, false, false, 30, null));
        }
        arrayList3.add(new SettingsGroup(CollectionsKt.build(createListBuilder3)));
        List createListBuilder4 = CollectionsKt.createListBuilder();
        if (!this.hostInfo.isIOS() && this.hostInfo.isMainland()) {
            createListBuilder4.add(item$default(this, SettingsItemKey.Update, null, false, false, false, 30, null));
        }
        createListBuilder4.add(item$default(this, SettingsItemKey.About, null, false, false, false, 30, null));
        arrayList3.add(new SettingsGroup(CollectionsKt.build(createListBuilder4)));
        if (this.hostInfo.isDebug()) {
            arrayList3.add(new SettingsGroup(CollectionsKt.listOf(item$default(this, SettingsItemKey.Debug, this.debugPpeEnv, false, false, false, 28, null))));
        }
        arrayList3.add(new SettingsGroup(CollectionsKt.listOf(item$default(this, SettingsItemKey.Logout, null, true, false, false, 26, null))));
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((SettingsGroup) obj).getItems().isEmpty()) {
                arrayList4.add(obj);
            }
        }
        return arrayList4;
    }

    private final SettingsFooterState buildFooterState() {
        if (this.hostInfo.isMainland()) {
            return SettingsFooterState.INSTANCE;
        }
        return null;
    }

    static /* synthetic */ SettingsItem item$default(SettingsEntryViewModel settingsEntryViewModel, SettingsItemKey settingsItemKey, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            z = false;
        }
        return settingsEntryViewModel.item(settingsItemKey, str2, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? true : z3);
    }

    private final SettingsItem item(SettingsItemKey key, String trailing, boolean destructive, boolean clickable, boolean showTrailingIcon) {
        return new SettingsItem(key, trailing, destructive, clickable, showTrailingIcon);
    }

    private final SettingsItem toSettingsItem(SettingsCreditsState settingsCreditsState) {
        if (Intrinsics.areEqual(settingsCreditsState, SettingsCreditsState.Hidden.INSTANCE)) {
            return null;
        }
        if (Intrinsics.areEqual(settingsCreditsState, SettingsCreditsState.Loading.INSTANCE)) {
            return item$default(this, SettingsItemKey.Points, CREDITS_LOADING_TEXT, false, false, false, 4, null);
        }
        if (!(settingsCreditsState instanceof SettingsCreditsState.Visible)) {
            throw new NoWhenBranchMatchedException();
        }
        return item$default(this, SettingsItemKey.Points, ((SettingsCreditsState.Visible) settingsCreditsState).getBalanceText(), false, false, false, 4, null);
    }

    private final String formatUnreadBadge(int count, boolean bytecloud, boolean enterprise) {
        if (bytecloud || enterprise || count <= 0) {
            return null;
        }
        return count > 99 ? "99+" : String.valueOf(count);
    }

    private final SettingsEnterpriseBadge enterpriseBadge(int i) {
        if (i == SaaS_PRODUCT_TYPE_TEAM_GROUP || i == SaaS_PRODUCT_TYPE_TEAM_GROUP_V2) {
            return SettingsEnterpriseBadge.Team;
        }
        return SettingsEnterpriseBadge.Enterprise;
    }
}
