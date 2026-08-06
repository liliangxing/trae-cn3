package com.bytedance.sdk.open.tt;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.douyin.model.OpenRecord;

/* renamed from: com.bytedance.sdk.open.tt.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0137c implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i == 7) {
                OpenRecord.Request request = new OpenRecord.Request(bundle);
                if (!request.checkArgs()) {
                    return false;
                }
                iApiEventHandler.onReq(request);
                return true;
            }
            if (i == 8) {
                OpenRecord.Response response = new OpenRecord.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}
