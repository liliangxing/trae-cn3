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

/* compiled from: LynxUIWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020 H&¢\u0006\u0002\u0010!J\u001f\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020%H&J\b\u0010'\u001a\u00020%H&J\b\u0010(\u001a\u00020%H&J\u0012\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010\u0003H&J\u0092\u0001\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010=H&J\u0092\u0001\u0010>\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010=H&R\u0018\u0010\u0004\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR4\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006?"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxUIWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "mInnerView", "getMInnerView", "()Landroid/view/View;", "setMInnerView", "(Landroid/view/View;)V", "mPropSetter", "Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;", "getMPropSetter", "()Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;", "setMPropSetter", "(Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;)V", "mUIMethods", "Ljava/util/HashMap;", "", "Ljava/lang/reflect/Method;", "Lkotlin/collections/HashMap;", "getMUIMethods", "()Ljava/util/HashMap;", "setMUIMethods", "(Ljava/util/HashMap;)V", TicketGuardProviderKt.PATH_SIGN, "", "getSign", "()I", "setSign", "(I)V", "createView", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Landroid/view/View;", RemoteMessageConst.MessageBody.PARAM, "(Landroid/content/Context;Ljava/lang/Object;)Landroid/view/View;", "initialize", "", "onAttach", "onDetach", "onLayoutUpdated", "updateExtraData", "extraData", "updateLayout", "left", "top", "width", "height", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "marginLeft", "marginTop", "marginRight", "marginBottom", "borderLeftWidth", "borderTopWidth", "borderRightWidth", "borderBottomWidth", "bound", "Landroid/graphics/Rect;", "updateLayoutInfo", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface LynxUIWrapper<T extends View> {
    T createView(Context context);

    T createView(Context context, Object param);

    T getMInnerView();

    LynxUISetterProxy getMPropSetter();

    HashMap<String, Method> getMUIMethods();

    int getSign();

    void initialize();

    void onAttach();

    void onDetach();

    void onLayoutUpdated();

    void setMInnerView(T t);

    void setMPropSetter(LynxUISetterProxy lynxUISetterProxy);

    void setMUIMethods(HashMap<String, Method> hashMap);

    void setSign(int i);

    void updateExtraData(Object extraData);

    void updateLayout(int left, int top, int width, int height, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int marginLeft, int marginTop, int marginRight, int marginBottom, int borderLeftWidth, int borderTopWidth, int borderRightWidth, int borderBottomWidth, Rect bound);

    void updateLayoutInfo(int left, int top, int width, int height, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int marginLeft, int marginTop, int marginRight, int marginBottom, int borderLeftWidth, int borderTopWidth, int borderRightWidth, int borderBottomWidth, Rect bound);
}
