package com.bytedance.ug.sdk.share.impl.p009ui.token.recognize;

import android.app.Activity;
import com.bytedance.share_ui.R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ArticleNoPicTokenDialog extends AbsTokenDialog {
    @Override // com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.AbsTokenDialog
    public void initActions() {
    }

    public ArticleNoPicTokenDialog(Activity activity) {
        super(activity);
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.AbsTokenDialog
    public int getLayoutId() {
        return R.layout.share_sdk_article_nopic_login_token_dialog;
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.AbsTokenDialog
    public void initViews() {
        if (this.mTitleTV != null) {
            this.mTitleTV.setMaxLines(3);
        }
    }
}
