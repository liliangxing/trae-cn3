package com.bytedance.sdk.open.aweme.commonability;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;

/* loaded from: classes5.dex */
public class CommonAbilityDataHandler implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i == 9) {
                CommonAbility.Request request = new CommonAbility.Request(bundle);
                if (!request.checkArgs()) {
                    return false;
                }
                iApiEventHandler.onReq(request);
                return true;
            }
            if (i == 10) {
                CommonAbility.Response response = new CommonAbility.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}
