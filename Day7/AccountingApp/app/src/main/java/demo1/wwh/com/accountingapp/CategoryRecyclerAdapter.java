package demo1.wwh.com.accountingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    private LayoutInflater minflater;
    public Context mContext;
    private LinkedList<CategoryResBean> cellList =GlobalUtil.getInstance().costRes;
    private String select="";

    public void setOnCategoryClickListener(OnCategoryClickListener onCategoryClickListener) {
        this.onCategoryClickListener = onCategoryClickListener;
    }

    private OnCategoryClickListener onCategoryClickListener;
    public CategoryRecyclerAdapter(Context context){
        this.mContext=context;
        minflater=LayoutInflater.from(mContext);
        select=cellList.get(0).title;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=minflater.inflate(R.layout.cell_caterory,parent,false);
        CategoryViewHolder myViewHolder =new CategoryViewHolder(view);
        return myViewHolder;
    }

    public String getSelect() {
        return select;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        final  CategoryResBean res=cellList.get(position);
        holder.imageView.setImageResource(res.resBlack);
        holder.textView.setText(res.title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select=res.title;
                notifyDataSetChanged();
                if(onCategoryClickListener!=null){
                    onCategoryClickListener.onClick(res.title);
                }
            }
        });
        if (holder.textView.getText().toString().equals(select)){
            holder.background.setBackgroundResource(R.drawable.bg_edit_text);
        }else {
            holder.background.setBackgroundResource(R.color.colorPrimary);
        }
    }

    @Override
    public int getItemCount() { return cellList.size(); }
    public interface OnCategoryClickListener{
        void onClick(String category);
    }
    public void changeType(RecordBean.RecordType type){
        if(type==RecordBean.RecordType.RECORD_TYPE_EXPENSE){
            cellList=GlobalUtil.getInstance().costRes;
        }else {
            cellList=GlobalUtil.getInstance().earnRes;
        }
        select=cellList.get(0).title;
        notifyDataSetChanged();
    }
}
class  CategoryViewHolder extends RecyclerView.ViewHolder{
    RelativeLayout background;
    ImageView imageView;
    TextView textView;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        background=itemView.findViewById(R.id.cell_background);
        imageView=itemView.findViewById(R.id.imageView_category);
        textView=itemView.findViewById(R.id.textView_category);
    }
}
