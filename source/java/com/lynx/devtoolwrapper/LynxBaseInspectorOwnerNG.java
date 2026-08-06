package com.lynx.devtoolwrapper;

import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.tasm.provider.LynxResourceCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface LynxBaseInspectorOwnerNG extends LynxBaseInspectorOwner {
    void downloadResource(String str, LynxResourceCallback<byte[]> lynxResourceCallback);

    void onRegisterModule(LynxModuleFactory lynxModuleFactory);

    void sendMessage(CustomizedMessage customizedMessage);

    void subscribeMessage(String str, MessageHandler messageHandler);

    void unsubscribeMessage(String str);
}
