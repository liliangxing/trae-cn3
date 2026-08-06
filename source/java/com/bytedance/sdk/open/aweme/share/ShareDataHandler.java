package com.bytedance.sdk.open.aweme.share;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.share.Share;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ShareDataHandler implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i == 3) {
                Share.Request request = new Share.Request(bundle);
                if (!request.checkArgs()) {
                    return false;
                }
                iApiEventHandler.onReq(request);
                return true;
            }
            if (i == 4) {
                Share.Response response = new Share.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}
