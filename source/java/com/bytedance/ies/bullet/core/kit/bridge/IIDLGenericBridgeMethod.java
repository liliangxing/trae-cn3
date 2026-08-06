package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u001aJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H&J#\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H&¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&J\u001c\u0010\u0019\u001a\u00020\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&R\u0018\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod;", "INPUT", "OUTPUT", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "innerClassType", "Ljava/lang/Class;", "getInnerClassType", "()Ljava/lang/Class;", "inputConverter", "Lkotlin/Function1;", "", "getInputConverter", "()Lkotlin/jvm/functions/Function1;", "outputConverter", "getOutputConverter", "createCallbackProxy", "Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod$ICallback;", "proxy", "handle", "", "params", JsCallParser.VALUE_CALLBACK, "(Ljava/lang/Object;Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod$ICallback;)V", "setLocalInputConverter", "converter", "setLocalOutputConverter", "ICallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IIDLGenericBridgeMethod<INPUT, OUTPUT> extends IGenericBridgeMethod {

    /* compiled from: BridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J%\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod$ICallback;", "OUTPUT", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "onComplete", "", "data", "(Ljava/lang/Object;)V", "onError", "code", "", "message", "", "(ILjava/lang/String;Ljava/lang/Object;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface ICallback<OUTPUT> extends IGenericBridgeMethod.ICallback {
        void onComplete(OUTPUT data);

        void onError(int code, String message);

        void onError(int code, String message, OUTPUT data);
    }

    ICallback<OUTPUT> createCallbackProxy(ICallback<OUTPUT> proxy);

    Class<?> getInnerClassType();

    Function1<Object, INPUT> getInputConverter();

    Function1<OUTPUT, Object> getOutputConverter();

    void handle(INPUT params, ICallback<OUTPUT> callback);

    void setLocalInputConverter(Function1<Object, ? extends Object> converter);

    void setLocalOutputConverter(Function1<Object, ? extends Object> converter);
}
