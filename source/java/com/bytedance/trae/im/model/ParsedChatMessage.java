package com.bytedance.trae.im.model;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.service.FastRequestEvent;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b\u0086\u0001\n\u0002\u0018\u0002\n\u0002\bA\b\u0086\b\u0018\u0000 \u0091\u00022\u00020\u0001:\u0002\u0091\u0002B\u0097\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0014\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0016\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0016\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010:\u001a\u00020\u0012\u0012\b\b\u0002\u0010;\u001a\u00020\u0012\u0012\b\b\u0002\u0010<\u001a\u00020\u0012\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J¢\u0006\u0004\bK\u0010LJ\n\u0010Ô\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010iJ\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010lJ\u0012\u0010á\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016HÆ\u0003J\f\u0010â\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010ã\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\f\u0010å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ê\u0001\u001a\u00020\u0014HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0012\u0010í\u0001\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0016HÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010iJ\f\u0010ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ò\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\f\u0010ó\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010õ\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010iJ\u0011\u0010ö\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010iJ\u0011\u0010÷\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010lJ\u0011\u0010ø\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010lJ\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0012\u0010ú\u0001\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0016HÆ\u0003J\f\u0010û\u0001\u001a\u0004\u0018\u000109HÆ\u0003J\n\u0010ü\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010ý\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010þ\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0003\u0010°\u0001J\f\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010GHÆ\u0003J\u0011\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010iJ\f\u0010\u008a\u0002\u001a\u0004\u0018\u00010JHÆ\u0003J¦\u0005\u0010\u008b\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00162\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00162\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u00122\b\b\u0002\u0010<\u001a\u00020\u00122\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010I\u001a\u0004\u0018\u00010JHÆ\u0001¢\u0006\u0003\u0010\u008c\u0002J\u0015\u0010\u008d\u0002\u001a\u00020\u00122\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u008f\u0002\u001a\u00020\u000bHÖ\u0001J\n\u0010\u0090\u0002\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010N\"\u0004\bR\u0010PR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010N\"\u0004\bV\u0010PR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010N\"\u0004\bX\u0010PR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010N\"\u0004\bZ\u0010PR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010NR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010N\"\u0004\ba\u0010PR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010j\u001a\u0004\bh\u0010iR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010o\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010cR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010N\"\u0004\bx\u0010PR \u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010N\"\u0004\bz\u0010PR \u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010N\"\u0004\b|\u0010PR \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010N\"\u0004\b~\u0010PR!\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010N\"\u0005\b\u0080\u0001\u0010PR\"\u0010\"\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010cR\u0019\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010cR\u001f\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010qR$\u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R%\u0010)\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0002\u0010j\u001a\u0005\b\u008c\u0001\u0010i\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010N\"\u0005\b\u0090\u0001\u0010PR\"\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010N\"\u0005\b\u0092\u0001\u0010PR\u001a\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010.\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\"\u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010N\"\u0005\b\u0098\u0001\u0010PR$\u00101\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010j\u001a\u0004\b1\u0010i\"\u0006\b\u0099\u0001\u0010\u008e\u0001R$\u00102\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010j\u001a\u0004\b2\u0010i\"\u0006\b\u009a\u0001\u0010\u008e\u0001R$\u00103\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010o\u001a\u0005\b\u009b\u0001\u0010l\"\u0005\b\u009c\u0001\u0010nR$\u00104\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010o\u001a\u0005\b\u009d\u0001\u0010l\"\u0005\b\u009e\u0001\u0010nR$\u00105\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001f\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b£\u0001\u0010qR$\u00108\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\u001d\u0010:\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b:\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010;\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b;\u0010¨\u0001\"\u0006\b«\u0001\u0010ª\u0001R\u001d\u0010<\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b<\u0010¨\u0001\"\u0006\b¬\u0001\u0010ª\u0001R\u001e\u0010=\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010N\"\u0005\b®\u0001\u0010PR#\u0010>\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010³\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R\u001e\u0010?\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010N\"\u0005\bµ\u0001\u0010PR\u001e\u0010@\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010N\"\u0005\b·\u0001\u0010PR\u001e\u0010A\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010N\"\u0005\b¹\u0001\u0010PR\u001e\u0010B\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010N\"\u0005\b»\u0001\u0010PR\u001e\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010N\"\u0005\b½\u0001\u0010PR\u001e\u0010D\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u0010N\"\u0005\b¿\u0001\u0010PR\u001e\u0010E\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010N\"\u0005\bÁ\u0001\u0010PR \u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R!\u0010H\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0013\n\u0002\u0010j\u001a\u0005\bÆ\u0001\u0010i\"\u0006\bÇ\u0001\u0010\u008e\u0001R \u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u0014\u0010Ì\u0001\u001a\u00020\u00128F¢\u0006\b\u001a\u0006\bÌ\u0001\u0010¨\u0001R\u0014\u0010Í\u0001\u001a\u00020\u00128F¢\u0006\b\u001a\u0006\bÍ\u0001\u0010¨\u0001R\u0015\u0010Î\u0001\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010NR\u0017\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00018F¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001¨\u0006\u0092\u0002"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedChatMessage;", "", "sessionId", "", "messageId", "taskIdUser", "turnId", PageDataManager.EXTRA_STATUS, "messageType", "role", "messageIndex", "", "replyToMessageId", "userMessageContext", "Lcom/google/gson/JsonObject;", "error", "Lcom/bytedance/trae/im/model/ParsedError;", "revertible", "", "versionCode", "", "references", "", "Lcom/bytedance/trae/im/model/Reference;", "contextMetadata", "searchReferenceData", "Lcom/bytedance/trae/im/model/SearchReferenceData;", "docReferences", "Lcom/bytedance/trae/im/model/DocReferencesData;", "agentType", "agentId", "agentName", "agentAvatarId", "traceId", "createdAt", "feeUsage", "maxFeeUsage", "notifications", "Lcom/bytedance/trae/im/model/NotificationPayload;", "modelSmartSelectionMeta", "Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;", "fromAppendMsg", "shallowMementoType", "chatProcessVersion", "tokenUsage", "Lcom/bytedance/trae/im/model/ParsedTokenUsage;", "contextUsage", "Lcom/bytedance/trae/im/model/ParsedContextUsage;", "agentProcessSupport", "isWorktree", "isUserCanceled", "chatStartTime", "chatEndTime", ReportConstant.COMMON_CONTENT, "query", "Lcom/bytedance/trae/im/model/MessagePart;", "fastRequestSavings", "Lcom/bytedance/trae/im/model/FastRequestSavings;", "isHistory", "isAppendMessage", "isInterjected", "streamingChatModel", "queuingPosition", "queuingMessage", "noticeTitle", "noticeMessage", "contentSecurityRuleName", "noticeType", "queueId", "requestUUID", "fastRequestEvent", "Lcom/bytedance/trae/im/service/FastRequestEvent;", "hasMetaData", "sourcePhase", "Lcom/bytedance/trae/im/model/MessageSourcePhase;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/trae/im/model/ParsedError;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Lcom/google/gson/JsonObject;Lcom/bytedance/trae/im/model/SearchReferenceData;Lcom/bytedance/trae/im/model/DocReferencesData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/util/List;Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedTokenUsage;Lcom/bytedance/trae/im/model/ParsedContextUsage;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Object;Ljava/util/List;Lcom/bytedance/trae/im/model/FastRequestSavings;ZZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/FastRequestEvent;Ljava/lang/Boolean;Lcom/bytedance/trae/im/model/MessageSourcePhase;)V", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getMessageId", "setMessageId", "getTaskIdUser", "setTaskIdUser", "getTurnId", "setTurnId", "getStatus", "setStatus", "getMessageType", "setMessageType", "getRole", "getMessageIndex", "()I", "setMessageIndex", "(I)V", "getReplyToMessageId", "setReplyToMessageId", "getUserMessageContext", "()Lcom/google/gson/JsonObject;", "getError", "()Lcom/bytedance/trae/im/model/ParsedError;", "setError", "(Lcom/bytedance/trae/im/model/ParsedError;)V", "getRevertible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVersionCode", "()Ljava/lang/Long;", "setVersionCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReferences", "()Ljava/util/List;", "getContextMetadata", "getSearchReferenceData", "()Lcom/bytedance/trae/im/model/SearchReferenceData;", "getDocReferences", "()Lcom/bytedance/trae/im/model/DocReferencesData;", "getAgentType", "setAgentType", "getAgentId", "setAgentId", "getAgentName", "setAgentName", "getAgentAvatarId", "setAgentAvatarId", "getTraceId", "setTraceId", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "getFeeUsage", "getMaxFeeUsage", "getNotifications", "getModelSmartSelectionMeta", "()Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;", "setModelSmartSelectionMeta", "(Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;)V", "getFromAppendMsg", "setFromAppendMsg", "(Ljava/lang/Boolean;)V", "getShallowMementoType", "setShallowMementoType", "getChatProcessVersion", "setChatProcessVersion", "getTokenUsage", "()Lcom/bytedance/trae/im/model/ParsedTokenUsage;", "getContextUsage", "()Lcom/bytedance/trae/im/model/ParsedContextUsage;", "getAgentProcessSupport", "setAgentProcessSupport", "setWorktree", "setUserCanceled", "getChatStartTime", "setChatStartTime", "getChatEndTime", "setChatEndTime", "getContent", "()Ljava/lang/Object;", "setContent", "(Ljava/lang/Object;)V", "getQuery", "getFastRequestSavings", "()Lcom/bytedance/trae/im/model/FastRequestSavings;", "setFastRequestSavings", "(Lcom/bytedance/trae/im/model/FastRequestSavings;)V", "()Z", "setHistory", "(Z)V", "setAppendMessage", "setInterjected", "getStreamingChatModel", "setStreamingChatModel", "getQueuingPosition", "()Ljava/lang/Integer;", "setQueuingPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQueuingMessage", "setQueuingMessage", "getNoticeTitle", "setNoticeTitle", "getNoticeMessage", "setNoticeMessage", "getContentSecurityRuleName", "setContentSecurityRuleName", "getNoticeType", "setNoticeType", "getQueueId", "setQueueId", "getRequestUUID", "setRequestUUID", "getFastRequestEvent", "()Lcom/bytedance/trae/im/service/FastRequestEvent;", "setFastRequestEvent", "(Lcom/bytedance/trae/im/service/FastRequestEvent;)V", "getHasMetaData", "setHasMetaData", "getSourcePhase", "()Lcom/bytedance/trae/im/model/MessageSourcePhase;", "setSourcePhase", "(Lcom/bytedance/trae/im/model/MessageSourcePhase;)V", "isUserMessage", "isAssistantMessage", "userContent", "getUserContent", "taskContent", "Lcom/bytedance/trae/im/model/ParsedTaskContent;", "getTaskContent", "()Lcom/bytedance/trae/im/model/ParsedTaskContent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/trae/im/model/ParsedError;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Lcom/google/gson/JsonObject;Lcom/bytedance/trae/im/model/SearchReferenceData;Lcom/bytedance/trae/im/model/DocReferencesData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/util/List;Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedTokenUsage;Lcom/bytedance/trae/im/model/ParsedContextUsage;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Object;Ljava/util/List;Lcom/bytedance/trae/im/model/FastRequestSavings;ZZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/FastRequestEvent;Ljava/lang/Boolean;Lcom/bytedance/trae/im/model/MessageSourcePhase;)Lcom/bytedance/trae/im/model/ParsedChatMessage;", "equals", "other", "hashCode", "toString", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ParsedChatMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NOTICE_CONTENT_FILTER_BLOCKED = "content_filter_blocked";
    public static final String NOTICE_CONTENT_FILTER_INPUT_DESENSITIZED = "content_filter_input_desensitized";
    public static final String NOTICE_CONTENT_FILTER_OUTPUT_DESENSITIZED = "content_filter_output_desensitized";
    public static final String ROLE_ASSISTANT = "assistant";
    public static final String ROLE_USER = "user";
    private static final long SECONDS_THRESHOLD = 10000000000L;

    @SerializedName("agent_avatar_id")
    private String agentAvatarId;

    @SerializedName("agent_id")
    private String agentId;

    @SerializedName("agent_name")
    private String agentName;

    @SerializedName("agent_process_support")
    private String agentProcessSupport;

    @SerializedName("agent_type")
    private String agentType;

    @SerializedName("chat_end_time")
    private Long chatEndTime;

    @SerializedName("chat_process_version")
    private String chatProcessVersion;

    @SerializedName("chat_start_time")
    private Long chatStartTime;

    @SerializedName(ReportConstant.COMMON_CONTENT)
    private Object content;
    private transient String contentSecurityRuleName;

    @SerializedName("context_metadata")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject contextMetadata;

    @SerializedName("context_usage")
    private final ParsedContextUsage contextUsage;

    @SerializedName("created_at")
    private long createdAt;

    @SerializedName("doc_references")
    private final DocReferencesData docReferences;

    @SerializedName("error")
    private ParsedError error;
    private transient FastRequestEvent fastRequestEvent;

    @SerializedName("fast_request_savings")
    private FastRequestSavings fastRequestSavings;

    @SerializedName("fee_usage")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject feeUsage;

    @SerializedName("from_append_msg")
    private Boolean fromAppendMsg;
    private transient Boolean hasMetaData;
    private transient boolean isAppendMessage;
    private transient boolean isHistory;
    private transient boolean isInterjected;

    @SerializedName("is_user_canceled")
    private Boolean isUserCanceled;

    @SerializedName("is_worktree")
    private Boolean isWorktree;

    @SerializedName("max_fee_usage")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject maxFeeUsage;

    @SerializedName("message_id")
    private String messageId;

    @SerializedName("message_index")
    private int messageIndex;

    @SerializedName("message_type")
    private String messageType;

    @SerializedName("model_smart_selection_meta")
    private ModelSmartSelectionMeta modelSmartSelectionMeta;
    private transient String noticeMessage;
    private transient String noticeTitle;
    private transient String noticeType;

    @SerializedName("notifications")
    private final List<NotificationPayload> notifications;

    @SerializedName("query")
    private final List<MessagePart> query;
    private transient String queueId;
    private transient String queuingMessage;
    private transient Integer queuingPosition;

    @SerializedName("references")
    private final List<Reference> references;

    @SerializedName("reply_to_message_id")
    private String replyToMessageId;
    private transient String requestUUID;

    @SerializedName("revertible")
    private final Boolean revertible;

    @SerializedName("role")
    private final String role;

    @SerializedName("search_reference_data")
    private final SearchReferenceData searchReferenceData;

    @SerializedName("session_id")
    private String sessionId;

    @SerializedName("shallow_memento_type")
    private String shallowMementoType;
    private transient MessageSourcePhase sourcePhase;

    @SerializedName(PageDataManager.EXTRA_STATUS)
    private String status;
    private transient String streamingChatModel;

    @SerializedName("task_id_user")
    private String taskIdUser;

    @SerializedName("token_usage")
    private final ParsedTokenUsage tokenUsage;

    @SerializedName("trace_id")
    private String traceId;

    @SerializedName("turn_id")
    private String turnId;

    @SerializedName("user_message_context")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject userMessageContext;

    @SerializedName("version_code")
    private Long versionCode;

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component10, reason: from getter */
    public final JsonObject getUserMessageContext() {
        return this.userMessageContext;
    }

    /* renamed from: component11, reason: from getter */
    public final ParsedError getError() {
        return this.error;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getRevertible() {
        return this.revertible;
    }

    /* renamed from: component13, reason: from getter */
    public final Long getVersionCode() {
        return this.versionCode;
    }

    public final List<Reference> component14() {
        return this.references;
    }

    /* renamed from: component15, reason: from getter */
    public final JsonObject getContextMetadata() {
        return this.contextMetadata;
    }

    /* renamed from: component16, reason: from getter */
    public final SearchReferenceData getSearchReferenceData() {
        return this.searchReferenceData;
    }

    /* renamed from: component17, reason: from getter */
    public final DocReferencesData getDocReferences() {
        return this.docReferences;
    }

    /* renamed from: component18, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    /* renamed from: component19, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component20, reason: from getter */
    public final String getAgentName() {
        return this.agentName;
    }

    /* renamed from: component21, reason: from getter */
    public final String getAgentAvatarId() {
        return this.agentAvatarId;
    }

    /* renamed from: component22, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component23, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component24, reason: from getter */
    public final JsonObject getFeeUsage() {
        return this.feeUsage;
    }

    /* renamed from: component25, reason: from getter */
    public final JsonObject getMaxFeeUsage() {
        return this.maxFeeUsage;
    }

    public final List<NotificationPayload> component26() {
        return this.notifications;
    }

    /* renamed from: component27, reason: from getter */
    public final ModelSmartSelectionMeta getModelSmartSelectionMeta() {
        return this.modelSmartSelectionMeta;
    }

    /* renamed from: component28, reason: from getter */
    public final Boolean getFromAppendMsg() {
        return this.fromAppendMsg;
    }

    /* renamed from: component29, reason: from getter */
    public final String getShallowMementoType() {
        return this.shallowMementoType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTaskIdUser() {
        return this.taskIdUser;
    }

    /* renamed from: component30, reason: from getter */
    public final String getChatProcessVersion() {
        return this.chatProcessVersion;
    }

    /* renamed from: component31, reason: from getter */
    public final ParsedTokenUsage getTokenUsage() {
        return this.tokenUsage;
    }

    /* renamed from: component32, reason: from getter */
    public final ParsedContextUsage getContextUsage() {
        return this.contextUsage;
    }

    /* renamed from: component33, reason: from getter */
    public final String getAgentProcessSupport() {
        return this.agentProcessSupport;
    }

    /* renamed from: component34, reason: from getter */
    public final Boolean getIsWorktree() {
        return this.isWorktree;
    }

    /* renamed from: component35, reason: from getter */
    public final Boolean getIsUserCanceled() {
        return this.isUserCanceled;
    }

    /* renamed from: component36, reason: from getter */
    public final Long getChatStartTime() {
        return this.chatStartTime;
    }

    /* renamed from: component37, reason: from getter */
    public final Long getChatEndTime() {
        return this.chatEndTime;
    }

    /* renamed from: component38, reason: from getter */
    public final Object getContent() {
        return this.content;
    }

    public final List<MessagePart> component39() {
        return this.query;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTurnId() {
        return this.turnId;
    }

    /* renamed from: component40, reason: from getter */
    public final FastRequestSavings getFastRequestSavings() {
        return this.fastRequestSavings;
    }

    /* renamed from: component41, reason: from getter */
    public final boolean getIsHistory() {
        return this.isHistory;
    }

    /* renamed from: component42, reason: from getter */
    public final boolean getIsAppendMessage() {
        return this.isAppendMessage;
    }

    /* renamed from: component43, reason: from getter */
    public final boolean getIsInterjected() {
        return this.isInterjected;
    }

    /* renamed from: component44, reason: from getter */
    public final String getStreamingChatModel() {
        return this.streamingChatModel;
    }

    /* renamed from: component45, reason: from getter */
    public final Integer getQueuingPosition() {
        return this.queuingPosition;
    }

    /* renamed from: component46, reason: from getter */
    public final String getQueuingMessage() {
        return this.queuingMessage;
    }

    /* renamed from: component47, reason: from getter */
    public final String getNoticeTitle() {
        return this.noticeTitle;
    }

    /* renamed from: component48, reason: from getter */
    public final String getNoticeMessage() {
        return this.noticeMessage;
    }

    /* renamed from: component49, reason: from getter */
    public final String getContentSecurityRuleName() {
        return this.contentSecurityRuleName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component50, reason: from getter */
    public final String getNoticeType() {
        return this.noticeType;
    }

    /* renamed from: component51, reason: from getter */
    public final String getQueueId() {
        return this.queueId;
    }

    /* renamed from: component52, reason: from getter */
    public final String getRequestUUID() {
        return this.requestUUID;
    }

    /* renamed from: component53, reason: from getter */
    public final FastRequestEvent getFastRequestEvent() {
        return this.fastRequestEvent;
    }

    /* renamed from: component54, reason: from getter */
    public final Boolean getHasMetaData() {
        return this.hasMetaData;
    }

    /* renamed from: component55, reason: from getter */
    public final MessageSourcePhase getSourcePhase() {
        return this.sourcePhase;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessageType() {
        return this.messageType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMessageIndex() {
        return this.messageIndex;
    }

    /* renamed from: component9, reason: from getter */
    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    public final ParsedChatMessage copy(String sessionId, String messageId, String taskIdUser, String turnId, String status, String messageType, String role, int messageIndex, String replyToMessageId, JsonObject userMessageContext, ParsedError error, Boolean revertible, Long versionCode, List<Reference> references, JsonObject contextMetadata, SearchReferenceData searchReferenceData, DocReferencesData docReferences, String agentType, String agentId, String agentName, String agentAvatarId, String traceId, long createdAt, JsonObject feeUsage, JsonObject maxFeeUsage, List<NotificationPayload> notifications, ModelSmartSelectionMeta modelSmartSelectionMeta, Boolean fromAppendMsg, String shallowMementoType, String chatProcessVersion, ParsedTokenUsage tokenUsage, ParsedContextUsage contextUsage, String agentProcessSupport, Boolean isWorktree, Boolean isUserCanceled, Long chatStartTime, Long chatEndTime, Object content, List<MessagePart> query, FastRequestSavings fastRequestSavings, boolean isHistory, boolean isAppendMessage, boolean isInterjected, String streamingChatModel, Integer queuingPosition, String queuingMessage, String noticeTitle, String noticeMessage, String contentSecurityRuleName, String noticeType, String queueId, String requestUUID, FastRequestEvent fastRequestEvent, Boolean hasMetaData, MessageSourcePhase sourcePhase) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(role, "role");
        return new ParsedChatMessage(sessionId, messageId, taskIdUser, turnId, status, messageType, role, messageIndex, replyToMessageId, userMessageContext, error, revertible, versionCode, references, contextMetadata, searchReferenceData, docReferences, agentType, agentId, agentName, agentAvatarId, traceId, createdAt, feeUsage, maxFeeUsage, notifications, modelSmartSelectionMeta, fromAppendMsg, shallowMementoType, chatProcessVersion, tokenUsage, contextUsage, agentProcessSupport, isWorktree, isUserCanceled, chatStartTime, chatEndTime, content, query, fastRequestSavings, isHistory, isAppendMessage, isInterjected, streamingChatModel, queuingPosition, queuingMessage, noticeTitle, noticeMessage, contentSecurityRuleName, noticeType, queueId, requestUUID, fastRequestEvent, hasMetaData, sourcePhase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedChatMessage)) {
            return false;
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) other;
        return Intrinsics.areEqual(this.sessionId, parsedChatMessage.sessionId) && Intrinsics.areEqual(this.messageId, parsedChatMessage.messageId) && Intrinsics.areEqual(this.taskIdUser, parsedChatMessage.taskIdUser) && Intrinsics.areEqual(this.turnId, parsedChatMessage.turnId) && Intrinsics.areEqual(this.status, parsedChatMessage.status) && Intrinsics.areEqual(this.messageType, parsedChatMessage.messageType) && Intrinsics.areEqual(this.role, parsedChatMessage.role) && this.messageIndex == parsedChatMessage.messageIndex && Intrinsics.areEqual(this.replyToMessageId, parsedChatMessage.replyToMessageId) && Intrinsics.areEqual(this.userMessageContext, parsedChatMessage.userMessageContext) && Intrinsics.areEqual(this.error, parsedChatMessage.error) && Intrinsics.areEqual(this.revertible, parsedChatMessage.revertible) && Intrinsics.areEqual(this.versionCode, parsedChatMessage.versionCode) && Intrinsics.areEqual(this.references, parsedChatMessage.references) && Intrinsics.areEqual(this.contextMetadata, parsedChatMessage.contextMetadata) && Intrinsics.areEqual(this.searchReferenceData, parsedChatMessage.searchReferenceData) && Intrinsics.areEqual(this.docReferences, parsedChatMessage.docReferences) && Intrinsics.areEqual(this.agentType, parsedChatMessage.agentType) && Intrinsics.areEqual(this.agentId, parsedChatMessage.agentId) && Intrinsics.areEqual(this.agentName, parsedChatMessage.agentName) && Intrinsics.areEqual(this.agentAvatarId, parsedChatMessage.agentAvatarId) && Intrinsics.areEqual(this.traceId, parsedChatMessage.traceId) && this.createdAt == parsedChatMessage.createdAt && Intrinsics.areEqual(this.feeUsage, parsedChatMessage.feeUsage) && Intrinsics.areEqual(this.maxFeeUsage, parsedChatMessage.maxFeeUsage) && Intrinsics.areEqual(this.notifications, parsedChatMessage.notifications) && Intrinsics.areEqual(this.modelSmartSelectionMeta, parsedChatMessage.modelSmartSelectionMeta) && Intrinsics.areEqual(this.fromAppendMsg, parsedChatMessage.fromAppendMsg) && Intrinsics.areEqual(this.shallowMementoType, parsedChatMessage.shallowMementoType) && Intrinsics.areEqual(this.chatProcessVersion, parsedChatMessage.chatProcessVersion) && Intrinsics.areEqual(this.tokenUsage, parsedChatMessage.tokenUsage) && Intrinsics.areEqual(this.contextUsage, parsedChatMessage.contextUsage) && Intrinsics.areEqual(this.agentProcessSupport, parsedChatMessage.agentProcessSupport) && Intrinsics.areEqual(this.isWorktree, parsedChatMessage.isWorktree) && Intrinsics.areEqual(this.isUserCanceled, parsedChatMessage.isUserCanceled) && Intrinsics.areEqual(this.chatStartTime, parsedChatMessage.chatStartTime) && Intrinsics.areEqual(this.chatEndTime, parsedChatMessage.chatEndTime) && Intrinsics.areEqual(this.content, parsedChatMessage.content) && Intrinsics.areEqual(this.query, parsedChatMessage.query) && Intrinsics.areEqual(this.fastRequestSavings, parsedChatMessage.fastRequestSavings) && this.isHistory == parsedChatMessage.isHistory && this.isAppendMessage == parsedChatMessage.isAppendMessage && this.isInterjected == parsedChatMessage.isInterjected && Intrinsics.areEqual(this.streamingChatModel, parsedChatMessage.streamingChatModel) && Intrinsics.areEqual(this.queuingPosition, parsedChatMessage.queuingPosition) && Intrinsics.areEqual(this.queuingMessage, parsedChatMessage.queuingMessage) && Intrinsics.areEqual(this.noticeTitle, parsedChatMessage.noticeTitle) && Intrinsics.areEqual(this.noticeMessage, parsedChatMessage.noticeMessage) && Intrinsics.areEqual(this.contentSecurityRuleName, parsedChatMessage.contentSecurityRuleName) && Intrinsics.areEqual(this.noticeType, parsedChatMessage.noticeType) && Intrinsics.areEqual(this.queueId, parsedChatMessage.queueId) && Intrinsics.areEqual(this.requestUUID, parsedChatMessage.requestUUID) && Intrinsics.areEqual(this.fastRequestEvent, parsedChatMessage.fastRequestEvent) && Intrinsics.areEqual(this.hasMetaData, parsedChatMessage.hasMetaData) && this.sourcePhase == parsedChatMessage.sourcePhase;
    }

    public int hashCode() {
        int hashCode = ((this.sessionId.hashCode() * 31) + this.messageId.hashCode()) * 31;
        String str = this.taskIdUser;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.turnId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.messageType;
        int hashCode5 = (((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.role.hashCode()) * 31) + Integer.hashCode(this.messageIndex)) * 31;
        String str5 = this.replyToMessageId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        JsonObject jsonObject = this.userMessageContext;
        int hashCode7 = (hashCode6 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        ParsedError parsedError = this.error;
        int hashCode8 = (hashCode7 + (parsedError == null ? 0 : parsedError.hashCode())) * 31;
        Boolean bool = this.revertible;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l = this.versionCode;
        int hashCode10 = (hashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        List<Reference> list = this.references;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        JsonObject jsonObject2 = this.contextMetadata;
        int hashCode12 = (hashCode11 + (jsonObject2 == null ? 0 : jsonObject2.hashCode())) * 31;
        SearchReferenceData searchReferenceData = this.searchReferenceData;
        int hashCode13 = (hashCode12 + (searchReferenceData == null ? 0 : searchReferenceData.hashCode())) * 31;
        DocReferencesData docReferencesData = this.docReferences;
        int hashCode14 = (hashCode13 + (docReferencesData == null ? 0 : docReferencesData.hashCode())) * 31;
        String str6 = this.agentType;
        int hashCode15 = (hashCode14 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.agentId;
        int hashCode16 = (hashCode15 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.agentName;
        int hashCode17 = (hashCode16 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.agentAvatarId;
        int hashCode18 = (hashCode17 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.traceId;
        int hashCode19 = (((hashCode18 + (str10 == null ? 0 : str10.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31;
        JsonObject jsonObject3 = this.feeUsage;
        int hashCode20 = (hashCode19 + (jsonObject3 == null ? 0 : jsonObject3.hashCode())) * 31;
        JsonObject jsonObject4 = this.maxFeeUsage;
        int hashCode21 = (hashCode20 + (jsonObject4 == null ? 0 : jsonObject4.hashCode())) * 31;
        List<NotificationPayload> list2 = this.notifications;
        int hashCode22 = (hashCode21 + (list2 == null ? 0 : list2.hashCode())) * 31;
        ModelSmartSelectionMeta modelSmartSelectionMeta = this.modelSmartSelectionMeta;
        int hashCode23 = (hashCode22 + (modelSmartSelectionMeta == null ? 0 : modelSmartSelectionMeta.hashCode())) * 31;
        Boolean bool2 = this.fromAppendMsg;
        int hashCode24 = (hashCode23 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str11 = this.shallowMementoType;
        int hashCode25 = (hashCode24 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.chatProcessVersion;
        int hashCode26 = (hashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
        ParsedTokenUsage parsedTokenUsage = this.tokenUsage;
        int hashCode27 = (hashCode26 + (parsedTokenUsage == null ? 0 : parsedTokenUsage.hashCode())) * 31;
        ParsedContextUsage parsedContextUsage = this.contextUsage;
        int hashCode28 = (hashCode27 + (parsedContextUsage == null ? 0 : parsedContextUsage.hashCode())) * 31;
        String str13 = this.agentProcessSupport;
        int hashCode29 = (hashCode28 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Boolean bool3 = this.isWorktree;
        int hashCode30 = (hashCode29 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isUserCanceled;
        int hashCode31 = (hashCode30 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Long l2 = this.chatStartTime;
        int hashCode32 = (hashCode31 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.chatEndTime;
        int hashCode33 = (hashCode32 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Object obj = this.content;
        int hashCode34 = (hashCode33 + (obj == null ? 0 : obj.hashCode())) * 31;
        List<MessagePart> list3 = this.query;
        int hashCode35 = (hashCode34 + (list3 == null ? 0 : list3.hashCode())) * 31;
        FastRequestSavings fastRequestSavings = this.fastRequestSavings;
        int hashCode36 = (((((((hashCode35 + (fastRequestSavings == null ? 0 : fastRequestSavings.hashCode())) * 31) + Boolean.hashCode(this.isHistory)) * 31) + Boolean.hashCode(this.isAppendMessage)) * 31) + Boolean.hashCode(this.isInterjected)) * 31;
        String str14 = this.streamingChatModel;
        int hashCode37 = (hashCode36 + (str14 == null ? 0 : str14.hashCode())) * 31;
        Integer num = this.queuingPosition;
        int hashCode38 = (hashCode37 + (num == null ? 0 : num.hashCode())) * 31;
        String str15 = this.queuingMessage;
        int hashCode39 = (hashCode38 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.noticeTitle;
        int hashCode40 = (hashCode39 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.noticeMessage;
        int hashCode41 = (hashCode40 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.contentSecurityRuleName;
        int hashCode42 = (hashCode41 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.noticeType;
        int hashCode43 = (hashCode42 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.queueId;
        int hashCode44 = (hashCode43 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.requestUUID;
        int hashCode45 = (hashCode44 + (str21 == null ? 0 : str21.hashCode())) * 31;
        FastRequestEvent fastRequestEvent = this.fastRequestEvent;
        int hashCode46 = (hashCode45 + (fastRequestEvent == null ? 0 : fastRequestEvent.hashCode())) * 31;
        Boolean bool5 = this.hasMetaData;
        int hashCode47 = (hashCode46 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        MessageSourcePhase messageSourcePhase = this.sourcePhase;
        return hashCode47 + (messageSourcePhase != null ? messageSourcePhase.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParsedChatMessage(sessionId=");
        sb.append(this.sessionId).append(", messageId=").append(this.messageId).append(", taskIdUser=").append(this.taskIdUser).append(", turnId=").append(this.turnId).append(", status=").append(this.status).append(", messageType=").append(this.messageType).append(", role=").append(this.role).append(", messageIndex=").append(this.messageIndex).append(", replyToMessageId=").append(this.replyToMessageId).append(", userMessageContext=").append(this.userMessageContext).append(", error=").append(this.error).append(", revertible=");
        sb.append(this.revertible).append(", versionCode=").append(this.versionCode).append(", references=").append(this.references).append(", contextMetadata=").append(this.contextMetadata).append(", searchReferenceData=").append(this.searchReferenceData).append(", docReferences=").append(this.docReferences).append(", agentType=").append(this.agentType).append(", agentId=").append(this.agentId).append(", agentName=").append(this.agentName).append(", agentAvatarId=").append(this.agentAvatarId).append(", traceId=").append(this.traceId).append(", createdAt=").append(this.createdAt);
        sb.append(", feeUsage=").append(this.feeUsage).append(", maxFeeUsage=").append(this.maxFeeUsage).append(", notifications=").append(this.notifications).append(", modelSmartSelectionMeta=").append(this.modelSmartSelectionMeta).append(", fromAppendMsg=").append(this.fromAppendMsg).append(", shallowMementoType=").append(this.shallowMementoType).append(", chatProcessVersion=").append(this.chatProcessVersion).append(", tokenUsage=").append(this.tokenUsage).append(", contextUsage=").append(this.contextUsage).append(", agentProcessSupport=").append(this.agentProcessSupport).append(", isWorktree=").append(this.isWorktree).append(", isUserCanceled=");
        sb.append(this.isUserCanceled).append(", chatStartTime=").append(this.chatStartTime).append(", chatEndTime=").append(this.chatEndTime).append(", content=").append(this.content).append(", query=").append(this.query).append(", fastRequestSavings=").append(this.fastRequestSavings).append(", isHistory=").append(this.isHistory).append(", isAppendMessage=").append(this.isAppendMessage).append(", isInterjected=").append(this.isInterjected).append(", streamingChatModel=").append(this.streamingChatModel).append(", queuingPosition=").append(this.queuingPosition).append(", queuingMessage=").append(this.queuingMessage);
        sb.append(", noticeTitle=").append(this.noticeTitle).append(", noticeMessage=").append(this.noticeMessage).append(", contentSecurityRuleName=").append(this.contentSecurityRuleName).append(", noticeType=").append(this.noticeType).append(", queueId=").append(this.queueId).append(", requestUUID=").append(this.requestUUID).append(", fastRequestEvent=").append(this.fastRequestEvent).append(", hasMetaData=").append(this.hasMetaData).append(", sourcePhase=").append(this.sourcePhase).append(')');
        return sb.toString();
    }

    public ParsedChatMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, JsonObject jsonObject, ParsedError parsedError, Boolean bool, Long l, List<Reference> list, JsonObject jsonObject2, SearchReferenceData searchReferenceData, DocReferencesData docReferencesData, String str9, String str10, String str11, String str12, String str13, long j, JsonObject jsonObject3, JsonObject jsonObject4, List<NotificationPayload> list2, ModelSmartSelectionMeta modelSmartSelectionMeta, Boolean bool2, String str14, String str15, ParsedTokenUsage parsedTokenUsage, ParsedContextUsage parsedContextUsage, String str16, Boolean bool3, Boolean bool4, Long l2, Long l3, Object obj, List<MessagePart> list3, FastRequestSavings fastRequestSavings, boolean z, boolean z2, boolean z3, String str17, Integer num, String str18, String str19, String str20, String str21, String str22, String str23, String str24, FastRequestEvent fastRequestEvent, Boolean bool5, MessageSourcePhase messageSourcePhase) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        Intrinsics.checkNotNullParameter(str7, "role");
        this.sessionId = str;
        this.messageId = str2;
        this.taskIdUser = str3;
        this.turnId = str4;
        this.status = str5;
        this.messageType = str6;
        this.role = str7;
        this.messageIndex = i;
        this.replyToMessageId = str8;
        this.userMessageContext = jsonObject;
        this.error = parsedError;
        this.revertible = bool;
        this.versionCode = l;
        this.references = list;
        this.contextMetadata = jsonObject2;
        this.searchReferenceData = searchReferenceData;
        this.docReferences = docReferencesData;
        this.agentType = str9;
        this.agentId = str10;
        this.agentName = str11;
        this.agentAvatarId = str12;
        this.traceId = str13;
        this.createdAt = j;
        this.feeUsage = jsonObject3;
        this.maxFeeUsage = jsonObject4;
        this.notifications = list2;
        this.modelSmartSelectionMeta = modelSmartSelectionMeta;
        this.fromAppendMsg = bool2;
        this.shallowMementoType = str14;
        this.chatProcessVersion = str15;
        this.tokenUsage = parsedTokenUsage;
        this.contextUsage = parsedContextUsage;
        this.agentProcessSupport = str16;
        this.isWorktree = bool3;
        this.isUserCanceled = bool4;
        this.chatStartTime = l2;
        this.chatEndTime = l3;
        this.content = obj;
        this.query = list3;
        this.fastRequestSavings = fastRequestSavings;
        this.isHistory = z;
        this.isAppendMessage = z2;
        this.isInterjected = z3;
        this.streamingChatModel = str17;
        this.queuingPosition = num;
        this.queuingMessage = str18;
        this.noticeTitle = str19;
        this.noticeMessage = str20;
        this.contentSecurityRuleName = str21;
        this.noticeType = str22;
        this.queueId = str23;
        this.requestUUID = str24;
        this.fastRequestEvent = fastRequestEvent;
        this.hasMetaData = bool5;
        this.sourcePhase = messageSourcePhase;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.messageId = str;
    }

    public final String getTaskIdUser() {
        return this.taskIdUser;
    }

    public final void setTaskIdUser(String str) {
        this.taskIdUser = str;
    }

    public final String getTurnId() {
        return this.turnId;
    }

    public final void setTurnId(String str) {
        this.turnId = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final void setMessageType(String str) {
        this.messageType = str;
    }

    public final String getRole() {
        return this.role;
    }

    public final int getMessageIndex() {
        return this.messageIndex;
    }

    public final void setMessageIndex(int i) {
        this.messageIndex = i;
    }

    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    public final void setReplyToMessageId(String str) {
        this.replyToMessageId = str;
    }

    public final JsonObject getUserMessageContext() {
        return this.userMessageContext;
    }

    public final ParsedError getError() {
        return this.error;
    }

    public final void setError(ParsedError parsedError) {
        this.error = parsedError;
    }

    public final Boolean getRevertible() {
        return this.revertible;
    }

    public final Long getVersionCode() {
        return this.versionCode;
    }

    public final void setVersionCode(Long l) {
        this.versionCode = l;
    }

    public final List<Reference> getReferences() {
        return this.references;
    }

    public final JsonObject getContextMetadata() {
        return this.contextMetadata;
    }

    public final SearchReferenceData getSearchReferenceData() {
        return this.searchReferenceData;
    }

    public final DocReferencesData getDocReferences() {
        return this.docReferences;
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final void setAgentType(String str) {
        this.agentType = str;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final void setAgentId(String str) {
        this.agentId = str;
    }

    public final String getAgentName() {
        return this.agentName;
    }

    public final void setAgentName(String str) {
        this.agentName = str;
    }

    public final String getAgentAvatarId() {
        return this.agentAvatarId;
    }

    public final void setAgentAvatarId(String str) {
        this.agentAvatarId = str;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    public /* synthetic */ ParsedChatMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, JsonObject jsonObject, ParsedError parsedError, Boolean bool, Long l, List list, JsonObject jsonObject2, SearchReferenceData searchReferenceData, DocReferencesData docReferencesData, String str9, String str10, String str11, String str12, String str13, long j, JsonObject jsonObject3, JsonObject jsonObject4, List list2, ModelSmartSelectionMeta modelSmartSelectionMeta, Boolean bool2, String str14, String str15, ParsedTokenUsage parsedTokenUsage, ParsedContextUsage parsedContextUsage, String str16, Boolean bool3, Boolean bool4, Long l2, Long l3, Object obj, List list3, FastRequestSavings fastRequestSavings, boolean z, boolean z2, boolean z3, String str17, Integer num, String str18, String str19, String str20, String str21, String str22, String str23, String str24, FastRequestEvent fastRequestEvent, Boolean bool5, MessageSourcePhase messageSourcePhase, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, str7, (i2 & 128) != 0 ? 0 : i, (i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str8, (i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : jsonObject, (i2 & 1024) != 0 ? null : parsedError, (i2 & 2048) != 0 ? null : bool, (i2 & 4096) != 0 ? null : l, (i2 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? null : list, (i2 & 16384) != 0 ? null : jsonObject2, (i2 & 32768) != 0 ? null : searchReferenceData, (i2 & 65536) != 0 ? null : docReferencesData, (i2 & 131072) != 0 ? null : str9, (i2 & 262144) != 0 ? null : str10, (i2 & FConstants.SLICE_SIZE) != 0 ? null : str11, (i2 & 1048576) != 0 ? null : str12, (i2 & 2097152) != 0 ? null : str13, (i2 & 4194304) != 0 ? System.currentTimeMillis() : j, (i2 & 8388608) != 0 ? null : jsonObject3, (i2 & 16777216) != 0 ? null : jsonObject4, (i2 & 33554432) != 0 ? null : list2, (i2 & 67108864) != 0 ? null : modelSmartSelectionMeta, (i2 & 134217728) != 0 ? null : bool2, (i2 & 268435456) != 0 ? null : str14, (i2 & 536870912) != 0 ? null : str15, (i2 & 1073741824) != 0 ? null : parsedTokenUsage, (i2 & Integer.MIN_VALUE) != 0 ? null : parsedContextUsage, (i3 & 1) != 0 ? null : str16, (i3 & 2) != 0 ? null : bool3, (i3 & 4) != 0 ? null : bool4, (i3 & 8) != 0 ? null : l2, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? null : obj, (i3 & 64) != 0 ? null : list3, (i3 & 128) != 0 ? null : fastRequestSavings, (i3 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? true : z, (i3 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? false : z2, (i3 & 1024) != 0 ? false : z3, (i3 & 2048) != 0 ? null : str17, (i3 & 4096) != 0 ? null : num, (i3 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? null : str18, (i3 & 16384) != 0 ? null : str19, (32768 & i3) != 0 ? null : str20, (i3 & 65536) != 0 ? null : str21, (i3 & 131072) != 0 ? null : str22, (i3 & 262144) != 0 ? null : str23, (i3 & FConstants.SLICE_SIZE) != 0 ? null : str24, (i3 & 1048576) != 0 ? null : fastRequestEvent, (i3 & 2097152) != 0 ? null : bool5, (i3 & 4194304) != 0 ? MessageSourcePhase.FETCHED : messageSourcePhase);
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public final JsonObject getFeeUsage() {
        return this.feeUsage;
    }

    public final JsonObject getMaxFeeUsage() {
        return this.maxFeeUsage;
    }

    public final List<NotificationPayload> getNotifications() {
        return this.notifications;
    }

    public final ModelSmartSelectionMeta getModelSmartSelectionMeta() {
        return this.modelSmartSelectionMeta;
    }

    public final void setModelSmartSelectionMeta(ModelSmartSelectionMeta modelSmartSelectionMeta) {
        this.modelSmartSelectionMeta = modelSmartSelectionMeta;
    }

    public final Boolean getFromAppendMsg() {
        return this.fromAppendMsg;
    }

    public final void setFromAppendMsg(Boolean bool) {
        this.fromAppendMsg = bool;
    }

    public final String getShallowMementoType() {
        return this.shallowMementoType;
    }

    public final void setShallowMementoType(String str) {
        this.shallowMementoType = str;
    }

    public final String getChatProcessVersion() {
        return this.chatProcessVersion;
    }

    public final void setChatProcessVersion(String str) {
        this.chatProcessVersion = str;
    }

    public final ParsedTokenUsage getTokenUsage() {
        return this.tokenUsage;
    }

    public final ParsedContextUsage getContextUsage() {
        return this.contextUsage;
    }

    public final String getAgentProcessSupport() {
        return this.agentProcessSupport;
    }

    public final void setAgentProcessSupport(String str) {
        this.agentProcessSupport = str;
    }

    public final Boolean isWorktree() {
        return this.isWorktree;
    }

    public final void setWorktree(Boolean bool) {
        this.isWorktree = bool;
    }

    public final Boolean isUserCanceled() {
        return this.isUserCanceled;
    }

    public final void setUserCanceled(Boolean bool) {
        this.isUserCanceled = bool;
    }

    public final Long getChatStartTime() {
        return this.chatStartTime;
    }

    public final void setChatStartTime(Long l) {
        this.chatStartTime = l;
    }

    public final Long getChatEndTime() {
        return this.chatEndTime;
    }

    public final void setChatEndTime(Long l) {
        this.chatEndTime = l;
    }

    public final Object getContent() {
        return this.content;
    }

    public final void setContent(Object obj) {
        this.content = obj;
    }

    public final List<MessagePart> getQuery() {
        return this.query;
    }

    public final FastRequestSavings getFastRequestSavings() {
        return this.fastRequestSavings;
    }

    public final void setFastRequestSavings(FastRequestSavings fastRequestSavings) {
        this.fastRequestSavings = fastRequestSavings;
    }

    public final boolean isHistory() {
        return this.isHistory;
    }

    public final void setHistory(boolean z) {
        this.isHistory = z;
    }

    public final boolean isAppendMessage() {
        return this.isAppendMessage;
    }

    public final void setAppendMessage(boolean z) {
        this.isAppendMessage = z;
    }

    public final boolean isInterjected() {
        return this.isInterjected;
    }

    public final void setInterjected(boolean z) {
        this.isInterjected = z;
    }

    public final String getStreamingChatModel() {
        return this.streamingChatModel;
    }

    public final void setStreamingChatModel(String str) {
        this.streamingChatModel = str;
    }

    public final Integer getQueuingPosition() {
        return this.queuingPosition;
    }

    public final void setQueuingPosition(Integer num) {
        this.queuingPosition = num;
    }

    public final String getQueuingMessage() {
        return this.queuingMessage;
    }

    public final void setQueuingMessage(String str) {
        this.queuingMessage = str;
    }

    public final String getNoticeTitle() {
        return this.noticeTitle;
    }

    public final void setNoticeTitle(String str) {
        this.noticeTitle = str;
    }

    public final String getNoticeMessage() {
        return this.noticeMessage;
    }

    public final void setNoticeMessage(String str) {
        this.noticeMessage = str;
    }

    public final String getContentSecurityRuleName() {
        return this.contentSecurityRuleName;
    }

    public final void setContentSecurityRuleName(String str) {
        this.contentSecurityRuleName = str;
    }

    public final String getNoticeType() {
        return this.noticeType;
    }

    public final void setNoticeType(String str) {
        this.noticeType = str;
    }

    public final String getQueueId() {
        return this.queueId;
    }

    public final void setQueueId(String str) {
        this.queueId = str;
    }

    public final String getRequestUUID() {
        return this.requestUUID;
    }

    public final void setRequestUUID(String str) {
        this.requestUUID = str;
    }

    public final FastRequestEvent getFastRequestEvent() {
        return this.fastRequestEvent;
    }

    public final void setFastRequestEvent(FastRequestEvent fastRequestEvent) {
        this.fastRequestEvent = fastRequestEvent;
    }

    public final Boolean getHasMetaData() {
        return this.hasMetaData;
    }

    public final void setHasMetaData(Boolean bool) {
        this.hasMetaData = bool;
    }

    public final MessageSourcePhase getSourcePhase() {
        return this.sourcePhase;
    }

    public final void setSourcePhase(MessageSourcePhase messageSourcePhase) {
        this.sourcePhase = messageSourcePhase;
    }

    public final boolean isUserMessage() {
        return Intrinsics.areEqual(this.role, ROLE_USER);
    }

    public final boolean isAssistantMessage() {
        return Intrinsics.areEqual(this.role, ROLE_ASSISTANT);
    }

    public final String getUserContent() {
        if (!isUserMessage()) {
            return null;
        }
        Object obj = this.content;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final ParsedTaskContent getTaskContent() {
        if (!isAssistantMessage()) {
            return null;
        }
        Object obj = this.content;
        if (obj instanceof ParsedTaskContent) {
            return (ParsedTaskContent) obj;
        }
        return null;
    }

    /* compiled from: ParsedChatMessage.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;", "", "<init>", "()V", "ROLE_USER", "", "ROLE_ASSISTANT", "NOTICE_CONTENT_FILTER_INPUT_DESENSITIZED", "NOTICE_CONTENT_FILTER_OUTPUT_DESENSITIZED", "NOTICE_CONTENT_FILTER_BLOCKED", "SECONDS_THRESHOLD", "", "normalizeToMillis", ReportConstant.COMMON_TIMESTAMP, "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long normalizeToMillis(long timestamp) {
            boolean z = false;
            if (1 <= timestamp && timestamp < ParsedChatMessage.SECONDS_THRESHOLD) {
                z = true;
            }
            return z ? timestamp * 1000 : timestamp;
        }

        private Companion() {
        }
    }
}
