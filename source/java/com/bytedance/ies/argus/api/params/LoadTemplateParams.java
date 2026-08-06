package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* compiled from: LoadTemplateParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/api/params/LoadTemplateParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithoutRewrite;", "isMainTemplate", "", "loaderInfo", "Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "enterFrom", "", "(ZLcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;Ljava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "()Z", "getLoaderInfo", "()Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LoadTemplateParams extends BaseAspectParamsWithoutRewrite {
    private final String enterFrom;
    private final boolean isMainTemplate;
    private final ArgusResourceLoaderInfo loaderInfo;

    /* renamed from: isMainTemplate, reason: from getter */
    public final boolean getIsMainTemplate() {
        return this.isMainTemplate;
    }

    public final ArgusResourceLoaderInfo getLoaderInfo() {
        return this.loaderInfo;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public LoadTemplateParams(boolean z, ArgusResourceLoaderInfo argusResourceLoaderInfo, String str) {
        this.isMainTemplate = z;
        this.loaderInfo = argusResourceLoaderInfo;
        this.enterFrom = str;
    }
}
