package com.appiskey.simplifyvolleynetworkresponse;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell 5521 on 5/7/2016.
 */
public class NetworkHandler {

    public static void post(String url, final String auth, final Map<String, String> map, final ServiceListener listener) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAGResponse",s);
                        listener.success(s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("TAGError",volleyError+"");
                NetworkResponse response = volleyError.networkResponse;
                if (volleyError.toString().contains("com.android.volley.NoConnectionError")){
                    listener.fail(volleyError.getMessage());
                } else if (response != null && response.data != null) {
                    try {
                        if(response.statusCode == 500){
                            listener.fail("500 Internal Server Error");
                        } else if (response.statusCode == 422) {
                            JSONObject jsonObject = new JSONObject(new String(response.data));
                            //String msg = jsonObject.getString("response");//{}
//                            String code = jsonObject.getString("code");//422,400,...
//                            if("401".equalsIgnoreCase(code) || "422".equalsIgnoreCase(code)){
                                JSONArray jsonArray = jsonObject.getJSONArray("errors");
                                String message = "";
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    message += jsonObject1.getString("message");
                                }
                                listener.fail(response.statusCode+" : "+message);
                        } else if(response.statusCode == 401){
                            JSONObject jsonObject = new JSONObject(new String(response.data));
                            JSONArray jsonArray = jsonObject.getJSONArray("errors");
                            JSONObject errorObj = jsonArray.getJSONObject(0);
                            String message = errorObj.getString("message");
                            listener.fail(response.statusCode+" : "+message);
                        }
                    } catch (Exception e) {
                        listener.fail("Something went wrong. Please try again");
                        e.printStackTrace();
                    }

                }
                //response is null
                //java.net.SocketException: socket failed: EACCES (Permission denied)
                //when server is not running
                else {
                    volleyError.printStackTrace();
                    Log.d("OOL",volleyError.getLocalizedMessage());
                    Log.d("OOM",volleyError.getMessage());
                    if("java.net.SocketException: socket failed: EACCES (Permission denied)".contains(volleyError.getMessage())){
                        listener.fail("Error : Make sure your server is running...");
                    } else if("java.lang.SecurityException: Permission denied (missing INTERNET permission?)"
                            .contains(volleyError.getMessage())){
                        listener.fail("You may not have INTERNET permission.");
                    } else if ("java.lang.IllegalArgumentException: timeout < 0".contains(volleyError.getMessage())){
                        listener.fail(volleyError.getMessage());
                    } else if ("java.lang.RuntimeException: Bad URL".contains(volleyError.getMessage())){
                        listener.fail("Error : Please check your URL");
                    } else {
                        listener.fail("response is null");
                    }
                }
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("name", "Amirr");
//                params.put("email", "oieurn@adf.co");
//                params.put("phone", "+923002361459");
//                params.put("password", "123465");
//                params.put("role", "worker");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    params.put(entry.getKey(), entry.getValue());
                }
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Authorization", auth);
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                Map<String, String> responseHeaders = response.headers;
                return super.parseNetworkResponse(response);
            }
        };
        stringRequest.setRetryPolicy(
                new DefaultRetryPolicy(10000,
                        DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppClass.requestQueue.add(stringRequest);
    }

    public static void get(String url, final String auth, final ServiceListener listener) {
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String jsonObject) {
                        try {
//                            JSONObject jsonObject1 = new JSONObject(jsonObject);
//                            String code = jsonObject1.getString("code");
//                            if(code.equalsIgnoreCase("200")){
//                                JSONObject response = jsonObject1.getJSONObject("response");
//                                listener.success(response);
//                            } else if (code.equalsIgnoreCase("201")) {
//
//                            } else {
//                                listener.success(jsonObject);
//                            }
                            listener.success(jsonObject);
                        } catch (Exception e){

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("TAGError",volleyError+"");
                NetworkResponse response = volleyError.networkResponse;
                if (volleyError.toString().contains("com.android.volley.NoConnectionError")){
                    listener.fail(volleyError.getMessage());
                } else if (volleyError.toString().contains("com.android.volley.TimeoutError")){
                    listener.fail(volleyError);
                } else if (response != null && response.data != null) {
                    try {
                        /*{
                            "code": 401,
                            "response": {},
                            "errors": [
                                {
                                "code": 4,
                                "message": "Authorization failed."
                                }
                            ]
                        }*/
                        if(response.statusCode == 501){
                            listener.fail("501 Internal Server Error");
                        } else if (response.statusCode == 422) {
                            JSONObject jsonObject = new JSONObject(new String(response.data));
                            //String msg = jsonObject.getString("response");//{}
//                            String code = jsonObject.getString("code");//422,400,...
//                            if("401".equalsIgnoreCase(code) || "422".equalsIgnoreCase(code)){
                            JSONArray jsonArray = jsonObject.getJSONArray("errors");
                            String message = "";
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                message += jsonObject1.getString("message");
                            }
                            listener.fail(response.statusCode+" : "+message);
                        } else if(response.statusCode == 401){
                            JSONObject jsonObject = new JSONObject(new String(response.data));
                            JSONArray jsonArray = jsonObject.getJSONArray("errors");
                            JSONObject errorObj = jsonArray.getJSONObject(0);
                            String message = errorObj.getString("message");
                            listener.fail(response.statusCode+" : "+message);
                        }
                    } catch (Exception e) {
                        listener.fail("Something went wrong. Please try again");
                        e.printStackTrace();
                    }

                }
                //response is null
                //java.net.SocketException: socket failed: EACCES (Permission denied)
                //when server is not running
                else {
                    volleyError.printStackTrace();
                    Log.d("OOL",volleyError.getLocalizedMessage());
                    Log.d("OOM",volleyError.getMessage());
                    if("java.net.SocketException: socket failed: EACCES (Permission denied)".contains(volleyError.getMessage())){
                        listener.fail("Error : Make sure your server is running...");
                    } else if("java.lang.SecurityException: Permission denied (missing INTERNET permission?)"
                            .contains(volleyError.getMessage())){
                        listener.fail("You may not have INTERNET permission.");
                    } else if ("java.lang.IllegalArgumentException: timeout < 0".contains(volleyError.getMessage())){
                        listener.fail(volleyError.getMessage());
                    } else if ("java.lang.RuntimeException: Bad URL".contains(volleyError.getMessage())){
                        listener.fail("Error : Please check your URL");
                    } else {
                        listener.fail("response is null");
                    }
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Authorization", auth);
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }

        };
        request.setRetryPolicy(
                new DefaultRetryPolicy(50000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppClass.requestQueue.add(request);
    }
}
