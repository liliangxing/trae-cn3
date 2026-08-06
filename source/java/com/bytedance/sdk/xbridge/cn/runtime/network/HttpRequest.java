package com.bytedance.sdk.xbridge.cn.runtime.network;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XNetworkRequestImpl;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u0002042\u0006\u00101\u001a\u000202J\u000e\u00105\u001a\u0002042\u0006\u00101\u001a\u000202J\u000e\u00106\u001a\u0002002\u0006\u00101\u001a\u000202J\u000e\u00107\u001a\u0002042\u0006\u00101\u001a\u000202J\u000e\u00108\u001a\u0002002\u0006\u00101\u001a\u000202J\u000e\u00109\u001a\u0002002\u0006\u00101\u001a\u000202J\u0006\u0010:\u001a\u00020\u0003J*\u0010\u0019\u001a\u00020\u00002\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0017j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0018J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0013J\u001a\u0010!\u001a\u00020\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 J*\u0010%\u001a\u00020\u00002\"\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0\u0017j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$`\u0018J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\nJ\u0010\u0010*\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010)J\u0010\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\nR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R^\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00182&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R:\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010 2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010 @BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R^\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$\u0018\u0001`\u00182&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$\u0018\u0001`\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001e\u0010'\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\rR\"\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0005\u001a\u0004\u0018\u00010)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\r¨\u0006="}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/network/HttpRequest;", "", IWeixinService.ResponseConstants.URL, "", "(Ljava/lang/String;)V", "<set-?>", "", "cacheTime", "getCacheTime", "()I", "", "connectTimeOut", "getConnectTimeOut", "()J", "contentEncoding", "getContentEncoding", "()Ljava/lang/String;", "contentType", "getContentType", "", "customCookie", "getCustomCookie", "()Z", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "headers", "getHeaders", "()Ljava/util/LinkedHashMap;", "maxLength", "getMaxLength", "needAddCommonParams", "getNeedAddCommonParams", "", "params", "getParams", "()Ljava/util/Map;", "Ljava/io/File;", "postFilePart", "getPostFilePart", "readTimeOut", "getReadTimeOut", "", "sendData", "getSendData", "()[B", "writeTimeOut", "getWriteTimeOut", "doDeleteForString", "Lcom/bytedance/sdk/xbridge/cn/runtime/network/AbsStringConnection;", "hostNetworkDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "doDownloadFile", "Lcom/bytedance/sdk/xbridge/cn/runtime/network/AbsStreamConnection;", "doGetForStream", "doGetForString", "doPostForStream", "doPostForString", "doPutForString", "getUrl", "setCustomCookie", "setMaxLength", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HttpRequest {
    private int cacheTime;
    private long connectTimeOut;
    private String contentEncoding;
    private String contentType;
    private boolean customCookie;
    private LinkedHashMap<String, String> headers;
    private int maxLength;
    private boolean needAddCommonParams;
    private Map<String, String> params;
    private LinkedHashMap<String, File> postFilePart;
    private long readTimeOut;
    private byte[] sendData;
    private String url;
    private long writeTimeOut;

    public HttpRequest(String str) {
        Intrinsics.checkNotNullParameter(str, IWeixinService.ResponseConstants.URL);
        this.url = str;
        this.maxLength = -1;
    }

    public final int getCacheTime() {
        return this.cacheTime;
    }

    public final LinkedHashMap<String, String> getHeaders() {
        return this.headers;
    }

    public final boolean getNeedAddCommonParams() {
        return this.needAddCommonParams;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final byte[] getSendData() {
        return this.sendData;
    }

    public final String getContentEncoding() {
        return this.contentEncoding;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final long getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public final long getReadTimeOut() {
        return this.readTimeOut;
    }

    public final long getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public final LinkedHashMap<String, File> getPostFilePart() {
        return this.postFilePart;
    }

    public final boolean getCustomCookie() {
        return this.customCookie;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final String getUrl() {
        return this.url;
    }

    public final HttpRequest cacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
        return this;
    }

    public final HttpRequest headers(LinkedHashMap<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
        return this;
    }

    public final HttpRequest needAddCommonParams(boolean needAddCommonParams) {
        this.needAddCommonParams = needAddCommonParams;
        return this;
    }

    public final HttpRequest params(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        return this;
    }

    public final HttpRequest postFilePart(LinkedHashMap<String, File> postFilePart) {
        Intrinsics.checkNotNullParameter(postFilePart, "postFilePart");
        this.postFilePart = postFilePart;
        return this;
    }

    public final HttpRequest sendData(byte[] sendData) {
        this.sendData = sendData;
        return this;
    }

    public final HttpRequest contentEncoding(String contentEncoding) {
        Intrinsics.checkNotNullParameter(contentEncoding, "contentEncoding");
        this.contentEncoding = contentEncoding;
        return this;
    }

    public final HttpRequest contentType(String contentType) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    public final HttpRequest connectTimeOut(long connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
        return this;
    }

    public final HttpRequest readTimeOut(long readTimeOut) {
        this.readTimeOut = readTimeOut;
        return this;
    }

    public final HttpRequest writeTimeOut(long writeTimeOut) {
        this.writeTimeOut = writeTimeOut;
        return this;
    }

    public static /* synthetic */ HttpRequest setCustomCookie$default(HttpRequest httpRequest, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return httpRequest.setCustomCookie(z);
    }

    public final HttpRequest setCustomCookie(boolean customCookie) {
        this.customCookie = customCookie;
        return this;
    }

    public final HttpRequest setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public final AbsStringConnection doGetForString(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        return XNetworkRequestImpl.INSTANCE.requestForString(RequestMethod.GET, this, hostNetworkDepend);
    }

    public final AbsStringConnection doPostForString(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        return XNetworkRequestImpl.INSTANCE.requestForString(RequestMethod.POST, this, hostNetworkDepend);
    }

    public final AbsStreamConnection doPostForStream(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        return XNetworkRequestImpl.INSTANCE.requestForStream(RequestMethod.POST, this, hostNetworkDepend);
    }

    public final AbsStringConnection doPutForString(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        return XNetworkRequestImpl.INSTANCE.requestForString(RequestMethod.PUT, this, hostNetworkDepend);
    }

    public final AbsStringConnection doDeleteForString(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        return XNetworkRequestImpl.INSTANCE.requestForString(RequestMethod.DELETE, this, hostNetworkDepend);
    }

    public final AbsStreamConnection doDownloadFile(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        return XNetworkRequestImpl.INSTANCE.requestForStream(RequestMethod.DOWNLOAD, this, hostNetworkDepend);
    }

    public final AbsStreamConnection doGetForStream(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        return XNetworkRequestImpl.INSTANCE.requestForStream(RequestMethod.GET, this, hostNetworkDepend);
    }
}
