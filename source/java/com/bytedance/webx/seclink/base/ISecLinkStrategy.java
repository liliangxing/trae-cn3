package com.bytedance.webx.seclink.base;

/* loaded from: classes6.dex */
public interface ISecLinkStrategy {
    boolean canGoBack();

    boolean handleGoBack();

    String handleLoadUrl(String str);

    void handleOverrideUrlLoading(String str);

    void prepare();

    void setAid(String str);

    void setBizInfoProvider(IBizInfoProvider iBizInfoProvider);

    void setCheckCallback(SecLinkCheckCallback secLinkCheckCallback);

    void setScene(String str);

    void setWebEnvProvider(IWebEnvProvider iWebEnvProvider);

    boolean syncHandleOverrideUrlLoading(String str);
}
