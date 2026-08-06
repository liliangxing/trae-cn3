package com.bytedance.ug.sdk.share.channel.wechat.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.callback.ShareEventCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseWXEntryActivity extends Activity implements IWXAPIEventHandler {
    public void onReq(BaseReq baseReq) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String weChatKey = ShareConfigManager.getInstance().getWeChatKey();
        IWXAPI createWXAPI = !TextUtils.isEmpty(weChatKey) ? WXAPIFactory.createWXAPI(this, weChatKey, true) : null;
        if (createWXAPI != null) {
            createWXAPI.handleIntent(getIntent(), this);
        }
        finish();
    }

    public void onResp(BaseResp baseResp) {
        if (baseResp != null && baseResp.getType() == 2) {
            ShareResult shareResult = new ShareResult(ShareResult.ERROR_SDK_UNKNOWN, ShareSdkManager.getInstance().getCurrentShareChannelType());
            if (baseResp.errCode == 0) {
                shareResult.errorCode = 10000;
            } else if (baseResp.errCode == -2) {
                shareResult.errorCode = 10001;
            } else {
                shareResult.errorCode = ShareResult.SHARE_FAILED;
            }
            shareResult.detailErrorCode = baseResp.errCode;
            shareResult.errorMsg = baseResp.errStr;
            ShareEventCallback shareEventCallback = ShareSdkManager.getInstance().getShareEventCallback();
            if (shareEventCallback != null) {
                shareEventCallback.onShareResultEvent(shareResult);
                ShareSdkManager.getInstance().resetShareEventCallback();
            }
        }
    }
}
