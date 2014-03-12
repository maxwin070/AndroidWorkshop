package net.stawrul.notes.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.stawrul.notes.R;
import net.stawrul.notes.model.Note;

import java.util.List;

/**
 * Created by Max on 12.03.14.
 */
public class NoteListItemAdapter extends ArrayAdapter<Note> {
    private LayoutInflater mInflater;
    List<Note> notes;

    public NoteListItemAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);

        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.notes = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = mInflater.inflate(R.layout.note_list_item, parent, false);
        }

        TextView textView = (TextView) view.findViewById(R.id.noteListText);
        ImageView imageView = (ImageView) view.findViewById(R.id.noteListImage);

        Note note = notes.get(position);
        textView.setText(note.getTitle());
        if(note.isStarred()) {
            imageView.setImageResource(R.drawable.ic_favourite_dark);
        }
        else {
            imageView.setImageResource(R.drawable.ic_star_dark);
        }

        return view;
    }
}
