package com.bytedance.sdk.account.platform.base;

import android.net.Uri;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class Request {
    public final String authTicket;
    public final int authType;
    public final String callerLocalEntry;
    public final Bundle extra;
    public final String language;
    public final String maskPhoneNumber;
    public final Set<String> optionalScopes0;
    public final Set<String> optionalScopes1;
    public final Uri redirectUri;
    public final String responseType;
    public final Map<String, String> scopeToFields;
    public final Set<String> scopes;
    public final String state;

    /* loaded from: classes5.dex */
    public interface ResponseType {
        public static final String CODE = "code";
        public static final String ID_TOKEN = "id_token";
        public static final String TOKEN = "token";
    }

    private Request(Builder builder) {
        if (builder.scopes != null) {
            this.scopes = builder.scopes;
        } else {
            this.scopes = new HashSet();
        }
        if (builder.optionalScopes0 != null) {
            this.optionalScopes0 = builder.optionalScopes0;
        } else {
            this.optionalScopes0 = new HashSet();
        }
        if (builder.optionalScopes1 != null) {
            this.optionalScopes1 = builder.optionalScopes1;
        } else {
            this.optionalScopes1 = new HashSet();
        }
        this.state = builder.state;
        this.callerLocalEntry = builder.callerLocalEntry;
        if (builder.extra != null) {
            this.extra = builder.extra;
        } else {
            this.extra = new Bundle();
        }
        this.responseType = builder.responseType;
        this.language = builder.language;
        this.redirectUri = builder.redirectUri;
        this.authTicket = builder.authTicket;
        this.maskPhoneNumber = builder.maskPhoneNumber;
        this.authType = builder.authType;
        this.scopeToFields = builder.scopeToFields;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        String authTicket;
        int authType;
        String callerLocalEntry;
        Bundle extra;
        String language;
        String maskPhoneNumber;
        Set<String> optionalScopes0;
        Set<String> optionalScopes1;
        Uri redirectUri;
        String responseType;
        Map<String, String> scopeToFields;
        Set<String> scopes;
        String state;

        public Builder() {
        }

        Builder(Request request) {
            this.scopes = request.scopes;
            this.optionalScopes0 = request.optionalScopes0;
            this.optionalScopes1 = request.optionalScopes1;
            this.state = request.state;
            this.callerLocalEntry = request.callerLocalEntry;
            this.extra = request.extra;
            this.responseType = request.responseType;
            this.language = request.language;
            this.redirectUri = request.redirectUri;
            this.authTicket = request.authTicket;
            this.maskPhoneNumber = request.maskPhoneNumber;
            this.authType = request.authType;
            this.scopeToFields = request.scopeToFields;
        }

        public Builder setScopes(Set<String> set) {
            this.scopes = set;
            return this;
        }

        public Builder setOptionalScopes0(Set<String> set) {
            this.optionalScopes0 = set;
            return this;
        }

        public Builder setOptionalScopes1(Set<String> set) {
            this.optionalScopes1 = set;
            return this;
        }

        public Builder setState(String str) {
            this.state = str;
            return this;
        }

        public Builder setCallerLocalEntry(String str) {
            this.callerLocalEntry = str;
            return this;
        }

        public Builder setExtra(Bundle bundle) {
            this.extra = bundle;
            return this;
        }

        public Builder setResponseType(String str) {
            this.responseType = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.language = str;
            return this;
        }

        public Builder setRedirectUri(Uri uri) {
            this.redirectUri = uri;
            return this;
        }

        public Builder setAuthTicket(String str) {
            this.authTicket = str;
            return this;
        }

        public Builder setMaskPhoneNumber(String str) {
            this.maskPhoneNumber = str;
            return this;
        }

        public Builder setAuthType(int i) {
            this.authType = i;
            return this;
        }

        public Builder setScopeToFields(Map<String, String> map) {
            this.scopeToFields = map;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
