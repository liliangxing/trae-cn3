package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.ies.lynx.lynx_adapter.inter.LynxUISetterProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseLynxUIWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010(\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020)H\u0016¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0012\u00100\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J\u0092\u0001\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020#2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0092\u0001\u0010E\u001a\u00020,2\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020#2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00028\u0000X\u0096.¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R6\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c`\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006F"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/BaseLynxUIWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxUIWrapper;", "context", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxContextWrapper;", RemoteMessageConst.MessageBody.PARAM, "", "(Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxContextWrapper;Ljava/lang/Object;)V", "getContext", "()Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxContextWrapper;", "setContext", "(Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxContextWrapper;)V", "mInnerView", "getMInnerView", "()Landroid/view/View;", "setMInnerView", "(Landroid/view/View;)V", "Landroid/view/View;", "mPropSetter", "Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;", "getMPropSetter", "()Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;", "setMPropSetter", "(Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;)V", "mUIMethods", "Ljava/util/HashMap;", "", "Ljava/lang/reflect/Method;", "Lkotlin/collections/HashMap;", "getMUIMethods", "()Ljava/util/HashMap;", "setMUIMethods", "(Ljava/util/HashMap;)V", TicketGuardProviderKt.PATH_SIGN, "", "getSign", "()I", "setSign", "(I)V", "createView", "Landroid/content/Context;", "(Landroid/content/Context;)Landroid/view/View;", "initialize", "", "onAttach", "onDetach", "onLayoutUpdated", "updateExtraData", "extraData", "updateLayout", "left", "top", "width", "height", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "marginLeft", "marginTop", "marginRight", "marginBottom", "borderLeftWidth", "borderTopWidth", "borderRightWidth", "borderBottomWidth", "bound", "Landroid/graphics/Rect;", "updateLayoutInfo", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public abstract class BaseLynxUIWrapper<T extends View> implements LynxUIWrapper<T> {
    private LynxContextWrapper context;
    public T mInnerView;
    private LynxUISetterProxy mPropSetter;
    private HashMap<String, Method> mUIMethods;
    private int sign;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseLynxUIWrapper(LynxContextWrapper lynxContextWrapper) {
        this(lynxContextWrapper, r0, 2, r0);
        DefaultConstructorMarker defaultConstructorMarker = null;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void initialize() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void onAttach() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void onDetach() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void onLayoutUpdated() {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void updateExtraData(Object extraData) {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void updateLayout(int left, int top, int width, int height, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int marginLeft, int marginTop, int marginRight, int marginBottom, int borderLeftWidth, int borderTopWidth, int borderRightWidth, int borderBottomWidth, Rect bound) {
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void updateLayoutInfo(int left, int top, int width, int height, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int marginLeft, int marginTop, int marginRight, int marginBottom, int borderLeftWidth, int borderTopWidth, int borderRightWidth, int borderBottomWidth, Rect bound) {
    }

    public BaseLynxUIWrapper(LynxContextWrapper context, Object obj) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.sign = -1;
        this.mPropSetter = new LynxUISetterProxy.Base();
        this.mUIMethods = new HashMap<>();
    }

    public /* synthetic */ BaseLynxUIWrapper(LynxContextWrapper lynxContextWrapper, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lynxContextWrapper, (i & 2) != 0 ? null : obj);
    }

    public final LynxContextWrapper getContext() {
        return this.context;
    }

    public final void setContext(LynxContextWrapper lynxContextWrapper) {
        Intrinsics.checkParameterIsNotNull(lynxContextWrapper, "<set-?>");
        this.context = lynxContextWrapper;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public T getMInnerView() {
        T t = this.mInnerView;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
        }
        return t;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void setMInnerView(T t) {
        Intrinsics.checkParameterIsNotNull(t, "<set-?>");
        this.mInnerView = t;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public int getSign() {
        return this.sign;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void setSign(int i) {
        this.sign = i;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public LynxUISetterProxy getMPropSetter() {
        return this.mPropSetter;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void setMPropSetter(LynxUISetterProxy lynxUISetterProxy) {
        Intrinsics.checkParameterIsNotNull(lynxUISetterProxy, "<set-?>");
        this.mPropSetter = lynxUISetterProxy;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public HashMap<String, Method> getMUIMethods() {
        return this.mUIMethods;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public void setMUIMethods(HashMap<String, Method> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "<set-?>");
        this.mUIMethods = hashMap;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper
    public T createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return createView(context, null);
    }
}
