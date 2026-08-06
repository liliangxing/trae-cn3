package com.bytedance.sync;

import com.bytedance.sync.logger.LogUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonParamWrapper implements ICommonParamProvider {
    private final ICommonParamProvider mCommonParam;

    public CommonParamWrapper(ICommonParamProvider iCommonParamProvider) {
        this.mCommonParam = iCommonParamProvider;
    }

    @Override // com.bytedance.sync.ICommonParamProvider
    public Map<String, String> getCommonParams() {
        ICommonParamProvider iCommonParamProvider = this.mCommonParam;
        Map<String, String> commonParams = iCommonParamProvider != null ? iCommonParamProvider.getCommonParams() : null;
        if (commonParams == null) {
            commonParams = new HashMap<>();
        }
        commonParams.put(SyncConstants.KEY_VERSION_CODE, String.valueOf(-1));
        appendBizCommonParam(commonParams);
        return commonParams;
    }

    private void appendBizCommonParam(Map<String, String> map) {
        ICommonParamProvider commonParamProvider;
        Map<String, String> commonParams;
        Collection<SyncBusiness> registeredBusinesses = SyncSDK.getRegisteredBusinesses();
        if (registeredBusinesses == null || registeredBusinesses.isEmpty()) {
            return;
        }
        for (SyncBusiness syncBusiness : registeredBusinesses) {
            if (syncBusiness != null && (commonParamProvider = syncBusiness.getCommonParamProvider()) != null && (commonParams = commonParamProvider.getCommonParams()) != null) {
                for (Map.Entry<String, String> entry : commonParams.entrySet()) {
                    if (map.containsKey(entry.getKey())) {
                        LogUtils.m186e("duplicate key between the common param of " + syncBusiness.getBusiness() + " and host/other biz. ignore it");
                    } else {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }
}
