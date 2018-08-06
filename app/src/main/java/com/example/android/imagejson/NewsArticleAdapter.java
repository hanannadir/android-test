package com.example.android.imagejson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.imagejson.model.NewsArticle;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsArticleAdapter extends ArrayAdapter<NewsArticle> {

    private Context context;
    private int resource;
    private ArrayList<NewsArticle> objects;

    public NewsArticleAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NewsArticle> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        StudentViewHolder studentViewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(resource, null);
            studentViewHolder = new StudentViewHolder();
            studentViewHolder.nameTextView = convertView.findViewById(R.id.name_tv);
            studentViewHolder.authorTextView = convertView.findViewById(R.id.publish);
            studentViewHolder.image = convertView.findViewById(R.id.image_iv);
            convertView.setTag(studentViewHolder);
        } else {
            studentViewHolder = (StudentViewHolder) convertView.getTag();
        }

        NewsArticle newsArticle = objects.get(position);
        studentViewHolder.nameTextView.setText(newsArticle.getTitle());
        studentViewHolder.authorTextView.setText(String.valueOf(newsArticle.getAuthor()));
        Picasso.get().load(newsArticle.getUrlToImage()).into(studentViewHolder.image);

        return convertView;
    }

    class StudentViewHolder {
        private TextView nameTextView;
        private TextView authorTextView;
        private ImageView image;


    }


}
