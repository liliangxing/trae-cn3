package com.bytedance.sdk.xbridge.cn.media.idl;

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

/* compiled from: AbsXChooseMediaMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006\r\u000e\u000f\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XChooseMediaParamModel;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XChooseMediaResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XBridgeBeanXChooseMediaImageParams", "XBridgeBeanXChooseMediaTempFiles", "XBridgeBeanXChooseMediaVideoParams", "XChooseMediaParamModel", "XChooseMediaResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXChooseMediaMethodIDL extends XCoreIDLBridgeMethod<XChooseMediaParamModel, XChooseMediaResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "32568"));

    @XBridgeMethodName(name = "x.chooseMedia", params = {"maxCount", "mediaTypes", "mediaType", "sourceType", "cameraType", "compressImage", "compressWidth", "compressHeight", "saveToPhotoAlbum", "isNeedCut", "cropRatioWidth", "cropRatioHeight", "needBase64Data", "needBinaryData", "imageParams", "videoParams", "ignoreUserCancel", "copyToPrivateDirection"}, results = {"tempFiles"})
    private final String name = "x.chooseMedia";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsXChooseMediaMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaImageParams;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "compressMaxSize", "", "getCompressMaxSize", "()Ljava/lang/Number;", "cropHeight", "", "getCropHeight", "()Ljava/lang/String;", "cropWidth", "getCropWidth", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXChooseMediaImageParams extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "compressMaxSize", required = false)
        Number getCompressMaxSize();

        @XBridgeParamField(isGetter = true, keyPath = "cropHeight", required = false)
        String getCropHeight();

        @XBridgeParamField(isGetter = true, keyPath = "cropWidth", required = false)
        String getCropWidth();
    }

    /* compiled from: AbsXChooseMediaMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaVideoParams;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "durationLimit", "", "getDurationLimit", "()Ljava/lang/Number;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXChooseMediaVideoParams extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "durationLimit", required = false)
        Number getDurationLimit();
    }

    /* compiled from: AbsXChooseMediaMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R4\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XChooseMediaResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaTempFiles;", "tempFiles", "getTempFiles", "()Ljava/util/List;", "setTempFiles", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XChooseMediaResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "tempFiles", nestedClassType = XBridgeBeanXChooseMediaTempFiles.class, required = true)
        List<XBridgeBeanXChooseMediaTempFiles> getTempFiles();

        @XBridgeParamField(isGetter = false, keyPath = "tempFiles", nestedClassType = XBridgeBeanXChooseMediaTempFiles.class, required = true)
        void setTempFiles(List<? extends XBridgeBeanXChooseMediaTempFiles> list);
    }

    /* compiled from: AbsXChooseMediaMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXChooseMediaMethodIDL.extensionMetaInfo;
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

    /* compiled from: AbsXChooseMediaMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 12\u00020\u0001:\u00011R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 8gX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 8gX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0016\u0010%\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\rR\u0016\u0010'\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\rR\u0016\u0010)\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\rR\u0014\u0010+\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0016\u0010-\u001a\u0004\u0018\u00010.8gX¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XChooseMediaParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "cameraType", "", "getCameraType", "()Ljava/lang/String;", "compressHeight", "", "getCompressHeight", "()Ljava/lang/Number;", "compressImage", "", "getCompressImage", "()Ljava/lang/Boolean;", "compressWidth", "getCompressWidth", "copyToPrivateDirection", "getCopyToPrivateDirection", "cropRatioHeight", "getCropRatioHeight", "cropRatioWidth", "getCropRatioWidth", "ignoreUserCancel", "getIgnoreUserCancel", "imageParams", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaImageParams;", "getImageParams", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaImageParams;", "isNeedCut", "maxCount", "getMaxCount", "mediaType", "", "getMediaType", "()Ljava/util/List;", "mediaTypes", "getMediaTypes", "needBase64Data", "getNeedBase64Data", "needBinaryData", "getNeedBinaryData", "saveToPhotoAlbum", "getSaveToPhotoAlbum", "sourceType", "getSourceType", "videoParams", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaVideoParams;", "getVideoParams", "()Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaVideoParams;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XChooseMediaParamModel extends XBaseParamModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XChooseMediaCameraTypeBack = "back";
        public static final String XChooseMediaCameraTypeFront = "front";
        public static final String XChooseMediaMediaTypeImage = "image";
        public static final String XChooseMediaMediaTypeVideo = "video";
        public static final String XChooseMediaMediaTypesImage = "image";
        public static final String XChooseMediaMediaTypesVideo = "video";
        public static final String XChooseMediaSourceTypeAlbum = "album";
        public static final String XChooseMediaSourceTypeCamera = "camera";

        @XBridgeStringEnum(option = {"back", "front"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "cameraType", required = false)
        String getCameraType();

        @XBridgeParamField(isGetter = true, keyPath = "compressHeight", required = false)
        Number getCompressHeight();

        @XBridgeParamField(isGetter = true, keyPath = "compressImage", required = false)
        Boolean getCompressImage();

        @XBridgeParamField(isGetter = true, keyPath = "compressWidth", required = false)
        Number getCompressWidth();

        @XBridgeParamField(isGetter = true, keyPath = "copyToPrivateDirection", required = false)
        Boolean getCopyToPrivateDirection();

        @XBridgeParamField(isGetter = true, keyPath = "cropRatioHeight", required = false)
        Number getCropRatioHeight();

        @XBridgeParamField(isGetter = true, keyPath = "cropRatioWidth", required = false)
        Number getCropRatioWidth();

        @XBridgeParamField(isGetter = true, keyPath = "ignoreUserCancel", required = false)
        Boolean getIgnoreUserCancel();

        @XBridgeParamField(isGetter = true, keyPath = "imageParams", nestedClassType = XBridgeBeanXChooseMediaImageParams.class, required = false)
        XBridgeBeanXChooseMediaImageParams getImageParams();

        @XBridgeParamField(isGetter = true, keyPath = "maxCount", required = false)
        Number getMaxCount();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", primitiveClassType = String.class, required = false)
        List<String> getMediaType();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaTypes", primitiveClassType = String.class, required = false)
        List<String> getMediaTypes();

        @XBridgeParamField(isGetter = true, keyPath = "needBase64Data", required = false)
        Boolean getNeedBase64Data();

        @XBridgeParamField(isGetter = true, keyPath = "needBinaryData", required = false)
        Boolean getNeedBinaryData();

        @XBridgeParamField(isGetter = true, keyPath = "saveToPhotoAlbum", required = false)
        Boolean getSaveToPhotoAlbum();

        @XBridgeStringEnum(option = {"album", "camera"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "sourceType", required = true)
        String getSourceType();

        @XBridgeParamField(isGetter = true, keyPath = "videoParams", nestedClassType = XBridgeBeanXChooseMediaVideoParams.class, required = false)
        XBridgeBeanXChooseMediaVideoParams getVideoParams();

        @XBridgeParamField(isGetter = true, keyPath = "isNeedCut", required = false)
        Boolean isNeedCut();

        /* compiled from: AbsXChooseMediaMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XChooseMediaParamModel$Companion;", "", "()V", "XChooseMediaCameraTypeBack", "", "XChooseMediaCameraTypeFront", "XChooseMediaMediaTypeImage", "XChooseMediaMediaTypeVideo", "XChooseMediaMediaTypesImage", "XChooseMediaMediaTypesVideo", "XChooseMediaSourceTypeAlbum", "XChooseMediaSourceTypeCamera", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XChooseMediaCameraTypeBack = "back";
            public static final String XChooseMediaCameraTypeFront = "front";
            public static final String XChooseMediaMediaTypeImage = "image";
            public static final String XChooseMediaMediaTypeVideo = "video";
            public static final String XChooseMediaMediaTypesImage = "image";
            public static final String XChooseMediaMediaTypesVideo = "video";
            public static final String XChooseMediaSourceTypeAlbum = "album";
            public static final String XChooseMediaSourceTypeCamera = "camera";

            private Companion() {
            }
        }
    }

    /* compiled from: AbsXChooseMediaMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0004\n\u0002\b\n\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bR(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00128g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaTempFiles;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", "base64Data", "getBase64Data", "()Ljava/lang/String;", "setBase64Data", "(Ljava/lang/String;)V", "mediaType", "getMediaType", "setMediaType", "mimeType", "getMimeType", "setMimeType", "path", "getPath", "setPath", "", "size", "getSize", "()Ljava/lang/Number;", "setSize", "(Ljava/lang/Number;)V", "tempFilePath", "getTempFilePath", "setTempFilePath", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XBridgeBeanXChooseMediaTempFiles extends XBaseModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XChooseMediaMediaTypeImage = "image";
        public static final String XChooseMediaMediaTypeVideo = "video";

        @XBridgeParamField(isGetter = true, keyPath = "base64Data", required = false)
        String getBase64Data();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", required = true)
        String getMediaType();

        @XBridgeParamField(isGetter = true, keyPath = "mimeType", required = false)
        String getMimeType();

        @XBridgeParamField(isGetter = true, keyPath = "path", required = true)
        String getPath();

        @XBridgeParamField(isGetter = true, keyPath = "size", required = true)
        Number getSize();

        @XBridgeParamField(isGetter = true, keyPath = "tempFilePath", required = true)
        String getTempFilePath();

        @XBridgeParamField(isGetter = false, keyPath = "base64Data", required = false)
        void setBase64Data(String str);

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "mediaType", required = true)
        void setMediaType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "mimeType", required = false)
        void setMimeType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "path", required = true)
        void setPath(String str);

        @XBridgeParamField(isGetter = false, keyPath = "size", required = true)
        void setSize(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "tempFilePath", required = true)
        void setTempFilePath(String str);

        /* compiled from: AbsXChooseMediaMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XBridgeBeanXChooseMediaTempFiles$Companion;", "", "()V", "XChooseMediaMediaTypeImage", "", "XChooseMediaMediaTypeVideo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XChooseMediaMediaTypeImage = "image";
            public static final String XChooseMediaMediaTypeVideo = "video";

            private Companion() {
            }
        }
    }
}
