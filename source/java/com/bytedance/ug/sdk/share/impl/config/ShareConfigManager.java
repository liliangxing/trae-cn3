package com.bytedance.ug.sdk.share.impl.config;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.callback.IFrameDecodeListener;
import com.bytedance.ug.sdk.share.api.callback.OnDownloadListener;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.depend.IShareAppConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareAsyncThreadConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareClipboardConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareDownloadConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareEventConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareImageConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareImageTokenConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareInterceptConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareKeyConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareLifecycleConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareNetworkConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareNewRuleConfig;
import com.bytedance.ug.sdk.share.api.depend.ISharePermissionConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareQrScanConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareSpConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareTokenConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareUIConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareVideoFrameConfig;
import com.bytedance.ug.sdk.share.api.depend.IShareVideoWmConfig;
import com.bytedance.ug.sdk.share.api.depend.ShareConfig;
import com.bytedance.ug.sdk.share.api.entity.RecognizeDialogClickType;
import com.bytedance.ug.sdk.share.api.entity.ShareConstant;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareMonitorEvent;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.entity.VideoOptions;
import com.bytedance.ug.sdk.share.api.p008ui.IAdditionalRecognizeTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IRecognizeTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IShareProgressView;
import com.bytedance.ug.sdk.share.api.p008ui.IShareTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.ISystemOptShareTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoGuideDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoShareDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.check.CheckManager;
import com.bytedance.ug.sdk.share.impl.constant.ShareConfigConstants;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.manager.AdditionalTokenDialogManager;
import com.bytedance.ug.sdk.share.impl.manager.DependManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.network.thread.ThreadPlus;
import com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.utils.ActivityStack;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareConfigManager {
    private static final String TAG = "ShareConfigManager";
    private IShareImageTokenConfig iImageTokenConfig;
    private IShareAppConfig mAppConfig;
    private JSONObject mAppExtraConfig;
    private IShareAsyncThreadConfig mAsyncThreadConfig;
    private IShareClipboardConfig mClipboardConfig;
    private String mDingDingKey;
    private String mDouYinKey;
    private IShareDownloadConfig mDownloadConfig;
    private String mDuoShanKey;
    private boolean mEnableServerAlbumParse;
    private boolean mEnableServerHiddenWatermark;
    private boolean mEnableServerQrcodeParse;
    private boolean mEnableServerTextTokenParse;
    private boolean mEnableServerVideoHiddenMark;
    private boolean mEnableServerVideoQrcodeParse;
    private IShareEventConfig mEventConfig;
    private String mFacebookKey;
    private String mFeiLiaoKey;
    private IShareImageConfig mImageConfig;
    private IShareInterceptConfig mInterceptConfig;
    private JSONObject mInterceptExtraConfig;
    private boolean mIsBoe;
    private boolean mIsDebug;
    private boolean mIsLocalMode;
    private IShareKeyConfig mKeyConfig;
    private IShareLifecycleConfig mLifecycleConfig;
    private String mMessengerKey;
    private IShareNetworkConfig mNetworkConfig;
    private IShareNewRuleConfig mNewRuleConfig;
    private ISharePermissionConfig mPermissionConfig;
    private String mQQKey;
    private IShareQrScanConfig mQrScanConfig;
    private IShareSpConfig mSpConfig;
    private JSONObject mThirdKeys;
    private String mTikTokKey;
    private IShareTokenConfig mTokenConfig;
    private String mToutiaoKey;
    private String mToutiaoSource;
    private String mTwitterKey;
    private String mTwitterSecret;
    private IShareUIConfig mUIConfig;
    private IShareVideoFrameConfig mVideoFrameConfig;
    private IShareVideoWmConfig mVideoWatermarkConfig;
    private String mWeChatKey;
    private String mWeiboDirectUrl;
    private String mWeiboKey;
    private String mWeiboScope;
    private String mZhifubaoKey;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Singleton {
        private static ShareConfigManager sInstance = new ShareConfigManager();

        private Singleton() {
        }
    }

    private ShareConfigManager() {
        this.mEnableServerAlbumParse = true;
        this.mEnableServerQrcodeParse = true;
        this.mEnableServerHiddenWatermark = true;
        this.mEnableServerTextTokenParse = true;
        this.mEnableServerVideoHiddenMark = true;
        this.mEnableServerVideoQrcodeParse = true;
        this.mIsLocalMode = false;
        this.mIsBoe = false;
    }

    public static ShareConfigManager getInstance() {
        return Singleton.sInstance;
    }

    public void init(ShareConfig shareConfig) {
        CheckManager.getInstance().checkConfig(shareConfig);
        if (shareConfig != null) {
            this.mImageConfig = shareConfig.getImageConfig();
            this.mPermissionConfig = shareConfig.getPermissionConfig();
            this.mKeyConfig = shareConfig.getKeyConfig();
            this.mNetworkConfig = shareConfig.getNetworkConfig();
            this.mAsyncThreadConfig = shareConfig.getAsyncThreadConfig();
            this.mClipboardConfig = shareConfig.getClipboardConfig();
            this.mAppConfig = shareConfig.getAppConfig();
            this.mNewRuleConfig = shareConfig.getNewRuleConfig();
            this.mLifecycleConfig = shareConfig.getLifecycleConfig();
            this.mDownloadConfig = shareConfig.getDownloadConfig();
            this.mQrScanConfig = shareConfig.getQrScanConfig();
            this.mVideoWatermarkConfig = shareConfig.getVideoWatermarkConfig();
            this.mVideoFrameConfig = shareConfig.getVideoFrameConfig();
            this.iImageTokenConfig = shareConfig.getImageTokenConfig();
            this.mEventConfig = shareConfig.getEventConfig();
            this.mUIConfig = shareConfig.getUIConfig();
            this.mTokenConfig = shareConfig.getTokenConfig();
            this.mSpConfig = shareConfig.getSpConfig();
            if (shareConfig.isDebug()) {
                this.mIsDebug = true;
                Logger.setLogLevel(2);
                ToastUtils.isDebug = true;
            }
            this.mIsLocalMode = shareConfig.isLocalMode();
            this.mIsBoe = shareConfig.isBoe();
        }
    }

    public boolean hasPermission(Context context, String str) {
        ISharePermissionConfig iSharePermissionConfig = this.mPermissionConfig;
        if (iSharePermissionConfig != null) {
            return iSharePermissionConfig.hasPermission(context, str);
        }
        return false;
    }

    public void requestPermissions(Activity activity, String[] strArr, ShareContent shareContent, RequestPermissionsCallback requestPermissionsCallback) {
        ISharePermissionConfig iSharePermissionConfig = this.mPermissionConfig;
        if (iSharePermissionConfig != null) {
            iSharePermissionConfig.requestPermissions(activity, strArr, shareContent, requestPermissionsCallback);
        }
    }

    public String getKeyStr(String str) {
        IShareKeyConfig iShareKeyConfig;
        try {
            if (this.mThirdKeys == null && (iShareKeyConfig = this.mKeyConfig) != null) {
                this.mThirdKeys = iShareKeyConfig.getKeys();
            }
            JSONObject jSONObject = this.mThirdKeys;
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString(str);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return optString;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public JSONObject getKeyJsonObject(String str) {
        IShareKeyConfig iShareKeyConfig;
        try {
            if (this.mThirdKeys == null && (iShareKeyConfig = this.mKeyConfig) != null) {
                this.mThirdKeys = iShareKeyConfig.getKeys();
            }
            JSONObject jSONObject = this.mThirdKeys;
            if (jSONObject != null) {
                return jSONObject.optJSONObject(str);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getWeChatKey() {
        if (!TextUtils.isEmpty(this.mWeChatKey)) {
            return this.mWeChatKey;
        }
        String keyStr = getKeyStr(ShareConstant.WECHAT);
        this.mWeChatKey = keyStr;
        return keyStr;
    }

    public String getQQKey() {
        if (!TextUtils.isEmpty(this.mQQKey)) {
            return this.mQQKey;
        }
        String keyStr = getKeyStr(ShareConstant.f153QQ);
        this.mQQKey = keyStr;
        return keyStr;
    }

    public String getDingDingKey() {
        if (!TextUtils.isEmpty(this.mDingDingKey)) {
            return this.mDingDingKey;
        }
        String keyStr = getKeyStr(ShareConstant.f149DD);
        this.mDingDingKey = keyStr;
        return keyStr;
    }

    public String getDouYinKey() {
        if (!TextUtils.isEmpty(this.mDouYinKey)) {
            return this.mDouYinKey;
        }
        String keyStr = getKeyStr("douyin");
        this.mDouYinKey = keyStr;
        return keyStr;
    }

    public String getTikTokKey() {
        if (!TextUtils.isEmpty(this.mTikTokKey)) {
            return this.mTikTokKey;
        }
        String keyStr = getKeyStr(ShareConstant.TIKTOK);
        this.mTikTokKey = keyStr;
        return keyStr;
    }

    public String getWeiboKey() {
        if (!TextUtils.isEmpty(this.mWeiboKey)) {
            return this.mWeiboKey;
        }
        JSONObject keyJsonObject = getKeyJsonObject(ShareConstant.f155WB);
        if (keyJsonObject == null) {
            return null;
        }
        String optString = keyJsonObject.optString("key");
        this.mWeiboKey = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mWeiboKey;
    }

    public String getWeiboDirectUrl() {
        if (!TextUtils.isEmpty(this.mWeiboDirectUrl)) {
            return this.mWeiboDirectUrl;
        }
        JSONObject keyJsonObject = getKeyJsonObject(ShareConstant.f155WB);
        if (keyJsonObject == null) {
            return null;
        }
        String optString = keyJsonObject.optString("direct_url");
        this.mWeiboDirectUrl = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mWeiboDirectUrl;
    }

    public String getWeiboScope() {
        if (!TextUtils.isEmpty(this.mWeiboScope)) {
            return this.mWeiboScope;
        }
        JSONObject keyJsonObject = getKeyJsonObject(ShareConstant.f155WB);
        if (keyJsonObject == null) {
            return null;
        }
        String optString = keyJsonObject.optString("scope");
        this.mWeiboScope = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mWeiboScope;
    }

    public String getTwitterKey() {
        if (!TextUtils.isEmpty(this.mTwitterKey)) {
            return this.mTwitterKey;
        }
        JSONObject keyJsonObject = getKeyJsonObject(ShareConstant.TWITTER);
        if (keyJsonObject == null) {
            return null;
        }
        String optString = keyJsonObject.optString("key");
        this.mTwitterKey = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mTwitterKey;
    }

    public String getTwitterSecret() {
        if (!TextUtils.isEmpty(this.mTwitterSecret)) {
            return this.mTwitterSecret;
        }
        JSONObject keyJsonObject = getKeyJsonObject(ShareConstant.TWITTER);
        if (keyJsonObject == null) {
            return null;
        }
        String optString = keyJsonObject.optString("secret");
        this.mTwitterSecret = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mTwitterSecret;
    }

    public String getFeiLiaoKey() {
        if (!TextUtils.isEmpty(this.mFeiLiaoKey)) {
            return this.mFeiLiaoKey;
        }
        String keyStr = getKeyStr(ShareConstant.f152FL);
        this.mFeiLiaoKey = keyStr;
        return keyStr;
    }

    @Deprecated
    public String getDuoShanKey() {
        if (!TextUtils.isEmpty(this.mDuoShanKey)) {
            return this.mDuoShanKey;
        }
        String keyStr = getKeyStr(ShareConstant.f150DS);
        this.mDuoShanKey = keyStr;
        return keyStr;
    }

    public String getFacebookKey() {
        if (!TextUtils.isEmpty(this.mFacebookKey)) {
            return this.mFacebookKey;
        }
        String keyStr = getKeyStr(ShareConstant.FACEBOOK);
        this.mFacebookKey = keyStr;
        return keyStr;
    }

    public String getMessengerKey() {
        if (!TextUtils.isEmpty(this.mMessengerKey)) {
            return this.mMessengerKey;
        }
        String keyStr = getKeyStr(ShareConstant.MESSENGER);
        this.mMessengerKey = keyStr;
        return keyStr;
    }

    public String getToutiaoKey() {
        if (!TextUtils.isEmpty(this.mToutiaoKey)) {
            return this.mToutiaoKey;
        }
        JSONObject keyJsonObject = getKeyJsonObject(ShareConstant.TOUTIAO);
        if (keyJsonObject == null) {
            return null;
        }
        String optString = keyJsonObject.optString("key");
        this.mToutiaoKey = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mToutiaoKey;
    }

    public String getToutiaoSource() {
        if (!TextUtils.isEmpty(this.mToutiaoSource)) {
            return this.mToutiaoSource;
        }
        JSONObject keyJsonObject = getKeyJsonObject(ShareConstant.TOUTIAO);
        if (keyJsonObject == null) {
            return null;
        }
        String optString = keyJsonObject.optString(EventConstants.PARAM_SOURCE);
        this.mToutiaoSource = optString;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mToutiaoSource;
    }

    public String getZhifubaoKey() {
        if (!TextUtils.isEmpty(this.mZhifubaoKey)) {
            return this.mZhifubaoKey;
        }
        String keyStr = getKeyStr(ShareConstant.ZHIFUBAO);
        this.mZhifubaoKey = keyStr;
        return keyStr;
    }

    public String getHost() {
        IShareNetworkConfig iShareNetworkConfig = this.mNetworkConfig;
        if (iShareNetworkConfig != null) {
            return iShareNetworkConfig.getHost();
        }
        return null;
    }

    public boolean isBoe() {
        return this.mIsBoe;
    }

    public String executeGet(int i, String str) throws Exception {
        IShareInterceptConfig iShareInterceptConfig = this.mInterceptConfig;
        if (iShareInterceptConfig != null && iShareInterceptConfig.interceptNetwork(str)) {
            return this.mInterceptConfig.executeGet(i, str);
        }
        IShareNetworkConfig iShareNetworkConfig = this.mNetworkConfig;
        if (iShareNetworkConfig != null) {
            return iShareNetworkConfig.executeGet(i, str);
        }
        return null;
    }

    public String executePost(int i, String str, JSONObject jSONObject) throws Exception {
        IShareInterceptConfig iShareInterceptConfig = this.mInterceptConfig;
        if (iShareInterceptConfig != null && iShareInterceptConfig.interceptNetwork(str)) {
            return this.mInterceptConfig.executePost(i, str, jSONObject);
        }
        IShareNetworkConfig iShareNetworkConfig = this.mNetworkConfig;
        if (iShareNetworkConfig != null) {
            return iShareNetworkConfig.executePost(i, str, jSONObject);
        }
        return null;
    }

    public int checkResponseException(Throwable th) {
        IShareNetworkConfig iShareNetworkConfig = this.mNetworkConfig;
        if (iShareNetworkConfig != null) {
            return iShareNetworkConfig.checkResponseException(th);
        }
        return -1;
    }

    public void setInterceptConfig(IShareInterceptConfig iShareInterceptConfig) {
        this.mInterceptConfig = iShareInterceptConfig;
        if (iShareInterceptConfig != null) {
            TokenParseManager.getInstance().parseWaitToken();
        }
    }

    public IShareInterceptConfig getInterceptConfig() {
        return this.mInterceptConfig;
    }

    public void execute(Runnable runnable) {
        IShareAsyncThreadConfig iShareAsyncThreadConfig = this.mAsyncThreadConfig;
        if (iShareAsyncThreadConfig != null) {
            iShareAsyncThreadConfig.execute(runnable);
        } else {
            ThreadPlus.submitRunnable(runnable);
        }
    }

    public void executeWithSingleThread(Runnable runnable) {
        IShareAsyncThreadConfig iShareAsyncThreadConfig = this.mAsyncThreadConfig;
        if (iShareAsyncThreadConfig != null) {
            iShareAsyncThreadConfig.executeWithSingleThread(runnable);
        } else {
            ThreadPlus.submitRunnable(runnable);
        }
    }

    public IShareClipboardConfig getClipboardConfig() {
        return this.mClipboardConfig;
    }

    public void getImageBitmap(final String str, final GetImageCallback getImageCallback) {
        if (this.mImageConfig != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            this.mImageConfig.getImageBitmap(str, new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.impl.config.ShareConfigManager.1
                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onSuccess(Bitmap bitmap) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        GetImageCallback getImageCallback2 = getImageCallback;
                        if (getImageCallback2 != null) {
                            getImageCallback2.onFailed();
                        }
                        MonitorEvent.monitorShareImageDownload(1, str, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    }
                    GetImageCallback getImageCallback3 = getImageCallback;
                    if (getImageCallback3 != null) {
                        getImageCallback3.onSuccess(bitmap);
                    }
                    MonitorEvent.monitorShareImageDownload(0, str, System.currentTimeMillis() - currentTimeMillis);
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onFailed() {
                    GetImageCallback getImageCallback2 = getImageCallback;
                    if (getImageCallback2 != null) {
                        getImageCallback2.onFailed();
                    }
                    MonitorEvent.monitorShareImageDownload(1, str, System.currentTimeMillis() - currentTimeMillis);
                }
            });
        }
    }

    public void onAppLogEvent(String str, JSONObject jSONObject) {
        IShareEventConfig iShareEventConfig = this.mEventConfig;
        if (iShareEventConfig != null) {
            iShareEventConfig.onAppLogEvent(str, jSONObject);
        }
    }

    public void onMonitorInit(Context context, String str, JSONObject jSONObject, List<String> list, List<String> list2) {
        IShareEventConfig iShareEventConfig = this.mEventConfig;
        if (iShareEventConfig != null) {
            iShareEventConfig.onSDKMonitorInit(context, str, jSONObject, list, list2);
        }
    }

    public void onMonitorEvent(String str, ShareMonitorEvent shareMonitorEvent) {
        IShareEventConfig iShareEventConfig = this.mEventConfig;
        if (iShareEventConfig != null) {
            iShareEventConfig.onSDKMonitorEvent(str, shareMonitorEvent);
        }
    }

    public void onALogEvent(int i, String str, String str2) {
        IShareEventConfig iShareEventConfig = this.mEventConfig;
        if (iShareEventConfig != null) {
            iShareEventConfig.onALogEvent(i, str, str2);
        }
    }

    public void openPage(Context context, String str) {
        IShareAppConfig iShareAppConfig = this.mAppConfig;
        if (iShareAppConfig != null) {
            iShareAppConfig.openPage(context, str);
        }
    }

    public String getAppId() {
        IShareAppConfig iShareAppConfig = this.mAppConfig;
        if (iShareAppConfig != null) {
            return iShareAppConfig.getAppId();
        }
        return null;
    }

    public String getDeviceId() {
        IShareAppConfig iShareAppConfig = this.mAppConfig;
        if (iShareAppConfig != null) {
            return iShareAppConfig.getDeviceId();
        }
        return null;
    }

    public boolean isLoadedNewRuleLibrary() {
        IShareNewRuleConfig iShareNewRuleConfig = this.mNewRuleConfig;
        if (iShareNewRuleConfig != null) {
            return iShareNewRuleConfig.isLoadedNewRuleLibrary();
        }
        return false;
    }

    public String getPackageName() {
        Activity topActivity = getTopActivity();
        if (topActivity != null) {
            return topActivity.getPackageName();
        }
        return null;
    }

    public Activity getTopActivity() {
        IShareLifecycleConfig iShareLifecycleConfig;
        Activity topActivity = ActivityStack.getTopActivity();
        return (topActivity != null || (iShareLifecycleConfig = this.mLifecycleConfig) == null) ? topActivity : iShareLifecycleConfig.getTopActivity();
    }

    public void downloadFile(ShareContent shareContent, String str, String str2, String str3, OnDownloadListener onDownloadListener) {
        IShareDownloadConfig iShareDownloadConfig = this.mDownloadConfig;
        if (iShareDownloadConfig != null) {
            iShareDownloadConfig.onDownloadFile(shareContent, str, str2, str3, onDownloadListener);
        }
    }

    public void cancelDownload(ShareContent shareContent, String str, String str2, String str3) {
        IShareDownloadConfig iShareDownloadConfig = this.mDownloadConfig;
        if (iShareDownloadConfig != null) {
            iShareDownloadConfig.onCancelDownload(shareContent, str, str2, str3);
        }
    }

    public Object getExtraConfigByKey(String str, Object obj) {
        JSONObject jSONObject;
        IShareAppConfig iShareAppConfig;
        IShareInterceptConfig iShareInterceptConfig;
        try {
            if (this.mInterceptExtraConfig == null && (iShareInterceptConfig = this.mInterceptConfig) != null) {
                this.mInterceptExtraConfig = iShareInterceptConfig.getExtraConfig();
            }
            jSONObject = this.mInterceptExtraConfig;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (jSONObject != null && jSONObject.has(str)) {
            return this.mInterceptExtraConfig.opt(str);
        }
        if (this.mAppExtraConfig == null && (iShareAppConfig = this.mAppConfig) != null) {
            this.mAppExtraConfig = iShareAppConfig.getExtraConfig();
        }
        JSONObject jSONObject2 = this.mAppExtraConfig;
        if (jSONObject2 != null && jSONObject2.has(str)) {
            return this.mAppExtraConfig.opt(str);
        }
        return obj;
    }

    public void reGetExtraConfig() {
        IShareAppConfig iShareAppConfig = this.mAppConfig;
        if (iShareAppConfig != null) {
            this.mAppExtraConfig = iShareAppConfig.getExtraConfig();
        }
    }

    public int getDownloadSuccessShareDelay() {
        return ((Integer) getExtraConfigByKey(ShareConfigConstants.KEY_DOWNLOAD_SUCCESS_SHARE_DELAY, 0)).intValue();
    }

    public boolean isEnableGetShareInfo() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_GET_SHARE_INFO, true)).booleanValue();
    }

    public int getShowSaveVideoShareDialogTimes() {
        return ((Integer) getExtraConfigByKey(ShareConfigConstants.KEY_SAVE_VIDEO_SHARE_DIALOG_TIMES, 3)).intValue();
    }

    public int getShowSaveVideoContinueShareDialogTimes() {
        return ((Integer) getExtraConfigByKey(ShareConfigConstants.KEY_SAVE_VIDEO_CONTINUE_SHARE_DIALOG_TIMES, -1)).intValue();
    }

    public boolean isEnableToken() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_TOKEN, true)).booleanValue();
    }

    public boolean enableHostHiddenWaterMark() {
        if (this.mEnableServerHiddenWatermark) {
            return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_HIDDEN_WATERMARK, true)).booleanValue();
        }
        return false;
    }

    private boolean enableHostTextToken() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_TEXT_TOKEN, true)).booleanValue();
    }

    private boolean enableHostQrcodeParse() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_QRCODE_PARSE, true)).booleanValue();
    }

    private boolean enableHostVideoQrcodeParse() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_VIDEO_QRCODE_PARSE, true)).booleanValue();
    }

    public boolean enableHostVideoHiddenWaterMark() {
        if (this.mEnableServerVideoHiddenMark) {
            return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_VIDEO_HIDDEN_WATERMARK, true)).booleanValue();
        }
        return false;
    }

    private boolean enableHostAlbumParse() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_ALBUM_PARSE, true)).booleanValue();
    }

    public boolean isDisableToken(String str) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str) && (jSONArray = (JSONArray) getExtraConfigByKey(ShareConfigConstants.KEY_DISABLE_TOKEN_ACTIVITIES, null)) != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                } catch (JSONException e) {
                    Logger.m465e(e.toString());
                }
                if (str.equals(jSONArray.getString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getQrDecodeStr(String str) {
        if (getQrScanConfig() != null) {
            return getQrScanConfig().getQrDecodeStr(str);
        }
        Logger.m469i(TAG, "getQrDecodeStr() is null");
        return null;
    }

    public String getVideoHiddenMark(String str) {
        if (getVideoWatermarkConfig() != null) {
            return getVideoWatermarkConfig().decodeWaterMarkWithPath(str);
        }
        Logger.m469i(TAG, "getVideoWatermarkConfig() is null");
        return null;
    }

    public String getVideoHiddenMark(ByteBuffer byteBuffer, int i, int i2) {
        if (getVideoWatermarkConfig() != null) {
            return getVideoWatermarkConfig().decodeWatermarkWithFrame(byteBuffer, i, i2);
        }
        Logger.m469i(TAG, "getVideoWatermarkConfig() is null");
        return null;
    }

    public void getVideoFrame(String str, VideoOptions videoOptions, IFrameDecodeListener iFrameDecodeListener) {
        IShareVideoFrameConfig iShareVideoFrameConfig = this.mVideoFrameConfig;
        if (iShareVideoFrameConfig != null) {
            iShareVideoFrameConfig.getVideoFrame(str, videoOptions, iFrameDecodeListener);
        }
    }

    public boolean showImageTokenDialog(Context context, ShareContent shareContent) {
        IShareImageTokenConfig imageTokenConfig = getImageTokenConfig();
        if (imageTokenConfig != null) {
            return imageTokenConfig.showImageTokenDialog(context, shareContent);
        }
        return false;
    }

    public void checkImageToken() {
        IShareImageTokenConfig imageTokenConfig = getImageTokenConfig();
        if (imageTokenConfig != null) {
            imageTokenConfig.checkImageToken();
        }
    }

    public void handleAppBackground() {
        IShareImageTokenConfig imageTokenConfig = getImageTokenConfig();
        if (imageTokenConfig != null) {
            imageTokenConfig.handleAppBackground();
        }
    }

    public void checkSelectedMediaToken(String str) {
        IShareImageTokenConfig imageTokenConfig = getImageTokenConfig();
        if (imageTokenConfig != null) {
            imageTokenConfig.checkSelectedMediaToken(str);
        }
    }

    public int getAlbumImageCacheNum() {
        return ((Integer) getExtraConfigByKey("cache_album_image_num", 5)).intValue();
    }

    private IShareQrScanConfig getQrScanConfig() {
        IShareQrScanConfig qrScanConfig = DependManager.getQrScanConfig();
        return qrScanConfig != null ? qrScanConfig : this.mQrScanConfig;
    }

    private IShareVideoWmConfig getVideoWatermarkConfig() {
        IShareVideoWmConfig videoWatermarkConfig = DependManager.getVideoWatermarkConfig();
        return videoWatermarkConfig != null ? videoWatermarkConfig : this.mVideoWatermarkConfig;
    }

    private IShareImageTokenConfig getImageTokenConfig() {
        IShareImageTokenConfig imageTokenConfig = DependManager.getImageTokenConfig();
        return imageTokenConfig != null ? imageTokenConfig : this.iImageTokenConfig;
    }

    public void handleQrScanResult(Activity activity, String str) {
        IShareQrScanConfig iShareQrScanConfig;
        IShareInterceptConfig iShareInterceptConfig = this.mInterceptConfig;
        if ((iShareInterceptConfig == null || !iShareInterceptConfig.handleQrScanResult(activity, str)) && (iShareQrScanConfig = this.mQrScanConfig) != null) {
            iShareQrScanConfig.handleQrScanResult(activity, str);
        }
    }

    public boolean isEnableAlbumParse() {
        return this.mEnableServerAlbumParse && enableHostAlbumParse();
    }

    public boolean isEnableQrcodeParse() {
        return this.mEnableServerQrcodeParse && enableHostQrcodeParse();
    }

    public boolean isEnableVideoQrcodeParse() {
        return this.mEnableServerVideoQrcodeParse && enableHostVideoQrcodeParse();
    }

    public boolean isEnableHiddenWatermark() {
        return enableHostHiddenWaterMark() || enableLongImageHiddenWaterMark();
    }

    public boolean isEnableTextTokenParse() {
        return this.mEnableServerTextTokenParse && enableHostTextToken();
    }

    public void setEnableServerHiddenWatermark(boolean z) {
        this.mEnableServerHiddenWatermark = z;
    }

    public void setEnableServerAlbumParse(boolean z) {
        this.mEnableServerAlbumParse = z;
    }

    public void setEnableServerQrcodeParse(boolean z) {
        this.mEnableServerQrcodeParse = z;
    }

    public void setEnableServerTextTokenParse(boolean z) {
        this.mEnableServerTextTokenParse = z;
    }

    public void setEnableServerVideoHiddenMark(boolean z) {
        this.mEnableServerVideoHiddenMark = z;
    }

    public void setEnableServerVideoQrcodeParse(boolean z) {
        this.mEnableServerVideoQrcodeParse = z;
    }

    public int getResourceIcon(ShareChannelType shareChannelType) {
        int shareIconResource;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (shareIconResource = iShareUIConfig.getShareIconResource(shareChannelType)) != 0) {
            return shareIconResource;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getShareIconResource(shareChannelType);
        }
        return 0;
    }

    public String getResourceIconText(ShareChannelType shareChannelType) {
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null) {
            String shareIconText = iShareUIConfig.getShareIconText(shareChannelType);
            if (!TextUtils.isEmpty(shareIconText)) {
                return shareIconText;
            }
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        return uIConfig != null ? uIConfig.getShareIconText(shareChannelType) : "";
    }

    public ISharePanel getSharePanel(Activity activity, ShareContent shareContent) {
        ISharePanel sharePanel;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (sharePanel = iShareUIConfig.getSharePanel(activity)) != null) {
            shareContent.setFrom("undefined");
            return sharePanel;
        }
        shareContent.setFrom(DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME);
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getSharePanel(activity);
        }
        return null;
    }

    public ISharePanel getSharePanelWithPreview(Activity activity, ShareContent shareContent) {
        ISharePanel sharePanelWithPreview;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (sharePanelWithPreview = iShareUIConfig.getSharePanelWithPreview(activity)) != null) {
            shareContent.setFrom("undefined");
            return sharePanelWithPreview;
        }
        shareContent.setFrom(DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME);
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getSharePanelWithPreview(activity);
        }
        return null;
    }

    public IRecognizeTokenDialog getAdditionRecognizeTokenDialog(Activity activity, TokenInfoBean tokenInfoBean) {
        ArrayList<IAdditionalRecognizeTokenDialog> recognizeTokenDialogList = AdditionalTokenDialogManager.getInstance().getRecognizeTokenDialogList();
        if (recognizeTokenDialogList == null || recognizeTokenDialogList.size() <= 0) {
            return null;
        }
        Iterator<IAdditionalRecognizeTokenDialog> it = recognizeTokenDialogList.iterator();
        while (it.hasNext()) {
            IRecognizeTokenDialog recognizeTokenDialog = it.next().getRecognizeTokenDialog(activity, tokenInfoBean);
            if (recognizeTokenDialog != null) {
                return recognizeTokenDialog;
            }
        }
        return null;
    }

    public IRecognizeTokenDialog getRecognizeTokenDialog(Activity activity, TokenInfoBean tokenInfoBean) {
        IRecognizeTokenDialog recognizeTokenDialog;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (recognizeTokenDialog = iShareUIConfig.getRecognizeTokenDialog(activity, tokenInfoBean)) != null) {
            return recognizeTokenDialog;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getRecognizeTokenDialog(activity, tokenInfoBean);
        }
        return null;
    }

    public IShareTokenDialog getShareTokenDialog(Activity activity) {
        IShareTokenDialog shareTokenDialog;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (shareTokenDialog = iShareUIConfig.getShareTokenDialog(activity)) != null) {
            return shareTokenDialog;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getShareTokenDialog(activity);
        }
        return null;
    }

    public ISystemOptShareTokenDialog getSystemOptShareTokenDialog(Activity activity) {
        ISystemOptShareTokenDialog systemOptShareTokenDialog;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (systemOptShareTokenDialog = iShareUIConfig.getSystemOptShareTokenDialog(activity)) != null) {
            return systemOptShareTokenDialog;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getSystemOptShareTokenDialog(activity);
        }
        return null;
    }

    public IImageTokenDialog getImageTokenDialog(Activity activity) {
        IImageTokenDialog imageTokenDialog;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (imageTokenDialog = iShareUIConfig.getImageTokenDialog(activity)) != null) {
            return imageTokenDialog;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getImageTokenDialog(activity);
        }
        return null;
    }

    public IVideoGuideDialog getVideoGuideDialog(Activity activity) {
        IVideoGuideDialog videoGuideDialog;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (videoGuideDialog = iShareUIConfig.getVideoGuideDialog(activity)) != null) {
            return videoGuideDialog;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getVideoGuideDialog(activity);
        }
        return null;
    }

    public IVideoShareDialog getVideoShareDialog(Activity activity) {
        IVideoShareDialog videoShareDialog;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (videoShareDialog = iShareUIConfig.getVideoShareDialog(activity)) != null) {
            return videoShareDialog;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getVideoShareDialog(activity);
        }
        return null;
    }

    public IDownloadProgressDialog getDownloadProgressDialog(Activity activity) {
        IDownloadProgressDialog downloadProgressDialog;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (downloadProgressDialog = iShareUIConfig.getDownloadProgressDialog(activity)) != null) {
            return downloadProgressDialog;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getDownloadProgressDialog(activity);
        }
        return null;
    }

    public IShareProgressView getShareProgressView(Activity activity) {
        IShareProgressView shareProgressView;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if (iShareUIConfig != null && (shareProgressView = iShareUIConfig.getShareProgressView(activity)) != null) {
            return shareProgressView;
        }
        IShareUIConfig uIConfig = DependManager.getUIConfig();
        if (uIConfig != null) {
            return uIConfig.getShareProgressView(activity);
        }
        return null;
    }

    public void showToast(Context context, ShareContent shareContent, int i, int i2) {
        IShareUIConfig uIConfig;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if ((iShareUIConfig == null || !iShareUIConfig.showToast(context, shareContent, i, i2)) && (uIConfig = DependManager.getUIConfig()) != null) {
            uIConfig.showToast(context, shareContent, i, i2);
        }
    }

    public void showToastWithIcon(Context context, ShareContent shareContent, int i, int i2, int i3) {
        IShareUIConfig uIConfig;
        IShareUIConfig iShareUIConfig = this.mUIConfig;
        if ((iShareUIConfig == null || !iShareUIConfig.showToastWithIcon(context, shareContent, i, i2, i3)) && (uIConfig = DependManager.getUIConfig()) != null) {
            uIConfig.showToastWithIcon(context, shareContent, i, i2, i3);
        }
    }

    public boolean interceptRecognizeToken(Activity activity, TokenInfoBean tokenInfoBean) {
        ArrayList<IAdditionalRecognizeTokenDialog> recognizeTokenDialogList = AdditionalTokenDialogManager.getInstance().getRecognizeTokenDialogList();
        if (recognizeTokenDialogList == null || recognizeTokenDialogList.size() <= 0) {
            return false;
        }
        Iterator<IAdditionalRecognizeTokenDialog> it = recognizeTokenDialogList.iterator();
        while (it.hasNext()) {
            if (it.next().handleRecognizeToken(activity, tokenInfoBean)) {
                return true;
            }
        }
        return false;
    }

    public boolean handleRecognizeToken(Activity activity, TokenInfoBean tokenInfoBean) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            return iShareTokenConfig.handleRecognizeToken(activity, tokenInfoBean);
        }
        return false;
    }

    public boolean disableRecognizeToken(Activity activity) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            return iShareTokenConfig.disableRecognizeToken(activity);
        }
        return false;
    }

    public boolean filterRecognizeToken(Activity activity) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            return iShareTokenConfig.filterRecognizeToken(activity);
        }
        return false;
    }

    public boolean interceptRecognizeTokenDialog(IRecognizeTokenDialog iRecognizeTokenDialog) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            return iShareTokenConfig.interceptRecognizeTokenDialog(iRecognizeTokenDialog);
        }
        return false;
    }

    public void onRecognizeTokenDialogShowEvent(IRecognizeTokenDialog iRecognizeTokenDialog, TokenInfoBean tokenInfoBean) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            iShareTokenConfig.onRecognizeTokenDialogShowEvent(iRecognizeTokenDialog, tokenInfoBean);
        }
    }

    public void onRecognizeTokenDialogDismissEvent(IRecognizeTokenDialog iRecognizeTokenDialog, TokenInfoBean tokenInfoBean) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            iShareTokenConfig.onRecognizeTokenDialogDismissEvent(iRecognizeTokenDialog, tokenInfoBean);
        }
    }

    public void onRecognizeTokenDialogClickEvent(IRecognizeTokenDialog iRecognizeTokenDialog, RecognizeDialogClickType recognizeDialogClickType, TokenInfoBean tokenInfoBean) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            iShareTokenConfig.onRecognizeTokenDialogClickEvent(iRecognizeTokenDialog, recognizeDialogClickType, tokenInfoBean);
        }
    }

    public void handleTokenCheckCallback(boolean z, String str, String str2) {
        IShareTokenConfig iShareTokenConfig = this.mTokenConfig;
        if (iShareTokenConfig != null) {
            iShareTokenConfig.handleTokenCheckCallback(z, str, str2);
        }
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public SharedPreferences getSharedPreferences(String str) {
        IShareSpConfig iShareSpConfig = this.mSpConfig;
        if (iShareSpConfig != null) {
            return iShareSpConfig.getSharedPreferences(str);
        }
        return null;
    }

    public boolean isLocalMode() {
        return this.mIsLocalMode;
    }

    public String getDefaultPanelList() {
        return (String) getExtraConfigByKey(ShareConfigConstants.KEY_DEFAULT_PANEL_LIST, "");
    }

    public String getDefaultActShareInfoUrl() {
        return (String) getExtraConfigByKey(ShareConfigConstants.KEY_DEFAULT_ACT_SHARE_INFO_URL, "");
    }

    public String getDefaultTokenActReg() {
        return (String) getExtraConfigByKey(ShareConfigConstants.KEY_DEFAULT_TOKEN_ACT_REG, "");
    }

    public String getDefaultTokenPicReg() {
        return (String) getExtraConfigByKey(ShareConfigConstants.KEY_DEFAULT_TOKEN_PIC_REG, "");
    }

    public String getDefaultTokenVideoReg() {
        return (String) getExtraConfigByKey(ShareConfigConstants.KEY_DEFAULT_TOKEN_VIDEO_REG, "");
    }

    public boolean enableLongImageHiddenWaterMark() {
        if (this.mEnableServerHiddenWatermark) {
            return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_LONG_IMAGE_HIDDEN_WATERMARK, false)).booleanValue();
        }
        return false;
    }

    public int getImageDownloadLoadingDelay() {
        return ((Integer) getExtraConfigByKey(ShareConfigConstants.KEY_IMAGE_DOWNLOAD_LOADING_DELAY, 150)).intValue();
    }

    public boolean needTransformShortUrl() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_NEED_SHORT_URL, false)).booleanValue();
    }

    public boolean enableKeepOpenUrl() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_KEEP_OPEN_URL, false)).booleanValue();
    }

    public boolean useHostClipboard() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_USE_HOST_CLIPBOARD, true)).booleanValue();
    }

    public boolean enableNewTokenRule() {
        return ((Boolean) getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_NEW_TOKEN_RULE, false)).booleanValue();
    }

    public boolean isDownloadCanCancel() {
        return ((Boolean) getInstance().getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_DOWNLOAD_DIALOG_CANCEL, true)).booleanValue();
    }

    public boolean isDownloadCanCancelOnTouchOutside() {
        return ((Boolean) getInstance().getExtraConfigByKey(ShareConfigConstants.KEY_ENABLE_DOWNLOAD_DIALOG_CANCEL_TOUCH_OUTSIDE, false)).booleanValue();
    }

    public int getTokenButtonBgColor() {
        return Color.parseColor((String) getInstance().getExtraConfigByKey("token_button_bg_color", "#f85959"));
    }

    public int getTokenButtonTextColor() {
        return Color.parseColor((String) getInstance().getExtraConfigByKey("token_button_text_color", "#ffffff"));
    }

    @Deprecated
    public float getLongImageOffsetY() {
        int intValue = ((Integer) getInstance().getExtraConfigByKey("image_token_long_image_offset_y", 0)).intValue();
        if (intValue != 0) {
            return TypedValue.applyDimension(1, intValue, ShareSdkManager.getInstance().getAppContext().getResources().getDisplayMetrics());
        }
        return 0.0f;
    }
}
