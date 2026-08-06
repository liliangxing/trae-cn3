package com.lynx.tasm.group;

import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ILynxViewGroup extends ILynxViewConfigProvider {
    void addLynxView(int i, LynxView lynxView);

    void fetchTemplateBundle(LynxResourceCallback<TemplateBundle> lynxResourceCallback);

    int generateNextLynxViewID();

    TemplateData getGlobalProps();

    LynxView getLynxViewById(int i);

    TemplateBundle getTemplateBundle();

    TemplateBundle getTemplateBundleNonBlocking();

    String getUrl();

    boolean isTemplateBundleReady();

    void registerModule(String str, Class<? extends LynxModule> cls, Object obj);

    void removeLynxView(int i);
}
