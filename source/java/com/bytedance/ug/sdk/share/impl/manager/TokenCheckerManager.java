package com.bytedance.ug.sdk.share.impl.manager;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.callback.InitDataCallback;
import com.bytedance.ug.sdk.share.impl.callback.TokenParseCallback;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.utils.ClipboardCompat;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.UGShareLogger;
import com.bytedance.ug.sdk.share.impl.utils.WindowFocusUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TokenCheckerManager {
    private static final String TAG = "TokenCheckerManager";
    private InitDataCallback mInitDataCallback;
    private boolean mIsHandleClipToken;
    private boolean mIsHandleImageToken;
    private TokenParseCallback mTokenParseCallback;

    private TokenCheckerManager() {
        this.mIsHandleClipToken = false;
        this.mIsHandleImageToken = false;
        this.mInitDataCallback = new InitDataCallback() { // from class: com.bytedance.ug.sdk.share.impl.manager.TokenCheckerManager.1
            @Override // com.bytedance.ug.sdk.share.impl.callback.InitDataCallback
            public void onFailed() {
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.InitDataCallback
            public void onSuccess() {
                TokenCheckerManager.this.handleToken();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Singleton {
        private static TokenCheckerManager sInstance = new TokenCheckerManager();

        private Singleton() {
        }
    }

    public static TokenCheckerManager getInstance() {
        return Singleton.sInstance;
    }

    public void checkToken() {
        checkToken(null);
    }

    public void checkToken(TokenParseCallback tokenParseCallback) {
        if (ShareConfigManager.getInstance().isLocalMode()) {
            return;
        }
        this.mTokenParseCallback = tokenParseCallback;
        if (!ShareSdkManager.getInstance().isInitData()) {
            Logger.m469i(TAG, "share init did not complete");
            ShareSdkManager.getInstance().setInitDataCallback(this.mInitDataCallback);
        } else {
            handleToken();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleToken() {
        Logger.m469i(TAG, "handleToken() is called");
        UGShareLogger.onHandleTokenStart();
        if (isEnableTextTokenParse()) {
            WindowFocusUtils.ensureGrantWindowFocus(new WindowFocusUtils.WindowFocusCallback() { // from class: com.bytedance.ug.sdk.share.impl.manager.TokenCheckerManager.2
                @Override // com.bytedance.ug.sdk.share.impl.utils.WindowFocusUtils.WindowFocusCallback
                public void onGrantFocus() {
                    TokenCheckerManager tokenCheckerManager = TokenCheckerManager.this;
                    tokenCheckerManager.handleTokenInner(true, tokenCheckerManager.getClipBoardTextAndCheck());
                }
            });
        } else {
            handleTokenInner(false, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getClipBoardTextAndCheck() {
        long currentTimeMillis = System.currentTimeMillis();
        String tryGetClipBoardText = ClipboardCompat.tryGetClipBoardText(ShareSdkManager.getInstance().getAppContext());
        Logger.m469i(TAG, "get clipboard spent = " + (System.currentTimeMillis() - currentTimeMillis));
        if (TextUtils.isEmpty(tryGetClipBoardText)) {
            UGShareLogger.onClipboardEmpty();
            Logger.m469i(TAG, "clipboard text is null");
            ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_EMPTY, "剪切板内容为空");
        }
        return tryGetClipBoardText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTokenInner(final boolean z, final String str) {
        ShareConfigManager.getInstance().execute(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.manager.TokenCheckerManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (z && !TextUtils.isEmpty(str)) {
                    ClipBoardCheckerManager.inst().checkClipboardToken(str);
                }
                if (!TokenCheckerManager.this.mIsHandleClipToken && TokenCheckerManager.this.isEnableAlbumParse()) {
                    ShareConfigManager.getInstance().checkImageToken();
                }
                if (TokenCheckerManager.this.mTokenParseCallback != null) {
                    TokenCheckerManager.this.mTokenParseCallback.onResult(TokenCheckerManager.this.mIsHandleClipToken || TokenCheckerManager.this.mIsHandleImageToken);
                }
            }
        });
    }

    public boolean isEnableAlbumParse() {
        boolean isEnableAlbumParse = ShareConfigManager.getInstance().isEnableAlbumParse();
        Logger.m469i(TAG, "album parse enable status is " + isEnableAlbumParse);
        UGShareLogger.onCheckAlbumParse(isEnableAlbumParse);
        return isEnableAlbumParse;
    }

    private boolean isEnableTextTokenParse() {
        boolean isEnableTextTokenParse = ShareConfigManager.getInstance().isEnableTextTokenParse();
        Logger.m469i(TAG, "text token parse enable status is " + isEnableTextTokenParse);
        UGShareLogger.onCheckTextTokenParse(isEnableTextTokenParse);
        return isEnableTextTokenParse;
    }

    public void setHandleClipToken(boolean z) {
        this.mIsHandleClipToken = z;
    }

    public void setHandleImageToken(boolean z) {
        this.mIsHandleImageToken = z;
    }
}
