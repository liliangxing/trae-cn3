package com.larus.business.markdown.api.model;

import io.noties.markwon.Markwon;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IMarkwonStruct.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getCustomMarkDownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "loading", "", "getLoading", "()Z", "markwon", "Lio/noties/markwon/Markwon;", "getMarkwon", "()Lio/noties/markwon/Markwon;", "maxContentWidth", "", "getMaxContentWidth", "()Ljava/lang/Integer;", "setMaxContentWidth", "(Ljava/lang/Integer;)V", "payload", "", "", "getPayload", "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IMarkwonStruct {
    CustomMarkDownInfo getCustomMarkDownInfo();

    boolean getLoading();

    Markwon getMarkwon();

    Integer getMaxContentWidth();

    Map<String, Object> getPayload();

    void setMaxContentWidth(Integer num);

    void setPayload(Map<String, ? extends Object> map);
}
