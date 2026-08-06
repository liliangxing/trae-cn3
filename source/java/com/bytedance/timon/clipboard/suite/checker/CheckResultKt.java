package com.bytedance.timon.clipboard.suite.checker;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: CheckResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0013\"\u001d\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"ERROR_CODE_TO_RULE_KEY", "", "", "", "getERROR_CODE_TO_RULE_KEY", "()Ljava/util/Map;", "kTMPasteboardErrorCodeBpeaCheckError", "kTMPasteboardErrorCodeCertExpired", "kTMPasteboardErrorCodeDetectPatternFailed", "kTMPasteboardErrorCodeDisableAutoRead", "kTMPasteboardErrorCodeDisableRepeatReadByTimestamp", "kTMPasteboardErrorCodeDisableRepeatReadUseCache", "kTMPasteboardErrorCodeImageIntercept", "kTMPasteboardErrorCodeInBackground", "kTMPasteboardErrorCodeInBasicMode", "kTMPasteboardErrorCodeNoFocus", "kTMPasteboardErrorCodeNone", "kTMPasteboardErrorCodeNotAgreePrivacy", "kTMPasteboardErrorCodeNotContainDataType", "kTMPasteboardErrorCodeRepeatWrite", "kTMPasteboardErrorCodeRuleIntercept", "kTMPasteboardErrorCodeSuiteNotInit", "clipboard-suite_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CheckResultKt {
    public static final int kTMPasteboardErrorCodeNone = 0;
    public static final int kTMPasteboardErrorCodeRuleIntercept = -6011;
    public static final int kTMPasteboardErrorCodeCertExpired = -6000;
    public static final int kTMPasteboardErrorCodeNotContainDataType = -6001;
    public static final int kTMPasteboardErrorCodeNotAgreePrivacy = -6002;
    public static final int kTMPasteboardErrorCodeInBackground = -6003;
    public static final int kTMPasteboardErrorCodeDisableAutoRead = -6004;
    public static final int kTMPasteboardErrorCodeDetectPatternFailed = -6005;
    public static final int kTMPasteboardErrorCodeInBasicMode = -6006;
    public static final int kTMPasteboardErrorCodeNoFocus = -6007;
    public static final int kTMPasteboardErrorCodeBpeaCheckError = -6008;
    public static final int kTMPasteboardErrorCodeSuiteNotInit = -6009;
    public static final int kTMPasteboardErrorCodeRepeatWrite = -6010;
    public static final int kTMPasteboardErrorCodeDisableRepeatReadUseCache = -6012;
    public static final int kTMPasteboardErrorCodeDisableRepeatReadByTimestamp = -6013;
    public static final int kTMPasteboardErrorCodeImageIntercept = -6014;
    private static final Map<Integer, String> ERROR_CODE_TO_RULE_KEY = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, "NO_ERROR"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeCertExpired), "TM_Clipboard_Suite_CertExpired"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeNotContainDataType), "TM_Clipboard_Suite_disable_Clipboard_NoData"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeNotAgreePrivacy), "TM_Clipboard_Suite_disable_NotAgreePrivacy"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeInBackground), "TM_Clipboard_Suite_disable_InBackground"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeDisableAutoRead), "TM_Clipboard_Suite_disable_AutoRead"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeDetectPatternFailed), "TM_Clipboard_Suite_disable_PatternFailed"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeInBasicMode), "TM_Clipboard_Suite_disable_InBasicMode"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeNoFocus), "TM_Clipboard_Suite_disable_InNoFocus"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeBpeaCheckError), "TM_Clipboard_Suite_disable_BpeaCheckError"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeSuiteNotInit), "TM_Clipboard_Suite_disable_SuiteNotInit"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeRepeatWrite), "TM_Clipboard_Suite_RepeatWrite"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeDisableRepeatReadUseCache), "TM_Clipboard_Disable_Repeat_Read_Use_Cache"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeDisableRepeatReadByTimestamp), "TM_Clipboard_Disable_Repeat_Read_By_Timestamp"), TuplesKt.to(Integer.valueOf(kTMPasteboardErrorCodeImageIntercept), "TM_Clipboard_Disable_Read_Non_Text")});

    public static final Map<Integer, String> getERROR_CODE_TO_RULE_KEY() {
        return ERROR_CODE_TO_RULE_KEY;
    }
}
