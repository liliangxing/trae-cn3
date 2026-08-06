package com.bytedance.trae.im.service.tenant;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: ContentSecurityFilter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u001c\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\n2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;", "", "<init>", "()V", "DEFAULT_REPLACEMENT", "", "filter", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;", ReportConstant.COMMON_CONTENT, "rules", "", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;", "scene", "", "executionPoint", "executeBlock", MessagePart.TYPE_RULE, "executeDesensitize", "isApplicableTo", "", "sortedDetails", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;", "compileRegex", "Lkotlin/text/Regex;", "detail", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ContentSecurityFilter {
    private static final String DEFAULT_REPLACEMENT = "***";
    public static final ContentSecurityFilter INSTANCE = new ContentSecurityFilter();

    private ContentSecurityFilter() {
    }

    public static /* synthetic */ ContentSecurityFilterResult filter$default(ContentSecurityFilter contentSecurityFilter, String str, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 1;
        }
        if ((i3 & 8) != 0) {
            i2 = 1;
        }
        return contentSecurityFilter.filter(str, list, i, i2);
    }

    public final ContentSecurityFilterResult filter(String content, List<ContentSecurityRule> rules, final int scene, final int executionPoint) {
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(rules, "rules");
        ArrayList arrayList = new ArrayList();
        String str = content;
        for (ContentSecurityRule contentSecurityRule : SequencesKt.filter(CollectionsKt.asSequence(rules), new Function1() { // from class: com.bytedance.trae.im.service.tenant.ContentSecurityFilter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean filter$lambda$0;
                filter$lambda$0 = ContentSecurityFilter.filter$lambda$0(scene, executionPoint, (ContentSecurityRule) obj);
                return Boolean.valueOf(filter$lambda$0);
            }
        })) {
            Integer actionType = contentSecurityRule.getActionType();
            if (actionType != null && actionType.intValue() == 1) {
                ContentSecurityFilterResult executeBlock = INSTANCE.executeBlock(str, contentSecurityRule);
                if (executeBlock != null) {
                    return executeBlock;
                }
            } else if (actionType != null && actionType.intValue() == 2) {
                ContentSecurityFilterResult executeDesensitize = INSTANCE.executeDesensitize(str, contentSecurityRule);
                if (executeDesensitize instanceof ContentSecurityFilterResult.Desensitized) {
                    ContentSecurityFilterResult.Desensitized desensitized = (ContentSecurityFilterResult.Desensitized) executeDesensitize;
                    if (desensitized.getRuleName().length() > 0) {
                        arrayList.add(desensitized.getRuleName());
                    }
                    str = desensitized.getProcessedContent();
                } else {
                    if (executeDesensitize instanceof ContentSecurityFilterResult.Error) {
                        return executeDesensitize;
                    }
                    if (!Intrinsics.areEqual(executeDesensitize, ContentSecurityFilterResult.Passed.INSTANCE)) {
                        if (executeDesensitize instanceof ContentSecurityFilterResult.Blocked) {
                            return executeDesensitize;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
        if (!Intrinsics.areEqual(str, content)) {
            return new ContentSecurityFilterResult.Desensitized(CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), str);
        }
        return ContentSecurityFilterResult.Passed.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filter$lambda$0(int i, int i2, ContentSecurityRule contentSecurityRule) {
        Intrinsics.checkNotNullParameter(contentSecurityRule, "it");
        return INSTANCE.isApplicableTo(contentSecurityRule, i, i2);
    }

    private final ContentSecurityFilterResult executeBlock(String content, ContentSecurityRule rule) {
        for (ContentSecurityRuleDetail contentSecurityRuleDetail : sortedDetails(rule)) {
            Regex compileRegex = INSTANCE.compileRegex(contentSecurityRuleDetail);
            if (compileRegex == null) {
                String ruleName = rule.getRuleName();
                if (ruleName == null) {
                    ruleName = "";
                }
                String ruleDetailName = contentSecurityRuleDetail.getRuleDetailName();
                if (ruleDetailName == null) {
                    ruleDetailName = "";
                }
                StringBuilder sb = new StringBuilder("Invalid regex pattern: ");
                String regexPattern = contentSecurityRuleDetail.getRegexPattern();
                return new ContentSecurityFilterResult.Error(ruleName, ruleDetailName, sb.append(regexPattern != null ? regexPattern : "").toString());
            }
            MatchResult find$default = Regex.find$default(compileRegex, content, 0, 2, (Object) null);
            if (find$default != null) {
                String ruleName2 = rule.getRuleName();
                if (ruleName2 == null) {
                    ruleName2 = "";
                }
                String ruleDetailName2 = contentSecurityRuleDetail.getRuleDetailName();
                return new ContentSecurityFilterResult.Blocked(ruleName2, ruleDetailName2 != null ? ruleDetailName2 : "", find$default.getValue());
            }
        }
        return null;
    }

    private final ContentSecurityFilterResult executeDesensitize(String content, ContentSecurityRule rule) {
        Object obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = content;
        Iterator<T> it = sortedDetails(rule).iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                if (z) {
                    String ruleName = rule.getRuleName();
                    return new ContentSecurityFilterResult.Desensitized(ruleName != null ? ruleName : "", (String) objectRef.element);
                }
                return ContentSecurityFilterResult.Passed.INSTANCE;
            }
            ContentSecurityRuleDetail contentSecurityRuleDetail = (ContentSecurityRuleDetail) it.next();
            Regex compileRegex = INSTANCE.compileRegex(contentSecurityRuleDetail);
            if (compileRegex == null) {
                String ruleName2 = rule.getRuleName();
                if (ruleName2 == null) {
                    ruleName2 = "";
                }
                String ruleDetailName = contentSecurityRuleDetail.getRuleDetailName();
                if (ruleDetailName == null) {
                    ruleDetailName = "";
                }
                StringBuilder sb = new StringBuilder("Invalid regex pattern: ");
                String regexPattern = contentSecurityRuleDetail.getRegexPattern();
                return new ContentSecurityFilterResult.Error(ruleName2, ruleDetailName, sb.append(regexPattern != null ? regexPattern : "").toString());
            }
            if (compileRegex.containsMatchIn((CharSequence) objectRef.element)) {
                String replacement = contentSecurityRuleDetail.getReplacement();
                if (replacement == null) {
                    replacement = DEFAULT_REPLACEMENT;
                }
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(compileRegex.replace((CharSequence) objectRef.element, replacement));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) == null) {
                    objectRef.element = obj;
                    z = true;
                } else {
                    String ruleName3 = rule.getRuleName();
                    if (ruleName3 == null) {
                        ruleName3 = "";
                    }
                    String ruleDetailName2 = contentSecurityRuleDetail.getRuleDetailName();
                    return new ContentSecurityFilterResult.Error(ruleName3, ruleDetailName2 != null ? ruleDetailName2 : "", "Invalid regex replacement: " + replacement);
                }
            }
        }
    }

    private final boolean isApplicableTo(ContentSecurityRule contentSecurityRule, int i, int i2) {
        Integer sceneType;
        return contentSecurityRule.isEnabled() && (sceneType = contentSecurityRule.getSceneType()) != null && sceneType.intValue() == i && contentSecurityRule.getExecutionPoints().contains(Integer.valueOf(i2));
    }

    private final List<ContentSecurityRuleDetail> sortedDetails(ContentSecurityRule rule) {
        return CollectionsKt.sortedWith(rule.getRuleDetails(), new Comparator() { // from class: com.bytedance.trae.im.service.tenant.ContentSecurityFilter$sortedDetails$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ContentSecurityRuleDetail) t).getSequence()), Integer.valueOf(((ContentSecurityRuleDetail) t2).getSequence()));
            }
        });
    }

    private final Regex compileRegex(ContentSecurityRuleDetail detail) {
        Object obj;
        String regexPattern = detail.getRegexPattern();
        if (regexPattern == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            ContentSecurityFilter contentSecurityFilter = this;
            obj = Result.constructor-impl(new Regex(regexPattern));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Regex) (Result.isFailure-impl(obj) ? null : obj);
    }
}
