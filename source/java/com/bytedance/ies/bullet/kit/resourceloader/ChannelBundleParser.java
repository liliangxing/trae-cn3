package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLoggerConstant;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ExtraInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ILoaderDepender;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ChannelBundleParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\b0\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J4\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019J \u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J \u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J\u000e\u0010\u001e\u001a\u00020\u0017*\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/ChannelBundleParser;", "", "()V", "PREFIX_PATTERN", "", "TAG", "sPatternCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/regex/Pattern;", "sResultMap", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;", "buildPrefixPattern", "kotlin.jvm.PlatformType", SchemaConstants.QUERY_KEY_PREFIX, "createOrGetPattern", "dealPrefix", "str", RLMonitorReporter.PARSE, "url", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "bid", "needMerge", "", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "parseWithPrefix", "prefixList", "", "parseWithPrefixSingleCycle", "isNotNullOrEmpty", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ChannelBundleParser {
    private static final String PREFIX_PATTERN = "/(([^/]+)/([^?]*))";
    private static final String TAG = "ChannelBundleParser";
    public static final ChannelBundleParser INSTANCE = new ChannelBundleParser();
    private static final ConcurrentHashMap<String, Pattern> sPatternCacheMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, RLChannelBundleModel> sResultMap = new ConcurrentHashMap<>();

    private ChannelBundleParser() {
    }

    public static /* synthetic */ RLChannelBundleModel parse$default(ChannelBundleParser channelBundleParser, String str, ResourceLoaderConfig resourceLoaderConfig, String str2, boolean z, TaskConfig taskConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            taskConfig = new TaskConfig("");
        }
        return channelBundleParser.parse(str, resourceLoaderConfig, str2, z2, taskConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RLChannelBundleModel parse(String str, ResourceLoaderConfig resourceLoaderConfig, String str2, boolean z, TaskConfig taskConfig) {
        String str3;
        Object obj;
        Object obj2;
        String str4;
        String str5;
        ExtraInfo extraInfo;
        str3 = "";
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(resourceLoaderConfig, "config");
        Intrinsics.checkNotNullParameter(str2, "bid");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(RLLoggerConstant.RESOURCE_SESSION, taskConfig.getResourceLoaderSession());
        Uri parse = Uri.parse(str);
        ILoaderDepender loaderDepender = resourceLoaderConfig.getDftGeckoCfg().getLoaderDepender();
        try {
            Result.Companion companion = Result.Companion;
            ChannelBundleParser channelBundleParser = this;
            ResourceLoaderUtils resourceLoaderUtils = ResourceLoaderUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            String cdn = resourceLoaderUtils.getCDN(parse);
            if (cdn == null) {
                cdn = "";
            }
            String queryParameter = parse.getQueryParameter(SchemaConstants.QUERY_KEY_RES_URL);
            if (queryParameter == null) {
                queryParameter = "";
            }
            if (!isNotNullOrEmpty(cdn)) {
                if (!(queryParameter.length() > 0)) {
                    cdn = str;
                }
            }
            obj = Result.constructor-impl(cdn);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        boolean z2 = Result.isFailure-impl(obj);
        Object obj3 = obj;
        if (z2) {
            obj3 = "";
        }
        String str6 = (String) obj3;
        ConcurrentHashMap<String, RLChannelBundleModel> concurrentHashMap = sResultMap;
        if (concurrentHashMap.get(str6) != null) {
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Pair[] pairArr = new Pair[2];
            RLChannelBundleModel rLChannelBundleModel = concurrentHashMap.get(str6);
            pairArr[0] = TuplesKt.to("channel", rLChannelBundleModel != null ? rLChannelBundleModel.getChannel() : null);
            RLChannelBundleModel rLChannelBundleModel2 = concurrentHashMap.get(str6);
            pairArr[1] = TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, rLChannelBundleModel2 != null ? rLChannelBundleModel2.getBundlePath() : null);
            hybridLogger.m11i("XResourceLoader", "get RLChannelBundleModel from ResultMap", MapsKt.mapOf(pairArr), loggerContext);
            return concurrentHashMap.get(str6);
        }
        if (z) {
            Uri parse2 = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse2, "parse(url)");
            TaskConfig from = new TaskConfig(null, 1, null).from(taskConfig);
            from.setCdnUrl(str6);
            Unit unit = Unit.INSTANCE;
            TaskConfig mergeConfig = loaderDepender.mergeConfig(parse2, from);
            if (mergeConfig.getChannel().length() > 0) {
                if (mergeConfig.getBundle().length() > 0) {
                    HybridLogger.INSTANCE.m11i("XResourceLoader", "get RLChannelBundleModel from loaderDepender", MapsKt.mapOf(new Pair[]{TuplesKt.to("channel", mergeConfig.getChannel()), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, mergeConfig.getBundle())}), loggerContext);
                    return new RLChannelBundleModel(mergeConfig.getChannel(), mergeConfig.getBundle(), true);
                }
            }
        }
        if (Intrinsics.areEqual(taskConfig.getResTag(), "web")) {
            str4 = "";
        } else {
            try {
                Result.Companion companion3 = Result.Companion;
                ChannelBundleParser channelBundleParser2 = this;
                String queryParameter2 = parse.getQueryParameter("channel");
                if (queryParameter2 == null) {
                    queryParameter2 = "";
                }
                obj2 = Result.constructor-impl(queryParameter2);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            if (Result.isFailure-impl(obj2)) {
                obj2 = "";
            }
            str4 = (String) obj2;
        }
        if (!Intrinsics.areEqual(taskConfig.getResTag(), "web")) {
            try {
                Result.Companion companion5 = Result.Companion;
                ChannelBundleParser channelBundleParser3 = this;
                String queryParameter3 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                if (queryParameter3 == null) {
                    queryParameter3 = "";
                }
                str5 = Result.constructor-impl(queryParameter3);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.Companion;
                str5 = Result.constructor-impl(ResultKt.createFailure(th3));
            }
            str3 = Result.isFailure-impl(str5) ? "" : str5;
        }
        if (str4.length() > 0) {
            if (str3.length() > 0) {
                HybridLogger.INSTANCE.m11i("XResourceLoader", "get RLChannelBundleModel from uri", MapsKt.mapOf(new Pair[]{TuplesKt.to("channel", str4), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, str3)}), loggerContext);
                return new RLChannelBundleModel(str4, str3, true);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!taskConfig.getSpecifiedPrefix().isEmpty()) {
            arrayList.addAll(taskConfig.getSpecifiedPrefix());
        } else {
            arrayList.addAll(resourceLoaderConfig.getPrefix());
        }
        String queryParameter4 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_PREFIX);
        if (queryParameter4 != null) {
            if (!(!TextUtils.isEmpty(StringsKt.trim(queryParameter4).toString()))) {
                queryParameter4 = null;
            }
            if (queryParameter4 != null) {
                arrayList.add(INSTANCE.dealPrefix(queryParameter4));
            }
        }
        TaskContext taskContext = taskConfig.getTaskContext();
        if (taskContext != null && (extraInfo = (ExtraInfo) taskContext.getDependency(ExtraInfo.class)) != null) {
            arrayList.add(extraInfo.getPrefix());
            RLLogger.INSTANCE.m21d("ChannelBundleParser get url prefix: " + extraInfo.getPrefix());
        }
        if (resourceLoaderConfig.getEnableParseInSingleCycle()) {
            RLChannelBundleModel parseWithPrefixSingleCycle = parseWithPrefixSingleCycle(str6, arrayList);
            HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
            Pair[] pairArr2 = new Pair[2];
            pairArr2[0] = TuplesKt.to("channel", parseWithPrefixSingleCycle != null ? parseWithPrefixSingleCycle.getChannel() : null);
            pairArr2[1] = TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, parseWithPrefixSingleCycle != null ? parseWithPrefixSingleCycle.getBundlePath() : null);
            hybridLogger2.m11i("XResourceLoader", "get RLChannelBundleModel from parse prefix with single cycle", MapsKt.mapOf(pairArr2), loggerContext);
            return parseWithPrefixSingleCycle;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (String str7 : arrayList3) {
            if (str7 != null) {
                if (!(!TextUtils.isEmpty(StringsKt.trim(str7).toString()))) {
                    str7 = null;
                }
                arrayList4.add(str7 != null ? Boolean.valueOf(arrayList2.add(INSTANCE.dealPrefix(str7))) : null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        RLChannelBundleModel parseWithPrefix = parseWithPrefix(str6, arrayList2);
        HybridLogger hybridLogger3 = HybridLogger.INSTANCE;
        Pair[] pairArr3 = new Pair[2];
        pairArr3[0] = TuplesKt.to("channel", parseWithPrefix != null ? parseWithPrefix.getChannel() : null);
        pairArr3[1] = TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, parseWithPrefix != null ? parseWithPrefix.getBundlePath() : null);
        hybridLogger3.m11i("XResourceLoader", "get RLChannelBundleModel from parse prefix", MapsKt.mapOf(pairArr3), loggerContext);
        return parseWithPrefix;
    }

    private final String dealPrefix(String str) {
        String str2 = str;
        if (!(str2.length() > 0) || StringsKt.lastIndexOf$default(str2, "/", 0, false, 6, (Object) null) != str.length() - 1) {
            return str;
        }
        int length = str.length() - 1;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(0, length);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    private final RLChannelBundleModel parseWithPrefixSingleCycle(String url, List<String> prefixList) {
        if (url.length() == 0) {
            return null;
        }
        try {
            for (String str : prefixList) {
                if (!(str.length() == 0)) {
                    ChannelBundleParser channelBundleParser = INSTANCE;
                    Matcher matcher = channelBundleParser.createOrGetPattern(channelBundleParser.dealPrefix(str)).matcher(url);
                    if (matcher.find() && matcher.groupCount() == 3) {
                        String group = matcher.group(2);
                        String group2 = matcher.group(3);
                        if (channelBundleParser.isNotNullOrEmpty(group) && channelBundleParser.isNotNullOrEmpty(group2)) {
                            Intrinsics.checkNotNull(group);
                            Intrinsics.checkNotNull(group2);
                            RLChannelBundleModel rLChannelBundleModel = new RLChannelBundleModel(group, group2, true);
                            sResultMap.put(url, rLChannelBundleModel);
                            return rLChannelBundleModel;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "ChannelBundleModel parse error: " + e.getMessage());
        }
        return null;
    }

    private final RLChannelBundleModel parseWithPrefix(String url, List<String> prefixList) {
        if (url.length() == 0) {
            return null;
        }
        try {
            for (String str : prefixList) {
                if (!(str.length() == 0)) {
                    ChannelBundleParser channelBundleParser = INSTANCE;
                    Matcher matcher = channelBundleParser.createOrGetPattern(str).matcher(url);
                    if (matcher.find() && matcher.groupCount() == 3) {
                        String group = matcher.group(2);
                        String group2 = matcher.group(3);
                        if (channelBundleParser.isNotNullOrEmpty(group) && channelBundleParser.isNotNullOrEmpty(group2)) {
                            Intrinsics.checkNotNull(group);
                            Intrinsics.checkNotNull(group2);
                            RLChannelBundleModel rLChannelBundleModel = new RLChannelBundleModel(group, group2, true);
                            sResultMap.put(url, rLChannelBundleModel);
                            return rLChannelBundleModel;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "ChannelBundleModel parse error: " + e.getMessage());
        }
        return null;
    }

    private final Pattern createOrGetPattern(String r3) {
        ConcurrentHashMap<String, Pattern> concurrentHashMap = sPatternCacheMap;
        Pattern pattern = concurrentHashMap.get(r3);
        if (pattern == null) {
            pattern = buildPrefixPattern(r3);
            concurrentHashMap.put(r3, pattern);
        }
        Intrinsics.checkNotNull(pattern);
        return pattern;
    }

    private final Pattern buildPrefixPattern(String r2) {
        return Pattern.compile(r2 + PREFIX_PATTERN);
    }

    private final boolean isNotNullOrEmpty(String str) {
        return str != null && str.length() > 0;
    }
}
