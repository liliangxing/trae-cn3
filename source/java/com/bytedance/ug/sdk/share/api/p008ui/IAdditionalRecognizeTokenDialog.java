package com.bytedance.ug.sdk.share.api.p008ui;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IAdditionalRecognizeTokenDialog {
    IRecognizeTokenDialog getRecognizeTokenDialog(Activity activity, TokenInfoBean tokenInfoBean);

    boolean handleRecognizeToken(Activity activity, TokenInfoBean tokenInfoBean);
}
