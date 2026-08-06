package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.IMessageHandler;
import com.monitor.cloudmessage.obversable.CloudMessageObservable;
import com.monitor.cloudmessage.obversable.CloudMessageObserver;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import java.util.Enumeration;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ObversableMessageHandler implements CloudMessageObservable, IMessageHandler {
    @Override // com.monitor.cloudmessage.handler.IMessageHandler
    public boolean handleCloudMessage(CloudMessage cloudMessage) {
        return dispatchCloudMessage(cloudMessage);
    }

    @Override // com.monitor.cloudmessage.obversable.CloudMessageObservable
    public boolean dispatchCloudMessage(CloudMessage cloudMessage) {
        Enumeration obverserList = CloudMessageManager.getInstance().getObverserList();
        if (obverserList == null) {
            return false;
        }
        while (obverserList.hasMoreElements()) {
            CloudMessageObserver cloudMessageObserver = (CloudMessageObserver) obverserList.nextElement();
            if (cloudMessageObserver != null && cloudMessageObserver.obverseCloudMessage(cloudMessage)) {
                CloudMessageUploadManager.upload(new UploadInfo(0L, false, cloudMessage.getCommandId(), null));
                return true;
            }
        }
        return false;
    }
}
