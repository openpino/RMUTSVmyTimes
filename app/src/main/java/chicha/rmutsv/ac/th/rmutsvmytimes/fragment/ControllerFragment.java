package chicha.rmutsv.ac.th.rmutsvmytimes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chicha.rmutsv.ac.th.rmutsvmytimes.R;

/**
 * Created by Dell on 25/1/2561.
 */

public class ControllerFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controller,container,false);
        return view;
    }
} //Main Class
