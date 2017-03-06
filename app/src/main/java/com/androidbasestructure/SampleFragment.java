package com.androidbasestructure;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tringapps-admin on 6/3/17.
 */

public class SampleFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_myschedule_layout, container, false);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        setToolbarIcons();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() == 0) {
                    setToolbarIcons();
                } else {
                    getBaseActivity().showBackButton();
                }
            }
        });
    }

    private void setToolbarIcons() {
        getBaseActivity().addRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sample fragment call
               // addFragment(new CalendarFragment(), true, "Sample title");
            }
        });
    }
}
