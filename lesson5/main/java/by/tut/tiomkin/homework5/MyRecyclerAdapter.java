package by.tut.tiomkin.homework5;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    public int imgQuantity;
    private LayoutInflater mLayoutInflater;

    public MyRecyclerAdapter(int imgQuantity) {
        this.imgQuantity = imgQuantity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //устанавливаем для отображения картинку из папки drawable: ic_launcher.png
        holder.mImg.setImageResource(R.drawable.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return imgQuantity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.item_img);

        }


    }
}
