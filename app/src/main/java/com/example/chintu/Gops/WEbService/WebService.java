package com.example.chintu.Gops.WEbService;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebService {
    private static final String BASEURL1 = "https://light-litres.000webhostapp.com";
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType URLENCODED = MediaType.parse("application/x-www-form-urlencoded");
    private static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");


    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER
    //HEADER


    public String callApi(
            DataMultiPart dataMultiPartMultiImage, String params,
            String api, Context context, boolean isEditApi
    )
            throws UnsupportedEncodingException {

        MyDownloader myDownloader = new MyDownloader(dataMultiPartMultiImage, params, api, context, isEditApi);
        myDownloader.execute();

        String responseString = "";


        //Log.e("APIRESULT", "RESULT=" + responseString);
       /* ApiCallback apiCallback = (ApiCallback) context;
        apiCallback.onApiResultResponse(responseString);*/
        return responseString;
    }

    public class MyDownloader extends AsyncTask<String, Void, String> {
        String result = "";
        DataMultiPart dataMultiPartMultiImage;
        String params;
        String api;
        Context context;
        boolean isEditApi;

        public MyDownloader(DataMultiPart dataMultiPartMultiImage,
                            String params, String api, Context context, boolean isEditApi) {
            this.dataMultiPartMultiImage = dataMultiPartMultiImage;
            this.params = params;
            this.api = api;
            this.context = context;
            this.isEditApi = isEditApi;

        }

        @Override

        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override

        protected void onPostExecute(String bitmap) {
            super.onPostExecute(bitmap);


        }

        @Override

        protected String doInBackground(String... paramslist) {
            String responseString = "";
            try {

                final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                        .connectTimeout(50000, TimeUnit.MILLISECONDS)
                        .retryOnConnectionFailure(true)
                        .build();

                final Request.Builder request;
                Utils features = new Utils();
                if (dataMultiPartMultiImage != null) {
                    //Multipart to upload files
                    MultipartBody.Builder formBodyBuilder = new MultipartBody.Builder();
                    formBodyBuilder.setType(MultipartBody.FORM);

                    Iterator<String> keys = dataMultiPartMultiImage.getParams().keySet().iterator();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        String value = dataMultiPartMultiImage.getParams().get(key);
                        formBodyBuilder.addFormDataPart(key, value);
                    }

                    //String currentFielPath : dataMultiPartMultiImage.getMultiFilePath()
                    for (int iSize = 0; iSize < dataMultiPartMultiImage.getMultiFilePath().size(); iSize++) {
                        try {
                            String currentFielPath = dataMultiPartMultiImage.getMultiFilePath().get(iSize);
                            File file = new File(currentFielPath);
                            String fileName = features.findNameRig(currentFielPath);
                            String mimeType = features.getMIMEType(currentFielPath);
                            formBodyBuilder.addFormDataPart(dataMultiPartMultiImage.getMultiFilePathKey().get(iSize), fileName,
                                    RequestBody.create(MediaType.parse(mimeType), file)
                            )
                                    .build();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    RequestBody formBody = formBodyBuilder.build();

                    request = new Request.Builder()
                            .url(BASEURL1 + api)
                            .post(formBody);
                } else if (features.isValidString(params)) {
                    //POST METHOD
                    RequestBody body = RequestBody.create(JSON, params);
                    Log.e("JsonParameter", JSON + " :  " + params);
                    request = new Request.Builder()
                            .url(BASEURL1 +/*"http://35.165.253.201/index.php/api/" +*/ api)
                            .addHeader("Content-Type", JSON.toString())
                            /*.addHeader("TokenId", "OPf10Upkeu2b5j1eqRnIxc/wbjwuT1USH1vTCwdaYlw8lyMUZwCcWQ==")
                            .addHeader("UserId", "52")
                            .addHeader("AppId", "1")*/
                            //.post(generateRequest(params))
                            .post(body)
                    ;
                } else {
                    //GET METHOD
                    String url = BASEURL1 + api;
                    if (!isEditApi) {
                        url = api;
                    }
                    request = new Request.Builder()
                            .url(url)
                            .addHeader("Content-Type", JSON.toString())
                        /*.addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addHeader("TokenId", "OPf10Upkeu2b5j1eqRnIxc/wbjwuT1USH1vTCwdaYlw8lyMUZwCcWQ==")
                        .addHeader("UserId", "52")
                        .addHeader("AppId", "1")*/
                    ;
                }


                //[Set header Start]
           /* if (userID != null && authToken != null) {

                request.header(Consts.HEADER_USER_ID, userID)
                        .header(Consts.HEADER_AUTH_KEY, authToken);
            }
            request.header(Consts.HEADER_TIME_ZONE, features.getTimeZone());*/
                //[Set header End]


                //Log.d("url",BASEURL1+/*"http://35.165.253.201/index.php/api/" +*/ api);
                final Response response = okHttpClient.newCall(request.build()).execute();
                responseString = response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
                String exceptionMessage = e.toString();
                if (exceptionMessage.contains(Consts.ERROR_NO_CONNECTION)) {
                    responseString = Consts.ERROR_NO_CONNECTION;
                } else if (exceptionMessage.contains(Consts.ERROR_NO_CONNECTION_2)) {
                    responseString = Consts.ERROR_NO_CONNECTION_2;
                } else if (exceptionMessage.contains(Consts.ERROR_NO_TIME_OUT)) {
                    responseString = Consts.ERROR_NO_TIME_OUT;
                }
            }

            result = responseString;
            Log.e("APIRESPOBSEComplete", "SUCCESS=" + result);
            return result;

        }

    }


}