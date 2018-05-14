package com.ifeins.recyclerviewespresso;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * @author ifeins
 */
public class RowViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNameView;

    public RowViewHolder(View itemView) {
        super(itemView);
        mNameView = itemView.findViewById(R.id.text_view_name);
    }

    public void setName(@NonNull String name) {
        mNameView.setText(name);
    }
}
