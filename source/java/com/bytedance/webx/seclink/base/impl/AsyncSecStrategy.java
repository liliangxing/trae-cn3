package com.bytedance.webx.seclink.base.impl;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.base.CheckRecord;
import com.bytedance.webx.seclink.base.Constants;
import com.bytedance.webx.seclink.base.IBizInfoProvider;
import com.bytedance.webx.seclink.base.IWebEnvProvider;
import com.bytedance.webx.seclink.base.SecLinkCheckCallback;
import com.bytedance.webx.seclink.cache.UrlSecLinkCache;
import com.bytedance.webx.seclink.request.CheckUrlCallback;
import com.bytedance.webx.seclink.request.CheckUrlResponse;
import com.bytedance.webx.seclink.setting.SettingManager;
import com.bytedance.webx.seclink.util.ExceptionUtil;
import com.bytedance.webx.seclink.util.Log;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.bytedance.webx.seclink.util.SecLinkHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AsyncSecStrategy extends AbsSecStrategy {
    private static final String TAG = "AsyncSecStrategy";
    private SecLinkCheckCallback callback;
    private String firstLoadUrl;
    private String mAid;
    private CheckRecord mLastCheckResult;
    private String scene;
    private String urlFromOverride;
    private WebView webview;
    private boolean firstApiRequest = true;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private IBizInfoProvider mBizInfoProvider = null;
    private IWebEnvProvider mWebEnvProvider = null;
    private CheckUrlCallback checkUrlCallback = new CheckUrlCallback() { // from class: com.bytedance.webx.seclink.base.impl.AsyncSecStrategy.2
        @Override // com.bytedance.webx.seclink.request.CheckUrlCallback
        public void onSuccess(final String str, CheckUrlResponse checkUrlResponse) {
            if (checkUrlResponse != null && AsyncSecStrategy.this.callback != null) {
                AsyncSecStrategy.this.callback.onGetSecLinkCheckResult(AsyncSecStrategy.this.webview, checkUrlResponse);
            }
            if (checkUrlResponse != null && checkUrlResponse.isNeedShowPage()) {
                AsyncSecStrategy.this.updateCheckResult(str, checkUrlResponse);
                AsyncSecStrategy.this.mainHandler.post(new Runnable() { // from class: com.bytedance.webx.seclink.base.impl.AsyncSecStrategy.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (AsyncSecStrategy.this.webview != null && AsyncSecStrategy.this.webview != null && str.equals(AsyncSecStrategy.this.urlFromOverride)) {
                                AsyncSecStrategy.this.webview.loadUrl(SecLinkHelper.buildSecLink(str, AsyncSecStrategy.this.mAid, AsyncSecStrategy.this.scene, AsyncSecStrategy.this.getExtraInfo(AsyncSecStrategy.this.scene, str), Constants.STRATEGY_V1));
                            } else {
                                Log.m51i(AsyncSecStrategy.TAG, "onSuccess url is not same with current，task url: " + str + " urlFromOverride : " + AsyncSecStrategy.this.urlFromOverride);
                            }
                        } catch (Exception e) {
                            Log.m50e(AsyncSecStrategy.TAG, "onSuccess Runnable ", e);
                            ExceptionUtil.handleException(e);
                        }
                    }
                });
            }
            Log.m51i(AsyncSecStrategy.TAG, "onSuccess url : " + str + ", response : " + checkUrlResponse);
        }

        @Override // com.bytedance.webx.seclink.request.CheckUrlCallback
        public void onFail(String str, String str2) {
            Log.m49e(AsyncSecStrategy.TAG, "onFail url : " + str + ", message : " + str2);
        }
    };

    public AsyncSecStrategy(WebView webView, String str, String str2) {
        this.webview = webView;
        this.scene = str2;
        this.mAid = str;
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public void setScene(String str) {
        this.scene = str;
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public void setAid(String str) {
        this.mAid = str;
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public void setCheckCallback(SecLinkCheckCallback secLinkCheckCallback) {
        this.callback = secLinkCheckCallback;
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public void setBizInfoProvider(IBizInfoProvider iBizInfoProvider) {
        this.mBizInfoProvider = iBizInfoProvider;
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public void setWebEnvProvider(IWebEnvProvider iWebEnvProvider) {
        this.mWebEnvProvider = iWebEnvProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> getExtraInfo(String str, String str2) {
        IBizInfoProvider iBizInfoProvider = this.mBizInfoProvider;
        Map<String, Object> bizInfo = iBizInfoProvider != null ? iBizInfoProvider.bizInfo(str, str2) : null;
        Map<String, Object> bizInfo2 = SecLinkFacade.getBizInfoProvider() != null ? SecLinkFacade.getBizInfoProvider().bizInfo(str, str2) : null;
        if (bizInfo == null || bizInfo.size() <= 0) {
            bizInfo = bizInfo2;
        } else if (bizInfo2 != null && bizInfo2.size() > 0) {
            for (Map.Entry<String, Object> entry : bizInfo2.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null && !bizInfo.containsKey(key)) {
                    bizInfo.put(key, value);
                }
            }
        }
        IWebEnvProvider iWebEnvProvider = this.mWebEnvProvider;
        if (iWebEnvProvider != null && iWebEnvProvider.webEnv(str, str2) != null) {
            if (bizInfo == null) {
                bizInfo = new HashMap<>();
            }
            Map<String, Object> webEnv = this.mWebEnvProvider.webEnv(str, str2);
            for (String str3 : webEnv.keySet()) {
                Object obj = webEnv.get(str3);
                if (!TextUtils.isEmpty(str3) && obj != null && !bizInfo.containsKey(str3)) {
                    bizInfo.put(str3, obj);
                }
            }
        }
        return bizInfo;
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    @Deprecated
    public void prepare() {
        this.firstApiRequest = true;
        this.firstLoadUrl = null;
        this.urlFromOverride = null;
        this.mLastCheckResult = null;
        Log.m48d(TAG, "prepare");
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public String handleLoadUrl(String str) {
        this.firstLoadUrl = str;
        updateCheckResult(str, null);
        int needBuildSecLink = needBuildSecLink(str, this.scene);
        ReportUtil.handleLoadUrl(str, this.scene, needBuildSecLink, Constants.STRATEGY_V1, 2);
        if (needBuildSecLink == 0) {
            String str2 = this.mAid;
            String str3 = this.scene;
            str = SecLinkHelper.buildSecLink(str, str2, str3, getExtraInfo(str3, str), Constants.STRATEGY_V1);
            Log.m48d(TAG, "handleLoadUrl : first force check :" + str);
        }
        this.firstApiRequest = true;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckResult(String str, CheckUrlResponse checkUrlResponse) {
        if (this.mLastCheckResult == null) {
            this.mLastCheckResult = new CheckRecord();
        }
        this.mLastCheckResult.setUrl(str);
        this.mLastCheckResult.setCheckResult(checkUrlResponse);
    }

    private String getLastCheckUrl() {
        CheckRecord checkRecord = this.mLastCheckResult;
        return checkRecord != null ? checkRecord.getUrl() : "";
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public void handleOverrideUrlLoading(String str) {
        Log.m48d(TAG, "handleOverrideUrlLoading :" + str);
        try {
            prepareCheck(str);
            int needBuildSecLink = needBuildSecLink(str, this.scene);
            ReportUtil.handleOverrideUrlLoading(str, this.scene, needBuildSecLink, Constants.STRATEGY_V1, 0);
            if (needBuildSecLink != 0) {
                return;
            }
            if (!SecLinkHelper.isEqual(getLastCheckUrl(), str)) {
                checkUrlSafely(str, getGrade(str));
            } else {
                CheckRecord checkRecord = this.mLastCheckResult;
                if (checkRecord != null && checkRecord.getCheckResult() != null && this.mLastCheckResult.getCheckResult().getRisk() == 9) {
                    checkUrlSafely(str, getGrade(str));
                }
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public boolean syncHandleOverrideUrlLoading(String str) {
        int needBuildSecLink;
        try {
            prepareCheck(str);
            needBuildSecLink = needBuildSecLink(str, this.scene);
            ReportUtil.handleOverrideUrlLoading(str, this.scene, needBuildSecLink, Constants.STRATEGY_V1, 1);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
        if (needBuildSecLink != 0) {
            return false;
        }
        if (!SecLinkHelper.isEqual(getLastCheckUrl(), str)) {
            return checkUrlSafely(str, getGrade(str), true);
        }
        CheckRecord checkRecord = this.mLastCheckResult;
        if (checkRecord != null && checkRecord.getCheckResult() != null && this.mLastCheckResult.getCheckResult().getRisk() == 9) {
            return checkUrlSafely(str, getGrade(str), true);
        }
        return false;
    }

    private void prepareCheck(String str) {
        if (SecLinkHelper.isEqual(getLastCheckUrl(), str) && SecLinkHelper.isEqual(this.firstLoadUrl, str)) {
            CheckUrlResponse checkUrlResponse = new CheckUrlResponse(str);
            checkUrlResponse.setNeedShowPage(false);
            checkUrlResponse.setRisk(0);
            UrlSecLinkCache.getInstance().saveCache(this.scene, str, checkUrlResponse);
            Log.m48d(TAG, "handleLoadUrl save first check in cache :" + str);
        }
        if (SecLinkHelper.isValid(str, this.scene)) {
            this.urlFromOverride = str;
        }
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public boolean canGoBack() {
        return canGoBackSkipBySecLink(this.webview, true);
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public boolean handleGoBack() {
        if (!canGoBackSkipBySecLink(this.webview, false)) {
            return false;
        }
        this.webview.goBackOrForward(-2);
        Log.m48d(TAG, "goBack skip two step");
        this.mLastCheckResult = null;
        return true;
    }

    private boolean syncCheck(String str, int i, Map<String, Object> map) {
        try {
            CheckUrlResponse checkUrlResponse = SecLinkHelper.checkUrlSafely(str, this.mAid, this.scene, i, map, true, Constants.STRATEGY_V1).get(SettingManager.getInstance().getSyncTimeOut(), TimeUnit.MILLISECONDS);
            SecLinkCheckCallback secLinkCheckCallback = this.callback;
            if (secLinkCheckCallback != null && checkUrlResponse != null) {
                secLinkCheckCallback.onGetSecLinkCheckResult(this.webview, checkUrlResponse);
            }
            if (checkUrlResponse.success() && checkUrlResponse.isNeedShowPage()) {
                updateCheckResult(str, checkUrlResponse);
                WebView webView = this.webview;
                String str2 = this.mAid;
                String str3 = this.scene;
                webView.loadUrl(SecLinkHelper.buildSecLinkMiddlePage(str, str2, str3, getExtraInfo(str3, str), checkUrlResponse.getRisk(), Constants.STRATEGY_V1));
                Log.m51i(TAG, "onSuccess url : " + str + ", response : " + checkUrlResponse);
                return true;
            }
            Log.m49e(TAG, "onFail url : " + str);
            return false;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    private boolean checkUrlSafely(String str, int i) {
        return checkUrlSafely(str, i, false);
    }

    private boolean checkUrlSafely(String str, int i, boolean z) {
        CheckUrlResponse validCache = UrlSecLinkCache.getInstance().getValidCache(this.scene, str);
        if (validCache == null && needBuildSecLink(str, this.scene) == 0) {
            if (z) {
                return syncCheck(str, i, getExtraInfo(this.scene, str));
            }
            asyncCheck(str, i, getExtraInfo(this.scene, str));
            return false;
        }
        if (validCache != null) {
            SecLinkCheckCallback secLinkCheckCallback = this.callback;
            if (secLinkCheckCallback != null) {
                secLinkCheckCallback.onGetSecLinkCheckResult(this.webview, validCache);
            }
            ReportUtil.hitCache(str, this.scene, Constants.STRATEGY_V1, validCache.isNeedShowPage(), "url_verify");
            if (validCache.isNeedShowPage()) {
                updateCheckResult(str, validCache);
                Log.m48d(TAG, "checkUrlSafely : jump seclink page directly : " + str);
                this.webview.loadUrl(SecLinkHelper.buildSecLink(str, this.mAid, this.scene, Constants.STRATEGY_V1));
                return true;
            }
            Log.m48d(TAG, "checkUrlSafely : safe url : " + str);
        }
        return false;
    }

    private void asyncCheck(final String str, final int i, Map<String, Object> map) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.bytedance.webx.seclink.base.impl.AsyncSecStrategy.1
            @Override // java.lang.Runnable
            public void run() {
                if (str != null && AsyncSecStrategy.this.webview != null && str.equals(AsyncSecStrategy.this.urlFromOverride)) {
                    Log.m48d(AsyncSecStrategy.TAG, "checkUrlSafely : send seclink request :" + str);
                    String str2 = str;
                    String str3 = AsyncSecStrategy.this.mAid;
                    String str4 = AsyncSecStrategy.this.scene;
                    int i2 = i;
                    AsyncSecStrategy asyncSecStrategy = AsyncSecStrategy.this;
                    SecLinkHelper.checkUrlSafely(str2, str3, str4, i2, asyncSecStrategy.getExtraInfo(asyncSecStrategy.scene, str), Constants.STRATEGY_V1, AsyncSecStrategy.this.checkUrlCallback, false);
                    return;
                }
                Log.m51i(AsyncSecStrategy.TAG, "checkUrlSafely url is not same with current task: " + str + "  urlFromOverride : " + AsyncSecStrategy.this.urlFromOverride);
            }
        }, 100L);
    }

    private int getGrade(String str) {
        if (SecLinkHelper.isEqual(this.firstLoadUrl, str)) {
            return 1;
        }
        if (!this.firstApiRequest) {
            return 3;
        }
        this.firstApiRequest = false;
        return 2;
    }
}
