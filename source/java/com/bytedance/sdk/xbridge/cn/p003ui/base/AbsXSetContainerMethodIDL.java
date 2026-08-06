package com.bytedance.sdk.xbridge.cn.p003ui.base;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXSetContainerMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XSetContainerParamModel;", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XSetContainerResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XBridgeBeanXSetContainerCommonInteraction", "XBridgeBeanXSetContainerPageInteraction", "XBridgeBeanXSetContainerPageUI", "XBridgeBeanXSetContainerPopupInteraction", "XSetContainerParamModel", "XSetContainerResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXSetContainerMethodIDL extends XCoreIDLBridgeMethod<XSetContainerParamModel, XSetContainerResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "38360"));

    @XBridgeMethodName(name = "x.setContainer", params = {"pageUI", "commonInteraction", "pageInteraction", "popupInteraction"})
    private final String name = "x.setContainer";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXSetContainerMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XSetContainerParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "commonInteraction", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerCommonInteraction;", "getCommonInteraction", "()Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerCommonInteraction;", "pageInteraction", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageInteraction;", "getPageInteraction", "()Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageInteraction;", "pageUI", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageUI;", "getPageUI", "()Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageUI;", "popupInteraction", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPopupInteraction;", "getPopupInteraction", "()Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPopupInteraction;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XSetContainerParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "commonInteraction", nestedClassType = XBridgeBeanXSetContainerCommonInteraction.class, required = false)
        XBridgeBeanXSetContainerCommonInteraction getCommonInteraction();

        @XBridgeParamField(isGetter = true, keyPath = "pageInteraction", nestedClassType = XBridgeBeanXSetContainerPageInteraction.class, required = false)
        XBridgeBeanXSetContainerPageInteraction getPageInteraction();

        @XBridgeParamField(isGetter = true, keyPath = "pageUI", nestedClassType = XBridgeBeanXSetContainerPageUI.class, required = false)
        XBridgeBeanXSetContainerPageUI getPageUI();

        @XBridgeParamField(isGetter = true, keyPath = "popupInteraction", nestedClassType = XBridgeBeanXSetContainerPopupInteraction.class, required = false)
        XBridgeBeanXSetContainerPopupInteraction getPopupInteraction();
    }

    /* compiled from: AbsXSetContainerMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XSetContainerResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XSetContainerResultModel extends XBaseResultModel {
    }

    /* compiled from: AbsXSetContainerMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXSetContainerMethodIDL.extensionMetaInfo;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    /* compiled from: AbsXSetContainerMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageUI;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "navBarColor", "", "getNavBarColor", "()Ljava/lang/String;", "statusBarBgColor", "getStatusBarBgColor", "statusFontMode", "getStatusFontMode", "title", "getTitle", "titleColor", "getTitleColor", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXSetContainerPageUI extends XBaseModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XSetContainerStatusFontModeDark = "dark";
        public static final String XSetContainerStatusFontModeLight = "light";

        @XBridgeParamField(isGetter = true, keyPath = "navBarColor", required = false)
        String getNavBarColor();

        @XBridgeParamField(isGetter = true, keyPath = "statusBarBgColor", required = false)
        String getStatusBarBgColor();

        @XBridgeStringEnum(option = {"dark", "light"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "statusFontMode", required = false)
        String getStatusFontMode();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = true, keyPath = "titleColor", required = false)
        String getTitleColor();

        /* compiled from: AbsXSetContainerMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageUI$Companion;", "", "()V", "XSetContainerStatusFontModeDark", "", "XSetContainerStatusFontModeLight", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XSetContainerStatusFontModeDark = "dark";
            public static final String XSetContainerStatusFontModeLight = "light";

            private Companion() {
            }
        }
    }

    /* compiled from: AbsXSetContainerMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerCommonInteraction;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "disableBackPress", "", "getDisableBackPress", "()Ljava/lang/Number;", "disableBounce", "getDisableBounce", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXSetContainerCommonInteraction extends XBaseModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int XSetContainerDisableBackPress = 0;
        public static final int XSetContainerDisableBackPress1 = 1;
        public static final int XSetContainerDisableBounce = 0;
        public static final int XSetContainerDisableBounce1 = 1;

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableBackPress", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableBackPress();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableBounce", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableBounce();

        /* compiled from: AbsXSetContainerMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerCommonInteraction$Companion;", "", "()V", "XSetContainerDisableBackPress", "", "XSetContainerDisableBackPress1", "XSetContainerDisableBounce", "XSetContainerDisableBounce1", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int XSetContainerDisableBackPress = 0;
            public static final int XSetContainerDisableBackPress1 = 1;
            public static final int XSetContainerDisableBounce = 0;
            public static final int XSetContainerDisableBounce1 = 1;

            private Companion() {
            }
        }
    }

    /* compiled from: AbsXSetContainerMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageInteraction;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "disableSwipe", "", "getDisableSwipe", "()Ljava/lang/Number;", "navBtnType", "", "getNavBtnType", "()Ljava/lang/String;", "shouldFullScreen", "getShouldFullScreen", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXSetContainerPageInteraction extends XBaseModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int XSetContainerDisableSwipe = 0;
        public static final int XSetContainerDisableSwipe1 = 1;
        public static final String XSetContainerNavBtnTypeCollect = "collect";
        public static final String XSetContainerNavBtnTypeReport = "report";
        public static final String XSetContainerNavBtnTypeShare = "share";
        public static final int XSetContainerShouldFullScreen = 0;
        public static final int XSetContainerShouldFullScreen1 = 1;

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableSwipe", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableSwipe();

        @XBridgeStringEnum(option = {"collect", "report", "share"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "navBtnType", required = false)
        String getNavBtnType();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "shouldFullScreen", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getShouldFullScreen();

        /* compiled from: AbsXSetContainerMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPageInteraction$Companion;", "", "()V", "XSetContainerDisableSwipe", "", "XSetContainerDisableSwipe1", "XSetContainerNavBtnTypeCollect", "", "XSetContainerNavBtnTypeReport", "XSetContainerNavBtnTypeShare", "XSetContainerShouldFullScreen", "XSetContainerShouldFullScreen1", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int XSetContainerDisableSwipe = 0;
            public static final int XSetContainerDisableSwipe1 = 1;
            public static final String XSetContainerNavBtnTypeCollect = "collect";
            public static final String XSetContainerNavBtnTypeReport = "report";
            public static final String XSetContainerNavBtnTypeShare = "share";
            public static final int XSetContainerShouldFullScreen = 0;
            public static final int XSetContainerShouldFullScreen1 = 1;

            private Companion() {
            }
        }
    }

    /* compiled from: AbsXSetContainerMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\b\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPopupInteraction;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "disableMaskClickClose", "", "getDisableMaskClickClose", "()Ljava/lang/Number;", "enableInterceptTouchEvent", "getEnableInterceptTouchEvent", "enablePullDownClose", "getEnablePullDownClose", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXSetContainerPopupInteraction extends XBaseModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int XSetContainerDisableMaskClickClose = 0;
        public static final int XSetContainerDisableMaskClickClose1 = 1;
        public static final int XSetContainerEnableInterceptTouchEvent = 0;
        public static final int XSetContainerEnableInterceptTouchEvent1 = 1;
        public static final int XSetContainerEnablePullDownClose = 0;
        public static final int XSetContainerEnablePullDownClose1 = 1;

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disableMaskClickClose", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getDisableMaskClickClose();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "enableInterceptTouchEvent", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getEnableInterceptTouchEvent();

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "enablePullDownClose", required = false)
        @XBridgeIntEnum(option = {0, 1})
        Number getEnablePullDownClose();

        /* compiled from: AbsXSetContainerMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XBridgeBeanXSetContainerPopupInteraction$Companion;", "", "()V", "XSetContainerDisableMaskClickClose", "", "XSetContainerDisableMaskClickClose1", "XSetContainerEnableInterceptTouchEvent", "XSetContainerEnableInterceptTouchEvent1", "XSetContainerEnablePullDownClose", "XSetContainerEnablePullDownClose1", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int XSetContainerDisableMaskClickClose = 0;
            public static final int XSetContainerDisableMaskClickClose1 = 1;
            public static final int XSetContainerEnableInterceptTouchEvent = 0;
            public static final int XSetContainerEnableInterceptTouchEvent1 = 1;
            public static final int XSetContainerEnablePullDownClose = 0;
            public static final int XSetContainerEnablePullDownClose1 = 1;

            private Companion() {
            }
        }
    }
}
