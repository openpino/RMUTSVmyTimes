package chicha.rmutsv.ac.th.rmutsvmytimes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

import chicha.rmutsv.ac.th.rmutsvmytimes.R;
import chicha.rmutsv.ac.th.rmutsvmytimes.utility.GetAllData;

/**
 * Created by Dell on 26/1/2561.
 */

public class GraphFragment extends Fragment {

    //Explicit
    private GraphView graphView; //Ctlr + space for at variable


                // Ctrl + Shift + Enter for add ;
    @Override   // Alt + insert for override method
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create GraphView
      try {

          String strURL = "http://androidthai.in.th/piw/getAllFirebaseChai.php";
          GetAllData getAllData = new GetAllData(getActivity());

          getAllData.execute(strURL);
          String strJSN = getAllData.get();
          Log.d("26Jan","JSON => " + strJSN);

         JSONArray jsonArray = new JSONArray(strJSN);
         int[] xInts = new int[jsonArray.length()];
         int[] yInts = new int[jsonArray.length()];
          DataPoint[] dataPoints = new  DataPoint[jsonArray.length()];
         for(int i=0;i<jsonArray.length();i++) {

             JSONObject jsonObject = jsonArray.getJSONObject(i);
             String strx = jsonObject.getString("X");
             String stry = jsonObject.getString("Y");
             xInts[i] = Integer.parseInt(strx);
             yInts[i] = Integer.parseInt(stry);

             dataPoints[i] = new DataPoint(xInts[i],yInts[i]);

         }// for

          graphView = getView().findViewById(R.id.graphViewMyData);
          LineGraphSeries<DataPoint> dataPointLineGraphSeries = new LineGraphSeries<>(dataPoints);
          graphView.addSeries(dataPointLineGraphSeries);

      }catch (Exception e)
      {
          e.printStackTrace();
      }



    }// Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph,container,false);
        return view;
    }
} //Main Class
