package es.iesnervion.fjruiz.mov_06_codefest_2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ArrayRetos<T> extends ArrayAdapter {
    public ArrayRetos(Context context, int resource, int textViewResourceId, Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        ViewHolder holder;

        String cadena = (String) getItem(position);

        if (row==null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );

            row = inflater.inflate(R.layout.row, parent, false);

            TextView tv = (TextView) row.findViewById(R.id.TextoRetos);

            holder = new ViewHolder (tv);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        holder.getTv().setText(cadena);

        return (row);
    }
}
