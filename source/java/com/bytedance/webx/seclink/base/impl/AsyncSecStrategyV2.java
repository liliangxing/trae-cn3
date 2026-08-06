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
public class AsyncSecStrategyV2 extends AbsSecStrategy {
    private static final String TAG = "AsyncSecStrategyV2";
    private SecLinkCheckCallback callback;
    private String firstLoadUrl;
    private String mAid;
    private CheckRecord mLastRiskCheckResult;
    private String scene;
    private String urlFromOverride;
    private WebView webview;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private IBizInfoProvider mBizInfoProvider = null;
    private IWebEnvProvider mWebEnvProvider = null;
    private CheckUrlCallback checkUrlCallback = new CheckUrlCallback() { // from class: com.bytedance.webx.seclink.base.impl.AsyncSecStrategyV2.2
        @Override // com.bytedance.webx.seclink.request.CheckUrlCallback
        public void onSuccess(final String str, final CheckUrlResponse checkUrlResponse) {
            if (checkUrlResponse != null && AsyncSecStrategyV2.this.callback != null) {
                AsyncSecStrategyV2.this.callback.onGetSecLinkCheckResult(AsyncSecStrategyV2.this.webview, checkUrlResponse);
            }
            if (checkUrlResponse != null && checkUrlResponse.isNeedShowPage()) {
                AsyncSecStrategyV2.this.updateRiskCheckResult(str, checkUrlResponse);
                AsyncSecStrategyV2.this.mainHandler.post(new Runnable() { // from class: com.bytedance.webx.seclink.base.impl.AsyncSecStrategyV2.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (AsyncSecStrategyV2.this.webview == null || !str.equals(AsyncSecStrategyV2.this.urlFromOverride)) {
                                return;
                            }
                            AsyncSecStrategyV2.this.webview.loadUrl(SecLinkHelper.buildSecLinkMiddlePage(str, AsyncSecStrategyV2.this.mAid, AsyncSecStrategyV2.this.scene, AsyncSecStrategyV2.this.getExtraInfo(AsyncSecStrategyV2.this.scene, str), checkUrlResponse.getRisk(), Constants.STRATEGY_V2));
                        } catch (Exception e) {
                            Log.m50e(AsyncSecStrategyV2.TAG, "onSuccess Runnable ", e);
                            ExceptionUtil.handleException(e);
                        }
                    }
                });
            }
            Log.m51i(AsyncSecStrategyV2.TAG, "onSuccess url : " + str + ", response : " + checkUrlResponse);
        }

        @Override // com.bytedance.webx.seclink.request.CheckUrlCallback
        public void onFail(String str, String str2) {
            Log.m49e(AsyncSecStrategyV2.TAG, "onFail url : " + str + ", message : " + str2);
        }
    };

    public AsyncSecStrategyV2(WebView webView, String str, String str2) {
        this.webview = webView;
        this.scene = str2;
        this.mAid = str;
    }

    @Override // com.bytedance.webx.seclink.base.impl.AbsSecStrategy
    protected int needBuildSecLink(String str, String str2) {
        if (!SettingManager.isSafeCheckEnable(str2)) {
            Log.m48d(TAG, "needBuildSecLink:sec link switch is off by sdk setting");
            return 6;
        }
        return super.needBuildSecLink(str, str2);
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
        this.firstLoadUrl = null;
        this.urlFromOverride = null;
        this.mLastRiskCheckResult = null;
        Log.m48d(TAG, "prepare");
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public String handleLoadUrl(String str) {
        if (this.firstLoadUrl == null) {
            this.firstLoadUrl = str;
        }
        int needBuildSecLink = needBuildSecLink(str, this.scene);
        boolean useAsyncMode = SettingManager.getInstance().useAsyncMode(this.scene);
        ReportUtil.handleLoadUrl(str, this.scene, needBuildSecLink, Constants.STRATEGY_V2, !useAsyncMode ? 1 : 0);
        if (needBuildSecLink == 0) {
            this.urlFromOverride = str;
            updateRiskCheckResult(str, null);
            checkUrlSafely(str, getGrade(str), !useAsyncMode, true);
            Log.m48d(TAG, "handleLoadUrl : first force check :" + str);
        }
        return str;
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public void handleOverrideUrlLoading(String str) {
        Log.m48d(TAG, "handleOverrideUrlLoading :" + str);
        try {
            saveOverrideUrl(str);
            int needBuildSecLink = needBuildSecLink(str, this.scene);
            boolean useAsyncMode = SettingManager.getInstance().useAsyncMode(this.scene);
            boolean z = true;
            ReportUtil.handleOverrideUrlLoading(str, this.scene, needBuildSecLink, Constants.STRATEGY_V2, useAsyncMode ? 0 : 1);
            if (needBuildSecLink != 0) {
                return;
            }
            if (!SecLinkHelper.isEqual(getLastCheckUrl(), str)) {
                int grade = getGrade(str);
                if (useAsyncMode) {
                    z = false;
                }
                checkUrlSafely(str, grade, z, false);
            } else {
                CheckRecord checkRecord = this.mLastRiskCheckResult;
                if (checkRecord != null && checkRecord.getCheckResult() != null && this.mLastRiskCheckResult.getCheckResult().getRisk() == 9) {
                    int grade2 = getGrade(str);
                    if (useAsyncMode) {
                        z = false;
                    }
                    checkUrlSafely(str, grade2, z, false);
                }
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRiskCheckResult(String str, CheckUrlResponse checkUrlResponse) {
        if (this.mLastRiskCheckResult == null) {
            this.mLastRiskCheckResult = new CheckRecord();
        }
        this.mLastRiskCheckResult.setUrl(str);
        this.mLastRiskCheckResult.setCheckResult(checkUrlResponse);
    }

    private String getLastCheckUrl() {
        CheckRecord checkRecord = this.mLastRiskCheckResult;
        return checkRecord != null ? checkRecord.getUrl() : "";
    }

    @Override // com.bytedance.webx.seclink.base.ISecLinkStrategy
    public boolean syncHandleOverrideUrlLoading(String str) {
        int needBuildSecLink;
        try {
            saveOverrideUrl(str);
            needBuildSecLink = needBuildSecLink(str, this.scene);
            ReportUtil.handleOverrideUrlLoading(str, this.scene, needBuildSecLink, Constants.STRATEGY_V2, 1);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
        if (needBuildSecLink != 0) {
            return false;
        }
        if (!SecLinkHelper.isEqual(getLastCheckUrl(), str)) {
            return checkUrlSafely(str, getGrade(str), true, false);
        }
        CheckRecord checkRecord = this.mLastRiskCheckResult;
        if (checkRecord != null && checkRecord.getCheckResult() != null && this.mLastRiskCheckResult.getCheckResult().getRisk() == 9) {
            return checkUrlSafely(str, getGrade(str), true, false);
        }
        return false;
    }

    private void saveOverrideUrl(String str) {
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
        this.mLastRiskCheckResult = null;
        Log.m48d(TAG, "goBack skip two step");
        return true;
    }

    private boolean syncCheck(String str, int i, Map<String, Object> map, boolean z) {
        try {
            CheckUrlResponse checkUrlResponse = SecLinkHelper.checkUrlSafely(str, this.mAid, this.scene, i, map, z, Constants.STRATEGY_V2).get(SettingManager.getInstance().getSyncTimeOut(), TimeUnit.MILLISECONDS);
            SecLinkCheckCallback secLinkCheckCallback = this.callback;
            if (secLinkCheckCallback != null && checkUrlResponse != null) {
                secLinkCheckCallback.onGetSecLinkCheckResult(this.webview, checkUrlResponse);
            }
            if (checkUrlResponse != null && checkUrlResponse.success() && checkUrlResponse.isNeedShowPage()) {
                updateRiskCheckResult(str, checkUrlResponse);
                WebView webView = this.webview;
                String str2 = this.mAid;
                String str3 = this.scene;
                webView.loadUrl(SecLinkHelper.buildSecLinkMiddlePage(str, str2, str3, getExtraInfo(str3, str), checkUrlResponse.getRisk(), Constants.STRATEGY_V2));
                return true;
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
        return false;
    }

    private boolean checkUrlSafely(String str, int i, boolean z, boolean z2) {
        if (z) {
            return syncCheck(str, i, getExtraInfo(this.scene, str), z2);
        }
        asyncCheck(str, i, getExtraInfo(this.scene, str), z2);
        return false;
    }

    private void asyncCheck(final String str, final int i, final Map<String, Object> map, final boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mainHandler.postDelayed(new Runnable() { // from class: com.bytedance.webx.seclink.base.impl.AsyncSecStrategyV2.1
            @Override // java.lang.Runnable
            public void run() {
                if (str == null || AsyncSecStrategyV2.this.webview == null || !str.equals(AsyncSecStrategyV2.this.urlFromOverride)) {
                    return;
                }
                Log.m48d(AsyncSecStrategyV2.TAG, "checkUrlSafely : send seclink request :" + str);
                SecLinkHelper.checkUrlSafely(str, AsyncSecStrategyV2.this.mAid, AsyncSecStrategyV2.this.scene, i, map, Constants.STRATEGY_V2, AsyncSecStrategyV2.this.checkUrlCallback, z);
            }
        }, 100L);
    }

    private int getGrade(String str) {
        return SecLinkHelper.isEqual(this.firstLoadUrl, str) ? 1 : 3;
    }
}
