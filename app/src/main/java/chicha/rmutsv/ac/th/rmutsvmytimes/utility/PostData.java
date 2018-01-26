package chicha.rmutsv.ac.th.rmutsvmytimes.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Dell on 26/1/2561.
 */
// Alt + Enter for implement method
public class PostData extends AsyncTask<String, Void,String> {

    private Context context;

    public PostData(Context context) {
        this.context = context;
    } //Constructor

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("X", strings[0])
                    .add("Y", strings[1])
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[2]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }




    }
}//Main Class
