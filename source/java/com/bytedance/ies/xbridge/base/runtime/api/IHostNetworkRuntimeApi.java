package com.bytedance.ies.xbridge.base.runtime.api;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IHostNetworkRuntimeApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'Jh\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'Jt\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'Jt\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'J\u0080\u0001\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0016\b\u0001\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'J\\\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'Jh\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/api/IHostNetworkRuntimeApi;", "", "doDeleteForString", "Lcom/bytedance/retrofit2/Call;", "", "addCommonPara", "", "maxLength", "", "relativePath", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "extraInfo", "doGetForString", "queryMap", "", "doPostForStream", "Lcom/bytedance/retrofit2/mime/TypedInput;", ReportConst.ValidationReport.BODY, "Lcom/bytedance/retrofit2/mime/TypedOutput;", "doPostForString", "fieldMap", "doPutForString", "downloadFile", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostNetworkRuntimeApi {
    @DELETE
    Call<String> doDeleteForString(@AddCommonParam boolean addCommonPara, @MaxLength int maxLength, @Url String relativePath, @HeaderList List<Header> headerList, @ExtraInfo Object extraInfo);

    @GET
    Call<String> doGetForString(@AddCommonParam boolean addCommonPara, @MaxLength int maxLength, @Url String relativePath, @QueryMap(encode = true) Map<String, String> queryMap, @HeaderList List<Header> headerList, @ExtraInfo Object extraInfo);

    @POST
    @Streaming
    Call<TypedInput> doPostForStream(@AddCommonParam boolean addCommonPara, @MaxLength int maxLength, @Url String relativePath, @QueryMap Map<String, String> queryMap, @HeaderList List<Header> headerList, @Body TypedOutput body, @ExtraInfo Object extraInfo);

    @POST
    Call<String> doPostForString(@AddCommonParam boolean addCommonPara, @MaxLength int maxLength, @Url String relativePath, @QueryMap Map<String, String> queryMap, @HeaderList List<Header> headerList, @Body TypedOutput body, @ExtraInfo Object extraInfo);

    @FormUrlEncoded
    @POST
    Call<String> doPostForString(@AddCommonParam boolean addCommonPara, @MaxLength int maxLength, @Url String relativePath, @QueryMap Map<String, String> queryMap, @HeaderList List<Header> headerList, @FieldMap(encode = true) Map<String, String> fieldMap, @ExtraInfo Object extraInfo);

    @PUT
    Call<String> doPutForString(@AddCommonParam boolean addCommonPara, @MaxLength int maxLength, @Url String relativePath, @HeaderList List<Header> headerList, @Body TypedOutput body, @ExtraInfo Object extraInfo);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean addCommonPara, @MaxLength int maxLength, @Url String relativePath, @QueryMap(encode = true) Map<String, String> queryMap, @HeaderList List<Header> headerList, @ExtraInfo Object extraInfo);
}
