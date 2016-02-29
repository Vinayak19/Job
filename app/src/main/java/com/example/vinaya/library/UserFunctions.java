package com.example.vinaya.library;

/**
 * Created by mvinaya on 2/25/16.
 */
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class UserFunctions {

    private JSONParser jsonParser;

    //URL of the PHP API
    private static String loginURL = "http://10.0.3.2/project/";
    private static String registerURL = "http://10.0.3.2/project/";
    private static String forpassURL = "http://10.0.3.2/project/";
    private static String chgpassURL = "http://10.0.3.2/project/";

    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String forpass_tag = "forpass";
    private static String chgpass_tag = "chgpass";
    private static String method = "POST";

    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }

    /**
     * Function to Login
     **/

    public JSONObject loginUser(String email, String password){
        // Building Parameters

        HashMap<String, String> params= new HashMap<String,String>();

        params.put("tag",login_tag);
        params.put("email",email);
        params.put("password",password);

        /*List params = new ArrayList();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password)); */

        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
        return json;
    }

    /**
     * Function to change password
     **/

    public JSONObject chgPass(String newpas, String email){


        HashMap<String, String> params= new HashMap<String,String>();
        params.put("tag",chgpass_tag);
        params.put("newpass",newpas);
        params.put("email",email);


        /*
        List params = new ArrayList();
        params.add(new BasicNameValuePair("tag", chgpass_tag));

        params.add(new BasicNameValuePair("newpas", newpas));
        params.add(new BasicNameValuePair("email", email)); */


        JSONObject json = jsonParser.getJSONFromUrl(chgpassURL, params);
        return json;
    }

    /**
     * Function to reset the password
     **/

    public JSONObject forPass(String forgotpassword)
    {


        HashMap<String, String> params= new HashMap<String,String>();

        params.put("tag",forpass_tag);
        params.put("forgetpassword",forgotpassword);

       /* List params = new ArrayList();
        params.add(new BasicNameValuePair("tag", forpass_tag));
        params.add(new BasicNameValuePair("forgotpassword", forgotpassword)); */

        JSONObject json = jsonParser.getJSONFromUrl(forpassURL, params);
        return json;
    }

    /**
     * Function to  Register
     **/
    public JSONObject registerUser(String fname, String lname, String email, String uname, String password) {
        // Building Parameters


        HashMap<String, String> params= new HashMap<String,String>();
        params.put("fname",fname);
        params.put("lname",lname);
        params.put("email",email);
        params.put("uname",uname);
        params.put("password",password);


            /*
            params.add(new BasicNameValuePair("tag", register_tag));
            params.add(new BasicNameValuePair("fname", fname));
            params.add(new BasicNameValuePair("lname", lname));
            params.add(new BasicNameValuePair("email", email));
            params.add(new BasicNameValuePair("uname", uname));
            params.add(new BasicNameValuePair("password", password));*/
            JSONObject json = jsonParser.getJSONFromUrl(registerURL,params);
            return json;
        }
    /**
     * Function to logout user
     * Resets the temporary data stored in SQLite Database
     * */
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }

}