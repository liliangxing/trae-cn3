package com.bytedance.sdk.xbridge.cn.media.idl;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
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

/* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XUploadVideoToVODParamModel;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XUploadVideoToVODResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XBridgeBeanXUploadVideoToVODAuthConfig", "XBridgeBeanXUploadVideoToVODErrorInfo", "XBridgeBeanXUploadVideoToVODUploadConfig", "XBridgeBeanXUploadVideoToVODVideoInfo", "XUploadVideoToVODParamModel", "XUploadVideoToVODResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXUploadVideoToVODMethodIDL extends XCoreIDLBridgeMethod<XUploadVideoToVODParamModel, XUploadVideoToVODResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "26429"));

    @XBridgeMethodName(name = "x.uploadVideoToVOD", params = {"authConfig", "uploadConfig", "filePath"}, results = {"traceId", "errorInfo", "videoInfo"})
    private final String name = "x.uploadVideoToVOD";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODAuthConfig;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "accessKeyId", "", "getAccessKeyId", "()Ljava/lang/String;", "hostName", "getHostName", "secretAccessKey", "getSecretAccessKey", "sessionToken", "getSessionToken", "spaceName", "getSpaceName", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadVideoToVODAuthConfig extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessKeyId", required = true)
        String getAccessKeyId();

        @XBridgeParamField(isGetter = true, keyPath = "hostName", required = true)
        String getHostName();

        @XBridgeParamField(isGetter = true, keyPath = "secretAccessKey", required = true)
        String getSecretAccessKey();

        @XBridgeParamField(isGetter = true, keyPath = "sessionToken", required = true)
        String getSessionToken();

        @XBridgeParamField(isGetter = true, keyPath = "spaceName", required = true)
        String getSpaceName();
    }

    /* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODErrorInfo;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", AccountMonitorConstants.CommonParameter.ERROR, "getErrorCode", "()Ljava/lang/Number;", "setErrorCode", "(Ljava/lang/Number;)V", "", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadVideoToVODErrorInfo extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = AccountMonitorConstants.CommonParameter.ERROR, required = false)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMessage", required = false)
        String getErrorMessage();

        @XBridgeParamField(isGetter = false, keyPath = AccountMonitorConstants.CommonParameter.ERROR, required = false)
        void setErrorCode(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "errorMessage", required = false)
        void setErrorMessage(String str);
    }

    /* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODUploadConfig;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "sliceSize", "", "getSliceSize", "()Ljava/lang/Number;", "socketNum", "getSocketNum", "traceId", "", "getTraceId", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadVideoToVODUploadConfig extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "sliceSize", required = false)
        Number getSliceSize();

        @XBridgeParamField(isGetter = true, keyPath = "socketNum", required = false)
        Number getSocketNum();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = false)
        String getTraceId();
    }

    /* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR@\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODVideoInfo;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", "coverUri", "getCoverUri", "()Ljava/lang/String;", "setCoverUri", "(Ljava/lang/String;)V", "", "", "metaInfo", "getMetaInfo", "()Ljava/util/Map;", "setMetaInfo", "(Ljava/util/Map;)V", "vid", "getVid", "setVid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadVideoToVODVideoInfo extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "coverUri", required = false)
        String getCoverUri();

        @XBridgeParamField(isGetter = true, keyPath = "metaInfo", required = false)
        Map<String, Object> getMetaInfo();

        @XBridgeParamField(isGetter = true, keyPath = "vid", required = false)
        String getVid();

        @XBridgeParamField(isGetter = false, keyPath = "coverUri", required = false)
        void setCoverUri(String str);

        @XBridgeParamField(isGetter = false, keyPath = "metaInfo", required = false)
        void setMetaInfo(Map<String, ? extends Object> map);

        @XBridgeParamField(isGetter = false, keyPath = "vid", required = false)
        void setVid(String str);
    }

    /* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XUploadVideoToVODParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "authConfig", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODAuthConfig;", "getAuthConfig", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODAuthConfig;", "filePath", "", "getFilePath", "()Ljava/lang/String;", "uploadConfig", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODUploadConfig;", "getUploadConfig", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODUploadConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XUploadVideoToVODParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "authConfig", nestedClassType = XBridgeBeanXUploadVideoToVODAuthConfig.class, required = true)
        XBridgeBeanXUploadVideoToVODAuthConfig getAuthConfig();

        @XBridgeParamField(isGetter = true, keyPath = "filePath", required = true)
        String getFilePath();

        @XBridgeParamField(isGetter = true, keyPath = "uploadConfig", nestedClassType = XBridgeBeanXUploadVideoToVODUploadConfig.class, required = false)
        XBridgeBeanXUploadVideoToVODUploadConfig getUploadConfig();
    }

    /* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XUploadVideoToVODResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODErrorInfo;", "errorInfo", "getErrorInfo", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODErrorInfo;", "setErrorInfo", "(Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODErrorInfo;)V", "", "traceId", "getTraceId", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODVideoInfo;", "videoInfo", "getVideoInfo", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODVideoInfo;", "setVideoInfo", "(Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XBridgeBeanXUploadVideoToVODVideoInfo;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XUploadVideoToVODResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorInfo", nestedClassType = XBridgeBeanXUploadVideoToVODErrorInfo.class, required = false)
        XBridgeBeanXUploadVideoToVODErrorInfo getErrorInfo();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = true)
        String getTraceId();

        @XBridgeParamField(isGetter = true, keyPath = "videoInfo", nestedClassType = XBridgeBeanXUploadVideoToVODVideoInfo.class, required = false)
        XBridgeBeanXUploadVideoToVODVideoInfo getVideoInfo();

        @XBridgeParamField(isGetter = false, keyPath = "errorInfo", nestedClassType = XBridgeBeanXUploadVideoToVODErrorInfo.class, required = false)
        void setErrorInfo(XBridgeBeanXUploadVideoToVODErrorInfo xBridgeBeanXUploadVideoToVODErrorInfo);

        @XBridgeParamField(isGetter = false, keyPath = "traceId", required = true)
        void setTraceId(String str);

        @XBridgeParamField(isGetter = false, keyPath = "videoInfo", nestedClassType = XBridgeBeanXUploadVideoToVODVideoInfo.class, required = false)
        void setVideoInfo(XBridgeBeanXUploadVideoToVODVideoInfo xBridgeBeanXUploadVideoToVODVideoInfo);
    }

    /* compiled from: AbsXUploadVideoToVODMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXUploadVideoToVODMethodIDL.extensionMetaInfo;
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
