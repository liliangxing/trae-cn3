package com.bytedance.ies.web.jsbridge2;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.ies.web.jsbridge2.PermissionConfig;
import com.bytedance.ies.web.jsbridge2.PermissionConfigRepository;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PermissionChecker {
    private final PermissionConfig config;
    private final PermissionConfigRepository configRepository = JsBridge2.permissionConfigRepositoryLazy.get();
    private final boolean enforceHttp;
    private IBridgePermissionConfigurator.OpenJsbPermissionValidator jsbPermissionValidator;
    private IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener;
    private final Set<String> publicMethodSet;
    private final Set<String> safeHostSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionChecker(PermissionConfig permissionConfig, Set<String> set, Set<String> set2, boolean z) {
        this.config = permissionConfig;
        this.safeHostSet = new LinkedHashSet(set);
        this.publicMethodSet = new LinkedHashSet(set2);
        this.enforceHttp = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized PermissionGroup shouldIntercept(boolean z, String str, BaseMethod baseMethod, List<TimeLineEvent> list) throws PermissionConfig.IllegalRemoteConfigException {
        IBridgePermissionConfigurator.PermissionCheckUrlFilter providePermissionCheckUrlFilter;
        String str2;
        String filterUrl;
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.URL, str).setExtraItem(TimeLineEvent.Constants.ENABLE_PERMISSION_CHECK, Boolean.valueOf(z)).setExtraItem(TimeLineEvent.Constants.METHOD_NAME, baseMethod.getName()).setExtraItem(TimeLineEvent.Constants.METHOD_CLASS, baseMethod.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.METHOD_PERMISSION_GROUP, baseMethod.getPermissionGroup()).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER, list);
        PermissionConfigRepository permissionConfigRepository = this.configRepository;
        if (permissionConfigRepository != null && (providePermissionCheckUrlFilter = permissionConfigRepository.providePermissionCheckUrlFilter()) != null) {
            try {
                try {
                    filterUrl = providePermissionCheckUrlFilter.filterUrl(str);
                } catch (Exception e) {
                    DebugUtil.m66w("PermissionCheckUriFilter process exception: " + e.getMessage());
                    str2 = (str == null || TextUtils.isEmpty(str)) ? "After permissionCheckUriFilter process, url becomes null or empty, revert to previous url" : "After permissionCheckUriFilter process, url becomes null or empty, revert to previous url";
                }
                if (filterUrl != null && !TextUtils.isEmpty(filterUrl)) {
                    str = filterUrl;
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.FILTER_URL, str).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_FILTER_URL, list);
                }
                DebugUtil.m66w(str2);
                TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.FILTER_URL, str).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_FILTER_URL, list);
            } catch (Throwable th) {
                if (str == null || TextUtils.isEmpty(str)) {
                    DebugUtil.m66w("After permissionCheckUriFilter process, url becomes null or empty, revert to previous url");
                }
                throw th;
            }
        }
        IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener = this.permissionCheckingListener;
        if (permissionCheckingListener != null) {
            permissionCheckingListener.onStartChecking(baseMethod.getName(), str);
        }
        Uri parse = Uri.parse(str);
        if (this.enforceHttp && !"http".equalsIgnoreCase(parse.getScheme()) && !"https".equalsIgnoreCase(parse.getScheme())) {
            return null;
        }
        String host = parse.getHost();
        boolean contains = this.publicMethodSet.contains(baseMethod.getName());
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CALL_PERMISSION_GROUP, contains ? PermissionGroup.PUBLIC.toString() : TimeLineEvent.Constants.NULL).setExtraItem(TimeLineEvent.Constants.PUBLIC_METHOD_SET, this.publicMethodSet).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_PUBLIC_METHOD, list);
        if (host == null) {
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.HOST, TimeLineEvent.Constants.NULL).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_NULL_HOST, list);
            r2 = contains ? PermissionGroup.PUBLIC : null;
            IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener2 = this.permissionCheckingListener;
            if (permissionCheckingListener2 != null) {
                permissionCheckingListener2.onFinishChecking(contains, "jsb_auth", baseMethod.getName(), str);
            }
            return r2;
        }
        boolean z2 = true;
        if (baseMethod.getPermissionGroup() != PermissionGroup.SECURE) {
            for (String str3 : this.safeHostSet) {
                if (parse.getHost().equals(str3) || host.endsWith(LibrarianImpl.Constants.DOT + str3)) {
                    IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener3 = this.permissionCheckingListener;
                    if (permissionCheckingListener3 != null) {
                        permissionCheckingListener3.onFinishChecking(true, "jsb_auth", baseMethod.getName(), str);
                    }
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CALL_PERMISSION_GROUP, PermissionGroup.PRIVATE.toString()).setExtraItem(TimeLineEvent.Constants.HOST, host).setExtraItem(TimeLineEvent.Constants.SAFE_HOST_SET, this.safeHostSet).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_SAFE_HOST, list);
                    return PermissionGroup.PRIVATE;
                }
            }
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CALL_PERMISSION_GROUP, TimeLineEvent.Constants.NULL).setExtraItem(TimeLineEvent.Constants.HOST, host).setExtraItem(TimeLineEvent.Constants.SAFE_HOST_SET, this.safeHostSet).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_SAFE_HOST, list);
        }
        IBridgePermissionConfigurator.OpenJsbPermissionValidator openJsbPermissionValidator = this.jsbPermissionValidator;
        if (openJsbPermissionValidator != null && openJsbPermissionValidator.shouldValidateUrl(str)) {
            boolean shouldIntercept = this.jsbPermissionValidator.shouldIntercept(str, baseMethod.getName());
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CALL_PERMISSION_GROUP, shouldIntercept ? TimeLineEvent.Constants.NULL : PermissionGroup.PRIVATE.toString()).setExtraItem(TimeLineEvent.Constants.VALIDATOR_CHECK, Boolean.valueOf(shouldIntercept)).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_VALIDATOR, list);
            if (!shouldIntercept) {
                IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener4 = this.permissionCheckingListener;
                if (permissionCheckingListener4 != null) {
                    permissionCheckingListener4.onFinishChecking(true, "open_jsb_auth", baseMethod.getName(), str);
                }
                return PermissionGroup.PRIVATE;
            }
        }
        if (z) {
            try {
                r2 = doPermissionCheck(str, baseMethod, list);
                if (r2 == null && !contains && this.config != null) {
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CONFIG, this.config.getRemoteConfigList(PermissionConfig.getShortenedHost(host))).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_REMOTE_CONFIG, list);
                }
            } catch (PermissionConfig.IllegalRemoteConfigException e2) {
                IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener5 = this.permissionCheckingListener;
                if (permissionCheckingListener5 != null) {
                    permissionCheckingListener5.onFinishChecking(false, "jsb_auth_exp", baseMethod.getName(), str);
                }
                throw e2;
            }
        }
        if (r2 == null && contains) {
            r2 = PermissionGroup.PUBLIC;
        }
        IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener6 = this.permissionCheckingListener;
        if (permissionCheckingListener6 != null) {
            if (r2 == null) {
                z2 = false;
            }
            permissionCheckingListener6.onFinishChecking(z2, "jsb_auth", baseMethod.getName(), str);
        }
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CALL_PERMISSION_GROUP, r2 == null ? TimeLineEvent.Constants.NULL : r2.toString()).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_RESULT, list);
        return r2;
    }

    void addSafeHost(String str) {
        this.safeHostSet.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addSafeHost(Collection<String> collection) {
        this.safeHostSet.addAll(collection);
    }

    public Set<String> getSafeHostSet() {
        return this.safeHostSet;
    }

    void addPublicMethod(String str) {
        this.publicMethodSet.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPublicMethod(Collection<String> collection) {
        this.publicMethodSet.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOpenJsbValidator(IBridgePermissionConfigurator.OpenJsbPermissionValidator openJsbPermissionValidator) {
        this.jsbPermissionValidator = openJsbPermissionValidator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPermissionCheckingListener(IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener) {
        this.permissionCheckingListener = permissionCheckingListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFetchCallback(PermissionConfigRepository.FetchCallback fetchCallback) {
        PermissionConfigRepository permissionConfigRepository = this.configRepository;
        if (permissionConfigRepository != null) {
            permissionConfigRepository.addFetchCallback(fetchCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFetchCallback(PermissionConfigRepository.FetchCallback fetchCallback) {
        PermissionConfigRepository permissionConfigRepository = this.configRepository;
        if (permissionConfigRepository != null) {
            permissionConfigRepository.removeFetchCallback(fetchCallback);
        }
    }

    private synchronized PermissionGroup doPermissionCheck(String str, BaseMethod baseMethod, List<TimeLineEvent> list) throws PermissionConfig.IllegalRemoteConfigException {
        if (this.config == null) {
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CALL_PERMISSION_GROUP, TimeLineEvent.Constants.NULL).setExtraItem(TimeLineEvent.Constants.CONFIG, TimeLineEvent.Constants.NULL).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_NULL_CONFIG, list);
            return null;
        }
        PermissionConfigRepository permissionConfigRepository = this.configRepository;
        if (permissionConfigRepository != null && !permissionConfigRepository.isFetched()) {
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REPO_FETCHED, TimeLineEvent.Constants.FALSE).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_FETCH, list);
            throw new PermissionConfig.IllegalRemoteConfigException("Permission configuration has not been fetched");
        }
        PermissionConfig.UrlBasedRule rule = this.config.getRule(str, list);
        if (rule.permissionGroup == baseMethod.getPermissionGroup() && rule.permissionGroup == PermissionGroup.SECURE && !rule.includedMethods.contains(baseMethod.getName())) {
            return null;
        }
        if (rule.excludedMethods.contains(baseMethod.getName())) {
            return null;
        }
        if (rule.includedMethods.contains(baseMethod.getName())) {
            return PermissionGroup.PRIVATE;
        }
        if (rule.permissionGroup.compareTo(baseMethod.getPermissionGroup()) < 0) {
            return null;
        }
        return rule.permissionGroup;
    }
}
