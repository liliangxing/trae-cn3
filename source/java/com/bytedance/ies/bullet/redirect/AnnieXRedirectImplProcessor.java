package com.bytedance.ies.bullet.redirect;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.ies.bullet.base.settings.AnnieXRedirectSettingsConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectInterceptor;
import com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectProcessor;
import com.bytedance.ies.bullet.redirect.data.RedirectException;
import com.bytedance.ies.bullet.redirect.data.RedirectInputInfo;
import com.bytedance.ies.bullet.redirect.data.RedirectOutputInfo;
import com.bytedance.ies.bullet.redirect.data.RedirectReportInfo;
import com.bytedance.ies.bullet.redirect.helper.OptimizeMainThreadScheduler;
import com.bytedance.ies.bullet.redirect.helper.RedirectRuleStorage;
import com.bytedance.ies.bullet.redirect.helper.UriQueryView;
import com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor;
import com.bytedance.ies.bullet.redirect.rule.AppVersionStrategy;
import com.bytedance.ies.bullet.redirect.rule.RuleStrategy;
import com.bytedance.ies.bullet.redirect.rule.TimeRangeStrategy;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import com.bytedance.news.common.settings.IndividualManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* compiled from: AnnieXRedirectImplProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\bH\u0002J\u001b\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0082\u0010J>\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u001f2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0002J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u001bH\u0002J\"\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u00101\u001a\u00020\nJ\u001a\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u00063"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/AnnieXRedirectImplProcessor;", "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor;", "()V", "interceptors", "Ljava/util/ArrayList;", "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectInterceptor;", "Lkotlin/collections/ArrayList;", "isInitialized", "", "maxDepth", "", ErrorType.SETTINGS, "Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "getSettings", "()Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "settings$delegate", "Lkotlin/Lazy;", "canJumpInCurRoute", "uri", "Landroid/net/Uri;", EventConstants.PARAM_SOURCE_INIT, "", "initInfo", "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor$RedirectInitInfo;", "parseRedirectInfo", "Lcom/bytedance/ies/bullet/redirect/data/RedirectInputInfo;", "url", "", "reportError", "printDetailMessageRecursion", "t", "", "writer", "Ljava/io/PrintWriter;", "processFinalResult", "redirectInfo", "redirectOutputInfo", "Lcom/bytedance/ies/bullet/redirect/data/RedirectOutputInfo;", "throwable", "callback", "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectProcessor$RedirectCallback;", "cost", "", "loopIndex", "processSchema", "info", "schema", "redirect", "redirectInputInfo", "redirectTimes", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AnnieXRedirectImplProcessor implements IAnnieXRedirectProcessor {
    public static final String TAG = "AnnieXRedirectTag";
    public static final String initUrl = "sslocal://annie_redirect?entry=initialize";
    private boolean isInitialized;
    private final ArrayList<IAnnieXRedirectInterceptor> interceptors = new ArrayList<>();
    private final int maxDepth = 3;

    /* renamed from: settings$delegate, reason: from kotlin metadata */
    private final Lazy settings = LazyKt.lazy(new Function0<IBulletSettings>() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$settings$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IBulletSettings m545invoke() {
            return (IBulletSettings) IndividualManager.obtainManager("Bullet").obtain(IBulletSettings.class);
        }
    });

    public final IBulletSettings getSettings() {
        return (IBulletSettings) this.settings.getValue();
    }

    @Override // com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectProcessor
    public void init(IAnnieXRedirectProcessor.RedirectInitInfo initInfo) {
        Intrinsics.checkNotNullParameter(initInfo, "initInfo");
        if (this.isInitialized) {
            return;
        }
        synchronized (this) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "AnnieX redirect init start", null, null, 12, null);
            this.isInitialized = true;
            String appVersion = initInfo.getAppVersion();
            if (appVersion != null) {
                RuleStrategy.INSTANCE.register(new AppVersionStrategy(appVersion));
            }
            RuleStrategy.INSTANCE.register(new TimeRangeStrategy());
            this.interceptors.add(new GeckoCDNInterceptor(new RedirectRuleStorage(), initInfo.getCdnSourceUrl()));
            Schedulers.io().scheduleDirect(new Runnable() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$init$1$2
                @Override // java.lang.Runnable
                public final void run() {
                    AnnieXRedirectImplProcessor.this.redirect(AnnieXRedirectImplProcessor.initUrl, null);
                }
            });
        }
    }

    @Override // com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectProcessor
    public boolean redirect(String schema, IAnnieXRedirectProcessor.RedirectCallback callback) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        RedirectInputInfo parseRedirectInfo = parseRedirectInfo(schema, true);
        if (parseRedirectInfo == null) {
            return false;
        }
        return redirect(parseRedirectInfo, callback, 1);
    }

    @Override // com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectProcessor
    public boolean canJumpInCurRoute(Uri uri) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(uri, "uri");
        AnnieXRedirectSettingsConfig annieXRedirectConfig = getSettings().getAnnieXRedirectConfig();
        if (annieXRedirectConfig == null || (jSONArray = annieXRedirectConfig.getRedirectInCurRouteWhiteList()) == null) {
            jSONArray = new JSONArray();
            jSONArray.put("lynxview");
            jSONArray.put("lynxview_popoup");
            jSONArray.put("webview");
            jSONArray.put("polaris/lynx");
            jSONArray.put("hunter_lynxview");
            jSONArray.put("hunter_popup");
            jSONArray.put("webcast_redirect");
            jSONArray.put("webcast_lynxview");
            jSONArray.put("webcast_webview");
        }
        String host = uri.getHost();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(jSONArray.getString(i), host)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean redirect$default(AnnieXRedirectImplProcessor annieXRedirectImplProcessor, RedirectInputInfo redirectInputInfo, IAnnieXRedirectProcessor.RedirectCallback redirectCallback, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return annieXRedirectImplProcessor.redirect(redirectInputInfo, redirectCallback, i);
    }

    public final boolean redirect(final RedirectInputInfo redirectInputInfo, final IAnnieXRedirectProcessor.RedirectCallback callback, final int redirectTimes) {
        Intrinsics.checkNotNullParameter(redirectInputInfo, "redirectInputInfo");
        if (!this.isInitialized) {
            init(new IAnnieXRedirectProcessor.RedirectInitInfo(BulletEnv.INSTANCE.getInstance().getAppVersion(), null, 2, null));
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ArrayList<IAnnieXRedirectInterceptor> arrayList = this.interceptors;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (final IAnnieXRedirectInterceptor iAnnieXRedirectInterceptor : arrayList) {
            arrayList2.add(Observable.create(new ObservableOnSubscribe() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$redirect$disposable$1$1
                public final void subscribe(final ObservableEmitter<RedirectOutputInfo> observableEmitter) {
                    Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
                    try {
                        IAnnieXRedirectInterceptor.this.intercept(redirectInputInfo, new Function1<RedirectOutputInfo, Unit>() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$redirect$disposable$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((RedirectOutputInfo) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RedirectOutputInfo redirectOutputInfo) {
                                Intrinsics.checkNotNullParameter(redirectOutputInfo, "it");
                                observableEmitter.onNext(redirectOutputInfo);
                                observableEmitter.onComplete();
                            }
                        }, new Function2<Integer, String, Unit>() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$redirect$disposable$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke(((Number) obj).intValue(), (String) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i, String str) {
                                Intrinsics.checkNotNullParameter(str, "msg");
                                observableEmitter.onError(new RedirectException(i, str, null, 4, null));
                            }
                        });
                    } catch (Throwable th) {
                        String message = th.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        observableEmitter.onError(new RedirectException(-1, message, null, 4, null));
                    }
                }
            }));
        }
        Intrinsics.checkNotNullExpressionValue(Observable.concat(arrayList2).firstOrError().doOnSubscribe(new Consumer() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$redirect$disposable$2
            public final void accept(Disposable disposable) {
                int i;
                int i2;
                int i3 = redirectTimes;
                i = this.maxDepth;
                boolean z = i3 < i;
                AnnieXRedirectImplProcessor annieXRedirectImplProcessor = this;
                if (z) {
                    return;
                }
                StringBuilder sb = new StringBuilder("redirect recursion must less than ");
                i2 = annieXRedirectImplProcessor.maxDepth;
                throw new IllegalStateException(sb.append(i2).append(" depth").toString().toString());
            }
        }).observeOn(OptimizeMainThreadScheduler.INSTANCE.getMainThread()).subscribe(new Consumer() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$redirect$disposable$3
            public final void accept(RedirectOutputInfo redirectOutputInfo) {
                AnnieXRedirectImplProcessor.this.processFinalResult(redirectInputInfo, redirectOutputInfo, null, callback, System.currentTimeMillis() - currentTimeMillis, redirectTimes);
            }
        }, new Consumer() { // from class: com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor$redirect$disposable$4
            public final void accept(Throwable th) {
                AnnieXRedirectImplProcessor.this.processFinalResult(redirectInputInfo, null, th, callback, System.currentTimeMillis() - currentTimeMillis, redirectTimes);
            }
        }), "fun redirect(redirectInp…        return true\n    }");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void processFinalResult(RedirectInputInfo redirectInfo, RedirectOutputInfo redirectOutputInfo, Throwable throwable, IAnnieXRedirectProcessor.RedirectCallback callback, long cost, int loopIndex) {
        String str;
        int i;
        RedirectReportInfo.Category category;
        Integer errorCode;
        if (Intrinsics.areEqual(redirectInfo.getRaw(), initUrl)) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "AnnieX redirect init finish", null, null, 12, null);
            return;
        }
        RedirectReportInfo reportInfo = redirectInfo.getReportInfo();
        if (reportInfo != null) {
            reportInfo.getCategory().setLoopIndex(loopIndex);
            reportInfo.getMetric().setDuration(cost);
        }
        boolean z = true;
        String str2 = null;
        str2 = null;
        if (((redirectOutputInfo == null || (errorCode = redirectOutputInfo.getErrorCode()) == null || errorCode.intValue() != 0) ? false : true) != false && redirectOutputInfo.getSchema() != null) {
            String processSchema = processSchema(redirectInfo, redirectOutputInfo.getSchema());
            RedirectReportInfo reportInfo2 = redirectInfo.getReportInfo();
            RedirectReportInfo.Category category2 = reportInfo2 != null ? reportInfo2.getCategory() : null;
            if (category2 != null) {
                category2.setResolvedSchema(processSchema);
            }
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "redirect success: schema {" + redirectInfo.getRaw() + "} to {" + processSchema + '}', null, null, 12, null);
            RedirectInputInfo parseRedirectInfo = parseRedirectInfo(processSchema, false);
            if (parseRedirectInfo != null) {
                redirect(parseRedirectInfo, callback, loopIndex + 1);
            } else if (callback != null) {
                callback.onSuccess(processSchema);
            }
            RedirectReportInfo reportInfo3 = redirectInfo.getReportInfo();
            if (reportInfo3 != null) {
                reportInfo3.reportSuccess();
                return;
            }
            return;
        }
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(redirectInfo.getDefaultSchema())) {
            String defaultSchema = redirectInfo.getDefaultSchema();
            if (defaultSchema == null) {
                defaultSchema = "";
            }
            String processSchema2 = processSchema(redirectInfo, defaultSchema);
            RedirectReportInfo reportInfo4 = redirectInfo.getReportInfo();
            RedirectReportInfo.Category category3 = reportInfo4 != null ? reportInfo4.getCategory() : null;
            if (category3 != null) {
                category3.setDefaultSchema(defaultSchema);
            }
            RedirectReportInfo reportInfo5 = redirectInfo.getReportInfo();
            RedirectReportInfo.Category category4 = reportInfo5 != null ? reportInfo5.getCategory() : null;
            if (category4 != null) {
                category4.setResolvedSchema(processSchema2);
            }
            RedirectInputInfo parseRedirectInfo2 = parseRedirectInfo(processSchema2, false);
            if (parseRedirectInfo2 != null) {
                redirect(parseRedirectInfo2, callback, loopIndex + 1);
            } else if (callback != null) {
                callback.onSuccess(processSchema2);
            }
        }
        if (throwable instanceof RedirectException) {
            StringWriter stringWriter = new StringWriter();
            printDetailMessageRecursion(throwable, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, "writer.toString()");
            i = ((RedirectException) throwable).getCode();
            str = "redirect FAILED: schema " + redirectInfo.getRaw() + ", reason：" + stringWriter2;
        } else {
            str = "redirect FAILED: schema " + redirectInfo.getRaw() + ", reason：" + (throwable != null ? throwable.getMessage() : null);
            i = -1;
        }
        RedirectReportInfo reportInfo6 = redirectInfo.getReportInfo();
        if (reportInfo6 != null) {
            reportInfo6.reportError(i, str);
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, TAG, str, null, null, 12, null);
        RedirectReportInfo reportInfo7 = redirectInfo.getReportInfo();
        if (reportInfo7 != null && (category = reportInfo7.getCategory()) != null) {
            str2 = category.getResolvedSchema();
        }
        String str3 = str2;
        if (str3 != null && str3.length() != 0) {
            z = false;
        }
        if (z) {
            if (callback != null) {
                callback.onFail(i, str);
            }
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "redirect fail: raw schema {" + redirectInfo.getRaw() + "};error code: " + i + "; error msg: " + str, null, null, 12, null);
            Toast.makeText(BulletEnv.INSTANCE.getInstance().getApplication(), "加载失败，请重试", 0).show();
        }
    }

    static /* synthetic */ RedirectInputInfo parseRedirectInfo$default(AnnieXRedirectImplProcessor annieXRedirectImplProcessor, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return annieXRedirectImplProcessor.parseRedirectInfo(str, z);
    }

    private final RedirectInputInfo parseRedirectInfo(String url, boolean reportError) {
        Uri parse = Uri.parse(url);
        String queryParameter = parse.getQueryParameter("entry");
        RedirectReportInfo redirectReportInfo = new RedirectReportInfo();
        redirectReportInfo.getCategory().setOriginSchema(url);
        redirectReportInfo.getCategory().setSdkVersion("9.0.0");
        redirectReportInfo.getCategory().setEntry(queryParameter == null ? "" : queryParameter);
        String str = queryParameter;
        if (str == null || str.length() == 0) {
            if (reportError) {
                redirectReportInfo.reportError(1, "There is no entry field on the Schema link");
            }
            return null;
        }
        if (TextUtils.equals(parse.getHost(), "annie_redirect")) {
            return new RedirectInputInfo(url, queryParameter, parse.getQueryParameter("scheme_query"), parse.getQueryParameter("url_query"), parse.getQueryParameter("default_schema"), redirectReportInfo, Intrinsics.areEqual(parse.getQueryParameter("decode_query_value"), "1"));
        }
        return null;
    }

    private final String processSchema(RedirectInputInfo info, String schema) {
        UriQueryView uriQueryView;
        Set<String> queryParameterNames;
        Set<String> queryParameterNames2;
        Set<String> queryParameterNames3;
        Uri parse = Uri.parse(info.getRaw());
        Uri parse2 = Uri.parse(schema);
        if (TextUtils.equals(parse2.getHost(), "annie_redirect")) {
            Uri.Builder clearQuery = parse2.buildUpon().clearQuery();
            if (parse2 != null && (queryParameterNames3 = parse2.getQueryParameterNames()) != null) {
                ArrayList<String> arrayList = new ArrayList();
                for (Object obj : queryParameterNames3) {
                    String str = (String) obj;
                    Intrinsics.checkNotNullExpressionValue(str, "it");
                    if (AnnieXRedirectImplProcessorKt.isAnyOf(str, "entry", "default_schema")) {
                        arrayList.add(obj);
                    }
                }
                for (String str2 : arrayList) {
                    clearQuery.appendQueryParameter(str2, parse2.getQueryParameter(str2));
                }
            }
            if (parse != null && (queryParameterNames2 = parse.getQueryParameterNames()) != null) {
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj2 : queryParameterNames2) {
                    Intrinsics.checkNotNullExpressionValue((String) obj2, "it");
                    if (!AnnieXRedirectImplProcessorKt.isAnyOf(r13, "entry", "default_schema", "url")) {
                        arrayList2.add(obj2);
                    }
                }
                for (String str3 : arrayList2) {
                    clearQuery.appendQueryParameter(str3, parse.getQueryParameter(str3));
                }
            }
            String builder = clearQuery.toString();
            Intrinsics.checkNotNullExpressionValue(builder, "builder.toString()");
            return builder;
        }
        UriQueryView uriQueryView2 = new UriQueryView(schema);
        UriQueryView uriQueryView3 = null;
        UriQueryView view = uriQueryView2.get("url") != null ? uriQueryView2.view("url") : null;
        if (uriQueryView2.get(SchemaConstants.QUERY_KEY_FALLBACK_URL) != null) {
            UriQueryView view2 = uriQueryView2.view(SchemaConstants.QUERY_KEY_FALLBACK_URL);
            if (view2 != null && view2.get("url") != null && view2 != null) {
                uriQueryView3 = view2.view("url");
            }
            uriQueryView = uriQueryView3;
            uriQueryView3 = view2;
        } else {
            uriQueryView = null;
        }
        if (parse != null && (queryParameterNames = parse.getQueryParameterNames()) != null) {
            ArrayList<String> arrayList3 = new ArrayList();
            for (Object obj3 : queryParameterNames) {
                Intrinsics.checkNotNullExpressionValue((String) obj3, "it");
                if (!AnnieXRedirectImplProcessorKt.isAnyOf(r7, "entry", "default_schema", "scheme_query", "url_query", "url", SchemaConstants.QUERY_KEY_FALLBACK_URL)) {
                    arrayList3.add(obj3);
                }
            }
            for (String str4 : arrayList3) {
                Intrinsics.checkNotNullExpressionValue(str4, "it");
                uriQueryView2.set(str4, parse.getQueryParameter(str4));
                if (uriQueryView3 != null) {
                    uriQueryView3.set(str4, parse.getQueryParameter(str4));
                }
            }
        }
        String schemaQuery = info.getSchemaQuery();
        if (schemaQuery != null) {
            Object[] array = StringsKt.split$default(schemaQuery, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                for (String str5 : (String[]) array) {
                    Object[] array2 = StringsKt.split$default(str5, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr = (String[]) array2;
                        if (strArr.length == 2) {
                            String str6 = strArr[0];
                            String str7 = strArr[1];
                            if (info.getDecodeQueryValue()) {
                                str7 = Uri.decode(str7);
                                Intrinsics.checkNotNullExpressionValue(str7, "decode(v)");
                            }
                            uriQueryView2.set(str6, str7);
                            if (uriQueryView3 != null) {
                                uriQueryView3.set(str6, str7);
                            }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        String urlQuery = info.getUrlQuery();
        if (urlQuery != null) {
            Object[] array3 = StringsKt.split$default(urlQuery, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array3 != null) {
                for (String str8 : (String[]) array3) {
                    Object[] array4 = StringsKt.split$default(str8, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array4 != null) {
                        String[] strArr2 = (String[]) array4;
                        if (strArr2.length == 2) {
                            String str9 = strArr2[0];
                            String str10 = strArr2[1];
                            if (info.getDecodeQueryValue()) {
                                str10 = Uri.decode(str10);
                                Intrinsics.checkNotNullExpressionValue(str10, "decode(v)");
                            }
                            if (view != null) {
                                view.set(str9, str10);
                            }
                            if (uriQueryView != null) {
                                uriQueryView.set(str9, str10);
                            }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return uriQueryView2.toString();
    }

    private final void printDetailMessageRecursion(Throwable t, PrintWriter writer) {
        while (t != null) {
            String message = t.getMessage();
            if (!(message == null || message.length() == 0)) {
                writer.print(" | ");
                writer.print(t.getMessage());
            }
            t = t.getCause();
        }
    }
}
