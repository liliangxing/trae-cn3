package com.bytedance.pia.core.utils;

import com.bytedance.pia.core.api.resource.IResourceResponse;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;

/* compiled from: ResourceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pia/core/utils/ResourceUtils;", "", "()V", "readAsString", "", "Lcom/bytedance/pia/core/api/resource/IResourceResponse;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = new ResourceUtils();

    private ResourceUtils() {
    }

    @JvmStatic
    public static final String readAsString(IResourceResponse iResourceResponse) {
        Object obj;
        InputStream data;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(iResourceResponse != null ? iResourceResponse.getEncoding() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (iResourceResponse == null || (data = iResourceResponse.getData()) == null) {
            return null;
        }
        return StreamUtils.readAndClose(data, str);
    }
}
