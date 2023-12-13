package com.example.hearoptima_d_03.views.HearingAidFind;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hearoptima_d_03.R;
import com.example.hearoptima_d_03.entity.AidsView;
import com.example.hearoptima_d_03.global.GlobalVar;

import java.util.ArrayList;

public class HearingAidAdapter extends RecyclerView.Adapter<HearingAidAdapter.ViewHolder> {

    private ArrayList<AidsView> dataList;
    private Resources resources;
    private String m_packName;
    private boolean isClickable = true;
    String m_TAG = "AidsListAdapter";

    public HearingAidAdapter(ArrayList<AidsView> dataList, Resources resources,String m_packName) {
        this.dataList = dataList;
        this.resources = resources;
        this.m_packName = m_packName;
        Log.v("HistoryListAdapter","size : "+dataList.size());
    }
    @NonNull
    @Override
    public HearingAidAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v(m_TAG,"onCreateViewHolder1");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_hearing_aid, parent,false);
        Log.v(m_TAG,"onCreateViewHolder2");
        return new ViewHolder(view);
    }
    public void setItemClickable(boolean clickable) {
        this.isClickable = clickable;
    }

    @Override
    public void onBindViewHolder(@NonNull HearingAidAdapter.ViewHolder holder, int position) {
        AidsView data = dataList.get(position);
        holder.brandName.setText(data.getBrand());
        holder.productName.setText(data.getProduct());
        holder.priceText.setText(data.getMaxPrice()+"~");
        holder.aidsImage.setBackgroundResource(resources.getIdentifier(data.getFile_name(),"drawable",m_packName));
        Log.v("TEST LOG",m_TAG +" brandName : " + holder.brandName.getText());
        Log.v("TEST LOG",m_TAG +" productName : " + holder.productName.getText());
        Log.v("TEST LOG",m_TAG +" priceText : " + holder.priceText.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isClickable){
                    Log.v("ItemViewOnClick","*******************ItemViewOnClick"+position);
                    Log.v("DataList.ididid","id ="+dataList.get(position).toString());
                    Log.v("아이디좀보여줘","id ="+dataList.get(position).getHa_id());
                    GlobalVar.Gha_id = dataList.get(position).getHa_id();
                    // 인텐트를 생성하여 상세보기 페이지로 이동
                    Intent detailIntent = new Intent(v.getContext(), HearingAidGoodsInfoActivity.class);
//                detailIntent.putExtra("EXTRA_DATA", dataList.get(position)); // 보청기 정보 전달
                    v.getContext().startActivity(detailIntent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView brandName;
        private TextView productName;
        private TextView priceText;
        private ImageView aidsImage;
        private LinearLayout aidsLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brandName = itemView.findViewById(R.id.brandName);
            productName = itemView.findViewById(R.id.productName);
            priceText = itemView.findViewById(R.id.priceText);
            aidsImage = itemView.findViewById(R.id.aidsImage);
            aidsLayout = itemView.findViewById(R.id.aidsLayout);
        }

        @Override
        public void onClick(View v) {
//            if(v.getId() == R.id.detailBtn){
//                Log.v(m_TAG, "detailBtn Click");
//                int mPosition = getAdapterPosition();
//                Context context = v.getContext();
//                Globar.TG_ID = dataList.get(mPosition).getTg_id();
//                Globar.TS_ID = dataList.get(mPosition).getTs_id();
//                int type = dataList.get(mPosition).getTs_type();
//                if(type==1){
//                    Intent intent = new Intent(context, TrainResultTotalActivity.class);
//                    (context).startActivity(intent);
//                }
//                if(type==2){
//
//                    Intent intent = new Intent((context), SentenceResultTotalActivity.class);
//                    (context).startActivity(intent);
//                }
//
////                Context context = v.getContext();
//            }

        }
    }
}
