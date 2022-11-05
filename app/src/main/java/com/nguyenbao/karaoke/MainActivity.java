package com.nguyenbao.karaoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TabHost;

import com.nguyenbao.karaoke.adapter.MusicAdapter;
import com.nguyenbao.karaoke.model.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvBaiHatGoc;
    ArrayList<Music> dsBaiHatGoc;
    MusicAdapter adapterBaiHatGoc;
    ListView lvBaiHatYeuThich;
    ArrayList<Music> dsBaiHatYeuThich;
    MusicAdapter adapterBaiHatYeuThich;
    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t1")){
                    xuLyHienThiBaiHatGoc();
                } else if (tabId.equalsIgnoreCase("t2")){
                    xuLyHienThiBaiHatYeuThich();
                }
            }
        });
    }

    private void xuLyHienThiBaiHatGoc() {
    }

    private void xuLyHienThiBaiHatYeuThich() {
        dsBaiHatYeuThich.clear(); // Xóa dữ liệu cũ
        for (Music music: dsBaiHatGoc){
            if (music.isThich()){
                dsBaiHatYeuThich.add(music);
            }
            adapterBaiHatYeuThich.notifyDataSetChanged();
        }
    }

    private void addControls() {

        tabhost = (TabHost) findViewById(R.id.tabHost);
        tabhost.setup();

        TabHost.TabSpec tab1 = tabhost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("",getResources().getDrawable(R.drawable.baihat));
        tabhost.addTab(tab1);

        TabHost.TabSpec tab2 = tabhost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("",getResources().getDrawable(R.drawable.yeuthich));
        tabhost.addTab(tab2);

        lvBaiHatGoc= (ListView) findViewById(R.id.lvBaiHatGoc);
        dsBaiHatGoc=new ArrayList<>();
        adapterBaiHatGoc=new MusicAdapter(MainActivity.this,R.layout.item,dsBaiHatGoc);
        lvBaiHatGoc.setAdapter(adapterBaiHatGoc);

        lvBaiHatYeuThich= (ListView) findViewById(R.id.lvBaiHatYeuThich);
        dsBaiHatYeuThich=new ArrayList<>();
        adapterBaiHatYeuThich=new MusicAdapter(MainActivity.this,R.layout.item,dsBaiHatYeuThich);
        lvBaiHatYeuThich.setAdapter(adapterBaiHatYeuThich);

        giaLapBaiHat();
    }

    private void giaLapBaiHat() {
        dsBaiHatGoc.add(new Music("10001","Bài hat thứ nhất","Hồ Ngọc Hà",false));
        dsBaiHatGoc.add(new Music("10002","Bài hat thứ hai","Lê Hiếu",true));
        dsBaiHatGoc.add(new Music("10003","Bài hat thứ ba","Mỹ Linh",true));
        dsBaiHatGoc.add(new Music("10004","Bài hat thứ bốn","Hồ Quang Hiếu",true));
        dsBaiHatGoc.add(new Music("10005","Bài hat thứ năm","Mỹ Tâm ",true));
        dsBaiHatGoc.add(new Music("10006","Bài hat thứ sáu","Trần Thu Hà",false));
        dsBaiHatGoc.add(new Music("10007","Bài hat thứ bảy","Hồ Quỳnh Hương",false));
        dsBaiHatGoc.add(new Music("10008","Bài hat thứ tám","Trọng Tấn",false));
        dsBaiHatGoc.add(new Music("10009","Bài hat thứ chín","Hà Anh Tuấn",false));
        dsBaiHatGoc.add(new Music("10010","Bài hat thứ mười","Cao Thái Sơn",false));
        dsBaiHatGoc.add(new Music("10011","Bài hat thứ mười một","Rihanna",false));
        adapterBaiHatGoc.notifyDataSetChanged();
    }
}
