package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.service.base.ResourceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ForestAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\tH\u0002\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0014"}, d2 = {"parseSubConfigs", "Lorg/json/JSONObject;", "fmpResourceList", "", "", "uri", "Landroid/net/Uri;", "toArgusLynxResourceType", "Lcom/bytedance/ies/argus/api/ArgusResourceType;", "Lcom/bytedance/forest/model/Scene;", "toRLChannelBundleModel", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;", "Lcom/bytedance/forest/model/GeckoModel;", "toRLResourceFrom", "Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "Lcom/bytedance/forest/model/ResourceFrom;", "response", "Lcom/bytedance/forest/model/Response;", "toRLResourceType", "Lcom/bytedance/ies/bullet/service/base/ResourceType;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestAdapterKt {

    /* compiled from: ForestAdapter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ResourceFrom.values().length];
            try {
                iArr[ResourceFrom.BUILTIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResourceFrom.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Scene.values().length];
            try {
                iArr2[Scene.LYNX_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Scene.LYNX_EXTERNAL_JS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Scene.LYNX_COMPONENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Scene.LYNX_CHILD_RESOURCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Scene.LYNX_FONT.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Scene.LYNX_I18N.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Scene.LYNX_IMAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[Scene.LYNX_LOTTIE.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Scene.LYNX_VIDEO.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Scene.LYNX_SVG.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject parseSubConfigs(List<String> list, Uri uri) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        try {
            Result.Companion companion = Result.Companion;
            if (list != null) {
                for (String str : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("enableMemory", true);
                    jSONObject2.put("url", str);
                    if (StringsKt.contains$default(str, ".css", false, 2, (Object) null)) {
                        jSONArray2.put(jSONObject2);
                    } else {
                        if (!StringsKt.contains$default(str, ".png", false, 2, (Object) null) && !StringsKt.contains$default(str, ".jpg", false, 2, (Object) null) && !StringsKt.contains$default(str, ".jpeg", false, 2, (Object) null) && !StringsKt.contains$default(str, ".webp", false, 2, (Object) null)) {
                            if (StringsKt.contains$default(str, ".js", false, 2, (Object) null)) {
                                jSONArray3.put(jSONObject2);
                            }
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("css", jSONArray2);
            jSONObject.put("script", jSONArray3);
            if (Intrinsics.areEqual(uri != null ? uri.getHost() : null, "webcast_lynxview")) {
                jSONObject.put("type", "lynx");
            } else {
                jSONObject.put("type", "web");
            }
            return jSONObject;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ResourceType toRLResourceType(ResourceFrom resourceFrom, Response response) {
        ResourceType rLResourceType;
        int i = WhenMappings.$EnumSwitchMapping$0[resourceFrom.ordinal()];
        if (i == 1) {
            return ResourceType.ASSET;
        }
        if (i == 2) {
            ResourceFrom originFrom = response.getOriginFrom();
            return (originFrom == null || (rLResourceType = toRLResourceType(originFrom, response)) == null) ? ResourceType.DISK : rLResourceType;
        }
        return ResourceType.DISK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bytedance.ies.bullet.service.base.ResourceFrom toRLResourceFrom(ResourceFrom resourceFrom, Response response) {
        if (response.isPreloaded() || response.isRequestReused()) {
            return com.bytedance.ies.bullet.service.base.ResourceFrom.PRELOAD;
        }
        if (resourceFrom != ResourceFrom.MEMORY) {
            return toRLResourceFrom(resourceFrom);
        }
        ResourceFrom originFrom = response.getOriginFrom();
        if (originFrom != null) {
            return toRLResourceFrom(originFrom, response);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bytedance.ies.bullet.service.base.ResourceFrom toRLResourceFrom(ResourceFrom resourceFrom) {
        if (resourceFrom == ResourceFrom.GECKO) {
            return com.bytedance.ies.bullet.service.base.ResourceFrom.GECKO;
        }
        if (resourceFrom == ResourceFrom.CDN) {
            return com.bytedance.ies.bullet.service.base.ResourceFrom.CDN;
        }
        if (resourceFrom == ResourceFrom.BUILTIN) {
            return com.bytedance.ies.bullet.service.base.ResourceFrom.BUILTIN;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RLChannelBundleModel toRLChannelBundleModel(GeckoModel geckoModel) {
        return new RLChannelBundleModel(geckoModel.getChannel(), geckoModel.getBundle(), !geckoModel.isChannelOrBundleBlank());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArgusResourceType toArgusLynxResourceType(Scene scene) {
        switch (scene == null ? -1 : WhenMappings.$EnumSwitchMapping$1[scene.ordinal()]) {
            case -1:
                return ArgusResourceType.UNKNOWN;
            case 0:
            default:
                return ArgusResourceType.OTHER;
            case 1:
                return ArgusResourceType.LYNX_MAIN_TEMPLATE;
            case 2:
                return ArgusResourceType.LYNX_EXTERNAL_JS;
            case 3:
                return ArgusResourceType.LYNX_COMPONENT;
            case 4:
                return ArgusResourceType.LYNX_CHILD_RESOURCE;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return ArgusResourceType.LYNX_STATIC_RESOURCE;
        }
    }
}
