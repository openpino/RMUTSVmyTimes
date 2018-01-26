package chicha.rmutsv.ac.th.rmutsvmytimes.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import chicha.rmutsv.ac.th.rmutsvmytimes.GraphActivity;
import chicha.rmutsv.ac.th.rmutsvmytimes.R;

/**
 * Created by Dell on 25/1/2561.
 */

public class MainFragment extends Fragment {


    //Explicit
    private TextView textView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private String myTimesString;
    private Button button;

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Initial View
        textView = getView().findViewById(R.id.txtShowMyTimes);

//        Get Data From Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map map = (Map) dataSnapshot.getValue();
                myTimesString = String.valueOf(map.get("myTimes"));
                textView.setText(myTimesString);

            } //onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        Graph Controller

        button = getView().findViewById(R.id.btnShowGraph);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(),"Show Graph",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), GraphActivity.class);
                startActivity(intent);

            }
        });

    }//Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }
}//Main Class
