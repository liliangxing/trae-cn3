package com.bytedance.sdk.xbridge.cn.storage.globalpropsinject;

import android.content.Context;
import android.net.Uri;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IGlobalPropsInjectService;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.NativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeProviderFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GlobalPropsInjectServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\b2\u0006\u0010\r\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/globalpropsinject/GlobalPropsInjectServiceImpl;", "Lcom/bytedance/ies/bullet/service/base/IGlobalPropsInjectService;", "()V", "getStorageValues", "", "", "", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getUserDomainStorageValues", "getQueryParameterSafely", "key", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GlobalPropsInjectServiceImpl implements IGlobalPropsInjectService {
    private static final String TAG = "GlobalPropsInject";
    private static final String URI_PARAM_STORAGE_KEYS = "bullet_storage_keys";
    private static final String URI_PARAM_USER_DOMAIN_STORAGE_KEYS = "user_domain_storage_keys";

    public Map<String, Object> getStorageValues(Uri uri, Context context) {
        if (context == null) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String queryParameterSafely = uri != null ? getQueryParameterSafely(uri, URI_PARAM_STORAGE_KEYS) : null;
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(queryParameterSafely)) {
            String decode = Uri.decode(queryParameterSafely);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(it)");
            List<String> split$default = StringsKt.split$default(decode, new String[]{IWeiboService.Scope.EMPTY_SCOPE}, false, 0, 6, (Object) null);
            INativeStorage providerNativeStorage = NativeProviderFactory.providerNativeStorage(context);
            for (String str : split$default) {
                Object storageItem = providerNativeStorage.getStorageItem(str, "getStorageValues", "");
                if (storageItem != null) {
                    linkedHashMap.put(str, storageItem);
                }
            }
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "GlobalPropsInject-getStorageValues.user_domain_map:" + linkedHashMap, (LogLevel) null, (String) null, 6, (Object) null);
        }
        return linkedHashMap;
    }

    public Map<String, Object> getUserDomainStorageValues(Uri uri, Context context) {
        if (context == null) {
            return new LinkedHashMap();
        }
        IHostUserDepend hostUserDepend = XBaseRuntime.INSTANCE.getHostUserDepend();
        List<String> list = null;
        if (Intrinsics.areEqual(hostUserDepend != null ? Boolean.valueOf(hostUserDepend.hasLogin()) : null, false)) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "GlobalPropsInject:getUserDomainStorageValuesFail.Fail. user is not login ", (LogLevel) null, (String) null, 6, (Object) null);
            return new LinkedHashMap();
        }
        IHostUserDepend hostUserDepend2 = XBaseRuntime.INSTANCE.getHostUserDepend();
        String userId = hostUserDepend2 != null ? hostUserDepend2.getUserId() : null;
        String str = userId;
        if (str == null || str.length() == 0) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "GlobalPropsInject:getUserDomainStorageValuesFail.Fail. userId is null or empty.", (LogLevel) null, (String) null, 6, (Object) null);
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String queryParameterSafely = uri != null ? getQueryParameterSafely(uri, URI_PARAM_USER_DOMAIN_STORAGE_KEYS) : null;
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(queryParameterSafely)) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "GlobalPropsInjectgetUserDomainStorageValues,keyList:" + queryParameterSafely, (LogLevel) null, (String) null, 6, (Object) null);
            if (queryParameterSafely != null) {
                String decode = Uri.decode(queryParameterSafely);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(it)");
                list = StringsKt.split$default(decode, new String[]{IWeiboService.Scope.EMPTY_SCOPE}, false, 0, 6, (Object) null);
            }
            IUserDomainNativeStorage providerUserDomainNativeStorage = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(context);
            if (list != null) {
                for (String str2 : list) {
                    Triple<Boolean, Boolean, Object> userDomainStorageItem = providerUserDomainNativeStorage.getUserDomainStorageItem(userId, str2, "getUserDomainStorageValues", "");
                    ((Boolean) userDomainStorageItem.component1()).booleanValue();
                    ((Boolean) userDomainStorageItem.component2()).booleanValue();
                    Object component3 = userDomainStorageItem.component3();
                    if (component3 != null) {
                        linkedHashMap.put(str2, component3);
                    }
                }
            }
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "GlobalPropsInject-getUserDomainStorageValues.user_domain_map:" + linkedHashMap, (LogLevel) null, (String) null, 6, (Object) null);
        }
        return linkedHashMap;
    }

    public final String getQueryParameterSafely(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (!uri.isHierarchical()) {
            uri = null;
        }
        if (uri != null) {
            return uri.getQueryParameter(str);
        }
        return null;
    }
}
