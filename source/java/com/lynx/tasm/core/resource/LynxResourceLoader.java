package com.lynx.tasm.core.resource;

import android.text.TextUtils;
import com.lynx.tasm.ILynxErrorReceiver;
import com.lynx.tasm.LynxBackgroundRuntimeOptions;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxInfoReportHelper;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.component.DynamicComponentFetcher;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.provider.LynxExternalResourceFetcherWrapper;
import com.lynx.tasm.provider.LynxProviderRegistry;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import com.lynx.tasm.utils.UIThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxResourceLoader {
    static final String ASSETS_SCHEME = "assets://";
    static final String CORE_DEBUG_JS = "lynx_core_dev.js";
    static final String CORE_JS = "assets://lynx_core.js";
    static final String FILE_SCHEME = "file://";
    static final String LYNX_ASSETS_SCHEME = "lynx_assets://";
    static final String METHOD_NAME_LOAD_LOCAL_SCRIPT = "loadLocalResource";
    static final String METHOD_NAME_LOAD_SCRIPT = "loadExternalResource";
    static final String MSG_NULL_DATA = "get null data for provider.";
    static final int RESOURCE_LOADER_FAILED = -1;
    static final int RESOURCE_LOADER_SUCCESS = 0;
    static final String TAG = "LynxResourceLoader";
    private final LynxExternalResourceFetcherWrapper mFetcherWrapper;
    private final LynxGenericResourceFetcher mGenericResourceFetcher;
    private final LynxBackgroundRuntimeOptions mLynxRuntimeOptions;
    private final LynxInfoReportHelper mReportHelper = new LynxInfoReportHelper();
    private final TemplateLoaderHelper mTemplateLoaderHelper;
    private final WeakReference<ILynxErrorReceiver> mWeekErrorReceiver;

    private native void nativeConfigLynxResourceSetting();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeInvokeCallback(long j, byte[] bArr, long j2, ByteBuffer byteBuffer, int i, String str);

    private String toTypeString(int i) {
        return i != 7 ? i != 9 ? "" : LynxProviderRegistry.LYNX_PROVIDER_TYPE_EXTERNAL_JS : LynxProviderRegistry.LYNX_PROVIDER_TYPE_DYNAMIC_COMPONENT;
    }

    public LynxResourceLoader(LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions, DynamicComponentFetcher dynamicComponentFetcher, ILynxErrorReceiver iLynxErrorReceiver, LynxTemplateResourceFetcher lynxTemplateResourceFetcher, LynxGenericResourceFetcher lynxGenericResourceFetcher) {
        this.mLynxRuntimeOptions = lynxBackgroundRuntimeOptions;
        this.mFetcherWrapper = new LynxExternalResourceFetcherWrapper(dynamicComponentFetcher);
        this.mWeekErrorReceiver = new WeakReference<>(iLynxErrorReceiver);
        this.mTemplateLoaderHelper = new TemplateLoaderHelper(lynxTemplateResourceFetcher);
        this.mGenericResourceFetcher = lynxGenericResourceFetcher;
    }

    private void loadResource(final long j, final String str, final int i, boolean z) {
        if (z) {
            loadResource(j, str, i);
            return;
        }
        try {
            LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    LynxResourceLoader.this.loadResource(j, str, i);
                }
            });
        } catch (Throwable th) {
            InvokeNativeCallbackWithBytes(j, null, -1, th.getMessage());
        }
    }

    void loadResource(long j, String str, int i) {
        if (i == 7) {
            LynxResourceRequest.LynxResourceType lynxResourceType = LynxResourceRequest.LynxResourceType.LynxResourceTypeDynamicComponent;
            if (fetchTemplateByGenericTemplateFetcher(j, str, lynxResourceType) || fetchTemplateByFetcherWrapper(j, str, lynxResourceType) || fetchTemplateByProvider(j, str, lynxResourceType)) {
                return;
            }
            InvokeNativeCallbackWithBytes(j, null, -1, "No available provider or fetcher.");
            return;
        }
        if (i == 9) {
            if (fetchScriptByGenericFetcher(j, str) || fetchScriptByProvider(j, str)) {
                return;
            }
            InvokeNativeCallbackWithBytes(j, null, -1, "No available provider or fetcher.");
            return;
        }
        if (i == 11) {
            InvokeNativeCallbackWithBytes(j, loadJSSource(str), 0, null);
        } else {
            if (i == 15) {
                if (fetchTemplateByGenericTemplateFetcher(j, str, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate)) {
                    return;
                }
                InvokeNativeCallbackWithBytes(j, null, -1, "No available provider or fetcher.");
                return;
            }
            InvokeNativeCallbackWithBytes(j, null, -1, "Unsupported type" + i);
        }
    }

    void loadBytecode(long j, String str, int i) {
        if (i == 16) {
            if (this.mGenericResourceFetcher != null) {
                this.mGenericResourceFetcher.fetchBytecode(new LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeExternalByteCode), new LynxResourceCallback<byte[]>(str, j) { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.2
                    private final GenericResourceCallback callback;
                    final /* synthetic */ long val$responseHandler;
                    final /* synthetic */ String val$url;

                    {
                        this.val$url = str;
                        this.val$responseHandler = j;
                        this.callback = new GenericResourceCallback(LynxResourceLoader.this, str, j);
                    }

                    @Override // com.lynx.tasm.resourceprovider.LynxResourceCallback
                    public void onResponse(LynxResourceResponse<byte[]> lynxResourceResponse) {
                        boolean z = lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.SUCCESS;
                        Throwable error = lynxResourceResponse.getError();
                        this.callback.onResourceLoaded(z, lynxResourceResponse.getData(), error != null ? error.getMessage() : "");
                    }
                });
            } else {
                InvokeNativeCallbackWithBytes(j, null, -1, "No available provider or fetcher.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportError(final String str, final String str2, final int i, final String str3, final String str4) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.3
            @Override // java.lang.Runnable
            public void run() {
                ILynxErrorReceiver iLynxErrorReceiver = (ILynxErrorReceiver) LynxResourceLoader.this.mWeekErrorReceiver.get();
                if (iLynxErrorReceiver == null) {
                    return;
                }
                LynxError lynxError = new LynxError(i, String.format("%s %s failed, the error message is: %s", LynxResourceLoader.TAG, str, str3), "Please refer to the solution in Doc 'LynxError FAQ' on the official website.", "error");
                lynxError.setRootCause(str4);
                lynxError.addCustomInfo(PropsConstants.SRC, str2);
                iLynxErrorReceiver.onErrorOccurred(lynxError);
            }
        });
    }

    private byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] loadJSSource(String str) {
        InputStream inputStream;
        String message;
        InputStream inputStream2;
        if (TextUtils.isEmpty(str)) {
            LLog.w(TAG, "loadJSSource failed with empty name");
            return null;
        }
        LLog.i(TAG, "loadJSSource with name " + str);
        try {
            if (CORE_JS.equals(str) && LynxEnv.inst().isDevtoolEnabled()) {
                try {
                    inputStream2 = LynxEnv.inst().getAppContext().getResources().getAssets().open(CORE_DEBUG_JS);
                } catch (IOException e) {
                    e.printStackTrace();
                    inputStream2 = null;
                }
                if (inputStream2 != null) {
                    try {
                        nativeConfigLynxResourceSetting();
                    } catch (Throwable th) {
                        inputStream = inputStream2;
                        th = th;
                        try {
                            message = th.getMessage();
                            if (inputStream != null) {
                            }
                            if (message != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th2;
                        }
                    }
                }
            } else {
                inputStream2 = null;
            }
            if (inputStream2 == null) {
                if (str.length() > 7 && str.startsWith("file://")) {
                    String substring = str.substring(7);
                    inputStream2 = new FileInputStream(substring.startsWith("/") ? new File(substring) : new File(LynxEnv.inst().getAppContext().getFilesDir(), substring));
                } else if (str.length() > 9 && str.startsWith(ASSETS_SCHEME)) {
                    inputStream2 = LynxEnv.inst().getAppContext().getResources().getAssets().open(str.substring(9));
                } else if (str.startsWith(LYNX_ASSETS_SCHEME)) {
                    byte[] loadLynxJSAsset = loadLynxJSAsset(str);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return loadLynxJSAsset;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            message = th.getMessage();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            if (message != null) {
                reportError(METHOD_NAME_LOAD_LOCAL_SCRIPT, str, 30302, "Error when loading js source", message);
                LLog.e(TAG, "loadJSSource " + str + "with error message: " + message);
            }
            return null;
        }
        if (inputStream2 == null) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        }
        byte[] byteArray = toByteArray(inputStream2);
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused5) {
            }
        }
        return byteArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006f A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #5 {all -> 0x006b, blocks: (B:47:0x0056, B:8:0x006f), top: B:46:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] loadLynxJSAsset(String str) {
        InputStream inputStream;
        StringBuilder sb;
        IOException e;
        String[] split;
        String substring = str.substring(14);
        try {
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        if (LynxEnv.inst().isDevtoolEnabled()) {
            try {
                split = substring.split("\\.");
            } catch (IOException unused) {
            }
            if (split.length == 2) {
                inputStream = LynxEnv.inst().getAppContext().getResources().getAssets().open(split[0] + "_dev." + split[1]);
                if (inputStream == null) {
                    try {
                        inputStream = LynxEnv.inst().getAppContext().getResources().getAssets().open(substring);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            LLog.e(TAG, "loadLynxJSAsset " + str + "with error message " + th.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e = e2;
                                    sb = new StringBuilder("loadLynxJSAsset inputStream close error: ");
                                    LLog.e(TAG, sb.append(e.getMessage()).toString());
                                    LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                                    return null;
                                }
                            }
                            LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                            return null;
                        } finally {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    LLog.e(TAG, "loadLynxJSAsset inputStream close error: " + e3.getMessage());
                                }
                            }
                        }
                    }
                }
                if (inputStream == null) {
                    return toByteArray(inputStream);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        sb = new StringBuilder("loadLynxJSAsset inputStream close error: ");
                        LLog.e(TAG, sb.append(e.getMessage()).toString());
                        LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                        return null;
                    }
                }
                LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                return null;
            }
        }
        inputStream = null;
        if (inputStream == null) {
        }
        if (inputStream == null) {
        }
    }

    private boolean fetchTemplateByFetcherWrapper(long j, String str, LynxResourceRequest.LynxResourceType lynxResourceType) {
        return this.mFetcherWrapper.fetchResourceWithDynamicComponentFetcher(str, new LynxExternalResourceFetcherWrapper.LoadedHandler(str, j, lynxResourceType) { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.4
            private final TemplateResourceCallback mCallback;
            final /* synthetic */ LynxResourceRequest.LynxResourceType val$resourceType;
            final /* synthetic */ long val$responseHandler;
            final /* synthetic */ String val$url;

            {
                this.val$url = str;
                this.val$responseHandler = j;
                this.val$resourceType = lynxResourceType;
                this.mCallback = new TemplateResourceCallback(str, j, LynxResourceLoader.this.mReportHelper, lynxResourceType);
            }

            @Override // com.lynx.tasm.provider.LynxExternalResourceFetcherWrapper.LoadedHandler
            public void onLoaded(byte[] bArr, Throwable th) {
                this.mCallback.onTemplateLoaded(th == null, bArr, null, null, th != null ? th.getMessage() : null);
            }
        });
    }

    private boolean fetchTemplateByProvider(long j, String str, LynxResourceRequest.LynxResourceType lynxResourceType) {
        LynxResourceProvider resourceProviderByType = getResourceProviderByType(7);
        if (resourceProviderByType == null) {
            return false;
        }
        resourceProviderByType.request(new com.lynx.tasm.provider.LynxResourceRequest(str), new com.lynx.tasm.provider.LynxResourceCallback<byte[]>(str, j, lynxResourceType) { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.5
            private final TemplateResourceCallback mCallback;
            final /* synthetic */ LynxResourceRequest.LynxResourceType val$resourceType;
            final /* synthetic */ long val$responseHandler;
            final /* synthetic */ String val$url;

            {
                this.val$url = str;
                this.val$responseHandler = j;
                this.val$resourceType = lynxResourceType;
                this.mCallback = new TemplateResourceCallback(str, j, LynxResourceLoader.this.mReportHelper, lynxResourceType);
            }

            @Override // com.lynx.tasm.provider.LynxResourceCallback
            public void onResponse(com.lynx.tasm.provider.LynxResourceResponse<byte[]> lynxResourceResponse) {
                super.onResponse(lynxResourceResponse);
                this.mCallback.onTemplateLoaded(lynxResourceResponse.success(), lynxResourceResponse.getData(), null, null, lynxResourceResponse.getError() != null ? lynxResourceResponse.getError().getMessage() : null);
            }
        });
        return true;
    }

    private boolean fetchTemplateByGenericTemplateFetcher(long j, String str, LynxResourceRequest.LynxResourceType lynxResourceType) {
        boolean hasTemplateFetcher = this.mTemplateLoaderHelper.hasTemplateFetcher();
        LLog.i(TAG, "Generic template fetcher existed: " + hasTemplateFetcher);
        if (!hasTemplateFetcher) {
            return false;
        }
        this.mTemplateLoaderHelper.fetchTemplateByGenericTemplateFetcher(str, new TemplateResourceCallback(str, j, this.mReportHelper, lynxResourceType));
        return true;
    }

    private boolean fetchExternalByteCodeByGenericFetcher(long j, String str) {
        if (this.mGenericResourceFetcher == null) {
            return false;
        }
        this.mGenericResourceFetcher.fetchResource(new LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeExternalByteCode), new LynxResourceCallback<byte[]>(str, j) { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.6
            private final GenericResourceCallback callback;
            final /* synthetic */ long val$responseHandler;
            final /* synthetic */ String val$url;

            {
                this.val$url = str;
                this.val$responseHandler = j;
                this.callback = new GenericResourceCallback(LynxResourceLoader.this, str, j);
            }

            @Override // com.lynx.tasm.resourceprovider.LynxResourceCallback
            public void onResponse(LynxResourceResponse<byte[]> lynxResourceResponse) {
                boolean z = lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.SUCCESS;
                Throwable error = lynxResourceResponse.getError();
                this.callback.onResourceLoaded(z, lynxResourceResponse.getData(), error != null ? error.getMessage() : "");
            }
        });
        return true;
    }

    private boolean fetchScriptByGenericFetcher(long j, String str) {
        if (this.mGenericResourceFetcher == null) {
            return false;
        }
        this.mGenericResourceFetcher.fetchResource(new LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeExternalJSSource), new LynxResourceCallback<byte[]>(str, j) { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.7
            private final ExternalScriptResourceCallback callback;
            final /* synthetic */ long val$responseHandler;
            final /* synthetic */ String val$url;

            {
                this.val$url = str;
                this.val$responseHandler = j;
                this.callback = new ExternalScriptResourceCallback(LynxResourceLoader.this, str, j);
            }

            @Override // com.lynx.tasm.resourceprovider.LynxResourceCallback
            public void onResponse(LynxResourceResponse<byte[]> lynxResourceResponse) {
                boolean z = lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.SUCCESS;
                Throwable error = lynxResourceResponse.getError();
                this.callback.onScriptLoaded(z, lynxResourceResponse.getData(), error != null ? error.getMessage() : "");
            }
        });
        return true;
    }

    private boolean fetchScriptByProvider(long j, String str) {
        LynxResourceProvider resourceProviderByType = getResourceProviderByType(9);
        if (resourceProviderByType == null) {
            return false;
        }
        resourceProviderByType.request(new com.lynx.tasm.provider.LynxResourceRequest(str), new com.lynx.tasm.provider.LynxResourceCallback<byte[]>(str, j) { // from class: com.lynx.tasm.core.resource.LynxResourceLoader.8
            private final ExternalScriptResourceCallback callback;
            final /* synthetic */ long val$responseHandler;
            final /* synthetic */ String val$url;

            {
                this.val$url = str;
                this.val$responseHandler = j;
                this.callback = new ExternalScriptResourceCallback(LynxResourceLoader.this, str, j);
            }

            @Override // com.lynx.tasm.provider.LynxResourceCallback
            public void onResponse(com.lynx.tasm.provider.LynxResourceResponse<byte[]> lynxResourceResponse) {
                boolean success = lynxResourceResponse.success();
                Throwable error = lynxResourceResponse.getError();
                this.callback.onScriptLoaded(success, lynxResourceResponse.getData(), error != null ? error.getMessage() : null);
            }
        });
        return true;
    }

    private LynxResourceProvider getResourceProviderByType(int i) {
        LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions = this.mLynxRuntimeOptions;
        LynxResourceProvider resourceProvidersByKey = lynxBackgroundRuntimeOptions != null ? lynxBackgroundRuntimeOptions.getResourceProvidersByKey(toTypeString(i)) : null;
        if (resourceProvidersByKey == null) {
            LLog.e(TAG, "lynx resource provider is null, type: " + i);
        }
        return resourceProvidersByKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void InvokeNativeCallbackWithBytes(long j, byte[] bArr, int i, String str) {
        nativeInvokeCallback(j, bArr, 0L, null, i, str);
    }
}
