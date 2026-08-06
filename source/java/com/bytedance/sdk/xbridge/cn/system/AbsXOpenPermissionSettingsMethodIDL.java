package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXOpenPermissionSettingsMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsParamModel;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XOpenPermissionSettingsParamModel", "XOpenPermissionSettingsResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXOpenPermissionSettingsMethodIDL extends XCoreIDLBridgeMethod<XOpenPermissionSettingsParamModel, XOpenPermissionSettingsResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "34886"));

    @XBridgeMethodName(name = "x.openPermissionSettings", params = {"permission", "accessLevel"}, results = {PageDataManager.EXTRA_STATUS})
    private final String name = "x.openPermissionSettings";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXOpenPermissionSettingsMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXOpenPermissionSettingsMethodIDL.extensionMetaInfo;
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

    /* compiled from: AbsXOpenPermissionSettingsMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "accessLevel", "", "getAccessLevel", "()Ljava/lang/String;", "permission", "getPermission", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XOpenPermissionSettingsParamModel extends XBaseParamModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XOpenPermissionSettingsAccessLevelReadOnly = "readOnly";
        public static final String XOpenPermissionSettingsAccessLevelReadWrite = "readWrite";
        public static final String XOpenPermissionSettingsAccessLevelWriteOnly = "writeOnly";
        public static final String XOpenPermissionSettingsPermissionCalendar = "calendar";
        public static final String XOpenPermissionSettingsPermissionCamera = "camera";
        public static final String XOpenPermissionSettingsPermissionContacts = "contacts";
        public static final String XOpenPermissionSettingsPermissionFineLocation = "fine_location";
        public static final String XOpenPermissionSettingsPermissionLocation = "location";
        public static final String XOpenPermissionSettingsPermissionMicrophone = "microphone";
        public static final String XOpenPermissionSettingsPermissionNotification = "notification";
        public static final String XOpenPermissionSettingsPermissionPhotoAlbum = "photoAlbum";
        public static final String XOpenPermissionSettingsPermissionReadCalendar = "read_calendar";
        public static final String XOpenPermissionSettingsPermissionVibrate = "vibrate";
        public static final String XOpenPermissionSettingsPermissionWriteCalendar = "write_calendar";

        @XBridgeStringEnum(option = {"readOnly", "readWrite", "writeOnly"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "accessLevel", required = false)
        String getAccessLevel();

        @XBridgeStringEnum(option = {"calendar", "camera", "contacts", "fine_location", "location", "microphone", "notification", "photoAlbum", "read_calendar", "vibrate", "write_calendar"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "permission", required = true)
        String getPermission();

        /* compiled from: AbsXOpenPermissionSettingsMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsParamModel$Companion;", "", "()V", "XOpenPermissionSettingsAccessLevelReadOnly", "", "XOpenPermissionSettingsAccessLevelReadWrite", "XOpenPermissionSettingsAccessLevelWriteOnly", "XOpenPermissionSettingsPermissionCalendar", "XOpenPermissionSettingsPermissionCamera", "XOpenPermissionSettingsPermissionContacts", "XOpenPermissionSettingsPermissionFineLocation", "XOpenPermissionSettingsPermissionLocation", "XOpenPermissionSettingsPermissionMicrophone", "XOpenPermissionSettingsPermissionNotification", "XOpenPermissionSettingsPermissionPhotoAlbum", "XOpenPermissionSettingsPermissionReadCalendar", "XOpenPermissionSettingsPermissionVibrate", "XOpenPermissionSettingsPermissionWriteCalendar", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XOpenPermissionSettingsAccessLevelReadOnly = "readOnly";
            public static final String XOpenPermissionSettingsAccessLevelReadWrite = "readWrite";
            public static final String XOpenPermissionSettingsAccessLevelWriteOnly = "writeOnly";
            public static final String XOpenPermissionSettingsPermissionCalendar = "calendar";
            public static final String XOpenPermissionSettingsPermissionCamera = "camera";
            public static final String XOpenPermissionSettingsPermissionContacts = "contacts";
            public static final String XOpenPermissionSettingsPermissionFineLocation = "fine_location";
            public static final String XOpenPermissionSettingsPermissionLocation = "location";
            public static final String XOpenPermissionSettingsPermissionMicrophone = "microphone";
            public static final String XOpenPermissionSettingsPermissionNotification = "notification";
            public static final String XOpenPermissionSettingsPermissionPhotoAlbum = "photoAlbum";
            public static final String XOpenPermissionSettingsPermissionReadCalendar = "read_calendar";
            public static final String XOpenPermissionSettingsPermissionVibrate = "vibrate";
            public static final String XOpenPermissionSettingsPermissionWriteCalendar = "write_calendar";

            private Companion() {
            }
        }
    }

    /* compiled from: AbsXOpenPermissionSettingsMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tR(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", PageDataManager.EXTRA_STATUS, "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XOpenPermissionSettingsResultModel extends XBaseResultModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XOpenPermissionSettingsStatusDenied = "denied";
        public static final String XOpenPermissionSettingsStatusPermitted = "permitted";
        public static final String XOpenPermissionSettingsStatusRestricted = "restricted";
        public static final String XOpenPermissionSettingsStatusUndetermined = "undetermined";

        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = PageDataManager.EXTRA_STATUS, required = true)
        String getStatus();

        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = PageDataManager.EXTRA_STATUS, required = true)
        void setStatus(String str);

        /* compiled from: AbsXOpenPermissionSettingsMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsResultModel$Companion;", "", "()V", "XOpenPermissionSettingsStatusDenied", "", "XOpenPermissionSettingsStatusPermitted", "XOpenPermissionSettingsStatusRestricted", "XOpenPermissionSettingsStatusUndetermined", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XOpenPermissionSettingsStatusDenied = "denied";
            public static final String XOpenPermissionSettingsStatusPermitted = "permitted";
            public static final String XOpenPermissionSettingsStatusRestricted = "restricted";
            public static final String XOpenPermissionSettingsStatusUndetermined = "undetermined";

            private Companion() {
            }
        }
    }
}
