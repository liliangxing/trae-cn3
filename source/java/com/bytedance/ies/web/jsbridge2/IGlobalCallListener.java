package com.bytedance.ies.web.jsbridge2;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IGlobalCallListener {
    default void onRawCall(Js2JavaCall js2JavaCall, BaseRawMethod baseRawMethod, CallContext callContext) {
    }

    default void onStatefulCall(Js2JavaCall js2JavaCall, BaseStatefulMethod baseStatefulMethod, CallContext callContext) {
    }

    default void onStatelessCall(Js2JavaCall js2JavaCall, BaseStatelessMethod baseStatelessMethod, CallContext callContext) {
    }
}
