package com.bytedance.pia.core.metrics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface TraceEvent {
    public static final String INITIALIZE_END = "initialize.end";
    public static final String INITIALIZE_START = "initialize.start";
    public static final String INITIALIZE_WORKER_END = "initialize_worker.end";
    public static final String INITIALIZE_WORKER_START = "initialize_worker.start";
    public static final String INTERCEPT_HTML_END = "intercept_html.end";
    public static final String INTERCEPT_HTML_START = "intercept_html.start";
    public static final String IS_WARMUP = "pia_is_warmup";
    public static final String MANIFEST_PARSE_END = "manifest_parse.end";
    public static final String MANIFEST_PARSE_START = "manifest_parse.start";
    public static final String REQUEST_HTML_END = "request_html.end";
    public static final String REQUEST_HTML_START = "request_html.start";
    public static final String REQUEST_WORKER_END = "request_worker.end";
    public static final String REQUEST_WORKER_START = "request_worker.start";
    public static final String WARMUP_END = "warmup.end";
    public static final String WARMUP_START = "warmup.start";
}
