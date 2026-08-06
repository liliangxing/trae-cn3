package com.bytedance.trae.conversation.share;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.ug.sdk.share.ShareSdk;
import com.bytedance.ug.sdk.share.api.depend.IShareLifecycleConfig;
import com.bytedance.ug.sdk.share.api.depend.ShareConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* compiled from: SharePanelService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/share/SharePanelService;", "", "<init>", "()V", "TAG", "", "init", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SharePanelService {
    private final String TAG = "SharePanelService";

    public final void init() {
        String str;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
            str = "";
        }
        String string = Keva.getRepo(str + "share").getString("weixin", "");
        ShareConfig build = new ShareConfig.Builder().setAppConfig(new ShareAppConfigImpl()).setEventConfig(new ShareEventConfigImpl()).setLifecycleConfig((IShareLifecycleConfig) null).setPermissionConfig(new SharePermissionConfigImpl()).setKeyConfig(new ShareKeyConfigImpl(null, 1, null)).setNetworkConfig(new ShareNetworkImpl()).setUIConfig(new ShareUIConfigImpl()).setBoe(false).setDebug(true).build();
        if (!TextUtils.isEmpty(string)) {
            ShareKeyConfigImpl.INSTANCE.setWEIXIN_KEY_AVAILABLE(true);
        }
        ShareSdk.init(AppHost.INSTANCE.getApplication(), build);
    }
}
