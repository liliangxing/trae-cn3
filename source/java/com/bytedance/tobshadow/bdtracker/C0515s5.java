package com.bytedance.tobshadow.bdtracker;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tobshadow.applog.IPageMeta;
import com.bytedance.tobshadow.applog.annotation.PageMeta;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.s5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0515s5 {

    /* renamed from: a */
    public static final List<String> f1020a;

    /* renamed from: b */
    public static final List<String> f1021b;

    /* renamed from: c */
    public static final List<Class<?>> f1022c;

    /* renamed from: d */
    public static final List<Class<?>> f1023d;

    /* renamed from: e */
    public static final List<String> f1024e;

    static {
        List<String> singletonList = Collections.singletonList("android.app.Activity");
        f1020a = singletonList;
        f1021b = Arrays.asList("android.app.Fragment", "androidx.fragment.app.Fragment", "android.support.v4.app.Fragment");
        f1022c = new ArrayList();
        f1023d = new ArrayList();
        f1024e = Collections.singletonList("PageUtils");
        Iterator<String> it = singletonList.iterator();
        while (it.hasNext()) {
            Class<?> m367b = C0411e.m367b(it.next());
            if (m367b != null) {
                f1022c.add(m367b);
            }
        }
        Iterator<String> it2 = f1021b.iterator();
        while (it2.hasNext()) {
            Class<?> m367b2 = C0411e.m367b(it2.next());
            if (m367b2 != null) {
                f1023d.add(m367b2);
            }
        }
    }

    /* renamed from: a */
    public static View m660a(Object obj) {
        try {
            Method method = obj.getClass().getMethod("getView", new Class[0]);
            if (method == null) {
                return null;
            }
            Object invoke = method.invoke(obj, new Object[0]);
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m661a(Object obj, JSONObject jSONObject) {
        if (obj instanceof IPageMeta) {
            try {
                JSONObject pageProperties = ((IPageMeta) obj).pageProperties();
                if (pageProperties != null) {
                    pageProperties.remove("page_key");
                    pageProperties.remove("refer_page_key");
                    pageProperties.remove("page_title");
                    pageProperties.remove("refer_page_title");
                    pageProperties.remove("page_path");
                    pageProperties.remove("referrer_page_path");
                    pageProperties.remove(ReportConstant.COMMON_INIT_DURATION);
                    pageProperties.remove("is_back");
                }
                return pageProperties;
            } catch (Throwable th) {
                LoggerImpl.global().error(f1024e, "Cannot get track properties from activity", th, new Object[0]);
            }
        }
        return jSONObject;
    }

    /* renamed from: b */
    public static String m662b(Object obj) {
        PageMeta pageMeta;
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).path();
            } catch (Throwable th) {
                LoggerImpl.global().error(f1024e, "Cannot get path from IPageMeta", th, new Object[0]);
            }
        }
        return (C0453k.m497a(C0453k.f712c) || !obj.getClass().isAnnotationPresent(PageMeta.class) || (pageMeta = (PageMeta) obj.getClass().getAnnotation(PageMeta.class)) == null || TextUtils.isEmpty(pageMeta.path())) ? obj.getClass().getCanonicalName() : pageMeta.path();
    }

    /* renamed from: c */
    public static String m663c(Object obj) {
        Object invoke;
        CharSequence charSequence;
        String obj2;
        PageMeta pageMeta;
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).title();
            } catch (Throwable th) {
                LoggerImpl.global().error(f1024e, "Cannot get title from IPageMeta", th, new Object[0]);
            }
        }
        if (!C0453k.m497a(C0453k.f712c) && obj.getClass().isAnnotationPresent(PageMeta.class) && (pageMeta = (PageMeta) obj.getClass().getAnnotation(PageMeta.class)) != null && !TextUtils.isEmpty(pageMeta.title())) {
            return pageMeta.title();
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (!TextUtils.isEmpty(activity.getTitle())) {
                return activity.getTitle().toString();
            }
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                if (!TextUtils.isEmpty(actionBar.getTitle())) {
                    obj2 = actionBar.getTitle().toString();
                }
                obj2 = null;
            } else {
                try {
                    Class<?> m346a = C0411e.m346a("android.support.v7.app.AppCompatActivity", "androidx.appcompat.app.AppCompatActivity");
                    if (m346a != null && m346a.isInstance(activity) && (invoke = activity.getClass().getMethod("getSupportActionBar", new Class[0]).invoke(activity, new Object[0])) != null && (charSequence = (CharSequence) invoke.getClass().getMethod("getTitle", new Class[0]).invoke(invoke, new Object[0])) != null) {
                        obj2 = charSequence.toString();
                    }
                } catch (Exception unused) {
                }
                obj2 = null;
            }
            if (!TextUtils.isEmpty(obj2)) {
                return obj2;
            }
            try {
                PackageManager packageManager = ((Activity) obj).getPackageManager();
                if (packageManager != null) {
                    CharSequence loadLabel = packageManager.getActivityInfo(((Activity) obj).getComponentName(), 0).loadLabel(packageManager);
                    if (!TextUtils.isEmpty(loadLabel)) {
                        return loadLabel.toString();
                    }
                }
            } catch (Exception e) {
                LoggerImpl.global().error(f1024e, "Cannot get title from activity label", e, new Object[0]);
            }
        }
        return obj.getClass().getName();
    }

    /* renamed from: d */
    public static JSONObject m664d(Object obj) {
        if (!(obj instanceof IPageMeta)) {
            return null;
        }
        try {
            JSONObject pageProperties = ((IPageMeta) obj).pageProperties();
            if (pageProperties != null) {
                pageProperties.remove("page_key");
                pageProperties.remove("refer_page_key");
                pageProperties.remove("page_title");
                pageProperties.remove("refer_page_title");
                pageProperties.remove("page_path");
                pageProperties.remove("referrer_page_path");
                pageProperties.remove(ReportConstant.COMMON_INIT_DURATION);
                pageProperties.remove("is_back");
            }
            return pageProperties;
        } catch (Throwable th) {
            LoggerImpl.global().error(f1024e, "Cannot get track properties from activity", th, new Object[0]);
            return null;
        }
    }
}
