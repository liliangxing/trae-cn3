package com.bytedance.apm.data.pipeline;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.data.BaseDataPipeline;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonDataPipeline extends BaseDataPipeline<ITypeData> {
    private static volatile CommonDataPipeline singleton;
    private ICommonDataInnerListener mCommonDataListener;

    private CommonDataPipeline() {
    }

    public static CommonDataPipeline getInstance() {
        if (singleton == null) {
            synchronized (CommonDataPipeline.class) {
                if (singleton == null) {
                    singleton = new CommonDataPipeline();
                }
            }
        }
        return singleton;
    }

    public void setCommonDataListener(ICommonDataInnerListener iCommonDataInnerListener) {
        this.mCommonDataListener = iCommonDataInnerListener;
    }

    @Override // com.bytedance.apm.data.BaseDataPipeline
    protected void handleAfterReady(ITypeData iTypeData) {
        JSONObject packLog = iTypeData.packLog();
        boolean isSampled = iTypeData.isSampled(packLog);
        if (ApmContext.isDebugMode()) {
            try {
                Logger.iJson(DebugLogger.TAG_FLOW, "logType: " + iTypeData.getTypeLabel() + ", subType: " + iTypeData.getSubTypeLabel() + "data: " + packLog, " ,sample: " + isSampled);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (isSampled || iTypeData.supportFetch()) {
            logSend(iTypeData.getTypeLabel(), iTypeData.getSubTypeLabel(), packLog, isSampled, false);
            ICommonDataInnerListener iCommonDataInnerListener = this.mCommonDataListener;
            if (iCommonDataInnerListener != null) {
                iCommonDataInnerListener.deliver(iTypeData.getTypeLabel(), iTypeData.getSubTypeLabel(), packLog);
            }
        }
    }
}
