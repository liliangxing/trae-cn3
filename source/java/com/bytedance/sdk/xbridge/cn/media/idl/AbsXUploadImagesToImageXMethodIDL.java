package com.bytedance.sdk.xbridge.cn.media.idl;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
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
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXParamModel;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XBridgeBeanXUploadImagesToImageXAuthConfig", "XBridgeBeanXUploadImagesToImageXE2EEncInfoDict", "XBridgeBeanXUploadImagesToImageXErrorInfo", "XBridgeBeanXUploadImagesToImageXImageInfos", "XBridgeBeanXUploadImagesToImageXUploadConfig", "XUploadImagesToImageXParamModel", "XUploadImagesToImageXResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXUploadImagesToImageXMethodIDL extends XCoreIDLBridgeMethod<XUploadImagesToImageXParamModel, XUploadImagesToImageXResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "26428"));

    @XBridgeMethodName(name = "x.uploadImagesToImageX", params = {"authConfig", "uploadConfig", "filePaths"}, results = {"imageInfos", "errorInfo", "traceId"})
    private final String name = "x.uploadImagesToImageX";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXAuthConfig;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "accessKeyId", "", "getAccessKeyId", "()Ljava/lang/String;", "hostName", "getHostName", "secretAccessKey", "getSecretAccessKey", "serviceId", "getServiceId", "sessionToken", "getSessionToken", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadImagesToImageXAuthConfig extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessKeyId", required = true)
        String getAccessKeyId();

        @XBridgeParamField(isGetter = true, keyPath = "hostName", required = true)
        String getHostName();

        @XBridgeParamField(isGetter = true, keyPath = "secretAccessKey", required = true)
        String getSecretAccessKey();

        @XBridgeParamField(isGetter = true, keyPath = "serviceId", required = true)
        String getServiceId();

        @XBridgeParamField(isGetter = true, keyPath = "sessionToken", required = true)
        String getSessionToken();
    }

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXE2EEncInfoDict;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "option", "", "getOption", "()Ljava/lang/Number;", "publicKey", "getPublicKey", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadImagesToImageXE2EEncInfoDict extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "aesKey", required = false)
        String getAesKey();

        @XBridgeParamField(isGetter = true, keyPath = "option", required = true)
        Number getOption();

        @XBridgeParamField(isGetter = true, keyPath = "publicKey", required = false)
        String getPublicKey();
    }

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXErrorInfo;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", AccountMonitorConstants.CommonParameter.ERROR, "getErrorCode", "()Ljava/lang/Number;", "setErrorCode", "(Ljava/lang/Number;)V", "", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadImagesToImageXErrorInfo extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = AccountMonitorConstants.CommonParameter.ERROR, required = false)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMessage", required = false)
        String getErrorMessage();

        @XBridgeParamField(isGetter = false, keyPath = AccountMonitorConstants.CommonParameter.ERROR, required = false)
        void setErrorCode(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "errorMessage", required = false)
        void setErrorMessage(String str);
    }

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001R@\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR@\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR(\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0002\u001a\u0004\u0018\u00010\u00048g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXImageInfos;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", "", "", "encryptionInfo", "getEncryptionInfo", "()Ljava/util/Map;", "setEncryptionInfo", "(Ljava/util/Map;)V", "metaInfo", "getMetaInfo", "setMetaInfo", "uri", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadImagesToImageXImageInfos extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "encryptionInfo", required = false)
        Map<String, Object> getEncryptionInfo();

        @XBridgeParamField(isGetter = true, keyPath = "metaInfo", required = false)
        Map<String, Object> getMetaInfo();

        @XBridgeParamField(isGetter = true, keyPath = "uri", required = false)
        String getUri();

        @XBridgeParamField(isGetter = false, keyPath = "encryptionInfo", required = false)
        void setEncryptionInfo(Map<String, ? extends Object> map);

        @XBridgeParamField(isGetter = false, keyPath = "metaInfo", required = false)
        void setMetaInfo(Map<String, ? extends Object> map);

        @XBridgeParamField(isGetter = false, keyPath = "uri", required = false)
        void setUri(String str);
    }

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXUploadConfig;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "sliceSize", "", "getSliceSize", "()Ljava/lang/Number;", "socketNum", "getSocketNum", "traceId", "", "getTraceId", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXUploadImagesToImageXUploadConfig extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "sliceSize", required = false)
        Number getSliceSize();

        @XBridgeParamField(isGetter = true, keyPath = "socketNum", required = false)
        Number getSocketNum();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = false)
        String getTraceId();
    }

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR4\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u00108g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXErrorInfo;", "errorInfo", "getErrorInfo", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXErrorInfo;", "setErrorInfo", "(Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXErrorInfo;)V", "", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXImageInfos;", "imageInfos", "getImageInfos", "()Ljava/util/List;", "setImageInfos", "(Ljava/util/List;)V", "", "traceId", "getTraceId", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XUploadImagesToImageXResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorInfo", nestedClassType = XBridgeBeanXUploadImagesToImageXErrorInfo.class, required = false)
        XBridgeBeanXUploadImagesToImageXErrorInfo getErrorInfo();

        @XBridgeParamField(isGetter = true, keyPath = "imageInfos", nestedClassType = XBridgeBeanXUploadImagesToImageXImageInfos.class, required = false)
        List<XBridgeBeanXUploadImagesToImageXImageInfos> getImageInfos();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = true)
        String getTraceId();

        @XBridgeParamField(isGetter = false, keyPath = "errorInfo", nestedClassType = XBridgeBeanXUploadImagesToImageXErrorInfo.class, required = false)
        void setErrorInfo(XBridgeBeanXUploadImagesToImageXErrorInfo xBridgeBeanXUploadImagesToImageXErrorInfo);

        @XBridgeParamField(isGetter = false, keyPath = "imageInfos", nestedClassType = XBridgeBeanXUploadImagesToImageXImageInfos.class, required = false)
        void setImageInfos(List<? extends XBridgeBeanXUploadImagesToImageXImageInfos> list);

        @XBridgeParamField(isGetter = false, keyPath = "traceId", required = true)
        void setTraceId(String str);
    }

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXUploadImagesToImageXMethodIDL.extensionMetaInfo;
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

    /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "authConfig", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXAuthConfig;", "getAuthConfig", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXAuthConfig;", "encryptionConfig", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXE2EEncInfoDict;", "getEncryptionConfig", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXE2EEncInfoDict;", "filePaths", "", "", "getFilePaths", "()Ljava/util/List;", "<set-?>", "mainNetworkType", "getMainNetworkType", "()Ljava/lang/String;", "setMainNetworkType", "(Ljava/lang/String;)V", "uploadConfig", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXUploadConfig;", "getUploadConfig", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XBridgeBeanXUploadImagesToImageXUploadConfig;", "MainNetworkType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XUploadImagesToImageXParamModel extends XBaseParamModel {
        public static final String BUILTIN = "builtIn";

        /* renamed from: MainNetworkType, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String TTNET = "ttnet";

        @XBridgeParamField(isGetter = true, keyPath = "authConfig", nestedClassType = XBridgeBeanXUploadImagesToImageXAuthConfig.class, required = true)
        XBridgeBeanXUploadImagesToImageXAuthConfig getAuthConfig();

        @XBridgeParamField(isGetter = true, keyPath = "encryptionConfig", nestedClassType = XBridgeBeanXUploadImagesToImageXE2EEncInfoDict.class, required = false)
        XBridgeBeanXUploadImagesToImageXE2EEncInfoDict getEncryptionConfig();

        @XBridgeParamField(isGetter = true, keyPath = "filePaths", primitiveClassType = String.class, required = true)
        List<String> getFilePaths();

        @XBridgeStringEnum(option = {"ttnet", "builtIn"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mainNetworkType", required = false)
        String getMainNetworkType();

        @XBridgeParamField(isGetter = true, keyPath = "uploadConfig", nestedClassType = XBridgeBeanXUploadImagesToImageXUploadConfig.class, required = false)
        XBridgeBeanXUploadImagesToImageXUploadConfig getUploadConfig();

        @XBridgeStringEnum(option = {"ttnet", "builtIn"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "mainNetworkType", required = false)
        void setMainNetworkType(String str);

        /* compiled from: AbsXUploadImagesToImageXMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXParamModel$MainNetworkType;", "", "()V", "BUILTIN", "", "TTNET", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* renamed from: com.bytedance.sdk.xbridge.cn.media.idl.AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXParamModel$MainNetworkType, reason: from kotlin metadata */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String BUILTIN = "builtIn";
            public static final String TTNET = "ttnet";

            private Companion() {
            }
        }
    }
}
