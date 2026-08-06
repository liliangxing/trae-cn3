package com.bytedance.pia.core.worker.bridge;

/* loaded from: classes4.dex */
public class PolyfillCompat {
    public static final String VALUE = "!function(){var e=globalThis.NativeModules,t=e.get(\"BaseModule\");globalThis.location={href:t.getHref()},globalThis.navigator={userAgent:t.getUserAgent()},globalThis.NativeModules={get:function(l){var a=e.get(l);return\"BaseModule\"==l?Object.assign(a,{storeNSRHtml:function(e){t.terminateWithResult({html:e})}}):a}}}();";
}
