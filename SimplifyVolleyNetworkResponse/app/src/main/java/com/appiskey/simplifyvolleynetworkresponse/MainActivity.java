package com.appiskey.simplifyvolleynetworkresponse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    //Could not response
    //POST http://192.168.1.124/auto-sleuths.lc/api/v1/workers/nearby?longitude=-122.4227152392268&latitude=37.78579551423501&distance=100
//    String url = "http://192.168.1.124/auto-sleuths.lc/api/v1/workers/nearby?longitude=-122.4227152392268&latitude=37.78579551423501&distance=100";

//    String auth = "5a0fc8aed3ed35965966b0869b6dc06e74080ab1df0cacbf94405883a859d3e7c5710df1fbb8cf491a402ea72328c579537d8206bfa0de9a8da2ecdc2a75f0a2xBd/cEhKlaDy+WbDHWpaxyy10gQ1BLgjByMbkZJVKdZRpMBgcxaBtqORroeA7SMs96NvL+PaovAIXNpe1+ySsVwygDNSzFhYxDr4SRa22+PqAVZ4S9I30RsJwLwOQq9hvK0ycWkVt7g1iYBZvhPFuQ==";
//    String url = "http://demo.appiskey.com/hireup/api/v1/contractor/jobs";

//    String auth = "5a0fc8aed3ed35965966b0869b6dc06e74080ab1df0cacbf94405883a859d3e7c5710df1fbb8cf491a402ea72328c579537d8206bfa0de9a8da2ecdc2a75f0a2xBd/cEhKlaDy+WbDHWpaxyy10gQ1BLgjByMbkZJVKdZRpMBgcxaBtqORroeA7SMs96NvL+PaovAIXNpe1+ySsVwygDNSzFhYxDr4SRa22+PqAVZ4S9I30RsJwLwOQq9hvK0ycWkVt7g1iYBZvhPFuQ==";
//    String url = "http://demo.appiskey.com/api/v1/contractor/jobs";

    //GET
//    String url = "http://demo.appiskey.com/api/v1/contractor/jobs/15";
//    String url = "http://192.168.1.124/auto-sleuths.lc/api/v1/contractor/jobs/15";
//    String url = "http://findworkquick.com/api/v1/contractor/profile/";

//    String auth = "";
        String auth = "ec63bae2c2461286ed2b31948c391fea3002304d1ecf5b0e3000b5a75ef21a16a6ecdcaa38ed7380a3c8b40d629fb1ea3847003599efb6de4401b297e48bed83GBDmbdHJV8LFS13E/yhDp4W12u6P7rL3WxnLjg5NN8EIR6Nv53+TXj9UaFcuidRm0YCMXIKC+TYeQkNRfigTsQEvqULnIzIXTQmHtc1s8gzL2h2LivCnO9J5kcvZO1SIDl2CXy1ku49F9pOP51M+Vg==";
        String url = "http://demo.appiskey.com/hireup/api/v1/worker/profile";
    private TextView resTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resTV = (TextView) findViewById(R.id.res);

//        getRequest();
        postRequest();

    }

    private void getRequest(){
        NetworkHandler.get(url, auth, new ServiceListener() {
            @Override
            public void success(Object obj) {
                Log.d("TAGg success",""+obj);
                resTV.setText("Success Response : "+obj);
            }

            @Override
            public void fail(Object obj) {
                Log.d("TAGg fail",""+obj);
                resTV.setText("Error Response : "+obj);
            }
        });
    }

    private void postRequest(){
        Map<String,String> map = new HashMap<>();
        map.put("ad","df");
        NetworkHandler.post(url, auth, map, new ServiceListener() {
            @Override
            public void success(Object obj) {
                Log.d("TAGg success",""+obj);
                resTV.setText("Success Response : "+obj);
            }

            @Override
            public void fail(Object obj) {
                Log.d("TAGg fail",""+obj);
                resTV.setText("Error Response : "+obj);
            }
        });
    }
}
