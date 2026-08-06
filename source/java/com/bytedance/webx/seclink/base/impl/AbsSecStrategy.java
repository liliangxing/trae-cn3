package com.bytedance.webx.seclink.base.impl;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.base.Constants;
import com.bytedance.webx.seclink.base.ISecLinkStrategy;
import com.bytedance.webx.seclink.cache.UrlSecLinkCache;
import com.bytedance.webx.seclink.request.CheckUrlResponse;
import com.bytedance.webx.seclink.request.CheckUrlSecManager;
import com.bytedance.webx.seclink.setting.SettingManager;
import com.bytedance.webx.seclink.util.Log;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.bytedance.webx.seclink.util.SecLinkHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbsSecStrategy implements ISecLinkStrategy {
    private static final String TAG = "AbsSecStrategy";
    protected static final int URL_STATE_CACHE_SAFE = 4;
    protected static final int URL_STATE_GLOBAL_DISABLE = 1;
    protected static final int URL_STATE_INVALID = 2;
    protected static final int URL_STATE_IN_ALLOWLIST = 3;
    protected static final int URL_STATE_IN_SHIELD = 5;
    protected static final int URL_STATE_NEED_CHECK = 0;
    protected static final int URL_STATE_SCENE_DISABLE = 6;

    /* JADX INFO: Access modifiers changed from: protected */
    public int needBuildSecLink(String str, String str2) {
        Log.m48d(TAG, "needBuildSecLink : " + str);
        if (!SecLinkFacade.isSafeLinkEnable()) {
            Log.m48d(TAG, "needBuildSecLink : seclink switch is off by client");
            return 1;
        }
        if (!SecLinkHelper.isValid(str, str2)) {
            Log.m48d(TAG, "needBuildSecLink : url is invalid.");
            return 2;
        }
        if (SecLinkFacade.containInAllowList(str)) {
            Log.m48d(TAG, "needBuildSecLink : url is in allowList.");
            return 3;
        }
        CheckUrlResponse validCache = UrlSecLinkCache.getInstance().getValidCache(str2, str);
        if (validCache != null && !validCache.isNeedShowPage()) {
            ReportUtil.hitCache(str, str2, getClass() == AsyncSecStrategyV2.class ? Constants.STRATEGY_V2 : Constants.STRATEGY_V1, false, "url_pre_check");
            Log.m48d(TAG, "needBuildSecLink : has cache and show safely");
            return 4;
        }
        if (!CheckUrlSecManager.getInstance().isShielding()) {
            return 0;
        }
        Log.m48d(TAG, "needBuildSecLink : seclink is shielding");
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canGoBackSkipBySecLink(WebView webView, boolean z) {
        WebBackForwardList copyBackForwardList;
        WebHistoryItem currentItem;
        WebHistoryItem itemAtIndex;
        if (SecLinkFacade.isSafeLinkEnable() && (copyBackForwardList = webView.copyBackForwardList()) != null && (currentItem = copyBackForwardList.getCurrentItem()) != null && SecLinkFacade.getLinkConfig() != null) {
            if (currentItem.getUrl().startsWith(getVerifyHost())) {
                return webView.canGoBackOrForward(-2);
            }
            if (copyBackForwardList.getSize() == 2 && (itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1)) != null && SecLinkHelper.startWithSecHost(itemAtIndex.getUrl())) {
                return webView.canGoBackOrForward(-2);
            }
        }
        return z;
    }

    private String getVerifyHost() {
        return SettingManager.getInstance().getVerifyHost();
    }
}
