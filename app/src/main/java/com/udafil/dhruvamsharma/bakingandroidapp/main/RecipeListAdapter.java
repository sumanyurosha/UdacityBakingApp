package com.udafil.dhruvamsharma.bakingandroidapp.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udafil.dhruvamsharma.bakingandroidapp.R;
import com.udafil.dhruvamsharma.bakingandroidapp.data.model.RecipeModel;

import java.util.zip.Inflater;

/**
 * Adapter class for Recipe List obtained from ViewModel
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>{

    private static RecipeModel[] recipeModel;


    public RecipeListAdapter(RecipeModel[] data) {
        recipeModel = data;
    }




    /**
     * View holder Class for Main Activity Adapter that contains two text views
     */
    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mDescription;
        TextView mServings;

        public RecipeViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.view_holder_main_title_tv);
            mDescription = itemView.findViewById(R.id.view_holder_main_desc_tv);
            mServings = itemView.findViewById(R.id.view_holder_main_servings_tv);
        }
    }


    /**
     * This method provides a new View Holder to the recyclerView for displaying data
     * @param parent
     * @param viewType
     * @return RecipeHolder
     */
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_activity_main, parent, false);

        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {

        holder.mTitle.setText(recipeModel[position].getName());
        holder.mDescription.setText("Id: " + recipeModel[position].getId());
        holder.mServings.setText("Servings: " + recipeModel[position].getServings());
    }

    /**
     * If the data is null, send 0 as item count and if not then
     * send the array length of the model data
     * @return
     */
    @Override
    public int getItemCount() {
        if(recipeModel == null)
            return 0;
        return recipeModel.length;
    }


    /**
     * public method to set the new data to the recycler view once the data is updated or added.
     * @param newData
     */
    public void switchAdapter(RecipeModel[] newData) {
        recipeModel = newData;
        notifyDataSetChanged();
    }
}
