package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.lynx.tasm.LynxErrorBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 5;
    private static final int NUM_NETWORK_THREADS = 3;
    private final ExecutorService mExecutorService;
    private int mHttpConnectionTimeout;

    private static boolean isHttpRedirect(int i) {
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case GenericDraweeHierarchyBuilder.DEFAULT_FADE_DURATION /* 300 */:
            case 301:
            case LynxErrorBehavior.EB_RESOURCE_FONT /* 302 */:
            case LynxErrorBehavior.EB_RESOURCE_EXTERNAL_RESOURCE /* 303 */:
                return true;
            default:
                return false;
        }
    }

    private static boolean isHttpSuccess(int i) {
        return i >= 200 && i < 300;
    }

    public HttpUrlConnectionNetworkFetcher() {
        this(Executors.newFixedThreadPool(3));
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        this(Executors.newFixedThreadPool(3));
        this.mHttpConnectionTimeout = i;
    }

    HttpUrlConnectionNetworkFetcher(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public FetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new FetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(final FetchState fetchState, final NetworkFetcher.Callback callback) {
        final Future<?> submit = this.mExecutorService.submit(new Runnable() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.1
            @Override // java.lang.Runnable
            public void run() {
                HttpUrlConnectionNetworkFetcher.this.fetchSync(fetchState, callback);
            }
        });
        fetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (submit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.facebook.imagepipeline.producers.FetchState] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void fetchSync(FetchState fetchState, NetworkFetcher.Callback callback) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = downloadFrom(fetchState.getUri(), 5);
                if (httpURLConnection != null) {
                    try {
                        inputStream = httpURLConnection.getInputStream();
                        callback.onResponse(inputStream, -1);
                    } catch (IOException e) {
                        e = e;
                        callback.onFailure(e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (fetchState != 0) {
                    throw th;
                }
                fetchState.disconnect();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            fetchState = 0;
            if (0 != 0) {
            }
            if (fetchState != 0) {
            }
        }
        httpURLConnection.disconnect();
    }

    private HttpURLConnection downloadFrom(Uri uri, int i) throws IOException {
        HttpURLConnection openConnectionTo = openConnectionTo(uri);
        openConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
        int responseCode = openConnectionTo.getResponseCode();
        if (isHttpSuccess(responseCode)) {
            return openConnectionTo;
        }
        if (isHttpRedirect(responseCode)) {
            String headerField = openConnectionTo.getHeaderField("Location");
            openConnectionTo.disconnect();
            Uri parse = headerField == null ? null : Uri.parse(headerField);
            String scheme = uri.getScheme();
            if (i > 0 && parse != null && !parse.getScheme().equals(scheme)) {
                return downloadFrom(parse, i - 1);
            }
            throw new IOException(i == 0 ? error("URL %s follows too many redirects", uri.toString()) : error("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        openConnectionTo.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
    }

    static HttpURLConnection openConnectionTo(Uri uri) throws IOException {
        return (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
    }

    private static String error(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }
}
