package com.bytedance.ug.sdk.share.impl.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ug.sdk.share.api.callback.ShareEventCallback;
import com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback;
import com.bytedance.ug.sdk.share.api.depend.IDYShareConfig;
import com.bytedance.ug.sdk.share.api.depend.ShareConfig;
import com.bytedance.ug.sdk.share.api.entity.DialogEventType;
import com.bytedance.ug.sdk.share.api.entity.DialogType;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.PermissionType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.api.panel.PanelItemType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.api.panel.exposure.ExposedPanelContent;
import com.bytedance.ug.sdk.share.impl.cache.ShareCacheManager;
import com.bytedance.ug.sdk.share.impl.callback.InitDataCallback;
import com.bytedance.ug.sdk.share.impl.check.CheckManager;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.constant.ShareConfigConstants;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.model.ShareChannelItem;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import com.bytedance.ug.sdk.share.impl.network.model.GetShareInfoResponse;
import com.bytedance.ug.sdk.share.impl.network.model.InitShareResponse;
import com.bytedance.ug.sdk.share.impl.network.model.InitShareSettings;
import com.bytedance.ug.sdk.share.impl.network.model.PanelInfo;
import com.bytedance.ug.sdk.share.impl.network.model.TokenRefluxInfo;
import com.bytedance.ug.sdk.share.impl.network.model.ZlinkInfo;
import com.bytedance.ug.sdk.share.impl.network.request.GetShareInfoThread;
import com.bytedance.ug.sdk.share.impl.network.request.InitShareSdkThread;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SharePanelProxy;
import com.bytedance.ug.sdk.share.impl.share.ShareFactory;
import com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend;
import com.bytedance.ug.sdk.share.impl.share.api.IShareHandler;
import com.bytedance.ug.sdk.share.impl.share.exposure.ExposedShare;
import com.bytedance.ug.sdk.share.impl.utils.ActivityStack;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.UGShareLogger;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareSdkManager {
    private static final String TAG = "ShareSdkManager";
    private List<List<String>> mAndroid12TokenDetectStrategy;
    private Context mAppContext;
    private List<String> mCheckAndSignChannelList;
    private Map<PanelItemType, IPanelItem> mDefaultPanelItems;
    private int mEnableUseTimon;
    private int mForegroundActivityNum;
    private InitDataCallback mInitDataCallback;
    private boolean mIsForeground;
    private volatile boolean mIsInit;
    private boolean mIsInitData;
    private boolean mIsInitDefaultPanelItem;
    private boolean mIsLoadPanelData;
    private ConcurrentHashMap<String, Runnable> mPostRunnable;
    private List<PanelInfo> mSharePanelList;
    private List<TokenRefluxInfo> mTokenActivityRegex;
    private List<TokenRefluxInfo> mTokenPicRegex;
    private String mTokenShareRegex;
    private List<Integer> mTokenStrategy;
    private List<TokenRefluxInfo> mTokenVideoRegex;
    private List<ZlinkInfo> mZlinkInfoList;
    private ShareChannelType sCurrShareChannelType;
    private ShareEventCallback sShareEventCallback;
    private ShareContent shareContent;

    private ShareSdkManager() {
        this.mForegroundActivityNum = 0;
        this.mIsForeground = false;
        this.mIsInitData = false;
        this.mIsInit = false;
        this.mIsLoadPanelData = false;
        this.mEnableUseTimon = -1;
        this.sCurrShareChannelType = null;
        this.mSharePanelList = new ArrayList();
        this.mPostRunnable = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SingleHolder {
        private static ShareSdkManager sInstance = new ShareSdkManager();

        private SingleHolder() {
        }
    }

    public static ShareSdkManager getInstance() {
        return SingleHolder.sInstance;
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public void enterBackground(Activity activity) {
        if (activity != null && ShareConfigManager.getInstance().isEnableToken()) {
            if (ShareConfigManager.getInstance().isDisableToken(activity.getClass().getName()) || ShareConfigManager.getInstance().filterRecognizeToken(activity)) {
                return;
            }
            int i = this.mForegroundActivityNum - 1;
            this.mForegroundActivityNum = i;
            if (i <= 0) {
                this.mForegroundActivityNum = 0;
                if (!this.mIsForeground || ShareConfigManager.getInstance().disableRecognizeToken(activity)) {
                    return;
                }
                handleAppBackground(activity);
                this.mIsForeground = false;
            }
        }
    }

    public void enterForeground(Activity activity) {
        if (activity != null && ShareConfigManager.getInstance().isEnableToken()) {
            String name = activity.getClass().getName();
            if (ShareConfigManager.getInstance().isDisableToken(name)) {
                return;
            }
            if (ShareConfigManager.getInstance().filterRecognizeToken(activity)) {
                Logger.m463d(TAG, "filterRecognizeToken" + name);
                return;
            }
            Logger.m463d(TAG, "continue" + name);
            if (this.mForegroundActivityNum <= 0) {
                this.mForegroundActivityNum = 0;
                if (!this.mIsForeground && !ShareConfigManager.getInstance().disableRecognizeToken(activity)) {
                    Logger.m463d(TAG, "handleAppForeground" + name);
                    handleAppForeground(activity);
                    this.mIsForeground = true;
                }
            }
            this.mForegroundActivityNum++;
        }
    }

    private void handleAppForeground(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                String name = activity.getClass().getName();
                if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                    Runnable runnable = new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TokenCheckerManager.getInstance().checkToken();
                        }
                    };
                    activity.getWindow().getDecorView().post(runnable);
                    this.mPostRunnable.put(name, runnable);
                } else {
                    Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.2
                        @Override // android.os.MessageQueue.IdleHandler
                        public boolean queueIdle() {
                            TokenCheckerManager.getInstance().checkToken();
                            return false;
                        }
                    });
                }
                return;
            } catch (Throwable th) {
                Logger.m465e(th.toString());
                return;
            }
        }
        TokenCheckerManager.getInstance().checkToken();
    }

    private void handleAppBackground(Activity activity) {
        ShareConfigManager.getInstance().handleAppBackground();
        if (Build.VERSION.SDK_INT < 29 || activity == null) {
            return;
        }
        try {
            if (activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                return;
            }
            String name = activity.getClass().getName();
            if (this.mPostRunnable.containsKey(name)) {
                activity.getWindow().getDecorView().removeCallbacks(this.mPostRunnable.get(name));
                this.mPostRunnable.remove(name);
            }
        } catch (Throwable th) {
            Logger.m465e(th.toString());
        }
    }

    public String getTokeShareRegex() {
        if (TextUtils.isEmpty(this.mTokenShareRegex)) {
            this.mTokenShareRegex = ShareCacheManager.getInstance().getTokenRegex();
        }
        return this.mTokenShareRegex;
    }

    public List<PanelInfo> getSharePanelList() {
        if (!isLoadPanelData()) {
            loadLocalPanelItems();
        }
        return this.mSharePanelList;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$3] */
    public List<TokenRefluxInfo> getTokenActivityRegex() {
        if (this.mTokenActivityRegex == null && !isInitData()) {
            String tokenActivityRegex = ShareCacheManager.getInstance().getTokenActivityRegex();
            if (!TextUtils.isEmpty(tokenActivityRegex)) {
                this.mTokenActivityRegex = (List) new Gson().fromJson(tokenActivityRegex, new TypeToken<ArrayList<TokenRefluxInfo>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.3
                }.getType());
            }
        }
        return this.mTokenActivityRegex;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$4] */
    public List<TokenRefluxInfo> getTokenPicRegex() {
        if (this.mTokenPicRegex == null && !isInitData()) {
            String tokenPicRegex = ShareCacheManager.getInstance().getTokenPicRegex();
            if (!TextUtils.isEmpty(tokenPicRegex)) {
                this.mTokenPicRegex = (List) new Gson().fromJson(tokenPicRegex, new TypeToken<ArrayList<TokenRefluxInfo>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.4
                }.getType());
            }
        }
        return this.mTokenPicRegex;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$5] */
    public List<TokenRefluxInfo> getTokenVideoRegex() {
        if (this.mTokenVideoRegex == null && !isInitData()) {
            String tokenVideoRegex = ShareCacheManager.getInstance().getTokenVideoRegex();
            if (!TextUtils.isEmpty(tokenVideoRegex)) {
                this.mTokenVideoRegex = (List) new Gson().fromJson(tokenVideoRegex, new TypeToken<ArrayList<TokenRefluxInfo>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.5
                }.getType());
            }
        }
        return this.mTokenVideoRegex;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$6] */
    public List<Integer> getTokenStrategy() {
        if (this.mTokenStrategy == null && !isInitData()) {
            String tokenStrategy = ShareCacheManager.getInstance().getTokenStrategy();
            if (!TextUtils.isEmpty(tokenStrategy)) {
                this.mTokenStrategy = (List) new Gson().fromJson(tokenStrategy, new TypeToken<ArrayList<Integer>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.6
                }.getType());
            }
        }
        return this.mTokenStrategy;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$7] */
    public String getChannelZlink(ShareChannelType shareChannelType) {
        String str;
        if (this.mZlinkInfoList == null && !isInitData()) {
            String zlinkInfoList = ShareCacheManager.getInstance().getZlinkInfoList();
            if (!TextUtils.isEmpty(zlinkInfoList)) {
                this.mZlinkInfoList = (List) new Gson().fromJson(zlinkInfoList, new TypeToken<ArrayList<ZlinkInfo>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.7
                }.getType());
            }
        }
        String shareItemTypeName = ShareChannelType.getShareItemTypeName(shareChannelType);
        List<ZlinkInfo> list = this.mZlinkInfoList;
        if (list != null) {
            for (ZlinkInfo zlinkInfo : list) {
                if (!TextUtils.isEmpty(shareItemTypeName) && TextUtils.equals(shareItemTypeName, zlinkInfo.getChannel())) {
                    str = zlinkInfo.getZlink();
                    break;
                }
            }
        }
        str = "";
        return str == null ? "" : str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$8] */
    public List<List<String>> getAndroid12TokenDetectStrategy() {
        if (this.mAndroid12TokenDetectStrategy == null && !isInitData()) {
            String android12TokenDetectStrategy = ShareCacheManager.getInstance().getAndroid12TokenDetectStrategy();
            if (!TextUtils.isEmpty(android12TokenDetectStrategy)) {
                this.mAndroid12TokenDetectStrategy = (List) new Gson().fromJson(android12TokenDetectStrategy, new TypeToken<ArrayList<String>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.8
                }.getType());
            }
        }
        return this.mAndroid12TokenDetectStrategy;
    }

    public boolean isEnableUseTimon() {
        if (this.mEnableUseTimon == -1) {
            this.mEnableUseTimon = ShareCacheManager.getInstance().getEnableUseTimon();
        }
        return this.mEnableUseTimon == 1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$9] */
    public boolean isChannelNeedCheckAndSign(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mCheckAndSignChannelList == null && !isInitData()) {
            String checkAndSignChannelList = ShareCacheManager.getInstance().getCheckAndSignChannelList();
            if (!TextUtils.isEmpty(checkAndSignChannelList)) {
                this.mCheckAndSignChannelList = (List) new Gson().fromJson(checkAndSignChannelList, new TypeToken<ArrayList<String>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.9
                }.getType());
            }
        }
        List<String> list = this.mCheckAndSignChannelList;
        if (list != null) {
            return list.contains(str);
        }
        return false;
    }

    public String getShareInfoUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!isLoadPanelData()) {
            loadLocalPanelItems();
        }
        List<PanelInfo> list = this.mSharePanelList;
        if (list != null && list.size() > 0) {
            for (PanelInfo panelInfo : this.mSharePanelList) {
                if (str.equals(panelInfo.getPanelId())) {
                    return panelInfo.getShareInfoUrl();
                }
            }
        }
        return ShareConfigManager.getInstance().getDefaultActShareInfoUrl();
    }

    public void register(Application application) {
        this.mAppContext = application.getApplicationContext();
        ActivityStack.register(application);
        CheckManager.getInstance().setRegister(true);
    }

    public void init(Application application, ShareConfig shareConfig) {
        if (this.mIsInit) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mIsInit = true;
        if (this.mAppContext == null) {
            this.mAppContext = application.getApplicationContext();
        }
        ShareConfigManager.getInstance().init(shareConfig);
        loadLocalShareConfig();
        if (!ShareConfigManager.getInstance().isLocalMode()) {
            loadServerShareConfig(currentTimeMillis);
        } else {
            MonitorEvent.monitorShareInit(0, System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void loadLocalShareConfig() {
        initDefaultPanelItems();
    }

    private void loadLocalPanelItems() {
        String panelList = ShareCacheManager.getInstance().getPanelList();
        parseSharePanelList(panelList);
        if (TextUtils.isEmpty(panelList)) {
            return;
        }
        this.mIsLoadPanelData = true;
    }

    private void initDefaultPanelItems() {
        this.mDefaultPanelItems = new HashMap();
        for (ShareChannelType shareChannelType : ShareChannelType.values()) {
            this.mDefaultPanelItems.put(shareChannelType, new ShareChannelItem(shareChannelType));
        }
        this.mIsInitDefaultPanelItem = true;
    }

    private void loadServerShareConfig(final long j) {
        final long currentTimeMillis = System.currentTimeMillis();
        ShareConfigManager.getInstance().execute(new InitShareSdkThread(new InitShareSdkThread.InitShareSdkCallback() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.10
            @Override // com.bytedance.ug.sdk.share.impl.network.request.InitShareSdkThread.InitShareSdkCallback
            public void onSuccess(InitShareResponse initShareResponse) {
                Logger.m469i(ShareSdkManager.TAG, "share init interface success");
                if (initShareResponse != null) {
                    ShareSdkManager.this.loadShareConfig(initShareResponse);
                }
                ShareEvent.sendRequestInitDataEvent(true, "success", System.currentTimeMillis() - currentTimeMillis);
                MonitorEvent.monitorShareInit(0, System.currentTimeMillis() - j);
                ShareSdkManager.this.mIsInitData = true;
                ShareSdkManager.this.mIsLoadPanelData = true;
                if (ShareSdkManager.this.mInitDataCallback != null) {
                    ShareSdkManager.this.mInitDataCallback.onSuccess();
                    ShareSdkManager.this.mInitDataCallback = null;
                }
            }

            @Override // com.bytedance.ug.sdk.share.impl.network.request.InitShareSdkThread.InitShareSdkCallback
            public void onFailed(int i, String str) {
                Logger.m469i(ShareSdkManager.TAG, "share init interface failed, status: " + i + ", errorMsg: " + str);
                ShareEvent.sendRequestInitDataEvent(false, str, System.currentTimeMillis() - currentTimeMillis);
                MonitorEvent.monitorShareInit(1, System.currentTimeMillis() - j);
                if (ShareSdkManager.this.mInitDataCallback != null) {
                    ShareSdkManager.this.mInitDataCallback.onFailed();
                    ShareSdkManager.this.mInitDataCallback = null;
                }
            }
        }));
    }

    public boolean isInitData() {
        return this.mIsInitData;
    }

    public boolean isLoadPanelData() {
        return this.mIsLoadPanelData;
    }

    public void setInitDataCallback(InitDataCallback initDataCallback) {
        this.mInitDataCallback = initDataCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadShareConfig(InitShareResponse initShareResponse) {
        if (initShareResponse == null) {
            return;
        }
        this.mSharePanelList = initShareResponse.getPanelList();
        this.mTokenShareRegex = initShareResponse.getTokenRegex();
        this.mTokenActivityRegex = initShareResponse.getTokenActivityRegex();
        this.mTokenPicRegex = initShareResponse.getTokenPicRegex();
        this.mTokenVideoRegex = initShareResponse.getTokenVideoRegex();
        this.mTokenStrategy = initShareResponse.getTokenStrategy();
        this.mZlinkInfoList = initShareResponse.getZlinkInfoList();
        if (initShareResponse.getInitSettings() != null) {
            initSettings(initShareResponse.getInitSettings());
        }
    }

    private void initSettings(InitShareSettings initShareSettings) {
        if (initShareSettings == null) {
            return;
        }
        ShareConfigManager.getInstance().setEnableServerAlbumParse(initShareSettings.getAlbumParseSwitch() != 0);
        ShareConfigManager.getInstance().setEnableServerHiddenWatermark(initShareSettings.getHiddenMarkParseSwitch() != 0);
        ShareConfigManager.getInstance().setEnableServerQrcodeParse(initShareSettings.getQrcodeParseSwitch() != 0);
        ShareConfigManager.getInstance().setEnableServerTextTokenParse(initShareSettings.getTextTokenParseSwitch() != 0);
        ShareConfigManager.getInstance().setEnableServerVideoHiddenMark(initShareSettings.getVideoHiddenMarkSwitch() != 0);
        ShareConfigManager.getInstance().setEnableServerVideoQrcodeParse(initShareSettings.getVideoQrcodeSwitch() != 0);
        this.mCheckAndSignChannelList = initShareSettings.getCheckAndSignChannelList();
        this.mAndroid12TokenDetectStrategy = initShareSettings.getAndroid12TokenDetectStrategy();
        this.mEnableUseTimon = initShareSettings.getUseTimon();
    }

    public ISharePanel showPanel(PanelContent panelContent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (panelContent == null || panelContent.getShareContent() == null) {
            MonitorEvent.monitorPanelShow(1, System.currentTimeMillis() - currentTimeMillis, panelContent == null ? "" : panelContent.getPanelId(), "content == null");
            return null;
        }
        ISharePanel panel = panelContent.getPanel();
        if (panel != null) {
            panelContent.getShareContent().setFrom("undefined");
        } else {
            panel = ShareConfigManager.getInstance().getSharePanel(panelContent.getActivity(), panelContent.getShareContent());
            if (panel == null) {
                MonitorEvent.monitorPanelShow(1, System.currentTimeMillis() - currentTimeMillis, panelContent.getPanelId(), "panel == null");
                return null;
            }
        }
        boolean show = new SharePanelProxy(panelContent, panel).show();
        MonitorEvent.monitorPanelShow(!show ? 1 : 0, System.currentTimeMillis() - currentTimeMillis, panelContent.getPanelId(), show ? "success" : "activity is not active");
        return panel;
    }

    public void share(ExposedPanelContent exposedPanelContent) {
        new ExposedShare(exposedPanelContent).share();
    }

    public void getShareInfo(String str, String str2, String str3, ShareContent shareContent, JSONObject jSONObject, ShareInfoCallback shareInfoCallback) {
        this.shareContent = shareContent;
        if (shareContent != null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!jSONObject.has(ShareConfigConstants.KEY_NEED_SHORT_URL) && ShareConfigManager.getInstance().needTransformShortUrl()) {
                jSONObject.put(ShareConfigConstants.KEY_NEED_SHORT_URL, 1);
            }
            if (ShareConfigManager.getInstance().enableKeepOpenUrl()) {
                if (!jSONObject.has("open_url") && !TextUtils.isEmpty(shareContent.getTargetUrl())) {
                    jSONObject.put("open_url", shareContent.getTargetUrl());
                }
            } else if (!TextUtils.isEmpty(shareContent.getTargetUrl())) {
                jSONObject.put("open_url", shareContent.getTargetUrl());
            }
            if (jSONObject.has("share_url")) {
                String optString = jSONObject.optString("share_url");
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject.put("share_url", HttpUtils.addUniqueParam(optString, "share_token", str3));
                }
            }
            if (!TextUtils.isEmpty(shareContent.getTitle())) {
                jSONObject.put(SchemaConstants.QUERY_KEY_TITLE, shareContent.getTitle());
            }
            if (!TextUtils.isEmpty(shareContent.getText())) {
                jSONObject.put("desc", shareContent.getText());
            }
            if (!TextUtils.isEmpty(shareContent.getImageUrl())) {
                jSONObject.put("thumb_image_url", shareContent.getImageUrl());
            }
            if (!TextUtils.isEmpty(shareContent.getHiddenImageUrl())) {
                jSONObject.put("hidden_url", shareContent.getHiddenImageUrl());
            }
            if (!TextUtils.isEmpty(shareContent.getQrcodeImageUrl())) {
                jSONObject.put("qrcode_url", shareContent.getQrcodeImageUrl());
            }
            if (!TextUtils.isEmpty(shareContent.getVideoUrl())) {
                jSONObject.put("video_url", shareContent.getVideoUrl());
            }
            if (!TextUtils.isEmpty(shareContent.getAudioUrl())) {
                jSONObject.put("audio_url", shareContent.getAudioUrl());
            }
        }
        getShareInfo(str, str2, shareContent, jSONObject, shareInfoCallback);
    }

    private void getShareInfo(String str, String str2, final ShareContent shareContent, JSONObject jSONObject, final ShareInfoCallback shareInfoCallback) {
        UGShareLogger.onGetShareInfo(str, str2, shareContent, jSONObject);
        ShareConfigManager.getInstance().execute(new GetShareInfoThread(str, str2, jSONObject, new GetShareInfoThread.GetShareInfoCallback() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.11
            @Override // com.bytedance.ug.sdk.share.impl.network.request.GetShareInfoThread.GetShareInfoCallback
            public void onSuccess(GetShareInfoResponse getShareInfoResponse) {
                ShareInfoCallback shareInfoCallback2 = shareInfoCallback;
                if (shareInfoCallback2 != null) {
                    shareInfoCallback2.onSuccess(getShareInfoResponse.getShareInfoList());
                }
                ShareContent shareContent2 = shareContent;
                if (shareContent2 != null && shareContent2.getEventCallBack() != null) {
                    shareContent.getEventCallBack().onGetShareInfoSuccess(getShareInfoResponse);
                }
                ShareEvent.sendRequestShareDataEvent(true, "success");
                UGShareLogger.onShareInfoSuccess(shareContent);
            }

            @Override // com.bytedance.ug.sdk.share.impl.network.request.GetShareInfoThread.GetShareInfoCallback
            public void onFailed(int i, String str3) {
                ShareInfoCallback shareInfoCallback2 = shareInfoCallback;
                if (shareInfoCallback2 != null) {
                    shareInfoCallback2.onFailed();
                }
                ShareContent shareContent2 = shareContent;
                if (shareContent2 != null && shareContent2.getEventCallBack() != null) {
                    shareContent.getEventCallBack().onGetShareInfoFailed(i, str3);
                }
                ShareEvent.sendRequestShareDataEvent(false, str3);
                UGShareLogger.onShareInfoFailed(str3, shareContent);
            }
        }));
    }

    public List<IPanelItem> getPanelItems(String str) {
        List<PanelInfo> list;
        if (!isLoadPanelData()) {
            loadLocalPanelItems();
        }
        if (TextUtils.isEmpty(str) || (list = this.mSharePanelList) == null || list.isEmpty()) {
            return getDefaultPanelList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PanelInfo> it = this.mSharePanelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PanelInfo next = it.next();
            if (str.equals(next.getPanelId())) {
                List<String> channelList = next.getChannelList();
                List<String> filteredChannelList = next.getFilteredChannelList();
                if (channelList != null) {
                    for (String str2 : channelList) {
                        ShareChannelType shareItemType = ShareChannelType.getShareItemType(str2);
                        if (shareItemType != null) {
                            if (!this.mIsInitDefaultPanelItem) {
                                initDefaultPanelItems();
                            }
                            IPanelItem iPanelItem = this.mDefaultPanelItems.get(shareItemType);
                            IShareChannelDepend channel = DependManager.getChannel(shareItemType);
                            if (channel != null && iPanelItem != null && !isFilteredChannel(str2, channel, filteredChannelList)) {
                                arrayList.add(iPanelItem);
                            } else if (shareItemType == ShareChannelType.SYSTEM || shareItemType == ShareChannelType.COPY_LINK || shareItemType == ShareChannelType.SMS || shareItemType == ShareChannelType.EMAIL) {
                                arrayList.add(iPanelItem);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isFilteredChannel(String str, IShareChannelDepend iShareChannelDepend, List<String> list) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(iShareChannelDepend.getPackageName())) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next()) && iShareChannelDepend.needFiltered()) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<IPanelItem> getDefaultPanelList() {
        if (!this.mIsInitDefaultPanelItem) {
            initDefaultPanelItems();
        }
        ArrayList arrayList = new ArrayList();
        IPanelItem iPanelItem = this.mDefaultPanelItems.get(ShareChannelType.WX);
        if (DependManager.getChannel(ShareChannelType.WX) != null && iPanelItem != null) {
            arrayList.add(iPanelItem);
        }
        IPanelItem iPanelItem2 = this.mDefaultPanelItems.get(ShareChannelType.WX_TIMELINE);
        if (DependManager.getChannel(ShareChannelType.WX_TIMELINE) != null && iPanelItem2 != null) {
            arrayList.add(iPanelItem2);
        }
        IPanelItem iPanelItem3 = this.mDefaultPanelItems.get(ShareChannelType.QQ);
        if (DependManager.getChannel(ShareChannelType.QQ) != null && iPanelItem3 != null) {
            arrayList.add(iPanelItem3);
        }
        IPanelItem iPanelItem4 = this.mDefaultPanelItems.get(ShareChannelType.QZONE);
        if (DependManager.getChannel(ShareChannelType.QZONE) != null && iPanelItem4 != null) {
            arrayList.add(iPanelItem4);
        }
        arrayList.add(this.mDefaultPanelItems.get(ShareChannelType.SYSTEM));
        arrayList.add(this.mDefaultPanelItems.get(ShareChannelType.COPY_LINK));
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager$12] */
    private void parseSharePanelList(String str) {
        List<PanelInfo> list;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            List list2 = (List) new Gson().fromJson(str, new TypeToken<ArrayList<PanelInfo>>() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.12
            }.getType());
            if (list2 == null || (list = this.mSharePanelList) == null) {
                return;
            }
            list.clear();
            this.mSharePanelList.addAll(list2);
        } catch (Throwable th) {
            Logger.m465e(th.toString());
        }
    }

    public ShareEventCallback getShareEventCallback() {
        return this.sShareEventCallback;
    }

    public void resetShareEventCallback() {
        this.sShareEventCallback = null;
    }

    public void setShareEventCallback(final ShareEventCallback shareEventCallback) {
        this.sShareEventCallback = new ShareEventCallback() { // from class: com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager.13
            @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
            public void onPermissionEvent(PermissionType permissionType, ShareContent shareContent, String str) {
                ShareEventCallback shareEventCallback2 = shareEventCallback;
                if (shareEventCallback2 != null) {
                    shareEventCallback2.onPermissionEvent(permissionType, shareContent, str);
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
            public void onTokenDialogEvent(DialogType dialogType, DialogEventType dialogEventType, ShareTokenType shareTokenType, ShareContent shareContent) {
                ShareEventCallback shareEventCallback2 = shareEventCallback;
                if (shareEventCallback2 != null) {
                    shareEventCallback2.onTokenDialogEvent(dialogType, dialogEventType, shareTokenType, shareContent);
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
            public void onDownloadEvent(DownloadStatus downloadStatus, String str, ShareContent shareContent) {
                ShareEventCallback shareEventCallback2 = shareEventCallback;
                if (shareEventCallback2 != null) {
                    shareEventCallback2.onDownloadEvent(downloadStatus, str, shareContent);
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
            public void onShareResultEvent(ShareResult shareResult) {
                ShareEventCallback shareEventCallback2 = shareEventCallback;
                if (shareEventCallback2 != null) {
                    shareEventCallback2.onShareResultEvent(shareResult);
                }
                UGShareLogger.onShareFinish(shareResult, ShareSdkManager.this.shareContent);
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
            public void onWillLaunchThirdAppEvent(ShareChannelType shareChannelType) {
                ShareEventCallback shareEventCallback2 = shareEventCallback;
                if (shareEventCallback2 != null) {
                    shareEventCallback2.onWillLaunchThirdAppEvent(shareChannelType);
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
            public void onGetShareInfoSuccess(GetShareInfoResponse getShareInfoResponse) {
                ShareEventCallback shareEventCallback2 = shareEventCallback;
                if (shareEventCallback2 != null) {
                    shareEventCallback2.onGetShareInfoSuccess(getShareInfoResponse);
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
            public void onGetShareInfoFailed(int i, String str) {
                ShareEventCallback shareEventCallback2 = shareEventCallback;
                if (shareEventCallback2 != null) {
                    shareEventCallback2.onGetShareInfoFailed(i, str);
                }
            }
        };
    }

    public ShareChannelType getCurrentShareChannelType() {
        return this.sCurrShareChannelType;
    }

    public void setCurrentShareChannelType(ShareChannelType shareChannelType) {
        this.sCurrShareChannelType = shareChannelType;
    }

    public void handleShareResultOnActivityResult(int i, int i2, Intent intent) {
        IShareHandler shareResultOnActivityResult;
        ShareChannelType shareChannelType = this.sCurrShareChannelType;
        if (shareChannelType == null || (shareResultOnActivityResult = ShareFactory.getShareResultOnActivityResult(shareChannelType)) == null) {
            return;
        }
        shareResultOnActivityResult.handleShareResult(i, i2, intent);
    }

    public boolean isSupportDouYinStory() {
        IDYShareConfig dYShareConfig = DependManager.getDYShareConfig();
        if (dYShareConfig != null) {
            return dYShareConfig.isSupportDYStory();
        }
        return false;
    }

    public boolean isSupportSetDYStoryBackGround() {
        IDYShareConfig dYShareConfig = DependManager.getDYShareConfig();
        if (dYShareConfig != null) {
            return dYShareConfig.isSupportSetDYStoryBackGround();
        }
        return false;
    }
}
