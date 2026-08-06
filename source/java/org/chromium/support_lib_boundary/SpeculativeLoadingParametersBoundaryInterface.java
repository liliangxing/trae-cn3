package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;
import java.util.Map;
import org.jspecify.annotations.NullMarked;

@NullMarked
/* loaded from: classes3.dex */
public interface SpeculativeLoadingParametersBoundaryInterface {
    Map<String, String> getAdditionalHeaders();

    InvocationHandler getNoVarySearchData();

    default Integer getVariationsId() {
        return null;
    }

    boolean isJavaScriptEnabled();
}
