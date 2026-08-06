package net.openid.appauth;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Map;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.RegistrationResponse;
import net.openid.appauth.TokenResponse;
import net.openid.appauth.browser.BrowserDescriptor;
import net.openid.appauth.browser.BrowserSelector;
import net.openid.appauth.browser.CustomTabManager;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.internal.Logger;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class AuthorizationService {
    private final BrowserDescriptor mBrowser;
    private final AppAuthConfiguration mClientConfiguration;
    Context mContext;
    private final CustomTabManager mCustomTabManager;
    private boolean mDisposed;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface RegistrationResponseCallback {
        void onRegistrationRequestCompleted(RegistrationResponse registrationResponse, AuthorizationException authorizationException);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface TokenResponseCallback {
        void onTokenRequestCompleted(TokenResponse tokenResponse, AuthorizationException authorizationException);
    }

    public AuthorizationService(Context context) {
        this(context, AppAuthConfiguration.DEFAULT);
    }

    public AuthorizationService(Context context, AppAuthConfiguration appAuthConfiguration) {
        this(context, appAuthConfiguration, BrowserSelector.select(context, appAuthConfiguration.getBrowserMatcher()), new CustomTabManager(context));
    }

    AuthorizationService(Context context, AppAuthConfiguration appAuthConfiguration, BrowserDescriptor browserDescriptor, CustomTabManager customTabManager) {
        this.mDisposed = false;
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mClientConfiguration = appAuthConfiguration;
        this.mCustomTabManager = customTabManager;
        this.mBrowser = browserDescriptor;
        if (browserDescriptor == null || !browserDescriptor.useCustomTab.booleanValue()) {
            return;
        }
        customTabManager.bind(browserDescriptor.packageName);
    }

    public CustomTabManager getCustomTabManager() {
        return this.mCustomTabManager;
    }

    public BrowserDescriptor getBrowserDescriptor() {
        return this.mBrowser;
    }

    public CustomTabsIntent.Builder createCustomTabsIntentBuilder(Uri... uriArr) {
        checkNotDisposed();
        return this.mCustomTabManager.createTabBuilder(uriArr);
    }

    public void performAuthorizationRequest(AuthorizationRequest authorizationRequest, PendingIntent pendingIntent) {
        performAuthorizationRequest(authorizationRequest, pendingIntent, null, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performAuthorizationRequest(AuthorizationRequest authorizationRequest, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        performAuthorizationRequest(authorizationRequest, pendingIntent, pendingIntent2, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performAuthorizationRequest(AuthorizationRequest authorizationRequest, PendingIntent pendingIntent, CustomTabsIntent customTabsIntent) {
        performAuthorizationRequest(authorizationRequest, pendingIntent, null, customTabsIntent);
    }

    public void performAuthorizationRequest(AuthorizationRequest authorizationRequest, PendingIntent pendingIntent, PendingIntent pendingIntent2, CustomTabsIntent customTabsIntent) {
        checkNotDisposed();
        Preconditions.checkNotNull(authorizationRequest);
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(customTabsIntent);
        Intent prepareAuthorizationRequestIntent = prepareAuthorizationRequestIntent(authorizationRequest, customTabsIntent);
        Context context = this.mContext;
        context.startActivity(AuthorizationManagementActivity.createStartIntent(context, authorizationRequest, prepareAuthorizationRequestIntent, pendingIntent, pendingIntent2));
    }

    public Intent getAuthorizationRequestIntent(AuthorizationRequest authorizationRequest, CustomTabsIntent customTabsIntent) {
        return AuthorizationManagementActivity.createStartForResultIntent(this.mContext, authorizationRequest, prepareAuthorizationRequestIntent(authorizationRequest, customTabsIntent));
    }

    public Intent getAuthorizationRequestIntent(AuthorizationRequest authorizationRequest) {
        return getAuthorizationRequestIntent(authorizationRequest, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performTokenRequest(TokenRequest tokenRequest, TokenResponseCallback tokenResponseCallback) {
        performTokenRequest(tokenRequest, NoClientAuthentication.INSTANCE, tokenResponseCallback);
    }

    public void performTokenRequest(TokenRequest tokenRequest, ClientAuthentication clientAuthentication, TokenResponseCallback tokenResponseCallback) {
        checkNotDisposed();
        Logger.debug("Initiating code exchange request to %s", tokenRequest.configuration.tokenEndpoint);
        new TokenRequestTask(tokenRequest, clientAuthentication, this.mClientConfiguration.getConnectionBuilder(), tokenResponseCallback).execute(new Void[0]);
    }

    public void performRegistrationRequest(RegistrationRequest registrationRequest, RegistrationResponseCallback registrationResponseCallback) {
        checkNotDisposed();
        Logger.debug("Initiating dynamic client registration %s", registrationRequest.configuration.registrationEndpoint.toString());
        new RegistrationRequestTask(registrationRequest, this.mClientConfiguration.getConnectionBuilder(), registrationResponseCallback).execute(new Void[0]);
    }

    public void dispose() {
        if (this.mDisposed) {
            return;
        }
        this.mCustomTabManager.dispose();
        this.mDisposed = true;
    }

    private void checkNotDisposed() {
        if (this.mDisposed) {
            throw new IllegalStateException("Service has been disposed and rendered inoperable");
        }
    }

    private Intent prepareAuthorizationRequestIntent(AuthorizationRequest authorizationRequest, CustomTabsIntent customTabsIntent) {
        Intent intent;
        checkNotDisposed();
        if (this.mBrowser == null) {
            throw new ActivityNotFoundException();
        }
        Uri uri = authorizationRequest.toUri();
        if (this.mBrowser.useCustomTab.booleanValue()) {
            intent = customTabsIntent.intent;
        } else {
            intent = new Intent("android.intent.action.VIEW");
        }
        intent.setPackage(this.mBrowser.packageName);
        intent.setData(uri);
        Logger.debug("Using %s as browser for auth, custom tab = %s", intent.getPackage(), this.mBrowser.useCustomTab.toString());
        Logger.debug("Initiating authorization request to %s", authorizationRequest.configuration.authorizationEndpoint);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static class TokenRequestTask extends AsyncTask<Void, Void, JSONObject> {
        private TokenResponseCallback mCallback;
        private ClientAuthentication mClientAuthentication;
        private final ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException;
        private TokenRequest mRequest;

        TokenRequestTask(TokenRequest tokenRequest, ClientAuthentication clientAuthentication, ConnectionBuilder connectionBuilder, TokenResponseCallback tokenResponseCallback) {
            this.mRequest = tokenRequest;
            this.mClientAuthentication = clientAuthentication;
            this.mConnectionBuilder = connectionBuilder;
            this.mCallback = tokenResponseCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Void... voidArr) {
            InputStream inputStream;
            InputStream errorStream;
            InputStream inputStream2 = null;
            try {
                try {
                    HttpURLConnection openConnection = this.mConnectionBuilder.openConnection(this.mRequest.configuration.tokenEndpoint);
                    openConnection.setRequestMethod("POST");
                    openConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    addJsonToAcceptHeader(openConnection);
                    openConnection.setDoOutput(true);
                    Map<String, String> requestHeaders = this.mClientAuthentication.getRequestHeaders(this.mRequest.clientId);
                    if (requestHeaders != null) {
                        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                            openConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    Map<String, String> requestParameters = this.mRequest.getRequestParameters();
                    Map<String, String> requestParameters2 = this.mClientAuthentication.getRequestParameters(this.mRequest.clientId);
                    if (requestParameters2 != null) {
                        requestParameters.putAll(requestParameters2);
                    }
                    String formUrlEncode = UriUtil.formUrlEncode(requestParameters);
                    openConnection.setRequestProperty("Content-Length", String.valueOf(formUrlEncode.length()));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openConnection.getOutputStream());
                    outputStreamWriter.write(formUrlEncode);
                    outputStreamWriter.flush();
                    if (openConnection.getResponseCode() >= 200 && openConnection.getResponseCode() < 300) {
                        errorStream = openConnection.getInputStream();
                    } else {
                        errorStream = openConnection.getErrorStream();
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                }
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (JSONException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                JSONObject jSONObject = new JSONObject(Utils.readInputStream(errorStream));
                Utils.closeQuietly(errorStream);
                return jSONObject;
            } catch (IOException e3) {
                inputStream = errorStream;
                e = e3;
                Logger.debugWithStack(e, "Failed to complete exchange request", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e);
                Utils.closeQuietly(inputStream);
                return null;
            } catch (JSONException e4) {
                inputStream = errorStream;
                e = e4;
                Logger.debugWithStack(e, "Failed to complete exchange request", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                Utils.closeQuietly(inputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = errorStream;
                Utils.closeQuietly(inputStream2);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject jSONObject) {
            AuthorizationException fromTemplate;
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onTokenRequestCompleted(null, authorizationException);
                return;
            }
            if (jSONObject.has(AuthorizationException.PARAM_ERROR)) {
                try {
                    String string = jSONObject.getString(AuthorizationException.PARAM_ERROR);
                    fromTemplate = AuthorizationException.fromOAuthTemplate(AuthorizationException.TokenRequestErrors.byString(string), string, jSONObject.optString(AuthorizationException.PARAM_ERROR_DESCRIPTION, null), UriUtil.parseUriIfAvailable(jSONObject.optString(AuthorizationException.PARAM_ERROR_URI)));
                } catch (JSONException e) {
                    fromTemplate = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                }
                this.mCallback.onTokenRequestCompleted(null, fromTemplate);
                return;
            }
            try {
                TokenResponse build = new TokenResponse.Builder(this.mRequest).fromResponseJson(jSONObject).build();
                Logger.debug("Token exchange with %s completed", this.mRequest.configuration.tokenEndpoint);
                this.mCallback.onTokenRequestCompleted(build, null);
            } catch (JSONException e2) {
                this.mCallback.onTokenRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e2));
            }
        }

        private void addJsonToAcceptHeader(URLConnection uRLConnection) {
            if (TextUtils.isEmpty(uRLConnection.getRequestProperty("Accept"))) {
                uRLConnection.setRequestProperty("Accept", "application/json");
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    private static class RegistrationRequestTask extends AsyncTask<Void, Void, JSONObject> {
        private RegistrationResponseCallback mCallback;
        private final ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException;
        private RegistrationRequest mRequest;

        RegistrationRequestTask(RegistrationRequest registrationRequest, ConnectionBuilder connectionBuilder, RegistrationResponseCallback registrationResponseCallback) {
            this.mRequest = registrationRequest;
            this.mConnectionBuilder = connectionBuilder;
            this.mCallback = registrationResponseCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v2 */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Void... voidArr) {
            InputStream inputStream;
            String jsonString = this.mRequest.toJsonString();
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection openConnection = this.mConnectionBuilder.openConnection(this.mRequest.configuration.registrationEndpoint);
                    openConnection.setRequestMethod("POST");
                    openConnection.setRequestProperty("Content-Type", "application/json");
                    openConnection.setDoOutput(true);
                    openConnection.setRequestProperty("Content-Length", String.valueOf(jsonString.length()));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openConnection.getOutputStream());
                    outputStreamWriter.write(jsonString);
                    outputStreamWriter.flush();
                    inputStream = openConnection.getInputStream();
                    try {
                        JSONObject jSONObject = new JSONObject(Utils.readInputStream(inputStream));
                        Utils.closeQuietly(inputStream);
                        return jSONObject;
                    } catch (IOException e) {
                        e = e;
                        Logger.debugWithStack(e, "Failed to complete registration request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e);
                        Utils.closeQuietly(inputStream);
                        return null;
                    } catch (JSONException e2) {
                        e = e2;
                        Logger.debugWithStack(e, "Failed to complete registration request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                        Utils.closeQuietly(inputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = jsonString;
                    Utils.closeQuietly(r2);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (JSONException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                Utils.closeQuietly(r2);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject jSONObject) {
            AuthorizationException fromTemplate;
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onRegistrationRequestCompleted(null, authorizationException);
                return;
            }
            if (jSONObject.has(AuthorizationException.PARAM_ERROR)) {
                try {
                    String string = jSONObject.getString(AuthorizationException.PARAM_ERROR);
                    fromTemplate = AuthorizationException.fromOAuthTemplate(AuthorizationException.RegistrationRequestErrors.byString(string), string, jSONObject.getString(AuthorizationException.PARAM_ERROR_DESCRIPTION), UriUtil.parseUriIfAvailable(jSONObject.getString(AuthorizationException.PARAM_ERROR_URI)));
                } catch (JSONException e) {
                    fromTemplate = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                }
                this.mCallback.onRegistrationRequestCompleted(null, fromTemplate);
                return;
            }
            try {
                RegistrationResponse build = new RegistrationResponse.Builder(this.mRequest).fromResponseJson(jSONObject).build();
                Logger.debug("Dynamic registration with %s completed", this.mRequest.configuration.registrationEndpoint);
                this.mCallback.onRegistrationRequestCompleted(build, null);
            } catch (RegistrationResponse.MissingArgumentException e2) {
                Logger.errorWithStack(e2, "Malformed registration response", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.INVALID_REGISTRATION_RESPONSE, e2);
            } catch (JSONException e3) {
                this.mCallback.onRegistrationRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e3));
            }
        }
    }
}
