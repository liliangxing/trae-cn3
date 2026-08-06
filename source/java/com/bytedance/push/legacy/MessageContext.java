package com.bytedance.push.legacy;

import android.content.Context;
import com.bytedance.push.Configuration;
import com.ss.android.pushmanager.IMessageContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MessageContext implements IMessageContext {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class MessageContextHolder {
        static final MessageContext mInstance = new MessageContext();

        private MessageContextHolder() {
        }
    }

    public static MessageContext getInstance() {
        return MessageContextHolder.mInstance;
    }

    public Context getContext() {
        return Configuration.get().mApplication;
    }

    public String getAppName() {
        return Configuration.get().mAppName;
    }

    public int getAid() {
        return Configuration.get().mAid;
    }

    public String getTweakedChannel() {
        return Configuration.get().mChannel;
    }

    public String getVersion() {
        return Configuration.get().mVersionName;
    }

    public int getVersionCode() {
        return Configuration.get().mVersionCode;
    }

    public int getUpdateVersionCode() {
        return Configuration.get().mUpdateVersionCode;
    }
}
