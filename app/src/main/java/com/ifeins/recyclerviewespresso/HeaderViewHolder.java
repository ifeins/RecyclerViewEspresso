package com.ifeins.recyclerviewespresso;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

/**
 * @author ifeins
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public interface Listener {
        void onHeaderToggle(boolean checked);
    }

    public HeaderViewHolder(@NonNull View itemView, @NonNull final Listener listener) {
        super(itemView);
        SwitchCompat toggle = itemView.findViewById(R.id.my_switch);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                listener.onHeaderToggle(checked);
            }
        });
    }
}
