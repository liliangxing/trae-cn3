package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.BuildConfig;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutDestination;
import com.bytedance.trae.kmp.host.KmpHostEnvironment;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.kmp.network.KmpHostResolver;
import com.bytedance.trae.kmp.network.KmpHostType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SettingsEntryViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;", "", "<init>", "()V", "build", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "buildAboutItems", "", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;", "aboutWebItem", "key", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;", IWeixinService.ResponseConstants.URL, "", "webOrigin", DBData.FIELD_TYPE, "Lcom/bytedance/trae/kmp/network/KmpHostType;", "webQuery", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsAboutStateFactory {
    public static final int $stable = 0;
    public static final SettingsAboutStateFactory INSTANCE = new SettingsAboutStateFactory();

    private SettingsAboutStateFactory() {
    }

    public static /* synthetic */ SettingsAboutState build$default(SettingsAboutStateFactory settingsAboutStateFactory, KmpHostInfo kmpHostInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            kmpHostInfo = (KmpHostInfo) KmpHostEnvironment.INSTANCE;
        }
        return settingsAboutStateFactory.build(kmpHostInfo);
    }

    public final SettingsAboutState build(KmpHostInfo hostInfo) {
        Intrinsics.checkNotNullParameter(hostInfo, "hostInfo");
        String appVersionName = hostInfo.getAppVersionName();
        if (StringsKt.isBlank(appVersionName)) {
            appVersionName = "1.0.0";
        }
        return new SettingsAboutState(BuildConfig.APP_NAME, appVersionName, buildAboutItems(hostInfo));
    }

    private final List<SettingsAboutItem> buildAboutItems(KmpHostInfo hostInfo) {
        String str;
        String webOrigin = webOrigin(KmpHostType.Website, hostInfo);
        String webOrigin2 = webOrigin(KmpHostType.Docs, hostInfo);
        String webQuery = webQuery(hostInfo);
        List createListBuilder = CollectionsKt.createListBuilder();
        SettingsAboutStateFactory settingsAboutStateFactory = INSTANCE;
        createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.Terms, webOrigin + "/terms-of-service?" + webQuery));
        createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.Privacy, webOrigin + "/privacy-policy?" + webQuery));
        createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.OpenSource, webOrigin2 + "/solo/open-source-software-notice-for-trae-solo-mobile-android?" + webQuery));
        createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.Help, webOrigin2 + "/solo/what-is-trae-solo?" + webQuery));
        if (hostInfo.isMainland()) {
            createListBuilder.add(new SettingsAboutItem(SettingsAboutItemKey.Community, new SettingsAboutDestination.ExternalBrowser(settingsAboutStateFactory.webOrigin(KmpHostType.Community, hostInfo) + '/')));
        }
        SettingsAboutItemKey settingsAboutItemKey = SettingsAboutItemKey.Contact;
        if (hostInfo.isEnterprise()) {
            str = webOrigin2 + "/enterprise_contact-us";
        } else {
            str = webOrigin2 + "/solo/support?" + webQuery;
        }
        createListBuilder.add(settingsAboutStateFactory.aboutWebItem(settingsAboutItemKey, str));
        if (hostInfo.isMainland()) {
            createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.PersonalInfoList, webOrigin + "/h5/personal-collect"));
            createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.ShareList, webOrigin + "/h5/share-list"));
            createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.BusinessLicense, webOrigin + "/h5/business-license"));
            createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.IcpFiling, webOrigin + "/h5/icp-filing"));
            createListBuilder.add(settingsAboutStateFactory.aboutWebItem(SettingsAboutItemKey.PermissionUsage, webOrigin + "/h5/permission-usage-policy"));
        }
        return CollectionsKt.build(createListBuilder);
    }

    private final SettingsAboutItem aboutWebItem(SettingsAboutItemKey key, String url) {
        return new SettingsAboutItem(key, new SettingsAboutDestination.WebUrl(url));
    }

    private final String webOrigin(KmpHostType type, KmpHostInfo hostInfo) {
        String host = KmpHostResolver.INSTANCE.host(type, hostInfo);
        return StringsKt.isBlank(host) ? "" : "https://" + host;
    }

    private final String webQuery(KmpHostInfo hostInfo) {
        return "_lang=" + hostInfo.getLanguageCode() + "&platform=h5";
    }
}
