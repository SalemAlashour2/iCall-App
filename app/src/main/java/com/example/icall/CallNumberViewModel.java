package com.example.icall;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CallNumberViewModel extends ViewModel {

    MutableLiveData<String> namemutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> numberMutableLiveData = new MutableLiveData<>();
   private static CallNumberViewModel INSTANCE;

    public static CallNumberViewModel getINSTANCE()
    {
        if(INSTANCE == null)
            INSTANCE = new CallNumberViewModel();
        return INSTANCE;
    }


    public void setNumber(String number) {
        numberMutableLiveData.setValue(number);
    }
    public void setName(String name) {
        namemutableLiveData.setValue(name);
    }
}
