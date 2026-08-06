package com.bytedance.sdk.xbridge.cn.media.idl;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
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

/* compiled from: AbsXChooseAndUploadMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006\r\u000e\u000f\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XChooseAndUploadParamModel;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XChooseAndUploadResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XBridgeBeanXChooseAndUploadImageParams", "XBridgeBeanXChooseAndUploadTempFiles", "XBridgeBeanXChooseAndUploadVideoParams", "XChooseAndUploadParamModel", "XChooseAndUploadResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXChooseAndUploadMethodIDL extends XCoreIDLBridgeMethod<XChooseAndUploadParamModel, XChooseAndUploadResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "15580"));

    @XBridgeMethodName(name = "x.chooseAndUpload", params = {"mediaType", "maxCount", "sourceType", "cameraType", "needBase64Data", "saveToPhotoAlbum", "imageParams", "videoParams", IWeixinService.ResponseConstants.URL, "params", "header", "needCommonParams"}, results = {"clientCode", "httpCode", "header", "response", "tempFiles"})
    private final String name = "x.chooseAndUpload";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadImageParams;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "compressMaxSize", "", "getCompressMaxSize", "()Ljava/lang/Number;", "cropHeight", "", "getCropHeight", "()Ljava/lang/String;", "cropWidth", "getCropWidth", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXChooseAndUploadImageParams extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "compressMaxSize", required = false)
        Number getCompressMaxSize();

        @XBridgeParamField(isGetter = true, keyPath = "cropHeight", required = false)
        String getCropHeight();

        @XBridgeParamField(isGetter = true, keyPath = "cropWidth", required = false)
        String getCropWidth();
    }

    /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadVideoParams;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "durationLimit", "", "getDurationLimit", "()Ljava/lang/Number;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXChooseAndUploadVideoParams extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "durationLimit", required = false)
        Number getDurationLimit();
    }

    /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR@\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR@\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R4\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XChooseAndUploadResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "clientCode", "getClientCode", "()Ljava/lang/Number;", "setClientCode", "(Ljava/lang/Number;)V", "", "", "", "header", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "httpCode", "getHttpCode", "setHttpCode", "response", "getResponse", "setResponse", "", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadTempFiles;", "tempFiles", "getTempFiles", "()Ljava/util/List;", "setTempFiles", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XChooseAndUploadResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientCode", required = true)
        Number getClientCode();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "httpCode", required = false)
        Number getHttpCode();

        @XBridgeParamField(isGetter = true, keyPath = "response", required = false)
        Map<String, Object> getResponse();

        @XBridgeParamField(isGetter = true, keyPath = "tempFiles", nestedClassType = XBridgeBeanXChooseAndUploadTempFiles.class, required = true)
        List<XBridgeBeanXChooseAndUploadTempFiles> getTempFiles();

        @XBridgeParamField(isGetter = false, keyPath = "clientCode", required = true)
        void setClientCode(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> map);

        @XBridgeParamField(isGetter = false, keyPath = "httpCode", required = false)
        void setHttpCode(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(Map<String, ? extends Object> map);

        @XBridgeParamField(isGetter = false, keyPath = "tempFiles", nestedClassType = XBridgeBeanXChooseAndUploadTempFiles.class, required = true)
        void setTempFiles(List<? extends XBridgeBeanXChooseAndUploadTempFiles> list);
    }

    /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXChooseAndUploadMethodIDL.extensionMetaInfo;
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

    /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 )2\u00020\u0001:\u0001)R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\"\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u0014\u0010\u001f\u001a\u00020\u00188gX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0005R\u0014\u0010#\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0005R\u0016\u0010%\u001a\u0004\u0018\u00010&8gX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XChooseAndUploadParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "cameraType", "", "getCameraType", "()Ljava/lang/String;", "header", "", "", "getHeader", "()Ljava/util/Map;", "imageParams", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadImageParams;", "getImageParams", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadImageParams;", "maxCount", "", "getMaxCount", "()Ljava/lang/Number;", "mediaType", "", "getMediaType", "()Ljava/util/List;", "needBase64Data", "", "getNeedBase64Data", "()Z", "needCommonParams", "getNeedCommonParams", "params", "getParams", "saveToPhotoAlbum", "getSaveToPhotoAlbum", "sourceType", "getSourceType", IWeixinService.ResponseConstants.URL, "getUrl", "videoParams", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadVideoParams;", "getVideoParams", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadVideoParams;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XChooseAndUploadParamModel extends XBaseParamModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XChooseAndUploadCameraTypeBack = "back";
        public static final String XChooseAndUploadCameraTypeFront = "front";
        public static final String XChooseAndUploadMediaTypeImage = "image";
        public static final String XChooseAndUploadMediaTypeVideo = "video";
        public static final String XChooseAndUploadSourceTypeAlbum = "album";
        public static final String XChooseAndUploadSourceTypeCamera = "camera";

        @XBridgeStringEnum(option = {"back", "front"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "cameraType", required = false)
        String getCameraType();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "imageParams", nestedClassType = XBridgeBeanXChooseAndUploadImageParams.class, required = false)
        XBridgeBeanXChooseAndUploadImageParams getImageParams();

        @XBridgeParamField(isGetter = true, keyPath = "maxCount", required = true)
        Number getMaxCount();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", primitiveClassType = String.class, required = true)
        List<String> getMediaType();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), isGetter = true, keyPath = "needBase64Data", required = false)
        boolean getNeedBase64Data();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), isGetter = true, keyPath = "needCommonParams", required = false)
        boolean getNeedCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), isGetter = true, keyPath = "saveToPhotoAlbum", required = false)
        boolean getSaveToPhotoAlbum();

        @XBridgeStringEnum(option = {"album", "camera"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "sourceType", required = true)
        String getSourceType();

        @XBridgeParamField(isGetter = true, keyPath = IWeixinService.ResponseConstants.URL, required = true)
        String getUrl();

        @XBridgeParamField(isGetter = true, keyPath = "videoParams", nestedClassType = XBridgeBeanXChooseAndUploadVideoParams.class, required = false)
        XBridgeBeanXChooseAndUploadVideoParams getVideoParams();

        /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XChooseAndUploadParamModel$Companion;", "", "()V", "XChooseAndUploadCameraTypeBack", "", "XChooseAndUploadCameraTypeFront", "XChooseAndUploadMediaTypeImage", "XChooseAndUploadMediaTypeVideo", "XChooseAndUploadSourceTypeAlbum", "XChooseAndUploadSourceTypeCamera", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XChooseAndUploadCameraTypeBack = "back";
            public static final String XChooseAndUploadCameraTypeFront = "front";
            public static final String XChooseAndUploadMediaTypeImage = "image";
            public static final String XChooseAndUploadMediaTypeVideo = "video";
            public static final String XChooseAndUploadSourceTypeAlbum = "album";
            public static final String XChooseAndUploadSourceTypeCamera = "camera";

            private Companion() {
            }
        }
    }

    /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0004\n\u0002\b\n\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bR(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00128g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadTempFiles;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", "base64Data", "getBase64Data", "()Ljava/lang/String;", "setBase64Data", "(Ljava/lang/String;)V", "mediaType", "getMediaType", "setMediaType", "mimeType", "getMimeType", "setMimeType", "path", "getPath", "setPath", "", "size", "getSize", "()Ljava/lang/Number;", "setSize", "(Ljava/lang/Number;)V", IWeixinService.ResponseConstants.URL, "getUrl", "setUrl", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXChooseAndUploadTempFiles extends XBaseModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String Image = "image";
        public static final String Video = "video";

        @XBridgeParamField(isGetter = true, keyPath = "base64Data", required = false)
        String getBase64Data();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", required = true)
        String getMediaType();

        @XBridgeParamField(isGetter = true, keyPath = "mimeType", required = true)
        String getMimeType();

        @XBridgeParamField(isGetter = true, keyPath = "path", required = true)
        String getPath();

        @XBridgeParamField(isGetter = true, keyPath = "size", required = true)
        Number getSize();

        @XBridgeParamField(isGetter = true, keyPath = IWeixinService.ResponseConstants.URL, required = false)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "base64Data", required = false)
        void setBase64Data(String str);

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "mediaType", required = true)
        void setMediaType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "mimeType", required = true)
        void setMimeType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "path", required = true)
        void setPath(String str);

        @XBridgeParamField(isGetter = false, keyPath = "size", required = true)
        void setSize(Number number);

        @XBridgeParamField(isGetter = false, keyPath = IWeixinService.ResponseConstants.URL, required = false)
        void setUrl(String str);

        /* compiled from: AbsXChooseAndUploadMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XBridgeBeanXChooseAndUploadTempFiles$Companion;", "", "()V", "Image", "", "Video", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String Image = "image";
            public static final String Video = "video";

            private Companion() {
            }
        }
    }
}
