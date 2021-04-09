package com.example.pianokids;

import android.provider.UserDictionary;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIToDatabase {

    public static String base_url="http://projectelapi.herokuapp.com/";
    List<Word> serverList;
    RealmResults<RData> wordRealmResults;

    public void retrieveData()
    {
        final Realm realm = Realm.getDefaultInstance();
        wordRealmResults = realm.where(RData.class).findAll();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API_Interface service = retrofit.create(API_Interface.class);
        Call<List<Word>> call = service.getAllWords();
        call.enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {

                if(response.code()==200)
                {
                    serverList=response.body();
                    if(wordRealmResults.size() < serverList.size())
                    {
                        int l=serverList.size(),i=0;
                        try{
                                realm.beginTransaction();
                                if(wordRealmResults!=null)
                                    wordRealmResults.deleteAllFromRealm();
                                while(i<l)
                                {
                                    RData obj =realm.createObject(RData.class);
                                    obj.setId(serverList.get(i).getId());
                                    obj.setDescription(serverList.get(i).getDescription());
                                    obj.setTitle(serverList.get(i).getTitle());
                                    obj.setV(serverList.get(i).getV());
                                    i++;
                                }
                                realm.commitTransaction();

                        }
                        catch (Exception e){}
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {

            }
        });

    }

}

