package com.example.android.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrgJSONTest {

    public String json = "{\"user\":{\"name\":\"alex\",\"age\":\"18\",\"isMan\":true}}";
//    {
//        "user":{
//          "name":"alex",
//          "age":"18",
//          "isMan":true
//         }
//    }

    public void parserJson(String json) {
        JSONObject obj = null;//最外层的JSONObject对象
        try {
            obj = new JSONObject(json);

            JSONObject user = obj.getJSONObject("user");//通过user字段获取其所包含的JSONObject对象
            String name = user.getString("name");//通过name字段获取其所包含的字符串

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //    "user":[
//    {
//        "name":"alex",
//            "age":"18",
//            "isMan":true
//    },
//    {
//        "name":"alex",
//            "age":"18",
//            "isMan":true
//    }
//    ]
    public void parserJsonArray(String json) {

        JSONObject obj = null;//最外层的JSONObject对象
        try {
            obj = new JSONObject(json);


            JSONArray array = obj.getJSONArray("user");

            for (int i = 0; i < array.length(); i++) {
                JSONObject user = array.getJSONObject(i);//索引值，获取数组中包含的值
                String name = user.getString("name");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}