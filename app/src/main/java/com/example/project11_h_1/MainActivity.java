package com.example.project11_h_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c; // context 변수를 다른 메소드에서 사용하기 위함
        }

        @Override
        public int getCount() { // 그리드뷰에 보여질 이미지의 개수를 반환
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

        String[] posterTitle = {"써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","Back to the Future",
                "써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","Back to the Future",
                "써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","Back to the Future",
                "써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","Back to the Future"};

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { // 영화 포스터를 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주게 함
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300)); //포스터 크기 지정
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 이미지를 각 그리드뷰 칸의 중앙에 배치
            imageView.setPadding(5,5,5,5); //패딩지정


            imageView.setImageResource(posterID[position]); // 이미지뷰에 영화 포스터 한개 적용, R.drawable.mov0x 이미지를 로드하여 출력

            final int pos = position; //원래 이미지 크기가 보이도록 함

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog, null); //dialogView에 대입
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); //대화상자 생성
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster); //접근근
                    ivPoster.setImageResource(posterID[pos]); //이미지뷰에 클릭한 영화포스터 아이디 지정
                    dlg.setTitle(posterTitle[pos]); //영화 제목
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show(); //대화상자 출력
                }
            });

            return imageView;
        }
    }
}