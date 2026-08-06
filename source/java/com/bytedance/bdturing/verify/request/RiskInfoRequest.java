package com.bytedance.bdturing.verify.request;

import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.TuringVerifyType;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: RiskInfoRequest.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/bdturing/verify/request/RiskInfoRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "riskInfo", "", "(Ljava/lang/String;)V", "uid", "(Ljava/lang/String;Ljava/lang/String;)V", "value", "", "fullscreen", "getFullscreen", "()Z", "setFullscreen", "(Z)V", "innerRequest", "getInnerRequest", "()Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "setInnerRequest", "(Lcom/bytedance/bdturing/verify/request/AbstractRequest;)V", "mMaxEvents", "", "getRiskInfo", "()Ljava/lang/String;", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "cancelAble", "getEventLimits", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RiskInfoRequest extends AbstractRequest {
    private AbstractRequest innerRequest;
    private int mMaxEvents;
    private final String riskInfo;

    /* JADX WARN: Failed to find 'out' block for switch in B:149:0x0246. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0308 A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0300 A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02f4 A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02e8 A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02dc A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02d0 A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ed A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x02c5 A[Catch: Exception -> 0x03b6, TRY_ENTER, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0313 A[Catch: Exception -> 0x03b6, TryCatch #1 {Exception -> 0x03b6, blocks: (B:3:0x0017, B:6:0x0056, B:8:0x0093, B:17:0x00ed, B:18:0x02be, B:21:0x02c5, B:22:0x02cb, B:25:0x02d7, B:28:0x02e3, B:31:0x02ef, B:34:0x02fb, B:37:0x0303, B:40:0x030b, B:42:0x0313, B:55:0x032e, B:59:0x0338, B:63:0x0344, B:65:0x034b, B:69:0x0356, B:73:0x0361, B:75:0x0367, B:79:0x0371, B:83:0x037c, B:85:0x0382, B:89:0x038b, B:93:0x0396, B:95:0x039c, B:99:0x03a5, B:103:0x03b0, B:106:0x0308, B:107:0x0300, B:108:0x02f4, B:109:0x02e8, B:110:0x02dc, B:111:0x02d0, B:114:0x0102, B:116:0x0111, B:117:0x0121, B:120:0x0147, B:123:0x0151, B:124:0x016a, B:127:0x0174, B:128:0x017f, B:131:0x0189, B:132:0x0197, B:135:0x01a1, B:136:0x01af, B:138:0x01b8, B:141:0x01cc, B:144:0x021d, B:148:0x0242, B:149:0x0246, B:151:0x024b, B:154:0x02a1, B:155:0x0254, B:158:0x025d, B:161:0x026f, B:164:0x026c, B:165:0x027f, B:167:0x0287, B:168:0x0298, B:171:0x00a7, B:174:0x00b1, B:175:0x00c8, B:178:0x00d2, B:179:0x00df, B:181:0x02b4, B:185:0x0091, B:160:0x0264, B:183:0x0085), top: B:2:0x0017, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RiskInfoRequest(String str, String str2) {
        AbstractRequest abstractRequest;
        AbstractRequest abstractRequest2;
        AbstractRequest abstractRequest3;
        AbstractRequest abstractRequest4;
        AbstractRequest abstractRequest5;
        AbstractRequest abstractRequest6;
        AbstractRequest abstractRequest7;
        BdTuringConfig config;
        BdTuringConfig config2;
        BdTuringConfig config3;
        BdTuringConfig config4;
        BdTuringConfig config5;
        this.riskInfo = str2;
        this.mMaxEvents = BdTuringConfig.DEFAULT_EVENT_COUNT;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(ReportProtocal.KEY_LOG_ID);
            long optLong = jSONObject.optLong(AlogMonitor.ALOG_RESULT_CODE);
            String optString2 = jSONObject.optString("subtype");
            String optString3 = jSONObject.optString("region");
            String optString4 = jSONObject.optString("maxEVS");
            String optString5 = jSONObject.optString("verify_scene");
            Intrinsics.checkNotNullExpressionValue(optString5, "riskJson.optString(\"verify_scene\")");
            setVerifyScene(optString5);
            int i = 1;
            setH5PopUp(jSONObject.optInt("h5_popup", 0) == 1);
            String optString6 = jSONObject.optString("replay_data", "");
            Intrinsics.checkNotNullExpressionValue(optString6, "riskJson.optString(\"replay_data\", \"\")");
            setReplayData(optString6);
            String optString7 = jSONObject.optString("detail", "");
            Intrinsics.checkNotNullExpressionValue(optString7, "riskJson.optString(\"detail\", \"\")");
            setDecision_detail(optString7);
            setVerifyTypeCode(optLong);
            Intrinsics.checkNotNullExpressionValue(optString2, "subtype");
            setVerifySubType(optString2);
            if (!TextUtils.isEmpty(optString4)) {
                try {
                    Intrinsics.checkNotNullExpressionValue(optString4, "limitStr");
                    this.mMaxEvents = Integer.parseInt(optString4);
                } catch (Exception unused) {
                    this.mMaxEvents = BdTuringConfig.DEFAULT_EVENT_COUNT;
                }
            }
            int hashCode = optString2.hashCode();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (hashCode == -135762164) {
                if (optString2.equals(TuringVerifyType.IDENTIFY)) {
                    this.innerRequest = new IdentityRequest(null, null, 3, null);
                    abstractRequest = this.innerRequest;
                    if (abstractRequest != null) {
                    }
                    abstractRequest2 = this.innerRequest;
                    if (abstractRequest2 == null) {
                    }
                    abstractRequest3 = this.innerRequest;
                    if (abstractRequest3 == null) {
                    }
                    abstractRequest4 = this.innerRequest;
                    if (abstractRequest4 == null) {
                    }
                    abstractRequest5 = this.innerRequest;
                    if (abstractRequest5 == null) {
                    }
                    abstractRequest6 = this.innerRequest;
                    if (abstractRequest6 == null) {
                    }
                    abstractRequest7 = this.innerRequest;
                    if (abstractRequest7 == null) {
                    }
                    Intrinsics.checkNotNullExpressionValue(optString, "logId");
                    setLogId(optString);
                    if (optString3 == null) {
                    }
                }
                if (optLong != GWorker.INTERVAL) {
                }
                abstractRequest = this.innerRequest;
                if (abstractRequest != null) {
                }
                abstractRequest2 = this.innerRequest;
                if (abstractRequest2 == null) {
                }
                abstractRequest3 = this.innerRequest;
                if (abstractRequest3 == null) {
                }
                abstractRequest4 = this.innerRequest;
                if (abstractRequest4 == null) {
                }
                abstractRequest5 = this.innerRequest;
                if (abstractRequest5 == null) {
                }
                abstractRequest6 = this.innerRequest;
                if (abstractRequest6 == null) {
                }
                abstractRequest7 = this.innerRequest;
                if (abstractRequest7 == null) {
                }
                Intrinsics.checkNotNullExpressionValue(optString, "logId");
                setLogId(optString);
                if (optString3 == null) {
                }
            } else if (hashCode != 3600) {
                if (hashCode == 114009 && optString2.equals("sms")) {
                    this.innerRequest = new SmsRequest(null, false, str, 3, null);
                    abstractRequest = this.innerRequest;
                    if (abstractRequest != null) {
                        Intrinsics.checkNotNullExpressionValue(optString, "logId");
                        abstractRequest.setLogId(optString);
                    }
                    abstractRequest2 = this.innerRequest;
                    if (abstractRequest2 == null) {
                        abstractRequest2.setH5PopUp(getH5PopUp());
                    }
                    abstractRequest3 = this.innerRequest;
                    if (abstractRequest3 == null) {
                        abstractRequest3.setVerifyScene(getVerifyScene());
                    }
                    abstractRequest4 = this.innerRequest;
                    if (abstractRequest4 == null) {
                        abstractRequest4.setReplayData(getReplayData());
                    }
                    abstractRequest5 = this.innerRequest;
                    if (abstractRequest5 == null) {
                        abstractRequest5.setDecision_detail(getDecision_detail());
                    }
                    abstractRequest6 = this.innerRequest;
                    if (abstractRequest6 == null) {
                        abstractRequest6.setVerifyTypeCode(optLong);
                    }
                    abstractRequest7 = this.innerRequest;
                    if (abstractRequest7 == null) {
                        abstractRequest7.setVerifySubType(optString2);
                    }
                    Intrinsics.checkNotNullExpressionValue(optString, "logId");
                    setLogId(optString);
                    if (optString3 == null) {
                        int hashCode2 = optString3.hashCode();
                        if (hashCode2 == 3179) {
                            if (optString3.equals("cn") && (config = BdTuring.getInstance().getConfig()) != null) {
                                config.setRegionType(BdTuringConfig.RegionType.REGION_CN);
                                return;
                            }
                            return;
                        }
                        if (hashCode2 == 3365) {
                            if (optString3.equals("in") && (config2 = BdTuring.getInstance().getConfig()) != null) {
                                config2.setRegionType(BdTuringConfig.RegionType.REGION_INDIA);
                                return;
                            }
                            return;
                        }
                        if (hashCode2 == 3668) {
                            if (optString3.equals("sg") && (config3 = BdTuring.getInstance().getConfig()) != null) {
                                config3.setRegionType(BdTuringConfig.RegionType.REGION_SINGAPOER);
                                return;
                            }
                            return;
                        }
                        if (hashCode2 == 3755) {
                            if (optString3.equals("va") && (config4 = BdTuring.getInstance().getConfig()) != null) {
                                config4.setRegionType(BdTuringConfig.RegionType.REGION_USA_EAST);
                                return;
                            }
                            return;
                        }
                        if (hashCode2 == 97720 && optString3.equals("boe") && (config5 = BdTuring.getInstance().getConfig()) != null) {
                            config5.setRegionType(BdTuringConfig.RegionType.REGION_BOE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (optLong != GWorker.INTERVAL) {
                    if (optLong != TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS) {
                        if (optLong != 30000) {
                            if (optLong == 40000) {
                                switch (optString2.hashCode()) {
                                    case -520509031:
                                        if (!optString2.equals("nocaptcha")) {
                                            break;
                                        }
                                        String optString8 = jSONObject.optString("detail");
                                        Intrinsics.checkNotNullExpressionValue(optString8, "detailStr");
                                        this.innerRequest = new SenselessVerifyRequest(optString2, optString8);
                                        break;
                                    case 3322092:
                                        if (optString2.equals(TuringVerifyType.live)) {
                                            String optString9 = jSONObject.optString("detail", "");
                                            Intrinsics.checkNotNullExpressionValue(optString9, "riskJson.optString(\"detail\", \"\")");
                                            this.innerRequest = new LiveDetectRequest(optString9, optString2);
                                            break;
                                        }
                                        break;
                                    case 103149417:
                                        if (!optString2.equals(TuringVerifyType.login)) {
                                            break;
                                        } else {
                                            String optString10 = jSONObject.optString("toast", "");
                                            try {
                                                optString10 = URLDecoder.decode(optString10, UrlUtils.UTF_8);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            Intrinsics.checkNotNullExpressionValue(optString10, "toastContent");
                                            this.innerRequest = new LoginVerifyRequest(optString10);
                                            break;
                                        }
                                    case 1733167236:
                                        if (!optString2.equals(TuringVerifyType.nocaptcha_collect)) {
                                            break;
                                        }
                                        String optString82 = jSONObject.optString("detail");
                                        Intrinsics.checkNotNullExpressionValue(optString82, "detailStr");
                                        this.innerRequest = new SenselessVerifyRequest(optString2, optString82);
                                        break;
                                }
                            }
                        } else {
                            String optString11 = jSONObject.optString("identity_scene");
                            String optString12 = jSONObject.optString("flow");
                            Intrinsics.checkNotNullExpressionValue(optString12, "riskJson.optString(\"flow\")");
                            String optString13 = jSONObject.optString("identity_action");
                            Intrinsics.checkNotNullExpressionValue(optString13, "riskJson.optString(\"identity_action\")");
                            String optString14 = jSONObject.optString("detail", "");
                            Intrinsics.checkNotNullExpressionValue(optString14, "riskJson.optString(\"detail\", \"\")");
                            String optString15 = jSONObject.optString("identity_ticket", "");
                            Intrinsics.checkNotNullExpressionValue(optString15, "riskJson.optString(\"identity_ticket\", \"\")");
                            String optString16 = jSONObject.optString("subtype", "");
                            Intrinsics.checkNotNullExpressionValue(optString16, "riskJson.optString(\"subtype\", \"\")");
                            long optLong2 = jSONObject.optLong("aid", 0L);
                            boolean z = !jSONObject.optBoolean("identity_no_need_popups", false);
                            Intrinsics.checkNotNullExpressionValue(optString11, "identityScene");
                            this.innerRequest = new IdentityVerifyRequest(optLong2, optString11, optString12, optString13, optString14, optString15, z, optString16);
                        }
                    } else {
                        String optString17 = jSONObject.optString("mfa_decision", "");
                        if (TextUtils.isEmpty(optString17)) {
                            String optString18 = jSONObject.optString("verify_ticket");
                            String optString19 = jSONObject.optString("channel_mobile");
                            String optString20 = jSONObject.optString("sms_content");
                            String optString21 = jSONObject.optString("mobile");
                            switch (optString2.hashCode()) {
                                case -797498437:
                                    if (optString2.equals(TuringVerifyType.PWD_VERIFY)) {
                                        Intrinsics.checkNotNullExpressionValue(optString18, "verifyTicket");
                                        this.innerRequest = new PasswordRequest(optString18);
                                        break;
                                    }
                                    break;
                                case 300626556:
                                    if (!optString2.equals(TuringVerifyType.email_verify)) {
                                        break;
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(optString18, "verifyTicket");
                                        this.innerRequest = new EmailRequest(optString18);
                                        break;
                                    }
                                case 307350857:
                                    if (!optString2.equals(TuringVerifyType.mobile_voice_sms_verify)) {
                                        break;
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(optString18, "verifyTicket");
                                        this.innerRequest = new VoiceSmsRequest(optString18);
                                        break;
                                    }
                                case 312290780:
                                    if (!optString2.equals(TuringVerifyType.mobile_sms_verify)) {
                                        break;
                                    } else {
                                        this.innerRequest = new DownSmsRequest(optString18, optString21);
                                        break;
                                    }
                                case 705104230:
                                    if (!optString2.equals(TuringVerifyType.mobile_up_sms_verify)) {
                                        break;
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(optString18, "verifyTicket");
                                        Intrinsics.checkNotNullExpressionValue(optString19, "channelMobile");
                                        Intrinsics.checkNotNullExpressionValue(optString20, "smsContent");
                                        this.innerRequest = new UpSmsRequest(optString18, optString19, optString20);
                                        break;
                                    }
                            }
                        } else {
                            Intrinsics.checkNotNullExpressionValue(optString17, "mfaDecision");
                            this.innerRequest = new UCTwiceVerifyRequest(optString17, optString2);
                        }
                    }
                } else {
                    ImageRequest imageRequest = new ImageRequest(0, i, defaultConstructorMarker);
                    imageRequest.setSubType(optString2);
                    this.innerRequest = imageRequest;
                }
                abstractRequest = this.innerRequest;
                if (abstractRequest != null) {
                }
                abstractRequest2 = this.innerRequest;
                if (abstractRequest2 == null) {
                }
                abstractRequest3 = this.innerRequest;
                if (abstractRequest3 == null) {
                }
                abstractRequest4 = this.innerRequest;
                if (abstractRequest4 == null) {
                }
                abstractRequest5 = this.innerRequest;
                if (abstractRequest5 == null) {
                }
                abstractRequest6 = this.innerRequest;
                if (abstractRequest6 == null) {
                }
                abstractRequest7 = this.innerRequest;
                if (abstractRequest7 == null) {
                }
                Intrinsics.checkNotNullExpressionValue(optString, "logId");
                setLogId(optString);
                if (optString3 == null) {
                }
            } else if (optString2.equals("qa")) {
                this.innerRequest = new QaRequest(str);
                abstractRequest = this.innerRequest;
                if (abstractRequest != null) {
                }
                abstractRequest2 = this.innerRequest;
                if (abstractRequest2 == null) {
                }
                abstractRequest3 = this.innerRequest;
                if (abstractRequest3 == null) {
                }
                abstractRequest4 = this.innerRequest;
                if (abstractRequest4 == null) {
                }
                abstractRequest5 = this.innerRequest;
                if (abstractRequest5 == null) {
                }
                abstractRequest6 = this.innerRequest;
                if (abstractRequest6 == null) {
                }
                abstractRequest7 = this.innerRequest;
                if (abstractRequest7 == null) {
                }
                Intrinsics.checkNotNullExpressionValue(optString, "logId");
                setLogId(optString);
                if (optString3 == null) {
                }
            } else {
                if (optLong != GWorker.INTERVAL) {
                }
                abstractRequest = this.innerRequest;
                if (abstractRequest != null) {
                }
                abstractRequest2 = this.innerRequest;
                if (abstractRequest2 == null) {
                }
                abstractRequest3 = this.innerRequest;
                if (abstractRequest3 == null) {
                }
                abstractRequest4 = this.innerRequest;
                if (abstractRequest4 == null) {
                }
                abstractRequest5 = this.innerRequest;
                if (abstractRequest5 == null) {
                }
                abstractRequest6 = this.innerRequest;
                if (abstractRequest6 == null) {
                }
                abstractRequest7 = this.innerRequest;
                if (abstractRequest7 == null) {
                }
                Intrinsics.checkNotNullExpressionValue(optString, "logId");
                setLogId(optString);
                if (optString3 == null) {
                }
            }
        } catch (Exception e2) {
            LogUtil.printException(e2);
        }
        LogUtil.printException(e2);
    }

    public /* synthetic */ RiskInfoRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2);
    }

    public final String getRiskInfo() {
        return this.riskInfo;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RiskInfoRequest(String str) {
        this(null, str);
        Intrinsics.checkNotNullParameter(str, "riskInfo");
    }

    public final AbstractRequest getInnerRequest() {
        return this.innerRequest;
    }

    public final void setInnerRequest(AbstractRequest abstractRequest) {
        this.innerRequest = abstractRequest;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void setFullscreen(boolean z) {
        AbstractRequest abstractRequest = this.innerRequest;
        if (abstractRequest == null) {
            return;
        }
        abstractRequest.setFullscreen(z);
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public boolean getFullscreen() {
        AbstractRequest abstractRequest = this.innerRequest;
        if (abstractRequest != null) {
            return abstractRequest.getFullscreen();
        }
        return false;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        AbstractRequest abstractRequest = this.innerRequest;
        if (abstractRequest != null) {
            return abstractRequest.getType();
        }
        return 0;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    /* renamed from: getEventLimits, reason: from getter */
    public int getMMaxEvents() {
        return this.mMaxEvents;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        String verifyType;
        AbstractRequest abstractRequest = this.innerRequest;
        return (abstractRequest == null || (verifyType = abstractRequest.getVerifyType()) == null) ? "" : verifyType;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getServiceType() {
        String serviceType;
        AbstractRequest abstractRequest = this.innerRequest;
        return (abstractRequest == null || (serviceType = abstractRequest.getServiceType()) == null) ? "" : serviceType;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public boolean cancelAble() {
        AbstractRequest abstractRequest = this.innerRequest;
        if (abstractRequest != null) {
            return abstractRequest.cancelAble();
        }
        return true;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        AbstractRequest abstractRequest = this.innerRequest;
        if (abstractRequest != null) {
            abstractRequest.buildUrl(queryBuilder);
        }
        UtilsKt.appendParams(queryBuilder, "verify_data", this.riskInfo);
    }
}
