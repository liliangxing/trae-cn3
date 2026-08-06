package com.bytedance.ies.bullet.service.popup;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.base.core.common.PadAdapterStyle;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import com.bytedance.ies.bullet.p003ui.common.utils.BulletPadAdapterUtil;
import com.bytedance.ies.bullet.p003ui.common.utils.StatusBarUtil;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.model.BDXPopupModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.DoubleParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.PercentParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupTriggerParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupTriggerType;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.npth.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupFragmentConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bt\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 ª\u00012\u00020\u0001:\u0002ª\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ/\u0010\u009c\u0001\u001a\u00020\u00122\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u00012\u0006\u0010\b\u001a\u00020\t2\u0007\u0010\u009f\u0001\u001a\u00020\u00122\u0007\u0010 \u0001\u001a\u00020\u0012H\u0002J\u001d\u0010¡\u0001\u001a\u00020\u00122\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u00012\u0006\u0010\b\u001a\u00020\tH\u0002J\u001d\u0010¢\u0001\u001a\u00020\u00122\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u00012\u0006\u0010\b\u001a\u00020\tH\u0002J\u0007\u0010£\u0001\u001a\u00020\fJ\u0007\u0010¤\u0001\u001a\u00020\fJ\u0007\u0010¥\u0001\u001a\u00020\fJ\u0007\u0010¦\u0001\u001a\u00020\fJ\u0010\u0010§\u0001\u001a\u00030¨\u00012\u0006\u0010\b\u001a\u00020\tJ\u0007\u0010©\u0001\u001a\u00020\fR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001a\u0010\u001e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u001a\u0010!\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u001a\u0010'\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\u001a\u0010-\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\u001a\u00100\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u00103R\u001a\u00107\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u001a\u0010:\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u00103R\u001a\u0010=\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u00103R\u001e\u0010@\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0013\u0010F\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u001aR\u001a\u0010H\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0014\"\u0004\bJ\u00103R\u001a\u0010K\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0014\"\u0004\bM\u00103R\u001a\u0010N\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000e\"\u0004\bP\u0010\u0010R\u001a\u0010Q\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u000e\"\u0004\bS\u0010\u0010R\u001a\u0010T\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000e\"\u0004\bV\u0010\u0010R\u001a\u0010W\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000e\"\u0004\bX\u0010\u0010R\u001a\u0010Y\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010\u0010R\u001a\u0010\\\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000e\"\u0004\b^\u0010\u0010R\u001a\u0010_\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000e\"\u0004\ba\u0010\u0010R\u001a\u0010b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0014\"\u0004\bd\u00103R\u001e\u0010e\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bf\u0010B\"\u0004\bg\u0010DR\u001a\u0010h\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001a\u0010m\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0014\"\u0004\bo\u00103R\u001a\u0010p\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0014\"\u0004\br\u00103R\u001a\u0010s\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0014\"\u0004\bu\u00103R\u0011\u0010v\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001a\u0010y\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0014\"\u0004\b{\u00103R\u001a\u0010|\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0014\"\u0004\b~\u00103R\u0012\u0010\u007f\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010jR\u001d\u0010\u0081\u0001\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010j\"\u0005\b\u0083\u0001\u0010lR!\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0012\n\u0002\u0010E\u001a\u0005\b\u0085\u0001\u0010B\"\u0005\b\u0086\u0001\u0010DR\u001d\u0010\u0087\u0001\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0014\"\u0005\b\u0089\u0001\u00103R \u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R \u0010\u0090\u0001\u001a\u00030\u0091\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001d\u0010\u0096\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u000e\"\u0005\b\u0098\u0001\u0010\u0010R\u001d\u0010\u0099\u0001\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0014\"\u0005\b\u009b\u0001\u00103¨\u0006«\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/PopupFragmentConfig;", "", "bid", "", "url", "Landroid/net/Uri;", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/net/Uri;Landroid/os/Bundle;Landroid/content/Context;)V", "allowClosed", "", "getAllowClosed", "()Z", "setAllowClosed", "(Z)V", "baseHeight", "", "getBaseHeight", "()I", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "getBundle", "()Landroid/os/Bundle;", "clickThroughMask", "getClickThroughMask", "setClickThroughMask", "closeByGesture", "getCloseByGesture", "setCloseByGesture", "closeByMask", "getCloseByMask", "setCloseByMask", "compatCoordinateLayoutScollView", "getCompatCoordinateLayoutScollView", "setCompatCoordinateLayoutScollView", "disableImmersive", "getDisableImmersive", "setDisableImmersive", "dragBack", "getDragBack", "setDragBack", "dragByGesture", "getDragByGesture", "setDragByGesture", "dragDownCloseThreshold", "getDragDownCloseThreshold", "setDragDownCloseThreshold", "(I)V", "dragDownThreshold", "getDragDownThreshold", "setDragDownThreshold", "dragFollowGesture", "getDragFollowGesture", "setDragFollowGesture", "dragHeight", "getDragHeight", "setDragHeight", "dragUpThreshold", "getDragUpThreshold", "setDragUpThreshold", "dragUppingThreshold", "getDragUppingThreshold", "()Ljava/lang/Integer;", "setDragUppingThreshold", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "extraBundle", "getExtraBundle", "height", "getHeight", "setHeight", "heightPercent", "getHeightPercent", "setHeightPercent", "hideNavBar", "getHideNavBar", "setHideNavBar", "hideStatusBar", "getHideStatusBar", "setHideStatusBar", "ignoreKeyboardPadding", "getIgnoreKeyboardPadding", "setIgnoreKeyboardPadding", "isAdjustPan", "setAdjustPan", "keyboardAdjust", "getKeyboardAdjust", "setKeyboardAdjust", "listenKeyboard", "getListenKeyboard", "setListenKeyboard", "maskCloseUntilLoaded", "getMaskCloseUntilLoaded", "setMaskCloseUntilLoaded", "maskColor", "getMaskColor", "setMaskColor", "navBarColor", "getNavBarColor", "setNavBarColor", "originContainerId", "getOriginContainerId", "()Ljava/lang/String;", "setOriginContainerId", "(Ljava/lang/String;)V", "peekDownCloseThreshold", "getPeekDownCloseThreshold", "setPeekDownCloseThreshold", "radius", "getRadius", "setRadius", "resizeDuration", "getResizeDuration", "setResizeDuration", "schema", "getSchema", "()Landroid/net/Uri;", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "sessionId", "getSessionId", SchemaConstants.QUERY_KEY_TITLE, "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "touchLimit", "getTouchLimit", "setTouchLimit", "triggerOrigin", "Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerType;", "getTriggerOrigin", "()Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerType;", "setTriggerOrigin", "(Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerType;)V", "type", "Lcom/bytedance/ies/bullet/service/sdk/param/PopupType;", "getType", "()Lcom/bytedance/ies/bullet/service/sdk/param/PopupType;", "setType", "(Lcom/bytedance/ies/bullet/service/sdk/param/PopupType;)V", "uniformStyleAdapter", "getUniformStyleAdapter", "setUniformStyleAdapter", "width", "getWidth", "setWidth", "initHeight", "popupModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPopupModel;", "totalHeight", "statusBarHeight", "initRadius", "initWidth", "isDelayOpen", "isFullScreen", "isScanOpen", "showOnSuccess", "updateWithContext", "", "useBridge3", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PopupFragmentConfig {
    public static final String TAG = "PopupLog";
    public static final int UNDEFINED = -1;
    private boolean allowClosed;
    private int baseHeight;
    private final BulletContext bulletContext;
    private final Bundle bundle;
    private boolean clickThroughMask;
    private boolean closeByGesture;
    private boolean closeByMask;
    private boolean compatCoordinateLayoutScollView;
    private boolean disableImmersive;
    private boolean dragBack;
    private boolean dragByGesture;
    private int dragDownCloseThreshold;
    private int dragDownThreshold;
    private boolean dragFollowGesture;
    private int dragHeight;
    private int dragUpThreshold;
    private Integer dragUppingThreshold;
    private final Bundle extraBundle;
    private int height;
    private int heightPercent;
    private boolean hideNavBar;
    private boolean hideStatusBar;
    private boolean ignoreKeyboardPadding;
    private boolean isAdjustPan;
    private boolean keyboardAdjust;
    private boolean listenKeyboard;
    private boolean maskCloseUntilLoaded;
    private int maskColor;
    private Integer navBarColor;
    private String originContainerId;
    private int peekDownCloseThreshold;
    private int radius;
    private int resizeDuration;
    private final Uri schema;
    private int screenHeight;
    private int screenWidth;
    private final String sessionId;
    private String title;
    private Integer titleColor;
    private int touchLimit;
    private PopupTriggerType triggerOrigin;
    private PopupType type;
    private boolean uniformStyleAdapter;
    private int width;

    public PopupFragmentConfig(String str, Uri uri, Bundle bundle, Context context) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        Intrinsics.checkNotNullParameter(context, "context");
        this.schema = uri;
        this.bundle = bundle;
        this.allowClosed = true;
        this.dragDownCloseThreshold = -1;
        this.dragDownThreshold = -1;
        this.dragFollowGesture = true;
        this.dragHeight = -1;
        this.dragUpThreshold = -1;
        this.height = -1;
        this.hideNavBar = true;
        this.isAdjustPan = true;
        this.originContainerId = "";
        this.peekDownCloseThreshold = -1;
        this.resizeDuration = PatchException.ERR_LOAD_SO_MD5_NOT_MATCH;
        this.screenHeight = -1;
        this.screenWidth = -1;
        this.title = "";
        this.triggerOrigin = PopupTriggerType.FINISH;
        this.type = PopupType.CENTER;
        this.width = -1;
        this.heightPercent = -1;
        this.baseHeight = -1;
        BulletContext orCreateContext$default = BulletContextManager.getOrCreateContext$default(BulletContextManager.INSTANCE.getInstance(), str, uri, bundle, false, null, 24, null);
        this.bulletContext = orCreateContext$default;
        this.sessionId = orCreateContext$default.getSessionId();
        this.uniformStyleAdapter = (AnnieXRuntime.INSTANCE.getDeviceDepend().isPad() || AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) && BulletPadAdapterUtil.INSTANCE.getPadAdapterStyle(orCreateContext$default.getSchemaModelUnion().getSchemaData()) == PadAdapterStyle.UNIFORM_STYLE;
        if (context instanceof Activity) {
            updateWithContext(context);
        }
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    public final Uri getSchema() {
        return this.schema;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final Bundle getExtraBundle() {
        return this.extraBundle;
    }

    public final boolean getAllowClosed() {
        return this.allowClosed;
    }

    public final void setAllowClosed(boolean z) {
        this.allowClosed = z;
    }

    public final boolean getClickThroughMask() {
        return this.clickThroughMask;
    }

    public final void setClickThroughMask(boolean z) {
        this.clickThroughMask = z;
    }

    public final boolean getCloseByGesture() {
        return this.closeByGesture;
    }

    public final void setCloseByGesture(boolean z) {
        this.closeByGesture = z;
    }

    public final boolean getCloseByMask() {
        return this.closeByMask;
    }

    public final void setCloseByMask(boolean z) {
        this.closeByMask = z;
    }

    public final boolean getDisableImmersive() {
        return this.disableImmersive;
    }

    public final void setDisableImmersive(boolean z) {
        this.disableImmersive = z;
    }

    public final boolean getDragBack() {
        return this.dragBack;
    }

    public final void setDragBack(boolean z) {
        this.dragBack = z;
    }

    public final boolean getDragByGesture() {
        return this.dragByGesture;
    }

    public final void setDragByGesture(boolean z) {
        this.dragByGesture = z;
    }

    public final int getDragDownCloseThreshold() {
        return this.dragDownCloseThreshold;
    }

    public final void setDragDownCloseThreshold(int i) {
        this.dragDownCloseThreshold = i;
    }

    public final int getDragDownThreshold() {
        return this.dragDownThreshold;
    }

    public final void setDragDownThreshold(int i) {
        this.dragDownThreshold = i;
    }

    public final boolean getDragFollowGesture() {
        return this.dragFollowGesture;
    }

    public final void setDragFollowGesture(boolean z) {
        this.dragFollowGesture = z;
    }

    public final int getDragHeight() {
        return this.dragHeight;
    }

    public final void setDragHeight(int i) {
        this.dragHeight = i;
    }

    public final int getDragUpThreshold() {
        return this.dragUpThreshold;
    }

    public final void setDragUpThreshold(int i) {
        this.dragUpThreshold = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final boolean getHideNavBar() {
        return this.hideNavBar;
    }

    public final void setHideNavBar(boolean z) {
        this.hideNavBar = z;
    }

    /* renamed from: isAdjustPan, reason: from getter */
    public final boolean getIsAdjustPan() {
        return this.isAdjustPan;
    }

    public final void setAdjustPan(boolean z) {
        this.isAdjustPan = z;
    }

    public final boolean getKeyboardAdjust() {
        return this.keyboardAdjust;
    }

    public final void setKeyboardAdjust(boolean z) {
        this.keyboardAdjust = z;
    }

    public final boolean getListenKeyboard() {
        return this.listenKeyboard;
    }

    public final void setListenKeyboard(boolean z) {
        this.listenKeyboard = z;
    }

    public final boolean getIgnoreKeyboardPadding() {
        return this.ignoreKeyboardPadding;
    }

    public final void setIgnoreKeyboardPadding(boolean z) {
        this.ignoreKeyboardPadding = z;
    }

    public final boolean getMaskCloseUntilLoaded() {
        return this.maskCloseUntilLoaded;
    }

    public final void setMaskCloseUntilLoaded(boolean z) {
        this.maskCloseUntilLoaded = z;
    }

    public final int getMaskColor() {
        return this.maskColor;
    }

    public final void setMaskColor(int i) {
        this.maskColor = i;
    }

    public final Integer getNavBarColor() {
        return this.navBarColor;
    }

    public final void setNavBarColor(Integer num) {
        this.navBarColor = num;
    }

    public final String getOriginContainerId() {
        return this.originContainerId;
    }

    public final void setOriginContainerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originContainerId = str;
    }

    public final int getPeekDownCloseThreshold() {
        return this.peekDownCloseThreshold;
    }

    public final void setPeekDownCloseThreshold(int i) {
        this.peekDownCloseThreshold = i;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final void setRadius(int i) {
        this.radius = i;
    }

    public final int getResizeDuration() {
        return this.resizeDuration;
    }

    public final void setResizeDuration(int i) {
        this.resizeDuration = i;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final void setScreenWidth(int i) {
        this.screenWidth = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final Integer getTitleColor() {
        return this.titleColor;
    }

    public final void setTitleColor(Integer num) {
        this.titleColor = num;
    }

    public final int getTouchLimit() {
        return this.touchLimit;
    }

    public final void setTouchLimit(int i) {
        this.touchLimit = i;
    }

    public final PopupTriggerType getTriggerOrigin() {
        return this.triggerOrigin;
    }

    public final void setTriggerOrigin(PopupTriggerType popupTriggerType) {
        Intrinsics.checkNotNullParameter(popupTriggerType, "<set-?>");
        this.triggerOrigin = popupTriggerType;
    }

    public final PopupType getType() {
        return this.type;
    }

    public final void setType(PopupType popupType) {
        Intrinsics.checkNotNullParameter(popupType, "<set-?>");
        this.type = popupType;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final Integer getDragUppingThreshold() {
        return this.dragUppingThreshold;
    }

    public final void setDragUppingThreshold(Integer num) {
        this.dragUppingThreshold = num;
    }

    public final boolean getCompatCoordinateLayoutScollView() {
        return this.compatCoordinateLayoutScollView;
    }

    public final void setCompatCoordinateLayoutScollView(boolean z) {
        this.compatCoordinateLayoutScollView = z;
    }

    public final boolean getHideStatusBar() {
        return this.hideStatusBar;
    }

    public final void setHideStatusBar(boolean z) {
        this.hideStatusBar = z;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final void setHeightPercent(int i) {
        this.heightPercent = i;
    }

    public final boolean getUniformStyleAdapter() {
        return this.uniformStyleAdapter;
    }

    public final void setUniformStyleAdapter(boolean z) {
        this.uniformStyleAdapter = z;
    }

    private final int getBaseHeight() {
        int i;
        return (!this.uniformStyleAdapter || (i = this.baseHeight) <= 0) ? this.screenHeight : i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:198:0x0384, code lost:
    
        if (r9 == null) goto L234;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateWithContext(Context context) {
        boolean z;
        boolean z2;
        int i;
        String str;
        int dpToPx$anniex_release;
        boolean booleanValue;
        int statusBarHeight$anniex_release;
        Activity activity;
        int initHeight;
        PopupType popupType;
        boolean booleanValue2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        IntegerParam touchLimit;
        Integer value;
        IntegerParam peakDownCloseThreshold;
        Integer value2;
        int baseHeight;
        int i7;
        Double d;
        int i8;
        Integer num;
        DoubleParam dragUpThreshold;
        Double value3;
        DoubleParam dragDownCloseThreshold;
        Double value4;
        DoubleParam dragDownThreshold;
        Double value5;
        PercentParam dragUppingSpacePercent;
        DoubleParam dragUppingSpace;
        PercentParam dragHeightPercent;
        DoubleParam dragHeight;
        BooleanParam dragByGesture;
        Boolean value6;
        BooleanParam useScreenHeight;
        Window window;
        int i9;
        BooleanParam dragExceptStatusBar;
        Boolean value7;
        BooleanParam dragUppingSpaceWithStatusBar;
        Boolean value8;
        PopupTriggerParam triggerOrigin;
        UIColorParam titleColor;
        StringParam title;
        String value9;
        DoubleParam resizeDuration;
        Double value10;
        StringParam originContainerId;
        UIColorParam navBarColor;
        Integer value11;
        BooleanParam maskCloseUntilLoaded;
        Boolean value12;
        BooleanParam ignoreKeyboardPadding;
        Boolean value13;
        BooleanParam listenKeyboard;
        Boolean value14;
        BooleanParam keyboardAdjust;
        Boolean value15;
        BooleanParam isAdjustPan;
        Boolean value16;
        PercentParam heightPercent;
        Integer value17;
        BooleanParam hideStatusBar;
        Boolean value18;
        BooleanParam hideNavBar;
        Boolean value19;
        BooleanParam dragFollowGesture;
        Boolean value20;
        BooleanParam dragBack;
        Boolean value21;
        BooleanParam disableImmersive;
        Boolean value22;
        Boolean value23;
        Boolean value24;
        BooleanParam clickThroughMask;
        Boolean value25;
        BooleanParam allowClosed;
        Boolean value26;
        BooleanParam compatCoordinateLayoutScrollView;
        Boolean value27;
        Intrinsics.checkNotNullParameter(context, "context");
        BDXPopupModel bDXPopupModel = (BDXPopupModel) SchemaService.INSTANCE.getInstance().generateSchemaModel(this.bulletContext.getSchemaModelUnion().getSchemaData(), BDXPopupModel.class);
        if (!IConditionCallKt.enableMixLogic()) {
            this.bulletContext.getSchemaModelUnion().setUiModel(bDXPopupModel);
        }
        this.compatCoordinateLayoutScollView = (bDXPopupModel == null || (compatCoordinateLayoutScrollView = bDXPopupModel.getCompatCoordinateLayoutScrollView()) == null || (value27 = compatCoordinateLayoutScrollView.getValue()) == null) ? false : value27.booleanValue();
        this.allowClosed = (bDXPopupModel == null || (allowClosed = bDXPopupModel.getAllowClosed()) == null || (value26 = allowClosed.getValue()) == null) ? true : value26.booleanValue();
        this.clickThroughMask = (bDXPopupModel == null || (clickThroughMask = bDXPopupModel.getClickThroughMask()) == null || (value25 = clickThroughMask.getValue()) == null) ? false : value25.booleanValue();
        if (bDXPopupModel != null) {
            if (bDXPopupModel.getEnablePullDownClose().get_isSet()) {
                value24 = bDXPopupModel.getEnablePullDownClose().getValue();
            } else {
                value24 = bDXPopupModel.getCloseByGesture().getValue();
            }
            if (value24 != null) {
                z = value24.booleanValue();
                this.closeByGesture = z;
                if (bDXPopupModel != null) {
                    if (bDXPopupModel.getDisableOutsideClickClose().get_isSet()) {
                        value23 = Boolean.valueOf(Intrinsics.areEqual(bDXPopupModel.getDisableOutsideClickClose().getValue(), false));
                    } else {
                        value23 = bDXPopupModel.getCloseByMask().getValue();
                    }
                    if (value23 != null) {
                        z2 = value23.booleanValue();
                        this.closeByMask = z2;
                        this.disableImmersive = (bDXPopupModel != null || (disableImmersive = bDXPopupModel.getDisableImmersive()) == null || (value22 = disableImmersive.getValue()) == null) ? false : value22.booleanValue();
                        this.dragBack = (bDXPopupModel != null || (dragBack = bDXPopupModel.getDragBack()) == null || (value21 = dragBack.getValue()) == null) ? false : value21.booleanValue();
                        this.dragFollowGesture = (bDXPopupModel != null || (dragFollowGesture = bDXPopupModel.getDragFollowGesture()) == null || (value20 = dragFollowGesture.getValue()) == null) ? true : value20.booleanValue();
                        this.hideNavBar = (bDXPopupModel != null || (hideNavBar = bDXPopupModel.getHideNavBar()) == null || (value19 = hideNavBar.getValue()) == null) ? true : value19.booleanValue();
                        this.hideStatusBar = (bDXPopupModel != null || (hideStatusBar = bDXPopupModel.getHideStatusBar()) == null || (value18 = hideStatusBar.getValue()) == null) ? false : value18.booleanValue();
                        this.heightPercent = (bDXPopupModel != null || (heightPercent = bDXPopupModel.getHeightPercent()) == null || (value17 = heightPercent.getValue()) == null) ? -1 : value17.intValue();
                        this.isAdjustPan = (bDXPopupModel != null || (isAdjustPan = bDXPopupModel.isAdjustPan()) == null || (value16 = isAdjustPan.getValue()) == null) ? true : value16.booleanValue();
                        this.keyboardAdjust = (bDXPopupModel != null || (keyboardAdjust = bDXPopupModel.getKeyboardAdjust()) == null || (value15 = keyboardAdjust.getValue()) == null) ? false : value15.booleanValue();
                        this.listenKeyboard = (bDXPopupModel != null || (listenKeyboard = bDXPopupModel.getListenKeyboard()) == null || (value14 = listenKeyboard.getValue()) == null) ? false : value14.booleanValue();
                        this.ignoreKeyboardPadding = (bDXPopupModel != null || (ignoreKeyboardPadding = bDXPopupModel.getIgnoreKeyboardPadding()) == null || (value13 = ignoreKeyboardPadding.getValue()) == null) ? false : value13.booleanValue();
                        this.maskCloseUntilLoaded = (bDXPopupModel != null || (maskCloseUntilLoaded = bDXPopupModel.getMaskCloseUntilLoaded()) == null || (value12 = maskCloseUntilLoaded.getValue()) == null) ? false : value12.booleanValue();
                        if (bDXPopupModel != null) {
                            if (bDXPopupModel.getMaskBgColor().get_isSet()) {
                                value11 = bDXPopupModel.getMaskBgColor().getValue();
                            } else {
                                value11 = bDXPopupModel.getMaskColor().getValue();
                            }
                            if (value11 != null) {
                                i = value11.intValue();
                                this.maskColor = i;
                                this.navBarColor = (bDXPopupModel != null || (navBarColor = bDXPopupModel.getNavBarColor()) == null) ? null : navBarColor.getValue();
                                str = "";
                                if (bDXPopupModel != null || (originContainerId = bDXPopupModel.getOriginContainerId()) == null || (r8 = originContainerId.getValue()) == null) {
                                    String str2 = "";
                                }
                                this.originContainerId = str2;
                                this.resizeDuration = (int) (((bDXPopupModel != null || (resizeDuration = bDXPopupModel.getResizeDuration()) == null || (value10 = resizeDuration.getValue()) == null) ? 0.3d : value10.doubleValue()) * BytePatchException.ErrorCode.paramsError);
                                if (bDXPopupModel != null && (title = bDXPopupModel.getTitle()) != null && (value9 = title.getValue()) != null) {
                                    str = value9;
                                }
                                this.title = str;
                                this.titleColor = (bDXPopupModel != null || (titleColor = bDXPopupModel.getTitleColor()) == null) ? null : titleColor.getValue();
                                if (bDXPopupModel != null || (triggerOrigin = bDXPopupModel.getTriggerOrigin()) == null || (r7 = triggerOrigin.getValue()) == null) {
                                    PopupTriggerType popupTriggerType = PopupTriggerType.FINISH;
                                }
                                this.triggerOrigin = popupTriggerType;
                                boolean booleanValue3 = (bDXPopupModel != null || (dragUppingSpaceWithStatusBar = bDXPopupModel.getDragUppingSpaceWithStatusBar()) == null || (value8 = dragUppingSpaceWithStatusBar.getValue()) == null) ? false : value8.booleanValue();
                                int dpToPx$anniex_release2 = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getWidth(), context);
                                int initWidth = initWidth(bDXPopupModel, context);
                                dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getHeight(), context);
                                booleanValue = (bDXPopupModel != null || (dragExceptStatusBar = bDXPopupModel.getDragExceptStatusBar()) == null || (value7 = dragExceptStatusBar.getValue()) == null) ? false : value7.booleanValue();
                                statusBarHeight$anniex_release = StatusBarUtil.INSTANCE.getStatusBarHeight$anniex_release(context);
                                activity = !(context instanceof Activity) ? (Activity) context : null;
                                if (activity != null && (window = activity.getWindow()) != null) {
                                    Intrinsics.checkNotNullExpressionValue(window, "window");
                                    Rect rect = new Rect();
                                    window.getDecorView().getWindowVisibleDisplayFrame(rect);
                                    statusBarHeight$anniex_release = rect.top;
                                    i9 = rect.bottom;
                                    if (window.getDecorView().getHeight() == 0 && rect.top == 0) {
                                        i9 += statusBarHeight$anniex_release;
                                    }
                                    dpToPx$anniex_release = i9;
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                if ((bDXPopupModel != null || (useScreenHeight = bDXPopupModel.getUseScreenHeight()) == null) ? false : Intrinsics.areEqual(useScreenHeight.getValue(), true)) {
                                    dpToPx$anniex_release = BulletDeviceUtils.INSTANCE.getScreenHeight(context);
                                }
                                if (booleanValue) {
                                    dpToPx$anniex_release -= statusBarHeight$anniex_release;
                                }
                                this.screenHeight = dpToPx$anniex_release;
                                this.screenWidth = dpToPx$anniex_release2;
                                this.width = initWidth;
                                initHeight = initHeight(bDXPopupModel, context, dpToPx$anniex_release, statusBarHeight$anniex_release);
                                this.height = initHeight;
                                this.radius = initRadius(bDXPopupModel, context);
                                if (bDXPopupModel != null) {
                                    if (bDXPopupModel.getGravity().get_isSet()) {
                                        popupType = bDXPopupModel.getGravity().getValue();
                                    } else {
                                        popupType = bDXPopupModel.getPopupEnterType().get_isSet() ? bDXPopupModel.getPopupEnterType().getValue() : bDXPopupModel.getType().getValue();
                                    }
                                }
                                popupType = PopupType.CENTER;
                                booleanValue2 = (bDXPopupModel != null || (dragByGesture = bDXPopupModel.getDragByGesture()) == null || (value6 = dragByGesture.getValue()) == null) ? false : value6.booleanValue();
                                if (booleanValue2 && popupType == PopupType.BOTTOM) {
                                    popupType = PopupType.DRAGGABLE;
                                }
                                Double value28 = (bDXPopupModel != null || (dragHeight = bDXPopupModel.getDragHeight()) == null) ? null : dragHeight.getValue();
                                Integer value29 = (bDXPopupModel != null || (dragHeightPercent = bDXPopupModel.getDragHeightPercent()) == null) ? null : dragHeightPercent.getValue();
                                Double value30 = (bDXPopupModel != null || (dragUppingSpace = bDXPopupModel.getDragUppingSpace()) == null) ? null : dragUppingSpace.getValue();
                                Integer value31 = (bDXPopupModel != null || (dragUppingSpacePercent = bDXPopupModel.getDragUppingSpacePercent()) == null) ? null : dragUppingSpacePercent.getValue();
                                if (booleanValue2) {
                                    i2 = 0;
                                    i3 = -1;
                                    i4 = -1;
                                    i5 = -1;
                                    i6 = -1;
                                } else {
                                    if (value29 != null) {
                                        baseHeight = (value29.intValue() * getBaseHeight()) / 100;
                                    } else if (value28 != null) {
                                        baseHeight = UIUtils.dpToPx$anniex_release((int) value28.doubleValue(), context);
                                    } else {
                                        baseHeight = getBaseHeight();
                                    }
                                    if (baseHeight > getBaseHeight()) {
                                        baseHeight = -1;
                                    }
                                    if (baseHeight < initHeight) {
                                        popupType = PopupType.BOTTOM;
                                        booleanValue2 = false;
                                    }
                                    if (bDXPopupModel != null && (dragDownThreshold = bDXPopupModel.getDragDownThreshold()) != null && (value5 = dragDownThreshold.getValue()) != null) {
                                        if (!(value5.doubleValue() > 1.0E-4d)) {
                                            value5 = null;
                                        }
                                        if (value5 != null) {
                                            i7 = UIUtils.dpToPx$anniex_release((int) value5.doubleValue(), context);
                                            if (bDXPopupModel != null && (dragDownCloseThreshold = bDXPopupModel.getDragDownCloseThreshold()) != null && (value4 = dragDownCloseThreshold.getValue()) != null) {
                                                if (!(value4.doubleValue() <= 1.0E-4d)) {
                                                    value4 = null;
                                                }
                                                if (value4 != null) {
                                                    d = value30;
                                                    i8 = UIUtils.dpToPx$anniex_release((int) value4.doubleValue(), context);
                                                    if (bDXPopupModel != null && (dragUpThreshold = bDXPopupModel.getDragUpThreshold()) != null && (value3 = dragUpThreshold.getValue()) != null) {
                                                        if (!(value3.doubleValue() <= 1.0E-4d)) {
                                                            value3 = null;
                                                        }
                                                        if (value3 != null) {
                                                            i4 = UIUtils.dpToPx$anniex_release((int) value3.doubleValue(), context);
                                                            if (d != null) {
                                                                Double d2 = (d.doubleValue() > 1.0E-4d ? 1 : (d.doubleValue() == 1.0E-4d ? 0 : -1)) > 0 ? d : null;
                                                                if (d2 != null) {
                                                                    num = Integer.valueOf(UIUtils.dpToPx$anniex_release((int) d2.doubleValue(), context));
                                                                    this.dragUppingThreshold = num;
                                                                    if (value31 != null) {
                                                                        int intValue = value31.intValue();
                                                                        Integer num2 = this.dragUppingThreshold;
                                                                        if (num2 == null) {
                                                                            this.dragUppingThreshold = Integer.valueOf((intValue * baseHeight) / 100);
                                                                        } else {
                                                                            this.dragUppingThreshold = num2 != null ? Integer.valueOf(num2.intValue() + ((intValue * baseHeight) / 100)) : null;
                                                                        }
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        Unit unit4 = Unit.INSTANCE;
                                                                    }
                                                                    if (booleanValue3) {
                                                                        Integer num3 = this.dragUppingThreshold;
                                                                        if (num3 == null) {
                                                                            this.dragUppingThreshold = Integer.valueOf(statusBarHeight$anniex_release);
                                                                        } else {
                                                                            this.dragUppingThreshold = num3 != null ? Integer.valueOf(num3.intValue() + statusBarHeight$anniex_release) : null;
                                                                        }
                                                                    }
                                                                    if (this.height == -1) {
                                                                        i2 = 0;
                                                                        this.dragUppingThreshold = 0;
                                                                    } else {
                                                                        i2 = 0;
                                                                        int i10 = this.dragUppingThreshold;
                                                                        if (i10 != null) {
                                                                            int intValue2 = i10.intValue();
                                                                            if (intValue2 < 0) {
                                                                                i10 = 0;
                                                                            }
                                                                            int i11 = baseHeight - this.height;
                                                                            if (intValue2 > i11) {
                                                                                i10 = Integer.valueOf(i11);
                                                                            }
                                                                            Unit unit5 = Unit.INSTANCE;
                                                                            Unit unit6 = Unit.INSTANCE;
                                                                        }
                                                                        this.dragUppingThreshold = i10;
                                                                    }
                                                                    i5 = i7;
                                                                    i6 = i8;
                                                                    i3 = baseHeight;
                                                                }
                                                            }
                                                            num = null;
                                                            this.dragUppingThreshold = num;
                                                            if (value31 != null) {
                                                            }
                                                            if (booleanValue3) {
                                                            }
                                                            if (this.height == -1) {
                                                            }
                                                            i5 = i7;
                                                            i6 = i8;
                                                            i3 = baseHeight;
                                                        }
                                                    }
                                                    i4 = (int) (UIUtils.dpToPx$anniex_release(getBaseHeight(), context) * 0.1d);
                                                    if (d != null) {
                                                    }
                                                    num = null;
                                                    this.dragUppingThreshold = num;
                                                    if (value31 != null) {
                                                    }
                                                    if (booleanValue3) {
                                                    }
                                                    if (this.height == -1) {
                                                    }
                                                    i5 = i7;
                                                    i6 = i8;
                                                    i3 = baseHeight;
                                                }
                                            }
                                            d = value30;
                                            i8 = (int) (baseHeight - (initHeight * 0.8d));
                                            if (bDXPopupModel != null) {
                                                if (!(value3.doubleValue() <= 1.0E-4d)) {
                                                }
                                                if (value3 != null) {
                                                }
                                            }
                                            i4 = (int) (UIUtils.dpToPx$anniex_release(getBaseHeight(), context) * 0.1d);
                                            if (d != null) {
                                            }
                                            num = null;
                                            this.dragUppingThreshold = num;
                                            if (value31 != null) {
                                            }
                                            if (booleanValue3) {
                                            }
                                            if (this.height == -1) {
                                            }
                                            i5 = i7;
                                            i6 = i8;
                                            i3 = baseHeight;
                                        }
                                    }
                                    i7 = baseHeight - initHeight;
                                    if (bDXPopupModel != null) {
                                        if (!(value4.doubleValue() <= 1.0E-4d)) {
                                        }
                                        if (value4 != null) {
                                        }
                                    }
                                    d = value30;
                                    i8 = (int) (baseHeight - (initHeight * 0.8d));
                                    if (bDXPopupModel != null) {
                                    }
                                    i4 = (int) (UIUtils.dpToPx$anniex_release(getBaseHeight(), context) * 0.1d);
                                    if (d != null) {
                                    }
                                    num = null;
                                    this.dragUppingThreshold = num;
                                    if (value31 != null) {
                                    }
                                    if (booleanValue3) {
                                    }
                                    if (this.height == -1) {
                                    }
                                    i5 = i7;
                                    i6 = i8;
                                    i3 = baseHeight;
                                }
                                if (this.closeByGesture && popupType == PopupType.BOTTOM) {
                                    popupType = PopupType.DRAGGABLE;
                                    i3 = initHeight - 1;
                                    booleanValue2 = true;
                                }
                                this.dragByGesture = booleanValue2;
                                this.dragDownCloseThreshold = i6;
                                this.dragDownThreshold = i5;
                                this.dragHeight = i3;
                                this.dragUpThreshold = i4;
                                this.type = popupType;
                                this.peekDownCloseThreshold = (bDXPopupModel != null || (peakDownCloseThreshold = bDXPopupModel.getPeakDownCloseThreshold()) == null || (value2 = peakDownCloseThreshold.getValue()) == null) ? (int) (initHeight * 0.2d) : value2.intValue();
                                int intValue3 = (bDXPopupModel != null || (touchLimit = bDXPopupModel.getTouchLimit()) == null || (value = touchLimit.getValue()) == null) ? i2 : value.intValue();
                                this.touchLimit = intValue3 <= 0 ? UIUtils.dpToPx$anniex_release(intValue3, context) : i2;
                            }
                        }
                        i = 0;
                        this.maskColor = i;
                        this.navBarColor = (bDXPopupModel != null || (navBarColor = bDXPopupModel.getNavBarColor()) == null) ? null : navBarColor.getValue();
                        str = "";
                        if (bDXPopupModel != null) {
                        }
                        String str22 = "";
                        this.originContainerId = str22;
                        this.resizeDuration = (int) (((bDXPopupModel != null || (resizeDuration = bDXPopupModel.getResizeDuration()) == null || (value10 = resizeDuration.getValue()) == null) ? 0.3d : value10.doubleValue()) * BytePatchException.ErrorCode.paramsError);
                        if (bDXPopupModel != null) {
                            str = value9;
                        }
                        this.title = str;
                        this.titleColor = (bDXPopupModel != null || (titleColor = bDXPopupModel.getTitleColor()) == null) ? null : titleColor.getValue();
                        if (bDXPopupModel != null) {
                        }
                        PopupTriggerType popupTriggerType2 = PopupTriggerType.FINISH;
                        this.triggerOrigin = popupTriggerType2;
                        if (bDXPopupModel != null) {
                        }
                        int dpToPx$anniex_release22 = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getWidth(), context);
                        int initWidth2 = initWidth(bDXPopupModel, context);
                        dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getHeight(), context);
                        if (bDXPopupModel != null) {
                        }
                        statusBarHeight$anniex_release = StatusBarUtil.INSTANCE.getStatusBarHeight$anniex_release(context);
                        if (!(context instanceof Activity)) {
                        }
                        if (activity != null) {
                            Intrinsics.checkNotNullExpressionValue(window, "window");
                            Rect rect2 = new Rect();
                            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                            statusBarHeight$anniex_release = rect2.top;
                            i9 = rect2.bottom;
                            if (window.getDecorView().getHeight() == 0) {
                                i9 += statusBarHeight$anniex_release;
                            }
                            dpToPx$anniex_release = i9;
                            Unit unit7 = Unit.INSTANCE;
                            Unit unit22 = Unit.INSTANCE;
                        }
                        if ((bDXPopupModel != null || (useScreenHeight = bDXPopupModel.getUseScreenHeight()) == null) ? false : Intrinsics.areEqual(useScreenHeight.getValue(), true)) {
                        }
                        if (booleanValue) {
                        }
                        this.screenHeight = dpToPx$anniex_release;
                        this.screenWidth = dpToPx$anniex_release22;
                        this.width = initWidth2;
                        initHeight = initHeight(bDXPopupModel, context, dpToPx$anniex_release, statusBarHeight$anniex_release);
                        this.height = initHeight;
                        this.radius = initRadius(bDXPopupModel, context);
                        if (bDXPopupModel != null) {
                        }
                        popupType = PopupType.CENTER;
                        if (bDXPopupModel != null) {
                        }
                        if (booleanValue2) {
                            popupType = PopupType.DRAGGABLE;
                        }
                        if (bDXPopupModel != null) {
                        }
                        if (bDXPopupModel != null) {
                        }
                        if (bDXPopupModel != null) {
                        }
                        if (bDXPopupModel != null) {
                        }
                        if (booleanValue2) {
                        }
                        if (this.closeByGesture) {
                            popupType = PopupType.DRAGGABLE;
                            i3 = initHeight - 1;
                            booleanValue2 = true;
                        }
                        this.dragByGesture = booleanValue2;
                        this.dragDownCloseThreshold = i6;
                        this.dragDownThreshold = i5;
                        this.dragHeight = i3;
                        this.dragUpThreshold = i4;
                        this.type = popupType;
                        this.peekDownCloseThreshold = (bDXPopupModel != null || (peakDownCloseThreshold = bDXPopupModel.getPeakDownCloseThreshold()) == null || (value2 = peakDownCloseThreshold.getValue()) == null) ? (int) (initHeight * 0.2d) : value2.intValue();
                        if (bDXPopupModel != null) {
                        }
                        this.touchLimit = intValue3 <= 0 ? UIUtils.dpToPx$anniex_release(intValue3, context) : i2;
                    }
                }
                z2 = false;
                this.closeByMask = z2;
                this.disableImmersive = (bDXPopupModel != null || (disableImmersive = bDXPopupModel.getDisableImmersive()) == null || (value22 = disableImmersive.getValue()) == null) ? false : value22.booleanValue();
                this.dragBack = (bDXPopupModel != null || (dragBack = bDXPopupModel.getDragBack()) == null || (value21 = dragBack.getValue()) == null) ? false : value21.booleanValue();
                this.dragFollowGesture = (bDXPopupModel != null || (dragFollowGesture = bDXPopupModel.getDragFollowGesture()) == null || (value20 = dragFollowGesture.getValue()) == null) ? true : value20.booleanValue();
                this.hideNavBar = (bDXPopupModel != null || (hideNavBar = bDXPopupModel.getHideNavBar()) == null || (value19 = hideNavBar.getValue()) == null) ? true : value19.booleanValue();
                this.hideStatusBar = (bDXPopupModel != null || (hideStatusBar = bDXPopupModel.getHideStatusBar()) == null || (value18 = hideStatusBar.getValue()) == null) ? false : value18.booleanValue();
                this.heightPercent = (bDXPopupModel != null || (heightPercent = bDXPopupModel.getHeightPercent()) == null || (value17 = heightPercent.getValue()) == null) ? -1 : value17.intValue();
                this.isAdjustPan = (bDXPopupModel != null || (isAdjustPan = bDXPopupModel.isAdjustPan()) == null || (value16 = isAdjustPan.getValue()) == null) ? true : value16.booleanValue();
                this.keyboardAdjust = (bDXPopupModel != null || (keyboardAdjust = bDXPopupModel.getKeyboardAdjust()) == null || (value15 = keyboardAdjust.getValue()) == null) ? false : value15.booleanValue();
                this.listenKeyboard = (bDXPopupModel != null || (listenKeyboard = bDXPopupModel.getListenKeyboard()) == null || (value14 = listenKeyboard.getValue()) == null) ? false : value14.booleanValue();
                this.ignoreKeyboardPadding = (bDXPopupModel != null || (ignoreKeyboardPadding = bDXPopupModel.getIgnoreKeyboardPadding()) == null || (value13 = ignoreKeyboardPadding.getValue()) == null) ? false : value13.booleanValue();
                this.maskCloseUntilLoaded = (bDXPopupModel != null || (maskCloseUntilLoaded = bDXPopupModel.getMaskCloseUntilLoaded()) == null || (value12 = maskCloseUntilLoaded.getValue()) == null) ? false : value12.booleanValue();
                if (bDXPopupModel != null) {
                }
                i = 0;
                this.maskColor = i;
                this.navBarColor = (bDXPopupModel != null || (navBarColor = bDXPopupModel.getNavBarColor()) == null) ? null : navBarColor.getValue();
                str = "";
                if (bDXPopupModel != null) {
                }
                String str222 = "";
                this.originContainerId = str222;
                this.resizeDuration = (int) (((bDXPopupModel != null || (resizeDuration = bDXPopupModel.getResizeDuration()) == null || (value10 = resizeDuration.getValue()) == null) ? 0.3d : value10.doubleValue()) * BytePatchException.ErrorCode.paramsError);
                if (bDXPopupModel != null) {
                }
                this.title = str;
                this.titleColor = (bDXPopupModel != null || (titleColor = bDXPopupModel.getTitleColor()) == null) ? null : titleColor.getValue();
                if (bDXPopupModel != null) {
                }
                PopupTriggerType popupTriggerType22 = PopupTriggerType.FINISH;
                this.triggerOrigin = popupTriggerType22;
                if (bDXPopupModel != null) {
                }
                int dpToPx$anniex_release222 = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getWidth(), context);
                int initWidth22 = initWidth(bDXPopupModel, context);
                dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getHeight(), context);
                if (bDXPopupModel != null) {
                }
                statusBarHeight$anniex_release = StatusBarUtil.INSTANCE.getStatusBarHeight$anniex_release(context);
                if (!(context instanceof Activity)) {
                }
                if (activity != null) {
                }
                if ((bDXPopupModel != null || (useScreenHeight = bDXPopupModel.getUseScreenHeight()) == null) ? false : Intrinsics.areEqual(useScreenHeight.getValue(), true)) {
                }
                if (booleanValue) {
                }
                this.screenHeight = dpToPx$anniex_release;
                this.screenWidth = dpToPx$anniex_release222;
                this.width = initWidth22;
                initHeight = initHeight(bDXPopupModel, context, dpToPx$anniex_release, statusBarHeight$anniex_release);
                this.height = initHeight;
                this.radius = initRadius(bDXPopupModel, context);
                if (bDXPopupModel != null) {
                }
                popupType = PopupType.CENTER;
                if (bDXPopupModel != null) {
                }
                if (booleanValue2) {
                }
                if (bDXPopupModel != null) {
                }
                if (bDXPopupModel != null) {
                }
                if (bDXPopupModel != null) {
                }
                if (bDXPopupModel != null) {
                }
                if (booleanValue2) {
                }
                if (this.closeByGesture) {
                }
                this.dragByGesture = booleanValue2;
                this.dragDownCloseThreshold = i6;
                this.dragDownThreshold = i5;
                this.dragHeight = i3;
                this.dragUpThreshold = i4;
                this.type = popupType;
                this.peekDownCloseThreshold = (bDXPopupModel != null || (peakDownCloseThreshold = bDXPopupModel.getPeakDownCloseThreshold()) == null || (value2 = peakDownCloseThreshold.getValue()) == null) ? (int) (initHeight * 0.2d) : value2.intValue();
                if (bDXPopupModel != null) {
                }
                this.touchLimit = intValue3 <= 0 ? UIUtils.dpToPx$anniex_release(intValue3, context) : i2;
            }
        }
        z = false;
        this.closeByGesture = z;
        if (bDXPopupModel != null) {
        }
        z2 = false;
        this.closeByMask = z2;
        this.disableImmersive = (bDXPopupModel != null || (disableImmersive = bDXPopupModel.getDisableImmersive()) == null || (value22 = disableImmersive.getValue()) == null) ? false : value22.booleanValue();
        this.dragBack = (bDXPopupModel != null || (dragBack = bDXPopupModel.getDragBack()) == null || (value21 = dragBack.getValue()) == null) ? false : value21.booleanValue();
        this.dragFollowGesture = (bDXPopupModel != null || (dragFollowGesture = bDXPopupModel.getDragFollowGesture()) == null || (value20 = dragFollowGesture.getValue()) == null) ? true : value20.booleanValue();
        this.hideNavBar = (bDXPopupModel != null || (hideNavBar = bDXPopupModel.getHideNavBar()) == null || (value19 = hideNavBar.getValue()) == null) ? true : value19.booleanValue();
        this.hideStatusBar = (bDXPopupModel != null || (hideStatusBar = bDXPopupModel.getHideStatusBar()) == null || (value18 = hideStatusBar.getValue()) == null) ? false : value18.booleanValue();
        this.heightPercent = (bDXPopupModel != null || (heightPercent = bDXPopupModel.getHeightPercent()) == null || (value17 = heightPercent.getValue()) == null) ? -1 : value17.intValue();
        this.isAdjustPan = (bDXPopupModel != null || (isAdjustPan = bDXPopupModel.isAdjustPan()) == null || (value16 = isAdjustPan.getValue()) == null) ? true : value16.booleanValue();
        this.keyboardAdjust = (bDXPopupModel != null || (keyboardAdjust = bDXPopupModel.getKeyboardAdjust()) == null || (value15 = keyboardAdjust.getValue()) == null) ? false : value15.booleanValue();
        this.listenKeyboard = (bDXPopupModel != null || (listenKeyboard = bDXPopupModel.getListenKeyboard()) == null || (value14 = listenKeyboard.getValue()) == null) ? false : value14.booleanValue();
        this.ignoreKeyboardPadding = (bDXPopupModel != null || (ignoreKeyboardPadding = bDXPopupModel.getIgnoreKeyboardPadding()) == null || (value13 = ignoreKeyboardPadding.getValue()) == null) ? false : value13.booleanValue();
        this.maskCloseUntilLoaded = (bDXPopupModel != null || (maskCloseUntilLoaded = bDXPopupModel.getMaskCloseUntilLoaded()) == null || (value12 = maskCloseUntilLoaded.getValue()) == null) ? false : value12.booleanValue();
        if (bDXPopupModel != null) {
        }
        i = 0;
        this.maskColor = i;
        this.navBarColor = (bDXPopupModel != null || (navBarColor = bDXPopupModel.getNavBarColor()) == null) ? null : navBarColor.getValue();
        str = "";
        if (bDXPopupModel != null) {
        }
        String str2222 = "";
        this.originContainerId = str2222;
        this.resizeDuration = (int) (((bDXPopupModel != null || (resizeDuration = bDXPopupModel.getResizeDuration()) == null || (value10 = resizeDuration.getValue()) == null) ? 0.3d : value10.doubleValue()) * BytePatchException.ErrorCode.paramsError);
        if (bDXPopupModel != null) {
        }
        this.title = str;
        this.titleColor = (bDXPopupModel != null || (titleColor = bDXPopupModel.getTitleColor()) == null) ? null : titleColor.getValue();
        if (bDXPopupModel != null) {
        }
        PopupTriggerType popupTriggerType222 = PopupTriggerType.FINISH;
        this.triggerOrigin = popupTriggerType222;
        if (bDXPopupModel != null) {
        }
        int dpToPx$anniex_release2222 = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getWidth(), context);
        int initWidth222 = initWidth(bDXPopupModel, context);
        dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getHeight(), context);
        if (bDXPopupModel != null) {
        }
        statusBarHeight$anniex_release = StatusBarUtil.INSTANCE.getStatusBarHeight$anniex_release(context);
        if (!(context instanceof Activity)) {
        }
        if (activity != null) {
        }
        if ((bDXPopupModel != null || (useScreenHeight = bDXPopupModel.getUseScreenHeight()) == null) ? false : Intrinsics.areEqual(useScreenHeight.getValue(), true)) {
        }
        if (booleanValue) {
        }
        this.screenHeight = dpToPx$anniex_release;
        this.screenWidth = dpToPx$anniex_release2222;
        this.width = initWidth222;
        initHeight = initHeight(bDXPopupModel, context, dpToPx$anniex_release, statusBarHeight$anniex_release);
        this.height = initHeight;
        this.radius = initRadius(bDXPopupModel, context);
        if (bDXPopupModel != null) {
        }
        popupType = PopupType.CENTER;
        if (bDXPopupModel != null) {
        }
        if (booleanValue2) {
        }
        if (bDXPopupModel != null) {
        }
        if (bDXPopupModel != null) {
        }
        if (bDXPopupModel != null) {
        }
        if (bDXPopupModel != null) {
        }
        if (booleanValue2) {
        }
        if (this.closeByGesture) {
        }
        this.dragByGesture = booleanValue2;
        this.dragDownCloseThreshold = i6;
        this.dragDownThreshold = i5;
        this.dragHeight = i3;
        this.dragUpThreshold = i4;
        this.type = popupType;
        this.peekDownCloseThreshold = (bDXPopupModel != null || (peakDownCloseThreshold = bDXPopupModel.getPeakDownCloseThreshold()) == null || (value2 = peakDownCloseThreshold.getValue()) == null) ? (int) (initHeight * 0.2d) : value2.intValue();
        if (bDXPopupModel != null) {
        }
        this.touchLimit = intValue3 <= 0 ? UIUtils.dpToPx$anniex_release(intValue3, context) : i2;
    }

    private final int initWidth(BDXPopupModel popupModel, Context context) {
        int i;
        PercentParam widthPercent;
        DoubleParam width;
        Double value;
        Configuration configuration;
        Resources resources = context.getResources();
        int i2 = (resources == null || (configuration = resources.getConfiguration()) == null) ? 0 : configuration.screenWidthDp;
        int dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(i2, context);
        int dpToPx$anniex_release2 = (!this.uniformStyleAdapter || dpToPx$anniex_release <= 0) ? UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(context).getWidth(), context) : dpToPx$anniex_release;
        Integer num = null;
        Integer valueOf = (popupModel == null || (width = popupModel.getWidth()) == null || (value = width.getValue()) == null) ? null : Integer.valueOf((int) value.doubleValue());
        if (popupModel != null && (widthPercent = popupModel.getWidthPercent()) != null) {
            num = widthPercent.getValue();
        }
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 窗口宽度 = " + dpToPx$anniex_release + "px = " + i2 + "dp", null, null, 12, null);
        if (num != null) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 指定百分比, width_percent = " + num, null, null, 12, null);
            i = (num.intValue() * dpToPx$anniex_release2) / 100;
        } else if (valueOf != null) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 指定宽度, width = " + valueOf + "dp", null, null, 12, null);
            i = UIUtils.dpToPx$anniex_release(valueOf.intValue(), context);
        } else if (!this.uniformStyleAdapter || i2 < 480) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 默认宽度, 线上默认尺寸 match_parent", null, null, 12, null);
            i = -1;
        } else if (i2 >= 960) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 默认宽度, 窗口宽度>=960dp, 弹窗宽度默认500dp", null, null, 12, null);
            i = UIUtils.dpToPx$anniex_release(500, context);
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 默认宽度, 窗口宽度>=480dp, 弹窗宽度默认420dp", null, null, 12, null);
            i = UIUtils.dpToPx$anniex_release(420, context);
        }
        if (i > dpToPx$anniex_release2) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 超过窗口宽度, 弹窗宽度 = match_parent", null, null, 12, null);
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initWidth: 弹窗宽度 = " + i + "px", null, null, 12, null);
        }
        if (i > dpToPx$anniex_release2) {
            return -1;
        }
        return i;
    }

    private final int initHeight(BDXPopupModel popupModel, Context context, int totalHeight, int statusBarHeight) {
        int i;
        BooleanParam dragExceptStatusBar;
        Boolean value;
        DoubleParam aspectRatio;
        PercentParam heightPercent;
        DoubleParam height;
        Double value2;
        Configuration configuration;
        Configuration configuration2;
        Resources resources = context.getResources();
        boolean z = false;
        int i2 = (resources == null || (configuration2 = resources.getConfiguration()) == null) ? 0 : configuration2.screenWidthDp;
        Resources resources2 = context.getResources();
        int i3 = (resources2 == null || (configuration = resources2.getConfiguration()) == null) ? 0 : configuration.screenHeightDp;
        int dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(i3, context);
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 窗口宽高 = (" + UIUtils.dpToPx$anniex_release(i2, context) + "px, " + dpToPx$anniex_release + "px) = (" + i2 + "dp, " + i3 + "dp)", null, null, 12, null);
        Double d = null;
        Integer valueOf = (popupModel == null || (height = popupModel.getHeight()) == null || (value2 = height.getValue()) == null) ? null : Integer.valueOf((int) value2.doubleValue());
        Integer value3 = (popupModel == null || (heightPercent = popupModel.getHeightPercent()) == null) ? null : heightPercent.getValue();
        if (popupModel != null && (aspectRatio = popupModel.getAspectRatio()) != null) {
            d = aspectRatio.getValue();
        }
        if (!this.uniformStyleAdapter || dpToPx$anniex_release <= 0) {
            dpToPx$anniex_release = totalHeight;
        } else {
            if (popupModel != null && (dragExceptStatusBar = popupModel.getDragExceptStatusBar()) != null && (value = dragExceptStatusBar.getValue()) != null) {
                z = value.booleanValue();
            }
            if (z) {
                dpToPx$anniex_release -= statusBarHeight;
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: drag_except_statusbar=true, 基准高度-状态栏高度=" + dpToPx$anniex_release + "px", null, null, 12, null);
            }
        }
        this.baseHeight = dpToPx$anniex_release;
        if (value3 != null) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 指定百分比, height_percent = " + value3, null, null, 12, null);
            i = (value3.intValue() * getBaseHeight()) / 100;
        } else if (valueOf != null) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 指定高度, height = " + valueOf + "dp", null, null, 12, null);
            i = UIUtils.dpToPx$anniex_release(valueOf.intValue(), context);
        } else if (d != null) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 指定高宽比, aspect_ratio = " + d, null, null, 12, null);
            i = (int) (d.doubleValue() * this.width);
        } else if (!this.uniformStyleAdapter || i2 < 480) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 默认高度, 线上默认尺寸 match_parent", null, null, 12, null);
            i = -1;
        } else if (i3 >= 704) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 默认高度, 窗口高度>=704dp时, 固定560dp", null, null, 12, null);
            i = UIUtils.dpToPx$anniex_release(560, context);
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 默认高度, 窗口高度<704dp时, 取高度的73%, 且计算出来的高度不小于290dp", null, null, 12, null);
            i = Math.max((int) (getBaseHeight() * 0.73d), UIUtils.dpToPx$anniex_release(BuildConfig.VERSION_CODE, context));
        }
        if (i > getBaseHeight()) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 超过窗口高度, 弹窗高度 = match_parent", null, null, 12, null);
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initHeight: 弹窗高度 = " + i + "px", null, null, 12, null);
        }
        if (i > getBaseHeight()) {
            i = -1;
        }
        if (!this.uniformStyleAdapter || value3 == null || value3.intValue() != 100 || Intrinsics.areEqual(popupModel.getDragExceptStatusBar().getValue(), true)) {
            return i;
        }
        return -1;
    }

    private final int initRadius(BDXPopupModel popupModel, Context context) {
        int dpToPx$anniex_release;
        BooleanParam radiusUseDp;
        DoubleParam radius;
        Double value;
        DoubleParam schemaRadius;
        Window window;
        View decorView;
        Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(context);
        boolean z = false;
        int px2dp$anniex_release = (ownerActivity == null || (window = ownerActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? 0 : UIUtils.px2dp$anniex_release(decorView.getWidth(), context);
        if (this.uniformStyleAdapter && px2dp$anniex_release >= 480) {
            if (((popupModel == null || (schemaRadius = popupModel.getSchemaRadius()) == null) ? null : schemaRadius.getValue()) == null) {
                dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(20, context);
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initRadius: 弹窗圆角 = " + dpToPx$anniex_release + "px", null, null, 12, null);
                return dpToPx$anniex_release;
            }
        }
        int doubleValue = (popupModel == null || (radius = popupModel.getRadius()) == null || (value = radius.getValue()) == null) ? 0 : (int) value.doubleValue();
        if (popupModel != null && (radiusUseDp = popupModel.getRadiusUseDp()) != null) {
            z = Intrinsics.areEqual(radiusUseDp.getValue(), true);
        }
        dpToPx$anniex_release = z ? UIUtils.dpToPx$anniex_release(doubleValue, context) : doubleValue;
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "initRadius: 弹窗圆角 = " + dpToPx$anniex_release + "px", null, null, 12, null);
        return dpToPx$anniex_release;
    }

    public final boolean isScanOpen() {
        return Intrinsics.areEqual(new BooleanParam(this.bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_SCAN_OPEN, null).getValue(), true);
    }

    public final boolean isDelayOpen() {
        return Intrinsics.areEqual(new BooleanParam(this.bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_DELAY_OPEN, null).getValue(), true);
    }

    public final boolean isFullScreen() {
        return this.width <= 0 && this.height <= 0;
    }

    public final boolean showOnSuccess() {
        return Intrinsics.areEqual(new BooleanParam(this.bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_SHOW_ON_SUCCESS, false).getValue(), true);
    }

    public final boolean useBridge3() {
        return Intrinsics.areEqual(new BooleanParam(this.bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.XBRIDGE_USE3, false).getValue(), true);
    }
}
