package com.ifeins.recyclerviewespresso;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author ifeins
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ROW = 1;

    @NonNull
    private final HeaderViewHolder.Listener mListener;

    private boolean mToggleEnabled;

    public MyAdapter() {
        mListener = new HeaderViewHolder.Listener() {
            @Override
            public void onHeaderToggle(boolean checked) {
                mToggleEnabled = checked;
                if (mToggleEnabled) {
                    notifyItemRemoved(2);
                } else {
                    notifyItemInserted(2);
                }
            }
        };
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_view, parent, false);
            return new HeaderViewHolder(view, mListener);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
            return new RowViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 1:
                ((RowViewHolder) holder).setName("John");
                break;
            case 2:
                ((RowViewHolder) holder).setName("Anne");
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mToggleEnabled) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_ROW;
        }
    }
}
