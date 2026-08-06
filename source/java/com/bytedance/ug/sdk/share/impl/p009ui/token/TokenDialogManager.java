package com.bytedance.ug.sdk.share.impl.p009ui.token;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.p008ui.IRecognizeTokenDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.ArticleNoPicTokenDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.ArticleWithPicTokenDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.LittleVideoTokenDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.VideoTokenDialog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TokenDialogManager {
    private static final int RECOGNIZE_DIALOG_TYPE_AUDIO = 5;
    private static final int RECOGNIZE_DIALOG_TYPE_LITTLE_VIDEO = 4;
    private static final int RECOGNIZE_DIALOG_TYPE_PICS = 2;
    private static final int RECOGNIZE_DIALOG_TYPE_PIC_TEXT = 1;
    private static final int RECOGNIZE_DIALOG_TYPE_TEXT = 0;
    private static final int RECOGNIZE_DIALOG_TYPE_VIDEO = 3;

    private TokenDialogManager() {
    }

    public static TokenDialogManager getInstance() {
        return Singleton.sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class Singleton {
        private static TokenDialogManager sInstance = new TokenDialogManager();

        private Singleton() {
        }
    }

    public IRecognizeTokenDialog getRecognizeTokenDialog(Activity activity, TokenInfoBean tokenInfoBean) {
        int mediaType = tokenInfoBean.getMediaType();
        if (tokenInfoBean.getPicCnt() < 1 || (tokenInfoBean.getPics() != null && tokenInfoBean.getPics().size() < 1)) {
            return new ArticleNoPicTokenDialog(activity);
        }
        if (mediaType != 0) {
            if (mediaType == 1 || mediaType == 2) {
                return new ArticleWithPicTokenDialog(activity);
            }
            if (mediaType == 3) {
                return new VideoTokenDialog(activity);
            }
            if (mediaType == 4) {
                return new LittleVideoTokenDialog(activity);
            }
            if (mediaType != 5) {
                return null;
            }
        }
        return new ArticleNoPicTokenDialog(activity);
    }
}
