package com.example.chintu.Gops;

import Model.Contact;
import Model.Otp;
import Model.ResultOTP;
import Model.ResultPass;
import Model.ResultRegistration;
import Model.ResultShowPRofile;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIinterface {
    @POST("/Registration.php")
    Call<ResultRegistration> inseertdata(
            @Field("source") String source,
            @Field("destination") String destination,
            @Field("pass_type") String pass_type,
            @Field("insti_name") String insti_name,
            @Field("ernoll_gr") String ernoll_gr,
            @Field("uname") String uname,
            @Field("addr1") String addr1,
            @Field("town_city") String town_city,
            @Field("area") String area,
            @Field("dist") String dist,
            @Field("pincode") String pincode,
            @Field("u_birthdate") String u_birthdate,
            @Field("gender") String gender,
            @Field("u_idname") String u_idname,
            @Field("u_idnumber") String u_idnumber,
            @Field("bus_type") String bus_type,
            @Field("duration") String duration,
            @Field("img1") String img1,
            @Field("img2") String img2,
            @Field("img3") String img3,
            @Field("mstdate") String mstdate
    );

    @FormUrlEncoded
    @POST("showpassdetail.php")
    Call<Contact> getdetail(@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("otpinsert.php")
    Call<ResultOTP> insertotp(@Field("u_m_number") String mobile);

    @GET("showregistration.php")
    Call<ResultRegistration> showdetail();

    @FormUrlEncoded
    @POST("insertpassdetail.php")
    Call<ResultPass> insertRenew(
            @Field("source") String source,
            @Field("destination") String destination,
            @Field("fare") String fare,
            @Field("mobile") String mobile
    );

    @FormUrlEncoded
    @POST("showprofile.php")
    Call<ResultShowPRofile> getprofile(@Field("otp") String mobile);
}
