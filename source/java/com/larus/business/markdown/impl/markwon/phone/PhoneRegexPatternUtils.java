package com.larus.business.markdown.impl.markwon.phone;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PhoneRegexPatternUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneRegexPatternUtils;", "", "()V", "HOTLINE_5_REGEX", "", "HYBRID_PHONE_REGEX", "SERVICE_5_REGEX", "SERVICE_6_REGEX", "SERVICE_REGEX", "customPattern", "Ljava/util/regex/Pattern;", "hybridPattern", "getAllPhoneInfo", "", "Lcom/larus/business/markdown/impl/markwon/phone/PhoneRegexPatternUtils$PhoneInfo;", "text", "phoneRegex", "getCustomRegexPattern", "getDefaultRegexPattern", "PhoneInfo", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PhoneRegexPatternUtils {
    private static final String HOTLINE_5_REGEX = "(?:1[0-3]\\d{3})";
    private static final String HYBRID_PHONE_REGEX = "(?<![\\d.])((?:(?:\\+86|86)[- ]?)?1[3-9][0-9][- ]?\\d{4}[- ]?\\d{4}|(?:\\(0\\d{2,3}\\)|0\\d{2,3})?[- ]?\\d{7,8}|(?:400|800)[- ]?\\d{3,4}[- ]?\\d{3,4}|(?:\\(0\\d{2,3}\\)|0\\d{2,3})?[- ]?(?:(?:1[0-3]\\d{3})|(?:9(?:[5,6]\\d{3}))|(?:1(?:2\\d{4}|\\d{5})|9(?:[5,6]\\d{4})|100\\d{3}))|\\+\\d{1,3}[- ]?(?:\\(\\d{1,5}\\)|\\d{1,5})[- ]?\\d{1,4}[- ]?\\d{3,5})(?![\\d.])";
    public static final PhoneRegexPatternUtils INSTANCE = new PhoneRegexPatternUtils();
    private static final String SERVICE_5_REGEX = "(?:9(?:[5,6]\\d{3}))";
    private static final String SERVICE_6_REGEX = "(?:1(?:2\\d{4}|\\d{5})|9(?:[5,6]\\d{4})|100\\d{3})";
    private static final String SERVICE_REGEX = "(?:\\(0\\d{2,3}\\)|0\\d{2,3})?[- ]?(?:(?:1[0-3]\\d{3})|(?:9(?:[5,6]\\d{3}))|(?:1(?:2\\d{4}|\\d{5})|9(?:[5,6]\\d{4})|100\\d{3}))";
    private static Pattern customPattern;
    private static Pattern hybridPattern;

    private PhoneRegexPatternUtils() {
    }

    private final Pattern getCustomRegexPattern(String phoneRegex) {
        String str = phoneRegex;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        Pattern pattern = customPattern;
        if (pattern != null) {
            return pattern;
        }
        Pattern compile = Pattern.compile(phoneRegex);
        customPattern = compile;
        return compile;
    }

    @JvmStatic
    private static final Pattern getDefaultRegexPattern() {
        Pattern pattern = hybridPattern;
        if (pattern != null) {
            return pattern;
        }
        Pattern compile = Pattern.compile(HYBRID_PHONE_REGEX);
        hybridPattern = compile;
        Intrinsics.checkNotNullExpressionValue(compile, "run {\n            val pa…        pattern\n        }");
        return compile;
    }

    public static /* synthetic */ List getAllPhoneInfo$default(PhoneRegexPatternUtils phoneRegexPatternUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return phoneRegexPatternUtils.getAllPhoneInfo(str, str2);
    }

    public final List<PhoneInfo> getAllPhoneInfo(String text, String phoneRegex) {
        Intrinsics.checkNotNullParameter(text, "text");
        Pattern customRegexPattern = getCustomRegexPattern(phoneRegex);
        if (customRegexPattern == null) {
            customRegexPattern = getDefaultRegexPattern();
        }
        Matcher matcher = customRegexPattern.matcher(text);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            Intrinsics.checkNotNullExpressionValue(group, "matcher.group()");
            arrayList.add(new PhoneInfo(start, end, group));
        }
        return arrayList;
    }

    /* compiled from: PhoneRegexPatternUtils.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneRegexPatternUtils$PhoneInfo;", "", "start", "", "end", "phoneNumber", "", "(IILjava/lang/String;)V", "getEnd", "()I", "getPhoneNumber", "()Ljava/lang/String;", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class PhoneInfo {
        private final int end;
        private final String phoneNumber;
        private final int start;

        public static /* synthetic */ PhoneInfo copy$default(PhoneInfo phoneInfo, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = phoneInfo.start;
            }
            if ((i3 & 2) != 0) {
                i2 = phoneInfo.end;
            }
            if ((i3 & 4) != 0) {
                str = phoneInfo.phoneNumber;
            }
            return phoneInfo.copy(i, i2, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final PhoneInfo copy(int start, int end, String phoneNumber) {
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            return new PhoneInfo(start, end, phoneNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PhoneInfo)) {
                return false;
            }
            PhoneInfo phoneInfo = (PhoneInfo) other;
            return this.start == phoneInfo.start && this.end == phoneInfo.end && Intrinsics.areEqual(this.phoneNumber, phoneInfo.phoneNumber);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + this.phoneNumber.hashCode();
        }

        public String toString() {
            return "PhoneInfo(start=" + this.start + ", end=" + this.end + ", phoneNumber=" + this.phoneNumber + ')';
        }

        public PhoneInfo(int i, int i2, String str) {
            Intrinsics.checkNotNullParameter(str, "phoneNumber");
            this.start = i;
            this.end = i2;
            this.phoneNumber = str;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }
    }
}
