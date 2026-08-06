package com.bytedance.ies.bullet.secure;

import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.ies.argus.api.params.ArgusResourceFrom;
import com.bytedance.ies.argus.api.params.ArgusResourceLoaderInfo;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusLynxDelegateAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007¨\u0006\b"}, d2 = {"getLastModified", "", "filePath", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getSecureInfo", "Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArgusLynxDelegateAdapterKt {

    /* compiled from: ArgusLynxDelegateAdapter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResourceFrom.values().length];
            try {
                iArr[ResourceFrom.CDN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResourceFrom.GECKO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ArgusResourceLoaderInfo getSecureInfo(ResourceInfo resourceInfo) {
        ArgusResourceFrom argusResourceFrom;
        Intrinsics.checkNotNullParameter(resourceInfo, "<this>");
        ArgusResourceType argusResourceType = resourceInfo.getArgusResourceType();
        String channel = resourceInfo.getChannel();
        String bundle = resourceInfo.getBundle();
        String cdnSafeUrl = resourceInfo.getCdnSafeUrl();
        String uri = resourceInfo.getSrcUri().toString();
        String loaderName = resourceInfo.getLoaderName().toString();
        long version = resourceInfo.getVersion();
        ResourceFrom from = resourceInfo.getFrom();
        int i = from == null ? -1 : WhenMappings.$EnumSwitchMapping$0[from.ordinal()];
        if (i == 1) {
            argusResourceFrom = ArgusResourceFrom.CDN;
        } else {
            argusResourceFrom = i != 2 ? null : ArgusResourceFrom.GECKO;
        }
        ArgusResourceFrom argusResourceFrom2 = argusResourceFrom;
        String cacheKey = resourceInfo.getCacheKey();
        String filePath = resourceInfo.getFilePath();
        String accessKey = resourceInfo.getAccessKey();
        Uri srcUri = resourceInfo.getSrcUri();
        Long lastModified = getLastModified(resourceInfo.getFilePath());
        Intrinsics.checkNotNullExpressionValue(uri, "toString()");
        return new ArgusResourceLoaderInfo(uri, cdnSafeUrl, channel, bundle, (String) null, loaderName, Long.valueOf(version), argusResourceType, argusResourceFrom2, cacheKey, filePath, accessKey, srcUri, lastModified, 16, (DefaultConstructorMarker) null);
    }

    public static final Long getLastModified(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Long.valueOf(new File(str).lastModified());
        } catch (Error unused) {
            return null;
        }
    }
}
