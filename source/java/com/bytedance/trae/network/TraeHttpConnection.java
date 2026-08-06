package com.bytedance.trae.network;

import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.notification.Constants;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.network.response.ApiRespInterceptedException;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.network.response.HttpErrorCode;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: TraeHttpConnection.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002]^B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J.\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\fJ¢\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\f2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010!2\b\b\u0002\u0010(\u001a\u00020\f2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010!2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010!J]\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,2\u0006\u0010\"\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2\b\b\u0002\u0010$\u001a\u00020\u0019¢\u0006\u0002\u00101J·\u0001\u00102\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\"\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0006\u00103\u001a\u0002042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2\b\b\u0002\u0010$\u001a\u00020\u00192\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192'\u00108\u001a#\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010;09¢\u0006\u0002\b<H\u0086@¢\u0006\u0002\u0010=J·\u0001\u0010>\u001a\b\u0012\u0004\u0012\u0002H\n0?\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\"\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0006\u00103\u001a\u0002042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2\b\b\u0002\u0010$\u001a\u00020\u00192\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192'\u00108\u001a#\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010;09¢\u0006\u0002\b<H\u0086@¢\u0006\u0002\u0010=Já\u0001\u00102\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\"\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2\b\b\u0002\u0010$\u001a\u00020\u00192\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192\b\b\u0002\u0010@\u001a\u00020\u00192&\u0010A\u001a\"\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0B\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0C092'\u00108\u001a#\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010;09¢\u0006\u0002\b<H\u0086@¢\u0006\u0002\u0010DJá\u0001\u0010>\u001a\b\u0012\u0004\u0012\u0002H\n0?\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\"\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2\b\b\u0002\u0010$\u001a\u00020\u00192\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192\b\b\u0002\u0010@\u001a\u00020\u00192&\u0010A\u001a\"\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0B\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0C092'\u00108\u001a#\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010;09¢\u0006\u0002\b<H\u0086@¢\u0006\u0002\u0010DJf\u00102\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010\n2\u0006\u00103\u001a\u0002042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192\u001c\u0010E\u001a\u0018\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010B0FH\u0086@¢\u0006\u0002\u0010GJf\u0010>\u001a\b\u0012\u0004\u0012\u0002H\n0?\"\u0004\b\u0000\u0010\n2\u0006\u00103\u001a\u0002042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192\u001c\u0010E\u001a\u0018\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010B0FH\u0086@¢\u0006\u0002\u0010GJ\u0090\u0001\u00102\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192\b\b\u0002\u0010@\u001a\u00020\u00192&\u0010A\u001a\"\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0B\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0C092\u001c\u0010E\u001a\u0018\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010B0FH\u0086@¢\u0006\u0002\u0010HJ\u0090\u0001\u0010>\u001a\b\u0012\u0004\u0012\u0002H\n0?\"\u0004\b\u0000\u0010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e062\b\b\u0002\u00107\u001a\u00020\u00192\b\b\u0002\u0010@\u001a\u00020\u00192&\u0010A\u001a\"\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0B\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0C092\u001c\u0010E\u001a\u0018\u0012\u0004\u0012\u00020:\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010B0FH\u0086@¢\u0006\u0002\u0010HJ\b\u0010I\u001a\u00020\u000eH\u0002J.\u0010J\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010H\u0002J\u0016\u0010K\u001a\u0004\u0018\u00010\f*\n\u0012\u0006\u0012\u0004\u0018\u00010\f0BH\u0002J\u000e\u0010L\u001a\u0004\u0018\u00010\f*\u00020\fH\u0002J\f\u0010M\u001a\u00020\f*\u00020\fH\u0002J,\u0010N\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002H\n0CH\u0002J\u008f\u0001\u0010P\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010Q\u001a\u0002042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0018\b\u0002\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010!2!\u00108\u001a\u001d\u0012\u0004\u0012\u0002H,\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010B0F¢\u0006\u0002\b<2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e06J\u0097\u0001\u0010P\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\"\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!2/\u00108\u001a+\b\u0001\u0012\u0004\u0012\u0002H,\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010C0S\u0012\u0006\u0012\u0004\u0018\u00010\u000109¢\u0006\u0002\b<2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e06H\u0086@¢\u0006\u0002\u0010TJ\u0095\u0001\u0010P\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010Q\u001a\u0002042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0016\b\u0002\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010!2!\u00108\u001a\u001d\u0012\u0004\u0012\u0002H,\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010B0F¢\u0006\u0002\b<2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e06J\u0083\u0001\u0010P\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\n2\u0006\u0010\"\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2/\u00108\u001a+\b\u0001\u0012\u0004\u0012\u0002H,\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010C0S\u0012\u0006\u0012\u0004\u0018\u00010\u000109¢\u0006\u0002\b<2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e06H\u0086@¢\u0006\u0002\u0010VJ+\u0010W\u001a\u00020\t*\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0017\u0010[\u001a\u0013\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\t0F¢\u0006\u0002\b<R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006_"}, d2 = {"Lcom/bytedance/trae/network/TraeHttpConnection;", "", "<init>", "()V", "extractErrorInfo", "Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;", "throwable", "", "trackRequestEvent", "", "T", "interceptorPath", "", "costTime", "", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "httpGson", "Lcom/google/gson/Gson;", "getHttpGson", "()Lcom/google/gson/Gson;", "apiRespInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/trae/network/IApiRespInterceptor;", "addApiRespInterceptor", "", "interceptor", "removeApiRespInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "getInterceptor", "()Lcom/bytedance/retrofit2/intercept/Interceptor;", "baseUrl", "buildServiceHeaders", "", Constants.NOTIFICATION_TAG, "extraHeaders", "isAddPPE", "addCommonHeaders", "ideToken", "ppeHeaders", "envLane", "customHeaders", "commonAppendHeaders", "createService", "S", "apiClazz", "Ljava/lang/Class;", "converterFactory", "Lcom/bytedance/retrofit2/Converter$Factory;", "(Ljava/lang/String;Ljava/lang/Class;Lcom/bytedance/retrofit2/Converter$Factory;Ljava/lang/String;Ljava/util/Map;Z)Ljava/lang/Object;", "rawBizCall", "dataType", "Ljava/lang/reflect/Type;", "successCodes", "", "requireHttpSuccess", "call", "Lkotlin/Function2;", "Lcom/bytedance/ttnet/http/RequestContext;", "Lcom/bytedance/retrofit2/Call;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Set;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rawBizCallWithBody", "Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;", "allowEmptyBody", "parseBody", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/trae/network/response/BizResponse;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Set;ZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lkotlin/Function1;", "(Ljava/lang/reflect/Type;Ljava/lang/String;Ljava/util/Set;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/util/Set;ZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elapsedRealtime", "trackRequestEventSafely", "readRawBody", "takeIfPresentBody", "normalizeJsonBody", "successResult", "bizResp", "safeCall", "outType", "metric", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "headers", "(Ljava/lang/String;Ljava/lang/Class;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendParamToBody", "Lcom/bytedance/retrofit2/client/Request$Builder;", "request", "Lcom/bytedance/retrofit2/client/Request;", "appendParam", "Lorg/json/JSONObject;", "ErrorInfo", "RawBizCallResult", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeHttpConnection {
    public static final TraeHttpConnection INSTANCE = new TraeHttpConnection();
    private static final CopyOnWriteArrayList<IApiRespInterceptor> apiRespInterceptors;
    private static final Gson httpGson;
    private static final Interceptor interceptor;

    private TraeHttpConnection() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraeHttpConnection.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/network/TraeHttpConnection$ErrorInfo;", "", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class ErrorInfo {
        private final int code;
        private final String message;

        public static /* synthetic */ ErrorInfo copy$default(ErrorInfo errorInfo, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = errorInfo.code;
            }
            if ((i2 & 2) != 0) {
                str = errorInfo.message;
            }
            return errorInfo.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ErrorInfo copy(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ErrorInfo(code, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorInfo)) {
                return false;
            }
            ErrorInfo errorInfo = (ErrorInfo) other;
            return this.code == errorInfo.code && Intrinsics.areEqual(this.message, errorInfo.message);
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "ErrorInfo(code=" + this.code + ", message=" + this.message + ')';
        }

        public ErrorInfo(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.code = i;
            this.message = str;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r3 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r3 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ErrorInfo extractErrorInfo(Throwable throwable) {
        String str;
        int i;
        String message;
        str = "";
        if (throwable instanceof CronetIOException) {
            i = ((CronetIOException) throwable).getStatusCode();
            message = throwable.getMessage();
        } else if (throwable instanceof NetworkNotAvailabeException) {
            i = ((NetworkNotAvailabeException) throwable).getCronetInternalErrorCode();
            message = throwable.getMessage();
        } else {
            String message2 = throwable.getMessage();
            str = message2 != null ? message2 : "";
            i = -1000;
        }
        return new ErrorInfo(i, str);
    }

    private final <T> void trackRequestEvent(String interceptorPath, long costTime, HttpDataResult<? extends T> result) {
        LinkedHashMap linkedHashMap;
        List<Header> headers;
        if (result instanceof HttpDataResult.Success) {
            TraeRequestEventReporter traeRequestEventReporter = TraeRequestEventReporter.INSTANCE;
            HttpDataResult.Success success = (HttpDataResult.Success) result;
            long code = success.getBizResp().getCode();
            String msg = success.getBizResp().getMsg();
            if (msg == null && (msg = success.getBizResp().getMessage()) == null) {
                msg = "";
            }
            String str = msg;
            SsResponse<String> sSResponse = success.getBizResp().getSSResponse();
            if (sSResponse == null || (headers = sSResponse.headers()) == null) {
                linkedHashMap = null;
            } else {
                List<Header> list = headers;
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                for (Header header : list) {
                    Pair pair = TuplesKt.to(header.getName(), header.getValue());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
            }
            traeRequestEventReporter.report(interceptorPath, costTime, code, str, linkedHashMap == null ? MapsKt.emptyMap() : linkedHashMap);
            return;
        }
        if (!(result instanceof HttpDataResult.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        TraeRequestEventReporter.INSTANCE.report(interceptorPath, costTime, r13.getCode(), ((HttpDataResult.Error) result).getMsg(), MapsKt.emptyMap());
    }

    static {
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        httpGson = create;
        apiRespInterceptors = new CopyOnWriteArrayList<>();
        interceptor = new Interceptor() { // from class: com.bytedance.trae.network.TraeHttpConnection$$ExternalSyntheticLambda4
            @Override // com.bytedance.retrofit2.intercept.Interceptor
            public final SsResponse intercept(Interceptor.Chain chain) {
                SsResponse interceptor$lambda$3;
                interceptor$lambda$3 = TraeHttpConnection.interceptor$lambda$3(chain);
                return interceptor$lambda$3;
            }
        };
    }

    public final Gson getHttpGson() {
        return httpGson;
    }

    /* compiled from: TraeHttpConnection.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bHÆ\u0003J?\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;", "T", "", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "body", "", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "<init>", "(Lcom/bytedance/trae/network/response/HttpDataResult;Ljava/lang/String;Lcom/bytedance/retrofit2/SsResponse;)V", "getResult", "()Lcom/bytedance/trae/network/response/HttpDataResult;", "getBody", "()Ljava/lang/String;", "getSsResponse", "()Lcom/bytedance/retrofit2/SsResponse;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class RawBizCallResult<T> {
        private final String body;
        private final HttpDataResult<T> result;
        private final SsResponse<String> ssResponse;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RawBizCallResult copy$default(RawBizCallResult rawBizCallResult, HttpDataResult httpDataResult, String str, SsResponse ssResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                httpDataResult = rawBizCallResult.result;
            }
            if ((i & 2) != 0) {
                str = rawBizCallResult.body;
            }
            if ((i & 4) != 0) {
                ssResponse = rawBizCallResult.ssResponse;
            }
            return rawBizCallResult.copy(httpDataResult, str, ssResponse);
        }

        public final HttpDataResult<T> component1() {
            return this.result;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final SsResponse<String> component3() {
            return this.ssResponse;
        }

        public final RawBizCallResult<T> copy(HttpDataResult<? extends T> result, String body, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new RawBizCallResult<>(result, body, ssResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RawBizCallResult)) {
                return false;
            }
            RawBizCallResult rawBizCallResult = (RawBizCallResult) other;
            return Intrinsics.areEqual(this.result, rawBizCallResult.result) && Intrinsics.areEqual(this.body, rawBizCallResult.body) && Intrinsics.areEqual(this.ssResponse, rawBizCallResult.ssResponse);
        }

        public int hashCode() {
            int hashCode = this.result.hashCode() * 31;
            String str = this.body;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            SsResponse<String> ssResponse = this.ssResponse;
            return hashCode2 + (ssResponse != null ? ssResponse.hashCode() : 0);
        }

        public String toString() {
            return "RawBizCallResult(result=" + this.result + ", body=" + this.body + ", ssResponse=" + this.ssResponse + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RawBizCallResult(HttpDataResult<? extends T> httpDataResult, String str, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(httpDataResult, "result");
            this.result = httpDataResult;
            this.body = str;
            this.ssResponse = ssResponse;
        }

        public final HttpDataResult<T> getResult() {
            return this.result;
        }

        public final String getBody() {
            return this.body;
        }

        public final SsResponse<String> getSsResponse() {
            return this.ssResponse;
        }
    }

    public final boolean addApiRespInterceptor(IApiRespInterceptor interceptor2) {
        Intrinsics.checkNotNullParameter(interceptor2, "interceptor");
        return apiRespInterceptors.add(interceptor2);
    }

    public final boolean removeApiRespInterceptor(IApiRespInterceptor interceptor2) {
        Intrinsics.checkNotNullParameter(interceptor2, "interceptor");
        return apiRespInterceptors.remove(interceptor2);
    }

    public final Interceptor getInterceptor() {
        return interceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse interceptor$lambda$3(Interceptor.Chain chain) {
        Map<String, String> commonParams = ISdkCommonHttp.INSTANCE.getCommonParams();
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        UrlBuilder urlBuilder = new UrlBuilder(request.getUrl());
        for (Map.Entry<String, String> entry : commonParams.entrySet()) {
            urlBuilder.addParam(entry.getKey(), entry.getValue());
        }
        Map<String, String> commonAppendHeaders = ISdkCommonHttp.INSTANCE.getCommonAppendHeaders();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders());
        for (Map.Entry<String, String> entry2 : commonAppendHeaders.entrySet()) {
            arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
        }
        newBuilder.url(urlBuilder.build());
        return chain.proceed(newBuilder.headers(arrayList).build());
    }

    public final String baseUrl() {
        return ISdkCommonHttp.INSTANCE.getOnlineBaseUrl();
    }

    public static /* synthetic */ Map buildServiceHeaders$default(TraeHttpConnection traeHttpConnection, String str, Map map, boolean z, boolean z2, String str2, Map map2, String str3, Map map3, Map map4, int i, Object obj) {
        return traeHttpConnection.buildServiceHeaders(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? ISdkCommonHttp.INSTANCE.getToken() : str2, (i & 32) != 0 ? null : map2, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? null : map3, (i & 256) == 0 ? map4 : null);
    }

    public final Map<String, String> buildServiceHeaders(String tag, Map<String, String> extraHeaders, boolean isAddPPE, boolean addCommonHeaders, String ideToken, Map<String, String> ppeHeaders, String envLane, Map<String, String> customHeaders, Map<String, String> commonAppendHeaders) {
        Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
        Intrinsics.checkNotNullParameter(ideToken, "ideToken");
        Intrinsics.checkNotNullParameter(envLane, "envLane");
        Map createMapBuilder = MapsKt.createMapBuilder();
        if (tag != null) {
            if (!(!StringsKt.isBlank(tag))) {
                tag = null;
            }
            if (tag != null) {
            }
        }
        if (ideToken.length() > 0) {
            createMapBuilder.put("x-ide-token", ideToken);
        }
        if (isAddPPE && !extraHeaders.containsKey("X-Use-PPE")) {
            if (ppeHeaders == null) {
                ppeHeaders = DebugSettings.INSTANCE.getPpeHeaders();
            }
            createMapBuilder.putAll(ppeHeaders);
        }
        if (!(envLane.length() > 0)) {
            envLane = null;
        }
        if (envLane != null) {
        }
        if (customHeaders == null) {
            customHeaders = DebugSettings.INSTANCE.getCustomHeaders();
        }
        createMapBuilder.putAll(customHeaders);
        createMapBuilder.putAll(extraHeaders);
        if (addCommonHeaders) {
            if (commonAppendHeaders == null) {
                commonAppendHeaders = ISdkCommonHttp.INSTANCE.getCommonAppendHeaders();
            }
            createMapBuilder.putAll(commonAppendHeaders);
        }
        return MapsKt.build(createMapBuilder);
    }

    public static /* synthetic */ Object createService$default(TraeHttpConnection traeHttpConnection, String str, Class cls, Converter.Factory factory, String str2, Map map, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            factory = null;
        }
        Converter.Factory factory2 = factory;
        if ((i & 8) != 0) {
            str2 = traeHttpConnection.baseUrl();
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i & 32) != 0) {
            z = false;
        }
        return traeHttpConnection.createService(str, cls, factory2, str3, map2, z);
    }

    public final <S> S createService(final String tag, Class<S> apiClazz, Converter.Factory converterFactory, String baseUrl, final Map<String, String> extraHeaders, final boolean isAddPPE) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkNotNullParameter(apiClazz, "apiClazz");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
        return (S) RetrofitUtils.createSsRetrofit(baseUrl, CollectionsKt.listOf(new Interceptor[]{new Interceptor() { // from class: com.bytedance.trae.network.TraeHttpConnection$$ExternalSyntheticLambda1
            @Override // com.bytedance.retrofit2.intercept.Interceptor
            public final SsResponse intercept(Interceptor.Chain chain) {
                SsResponse createService$lambda$11;
                createService$lambda$11 = TraeHttpConnection.createService$lambda$11(tag, extraHeaders, isAddPPE, chain);
                return createService$lambda$11;
            }
        }, interceptor}), converterFactory).create(apiClazz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse createService$lambda$11(String str, Map map, boolean z, Interceptor.Chain chain) {
        Request request = chain.request();
        Map buildServiceHeaders$default = buildServiceHeaders$default(INSTANCE, str, map, z, false, null, null, null, null, null, 496, null);
        List<Header> headers = request.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "getHeaders(...)");
        List<Header> mutableList = CollectionsKt.toMutableList(headers);
        for (Map.Entry entry : buildServiceHeaders$default.entrySet()) {
            mutableList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
        }
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.headers(mutableList);
        return chain.proceed(newBuilder.build());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <S, T> Object rawBizCall(String str, Class<S> cls, Type type, String str2, String str3, Map<String, String> map, boolean z, Set<Long> set, boolean z2, Function2<? super S, ? super RequestContext, ? extends Call<String>> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
        TraeHttpConnection$rawBizCall$1 traeHttpConnection$rawBizCall$1;
        int i;
        if (continuation instanceof TraeHttpConnection$rawBizCall$1) {
            traeHttpConnection$rawBizCall$1 = (TraeHttpConnection$rawBizCall$1) continuation;
            if ((traeHttpConnection$rawBizCall$1.label & Integer.MIN_VALUE) != 0) {
                traeHttpConnection$rawBizCall$1.label -= Integer.MIN_VALUE;
                TraeHttpConnection$rawBizCall$1 traeHttpConnection$rawBizCall$12 = traeHttpConnection$rawBizCall$1;
                Object obj = traeHttpConnection$rawBizCall$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeHttpConnection$rawBizCall$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    traeHttpConnection$rawBizCall$12.label = 1;
                    obj = rawBizCallWithBody(str, cls, type, str2, str3, map, z, set, z2, function2, traeHttpConnection$rawBizCall$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((RawBizCallResult) obj).getResult();
            }
        }
        traeHttpConnection$rawBizCall$1 = new TraeHttpConnection$rawBizCall$1(this, continuation);
        TraeHttpConnection$rawBizCall$1 traeHttpConnection$rawBizCall$122 = traeHttpConnection$rawBizCall$1;
        Object obj2 = traeHttpConnection$rawBizCall$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeHttpConnection$rawBizCall$122.label;
        if (i != 0) {
        }
        return ((RawBizCallResult) obj2).getResult();
    }

    public final <S, T> Object rawBizCallWithBody(String str, Class<S> cls, Type type, String str2, String str3, Map<String, String> map, boolean z, Set<Long> set, boolean z2, final Function2<? super S, ? super RequestContext, ? extends Call<String>> function2, Continuation<? super RawBizCallResult<T>> continuation) {
        final Object createService$default = createService$default(this, str, cls, null, str3, map, z, 4, null);
        return rawBizCallWithBody(type, str2, set, z2, new Function1() { // from class: com.bytedance.trae.network.TraeHttpConnection$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                SsResponse rawBizCallWithBody$lambda$12;
                rawBizCallWithBody$lambda$12 = TraeHttpConnection.rawBizCallWithBody$lambda$12(function2, createService$default, (RequestContext) obj);
                return rawBizCallWithBody$lambda$12;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse rawBizCallWithBody$lambda$12(Function2 function2, Object obj, RequestContext requestContext) {
        Intrinsics.checkNotNullParameter(requestContext, "requestContext");
        Call call = (Call) function2.invoke(obj, requestContext);
        if (call != null) {
            return call.execute();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <S, T> Object rawBizCall(String str, Class<S> cls, String str2, String str3, Map<String, String> map, boolean z, Set<Long> set, boolean z2, boolean z3, Function2<? super String, ? super SsResponse<String>, BizResponse<T>> function2, Function2<? super S, ? super RequestContext, ? extends Call<String>> function22, Continuation<? super HttpDataResult<? extends T>> continuation) {
        TraeHttpConnection$rawBizCall$2 traeHttpConnection$rawBizCall$2;
        int i;
        if (continuation instanceof TraeHttpConnection$rawBizCall$2) {
            traeHttpConnection$rawBizCall$2 = (TraeHttpConnection$rawBizCall$2) continuation;
            if ((traeHttpConnection$rawBizCall$2.label & Integer.MIN_VALUE) != 0) {
                traeHttpConnection$rawBizCall$2.label -= Integer.MIN_VALUE;
                TraeHttpConnection$rawBizCall$2 traeHttpConnection$rawBizCall$22 = traeHttpConnection$rawBizCall$2;
                Object obj = traeHttpConnection$rawBizCall$22.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeHttpConnection$rawBizCall$22.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    traeHttpConnection$rawBizCall$22.label = 1;
                    obj = rawBizCallWithBody(str, cls, str2, str3, map, z, set, z2, z3, function2, function22, traeHttpConnection$rawBizCall$22);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((RawBizCallResult) obj).getResult();
            }
        }
        traeHttpConnection$rawBizCall$2 = new TraeHttpConnection$rawBizCall$2(this, continuation);
        TraeHttpConnection$rawBizCall$2 traeHttpConnection$rawBizCall$222 = traeHttpConnection$rawBizCall$2;
        Object obj2 = traeHttpConnection$rawBizCall$222.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeHttpConnection$rawBizCall$222.label;
        if (i != 0) {
        }
        return ((RawBizCallResult) obj2).getResult();
    }

    public final <S, T> Object rawBizCallWithBody(String str, Class<S> cls, String str2, String str3, Map<String, String> map, boolean z, Set<Long> set, boolean z2, boolean z3, Function2<? super String, ? super SsResponse<String>, BizResponse<T>> function2, final Function2<? super S, ? super RequestContext, ? extends Call<String>> function22, Continuation<? super RawBizCallResult<T>> continuation) {
        final Object createService$default = createService$default(this, str, cls, null, str3, map, z, 4, null);
        return rawBizCallWithBody(str2, set, z2, z3, function2, new Function1() { // from class: com.bytedance.trae.network.TraeHttpConnection$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                SsResponse rawBizCallWithBody$lambda$13;
                rawBizCallWithBody$lambda$13 = TraeHttpConnection.rawBizCallWithBody$lambda$13(function22, createService$default, (RequestContext) obj);
                return rawBizCallWithBody$lambda$13;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse rawBizCallWithBody$lambda$13(Function2 function2, Object obj, RequestContext requestContext) {
        Intrinsics.checkNotNullParameter(requestContext, "requestContext");
        Call call = (Call) function2.invoke(obj, requestContext);
        if (call != null) {
            return call.execute();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object rawBizCall(Type type, String str, Set<Long> set, boolean z, Function1<? super RequestContext, SsResponse<String>> function1, Continuation<? super HttpDataResult<? extends T>> continuation) {
        TraeHttpConnection$rawBizCall$3 traeHttpConnection$rawBizCall$3;
        int i;
        if (continuation instanceof TraeHttpConnection$rawBizCall$3) {
            traeHttpConnection$rawBizCall$3 = (TraeHttpConnection$rawBizCall$3) continuation;
            if ((traeHttpConnection$rawBizCall$3.label & Integer.MIN_VALUE) != 0) {
                traeHttpConnection$rawBizCall$3.label -= Integer.MIN_VALUE;
                TraeHttpConnection$rawBizCall$3 traeHttpConnection$rawBizCall$32 = traeHttpConnection$rawBizCall$3;
                Object obj = traeHttpConnection$rawBizCall$32.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeHttpConnection$rawBizCall$32.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    traeHttpConnection$rawBizCall$32.label = 1;
                    obj = rawBizCallWithBody(type, str, set, z, function1, traeHttpConnection$rawBizCall$32);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((RawBizCallResult) obj).getResult();
            }
        }
        traeHttpConnection$rawBizCall$3 = new TraeHttpConnection$rawBizCall$3(this, continuation);
        TraeHttpConnection$rawBizCall$3 traeHttpConnection$rawBizCall$322 = traeHttpConnection$rawBizCall$3;
        Object obj2 = traeHttpConnection$rawBizCall$322.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeHttpConnection$rawBizCall$322.label;
        if (i != 0) {
        }
        return ((RawBizCallResult) obj2).getResult();
    }

    public static /* synthetic */ Object rawBizCall$default(TraeHttpConnection traeHttpConnection, Type type, String str, Set set, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            set = BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES();
        }
        Set set2 = set;
        if ((i & 8) != 0) {
            z = false;
        }
        return traeHttpConnection.rawBizCall(type, str2, set2, z, function1, continuation);
    }

    public static /* synthetic */ Object rawBizCallWithBody$default(TraeHttpConnection traeHttpConnection, Type type, String str, Set set, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            set = BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES();
        }
        Set set2 = set;
        if ((i & 8) != 0) {
            z = false;
        }
        return traeHttpConnection.rawBizCallWithBody(type, str2, set2, z, function1, continuation);
    }

    public final <T> Object rawBizCallWithBody(final Type type, String str, Set<Long> set, boolean z, Function1<? super RequestContext, SsResponse<String>> function1, Continuation<? super RawBizCallResult<T>> continuation) {
        return rawBizCallWithBody$default(this, str, set, z, false, new Function2() { // from class: com.bytedance.trae.network.TraeHttpConnection$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                BizResponse rawBizCallWithBody$lambda$15;
                rawBizCallWithBody$lambda$15 = TraeHttpConnection.rawBizCallWithBody$lambda$15(type, (String) obj, (SsResponse) obj2);
                return rawBizCallWithBody$lambda$15;
            }
        }, function1, continuation, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BizResponse rawBizCallWithBody$lambda$15(Type type, String str, SsResponse ssResponse) {
        Intrinsics.checkNotNullParameter(str, "body");
        Intrinsics.checkNotNullParameter(ssResponse, "ssResponse");
        Object fromJson = httpGson.fromJson(str, TypeToken.getParameterized(BizResponse.class, new Type[]{type}).getType());
        BizResponse bizResponse = (BizResponse) fromJson;
        bizResponse.setupSSResponse(ssResponse);
        Intrinsics.checkNotNullExpressionValue(fromJson, "apply(...)");
        return bizResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object rawBizCall(String str, Set<Long> set, boolean z, boolean z2, Function2<? super String, ? super SsResponse<String>, BizResponse<T>> function2, Function1<? super RequestContext, SsResponse<String>> function1, Continuation<? super HttpDataResult<? extends T>> continuation) {
        TraeHttpConnection$rawBizCall$4 traeHttpConnection$rawBizCall$4;
        int i;
        if (continuation instanceof TraeHttpConnection$rawBizCall$4) {
            traeHttpConnection$rawBizCall$4 = (TraeHttpConnection$rawBizCall$4) continuation;
            if ((traeHttpConnection$rawBizCall$4.label & Integer.MIN_VALUE) != 0) {
                traeHttpConnection$rawBizCall$4.label -= Integer.MIN_VALUE;
                TraeHttpConnection$rawBizCall$4 traeHttpConnection$rawBizCall$42 = traeHttpConnection$rawBizCall$4;
                Object obj = traeHttpConnection$rawBizCall$42.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeHttpConnection$rawBizCall$42.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    traeHttpConnection$rawBizCall$42.label = 1;
                    obj = rawBizCallWithBody(str, set, z, z2, function2, function1, traeHttpConnection$rawBizCall$42);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((RawBizCallResult) obj).getResult();
            }
        }
        traeHttpConnection$rawBizCall$4 = new TraeHttpConnection$rawBizCall$4(this, continuation);
        TraeHttpConnection$rawBizCall$4 traeHttpConnection$rawBizCall$422 = traeHttpConnection$rawBizCall$4;
        Object obj2 = traeHttpConnection$rawBizCall$422.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeHttpConnection$rawBizCall$422.label;
        if (i != 0) {
        }
        return ((RawBizCallResult) obj2).getResult();
    }

    public static /* synthetic */ Object rawBizCallWithBody$default(TraeHttpConnection traeHttpConnection, String str, Set set, boolean z, boolean z2, Function2 function2, Function1 function1, Continuation continuation, int i, Object obj) {
        return traeHttpConnection.rawBizCallWithBody((i & 1) != 0 ? null : str, (i & 2) != 0 ? BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES() : set, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, function2, function1, continuation);
    }

    public final <T> Object rawBizCallWithBody(String str, Set<Long> set, boolean z, boolean z2, Function2<? super String, ? super SsResponse<String>, BizResponse<T>> function2, Function1<? super RequestContext, SsResponse<String>> function1, Continuation<? super RawBizCallResult<T>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TraeHttpConnection$rawBizCallWithBody$8(function1, z2, z, function2, set, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long elapsedRealtime() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            TraeHttpConnection traeHttpConnection = this;
            obj = Result.constructor-impl(Long.valueOf(SystemClock.elapsedRealtime()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Long.valueOf(System.currentTimeMillis());
        }
        return ((Number) obj).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void trackRequestEventSafely(String interceptorPath, long costTime, HttpDataResult<? extends T> result) {
        try {
            Result.Companion companion = Result.Companion;
            TraeHttpConnection traeHttpConnection = this;
            trackRequestEvent(interceptorPath, costTime, result);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String readRawBody(SsResponse<String> ssResponse) {
        InputStream mo349in;
        String body = ssResponse.body();
        if (body != null) {
            return body;
        }
        TypedInput errorBody = ssResponse.errorBody();
        if (errorBody == null || (mo349in = errorBody.mo349in()) == null) {
            return null;
        }
        Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, (Throwable) null);
            return readText;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String takeIfPresentBody(String str) {
        String obj = StringsKt.trim(str).toString();
        if (!(obj.length() > 0) || Intrinsics.areEqual(obj, "null")) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeJsonBody(String str) {
        String obj = StringsKt.trim(str).toString();
        if (!StringsKt.startsWith$default(obj, "\"", false, 2, (Object) null) || !StringsKt.endsWith$default(obj, "\"", false, 2, (Object) null)) {
            return str;
        }
        Object fromJson = httpGson.fromJson(obj, String.class);
        Intrinsics.checkNotNull(fromJson);
        return (String) fromJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> HttpDataResult<T> successResult(String interceptorPath, BizResponse<T> bizResp) {
        CopyOnWriteArrayList<IApiRespInterceptor> copyOnWriteArrayList = apiRespInterceptors;
        boolean z = false;
        if (!copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((IApiRespInterceptor) it.next()).intercept(interceptorPath, bizResp)) {
                    z = true;
                }
            }
        }
        return new HttpDataResult.Success(bizResp, z ? new ApiRespInterceptedException(null, 1, null) : null);
    }

    public final <S, T> HttpDataResult<T> safeCall(String tag, Type outType, String interceptorPath, Class<S> apiClazz, Map<String, ? extends Object> metric, Function1<? super S, SsResponse<String>> call, Set<Long> successCodes) {
        HttpDataResult.Error error;
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkNotNullParameter(outType, "outType");
        Intrinsics.checkNotNullParameter(apiClazz, "apiClazz");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(successCodes, "successCodes");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            SsResponse<String> ssResponse = (SsResponse) call.invoke(createService$default(this, tag, apiClazz, null, null, null, false, 60, null));
            if (ssResponse == null) {
                error = new HttpDataResult.Error(HttpErrorCode.NULL_POINTER, "ssResponse is null", new Exception("ssResponse is null"), null, 8, null);
            } else {
                boolean z = false;
                BizResponse<T> bizResponse = (BizResponse) httpGson.fromJson(ssResponse.body(), TypeToken.getParameterized(BizResponse.class, new Type[]{outType}).getType());
                bizResponse.setupSSResponse(ssResponse);
                bizResponse.setupSuccessCodes(successCodes);
                CopyOnWriteArrayList<IApiRespInterceptor> copyOnWriteArrayList = apiRespInterceptors;
                if (!copyOnWriteArrayList.isEmpty()) {
                    Iterator<T> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        if (((IApiRespInterceptor) it.next()).intercept(interceptorPath, bizResponse)) {
                            z = true;
                        }
                    }
                }
                Intrinsics.checkNotNull(bizResponse);
                error = new HttpDataResult.Success(bizResponse, z ? new ApiRespInterceptedException(null, 1, null) : null);
            }
        } catch (CancellationException e) {
            error = new HttpDataResult.Error(-1001, "", e, null, 8, null);
        } catch (Throwable th) {
            ErrorInfo extractErrorInfo = extractErrorInfo(th);
            error = new HttpDataResult.Error(extractErrorInfo.getCode(), extractErrorInfo.getMessage(), th, null, 8, null);
        }
        trackRequestEvent(interceptorPath, SystemClock.elapsedRealtime() - elapsedRealtime, error);
        return error;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(4:9|10|11|12)(2:46|47))(7:48|49|50|51|52|53|(1:55)(1:56))|13|14|(1:16)(5:20|(3:22|(4:25|(3:27|28|29)(1:31)|30|23)|32)|33|(1:35)|36)|17|18))|67|6|(0)(0)|13|14|(0)(0)|17|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086 A[Catch: all -> 0x00f3, CancellationException -> 0x00f5, TryCatch #7 {CancellationException -> 0x00f5, all -> 0x00f3, blocks: (B:14:0x0082, B:16:0x0086, B:20:0x00ae, B:22:0x00c2, B:23:0x00c8, B:25:0x00ce, B:28:0x00da, B:33:0x00dd, B:35:0x00e4, B:36:0x00ea), top: B:13:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae A[Catch: all -> 0x00f3, CancellationException -> 0x00f5, TryCatch #7 {CancellationException -> 0x00f5, all -> 0x00f3, blocks: (B:14:0x0082, B:16:0x0086, B:20:0x00ae, B:22:0x00c2, B:23:0x00c8, B:25:0x00ce, B:28:0x00da, B:33:0x00dd, B:35:0x00e4, B:36:0x00ea), top: B:13:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <S, T> Object safeCall(String str, Class<S> cls, Map<String, String> map, Function2<? super S, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, String str2, Set<Long> set, Continuation<? super HttpDataResult<? extends T>> continuation) {
        TraeHttpConnection$safeCall$1 traeHttpConnection$safeCall$1;
        int i;
        long elapsedRealtime;
        String str3;
        TraeHttpConnection traeHttpConnection;
        Set<Long> set2;
        HttpDataResult.Error error;
        BizResponse<T> bizResponse;
        if (continuation instanceof TraeHttpConnection$safeCall$1) {
            traeHttpConnection$safeCall$1 = (TraeHttpConnection$safeCall$1) continuation;
            if ((traeHttpConnection$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                traeHttpConnection$safeCall$1.label -= Integer.MIN_VALUE;
                TraeHttpConnection$safeCall$1 traeHttpConnection$safeCall$12 = traeHttpConnection$safeCall$1;
                Object obj = traeHttpConnection$safeCall$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeHttpConnection$safeCall$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        Object createService$default = createService$default(this, str, cls, null, null, map, false, 44, null);
                        traeHttpConnection$safeCall$12.L$0 = this;
                        str3 = str2;
                        try {
                            traeHttpConnection$safeCall$12.L$1 = str3;
                            set2 = set;
                            traeHttpConnection$safeCall$12.L$2 = set2;
                            traeHttpConnection$safeCall$12.J$0 = elapsedRealtime;
                            traeHttpConnection$safeCall$12.label = 1;
                            obj = function2.invoke(createService$default, traeHttpConnection$safeCall$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            traeHttpConnection = this;
                        } catch (CancellationException e) {
                            e = e;
                            traeHttpConnection = this;
                            error = new HttpDataResult.Error(-1001, "", e, null, 8, null);
                            traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                            return error;
                        } catch (Throwable th) {
                            th = th;
                            traeHttpConnection = this;
                            ErrorInfo extractErrorInfo = traeHttpConnection.extractErrorInfo(th);
                            error = new HttpDataResult.Error(extractErrorInfo.getCode(), extractErrorInfo.getMessage(), th, null, 8, null);
                            traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                            return error;
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        str3 = str2;
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = str2;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j = traeHttpConnection$safeCall$12.J$0;
                    Set<Long> set3 = (Set) traeHttpConnection$safeCall$12.L$2;
                    String str4 = (String) traeHttpConnection$safeCall$12.L$1;
                    traeHttpConnection = (TraeHttpConnection) traeHttpConnection$safeCall$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        elapsedRealtime = j;
                        set2 = set3;
                        str3 = str4;
                    } catch (CancellationException e3) {
                        e = e3;
                        elapsedRealtime = j;
                        str3 = str4;
                        error = new HttpDataResult.Error(-1001, "", e, null, 8, null);
                        traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                        return error;
                    } catch (Throwable th3) {
                        th = th3;
                        elapsedRealtime = j;
                        str3 = str4;
                        ErrorInfo extractErrorInfo2 = traeHttpConnection.extractErrorInfo(th);
                        error = new HttpDataResult.Error(extractErrorInfo2.getCode(), extractErrorInfo2.getMessage(), th, null, 8, null);
                        traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                        return error;
                    }
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                    error = new HttpDataResult.Error(HttpErrorCode.NULL_POINTER, "BizResponse is null", new Exception("BizResponse is null"), null, 8, null);
                } else {
                    bizResponse.setupSuccessCodes(set2);
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    CopyOnWriteArrayList<IApiRespInterceptor> copyOnWriteArrayList = apiRespInterceptors;
                    if (!copyOnWriteArrayList.isEmpty()) {
                        Iterator<T> it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            if (((IApiRespInterceptor) it.next()).intercept(str3, bizResponse)) {
                                booleanRef.element = true;
                            }
                        }
                    }
                    error = new HttpDataResult.Success(bizResponse, booleanRef.element ? new ApiRespInterceptedException(null, 1, null) : null);
                }
                traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                return error;
            }
        }
        traeHttpConnection$safeCall$1 = new TraeHttpConnection$safeCall$1(this, continuation);
        TraeHttpConnection$safeCall$1 traeHttpConnection$safeCall$122 = traeHttpConnection$safeCall$1;
        Object obj2 = traeHttpConnection$safeCall$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeHttpConnection$safeCall$122.label;
        if (i != 0) {
        }
        bizResponse = (BizResponse) obj2;
        if (bizResponse != null) {
        }
        traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
        return error;
    }

    public final <S, T> HttpDataResult<T> safeCall(String baseUrl, String tag, Type outType, String interceptorPath, Class<S> apiClazz, Map<String, String> headers, Function1<? super S, SsResponse<String>> call, Set<Long> successCodes) {
        HttpDataResult.Error error;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkNotNullParameter(outType, "outType");
        Intrinsics.checkNotNullParameter(apiClazz, "apiClazz");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(successCodes, "successCodes");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (headers == null) {
            try {
                emptyMap = MapsKt.emptyMap();
            } catch (CancellationException e) {
                error = new HttpDataResult.Error(-1001, "", e, null, 8, null);
            } catch (Throwable th) {
                ErrorInfo extractErrorInfo = extractErrorInfo(th);
                error = new HttpDataResult.Error(extractErrorInfo.getCode(), extractErrorInfo.getMessage(), th, null, 8, null);
            }
        } else {
            emptyMap = headers;
        }
        SsResponse<String> ssResponse = (SsResponse) call.invoke(createService$default(this, tag, apiClazz, null, baseUrl, emptyMap, false, 36, null));
        if (ssResponse == null) {
            error = new HttpDataResult.Error(HttpErrorCode.NULL_POINTER, "ssResponse is null", new Exception("ssResponse is null"), null, 8, null);
        } else {
            boolean z = false;
            BizResponse<T> bizResponse = (BizResponse) httpGson.fromJson(ssResponse.body(), TypeToken.getParameterized(BizResponse.class, new Type[]{outType}).getType());
            bizResponse.setupSSResponse(ssResponse);
            bizResponse.setupSuccessCodes(successCodes);
            CopyOnWriteArrayList<IApiRespInterceptor> copyOnWriteArrayList = apiRespInterceptors;
            if (!copyOnWriteArrayList.isEmpty()) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (((IApiRespInterceptor) it.next()).intercept(interceptorPath, bizResponse)) {
                        z = true;
                    }
                }
            }
            Intrinsics.checkNotNull(bizResponse);
            error = new HttpDataResult.Success(bizResponse, z ? new ApiRespInterceptedException(null, 1, null) : null);
        }
        trackRequestEvent(interceptorPath, SystemClock.elapsedRealtime() - elapsedRealtime, error);
        return error;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(4:9|10|11|12)(2:46|47))(7:48|49|50|51|52|53|(1:55)(1:56))|13|14|(1:16)(5:20|(3:22|(4:25|(3:27|28|29)(1:31)|30|23)|32)|33|(1:35)|36)|17|18))|67|6|(0)(0)|13|14|(0)(0)|17|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ed, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0087 A[Catch: all -> 0x00eb, CancellationException -> 0x00ed, TryCatch #5 {CancellationException -> 0x00ed, all -> 0x00eb, blocks: (B:14:0x0083, B:16:0x0087, B:20:0x00a6, B:22:0x00ba, B:23:0x00c0, B:25:0x00c6, B:28:0x00d2, B:33:0x00d5, B:35:0x00dc, B:36:0x00e2), top: B:13:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6 A[Catch: all -> 0x00eb, CancellationException -> 0x00ed, TryCatch #5 {CancellationException -> 0x00ed, all -> 0x00eb, blocks: (B:14:0x0083, B:16:0x0087, B:20:0x00a6, B:22:0x00ba, B:23:0x00c0, B:25:0x00c6, B:28:0x00d2, B:33:0x00d5, B:35:0x00dc, B:36:0x00e2), top: B:13:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <S, T> Object safeCall(String str, Class<S> cls, Function2<? super S, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, String str2, Set<Long> set, Continuation<? super HttpDataResult<? extends T>> continuation) {
        TraeHttpConnection$safeCall$2 traeHttpConnection$safeCall$2;
        int i;
        long elapsedRealtime;
        String str3;
        TraeHttpConnection traeHttpConnection;
        Set<Long> set2;
        HttpDataResult.Error error;
        BizResponse<T> bizResponse;
        if (continuation instanceof TraeHttpConnection$safeCall$2) {
            traeHttpConnection$safeCall$2 = (TraeHttpConnection$safeCall$2) continuation;
            if ((traeHttpConnection$safeCall$2.label & Integer.MIN_VALUE) != 0) {
                traeHttpConnection$safeCall$2.label -= Integer.MIN_VALUE;
                TraeHttpConnection$safeCall$2 traeHttpConnection$safeCall$22 = traeHttpConnection$safeCall$2;
                Object obj = traeHttpConnection$safeCall$22.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeHttpConnection$safeCall$22.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        Object createService$default = createService$default(this, str, cls, null, null, null, false, 60, null);
                        traeHttpConnection$safeCall$22.L$0 = this;
                        str3 = str2;
                        try {
                            traeHttpConnection$safeCall$22.L$1 = str3;
                            set2 = set;
                            traeHttpConnection$safeCall$22.L$2 = set2;
                            traeHttpConnection$safeCall$22.J$0 = elapsedRealtime;
                            traeHttpConnection$safeCall$22.label = 1;
                            obj = function2.invoke(createService$default, traeHttpConnection$safeCall$22);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            traeHttpConnection = this;
                        } catch (CancellationException e) {
                            e = e;
                            traeHttpConnection = this;
                            error = new HttpDataResult.Error(-1001, "", e, null, 8, null);
                            traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                            return error;
                        } catch (Throwable th) {
                            th = th;
                            traeHttpConnection = this;
                            ErrorInfo extractErrorInfo = traeHttpConnection.extractErrorInfo(th);
                            error = new HttpDataResult.Error(extractErrorInfo.getCode(), extractErrorInfo.getMessage(), th, null, 8, null);
                            traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                            return error;
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        str3 = str2;
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = str2;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j = traeHttpConnection$safeCall$22.J$0;
                    Set<Long> set3 = (Set) traeHttpConnection$safeCall$22.L$2;
                    String str4 = (String) traeHttpConnection$safeCall$22.L$1;
                    traeHttpConnection = (TraeHttpConnection) traeHttpConnection$safeCall$22.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        elapsedRealtime = j;
                        set2 = set3;
                        str3 = str4;
                    } catch (CancellationException e3) {
                        e = e3;
                        elapsedRealtime = j;
                        str3 = str4;
                        error = new HttpDataResult.Error(-1001, "", e, null, 8, null);
                        traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                        return error;
                    } catch (Throwable th3) {
                        th = th3;
                        elapsedRealtime = j;
                        str3 = str4;
                        ErrorInfo extractErrorInfo2 = traeHttpConnection.extractErrorInfo(th);
                        error = new HttpDataResult.Error(extractErrorInfo2.getCode(), extractErrorInfo2.getMessage(), th, null, 8, null);
                        traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                        return error;
                    }
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                    error = new HttpDataResult.Error(HttpErrorCode.NULL_POINTER, "BizResponse is null", new Exception("BizResponse is null"), null, 8, null);
                } else {
                    bizResponse.setupSuccessCodes(set2);
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    CopyOnWriteArrayList<IApiRespInterceptor> copyOnWriteArrayList = apiRespInterceptors;
                    if (!copyOnWriteArrayList.isEmpty()) {
                        Iterator<T> it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            if (((IApiRespInterceptor) it.next()).intercept(str3, bizResponse)) {
                                booleanRef.element = true;
                            }
                        }
                    }
                    error = new HttpDataResult.Success(bizResponse, booleanRef.element ? new ApiRespInterceptedException(null, 1, null) : null);
                }
                traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
                return error;
            }
        }
        traeHttpConnection$safeCall$2 = new TraeHttpConnection$safeCall$2(this, continuation);
        TraeHttpConnection$safeCall$2 traeHttpConnection$safeCall$222 = traeHttpConnection$safeCall$2;
        Object obj2 = traeHttpConnection$safeCall$222.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeHttpConnection$safeCall$222.label;
        if (i != 0) {
        }
        bizResponse = (BizResponse) obj2;
        if (bizResponse != null) {
        }
        traeHttpConnection.trackRequestEvent(str3, SystemClock.elapsedRealtime() - elapsedRealtime, error);
        return error;
    }

    public static /* synthetic */ Object safeCall$default(TraeHttpConnection traeHttpConnection, String str, Class cls, Function2 function2, String str2, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            set = BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES();
        }
        return traeHttpConnection.safeCall(str, cls, function2, str3, set, continuation);
    }

    public final void appendParamToBody(Request.Builder builder, Request request, Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(function1, "appendParam");
        try {
            Result.Companion companion = Result.Companion;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            request.getBody().writeTo(byteArrayOutputStream);
            JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
            function1.invoke(jSONObject);
            String method = request.getMethod();
            String mimeType = request.getBody().mimeType();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            Result.constructor-impl(builder.method(method, new TypedByteArray(mimeType, bytes, new String[0])));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
