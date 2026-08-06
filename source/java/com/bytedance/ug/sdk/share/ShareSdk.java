package com.bytedance.ug.sdk.share;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback;
import com.bytedance.ug.sdk.share.api.depend.ShareConfig;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.api.panel.exposure.ExposedPanelContent;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ClipBoardCheckerManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.manager.TokenCheckerManager;
import com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.utils.MainThreadUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareSdk {
    public static void register(Application application) {
        ShareSdkManager.getInstance().register(application);
    }

    public static void init(Application application, ShareConfig shareConfig) {
        ShareSdkManager.getInstance().init(application, shareConfig);
    }

    public static ISharePanel showPanel(PanelContent panelContent) {
        return ShareSdkManager.getInstance().showPanel(panelContent);
    }

    public static void share(ExposedPanelContent exposedPanelContent) {
        ShareSdkManager.getInstance().share(exposedPanelContent);
    }

    public static List<IPanelItem> getPanelItems(String str) {
        return ShareSdkManager.getInstance().getPanelItems(str);
    }

    public static void preloadShareInfo(String str, String str2, ShareContent shareContent, JSONObject jSONObject, ShareInfoCallback shareInfoCallback) {
        String generateShareToken = shareContent.getShareTokenGenerator().generateShareToken(shareContent);
        shareContent.setShareToken(generateShareToken);
        ShareSdkManager.getInstance().getShareInfo(str, str2, generateShareToken, shareContent, jSONObject, shareInfoCallback);
    }

    public static void enterBackground(final Activity activity) {
        MainThreadUtils.runOnMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.ShareSdk.1
            @Override // java.lang.Runnable
            public void run() {
                ShareSdkManager.getInstance().enterBackground(activity);
            }
        });
    }

    public static void enterForeground(final Activity activity) {
        MainThreadUtils.runOnMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.ShareSdk.2
            @Override // java.lang.Runnable
            public void run() {
                ShareSdkManager.getInstance().enterForeground(activity);
            }
        });
    }

    public static void checkToken() {
        TokenCheckerManager.getInstance().checkToken();
    }

    public static void checkSelectedMediaToken(String str) {
        ShareConfigManager.getInstance().checkSelectedMediaToken(str);
    }

    public static void handleShareResultOnActivityResult(int i, int i2, Intent intent) {
        ShareSdkManager.getInstance().handleShareResultOnActivityResult(i, i2, intent);
    }

    public static String checkTextToken(String str) {
        return ClipBoardCheckerManager.inst().checkTextToken(str, false);
    }

    public static void parseTextToken(String str) {
        TokenParseManager.getInstance().translateCommand(str, 3);
    }

    public static void parseTextToken(String str, int i) {
        TokenParseManager.getInstance().translateCommand(str, i);
    }

    public static void parseTextToken(String str, int i, boolean z, TokenParseManager.TranslateCommandCallback translateCommandCallback) {
        TokenParseManager.getInstance().translateCommand(str, i, z, translateCommandCallback);
    }

    public static void LoadedTokenRuleLibrary() {
        ClipBoardCheckerManager.inst().tryParseNewRuleToken();
    }

    public static void reGetExtraConfig() {
        ShareConfigManager.getInstance().reGetExtraConfig();
    }

    public static boolean isSupportDYStory() {
        return ShareSdkManager.getInstance().isSupportDouYinStory();
    }

    public static boolean isSupportSetDYStoryBackGround() {
        return ShareSdkManager.getInstance().isSupportSetDYStoryBackGround();
    }

    public static boolean checkClipboardToken(String str, boolean z) {
        return ClipBoardCheckerManager.inst().checkClipboardTokenSelf(str, z);
    }
}
