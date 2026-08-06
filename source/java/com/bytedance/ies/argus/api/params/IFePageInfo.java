package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.aspect.eventCenter.FeAuthConfig;
import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;

/* compiled from: IFePageInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "feAuthConfig", "Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "getFeAuthConfig", "()Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "setFeAuthConfig", "(Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;)V", "feId", "", "getFeId", "()J", "setFeId", "(J)V", WebViewContainer.EVENT_loadUrl, "", "getLoadUrl", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface IFePageInfo {
    ArgusContainerType getContainerType();

    FeAuthConfig getFeAuthConfig();

    long getFeId();

    String getLoadUrl();

    void setFeAuthConfig(FeAuthConfig feAuthConfig);

    void setFeId(long j);
}
