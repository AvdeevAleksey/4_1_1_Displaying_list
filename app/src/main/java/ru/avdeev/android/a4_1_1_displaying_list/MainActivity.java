package ru.avdeev.android.a4_1_1_displaying_list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Adapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String KEY1="key1";
    private static final String KEY2="key2";
    private ListAdapter listContentAdapter;
    List<Map<String, String>> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        listContentAdapter = createAdapter();

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private ListAdapter createAdapter() {
        values = prepareContent();
        return new SimpleAdapter(this, values, android.R.layout.simple_list_item_2, new String[]{KEY1,KEY2}, new int[]{android.R.id.text1,android.R.id.text2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String,String>> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        String[] text = getString(R.string.large_text).split("\n\n");
        for (int i=0; i<text.length; i++) {
            map.put(i + "", text[i]);
            map.put(i+"a", text[i].length()+"");
        }
        result.add(map);
        //result.add(String.valueOf(getString(R.string.large_text).split("\n\n");
        //result.add(getString(R.string.large_text).length() + ""));
        return result;
    }
}