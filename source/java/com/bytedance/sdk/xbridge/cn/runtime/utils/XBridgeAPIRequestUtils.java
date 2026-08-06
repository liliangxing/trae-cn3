package com.bytedance.sdk.xbridge.cn.runtime.utils;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.ISecurityContext;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.network.AbsStringConnection;
import com.bytedance.sdk.xbridge.cn.runtime.network.HttpRequest;
import com.bytedance.sdk.xbridge.cn.runtime.network.HttpUrlBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XBridgeAPIRequestUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010J<\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JP\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JF\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007J`\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\u0006\u0010\u001a\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020%JL\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\u0006\u0010\u001a\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J8\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010J<\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JP\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JF\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007J,\u0010*\u001a\u00020\u00042\"\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"H\u0002J\u001a\u0010,\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002Jc\u0010/\u001a\u00020\u00142\b\u00100\u001a\u0004\u0018\u00010\u00072&\u00101\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\"2\b\u00102\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u00106JU\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010\u00042\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\b\u00109\u001a\u0004\u0018\u00010\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010:JU\u0010;\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010\u00042\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\b\u00109\u001a\u0004\u0018\u00010\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010:J\u0098\u0001\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\"\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>0!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>`\"2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007J\u008e\u0001\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\"\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>0!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>`\"2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JL\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J`\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JV\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JL\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001a\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0014JV\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001a\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u0014JL\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J`\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JV\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JL\u0010C\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J`\u0010C\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007JV\u0010C\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0007J\u0010\u0010D\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010\u0001J.\u0010F\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\u0006\u0010G\u001a\u00020HJ0\u0010F\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\b\u0010I\u001a\u0004\u0018\u00010JJ.\u0010F\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\u0006\u0010K\u001a\u00020LJ8\u0010M\u001a\u00020\u0017*\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\"2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/utils/XBridgeAPIRequestUtils;", "", "()V", "CONTENT_TYPE", "", "CONTENT_TYPE_JSON", "ERROR_CODE_408", "", "REQUEST_ID_KEY", "REQUEST_TAG_FROM", "TAG", "kotlin.jvm.PlatformType", "X_TT_LOG_ID", "addParametersToUrl", IWeixinService.ResponseConstants.URL, "params", "", DBData.FIELD_TYPE, "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "addCommonParams", "", "convertParamValueToString", "delete", "", "targetUrl", "headers", "callback", "Lcom/bytedance/sdk/xbridge/cn/runtime/utils/IResponseCallback;", "hostNetworkDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "isCustomizedCookie", "maxLength", "doGetForStream", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Lcom/bytedance/sdk/xbridge/cn/runtime/utils/IStreamResponseCallback;", "timeOut", "", "downloadFile", "filterHeaderEmptyValue", "header", ApiRequest.METHOD_GET, "getRequestLogId", "responseHeader", "handleConnection", "connection", "Lcom/bytedance/sdk/xbridge/cn/runtime/network/AbsStringConnection;", "handleError", AccountMonitorConstants.CommonParameter.ERROR, "respHeader", "errorMsg", "throwable", "", "clientCode", "(Ljava/lang/Integer;Ljava/util/LinkedHashMap;Ljava/lang/String;Ljava/lang/Throwable;ILcom/bytedance/sdk/xbridge/cn/runtime/utils/IResponseCallback;)Z", "handleSuccess", "body", "respCode", "(Ljava/lang/String;Ljava/util/LinkedHashMap;Ljava/lang/Integer;ILcom/bytedance/sdk/xbridge/cn/runtime/utils/IResponseCallback;)V", "handleSuccessAsync", ApiRequest.METHOD_POST, "postFilePart", "Ljava/io/File;", "contentType", "postData", "", "Lorg/json/JSONObject;", "put", "toStringOrJson", "data", "addXSecurityArgusHeader", "callContext", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "securityContext", "Lcom/bytedance/sdk/xbridge/cn/auth/ISecurityContext;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "forceSetHeaderIgnoreCase", "key", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgeAPIRequestUtils {
    public static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    public static final int ERROR_CODE_408 = -408;
    public static final String REQUEST_ID_KEY = "_Header_RequestID";
    public static final String REQUEST_TAG_FROM = "request_tag_from";
    public static final String X_TT_LOG_ID = "x-tt-logid";
    public static final XBridgeAPIRequestUtils INSTANCE = new XBridgeAPIRequestUtils();
    private static String TAG = "XBridgeAPIRequestUtils";

    private XBridgeAPIRequestUtils() {
    }

    public final String toStringOrJson(Object data) {
        if (data == null) {
            return "";
        }
        if (data instanceof Map) {
            String jSONObject = new JSONObject((Map) data).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(data).toString()");
            return jSONObject;
        }
        if (!(data instanceof List)) {
            return data.toString();
        }
        String jSONArray = new JSONArray((Collection) data).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(data).toString()");
        return jSONArray;
    }

    public final LinkedHashMap<String, String> filterHeaderEmptyValue(Map<String, ? extends Object> header) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (header != null) {
            for (Map.Entry<String, ? extends Object> entry : header.entrySet()) {
                String stringOrJson = INSTANCE.toStringOrJson(entry.getValue());
                if (stringOrJson.length() > 0) {
                    linkedHashMap.put(entry.getKey(), stringOrJson);
                }
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ String addParametersToUrl$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, PlatformType platformType, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return xBridgeAPIRequestUtils.addParametersToUrl(str, map, platformType, z);
    }

    public final String addParametersToUrl(String r4, Map<String, ? extends Object> params, PlatformType r6, boolean addCommonParams) {
        String str;
        Intrinsics.checkNotNullParameter(r4, IWeixinService.ResponseConstants.URL);
        Intrinsics.checkNotNullParameter(r6, DBData.FIELD_TYPE);
        HttpUrlBuilder httpUrlBuilder = new HttpUrlBuilder(r4);
        if (params != null) {
            for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
                httpUrlBuilder.addParam(entry.getKey(), INSTANCE.toStringOrJson(entry.getValue()));
            }
        }
        if (addCommonParams) {
            if (r6 == PlatformType.WEB) {
                str = "h5";
            } else {
                str = r6 == PlatformType.LYNX ? "lynx" : "";
            }
            httpUrlBuilder.addParam(REQUEST_TAG_FROM, str);
        }
        Log.d(TAG, "build url is " + httpUrlBuilder.build());
        return httpUrlBuilder.build();
    }

    public static /* synthetic */ void get$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        xBridgeAPIRequestUtils.get(str, map, iResponseCallback, iHostNetworkDepend, z);
    }

    public final void get(String str, Map<String, String> map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        get(str, map, iResponseCallback, iHostNetworkDepend, z, false, -1);
    }

    public static /* synthetic */ void get$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            i = -1;
        }
        xBridgeAPIRequestUtils.get(str, map, iResponseCallback, iHostNetworkDepend, z2, i);
    }

    public final void get(String str, Map<String, String> map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        get(str, map, iResponseCallback, iHostNetworkDepend, z, false, i);
    }

    public final void get(String str, Map<String, String> map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        handleConnection(new HttpRequest(str).headers((LinkedHashMap) map).needAddCommonParams(z).setCustomCookie(z2).setMaxLength(i).doGetForString(iHostNetworkDepend), iResponseCallback);
    }

    public final void post(String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, File> linkedHashMap2, Map<String, String> map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(linkedHashMap, "headers");
        Intrinsics.checkNotNullParameter(linkedHashMap2, "postFilePart");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        post(str, linkedHashMap, linkedHashMap2, map, iResponseCallback, iHostNetworkDepend, z, false, i);
    }

    public final void post(String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, File> linkedHashMap2, Map<String, String> map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(linkedHashMap, "headers");
        Intrinsics.checkNotNullParameter(linkedHashMap2, "postFilePart");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        handleConnection(new HttpRequest(str).headers(linkedHashMap).postFilePart(linkedHashMap2).params(map).needAddCommonParams(z).setCustomCookie(z2).setMaxLength(i).doPostForString(iHostNetworkDepend), iResponseCallback);
    }

    public final void post(String str, Map<String, String> map, String str2, byte[] bArr, IStreamResponseCallback iStreamResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(bArr, "postData");
        Intrinsics.checkNotNullParameter(iStreamResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        post(str, map, str2, bArr, iStreamResponseCallback, iHostNetworkDepend, z, false);
    }

    public final void post(String str, Map<String, String> map, String str2, byte[] bArr, IStreamResponseCallback iStreamResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(bArr, "postData");
        Intrinsics.checkNotNullParameter(iStreamResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.putAll(map);
            iStreamResponseCallback.handleConnection(new HttpRequest(str).headers(linkedHashMap).contentType(str2).needAddCommonParams(z).setCustomCookie(z2).sendData(bArr).doPostForStream(iHostNetworkDepend));
        } catch (Throwable th) {
            Log.e(TAG, "get failed", th);
        }
    }

    public final void post(String str, Map<String, String> map, String str2, byte[] bArr, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(bArr, "postData");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        post(str, map, str2, bArr, iResponseCallback, iHostNetworkDepend, z, false, -1);
    }

    public final void post(String str, Map<String, String> map, String str2, byte[] bArr, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(bArr, "postData");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        post(str, map, str2, bArr, iResponseCallback, iHostNetworkDepend, z, false, i);
    }

    public final void post(String str, Map<String, String> map, String str2, byte[] bArr, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(bArr, "postData");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.putAll(map);
            handleConnection(new HttpRequest(str).headers(linkedHashMap).contentType(str2).needAddCommonParams(z).setCustomCookie(z2).sendData(bArr).setMaxLength(i).doPostForString(iHostNetworkDepend), iResponseCallback);
        } catch (Throwable th) {
            Log.e(TAG, "get failed", th);
        }
    }

    public final void post(String str, Map<String, String> map, String str2, JSONObject jSONObject, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(jSONObject, "postData");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        post(str, map, str2, jSONObject, iResponseCallback, iHostNetworkDepend, z, false, -1);
    }

    public final void post(String str, Map<String, String> map, String str2, JSONObject jSONObject, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(jSONObject, "postData");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        post(str, map, str2, jSONObject, iResponseCallback, iHostNetworkDepend, z, false, i);
    }

    public final void post(String str, Map<String, String> map, String str2, JSONObject jSONObject, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, boolean z2, int i) {
        AbsStringConnection doPostForString;
        Intrinsics.checkNotNullParameter(str, "targetUrl");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        Intrinsics.checkNotNullParameter(jSONObject, "postData");
        Intrinsics.checkNotNullParameter(iResponseCallback, "callback");
        Intrinsics.checkNotNullParameter(iHostNetworkDepend, "hostNetworkDepend");
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.putAll(map);
            if (Intrinsics.areEqual(str2, "application/json")) {
                HttpRequest customCookie = new HttpRequest(str).headers(linkedHashMap).contentType(str2).needAddCommonParams(z).setCustomCookie(z2);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "postData.toString()");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                byte[] bytes = jSONObject2.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                doPostForString = customCookie.sendData(bytes).setMaxLength(i).doPostForString(iHostNetworkDepend);
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next, "");
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    Intrinsics.checkNotNullExpressionValue(optString, "value");
                    linkedHashMap2.put(next, optString);
                }
                doPostForString = new HttpRequest(str).headers(linkedHashMap).params(linkedHashMap2).needAddCommonParams(z).setCustomCookie(z2).setMaxLength(i).doPostForString(iHostNetworkDepend);
            }
            handleConnection(doPostForString, iResponseCallback);
        } catch (Throwable th) {
            Log.e(TAG, "get failed", th);
        }
    }

    public final void put(String targetUrl, Map<String, String> headers, String contentType, JSONObject postData, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        put(targetUrl, headers, contentType, postData, callback, hostNetworkDepend, addCommonParams, false, -1);
    }

    public final void put(String targetUrl, Map<String, String> headers, String contentType, JSONObject postData, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams, int maxLength) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        put(targetUrl, headers, contentType, postData, callback, hostNetworkDepend, addCommonParams, false, maxLength);
    }

    public final void put(String targetUrl, Map<String, String> headers, String contentType, JSONObject postData, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams, boolean isCustomizedCookie, int maxLength) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        HttpRequest customCookie = new HttpRequest(targetUrl).headers((LinkedHashMap) headers).contentType(contentType).needAddCommonParams(addCommonParams).setCustomCookie(isCustomizedCookie);
        String jSONObject = postData.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "postData.toString()");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
        byte[] bytes = jSONObject.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        handleConnection(customCookie.sendData(bytes).setMaxLength(maxLength).doPutForString(hostNetworkDepend), callback);
    }

    public static /* synthetic */ void delete$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        xBridgeAPIRequestUtils.delete(str, map, iResponseCallback, iHostNetworkDepend, z);
    }

    public final void delete(String targetUrl, Map<String, String> headers, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        delete(targetUrl, headers, callback, hostNetworkDepend, addCommonParams, false, -1);
    }

    public static /* synthetic */ void delete$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, Map map, IResponseCallback iResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            i = -1;
        }
        xBridgeAPIRequestUtils.delete(str, map, iResponseCallback, iHostNetworkDepend, z2, i);
    }

    public final void delete(String targetUrl, Map<String, String> headers, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams, int maxLength) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        delete(targetUrl, headers, callback, hostNetworkDepend, addCommonParams, false, maxLength);
    }

    public final void delete(String targetUrl, Map<String, String> headers, IResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams, boolean isCustomizedCookie, int maxLength) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        handleConnection(new HttpRequest(targetUrl).headers((LinkedHashMap) headers).needAddCommonParams(addCommonParams).setCustomCookie(isCustomizedCookie).setMaxLength(maxLength).doDeleteForString(hostNetworkDepend), callback);
    }

    public static /* synthetic */ void downloadFile$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, LinkedHashMap linkedHashMap, IStreamResponseCallback iStreamResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = true;
        }
        xBridgeAPIRequestUtils.downloadFile(str, linkedHashMap, iStreamResponseCallback, iHostNetworkDepend, z);
    }

    public final void downloadFile(String targetUrl, LinkedHashMap<String, String> headers, IStreamResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        callback.handleConnection(new HttpRequest(targetUrl).headers(headers).needAddCommonParams(addCommonParams).doDownloadFile(hostNetworkDepend));
    }

    public static /* synthetic */ void doGetForStream$default(XBridgeAPIRequestUtils xBridgeAPIRequestUtils, String str, LinkedHashMap linkedHashMap, IStreamResponseCallback iStreamResponseCallback, IHostNetworkDepend iHostNetworkDepend, boolean z, boolean z2, long j, int i, Object obj) {
        xBridgeAPIRequestUtils.doGetForStream(str, linkedHashMap, iStreamResponseCallback, iHostNetworkDepend, (i & 16) != 0 ? true : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? 15000L : j);
    }

    public final void doGetForStream(String targetUrl, LinkedHashMap<String, String> headers, IStreamResponseCallback callback, IHostNetworkDepend hostNetworkDepend, boolean addCommonParams, boolean isCustomizedCookie, long timeOut) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        callback.handleConnection(new HttpRequest(targetUrl).headers(headers).needAddCommonParams(addCommonParams).setCustomCookie(isCustomizedCookie).connectTimeOut(timeOut).writeTimeOut(timeOut).readTimeOut(timeOut).doGetForStream(hostNetworkDepend));
    }

    public final String getRequestLogId(LinkedHashMap<String, String> responseHeader) {
        String str;
        return (!responseHeader.containsKey(X_TT_LOG_ID) || (str = responseHeader.get(X_TT_LOG_ID)) == null) ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleConnection(AbsStringConnection connection, IResponseCallback callback) {
        String str;
        if (connection == null) {
            Log.d(TAG, "connection is null");
            handleError(Integer.valueOf(ERROR_CODE_408), null, "connection failed", null, 0, callback);
            return;
        }
        String stringResponseBody = connection.getStringResponseBody();
        if (stringResponseBody != null) {
            if (stringResponseBody.length() > 0) {
                str = stringResponseBody;
                Integer clientCode = connection.getClientCode();
                if (str != null) {
                    Log.d(TAG, "response body is null");
                    if (handleError(connection.getResponseCode(), connection.getResponseHeader(), connection.getErrorMsg(), connection.getException(), clientCode != null ? clientCode.intValue() : 0, callback)) {
                        return;
                    }
                    handleSuccess(str, connection.getResponseHeader(), connection.getResponseCode(), clientCode != null ? clientCode.intValue() : 0, callback);
                    return;
                }
                if (handleError(connection.getResponseCode(), connection.getResponseHeader(), connection.getErrorMsg(), connection.getException(), clientCode != null ? clientCode.intValue() : 0, callback)) {
                    return;
                }
                Log.d(TAG, "handle response body");
                handleSuccess(str, connection.getResponseHeader(), connection.getResponseCode(), clientCode != null ? clientCode.intValue() : 0, callback);
                return;
            }
        }
        str = null;
        Integer clientCode2 = connection.getClientCode();
        if (str != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r12 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean handleError(final Integer r10, final LinkedHashMap<String, String> respHeader, String errorMsg, final Throwable throwable, final int clientCode, final IResponseCallback callback) {
        final String str;
        if (throwable == null && TextUtils.isEmpty(errorMsg)) {
            return false;
        }
        if (errorMsg != null) {
            if (!(errorMsg.length() > 0)) {
                errorMsg = null;
            }
        }
        String message = throwable != null ? throwable.getMessage() : null;
        if (message == null) {
            errorMsg = "";
            str = errorMsg;
            ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils$handleError$1
                @Override // java.lang.Runnable
                public final void run() {
                    IResponseCallback iResponseCallback = IResponseCallback.this;
                    Integer num = r10;
                    LinkedHashMap<String, String> linkedHashMap = respHeader;
                    Throwable th = throwable;
                    String str2 = str;
                    int i = clientCode;
                    try {
                        Result.Companion companion = Result.Companion;
                        if (th == null) {
                            th = new Throwable(str2);
                        }
                        iResponseCallback.onFailed(num, linkedHashMap, th, i);
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
            });
            Log.d(TAG, "handle error finish");
            return true;
        }
        str = message;
        ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils$handleError$1
            @Override // java.lang.Runnable
            public final void run() {
                IResponseCallback iResponseCallback = IResponseCallback.this;
                Integer num = r10;
                LinkedHashMap<String, String> linkedHashMap = respHeader;
                Throwable th = throwable;
                String str2 = str;
                int i = clientCode;
                try {
                    Result.Companion companion = Result.Companion;
                    if (th == null) {
                        th = new Throwable(str2);
                    }
                    iResponseCallback.onFailed(num, linkedHashMap, th, i);
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th2));
                }
            }
        });
        Log.d(TAG, "handle error finish");
        return true;
    }

    private final void handleSuccess(final String body, final LinkedHashMap<String, String> respHeader, final Integer respCode, final int clientCode, final IResponseCallback callback) {
        if (IConditionCallKt.enableJsonOpt()) {
            handleSuccessAsync(body, respHeader, respCode, clientCode, callback);
        } else {
            ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils$handleSuccess$1
                /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
                
                    r4 = "";
                 */
                /* JADX WARN: Removed duplicated region for block: B:23:0x00ce  */
                /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    Object obj;
                    Throwable th;
                    String requestLogId;
                    JSONObject jSONObject;
                    String str;
                    String str2;
                    boolean z;
                    String str3 = body;
                    LinkedHashMap<String, String> linkedHashMap = respHeader;
                    IResponseCallback iResponseCallback = callback;
                    Integer num = respCode;
                    int i = clientCode;
                    try {
                        Result.Companion companion = Result.Companion;
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            str2 = null;
                            str = null;
                            jSONObject = jSONObject2;
                            th = null;
                        } catch (Throwable th2) {
                            th = th2;
                            JSONObject jSONObject3 = new JSONObject();
                            requestLogId = XBridgeAPIRequestUtils.INSTANCE.getRequestLogId(linkedHashMap);
                            JSONObject put = jSONObject3.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, requestLogId);
                            Intrinsics.checkNotNullExpressionValue(put, "JSONObject().put(REQUEST…RequestLogId(respHeader))");
                            jSONObject = put;
                            str = str3;
                            str2 = th.getClass().toString() + ':' + th.getMessage();
                        }
                        z = false;
                        if (str2 != null) {
                            if (str2.length() > 0) {
                                z = true;
                            }
                        }
                    } catch (Throwable th3) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th3));
                    }
                    if (!z && th == null && str == null) {
                        iResponseCallback.onSuccess(jSONObject, linkedHashMap, num, i);
                        XBridge.log("x.request response:" + jSONObject + " header:" + linkedHashMap + " respCode:" + num);
                        obj = Result.constructor-impl(Unit.INSTANCE);
                        IResponseCallback iResponseCallback2 = callback;
                        LinkedHashMap<String, String> linkedHashMap2 = respHeader;
                        Integer num2 = respCode;
                        int i2 = clientCode;
                        th = Result.exceptionOrNull-impl(obj);
                        if (th != null) {
                            return;
                        }
                        iResponseCallback2.onParsingFailed(new JSONObject(), linkedHashMap2, "", th, num2, i2);
                        return;
                    }
                    String str4 = str;
                    if (th == null) {
                        th = new Throwable(str2);
                    }
                    iResponseCallback.onParsingFailed(jSONObject, linkedHashMap, str4, th, num, i);
                    XBridge.log("x.request response:" + jSONObject + " header:" + linkedHashMap + " respCode:" + num);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    IResponseCallback iResponseCallback22 = callback;
                    LinkedHashMap<String, String> linkedHashMap22 = respHeader;
                    Integer num22 = respCode;
                    int i22 = clientCode;
                    th = Result.exceptionOrNull-impl(obj);
                    if (th != null) {
                    }
                }
            });
        }
    }

    private final void handleSuccessAsync(String body, final LinkedHashMap<String, String> respHeader, final Integer respCode, final int clientCode, final IResponseCallback callback) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        try {
            objectRef.element = new JSONObject(body);
            XBridge.log("x.request body:" + body + " header:" + respHeader + " respCode:" + respCode);
        } catch (Throwable th) {
            String requestLogId = getRequestLogId(respHeader);
            JSONObject put = new JSONObject().put(REQUEST_ID_KEY, requestLogId);
            Intrinsics.checkNotNullExpressionValue(put, "JSONObject().put(REQUEST_ID_KEY, requestLogId)");
            objectRef.element = put;
            objectRef2.element = th.getClass().toString() + ':' + th.getMessage();
            objectRef3.element = th;
            objectRef4.element = body;
            XBridge.log("x.request requestLogId:" + requestLogId + " header:" + respHeader + " respCode:" + respCode);
        }
        ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils$handleSuccessAsync$1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                Unit unit;
                Ref.ObjectRef<String> objectRef5 = objectRef2;
                IResponseCallback iResponseCallback = callback;
                Ref.ObjectRef<JSONObject> objectRef6 = objectRef;
                LinkedHashMap<String, String> linkedHashMap = respHeader;
                Ref.ObjectRef<String> objectRef7 = objectRef4;
                Ref.ObjectRef<Throwable> objectRef8 = objectRef3;
                Integer num = respCode;
                int i = clientCode;
                try {
                    Result.Companion companion = Result.Companion;
                    if (objectRef5.element != null) {
                        JSONObject jSONObject = (JSONObject) objectRef6.element;
                        String str = (String) objectRef7.element;
                        if (str == null) {
                            str = "";
                        }
                        Throwable th2 = (Throwable) objectRef8.element;
                        if (th2 == null) {
                            th2 = new Throwable((String) objectRef5.element);
                        }
                        unit = iResponseCallback.onParsingFailed(jSONObject, linkedHashMap, str, th2, num, i);
                    } else {
                        iResponseCallback.onSuccess((JSONObject) objectRef6.element, linkedHashMap, num, i);
                        unit = Unit.INSTANCE;
                    }
                    obj = Result.constructor-impl(unit);
                } catch (Throwable th3) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                IResponseCallback iResponseCallback2 = callback;
                LinkedHashMap<String, String> linkedHashMap2 = respHeader;
                Integer num2 = respCode;
                int i2 = clientCode;
                Throwable th4 = Result.exceptionOrNull-impl(obj);
                if (th4 == null) {
                    return;
                }
                iResponseCallback2.onParsingFailed(new JSONObject(), linkedHashMap2, "", th4, num2, i2);
            }
        });
    }

    public final void addXSecurityArgusHeader(LinkedHashMap<String, String> linkedHashMap, IBDXBridgeContext iBDXBridgeContext) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        Intrinsics.checkNotNullParameter(iBDXBridgeContext, "bridgeContext");
        forceSetHeaderIgnoreCase(linkedHashMap, SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderKey(iBDXBridgeContext), SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderValue(iBDXBridgeContext));
    }

    public final void addXSecurityArgusHeader(LinkedHashMap<String, String> linkedHashMap, ISecurityContext iSecurityContext) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        if (iSecurityContext == null) {
            return;
        }
        forceSetHeaderIgnoreCase(linkedHashMap, SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderKey(iSecurityContext), SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderValue(iSecurityContext));
    }

    public final void addXSecurityArgusHeader(LinkedHashMap<String, String> linkedHashMap, CallContext callContext) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        forceSetHeaderIgnoreCase(linkedHashMap, SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderKey(callContext), SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderValue(callContext));
    }

    private final void forceSetHeaderIgnoreCase(LinkedHashMap<String, String> linkedHashMap, String str, String str2) {
        Object obj;
        Set<String> keySet = linkedHashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "this.keys");
        Iterator<T> it = keySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (StringsKt.equals((String) obj, str, true)) {
                    break;
                }
            }
        }
        String str3 = (String) obj;
        if (str3 != null) {
            linkedHashMap.remove(str3);
        }
        linkedHashMap.put(str, str2);
    }

    public final Map<String, String> convertParamValueToString(Map<String, ? extends Object> params) {
        if (params == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(params.size()));
        Iterator<T> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), INSTANCE.toStringOrJson(entry.getValue()));
        }
        return linkedHashMap;
    }
}
