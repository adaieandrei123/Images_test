package com.ainnov.testapp.images_fragment;

import androidx.fragment.app.Fragment;

/**
 Base fragment - improvements can be done
 */

public class BaseFragment extends Fragment {

    public BaseFragment(){

    }

    public static boolean containsImage(int [] array , int id){
        boolean exists = false;
        for(int a : array){
            if(a==id){
                exists = true;
                break;
            }
        }
        return exists;
    }
}
