package com.bytedance.ug.sdk.share.impl.network.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ug.sdk.share.api.callback.ITokenParseCallback;
import com.bytedance.ug.sdk.share.api.entity.ActivityInfo;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.p008ui.IRecognizeTokenDialog;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.manager.ClipBoardCheckerManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.manager.TokenCheckerManager;
import com.bytedance.ug.sdk.share.impl.network.model.TokenRefluxInfo;
import com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread;
import com.bytedance.ug.sdk.share.impl.p009ui.recognize.RecognizeTokenDialogProxy;
import com.bytedance.ug.sdk.share.impl.utils.ClipboardCompat;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.UGShareLogger;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TokenParseManager {
    public static final int CLIPBOARD_TOKEN = 0;
    public static final int IMAGE_HIDDEN_TOKEN = 1;
    private static final int MEDIA_TYPE_OPEN_DIRECTLY = 10;
    public static final int QR_CODE_TOKEN = 3;
    private static final String TAG = "TokenParseManager";
    public static final int VIDEO_HIDDEN_TOKEN = 2;
    private volatile boolean checkLock;
    private String mCommand;
    private ITokenParseCallback mTokenParseCallback;
    private int mTokenType;
    private boolean mWaitTokenParse;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface TranslateCommandCallback {
        void onFailed(int i, String str);

        void onSuccess(String str, String str2);
    }

    private TokenParseManager() {
        this.mWaitTokenParse = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SingleHolder {
        private static TokenParseManager sInstance = new TokenParseManager();

        private SingleHolder() {
        }
    }

    public static TokenParseManager getInstance() {
        return SingleHolder.sInstance;
    }

    public void parseTokenInfo(String str, final int i, final ITokenParseCallback iTokenParseCallback) {
        if (ShareConfigManager.getInstance().getInterceptConfig() == null && needWaitTokenParse(str, i)) {
            Logger.m469i(TAG, "parse token info is pending");
            this.mWaitTokenParse = true;
            this.mCommand = str;
            this.mTokenType = i;
            this.mTokenParseCallback = iTokenParseCallback;
            return;
        }
        this.checkLock = true;
        String str2 = i == 1 ? "image" : i == 2 ? FetchTokenInfoThread.VIDEO_TOKEN : FetchTokenInfoThread.CLIPBOARD_TOKEN;
        Logger.m469i(TAG, "start parsing token info");
        UGShareLogger.onRequestParseToken();
        ShareConfigManager.getInstance().execute(new FetchTokenInfoThread(str, str2, new FetchTokenInfoThread.FetchTokenCallback() { // from class: com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager.1
            @Override // com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread.FetchTokenCallback
            public void onSuccess(String str3) {
                Logger.m469i(TokenParseManager.TAG, "parse token success");
                TokenParseManager.this.checkLock = false;
                if (i == 0) {
                    ClipboardCompat.clearClipBoard();
                    ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_SUCCESS, "口令解析成功");
                }
                ITokenParseCallback iTokenParseCallback2 = iTokenParseCallback;
                if (iTokenParseCallback2 != null) {
                    iTokenParseCallback2.onSuccess(str3);
                }
            }

            @Override // com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread.FetchTokenCallback
            public void onFailed(int i2, String str3) {
                String str4;
                Logger.m469i(TokenParseManager.TAG, "parse token error");
                UGShareLogger.onTokenParseFailed(str3);
                TokenParseManager.this.checkLock = false;
                if (i2 == 2) {
                    if (i == 0) {
                        ClipboardCompat.clearClipBoard();
                    }
                    ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_EXPIRED, "口令过期");
                    str4 = "expired";
                } else if (i2 == 1001) {
                    ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_OTHER_APP, "其他app的口令");
                    str4 = "other_app";
                } else if (i2 == 1) {
                    ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_OTHER, "口令接口返回其他错误: " + str3);
                    str4 = CDNLoader.PIPELINE_STATUS_FAILED;
                } else {
                    str4 = "unknown";
                }
                ITokenParseCallback iTokenParseCallback2 = iTokenParseCallback;
                if (iTokenParseCallback2 != null) {
                    if (str3 == null) {
                        str3 = str4;
                    }
                    iTokenParseCallback2.onFailed(i2, str3);
                }
            }
        }));
    }

    public void translateCommand(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String str2 = (i == 1 || i == 2) ? "hidden_mark" : "token";
        parseTokenInfo(str, i, new ITokenParseCallback() { // from class: com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager.2
            @Override // com.bytedance.ug.sdk.share.api.callback.ITokenParseCallback
            public void onSuccess(String str3) {
                String str4 = "";
                ActivityInfo activityInfo = null;
                try {
                    TokenInfoBean tokenInfoBean = (TokenInfoBean) new GsonBuilder().create().fromJson(str3, TokenInfoBean.class);
                    UGShareLogger.onRequestParseTokenSuccess(tokenInfoBean);
                    if (tokenInfoBean != null) {
                        str4 = tokenInfoBean.getOpenUrl();
                        activityInfo = tokenInfoBean.getActivityInfo();
                        tokenInfoBean.setFrom(str2);
                        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
                        if (topActivity == null) {
                            return;
                        }
                        if (ShareConfigManager.getInstance().interceptRecognizeToken(topActivity, tokenInfoBean)) {
                            Logger.m469i(TokenParseManager.TAG, "show intercept recognize token dialog");
                            UGShareLogger.onInterceptRecognizeToken();
                            TokenParseManager.this.tryShowTokenInfoDialog(topActivity, tokenInfoBean, ShareConfigManager.getInstance().getAdditionRecognizeTokenDialog(topActivity, tokenInfoBean));
                        } else if (!ShareConfigManager.getInstance().handleRecognizeToken(topActivity, tokenInfoBean)) {
                            Logger.m469i(TokenParseManager.TAG, "show normal recognize token dialog");
                            UGShareLogger.onShowRecognizeTokenDialog();
                            IRecognizeTokenDialog recognizeTokenDialog = ShareConfigManager.getInstance().getRecognizeTokenDialog(topActivity, tokenInfoBean);
                            if (recognizeTokenDialog != null) {
                                TokenParseManager.this.tryShowTokenInfoDialog(topActivity, tokenInfoBean, recognizeTokenDialog);
                            } else {
                                TokenParseManager.this.handleTokenInfoWithoutDialog(topActivity, tokenInfoBean);
                            }
                        }
                    }
                } catch (Exception e) {
                    Logger.m465e(e.toString());
                }
                TokenCheckerManager.getInstance().setHandleClipToken(false);
                TokenCheckerManager.getInstance().setHandleImageToken(false);
                ShareEvent.sendRequestRecogniseDataEvent(true, str2, "success", str4, activityInfo);
                ShareConfigManager.getInstance().handleTokenCheckCallback(true, str2, "success");
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ITokenParseCallback
            public void onFailed(int i2, String str3) {
                TokenCheckerManager.getInstance().setHandleClipToken(false);
                TokenCheckerManager.getInstance().setHandleImageToken(false);
                ShareEvent.sendRequestRecogniseDataEvent(false, str2, str3, "", null);
                ShareConfigManager.getInstance().handleTokenCheckCallback(false, str2, str3);
            }
        });
    }

    public void translateCommand(String str, int i, final boolean z, final TranslateCommandCallback translateCommandCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String str2 = (i == 1 || i == 2) ? "hidden_mark" : "token";
        parseTokenInfo(str, i, new ITokenParseCallback() { // from class: com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager.3
            @Override // com.bytedance.ug.sdk.share.api.callback.ITokenParseCallback
            public void onSuccess(String str3) {
                String str4;
                str4 = "";
                ActivityInfo activityInfo = null;
                try {
                    TokenInfoBean tokenInfoBean = (TokenInfoBean) new GsonBuilder().create().fromJson(str3, TokenInfoBean.class);
                    UGShareLogger.onRequestParseTokenSuccess(tokenInfoBean);
                    if (tokenInfoBean != null) {
                        String openUrl = tokenInfoBean.getOpenUrl();
                        try {
                            activityInfo = tokenInfoBean.getActivityInfo();
                            tokenInfoBean.setFrom(str2);
                            Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
                            if (topActivity == null) {
                                return;
                            }
                            if (z) {
                                if (ShareConfigManager.getInstance().interceptRecognizeToken(topActivity, tokenInfoBean)) {
                                    Logger.m469i(TokenParseManager.TAG, "show intercept recognize token dialog");
                                    UGShareLogger.onInterceptRecognizeToken();
                                    TokenParseManager.this.tryShowTokenInfoDialog(topActivity, tokenInfoBean, ShareConfigManager.getInstance().getAdditionRecognizeTokenDialog(topActivity, tokenInfoBean));
                                } else if (!ShareConfigManager.getInstance().handleRecognizeToken(topActivity, tokenInfoBean)) {
                                    Logger.m469i(TokenParseManager.TAG, "show normal recognize token dialog");
                                    UGShareLogger.onShowRecognizeTokenDialog();
                                    IRecognizeTokenDialog recognizeTokenDialog = ShareConfigManager.getInstance().getRecognizeTokenDialog(topActivity, tokenInfoBean);
                                    if (recognizeTokenDialog != null) {
                                        TokenParseManager.this.tryShowTokenInfoDialog(topActivity, tokenInfoBean, recognizeTokenDialog);
                                    } else {
                                        TokenParseManager.this.handleTokenInfoWithoutDialog(topActivity, tokenInfoBean);
                                    }
                                }
                            }
                            if (translateCommandCallback != null) {
                                translateCommandCallback.onSuccess(tokenInfoBean.getOpenUrl(), tokenInfoBean.getShareUserInfo() != null ? tokenInfoBean.getShareUserInfo().getSourceOpenUrl() : "");
                            }
                            str4 = openUrl;
                        } catch (Exception e) {
                            e = e;
                            str4 = openUrl;
                            Logger.m465e(e.toString());
                            TokenCheckerManager.getInstance().setHandleClipToken(false);
                            TokenCheckerManager.getInstance().setHandleImageToken(false);
                            ShareEvent.sendRequestRecogniseDataEvent(true, str2, "success", str4, activityInfo);
                            ShareConfigManager.getInstance().handleTokenCheckCallback(true, str2, "success");
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                TokenCheckerManager.getInstance().setHandleClipToken(false);
                TokenCheckerManager.getInstance().setHandleImageToken(false);
                ShareEvent.sendRequestRecogniseDataEvent(true, str2, "success", str4, activityInfo);
                ShareConfigManager.getInstance().handleTokenCheckCallback(true, str2, "success");
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ITokenParseCallback
            public void onFailed(int i2, String str3) {
                TokenCheckerManager.getInstance().setHandleClipToken(false);
                TokenCheckerManager.getInstance().setHandleImageToken(false);
                ShareEvent.sendRequestRecogniseDataEvent(false, str2, str3, "", null);
                ShareConfigManager.getInstance().handleTokenCheckCallback(false, str2, str3);
                TranslateCommandCallback translateCommandCallback2 = translateCommandCallback;
                if (translateCommandCallback2 != null) {
                    translateCommandCallback2.onFailed(i2, str3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTokenInfoWithoutDialog(Activity activity, TokenInfoBean tokenInfoBean) {
        if (activity == null || tokenInfoBean == null || tokenInfoBean.getMediaType() != 10 || TextUtils.isEmpty(tokenInfoBean.getOpenUrl())) {
            return;
        }
        ShareConfigManager.getInstance().openPage(activity, tokenInfoBean.getOpenUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryShowTokenInfoDialog(Activity activity, TokenInfoBean tokenInfoBean, IRecognizeTokenDialog iRecognizeTokenDialog) {
        if (activity == null || tokenInfoBean == null || iRecognizeTokenDialog == null) {
            return;
        }
        new RecognizeTokenDialogProxy(activity, tokenInfoBean, iRecognizeTokenDialog).show();
    }

    public boolean getCheckLock() {
        return this.checkLock;
    }

    public void parseWaitToken() {
        Logger.m469i(TAG, "parse wait token");
        if (this.mWaitTokenParse) {
            this.mWaitTokenParse = false;
            ITokenParseCallback iTokenParseCallback = this.mTokenParseCallback;
            if (iTokenParseCallback == null && this.mTokenType == 3) {
                dealWithQrScanResult(this.mCommand);
            } else {
                parseTokenInfo(this.mCommand, this.mTokenType, iTokenParseCallback);
                this.mTokenParseCallback = null;
            }
        }
    }

    private boolean needWaitTokenParse(String str, int i) {
        List<TokenRefluxInfo> tokenActivityRegex;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 1) {
            tokenActivityRegex = ShareSdkManager.getInstance().getTokenPicRegex();
        } else if (i == 2) {
            tokenActivityRegex = ShareSdkManager.getInstance().getTokenVideoRegex();
        } else {
            tokenActivityRegex = ShareSdkManager.getInstance().getTokenActivityRegex();
        }
        if (tokenActivityRegex != null && !tokenActivityRegex.isEmpty()) {
            for (TokenRefluxInfo tokenRefluxInfo : tokenActivityRegex) {
                if ("niu".equals(tokenRefluxInfo.getId()) && !TextUtils.isEmpty(checkTokenRegex(str, tokenRefluxInfo.getToken()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String checkTokenRegex(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                Matcher matcher = Pattern.compile(str2).matcher(str);
                if (matcher.find()) {
                    return matcher.group();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void dealWithQrScanResult(final String str) {
        Logger.m469i(TAG, "deal with qrscan result");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (ShareConfigManager.getInstance().getInterceptConfig() == null && needWaitTokenParse(str, 3)) {
            this.mWaitTokenParse = true;
            this.mCommand = str;
            this.mTokenType = 3;
            this.mTokenParseCallback = null;
            return;
        }
        this.checkLock = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager.4
            @Override // java.lang.Runnable
            public void run() {
                String checkTextToken = ClipBoardCheckerManager.inst().checkTextToken(str, false);
                if (!TextUtils.isEmpty(checkTextToken)) {
                    TokenParseManager.getInstance().translateCommand(checkTextToken, 3);
                } else {
                    ShareConfigManager.getInstance().handleQrScanResult(ShareConfigManager.getInstance().getTopActivity(), str);
                }
                TokenCheckerManager.getInstance().setHandleImageToken(false);
            }
        });
        this.checkLock = false;
    }
}
