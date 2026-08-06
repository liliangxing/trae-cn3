package com.bytedance.tracing.tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface TagTypeInf {
    public static final String ERROR = "error";
    public static final String SPAN_KIND = "span.kind";
}
