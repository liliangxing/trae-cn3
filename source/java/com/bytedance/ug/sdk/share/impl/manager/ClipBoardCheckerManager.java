package com.bytedance.ug.sdk.share.impl.manager;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.depend.IShareTokenRuleConfig;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.network.model.TokenRefluxInfo;
import com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager;
import com.bytedance.ug.sdk.share.impl.utils.ClipboardCompat;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.SharePrefHelper;
import com.bytedance.ug.sdk.share.impl.utils.UGShareLogger;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClipBoardCheckerManager {
    private static final String TAG = "ClipBoardCheckerManager";
    private final Context mContext;
    private volatile String mNewRuleTokenPending;

    private ClipBoardCheckerManager() {
        this.mContext = ShareSdkManager.getInstance().getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Singleton {
        private static ClipBoardCheckerManager sInstance = new ClipBoardCheckerManager();

        private Singleton() {
        }
    }

    public static ClipBoardCheckerManager inst() {
        return Singleton.sInstance;
    }

    public void checkClipboardToken(String str) {
        if (TokenParseManager.getInstance().getCheckLock()) {
            Logger.m469i(TAG, "checkLock is true");
            return;
        }
        String userCopyContent = getUserCopyContent();
        if (!TextUtils.isEmpty(userCopyContent) && str.equals(userCopyContent)) {
            Logger.m469i(TAG, "cache text is equal to clipboard text");
            UGShareLogger.onSelfTokenReflow();
            ShareConfigManager.getInstance().handleTokenCheckCallback(false, "token", "filtered");
            ClipboardCompat.clearClipBoard();
            ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_SELF, "自己复制的口令");
            return;
        }
        checkAndClearClipBoard(str);
    }

    public boolean checkClipboardTokenSelf(String str, boolean z) {
        if (TokenParseManager.getInstance().getCheckLock()) {
            Logger.m469i(TAG, "checkLock is true");
            return false;
        }
        String userCopyContent = getUserCopyContent();
        if (TextUtils.isEmpty(userCopyContent) || TextUtils.isEmpty(str) || !str.equals(userCopyContent)) {
            return false;
        }
        Logger.m469i(TAG, "checkClipboardTokenSelf cache text is equal to clipboard text");
        UGShareLogger.onSelfTokenReflow();
        ShareConfigManager.getInstance().handleTokenCheckCallback(false, "token", "filtered");
        if (z) {
            ClipboardCompat.clearClipBoard();
        }
        ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_SELF, "自己复制的口令");
        return true;
    }

    private String getUserCopyContent() {
        return SharePrefHelper.getInstance().getPref(SharePrefHelper.SP_USER_COPY_CONTENT, "");
    }

    public void checkAndClearClipBoard(String str) {
        this.mNewRuleTokenPending = null;
        String checkTextToken = checkTextToken(str, true);
        Logger.m463d(TAG, "clipboard command is " + checkTextToken);
        if (TextUtils.isEmpty(checkTextToken) && TextUtils.isEmpty(this.mNewRuleTokenPending)) {
            ShareConfigManager.getInstance().handleTokenCheckCallback(false, "token", "regex match failed");
            ClipboardCompat.onClipBoardResult(ClipboardCompat.CLOP_BOARD_ERR_CODE_PATTERN, "正则匹配失败");
        } else {
            TokenCheckerManager.getInstance().setHandleClipToken(true);
            TokenParseManager.getInstance().translateCommand(checkTextToken, 0);
        }
    }

    public String checkTextToken(String str, boolean z) {
        List<TokenRefluxInfo> tokenActivityRegex;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String checkTokenRegex = TokenParseManager.getInstance().checkTokenRegex(str, ShareSdkManager.getInstance().getTokeShareRegex());
        if (TextUtils.isEmpty(checkTokenRegex) && (tokenActivityRegex = ShareSdkManager.getInstance().getTokenActivityRegex()) != null && tokenActivityRegex.size() > 0) {
            Iterator<TokenRefluxInfo> it = tokenActivityRegex.iterator();
            while (it.hasNext()) {
                checkTokenRegex = TokenParseManager.getInstance().checkTokenRegex(str, it.next().getToken());
                if (!TextUtils.isEmpty(checkTokenRegex)) {
                    break;
                }
            }
        }
        UGShareLogger.onCheckTokenByServerRules(checkTokenRegex);
        if (!TextUtils.isEmpty(checkTokenRegex) || !ShareConfigManager.getInstance().enableNewTokenRule()) {
            return checkTokenRegex;
        }
        String checkTokenByNewRules = checkTokenByNewRules(str, z);
        UGShareLogger.onCheckTokenByClientRules(checkTokenByNewRules);
        return checkTokenByNewRules;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String checkTokenByNewRules(String str, boolean z) {
        if (!ShareConfigManager.getInstance().isLoadedNewRuleLibrary()) {
            Logger.m469i(TAG, "checkTokenByNewRules(), isLoadedNewRuleLibrary is false ");
            if (z) {
                this.mNewRuleTokenPending = str;
                Logger.m463d(TAG, "checkTokenByNewRules(), mNewRuleTokenPending = " + this.mNewRuleTokenPending);
            }
            return null;
        }
        IShareTokenRuleConfig tokenRuleConfig = DependManager.getTokenRuleConfig();
        if (tokenRuleConfig != null) {
            return tokenRuleConfig.onCheckToken(str);
        }
        Logger.m469i(TAG, "checkTokenByNewRules(), IShareTokenRuleConfig is null");
        return null;
    }

    public void tryParseNewRuleToken() {
        Logger.m463d(TAG, "tryParseNewRuleToken(), mNewRuleTokenPending = " + this.mNewRuleTokenPending);
        if (TextUtils.isEmpty(this.mNewRuleTokenPending)) {
            return;
        }
        ShareConfigManager.getInstance().execute(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.manager.ClipBoardCheckerManager.1
            @Override // java.lang.Runnable
            public void run() {
                ClipBoardCheckerManager clipBoardCheckerManager = ClipBoardCheckerManager.this;
                String checkTokenByNewRules = clipBoardCheckerManager.checkTokenByNewRules(clipBoardCheckerManager.mNewRuleTokenPending, true);
                ClipBoardCheckerManager.this.mNewRuleTokenPending = null;
                if (!TextUtils.isEmpty(checkTokenByNewRules)) {
                    TokenParseManager.getInstance().translateCommand(checkTokenByNewRules, 0);
                    return;
                }
                TokenCheckerManager.getInstance().setHandleClipToken(false);
                if (TokenCheckerManager.getInstance().isEnableAlbumParse()) {
                    ShareConfigManager.getInstance().checkImageToken();
                }
            }
        });
    }
}
