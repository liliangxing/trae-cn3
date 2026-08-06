package com.bytedance.sdk.xbridge.cn.account;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXGetUserInfoMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\r\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XGetUserInfoParamModel;", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XGetUserInfoResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XBridgeBeanXGetUserInfoUserInfo", "XGetUserInfoParamModel", "XGetUserInfoResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXGetUserInfoMethodIDL extends XCoreIDLBridgeMethod<XGetUserInfoParamModel, XGetUserInfoResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "32019"));

    @XBridgeMethodName(name = "x.getUserInfo", params = {""}, results = {"isLogin", "hasLoggedIn", "userInfo"})
    private final String name = "x.getUserInfo";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXGetUserInfoMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\bf\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R(\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR(\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR(\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR(\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR(\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XBridgeBeanXGetUserInfoUserInfo;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", "avatarURL", "getAvatarURL", "()Ljava/lang/String;", "setAvatarURL", "(Ljava/lang/String;)V", "bindPhone", "getBindPhone", "setBindPhone", "", "hasBoundPhone", "getHasBoundPhone", "()Ljava/lang/Boolean;", "setHasBoundPhone", "(Ljava/lang/Boolean;)V", "isBoundPhone", "setBoundPhone", "nickname", "getNickname", "setNickname", "secUserID", "getSecUserID", "setSecUserID", "shortID", "getShortID", "setShortID", "uniqueID", "getUniqueID", "setUniqueID", "userID", "getUserID", "setUserID", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXGetUserInfoUserInfo extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "avatarURL", required = false)
        String getAvatarURL();

        @XBridgeParamField(isGetter = true, keyPath = "bindPhone", required = false)
        String getBindPhone();

        @XBridgeParamField(isGetter = true, keyPath = "hasBoundPhone", required = false)
        Boolean getHasBoundPhone();

        @XBridgeParamField(isGetter = true, keyPath = "nickname", required = false)
        String getNickname();

        @XBridgeParamField(isGetter = true, keyPath = "secUserID", required = false)
        String getSecUserID();

        @XBridgeParamField(isGetter = true, keyPath = "shortID", required = false)
        String getShortID();

        @XBridgeParamField(isGetter = true, keyPath = "uniqueID", required = false)
        String getUniqueID();

        @XBridgeParamField(isGetter = true, keyPath = "userID", required = false)
        String getUserID();

        @XBridgeParamField(isGetter = true, keyPath = "isBoundPhone", required = false)
        Boolean isBoundPhone();

        @XBridgeParamField(isGetter = false, keyPath = "avatarURL", required = false)
        void setAvatarURL(String str);

        @XBridgeParamField(isGetter = false, keyPath = "bindPhone", required = false)
        void setBindPhone(String str);

        @XBridgeParamField(isGetter = false, keyPath = "isBoundPhone", required = false)
        void setBoundPhone(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "hasBoundPhone", required = false)
        void setHasBoundPhone(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "nickname", required = false)
        void setNickname(String str);

        @XBridgeParamField(isGetter = false, keyPath = "secUserID", required = false)
        void setSecUserID(String str);

        @XBridgeParamField(isGetter = false, keyPath = "shortID", required = false)
        void setShortID(String str);

        @XBridgeParamField(isGetter = false, keyPath = "uniqueID", required = false)
        void setUniqueID(String str);

        @XBridgeParamField(isGetter = false, keyPath = "userID", required = false)
        void setUserID(String str);
    }

    /* compiled from: AbsXGetUserInfoMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XGetUserInfoParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XGetUserInfoParamModel extends XBaseParamModel {
    }

    /* compiled from: AbsXGetUserInfoMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000b8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XGetUserInfoResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "hasLoggedIn", "getHasLoggedIn", "()Ljava/lang/Boolean;", "setHasLoggedIn", "(Ljava/lang/Boolean;)V", "isLogin", "setLogin", "Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XBridgeBeanXGetUserInfoUserInfo;", "userInfo", "getUserInfo", "()Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XBridgeBeanXGetUserInfoUserInfo;", "setUserInfo", "(Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$XBridgeBeanXGetUserInfoUserInfo;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XGetUserInfoResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "hasLoggedIn", required = true)
        Boolean getHasLoggedIn();

        @XBridgeParamField(isGetter = true, keyPath = "userInfo", nestedClassType = XBridgeBeanXGetUserInfoUserInfo.class, required = false)
        XBridgeBeanXGetUserInfoUserInfo getUserInfo();

        @XBridgeParamField(isGetter = true, keyPath = "isLogin", required = true)
        Boolean isLogin();

        @XBridgeParamField(isGetter = false, keyPath = "hasLoggedIn", required = true)
        void setHasLoggedIn(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "isLogin", required = true)
        void setLogin(Boolean bool);

        @XBridgeParamField(isGetter = false, keyPath = "userInfo", nestedClassType = XBridgeBeanXGetUserInfoUserInfo.class, required = false)
        void setUserInfo(XBridgeBeanXGetUserInfoUserInfo xBridgeBeanXGetUserInfoUserInfo);
    }

    /* compiled from: AbsXGetUserInfoMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/AbsXGetUserInfoMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXGetUserInfoMethodIDL.extensionMetaInfo;
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
}
