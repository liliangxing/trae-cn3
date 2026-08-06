package com.huawei.hms.p030ui;

import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractPromptDialog extends AbstractDialog {
    @Override // com.huawei.hms.p030ui.AbstractDialog
    protected String onGetNegativeButtonString(Context context) {
        return null;
    }

    @Override // com.huawei.hms.p030ui.AbstractDialog
    protected String onGetTitleString(Context context) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context);
        }
        return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
    }
}
