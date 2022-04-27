package yanshi.juyan.com.yanshi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BooksAdapter extends RecyclerView.Adapter{

    Context context;
    public BooksAdapter(Context context) {
        this.context = context;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.laout_data_item,viewGroup,false);
        return new VedioHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        VedioHolder holder= (VedioHolder) viewHolder;
        if(!TextUtils.isEmpty(Tools.danweiGongjiJ)){
            holder.mName.setText(Tools.danweiGongjiJ);
        }
        holder.mPay.setText(GJinfos.getInfosList().get(i).getPay());
        holder.mmouth.setText(GJinfos.getInfosList().get(i).getMouth());
        holder.mdate.setText(GJinfos.getInfosList().get(i).getDate());
        holder.mMoney.setText(GJinfos.getInfosList().get(i).getMoney());
        holder.mTip.setText(GJinfos.getInfosList().get(i).getIndex());
        if(GJinfos.getInfosList().get(i).getIndex().contains("年度结息")){
            holder.ip_mouth.setVisibility(View.INVISIBLE);
            holder.mmouth.setVisibility(View.INVISIBLE);
        }else{
            holder.ip_mouth.setVisibility(View.VISIBLE);
            holder.mmouth.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return GJinfos.getInfosList().size()>0?GJinfos.getInfosList().size():0;
    }

    public class VedioHolder extends RecyclerView.ViewHolder{


        @InjectView(R.id.et_company)
        EditText mName;
        @InjectView(R.id.et_g_pay)
        EditText mPay;
        @InjectView(R.id.et_g_mouth)
        EditText mmouth;
        @InjectView(R.id.et_g_date)
        EditText mdate;
        @InjectView(R.id.et_g_money)
        EditText mMoney;
        @InjectView(R.id.tv_tip_mouth)
        TextView ip_mouth;
        @InjectView(R.id.et_tip_info)
        EditText mTip;
        public VedioHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
}
