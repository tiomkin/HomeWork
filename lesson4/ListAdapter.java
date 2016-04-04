package by.tut.tiomkin.class4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    public ListAdapter(Context context, List<String> list) {
        this.mList = list;
        this.mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        if (mList == null) {
            return null;
        }
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("ListAdapter", "getView() position = " + position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_text, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.tv_text);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(mList.get(position));

        //конвертируем xml в объектную модель
        /*View item = mLayoutInflater.inflate(R.layout.item_text, parent, false);

        //ищем обхект TextView в View, который конвертировали выше
        TextView textView = (TextView) item.findViewById(R.id.tv_text);

        //position получаем от ListView, которому задаем этот адаптер
        textView.setText(mList.get(position));*/

        //return item;

        return convertView;
    }

    private static class ViewHolder {
        public TextView text;
    }
}
