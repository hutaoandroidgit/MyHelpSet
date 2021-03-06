package com.hutao.myhelpset.tool.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;
import com.hutao.myhelpset.tool.rxjava.code.CodeActivity;
import com.hutao.myhelpset.tool.rxjava.mvp.RealViewActivity;
import com.hutao.myhelpset.tool.rxjava.retrofit.ApiService;
import com.hutao.myhelpset.tool.rxjava.retrofit.UserInfo;
import com.hutao.myhelpset.tool.rxjava.retrofit.UserParam;
import com.hutao.myhelpset.tool.rxjava.retrofit.VipInfo;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: hutao
 * @date: 2021/10/12
 */
public class RxJavaRetrofitActivity extends BaseActivity {
    @RegisterView(id = R.id.btnRetrofit)
    private Button btnRetrofit;
    @RegisterView(id = R.id.tvShowVip)
    private TextView tvShowVip;
    @RegisterView(id = R.id.editTextRxBinding)
    private EditText editTextRxBinding;
    @RegisterView(id = R.id.tvShowRxBinding)
    private TextView tvShowRxBinding;
    @RegisterView(id = R.id.btnRxLifecycle)
    private TextView btnRxLifecycle;
    @RegisterView(id = R.id.btnMVP)
    private TextView btnMVP;
    @RegisterView(id = R.id.btnCode)
    private TextView btnCode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_rxjava_retrofit;
    }

    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {
        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofit(v);
            }
        });

        //rxjava+rxbinding
        //????????????????????????????????????????????????
        RxTextView.textChanges(editTextRxBinding)
                //?????????500???????????????????????????
                .debounce(500, TimeUnit.MILLISECONDS)
                //????????????????????????
                //flatMap???????????????????????????????????????????????????????????????????????????????????????????????????
                //switchMap?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                .switchMap(new Function<CharSequence, ObservableSource<List<String>>>() {
                    @Override
                    public ObservableSource<List<String>> apply(@NonNull CharSequence charSequence) throws Exception {
                        //?????????????????? ????????????????????????
                        List<String> strings = new ArrayList<>();
                        strings.add("????????????????????????????????????????????????"+ ++i);
                        return Observable.just(strings);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        tvShowRxBinding.setText(strings.toString());
                    }
                });

        //rxjava+rxlifecycle
        btnRxLifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RxLifecycleActivity.class);
            }
        });

        //rxjava+MVP
        btnMVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RealViewActivity.class);
            }
        });

        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(CodeActivity.class);
            }
        });
    }
    public int i;
    /**
     * @description ????????????Retrofit+RxJava????????????????????????????????????UI
     * @param 
     * @return 
     * @author hutao
     * @time 2021/10/13 16:53
     */
    private void retrofit(View v) {
        //??????Retrofit
        ApiService apiService = new Retrofit.Builder()
                .baseUrl("http://www.sosoapi.com/pass/mock/20761/")
                //rx Gson??????
                .addConverterFactory(GsonConverterFactory.create())
                //rx retrofit??????
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class);
        //??????RxJava
        UserParam param = new UserParam("hutao","123456");
        //??????param??????
        Observable.just(param)
                .flatMap(new Function<UserParam, ObservableSource<UserInfo>>() {
                    @Override
                    public ObservableSource<UserInfo> apply(@NonNull UserParam userParam) throws Exception {
                        return apiService.getUserInfo(userParam.name,userParam.pwd);
                    }
                })
                .flatMap(new Function<UserInfo, ObservableSource<VipInfo>>() {
                    @Override
                    public ObservableSource<VipInfo> apply(@NonNull UserInfo userInfo) throws Exception {
                        return apiService.getVipInfo(userInfo.uid);
                    }
                })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VipInfo>() {
                    @Override
                    public void accept(VipInfo vipInfo) throws Exception {
                        tvShowVip.setText("???????????????"+vipInfo.vipLevel +"???????????????"+vipInfo.vipScore);
                    }
                });

    }
}