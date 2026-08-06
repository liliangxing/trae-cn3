package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* renamed from: com.hihonor.push.sdk.f1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC0924f1<TResult> {

    /* renamed from: a */
    public C0943n0<TResult> f711a;

    /* renamed from: b */
    public final String f712b;

    /* renamed from: c */
    public final IMessageEntity f713c;

    /* renamed from: d */
    public final C0960w f714d;

    /* renamed from: e */
    public RequestHeader f715e;

    public AbstractC0924f1(String str, IMessageEntity iMessageEntity) {
        this.f712b = str;
        this.f713c = iMessageEntity;
        this.f714d = C0960w.m782a(str);
    }

    /* renamed from: a */
    public abstract void mo758a(ApiException apiException, Object obj);

    /* renamed from: b */
    public final void m767b(ApiException apiException, Object obj) {
        if (this.f711a != null) {
            mo758a(apiException, obj);
        } else {
            String str = "This Task has been canceled, uri:" + this.f712b;
        }
    }
}
