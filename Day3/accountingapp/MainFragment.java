package demo1.wwh.com.accountingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {
    private View rootView;
    private TextView textView;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private LinkedList<RecordBean> records=new LinkedList<>();
    private String date=" ";
    public MainFragment(String date){
        this.date=date;
        records.add(new RecordBean());
        records.add(new RecordBean());
        records.add(new RecordBean());
        records.add(new RecordBean());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_main,container,false);
        initView();
        return rootView;
    }
    private void initView(){
        textView = (TextView) rootView.findViewById(R.id.day_text_view);
        listView = (ListView) rootView.findViewById(R.id.listView);
        textView.setText(date);
        listViewAdapter = new ListViewAdapter(getContext());
        listViewAdapter.setData(records);
        listView.setAdapter(listViewAdapter);
        if (listViewAdapter.getCount()>0){
            rootView.findViewById(R.id.no_record_layout).setVisibility(View.INVISIBLE);
        }
    }
}
