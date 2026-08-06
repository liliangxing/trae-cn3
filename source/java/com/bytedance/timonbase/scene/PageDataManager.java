package com.bytedance.timonbase.scene;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PageDataManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\b\u0010\b\u001a\u00020\u0005H\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/timonbase/scene/PageDataManager;", "", "()V", "pageRecordList", "Ljava/util/LinkedList;", "Lcom/bytedance/timonbase/scene/PageDataManager$PageRecord;", "getHistoryPage", "", "getRecord", "recordPageInfo", "", "activity", "Landroid/app/Activity;", "pageStatus", "", DBData.FIELD_TIME, "", "registerActivityManager", "context", "Landroid/content/Context;", "start", "updateActivity", "Companion", "PageRecord", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PageDataManager {
    public static final String EXTRA_FRAGMENTS = "fragments";
    public static final String EXTRA_STATUS = "status";
    public static final String ON_CREATED = "onCreated";
    public static final String ON_DESTROYED = "onDestroyed";
    public static final String ON_PAUSED = "onPaused";
    public static final String ON_RESUMED = "onResumed";
    public static final String ON_STARTED = "onStarted";
    public static final String ON_STOPPED = "onStopped";
    private static final int PAGE_CACHE_MAX_SIZE = 200;
    private static final int PAGE_UPLOAD_MAX_SIZE = 20;
    private final LinkedList<PageRecord> pageRecordList = new LinkedList<>();

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String lastPage = "null";
    private static String topPage = "null";
    private static int topPageHashCode = -1;
    private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<PageDataManager>() { // from class: com.bytedance.timonbase.scene.PageDataManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PageDataManager m1067invoke() {
            return new PageDataManager();
        }
    });

    public final void start(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        registerActivityManager(context);
    }

    private final void registerActivityManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.timonbase.scene.PageDataManager$registerActivityManager$lifecycleCallbacks$1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                    Intrinsics.checkParameterIsNotNull(bundle, "bundle");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                    PageDataManager.this.updateActivity(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                    PageDataManager.this.updateActivity(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                    PageDataManager.this.recordPageInfo(activity, PageDataManager.ON_RESUMED, System.currentTimeMillis());
                    PageDataManager.this.updateActivity(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Intrinsics.checkParameterIsNotNull(activity, "activity");
                    if (activity.hashCode() == PageDataManager.INSTANCE.getTopPageHashCode()) {
                        PageDataManager.INSTANCE.setTopPage("null");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateActivity(Activity activity) {
        String name = activity.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "activity.javaClass.name");
        topPage = name;
        topPageHashCode = activity.hashCode();
        String name2 = activity.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "activity.javaClass.name");
        lastPage = name2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordPageInfo(final Activity activity, final String pageStatus, final long time) {
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.PageDataManager$recordPageInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1068invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1068invoke() {
                PageDataManager.PageRecord record;
                record = PageDataManager.this.getRecord();
                record.setPageType("activity");
                String name = activity.getClass().getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "activity.javaClass.name");
                record.setPageName(name);
                record.setTimestamp(time);
                record.getExtra().put(PageDataManager.EXTRA_STATUS, pageStatus);
                ArrayList arrayList = new ArrayList();
                if (Intrinsics.areEqual(pageStatus, PageDataManager.ON_RESUMED) && (activity instanceof FragmentActivity)) {
                    try {
                        Result.Companion companion = Result.Companion;
                        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "activity.supportFragmentManager");
                        List fragments = supportFragmentManager.getFragments();
                        Intrinsics.checkExpressionValueIsNotNull(fragments, "activity.supportFragmentManager.fragments");
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : fragments) {
                            Fragment fragment = (Fragment) obj;
                            Intrinsics.checkExpressionValueIsNotNull(fragment, "it");
                            if (!fragment.isDetached() && fragment.isResumed()) {
                                arrayList2.add(obj);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            String name2 = ((Fragment) it.next()).getClass().getName();
                            Intrinsics.checkExpressionValueIsNotNull(name2, "it.javaClass.name");
                            arrayList.add(name2);
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                }
                if (!arrayList.isEmpty()) {
                    record.getExtra().put(PageDataManager.EXTRA_FRAGMENTS, arrayList);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized PageRecord getRecord() {
        PageRecord poll;
        poll = this.pageRecordList.size() >= 200 ? this.pageRecordList.poll() : null;
        if (poll == null) {
            poll = new PageRecord(null, null, 0L, null, 15, null);
        }
        this.pageRecordList.add(poll);
        return poll;
    }

    public final synchronized List<PageRecord> getHistoryPage() {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(this.pageRecordList);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (Intrinsics.areEqual(((PageRecord) obj).getExtra().get(EXTRA_STATUS), ON_RESUMED)) {
                arrayList3.add(obj);
            }
        }
        arrayList = arrayList3;
        if (!arrayList.isEmpty()) {
            CollectionsKt.reversed(arrayList);
            arrayList = arrayList.subList(0, RangesKt.coerceAtMost(arrayList.size(), 20));
        }
        return arrayList;
    }

    /* compiled from: PageDataManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R*\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/bytedance/timonbase/scene/PageDataManager$PageRecord;", "", "pageType", "", "pageName", ReportConstant.COMMON_TIMESTAMP, "", "extra", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;)V", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "getPageType", "setPageType", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PageRecord {

        @SerializedName("extra")
        private Map<String, Object> extra;

        @SerializedName("page_name")
        private String pageName;

        @SerializedName("page_type")
        private String pageType;

        @SerializedName(ReportConstant.COMMON_TIMESTAMP)
        private long timestamp;

        public PageRecord() {
            this(null, null, 0L, null, 15, null);
        }

        public static /* synthetic */ PageRecord copy$default(PageRecord pageRecord, String str, String str2, long j, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageRecord.pageType;
            }
            if ((i & 2) != 0) {
                str2 = pageRecord.pageName;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                j = pageRecord.timestamp;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                map = pageRecord.extra;
            }
            return pageRecord.copy(str, str3, j2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPageType() {
            return this.pageType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPageName() {
            return this.pageName;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Map<String, Object> component4() {
            return this.extra;
        }

        public final PageRecord copy(String pageType, String pageName, long timestamp, Map<String, Object> extra) {
            Intrinsics.checkParameterIsNotNull(pageType, "pageType");
            Intrinsics.checkParameterIsNotNull(pageName, "pageName");
            Intrinsics.checkParameterIsNotNull(extra, "extra");
            return new PageRecord(pageType, pageName, timestamp, extra);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageRecord)) {
                return false;
            }
            PageRecord pageRecord = (PageRecord) other;
            return Intrinsics.areEqual(this.pageType, pageRecord.pageType) && Intrinsics.areEqual(this.pageName, pageRecord.pageName) && this.timestamp == pageRecord.timestamp && Intrinsics.areEqual(this.extra, pageRecord.extra);
        }

        public int hashCode() {
            String str = this.pageType;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.pageName;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.timestamp)) * 31;
            Map<String, Object> map = this.extra;
            return hashCode2 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "PageRecord(pageType=" + this.pageType + ", pageName=" + this.pageName + ", timestamp=" + this.timestamp + ", extra=" + this.extra + ")";
        }

        public PageRecord(String str, String str2, long j, Map<String, Object> map) {
            Intrinsics.checkParameterIsNotNull(str, "pageType");
            Intrinsics.checkParameterIsNotNull(str2, "pageName");
            Intrinsics.checkParameterIsNotNull(map, "extra");
            this.pageType = str;
            this.pageName = str2;
            this.timestamp = j;
            this.extra = map;
        }

        public final String getPageType() {
            return this.pageType;
        }

        public final void setPageType(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.pageType = str;
        }

        public final String getPageName() {
            return this.pageName;
        }

        public final void setPageName(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.pageName = str;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final void setTimestamp(long j) {
            this.timestamp = j;
        }

        public /* synthetic */ PageRecord(String str, String str2, long j, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getExtra() {
            return this.extra;
        }

        public final void setExtra(Map<String, Object> map) {
            Intrinsics.checkParameterIsNotNull(map, "<set-?>");
            this.extra = map;
        }
    }

    /* compiled from: PageDataManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/bytedance/timonbase/scene/PageDataManager$Companion;", "", "()V", "EXTRA_FRAGMENTS", "", "EXTRA_STATUS", "ON_CREATED", "ON_DESTROYED", "ON_PAUSED", "ON_RESUMED", "ON_STARTED", "ON_STOPPED", "PAGE_CACHE_MAX_SIZE", "", "PAGE_UPLOAD_MAX_SIZE", "instance", "Lcom/bytedance/timonbase/scene/PageDataManager;", "getInstance", "()Lcom/bytedance/timonbase/scene/PageDataManager;", "instance$delegate", "Lkotlin/Lazy;", "<set-?>", "lastPage", "getLastPage", "()Ljava/lang/String;", "setLastPage", "(Ljava/lang/String;)V", "topPage", "getTopPage", "setTopPage", "topPageHashCode", "getTopPageHashCode", "()I", "setTopPageHashCode", "(I)V", ApiRequest.METHOD_GET, "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private final PageDataManager getInstance() {
            Lazy lazy = PageDataManager.instance$delegate;
            Companion companion = PageDataManager.INSTANCE;
            return (PageDataManager) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void setLastPage(String str) {
            PageDataManager.lastPage = str;
        }

        public final String getLastPage() {
            return PageDataManager.lastPage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setTopPage(String str) {
            PageDataManager.topPage = str;
        }

        public final String getTopPage() {
            return PageDataManager.topPage;
        }

        public final int getTopPageHashCode() {
            return PageDataManager.topPageHashCode;
        }

        public final void setTopPageHashCode(int i) {
            PageDataManager.topPageHashCode = i;
        }

        public final PageDataManager get() {
            return getInstance();
        }
    }
}
