package com.bytedance.kit.nglynx.compatible;

import android.net.Uri;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CompatibleUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0002\b\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u001e\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J4\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010!\u001a\u00020\"*\u00020\"2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/kit/nglynx/compatible/CompatibleUtil;", "", "()V", "CONFIG_FILE_NAME", "", "KEY_ACCESS_KEY", "KEY_CARD_ID", "KEY_GECKO_FORMAT", "KEY_GROUP_ID", "RES_CHANNEL_SUFFIX", "SCHEMA_FILE", "config", "Lcom/bytedance/kit/nglynx/compatible/GroupConfig;", "bdlynxCompatible", "uri", "Landroid/net/Uri;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "bdlynxCompatible$anniex_release", "cutOffHttpPrefixByConfig", "Lcom/bytedance/kit/nglynx/compatible/CardConfig;", "url", "makeRelativeUri", "path", "sourceUri", "redirectImgUrl", "cardConfig", "resGroup", "resFormat", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "replaceResSuffixByFormat", "resPath", "appendExtraPart", "Landroid/net/Uri$Builder;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CompatibleUtil {
    private static final String CONFIG_FILE_NAME = "config.json";
    public static final CompatibleUtil INSTANCE = new CompatibleUtil();
    private static final String KEY_ACCESS_KEY = "accessKey";
    private static final String KEY_CARD_ID = "cardId";
    private static final String KEY_GECKO_FORMAT = "gecko_format";
    private static final String KEY_GROUP_ID = "groupId";
    private static final String RES_CHANNEL_SUFFIX = "_resource";
    private static final String SCHEMA_FILE = "file";
    private static GroupConfig config;

    private CompatibleUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f5  */
    @Deprecated(message = "compatible code for only BDLynx, url like:  https://xxxxx?groupId=xxx&cardId=xxxx")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String bdlynxCompatible$anniex_release(Uri uri, IServiceToken context) {
        String queryParameter;
        String str;
        String str2;
        ResourceInfo loadSync;
        CardConfig cardConfig;
        String businessId = context != null ? context.getBusinessId() : null;
        if (uri != null) {
            Uri uri2 = uri.isHierarchical() ? uri : null;
            if (uri2 != null && (queryParameter = uri2.getQueryParameter(KEY_GROUP_ID)) != null) {
                String queryParameter2 = uri.getQueryParameter(KEY_CARD_ID);
                String queryParameter3 = uri.getQueryParameter(KEY_GECKO_FORMAT);
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                taskConfig.setTaskContext(TaskContext.INSTANCE.from(context != null ? context.getAllDependency() : null));
                String queryParameter4 = uri.getQueryParameter(KEY_ACCESS_KEY);
                if (queryParameter4 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter4, "it");
                    taskConfig.setAccessKey(queryParameter4);
                }
                taskConfig.setResTag("sub_resource");
                CustomLoaderConfig from = CustomLoaderConfig.INSTANCE.from(context != null ? (CustomLoaderConfig) context.getDependency(CustomLoaderConfig.class) : null);
                if (from == null) {
                    from = new CustomLoaderConfig(true);
                }
                from.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
                taskConfig.setLoaderConfig(from);
                GroupConfig groupConfig = config;
                if (groupConfig != null && queryParameter2 != null) {
                    Intrinsics.checkNotNull(groupConfig);
                    CardConfig cardConfig2 = groupConfig.getCardConfigs().get(queryParameter2);
                    if (cardConfig2 != null) {
                        CompatibleUtil compatibleUtil = INSTANCE;
                        String uri3 = uri.toString();
                        Intrinsics.checkNotNullExpressionValue(uri3, "uri.toString()");
                        String str3 = queryParameter + RES_CHANNEL_SUFFIX;
                        str = "uri.toString()";
                        str2 = RES_CHANNEL_SUFFIX;
                        String redirectImgUrl = compatibleUtil.redirectImgUrl(cardConfig2, uri3, str3, queryParameter3, taskConfig);
                        if (redirectImgUrl != null) {
                            return Uri.fromFile(new File(redirectImgUrl)).toString();
                        }
                        ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, businessId, null, 2, null);
                        CompatibleUtil compatibleUtil2 = INSTANCE;
                        String makeRelativeUri$default = makeRelativeUri$default(compatibleUtil2, queryParameter, null, 2, null);
                        taskConfig.setChannel(queryParameter);
                        taskConfig.setResTag("sub_resource");
                        Unit unit = Unit.INSTANCE;
                        loadSync = with$default.loadSync(makeRelativeUri$default, taskConfig);
                        if (loadSync != null) {
                            File file = new File(loadSync.getFilePath() + File.separator + CONFIG_FILE_NAME);
                            if (!file.exists()) {
                                file = null;
                            }
                            if (file != null) {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                try {
                                    GroupConfig readGroupConfig = GroupConfigKt.readGroupConfig(fileInputStream);
                                    if (readGroupConfig != null) {
                                        config = readGroupConfig;
                                        if (queryParameter2 != null && (cardConfig = readGroupConfig.getCardConfigs().get(queryParameter2)) != null) {
                                            String uri4 = uri.toString();
                                            Intrinsics.checkNotNullExpressionValue(uri4, str);
                                            String redirectImgUrl2 = compatibleUtil2.redirectImgUrl(cardConfig, uri4, queryParameter + str2, queryParameter3, taskConfig);
                                            if (redirectImgUrl2 != null) {
                                                String uri5 = Uri.fromFile(new File(redirectImgUrl2)).toString();
                                                CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                                                return uri5;
                                            }
                                        }
                                    }
                                    CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                                } finally {
                                }
                            }
                        }
                    }
                }
                str = "uri.toString()";
                str2 = RES_CHANNEL_SUFFIX;
                ResourceLoaderService with$default2 = ResourceLoader.with$default(ResourceLoader.INSTANCE, businessId, null, 2, null);
                CompatibleUtil compatibleUtil22 = INSTANCE;
                String makeRelativeUri$default2 = makeRelativeUri$default(compatibleUtil22, queryParameter, null, 2, null);
                taskConfig.setChannel(queryParameter);
                taskConfig.setResTag("sub_resource");
                Unit unit2 = Unit.INSTANCE;
                loadSync = with$default2.loadSync(makeRelativeUri$default2, taskConfig);
                if (loadSync != null) {
                }
            }
        }
        return null;
    }

    private final String makeRelativeUri(String path, Uri sourceUri) {
        Uri.Builder path2 = new Uri.Builder().scheme(ResourceUriHelperKt.SCHEME_FILE).authority(ResourceUriHelperKt.AUTHORITY_RELATIVE).path(path);
        Intrinsics.checkNotNullExpressionValue(path2, "Builder()\n        .schem…ty(\"relative\").path(path)");
        String uri = appendExtraPart(path2, sourceUri).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Builder()\n        .schem…ild()\n        .toString()");
        return uri;
    }

    static /* synthetic */ String makeRelativeUri$default(CompatibleUtil compatibleUtil, String str, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        return compatibleUtil.makeRelativeUri(str, uri);
    }

    static /* synthetic */ Uri.Builder appendExtraPart$default(CompatibleUtil compatibleUtil, Uri.Builder builder, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        return compatibleUtil.appendExtraPart(builder, uri);
    }

    private final Uri.Builder appendExtraPart(Uri.Builder builder, Uri uri) {
        if (uri != null) {
            builder.encodedQuery(uri.getEncodedQuery());
        }
        return builder;
    }

    private final String redirectImgUrl(CardConfig cardConfig, String url, String resGroup, String resFormat, TaskConfig taskConfig) {
        String cutOffHttpPrefixByConfig = cutOffHttpPrefixByConfig(cardConfig, url);
        if (cutOffHttpPrefixByConfig == null) {
            return null;
        }
        CompatibleUtil compatibleUtil = INSTANCE;
        String replaceResSuffixByFormat = compatibleUtil.replaceResSuffixByFormat(cutOffHttpPrefixByConfig, resFormat);
        ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, taskConfig.getBid(), null, 2, null);
        String makeRelativeUri$default = makeRelativeUri$default(compatibleUtil, resGroup, null, 2, null);
        taskConfig.setResTag("sub_resource");
        Unit unit = Unit.INSTANCE;
        ResourceInfo loadSync = with$default.loadSync(makeRelativeUri$default, taskConfig);
        if (loadSync == null) {
            return null;
        }
        File file = new File(loadSync.getFilePath() + File.separator + replaceResSuffixByFormat);
        if (!file.exists()) {
            file = null;
        }
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    private final String cutOffHttpPrefixByConfig(CardConfig config2, String url) {
        Object obj;
        List<String> resPrefix = config2.getResPrefix();
        if (resPrefix != null) {
            Iterator<T> it = resPrefix.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (StringsKt.startsWith$default(url, (String) obj, false, 2, (Object) null)) {
                    break;
                }
            }
            String str = (String) obj;
            if (str != null) {
                int length = str.length();
                if (url == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = url.substring(length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return StringsKt.substringBefore$default(substring, '?', (String) null, 2, (Object) null);
            }
        }
        return null;
    }

    private final String replaceResSuffixByFormat(String resPath, String resFormat) {
        String str = resFormat;
        return str == null || str.length() == 0 ? resPath : StringsKt.replaceAfterLast$default(resPath, '.', resFormat, (String) null, 4, (Object) null);
    }
}
