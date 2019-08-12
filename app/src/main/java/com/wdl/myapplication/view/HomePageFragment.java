package com.wdl.myapplication.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wdl.myapplication.R;
import com.wdl.myapplication.adapter.HomePageHotAdapter;
import com.wdl.myapplication.bean.HomePageHotBean;
import com.wdl.myapplication.commonality.SpacingItemDecoration;
import com.wdl.myapplication.adapter.HomePageJiFenAdapter;
import com.wdl.myapplication.adapter.HomePagetuijAdapter;
import com.wdl.myapplication.bean.HomePageBanderBean;
import com.wdl.myapplication.bean.HomePageGoodsBean;
import com.wdl.myapplication.bean.HomePageIntegralBean;
import com.wdl.myapplication.contract.MyContract;
import com.wdl.myapplication.presenter.MyPresenter;
import com.wdl.myapplication.zxing.android.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment implements MyContract.MyView.HomePageActivity {

    private Banner banner;
    MyContract.MyPresenter myPresenter = new MyPresenter<>(this);
    List<HomePageHotBean.DataBean> hotlist = new ArrayList<>();
    List<HomePageBanderBean.DataBean> list = new ArrayList<>();
    List<String> integerList = new ArrayList<String>();
    private RecyclerView jifen_xRecyclerView;
    private XRecyclerView recommend_xRecyclerView;
    List<HomePageIntegralBean.DataBean> Integrallist = new ArrayList<>();
    private HomePageJiFenAdapter jifenadapter;
    List<HomePageGoodsBean.DataBean> goodslist = new ArrayList<>();
    private HomePagetuijAdapter tuijadapter;
    private NestedScrollView scrollView;
    private EditText editText;
    private RecyclerView recyclerView ;
    LinearLayout linearLayout ;


    private TextView SYS ;
    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private static final int REQUEST_CODE_SCAN = 0x0000;
    private HomePageHotAdapter hotAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_homepage, null);
        banner = view.findViewById(R.id.homepage_Banner);
        jifen_xRecyclerView = view.findViewById(R.id.homepage_jifen_XRecyclerView);
        recommend_xRecyclerView = view.findViewById(R.id.homepage_recommend_XRecyclerView);
        scrollView = view.findViewById(R.id.homepage_ScrollView);
        editText = view.findViewById(R.id.homepage_EditText);
        SYS = view.findViewById(R.id.homepage_SYS);
        recyclerView = view.findViewById(R.id.homepage_recommend_RecyclerView);
        linearLayout = view.findViewById(R.id.homepage_LinearLayout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editText.setFocusable(false);

        myPresenter.PHomePageBander();
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollView.setFocusable(true);
                scrollView.setFocusableInTouchMode(true);
                scrollView.requestFocus();
                HideKeyboard(getView());
                return false;
            }
        });




        sys();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        myPresenter.PHomePagehot();

        hotAdapter = new HomePageHotAdapter(getActivity(),hotlist);
        recyclerView.setAdapter(hotAdapter);




        //积分商城
        jifen_xRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        myPresenter.PHomePageIntegral();
        jifenadapter = new HomePageJiFenAdapter(getActivity(),Integrallist);
        jifen_xRecyclerView.setAdapter(jifenadapter);

        //为您推荐
        recommend_xRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recommend_xRecyclerView.setPullRefreshEnabled(true);
        recommend_xRecyclerView.setLoadingMoreEnabled(true);
        myPresenter.PHomePageGoods();



        tuijadapter = new HomePagetuijAdapter(getActivity(),goodslist);
        recommend_xRecyclerView.setAdapter(tuijadapter);
        int pixelSize = getResources().getDimensionPixelSize(R.dimen.dp_20);
        recommend_xRecyclerView.addItemDecoration(new SpacingItemDecoration(pixelSize));

        /*//解决滑动冲突
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            int page = 0 ;
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    //底部加载
                    page++;
                    myPresenter.PHomePageGoods();
                }
            }

        });*/

        editText.clearFocus();
        //输入框获取焦点
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
            }
        });

        //点击详情页面
        jifenadapter.setSetOnClickItem(new HomePagetuijAdapter.setOnClickItem() {
            @Override
            public void onGreat(int id) {

            }
        });
        hotAdapter.setSetOnClickItem(new HomePagetuijAdapter.setOnClickItem() {
            @Override
            public void onGreat(int id) {
                Intent intent = new Intent(getActivity(),HomepageGoodsInfoActivity.class);
                //Log.e("图片啊",id+"");
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        tuijadapter.setSetOnClickItem(new HomePagetuijAdapter.setOnClickItem() {
            @Override
            public void onGreat(int id) {
                Intent intent = new Intent(getActivity(),HomepageGoodsInfoActivity.class);
                //Log.e("图片啊",id+"");
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }



    //轮播
    @Override
    public void ShowBander(Object o) {
        HomePageBanderBean homePageBanderBean = (HomePageBanderBean) o;
        //Log.e("数据v",o.toString());
        list.addAll(homePageBanderBean.getData());
        for (int i = 0; i < list.size(); i++) {
            integerList.add(list.get(i).getPic());
        }
        //Log.e("轮播图",integerList.toString());
        banner.isAutoPlay(true).setDelayTime(2500).setImages(integerList).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }
    //数据
    @Override
    public void ShowIntegral(Object o) {
        //Log.e("数据vv",o.toString());
        HomePageIntegralBean homePageIntegralBean = (HomePageIntegralBean) o;
        Integrallist.addAll(homePageIntegralBean.getData());

        jifenadapter.notifyDataSetChanged();
    }
    //为您推荐
    @Override
    public void ShowGoods(Object o) {
        recommend_xRecyclerView.loadMoreComplete();
        recommend_xRecyclerView.refreshComplete();
        HomePageGoodsBean homePageGoodsBean = (HomePageGoodsBean) o;
        goodslist.addAll(homePageGoodsBean.getData());
        tuijadapter.notifyDataSetChanged();

    }

    @Override
    public void Showhot(Object o) {
        HomePageHotBean homePageHotBean = (HomePageHotBean) o;
        hotlist.addAll(homePageHotBean.getData());
        hotAdapter.notifyDataSetChanged();
    }

    private void sys() {
        SYS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    goScan();
                }
            }
        });
    }
    /**
     * 跳转到扫码界面扫码
     */
    private void goScan(){
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    goScan();
                } else {
                    Toast.makeText(getContext(), "你拒绝了权限申请，可能无法打开相机扫码哟！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == 1) {
            if (data != null) {
                //返回的文本内容
                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                //返回的BitMap图像
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);

                //tv_scanResult.setText("你扫描到的内容是：" + content);
                Toast.makeText(getContext(), "你扫描到的内容是：" + content, Toast.LENGTH_SHORT).show();
            }
        }
    }
    public static void HideKeyboard(View v)
    {
        InputMethodManager imm = ( InputMethodManager ) v.getContext( ).getSystemService( Context.INPUT_METHOD_SERVICE );
        if ( imm.isActive( ) ) {
            imm.hideSoftInputFromWindow( v.getApplicationWindowToken( ) , 0 );
        } }

}
