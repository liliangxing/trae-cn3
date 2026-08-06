package com.bytedance.frameworks.baselib.network.http;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BaseRequestContext {
    public AuthCredentials authCredentials;
    public boolean force_handle_response;
    public boolean ignoreCheckMinInputStreamBufferSize;
    public int input_stream_buffer_size;
    public IOkHttpRequestClientBuilderHook okHttpRequestClientBuilderHook;
    public int output_stream_buffer_size;
    public long protect_timeout;
    public boolean read_error_response;
    public String remoteIp;
    public int request_flag;
    public List<RotationHostRetryInfo> rotationHostRetryInfoList;
    public long socket_connect_timeout;
    public long socket_read_timeout;
    public long socket_write_timeout;
    public int status;

    @Deprecated
    public boolean streaming_force_return_response;
    public long throttle_net_speed;
    public long timeout_connect;
    public long timeout_read;
    public long timeout_write;
    public boolean force_use_okhttp = false;
    public int request_type_flags = 0;
    public boolean bypass_network_status_check = true;
    public boolean followRedirectInternal = true;
    public boolean enable_http_cache = false;

    @Deprecated
    public boolean is_need_monitor_in_cancel = true;
    public boolean bypassCookie = false;
    public boolean isCustomizedCookie = false;
    public boolean byPassProxy = false;
    public JSONObject extraInfo = new JSONObject();
    public int priorityLevel = -999;
    public int commonParamLevel = -1;

    /* loaded from: classes2.dex */
    public interface IOkHttpRequestClientBuilderHook {
        void addBuilderConfig(OkHttpClient.Builder builder);
    }

    /* loaded from: classes2.dex */
    public static class AuthCredentials {
        public String password;
        public String username;

        public String toString() {
            return "AuthCredentials{username=" + this.username + ", password=" + this.password + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* loaded from: classes2.dex */
    public static class RotationHostRetryInfo {
        public String host;
        public String path;

        public RotationHostRetryInfo(String str, String str2) {
            this.host = str;
            this.path = str2;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RotationHostRetryInfo m7692clone() {
            return new RotationHostRetryInfo(this.host, this.path);
        }
    }
}
