package com.bytedance.sdk.account.impl;

import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.IBDAccountPlatformAPI;
import com.bytedance.sdk.account.api.OauthTokenExtraParams;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.PlatformAuthTokenResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.CanAwemeQuickLoginCallback;
import com.bytedance.sdk.account.api.response.AuthCodeAccessTokenResponse;
import com.bytedance.sdk.account.api.response.AuthLoginAuthorizeResponse;
import com.bytedance.sdk.account.api.response.GetOauthTokenResponse;
import com.bytedance.sdk.account.api.response.OpenTokenInfoResponse;
import com.bytedance.sdk.account.api.response.UpdateAuthorizeInfoResponse;
import com.bytedance.sdk.account.information.method.oauth_profile.OauthProfileCallback;
import com.bytedance.sdk.open.douyin.p002ui.DouYinWebAuthorizeActivity;
import com.ss.android.account.UserBindCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDAccountPlatformChinaImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J¡\u0001\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\u000b\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001JÍ\u0001\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112F\u0010\u0012\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\u0013\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00140\u0014H\u0096\u0001JÍ\u0001\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112F\u0010\u0012\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\u0013\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00140\u0014H\u0096\u0001JÍ\u0001\u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\u000e\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\u0012\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00180\u0018 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00140\u0014H\u0096\u0001J}\u0010\u0019\u001a\u00020\u00042F\u0010\u0005\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u001a0\u001a \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u00140\u0014H\u0096\u0001Jù\u0001\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0013\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u001e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\u001f\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u000e\u0010 \u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u0019\u0010!\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\"0\"H\u0096\u0001J<\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0014JÁ\u0001\u0010*\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\u0012\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u000e\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010+0+H\u0096\u0001J\u0099\u0001\u0010,\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2F\u0010\u000b\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010+0+H\u0096\u0001J©\u0001\u0010,\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000b\u001a\u00020\u001c2F\u0010\u000e\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u000e\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010+0+H\u0096\u0001J\u0099\u0001\u0010-\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2F\u0010\u000b\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010+0+H\u0096\u0001Jà\u0001\u0010.\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062,\u0010\t\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010/0/2F\u0010\n\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010&0&2*\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010)0) \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010)0)\u0018\u00010\u00140\u0014H\u0096\u0001¢\u0006\u0002\u00100JØ\u0001\u0010.\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062,\u0010\t\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010/0/2F\u0010\n\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2\u0006\u0010\u000b\u001a\u00020\u00112*\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010)0) \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010)0)\u0018\u00010\u00140\u0014H\u0096\u0001¢\u0006\u0002\u00101J\u00ad\u0001\u0010.\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\n\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\u000b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010)0) \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010)0)\u0018\u00010\u00140\u0014H\u0096\u0001J\u009d\u0001\u00102\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\t\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\n\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010303 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010303\u0018\u00010\u00140\u0014H\u0096\u0001J»\u0001\u00104\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000e\u001a\u00020\u001c2,\u0010\u0012\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u0013\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010707 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010707\u0018\u00010606H\u0096\u0001J\u0093\u0001\u00108\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062,\u0010\n\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u000b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u00ad\u0001\u00109\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\n\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\u000b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J«\u0001\u0010:\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062,\u0010\u000e\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u0012\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u007f\u0010;\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u008f\u0001\u0010;\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000b\u001a\u00020\u001c2,\u0010\u000e\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u009b\u0001\u0010<\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J«\u0001\u0010<\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000b\u001a\u00020\u001c2,\u0010\u000e\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u0012\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u009b\u0001\u0010=\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u007f\u0010>\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J³\u0001\u0010?\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112,\u0010\u0012\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u0013\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u009b\u0001\u0010@\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u009b\u0001\u0010A\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u007f\u0010B\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u009b\u0001\u0010C\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012*\u0010\u000e\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u0015\u0018\u00010606H\u0096\u0001J\u007f\u0010D\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2,\u0010\u000b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u008f\u0001\u0010E\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062,\u0010\u000e\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u008f\u0001\u0010F\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\n\u001a\u00020\u001c2\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062,\u0010\u000e\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001JE\u0010G\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062*\u0010\b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010H0H \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010H0H\u0018\u00010606H\u0096\u0001J]\u0010G\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\b\u001a\u00020I2\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062*\u0010\n\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010H0H \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010H0H\u0018\u00010606H\u0096\u0001J\u008d\u0001\u0010G\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\b\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\t\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010H0H \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010H0H\u0018\u00010606H\u0096\u0001JÝ\u0001\u0010J\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\u0012\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\u0013\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010K0K \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010K0K\u0018\u00010\u00140\u0014H\u0096\u0001J\u00ad\u0001\u0010J\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062F\u0010\n\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\f2*\u0010\u000b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010K0K \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010K0K\u0018\u00010\u00140\u0014H\u0096\u0001JW\u0010L\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062,\u0010\b\u001a(\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u000105 \u0007*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¨\u0006\u00010\f¨\u0006\u00012\u000e\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001¨\u0006M"}, d2 = {"Lcom/bytedance/sdk/account/impl/BDAccountPlatformChinaImpl;", "Lcom/bytedance/sdk/account/api/IBDAccountPlatformAPI;", "()V", "authBindLoginWithProfileKey", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "p2", "p3", "p4", "", "", "p5", "Lcom/ss/android/account/UserBindCallback;", "authChangeBind", "", "p6", "p7", "Lcom/bytedance/sdk/account/CommonCallBack;", "Lcom/bytedance/sdk/account/api/call/UserApiResponse;", "authChangeBindWithAuthCodeOrAccessToken", "authCodeAccessToken", "Lcom/bytedance/sdk/account/api/response/AuthCodeAccessTokenResponse;", "authLoginAuthorize", "Lcom/bytedance/sdk/account/api/response/AuthLoginAuthorizeResponse;", "bindWithMobile", "", "p8", "p9", "p10", "p11", "canAwemeQuickLogin", "Lcom/bytedance/sdk/account/api/callback/CanAwemeQuickLoginCallback;", "getDouyinOauthToken", "platformAppId", "eventParams", "Lcom/bytedance/sdk/account/api/OauthTokenExtraParams;", "extra", "call", "Lcom/bytedance/sdk/account/api/response/GetOauthTokenResponse;", "getOauthProfile", "Lcom/bytedance/sdk/account/information/method/oauth_profile/OauthProfileCallback;", "getOauthProfileByAccessToken", "getOauthProfileByCode", "getOauthToken", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/sdk/account/api/OauthTokenExtraParams;Lcom/bytedance/sdk/account/CommonCallBack;)V", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/Map;ZLcom/bytedance/sdk/account/CommonCallBack;)V", "openTokenInfo", "Lcom/bytedance/sdk/account/api/response/OpenTokenInfoResponse;", "platformAuthToken", "", "Lcom/bytedance/sdk/account/api/call/AbsApiCall;", "Lcom/bytedance/sdk/account/api/call/PlatformAuthTokenResponse;", "shareLogin", "ssoCheckBindLogin", "ssoSwitchBindWithAuthToken", "ssoWithAccessTokenBind", "ssoWithAccessTokenLogin", "ssoWithAccessTokenOnlyLogin", "ssoWithAuthCodeBind", "ssoWithAuthCodeBindMobileLogin", "ssoWithAuthCodeLogin", "ssoWithAuthCodeOnlyLogin", "ssoWithProfileKeyBind", "ssoWithProfileKeyLogin", "ssoWithProfileKeyRegister", "switchBindWithAccessToken", "switchBindWithAuthCode", "unbindPlatform", "Lcom/bytedance/sdk/account/api/call/BaseApiResponse;", "", "updateAuthorizeInfo", "Lcom/bytedance/sdk/account/api/response/UpdateAuthorizeInfoResponse;", "webAuth", "account_china_adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BDAccountPlatformChinaImpl implements IBDAccountPlatformAPI {
    public static final BDAccountPlatformChinaImpl INSTANCE = new BDAccountPlatformChinaImpl();
    private final /* synthetic */ IBDAccountPlatformAPI $$delegate_0;

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authBindLoginWithProfileKey(String p0, String p1, String p2, String p3, Map<String, String> p4, UserBindCallback p5) {
        this.$$delegate_0.authBindLoginWithProfileKey(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authChangeBind(String p0, String p1, String p2, String p3, boolean p4, boolean p5, Map<String, String> p6, CommonCallBack<UserApiResponse> p7) {
        this.$$delegate_0.authChangeBind(p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authChangeBindWithAuthCodeOrAccessToken(String p0, String p1, String p2, String p3, boolean p4, boolean p5, Map<String, String> p6, CommonCallBack<UserApiResponse> p7) {
        this.$$delegate_0.authChangeBindWithAuthCodeOrAccessToken(p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authCodeAccessToken(String p0, String p1, String p2, String p3, String p4, Map<String, String> p5, CommonCallBack<AuthCodeAccessTokenResponse> p6) {
        this.$$delegate_0.authCodeAccessToken(p0, p1, p2, p3, p4, p5, p6);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authLoginAuthorize(Map<String, String> p0, CommonCallBack<AuthLoginAuthorizeResponse> p1) {
        this.$$delegate_0.authLoginAuthorize(p0, p1);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void bindWithMobile(String p0, String p1, String p2, String p3, String p4, String p5, String p6, long p7, String p8, String p9, Map<String, String> p10, UserBindCallback p11) {
        this.$$delegate_0.bindWithMobile(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void canAwemeQuickLogin(CanAwemeQuickLoginCallback p0) {
        this.$$delegate_0.canAwemeQuickLogin(p0);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfile(String p0, String p1, String p2, String p3, String p4, String p5, Map<String, String> p6, OauthProfileCallback p7) {
        this.$$delegate_0.getOauthProfile(p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfileByAccessToken(String p0, String p1, String p2, long p3, Map<String, String> p4, OauthProfileCallback p5) {
        this.$$delegate_0.getOauthProfileByAccessToken(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfileByAccessToken(String p0, String p1, String p2, String p3, long p4, Map<String, String> p5, OauthProfileCallback p6) {
        this.$$delegate_0.getOauthProfileByAccessToken(p0, p1, p2, p3, p4, p5, p6);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfileByCode(String p0, String p1, String p2, long p3, Map<String, String> p4, OauthProfileCallback p5) {
        this.$$delegate_0.getOauthProfileByCode(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthToken(String p0, String p1, String p2, Map<String, String> p3, CommonCallBack<GetOauthTokenResponse> p4) {
        this.$$delegate_0.getOauthToken(p0, p1, p2, p3, p4);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthToken(String p0, String p1, String[] p2, Map<String, String> p3, OauthTokenExtraParams p4, CommonCallBack<GetOauthTokenResponse> p5) {
        this.$$delegate_0.getOauthToken(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthToken(String p0, String p1, String[] p2, Map<String, String> p3, boolean p4, CommonCallBack<GetOauthTokenResponse> p5) {
        this.$$delegate_0.getOauthToken(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void openTokenInfo(String p0, String p1, Map<String, String> p2, CommonCallBack<OpenTokenInfoResponse> p3) {
        this.$$delegate_0.openTokenInfo(p0, p1, p2, p3);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void platformAuthToken(String p0, String p1, String p2, String p3, String p4, long p5, Map<Object, Object> p6, AbsApiCall<PlatformAuthTokenResponse> p7) {
        this.$$delegate_0.platformAuthToken(p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void shareLogin(String p0, String p1, String p2, Map<Object, Object> p3, AbsApiCall<UserApiResponse> p4) {
        this.$$delegate_0.shareLogin(p0, p1, p2, p3, p4);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoCheckBindLogin(String p0, String p1, String p2, Map<String, String> p3, AbsApiCall<UserApiResponse> p4) {
        this.$$delegate_0.ssoCheckBindLogin(p0, p1, p2, p3, p4);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoSwitchBindWithAuthToken(String p0, String p1, String p2, long p3, String p4, Map<Object, Object> p5, AbsApiCall<UserApiResponse> p6) {
        this.$$delegate_0.ssoSwitchBindWithAuthToken(p0, p1, p2, p3, p4, p5, p6);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenBind(String p0, String p1, String p2, long p3, Map<Object, Object> p4, UserBindCallback p5) {
        this.$$delegate_0.ssoWithAccessTokenBind(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenBind(String p0, String p1, String p2, String p3, long p4, Map<Object, Object> p5, UserBindCallback p6) {
        this.$$delegate_0.ssoWithAccessTokenBind(p0, p1, p2, p3, p4, p5, p6);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenLogin(String p0, String p1, String p2, long p3, Map<Object, Object> p4, AbsApiCall<UserApiResponse> p5) {
        this.$$delegate_0.ssoWithAccessTokenLogin(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenLogin(String p0, String p1, String p2, String p3, long p4, Map<Object, Object> p5, AbsApiCall<UserApiResponse> p6) {
        this.$$delegate_0.ssoWithAccessTokenLogin(p0, p1, p2, p3, p4, p5, p6);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenOnlyLogin(String p0, String p1, String p2, long p3, Map<Object, Object> p4, AbsApiCall<UserApiResponse> p5) {
        this.$$delegate_0.ssoWithAccessTokenOnlyLogin(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeBind(String p0, String p1, String p2, long p3, Map<Object, Object> p4, UserBindCallback p5) {
        this.$$delegate_0.ssoWithAuthCodeBind(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeBindMobileLogin(String p0, String p1, String p2, String p3, boolean p4, boolean p5, Map<Object, Object> p6, AbsApiCall<UserApiResponse> p7) {
        this.$$delegate_0.ssoWithAuthCodeBindMobileLogin(p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeLogin(String p0, String p1, String p2, long p3, Map<Object, Object> p4, AbsApiCall<UserApiResponse> p5) {
        this.$$delegate_0.ssoWithAuthCodeLogin(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeOnlyLogin(String p0, String p1, String p2, long p3, Map<Object, Object> p4, AbsApiCall<UserApiResponse> p5) {
        this.$$delegate_0.ssoWithAuthCodeOnlyLogin(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithProfileKeyBind(String p0, String p1, String p2, long p3, Map<Object, Object> p4, UserBindCallback p5) {
        this.$$delegate_0.ssoWithProfileKeyBind(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithProfileKeyLogin(String p0, String p1, String p2, long p3, Map<Object, Object> p4, AbsApiCall<UserApiResponse> p5) {
        this.$$delegate_0.ssoWithProfileKeyLogin(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithProfileKeyRegister(String p0, String p1, String p2, long p3, Map<Object, Object> p4, UserBindCallback p5) {
        this.$$delegate_0.ssoWithProfileKeyRegister(p0, p1, p2, p3, p4, p5);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void switchBindWithAccessToken(String p0, String p1, String p2, long p3, String p4, Map<Object, Object> p5, UserBindCallback p6) {
        this.$$delegate_0.switchBindWithAccessToken(p0, p1, p2, p3, p4, p5, p6);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void switchBindWithAuthCode(String p0, String p1, String p2, long p3, String p4, Map<Object, Object> p5, UserBindCallback p6) {
        this.$$delegate_0.switchBindWithAuthCode(p0, p1, p2, p3, p4, p5, p6);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void unbindPlatform(String p0, int p1, String p2, AbsApiCall<BaseApiResponse> p3) {
        this.$$delegate_0.unbindPlatform(p0, p1, p2, p3);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void unbindPlatform(String p0, AbsApiCall<BaseApiResponse> p1) {
        this.$$delegate_0.unbindPlatform(p0, p1);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void unbindPlatform(String p0, Map<String, String> p1, AbsApiCall<BaseApiResponse> p2) {
        this.$$delegate_0.unbindPlatform(p0, p1, p2);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void updateAuthorizeInfo(String p0, String p1, String p2, String p3, String p4, String p5, Map<String, String> p6, CommonCallBack<UpdateAuthorizeInfoResponse> p7) {
        this.$$delegate_0.updateAuthorizeInfo(p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void updateAuthorizeInfo(String p0, String p1, String p2, Map<String, String> p3, CommonCallBack<UpdateAuthorizeInfoResponse> p4) {
        this.$$delegate_0.updateAuthorizeInfo(p0, p1, p2, p3, p4);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void webAuth(String p0, Map<Object, Object> p1, UserBindCallback p2) {
        this.$$delegate_0.webAuth(p0, p1, p2);
    }

    private BDAccountPlatformChinaImpl() {
        IBDAccountPlatformAPI instance = BDAccountPlatformImpl.instance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "BDAccountPlatformImpl.instance()");
        this.$$delegate_0 = instance;
    }

    public final void getDouyinOauthToken(String platformAppId, OauthTokenExtraParams eventParams, Map<String, String> extra, CommonCallBack<GetOauthTokenResponse> call) {
        Intrinsics.checkParameterIsNotNull(platformAppId, "platformAppId");
        Intrinsics.checkParameterIsNotNull(eventParams, "eventParams");
        BDAccountPlatformImpl.instance().getOauthToken(DouYinWebAuthorizeActivity.f192d, platformAppId, new String[]{"aweme_v2", "aweme"}, extra, eventParams, call);
    }
}
